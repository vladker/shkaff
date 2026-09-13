package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import A3.AbstractC0157z;
import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbsw extends zbtb {
    private final int zbc;

    public zbsw(byte[] bArr, int i5, int i6) {
        super(bArr);
        zbtc.zbh(0, i6, bArr.length);
        this.zbc = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final byte zba(int i5) {
        int i6 = this.zbc;
        if (((i6 - (i5 + 1)) | i5) >= 0) {
            return ((zbtb) this).zba[i5];
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.k(i5, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(a.h(i5, i6, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final byte zbb(int i5) {
        return ((zbtb) this).zba[i5];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb
    public final int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final int zbd() {
        return this.zbc;
    }
}
