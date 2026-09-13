package com.shockwave.pdfium.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3766a;
    public final int b;

    public Size(int i5, int i6) {
        this.f3766a = i5;
        this.b = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f3766a == size.f3766a && this.b == size.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.f3766a;
        return ((i5 >>> 16) | (i5 << 16)) ^ this.b;
    }

    public final String toString() {
        return this.f3766a + "x" + this.b;
    }
}
