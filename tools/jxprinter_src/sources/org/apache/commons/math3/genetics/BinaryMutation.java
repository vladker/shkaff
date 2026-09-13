package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BinaryMutation implements MutationPolicy {
    @Override // org.apache.commons.math3.genetics.MutationPolicy
    public Chromosome mutate(Chromosome chromosome) {
        if (!(chromosome instanceof BinaryChromosome)) {
            throw new MathIllegalArgumentException(LocalizedFormats.INVALID_BINARY_CHROMOSOME, new Object[0]);
        }
        BinaryChromosome binaryChromosome = (BinaryChromosome) chromosome;
        ArrayList arrayList = new ArrayList(binaryChromosome.getRepresentation());
        int iNextInt = GeneticAlgorithm.getRandomGenerator().nextInt(binaryChromosome.getLength());
        arrayList.set(iNextInt, Integer.valueOf(binaryChromosome.getRepresentation().get(iNextInt).intValue() == 0 ? 1 : 0));
        return binaryChromosome.newFixedLengthChromosome(arrayList);
    }
}
