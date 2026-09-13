package androidx.datastore.core;

import E3.g;
import E3.q;
import F3.i;
import G3.d;
import G3.f;
import G3.m;
import O3.l;
import O3.p;
import X3.W;
import androidx.core.location.LocationRequestCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.M;
import p023d4.InterfaceC0612o;
import p049i4.b;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiProcessCoordinator implements InterProcessCoordinator {
    public static final Companion Companion = new Companion(null);
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = 60000;
    private final String LOCK_ERROR_MESSAGE;
    private final String LOCK_SUFFIX;
    private final String VERSION_SUFFIX;
    private final q context;
    private final File file;
    private final b inMemoryMutex;
    private final InterfaceC1934n lazySharedCounter;
    private final InterfaceC1934n lockFile$delegate;
    private final InterfaceC0612o updateNotifications;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(3:31|17|18) */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
        
            r2 = r0.getMessage();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        
            if (r2 == null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
        
            r14.L$0 = r13;
            r14.J$0 = r4;
            r14.label = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
        
            if (p007a4.AbstractC0261a0.delay(r4, r14) == r1) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007c, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
        
            throw r0;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007a -> B:27:0x007d). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream r13, E3.g<? super java.nio.channels.FileLock> r14) throws java.lang.Throwable {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L38
                if (r2 != r3) goto L30
                long r4 = r0.J$0
                java.lang.Object r13 = r0.L$0
                java.io.FileOutputStream r13 = (java.io.FileOutputStream) r13
                p147z3.v.throwOnFailure(r14)
                r14 = r0
                goto L7d
            L30:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L38:
                p147z3.v.throwOnFailure(r14)
                long r4 = androidx.datastore.core.MultiProcessCoordinator.access$getINITIAL_WAIT_MILLIS$cp()
                r14 = r0
            L40:
                long r6 = androidx.datastore.core.MultiProcessCoordinator.access$getMAX_WAIT_MILLIS$cp()
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            */
            //  java.lang.String r2 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
            /*
                if (r0 > 0) goto L82
                java.nio.channels.FileChannel r6 = r13.getChannel()     // Catch: java.io.IOException -> L5e
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = 0
                r7 = 0
                java.nio.channels.FileLock r0 = r6.lock(r7, r9, r11)     // Catch: java.io.IOException -> L5e
                kotlin.jvm.internal.E.e(r0, r2)     // Catch: java.io.IOException -> L5e
                return r0
            L5e:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L81
                java.lang.String r6 = androidx.datastore.core.MultiProcessCoordinator.access$getDEADLOCK_ERROR_MESSAGE$cp()
                r7 = 0
                boolean r2 = X3.b0.contains(r2, r6, r7)
                if (r2 != r3) goto L81
                r14.L$0 = r13
                r14.J$0 = r4
                r14.label = r3
                java.lang.Object r0 = p007a4.AbstractC0261a0.delay(r4, r14)
                if (r0 != r1) goto L7d
                return r1
            L7d:
                r0 = 2
                long r6 = (long) r0
                long r4 = r4 * r6
                goto L40
            L81:
                throw r0
            L82:
                java.nio.channels.FileChannel r6 = r13.getChannel()
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = 0
                r7 = 0
                java.nio.channels.FileLock r13 = r6.lock(r7, r9, r11)
                kotlin.jvm.internal.E.e(r13, r2)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.Companion.getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream, E3.g):java.lang.Object");
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {211, 47, 48}, m = "lock", n = {"this", "block", "$this$withLock_u24default$iv", "block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "lock"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$2"})
    public static final class AnonymousClass1<T> extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", i = {0, 0, 1, 1, 1}, l = {62, 87}, m = "tryLock", n = {"$this$withTryLock_u24default$iv", "locked$iv", "$this$withTryLock_u24default$iv", "lock", "locked$iv"}, s = {"L$0", "Z$0", "L$0", "L$2", "Z$0"})
    public static final class C03411<T> extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C03411(g<? super C03411> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.tryLock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", f = "MultiProcessCoordinator.android.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ p $block;
        int label;
        final /* synthetic */ MultiProcessCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p pVar, MultiProcessCoordinator multiProcessCoordinator, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.$block = pVar;
            this.this$0 = multiProcessCoordinator;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass2(this.$block, this.this$0, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super T> gVar) {
            return ((AnonymousClass2) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
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
            p pVar = this.$block;
            SharedCounter sharedCounter = this.this$0.getSharedCounter();
            this.label = 1;
            Object objInvoke = pVar.invoke(sharedCounter, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(this.this$0.getSharedCounter(), this);
        }
    }

    public MultiProcessCoordinator(q context, File file) {
        E.f(context, "context");
        E.f(file, "file");
        this.context = context;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = p049i4.i.Mutex(false);
        this.lockFile$delegate = AbstractC1935o.lazy(new MultiProcessCoordinator$lockFile$2(this));
        this.lazySharedCounter = AbstractC1935o.lazy(new MultiProcessCoordinator$lazySharedCounter$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createIfNotExists(File file) throws IOException {
        createParentDirectories(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException(androidx.collection.a.k(file, "Unable to create parent directories of "));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return (SharedCounter) this.lazySharedCounter.getValue();
    }

    private final <T> Object withLazyCounter(p pVar, g<? super T> gVar) {
        return this.lazySharedCounter.isInitialized() ? pVar.invoke(getSharedCounter(), gVar) : AbstractC0272e.withContext(this.context, new AnonymousClass2(pVar, this, null), gVar);
    }

    public final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public InterfaceC0612o getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(g<? super Integer> gVar) {
        return this.lazySharedCounter.isInitialized() ? G3.b.boxInt(getSharedCounter().getValue()) : AbstractC0272e.withContext(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), gVar);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(g<? super Integer> gVar) {
        return this.lazySharedCounter.isInitialized() ? G3.b.boxInt(getSharedCounter().incrementAndGetValue()) : AbstractC0272e.withContext(this.context, new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, null), gVar);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bd A[Catch: all -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c1, blocks: (B:42:0x00bd, B:56:0x00dd, B:57:0x00e0), top: B:67:0x0024, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00dd A[Catch: all -> 0x00c1, TRY_ENTER, TryCatch #1 {all -> 0x00c1, blocks: (B:42:0x00bd, B:56:0x00dd, B:57:0x00e0), top: B:67:0x0024, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.Object] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    public <T> Object lock(l lVar, g<? super T> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        MultiProcessCoordinator multiProcessCoordinator;
        FileOutputStream fileOutputStream;
        Throwable th;
        l lVar2;
        java.io.Closeable closeable;
        Object obj;
        Object obj2;
        FileLock fileLock;
        FileLock fileLock2;
        Object objInvoke;
        java.io.Closeable closeable2;
        Object obj3;
        Object obj4;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(gVar);
        }
        Object obj5 = anonymousClass1.result;
        ?? coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        try {
            try {
                try {
                    if (i6 == 0) {
                        v.throwOnFailure(obj5);
                        b bVar = this.inMemoryMutex;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = lVar;
                        anonymousClass1.L$2 = bVar;
                        anonymousClass1.label = 1;
                        p049i4.g gVar2 = (p049i4.g) bVar;
                        if (gVar2.lock(null, anonymousClass1) != coroutine_suspended) {
                            multiProcessCoordinator = this;
                            obj5 = gVar2;
                        }
                        return coroutine_suspended;
                    }
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            fileLock = (FileLock) anonymousClass1.L$2;
                            closeable2 = (java.io.Closeable) anonymousClass1.L$1;
                            b bVar2 = (b) anonymousClass1.L$0;
                            try {
                                v.throwOnFailure(obj5);
                                obj4 = bVar2;
                                obj3 = obj5;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                try {
                                    L3.d.closeFinally(closeable2, null);
                                    ((p049i4.g) obj4).unlock(null);
                                    return obj3;
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj5 = obj4;
                                    ((p049i4.g) obj5).unlock(null);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                        }
                        closeable = (java.io.Closeable) anonymousClass1.L$2;
                        obj = (b) anonymousClass1.L$1;
                        lVar2 = (l) anonymousClass1.L$0;
                        try {
                            v.throwOnFailure(obj5);
                            obj = obj;
                            obj2 = obj5;
                            fileLock2 = (FileLock) obj2;
                            try {
                                anonymousClass1.L$0 = obj;
                                anonymousClass1.L$1 = closeable;
                                anonymousClass1.L$2 = fileLock2;
                                anonymousClass1.label = 3;
                                objInvoke = lVar2.invoke(anonymousClass1);
                                if (objInvoke != coroutine_suspended) {
                                    closeable2 = closeable;
                                    fileLock = fileLock2;
                                    obj3 = objInvoke;
                                    obj4 = obj;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    L3.d.closeFinally(closeable2, null);
                                    ((p049i4.g) obj4).unlock(null);
                                    return obj3;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th4) {
                                fileLock = fileLock2;
                                th = th4;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileLock = null;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            throw th;
                        }
                    }
                    b bVar3 = (b) anonymousClass1.L$2;
                    l lVar3 = (l) anonymousClass1.L$1;
                    multiProcessCoordinator = (MultiProcessCoordinator) anonymousClass1.L$0;
                    v.throwOnFailure(obj5);
                    obj5 = bVar3;
                    lVar = lVar3;
                    Companion companion = Companion;
                    anonymousClass1.L$0 = lVar;
                    anonymousClass1.L$1 = obj5;
                    anonymousClass1.L$2 = fileOutputStream;
                    anonymousClass1.label = 2;
                    Object exclusiveFileLockWithRetryIfDeadlock = companion.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream, anonymousClass1);
                    if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                        lVar2 = lVar;
                        closeable = fileOutputStream;
                        obj = obj5;
                        obj2 = exclusiveFileLockWithRetryIfDeadlock;
                        fileLock2 = (FileLock) obj2;
                        anonymousClass1.L$0 = obj;
                        anonymousClass1.L$1 = closeable;
                        anonymousClass1.L$2 = fileLock2;
                        anonymousClass1.label = 3;
                        objInvoke = lVar2.invoke(anonymousClass1);
                        if (objInvoke != coroutine_suspended) {
                            closeable2 = closeable;
                            fileLock = fileLock2;
                            obj3 = objInvoke;
                            obj4 = obj;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            L3.d.closeFinally(closeable2, null);
                            ((p049i4.g) obj4).unlock(null);
                            return obj3;
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th6) {
                    th = th6;
                    fileLock = null;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    throw th;
                }
                fileOutputStream = new FileOutputStream(multiProcessCoordinator.getLockFile());
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            obj5 = anonymousClass1;
            try {
                throw th8;
            } catch (Throwable th9) {
                L3.d.closeFinally(coroutine_suspended, th8);
                throw th9;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00eb A[Catch: all -> 0x00ef, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00ef, blocks: (B:59:0x00eb, B:71:0x0108, B:72:0x010b), top: B:90:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:71:0x0108 A[Catch: all -> 0x00ef, TRY_ENTER, TryCatch #8 {all -> 0x00ef, blocks: (B:59:0x00eb, B:71:0x0108, B:72:0x010b), top: B:90:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x0117  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [O3.p] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int, java.io.Closeable] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    public <T> Object tryLock(p pVar, g<? super T> gVar) throws Throwable {
        ?? c03411;
        String message;
        FileLock fileLockTryLock;
        FileLock fileLock;
        b bVar;
        boolean z6;
        java.io.Closeable closeable;
        b bVar2;
        boolean z7;
        ?? r6 = pVar;
        if (gVar instanceof C03411) {
            C03411 c03412 = (C03411) gVar;
            int i5 = c03412.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c03412.label = i5 - Integer.MIN_VALUE;
                c03411 = c03412;
            } else {
                c03411 = new C03411(gVar);
            }
        } else {
            c03411 = new C03411(gVar);
        }
        Object objInvoke = c03411.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        ?? r7 = c03411.label;
        try {
            try {
                if (r7 != 0) {
                    if (r7 == 1) {
                        z7 = c03411.Z$0;
                        bVar2 = (b) c03411.L$0;
                        v.throwOnFailure(objInvoke);
                        if (z7) {
                            ((p049i4.g) bVar2).unlock(null);
                        }
                        return objInvoke;
                    }
                    if (r7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z6 = c03411.Z$0;
                    fileLock = (FileLock) c03411.L$2;
                    closeable = (java.io.Closeable) c03411.L$1;
                    bVar = (b) c03411.L$0;
                    try {
                        v.throwOnFailure(objInvoke);
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        L3.d.closeFinally(closeable, null);
                        if (z6) {
                            ((p049i4.g) bVar).unlock(null);
                        }
                        return objInvoke;
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        throw th;
                    }
                }
                v.throwOnFailure(objInvoke);
                p049i4.g gVar2 = (p049i4.g) this.inMemoryMutex;
                boolean zTryLock = gVar2.tryLock(null);
                try {
                    if (zTryLock) {
                        FileInputStream fileInputStream = new FileInputStream(getLockFile());
                        try {
                            try {
                                fileLockTryLock = fileInputStream.getChannel().tryLock(0L, LocationRequestCompat.PASSIVE_INTERVAL, true);
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = null;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                        } catch (IOException e) {
                            String message2 = e.getMessage();
                            if ((message2 == null || !W.startsWith(message2, this.LOCK_ERROR_MESSAGE, false)) && ((message = e.getMessage()) == null || !W.startsWith(message, DEADLOCK_ERROR_MESSAGE, false))) {
                                throw e;
                            }
                            fileLockTryLock = null;
                        }
                        try {
                            Boolean boolBoxBoolean = G3.b.boxBoolean(fileLockTryLock != null);
                            c03411.L$0 = gVar2;
                            c03411.L$1 = fileInputStream;
                            c03411.L$2 = fileLockTryLock;
                            c03411.Z$0 = zTryLock;
                            c03411.label = 2;
                            objInvoke = r6.invoke(boolBoxBoolean, c03411);
                            if (objInvoke != coroutine_suspended) {
                                bVar = gVar2;
                                z6 = zTryLock;
                                closeable = fileInputStream;
                                fileLock = fileLockTryLock;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                L3.d.closeFinally(closeable, null);
                                if (z6) {
                                    ((p049i4.g) bVar).unlock(null);
                                }
                                return objInvoke;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = fileLockTryLock;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            throw th;
                        }
                    } else {
                        Boolean boolBoxBoolean2 = G3.b.boxBoolean(false);
                        c03411.L$0 = gVar2;
                        c03411.Z$0 = zTryLock;
                        c03411.label = 1;
                        objInvoke = r6.invoke(boolBoxBoolean2, c03411);
                        if (objInvoke != coroutine_suspended) {
                            bVar2 = gVar2;
                            z7 = zTryLock;
                            if (z7) {
                                ((p049i4.g) bVar2).unlock(null);
                            }
                            return objInvoke;
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    c03411 = gVar2;
                    r6 = zTryLock;
                    if (r6 != 0) {
                        ((p049i4.g) c03411).unlock(null);
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            ?? r8 = c03411;
            try {
                throw th6;
            } catch (Throwable th7) {
                try {
                    L3.d.closeFinally(r7, th6);
                    throw th7;
                } catch (Throwable th8) {
                    th = th8;
                    r6 = r6;
                    c03411 = r8;
                    if (r6 != 0) {
                        ((p049i4.g) c03411).unlock(null);
                    }
                    throw th;
                }
            }
        }
    }
}
