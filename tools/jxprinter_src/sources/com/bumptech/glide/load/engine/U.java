package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class U implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p144z0.S f2978a;
    public final /* synthetic */ V b;

    public U(V v6, p144z0.S s6) {
        this.b = v6;
        this.f2978a = s6;
    }

    @Override // com.bumptech.glide.load.data.d
    public void onDataReady(@Nullable Object obj) {
        V v6 = this.b;
        p144z0.S s6 = this.f2978a;
        p144z0.S s7 = v6.f2980f;
        if (s7 == null || s7 != s6) {
            return;
        }
        V v7 = this.b;
        p144z0.S s8 = this.f2978a;
        AbstractC0501q abstractC0501q = v7.f2979a.f3028p;
        if (obj != null && abstractC0501q.c(s8.c.getDataSource())) {
            v7.e = obj;
            v7.b.h(2);
        } else {
            RunnableC0497m runnableC0497m = v7.b;
            p126w0.q qVar = s8.f9063a;
            com.bumptech.glide.load.data.e eVar = s8.c;
            runnableC0497m.onDataFetcherReady(qVar, obj, eVar, eVar.getDataSource(), v7.f2981g);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void onLoadFailed(@NonNull Exception exc) {
        V v6 = this.b;
        p144z0.S s6 = this.f2978a;
        p144z0.S s7 = v6.f2980f;
        if (s7 == null || s7 != s6) {
            return;
        }
        v6.onLoadFailedInternal(s6, exc);
    }
}
