package org.apache.commons.math3.genetics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Chromosome implements Comparable<Chromosome>, Fitness {
    private static final double NO_FITNESS = Double.NEGATIVE_INFINITY;
    private double fitness = NO_FITNESS;

    public Chromosome findSameChromosome(Population population) {
        for (Chromosome chromosome : population) {
            if (isSame(chromosome)) {
                return chromosome;
            }
        }
        return null;
    }

    public double getFitness() {
        if (this.fitness == NO_FITNESS) {
            this.fitness = fitness();
        }
        return this.fitness;
    }

    public boolean isSame(Chromosome chromosome) {
        return false;
    }

    public void searchForFitnessUpdate(Population population) {
        Chromosome chromosomeFindSameChromosome = findSameChromosome(population);
        if (chromosomeFindSameChromosome != null) {
            this.fitness = chromosomeFindSameChromosome.getFitness();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Chromosome chromosome) {
        return Double.compare(getFitness(), chromosome.getFitness());
    }
}
