package p147z3;

import O3.a;
import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements InterfaceC1934n, Serializable {
    private volatile Object _value;
    private a initializer;
    private final Object lock;

    public y(a initializer, Object obj) {
        E.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = L.INSTANCE;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new C1928h(getValue());
    }

    @Override // p147z3.InterfaceC1934n
    public final Object getValue() {
        Object objInvoke;
        Object obj = this._value;
        L l6 = L.INSTANCE;
        if (obj != l6) {
            return obj;
        }
        synchronized (this.lock) {
            objInvoke = this._value;
            if (objInvoke == l6) {
                a aVar = this.initializer;
                E.c(aVar);
                objInvoke = aVar.invoke();
                this._value = objInvoke;
                this.initializer = null;
            }
        }
        return objInvoke;
    }

    @Override // p147z3.InterfaceC1934n
    public final boolean isInitialized() {
        return this._value != L.INSTANCE;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
