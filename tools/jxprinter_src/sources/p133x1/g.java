package p133x1;

import M1.a;
import W2.b;
import W2.c;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final f Companion = new f();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private MethodChannel.Result result;

    public g(MethodChannel.Result result) {
        this.result = result;
    }

    public static void a(g gVar) {
        MethodChannel.Result result = gVar.result;
        if (result != null) {
            result.notImplemented();
        }
    }

    public final void b() {
        handler.post(new c(this, 20));
    }

    public final void reply(Object obj) {
        MethodChannel.Result result = this.result;
        this.result = null;
        handler.post(new b(result, obj, 29));
    }

    public final void replyError(String code, String str, Object obj) {
        E.f(code, "code");
        MethodChannel.Result result = this.result;
        this.result = null;
        handler.post(new a(result, code, str, obj, 13));
    }
}
