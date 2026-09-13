package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: okhttp3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1366l {
    public static final C1366l c;
    public static final C1366l d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6659a;
    public final boolean b;
    final String[] cipherSuites;
    final String[] tlsVersions;

    static {
        C1356i c1356i = C1356i.f6578q;
        C1356i c1356i2 = C1356i.f6579r;
        C1356i c1356i3 = C1356i.f6580s;
        C1356i c1356i4 = C1356i.f6572k;
        C1356i c1356i5 = C1356i.f6574m;
        C1356i c1356i6 = C1356i.f6573l;
        C1356i c1356i7 = C1356i.f6575n;
        C1356i c1356i8 = C1356i.f6577p;
        C1356i c1356i9 = C1356i.f6576o;
        C1356i[] c1356iArr = {c1356i, c1356i2, c1356i3, c1356i4, c1356i5, c1356i6, c1356i7, c1356i8, c1356i9};
        C1356i[] c1356iArr2 = {c1356i, c1356i2, c1356i3, c1356i4, c1356i5, c1356i6, c1356i7, c1356i8, c1356i9, C1356i.f6570i, C1356i.f6571j, C1356i.f6568g, C1356i.f6569h, C1356i.e, C1356i.f6567f, C1356i.d};
        C1365k c1365k = new C1365k(true);
        c1365k.b(c1356iArr);
        Y y6 = Y.TLS_1_3;
        Y y7 = Y.TLS_1_2;
        c1365k.d(y6, y7);
        c1365k.b = true;
        C1365k c1365k2 = new C1365k(true);
        c1365k2.b(c1356iArr2);
        c1365k2.d(y6, y7);
        c1365k2.b = true;
        c = new C1366l(c1365k2);
        C1365k c1365k3 = new C1365k(true);
        c1365k3.b(c1356iArr2);
        c1365k3.d(y6, y7, Y.TLS_1_1, Y.TLS_1_0);
        c1365k3.b = true;
        d = new C1366l(new C1365k(false));
    }

    public C1366l(C1365k c1365k) {
        this.f6659a = c1365k.f6658a;
        this.cipherSuites = c1365k.cipherSuites;
        this.tlsVersions = c1365k.tlsVersions;
        this.b = c1365k.b;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.f6659a) {
            return false;
        }
        String[] strArr = this.tlsVersions;
        if (strArr != null && !p107s4.d.l(p107s4.d.f8239i, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.cipherSuites;
        return strArr2 == null || p107s4.d.l(C1356i.b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public List<C1356i> cipherSuites() {
        String[] strArr = this.cipherSuites;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C1356i.a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1366l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1366l c1366l = (C1366l) obj;
        boolean z6 = c1366l.f6659a;
        boolean z7 = this.f6659a;
        if (z7 != z6) {
            return false;
        }
        if (z7) {
            return Arrays.equals(this.cipherSuites, c1366l.cipherSuites) && Arrays.equals(this.tlsVersions, c1366l.tlsVersions) && this.b == c1366l.b;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f6659a) {
            return ((((527 + Arrays.hashCode(this.cipherSuites)) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public List<Y> tlsVersions() {
        String[] strArr = this.tlsVersions;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(Y.a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        if (!this.f6659a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ")";
    }
}
