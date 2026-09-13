package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GeneticAlgorithm {
    private static RandomGenerator randomGenerator = new JDKRandomGenerator();
    private final CrossoverPolicy crossoverPolicy;
    private final double crossoverRate;
    private int generationsEvolved = 0;
    private final MutationPolicy mutationPolicy;
    private final double mutationRate;
    private final SelectionPolicy selectionPolicy;

    public GeneticAlgorithm(CrossoverPolicy crossoverPolicy, double d, MutationPolicy mutationPolicy, double d6, SelectionPolicy selectionPolicy) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(LocalizedFormats.CROSSOVER_RATE, Double.valueOf(d), 0, 1);
        }
        if (d6 < 0.0d || d6 > 1.0d) {
            throw new OutOfRangeException(LocalizedFormats.MUTATION_RATE, Double.valueOf(d6), 0, 1);
        }
        this.crossoverPolicy = crossoverPolicy;
        this.crossoverRate = d;
        this.mutationPolicy = mutationPolicy;
        this.mutationRate = d6;
        this.selectionPolicy = selectionPolicy;
    }

    public static synchronized RandomGenerator getRandomGenerator() {
        return randomGenerator;
    }

    public static synchronized void setRandomGenerator(RandomGenerator randomGenerator2) {
        randomGenerator = randomGenerator2;
    }

    public Population evolve(Population population, StoppingCondition stoppingCondition) {
        this.generationsEvolved = 0;
        while (!stoppingCondition.isSatisfied(population)) {
            population = nextGeneration(population);
            this.generationsEvolved++;
        }
        return population;
    }

    public CrossoverPolicy getCrossoverPolicy() {
        return this.crossoverPolicy;
    }

    public double getCrossoverRate() {
        return this.crossoverRate;
    }

    public int getGenerationsEvolved() {
        return this.generationsEvolved;
    }

    public MutationPolicy getMutationPolicy() {
        return this.mutationPolicy;
    }

    public double getMutationRate() {
        return this.mutationRate;
    }

    public SelectionPolicy getSelectionPolicy() {
        return this.selectionPolicy;
    }

    public Population nextGeneration(Population population) {
        Population populationNextGeneration = population.nextGeneration();
        RandomGenerator randomGenerator2 = getRandomGenerator();
        while (populationNextGeneration.getPopulationSize() < populationNextGeneration.getPopulationLimit()) {
            ChromosomePair chromosomePairSelect = getSelectionPolicy().select(population);
            if (randomGenerator2.nextDouble() < getCrossoverRate()) {
                chromosomePairSelect = getCrossoverPolicy().crossover(chromosomePairSelect.getFirst(), chromosomePairSelect.getSecond());
            }
            if (randomGenerator2.nextDouble() < getMutationRate()) {
                chromosomePairSelect = new ChromosomePair(getMutationPolicy().mutate(chromosomePairSelect.getFirst()), getMutationPolicy().mutate(chromosomePairSelect.getSecond()));
            }
            populationNextGeneration.addChromosome(chromosomePairSelect.getFirst());
            if (populationNextGeneration.getPopulationSize() < populationNextGeneration.getPopulationLimit()) {
                populationNextGeneration.addChromosome(chromosomePairSelect.getSecond());
            }
        }
        return populationNextGeneration;
    }
}
