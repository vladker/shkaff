package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0491g implements com.bumptech.glide.load.engine.cache.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p126w0.d f3016a;
    public final Object b;
    public final p126w0.v c;

    public C0491g(p126w0.d dVar, Object obj, p126w0.v vVar) {
        this.f3016a = dVar;
        this.b = obj;
        this.c = vVar;
    }

    @Override // com.bumptech.glide.load.engine.cache.b
    public boolean write(@NonNull File file) {
        return this.f3016a.encode(this.b, file, this.c);
    }
}
