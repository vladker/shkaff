package androidx.window.layout.adapter.extensions;

import O3.l;
import androidx.window.extensions.layout.WindowLayoutInfo;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1 extends B implements l {
    public ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(Object obj) {
        super(1, obj, MulticastConsumer.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
    }

    @Override // O3.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WindowLayoutInfo) obj);
        return Q.INSTANCE;
    }

    public final void invoke(WindowLayoutInfo p1) {
        E.f(p1, "p0");
        ((MulticastConsumer) this.receiver).accept(p1);
    }
}
