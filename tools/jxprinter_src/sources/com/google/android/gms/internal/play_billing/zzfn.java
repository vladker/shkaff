package com.google.android.gms.internal.play_billing;

import androidx.collection.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfn extends zzfm {
    private final byte[] zzb;

    public zzfn(byte[] bArr) {
        super(null);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final byte zza(int i5) {
        return this.zzb[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final int zzc(int i5, int i6, int i7) {
        return zzgv.zzb(i5, this.zzb, 0, i7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final int zzd() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final zzfp zze(int i5, int i6) {
        byte[] bArr = this.zzb;
        int iZzj = zzfp.zzj(0, i6, bArr.length);
        return iZzj == 0 ? zzfp.zza : new zzfj(bArr, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final void zzf(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.zzb, 0, bArr, 0, i7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final void zzg(zzfg zzfgVar) throws zzfv {
        byte[] bArr = this.zzb;
        ((zzfu) zzfgVar).zzc(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final boolean zzh(zzfp zzfpVar) {
        boolean z6 = zzfpVar instanceof zzfn;
        if (z6) {
            return Arrays.equals(this.zzb, ((zzfn) zzfpVar).zzb);
        }
        boolean z7 = zzfpVar instanceof zzfj;
        if (!z7) {
            return zzfpVar.zzh(this);
        }
        byte[] bArr = this.zzb;
        int iZzd = zzfpVar.zzd();
        int length = bArr.length;
        if (length > iZzd) {
            throw new IllegalArgumentException("Length too large: " + length + length);
        }
        if (length > zzfpVar.zzd()) {
            throw new IllegalArgumentException(a.h(length, zzfpVar.zzd(), "Ran off end of other: 0, ", ", "));
        }
        if (z6) {
            return zzfp.zzl(bArr, 0, ((zzfn) zzfpVar).zzb, 0, length);
        }
        if (!z7) {
            return zzfpVar.zze(0, length).equals(zze(0, length));
        }
        zzfj zzfjVar = (zzfj) zzfpVar;
        return zzfp.zzl(bArr, 0, zzfjVar.zzb, zzfjVar.zzc, length);
    }
}
