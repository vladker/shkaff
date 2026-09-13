package androidx.window.java.core;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import androidx.core.util.Consumer;
import p007a4.M;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.window.java.core.CallbackToFlowAdapter$connect$1$1", f = "CallbackToFlowAdapter.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class CallbackToFlowAdapter$connect$1$1 extends m implements p {
    final /* synthetic */ Consumer<T> $consumer;
    final /* synthetic */ InterfaceC0612o $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackToFlowAdapter$connect$1$1(InterfaceC0612o interfaceC0612o, Consumer<T> consumer, g<? super CallbackToFlowAdapter$connect$1$1> gVar) {
        super(2, gVar);
        this.$flow = interfaceC0612o;
        this.$consumer = consumer;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new CallbackToFlowAdapter$connect$1$1(this.$flow, this.$consumer, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((CallbackToFlowAdapter$connect$1$1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            InterfaceC0612o interfaceC0612o = this.$flow;
            final Consumer<T> consumer = this.$consumer;
            InterfaceC0615p interfaceC0615p = new InterfaceC0615p() { // from class: androidx.window.java.core.CallbackToFlowAdapter$connect$1$1.1
                @Override // p023d4.InterfaceC0615p
                public final Object emit(T t6, g<? super Q> gVar) {
                    consumer.accept(t6);
                    return Q.INSTANCE;
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
