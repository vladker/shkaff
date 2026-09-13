package p006a3;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import io.reactivex.N;
import p017c3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N f936a;

    static {
        try {
            N n6 = (N) new a().call();
            if (n6 == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
            f936a = n6;
        } catch (Throwable th) {
            throw d.propagate(th);
        }
    }

    @SuppressLint({"NewApi"})
    public static N from(Looper looper, boolean z6) {
        if (looper != null) {
            return new f(new Handler(looper), z6);
        }
        throw new NullPointerException("looper == null");
    }
}
