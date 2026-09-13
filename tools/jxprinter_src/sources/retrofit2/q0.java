package retrofit2;

import A3.AbstractC0157z;
import java.lang.reflect.Method;
import java.util.ArrayList;
import okhttp3.C1376w;
import okhttp3.C1378y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8154a;
    public final Method b;
    public final C1378y c;
    private final okhttp3.B contentType;
    public final String d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0[] f8157h;
    private final C1376w headers;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f8158i;
    private final String relativeUrl;

    public q0(p0 p0Var) {
        this.f8154a = p0Var.b;
        this.b = p0Var.c;
        this.c = p0Var.f8139a.c;
        this.d = p0Var.httpMethod;
        this.relativeUrl = p0Var.relativeUrl;
        this.headers = p0Var.headers;
        this.contentType = p0Var.contentType;
        this.e = p0Var.f8149o;
        this.f8155f = p0Var.f8150p;
        this.f8156g = p0Var.f8151q;
        this.f8157h = p0Var.parameterHandlers;
        this.f8158i = p0Var.f8152r;
    }

    public okhttp3.M create(Object obj, Object[] objArr) {
        int length = objArr.length;
        i0[] i0VarArr = this.f8157h;
        if (length != i0VarArr.length) {
            throw new IllegalArgumentException(AbstractC0157z.l(")", i0VarArr.length, AbstractC0157z.t(length, "Argument count (", ") doesn't match expected count (")));
        }
        o0 o0Var = new o0(this.d, this.c, this.relativeUrl, this.headers, this.contentType, this.e, this.f8155f, this.f8156g);
        if (this.f8158i) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i5 = 0; i5 < length; i5++) {
            arrayList.add(objArr[i5]);
            i0VarArr[i5].apply(o0Var, objArr[i5]);
        }
        return o0Var.f().tag(B.class, new B(this.f8154a, obj, this.b, arrayList)).a();
    }
}
