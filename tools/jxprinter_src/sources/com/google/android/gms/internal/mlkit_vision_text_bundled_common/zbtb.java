package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class zbtb extends zbta {
    protected final byte[] zba;

    public zbtb(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zba = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zbtc) || zbd() != ((zbtc) obj).zbd()) {
            return false;
        }
        if (zbd() == 0) {
            return true;
        }
        if (!(obj instanceof zbtb)) {
            return obj.equals(this);
        }
        zbtb zbtbVar = (zbtb) obj;
        int iZbi = zbi();
        int iZbi2 = zbtbVar.zbi();
        if (iZbi != 0 && iZbi2 != 0 && iZbi != iZbi2) {
            return false;
        }
        int iZbd = zbd();
        if (iZbd > zbtbVar.zbd()) {
            throw new IllegalArgumentException("Length too large: " + iZbd + zbd());
        }
        if (iZbd > zbtbVar.zbd()) {
            throw new IllegalArgumentException(a.h(iZbd, zbtbVar.zbd(), "Ran off end of other: 0, ", ", "));
        }
        byte[] bArr = this.zba;
        byte[] bArr2 = zbtbVar.zba;
        zbtbVar.zbc();
        int i5 = 0;
        int i6 = 0;
        while (i5 < iZbd) {
            if (bArr[i5] != bArr2[i6]) {
                return false;
            }
            i5++;
            i6++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public byte zba(int i5) {
        return this.zba[i5];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public byte zbb(int i5) {
        return this.zba[i5];
    }

    public int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public int zbd() {
        return this.zba.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final int zbe(int i5, int i6, int i7) {
        return zbuo.zbb(i5, this.zba, 0, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final zbtc zbf(int i5, int i6) {
        int iZbh = zbtc.zbh(0, i6, zbd());
        return iZbh == 0 ? zbtc.zbb : new zbsw(this.zba, 0, iZbh);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final void zbg(zbst zbstVar) {
        ((zbth) zbstVar).zbc(this.zba, 0, zbd());
    }
}
