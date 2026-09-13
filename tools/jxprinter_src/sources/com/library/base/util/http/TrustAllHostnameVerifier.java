package com.library.base.util.http;

import android.annotation.SuppressLint;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class TrustAllHostnameVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    @SuppressLint({"BadHostnameVerifier"})
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
