package p018c4;

import E3.g;
import p044h4.h;

/* JADX INFO: renamed from: c4.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0389t {
    public static <E> h getOnReceiveOrNull(InterfaceC0391v interfaceC0391v) {
        return z0.getOnReceiveOrNull(interfaceC0391v);
    }

    public static <E> boolean offer(InterfaceC0391v interfaceC0391v, E e) {
        return C0.offer(interfaceC0391v, e);
    }

    public static <E> E poll(InterfaceC0391v interfaceC0391v) {
        return (E) z0.poll(interfaceC0391v);
    }

    public static <E> Object receiveOrNull(InterfaceC0391v interfaceC0391v, g<? super E> gVar) {
        return z0.receiveOrNull(interfaceC0391v, gVar);
    }
}
