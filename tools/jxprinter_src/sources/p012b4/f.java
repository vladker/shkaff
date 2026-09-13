package p012b4;

import E3.g;
import F3.h;
import F3.i;
import H2.c;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.E;
import p007a4.C0276f0;
import p007a4.C0289m;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final d Main;
    private static volatile Choreographer choreographer;

    static {
        Object objM1361constructorimpl;
        try {
            objM1361constructorimpl = u.m1361constructorimpl(new c(asHandler(Looper.getMainLooper(), true), null));
        } catch (Throwable th) {
            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
        }
        Main = (d) (objM1361constructorimpl instanceof u.a ? null : objM1361constructorimpl);
    }

    public static final void a(C0289m c0289m) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            E.c(choreographer2);
            choreographer = choreographer2;
        }
        choreographer2.postFrameCallback(new e(c0289m));
    }

    @VisibleForTesting
    public static final Handler asHandler(Looper looper, boolean z6) throws IllegalAccessException, InvocationTargetException {
        if (!z6) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            E.d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    public static final Object awaitFrame(g<? super Long> gVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
            c0289m.initCancellability();
            choreographer2.postFrameCallback(new e(c0289m));
            Object result = c0289m.getResult();
            if (result == i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(gVar);
            }
            return result;
        }
        C0289m c0289m2 = new C0289m(h.intercepted(gVar), 1);
        c0289m2.initCancellability();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(c0289m2);
        } else {
            C0276f0.getMain().mo1035dispatch(c0289m2.getContext(), new c(c0289m2, 6));
        }
        Object result2 = c0289m2.getResult();
        if (result2 == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result2;
    }

    public static final d from(Handler handler) {
        return from(handler, null);
    }

    public static final d from(Handler handler, String str) {
        return new c(handler, str);
    }

    public static /* synthetic */ void getMain$annotations() {
    }
}
