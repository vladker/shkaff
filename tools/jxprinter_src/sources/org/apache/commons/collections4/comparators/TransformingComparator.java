package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TransformingComparator<I, O> implements Comparator<I>, Serializable {
    private static final long serialVersionUID = 3456940356043606220L;
    private final Comparator<O> decorated;
    private final Transformer<? super I, ? extends O> transformer;

    public TransformingComparator(Transformer<? super I, ? extends O> transformer) {
        this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
    }

    @Override // java.util.Comparator
    public int compare(I i5, I i6) {
        return this.decorated.compare(this.transformer.transform(i5), this.transformer.transform(i6));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            TransformingComparator transformingComparator = (TransformingComparator) obj;
            Comparator<O> comparator = this.decorated;
            if (comparator != null ? comparator.equals(transformingComparator.decorated) : transformingComparator.decorated == null) {
                Transformer<? super I, ? extends O> transformer = this.transformer;
                Transformer<? super I, ? extends O> transformer2 = transformingComparator.transformer;
                if (transformer != null ? transformer.equals(transformer2) : transformer2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Comparator<O> comparator = this.decorated;
        int iHashCode = (629 + (comparator == null ? 0 : comparator.hashCode())) * 37;
        Transformer<? super I, ? extends O> transformer = this.transformer;
        return iHashCode + (transformer != null ? transformer.hashCode() : 0);
    }

    public TransformingComparator(Transformer<? super I, ? extends O> transformer, Comparator<O> comparator) {
        this.decorated = comparator;
        this.transformer = transformer;
    }
}
