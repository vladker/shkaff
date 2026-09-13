package cn.fly.tools.b;

import android.content.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f1686a = new c();
    private volatile Context b;
    private volatile a c;
    private volatile a d;
    private volatile a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f1687f = new AtomicBoolean(false);

    public static c a(Context context) {
        if (f1686a.b == null && context != null) {
            f1686a.b = context.getApplicationContext();
        }
        return f1686a;
    }

    public void b() {
        if (this.f1687f.compareAndSet(false, true)) {
            d();
            c();
            e.a(this.b);
        }
    }

    public a c() {
        if (this.c == null) {
            this.c = new k(this.b);
        }
        return this.c;
    }

    public a d() {
        if (this.d == null) {
            this.d = new g(this.b);
        }
        return this.d;
    }

    public a e() {
        return this.e == null ? c() : this.e;
    }

    public CountDownLatch a() {
        b();
        return d.a(this.b).a();
    }

    public boolean a(a aVar) {
        this.e = aVar;
        return true;
    }
}
