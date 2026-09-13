package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractListChromosome<T> extends Chromosome {
    private final List<T> representation;

    public AbstractListChromosome(List<T> list) {
        this(list, true);
    }

    public abstract void checkValidity(List<T> list);

    public int getLength() {
        return getRepresentation().size();
    }

    public List<T> getRepresentation() {
        return this.representation;
    }

    public abstract AbstractListChromosome<T> newFixedLengthChromosome(List<T> list);

    public String toString() {
        return String.format("(f=%s %s)", Double.valueOf(getFitness()), getRepresentation());
    }

    public AbstractListChromosome(T[] tArr) {
        this(Arrays.asList(tArr));
    }

    public AbstractListChromosome(List<T> list, boolean z6) {
        checkValidity(list);
        this.representation = Collections.unmodifiableList(z6 ? new ArrayList(list) : list);
    }
}
