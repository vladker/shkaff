package p023d4;

import E3.r;
import O3.a;
import O3.l;
import O3.p;
import U3.q;
import U3.v;
import W3.InterfaceC0233q;
import java.util.Iterator;
import p018c4.EnumC0368b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class D {
    public static final <T> InterfaceC0612o asFlow(a aVar) {
        return new C0623s(aVar, 1);
    }

    public static final <T> InterfaceC0612o callbackFlow(p pVar) {
        return new C0579d(pVar, r.INSTANCE, -2, EnumC0368b.f1135a);
    }

    public static final <T> InterfaceC0612o channelFlow(p pVar) {
        return new C0597j(pVar, r.INSTANCE, -2, EnumC0368b.f1135a);
    }

    public static final <T> InterfaceC0612o emptyFlow() {
        return C0609n.INSTANCE;
    }

    public static final <T> InterfaceC0612o flow(p pVar) {
        return new Y1(pVar);
    }

    public static final <T> InterfaceC0612o flowOf(T... tArr) {
        return new C0641y(tArr, 1);
    }

    public static final <T> InterfaceC0612o asFlow(l lVar) {
        return new C0623s(lVar, 2);
    }

    public static final <T> InterfaceC0612o flowOf(T t6) {
        return new C0623s(t6, 9);
    }

    public static final <T> InterfaceC0612o asFlow(Iterable<? extends T> iterable) {
        return new C0623s(iterable, 3);
    }

    public static final <T> InterfaceC0612o asFlow(Iterator<? extends T> it) {
        return new C0623s(it, 4);
    }

    public static final <T> InterfaceC0612o asFlow(InterfaceC0233q interfaceC0233q) {
        return new C0623s(interfaceC0233q, 5);
    }

    public static final <T> InterfaceC0612o asFlow(T[] tArr) {
        return new C0641y(tArr, 0);
    }

    public static final InterfaceC0612o asFlow(int[] iArr) {
        return new C0623s(iArr, 6);
    }

    public static final InterfaceC0612o asFlow(long[] jArr) {
        return new C0623s(jArr, 7);
    }

    public static final InterfaceC0612o asFlow(q qVar) {
        return new C0623s(qVar, 8);
    }

    public static final InterfaceC0612o asFlow(v vVar) {
        return new C0623s(vVar, 0);
    }
}
