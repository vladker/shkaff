package p006a3;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.M;
import io.reactivex.N;
import io.reactivex.plugins.a;
import java.util.concurrent.TimeUnit;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends N {
    public final Handler b;
    public final boolean c;

    public f(Handler handler, boolean z6) {
        this.b = handler;
        this.c = z6;
    }

    @Override // io.reactivex.N
    public final M createWorker() {
        return new d(this.b, this.c);
    }

    @Override // io.reactivex.N
    @SuppressLint({"NewApi"})
    public c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        Runnable runnableOnSchedule = a.onSchedule(runnable);
        Handler handler = this.b;
        e eVar = new e(handler, runnableOnSchedule);
        Message messageObtain = Message.obtain(handler, eVar);
        if (this.c) {
            messageObtain.setAsynchronous(true);
        }
        handler.sendMessageDelayed(messageObtain, timeUnit.toMillis(j6));
        return eVar;
    }
}
