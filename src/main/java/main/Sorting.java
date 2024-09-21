package main;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(jvmArgs = {
        "-XX:-TieredCompilation",
        "-Xms16g",
        "--enable-preview",
        "--add-modules=jdk.incubator.vector"
})
public class Sorting {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Param({ "64", "512", "4096", "32768", "262144", "2097152" })
    int arraySize;

    float[] array;

    @Setup(Level.Trial)
    public void setup() {
        array = new float[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (float) Math.random();
        }
    }

    @Benchmark
    public void arraySort() {
        Arrays.sort(array);
    }

    @Benchmark
    public void vectorSort() {
        // Simple vectorized bubble sort for demonstration purposes
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < array.length - SPECIES.length(); i += SPECIES.length()) {
                FloatVector current = FloatVector.fromArray(SPECIES, array, i);
                FloatVector next = FloatVector.fromArray(SPECIES, array, i + 1);
                VectorMask<Float> mask = current.compare(VectorOperators.GT, next);
                if (mask.anyTrue()) {
                    sorted = false;
                    FloatVector temp = current.blend(next, mask);
                    next = next.blend(current, mask);
                    temp.intoArray(array, i);
                    next.intoArray(array, i + 1);
                }
            }
        } while (!sorted);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Sorting.class.getSimpleName())
                .exclude(SortingNoSuperWord.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .result("results/sorting.json")
                .build();

        new Runner(opt).run();
    }
}