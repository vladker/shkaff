package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbcr {
    private final int zba;
    private final int zbb;

    public zbcr(int i5, int i6) {
        zbkj.zbc(i5 < 32767 && i5 >= 0);
        zbkj.zbc(i6 < 32767 && i6 >= 0);
        this.zba = i5;
        this.zbb = i6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zbcr) {
            zbcr zbcrVar = (zbcr) obj;
            if (this.zba == zbcrVar.zba && this.zbb == zbcrVar.zbb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zba << 16) | this.zbb;
    }

    public final String toString() {
        return this.zba + "x" + this.zbb;
    }

    public final int zba() {
        return this.zbb;
    }

    public final int zbb() {
        return this.zba;
    }
}
