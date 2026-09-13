package com.google.android.gms.internal.play_billing;

import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfj extends zzfm {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    public zzfj(byte[] bArr, int i5, int i6) {
        super(null);
        zzfp.zzj(i5, i5 + i6, bArr.length);
        this.zzb = bArr;
        this.zzc = i5;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final byte zza(int i5) {
        return this.zzb[this.zzc + i5];
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final int zzc(int i5, int i6, int i7) {
        return zzgv.zzb(i5, this.zzb, this.zzc, i7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final zzfp zze(int i5, int i6) {
        int iZzj = zzfp.zzj(i5, i6, this.zzd);
        return iZzj == 0 ? zzfp.zza : new zzfj(this.zzb, this.zzc + i5, iZzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final void zzf(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.zzb, this.zzc, bArr, 0, i7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final void zzg(zzfg zzfgVar) throws zzfv {
        ((zzfu) zzfgVar).zzc(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final boolean zzh(zzfp zzfpVar) {
        boolean z6 = zzfpVar instanceof zzfn;
        if (!z6 && !(zzfpVar instanceof zzfj)) {
            return zzfpVar.zzh(this);
        }
        int i5 = this.zzd;
        if (i5 > zzfpVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i5 + i5);
        }
        if (i5 > zzfpVar.zzd()) {
            throw new IllegalArgumentException(a.h(i5, zzfpVar.zzd(), "Ran off end of other: 0, ", ", "));
        }
        if (z6) {
            return zzfp.zzl(this.zzb, this.zzc, ((zzfn) zzfpVar).zzb, 0, i5);
        }
        if (zzfpVar instanceof zzfj) {
            zzfj zzfjVar = (zzfj) zzfpVar;
            return zzfp.zzl(this.zzb, this.zzc, zzfjVar.zzb, zzfjVar.zzc, i5);
        }
        zzfp zzfpVarZze = zzfpVar.zze(0, i5);
        int i6 = this.zzc;
        return zzfpVarZze.equals(zze(i6, i5 + i6));
    }
}
