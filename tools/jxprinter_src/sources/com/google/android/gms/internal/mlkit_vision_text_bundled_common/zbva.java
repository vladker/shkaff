package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbva extends zbsl implements RandomAccess, zbum {
    private static final zbva zba = new zbva(new long[0], 0, false);
    private long[] zbb;
    private int zbc;

    public zbva() {
        this(new long[10], 0, true);
    }

    public static zbva zbf() {
        return zba;
    }

    private final String zbh(int i5) {
        return a.h(i5, this.zbc, "Index:", ", Size:");
    }

    private final void zbi(int i5) {
        if (i5 < 0 || i5 >= this.zbc) {
            throw new IndexOutOfBoundsException(zbh(i5));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        long jLongValue = ((Long) obj).longValue();
        zba();
        if (i5 < 0 || i5 > (i6 = this.zbc)) {
            throw new IndexOutOfBoundsException(zbh(i5));
        }
        int i7 = i5 + 1;
        long[] jArr = this.zbb;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i7, i6 - i5);
        } else {
            long[] jArr2 = new long[a.c(i6, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.zbb, i5, jArr2, i7, this.zbc - i5);
            this.zbb = jArr2;
        }
        this.zbb[i5] = jLongValue;
        this.zbc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbva)) {
            return super.addAll(collection);
        }
        zbva zbvaVar = (zbva) collection;
        int i5 = zbvaVar.zbc;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zbc;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        long[] jArr = this.zbb;
        if (i7 > jArr.length) {
            this.zbb = Arrays.copyOf(jArr, i7);
        }
        System.arraycopy(zbvaVar.zbb, 0, this.zbb, this.zbc, zbvaVar.zbc);
        this.zbc = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zbva)) {
            return super.equals(obj);
        }
        zbva zbvaVar = (zbva) obj;
        if (this.zbc != zbvaVar.zbc) {
            return false;
        }
        long[] jArr = zbvaVar.zbb;
        for (int i5 = 0; i5 < this.zbc; i5++) {
            if (this.zbb[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zbi(i5);
        return Long.valueOf(this.zbb[i5]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zbc; i6++) {
            long j6 = this.zbb[i6];
            byte[] bArr = zbuo.zbb;
            i5 = (i5 * 31) + ((int) (j6 ^ (j6 >>> 32)));
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i5 = this.zbc;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.zbb[i6] == jLongValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zba();
        zbi(i5);
        long[] jArr = this.zbb;
        long j6 = jArr[i5];
        int i6 = this.zbc;
        if (i5 < i6 - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.zbc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        zba();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zbb;
        System.arraycopy(jArr, i6, jArr, i5, this.zbc - i6);
        this.zbc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zba();
        zbi(i5);
        long[] jArr = this.zbb;
        long j6 = jArr[i5];
        jArr[i5] = jLongValue;
        return Long.valueOf(j6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i5) {
        if (i5 >= this.zbc) {
            return new zbva(Arrays.copyOf(this.zbb, i5), this.zbc, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zbe(int i5) {
        zbi(i5);
        return this.zbb[i5];
    }

    public final void zbg(long j6) {
        zba();
        int i5 = this.zbc;
        long[] jArr = this.zbb;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[a.c(i5, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.zbb = jArr2;
        }
        long[] jArr3 = this.zbb;
        int i6 = this.zbc;
        this.zbc = i6 + 1;
        jArr3[i6] = j6;
    }

    private zbva(long[] jArr, int i5, boolean z6) {
        super(z6);
        this.zbb = jArr;
        this.zbc = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbg(((Long) obj).longValue());
        return true;
    }
}
