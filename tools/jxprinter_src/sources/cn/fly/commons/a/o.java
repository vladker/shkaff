package cn.fly.commons.a;

import android.text.TextUtils;
import cn.fly.commons.C0396r;
import cn.fly.commons.ae;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class o extends c {
    private volatile long b;
    private volatile AtomicInteger c;

    public o() {
        super(l.a("0022gh7h"), 0L, l.a("004IghVh>gjek"), 300L, c.a(l.a("0022gh7h"), (Long) 0L));
        this.b = 0L;
        this.c = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.b = System.currentTimeMillis();
        C0396r.a(new cn.fly.tools.utils.d<ArrayList<HashMap<String, Object>>>() { // from class: cn.fly.commons.a.o.2
            @Override // cn.fly.tools.utils.d
            public void a(ArrayList<HashMap<String, Object>> arrayList) {
                if (arrayList != null) {
                    try {
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int size = arrayList.size();
                        int i5 = 0;
                        while (i5 < size) {
                            HashMap<String, Object> map = arrayList.get(i5);
                            i5++;
                            Object obj = map.get(l.a("0055gkfmfmffgm"));
                            if (obj != null) {
                                arrayList2.add(String.valueOf(obj));
                            }
                        }
                        Collections.sort(arrayList2);
                        String strMD5 = Data.MD5(TextUtils.join("", arrayList2));
                        ae aeVarB = ae.b();
                        String str = ae.f1272j;
                        String strB = aeVarB.b(str, (String) null);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ae aeVarB2 = ae.b();
                        String str2 = ae.f1273k;
                        long jB = aeVarB2.b(str2, 0L);
                        long jIntValue = ((Integer) o.this.a(l.a("005:ghTh6fkRek"), 7200)).intValue() * 1000;
                        if (strB == null || !strB.equals(strMD5) || jCurrentTimeMillis - jIntValue >= jB) {
                            o.this.a(0L, "WLMT", (Object) arrayList, true);
                            ae.b().a(str, strMD5);
                            ae.b().a(str2, jCurrentTimeMillis);
                        }
                    } catch (Throwable th) {
                        FlyLog.getInstance().w(th);
                    }
                }
            }
        });
    }

    @Override // cn.fly.commons.a.c
    public void d() {
        cn.fly.tools.utils.k.a().a(getClass().getName(), new cn.fly.tools.utils.k.a() { // from class: cn.fly.commons.a.o.1
            @Override // cn.fly.tools.utils.k.a
            public void a() {
                if (o.this.g()) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis() - o.this.b;
                        long jIntValue = ((Integer) cn.fly.commons.c.a("wsct", 300)).intValue() * 1000;
                        if (jCurrentTimeMillis >= jIntValue) {
                            o.this.n();
                        } else if (o.this.c.get() == 0) {
                            o.this.c.getAndSet(1);
                            o.this.a(Boolean.TRUE);
                            d.a().a(o.this, (jIntValue - jCurrentTimeMillis) / 1000, 0);
                        }
                    } catch (Throwable th) {
                        FlyLog.getInstance().d(th);
                    }
                }
            }
        });
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        Object obj = this.f1211a;
        if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            this.c.set(0);
        }
        n();
    }
}
