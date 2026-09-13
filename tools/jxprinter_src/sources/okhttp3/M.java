package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1378y f6539a;
    public final String b;
    final Q body;
    public final C1376w c;
    private volatile C1351d cacheControl;
    public final Map d;

    public M(L l6) {
        this.f6539a = l6.url;
        this.b = l6.f6538a;
        C1375v c1375v = l6.b;
        c1375v.getClass();
        this.c = new C1376w(c1375v);
        this.body = l6.body;
        Map map = l6.c;
        byte[] bArr = p107s4.d.f8235a;
        this.d = map.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public final C1351d a() {
        C1351d c1351d = this.cacheControl;
        if (c1351d != null) {
            return c1351d;
        }
        C1351d c1351dA = C1351d.a(this.c);
        this.cacheControl = c1351dA;
        return c1351dA;
    }

    public final L b() {
        L l6 = new L();
        Map linkedHashMap = Collections.EMPTY_MAP;
        l6.c = linkedHashMap;
        l6.url = this.f6539a;
        l6.f6538a = this.b;
        l6.body = this.body;
        Map map = this.d;
        if (!map.isEmpty()) {
            linkedHashMap = new LinkedHashMap(map);
        }
        l6.c = linkedHashMap;
        l6.b = this.c.d();
        return l6;
    }

    public Q body() {
        return this.body;
    }

    public String header(String str) {
        return this.c.get(str);
    }

    public Object tag() {
        return tag(Object.class);
    }

    public final String toString() {
        return "Request{method=" + this.b + ", url=" + this.f6539a + ", tags=" + this.d + '}';
    }

    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.d.get(cls));
    }
}
