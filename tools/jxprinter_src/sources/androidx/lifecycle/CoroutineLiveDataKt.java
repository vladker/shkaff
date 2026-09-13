package androidx.lifecycle;

import E3.g;
import E3.q;
import E3.r;
import F3.i;
import G3.f;
import G3.m;
import O3.l;
import O3.p;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ LiveData<T> $source;
        final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class AnonymousClass1 extends F implements l {
            final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MediatorLiveData<T> mediatorLiveData) {
                super(1);
                this.$this_addDisposableSource = mediatorLiveData;
            }

            @Override // O3.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m984invoke(obj);
                return Q.INSTANCE;
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
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m984invoke(T t6) {
                this.$this_addDisposableSource.setValue(t6);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass2(this.$this_addDisposableSource, this.$source, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super EmittedSource> gVar) {
            return ((AnonymousClass2) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
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
            MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData)));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, g<? super EmittedSource> gVar) {
        return AbstractC0272e.withContext(C0276f0.getMain().getImmediate(), new AnonymousClass2(mediatorLiveData, liveData, null), gVar);
    }

    public static final <T> LiveData<T> liveData(q context, p block) {
        E.f(context, "context");
        E.f(block, "block");
        return liveData$default(context, 0L, block, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(q qVar, long j6, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            qVar = r.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            j6 = DEFAULT_TIMEOUT;
        }
        return liveData(qVar, j6, pVar);
    }

    public static final <T> LiveData<T> liveData(p block) {
        E.f(block, "block");
        return liveData$default((q) null, 0L, block, 3, (Object) null);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration timeout, p block) {
        E.f(timeout, "timeout");
        E.f(block, "block");
        return liveData$default(timeout, (q) null, block, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, q qVar, p pVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            qVar = r.INSTANCE;
        }
        return liveData(duration, qVar, pVar);
    }

    public static final <T> LiveData<T> liveData(q context, long j6, p block) {
        E.f(context, "context");
        E.f(block, "block");
        return new CoroutineLiveData(context, j6, block);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration timeout, q context, p block) {
        E.f(timeout, "timeout");
        E.f(context, "context");
        E.f(block, "block");
        return new CoroutineLiveData(context, Api26Impl.INSTANCE.toMillis(timeout), block);
    }
}
