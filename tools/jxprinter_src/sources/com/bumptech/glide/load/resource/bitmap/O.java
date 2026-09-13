package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class O implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0524t f3095a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a b;

    public O(C0524t c0524t, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f3095a = c0524t;
        this.b = aVar;
    }

    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull InputStream inputStream, int i5, int i6, @NonNull p126w0.v vVar) {
        boolean z6;
        K k6;
        if (inputStream instanceof K) {
            k6 = (K) inputStream;
            z6 = false;
        } else {
            z6 = true;
            k6 = new K(inputStream, this.b);
        }
        L0.f fVarObtain = L0.f.obtain(k6);
        try {
            return this.f3095a.decode(new L0.o(fVarObtain), i5, i6, vVar, new N(k6, fVarObtain));
        } finally {
            fVarObtain.release();
            if (z6) {
                k6.release();
            }
        }
    }

    @Override // p126w0.x
    public boolean handles(@NonNull InputStream inputStream, @NonNull p126w0.v vVar) {
        this.f3095a.getClass();
        return true;
    }
}
