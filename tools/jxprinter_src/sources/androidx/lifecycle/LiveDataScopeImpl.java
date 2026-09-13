package androidx.lifecycle;

import E3.g;
import E3.q;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import android.annotation.SuppressLint;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.InterfaceC0280h0;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final q coroutineContext;
    private CoroutineLiveData<T> target;

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emit$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ T $value;
        int label;
        final /* synthetic */ LiveDataScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LiveDataScopeImpl<T> liveDataScopeImpl, T t6, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.this$0 = liveDataScopeImpl;
            this.$value = t6;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass2(this.this$0, this.$value, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((AnonymousClass2) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
                this.label = 1;
                if (target$lifecycle_livedata_release.clearSource$lifecycle_livedata_release(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            this.this$0.getTarget$lifecycle_livedata_release().setValue(this.$value);
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emitSource$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03512 extends m implements p {
        final /* synthetic */ LiveData<T> $source;
        int label;
        final /* synthetic */ LiveDataScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03512(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, g<? super C03512> gVar) {
            super(2, gVar);
            this.this$0 = liveDataScopeImpl;
            this.$source = liveData;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new C03512(this.this$0, this.$source, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super InterfaceC0280h0> gVar) {
            return ((C03512) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                return obj;
            }
            v.throwOnFailure(obj);
            CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
            LiveData<T> liveData = this.$source;
            this.label = 1;
            Object objEmitSource$lifecycle_livedata_release = target$lifecycle_livedata_release.emitSource$lifecycle_livedata_release(liveData, this);
            return objEmitSource$lifecycle_livedata_release == coroutine_suspended ? coroutine_suspended : objEmitSource$lifecycle_livedata_release;
        }
    }

    public LiveDataScopeImpl(CoroutineLiveData<T> target, q context) {
        E.f(target, "target");
        E.f(context, "context");
        this.target = target;
        this.coroutineContext = context.plus(C0276f0.getMain().getImmediate());
    }

    @Override // androidx.lifecycle.LiveDataScope
    @SuppressLint({"NullSafeMutableLiveData"})
    public Object emit(T t6, g<? super Q> gVar) {
        Object objWithContext = AbstractC0272e.withContext(this.coroutineContext, new AnonymousClass2(this, t6, null), gVar);
        return objWithContext == i.getCOROUTINE_SUSPENDED() ? objWithContext : Q.INSTANCE;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> liveData, g<? super InterfaceC0280h0> gVar) {
        return AbstractC0272e.withContext(this.coroutineContext, new C03512(this, liveData, null), gVar);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_release(CoroutineLiveData<T> coroutineLiveData) {
        E.f(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
