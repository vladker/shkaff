package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0502s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0505v f3070a;
    public final Pools.Pool b = M0.h.threadSafe(150, new r(this));
    public int c;

    public C0502s(C0505v c0505v) {
        this.f3070a = c0505v;
    }
}
