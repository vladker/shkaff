package p006a3;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.M;
import io.reactivex.plugins.a;
import java.util.concurrent.TimeUnit;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f937a;
    public final boolean b;
    public volatile boolean c;

    public d(Handler handler, boolean z6) {
        this.f937a = handler;
        this.b = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c = true;
        this.f937a.removeCallbacksAndMessages(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c;
    }

    @Override // io.reactivex.M
    @SuppressLint({"NewApi"})
    public c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        if (this.c) {
            return p011b3.d.disposed();
        }
        Runnable runnableOnSchedule = a.onSchedule(runnable);
        Handler handler = this.f937a;
        e eVar = new e(handler, runnableOnSchedule);
        Message messageObtain = Message.obtain(handler, eVar);
        messageObtain.obj = this;
        if (this.b) {
            messageObtain.setAsynchronous(true);
        }
        this.f937a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j6));
        if (!this.c) {
            return eVar;
        }
        this.f937a.removeCallbacks(eVar);
        return p011b3.d.disposed();
    }
}
