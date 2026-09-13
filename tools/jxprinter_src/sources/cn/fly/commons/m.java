package cn.fly.commons;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyHandlerThread;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.ActivityTracker;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f1464a;
    private volatile Handler c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f1465f;
    private final HashSet<l> b = new HashSet<>();
    private String d = null;
    private volatile long e = -1;

    private m() {
        String str = null;
        this.f1465f = 0L;
        this.f1465f = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty("M-")) {
            str = "M-H-" + a("0044iehljmjh");
        }
        this.c = FlyHandlerThread.newHandler(str, new Handler.Callback() { // from class: cn.fly.commons.m.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i5 = message.what;
                if (i5 == 0) {
                    m.this.e = SystemClock.elapsedRealtime();
                    m.this.a(false);
                    m.this.d();
                } else if (i5 == 1) {
                    m.this.a(true);
                } else if (i5 == 2) {
                    m.this.a(((Long) message.obj).longValue(), true);
                } else if (i5 == 3) {
                    try {
                        l lVar = (l) message.obj;
                        if (lVar != null) {
                            m.this.b.add(lVar);
                            lVar.a(m.this.e > 0, true, 0L);
                        }
                    } catch (Throwable th) {
                        FlyLog.getInstance().d(th);
                    }
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ActivityTracker.getInstance(FlySDK.getContext()).addTracker(new ActivityTracker.Tracker() { // from class: cn.fly.commons.FBManager$2
            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onDestroyed(Activity activity) {
                if (this.f1200a.e > 0) {
                    onStopped(activity);
                }
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onResumed(Activity activity) {
                try {
                    this.f1200a.f1465f = SystemClock.elapsedRealtime();
                    if (this.f1200a.e == 0) {
                        this.f1200a.e = SystemClock.elapsedRealtime();
                        if (this.f1200a.c != null) {
                            this.f1200a.c.sendEmptyMessage(1);
                        }
                    }
                    this.f1200a.d = activity == null ? null : activity.toString();
                } catch (Throwable unused) {
                }
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onStopped(Activity activity) {
                try {
                    if (this.f1200a.d != null) {
                        if (!this.f1200a.d.equals(activity == null ? null : activity.toString())) {
                            return;
                        }
                    }
                    if (this.f1200a.c != null) {
                        long jElapsedRealtime = this.f1200a.e > 0 ? SystemClock.elapsedRealtime() - this.f1200a.e : 0L;
                        Message message = new Message();
                        message.what = 2;
                        message.obj = Long.valueOf(jElapsedRealtime);
                        this.f1200a.c.sendMessage(message);
                    }
                    this.f1200a.e = 0L;
                    this.f1200a.d = null;
                } catch (Throwable unused) {
                }
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onPaused(Activity activity) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onStarted(Activity activity) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onCreated(Activity activity, Bundle bundle) {
            }

            @Override // cn.fly.tools.utils.ActivityTracker.Tracker
            public void onSaveInstanceState(Activity activity, Bundle bundle) {
            }
        });
    }

    public long c() {
        return this.f1465f;
    }

    public boolean b() {
        return this.e == 0;
    }

    public static synchronized m a() {
        try {
            if (f1464a == null) {
                m mVar = new m();
                f1464a = mVar;
                if (mVar.c != null) {
                    f1464a.c.sendEmptyMessage(0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1464a;
    }

    public void a(l lVar) {
        if (lVar == null) {
            return;
        }
        synchronized (this.b) {
            try {
                if (this.b.contains(lVar)) {
                    return;
                }
                if (this.c != null) {
                    Message message = new Message();
                    message.what = 3;
                    message.obj = lVar;
                    this.c.sendMessage(message);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z6) {
        if (z6) {
            a(true, false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j6, boolean z6) {
        if (z6) {
            a(false, false, j6);
        }
    }

    private void a(boolean z6, boolean z7, long j6) {
        synchronized (this.b) {
            try {
                Iterator<l> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().a(z6, z7, j6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String a(String str) {
        return C0396r.a(str, 101);
    }
}
