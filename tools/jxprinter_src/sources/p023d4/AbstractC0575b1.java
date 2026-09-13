package p023d4;

import O3.l;
import O3.p;
import O3.q;
import O3.r;
import O3.s;
import O3.t;
import com.google.android.gms.auth.api.accounttransfer.a;

/* JADX INFO: renamed from: d4.b1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0575b1 {
    public static final <T> InterfaceC0612o cache(InterfaceC0612o interfaceC0612o) {
        throw a.l();
    }

    public static final <T1, T2, R> InterfaceC0612o combineLatest(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, q qVar) {
        return AbstractC0618q.combine(interfaceC0612o, interfaceC0612o2, qVar);
    }

    public static final <T, R> InterfaceC0612o compose(InterfaceC0612o interfaceC0612o, l lVar) {
        throw a.l();
    }

    public static final <T, R> InterfaceC0612o concatMap(InterfaceC0612o interfaceC0612o, l lVar) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o concatWith(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o delayEach(InterfaceC0612o interfaceC0612o, long j6) {
        return AbstractC0618q.onEach(interfaceC0612o, new Z0(j6, null, 0));
    }

    public static final <T> InterfaceC0612o delayFlow(InterfaceC0612o interfaceC0612o, long j6) {
        return AbstractC0618q.onStart(interfaceC0612o, new Z0(j6, null, 1));
    }

    public static final <T, R> InterfaceC0612o flatMap(InterfaceC0612o interfaceC0612o, p pVar) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o flatten(InterfaceC0612o interfaceC0612o) {
        throw a.l();
    }

    public static final <T> void forEach(InterfaceC0612o interfaceC0612o, p pVar) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o merge(InterfaceC0612o interfaceC0612o) {
        throw a.l();
    }

    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    public static final <T> InterfaceC0612o observeOn(InterfaceC0612o interfaceC0612o, E3.q qVar) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o onErrorResume(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o onErrorResumeNext(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o onErrorReturn(InterfaceC0612o interfaceC0612o, T t6) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o publish(InterfaceC0612o interfaceC0612o) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o publishOn(InterfaceC0612o interfaceC0612o, E3.q qVar) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o replay(InterfaceC0612o interfaceC0612o) {
        throw a.l();
    }

    public static final <T, R> InterfaceC0612o scanFold(InterfaceC0612o interfaceC0612o, R r6, q qVar) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o scanReduce(InterfaceC0612o interfaceC0612o, q qVar) {
        return AbstractC0618q.runningReduce(interfaceC0612o, qVar);
    }

    public static final <T> InterfaceC0612o skip(InterfaceC0612o interfaceC0612o, int i5) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o startWith(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2) {
        throw a.l();
    }

    public static final <T> void subscribe(InterfaceC0612o interfaceC0612o) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o subscribeOn(InterfaceC0612o interfaceC0612o, E3.q qVar) {
        throw a.l();
    }

    public static final <T, R> InterfaceC0612o switchMap(InterfaceC0612o interfaceC0612o, p pVar) {
        return AbstractC0618q.transformLatest(interfaceC0612o, new U0(pVar, null, 2));
    }

    public static final <T1, T2, T3, R> InterfaceC0612o combineLatest(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, r rVar) {
        return AbstractC0618q.combine(interfaceC0612o, interfaceC0612o2, interfaceC0612o3, rVar);
    }

    public static final <T1, T2, T3, T4, R> InterfaceC0612o combineLatest(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, InterfaceC0612o interfaceC0612o4, s sVar) {
        return AbstractC0618q.combine(interfaceC0612o, interfaceC0612o2, interfaceC0612o3, interfaceC0612o4, sVar);
    }

    public static final <T1, T2, T3, T4, T5, R> InterfaceC0612o combineLatest(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, InterfaceC0612o interfaceC0612o4, InterfaceC0612o interfaceC0612o5, t tVar) {
        return AbstractC0618q.combine(interfaceC0612o, interfaceC0612o2, interfaceC0612o3, interfaceC0612o4, interfaceC0612o5, tVar);
    }

    public static final <T> InterfaceC0612o concatWith(InterfaceC0612o interfaceC0612o, T t6) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o onErrorReturn(InterfaceC0612o interfaceC0612o, T t6, l lVar) {
        return AbstractC0618q.m1026catch(interfaceC0612o, new C0572a1(lVar, t6, null));
    }

    public static final <T> InterfaceC0612o publish(InterfaceC0612o interfaceC0612o, int i5) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o replay(InterfaceC0612o interfaceC0612o, int i5) {
        throw a.l();
    }

    public static final <T> InterfaceC0612o startWith(InterfaceC0612o interfaceC0612o, T t6) {
        throw a.l();
    }

    public static final <T> void subscribe(InterfaceC0612o interfaceC0612o, p pVar) {
        throw a.l();
    }

    public static final <T> void subscribe(InterfaceC0612o interfaceC0612o, p pVar, p pVar2) {
        throw a.l();
    }
}
