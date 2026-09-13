package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OnePointCrossover<T> implements CrossoverPolicy {
    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome chromosome, Chromosome chromosome2) {
        if ((chromosome instanceof AbstractListChromosome) && (chromosome2 instanceof AbstractListChromosome)) {
            return crossover((AbstractListChromosome) chromosome, (AbstractListChromosome) chromosome2);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    private ChromosomePair crossover(AbstractListChromosome<T> abstractListChromosome, AbstractListChromosome<T> abstractListChromosome2) {
        int length = abstractListChromosome.getLength();
        if (length == abstractListChromosome2.getLength()) {
            List<T> representation = abstractListChromosome.getRepresentation();
            List<T> representation2 = abstractListChromosome2.getRepresentation();
            ArrayList arrayList = new ArrayList(length);
            ArrayList arrayList2 = new ArrayList(length);
            int iNextInt = GeneticAlgorithm.getRandomGenerator().nextInt(length - 2) + 1;
            for (int i5 = 0; i5 < iNextInt; i5++) {
                arrayList.add(representation.get(i5));
                arrayList2.add(representation2.get(i5));
            }
            while (iNextInt < length) {
                arrayList.add(representation2.get(iNextInt));
                arrayList2.add(representation.get(iNextInt));
                iNextInt++;
            }
            return new ChromosomePair(abstractListChromosome.newFixedLengthChromosome(arrayList), abstractListChromosome2.newFixedLengthChromosome(arrayList2));
        }
        throw new DimensionMismatchException(abstractListChromosome2.getLength(), length);
    }
}
