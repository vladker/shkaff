package androidx.lifecycle;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import androidx.annotation.MainThread;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.InterfaceC0280h0;
import p007a4.M;
import p007a4.N;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class EmittedSource implements InterfaceC0280h0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        int label;

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return EmittedSource.this.new AnonymousClass1(gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((AnonymousClass1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            EmittedSource.this.removeSource();
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$disposeNow$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        int label;

        public AnonymousClass2(g<? super AnonymousClass2> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return EmittedSource.this.new AnonymousClass2(gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((AnonymousClass2) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            EmittedSource.this.removeSource();
            return Q.INSTANCE;
        }
    }

    public EmittedSource(LiveData<?> source, MediatorLiveData<?> mediator) {
        E.f(source, "source");
        E.f(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // p007a4.InterfaceC0280h0
    public void dispose() {
        AbstractC0272e.b(N.CoroutineScope(C0276f0.getMain().getImmediate()), null, 3, new AnonymousClass1(null));
    }

    public final Object disposeNow(g<? super Q> gVar) {
        Object objWithContext = AbstractC0272e.withContext(C0276f0.getMain().getImmediate(), new AnonymousClass2(null), gVar);
        return objWithContext == i.getCOROUTINE_SUSPENDED() ? objWithContext : Q.INSTANCE;
    }
}
