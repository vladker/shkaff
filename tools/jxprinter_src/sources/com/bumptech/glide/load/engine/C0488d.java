package com.bumptech.glide.load.engine;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0488d extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public C0488d(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
