package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbku extends zbkr {
    public zbku() {
        super(4);
    }

    public final zbku zba(Object obj) {
        int i5 = this.zbb;
        int i6 = i5 + 1;
        Object[] objArr = this.zba;
        int length = objArr.length;
        if (length < i6) {
            int i7 = length + (length >> 1) + 1;
            if (i7 < i6) {
                int iHighestOneBit = Integer.highestOneBit(i5);
                i7 = iHighestOneBit + iHighestOneBit;
            }
            if (i7 < 0) {
                i7 = Integer.MAX_VALUE;
            }
            this.zba = Arrays.copyOf(objArr, i7);
            this.zbc = false;
        } else if (this.zbc) {
            this.zba = (Object[]) objArr.clone();
            this.zbc = false;
        }
        Object[] objArr2 = this.zba;
        int i8 = this.zbb;
        this.zbb = i8 + 1;
        objArr2[i8] = obj;
        return this;
    }

    public final zbkx zbb() {
        this.zbc = true;
        return zbkx.zbg(this.zba, this.zbb);
    }
}
