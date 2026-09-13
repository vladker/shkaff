package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhv implements zzib {
    private final zzhr zza;
    private final zziq zzb;
    private final boolean zzc;
    private final zzgd zzd;

    private zzhv(zziq zziqVar, zzgd zzgdVar, zzhr zzhrVar) {
        this.zzb = zziqVar;
        this.zzc = zzhrVar instanceof zzgm;
        this.zzd = zzgdVar;
        this.zza = zzhrVar;
    }

    public static zzhv zzc(zziq zziqVar, zzgd zzgdVar, zzhr zzhrVar) {
        return new zzhv(zziqVar, zzgdVar, zzhrVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final int zza(Object obj) {
        int iZzb = ((zzgp) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzgm) obj).zzb.zzd() : iZzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final int zzb(Object obj) {
        int iHashCode = ((zzgp) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzgm) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final Object zze() {
        zzhr zzhrVar = this.zza;
        return zzhrVar instanceof zzgp ? ((zzgp) zzhrVar).zzs() : zzhrVar.zzw().zzk();
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzf(Object obj) {
        ((zzgp) obj).zzc.zzh();
        ((zzgm) obj).zzb.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzg(Object obj, Object obj2) {
        zzic.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzic.zzo(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzh(Object obj, byte[] bArr, int i5, int i6, zzfd zzfdVar) {
        zzgp zzgpVar = (zzgp) obj;
        if (zzgpVar.zzc == zzir.zzc()) {
            zzgpVar.zzc = zzir.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzi(Object obj, zzji zzjiVar) {
        Iterator itZzf = ((zzgm) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzgg zzggVar = (zzgg) entry.getKey();
            if (zzggVar.zzc() != zzjh.MESSAGE || zzggVar.zze() || zzggVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzgw) {
                zzjiVar.zzx(zzggVar.zza(), ((zzgw) entry).zza().zzb());
            } else {
                zzjiVar.zzx(zzggVar.zza(), entry.getValue());
            }
        }
        ((zzgp) obj).zzc.zzk(zzjiVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzgp) obj).zzc.equals(((zzgp) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgm) obj).zzb.equals(((zzgm) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final boolean zzk(Object obj) {
        return ((zzgm) obj).zzb.zzj();
    }
}
