package com.google.android.odml.image;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzb extends zzh {
    private Integer zza;
    private Integer zzb;

    @Override // com.google.android.odml.image.zzh
    public final zzh zza(int i5) {
        this.zza = Integer.valueOf(i5);
        return this;
    }

    @Override // com.google.android.odml.image.zzh
    public final zzh zzb(int i5) {
        this.zzb = Integer.valueOf(i5);
        return this;
    }

    @Override // com.google.android.odml.image.zzh
    public final ImageProperties zzc() {
        Integer num = this.zza;
        if (num != null && this.zzb != null) {
            return new zzc(num.intValue(), this.zzb.intValue(), null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" imageFormat");
        }
        if (this.zzb == null) {
            sb.append(" storageType");
        }
        String strValueOf = String.valueOf(sb);
        throw new IllegalStateException(AbstractC0157z.s(new StringBuilder(strValueOf.length() + 28), "Missing required properties:", strValueOf));
    }
}
