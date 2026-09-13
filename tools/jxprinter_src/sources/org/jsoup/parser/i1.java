package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f7670a;
    public C1465a b;
    public Q c;
    public org.jsoup.nodes.i d;
    public ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public O f7672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public D f7673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f7674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final M f7675j = new M();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final L f7676k = new L();

    public final org.jsoup.nodes.m a() {
        int size = this.e.size();
        return size > 0 ? (org.jsoup.nodes.m) this.e.get(size - 1) : this.d;
    }

    public final boolean b(String str) {
        org.jsoup.nodes.m mVarA;
        return (this.e.size() == 0 || (mVarA = a()) == null || !mVarA.c.b.equals(str)) ? false : true;
    }

    public abstract D c();

    public abstract boolean d(O o6);

    public final boolean e(String str) {
        O o6 = this.f7672g;
        L l6 = this.f7676k;
        if (o6 == l6) {
            L l7 = new L();
            l7.p(str);
            return d(l7);
        }
        l6.f();
        l6.p(str);
        return d(l6);
    }

    public final void f(String str) {
        O o6 = this.f7672g;
        M m6 = this.f7675j;
        if (o6 == m6) {
            M m7 = new M();
            m7.p(str);
            d(m7);
        } else {
            m6.f();
            m6.p(str);
            d(m6);
        }
    }

    public final void g() {
        O o6;
        Q q6 = this.c;
        do {
            H h6 = q6.f7571l;
            while (!q6.e) {
                q6.c.d(q6, q6.f7564a);
            }
            StringBuilder sb = q6.f7566g;
            if (sb.length() != 0) {
                String string = sb.toString();
                sb.delete(0, sb.length());
                q6.f7565f = null;
                h6.b = string;
                o6 = h6;
            } else {
                String str = q6.f7565f;
                if (str != null) {
                    h6.b = str;
                    q6.f7565f = null;
                    o6 = h6;
                } else {
                    q6.e = false;
                    o6 = q6.d;
                }
            }
            d(o6);
            o6.f();
        } while (o6.f7560a != 6);
    }

    public final F h(String str, D d) {
        F f6 = (F) this.f7674i.get(str);
        if (f6 != null) {
            return f6;
        }
        F fE = F.e(str, d);
        this.f7674i.put(str, fE);
        return fE;
    }

    public void initialiseParse(Reader reader, String str, E e) {
        V4.h.notNull(reader, "String input must not be null");
        V4.h.notNull(str, "BaseURI must not be null");
        V4.h.notNull(e);
        org.jsoup.nodes.i iVar = new org.jsoup.nodes.i(str);
        this.d = iVar;
        iVar.f7472h = e;
        this.f7670a = e;
        this.f7673h = e.c;
        C1465a c1465a = new C1465a(reader, 32768);
        this.b = c1465a;
        c1465a.y(e.b.f7542a > 0);
        this.f7672g = null;
        this.c = new Q(this.b, e.b);
        this.e = new ArrayList(32);
        this.f7674i = new HashMap();
        this.f7671f = str;
    }

    public org.jsoup.nodes.i parse(Reader reader, String str, E e) {
        initialiseParse(reader, str, e);
        g();
        this.b.d();
        this.b = null;
        this.c = null;
        this.e = null;
        this.f7674i = null;
        return this.d;
    }
}
