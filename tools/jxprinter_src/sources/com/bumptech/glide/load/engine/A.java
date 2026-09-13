package com.bumptech.glide.load.engine;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I0.m f2927a;
    public final Executor b;

    public A(I0.m mVar, Executor executor) {
        this.f2927a = mVar;
        this.b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof A) {
            return this.f2927a.equals(((A) obj).f2927a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2927a.hashCode();
    }
}
