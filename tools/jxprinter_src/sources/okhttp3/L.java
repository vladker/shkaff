package okhttp3;

import A3.AbstractC0157z;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class L {
    Q body;
    C1378y url;
    public Map c = Collections.EMPTY_MAP;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6538a = ShareTarget.METHOD_GET;
    public C1375v b = new C1375v();

    public final M a() {
        if (this.url != null) {
            return new M(this);
        }
        throw new IllegalStateException("url == null");
    }

    public final void b(String str) {
        this.b.c(str);
    }

    public final void c(String str) {
        String strJ;
        if (str == null) {
            throw new NullPointerException("url == null");
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            strJ = androidx.exifinterface.media.a.j(str, 3, new StringBuilder("http:"));
        } else {
            strJ = str.regionMatches(true, 0, "wss:", 0, 4) ? androidx.exifinterface.media.a.j(str, 4, new StringBuilder("https:")) : str;
        }
        this.url = new C1377x().parse(null, strJ).a();
    }

    public final void d(C1378y c1378y) {
        if (c1378y == null) {
            throw new NullPointerException("url == null");
        }
        this.url = c1378y;
    }

    public L delete(Q q6) {
        return method("DELETE", q6);
    }

    public L method(String str, Q q6) {
        if (str == null) {
            throw new NullPointerException("method == null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("method.length() == 0");
        }
        if (q6 != null && !com.bumptech.glide.h.c(str)) {
            throw new IllegalArgumentException(AbstractC0157z.o("method ", str, " must not have a request body."));
        }
        if (q6 == null && (str.equals(ShareTarget.METHOD_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT"))) {
            throw new IllegalArgumentException(AbstractC0157z.o("method ", str, " must have a request body."));
        }
        this.f6538a = str;
        this.body = q6;
        return this;
    }

    public L tag(Object obj) {
        return tag(Object.class, obj);
    }

    public <T> L tag(Class<? super T> cls, T t6) {
        if (cls == null) {
            throw new NullPointerException("type == null");
        }
        if (t6 == null) {
            this.c.remove(cls);
            return this;
        }
        if (this.c.isEmpty()) {
            this.c = new LinkedHashMap();
        }
        this.c.put(cls, cls.cast(t6));
        return this;
    }
}
