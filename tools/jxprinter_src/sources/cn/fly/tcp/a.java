package cn.fly.tcp;

import cn.fly.FlySDK;
import cn.fly.commons.ae;
import cn.fly.commons.q;
import cn.fly.mcl.TcpStatus;
import cn.fly.tcp.impl.h;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.i;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f1524a = Executors.newSingleThreadScheduledExecutor();
    private static AtomicBoolean b = new AtomicBoolean(false);
    private AtomicBoolean c = new AtomicBoolean(false);

    public void a() {
        if (this.c.compareAndSet(false, true)) {
            h.b().a(FlySDK.getContext(), q.a(), b.a().f());
            ae.b().a("use_config", false);
            a(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i5, int i6) {
        cn.fly.tcp.a.c.a().b(androidx.collection.a.m("sched: count: ", i5, i6, ", delay: ", "s"));
        if (h.b().c()) {
            return;
        }
        f1524a.schedule(new i() { // from class: cn.fly.tcp.a.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                a.this.a(5000, new cn.fly.tools.utils.d<Boolean>() { // from class: cn.fly.tcp.a.1.1
                    @Override // cn.fly.tools.utils.d
                    public void a(Boolean bool) {
                        if (bool.booleanValue()) {
                            h.b().f();
                            h.b().b(TcpStatus.obtain(10));
                        } else if (h.b().a()) {
                            h.b().b(TcpStatus.obtain(22));
                        } else {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a.this.a(i5 + 1, 30);
                        }
                    }
                });
            }
        }, i6, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i5, final cn.fly.tools.utils.d<Boolean> dVar) {
        if (b.getAndSet(true)) {
            return;
        }
        try {
            boolean zIsInMainProcess = DH.SyncMtd.isInMainProcess();
            cn.fly.tcp.a.c.a().b("init tp, main p: " + zIsInMainProcess);
            if (zIsInMainProcess) {
                h.b().e();
                if (!h.b().f1558g) {
                    b.set(false);
                    h.b().a(TcpStatus.obtain(21).setDetailedMsg("global: " + h.b().f1558g));
                    if (dVar != null) {
                        dVar.a(Boolean.FALSE);
                    }
                } else if (h.b().d()) {
                    h.b().a(i5, new cn.fly.tools.utils.d<Boolean>() { // from class: cn.fly.tcp.a.2
                        @Override // cn.fly.tools.utils.d
                        public void a(Boolean bool) {
                            if (bool.booleanValue()) {
                                cn.fly.tcp.impl.b.a();
                                a.b.set(false);
                                cn.fly.tools.utils.d dVar2 = dVar;
                                if (dVar2 != null) {
                                    dVar2.a(Boolean.TRUE);
                                    return;
                                }
                                return;
                            }
                            cn.fly.tcp.a.c.a().a("tp reg failed");
                            a.b.set(false);
                            cn.fly.tools.utils.d dVar3 = dVar;
                            if (dVar3 != null) {
                                dVar3.a(Boolean.FALSE);
                            }
                        }
                    });
                } else {
                    h.b().a(TcpStatus.obtain(21).setDetailedMsg("unavailable(global: " + h.b().f1558g + ", connect: " + h.b().f1559h + ")"));
                    cn.fly.tcp.a.c.a().a("tp reg avail false");
                }
                b.set(false);
                return;
            }
            h.b().a(TcpStatus.obtain(21).setDetailedMsg("sub process"));
            cn.fly.tcp.a.c.a().a("tp reg failed: sub process");
        } catch (Throwable th) {
            try {
                h.b().a(TcpStatus.obtain(23).setDetailedMsg("Exception: " + th.getMessage()));
                cn.fly.tcp.a.c.a().a(th);
            } catch (Throwable th2) {
                b.set(false);
                throw th2;
            }
        }
        b.set(false);
        if (dVar != null) {
            dVar.a(Boolean.FALSE);
        }
    }
}
