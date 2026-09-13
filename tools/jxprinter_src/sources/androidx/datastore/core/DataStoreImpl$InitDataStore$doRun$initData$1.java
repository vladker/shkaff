package androidx.datastore.core;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.l;
import O3.p;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.P;
import kotlin.jvm.internal.T;
import org.opencv.videoio.Videoio;
import p049i4.b;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1", f = "DataStoreImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {Videoio.CAP_PROP_XI_SENSOR_TAPS, 458, Videoio.CAP_PROP_XI_TS_RST_SOURCE, Videoio.CAP_PROP_XI_CHIP_TEMP}, m = "invokeSuspend", n = {"updateLock", "initializationComplete", "currentData", "updateLock", "initializationComplete", "currentData", "api", "initializationComplete", "currentData", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class DataStoreImpl$InitDataStore$doRun$initData$1 extends m implements l {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;
    final /* synthetic */ DataStoreImpl<T>.InitDataStore this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl<T> dataStoreImpl, DataStoreImpl<T>.InitDataStore initDataStore, g<? super DataStoreImpl$InitDataStore$doRun$initData$1> gVar) {
        super(1, gVar);
        this.this$0 = dataStoreImpl;
        this.this$1 = initDataStore;
    }

    @Override // G3.a
    public final g<Q> create(g<?> gVar) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this.this$1, gVar);
    }

    @Override // O3.l
    public final Object invoke(g<? super Data<T>> gVar) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create(gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00af  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:39:0x010f  */
    /* JADX WARN: Code duplicated, block: B:48:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[LOOP:0: B:21:0x00a9->B:50:?, LOOP_END, SYNTHETIC] */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        b bVarMutex;
        P p6;
        T t6;
        T t7;
        P p7;
        Iterator it;
        b bVar;
        P p8;
        T t8;
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
        b bVar2;
        T t9;
        p pVar;
        Object obj2;
        int iHashCode;
        int i5;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            bVarMutex = p049i4.i.Mutex(false);
            p6 = new P();
            t6 = new T();
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.L$0 = bVarMutex;
            this.L$1 = p6;
            this.L$2 = t6;
            this.L$3 = t6;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
            if (obj != coroutine_suspended) {
                t7 = t6;
            }
            return coroutine_suspended;
        }
        if (i6 == 1) {
            t6 = (T) this.L$3;
            t7 = (T) this.L$2;
            p6 = (P) this.L$1;
            bVarMutex = (b) this.L$0;
            v.throwOnFailure(obj);
        } else {
            if (i6 == 2) {
                it = (Iterator) this.L$4;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1) this.L$3;
                t8 = (T) this.L$2;
                p8 = (P) this.L$1;
                bVar = (b) this.L$0;
                v.throwOnFailure(obj);
                while (it.hasNext()) {
                    pVar = (p) it.next();
                    this.L$0 = bVar;
                    this.L$1 = p8;
                    this.L$2 = t8;
                    this.L$3 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
                    this.L$4 = it;
                    this.label = 2;
                    if (pVar.invoke(dataStoreImpl$InitDataStore$doRun$initData$1$api$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                t7 = t8;
                p7 = p8;
                bVarMutex = bVar;
                ((DataStoreImpl.InitDataStore) this.this$1).initTasks = null;
                this.L$0 = p7;
                this.L$1 = t7;
                this.L$2 = bVarMutex;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                bVar2 = (p049i4.g) bVarMutex;
                if (bVar2.lock(null, this) != coroutine_suspended) {
                    t9 = t7;
                    p7.f5686a = true;
                    ((p049i4.g) bVar2).unlock(null);
                    obj2 = t9.f5689a;
                    if (obj2 != null) {
                    }
                    InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = iHashCode;
                    this.label = 4;
                    obj = coordinator.getVersion(this);
                    if (obj != coroutine_suspended) {
                        i5 = iHashCode;
                    }
                }
                return coroutine_suspended;
            }
            if (i6 == 3) {
                bVar2 = (b) this.L$2;
                t9 = (T) this.L$1;
                p7 = (P) this.L$0;
                v.throwOnFailure(obj);
                try {
                    p7.f5686a = true;
                    ((p049i4.g) bVar2).unlock(null);
                    obj2 = t9.f5689a;
                    iHashCode = obj2 != null ? obj2.hashCode() : 0;
                    InterProcessCoordinator coordinator2 = this.this$0.getCoordinator();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = iHashCode;
                    this.label = 4;
                    obj = coordinator2.getVersion(this);
                    if (obj != coroutine_suspended) {
                        i5 = iHashCode;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    ((p049i4.g) bVar2).unlock(null);
                    throw th;
                }
            }
            if (i6 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = this.I$0;
            obj2 = this.L$0;
            v.throwOnFailure(obj);
        }
        return new Data(obj2, i5, ((Number) obj).intValue());
        t6.f5689a = ((Data) obj).getValue();
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$2 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1(bVarMutex, p6, t7, this.this$0);
        List list = ((DataStoreImpl.InitDataStore) this.this$1).initTasks;
        if (list != null) {
            it = list.iterator();
            bVar = bVarMutex;
            p8 = p6;
            t8 = t7;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = dataStoreImpl$InitDataStore$doRun$initData$1$api$2;
            while (it.hasNext()) {
                pVar = (p) it.next();
                this.L$0 = bVar;
                this.L$1 = p8;
                this.L$2 = t8;
                this.L$3 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
                this.L$4 = it;
                this.label = 2;
                if (pVar.invoke(dataStoreImpl$InitDataStore$doRun$initData$1$api$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            t7 = t8;
            p7 = p8;
            bVarMutex = bVar;
        } else {
            p7 = p6;
        }
        ((DataStoreImpl.InitDataStore) this.this$1).initTasks = null;
        this.L$0 = p7;
        this.L$1 = t7;
        this.L$2 = bVarMutex;
        this.L$3 = null;
        this.L$4 = null;
        this.label = 3;
        bVar2 = (p049i4.g) bVarMutex;
        if (bVar2.lock(null, this) != coroutine_suspended) {
            t9 = t7;
            p7.f5686a = true;
            ((p049i4.g) bVar2).unlock(null);
            obj2 = t9.f5689a;
            if (obj2 != null) {
            }
            InterProcessCoordinator coordinator3 = this.this$0.getCoordinator();
            this.L$0 = obj2;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = iHashCode;
            this.label = 4;
            obj = coordinator3.getVersion(this);
            if (obj != coroutine_suspended) {
                i5 = iHashCode;
                return new Data(obj2, i5, ((Number) obj).intValue());
            }
        }
        return coroutine_suspended;
    }
}
