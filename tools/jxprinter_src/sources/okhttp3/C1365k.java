package okhttp3;

/* JADX INFO: renamed from: okhttp3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1365k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6658a;
    public boolean b;
    String[] cipherSuites;
    String[] tlsVersions;

    public C1365k(boolean z6) {
        this.f6658a = z6;
    }

    public final void a(String... strArr) {
        if (!this.f6658a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.cipherSuites = (String[]) strArr.clone();
    }

    public final void b(C1356i... c1356iArr) {
        if (!this.f6658a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[c1356iArr.length];
        for (int i5 = 0; i5 < c1356iArr.length; i5++) {
            strArr[i5] = c1356iArr[i5].f6581a;
        }
        a(strArr);
    }

    public final void c(String... strArr) {
        if (!this.f6658a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.tlsVersions = (String[]) strArr.clone();
    }

    public final void d(Y... yArr) {
        if (!this.f6658a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        String[] strArr = new String[yArr.length];
        for (int i5 = 0; i5 < yArr.length; i5++) {
            strArr[i5] = yArr[i5].f6552a;
        }
        c(strArr);
    }
}
