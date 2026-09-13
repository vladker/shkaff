package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0513h implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0509d f3111a = new C0509d();

    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull ByteBuffer byteBuffer, int i5, int i6, @NonNull p126w0.v vVar) {
        return this.f3111a.decode(ImageDecoder.createSource(byteBuffer), i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull p126w0.v vVar) {
        return true;
    }
}
