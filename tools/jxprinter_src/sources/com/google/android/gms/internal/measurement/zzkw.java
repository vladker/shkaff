package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkw {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlr zzd;
    public int zze;

    public zzkw() {
        int i5 = zzlr.zzb;
        int i6 = zznu.zza;
        this.zzd = zzlr.zza;
    }

    public static /* synthetic */ String zza(int i5, int i6, byte b, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + b + String.valueOf(i5).length());
        sb.append(str);
        sb.append(i6);
        sb.append(str2);
        sb.append(i5);
        return sb.toString();
    }

    public zzkw(zzlr zzlrVar) {
        zzlrVar.getClass();
        this.zzd = zzlrVar;
    }
}
