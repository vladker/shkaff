package com.google.android.gms.internal.measurement;

import androidx.collection.a;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlk extends zzlm {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzlk(byte[] bArr, int i5, int i6) {
        super(null);
        int length = bArr.length;
        if (((length - i6) | i6) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(a.h(length, i6, "Array range is invalid. Buffer.length=", ", offset=0, length="));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zza(int i5, int i6) throws zzll {
        zzr((i5 << 3) | i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzb(int i5, int i6) throws zzll {
        zzr(i5 << 3);
        zzq(i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzc(int i5, int i6) throws zzll {
        zzr(i5 << 3);
        zzr(i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzd(int i5, int i6) throws zzll {
        zzr((i5 << 3) | 5);
        zzs(i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zze(int i5, long j6) throws zzll {
        zzr(i5 << 3);
        zzt(j6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzf(int i5, long j6) throws zzll {
        zzr((i5 << 3) | 1);
        zzu(j6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzg(int i5, boolean z6) throws zzll {
        zzr(i5 << 3);
        zzp(z6 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzh(int i5, String str) throws zzll {
        zzr((i5 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzi(int i5, zzlh zzlhVar) throws zzll {
        zzr((i5 << 3) | 2);
        zzj(zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzj(zzlh zzlhVar) throws zzll {
        zzr(zzlhVar.zzc());
        zzlhVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzk(byte[] bArr, int i5, int i6) throws zzll {
        zzr(i6);
        zzv(bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzl(int i5, zznm zznmVar, zznx zznxVar) throws zzll {
        zzr((i5 << 3) | 2);
        zzr(((zzks) zznmVar).zzcd(zznxVar));
        zznxVar.zzf(zznmVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzm(int i5, zznm zznmVar) throws zzll {
        zzr(11);
        zzc(2, i5);
        zzr(26);
        zzo(zznmVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzn(int i5, zzlh zzlhVar) throws zzll {
        zzr(11);
        zzc(2, i5);
        zzi(3, zzlhVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzo(zznm zznmVar) throws zzll {
        zzr(zznmVar.zzcn());
        zznmVar.zzcB(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzp(byte b) throws zzll {
        int i5 = this.zze;
        try {
            int i6 = i5 + 1;
            try {
                this.zzc[i5] = b;
                this.zze = i6;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i5 = i6;
                throw new zzll(i5, this.zzd, 1, e);
            }
        } catch (IndexOutOfBoundsException e6) {
            e = e6;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzq(int i5) throws zzll {
        if (i5 >= 0) {
            zzr(i5);
        } else {
            zzt(i5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzr(int i5) throws zzll {
        int i6;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i7 = this.zze;
        while ((i5 & (-128)) != 0) {
            try {
                i6 = i7 + 1;
                try {
                    this.zzc[i7] = (byte) (i5 | 128);
                    i5 >>>= 7;
                    i7 = i6;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                    i7 = i6;
                    throw new zzll(i7, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e6) {
                indexOutOfBoundsException = e6;
                throw new zzll(i7, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i6 = i7 + 1;
        this.zzc[i7] = (byte) i5;
        this.zze = i6;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzs(int i5) throws zzll {
        int i6 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i6] = (byte) i5;
            bArr[i6 + 1] = (byte) (i5 >> 8);
            bArr[i6 + 2] = (byte) (i5 >> 16);
            bArr[i6 + 3] = (byte) (i5 >> 24);
            this.zze = i6 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(i6, this.zzd, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzt(long j6) throws zzll {
        int i5;
        IndexOutOfBoundsException indexOutOfBoundsException;
        boolean z6 = zzlm.zzd;
        int i6 = this.zze;
        if (!z6 || this.zzd - i6 < 10) {
            while ((j6 & (-128)) != 0) {
                try {
                    int i7 = i6 + 1;
                    try {
                        this.zzc[i6] = (byte) (((int) j6) | 128);
                        j6 >>>= 7;
                        i6 = i7;
                    } catch (IndexOutOfBoundsException e) {
                        indexOutOfBoundsException = e;
                        i6 = i7;
                        throw new zzll(i6, this.zzd, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e6) {
                    indexOutOfBoundsException = e6;
                }
            }
            i5 = i6 + 1;
            try {
                this.zzc[i6] = (byte) j6;
            } catch (IndexOutOfBoundsException e7) {
                indexOutOfBoundsException = e7;
                i6 = i5;
                throw new zzll(i6, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j6 & (-128)) != 0) {
                zzop.zzp(this.zzc, i6, (byte) (((int) j6) | 128));
                j6 >>>= 7;
                i6++;
            }
            i5 = i6 + 1;
            zzop.zzp(this.zzc, i6, (byte) j6);
        }
        this.zze = i5;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzu(long j6) throws zzll {
        int i5 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i5] = (byte) j6;
            bArr[i5 + 1] = (byte) (j6 >> 8);
            bArr[i5 + 2] = (byte) (j6 >> 16);
            bArr[i5 + 3] = (byte) (j6 >> 24);
            bArr[i5 + 4] = (byte) (j6 >> 32);
            bArr[i5 + 5] = (byte) (j6 >> 40);
            bArr[i5 + 6] = (byte) (j6 >> 48);
            bArr[i5 + 7] = (byte) (j6 >> 56);
            this.zze = i5 + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(i5, this.zzd, 8, e);
        }
    }

    public final void zzv(byte[] bArr, int i5, int i6) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i6);
            this.zze += i6;
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(this.zze, this.zzd, i6, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzw(byte[] bArr, int i5, int i6) {
        zzv(bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzx(String str) throws zzll {
        int i5 = this.zze;
        try {
            int iZzz = zzlm.zzz(str.length() * 3);
            int iZzz2 = zzlm.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzr(zzos.zzb(str));
                byte[] bArr = this.zzc;
                int i6 = this.zze;
                this.zze = zzos.zzc(str, bArr, i6, this.zzd - i6);
                return;
            }
            int i7 = i5 + iZzz2;
            this.zze = i7;
            int iZzc = zzos.zzc(str, this.zzc, i7, this.zzd - i7);
            this.zze = i5;
            zzr((iZzc - i5) - iZzz2);
            this.zze = iZzc;
        } catch (zzor e) {
            this.zze = i5;
            zzF(str, e);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzll(e6);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzy() {
        return this.zzd - this.zze;
    }
}
