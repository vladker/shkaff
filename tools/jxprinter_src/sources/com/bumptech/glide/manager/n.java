package com.bumptech.glide.manager;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f3171a;
    public final /* synthetic */ p b;

    public n(p pVar, Lifecycle lifecycle) {
        this.b = pVar;
        this.f3171a = lifecycle;
    }

    @Override // com.bumptech.glide.manager.m
    public final void onDestroy() {
        this.b.f3173a.remove(this.f3171a);
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStop() {
    }
}
