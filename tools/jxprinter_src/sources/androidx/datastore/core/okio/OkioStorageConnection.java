package androidx.datastore.core.okio;

import A4.AbstractC0180x;
import A4.V;
import E3.g;
import G3.d;
import G3.f;
import O3.a;
import O3.p;
import O3.q;
import androidx.datastore.core.Closeable;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import java.io.IOException;
import kotlin.jvm.internal.E;
import p049i4.b;
import p049i4.i;
import p147z3.AbstractC1926f;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final AbstractC0180x fileSystem;
    private final a onClose;
    private final V path;
    private final OkioSerializer<T> serializer;
    private final b transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", i = {0, 0, 0}, l = {113}, m = "readScope", n = {"this", "$this$use$iv", "lock"}, s = {"L$0", "L$1", "Z$0"})
    public static final class AnonymousClass1<R> extends d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioStorageConnection<T> okioStorageConnection, g<? super AnonymousClass1> gVar) {
            super(gVar);
            this.this$0 = okioStorageConnection;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {236, 137}, m = "writeScope", n = {"this", "block", "parentDir", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "scratchPath", "$this$use$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class C03441 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03441(OkioStorageConnection<T> okioStorageConnection, g<? super C03441> gVar) {
            super(gVar);
            this.this$0 = okioStorageConnection;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public OkioStorageConnection(AbstractC0180x fileSystem, V path, OkioSerializer<T> serializer, InterProcessCoordinator coordinator, a onClose) {
        E.f(fileSystem, "fileSystem");
        E.f(path, "path");
        E.f(serializer, "serializer");
        E.f(coordinator, "coordinator");
        E.f(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = i.Mutex(false);
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
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

    /* JADX WARN: Code duplicated, block: B:28:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0078  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e A[Catch: all -> 0x007f, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x007f, blocks: (B:31:0x007e, B:40:0x008f, B:39:0x008c, B:36:0x0087), top: B:56:0x0022, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [O3.q] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.datastore.core.StorageConnection
    public <R> Object readScope(q qVar, g<? super R> gVar) throws Throwable {
        ?? anonymousClass1;
        Throwable th;
        Closeable closeable;
        ?? r9;
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
                anonymousClass1 = (OkioStorageConnection) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    r6 = anonymousClass1;
                    r9 = qVar;
                    try {
                        closeable.close();
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                    if (th2 == null) {
                        throw th2;
                    }
                    if (r9 != 0) {
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
                OkioReadScope okioReadScope = new OkioReadScope(this.fileSystem, this.path, this.serializer);
                try {
                    Boolean boolBoxBoolean = G3.b.boxBoolean(zTryLock);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = okioReadScope;
                    anonymousClass1.Z$0 = zTryLock;
                    anonymousClass1.label = 1;
                    Object objInvoke = qVar.invoke(okioReadScope, boolBoxBoolean, anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objInvoke;
                    r9 = zTryLock;
                    r6 = this;
                    closeable = okioReadScope;
                    closeable.close();
                    if (th2 == null) {
                        throw th2;
                    }
                    if (r9 != 0) {
                        ((p049i4.g) r6.transactionMutex).unlock(null);
                    }
                    return obj;
                } catch (Throwable th6) {
                    th = th6;
                    qVar = zTryLock;
                    anonymousClass1 = this;
                    closeable = okioReadScope;
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

    /* JADX WARN: Code duplicated, block: B:36:0x00cf A[Catch: all -> 0x00df, IOException -> 0x00e2, TRY_ENTER, TryCatch #9 {IOException -> 0x00e2, all -> 0x00df, blocks: (B:36:0x00cf, B:38:0x00d7, B:46:0x00ef, B:53:0x00fe, B:52:0x00fb), top: B:80:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d7 A[Catch: all -> 0x00df, IOException -> 0x00e2, TRY_LEAVE, TryCatch #9 {IOException -> 0x00e2, all -> 0x00df, blocks: (B:36:0x00cf, B:38:0x00d7, B:46:0x00ef, B:53:0x00fe, B:52:0x00fb), top: B:80:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ef A[Catch: all -> 0x00df, IOException -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00e2, all -> 0x00df, blocks: (B:36:0x00cf, B:38:0x00d7, B:46:0x00ef, B:53:0x00fe, B:52:0x00fb), top: B:80:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [A4.x] */
    /* JADX WARN: Type inference failed for: r0v5, types: [A4.x] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r10v18, types: [A4.x] */
    /* JADX WARN: Type inference failed for: r10v21, types: [A4.x] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [A4.V] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [A4.V] */
    /* JADX WARN: Type inference failed for: r2v5, types: [A4.V, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v4, types: [A4.x] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [androidx.datastore.core.okio.OkioStorageConnection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
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
    @Override // androidx.datastore.core.StorageConnection
    public Object writeScope(p pVar, g<? super Q> gVar) throws Throwable {
        C03441 c03441;
        ?? r11;
        ?? r7;
        ?? Resolve;
        V vParent;
        OkioWriteScope okioWriteScope;
        Throwable th;
        Closeable closeable;
        ?? r6;
        ?? r8;
        ?? r9;
        if (gVar instanceof C03441) {
            c03441 = (C03441) gVar;
            int i5 = c03441.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c03441.label = i5 - Integer.MIN_VALUE;
            } else {
                c03441 = new C03441(this, gVar);
            }
        } else {
            c03441 = new C03441(this, gVar);
        }
        Object obj = c03441.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        ?? r10 = c03441.label;
        try {
            try {
                try {
                    try {
                        if (r10 == 0) {
                            v.throwOnFailure(obj);
                            checkNotClosed();
                            vParent = this.path.parent();
                            if (vParent == null) {
                                throw new IllegalStateException("must have a parent path");
                            }
                            this.fileSystem.createDirectories(vParent, false);
                            b bVar = this.transactionMutex;
                            c03441.L$0 = this;
                            c03441.L$1 = pVar;
                            c03441.L$2 = vParent;
                            c03441.L$3 = bVar;
                            c03441.label = 1;
                            p049i4.g gVar2 = (p049i4.g) bVar;
                            if (gVar2.lock(null, c03441) != coroutine_suspended) {
                                r7 = this;
                                r11 = gVar2;
                            }
                            return coroutine_suspended;
                        }
                        if (r10 != 1) {
                            if (r10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            closeable = (Closeable) c03441.L$3;
                            V v6 = (V) c03441.L$2;
                            b bVar2 = (b) c03441.L$1;
                            OkioStorageConnection okioStorageConnection = (OkioStorageConnection) c03441.L$0;
                            try {
                                v.throwOnFailure(obj);
                                r8 = okioStorageConnection;
                                r6 = v6;
                                r9 = bVar2;
                                try {
                                    closeable.close();
                                    th = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (th == null) {
                                    throw th;
                                }
                                if (r8.fileSystem.exists(r6)) {
                                    r8.fileSystem.atomicMove(r6, r8.path);
                                }
                                ((p049i4.g) r9).unlock(null);
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
                        b bVar3 = (b) c03441.L$3;
                        vParent = (V) c03441.L$2;
                        p pVar2 = (p) c03441.L$1;
                        OkioStorageConnection okioStorageConnection2 = (OkioStorageConnection) c03441.L$0;
                        v.throwOnFailure(obj);
                        r11 = bVar3;
                        pVar = pVar2;
                        r7 = okioStorageConnection2;
                        c03441.L$0 = r7;
                        c03441.L$1 = r11;
                        c03441.L$2 = Resolve;
                        c03441.L$3 = okioWriteScope;
                        c03441.label = 2;
                        if (pVar.invoke(okioWriteScope, c03441) != coroutine_suspended) {
                            r6 = Resolve;
                            closeable = okioWriteScope;
                            r8 = r7;
                            r9 = r11;
                            closeable.close();
                            th = null;
                            if (th == null) {
                                throw th;
                            }
                            if (r8.fileSystem.exists(r6)) {
                                r8.fileSystem.atomicMove(r6, r8.path);
                            }
                            ((p049i4.g) r9).unlock(null);
                            return Q.INSTANCE;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th5) {
                        th = th5;
                        closeable = okioWriteScope;
                        closeable.close();
                        throw th;
                    }
                    r7.fileSystem.delete(Resolve, false);
                    okioWriteScope = new OkioWriteScope(r7.fileSystem, Resolve, r7.serializer);
                } catch (IOException e) {
                    e = e;
                    if (r7.fileSystem.exists(Resolve)) {
                        try {
                            r7.fileSystem.delete(Resolve);
                        } catch (IOException unused) {
                        }
                    }
                    throw e;
                }
                Resolve = vParent.resolve(r7.path.name() + ".tmp");
            } catch (Throwable th6) {
                th = th6;
                ((p049i4.g) r11).unlock(null);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            r7 = c03441;
            r11 = r10;
            Resolve = coroutine_suspended;
        } catch (Throwable th7) {
            th = th7;
            r11 = r10;
            ((p049i4.g) r11).unlock(null);
            throw th;
        }
    }
}
