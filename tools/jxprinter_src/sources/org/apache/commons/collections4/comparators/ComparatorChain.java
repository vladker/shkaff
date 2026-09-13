package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ComparatorChain<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -721644942746081630L;
    private final List<Comparator<E>> comparatorChain;
    private boolean isLocked;
    private BitSet orderingBits;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    public void addComparator(Comparator<E> comparator) {
        addComparator(comparator, false);
    }

    @Override // java.util.Comparator
    public int compare(E e, E e6) {
        if (!this.isLocked) {
            checkChainIntegrity();
            this.isLocked = true;
        }
        Iterator<Comparator<E>> it = this.comparatorChain.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            int iCompare = it.next().compare(e, e6);
            if (iCompare != 0) {
                if (this.orderingBits.get(i5)) {
                    return iCompare > 0 ? -1 : 1;
                }
                return iCompare;
            }
            i5++;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ComparatorChain comparatorChain = (ComparatorChain) obj;
            BitSet bitSet = this.orderingBits;
            if (bitSet != null ? bitSet.equals(comparatorChain.orderingBits) : comparatorChain.orderingBits == null) {
                List<Comparator<E>> list = this.comparatorChain;
                List<Comparator<E>> list2 = comparatorChain.comparatorChain;
                if (list != null ? list.equals(list2) : list2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        List<Comparator<E>> list = this.comparatorChain;
        int iHashCode = list != null ? list.hashCode() : 0;
        BitSet bitSet = this.orderingBits;
        return bitSet != null ? iHashCode ^ bitSet.hashCode() : iHashCode;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setComparator(int i5, Comparator<E> comparator) {
        setComparator(i5, comparator, false);
    }

    public void setForwardSort(int i5) {
        checkLocked();
        this.orderingBits.clear(i5);
    }

    public void setReverseSort(int i5) {
        checkLocked();
        this.orderingBits.set(i5);
    }

    public int size() {
        return this.comparatorChain.size();
    }

    public ComparatorChain(Comparator<E> comparator) {
        this((Comparator) comparator, false);
    }

    public void addComparator(Comparator<E> comparator, boolean z6) {
        checkLocked();
        this.comparatorChain.add(comparator);
        if (z6) {
            this.orderingBits.set(this.comparatorChain.size() - 1);
        }
    }

    public void setComparator(int i5, Comparator<E> comparator, boolean z6) {
        checkLocked();
        this.comparatorChain.set(i5, comparator);
        if (z6) {
            this.orderingBits.set(i5);
        } else {
            this.orderingBits.clear(i5);
        }
    }

    public ComparatorChain(Comparator<E> comparator, boolean z6) {
        this.orderingBits = null;
        this.isLocked = false;
        ArrayList arrayList = new ArrayList(1);
        this.comparatorChain = arrayList;
        arrayList.add(comparator);
        BitSet bitSet = new BitSet(1);
        this.orderingBits = bitSet;
        if (z6) {
            bitSet.set(0);
        }
    }

    public ComparatorChain(List<Comparator<E>> list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List<Comparator<E>> list, BitSet bitSet) {
        this.isLocked = false;
        this.comparatorChain = list;
        this.orderingBits = bitSet;
    }
}
