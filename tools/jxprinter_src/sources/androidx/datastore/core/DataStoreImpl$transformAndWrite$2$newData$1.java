package androidx.datastore.core;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1", f = "DataStoreImpl.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
public final class DataStoreImpl$transformAndWrite$2$newData$1 extends m implements p {
    final /* synthetic */ Data<T> $curData;
    final /* synthetic */ p $transform;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$transformAndWrite$2$newData$1(p pVar, Data<T> data, g<? super DataStoreImpl$transformAndWrite$2$newData$1> gVar) {
        super(2, gVar);
        this.$transform = pVar;
        this.$curData = data;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, this.$curData, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super T> gVar) {
        return ((DataStoreImpl$transformAndWrite$2$newData$1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
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
        p pVar = this.$transform;
        Object value = this.$curData.getValue();
        this.label = 1;
        Object objInvoke = pVar.invoke(value, this);
        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
    }
}
