package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0512g implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0524t f3110a;

    public C0512g(C0524t c0524t) {
        this.f3110a = c0524t;
    }

    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull ByteBuffer byteBuffer, int i5, int i6, @NonNull p126w0.v vVar) {
        return this.f3110a.decode(byteBuffer, i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull p126w0.v vVar) {
        this.f3110a.getClass();
        return true;
    }
}
