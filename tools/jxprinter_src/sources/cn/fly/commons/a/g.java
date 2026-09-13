package cn.fly.commons.a;

import cn.fly.commons.ae;
import cn.fly.tools.FlyLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends c {
    private static volatile cn.fly.commons.l b;
    private static final String c = l.a("0148fiGgWfdei%edjEejee*g5eiIh+elfk");

    public g() {
        super(l.a("002!ggej"), 0L, l.a("005%ggejfk,ek"), 30L, 0L);
    }

    private void n() {
        try {
            HashMap map = (HashMap) ae.b().c(c, null);
            if (map == null || map.isEmpty()) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                long jLongValue = ((Long) entry.getKey()).longValue();
                Long l6 = (Long) entry.getValue();
                long jLongValue2 = l6.longValue() - jLongValue;
                if (jLongValue2 > 0) {
                    HashMap<String, Object> map2 = new HashMap<>();
                    map2.put(l.a("005Feh_fjVejCh"), l6);
                    map2.put(l.a("008!ekeh^fj8ejeg)gEgj"), Long.valueOf(jLongValue2));
                    a("BKIOMT", map2);
                }
            }
            ae.b().b(c);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
    }

    private void o() {
        if (b == null) {
            synchronized (g.class) {
                try {
                    if (b == null) {
                        b = new cn.fly.commons.l() { // from class: cn.fly.commons.a.g.1
                            private volatile long b = 0;

                            @Override // cn.fly.commons.l
                            public void a(boolean z6, boolean z7, long j6) {
                                if (z7) {
                                    this.b = System.currentTimeMillis();
                                    g.this.a(new Long[]{0L, Long.valueOf(this.b), Long.valueOf(this.b)});
                                    d.a().b(g.this, 0L, 1);
                                }
                                if (!z6) {
                                    if (j6 > 0) {
                                        g.this.a(new Long[]{2L, Long.valueOf(this.b), Long.valueOf(System.currentTimeMillis())});
                                        d.a().b(g.this, 0L, 1);
                                        return;
                                    }
                                    return;
                                }
                                if (z7) {
                                    return;
                                }
                                this.b = System.currentTimeMillis();
                                g.this.a(new Long[]{1L, Long.valueOf(this.b), Long.valueOf(this.b)});
                                d.a().b(g.this, 0L, 0);
                            }
                        };
                        cn.fly.commons.m.a().a(b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        if (i()) {
            return;
        }
        Long[] lArr = (Long[]) this.f1211a;
        long jLongValue = lArr[0].longValue();
        long jLongValue2 = lArr[1].longValue();
        long jLongValue3 = (jLongValue != 3 || lArr.length >= 3) ? lArr[2].longValue() : System.currentTimeMillis();
        if (jLongValue == 0) {
            n();
            a(jLongValue2, jLongValue3);
            a(jLongValue2);
        } else if (jLongValue != 1 && jLongValue != 3) {
            if (jLongValue == 2) {
                a(jLongValue2, jLongValue3);
            }
        } else {
            if (jLongValue == 1) {
                n();
            }
            a(jLongValue2, jLongValue3);
            a(jLongValue2);
        }
    }

    @Override // cn.fly.commons.a.c
    public void d() {
        o();
    }

    private void a(long j6) {
        if (cn.fly.commons.m.a().b()) {
            return;
        }
        a(new Long[]{3L, Long.valueOf(j6)});
        d.a().b(this, b(), 0);
    }

    private void a(long j6, long j7) {
        try {
            ae aeVarB = ae.b();
            String str = c;
            HashMap map = (HashMap) aeVarB.c(str, null);
            if (map == null) {
                map = new HashMap();
            }
            map.put(Long.valueOf(j6), Long.valueOf(j7));
            ae.b().b(str, map);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
    }
}
