package p102s;

import kotlin.jvm.internal.E;
import p004a1.d;
import p051j0.a;
import p108t.I;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements I {
    @Override // p108t.I
    public void d(String tag, String message) {
        E.f(tag, "tag");
        E.f(message, "message");
        a.c(tag, message);
    }

    @Override // p108t.I
    public void e(String tag, String message) {
        E.f(tag, "tag");
        E.f(message, "message");
        a.d(tag, message);
    }

    @Override // p108t.I
    public void i(String tag, String message) {
        E.f(tag, "tag");
        E.f(message, "message");
        a.k(tag, message);
    }

    @Override // p108t.I
    public void v(String tag, String message) {
        E.f(tag, "tag");
        E.f(message, "message");
        if (a.f5394a < 0) {
            d.c(tag).a().g(2, message);
        }
    }

    @Override // p108t.I
    public void w(String tag, String message) {
        E.f(tag, "tag");
        E.f(message, "message");
        a.o(tag, message);
    }
}
