package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfb extends zzcs implements RandomAccess, zzeo {
    private long[] zza;
    private int zzb;

    static {
        new zzfb(new long[0], 0, false);
    }

    public zzfb() {
        this(new long[10], 0, true);
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
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i5));
        }
        int i7 = i5 + 1;
        long[] jArr = this.zza;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i7, i6 - i5);
        } else {
            long[] jArr2 = new long[a.c(i6, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.zza, i5, jArr2, i7, this.zzb - i5);
            this.zza = jArr2;
        }
        this.zza[i5] = jLongValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzfb)) {
            return super.addAll(collection);
        }
        zzfb zzfbVar = (zzfb) collection;
        int i5 = zzfbVar.zzb;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzb;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        long[] jArr = this.zza;
        if (i7 > jArr.length) {
            this.zza = Arrays.copyOf(jArr, i7);
        }
        System.arraycopy(zzfbVar.zza, 0, this.zza, this.zzb, zzfbVar.zzb);
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
        if (!(obj instanceof zzfb)) {
            return super.equals(obj);
        }
        zzfb zzfbVar = (zzfb) obj;
        if (this.zzb != zzfbVar.zzb) {
            return false;
        }
        long[] jArr = zzfbVar.zza;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            if (this.zza[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zzh(i5);
        return Long.valueOf(this.zza[i5]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            long j6 = this.zza[i6];
            byte[] bArr = zzep.zzb;
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
        int i5 = this.zzb;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.zza[i6] == jLongValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zza();
        zzh(i5);
        long[] jArr = this.zza;
        long j6 = jArr[i5];
        int i6 = this.zzb;
        if (i5 < i6 - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zza;
        System.arraycopy(jArr, i6, jArr, i5, this.zzb - i6);
        this.zzb -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        zzh(i5);
        long[] jArr = this.zza;
        long j6 = jArr[i5];
        jArr[i5] = jLongValue;
        return Long.valueOf(j6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo
    public final /* bridge */ /* synthetic */ zzeo zzd(int i5) {
        if (i5 >= this.zzb) {
            return new zzfb(Arrays.copyOf(this.zza, i5), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i5) {
        zzh(i5);
        return this.zza[i5];
    }

    public final void zzf(long j6) {
        zza();
        int i5 = this.zzb;
        long[] jArr = this.zza;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[a.c(i5, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.zza = jArr2;
        }
        long[] jArr3 = this.zza;
        int i6 = this.zzb;
        this.zzb = i6 + 1;
        jArr3[i6] = j6;
    }

    private zzfb(long[] jArr, int i5, boolean z6) {
        super(z6);
        this.zza = jArr;
        this.zzb = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
