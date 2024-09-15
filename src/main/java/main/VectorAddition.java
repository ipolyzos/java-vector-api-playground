package main;

import jdk.incubator.vector.FloatVector;
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
        "-Xms16g",
        "--enable-preview",
        "--add-modules=jdk.incubator.vector",
})
public class VectorAddition {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Param({ "64", "512", "4096", "32768", "262144", "2097152", "16777216", "134217728" })
    int arraySize;

    float[] a;
    float[] b;
    float[] result;

    @Benchmark
    public void arrays() {
        for (int i = 0; i < arraySize; i++) {
            result[i] = a[i] + b[i];
        }
    }

    @Benchmark
    public void vectors() {
        for (int i = 0; i < arraySize; i += SPECIES.length()) {
            FloatVector aVector = FloatVector.fromArray(SPECIES, a, i);
            FloatVector bVector = FloatVector.fromArray(SPECIES, b, i);
            FloatVector resultVector = aVector.add(bVector);
            resultVector.intoArray(result, i);
        }
    }

    @Setup(Level.Trial)
    public void setup() {
        Random random = new Random();
        a = new float[arraySize];
        b = new float[arraySize];
        result = new float[arraySize];

        for (int i = 0; i < arraySize; i++) {
            a[i] = random.nextFloat();
            b[i] = random.nextFloat();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(VectorAddition.class.getSimpleName())
                .result("results/VectorAddition.json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(options).run();
    }
}