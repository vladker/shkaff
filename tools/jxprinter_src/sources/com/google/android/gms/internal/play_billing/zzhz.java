package com.google.android.gms.internal.play_billing;

import androidx.collection.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhz extends zzfb implements RandomAccess {
    private static final Object[] zza;
    private static final zzhz zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzhz(objArr, 0, false);
    }

    public zzhz() {
        this(zza, 0, true);
    }

    public static zzhz zze() {
        return zzb;
    }

    private static int zzg(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final String zzh(int i5) {
        return a.h(i5, this.zzd, "Index:", ", Size:");
    }

    private final void zzi(int i5) {
        if (i5 < 0 || i5 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzh(i5));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfb, java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        int i6;
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzh(i5));
        }
        int i7 = i5 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i6 < length) {
            System.arraycopy(objArr, i5, objArr, i7, i6 - i5);
        } else {
            Object[] objArr2 = new Object[zzg(length)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i5);
            System.arraycopy(this.zzc, i5, objArr2, i7, this.zzd - i5);
            this.zzc = objArr2;
        }
        this.zzc[i5] = obj;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int i5 = this.zzd;
        if (i5 != list.size()) {
            return false;
        }
        if (!(obj instanceof zzhz)) {
            for (int i6 = 0; i6 < i5; i6++) {
                if (!this.zzc[i6].equals(list.get(i6))) {
                    return false;
                }
            }
            return true;
        }
        zzhz zzhzVar = (zzhz) obj;
        for (int i7 = 0; i7 < i5; i7++) {
            if (!this.zzc[i7].equals(zzhzVar.zzc[i7])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        zzi(i5);
        return this.zzc[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.zzfb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = this.zzd;
        int iHashCode = 1;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + this.zzc[i6].hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfb, java.util.AbstractList, java.util.List
    public final Object remove(int i5) {
        zza();
        zzi(i5);
        Object[] objArr = this.zzc;
        Object obj = objArr[i5];
        int i6 = this.zzd;
        if (i5 < i6 - 1) {
            System.arraycopy(objArr, i5 + 1, objArr, i5, (i6 - i5) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfb, java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        zza();
        zzi(i5);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgu
    public final /* bridge */ /* synthetic */ zzgu zzd(int i5) {
        if (i5 >= this.zzd) {
            return new zzhz(i5 == 0 ? zza : Arrays.copyOf(this.zzc, i5), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(int i5) {
        int length = this.zzc.length;
        if (i5 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i5, 10)];
            return;
        }
        while (length < i5) {
            length = zzg(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzhz(Object[] objArr, int i5, boolean z6) {
        super(z6);
        this.zzc = objArr;
        this.zzd = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i5 = this.zzd;
        int length = this.zzc.length;
        if (i5 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzg(length));
        }
        Object[] objArr = this.zzc;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        objArr[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
