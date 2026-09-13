package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzli extends zzlj {
    private int zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzli(byte[] bArr, int i5, int i6, boolean z6, byte[] bArr2) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zzb = 0;
    }

    public final int zza(int i5) {
        int i6 = this.zzd;
        this.zzd = 0;
        int i7 = this.zzb + this.zzc;
        this.zzb = i7;
        if (i7 <= 0) {
            this.zzc = 0;
            return i6;
        }
        this.zzc = i7;
        this.zzb = 0;
        return i6;
    }
}
