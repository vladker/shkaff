package org.apache.commons.math3.genetics;

import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ElitisticListPopulation extends ListPopulation {
    private double elitismRate;

    public ElitisticListPopulation(List<Chromosome> list, int i5, double d) {
        super(list, i5);
        this.elitismRate = 0.9d;
        setElitismRate(d);
    }

    public double getElitismRate() {
        return this.elitismRate;
    }

    @Override // org.apache.commons.math3.genetics.Population
    public Population nextGeneration() {
        ElitisticListPopulation elitisticListPopulation = new ElitisticListPopulation(getPopulationLimit(), getElitismRate());
        List<Chromosome> chromosomeList = getChromosomeList();
        Collections.sort(chromosomeList);
        for (int iCeil = (int) FastMath.ceil((1.0d - getElitismRate()) * ((double) chromosomeList.size())); iCeil < chromosomeList.size(); iCeil++) {
            elitisticListPopulation.addChromosome(chromosomeList.get(iCeil));
        }
        return elitisticListPopulation;
    }

    public void setElitismRate(double d) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(LocalizedFormats.ELITISM_RATE, Double.valueOf(d), 0, 1);
        }
        this.elitismRate = d;
    }

    public ElitisticListPopulation(int i5, double d) {
        super(i5);
        this.elitismRate = 0.9d;
        setElitismRate(d);
    }
}
