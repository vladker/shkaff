package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NullComparator<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private final Comparator<? super E> nonNullComparator;
    private final boolean nullsAreHigh;

    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
    }

    @Override // java.util.Comparator
    public int compare(E e, E e6) {
        if (e == e6) {
            return 0;
        }
        if (e == null) {
            return this.nullsAreHigh ? 1 : -1;
        }
        if (e6 == null) {
            return this.nullsAreHigh ? -1 : 1;
        }
        return this.nonNullComparator.compare(e, e6);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        return this.nullsAreHigh == nullComparator.nullsAreHigh && this.nonNullComparator.equals(nullComparator.nonNullComparator);
    }

    public int hashCode() {
        return this.nonNullComparator.hashCode() * (this.nullsAreHigh ? -1 : 1);
    }

    public NullComparator(Comparator<? super E> comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z6) {
        this(ComparatorUtils.NATURAL_COMPARATOR, z6);
    }

    public NullComparator(Comparator<? super E> comparator, boolean z6) {
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z6;
        if (comparator == null) {
            throw new NullPointerException("null nonNullComparator");
        }
    }
}
