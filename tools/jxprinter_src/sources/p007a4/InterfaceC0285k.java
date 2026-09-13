package p007a4;

import E3.g;
import E3.q;
import O3.l;

/* JADX INFO: renamed from: a4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0285k extends g {
    boolean cancel(Throwable th);

    void completeResume(Object obj);

    @Override // E3.g
    /* synthetic */ q getContext();

    void initCancellability();

    void invokeOnCancellation(l lVar);

    void resume(Object obj, l lVar);

    <R> void resume(R r6, O3.q qVar);

    void resumeUndispatched(F f6, Object obj);

    void resumeUndispatchedWithException(F f6, Throwable th);

    @Override // E3.g
    /* synthetic */ void resumeWith(Object obj);

    Object tryResume(Object obj, Object obj2);

    <R> Object tryResume(R r6, Object obj, O3.q qVar);

    Object tryResumeWithException(Throwable th);
}
