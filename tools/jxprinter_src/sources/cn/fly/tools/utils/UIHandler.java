package cn.fly.tools.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.fly.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes.dex */
public class UIHandler implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f1952a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f1953a;
        public final Handler.Callback b;

        public a(Message message, Handler.Callback callback) {
            this.f1953a = message;
            this.b = callback;
        }
    }

    private static void b() {
        f1952a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: cn.fly.tools.utils.UIHandler.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                UIHandler.b(message);
                return false;
            }
        });
    }

    public static boolean sendEmptyMessage(int i5, Handler.Callback callback) {
        a();
        return f1952a.sendMessage(a(i5, callback));
    }

    public static boolean sendEmptyMessageDelayed(int i5, long j6, Handler.Callback callback) {
        a();
        return f1952a.sendMessageDelayed(a(i5, callback), j6);
    }

    public static boolean sendMessage(Message message, Handler.Callback callback) {
        a();
        return f1952a.sendMessage(a(message, callback));
    }

    public static boolean sendMessageDelayed(Message message, long j6, Handler.Callback callback) {
        a();
        return f1952a.sendMessageDelayed(a(message, callback), j6);
    }

    private static synchronized void a() {
        if (f1952a == null) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        a aVar = (a) message.obj;
        Message message2 = aVar.f1953a;
        Handler.Callback callback = aVar.b;
        if (callback != null) {
            callback.handleMessage(message2);
        }
    }

    private static Message a(Message message, Handler.Callback callback) {
        Message message2 = new Message();
        message2.obj = new a(message, callback);
        return message2;
    }

    private static Message a(int i5, Handler.Callback callback) {
        Message message = new Message();
        message.what = i5;
        return a(message, callback);
    }
}
