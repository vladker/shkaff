package cn.fly.commons.a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class j extends c {
    private static cn.fly.commons.l b;

    public j() {
        super("p", 0L, null, 0L, 0L);
        a(0);
    }

    private synchronized boolean n() {
        if (b != null) {
            return false;
        }
        b = new cn.fly.commons.l() { // from class: cn.fly.commons.a.j.1
            @Override // cn.fly.commons.l
            public void a(boolean z6, boolean z7, long j6) {
                if (z6) {
                    j.this.a(Long.valueOf(System.currentTimeMillis()));
                    d.a().a(j.this, 0L, 0);
                }
            }
        };
        cn.fly.commons.m.a().a(b);
        return true;
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        if (i()) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put(cn.fly.commons.o.a("004i3ec3jf"), "PVMT");
        map.put(cn.fly.commons.o.a("008,dc4difiKdidfKf"), this.f1211a);
        if (!cn.fly.commons.k.a().f1458a.get()) {
            map.putAll(cn.fly.commons.k.a().c());
            cn.fly.commons.k.a().f1458a.compareAndSet(false, true);
        }
        cn.fly.commons.d.a().a(System.currentTimeMillis(), map);
    }

    @Override // cn.fly.commons.a.c
    public void d() {
        n();
    }
}
