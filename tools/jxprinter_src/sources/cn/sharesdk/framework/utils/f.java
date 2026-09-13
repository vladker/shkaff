package cn.sharesdk.framework.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Handler f2230a = MobHandlerThread.newHandler(this);

    public void a(Message message) {
    }

    public abstract void b(Message message);

    public void c(Message message) {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        if (i5 == -2) {
            c(message);
            return false;
        }
        if (i5 != -1) {
            b(message);
            return false;
        }
        a(message);
        return false;
    }

    public void a(int i5, int i6, Object obj) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = i5;
        message.arg2 = i6;
        message.obj = obj;
        this.f2230a.sendMessage(message);
    }

    public void c() {
        a(0, 0, null);
    }
}
