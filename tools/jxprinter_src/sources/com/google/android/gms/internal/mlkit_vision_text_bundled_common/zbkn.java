package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zbkn extends zbjz {
    final CharSequence zbb;
    int zbc = 0;
    int zbd = Integer.MAX_VALUE;

    public zbkn(zbko zbkoVar, CharSequence charSequence) {
        this.zbb = charSequence;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbjz
    public final /* bridge */ /* synthetic */ Object zba() {
        int iZbc;
        int i5 = this.zbc;
        while (true) {
            int i6 = this.zbc;
            if (i6 == -1) {
                zbb();
                return null;
            }
            int iZbd = zbd(i6);
            if (iZbd == -1) {
                iZbd = this.zbb.length();
                this.zbc = -1;
                iZbc = -1;
            } else {
                iZbc = zbc(iZbd);
                this.zbc = iZbc;
            }
            if (iZbc != i5) {
                if (i5 < iZbd) {
                    this.zbb.charAt(i5);
                }
                if (i5 < iZbd) {
                    this.zbb.charAt(iZbd - 1);
                }
                int i7 = this.zbd;
                if (i7 == 1) {
                    iZbd = this.zbb.length();
                    this.zbc = -1;
                    if (iZbd > i5) {
                        this.zbb.charAt(iZbd - 1);
                    }
                } else {
                    this.zbd = i7 - 1;
                }
                return this.zbb.subSequence(i5, iZbd).toString();
            }
            int i8 = iZbc + 1;
            this.zbc = i8;
            if (i8 > this.zbb.length()) {
                this.zbc = -1;
            }
        }
    }

    public abstract int zbc(int i5);

    public abstract int zbd(int i5);
}
