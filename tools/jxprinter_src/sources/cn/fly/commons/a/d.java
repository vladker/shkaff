package cn.fly.commons.a;

import cn.fly.commons.ab;
import cn.fly.commons.ac;
import cn.fly.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f1224a;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final ArrayList<c> c = new ArrayList<>();

    private d() {
        a(new a());
        a(new b());
        a(new e());
        a(new f());
        a(new k());
        g gVar = new g();
        gVar.c();
        a(gVar);
        a(new h());
        a(new j());
        a(new i());
        a(new m());
        a(new n());
        a(new o());
    }

    public static d a() {
        if (f1224a == null) {
            synchronized (ab.class) {
                try {
                    if (f1224a == null) {
                        f1224a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1224a;
    }

    private long c() {
        return ((Integer) ResHelper.forceCast(cn.fly.commons.c.a(cn.fly.commons.m.a("003Afl(lk"), 300), 300)).intValue() * 1000;
    }

    public void b() {
        if (this.b.compareAndSet(false, true)) {
            ac.f1261a.execute(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.isEmpty()) {
            l.a().b(c(), this);
            return;
        }
        if (!cn.fly.commons.c.e() || !cn.fly.commons.e.j()) {
            l.a().b(60000L, this);
            return;
        }
        try {
            ArrayList<c> arrayList = this.c;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                c cVar = arrayList.get(i5);
                i5++;
                c cVar2 = cVar;
                if (cVar2.i() || cVar2.f()) {
                    cVar2.j();
                }
            }
        } catch (Throwable unused) {
        }
        l.a().b(c(), this);
    }

    public void b(c cVar, long j6, int i5) {
        l.a().a(j6, cVar, i5, false);
    }

    private <T extends c> void a(T t6) {
        this.c.add(t6);
    }

    public void a(c cVar, long j6, int i5) {
        l.a().a(j6, cVar, i5);
    }
}
