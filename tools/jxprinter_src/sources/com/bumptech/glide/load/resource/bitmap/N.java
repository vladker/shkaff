package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class N implements InterfaceC0523s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f3094a;
    public final L0.f b;

    public N(K k6, L0.f fVar) {
        this.f3094a = k6;
        this.b = fVar;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0523s
    public final void b() {
        K k6 = this.f3094a;
        synchronized (k6) {
            k6.c = k6.f3091a.length;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0523s
    public void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap) throws IOException {
        IOException exception = this.b.getException();
        if (exception != null) {
            if (bitmap == null) {
                throw exception;
            }
            cVar.b(bitmap);
            throw exception;
        }
    }
}
