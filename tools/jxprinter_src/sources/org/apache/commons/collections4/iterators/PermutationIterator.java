package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PermutationIterator<E> implements Iterator<List<E>> {
    private final boolean[] direction;
    private final int[] keys;
    private List<E> nextPermutation;
    private final Map<Integer, E> objectMap;

    public PermutationIterator(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        this.objectMap = new HashMap();
        Iterator<? extends E> it = collection.iterator();
        int i5 = 1;
        while (it.hasNext()) {
            this.objectMap.put(Integer.valueOf(i5), it.next());
            this.keys[i5 - 1] = i5;
            i5++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.Iterator
    public List<E> next() {
        int[] iArr;
        int i5;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = -1;
        int i9 = -1;
        while (true) {
            iArr = this.keys;
            if (i7 >= iArr.length) {
                break;
            }
            boolean z6 = this.direction[i7];
            if (((z6 && i7 < iArr.length - 1 && iArr[i7] > iArr[i7 + 1]) || (!z6 && i7 > 0 && iArr[i7] > iArr[i7 - 1])) && (i5 = iArr[i7]) > i8) {
                i9 = i7;
                i8 = i5;
            }
            i7++;
        }
        if (i8 == -1) {
            List<E> list = this.nextPermutation;
            this.nextPermutation = null;
            return list;
        }
        boolean[] zArr = this.direction;
        boolean z7 = zArr[i9];
        int i10 = z7 ? 1 : -1;
        int i11 = iArr[i9];
        int i12 = i10 + i9;
        iArr[i9] = iArr[i12];
        iArr[i12] = i11;
        zArr[i9] = zArr[i12];
        zArr[i12] = z7;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr2 = this.keys;
            if (i6 >= iArr2.length) {
                List<E> list2 = this.nextPermutation;
                this.nextPermutation = arrayList;
                return list2;
            }
            int i13 = iArr2[i6];
            if (i13 > i8) {
                boolean[] zArr2 = this.direction;
                zArr2[i6] = !zArr2[i6];
            }
            arrayList.add(this.objectMap.get(Integer.valueOf(i13)));
            i6++;
        }
    }
}
