package p147z3;

import O3.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements InterfaceC1934n, Serializable {
    public static final w Companion = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9135a = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_value");
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private final Object f3final;
    private volatile a initializer;

    public x(a initializer) {
        E.f(initializer, "initializer");
        this.initializer = initializer;
        L l6 = L.INSTANCE;
        this._value = l6;
        this.f3final = l6;
    }

    private final Object writeReplace() {
        return new C1928h(getValue());
    }

    @Override // p147z3.InterfaceC1934n
    public final Object getValue() {
        Object obj = this._value;
        L l6 = L.INSTANCE;
        if (obj != l6) {
            return obj;
        }
        a aVar = this.initializer;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9135a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, l6, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != l6) {
                }
            }
            this.initializer = null;
            return objInvoke;
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
