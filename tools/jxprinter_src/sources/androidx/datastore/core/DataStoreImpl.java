package androidx.datastore.core;

import A3.I;
import A3.T;
import E3.g;
import E3.q;
import F3.i;
import G3.d;
import G3.f;
import G3.m;
import O3.l;
import O3.p;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import org.apache.poi.ss.util.CellUtil;
import org.opencv.videoio.Videoio;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0308w;
import p007a4.H0;
import p007a4.InterfaceC0304u;
import p007a4.M;
import p007a4.N;
import p007a4.n1;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p049i4.b;
import p147z3.A;
import p147z3.AbstractC1926f;
import p147z3.AbstractC1935o;
import p147z3.C1938s;
import p147z3.InterfaceC1934n;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    public static final Companion Companion = new Companion(null);
    private int collectorCounter;
    private H0 collectorJob;
    private final b collectorMutex;
    private final InterfaceC1934n coordinator$delegate;
    private final CorruptionHandler<T> corruptionHandler;
    private final InterfaceC0612o data;
    private final DataStoreInMemoryCache<T> inMemoryCache;
    private final DataStoreImpl<T>.InitDataStore readAndInit;
    private final M scope;
    private final Storage<T> storage;
    private final InterfaceC1934n storageConnectionDelegate;
    private final SimpleActor<Message.Update<T>> writeActor;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class InitDataStore extends RunOnce {
        private List<? extends p> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends p> initTasksList) {
            E.f(initTasksList, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = T.toList(initTasksList);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006e  */
        /* JADX WARN: Code duplicated, block: B:29:0x007c  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.datastore.core.RunOnce
        public Object doRun(g<? super Q> gVar) throws Throwable {
            DataStoreImpl$InitDataStore$doRun$1 dataStoreImpl$InitDataStore$doRun$1;
            InitDataStore initDataStore;
            Data data;
            if (gVar instanceof DataStoreImpl$InitDataStore$doRun$1) {
                dataStoreImpl$InitDataStore$doRun$1 = (DataStoreImpl$InitDataStore$doRun$1) gVar;
                int i5 = dataStoreImpl$InitDataStore$doRun$1.label;
                if ((i5 & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$InitDataStore$doRun$1.label = i5 - Integer.MIN_VALUE;
                } else {
                    dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, gVar);
                }
            } else {
                dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, gVar);
            }
            Object dataOrHandleCorruption = dataStoreImpl$InitDataStore$doRun$1.result;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i6 = dataStoreImpl$InitDataStore$doRun$1.label;
            if (i6 == 0) {
                v.throwOnFailure(dataOrHandleCorruption);
                List<? extends p> list = this.initTasks;
                if (list != null) {
                    E.c(list);
                    if (list.isEmpty()) {
                        DataStoreImpl<T> dataStoreImpl = this.this$0;
                        dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                        dataStoreImpl$InitDataStore$doRun$1.label = 1;
                        dataOrHandleCorruption = dataStoreImpl.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
                        if (dataOrHandleCorruption != coroutine_suspended) {
                            initDataStore = this;
                            data = (Data) dataOrHandleCorruption;
                        }
                    } else {
                        InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                        DataStoreImpl$InitDataStore$doRun$initData$1 dataStoreImpl$InitDataStore$doRun$initData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this, null);
                        dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                        dataStoreImpl$InitDataStore$doRun$1.label = 2;
                        dataOrHandleCorruption = coordinator.lock(dataStoreImpl$InitDataStore$doRun$initData$1, dataStoreImpl$InitDataStore$doRun$1);
                        if (dataOrHandleCorruption != coroutine_suspended) {
                            initDataStore = this;
                            data = (Data) dataOrHandleCorruption;
                        }
                    }
                } else {
                    DataStoreImpl<T> dataStoreImpl2 = this.this$0;
                    dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                    dataStoreImpl$InitDataStore$doRun$1.label = 1;
                    dataOrHandleCorruption = dataStoreImpl2.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
                    if (dataOrHandleCorruption != coroutine_suspended) {
                        initDataStore = this;
                        data = (Data) dataOrHandleCorruption;
                    }
                }
                return coroutine_suspended;
            }
            if (i6 == 1) {
                initDataStore = (InitDataStore) dataStoreImpl$InitDataStore$doRun$1.L$0;
                v.throwOnFailure(dataOrHandleCorruption);
                data = (Data) dataOrHandleCorruption;
            } else {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                initDataStore = (InitDataStore) dataStoreImpl$InitDataStore$doRun$1.L$0;
                v.throwOnFailure(dataOrHandleCorruption);
                data = (Data) dataOrHandleCorruption;
            }
            ((DataStoreImpl) initDataStore.this$0).inMemoryCache.tryUpdate(data);
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$decrementCollector$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0, 0}, l = {Videoio.CAP_PROP_XI_TRG_DELAY}, m = "decrementCollector", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DataStoreImpl<T> dataStoreImpl, g<? super AnonymousClass1> gVar) {
            super(gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.decrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", i = {}, l = {416}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends m implements l {
        final /* synthetic */ l $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(l lVar, g<? super AnonymousClass3> gVar) {
            super(1, gVar);
            this.$block = lVar;
        }

        @Override // G3.a
        public final g<Q> create(g<?> gVar) {
            return new AnonymousClass3(this.$block, gVar);
        }

        @Override // O3.l
        public final Object invoke(g<? super R> gVar) {
            return ((AnonymousClass3) create(gVar)).invokeSuspend(Q.INSTANCE);
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
            l lVar = this.$block;
            this.label = 1;
            Object objInvoke = lVar.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$handleUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {1, 1}, l = {237, 243, 246}, m = "handleUpdate", n = {"update", "$this$handleUpdate_u24lambda_u242"}, s = {"L$0", "L$1"})
    public static final class C03301 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03301(DataStoreImpl<T> dataStoreImpl, g<? super C03301> gVar) {
            super(gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$incrementCollector$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0, 0}, l = {Videoio.CAP_PROP_XI_TRG_DELAY}, m = "incrementCollector", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class C03311 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03311(DataStoreImpl<T> dataStoreImpl, g<? super C03311> gVar) {
            super(gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.incrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0, 1, 1}, l = {264, 266}, m = "readAndInitOrPropagateAndThrowFailure", n = {"this", "this", "preReadVersion"}, s = {"L$0", "L$0", "I$0"})
    public static final class C03321 extends d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03321(DataStoreImpl<T> dataStoreImpl, g<? super C03321> gVar) {
            super(gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0, 0, 0, 1, 2}, l = {287, 296, 304}, m = "readDataAndUpdateCache", n = {"this", "currentState", "requireLock", "this", "this"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$0"})
    public static final class C03331 extends d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03331(DataStoreImpl<T> dataStoreImpl, g<? super C03331> gVar) {
            super(gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataAndUpdateCache(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", i = {}, l = {298, 300}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03343 extends m implements l {
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03343(DataStoreImpl<T> dataStoreImpl, g<? super C03343> gVar) {
            super(1, gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final g<Q> create(g<?> gVar) {
            return new C03343(this.this$0, gVar);
        }

        @Override // O3.l
        public final Object invoke(g<? super C1938s> gVar) {
            return ((C03343) create(gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            State readException;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    DataStoreImpl<T> dataStoreImpl = this.this$0;
                    this.label = 1;
                    obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) this.L$0;
                        v.throwOnFailure(obj);
                        readException = new ReadException(th, ((Number) obj).intValue());
                        return A.to(readException, G3.b.boxBoolean(true));
                    }
                    v.throwOnFailure(obj);
                }
                readException = (State) obj;
            } catch (Throwable th2) {
                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                this.L$0 = th2;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version != coroutine_suspended) {
                    th = th2;
                    obj = version;
                }
                return coroutine_suspended;
            }
            return A.to(readException, G3.b.boxBoolean(true));
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", i = {0, 1}, l = {306, 309}, m = "invokeSuspend", n = {CellUtil.LOCKED, CellUtil.LOCKED}, s = {"Z$0", "Z$0"})
    public static final class AnonymousClass4 extends m implements p {
        final /* synthetic */ int $cachedVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DataStoreImpl<T> dataStoreImpl, int i5, g<? super AnonymousClass4> gVar) {
            super(2, gVar);
            this.this$0 = dataStoreImpl;
            this.$cachedVersion = i5;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, this.$cachedVersion, gVar);
            anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass4;
        }

        @Override // O3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (g<? super C1938s>) obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r4v0 */
        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            int iIntValue;
            ?? r6;
            ?? r7;
            State state;
            ?? r8;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            ?? r9 = this.label;
            try {
                if (r9 == 0) {
                    v.throwOnFailure(obj);
                    boolean z6 = this.Z$0;
                    DataStoreImpl<T> dataStoreImpl = this.this$0;
                    this.Z$0 = z6;
                    this.label = 1;
                    obj = dataStoreImpl.readDataOrHandleCorruption(z6, this);
                    r9 = z6;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (r9 != 1) {
                        if (r9 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z7 = this.Z$0;
                        th = (Throwable) this.L$0;
                        v.throwOnFailure(obj);
                        r7 = z7;
                        iIntValue = ((Number) obj).intValue();
                        r6 = r7;
                        ReadException readException = new ReadException(th, iIntValue);
                        r8 = r6;
                        state = readException;
                        return A.to(state, G3.b.boxBoolean(r8));
                    }
                    boolean z8 = this.Z$0;
                    v.throwOnFailure(obj);
                    r9 = z8;
                }
                state = (State) obj;
                r8 = r9;
            } catch (Throwable th2) {
                if (r9 != 0) {
                    InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                    this.L$0 = th2;
                    this.Z$0 = r9;
                    this.label = 2;
                    Object version = coordinator.getVersion(this);
                    if (version != coroutine_suspended) {
                        r7 = r9;
                        th = th2;
                        obj = version;
                    }
                    return coroutine_suspended;
                }
                ?? r10 = r9;
                th = th2;
                iIntValue = this.$cachedVersion;
                r6 = r10 == true ? 1 : 0;
            }
            return A.to(state, G3.b.boxBoolean(r8));
        }

        public final Object invoke(boolean z6, g<? super C1938s> gVar) {
            return ((AnonymousClass4) create(Boolean.valueOf(z6), gVar)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5}, l = {365, 366, 368, 369, 380, 384}, m = "readDataOrHandleCorruption", n = {"this", "hasWriteFileLock", "this", "hasWriteFileLock", "this", "hasWriteFileLock", "this", "hasWriteFileLock", "this", "ex", "newData", "hasWriteFileLock", "ex", "newData", "version"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2"})
    public static final class C03351 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03351(DataStoreImpl<T> dataStoreImpl, g<? super C03351> gVar) {
            super(gVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", i = {0, 1}, l = {370, 371}, m = "invokeSuspend", n = {CellUtil.LOCKED, "data"}, s = {"Z$0", "L$0"})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ int $preLockVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DataStoreImpl<T> dataStoreImpl, int i5, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.this$0 = dataStoreImpl;
            this.$preLockVersion = i5;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$preLockVersion, gVar);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // O3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (g) obj2);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0059  */
        /* JADX WARN: Code duplicated, block: B:23:0x005e  */
        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z6;
            Object obj2;
            int iIntValue;
            int iHashCode;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                z6 = this.Z$0;
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.Z$0 = z6;
                this.label = 1;
                obj = dataStoreImpl.readDataFromFileOrDefault(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i5 == 1) {
                z6 = this.Z$0;
                v.throwOnFailure(obj);
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$0;
                v.throwOnFailure(obj);
            }
            iIntValue = ((Number) obj).intValue();
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            } else {
                iHashCode = 0;
            }
            return new Data(obj2, iHashCode, iIntValue);
            if (z6) {
                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                this.L$0 = obj;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version != coroutine_suspended) {
                    obj2 = obj;
                    obj = version;
                    iIntValue = ((Number) obj).intValue();
                }
                return coroutine_suspended;
            }
            obj2 = obj;
            iIntValue = this.$preLockVersion;
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            } else {
                iHashCode = 0;
            }
            return new Data(obj2, iHashCode, iIntValue);
        }

        public final Object invoke(boolean z6, g<? super Data<T>> gVar) {
            return ((AnonymousClass2) create(Boolean.valueOf(z6), gVar)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", i = {}, l = {387, 388, 390}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03363 extends m implements l {
        final /* synthetic */ kotlin.jvm.internal.T $newData;
        final /* synthetic */ kotlin.jvm.internal.Q $version;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03363(kotlin.jvm.internal.T t6, DataStoreImpl<T> dataStoreImpl, kotlin.jvm.internal.Q q6, g<? super C03363> gVar) {
            super(1, gVar);
            this.$newData = t6;
            this.this$0 = dataStoreImpl;
            this.$version = q6;
        }

        @Override // G3.a
        public final g<Q> create(g<?> gVar) {
            return new C03363(this.$newData, this.this$0, this.$version, gVar);
        }

        @Override // O3.l
        public final Object invoke(g<? super Q> gVar) {
            return ((C03363) create(gVar)).invokeSuspend(Q.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type E3.g to androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3 for r5v1 'this'  E3.g
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // G3.a
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L31
                if (r1 == r4) goto L29
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r0 = r5.L$0
                kotlin.jvm.internal.Q r0 = (kotlin.jvm.internal.Q) r0
                p147z3.v.throwOnFailure(r6)
                goto L76
            L19:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L21:
                java.lang.Object r1 = r5.L$0
                kotlin.jvm.internal.Q r1 = (kotlin.jvm.internal.Q) r1
                p147z3.v.throwOnFailure(r6)     // Catch: androidx.datastore.core.CorruptionException -> L61
                goto L58
            L29:
                java.lang.Object r1 = r5.L$0
                kotlin.jvm.internal.T r1 = (kotlin.jvm.internal.T) r1
                p147z3.v.throwOnFailure(r6)     // Catch: androidx.datastore.core.CorruptionException -> L61
                goto L43
            L31:
                p147z3.v.throwOnFailure(r6)
                kotlin.jvm.internal.T r1 = r5.$newData     // Catch: androidx.datastore.core.CorruptionException -> L61
                androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0     // Catch: androidx.datastore.core.CorruptionException -> L61
                r5.L$0 = r1     // Catch: androidx.datastore.core.CorruptionException -> L61
                r5.label = r4     // Catch: androidx.datastore.core.CorruptionException -> L61
                java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.access$readDataFromFileOrDefault(r6, r5)     // Catch: androidx.datastore.core.CorruptionException -> L61
                if (r6 != r0) goto L43
                goto L73
            L43:
                r1.f5689a = r6     // Catch: androidx.datastore.core.CorruptionException -> L61
                kotlin.jvm.internal.Q r1 = r5.$version     // Catch: androidx.datastore.core.CorruptionException -> L61
                androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0     // Catch: androidx.datastore.core.CorruptionException -> L61
                androidx.datastore.core.InterProcessCoordinator r6 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r6)     // Catch: androidx.datastore.core.CorruptionException -> L61
                r5.L$0 = r1     // Catch: androidx.datastore.core.CorruptionException -> L61
                r5.label = r3     // Catch: androidx.datastore.core.CorruptionException -> L61
                java.lang.Object r6 = r6.getVersion(r5)     // Catch: androidx.datastore.core.CorruptionException -> L61
                if (r6 != r0) goto L58
                goto L73
            L58:
                java.lang.Number r6 = (java.lang.Number) r6     // Catch: androidx.datastore.core.CorruptionException -> L61
                int r6 = r6.intValue()     // Catch: androidx.datastore.core.CorruptionException -> L61
                r1.f5687a = r6     // Catch: androidx.datastore.core.CorruptionException -> L61
                goto L7e
            L61:
                kotlin.jvm.internal.Q r6 = r5.$version
                androidx.datastore.core.DataStoreImpl<T> r1 = r5.this$0
                kotlin.jvm.internal.T r3 = r5.$newData
                java.lang.Object r3 = r3.f5689a
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r1 = r1.writeData$datastore_core_release(r3, r4, r5)
                if (r1 != r0) goto L74
            L73:
                return r0
            L74:
                r0 = r6
                r6 = r1
            L76:
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                r0.f5687a = r6
            L7e:
                z3.Q r6 = p147z3.Q.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C03363.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", i = {}, l = {218, 226}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03372 extends m implements p {
        final /* synthetic */ boolean $requireLock;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03372(DataStoreImpl<T> dataStoreImpl, boolean z6, g<? super C03372> gVar) {
            super(2, gVar);
            this.this$0 = dataStoreImpl;
            this.$requireLock = z6;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new C03372(this.this$0, this.$requireLock, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super State<T>> gVar) {
            return ((C03372) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        
            if (r5 == r0) goto L22;
         */
        @Override // G3.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                p147z3.v.throwOnFailure(r5)
                goto L54
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                p147z3.v.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L1e
                goto L47
            L1e:
                r5 = move-exception
                goto L57
            L20:
                p147z3.v.throwOnFailure(r5)
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
                androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
                androidx.datastore.core.State r5 = r5.getCurrentState()
                boolean r5 = r5 instanceof androidx.datastore.core.Final
                if (r5 == 0) goto L3c
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
                androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
                androidx.datastore.core.State r5 = r5.getCurrentState()
                return r5
            L3c:
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0     // Catch: java.lang.Throwable -> L1e
                r4.label = r3     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readAndInitOrPropagateAndThrowFailure(r5, r4)     // Catch: java.lang.Throwable -> L1e
                if (r5 != r0) goto L47
                goto L53
            L47:
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
                boolean r1 = r4.$requireLock
                r4.label = r2
                java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readDataAndUpdateCache(r5, r1, r4)
                if (r5 != r0) goto L54
            L53:
                return r0
            L54:
                androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                return r5
            L57:
                androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
                r1 = -1
                r0.<init>(r5, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C03372.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$transformAndWrite$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", i = {1, 2}, l = {330, 331, 337}, m = "invokeSuspend", n = {"curData", "newData"}, s = {"L$0", "L$0"})
    public static final class C03382 extends m implements l {
        final /* synthetic */ q $callerContext;
        final /* synthetic */ p $transform;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03382(DataStoreImpl<T> dataStoreImpl, q qVar, p pVar, g<? super C03382> gVar) {
            super(1, gVar);
            this.this$0 = dataStoreImpl;
            this.$callerContext = qVar;
            this.$transform = pVar;
        }

        @Override // G3.a
        public final g<Q> create(g<?> gVar) {
            return new C03382(this.this$0, this.$callerContext, this.$transform, gVar);
        }

        @Override // O3.l
        public final Object invoke(g<? super T> gVar) {
            return ((C03382) create(gVar)).invokeSuspend(Q.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type E3.g to androidx.datastore.core.DataStoreImpl$transformAndWrite$2 for r8v1 'this'  E3.g
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // G3.a
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2b
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r8.L$0
                p147z3.v.throwOnFailure(r9)
                return r0
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                java.lang.Object r1 = r8.L$0
                androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
                p147z3.v.throwOnFailure(r9)
                goto L51
            L27:
                p147z3.v.throwOnFailure(r9)
                goto L39
            L2b:
                p147z3.v.throwOnFailure(r9)
                androidx.datastore.core.DataStoreImpl<T> r9 = r8.this$0
                r8.label = r4
                java.lang.Object r9 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r9, r4, r8)
                if (r9 != r0) goto L39
                goto L6a
            L39:
                r1 = r9
                androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
                E3.q r9 = r8.$callerContext
                androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
                O3.p r6 = r8.$transform
                r7 = 0
                r5.<init>(r6, r1, r7)
                r8.L$0 = r1
                r8.label = r3
                java.lang.Object r9 = p007a4.AbstractC0272e.withContext(r9, r5, r8)
                if (r9 != r0) goto L51
                goto L6a
            L51:
                r1.checkHashCode()
                java.lang.Object r1 = r1.getValue()
                boolean r1 = kotlin.jvm.internal.E.a(r1, r9)
                if (r1 != 0) goto L6b
                androidx.datastore.core.DataStoreImpl<T> r1 = r8.this$0
                r8.L$0 = r9
                r8.label = r2
                java.lang.Object r1 = r1.writeData$datastore_core_release(r9, r4, r8)
                if (r1 != r0) goto L6b
            L6a:
                return r0
            L6b:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C03382.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$updateData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03392 extends m implements p {
        final /* synthetic */ p $transform;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03392(DataStoreImpl<T> dataStoreImpl, p pVar, g<? super C03392> gVar) {
            super(2, gVar);
            this.this$0 = dataStoreImpl;
            this.$transform = pVar;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            C03392 c03392 = new C03392(this.this$0, this.$transform, gVar);
            c03392.L$0 = obj;
            return c03392;
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super T> gVar) {
            return ((C03392) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
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
            M m6 = (M) this.L$0;
            InterfaceC0304u interfaceC0304uCompletableDeferred = AbstractC0308w.CompletableDeferred((H0) null);
            ((DataStoreImpl) this.this$0).writeActor.offer(new Message.Update(this.$transform, interfaceC0304uCompletableDeferred, ((DataStoreImpl) this.this$0).inMemoryCache.getCurrentState(), m6.getCoroutineContext()));
            this.label = 1;
            Object objAwait = interfaceC0304uCompletableDeferred.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public DataStoreImpl(Storage<T> storage, List<? extends p> initTasksList, CorruptionHandler<T> corruptionHandler, M scope) {
        E.f(storage, "storage");
        E.f(initTasksList, "initTasksList");
        E.f(corruptionHandler, "corruptionHandler");
        E.f(scope, "scope");
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = AbstractC0618q.flow(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = p049i4.i.Mutex(false);
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, initTasksList);
        this.storageConnectionDelegate = AbstractC1935o.lazy(new DataStoreImpl$storageConnectionDelegate$1(this));
        this.coordinator$delegate = AbstractC1935o.lazy(new DataStoreImpl$coordinator$2(this));
        this.writeActor = new SimpleActor<>(scope, new DataStoreImpl$writeActor$1(this), DataStoreImpl$writeActor$2.INSTANCE, new DataStoreImpl$writeActor$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object decrementCollector(g<? super Q> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        DataStoreImpl<T> dataStoreImpl;
        b bVar;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            b bVar2 = this.collectorMutex;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = bVar2;
            anonymousClass1.label = 1;
            p049i4.g gVar2 = (p049i4.g) bVar2;
            if (gVar2.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dataStoreImpl = this;
            bVar = gVar2;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (b) anonymousClass1.L$1;
            dataStoreImpl = (DataStoreImpl) anonymousClass1.L$0;
            v.throwOnFailure(obj);
        }
        try {
            int i7 = dataStoreImpl.collectorCounter - 1;
            dataStoreImpl.collectorCounter = i7;
            if (i7 == 0) {
                H0 h1 = dataStoreImpl.collectorJob;
                if (h1 != null) {
                    h1.cancel((CancellationException) null);
                }
                dataStoreImpl.collectorJob = null;
            }
            return Q.INSTANCE;
        } finally {
            ((p049i4.g) bVar).unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z6, l lVar, g<? super R> gVar) {
        return z6 ? lVar.invoke(gVar) : getCoordinator().lock(new AnonymousClass3(lVar, null), gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
    
        if (r9 == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.datastore.core.DataStoreImpl] */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.DataStoreImpl, androidx.datastore.core.DataStoreImpl<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.Message$Update, androidx.datastore.core.Message$Update<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v17, types: [androidx.datastore.core.Message$Update] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [a4.u] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, E3.g<? super p147z3.Q> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, E3.g):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object incrementCollector(g<? super Q> gVar) throws Throwable {
        C03311 c03311;
        DataStoreImpl<T> dataStoreImpl;
        b bVar;
        if (gVar instanceof C03311) {
            c03311 = (C03311) gVar;
            int i5 = c03311.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c03311.label = i5 - Integer.MIN_VALUE;
            } else {
                c03311 = new C03311(this, gVar);
            }
        } else {
            c03311 = new C03311(this, gVar);
        }
        Object obj = c03311.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c03311.label;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            b bVar2 = this.collectorMutex;
            c03311.L$0 = this;
            c03311.L$1 = bVar2;
            c03311.label = 1;
            p049i4.g gVar2 = (p049i4.g) bVar2;
            if (gVar2.lock(null, c03311) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dataStoreImpl = this;
            bVar = gVar2;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (b) c03311.L$1;
            dataStoreImpl = (DataStoreImpl) c03311.L$0;
            v.throwOnFailure(obj);
        }
        try {
            int i7 = dataStoreImpl.collectorCounter + 1;
            dataStoreImpl.collectorCounter = i7;
            if (i7 == 1) {
                dataStoreImpl.collectorJob = AbstractC0272e.b(dataStoreImpl.scope, null, 3, new DataStoreImpl$incrementCollector$2$1(dataStoreImpl, null));
            }
            return Q.INSTANCE;
        } finally {
            ((p049i4.g) bVar).unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (r4.runIfNeeded(r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(E3.g<? super p147z3.Q> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl.C03321
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl.C03321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            p147z3.v.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L32
            goto L6c
        L32:
            r6 = move-exception
            goto L73
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3c:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            p147z3.v.throwOnFailure(r6)
            goto L57
        L44:
            p147z3.v.throwOnFailure(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.getCoordinator()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getVersion(r0)
            if (r6 != r1) goto L56
            goto L6b
        L56:
            r2 = r5
        L57:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r4 = r2.readAndInit     // Catch: java.lang.Throwable -> L6f
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L6f
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L6f
            r0.label = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r6 = r4.runIfNeeded(r0)     // Catch: java.lang.Throwable -> L6f
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            z3.Q r6 = p147z3.Q.INSTANCE
            return r6
        L6f:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L73:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r6, r1)
            r0.tryUpdate(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(E3.g):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
    
        if (r11 == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, E3.g<? super androidx.datastore.core.State<T>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, E3.g):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(g<? super T> gVar) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:60:0x010d  */
    /* JADX WARN: Code duplicated, block: B:66:0x012c  */
    /* JADX WARN: Code duplicated, block: B:71:0x014d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0155  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.datastore.core.DataStoreImpl] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.datastore.core.DataStoreImpl] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.DataStoreImpl, androidx.datastore.core.DataStoreImpl<T>, java.lang.Object] */
    public final Object readDataOrHandleCorruption(boolean z6, g<? super Data<T>> gVar) throws Throwable {
        C03351 c03351;
        ?? r7;
        kotlin.jvm.internal.T t6;
        Object objHandleCorruption;
        CorruptionException corruptionException;
        kotlin.jvm.internal.T t7;
        ?? r8;
        kotlin.jvm.internal.Q q6;
        CorruptionException corruptionException2;
        C03363 c03363;
        kotlin.jvm.internal.Q q7;
        kotlin.jvm.internal.T t8;
        ?? r6;
        ?? r9;
        int iHashCode;
        Object version;
        boolean z7;
        int i5;
        Object obj;
        ?? r10;
        ?? r11;
        if (gVar instanceof C03351) {
            c03351 = (C03351) gVar;
            int i6 = c03351.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c03351.label = i6 - Integer.MIN_VALUE;
            } else {
                c03351 = new C03351(this, gVar);
            }
        } else {
            c03351 = new C03351(this, gVar);
        }
        Object version2 = c03351.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        ?? r12 = c03351.label;
        try {
            switch (r12) {
                case 0:
                    v.throwOnFailure(version2);
                    try {
                        if (z6) {
                            c03351.L$0 = this;
                            c03351.Z$0 = z6;
                            c03351.label = 1;
                            version2 = readDataFromFileOrDefault(c03351);
                            if (version2 != coroutine_suspended) {
                                r9 = this;
                                if (version2 != null) {
                                    try {
                                        iHashCode = version2.hashCode();
                                    } catch (CorruptionException e) {
                                        e = e;
                                        r10 = r9;
                                        r7 = r10;
                                        t6 = new kotlin.jvm.internal.T();
                                        CorruptionHandler<T> corruptionHandler = r7.corruptionHandler;
                                        c03351.L$0 = r7;
                                        c03351.L$1 = e;
                                        c03351.L$2 = t6;
                                        c03351.L$3 = t6;
                                        c03351.Z$0 = z6;
                                        c03351.label = 5;
                                        objHandleCorruption = corruptionHandler.handleCorruption(e, c03351);
                                        if (objHandleCorruption != coroutine_suspended) {
                                            corruptionException = e;
                                            version2 = objHandleCorruption;
                                            t7 = t6;
                                            r8 = r7;
                                            t7.f5689a = version2;
                                            q6 = new kotlin.jvm.internal.Q();
                                            try {
                                                c03363 = new C03363(t6, r8, q6, null);
                                                c03351.L$0 = corruptionException;
                                                c03351.L$1 = t6;
                                                c03351.L$2 = q6;
                                                c03351.L$3 = null;
                                                c03351.label = 6;
                                                if (r8.doWithWriteFileLock(z6, c03363, c03351) != coroutine_suspended) {
                                                    q7 = q6;
                                                    t8 = t6;
                                                    Object obj2 = t8.f5689a;
                                                    return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, q7.f5687a);
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                corruptionException2 = corruptionException;
                                                AbstractC1926f.addSuppressed(corruptionException2, th);
                                                throw corruptionException2;
                                            }
                                        }
                                    }
                                } else {
                                    iHashCode = 0;
                                }
                                InterProcessCoordinator coordinator = r9.getCoordinator();
                                c03351.L$0 = r9;
                                c03351.L$1 = version2;
                                c03351.Z$0 = z6;
                                c03351.I$0 = iHashCode;
                                c03351.label = 2;
                                version = coordinator.getVersion(c03351);
                                if (version != coroutine_suspended) {
                                    int i7 = iHashCode;
                                    z7 = z6;
                                    i5 = i7;
                                    obj = version2;
                                    version2 = version;
                                    r11 = r9;
                                    return new Data(obj, i5, ((Number) version2).intValue());
                                }
                            }
                        } else {
                            InterProcessCoordinator coordinator2 = getCoordinator();
                            c03351.L$0 = this;
                            c03351.Z$0 = z6;
                            c03351.label = 3;
                            version2 = coordinator2.getVersion(c03351);
                            if (version2 != coroutine_suspended) {
                                r6 = this;
                                int iIntValue = ((Number) version2).intValue();
                                InterProcessCoordinator coordinator3 = r6.getCoordinator();
                                AnonymousClass2 anonymousClass2 = new AnonymousClass2(r6, iIntValue, null);
                                c03351.L$0 = r6;
                                c03351.Z$0 = z6;
                                c03351.label = 4;
                                version2 = coordinator3.tryLock(anonymousClass2, c03351);
                                if (version2 == coroutine_suspended) {
                                }
                                return (Data) version2;
                            }
                        }
                    } catch (CorruptionException e6) {
                        e = e6;
                        r7 = this;
                        t6 = new kotlin.jvm.internal.T();
                        CorruptionHandler<T> corruptionHandler2 = r7.corruptionHandler;
                        c03351.L$0 = r7;
                        c03351.L$1 = e;
                        c03351.L$2 = t6;
                        c03351.L$3 = t6;
                        c03351.Z$0 = z6;
                        c03351.label = 5;
                        objHandleCorruption = corruptionHandler2.handleCorruption(e, c03351);
                        if (objHandleCorruption != coroutine_suspended) {
                            corruptionException = e;
                            version2 = objHandleCorruption;
                            t7 = t6;
                            r8 = r7;
                            t7.f5689a = version2;
                            q6 = new kotlin.jvm.internal.Q();
                            c03363 = new C03363(t6, r8, q6, null);
                            c03351.L$0 = corruptionException;
                            c03351.L$1 = t6;
                            c03351.L$2 = q6;
                            c03351.L$3 = null;
                            c03351.label = 6;
                            if (r8.doWithWriteFileLock(z6, c03363, c03351) != coroutine_suspended) {
                                q7 = q6;
                                t8 = t6;
                                Object obj3 = t8.f5689a;
                                return new Data(obj3, obj3 != null ? obj3.hashCode() : 0, q7.f5687a);
                            }
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    z6 = c03351.Z$0;
                    DataStoreImpl dataStoreImpl = (DataStoreImpl) c03351.L$0;
                    v.throwOnFailure(version2);
                    r9 = dataStoreImpl;
                    if (version2 != null) {
                        iHashCode = version2.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    InterProcessCoordinator coordinator4 = r9.getCoordinator();
                    c03351.L$0 = r9;
                    c03351.L$1 = version2;
                    c03351.Z$0 = z6;
                    c03351.I$0 = iHashCode;
                    c03351.label = 2;
                    version = coordinator4.getVersion(c03351);
                    if (version != coroutine_suspended) {
                        int i8 = iHashCode;
                        z7 = z6;
                        i5 = i8;
                        obj = version2;
                        version2 = version;
                        r11 = r9;
                        return new Data(obj, i5, ((Number) version2).intValue());
                    }
                    return coroutine_suspended;
                case 2:
                    i5 = c03351.I$0;
                    z7 = c03351.Z$0;
                    obj = c03351.L$1;
                    r11 = (DataStoreImpl) c03351.L$0;
                    try {
                        v.throwOnFailure(version2);
                        r11 = r11;
                        return new Data(obj, i5, ((Number) version2).intValue());
                    } catch (CorruptionException e7) {
                        e = e7;
                        z6 = z7;
                        r10 = r11;
                        r7 = r10;
                        t6 = new kotlin.jvm.internal.T();
                        CorruptionHandler<T> corruptionHandler3 = r7.corruptionHandler;
                        c03351.L$0 = r7;
                        c03351.L$1 = e;
                        c03351.L$2 = t6;
                        c03351.L$3 = t6;
                        c03351.Z$0 = z6;
                        c03351.label = 5;
                        objHandleCorruption = corruptionHandler3.handleCorruption(e, c03351);
                        if (objHandleCorruption != coroutine_suspended) {
                            corruptionException = e;
                            version2 = objHandleCorruption;
                            t7 = t6;
                            r8 = r7;
                            t7.f5689a = version2;
                            q6 = new kotlin.jvm.internal.Q();
                            c03363 = new C03363(t6, r8, q6, null);
                            c03351.L$0 = corruptionException;
                            c03351.L$1 = t6;
                            c03351.L$2 = q6;
                            c03351.L$3 = null;
                            c03351.label = 6;
                            if (r8.doWithWriteFileLock(z6, c03363, c03351) != coroutine_suspended) {
                                q7 = q6;
                                t8 = t6;
                                Object obj4 = t8.f5689a;
                                return new Data(obj4, obj4 != null ? obj4.hashCode() : 0, q7.f5687a);
                            }
                        }
                        return coroutine_suspended;
                    }
                case 3:
                    z6 = c03351.Z$0;
                    DataStoreImpl dataStoreImpl2 = (DataStoreImpl) c03351.L$0;
                    v.throwOnFailure(version2);
                    r6 = dataStoreImpl2;
                    int iIntValue2 = ((Number) version2).intValue();
                    InterProcessCoordinator coordinator5 = r6.getCoordinator();
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(r6, iIntValue2, null);
                    c03351.L$0 = r6;
                    c03351.Z$0 = z6;
                    c03351.label = 4;
                    version2 = coordinator5.tryLock(anonymousClass3, c03351);
                    if (version2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (Data) version2;
                case 4:
                    boolean z8 = c03351.Z$0;
                    v.throwOnFailure(version2);
                    return (Data) version2;
                case 5:
                    z6 = c03351.Z$0;
                    kotlin.jvm.internal.T t9 = (kotlin.jvm.internal.T) c03351.L$3;
                    kotlin.jvm.internal.T t10 = (kotlin.jvm.internal.T) c03351.L$2;
                    corruptionException = (CorruptionException) c03351.L$1;
                    DataStoreImpl dataStoreImpl3 = (DataStoreImpl) c03351.L$0;
                    v.throwOnFailure(version2);
                    t7 = t9;
                    t6 = t10;
                    r8 = dataStoreImpl3;
                    t7.f5689a = version2;
                    q6 = new kotlin.jvm.internal.Q();
                    c03363 = new C03363(t6, r8, q6, null);
                    c03351.L$0 = corruptionException;
                    c03351.L$1 = t6;
                    c03351.L$2 = q6;
                    c03351.L$3 = null;
                    c03351.label = 6;
                    if (r8.doWithWriteFileLock(z6, c03363, c03351) != coroutine_suspended) {
                        q7 = q6;
                        t8 = t6;
                        Object obj5 = t8.f5689a;
                        return new Data(obj5, obj5 != null ? obj5.hashCode() : 0, q7.f5687a);
                    }
                    return coroutine_suspended;
                case 6:
                    q7 = (kotlin.jvm.internal.Q) c03351.L$2;
                    t8 = (kotlin.jvm.internal.T) c03351.L$1;
                    corruptionException2 = (CorruptionException) c03351.L$0;
                    try {
                        v.throwOnFailure(version2);
                        Object obj6 = t8.f5689a;
                        return new Data(obj6, obj6 != null ? obj6.hashCode() : 0, q7.f5687a);
                    } catch (Throwable th2) {
                        th = th2;
                        AbstractC1926f.addSuppressed(corruptionException2, th);
                        throw corruptionException2;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CorruptionException e8) {
            e = e8;
            r7 = r12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z6, g<? super State<T>> gVar) {
        return AbstractC0272e.withContext(this.scope.getCoroutineContext(), new C03372(this, z6, null), gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformAndWrite(p pVar, q qVar, g<? super T> gVar) {
        return getCoordinator().lock(new C03382(this, qVar, pVar, null), gVar);
    }

    @Override // androidx.datastore.core.DataStore
    public InterfaceC0612o getData() {
        return this.data;
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return (StorageConnection) this.storageConnectionDelegate.getValue();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(p pVar, g<? super T> gVar) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) gVar.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return AbstractC0272e.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new C03392(this, pVar, null), gVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object writeData$datastore_core_release(T t6, boolean z6, g<? super Integer> gVar) throws Throwable {
        DataStoreImpl$writeData$1 dataStoreImpl$writeData$1;
        kotlin.jvm.internal.Q q6;
        if (gVar instanceof DataStoreImpl$writeData$1) {
            dataStoreImpl$writeData$1 = (DataStoreImpl$writeData$1) gVar;
            int i5 = dataStoreImpl$writeData$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$writeData$1.label = i5 - Integer.MIN_VALUE;
            } else {
                dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, gVar);
            }
        } else {
            dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, gVar);
        }
        Object obj = dataStoreImpl$writeData$1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = dataStoreImpl$writeData$1.label;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            kotlin.jvm.internal.Q q7 = new kotlin.jvm.internal.Q();
            StorageConnection<T> storageConnection$datastore_core_release = getStorageConnection$datastore_core_release();
            DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(q7, this, t6, z6, null);
            dataStoreImpl$writeData$1.L$0 = q7;
            dataStoreImpl$writeData$1.label = 1;
            if (storageConnection$datastore_core_release.writeScope(dataStoreImpl$writeData$2, dataStoreImpl$writeData$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            q6 = q7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q6 = (kotlin.jvm.internal.Q) dataStoreImpl$writeData$1.L$0;
            v.throwOnFailure(obj);
        }
        return G3.b.boxInt(q6.f5687a);
    }

    public /* synthetic */ DataStoreImpl(Storage storage, List list, CorruptionHandler corruptionHandler, M m6, int i5, AbstractC1107v abstractC1107v) {
        this(storage, (i5 & 2) != 0 ? I.emptyList() : list, (i5 & 4) != 0 ? new NoOpCorruptionHandler() : corruptionHandler, (i5 & 8) != 0 ? N.CoroutineScope(Actual_jvmKt.ioDispatcher().plus(n1.m930SupervisorJob((H0) null))) : m6);
    }
}
