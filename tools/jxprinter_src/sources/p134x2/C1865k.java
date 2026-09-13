package p134x2;

import A3.T;
import E3.g;
import F3.i;
import G3.m;
import O3.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;
import p007a4.M;
import p049i4.b;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: x2.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1865k extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f8910a;
    public M0 b;
    public int c;
    public final /* synthetic */ M0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1865k(M0 m6, g gVar) {
        super(2, gVar);
        this.d = m6;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new C1865k(this.d, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((C1865k) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009d A[Catch: all -> 0x0018, LOOP:0: B:32:0x0097->B:34:0x009d, LOOP_END, TryCatch #1 {all -> 0x0018, blocks: (B:7:0x0013, B:27:0x0085, B:28:0x0089, B:30:0x0092, B:31:0x0093, B:32:0x0097, B:34:0x009d, B:37:0x00af, B:38:0x00b0, B:29:0x008a), top: B:47:0x0013, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        M0 m6;
        b bVar;
        b bVar2;
        Throwable th;
        M0 m7;
        Iterator it;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.c;
        try {
            if (i5 == 0) {
                v.throwOnFailure(obj);
                b bVar3 = E.lock;
                m6 = this.d;
                this.f8910a = bVar3;
                this.b = m6;
                this.c = 1;
                bVar = (p049i4.g) bVar3;
                if (bVar.lock(null, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m7 = this.b;
                bVar2 = this.f8910a;
                try {
                    v.throwOnFailure(obj);
                    synchronized (E.eventListeners) {
                        List mutableList = T.toMutableList((Collection) E.eventListeners);
                    }
                    it = mutableList.iterator();
                    while (it.hasNext()) {
                        ((O0) it.next()).onPrinterError(m7, false, N0.f8860a, "recv data is null");
                    }
                    bVar = bVar2;
                    ((p049i4.g) bVar).unlock(null);
                    return Q.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    ((p049i4.g) bVar2).unlock(null);
                    throw th;
                }
            }
            m6 = this.b;
            b bVar4 = this.f8910a;
            v.throwOnFailure(obj);
            bVar = bVar4;
            if (E._printer != null) {
                K0 k6 = E._printer;
                E.c(k6);
                if (k6.b()) {
                    K0 printer = E.getPrinter();
                    E.c(printer);
                    M0 printerDevice = printer.getPrinterDevice();
                    E.c(printerDevice);
                    if (printerDevice.isSameDevice(m6)) {
                        O.INSTANCE.i("CurrentPrinter", "recv data error close and reconnect printer");
                        E e = E.INSTANCE;
                        this.f8910a = bVar;
                        this.b = m6;
                        this.c = 2;
                        if (e.j(true, this) != coroutine_suspended) {
                            m7 = m6;
                            bVar2 = bVar;
                            synchronized (E.eventListeners) {
                                List mutableList2 = T.toMutableList((Collection) E.eventListeners);
                                it = mutableList2.iterator();
                                while (it.hasNext()) {
                                    ((O0) it.next()).onPrinterError(m7, false, N0.f8860a, "recv data is null");
                                }
                                bVar = bVar2;
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            }
            ((p049i4.g) bVar).unlock(null);
            return Q.INSTANCE;
        } catch (Throwable th3) {
            bVar2 = bVar;
            th = th3;
            ((p049i4.g) bVar2).unlock(null);
            throw th;
        }
    }
}
