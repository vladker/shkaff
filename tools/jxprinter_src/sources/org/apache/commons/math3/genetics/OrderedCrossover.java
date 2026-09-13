package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OrderedCrossover<T> implements CrossoverPolicy {
    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome chromosome, Chromosome chromosome2) {
        if ((chromosome instanceof AbstractListChromosome) && (chromosome2 instanceof AbstractListChromosome)) {
            return mate((AbstractListChromosome) chromosome, (AbstractListChromosome) chromosome2);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    public ChromosomePair mate(AbstractListChromosome<T> abstractListChromosome, AbstractListChromosome<T> abstractListChromosome2) {
        int iNextInt;
        int length = abstractListChromosome.getLength();
        if (length != abstractListChromosome2.getLength()) {
            throw new DimensionMismatchException(abstractListChromosome2.getLength(), length);
        }
        List<T> representation = abstractListChromosome.getRepresentation();
        List<T> representation2 = abstractListChromosome2.getRepresentation();
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = new ArrayList(length);
        HashSet hashSet = new HashSet(length);
        HashSet hashSet2 = new HashSet(length);
        RandomGenerator randomGenerator = GeneticAlgorithm.getRandomGenerator();
        int iNextInt2 = randomGenerator.nextInt(length);
        do {
            iNextInt = randomGenerator.nextInt(length);
        } while (iNextInt2 == iNextInt);
        int iMin = FastMath.min(iNextInt2, iNextInt);
        int iMax = FastMath.max(iNextInt2, iNextInt);
        int i5 = iMax + 1;
        arrayList.addAll(representation.subList(iMin, i5));
        hashSet.addAll(arrayList);
        arrayList2.addAll(representation2.subList(iMin, i5));
        hashSet2.addAll(arrayList2);
        for (int i6 = 1; i6 <= length; i6++) {
            int i7 = (iMax + i6) % length;
            T t6 = representation.get(i7);
            T t7 = representation2.get(i7);
            if (!hashSet.contains(t7)) {
                arrayList.add(t7);
                hashSet.add(t7);
            }
            if (!hashSet2.contains(t6)) {
                arrayList2.add(t6);
                hashSet2.add(t6);
            }
        }
        Collections.rotate(arrayList, iMin);
        Collections.rotate(arrayList2, iMin);
        return new ChromosomePair(abstractListChromosome.newFixedLengthChromosome(arrayList), abstractListChromosome2.newFixedLengthChromosome(arrayList2));
    }
}
