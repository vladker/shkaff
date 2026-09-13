package androidx.lifecycle;

import E3.g;
import E3.q;
import E3.r;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.loader.app.LoaderManagerImpl;
import java.time.Duration;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p007a4.M;
import p018c4.x0;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p023d4.n2;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions {

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0}, l = {112, 116}, m = "invokeSuspend", n = {"$this$callbackFlow", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends m implements p {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00021 extends m implements p {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00021(LiveData<T> liveData, Observer<T> observer, g<? super C00021> gVar) {
                super(2, gVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // G3.a
            public final g<Q> create(Object obj, g<?> gVar) {
                return new C00021(this.$this_asFlow, this.$observer, gVar);
            }

            @Override // O3.p
            public final Object invoke(M m6, g<? super Q> gVar) {
                return ((C00021) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // G3.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                i.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return Q.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class AnonymousClass2 extends F implements O3.a {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;

            /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00031 extends m implements p {
                final /* synthetic */ Observer<T> $observer;
                final /* synthetic */ LiveData<T> $this_asFlow;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00031(LiveData<T> liveData, Observer<T> observer, g<? super C00031> gVar) {
                    super(2, gVar);
                    this.$this_asFlow = liveData;
                    this.$observer = observer;
                }

                @Override // G3.a
                public final g<Q> create(Object obj, g<?> gVar) {
                    return new C00031(this.$this_asFlow, this.$observer, gVar);
                }

                @Override // O3.p
                public final Object invoke(M m6, g<? super Q> gVar) {
                    return ((C00031) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // G3.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    i.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                    this.$this_asFlow.removeObserver(this.$observer);
                    return Q.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LiveData<T> liveData, Observer<T> observer) {
                super(0);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // O3.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m985invoke();
                return Q.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m985invoke() {
                AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain().getImmediate(), 2, new C00031(this.$this_asFlow, this.$observer, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.$this_asFlow = liveData;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, gVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // O3.p
        public final Object invoke(x0 x0Var, g<? super Q> gVar) {
            return ((AnonymousClass1) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
        
            if (p018c4.v0.awaitClose(r3, r9, r8) == r0) goto L16;
         */
        @Override // G3.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L27
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                p147z3.v.throwOnFailure(r9)
                goto L64
            L13:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1b:
                java.lang.Object r1 = r8.L$1
                androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
                java.lang.Object r3 = r8.L$0
                c4.x0 r3 = (p018c4.x0) r3
                p147z3.v.throwOnFailure(r9)
                goto L50
            L27:
                p147z3.v.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                c4.x0 r9 = (p018c4.x0) r9
                androidx.lifecycle.b r1 = new androidx.lifecycle.b
                r1.<init>()
                a4.b1 r5 = p007a4.C0276f0.getMain()
                a4.b1 r5 = r5.getImmediate()
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r6 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
                androidx.lifecycle.LiveData<T> r7 = r8.$this_asFlow
                r6.<init>(r7, r1, r4)
                r8.L$0 = r9
                r8.L$1 = r1
                r8.label = r3
                java.lang.Object r3 = p007a4.AbstractC0272e.withContext(r5, r6, r8)
                if (r3 != r0) goto L4f
                goto L63
            L4f:
                r3 = r9
            L50:
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r9 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
                androidx.lifecycle.LiveData<T> r5 = r8.$this_asFlow
                r9.<init>(r5, r1)
                r8.L$0 = r4
                r8.L$1 = r4
                r8.label = r2
                java.lang.Object r9 = p018c4.v0.awaitClose(r3, r9, r8)
                if (r9 != r0) goto L64
            L63:
                return r0
            L64:
                z3.Q r9 = p147z3.Q.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03481 extends m implements p {
        final /* synthetic */ InterfaceC0612o $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03481(InterfaceC0612o interfaceC0612o, g<? super C03481> gVar) {
            super(2, gVar);
            this.$this_asLiveData = interfaceC0612o;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            C03481 c03481 = new C03481(this.$this_asLiveData, gVar);
            c03481.L$0 = obj;
            return c03481;
        }

        @Override // O3.p
        public final Object invoke(LiveDataScope<T> liveDataScope, g<? super Q> gVar) {
            return ((C03481) create(liveDataScope, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                InterfaceC0612o interfaceC0612o = this.$this_asLiveData;
                InterfaceC0615p interfaceC0615p = new InterfaceC0615p() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // p023d4.InterfaceC0615p
                    public final Object emit(T t6, g<? super Q> gVar) {
                        Object objEmit = liveDataScope.emit(t6, gVar);
                        return objEmit == i.getCOROUTINE_SUSPENDED() ? objEmit : Q.INSTANCE;
                    }
                };
                this.label = 1;
                if (interfaceC0612o.collect(interfaceC0615p, this) == coroutine_suspended) {
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

    public static final <T> InterfaceC0612o asFlow(LiveData<T> liveData) {
        E.f(liveData, "<this>");
        return AbstractC0618q.conflate(AbstractC0618q.callbackFlow(new AnonymousClass1(liveData, null)));
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC0612o interfaceC0612o) {
        E.f(interfaceC0612o, "<this>");
        return asLiveData$default(interfaceC0612o, (q) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC0612o interfaceC0612o, q qVar, long j6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            qVar = r.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            j6 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(interfaceC0612o, qVar, j6);
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC0612o interfaceC0612o, q context) {
        E.f(interfaceC0612o, "<this>");
        E.f(context, "context");
        return asLiveData$default(interfaceC0612o, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(InterfaceC0612o interfaceC0612o, q context, long j6) {
        E.f(interfaceC0612o, "<this>");
        E.f(context, "context");
        LoaderManagerImpl.LoaderInfo loaderInfo = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j6, new C03481(interfaceC0612o, null));
        if (interfaceC0612o instanceof n2) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                loaderInfo.setValue(((n2) interfaceC0612o).getValue());
                return loaderInfo;
            }
            loaderInfo.postValue(((n2) interfaceC0612o).getValue());
        }
        return loaderInfo;
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC0612o interfaceC0612o, Duration duration, q qVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            qVar = r.INSTANCE;
        }
        return asLiveData(interfaceC0612o, duration, qVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(InterfaceC0612o interfaceC0612o, Duration timeout, q context) {
        E.f(interfaceC0612o, "<this>");
        E.f(timeout, "timeout");
        E.f(context, "context");
        return asLiveData(interfaceC0612o, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
