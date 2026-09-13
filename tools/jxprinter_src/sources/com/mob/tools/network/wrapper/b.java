package com.mob.tools.network.wrapper;

import cn.fly.tools.network.HttpConnection;
import cn.fly.tools.network.HttpResponseCallback;

/* JADX INFO: loaded from: classes3.dex */
public class b implements HttpResponseCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mob.tools.network.HttpResponseCallback f3662a;

    private b(com.mob.tools.network.HttpResponseCallback httpResponseCallback) {
        this.f3662a = httpResponseCallback;
    }

    public static b a(com.mob.tools.network.HttpResponseCallback httpResponseCallback) {
        if (httpResponseCallback == null) {
            return null;
        }
        return new b(httpResponseCallback);
    }

    @Override // cn.fly.tools.network.HttpResponseCallback
    public void onResponse(HttpConnection httpConnection) {
        this.f3662a.onResponse(HttpConnectionWrapper.adapt(httpConnection));
    }
}
