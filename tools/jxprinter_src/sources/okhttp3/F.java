package okhttp3;

import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class F extends p107s4.a {
    public final void a(C1366l c1366l, SSLSocket sSLSocket, boolean z6) {
        String[] strArrJ = c1366l.cipherSuites != null ? p107s4.d.j(C1356i.b, sSLSocket.getEnabledCipherSuites(), c1366l.cipherSuites) : sSLSocket.getEnabledCipherSuites();
        String[] strArrJ2 = c1366l.tlsVersions != null ? p107s4.d.j(p107s4.d.f8239i, sSLSocket.getEnabledProtocols(), c1366l.tlsVersions) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        I4.a aVar = C1356i.b;
        byte[] bArr = p107s4.d.f8235a;
        int length = supportedCipherSuites.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            } else if (aVar.compare(supportedCipherSuites[i5], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i5++;
            }
        }
        if (z6 && i5 != -1) {
            String str = supportedCipherSuites[i5];
            int length2 = strArrJ.length;
            String[] strArr = new String[length2 + 1];
            System.arraycopy(strArrJ, 0, strArr, 0, strArrJ.length);
            strArr[length2] = str;
            strArrJ = strArr;
        }
        C1365k c1365k = new C1365k();
        c1365k.f6658a = c1366l.f6659a;
        c1365k.cipherSuites = c1366l.cipherSuites;
        c1365k.tlsVersions = c1366l.tlsVersions;
        c1365k.b = c1366l.b;
        c1365k.a(strArrJ);
        c1365k.c(strArrJ2);
        C1366l c1366l2 = new C1366l(c1365k);
        String[] strArr2 = c1366l2.tlsVersions;
        if (strArr2 != null) {
            sSLSocket.setEnabledProtocols(strArr2);
        }
        String[] strArr3 = c1366l2.cipherSuites;
        if (strArr3 != null) {
            sSLSocket.setEnabledCipherSuites(strArr3);
        }
    }

    public final void b(S s6, t4.e eVar) {
        s6.exchange = eVar;
    }

    @Override // p107s4.a
    public t4.e exchange(T t6) {
        return t6.exchange;
    }
}
