package cn.fly.tcp;

import android.text.TextUtils;
import cn.fly.commons.f;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.utils.j;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f1531a;
    private volatile String c;
    private volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f1532f;
    private volatile boolean b = false;
    private byte[] d = new byte[0];

    private b() {
    }

    public void b() {
        if (this.b) {
            cn.fly.tcp.a.c.a().b("MclGlobal already initialized");
        } else {
            new j() { // from class: cn.fly.tcp.b.1
                @Override // cn.fly.tools.utils.j
                public void a() {
                    cn.fly.tcp.a.c.a().b("MclGlobal init: start");
                    b.this.f();
                    b.this.b = true;
                    cn.fly.tcp.a.c.a().b("MclGlobal init: done");
                }
            }.start();
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.c)) {
            cn.fly.tcp.a.c.a().b("WARNING: getDuidQuick got null!");
        }
        return this.c;
    }

    public boolean d() {
        return this.e;
    }

    public String e() {
        return this.f1532f;
    }

    public String f() {
        HashMap<String, Object> mapB;
        if (TextUtils.isEmpty(this.c)) {
            synchronized (this.d) {
                try {
                    if (TextUtils.isEmpty(this.c) && (mapB = f.b(null)) != null) {
                        this.c = (String) mapB.get(NetCommunicator.KEY_DUID);
                        this.e = ((Boolean) mapB.get("isModified")).booleanValue();
                        this.f1532f = (String) mapB.get("duidPrevious");
                        cn.fly.tcp.a.c.a().b("MC Global -> duid: " + this.c + ", duidPre: " + this.f1532f + ", isModified: " + this.e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }

    public static b a() {
        if (f1531a == null) {
            synchronized (b.class) {
                try {
                    if (f1531a == null) {
                        f1531a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1531a;
    }
}
