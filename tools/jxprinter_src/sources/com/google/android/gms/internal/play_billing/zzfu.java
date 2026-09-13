package com.google.android.gms.internal.play_billing;

import androidx.collection.a;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfu extends zzfx {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzfu(byte[] bArr, int i5, int i6) {
        super(null);
        int length = bArr.length;
        if (((length - i6) | i6) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(a.h(length, i6, "Array range is invalid. Buffer.length=", ", offset=0, length="));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzb(byte b) throws zzfv {
        int i5 = this.zzd;
        try {
            int i6 = i5 + 1;
            try {
                this.zzb[i5] = b;
                this.zzd = i6;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i5 = i6;
                throw new zzfv(i5, this.zzc, 1, e);
            }
        } catch (IndexOutOfBoundsException e6) {
            e = e6;
        }
    }

    public final void zzc(byte[] bArr, int i5, int i6) throws zzfv {
        try {
            System.arraycopy(bArr, i5, this.zzb, this.zzd, i6);
            this.zzd += i6;
        } catch (IndexOutOfBoundsException e) {
            throw new zzfv(this.zzd, this.zzc, i6, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzd(int i5, boolean z6) throws zzfv {
        zzu(i5 << 3);
        zzb(z6 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zze(byte[] bArr, int i5, int i6) throws zzfv {
        zzu(i6);
        zzc(bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzf(int i5, zzfp zzfpVar) throws zzfv {
        zzu((i5 << 3) | 2);
        zzg(zzfpVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzg(zzfp zzfpVar) throws zzfv {
        zzu(zzfpVar.zzd());
        zzfpVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzh(int i5, int i6) throws zzfv {
        zzu((i5 << 3) | 5);
        zzi(i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzi(int i5) throws zzfv {
        int i6 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i6] = (byte) i5;
            bArr[i6 + 1] = (byte) (i5 >> 8);
            bArr[i6 + 2] = (byte) (i5 >> 16);
            bArr[i6 + 3] = (byte) (i5 >> 24);
            this.zzd = i6 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzfv(i6, this.zzc, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzj(int i5, long j6) throws zzfv {
        zzu((i5 << 3) | 1);
        zzk(j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzk(long j6) throws zzfv {
        int i5 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i5] = (byte) j6;
            bArr[i5 + 1] = (byte) (j6 >> 8);
            bArr[i5 + 2] = (byte) (j6 >> 16);
            bArr[i5 + 3] = (byte) (j6 >> 24);
            bArr[i5 + 4] = (byte) (j6 >> 32);
            bArr[i5 + 5] = (byte) (j6 >> 40);
            bArr[i5 + 6] = (byte) (j6 >> 48);
            bArr[i5 + 7] = (byte) (j6 >> 56);
            this.zzd = i5 + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzfv(i5, this.zzc, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzl(int i5, int i6) throws zzfv {
        zzu(i5 << 3);
        zzm(i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzm(int i5) throws zzfv {
        IndexOutOfBoundsException indexOutOfBoundsException;
        if (i5 >= 0) {
            zzu(i5);
            return;
        }
        int i6 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            long j6 = i5;
            int i7 = i6 + 1;
            try {
                bArr[i6] = (byte) (((int) j6) | 128);
                int i8 = i6 + 2;
                try {
                    bArr[i7] = (byte) (((int) (j6 >>> 7)) | 128);
                    int i9 = i6 + 3;
                    bArr[i8] = (byte) (((int) (j6 >>> 14)) | 128);
                    i8 = i6 + 4;
                    bArr[i9] = (byte) (((int) (j6 >>> 21)) | 128);
                    int i10 = i6 + 5;
                    bArr[i8] = (byte) (((int) (j6 >>> 28)) | 128);
                    int i11 = i6 + 6;
                    try {
                        bArr[i10] = -1;
                        int i12 = i6 + 7;
                        bArr[i11] = -1;
                        i11 = i6 + 8;
                        bArr[i12] = -1;
                        i7 = i6 + 9;
                        bArr[i11] = -1;
                        i6 += 10;
                        bArr[i7] = 1;
                        this.zzd = i6;
                    } catch (IndexOutOfBoundsException e) {
                        indexOutOfBoundsException = e;
                        i6 = i11;
                        throw new zzfv(i6, this.zzc, 10, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e6) {
                    indexOutOfBoundsException = e6;
                    i6 = i8;
                }
            } catch (IndexOutOfBoundsException e7) {
                i6 = i7;
                indexOutOfBoundsException = e7;
            }
        } catch (IndexOutOfBoundsException e8) {
            indexOutOfBoundsException = e8;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzn(zzhr zzhrVar) throws zzfv {
        zzu(zzhrVar.zzn());
        zzhrVar.zzD(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzo(int i5, zzhr zzhrVar) throws zzfv {
        zzu(11);
        zzt(2, i5);
        zzu(26);
        zzn(zzhrVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzp(int i5, zzfp zzfpVar) throws zzfv {
        zzu(11);
        zzt(2, i5);
        zzf(3, zzfpVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzq(int i5, String str) throws zzfv {
        zzu((i5 << 3) | 2);
        zzr(str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzr(String str) throws zzfv {
        int i5 = this.zzd;
        try {
            int iZzy = zzfx.zzy(str.length() * 3);
            int iZzy2 = zzfx.zzy(str.length());
            if (iZzy2 != iZzy) {
                int i6 = zzjc.zza;
                zzu(zziz.zzb(str));
                byte[] bArr = this.zzb;
                int i7 = this.zzd;
                this.zzd = zzjc.zza(str, bArr, i7, bArr.length - i7);
                return;
            }
            int i8 = i5 + iZzy2;
            this.zzd = i8;
            byte[] bArr2 = this.zzb;
            int iZza = zzjc.zza(str, bArr2, i8, bArr2.length - i8);
            this.zzd = i5;
            zzu((iZza - i5) - iZzy2);
            this.zzd = iZza;
        } catch (IndexOutOfBoundsException e) {
            throw new zzfv(e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzs(int i5, int i6) throws zzfv {
        zzu((i5 << 3) | i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzt(int i5, int i6) throws zzfv {
        zzu(i5 << 3);
        zzu(i6);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0011: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:18), block:B:8:0x0010 */
    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzu(int i5) throws zzfv {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i6;
        int i7 = this.zzd;
        try {
            try {
                if ((i5 & (-128)) == 0) {
                    int i8 = i7 + 1;
                    this.zzb[i7] = (byte) i5;
                    this.zzd = i8;
                    return;
                }
                byte[] bArr = this.zzb;
                int i9 = i7 + 1;
                bArr[i7] = (byte) (i5 | 128);
                int i10 = i5 >>> 7;
                if ((i10 & (-128)) == 0) {
                    int i11 = i7 + 2;
                    bArr[i9] = (byte) i10;
                    this.zzd = i11;
                    return;
                }
                int i12 = i7 + 2;
                try {
                    bArr[i9] = (byte) (i10 | 128);
                    int i13 = i5 >>> 14;
                    if ((i13 & (-128)) == 0) {
                        int i14 = i7 + 3;
                        bArr[i12] = (byte) i13;
                        this.zzd = i14;
                        return;
                    }
                    int i15 = i7 + 3;
                    try {
                        bArr[i12] = (byte) (i13 | 128);
                        int i16 = i5 >>> 21;
                        if ((i16 & (-128)) == 0) {
                            int i17 = i7 + 4;
                            bArr[i15] = (byte) i16;
                            this.zzd = i17;
                            return;
                        } else {
                            i12 = i7 + 4;
                            bArr[i15] = (byte) (i16 | 128);
                            int i18 = i7 + 5;
                            bArr[i12] = (byte) (i5 >>> 28);
                            this.zzd = i18;
                            return;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        indexOutOfBoundsException = e;
                        i7 = i15;
                    }
                } catch (IndexOutOfBoundsException e6) {
                    indexOutOfBoundsException = e6;
                    i7 = i12;
                }
                throw new zzfv(i7, this.zzc, 1, indexOutOfBoundsException);
            } catch (IndexOutOfBoundsException e7) {
                indexOutOfBoundsException = e7;
            }
        } catch (IndexOutOfBoundsException e8) {
            indexOutOfBoundsException = e8;
            i7 = i6;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzv(int i5, long j6) throws zzfv {
        zzu(i5 << 3);
        zzw(j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzw(long j6) throws zzfv {
        long j7 = j6 & (-128);
        int i5 = this.zzd;
        try {
            if (j7 == 0) {
                this.zzb[i5] = (byte) j6;
                this.zzd = i5 + 1;
                return;
            }
            byte[] bArr = this.zzb;
            bArr[i5] = (byte) (((int) j6) | 128);
            int i6 = i5 + 1;
            long j8 = j6 >>> 7;
            long j9 = j8 & (-128);
            int i7 = (int) j8;
            if (j9 == 0) {
                bArr[i6] = (byte) i7;
                this.zzd = i5 + 2;
                return;
            }
            bArr[i6] = (byte) (i7 | 128);
            int i8 = i5 + 2;
            long j10 = j6 >>> 14;
            long j11 = j10 & (-128);
            int i9 = (int) j10;
            if (j11 == 0) {
                bArr[i8] = (byte) i9;
                this.zzd = i5 + 3;
                return;
            }
            bArr[i8] = (byte) (i9 | 128);
            int i10 = i5 + 3;
            long j12 = j6 >>> 21;
            long j13 = j12 & (-128);
            int i11 = (int) j12;
            if (j13 == 0) {
                bArr[i10] = (byte) i11;
                this.zzd = i5 + 4;
                return;
            }
            bArr[i10] = (byte) (i11 | 128);
            int i12 = i5 + 4;
            long j14 = j6 >>> 28;
            long j15 = j14 & (-128);
            int i13 = (int) j14;
            if (j15 == 0) {
                bArr[i12] = (byte) i13;
                this.zzd = i5 + 5;
                return;
            }
            bArr[i12] = (byte) (i13 | 128);
            int i14 = i5 + 5;
            long j16 = j6 >>> 35;
            long j17 = j16 & (-128);
            int i15 = (int) j16;
            if (j17 == 0) {
                bArr[i14] = (byte) i15;
                this.zzd = i5 + 6;
                return;
            }
            bArr[i14] = (byte) (i15 | 128);
            int i16 = i5 + 6;
            long j18 = j6 >>> 42;
            long j19 = j18 & (-128);
            int i17 = (int) j18;
            if (j19 == 0) {
                bArr[i16] = (byte) i17;
                this.zzd = i5 + 7;
                return;
            }
            bArr[i16] = (byte) (i17 | 128);
            int i18 = i5 + 7;
            long j20 = j6 >>> 49;
            long j21 = j20 & (-128);
            int i19 = (int) j20;
            if (j21 == 0) {
                bArr[i18] = (byte) i19;
                this.zzd = i5 + 8;
                return;
            }
            bArr[i18] = (byte) (i19 | 128);
            int i20 = i5 + 8;
            long j22 = j6 >>> 56;
            int i21 = (int) j22;
            if (((-128) & j22) == 0) {
                bArr[i20] = (byte) i21;
                this.zzd = i5 + 9;
            } else {
                bArr[i20] = (byte) (i21 | 128);
                bArr[i5 + 9] = (byte) (j6 >>> 63);
                this.zzd = i5 + 10;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new zzfv(i5, this.zzc, 1, e);
        }
    }
}
