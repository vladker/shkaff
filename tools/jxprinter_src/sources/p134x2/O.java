package p134x2;

import io.reactivex.internal.operators.observable.C0953x2;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import p004a1.d;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O {
    public static final O INSTANCE = new O();
    private static N logger;

    public final void d(String str, String str2) {
        if (logger != null) {
            a.c(str, str2);
        }
    }

    public final void e(String str, String str2) {
        if (logger != null) {
            a.d(str, str2);
        }
    }

    public final void i(String str, String str2) {
        if (logger != null) {
            a.k(str, str2);
        }
    }

    public final void setLogger(N n6) {
        logger = n6;
    }

    public final void v(String str, String str2) {
        if (logger == null || a.f5394a >= 0) {
            return;
        }
        d.c(str).a().g(2, str2);
    }

    public final void w(String str, String str2) {
        if (logger != null) {
            a.o(str, str2);
        }
    }

    public final void d(String str, String str2, Object... args) {
        E.f(args, "args");
        N n6 = logger;
        if (n6 != null) {
            ((C0953x2) n6).d(str, str2, Arrays.copyOf(args, args.length));
        }
    }

    public final void e(String str, String str2, Throwable th) {
        if (logger != null) {
            a.e(str, str2, th);
        }
    }

    public final void i(String str, String str2, Object... args) {
        E.f(args, "args");
        N n6 = logger;
        if (n6 != null) {
            ((C0953x2) n6).i(str, str2, Arrays.copyOf(args, args.length));
        }
    }

    public final void w(String str, String str2, Object... args) {
        E.f(args, "args");
        N n6 = logger;
        if (n6 != null) {
            ((C0953x2) n6).w(str, str2, Arrays.copyOf(args, args.length));
        }
    }

    public final void e(String str, String str2, Object... args) {
        E.f(args, "args");
        N n6 = logger;
        if (n6 != null) {
            ((C0953x2) n6).e(str, str2, Arrays.copyOf(args, args.length));
        }
    }

    public final void v(String str, String str2, Object... args) {
        E.f(args, "args");
        N n6 = logger;
        if (n6 != null) {
            ((C0953x2) n6).v(str, str2, Arrays.copyOf(args, args.length));
        }
    }
}
