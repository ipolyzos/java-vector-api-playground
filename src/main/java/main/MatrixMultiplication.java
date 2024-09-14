package main;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;
import org.openjdk.jmh.annotations.*;
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
public class MatrixMultiplication {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Param({ "64", "128", "256", "512" })
    int size;

    float[][] a;
    float[][] b;
    float[][] result;

    @Benchmark
    public void arrays() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }

    @Benchmark
    public void vectors() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                FloatVector sumVector = FloatVector.zero(SPECIES);
                for (int k = 0; k < size; k += SPECIES.length()) {
                    FloatVector aVector = FloatVector.fromArray(SPECIES, a[i], k);
                    FloatVector bVector = FloatVector.fromArray(SPECIES, b[j], k);
                    sumVector = sumVector.add(aVector.mul(bVector));
                }
                result[i][j] = sumVector.reduceLanes(VectorOperators.ADD);
            }
        }
    }

    @Setup(Level.Trial)
    public void setup() {
        Random random = new Random();
        a = new float[size][size];
        b = new float[size][size];
        result = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = random.nextFloat();
                b[i][j] = random.nextFloat();
            }
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(MatrixMultiplication.class.getSimpleName())
                .result("results/MatrixMultiplication.json")
                .build();

        new Runner(options).run();
    }
}