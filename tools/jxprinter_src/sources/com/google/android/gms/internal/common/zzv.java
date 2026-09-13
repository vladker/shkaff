package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzv extends zzk {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = Integer.MAX_VALUE;

    public zzv(zzw zzwVar, CharSequence charSequence) {
        this.zzc = zzwVar.zzf();
        this.zzd = zzwVar.zzg();
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.common.zzk
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int i5 = this.zze;
        while (true) {
            int i6 = this.zze;
            if (i6 == -1) {
                zzb();
                return null;
            }
            int iZzc = zzc(i6);
            if (iZzc == -1) {
                iZzc = this.zzb.length();
                this.zze = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zze = iZzd;
            }
            if (iZzd == i5) {
                int i7 = iZzd + 1;
                this.zze = i7;
                if (i7 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i5 < iZzc) {
                    this.zzb.charAt(i5);
                }
                if (i5 < iZzc) {
                    this.zzb.charAt(iZzc - 1);
                }
                if (!this.zzd || i5 != iZzc) {
                    int i8 = this.zzf;
                    if (i8 == 1) {
                        CharSequence charSequence = this.zzb;
                        int length = charSequence.length();
                        this.zze = -1;
                        if (length > i5) {
                            charSequence.charAt(length - 1);
                        }
                        iZzc = length;
                    } else {
                        this.zzf = i8 - 1;
                    }
                    return this.zzb.subSequence(i5, iZzc).toString();
                }
                i5 = this.zze;
            }
        }
    }

    public abstract int zzc(int i5);

    public abstract int zzd(int i5);
}
