package p023d4;

import E3.g;
import F3.i;
import O3.p;
import O3.q;
import O3.r;
import androidx.collection.a;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.T;
import p007a4.H0;
import p147z3.AbstractC1926f;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class C0 {
    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public static final <T> InterfaceC0612o m1022catch(InterfaceC0612o interfaceC0612o, q qVar) {
        return new C0627t0(interfaceC0612o, qVar, 1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object catchImpl(InterfaceC0612o interfaceC0612o, InterfaceC0615p interfaceC0615p, g<? super Throwable> gVar) throws Throwable {
        C0639x0 c0639x0;
        T t6;
        H0 h1;
        CancellationException cancellationException;
        if (gVar instanceof C0639x0) {
            c0639x0 = (C0639x0) gVar;
            int i5 = c0639x0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0639x0.c = i5 - Integer.MIN_VALUE;
            } else {
                c0639x0 = new C0639x0(gVar);
            }
        } else {
            c0639x0 = new C0639x0(gVar);
        }
        Object obj = c0639x0.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0639x0.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            try {
                InterfaceC0615p s6 = new S(interfaceC0615p, t7, 1);
                c0639x0.f3925a = t7;
                c0639x0.c = 1;
                if (interfaceC0612o.collect(s6, c0639x0) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                t6 = t7;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = c0639x0.f3925a;
            try {
                v.throwOnFailure(obj);
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        Throwable th3 = (Throwable) t6.f5689a;
        if ((th3 != null && th3.equals(th)) || ((h1 = (H0) c0639x0.getContext().get(H0.Key)) != null && h1.b() && (cancellationException = h1.getCancellationException()) != null && cancellationException.equals(th))) {
            throw th;
        }
        if (th3 == null) {
            return th;
        }
        if (th instanceof CancellationException) {
            AbstractC1926f.addSuppressed(th3, th);
            throw th3;
        }
        AbstractC1926f.addSuppressed(th, th3);
        throw th;
    }

    public static final <T> InterfaceC0612o retry(InterfaceC0612o interfaceC0612o, long j6, p pVar) {
        if (j6 > 0) {
            return AbstractC0618q.retryWhen(interfaceC0612o, new C0645z0(j6, pVar, null));
        }
        throw new IllegalArgumentException(a.j(j6, "Expected positive amount of retries, but had ").toString());
    }

    public static final <T> InterfaceC0612o retryWhen(InterfaceC0612o interfaceC0612o, r rVar) {
        return new B0(interfaceC0612o, rVar, 0);
    }
}
