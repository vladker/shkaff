package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcp extends zzcf {
    static final zzcp zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzcp(objArr, 0, objArr, 0, 0);
    }

    public zzcp(Object[] objArr, int i5, Object[] objArr2, int i6, int i7) {
        this.zzb = objArr;
        this.zze = i5;
        this.zzc = objArr2;
        this.zzf = i6;
        this.zzg = i7;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzbu.zza(obj.hashCode());
                while (true) {
                    int i5 = iZza & this.zzf;
                    Object obj2 = objArr[i5];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i5 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf, com.google.android.gms.internal.play_billing.zzbx, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final int zza(Object[] objArr, int i5) {
        Object[] objArr2 = this.zzb;
        int i6 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, 0, i6);
        return i6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf, com.google.android.gms.internal.play_billing.zzbx
    /* JADX INFO: renamed from: zze */
    public final zzcs iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final boolean zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final Object[] zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf
    public final zzca zzi() {
        return zzca.zzi(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf
    public final boolean zzl() {
        return true;
    }
}
