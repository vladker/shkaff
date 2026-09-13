package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.K;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f2925a;

    public r(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        K k6 = new K(inputStream, aVar);
        this.f2925a = k6;
        k6.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.g
    public final void a() {
        this.f2925a.release();
    }

    @Override // com.bumptech.glide.load.data.g
    @NonNull
    public InputStream rewindAndGet() {
        K k6 = this.f2925a;
        k6.reset();
        return k6;
    }
}
