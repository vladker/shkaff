package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbkl extends zbkn {
    final /* synthetic */ zbkm zba;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zbkl(zbkm zbkmVar, zbko zbkoVar, CharSequence charSequence) {
        super(zbkoVar, charSequence);
        this.zba = zbkmVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkn
    public final int zbc(int i5) {
        return this.zba.zba.length() + i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkn
    public final int zbd(int i5) {
        int length = ((zbkn) this).zbb.length();
        int length2 = this.zba.zba.length();
        int i6 = length - length2;
        while (i5 <= i6) {
            for (int i7 = 0; i7 < length2; i7++) {
                if (((zbkn) this).zbb.charAt(i7 + i5) != this.zba.zba.charAt(i7)) {
                    i5++;
                }
            }
            return i5;
        }
        return -1;
    }
}
