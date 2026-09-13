package retrofit2;

import A3.AbstractC0157z;
import java.util.Objects;
import okhttp3.C1376w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class r0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.T f8159a;
    private final T body;
    private final okhttp3.W errorBody;

    private r0(okhttp3.T t6, T t7, okhttp3.W w6) {
        this.f8159a = t6;
        this.body = t7;
        this.errorBody = w6;
    }

    public static r0 a(okhttp3.W w6, okhttp3.T t6) {
        Objects.requireNonNull(w6, "body == null");
        if (t6.a()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new r0(t6, null, w6);
    }

    public static <T> r0<T> success(T t6) {
        okhttp3.S s6 = new okhttp3.S();
        s6.f6543a = 200;
        s6.b = "OK";
        s6.c(okhttp3.I.HTTP_1_1);
        okhttp3.L l6 = new okhttp3.L();
        l6.c("http://localhost/");
        s6.d(l6.a());
        return success(t6, s6.a());
    }

    public T body() {
        return this.body;
    }

    public okhttp3.W errorBody() {
        return this.errorBody;
    }

    public final String toString() {
        return this.f8159a.toString();
    }

    public static <T> r0<T> success(int i5, T t6) {
        if (i5 >= 200 && i5 < 300) {
            okhttp3.S s6 = new okhttp3.S();
            s6.f6543a = i5;
            s6.b = "Response.success()";
            s6.c(okhttp3.I.HTTP_1_1);
            okhttp3.L l6 = new okhttp3.L();
            l6.c("http://localhost/");
            s6.d(l6.a());
            return success(t6, s6.a());
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "code < 200 or >= 300: "));
    }

    public static <T> r0<T> success(T t6, C1376w c1376w) {
        Objects.requireNonNull(c1376w, "headers == null");
        okhttp3.S s6 = new okhttp3.S();
        s6.f6543a = 200;
        s6.b = "OK";
        s6.c(okhttp3.I.HTTP_1_1);
        s6.c = c1376w.d();
        okhttp3.L l6 = new okhttp3.L();
        l6.c("http://localhost/");
        s6.d(l6.a());
        return success(t6, s6.a());
    }

    public static <T> r0<T> success(T t6, okhttp3.T t7) {
        Objects.requireNonNull(t7, "rawResponse == null");
        if (t7.a()) {
            return new r0<>(t7, t6, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
