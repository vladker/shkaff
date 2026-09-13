package com.bumptech.glide.load.data;

import A3.AbstractC0157z;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p144z0.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class p implements e {

    @VisibleForTesting
    static final o DEFAULT_CONNECTION_FACTORY = new n();

    @VisibleForTesting
    static final int INVALID_STATUS_CODE = -1;

    @VisibleForTesting
    static final String REDIRECT_HEADER_FIELD = "Location";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f2922a;
    public final int b;
    public final o c;
    public HttpURLConnection d;
    public InputStream e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f2923f;

    public p(E e, int i5) {
        this(e, i5, DEFAULT_CONNECTION_FACTORY);
    }

    public static int b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    private HttpURLConnection buildAndConfigureConnection(URL url, Map<String, String> map) throws p126w0.e {
        try {
            HttpURLConnection httpURLConnectionBuild = ((n) this.c).build(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionBuild.addRequestProperty(entry.getKey(), entry.getValue());
            }
            int i5 = this.b;
            httpURLConnectionBuild.setConnectTimeout(i5);
            httpURLConnectionBuild.setReadTimeout(i5);
            httpURLConnectionBuild.setUseCaches(false);
            httpURLConnectionBuild.setDoInput(true);
            httpURLConnectionBuild.setInstanceFollowRedirects(false);
            return httpURLConnectionBuild;
        } catch (IOException e) {
            throw new p126w0.e("URL.openConnection threw", 0, e);
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws p126w0.e {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.e = L0.e.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.e = httpURLConnection.getInputStream();
            }
            return this.e;
        } catch (IOException e) {
            throw new p126w0.e("Failed to obtain InputStream", b(httpURLConnection), e);
        }
    }

    private InputStream loadDataWithRedirects(URL url, int i5, URL url2, Map<String, String> map) throws p126w0.e {
        if (i5 >= 5) {
            throw new p126w0.e("Too many (> 5) redirects!", -1, null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new p126w0.e("In re-direct loop", -1, null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionBuildAndConfigureConnection = buildAndConfigureConnection(url, map);
        this.d = httpURLConnectionBuildAndConfigureConnection;
        try {
            httpURLConnectionBuildAndConfigureConnection.connect();
            this.e = this.d.getInputStream();
            if (this.f2923f) {
                return null;
            }
            int iB = b(this.d);
            int i6 = iB / 100;
            if (i6 == 2) {
                return getStreamForSuccessfulRequest(this.d);
            }
            if (i6 != 3) {
                if (iB == -1) {
                    throw new p126w0.e("Http request failed", iB, null);
                }
                try {
                    throw new p126w0.e(this.d.getResponseMessage(), iB, null);
                } catch (IOException e) {
                    throw new p126w0.e("Failed to get a response message", iB, e);
                }
            }
            String headerField = this.d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new p126w0.e("Received empty or null redirect url", iB, null);
            }
            try {
                URL url3 = new URL(url, headerField);
                a();
                return loadDataWithRedirects(url3, i5 + 1, url, map);
            } catch (MalformedURLException e6) {
                throw new p126w0.e(AbstractC0157z.n("Bad redirect url: ", headerField), iB, e6);
            }
        } catch (IOException e7) {
            throw new p126w0.e("Failed to connect or obtain data", b(this.d), e7);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f2923f = true;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public p126w0.a getDataSource() {
        return p126w0.a.b;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull com.bumptech.glide.o oVar, @NonNull d dVar) {
        E e = this.f2922a;
        long logTime = L0.l.getLogTime();
        try {
            dVar.onDataReady(loadDataWithRedirects(e.toURL(), 0, null, e.b.getHeaders()));
        } catch (IOException e6) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e6);
            }
            dVar.onLoadFailed(e6);
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + L0.l.a(logTime));
            }
        }
    }

    @VisibleForTesting
    public p(E e, int i5, o oVar) {
        this.f2922a = e;
        this.b = i5;
        this.c = oVar;
    }
}
