package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RandomKey<T> extends AbstractListChromosome<Double> implements PermutationChromosome<T> {
    private final List<Integer> baseSeqPermutation;
    private final List<Double> sortedRepresentation;

    public RandomKey(List<Double> list) {
        super(list);
        ArrayList arrayList = new ArrayList(getRepresentation());
        Collections.sort(arrayList);
        List<Double> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.sortedRepresentation = listUnmodifiableList;
        this.baseSeqPermutation = Collections.unmodifiableList(decodeGeneric(baseSequence(getLength()), getRepresentation(), listUnmodifiableList));
    }

    private static List<Integer> baseSequence(int i5) {
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }

    public static <S> List<Double> comparatorPermutation(List<S> list, Comparator<S> comparator) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, comparator);
        return inducedPermutation(list, arrayList);
    }

    private static <S> List<S> decodeGeneric(List<S> list, List<Double> list2, List<Double> list3) {
        int size = list.size();
        if (list2.size() != size) {
            throw new DimensionMismatchException(list2.size(), size);
        }
        if (list3.size() != size) {
            throw new DimensionMismatchException(list3.size(), size);
        }
        ArrayList arrayList = new ArrayList(list2);
        ArrayList arrayList2 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            int iIndexOf = arrayList.indexOf(list3.get(i5));
            arrayList2.add(list.get(iIndexOf));
            arrayList.set(iIndexOf, null);
        }
        return arrayList2;
    }

    public static final List<Double> identityPermutation(int i5) {
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(Double.valueOf(((double) i6) / ((double) i5)));
        }
        return arrayList;
    }

    public static <S> List<Double> inducedPermutation(List<S> list, List<S> list2) {
        if (list.size() != list2.size()) {
            throw new DimensionMismatchException(list2.size(), list.size());
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(list);
        Double[] dArr = new Double[size];
        for (int i5 = 0; i5 < size; i5++) {
            int iIndexOf = arrayList.indexOf(list2.get(i5));
            if (iIndexOf == -1) {
                throw new MathIllegalArgumentException(LocalizedFormats.DIFFERENT_ORIG_AND_PERMUTED_DATA, new Object[0]);
            }
            dArr[iIndexOf] = Double.valueOf(((double) i5) / ((double) size));
            arrayList.set(iIndexOf, null);
        }
        return Arrays.asList(dArr);
    }

    public static final List<Double> randomPermutation(int i5) {
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(Double.valueOf(GeneticAlgorithm.getRandomGenerator().nextDouble()));
        }
        return arrayList;
    }

    @Override // org.apache.commons.math3.genetics.AbstractListChromosome
    public void checkValidity(List<Double> list) {
        for (Double d : list) {
            double dDoubleValue = d.doubleValue();
            if (dDoubleValue < 0.0d || dDoubleValue > 1.0d) {
                throw new InvalidRepresentationException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, d, 0, 1);
            }
        }
    }

    @Override // org.apache.commons.math3.genetics.PermutationChromosome
    public List<T> decode(List<T> list) {
        return decodeGeneric(list, getRepresentation(), this.sortedRepresentation);
    }

    @Override // org.apache.commons.math3.genetics.Chromosome
    public boolean isSame(Chromosome chromosome) {
        if (!(chromosome instanceof RandomKey)) {
            return false;
        }
        RandomKey randomKey = (RandomKey) chromosome;
        if (getLength() != randomKey.getLength()) {
            return false;
        }
        List<Integer> list = this.baseSeqPermutation;
        List<Integer> list2 = randomKey.baseSeqPermutation;
        for (int i5 = 0; i5 < getLength(); i5++) {
            if (list.get(i5) != list2.get(i5)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.math3.genetics.AbstractListChromosome
    public String toString() {
        return String.format("(f=%s pi=(%s))", Double.valueOf(getFitness()), this.baseSeqPermutation);
    }

    public RandomKey(Double[] dArr) {
        this((List<Double>) Arrays.asList(dArr));
    }
}
