package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ReflectablePlatformActionListener implements PlatformActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2083a;
    private Handler.Callback b;
    private int c;
    private Handler.Callback d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler.Callback f2084f;

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i5) {
        if (this.f2084f != null) {
            Message message = new Message();
            message.what = this.e;
            message.obj = new Object[]{platform, Integer.valueOf(i5)};
            UIHandler.sendMessage(message, this.f2084f);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i5, HashMap<String, Object> map) {
        if (this.b != null) {
            Message message = new Message();
            message.what = this.f2083a;
            message.obj = new Object[]{platform, Integer.valueOf(i5), map};
            UIHandler.sendMessage(message, this.b);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i5, Throwable th) {
        if (this.d != null) {
            Message message = new Message();
            message.what = this.c;
            message.obj = new Object[]{platform, Integer.valueOf(i5), th};
            UIHandler.sendMessage(message, this.d);
        }
    }

    public void setOnCancelCallback(int i5, Handler.Callback callback) {
        this.e = i5;
        this.f2084f = callback;
    }

    public void setOnCompleteCallback(int i5, Handler.Callback callback) {
        this.f2083a = i5;
        this.b = callback;
    }

    public void setOnErrorCallback(int i5, Handler.Callback callback) {
        this.c = i5;
        this.d = callback;
    }
}
