package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbss extends zbsl implements RandomAccess, zbun {
    private boolean[] zba;
    private int zbb;

    static {
        new zbss(new boolean[0], 0, false);
    }

    public zbss() {
        this(new boolean[10], 0, true);
    }

    private final String zbg(int i5) {
        return a.h(i5, this.zbb, "Index:", ", Size:");
    }

    private final void zbh(int i5) {
        if (i5 < 0 || i5 >= this.zbb) {
            throw new IndexOutOfBoundsException(zbg(i5));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zba();
        if (i5 < 0 || i5 > (i6 = this.zbb)) {
            throw new IndexOutOfBoundsException(zbg(i5));
        }
        int i7 = i5 + 1;
        boolean[] zArr = this.zba;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i7, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[a.c(i6, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.zba, i5, zArr2, i7, this.zbb - i5);
            this.zba = zArr2;
        }
        this.zba[i5] = zBooleanValue;
        this.zbb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbss)) {
            return super.addAll(collection);
        }
        zbss zbssVar = (zbss) collection;
        int i5 = zbssVar.zbb;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zbb;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        boolean[] zArr = this.zba;
        if (i7 > zArr.length) {
            this.zba = Arrays.copyOf(zArr, i7);
        }
        System.arraycopy(zbssVar.zba, 0, this.zba, this.zbb, zbssVar.zbb);
        this.zbb = i7;
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
        if (!(obj instanceof zbss)) {
            return super.equals(obj);
        }
        zbss zbssVar = (zbss) obj;
        if (this.zbb != zbssVar.zbb) {
            return false;
        }
        boolean[] zArr = zbssVar.zba;
        for (int i5 = 0; i5 < this.zbb; i5++) {
            if (this.zba[i5] != zArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zbh(i5);
        return Boolean.valueOf(this.zba[i5]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZba = 1;
        for (int i5 = 0; i5 < this.zbb; i5++) {
            iZba = (iZba * 31) + zbuo.zba(this.zba[i5]);
        }
        return iZba;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i5 = this.zbb;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.zba[i6] == zBooleanValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zba();
        zbh(i5);
        boolean[] zArr = this.zba;
        boolean z6 = zArr[i5];
        int i6 = this.zbb;
        if (i5 < i6 - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (i6 - i5) - 1);
        }
        this.zbb--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        zba();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zba;
        System.arraycopy(zArr, i6, zArr, i5, this.zbb - i6);
        this.zbb -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zba();
        zbh(i5);
        boolean[] zArr = this.zba;
        boolean z6 = zArr[i5];
        zArr[i5] = zBooleanValue;
        return Boolean.valueOf(z6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i5) {
        if (i5 >= this.zbb) {
            return new zbss(Arrays.copyOf(this.zba, i5), this.zbb, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zbe(boolean z6) {
        zba();
        int i5 = this.zbb;
        boolean[] zArr = this.zba;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[a.c(i5, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.zba = zArr2;
        }
        boolean[] zArr3 = this.zba;
        int i6 = this.zbb;
        this.zbb = i6 + 1;
        zArr3[i6] = z6;
    }

    public final boolean zbf(int i5) {
        zbh(i5);
        return this.zba[i5];
    }

    private zbss(boolean[] zArr, int i5, boolean z6) {
        super(z6);
        this.zba = zArr;
        this.zbb = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbe(((Boolean) obj).booleanValue());
        return true;
    }
}
