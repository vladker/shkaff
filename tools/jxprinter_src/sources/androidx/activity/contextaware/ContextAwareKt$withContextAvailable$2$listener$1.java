package androidx.activity.contextaware;

import O3.l;
import android.content.Context;
import kotlin.jvm.internal.E;
import p007a4.InterfaceC0285k;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ InterfaceC0285k $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(InterfaceC0285k interfaceC0285k, l lVar) {
        this.$co = interfaceC0285k;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objM1361constructorimpl;
        E.f(context, "context");
        InterfaceC0285k interfaceC0285k = this.$co;
        try {
            objM1361constructorimpl = u.m1361constructorimpl(this.$onContextAvailable.invoke(context));
        } catch (Throwable th) {
            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
        }
        interfaceC0285k.resumeWith(objM1361constructorimpl);
    }
}
