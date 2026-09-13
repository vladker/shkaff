package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f2924a;

    public q(com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f2924a = aVar;
    }

    @Override // com.bumptech.glide.load.data.f
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.f
    @NonNull
    public g build(InputStream inputStream) {
        return new r(inputStream, this.f2924a);
    }
}
