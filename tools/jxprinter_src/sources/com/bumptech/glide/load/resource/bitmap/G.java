package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class G implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0509d f3088a = new C0509d();

    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull InputStream inputStream, int i5, int i6, @NonNull p126w0.v vVar) {
        return this.f3088a.decode(ImageDecoder.createSource(L0.c.fromStream(inputStream)), i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull InputStream inputStream, @NonNull p126w0.v vVar) {
        return true;
    }
}
