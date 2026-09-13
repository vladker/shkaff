package androidx.datastore.core;

import E3.g;
import G3.d;
import G3.f;
import O3.p;
import O3.q;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.E;
import p049i4.b;
import p049i4.i;
import p147z3.AbstractC1926f;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final O3.a onClose;
    private final Serializer<T> serializer;
    private final b transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", i = {0, 0, 0}, l = {101}, m = "readScope", n = {"this", "$this$use$iv", "lock"}, s = {"L$0", "L$1", "Z$0"})
    public static final class AnonymousClass1<R> extends d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileStorageConnection<T> fileStorageConnection, g<? super AnonymousClass1> gVar) {
            super(gVar);
            this.this$0 = fileStorageConnection;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {214, 118}, m = "writeScope", n = {"this", "block", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "scratchFile", "$this$use$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class C03401 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03401(FileStorageConnection<T> fileStorageConnection, g<? super C03401> gVar) {
            super(gVar);
            this.this$0 = fileStorageConnection;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator coordinator, O3.a onClose) {
        E.f(file, "file");
        E.f(serializer, "serializer");
        E.f(coordinator, "coordinator");
        E.f(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = i.Mutex(false);
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
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

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:31:0x007c A[Catch: all -> 0x007d, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007d, blocks: (B:31:0x007c, B:40:0x008d, B:39:0x008a, B:36:0x0085), top: B:52:0x0022, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0095  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.FileStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [O3.q] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.datastore.core.StorageConnection
    public <R> Object readScope(q qVar, g<? super R> gVar) throws Throwable {
        ?? anonymousClass1;
        Throwable th;
        Closeable closeable;
        ?? r8;
        ?? r6;
        if (gVar instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass2 = (AnonymousClass1) gVar;
            int i5 = anonymousClass2.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i5 - Integer.MIN_VALUE;
                anonymousClass1 = anonymousClass2;
            } else {
                anonymousClass1 = new AnonymousClass1(this, gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        Throwable th2 = null;
        try {
            if (i6 != 0) {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                qVar = anonymousClass1.Z$0;
                closeable = (Closeable) anonymousClass1.L$1;
                anonymousClass1 = (FileStorageConnection) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    r6 = anonymousClass1;
                    r8 = qVar;
                    try {
                        closeable.close();
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                    if (th2 == null) {
                        throw th2;
                    }
                    if (r8 != 0) {
                        ((p049i4.g) r6.transactionMutex).unlock(null);
                    }
                    return obj;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        closeable.close();
                    } catch (Throwable th5) {
                        AbstractC1926f.addSuppressed(th, th5);
                    }
                    throw th;
                }
            }
            v.throwOnFailure(obj);
            checkNotClosed();
            boolean zTryLock = ((p049i4.g) this.transactionMutex).tryLock(null);
            try {
                FileReadScope fileReadScope = new FileReadScope(this.file, this.serializer);
                try {
                    Boolean boolBoxBoolean = G3.b.boxBoolean(zTryLock);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = fileReadScope;
                    anonymousClass1.Z$0 = zTryLock;
                    anonymousClass1.label = 1;
                    Object objInvoke = qVar.invoke(fileReadScope, boolBoxBoolean, anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objInvoke;
                    r8 = zTryLock;
                    r6 = this;
                    closeable = fileReadScope;
                    closeable.close();
                    if (th2 == null) {
                        throw th2;
                    }
                    if (r8 != 0) {
                        ((p049i4.g) r6.transactionMutex).unlock(null);
                    }
                    return obj;
                } catch (Throwable th6) {
                    th = th6;
                    qVar = zTryLock;
                    anonymousClass1 = this;
                    closeable = fileReadScope;
                    closeable.close();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                qVar = zTryLock;
                anonymousClass1 = this;
                if (qVar != 0) {
                    ((p049i4.g) anonymousClass1.transactionMutex).unlock(null);
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            if (qVar != 0) {
                ((p049i4.g) anonymousClass1.transactionMutex).unlock(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00bd A[Catch: all -> 0x00ed, IOException -> 0x00ef, TRY_ENTER, TryCatch #3 {IOException -> 0x00ef, blocks: (B:34:0x00bd, B:36:0x00c3, B:39:0x00cc, B:40:0x00ec, B:47:0x00fa, B:54:0x0107, B:53:0x0104), top: B:68:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fa A[Catch: all -> 0x00ed, IOException -> 0x00ef, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x00ef, blocks: (B:34:0x00bd, B:36:0x00c3, B:39:0x00cc, B:40:0x00ec, B:47:0x00fa, B:54:0x0107, B:53:0x0104), top: B:68:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.core.StorageConnection
    public Object writeScope(p pVar, g<? super Q> gVar) throws Throwable {
        C03401 c03401;
        File file;
        FileStorageConnection<T> fileStorageConnection;
        b bVar;
        FileWriteScope fileWriteScope;
        Throwable th;
        Closeable closeable;
        File file2;
        FileStorageConnection<T> fileStorageConnection2;
        if (gVar instanceof C03401) {
            c03401 = (C03401) gVar;
            int i5 = c03401.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c03401.label = i5 - Integer.MIN_VALUE;
            } else {
                c03401 = new C03401(this, gVar);
            }
        } else {
            c03401 = new C03401(this, gVar);
        }
        Object obj = c03401.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c03401.label;
        try {
            try {
                try {
                    try {
                        if (i6 == 0) {
                            v.throwOnFailure(obj);
                            checkNotClosed();
                            createParentDirectories(this.file);
                            b bVar2 = this.transactionMutex;
                            c03401.L$0 = this;
                            c03401.L$1 = pVar;
                            c03401.L$2 = bVar2;
                            c03401.label = 1;
                            p049i4.g gVar2 = (p049i4.g) bVar2;
                            if (gVar2.lock(null, c03401) != coroutine_suspended) {
                                fileStorageConnection = this;
                                bVar = gVar2;
                            }
                            return coroutine_suspended;
                        }
                        if (i6 != 1) {
                            if (i6 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            closeable = (Closeable) c03401.L$3;
                            File file3 = (File) c03401.L$2;
                            bVar = (b) c03401.L$1;
                            fileStorageConnection2 = (FileStorageConnection) c03401.L$0;
                            try {
                                v.throwOnFailure(obj);
                                file2 = file3;
                                try {
                                    closeable.close();
                                    th = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (th == null) {
                                    throw th;
                                }
                                if (file2.exists() && !FileMoves_androidKt.atomicMoveTo(file2, fileStorageConnection2.file)) {
                                    throw new IOException("Unable to rename " + file2 + " to " + fileStorageConnection2.file + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                }
                                ((p049i4.g) bVar).unlock(null);
                                return Q.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    closeable.close();
                                } catch (Throwable th4) {
                                    AbstractC1926f.addSuppressed(th, th4);
                                }
                                throw th;
                            }
                        }
                        b bVar3 = (b) c03401.L$2;
                        p pVar2 = (p) c03401.L$1;
                        fileStorageConnection = (FileStorageConnection) c03401.L$0;
                        v.throwOnFailure(obj);
                        bVar = bVar3;
                        pVar = pVar2;
                        c03401.L$0 = fileStorageConnection;
                        c03401.L$1 = bVar;
                        c03401.L$2 = file;
                        c03401.L$3 = fileWriteScope;
                        c03401.label = 2;
                        if (pVar.invoke(fileWriteScope, c03401) != coroutine_suspended) {
                            file2 = file;
                            fileStorageConnection2 = fileStorageConnection;
                            closeable = fileWriteScope;
                            closeable.close();
                            th = null;
                            if (th == null) {
                                throw th;
                            }
                            if (file2.exists()) {
                                throw new IOException("Unable to rename " + file2 + " to " + fileStorageConnection2.file + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                            }
                            ((p049i4.g) bVar).unlock(null);
                            return Q.INSTANCE;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th5) {
                        th = th5;
                        closeable = fileWriteScope;
                        closeable.close();
                        throw th;
                    }
                    fileWriteScope = new FileWriteScope(file, fileStorageConnection.serializer);
                } catch (IOException e) {
                    e = e;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
                file = new File(fileStorageConnection.file.getAbsolutePath() + ".tmp");
            } catch (Throwable th6) {
                ((p049i4.g) bVar).unlock(null);
                throw th6;
            }
        } catch (IOException e6) {
            e = e6;
            file = coroutine_suspended;
        }
    }
}
