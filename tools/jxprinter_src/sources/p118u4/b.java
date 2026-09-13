package p118u4;

import A3.AbstractC0157z;
import A4.InterfaceC0170m;
import A4.N;
import com.bumptech.glide.h;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.A;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import okhttp3.r;
import okhttp3.z;
import t4.e;
import t4.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements A {
    @Override // okhttp3.A
    public T intercept(z zVar) throws IOException {
        boolean z6;
        S responseHeaders;
        f fVar = (f) zVar;
        e eVarA = fVar.a();
        M m6 = fVar.d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVarA.writeRequestHeaders(m6);
        o oVar = eVarA.f8669a;
        r rVar = eVarA.b;
        c cVar = eVarA.d;
        S responseHeaders2 = null;
        if (!h.c(m6.b) || m6.body() == null) {
            oVar.exchangeMessageDone(eVarA, true, false, null);
            z6 = false;
        } else {
            if ("100-continue".equalsIgnoreCase(m6.header(HttpHeaders.EXPECT))) {
                eVarA.flushRequest();
                rVar.getClass();
                responseHeaders = eVarA.readResponseHeaders(true);
                z6 = true;
            } else {
                z6 = false;
                responseHeaders = null;
            }
            if (responseHeaders == null) {
                m6.body().getClass();
                InterfaceC0170m interfaceC0170mBuffer = N.buffer(eVarA.createRequestBody(m6, false));
                m6.body().writeTo(interfaceC0170mBuffer);
                interfaceC0170mBuffer.close();
            } else {
                oVar.exchangeMessageDone(eVarA, true, false, null);
                if (cVar.connection().f8679h == null) {
                    cVar.connection().c();
                }
            }
            responseHeaders2 = responseHeaders;
        }
        if (m6.body() != null) {
            m6.body().getClass();
        }
        eVarA.finishRequest();
        if (!z6) {
            rVar.getClass();
        }
        if (responseHeaders2 == null) {
            responseHeaders2 = eVarA.readResponseHeaders(false);
        }
        responseHeaders2.d(m6);
        S sHandshake = responseHeaders2.handshake(cVar.connection().f8677f);
        sHandshake.d = jCurrentTimeMillis;
        sHandshake.e = System.currentTimeMillis();
        T tA = sHandshake.a();
        int i5 = tA.c;
        if (i5 == 100) {
            S responseHeaders3 = eVarA.readResponseHeaders(false);
            responseHeaders3.d(m6);
            S sHandshake2 = responseHeaders3.handshake(cVar.connection().f8677f);
            sHandshake2.d = jCurrentTimeMillis;
            sHandshake2.e = System.currentTimeMillis();
            tA = sHandshake2.a();
            i5 = tA.c;
        }
        rVar.getClass();
        T tA2 = tA.b().body(eVarA.openResponseBody(tA)).a();
        if ("close".equalsIgnoreCase(tA2.f6544a.header(HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(tA2.header(HttpHeaders.CONNECTION))) {
            cVar.connection().c();
        }
        if ((i5 != 204 && i5 != 205) || tA2.body().c() <= 0) {
            return tA2;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "HTTP ", " had non-zero Content-Length: ");
        sbT.append(tA2.body().c());
        throw new ProtocolException(sbT.toString());
    }
}
