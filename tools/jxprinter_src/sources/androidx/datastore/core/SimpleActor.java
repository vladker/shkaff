package androidx.datastore.core;

import E3.g;
import G3.f;
import G3.m;
import O3.l;
import O3.p;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.AbstractC0272e;
import p007a4.H0;
import p007a4.M;
import p018c4.A;
import p018c4.B;
import p018c4.D;
import p018c4.InterfaceC0391v;
import p018c4.r0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleActor<T> {
    private final p consumeMessage;
    private final InterfaceC0391v messageQueue;
    private final AtomicInt remainingMessages;
    private final M scope;

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements l {
        final /* synthetic */ l $onComplete;
        final /* synthetic */ p $onUndeliveredElement;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, SimpleActor<T> simpleActor, p pVar) {
            super(1);
            this.$onComplete = lVar;
            this.this$0 = simpleActor;
            this.$onUndeliveredElement = pVar;
        }

        @Override // O3.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Q.INSTANCE;
        }

        public final void invoke(Throwable th) {
            Q q6;
            this.$onComplete.invoke(th);
            ((SimpleActor) this.this$0).messageQueue.close(th);
            do {
                Object objM1004getOrNullimpl = B.m1004getOrNullimpl(((SimpleActor) this.this$0).messageQueue.mo1007tryReceivePtdJZtk());
                if (objM1004getOrNullimpl != null) {
                    this.$onUndeliveredElement.invoke(objM1004getOrNullimpl, th);
                    q6 = Q.INSTANCE;
                } else {
                    q6 = null;
                }
            } while (q6 != null);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$offer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", i = {}, l = {121, 121}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        Object L$0;
        int label;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SimpleActor<T> simpleActor, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.this$0 = simpleActor;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass2(this.this$0, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((AnonymousClass2) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0051 A[PHI: r1 r6
  0x0051: PHI (r1v1 O3.p) = (r1v2 O3.p), (r1v4 O3.p) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
  0x0051: PHI (r6v5 java.lang.Object) = (r6v12 java.lang.Object), (r6v0 java.lang.Object) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        
            if (r1.invoke(r6, r5) == r0) goto L17;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
        @Override // G3.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                p147z3.v.throwOnFailure(r6)
                goto L5d
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.L$0
                O3.p r1 = (O3.p) r1
                p147z3.v.throwOnFailure(r6)
                goto L51
            L22:
                p147z3.v.throwOnFailure(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.get()
                if (r6 <= 0) goto L6c
            L31:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                a4.M r6 = androidx.datastore.core.SimpleActor.access$getScope$p(r6)
                p007a4.N.ensureActive(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                O3.p r1 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                c4.v r6 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r6)
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.receive(r5)
                if (r6 != r0) goto L51
                goto L5c
            L51:
                r4 = 0
                r5.L$0 = r4
                r5.label = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L5d
            L5c:
                return r0
            L5d:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.decrementAndGet()
                if (r6 != 0) goto L31
                z3.Q r6 = p147z3.Q.INSTANCE
                return r6
            L6c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SimpleActor(M scope, l onComplete, p onUndeliveredElement, p consumeMessage) {
        E.f(scope, "scope");
        E.f(onComplete, "onComplete");
        E.f(onUndeliveredElement, "onUndeliveredElement");
        E.f(consumeMessage, "consumeMessage");
        this.scope = scope;
        this.consumeMessage = consumeMessage;
        this.messageQueue = A.a(Integer.MAX_VALUE, 6, null);
        this.remainingMessages = new AtomicInt(0);
        H0 h1 = (H0) scope.getCoroutineContext().get(H0.Key);
        if (h1 != null) {
            h1.invokeOnCompletion(new AnonymousClass1(onComplete, this, onUndeliveredElement));
        }
    }

    public final void offer(T t6) {
        Object objMo1011trySendJP2dKIU = this.messageQueue.mo1011trySendJP2dKIU(t6);
        if (objMo1011trySendJP2dKIU instanceof B.a) {
            Throwable thM1003exceptionOrNullimpl = B.m1003exceptionOrNullimpl(objMo1011trySendJP2dKIU);
            if (thM1003exceptionOrNullimpl != null) {
                throw thM1003exceptionOrNullimpl;
            }
            throw new r0("Channel was closed normally");
        }
        if (objMo1011trySendJP2dKIU instanceof D) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.remainingMessages.getAndIncrement() == 0) {
            AbstractC0272e.b(this.scope, null, 3, new AnonymousClass2(this, null));
        }
    }
}
