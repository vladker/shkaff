package p079o;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.TimeZone;
import p050j.a;
import p050j.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class G extends a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Y f6324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b0 f6325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f6327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f6328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SimpleDateFormat f6329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IdentityHashMap f6330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public W f6331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TimeZone f6332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Locale f6333r;

    public G(b0 b0Var, Y y6) {
        this.f6326k = 0;
        this.f6327l = "\t";
        this.f6330o = null;
        this.f6332q = a.f5372a;
        this.f6333r = a.b;
        this.f6325j = b0Var;
        this.f6324i = y6;
    }

    public final boolean e(Object obj) {
        W w6;
        IdentityHashMap identityHashMap = this.f6330o;
        if (identityHashMap == null || (w6 = (W) identityHashMap.get(obj)) == null) {
            return false;
        }
        Object obj2 = w6.c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public final void f() {
        b0 b0Var = this.f6325j;
        b0Var.write(10);
        for (int i5 = 0; i5 < this.f6326k; i5++) {
            b0Var.write(this.f6327l);
        }
    }

    public final void g(W w6, Object obj, Object obj2, int i5) {
        if (this.f6325j.f6371g) {
            return;
        }
        this.f6331p = new W(w6, obj, obj2, i5);
        if (this.f6330o == null) {
            this.f6330o = new IdentityHashMap();
        }
        this.f6330o.put(obj, this.f6331p);
    }

    public final void h(Object obj) {
        if (obj == null) {
            this.f6325j.n();
            return;
        }
        try {
            this.f6324i.b(obj.getClass()).write(this, obj, null, null, 0);
        } catch (IOException e) {
            throw new d(e.getMessage(), e);
        }
    }

    public final void i(String str) {
        b0 b0Var = this.f6325j;
        if (str == null) {
            b0Var.p(c0.WriteNullStringAsEmpty);
        } else {
            b0Var.q(str);
        }
    }

    public final void j(Object obj) {
        W w6 = this.f6331p;
        Object obj2 = w6.b;
        b0 b0Var = this.f6325j;
        if (obj == obj2) {
            b0Var.write("{\"$ref\":\"@\"}");
            return;
        }
        W w7 = w6.f6344a;
        if (w7 != null && obj == w7.b) {
            b0Var.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            W w8 = w6.f6344a;
            if (w8 == null) {
                break;
            } else {
                w6 = w8;
            }
        }
        if (obj == w6.b) {
            b0Var.write("{\"$ref\":\"$\"}");
            return;
        }
        b0Var.write("{\"$ref\":\"");
        b0Var.write(((W) this.f6330o.get(obj)).toString());
        b0Var.write("\"}");
    }

    public final String toString() {
        return this.f6325j.toString();
    }

    public G(b0 b0Var) {
        this(b0Var, Y.e);
    }
}
