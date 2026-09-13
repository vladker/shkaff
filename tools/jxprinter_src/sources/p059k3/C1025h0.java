package p059k3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p039g3.A;

/* JADX INFO: renamed from: k3.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1025h0 extends AtomicReferenceArray implements InterfaceC1027i0 {
    private static final long serialVersionUID = -7969063454040569579L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f5560a;
    public int b;

    public C1025h0(int i5) {
        super(i5);
        this.f5560a = new AtomicInteger();
    }

    @Override // p059k3.InterfaceC1027i0
    public final void b() {
        int i5 = this.b;
        lazySet(i5, null);
        this.b = i5 + 1;
    }

    @Override // p043h3.j
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // p059k3.InterfaceC1027i0
    public final int d() {
        return this.b;
    }

    @Override // p059k3.InterfaceC1027i0
    public final int g() {
        return this.f5560a.get();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.b == this.f5560a.get();
    }

    @Override // p059k3.InterfaceC1027i0, java.util.Queue, p043h3.j
    public final boolean offer(Object obj) {
        A.b(obj, "value is null");
        int andIncrement = this.f5560a.getAndIncrement();
        if (andIncrement >= length()) {
            return false;
        }
        lazySet(andIncrement, obj);
        return true;
    }

    @Override // p059k3.InterfaceC1027i0
    public final Object peek() {
        int i5 = this.b;
        if (i5 == length()) {
            return null;
        }
        return get(i5);
    }

    @Override // p059k3.InterfaceC1027i0, java.util.Queue, p043h3.j
    public Object poll() {
        int i5 = this.b;
        if (i5 == length()) {
            return null;
        }
        do {
            Object obj = get(i5);
            if (obj != null) {
                this.b = i5 + 1;
                lazySet(i5, null);
                return obj;
            }
        } while (this.f5560a.get() != i5);
        return null;
    }

    @Override // p059k3.InterfaceC1027i0, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
