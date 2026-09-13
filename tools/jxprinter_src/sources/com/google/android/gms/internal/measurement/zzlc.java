package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlc extends zzlg {
    private final int zzc;

    public zzlc(byte[] bArr, int i5, int i6) {
        super(bArr);
        zzlh.zzj(0, i6, bArr.length);
        this.zzc = i6;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zza(int i5) {
        int i6 = this.zzc;
        if (((i6 - (i5 + 1)) | i5) >= 0) {
            return ((zzlg) this).zza[i5];
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(a.q(new StringBuilder(String.valueOf(i5).length() + 11), "Index < 0: ", i5));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 18 + String.valueOf(i6).length());
        sb.append("Index > length: ");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zzb(int i5) {
        return ((zzlg) this).zza[i5];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final int zzd() {
        return 0;
    }
}
