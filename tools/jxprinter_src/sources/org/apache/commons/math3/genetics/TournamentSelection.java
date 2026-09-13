package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TournamentSelection implements SelectionPolicy {
    private int arity;

    public TournamentSelection(int i5) {
        this.arity = i5;
    }

    private Chromosome tournament(ListPopulation listPopulation) {
        int populationSize = listPopulation.getPopulationSize();
        int i5 = this.arity;
        if (populationSize < i5) {
            throw new MathIllegalArgumentException(LocalizedFormats.TOO_LARGE_TOURNAMENT_ARITY, Integer.valueOf(this.arity), Integer.valueOf(listPopulation.getPopulationSize()));
        }
        ListPopulation listPopulation2 = new ListPopulation(i5) { // from class: org.apache.commons.math3.genetics.TournamentSelection.1
            @Override // org.apache.commons.math3.genetics.Population
            public Population nextGeneration() {
                return null;
            }
        };
        ArrayList arrayList = new ArrayList(listPopulation.getChromosomes());
        for (int i6 = 0; i6 < this.arity; i6++) {
            int iNextInt = GeneticAlgorithm.getRandomGenerator().nextInt(arrayList.size());
            listPopulation2.addChromosome((Chromosome) arrayList.get(iNextInt));
            arrayList.remove(iNextInt);
        }
        return listPopulation2.getFittestChromosome();
    }

    public int getArity() {
        return this.arity;
    }

    @Override // org.apache.commons.math3.genetics.SelectionPolicy
    public ChromosomePair select(Population population) {
        ListPopulation listPopulation = (ListPopulation) population;
        return new ChromosomePair(tournament(listPopulation), tournament(listPopulation));
    }

    public void setArity(int i5) {
        this.arity = i5;
    }
}
