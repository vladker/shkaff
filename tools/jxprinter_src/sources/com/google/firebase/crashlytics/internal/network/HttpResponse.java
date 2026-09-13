package com.google.firebase.crashlytics.internal.network;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class HttpResponse {
    private final String body;
    private final int code;

    public HttpResponse(int i5, String str) {
        this.code = i5;
        this.body = str;
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }
}
