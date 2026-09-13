package cn.fly.tcp.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.ac;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.UIHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f1541a;
    private ScheduledExecutorService d;
    private ScheduledFuture e;
    private int c = -1;
    private Context b = FlySDK.getContext();

    /* JADX INFO: renamed from: cn.fly.tcp.impl.b$3, reason: invalid class name */
    public class AnonymousClass3 extends BroadcastReceiver {
        public AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            try {
                ac.f1261a.execute(new Runnable() { // from class: cn.fly.tcp.impl.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                                DH.requester(context).checkNetworkAvailableForce(true).request(new DH.DHResponder() { // from class: cn.fly.tcp.impl.b.3.1.1
                                    @Override // cn.fly.tools.utils.DH.DHResponder
                                    public void onResponse(DH.DHResponse dHResponse) {
                                        b.this.a(dHResponse.checkNetworkAvailableForce(new int[0]));
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            cn.fly.tcp.a.c.a().a(th);
                        }
                    }
                });
            } catch (Throwable th) {
                cn.fly.tcp.a.c.a().a(th);
            }
        }
    }

    private b() {
        C0396r.a(d(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.d = Executors.newSingleThreadScheduledExecutor();
    }

    private BroadcastReceiver d() {
        return new AnonymousClass3();
    }

    public void b() {
        try {
            c();
            this.e = this.d.scheduleWithFixedDelay(new Runnable() { // from class: cn.fly.tcp.impl.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (h.b().c() && h.b().a(2000, 0)) {
                            cn.fly.tcp.a.c.a().b("TP HB tcp send ping success");
                        } else {
                            b.this.a(new cn.fly.tools.utils.d<Void>() { // from class: cn.fly.tcp.impl.b.1.1
                                @Override // cn.fly.tools.utils.d
                                public void a(Void r6) {
                                }
                            });
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, 0L, h.b().e, TimeUnit.SECONDS);
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a("TP HB timer error", th);
        }
    }

    public boolean c() {
        boolean zCancel = false;
        try {
            ScheduledFuture scheduledFuture = this.e;
            if (scheduledFuture == null) {
                return false;
            }
            zCancel = scheduledFuture.cancel(true);
            cn.fly.tcp.a.c.a().b("TP HB cancel: " + zCancel);
            return zCancel;
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
            return zCancel;
        }
    }

    public static b a() {
        if (f1541a == null) {
            synchronized (b.class) {
                try {
                    if (f1541a == null) {
                        f1541a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1541a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z6) {
        cn.fly.tcp.a.c.a().b("TP HB onNetworkChanged. avail: " + z6 + ", last: " + this.c);
        int i5 = this.c;
        if (i5 == -1) {
            this.c = i5 + 1;
        } else if (z6) {
            if (h.b().c()) {
                cn.fly.tcp.a.c.a().b("TP HB tcp status: true");
            } else {
                UIHandler.sendEmptyMessageDelayed(0, 200L, new Handler.Callback() { // from class: cn.fly.tcp.impl.b.2
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        cn.fly.tcp.a.f1524a.execute(new Runnable() { // from class: cn.fly.tcp.impl.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (h.b().c()) {
                                        return;
                                    }
                                    if (!h.b().d()) {
                                        h.b().e();
                                    }
                                    cn.fly.tcp.a.c.a().b("TP HB reg tcp");
                                    h.b().a(new cn.fly.tools.utils.d<Boolean>() { // from class: cn.fly.tcp.impl.b.2.1.1
                                        @Override // cn.fly.tools.utils.d
                                        public void a(Boolean bool) {
                                        }
                                    });
                                } catch (Throwable unused) {
                                }
                            }
                        });
                        return false;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final cn.fly.tools.utils.d<Void> dVar) {
        if (!h.b().d()) {
            h.b().e();
        }
        h.b().a(new cn.fly.tools.utils.d<Boolean>() { // from class: cn.fly.tcp.impl.b.4
            @Override // cn.fly.tools.utils.d
            public void a(Boolean bool) {
                cn.fly.tools.utils.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a(null);
                }
            }
        });
    }
}
