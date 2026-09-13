package androidx.datastore.core.okio;

import A4.AbstractC0177u;
import A4.AbstractC0180x;
import A4.InterfaceC0170m;
import A4.N;
import A4.V;
import E3.g;
import F3.i;
import G3.d;
import G3.f;
import androidx.datastore.core.WriteScope;
import java.io.Closeable;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1926f;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioWriteScope$writeData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.okio.OkioWriteScope", f = "OkioStorage.kt", i = {0, 0, 0}, l = {216}, m = "writeData", n = {"$this$use$iv", "handle", "$this$use$iv"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioWriteScope<T> okioWriteScope, g<? super AnonymousClass1> gVar) {
            super(gVar);
            this.this$0 = okioWriteScope;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(AbstractC0180x fileSystem, V path, OkioSerializer<T> serializer) {
        super(fileSystem, path, serializer);
        E.f(fileSystem, "fileSystem");
        E.f(path, "path");
        E.f(serializer, "serializer");
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [E3.g, androidx.datastore.core.okio.OkioWriteScope$writeData$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v6, types: [A4.u, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [A4.u] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.datastore.core.okio.OkioSerializer] */
    @Override // androidx.datastore.core.WriteScope
    public Object writeData(T t6, g<? super Q> gVar) throws Throwable {
        ?? anonymousClass1;
        ?? OpenReadWrite;
        Q q6;
        Throwable th;
        Closeable closeable;
        ?? r6;
        Throwable th2;
        Q q7;
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
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        Throwable th3 = null;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                checkClose();
                OpenReadWrite = getFileSystem().openReadWrite(getPath());
                try {
                    InterfaceC0170m interfaceC0170mBuffer = N.buffer(AbstractC0177u.sink$default(OpenReadWrite, 0L, 1, null));
                    try {
                        OkioSerializer<T> serializer = getSerializer();
                        anonymousClass1.L$0 = OpenReadWrite;
                        anonymousClass1.L$1 = OpenReadWrite;
                        anonymousClass1.L$2 = interfaceC0170mBuffer;
                        anonymousClass1.label = 1;
                        if (serializer.writeTo(t6, interfaceC0170mBuffer, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ?? r7 = OpenReadWrite;
                        r6 = r7;
                        closeable = interfaceC0170mBuffer;
                        anonymousClass1 = r7;
                    } catch (Throwable th4) {
                        anonymousClass1 = OpenReadWrite;
                        th = th4;
                        closeable = interfaceC0170mBuffer;
                        if (closeable != null) {
                            closeable.close();
                        }
                        th2 = th;
                        q7 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (OpenReadWrite != 0) {
                        try {
                            OpenReadWrite.close();
                        } catch (Throwable th6) {
                            AbstractC1926f.addSuppressed(th, th6);
                        }
                    }
                    th3 = th;
                    q6 = null;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) anonymousClass1.L$2;
                AbstractC0177u abstractC0177u = (AbstractC0177u) anonymousClass1.L$1;
                anonymousClass1 = (Closeable) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    anonymousClass1 = anonymousClass1;
                    r6 = abstractC0177u;
                } catch (Throwable th7) {
                    th = th7;
                    if (closeable != null) {
                        try {
                            closeable.close();
                        } catch (Throwable th8) {
                            AbstractC1926f.addSuppressed(th, th8);
                        }
                    }
                    th2 = th;
                    q7 = null;
                }
            }
            r6.flush();
            q7 = Q.INSTANCE;
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th9) {
                    th2 = th9;
                }
            }
            th2 = null;
            if (th2 != null) {
                throw th2;
            }
            E.c(q7);
            q6 = Q.INSTANCE;
            if (anonymousClass1 != 0) {
                try {
                    anonymousClass1.close();
                } catch (Throwable th10) {
                    th3 = th10;
                }
            }
            if (th3 != null) {
                throw th3;
            }
            E.c(q6);
            return Q.INSTANCE;
        } catch (Throwable th11) {
            th = th11;
            OpenReadWrite = anonymousClass1;
        }
    }
}
