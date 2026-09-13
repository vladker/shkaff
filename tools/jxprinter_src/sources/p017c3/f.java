package p017c3;

import androidx.exifinterface.media.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public f(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public f(Throwable th) {
        this(a.n("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ", th), th);
    }
}
