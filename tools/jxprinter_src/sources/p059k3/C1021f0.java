package p059k3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: k3.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1021f0 extends ConcurrentLinkedQueue implements InterfaceC1027i0 {
    private static final long serialVersionUID = -4025173261791142821L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5550a;
    public final AtomicInteger b = new AtomicInteger();

    @Override // p059k3.InterfaceC1027i0
    public final void b() {
        poll();
    }

    @Override // p059k3.InterfaceC1027i0
    public final int d() {
        return this.f5550a;
    }

    @Override // p059k3.InterfaceC1027i0
    public final int g() {
        return this.b.get();
    }

    @Override // p059k3.InterfaceC1027i0, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, p059k3.InterfaceC1027i0, p043h3.j
    public Object poll() {
        Object objPoll = super.poll();
        if (objPoll != null) {
            this.f5550a++;
        }
        return objPoll;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, p059k3.InterfaceC1027i0, p043h3.j
    public final boolean offer(Object obj) {
        this.b.getAndIncrement();
        return super.offer(obj);
    }
}
