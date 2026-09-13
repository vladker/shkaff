package androidx.lifecycle;

import O3.l;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.InterfaceC1110y;
import p147z3.InterfaceC1927g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, InterfaceC1110y {
    private final /* synthetic */ l function;

    public CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(l function) {
        E.f(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof InterfaceC1110y)) {
            return E.a(getFunctionDelegate(), ((InterfaceC1110y) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.InterfaceC1110y
    public final InterfaceC1927g getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
