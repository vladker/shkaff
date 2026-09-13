package A4;

import W3.InterfaceC0233q;
import java.nio.file.FileSystem;
import java.util.List;
import org.apache.poi.util.TempFile;
import p147z3.AbstractC1926f;

/* JADX INFO: renamed from: A4.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0180x {
    public static final C0179w Companion = new C0179w();
    public static final AbstractC0180x RESOURCES;
    public static final AbstractC0180x SYSTEM;
    public static final V SYSTEM_TEMPORARY_DIRECTORY;

    /* JADX INFO: renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m128write$default(AbstractC0180x abstractC0180x, V file, boolean z6, O3.l writerAction, int i5, Object obj) throws Throwable {
        Object objInvoke;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        kotlin.jvm.internal.E.f(file, "file");
        kotlin.jvm.internal.E.f(writerAction, "writerAction");
        InterfaceC0170m interfaceC0170mBuffer = N.buffer(abstractC0180x.sink(file, z6));
        Throwable th = null;
        try {
            objInvoke = writerAction.invoke(interfaceC0170mBuffer);
            if (interfaceC0170mBuffer != null) {
                try {
                    interfaceC0170mBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (interfaceC0170mBuffer != null) {
                try {
                    interfaceC0170mBuffer.close();
                } catch (Throwable th4) {
                    AbstractC1926f.addSuppressed(th3, th4);
                }
            }
            objInvoke = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.E.c(objInvoke);
        return objInvoke;
    }

    static {
        AbstractC0180x j6;
        try {
            Class.forName("java.nio.file.Files");
            j6 = new M();
        } catch (ClassNotFoundException unused) {
            j6 = new J();
        }
        SYSTEM = j6;
        U u6 = V.Companion;
        String property = System.getProperty(TempFile.JAVA_IO_TMPDIR);
        kotlin.jvm.internal.E.e(property, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = u6.get(property, false);
        ClassLoader classLoader = B4.n.class.getClassLoader();
        kotlin.jvm.internal.E.e(classLoader, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new B4.n(classLoader, false);
    }

    public static /* synthetic */ f0 appendingSink$default(AbstractC0180x abstractC0180x, V v6, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        return abstractC0180x.appendingSink(v6, z6);
    }

    public static /* synthetic */ void createDirectories$default(AbstractC0180x abstractC0180x, V v6, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        abstractC0180x.createDirectories(v6, z6);
    }

    public static /* synthetic */ void createDirectory$default(AbstractC0180x abstractC0180x, V v6, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        abstractC0180x.createDirectory(v6, z6);
    }

    public static /* synthetic */ void delete$default(AbstractC0180x abstractC0180x, V v6, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        abstractC0180x.delete(v6, z6);
    }

    public static /* synthetic */ void deleteRecursively$default(AbstractC0180x abstractC0180x, V v6, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        abstractC0180x.deleteRecursively(v6, z6);
    }

    public static final AbstractC0180x get(FileSystem fileSystem) {
        return Companion.get(fileSystem);
    }

    public static /* synthetic */ AbstractC0177u openReadWrite$default(AbstractC0180x abstractC0180x, V v6, boolean z6, boolean z7, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        if ((i5 & 4) != 0) {
            z7 = false;
        }
        return abstractC0180x.openReadWrite(v6, z6, z7);
    }

    public static /* synthetic */ f0 sink$default(AbstractC0180x abstractC0180x, V v6, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        return abstractC0180x.sink(v6, z6);
    }

    /* JADX INFO: renamed from: -read, reason: not valid java name */
    public final <T> T m129read(V file, O3.l readerAction) throws Throwable {
        T t6;
        kotlin.jvm.internal.E.f(file, "file");
        kotlin.jvm.internal.E.f(readerAction, "readerAction");
        InterfaceC0171n interfaceC0171nBuffer = N.buffer(source(file));
        Throwable th = null;
        try {
            t6 = (T) readerAction.invoke(interfaceC0171nBuffer);
            if (interfaceC0171nBuffer != null) {
                try {
                    interfaceC0171nBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (interfaceC0171nBuffer != null) {
                try {
                    interfaceC0171nBuffer.close();
                } catch (Throwable th4) {
                    AbstractC1926f.addSuppressed(th3, th4);
                }
            }
            th = th3;
            t6 = null;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.E.c(t6);
        return t6;
    }

    /* JADX INFO: renamed from: -write, reason: not valid java name */
    public final <T> T m130write(V file, boolean z6, O3.l writerAction) throws Throwable {
        T t6;
        kotlin.jvm.internal.E.f(file, "file");
        kotlin.jvm.internal.E.f(writerAction, "writerAction");
        InterfaceC0170m interfaceC0170mBuffer = N.buffer(sink(file, z6));
        Throwable th = null;
        try {
            t6 = (T) writerAction.invoke(interfaceC0170mBuffer);
            if (interfaceC0170mBuffer != null) {
                try {
                    interfaceC0170mBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (interfaceC0170mBuffer != null) {
                try {
                    interfaceC0170mBuffer.close();
                } catch (Throwable th4) {
                    AbstractC1926f.addSuppressed(th3, th4);
                }
            }
            t6 = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.E.c(t6);
        return t6;
    }

    public final f0 appendingSink(V file) {
        kotlin.jvm.internal.E.f(file, "file");
        return appendingSink(file, false);
    }

    public abstract f0 appendingSink(V v6, boolean z6);

    public abstract void atomicMove(V v6, V v7);

    public abstract V canonicalize(V v6);

    public void copy(V source, V target) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        B4.f.commonCopy(this, source, target);
    }

    public final void createDirectories(V dir, boolean z6) {
        kotlin.jvm.internal.E.f(dir, "dir");
        B4.f.commonCreateDirectories(this, dir, z6);
    }

    public final void createDirectory(V dir) {
        kotlin.jvm.internal.E.f(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(V v6, boolean z6);

    public abstract void createSymlink(V v6, V v7);

    public final void delete(V path) {
        kotlin.jvm.internal.E.f(path, "path");
        delete(path, false);
    }

    public abstract void delete(V v6, boolean z6);

    public void deleteRecursively(V fileOrDirectory, boolean z6) {
        kotlin.jvm.internal.E.f(fileOrDirectory, "fileOrDirectory");
        B4.f.commonDeleteRecursively(this, fileOrDirectory, z6);
    }

    public final boolean exists(V path) {
        kotlin.jvm.internal.E.f(path, "path");
        return B4.f.commonExists(this, path);
    }

    public abstract List<V> list(V v6);

    public abstract List<V> listOrNull(V v6);

    public InterfaceC0233q listRecursively(V dir, boolean z6) {
        kotlin.jvm.internal.E.f(dir, "dir");
        return B4.f.commonListRecursively(this, dir, z6);
    }

    public final C0178v metadata(V path) {
        kotlin.jvm.internal.E.f(path, "path");
        return B4.f.commonMetadata(this, path);
    }

    public abstract C0178v metadataOrNull(V v6);

    public abstract AbstractC0177u openReadOnly(V v6);

    public final AbstractC0177u openReadWrite(V file) {
        kotlin.jvm.internal.E.f(file, "file");
        return openReadWrite(file, false, false);
    }

    public abstract AbstractC0177u openReadWrite(V v6, boolean z6, boolean z7);

    public final f0 sink(V file) {
        kotlin.jvm.internal.E.f(file, "file");
        return sink(file, false);
    }

    public abstract f0 sink(V v6, boolean z6);

    public abstract h0 source(V v6);

    public final void createDirectories(V dir) {
        kotlin.jvm.internal.E.f(dir, "dir");
        createDirectories(dir, false);
    }

    public final void deleteRecursively(V fileOrDirectory) {
        kotlin.jvm.internal.E.f(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    public final InterfaceC0233q listRecursively(V dir) {
        kotlin.jvm.internal.E.f(dir, "dir");
        return listRecursively(dir, false);
    }
}
