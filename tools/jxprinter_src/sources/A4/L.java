package A4;

import A3.AbstractC0157z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class L extends M {
    private final FileSystem nioFileSystem;

    public L(FileSystem nioFileSystem) {
        kotlin.jvm.internal.E.f(nioFileSystem, "nioFileSystem");
        this.nioFileSystem = nioFileSystem;
    }

    @Override // A4.J, A4.AbstractC0180x
    public f0 appendingSink(V file, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        List listCreateListBuilder = A3.G.createListBuilder();
        listCreateListBuilder.add(StandardOpenOption.APPEND);
        if (!z6) {
            listCreateListBuilder.add(StandardOpenOption.CREATE);
        }
        List listBuild = A3.G.build(listCreateListBuilder);
        Path pathD = d(file);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathD, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        kotlin.jvm.internal.E.e(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        return N.sink(outputStreamNewOutputStream);
    }

    @Override // A4.M, A4.J, A4.AbstractC0180x
    public void atomicMove(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        try {
            kotlin.jvm.internal.E.e(Files.move(d(source), d(target), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(this, target, *options)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    public final ArrayList c(V v6, boolean z6) throws IOException {
        Path pathD = d(v6);
        try {
            List listListDirectoryEntries$default = M3.y.listDirectoryEntries$default(pathD, null, 1, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listListDirectoryEntries$default.iterator();
            while (it.hasNext()) {
                arrayList.add(v6.resolve(((Path) it.next()).toString()));
            }
            A3.N.sort(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (!z6) {
                return null;
            }
            if (Files.exists(pathD, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(AbstractC0157z.m("failed to list ", v6));
            }
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", v6));
        }
    }

    @Override // A4.J, A4.AbstractC0180x
    public V canonicalize(V path) throws IOException {
        kotlin.jvm.internal.E.f(path, "path");
        try {
            U u6 = V.Companion;
            Path realPath = d(path).toRealPath(new LinkOption[0]);
            kotlin.jvm.internal.E.e(realPath, "path.resolve().toRealPath()");
            return u6.get(realPath, false);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", path));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    @Override // A4.J, A4.AbstractC0180x
    public void createDirectory(V dir, boolean z6) throws IOException {
        boolean z7;
        kotlin.jvm.internal.E.f(dir, "dir");
        C0178v c0178vMetadataOrNull = metadataOrNull(dir);
        if (c0178vMetadataOrNull != null) {
            z7 = c0178vMetadataOrNull.b;
        }
        if (z7 && z6) {
            throw new IOException(dir + " already exist.");
        }
        try {
            kotlin.jvm.internal.E.e(Files.createDirectory(d(dir), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createDirectory(this, *attributes)");
        } catch (IOException e) {
            if (!z7) {
                throw new IOException(AbstractC0157z.m("failed to create directory: ", dir), e);
            }
        }
    }

    @Override // A4.M, A4.J, A4.AbstractC0180x
    public void createSymlink(V source, V target) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        kotlin.jvm.internal.E.e(Files.createSymbolicLink(d(source), d(target), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createSymbolicLink(this, target, *attributes)");
    }

    public final Path d(V v6) {
        Path path = this.nioFileSystem.getPath(v6.toString(), new String[0]);
        kotlin.jvm.internal.E.e(path, "nioFileSystem.getPath(toString())");
        return path;
    }

    @Override // A4.J, A4.AbstractC0180x
    public void delete(V path, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        Path pathD = d(path);
        try {
            Files.delete(pathD);
        } catch (NoSuchFileException unused) {
            if (z6) {
                throw new FileNotFoundException(AbstractC0157z.m("no such file: ", path));
            }
        } catch (IOException unused2) {
            if (Files.exists(pathD, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(AbstractC0157z.m("failed to delete ", path));
            }
        }
    }

    @Override // A4.J, A4.AbstractC0180x
    public List<V> list(V dir) throws IOException {
        kotlin.jvm.internal.E.f(dir, "dir");
        ArrayList arrayListC = c(dir, true);
        kotlin.jvm.internal.E.c(arrayListC);
        return arrayListC;
    }

    @Override // A4.J, A4.AbstractC0180x
    public List<V> listOrNull(V dir) {
        kotlin.jvm.internal.E.f(dir, "dir");
        return c(dir, false);
    }

    @Override // A4.M, A4.J, A4.AbstractC0180x
    public C0178v metadataOrNull(V path) {
        kotlin.jvm.internal.E.f(path, "path");
        return metadataOrNull(d(path));
    }

    @Override // A4.J, A4.AbstractC0180x
    public AbstractC0177u openReadOnly(V file) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        try {
            FileChannel channel = FileChannel.open(d(file), StandardOpenOption.READ);
            kotlin.jvm.internal.E.e(channel, "channel");
            return new K(false, channel);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", file));
        }
    }

    @Override // A4.J, A4.AbstractC0180x
    public AbstractC0177u openReadWrite(V file, boolean z6, boolean z7) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        if (z6 && z7) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        List listCreateListBuilder = A3.G.createListBuilder();
        listCreateListBuilder.add(StandardOpenOption.READ);
        listCreateListBuilder.add(StandardOpenOption.WRITE);
        if (z6) {
            listCreateListBuilder.add(StandardOpenOption.CREATE_NEW);
        } else if (!z7) {
            listCreateListBuilder.add(StandardOpenOption.CREATE);
        }
        List listBuild = A3.G.build(listCreateListBuilder);
        try {
            Path pathD = d(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
            FileChannel channel = FileChannel.open(pathD, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            kotlin.jvm.internal.E.e(channel, "channel");
            return new K(true, channel);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", file));
        }
    }

    @Override // A4.J, A4.AbstractC0180x
    public f0 sink(V file, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        List listCreateListBuilder = A3.G.createListBuilder();
        if (z6) {
            listCreateListBuilder.add(StandardOpenOption.CREATE_NEW);
        }
        List listBuild = A3.G.build(listCreateListBuilder);
        try {
            Path pathD = d(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathD, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            kotlin.jvm.internal.E.e(outputStreamNewOutputStream, "newOutputStream(this, *options)");
            return N.sink(outputStreamNewOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", file));
        }
    }

    @Override // A4.J, A4.AbstractC0180x
    public h0 source(V file) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(d(file), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            kotlin.jvm.internal.E.e(inputStreamNewInputStream, "newInputStream(this, *options)");
            return N.source(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", file));
        }
    }

    @Override // A4.M, A4.J
    public String toString() {
        String simpleName = kotlin.jvm.internal.U.a(this.nioFileSystem.getClass()).getSimpleName();
        kotlin.jvm.internal.E.c(simpleName);
        return simpleName;
    }
}
