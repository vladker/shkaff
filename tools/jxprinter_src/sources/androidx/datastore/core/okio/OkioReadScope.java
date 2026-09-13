package androidx.datastore.core.okio;

import A4.AbstractC0180x;
import A4.InterfaceC0171n;
import A4.N;
import A4.V;
import E3.g;
import F3.i;
import G3.d;
import G3.f;
import androidx.datastore.core.ReadScope;
import java.io.Closeable;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1926f;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final AbstractC0180x fileSystem;
    private final V path;
    private final OkioSerializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioReadScope$readData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", i = {0, 0, 1}, l = {180, 187}, m = "readData$suspendImpl", n = {"$this", "$this$use$iv$iv", "$this$use$iv$iv"}, s = {"L$0", "L$1", "L$0"})
    public static final class AnonymousClass1<T> extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioReadScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioReadScope<T> okioReadScope, g<? super AnonymousClass1> gVar) {
            super(gVar);
            this.this$0 = okioReadScope;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkioReadScope.readData$suspendImpl(this.this$0, this);
        }
    }

    public OkioReadScope(AbstractC0180x fileSystem, V path, OkioSerializer<T> serializer) {
        E.f(fileSystem, "fileSystem");
        E.f(path, "path");
        E.f(serializer, "serializer");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0090 A[Catch: FileNotFoundException -> 0x008a, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:46:0x0090, B:47:0x0094, B:42:0x0086, B:39:0x0081), top: B:82:0x0081, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0094 A[Catch: FileNotFoundException -> 0x008a, TRY_LEAVE, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:46:0x0090, B:47:0x0094, B:42:0x0086, B:39:0x0081), top: B:82:0x0081, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x009f  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:82:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static /* synthetic */ <T> Object readData$suspendImpl(OkioReadScope<T> okioReadScope, g<? super T> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        OkioReadScope<T> okioReadScope2;
        Closeable closeable;
        Throwable th;
        InterfaceC0171n interfaceC0171nBuffer;
        Throwable th2;
        Closeable closeable2;
        Object from;
        Throwable th3;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(okioReadScope, gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(okioReadScope, gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        Throwable th4 = null;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            okioReadScope.checkClose();
            try {
                InterfaceC0171n interfaceC0171nBuffer2 = N.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                try {
                    OkioSerializer<T> okioSerializer = ((OkioReadScope) okioReadScope).serializer;
                    anonymousClass1.L$0 = okioReadScope;
                    anonymousClass1.L$1 = interfaceC0171nBuffer2;
                    anonymousClass1.label = 1;
                    Object from2 = okioSerializer.readFrom(interfaceC0171nBuffer2, anonymousClass1);
                    if (from2 != coroutine_suspended) {
                        closeable = interfaceC0171nBuffer2;
                        obj = from2;
                        if (closeable != null) {
                            closeable.close();
                        }
                        th3 = null;
                        if (th3 == null) {
                            throw th3;
                        }
                        E.c(obj);
                        return obj;
                    }
                    return coroutine_suspended;
                } catch (Throwable th5) {
                    okioReadScope2 = okioReadScope;
                    closeable = interfaceC0171nBuffer2;
                    th = th5;
                    if (closeable != null) {
                        closeable.close();
                    }
                    th3 = th;
                    obj = null;
                }
            } catch (FileNotFoundException unused) {
                if (((OkioReadScope) okioReadScope).fileSystem.exists(((OkioReadScope) okioReadScope).path)) {
                    return ((OkioReadScope) okioReadScope).serializer.getDefaultValue();
                }
                interfaceC0171nBuffer = N.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                OkioSerializer<T> okioSerializer2 = ((OkioReadScope) okioReadScope).serializer;
                anonymousClass1.L$0 = interfaceC0171nBuffer;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
                from = okioSerializer2.readFrom(interfaceC0171nBuffer, anonymousClass1);
                if (from != coroutine_suspended) {
                    obj = from;
                    closeable2 = interfaceC0171nBuffer;
                    if (closeable2 != null) {
                        closeable2.close();
                    }
                    if (th4 != null) {
                        throw th4;
                    }
                    E.c(obj);
                    return obj;
                }
            }
        } else {
            if (i6 == 1) {
                closeable = (Closeable) anonymousClass1.L$1;
                okioReadScope2 = (OkioReadScope) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    if (closeable != null) {
                        try {
                            closeable.close();
                        } catch (Throwable th6) {
                            th3 = th6;
                        }
                    }
                    th3 = null;
                } catch (Throwable th7) {
                    th = th7;
                    if (closeable != null) {
                        try {
                            try {
                                closeable.close();
                            } catch (Throwable th8) {
                                AbstractC1926f.addSuppressed(th, th8);
                            }
                        } catch (FileNotFoundException unused2) {
                            okioReadScope = okioReadScope2;
                            if (((OkioReadScope) okioReadScope).fileSystem.exists(((OkioReadScope) okioReadScope).path)) {
                                return ((OkioReadScope) okioReadScope).serializer.getDefaultValue();
                            }
                            interfaceC0171nBuffer = N.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                            try {
                                OkioSerializer<T> okioSerializer3 = ((OkioReadScope) okioReadScope).serializer;
                                anonymousClass1.L$0 = interfaceC0171nBuffer;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.label = 2;
                                from = okioSerializer3.readFrom(interfaceC0171nBuffer, anonymousClass1);
                                if (from != coroutine_suspended) {
                                    obj = from;
                                    closeable2 = interfaceC0171nBuffer;
                                    if (closeable2 != null) {
                                        closeable2.close();
                                    }
                                    if (th4 != null) {
                                        throw th4;
                                    }
                                    E.c(obj);
                                    return obj;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th9) {
                                th2 = th9;
                                closeable2 = interfaceC0171nBuffer;
                                if (closeable2 != null) {
                                    closeable2.close();
                                }
                                th4 = th2;
                                obj = null;
                            }
                        }
                    }
                    th3 = th;
                    obj = null;
                }
                if (th3 == null) {
                    throw th3;
                }
                E.c(obj);
                return obj;
            }
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeable2 = (Closeable) anonymousClass1.L$0;
            try {
                v.throwOnFailure(obj);
                if (closeable2 != null) {
                    try {
                        closeable2.close();
                    } catch (Throwable th10) {
                        th4 = th10;
                    }
                }
            } catch (Throwable th11) {
                th2 = th11;
                if (closeable2 != null) {
                    try {
                        closeable2.close();
                    } catch (Throwable th12) {
                        AbstractC1926f.addSuppressed(th2, th12);
                    }
                }
                th4 = th2;
                obj = null;
            }
        }
        if (th4 != null) {
            throw th4;
        }
        E.c(obj);
        return obj;
    }

    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final AbstractC0180x getFileSystem() {
        return this.fileSystem;
    }

    public final V getPath() {
        return this.path;
    }

    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(g<? super T> gVar) {
        return readData$suspendImpl(this, gVar);
    }
}
