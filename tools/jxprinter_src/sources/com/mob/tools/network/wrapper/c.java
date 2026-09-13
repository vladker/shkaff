package com.mob.tools.network.wrapper;

import cn.fly.tools.network.RawNetworkCallback;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class c implements RawNetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mob.tools.network.RawNetworkCallback f3663a;

    private c(com.mob.tools.network.RawNetworkCallback rawNetworkCallback) {
        this.f3663a = rawNetworkCallback;
    }

    public static c a(com.mob.tools.network.RawNetworkCallback rawNetworkCallback) {
        if (rawNetworkCallback == null) {
            return null;
        }
        return new c(rawNetworkCallback);
    }

    @Override // cn.fly.tools.network.RawNetworkCallback
    public void onResponse(InputStream inputStream) {
        this.f3663a.onResponse(inputStream);
    }
}
