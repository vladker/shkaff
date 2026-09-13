package okhttp3;

import A4.C0173p;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0173p f6484a;
    public B b;
    public final ArrayList c;

    public C() {
        String string = UUID.randomUUID().toString();
        this.b = E.e;
        this.c = new ArrayList();
        this.f6484a = C0173p.encodeUtf8(string);
    }

    public final void a(D d) {
        if (d == null) {
            throw new NullPointerException("part == null");
        }
        this.c.add(d);
    }

    public C addFormDataPart(String str, String str2, Q q6) {
        a(D.createFormData(str, str2, q6));
        return this;
    }

    public C addPart(C1376w c1376w, Q q6) {
        a(D.create(c1376w, q6));
        return this;
    }
}
