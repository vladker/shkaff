package androidx.datastore.core;

import E3.g;
import F3.i;
import G3.d;
import G3.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.E;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class FileReadScope<T> implements ReadScope<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final File file;
    private final Serializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.FileReadScope$readData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.FileReadScope", f = "FileStorage.kt", i = {0}, l = {169, 178}, m = "readData$suspendImpl", n = {"$this"}, s = {"L$0"})
    public static final class AnonymousClass1<T> extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileReadScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileReadScope<T> fileReadScope, g<? super AnonymousClass1> gVar) {
            super(gVar);
            this.this$0 = fileReadScope;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileReadScope.readData$suspendImpl(this.this$0, this);
        }
    }

    public FileReadScope(File file, Serializer<T> serializer) {
        E.f(file, "file");
        E.f(serializer, "serializer");
        this.file = file;
        this.serializer = serializer;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v21 */
    public static /* synthetic */ <T> Object readData$suspendImpl(FileReadScope<T> fileReadScope, g<? super T> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        java.io.Closeable closeable;
        java.io.Closeable closeable2;
        Throwable th2;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fileReadScope, gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fileReadScope, gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        ?? r6 = anonymousClass1.label;
        try {
            if (r6 != 0) {
                if (r6 == 1) {
                    closeable2 = (java.io.Closeable) anonymousClass1.L$1;
                    r6 = (FileReadScope) anonymousClass1.L$0;
                    try {
                        v.throwOnFailure(obj);
                        L3.d.closeFinally(closeable2, null);
                        return obj;
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            throw th2;
                        } catch (Throwable th4) {
                            L3.d.closeFinally(closeable2, th2);
                            throw th4;
                        }
                    }
                }
                if (r6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (java.io.Closeable) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    L3.d.closeFinally(closeable, null);
                    return obj;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        throw th;
                    } catch (Throwable th6) {
                        L3.d.closeFinally(closeable, th);
                        throw th6;
                    }
                }
            }
            v.throwOnFailure(obj);
            fileReadScope.checkNotClosed();
            try {
                FileInputStream fileInputStream = new FileInputStream(((FileReadScope) fileReadScope).file);
                try {
                    Serializer<T> serializer = ((FileReadScope) fileReadScope).serializer;
                    anonymousClass1.L$0 = fileReadScope;
                    anonymousClass1.L$1 = fileInputStream;
                    anonymousClass1.label = 1;
                    Object from = serializer.readFrom(fileInputStream, anonymousClass1);
                    if (from != coroutine_suspended) {
                        closeable2 = fileInputStream;
                        obj = from;
                        L3.d.closeFinally(closeable2, null);
                        return obj;
                    }
                } catch (Throwable th7) {
                    r6 = fileReadScope;
                    closeable2 = fileInputStream;
                    th2 = th7;
                    throw th2;
                }
            } catch (FileNotFoundException unused) {
                if (!((FileReadScope) fileReadScope).file.exists()) {
                    return ((FileReadScope) fileReadScope).serializer.getDefaultValue();
                }
                FileInputStream fileInputStream2 = new FileInputStream(((FileReadScope) fileReadScope).file);
                try {
                    Serializer<T> serializer2 = ((FileReadScope) fileReadScope).serializer;
                    anonymousClass1.L$0 = fileInputStream2;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                    Object from2 = serializer2.readFrom(fileInputStream2, anonymousClass1);
                    if (from2 != coroutine_suspended) {
                        obj = from2;
                        closeable = fileInputStream2;
                        L3.d.closeFinally(closeable, null);
                        return obj;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    closeable = fileInputStream2;
                    throw th;
                }
            }
            return coroutine_suspended;
        } catch (FileNotFoundException unused2) {
            fileReadScope = (FileReadScope<T>) r6;
        }
    }

    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final File getFile() {
        return this.file;
    }

    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(g<? super T> gVar) {
        return readData$suspendImpl(this, gVar);
    }
}
