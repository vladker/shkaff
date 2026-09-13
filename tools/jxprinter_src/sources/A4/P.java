package A4;

import java.io.Closeable;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class P {
    public static final f0 blackhole() {
        return new C0165h();
    }

    public static final InterfaceC0171n buffer(h0 h0Var) {
        kotlin.jvm.internal.E.f(h0Var, "<this>");
        return new a0(h0Var);
    }

    public static final <T extends Closeable, R> R use(T t6, O3.l block) throws Throwable {
        R r6;
        kotlin.jvm.internal.E.f(block, "block");
        Throwable th = null;
        try {
            r6 = (R) block.invoke(t6);
            if (t6 != null) {
                try {
                    t6.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (t6 != null) {
                try {
                    t6.close();
                } catch (Throwable th4) {
                    AbstractC1926f.addSuppressed(th3, th4);
                }
            }
            th = th3;
            r6 = null;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.E.c(r6);
        return r6;
    }

    public static final InterfaceC0170m buffer(f0 f0Var) {
        kotlin.jvm.internal.E.f(f0Var, "<this>");
        return new Y(f0Var);
    }
}
