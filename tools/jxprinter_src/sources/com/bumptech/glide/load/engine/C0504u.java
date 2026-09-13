package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0504u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p138y0.e f3072a;
    public final p138y0.e b;
    public final p138y0.e c;
    public final p138y0.e d;
    public final x e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x f3073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pools.Pool f3074g = M0.h.threadSafe(150, new C0503t(this));

    public C0504u(p138y0.e eVar, p138y0.e eVar2, p138y0.e eVar3, p138y0.e eVar4, x xVar, x xVar2) {
        this.f3072a = eVar;
        this.b = eVar2;
        this.c = eVar3;
        this.d = eVar4;
        this.e = xVar;
        this.f3073f = xVar2;
    }

    @VisibleForTesting
    public void shutdown() {
        L0.i.shutdownAndAwaitTermination(this.f3072a);
        L0.i.shutdownAndAwaitTermination(this.b);
        L0.i.shutdownAndAwaitTermination(this.c);
        L0.i.shutdownAndAwaitTermination(this.d);
    }
}
