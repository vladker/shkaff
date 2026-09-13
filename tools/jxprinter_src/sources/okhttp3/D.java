package okhttp3;

import com.google.common.net.HttpHeaders;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q f6485a;
    final C1376w headers;

    private D(C1376w c1376w, Q q6) {
        this.headers = c1376w;
        this.f6485a = q6;
    }

    public static D create(C1376w c1376w, Q q6) {
        if (q6 == null) {
            throw new NullPointerException("body == null");
        }
        if (c1376w != null && c1376w.get(HttpHeaders.CONTENT_TYPE) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (c1376w == null || c1376w.get(HttpHeaders.CONTENT_LENGTH) == null) {
            return new D(c1376w, q6);
        }
        throw new IllegalArgumentException("Unexpected header: Content-Length");
    }

    public static D createFormData(String str, String str2, Q q6) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        StringBuilder sb = new StringBuilder("form-data; name=");
        E.a(str, sb);
        if (str2 != null) {
            sb.append("; filename=");
            E.a(str2, sb);
        }
        C1375v c1375v = new C1375v();
        String string = sb.toString();
        C1376w.a(HttpHeaders.CONTENT_DISPOSITION);
        c1375v.b(HttpHeaders.CONTENT_DISPOSITION, string);
        return create(new C1376w(c1375v), q6);
    }

    public C1376w headers() {
        return this.headers;
    }
}
