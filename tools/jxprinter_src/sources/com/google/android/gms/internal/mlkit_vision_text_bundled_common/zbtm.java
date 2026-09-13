package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbtm extends zbsl implements RandomAccess, zbun {
    private double[] zba;
    private int zbb;

    static {
        new zbtm(new double[0], 0, false);
    }

    public zbtm() {
        this(new double[10], 0, true);
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
        double dDoubleValue = ((Double) obj).doubleValue();
        zba();
        if (i5 < 0 || i5 > (i6 = this.zbb)) {
            throw new IndexOutOfBoundsException(zbg(i5));
        }
        int i7 = i5 + 1;
        double[] dArr = this.zba;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i7, i6 - i5);
        } else {
            double[] dArr2 = new double[a.c(i6, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.zba, i5, dArr2, i7, this.zbb - i5);
            this.zba = dArr2;
        }
        this.zba[i5] = dDoubleValue;
        this.zbb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbtm)) {
            return super.addAll(collection);
        }
        zbtm zbtmVar = (zbtm) collection;
        int i5 = zbtmVar.zbb;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zbb;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        double[] dArr = this.zba;
        if (i7 > dArr.length) {
            this.zba = Arrays.copyOf(dArr, i7);
        }
        System.arraycopy(zbtmVar.zba, 0, this.zba, this.zbb, zbtmVar.zbb);
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
        if (!(obj instanceof zbtm)) {
            return super.equals(obj);
        }
        zbtm zbtmVar = (zbtm) obj;
        if (this.zbb != zbtmVar.zbb) {
            return false;
        }
        double[] dArr = zbtmVar.zba;
        for (int i5 = 0; i5 < this.zbb; i5++) {
            if (Double.doubleToLongBits(this.zba[i5]) != Double.doubleToLongBits(dArr[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zbh(i5);
        return Double.valueOf(this.zba[i5]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zbb; i6++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zba[i6]);
            byte[] bArr = zbuo.zbb;
            i5 = (i5 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i5 = this.zbb;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.zba[i6] == dDoubleValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zba();
        zbh(i5);
        double[] dArr = this.zba;
        double d = dArr[i5];
        int i6 = this.zbb;
        if (i5 < i6 - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (i6 - i5) - 1);
        }
        this.zbb--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        zba();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zba;
        System.arraycopy(dArr, i6, dArr, i5, this.zbb - i6);
        this.zbb -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zba();
        zbh(i5);
        double[] dArr = this.zba;
        double d = dArr[i5];
        dArr[i5] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i5) {
        if (i5 >= this.zbb) {
            return new zbtm(Arrays.copyOf(this.zba, i5), this.zbb, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zbe(int i5) {
        zbh(i5);
        return this.zba[i5];
    }

    public final void zbf(double d) {
        zba();
        int i5 = this.zbb;
        double[] dArr = this.zba;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[a.c(i5, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.zba = dArr2;
        }
        double[] dArr3 = this.zba;
        int i6 = this.zbb;
        this.zbb = i6 + 1;
        dArr3[i6] = d;
    }

    private zbtm(double[] dArr, int i5, boolean z6) {
        super(z6);
        this.zba = dArr;
        this.zbb = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbf(((Double) obj).doubleValue());
        return true;
    }
}
