package A4;

import A3.AbstractC0157z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class J extends AbstractC0180x {
    public static ArrayList a(V v6, boolean z6) throws IOException {
        File file = v6.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z6) {
                return null;
            }
            if (file.exists()) {
                throw new IOException(AbstractC0157z.m("failed to list ", v6));
            }
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", v6));
        }
        ArrayList arrayList = new ArrayList();
        for (String it : list) {
            kotlin.jvm.internal.E.e(it, "it");
            arrayList.add(v6.resolve(it));
        }
        A3.N.sort(arrayList);
        return arrayList;
    }

    @Override // A4.AbstractC0180x
    public f0 appendingSink(V file, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        if (!z6 || exists(file)) {
            return N.sink(file.toFile(), true);
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // A4.AbstractC0180x
    public void atomicMove(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // A4.AbstractC0180x
    public V canonicalize(V path) throws IOException {
        kotlin.jvm.internal.E.f(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            return V.Companion.get(canonicalFile, false);
        }
        throw new FileNotFoundException("no such file");
    }

    @Override // A4.AbstractC0180x
    public void createDirectory(V dir, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        C0178v c0178vMetadataOrNull = metadataOrNull(dir);
        if (c0178vMetadataOrNull == null || !c0178vMetadataOrNull.b) {
            throw new IOException(AbstractC0157z.m("failed to create directory: ", dir));
        }
        if (z6) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // A4.AbstractC0180x
    public void createSymlink(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        throw new IOException("unsupported");
    }

    @Override // A4.AbstractC0180x
    public void delete(V path, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(AbstractC0157z.m("failed to delete ", path));
        }
        if (z6) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", path));
        }
    }

    @Override // A4.AbstractC0180x
    public List<V> list(V dir) throws IOException {
        kotlin.jvm.internal.E.f(dir, "dir");
        ArrayList arrayListA = a(dir, true);
        kotlin.jvm.internal.E.c(arrayListA);
        return arrayListA;
    }

    @Override // A4.AbstractC0180x
    public List<V> listOrNull(V dir) {
        kotlin.jvm.internal.E.f(dir, "dir");
        return a(dir, false);
    }

    @Override // A4.AbstractC0180x
    public C0178v metadataOrNull(V path) {
        kotlin.jvm.internal.E.f(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new C0178v(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // A4.AbstractC0180x
    public AbstractC0177u openReadOnly(V file) {
        kotlin.jvm.internal.E.f(file, "file");
        return new I(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override // A4.AbstractC0180x
    public AbstractC0177u openReadWrite(V file, boolean z6, boolean z7) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        if (z6 && z7) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z6 && exists(file)) {
            throw new IOException(file + " already exists.");
        }
        if (!z7 || exists(file)) {
            return new I(true, new RandomAccessFile(file.toFile(), "rw"));
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // A4.AbstractC0180x
    public f0 sink(V file, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        if (!z6 || !exists(file)) {
            return O.sink$default(file.toFile(), false, 1, null);
        }
        throw new IOException(file + " already exists.");
    }

    @Override // A4.AbstractC0180x
    public h0 source(V file) {
        kotlin.jvm.internal.E.f(file, "file");
        return N.source(file.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
