package androidx.datastore.core;

import E3.g;
import F3.i;
import O3.p;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.P;
import kotlin.jvm.internal.T;
import p049i4.b;
import p147z3.v;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ T $currentData;
    final /* synthetic */ P $initializationComplete;
    final /* synthetic */ b $updateLock;
    final /* synthetic */ DataStoreImpl<T> this$0;

    public DataStoreImpl$InitDataStore$doRun$initData$1$api$1(b bVar, P p6, T t6, DataStoreImpl<T> dataStoreImpl) {
        this.$updateLock = bVar;
        this.$initializationComplete = p6;
        this.$currentData = t6;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bc A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b4, B:38:0x00bc), top: B:53:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InitializerApi
    public Object updateData(p pVar, g<? super T> gVar) throws Throwable {
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1;
        DataStoreImpl dataStoreImpl;
        b bVar;
        P p6;
        T t6;
        b bVar2;
        b bVar3;
        DataStoreImpl dataStoreImpl2;
        Object obj;
        T t7;
        if (gVar instanceof DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) {
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) gVar;
            int i5 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = i5 - Integer.MIN_VALUE;
            } else {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, gVar);
            }
        } else {
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, gVar);
        }
        Object obj2 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj2);
                b bVar4 = this.$updateLock;
                P p7 = this.$initializationComplete;
                T t8 = this.$currentData;
                dataStoreImpl = this.this$0;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = pVar;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = bVar4;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = p7;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = t8;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = dataStoreImpl;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 1;
                bVar = (p049i4.g) bVar4;
                if (bVar.lock(null, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) != coroutine_suspended) {
                    p6 = p7;
                    t6 = t8;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                    t7 = (T) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                    bVar2 = (b) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                    try {
                        v.throwOnFailure(obj2);
                        t7.f5689a = obj;
                        t6 = t7;
                        Object obj3 = t6.f5689a;
                        ((p049i4.g) bVar2).unlock(null);
                        return obj3;
                    } catch (Throwable th) {
                        th = th;
                        ((p049i4.g) bVar2).unlock(null);
                        throw th;
                    }
                }
                DataStoreImpl dataStoreImpl3 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                t6 = (T) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                bVar3 = (b) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                try {
                    v.throwOnFailure(obj2);
                    dataStoreImpl2 = dataStoreImpl3;
                    if (!E.a(obj2, t6.f5689a)) {
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = bVar3;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = t6;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                        if (dataStoreImpl2.writeData$datastore_core_release(obj2, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) != coroutine_suspended) {
                            obj = obj2;
                            t7 = t6;
                            bVar2 = bVar3;
                            t7.f5689a = obj;
                            t6 = t7;
                        }
                        return coroutine_suspended;
                    }
                    bVar2 = bVar3;
                    Object obj4 = t6.f5689a;
                    ((p049i4.g) bVar2).unlock(null);
                    return obj4;
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar3;
                    ((p049i4.g) bVar2).unlock(null);
                    throw th;
                }
            }
            DataStoreImpl dataStoreImpl4 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4;
            t6 = (T) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3;
            p6 = (P) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
            b bVar5 = (b) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
            p pVar2 = (p) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
            v.throwOnFailure(obj2);
            dataStoreImpl = dataStoreImpl4;
            pVar = pVar2;
            bVar = bVar5;
            if (p6.f5686a) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            Object obj5 = t6.f5689a;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = bVar;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = t6;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = dataStoreImpl;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = null;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = null;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 2;
            Object objInvoke = pVar.invoke(obj5, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1);
            if (objInvoke != coroutine_suspended) {
                bVar3 = bVar;
                obj2 = objInvoke;
                dataStoreImpl2 = dataStoreImpl;
                if (!E.a(obj2, t6.f5689a)) {
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = bVar3;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = t6;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj2;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                    if (dataStoreImpl2.writeData$datastore_core_release(obj2, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) != coroutine_suspended) {
                        obj = obj2;
                        t7 = t6;
                        bVar2 = bVar3;
                        t7.f5689a = obj;
                        t6 = t7;
                    }
                } else {
                    bVar2 = bVar3;
                }
                Object obj6 = t6.f5689a;
                ((p049i4.g) bVar2).unlock(null);
                return obj6;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
            bVar2 = bVar;
            ((p049i4.g) bVar2).unlock(null);
            throw th;
        }
    }
}
