package cn.fly.commons.a;

import android.text.TextUtils;
import cn.fly.commons.ae;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.HashonHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private static volatile long b;
    private static volatile HashMap<Long, Long> c;

    public a() {
        super(cn.fly.commons.o.a("002di"), 0L, cn.fly.commons.o.a("005diZejSdj"), 900L, 0L);
        if (c == null) {
            b = System.currentTimeMillis();
            c = o();
        }
    }

    private void n() {
        try {
            HashMap<String, Object> map = new HashMap<>();
            for (Map.Entry<Long, Long> entry : c.entrySet()) {
                if (entry != null) {
                    map.put(cn.fly.commons.o.a("008gd!dg3ech!fd;i"), entry.getKey());
                    map.put(cn.fly.commons.o.a("0080dcdgdj[di*didk+e"), entry.getValue());
                }
            }
            a("ARSTAMT", map);
            ae.b().a(ae.f1268f, System.currentTimeMillis());
            if (c != null) {
                c.clear();
            }
            a((HashMap<Long, Long>) null);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<Long, Long> o() {
        HashMap mapFromJson;
        HashMap<Long, Long> map = new HashMap<>();
        try {
            String strB = ae.b().b(ae.f1276n, (String) null);
            if (!TextUtils.isEmpty(strB) && (mapFromJson = HashonHelper.fromJson(strB)) != null && !mapFromJson.isEmpty()) {
                for (Map.Entry entry : mapFromJson.entrySet()) {
                    if (entry != null) {
                        map.put(Long.valueOf(Long.parseLong((String) entry.getKey())), entry.getValue());
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        if (c == null) {
            c = new HashMap<>();
        } else {
            for (Map.Entry<Long, Long> entry : c.entrySet()) {
                if (entry != null && entry.getKey().longValue() != b) {
                    n();
                }
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - b;
        c.put(Long.valueOf(b), Long.valueOf(jCurrentTimeMillis));
        a(c);
        long jB = ae.b().b(ae.f1268f, 0L);
        long jB2 = b() * 1000;
        if (jCurrentTimeMillis < jB2 || System.currentTimeMillis() - jB <= jB2) {
            return;
        }
        n();
    }

    @Override // cn.fly.commons.a.c
    public long b() {
        long jLongValue = ((Long) a(e(), 0L)).longValue();
        if (jLongValue <= 0 || jLongValue >= 604800) {
            return 0L;
        }
        return jLongValue;
    }

    private static void a(HashMap<Long, Long> map) {
        if (map != null && !map.isEmpty()) {
            HashMap map2 = new HashMap();
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                if (entry != null) {
                    map2.put(entry.getKey() + "", entry.getValue());
                }
            }
            ae.b().a(ae.f1276n, HashonHelper.fromHashMap(map2));
            return;
        }
        ae.b().b(ae.f1276n);
    }
}
