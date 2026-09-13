package t4;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.C1366l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8666a;
    public int b = 0;
    public boolean c;
    public boolean d;

    public b(List list) {
        this.f8666a = list;
    }

    public C1366l configureSecureSocket(SSLSocket sSLSocket) throws UnknownServiceException {
        boolean z6;
        C1366l c1366l;
        int i5 = this.b;
        List list = this.f8666a;
        int size = list.size();
        while (true) {
            z6 = true;
            if (i5 >= size) {
                c1366l = null;
                break;
            }
            c1366l = (C1366l) list.get(i5);
            if (c1366l.a(sSLSocket)) {
                this.b = i5 + 1;
                break;
            }
            i5++;
        }
        if (c1366l == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + list + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        for (int i6 = this.b; i6 < list.size(); i6++) {
            if (((C1366l) list.get(i6)).a(sSLSocket)) {
                this.c = z6;
                p107s4.a.f8232a.a(c1366l, sSLSocket, this.d);
                return c1366l;
            }
        }
        z6 = false;
        this.c = z6;
        p107s4.a.f8232a.a(c1366l, sSLSocket, this.d);
        return c1366l;
    }
}
