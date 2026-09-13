package cn.fly.tcp;

import cn.fly.FlySDK;
import cn.fly.commons.ac;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.i;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1534a;

    public static void a() {
        ac.f1261a.execute(new i() { // from class: cn.fly.tcp.d.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                boolean zIsInMainProcess = DH.SyncMtd.isInMainProcess();
                cn.fly.tcp.a.c.a().b("TpEntrance init, main p: " + zIsInMainProcess);
                if (zIsInMainProcess && !FlySDK.isForb()) {
                    b.a().b();
                    if (d.f1534a == null) {
                        synchronized (d.class) {
                            try {
                                if (d.f1534a == null) {
                                    a unused = d.f1534a = new a();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    d.f1534a.a();
                }
            }
        });
    }
}
