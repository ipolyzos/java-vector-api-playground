package main;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
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
    "--add-modules=jdk.incubator.vector"
})
public class ArrayStats {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Param({ "64", "512", "4096", "32768", "262144", "2097152", "16777216", "134217728" })
    int arraySize;
    
    int eq = 0;
    int gt = 0;
    int lt = 0;
    
    float[] a;
    float[] b;
    
    @Benchmark
    public void arrays() {
        for (int i = 0; i < arraySize; i++) {
            if (a[i] == b[i]) {
                eq++;
            } else if (a[i] > b[i]) {
                gt++;
            } else {
                lt++;
            }
        }
    }

    @Benchmark
    public void vectors() {
        for (int i = 0; i < arraySize; i += SPECIES.length()) {
            FloatVector aVector = FloatVector.fromArray(SPECIES, a, i);
            FloatVector bVector = FloatVector.fromArray(SPECIES, b, i);

            int ltCount = aVector.lt(bVector).trueCount();
            int eqCount = aVector.eq(bVector).trueCount();

            eq += eqCount;
            lt += ltCount;
            gt += SPECIES.length() - ltCount - eqCount; // SPECIES.length() == Number of array elements that fit inside a SIMD register
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
    
    @Setup(Level.Invocation)
    public void reset() {
        eq = 0;
        gt = 0;
        lt = 0;
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ArrayStats.class.getSimpleName())
            .result("results/array-stats.json")
            .build();
        
        new Runner(options).run();
    }
}

