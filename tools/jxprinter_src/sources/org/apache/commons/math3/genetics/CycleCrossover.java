package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CycleCrossover<T> implements CrossoverPolicy {
    private final boolean randomStart;

    public CycleCrossover() {
        this(false);
    }

    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome chromosome, Chromosome chromosome2) {
        if ((chromosome instanceof AbstractListChromosome) && (chromosome2 instanceof AbstractListChromosome)) {
            return mate((AbstractListChromosome) chromosome, (AbstractListChromosome) chromosome2);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    public boolean isRandomStart() {
        return this.randomStart;
    }

    public ChromosomePair mate(AbstractListChromosome<T> abstractListChromosome, AbstractListChromosome<T> abstractListChromosome2) {
        int length = abstractListChromosome.getLength();
        if (length != abstractListChromosome2.getLength()) {
            throw new DimensionMismatchException(abstractListChromosome2.getLength(), length);
        }
        List<T> representation = abstractListChromosome.getRepresentation();
        List<T> representation2 = abstractListChromosome2.getRepresentation();
        ArrayList arrayList = new ArrayList(abstractListChromosome2.getRepresentation());
        ArrayList arrayList2 = new ArrayList(abstractListChromosome.getRepresentation());
        HashSet hashSet = new HashSet(length);
        ArrayList arrayList3 = new ArrayList(length);
        int iNextInt = this.randomStart ? GeneticAlgorithm.getRandomGenerator().nextInt(length) : 0;
        int i5 = 1;
        while (hashSet.size() < length) {
            arrayList3.add(Integer.valueOf(iNextInt));
            for (int iIndexOf = representation.indexOf(representation2.get(iNextInt)); iIndexOf != ((Integer) arrayList3.get(0)).intValue(); iIndexOf = representation.indexOf(representation2.get(iIndexOf))) {
                arrayList3.add(Integer.valueOf(iIndexOf));
            }
            int i6 = i5 + 1;
            if (i5 % 2 != 0) {
                int size = arrayList3.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj = arrayList3.get(i7);
                    i7++;
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = arrayList.get(iIntValue);
                    arrayList.set(iIntValue, arrayList2.get(iIntValue));
                    arrayList2.set(iIntValue, obj2);
                }
            }
            hashSet.addAll(arrayList3);
            int iIntValue2 = (((Integer) arrayList3.get(0)).intValue() + 1) % length;
            while (hashSet.contains(Integer.valueOf(iIntValue2)) && hashSet.size() < length) {
                iIntValue2++;
                if (iIntValue2 >= length) {
                    iIntValue2 = 0;
                }
            }
            arrayList3.clear();
            int i8 = iIntValue2;
            i5 = i6;
            iNextInt = i8;
        }
        return new ChromosomePair(abstractListChromosome.newFixedLengthChromosome(arrayList), abstractListChromosome2.newFixedLengthChromosome(arrayList2));
    }

    public CycleCrossover(boolean z6) {
        this.randomStart = z6;
    }
}
