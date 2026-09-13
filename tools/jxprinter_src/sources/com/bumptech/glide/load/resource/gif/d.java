package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.bumptech.glide.gifdecoder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.c f3136a;

    @Nullable
    private final com.bumptech.glide.load.engine.bitmap_recycle.a arrayPool;

    public d(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @Nullable com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f3136a = cVar;
        this.arrayPool = aVar;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    @NonNull
    public Bitmap obtain(int i5, int i6, @NonNull Bitmap.Config config) {
        return this.f3136a.getDirty(i5, i6, config);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    @NonNull
    public byte[] obtainByteArray(int i5) {
        com.bumptech.glide.load.engine.bitmap_recycle.a aVar = this.arrayPool;
        return aVar == null ? new byte[i5] : (byte[]) ((com.bumptech.glide.load.engine.bitmap_recycle.j) aVar).c(i5, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    @NonNull
    public int[] obtainIntArray(int i5) {
        com.bumptech.glide.load.engine.bitmap_recycle.a aVar = this.arrayPool;
        return aVar == null ? new int[i5] : (int[]) ((com.bumptech.glide.load.engine.bitmap_recycle.j) aVar).c(i5, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void release(@NonNull Bitmap bitmap) {
        this.f3136a.b(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void release(@NonNull byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.a aVar = this.arrayPool;
        if (aVar == null) {
            return;
        }
        ((com.bumptech.glide.load.engine.bitmap_recycle.j) aVar).g(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void release(@NonNull int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.a aVar = this.arrayPool;
        if (aVar == null) {
            return;
        }
        ((com.bumptech.glide.load.engine.bitmap_recycle.j) aVar).g(iArr);
    }
}
