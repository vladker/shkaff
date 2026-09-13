package E3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements g, G3.e {
    private static final s Companion = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f231a = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "result");
    private final g<Object> delegate;
    private volatile Object result;

    public t(g<Object> delegate, Object obj) {
        E.f(delegate, "delegate");
        this.delegate = delegate;
        this.result = obj;
    }

    @Override // G3.e
    public G3.e getCallerFrame() {
        g<Object> gVar = this.delegate;
        if (gVar instanceof G3.e) {
            return (G3.e) gVar;
        }
        return null;
    }

    @Override // E3.g
    public q getContext() {
        return this.delegate.getContext();
    }

    public final Object getOrThrow() {
        Object obj = this.result;
        F3.a aVar = F3.a.b;
        if (obj == aVar) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f231a;
            Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, coroutine_suspended)) {
                if (atomicReferenceFieldUpdater.get(this) != aVar) {
                    obj = this.result;
                }
            }
            return F3.i.getCOROUTINE_SUSPENDED();
        }
        if (obj == F3.a.c) {
            return F3.i.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof u.a) {
            throw ((u.a) obj).exception;
        }
        return obj;
    }

    @Override // G3.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // E3.g
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            F3.a aVar = F3.a.b;
            if (obj2 == aVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f231a;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != aVar) {
                    }
                }
                return;
            } else {
                if (obj2 != F3.i.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f231a;
                Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
                F3.a aVar2 = F3.a.c;
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, coroutine_suspended, aVar2)) {
                        this.delegate.resumeWith(obj);
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == coroutine_suspended);
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(g<Object> delegate) {
        this(delegate, F3.a.b);
        E.f(delegate, "delegate");
    }
}
