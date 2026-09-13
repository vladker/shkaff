package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BinaryChromosome extends AbstractListChromosome<Integer> {
    public BinaryChromosome(List<Integer> list) {
        super(list);
    }

    public static List<Integer> randomBinaryRepresentation(int i5) {
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(Integer.valueOf(GeneticAlgorithm.getRandomGenerator().nextInt(2)));
        }
        return arrayList;
    }

    @Override // org.apache.commons.math3.genetics.AbstractListChromosome
    public void checkValidity(List<Integer> list) {
        for (Integer num : list) {
            int iIntValue = num.intValue();
            if (iIntValue < 0 || iIntValue > 1) {
                throw new InvalidRepresentationException(LocalizedFormats.INVALID_BINARY_DIGIT, num);
            }
        }
    }

    @Override // org.apache.commons.math3.genetics.Chromosome
    public boolean isSame(Chromosome chromosome) {
        if (!(chromosome instanceof BinaryChromosome)) {
            return false;
        }
        BinaryChromosome binaryChromosome = (BinaryChromosome) chromosome;
        if (getLength() != binaryChromosome.getLength()) {
            return false;
        }
        for (int i5 = 0; i5 < getRepresentation().size(); i5++) {
            if (!getRepresentation().get(i5).equals(binaryChromosome.getRepresentation().get(i5))) {
                return false;
            }
        }
        return true;
    }

    public BinaryChromosome(Integer[] numArr) {
        super(numArr);
    }
}
