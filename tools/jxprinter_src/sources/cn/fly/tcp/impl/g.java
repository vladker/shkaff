package cn.fly.tcp.impl;

import cn.fly.commons.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1554a = x.b("0042gfehcj?d");
    private static g b;
    private List<Map<String, Object>> c;

    private g() {
    }

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                try {
                    if (b == null) {
                        b = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public boolean b() {
        List<Map<String, Object>> list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public List<Map<String, Object>> c() {
        return this.c;
    }

    public void b(Map<String, Object> map) {
        List<Map<String, Object>> list = this.c;
        if (list == null || !list.contains(map)) {
            return;
        }
        this.c.remove(map);
    }

    public void a(Map<String, Object> map) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(map);
    }
}
