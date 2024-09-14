package main;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(jvmArgs = {
        "-XX:-TieredCompilation",
        "-XX:-UseSuperWord",
        "-Xms16g",
        "--enable-preview",
        "--add-modules=jdk.incubator.vector",
})
public class DotProductNoSuperWord {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Param({ "64", "512", "4096", "32768", "262144", "2097152", "16777216", "134217728" })
    int arraySize;

    float[] a;
    float[] b;
    float result;

    @Benchmark
    public void arrays() {
        result = 0;
        for (int i = 0; i < arraySize; i++) {
            result += a[i] * b[i];
        }
    }

    @Benchmark
    public void vectors() {
        result = 0;
        for (int i = 0; i < arraySize; i += SPECIES.length()) {
            FloatVector aVector = FloatVector.fromArray(SPECIES, a, i);
            FloatVector bVector = FloatVector.fromArray(SPECIES, b, i);

            result += aVector.mul(bVector).reduceLanes(VectorOperators.ADD);
        }
    }

    @Setup(Level.Trial)
    public void setup() {
        Random random = new Random();
        a = new float[arraySize];
        b = new float[arraySize];

        for (int i = 0; i < arraySize; i++) {
            a[i] = random.nextFloat();
            b[i] = random.nextFloat();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(DotProductNoSuperWord.class.getSimpleName())
                .result("results/DotProduct.json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(options).run();
    }
}