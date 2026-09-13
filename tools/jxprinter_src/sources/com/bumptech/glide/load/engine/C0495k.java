package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0495k implements InterfaceC0498n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p126w0.a f3031a;
    public final /* synthetic */ RunnableC0497m b;

    public C0495k(RunnableC0497m runnableC0497m, p126w0.a aVar) {
        this.b = runnableC0497m;
        this.f3031a = aVar;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0498n
    @NonNull
    public O onResourceDecoded(@NonNull O o6) {
        return this.b.onResourceDecoded(this.f3031a, o6);
    }
}
