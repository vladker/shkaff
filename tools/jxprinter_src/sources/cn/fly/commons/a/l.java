package cn.fly.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import cn.fly.commons.C0396r;
import cn.fly.commons.ac;
import cn.fly.tools.FlyHandlerThread;
import cn.fly.tools.FlyLog;
import com.google.android.gms.location.GeofenceStatusCodes;

/* JADX INFO: loaded from: classes.dex */
public class l implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l f1236a = new l();
    private Handler b;

    private l() {
        String str;
        if (TextUtils.isEmpty("M-")) {
            str = null;
        } else {
            str = "M-H-" + a("004Cgdidilig");
        }
        this.b = FlyHandlerThread.newHandler(str, this);
    }

    public static l a() {
        return f1236a;
    }

    private boolean e() {
        return this.b != null;
    }

    public Handler b() {
        return this.b;
    }

    public Looper c() {
        Handler handler = this.b;
        if (handler != null) {
            return handler.getLooper();
        }
        return null;
    }

    public void d() {
        if (e()) {
            this.b.removeMessages(1002);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c cVar;
        try {
            if (message.arg2 != -1 && !cn.fly.commons.c.e()) {
                Message messageObtain = Message.obtain();
                messageObtain.copyFrom(message);
                a(messageObtain, 60000L);
                return false;
            }
            int i5 = message.what;
            if (i5 == 1003 || i5 == 1004 || i5 == 1006) {
                Runnable runnable = (Runnable) message.obj;
                if (runnable != null) {
                    ac.b.execute(runnable);
                }
            } else if (i5 == 1002) {
                cn.fly.commons.d.b bVar = (cn.fly.commons.d.b) message.obj;
                if (bVar != null) {
                    if (!bVar.f1420a) {
                        bVar.f1420a = true;
                    }
                    ac.b.execute(bVar);
                    int i6 = message.arg1;
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 1002;
                    messageObtain2.obj = bVar;
                    messageObtain2.arg1 = i6;
                    a(messageObtain2, i6 * 1000);
                }
            } else if (i5 == 1005 || i5 == 1007) {
                Runnable runnable2 = (Runnable) message.obj;
                if (runnable2 != null) {
                    ac.f1261a.execute(runnable2);
                }
            } else if ((i5 >= 10000 || i5 < -10000) && (cVar = (c) message.obj) != null) {
                cVar.j();
            }
            return false;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public <T extends c> void a(long j6, T t6, int i5) {
        a(j6, t6, i5, true);
    }

    public boolean b(long j6, Runnable runnable) {
        return b(GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT, j6, runnable);
    }

    private boolean b(int i5, long j6, Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i5;
        messageObtain.obj = runnable;
        a(messageObtain, j6);
        return true;
    }

    public <T extends c> void a(long j6, T t6, int i5, boolean z6) {
        if (e()) {
            int iA = a(t6);
            if (i5 == 1) {
                this.b.removeMessages(iA);
            } else if (i5 == 2 && this.b.hasMessages(iA)) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = iA;
            messageObtain.obj = t6;
            if (!z6) {
                messageObtain.arg2 = -1;
            }
            a(messageObtain, j6 * 1000);
        }
    }

    public void c(long j6, Runnable runnable) {
        if (!e() || this.b.hasMessages(PointerIconCompat.TYPE_CROSSHAIR)) {
            return;
        }
        b(PointerIconCompat.TYPE_CROSSHAIR, j6, runnable);
    }

    public boolean a(long j6, Runnable runnable) {
        return a(PointerIconCompat.TYPE_HELP, j6 * 1000, runnable);
    }

    public void a(long j6, int i5, cn.fly.commons.d.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1002;
        messageObtain.arg1 = i5;
        messageObtain.obj = bVar;
        a(messageObtain, j6 * 1000);
    }

    private boolean a(int i5, long j6, Runnable runnable) {
        if (!e()) {
            return true;
        }
        if (this.b.hasMessages(i5)) {
            return false;
        }
        b(i5, j6, runnable);
        return true;
    }

    private <T extends c> int a(T t6) {
        int iL = t6.l();
        return iL > 0 ? iL + 10000 : iL - 10000;
    }

    private void a(Message message, long j6) {
        if (e()) {
            if (j6 > 0) {
                this.b.sendMessageDelayed(message, j6);
            } else {
                this.b.sendMessage(message);
            }
        }
    }

    public static String a(String str) {
        return C0396r.a(str, 100);
    }
}
