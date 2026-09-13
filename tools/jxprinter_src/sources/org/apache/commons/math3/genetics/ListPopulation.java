package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ListPopulation implements Population {
    private List<Chromosome> chromosomes;
    private int populationLimit;

    public ListPopulation(int i5) {
        this(Collections.EMPTY_LIST, i5);
    }

    @Override // org.apache.commons.math3.genetics.Population
    public void addChromosome(Chromosome chromosome) {
        if (this.chromosomes.size() >= this.populationLimit) {
            throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(this.chromosomes.size()), Integer.valueOf(this.populationLimit), false);
        }
        this.chromosomes.add(chromosome);
    }

    public void addChromosomes(Collection<Chromosome> collection) {
        if (collection.size() + this.chromosomes.size() > this.populationLimit) {
            throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(this.chromosomes.size()), Integer.valueOf(this.populationLimit), false);
        }
        this.chromosomes.addAll(collection);
    }

    public List<Chromosome> getChromosomeList() {
        return this.chromosomes;
    }

    public List<Chromosome> getChromosomes() {
        return Collections.unmodifiableList(this.chromosomes);
    }

    @Override // org.apache.commons.math3.genetics.Population
    public Chromosome getFittestChromosome() {
        Chromosome chromosome = this.chromosomes.get(0);
        for (Chromosome chromosome2 : this.chromosomes) {
            if (chromosome2.compareTo(chromosome) > 0) {
                chromosome = chromosome2;
            }
        }
        return chromosome;
    }

    @Override // org.apache.commons.math3.genetics.Population
    public int getPopulationLimit() {
        return this.populationLimit;
    }

    @Override // org.apache.commons.math3.genetics.Population
    public int getPopulationSize() {
        return this.chromosomes.size();
    }

    @Override // java.lang.Iterable
    public Iterator<Chromosome> iterator() {
        return getChromosomes().iterator();
    }

    @Deprecated
    public void setChromosomes(List<Chromosome> list) {
        if (list == null) {
            throw new NullArgumentException();
        }
        if (list.size() > this.populationLimit) {
            throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(list.size()), Integer.valueOf(this.populationLimit), false);
        }
        this.chromosomes.clear();
        this.chromosomes.addAll(list);
    }

    public void setPopulationLimit(int i5) {
        if (i5 <= 0) {
            throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, Integer.valueOf(i5));
        }
        if (i5 < this.chromosomes.size()) {
            throw new NumberIsTooSmallException(Integer.valueOf(i5), Integer.valueOf(this.chromosomes.size()), true);
        }
        this.populationLimit = i5;
    }

    public String toString() {
        return this.chromosomes.toString();
    }

    public ListPopulation(List<Chromosome> list, int i5) {
        if (list == null) {
            throw new NullArgumentException();
        }
        if (i5 <= 0) {
            throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, Integer.valueOf(i5));
        }
        if (list.size() > i5) {
            throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(list.size()), Integer.valueOf(i5), false);
        }
        this.populationLimit = i5;
        ArrayList arrayList = new ArrayList(i5);
        this.chromosomes = arrayList;
        arrayList.addAll(list);
    }
}
