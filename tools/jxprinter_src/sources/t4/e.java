package t4;

import A4.N;
import A4.f0;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import okhttp3.C1371q;
import okhttp3.C1376w;
import okhttp3.K;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import okhttp3.W;
import okhttp3.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f8669a;
    public final r b;
    public final f c;
    public final p118u4.c d;
    public boolean e;

    public e(o oVar, K k6, C1371q c1371q, f fVar, p118u4.c cVar) {
        this.f8669a = oVar;
        this.b = c1371q;
        this.c = fVar;
        this.d = cVar;
    }

    public final void a(IOException iOException) {
        f fVar = this.c;
        synchronized (fVar.c) {
            fVar.f8674i = true;
        }
        this.d.connection().trackFailure(iOException);
    }

    public IOException bodyComplete(long j6, boolean z6, boolean z7, IOException iOException) {
        if (iOException != null) {
            a(iOException);
        }
        r rVar = this.b;
        if (z7) {
            if (iOException != null) {
                rVar.getClass();
            } else {
                rVar.getClass();
            }
        }
        if (z6) {
            if (iOException != null) {
                rVar.getClass();
            } else {
                rVar.getClass();
            }
        }
        return this.f8669a.exchangeMessageDone(this, z7, z6, iOException);
    }

    public f0 createRequestBody(M m6, boolean z6) {
        this.e = z6;
        long jContentLength = m6.body().contentLength();
        this.b.getClass();
        return new c(this, this.d.createRequestBody(m6, jContentLength), jContentLength);
    }

    public void finishRequest() throws IOException {
        try {
            this.d.finishRequest();
        } catch (IOException e) {
            this.b.getClass();
            a(e);
            throw e;
        }
    }

    public void flushRequest() throws IOException {
        try {
            this.d.flushRequest();
        } catch (IOException e) {
            this.b.getClass();
            a(e);
            throw e;
        }
    }

    public p148z4.a newWebSocketStreams() {
        o oVar = this.f8669a;
        if (oVar.f8706l) {
            throw new IllegalStateException();
        }
        oVar.f8706l = true;
        oVar.e.k();
        return this.d.connection().newWebSocketStreams(this);
    }

    public W openResponseBody(T t6) throws IOException {
        p118u4.c cVar = this.d;
        r rVar = this.b;
        try {
            rVar.getClass();
            String strHeader = t6.header(HttpHeaders.CONTENT_TYPE);
            long jReportedContentLength = cVar.reportedContentLength(t6);
            return new p118u4.g(strHeader, jReportedContentLength, N.buffer(new d(this, cVar.openResponseBodySource(t6), jReportedContentLength)));
        } catch (IOException e) {
            rVar.getClass();
            a(e);
            throw e;
        }
    }

    public S readResponseHeaders(boolean z6) throws IOException {
        try {
            S responseHeaders = this.d.readResponseHeaders(z6);
            if (responseHeaders == null) {
                return responseHeaders;
            }
            p107s4.a.f8232a.b(responseHeaders, this);
            return responseHeaders;
        } catch (IOException e) {
            this.b.getClass();
            a(e);
            throw e;
        }
    }

    public C1376w trailers() {
        return this.d.trailers();
    }

    public void writeRequestHeaders(M m6) throws IOException {
        r rVar = this.b;
        try {
            rVar.getClass();
            this.d.writeRequestHeaders(m6);
            rVar.getClass();
        } catch (IOException e) {
            rVar.getClass();
            a(e);
            throw e;
        }
    }
}
