package androidx.datastore.core;

import E3.g;
import F3.i;
import G3.b;
import G3.f;
import G3.m;
import O3.p;
import O3.q;
import p023d4.InterfaceC0615p;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.DataStoreImpl$data$1", f = "DataStoreImpl.kt", i = {0, 1, 1}, l = {72, 74, 100}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "startState"}, s = {"L$0", "L$0", "L$1"})
public final class DataStoreImpl$data$1 extends m implements p {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$data$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$data$1$1", f = "DataStoreImpl.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DataStoreImpl<T> dataStoreImpl, g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass1(this.this$0, gVar);
        }

        @Override // O3.p
        public final Object invoke(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
            return ((AnonymousClass1) create(interfaceC0615p, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                if (dataStoreImpl.incrementCollector(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$data$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$data$1$2", f = "DataStoreImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(g<? super AnonymousClass2> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(gVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // O3.p
        public final Object invoke(State<T> state, g<? super Boolean> gVar) {
            return ((AnonymousClass2) create(state, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return b.boxBoolean(!(((State) this.L$0) instanceof Final));
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$data$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$data$1$3", f = "DataStoreImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends m implements p {
        final /* synthetic */ State<T> $startState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(State<T> state, g<? super AnonymousClass3> gVar) {
            super(2, gVar);
            this.$startState = state;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$startState, gVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // O3.p
        public final Object invoke(State<T> state, g<? super Boolean> gVar) {
            return ((AnonymousClass3) create(state, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            State state = (State) this.L$0;
            return b.boxBoolean((state instanceof Data) && state.getVersion() <= this.$startState.getVersion());
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$data$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$data$1$5", f = "DataStoreImpl.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends m implements q {
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DataStoreImpl<T> dataStoreImpl, g<? super AnonymousClass5> gVar) {
            super(3, gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // O3.q
        public final Object invoke(InterfaceC0615p interfaceC0615p, Throwable th, g<? super Q> gVar) {
            return new AnonymousClass5(this.this$0, gVar).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                if (dataStoreImpl.decrementCollector(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            return Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$data$1(DataStoreImpl<T> dataStoreImpl, g<? super DataStoreImpl$data$1> gVar) {
        super(2, gVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        DataStoreImpl$data$1 dataStoreImpl$data$1 = new DataStoreImpl$data$1(this.this$0, gVar);
        dataStoreImpl$data$1.L$0 = obj;
        return dataStoreImpl$data$1;
    }

    @Override // O3.p
    public final Object invoke(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
        return ((DataStoreImpl$data$1) create(interfaceC0615p, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
    
        if (p023d4.AbstractC0618q.emitAll(r1, r9, r8) == r0) goto L33;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$data$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
