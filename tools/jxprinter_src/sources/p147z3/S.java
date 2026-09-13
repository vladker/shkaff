package p147z3;

import O3.a;
import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S implements InterfaceC1934n, Serializable {
    private Object _value;
    private a initializer;

    public S(a initializer) {
        E.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = L.INSTANCE;
    }

    private final Object writeReplace() {
        return new C1928h(getValue());
    }

    @Override // p147z3.InterfaceC1934n
    public final Object getValue() {
        if (this._value == L.INSTANCE) {
            a aVar = this.initializer;
            E.c(aVar);
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    @Override // p147z3.InterfaceC1934n
    public final boolean isInitialized() {
        return this._value != L.INSTANCE;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
