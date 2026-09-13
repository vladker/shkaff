package com.bumptech.glide.load;

import p126w0.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    ANIMATED_WEBP(true),
    AVIF(true),
    ANIMATED_AVIF(true),
    UNKNOWN(false);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2914a;

    ImageHeaderParser$ImageType(boolean z6) {
        this.f2914a = z6;
    }

    public boolean hasAlpha() {
        return this.f2914a;
    }

    public boolean isWebp() {
        int i5 = f.f8805a[ordinal()];
        return i5 == 1 || i5 == 2 || i5 == 3;
    }
}
