package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdp extends zzcs implements RandomAccess, zzeo {
    private double[] zza;
    private int zzb;

    static {
        new zzdp(new double[0], 0, false);
    }

    public zzdp() {
        this(new double[10], 0, true);
    }

    private final String zzg(int i5) {
        return a.h(i5, this.zzb, "Index:", ", Size:");
    }

    private final void zzh(int i5) {
        if (i5 < 0 || i5 >= this.zzb) {
            throw new IndexOutOfBoundsException(zzg(i5));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i5));
        }
        int i7 = i5 + 1;
        double[] dArr = this.zza;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i7, i6 - i5);
        } else {
            double[] dArr2 = new double[a.c(i6, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.zza, i5, dArr2, i7, this.zzb - i5);
            this.zza = dArr2;
        }
        this.zza[i5] = dDoubleValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzdp)) {
            return super.addAll(collection);
        }
        zzdp zzdpVar = (zzdp) collection;
        int i5 = zzdpVar.zzb;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzb;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        double[] dArr = this.zza;
        if (i7 > dArr.length) {
            this.zza = Arrays.copyOf(dArr, i7);
        }
        System.arraycopy(zzdpVar.zza, 0, this.zza, this.zzb, zzdpVar.zzb);
        this.zzb = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return super.equals(obj);
        }
        zzdp zzdpVar = (zzdp) obj;
        if (this.zzb != zzdpVar.zzb) {
            return false;
        }
        double[] dArr = zzdpVar.zza;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            if (Double.doubleToLongBits(this.zza[i5]) != Double.doubleToLongBits(dArr[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zzh(i5);
        return Double.valueOf(this.zza[i5]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zza[i6]);
            byte[] bArr = zzep.zzb;
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
        int i5 = this.zzb;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.zza[i6] == dDoubleValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zza();
        zzh(i5);
        double[] dArr = this.zza;
        double d = dArr[i5];
        int i6 = this.zzb;
        if (i5 < i6 - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (i6 - i5) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zza;
        System.arraycopy(dArr, i6, dArr, i5, this.zzb - i6);
        this.zzb -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        zzh(i5);
        double[] dArr = this.zza;
        double d = dArr[i5];
        dArr[i5] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i5) {
        if (i5 >= this.zzb) {
            return new zzdp(Arrays.copyOf(this.zza, i5), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i5) {
        zzh(i5);
        return this.zza[i5];
    }

    public final void zzf(double d) {
        zza();
        int i5 = this.zzb;
        double[] dArr = this.zza;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[a.c(i5, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.zza = dArr2;
        }
        double[] dArr3 = this.zza;
        int i6 = this.zzb;
        this.zzb = i6 + 1;
        dArr3[i6] = d;
    }

    private zzdp(double[] dArr, int i5, boolean z6) {
        super(z6);
        this.zza = dArr;
        this.zzb = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
