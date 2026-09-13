package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdk extends zzdn {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzdk(byte[] bArr, int i5, int i6) {
        super(null);
        int length = bArr.length;
        if (((length - i6) | i6) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i6)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzb(byte b) throws zzdl {
        try {
            byte[] bArr = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr[i5] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzc(byte[] bArr, int i5, int i6) {
        try {
            System.arraycopy(bArr, i5, this.zzb, this.zzd, i6);
            this.zzd += i6;
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i6)), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzd(int i5, boolean z6) throws zzdl {
        zzt(i5 << 3);
        zzb(z6 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zze(int i5, zzdf zzdfVar) throws zzdl {
        zzt((i5 << 3) | 2);
        zzt(zzdfVar.zzd());
        zzdfVar.zzm(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzf(int i5, int i6) throws zzdl {
        zzt((i5 << 3) | 5);
        zzg(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzg(int i5) throws zzdl {
        try {
            byte[] bArr = this.zzb;
            int i6 = this.zzd;
            int i7 = i6 + 1;
            this.zzd = i7;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i6 + 2;
            this.zzd = i8;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i6 + 3;
            this.zzd = i9;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.zzd = i6 + 4;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzh(int i5, long j6) throws zzdl {
        zzt((i5 << 3) | 1);
        zzi(j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzi(long j6) throws zzdl {
        try {
            byte[] bArr = this.zzb;
            int i5 = this.zzd;
            int i6 = i5 + 1;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) j6) & 255);
            int i7 = i5 + 2;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j6 >> 8)) & 255);
            int i8 = i5 + 3;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j6 >> 16)) & 255);
            int i9 = i5 + 4;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j6 >> 24)) & 255);
            int i10 = i5 + 5;
            this.zzd = i10;
            bArr[i9] = (byte) (((int) (j6 >> 32)) & 255);
            int i11 = i5 + 6;
            this.zzd = i11;
            bArr[i10] = (byte) (((int) (j6 >> 40)) & 255);
            int i12 = i5 + 7;
            this.zzd = i12;
            bArr[i11] = (byte) (((int) (j6 >> 48)) & 255);
            this.zzd = i5 + 8;
            bArr[i12] = (byte) (((int) (j6 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzj(int i5, int i6) throws zzdl {
        zzt(i5 << 3);
        zzk(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzk(int i5) throws zzdl {
        if (i5 >= 0) {
            zzt(i5);
        } else {
            zzv(i5);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzl(byte[] bArr, int i5, int i6) {
        zzc(bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzm(int i5, zzfm zzfmVar, zzge zzgeVar) throws zzdl {
        zzt((i5 << 3) | 2);
        zzt(((zzcq) zzfmVar).zzB(zzgeVar));
        zzgeVar.zzi(zzfmVar, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzn(int i5, zzfm zzfmVar) throws zzdl {
        zzt(11);
        zzs(2, i5);
        zzt(26);
        zzt(zzfmVar.zzF());
        zzfmVar.zzab(this);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzo(int i5, zzdf zzdfVar) throws zzdl {
        zzt(11);
        zzs(2, i5);
        zze(3, zzdfVar);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzp(int i5, String str) throws zzdl {
        zzt((i5 << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws zzdl {
        int i5 = this.zzd;
        try {
            int iZzA = zzdn.zzA(str.length() * 3);
            int iZzA2 = zzdn.zzA(str.length());
            if (iZzA2 != iZzA) {
                zzt(zzhe.zze(str));
                byte[] bArr = this.zzb;
                int i6 = this.zzd;
                this.zzd = zzhe.zzd(str, bArr, i6, this.zzc - i6);
                return;
            }
            int i7 = i5 + iZzA2;
            this.zzd = i7;
            int iZzd = zzhe.zzd(str, this.zzb, i7, this.zzc - i7);
            this.zzd = i5;
            zzt((iZzd - i5) - iZzA2);
            this.zzd = iZzd;
        } catch (zzhd e) {
            this.zzd = i5;
            zzD(str, e);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzdl(e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzr(int i5, int i6) throws zzdl {
        zzt((i5 << 3) | i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzs(int i5, int i6) throws zzdl {
        zzt(i5 << 3);
        zzt(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzt(int i5) throws zzdl {
        while ((i5 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i6 = this.zzd;
                this.zzd = i6 + 1;
                bArr[i6] = (byte) ((i5 | 128) & 255);
                i5 >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
            }
        }
        byte[] bArr2 = this.zzb;
        int i7 = this.zzd;
        this.zzd = i7 + 1;
        bArr2[i7] = (byte) i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzu(int i5, long j6) throws zzdl {
        zzt(i5 << 3);
        zzv(j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzv(long j6) throws zzdl {
        if (!zzdn.zzc || this.zzc - this.zzd < 10) {
            while ((j6 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i5 = this.zzd;
                    this.zzd = i5 + 1;
                    bArr[i5] = (byte) ((((int) j6) | 128) & 255);
                    j6 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
                }
            }
            byte[] bArr2 = this.zzb;
            int i6 = this.zzd;
            this.zzd = i6 + 1;
            bArr2[i6] = (byte) j6;
            return;
        }
        while (true) {
            int i7 = (int) j6;
            if ((j6 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i8 = this.zzd;
                this.zzd = i8 + 1;
                zzgz.zzn(bArr3, i8, (byte) i7);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i9 = this.zzd;
            this.zzd = i9 + 1;
            zzgz.zzn(bArr4, i9, (byte) ((i7 | 128) & 255));
            j6 >>>= 7;
        }
    }
}
