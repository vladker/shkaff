package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbug extends zbsl implements RandomAccess, zbul {
    private static final zbug zba = new zbug(new int[0], 0, false);
    private int[] zbb;
    private int zbc;

    public zbug() {
        this(new int[10], 0, true);
    }

    public static zbug zbf() {
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
        int iIntValue = ((Integer) obj).intValue();
        zba();
        if (i5 < 0 || i5 > (i6 = this.zbc)) {
            throw new IndexOutOfBoundsException(zbh(i5));
        }
        int i7 = i5 + 1;
        int[] iArr = this.zbb;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i7, i6 - i5);
        } else {
            int[] iArr2 = new int[a.c(i6, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.zbb, i5, iArr2, i7, this.zbc - i5);
            this.zbb = iArr2;
        }
        this.zbb[i5] = iIntValue;
        this.zbc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbug)) {
            return super.addAll(collection);
        }
        zbug zbugVar = (zbug) collection;
        int i5 = zbugVar.zbc;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zbc;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        int[] iArr = this.zbb;
        if (i7 > iArr.length) {
            this.zbb = Arrays.copyOf(iArr, i7);
        }
        System.arraycopy(zbugVar.zbb, 0, this.zbb, this.zbc, zbugVar.zbc);
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
        if (!(obj instanceof zbug)) {
            return super.equals(obj);
        }
        zbug zbugVar = (zbug) obj;
        if (this.zbc != zbugVar.zbc) {
            return false;
        }
        int[] iArr = zbugVar.zbb;
        for (int i5 = 0; i5 < this.zbc; i5++) {
            if (this.zbb[i5] != iArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zbi(i5);
        return Integer.valueOf(this.zbb[i5]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zbc; i6++) {
            i5 = (i5 * 31) + this.zbb[i6];
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i5 = this.zbc;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.zbb[i6] == iIntValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zba();
        zbi(i5);
        int[] iArr = this.zbb;
        int i6 = iArr[i5];
        int i7 = this.zbc;
        if (i5 < i7 - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i7 - i5) - 1);
        }
        this.zbc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        zba();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zbb;
        System.arraycopy(iArr, i6, iArr, i5, this.zbc - i6);
        this.zbc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zba();
        zbi(i5);
        int[] iArr = this.zbb;
        int i6 = iArr[i5];
        iArr[i5] = iIntValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i5) {
        if (i5 >= this.zbc) {
            return new zbug(Arrays.copyOf(this.zbb, i5), this.zbc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zbe(int i5) {
        zbi(i5);
        return this.zbb[i5];
    }

    public final void zbg(int i5) {
        zba();
        int i6 = this.zbc;
        int[] iArr = this.zbb;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[a.c(i6, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.zbb = iArr2;
        }
        int[] iArr3 = this.zbb;
        int i7 = this.zbc;
        this.zbc = i7 + 1;
        iArr3[i7] = i5;
    }

    private zbug(int[] iArr, int i5, boolean z6) {
        super(z6);
        this.zbb = iArr;
        this.zbc = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbg(((Integer) obj).intValue());
        return true;
    }
}
