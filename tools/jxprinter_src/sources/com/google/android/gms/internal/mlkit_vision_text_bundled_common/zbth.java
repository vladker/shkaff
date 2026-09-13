package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbth extends zbtk {
    private final byte[] zbb;
    private final int zbc;
    private int zbd;

    public zbth(byte[] bArr, int i5, int i6) {
        super(null);
        int length = bArr.length;
        if (((length - i6) | i6) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i6)));
        }
        this.zbb = bArr;
        this.zbd = 0;
        this.zbc = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final int zba() {
        return this.zbc - this.zbd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbb(byte b) throws zbti {
        try {
            byte[] bArr = this.zbb;
            int i5 = this.zbd;
            this.zbd = i5 + 1;
            bArr[i5] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zbti(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zbd), Integer.valueOf(this.zbc), 1), e);
        }
    }

    public final void zbc(byte[] bArr, int i5, int i6) {
        try {
            System.arraycopy(bArr, 0, this.zbb, this.zbd, i6);
            this.zbd += i6;
        } catch (IndexOutOfBoundsException e) {
            throw new zbti(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zbd), Integer.valueOf(this.zbc), Integer.valueOf(i6)), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbd(int i5, boolean z6) throws zbti {
        zbw(i5 << 3);
        zbb(z6 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbe(byte[] bArr, int i5, int i6) throws zbti {
        zbw(i6);
        zbc(bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbf(int i5, zbtc zbtcVar) throws zbti {
        zbw((i5 << 3) | 2);
        zbg(zbtcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbg(zbtc zbtcVar) throws zbti {
        zbw(zbtcVar.zbd());
        zbtcVar.zbg(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbh(int i5, int i6) throws zbti {
        zbw((i5 << 3) | 5);
        zbi(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbi(int i5) throws zbti {
        try {
            byte[] bArr = this.zbb;
            int i6 = this.zbd;
            int i7 = i6 + 1;
            this.zbd = i7;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i6 + 2;
            this.zbd = i8;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i6 + 3;
            this.zbd = i9;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.zbd = i6 + 4;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zbti(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zbd), Integer.valueOf(this.zbc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbj(int i5, long j6) throws zbti {
        zbw((i5 << 3) | 1);
        zbk(j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbk(long j6) throws zbti {
        try {
            byte[] bArr = this.zbb;
            int i5 = this.zbd;
            int i6 = i5 + 1;
            this.zbd = i6;
            bArr[i5] = (byte) (((int) j6) & 255);
            int i7 = i5 + 2;
            this.zbd = i7;
            bArr[i6] = (byte) (((int) (j6 >> 8)) & 255);
            int i8 = i5 + 3;
            this.zbd = i8;
            bArr[i7] = (byte) (((int) (j6 >> 16)) & 255);
            int i9 = i5 + 4;
            this.zbd = i9;
            bArr[i8] = (byte) (((int) (j6 >> 24)) & 255);
            int i10 = i5 + 5;
            this.zbd = i10;
            bArr[i9] = (byte) (((int) (j6 >> 32)) & 255);
            int i11 = i5 + 6;
            this.zbd = i11;
            bArr[i10] = (byte) (((int) (j6 >> 40)) & 255);
            int i12 = i5 + 7;
            this.zbd = i12;
            bArr[i11] = (byte) (((int) (j6 >> 48)) & 255);
            this.zbd = i5 + 8;
            bArr[i12] = (byte) (((int) (j6 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zbti(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zbd), Integer.valueOf(this.zbc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbl(int i5, int i6) throws zbti {
        zbw(i5 << 3);
        zbm(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbm(int i5) throws zbti {
        if (i5 >= 0) {
            zbw(i5);
        } else {
            zby(i5);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbn(byte[] bArr, int i5, int i6) {
        zbc(bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbo(int i5, zbvm zbvmVar, zbvx zbvxVar) throws zbti {
        zbw((i5 << 3) | 2);
        zbw(((zbsj) zbvmVar).zbj(zbvxVar));
        zbvxVar.zbi(zbvmVar, this.zba);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbp(zbvm zbvmVar) throws zbti {
        zbw(zbvmVar.zbo());
        zbvmVar.zbL(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbq(int i5, zbvm zbvmVar) throws zbti {
        zbw(11);
        zbv(2, i5);
        zbw(26);
        zbp(zbvmVar);
        zbw(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbr(int i5, zbtc zbtcVar) throws zbti {
        zbw(11);
        zbv(2, i5);
        zbf(3, zbtcVar);
        zbw(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbs(int i5, String str) throws zbti {
        zbw((i5 << 3) | 2);
        zbt(str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbt(String str) throws zbti {
        int i5 = this.zbd;
        try {
            int iZbD = zbtk.zbD(str.length() * 3);
            int iZbD2 = zbtk.zbD(str.length());
            if (iZbD2 != iZbD) {
                zbw(zbwv.zbc(str));
                byte[] bArr = this.zbb;
                int i6 = this.zbd;
                this.zbd = zbwv.zbb(str, bArr, i6, this.zbc - i6);
                return;
            }
            int i7 = i5 + iZbD2;
            this.zbd = i7;
            int iZbb = zbwv.zbb(str, this.zbb, i7, this.zbc - i7);
            this.zbd = i5;
            zbw((iZbb - i5) - iZbD2);
            this.zbd = iZbb;
        } catch (zbwu e) {
            this.zbd = i5;
            zbG(str, e);
        } catch (IndexOutOfBoundsException e6) {
            throw new zbti(e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbu(int i5, int i6) throws zbti {
        zbw((i5 << 3) | i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbv(int i5, int i6) throws zbti {
        zbw(i5 << 3);
        zbw(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbw(int i5) throws zbti {
        while ((i5 & (-128)) != 0) {
            try {
                byte[] bArr = this.zbb;
                int i6 = this.zbd;
                this.zbd = i6 + 1;
                bArr[i6] = (byte) ((i5 | 128) & 255);
                i5 >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zbti(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zbd), Integer.valueOf(this.zbc), 1), e);
            }
        }
        byte[] bArr2 = this.zbb;
        int i7 = this.zbd;
        this.zbd = i7 + 1;
        bArr2[i7] = (byte) i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zbx(int i5, long j6) throws zbti {
        zbw(i5 << 3);
        zby(j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk
    public final void zby(long j6) throws zbti {
        if (!zbtk.zbc || this.zbc - this.zbd < 10) {
            while ((j6 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zbb;
                    int i5 = this.zbd;
                    this.zbd = i5 + 1;
                    bArr[i5] = (byte) ((((int) j6) | 128) & 255);
                    j6 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zbti(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zbd), Integer.valueOf(this.zbc), 1), e);
                }
            }
            byte[] bArr2 = this.zbb;
            int i6 = this.zbd;
            this.zbd = i6 + 1;
            bArr2[i6] = (byte) j6;
            return;
        }
        while (true) {
            int i7 = (int) j6;
            if ((j6 & (-128)) == 0) {
                byte[] bArr3 = this.zbb;
                int i8 = this.zbd;
                this.zbd = i8 + 1;
                zbws.zbn(bArr3, i8, (byte) i7);
                return;
            }
            byte[] bArr4 = this.zbb;
            int i9 = this.zbd;
            this.zbd = i9 + 1;
            zbws.zbn(bArr4, i9, (byte) ((i7 | 128) & 255));
            j6 >>>= 7;
        }
    }
}
