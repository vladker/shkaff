package M3;

import A3.O;
import A3.T;
import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1926f;
import p147z3.C1937q;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends q {
    public static final void a(Path path, Path path2) throws FileSystemLoopException {
        if (!Files.isSymbolicLink(path) && Files.isSameFile(path, path2)) {
            throw new FileSystemLoopException(path.toString());
        }
    }

    public static final FileVisitResult b(ArrayList arrayList, O3.q qVar, Path path, Path path2, Path path3, O3.q qVar2, Path path4) {
        try {
            if (!arrayList.isEmpty()) {
                checkFileName(path4);
                Object objLast = T.last((List<? extends Object>) arrayList);
                E.e(objLast, "last(...)");
                a(path4, (Path) objLast);
            }
            c cVar = c.INSTANCE;
            Path pathResolve = path2.resolve(y.relativeTo(path4, path).toString());
            if (pathResolve.normalize().startsWith(path3)) {
                return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((b) qVar.invoke(cVar, path4, pathResolve));
            }
            throw new i(path4, pathResolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
        } catch (Exception e) {
            return c(qVar2, path, path2, path3, path4, e);
        }
    }

    public static final FileVisitResult c(O3.q qVar, Path path, Path path2, Path path3, Path path4, Exception exc) throws i {
        Path pathResolve = path2.resolve(y.relativeTo(path4, path).toString());
        if (pathResolve.normalize().startsWith(path3)) {
            return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((k) qVar.invoke(path4, pathResolve, exc));
        }
        throw new i(path4, pathResolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
    }

    public static final void checkFileName(Path path) throws i {
        E.f(path, "<this>");
        String name = y.getName(path);
        int iHashCode = name.hashCode();
        if (iHashCode != 46) {
            if (iHashCode != 1518) {
                if (iHashCode != 45679) {
                    if (iHashCode != 45724) {
                        if (iHashCode != 1472) {
                            if (iHashCode != 1473 || !name.equals("./")) {
                                return;
                            }
                        } else if (!name.equals("..")) {
                            return;
                        }
                    } else if (!name.equals("..\\")) {
                        return;
                    }
                } else if (!name.equals("../")) {
                    return;
                }
            } else if (!name.equals(".\\")) {
                return;
            }
        } else if (!name.equals(Consts.DOT)) {
            return;
        }
        throw new i(path);
    }

    public static final Path copyToRecursively(Path path, Path target, O3.q onError, final boolean z6, boolean z7) {
        E.f(path, "<this>");
        E.f(target, "target");
        E.f(onError, "onError");
        if (z7) {
            final int i5 = 0;
            return copyToRecursively(path, target, onError, z6, new O3.q() { // from class: M3.r
                @Override // O3.q
                public final Object invoke(Object obj, Object obj2, Object obj3) throws IllegalAccessException, IOException, InvocationTargetException {
                    a copyToRecursively = (a) obj;
                    Path src = (Path) obj2;
                    Path dst = (Path) obj3;
                    switch (i5) {
                        case 0:
                            E.f(copyToRecursively, "$this$copyToRecursively");
                            E.f(src, "src");
                            E.f(dst, "dst");
                            LinkOption[] linkOptions = j.INSTANCE.toLinkOptions(z6);
                            boolean zIsDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
                            LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                            if (!Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !zIsDirectory) {
                                if (zIsDirectory) {
                                    x.deleteRecursively(dst);
                                }
                                ArrayList arrayList = new ArrayList(2);
                                if (linkOptions.length > 0) {
                                    arrayList.ensureCapacity(arrayList.size() + linkOptions.length);
                                    Collections.addAll(arrayList, linkOptions);
                                }
                                arrayList.add(StandardCopyOption.REPLACE_EXISTING);
                                CopyOption[] copyOptionArr = (CopyOption[]) arrayList.toArray(new CopyOption[arrayList.size()]);
                                E.e(Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
                            }
                            return b.f472a;
                        default:
                            E.f(copyToRecursively, "<this>");
                            E.f(src, "src");
                            E.f(dst, "dst");
                            return ((c) copyToRecursively).copyToIgnoringExistingDirectory(src, dst, z6);
                    }
                }
            });
        }
        final int i6 = 1;
        return copyToRecursively(path, target, onError, z6, new O3.q() { // from class: M3.r
            @Override // O3.q
            public final Object invoke(Object obj, Object obj2, Object obj3) throws IllegalAccessException, IOException, InvocationTargetException {
                a copyToRecursively = (a) obj;
                Path src = (Path) obj2;
                Path dst = (Path) obj3;
                switch (i6) {
                    case 0:
                        E.f(copyToRecursively, "$this$copyToRecursively");
                        E.f(src, "src");
                        E.f(dst, "dst");
                        LinkOption[] linkOptions = j.INSTANCE.toLinkOptions(z6);
                        boolean zIsDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
                        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                        if (!Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !zIsDirectory) {
                            if (zIsDirectory) {
                                x.deleteRecursively(dst);
                            }
                            ArrayList arrayList = new ArrayList(2);
                            if (linkOptions.length > 0) {
                                arrayList.ensureCapacity(arrayList.size() + linkOptions.length);
                                Collections.addAll(arrayList, linkOptions);
                            }
                            arrayList.add(StandardCopyOption.REPLACE_EXISTING);
                            CopyOption[] copyOptionArr = (CopyOption[]) arrayList.toArray(new CopyOption[arrayList.size()]);
                            E.e(Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
                        }
                        return b.f472a;
                    default:
                        E.f(copyToRecursively, "<this>");
                        E.f(src, "src");
                        E.f(dst, "dst");
                        return ((c) copyToRecursively).copyToIgnoringExistingDirectory(src, dst, z6);
                }
            }
        });
    }

    public static final void d(SecureDirectoryStream secureDirectoryStream, Path path, e eVar) {
        SecureDirectoryStream secureDirectoryStreamNewDirectoryStream;
        try {
            try {
                secureDirectoryStreamNewDirectoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception e) {
                eVar.collect(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStreamNewDirectoryStream = null;
        }
        if (secureDirectoryStreamNewDirectoryStream != null) {
            try {
                Iterator it = secureDirectoryStreamNewDirectoryStream.iterator();
                E.e(it, "iterator(...)");
                while (it.hasNext()) {
                    Path fileName = ((Path) it.next()).getFileName();
                    E.e(fileName, "getFileName(...)");
                    e(secureDirectoryStreamNewDirectoryStream, fileName, eVar.getPath(), eVar);
                }
                L3.d.closeFinally(secureDirectoryStreamNewDirectoryStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    L3.d.closeFinally(secureDirectoryStreamNewDirectoryStream, th);
                    throw th2;
                }
            }
        }
    }

    public static final void deleteRecursively(Path path) throws IllegalAccessException, IOException, InvocationTargetException {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        E.f(path, "<this>");
        e eVar = new e();
        Path parent = path.getParent();
        boolean z6 = true;
        if (parent != null) {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStreamNewDirectoryStream = null;
            }
            if (directoryStreamNewDirectoryStream != null) {
                try {
                    if (directoryStreamNewDirectoryStream instanceof SecureDirectoryStream) {
                        eVar.setPath(parent);
                        Path fileName = path.getFileName();
                        E.e(fileName, "getFileName(...)");
                        e((SecureDirectoryStream) directoryStreamNewDirectoryStream, fileName, null, eVar);
                        z6 = false;
                    }
                    L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                        throw th2;
                    }
                }
            }
        }
        if (z6) {
            f(path, null, eVar);
        }
        List<Exception> collectedExceptions = eVar.getCollectedExceptions();
        if (collectedExceptions.isEmpty()) {
            return;
        }
        FileSystemException fileSystemException = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> it = collectedExceptions.iterator();
        while (it.hasNext()) {
            AbstractC1926f.addSuppressed(fileSystemException, (Exception) it.next());
        }
        throw fileSystemException;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a A[Catch: Exception -> 0x0013, TRY_ENTER, TryCatch #1 {Exception -> 0x0013, blocks: (B:4:0x0005, B:7:0x0015, B:8:0x001b, B:12:0x003a, B:15:0x0042, B:17:0x004b, B:18:0x004f), top: B:27:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x003f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0042 A[Catch: Exception -> 0x0013, TRY_LEAVE, TryCatch #1 {Exception -> 0x0013, blocks: (B:4:0x0005, B:7:0x0015, B:8:0x001b, B:12:0x003a, B:15:0x0042, B:17:0x004b, B:18:0x004f), top: B:27:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x004b A[Catch: Exception -> 0x0013, NoSuchFileException -> 0x0056, TRY_ENTER, TryCatch #0 {NoSuchFileException -> 0x0056, blocks: (B:17:0x004b, B:18:0x004f), top: B:25:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004f A[Catch: Exception -> 0x0013, NoSuchFileException -> 0x0056, TRY_LEAVE, TryCatch #0 {NoSuchFileException -> 0x0056, blocks: (B:17:0x004b, B:18:0x004f), top: B:25:0x0040 }] */
    public static final void e(SecureDirectoryStream secureDirectoryStream, Path path, Path path2, e eVar) {
        Boolean boolValueOf;
        boolean zBooleanValue;
        int i5;
        eVar.enterEntry(path);
        if (path2 != null) {
            try {
                Path path3 = eVar.getPath();
                E.c(path3);
                checkFileName(path3);
                a(path3, path2);
                try {
                    boolValueOf = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))).readAttributes().isDirectory());
                } catch (NoSuchFileException unused) {
                    boolValueOf = null;
                }
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                } else {
                    zBooleanValue = false;
                }
                try {
                    if (zBooleanValue) {
                        i5 = eVar.f474a;
                        d(secureDirectoryStream, path, eVar);
                        if (i5 == eVar.f474a) {
                            secureDirectoryStream.deleteDirectory(path);
                        }
                    } else {
                        secureDirectoryStream.deleteFile(path);
                    }
                } catch (NoSuchFileException unused2) {
                }
            } catch (Exception e) {
                eVar.collect(e);
            }
        } else {
            boolValueOf = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))).readAttributes().isDirectory());
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                i5 = eVar.f474a;
                d(secureDirectoryStream, path, eVar);
                if (i5 == eVar.f474a) {
                    secureDirectoryStream.deleteDirectory(path);
                }
            } else {
                secureDirectoryStream.deleteFile(path);
            }
        }
        eVar.exitEntry(path);
    }

    public static final void f(Path path, Path path2, e eVar) {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        if (path2 != null) {
            try {
                checkFileName(path);
                a(path, path2);
            } catch (Exception e) {
                eVar.collect(e);
                return;
            }
        }
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            Files.deleteIfExists(path);
            return;
        }
        int i5 = eVar.f474a;
        try {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            } catch (Exception e6) {
                eVar.collect(e6);
            }
        } catch (NoSuchFileException unused) {
            directoryStreamNewDirectoryStream = null;
        }
        if (directoryStreamNewDirectoryStream != null) {
            try {
                Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
                E.e(it, "iterator(...)");
                while (it.hasNext()) {
                    Path next = it.next();
                    E.c(next);
                    f(next, path, eVar);
                }
                L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                    throw th2;
                }
            }
        }
        if (i5 == eVar.f474a) {
            Files.deleteIfExists(path);
        }
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(b bVar) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            return FileVisitResult.CONTINUE;
        }
        if (iOrdinal == 1) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        if (iOrdinal == 2) {
            return FileVisitResult.TERMINATE;
        }
        throw new C1937q();
    }

    public static final Path copyToRecursively(final Path path, final Path target, final O3.q onError, boolean z6, final O3.q copyAction) throws FileSystemException {
        E.f(path, "<this>");
        E.f(target, "target");
        E.f(onError, "onError");
        E.f(copyAction, "copyAction");
        LinkOption[] linkOptions = j.INSTANCE.toLinkOptions(z6);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            boolean zStartsWith = false;
            if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z6 || !Files.isSymbolicLink(path))) {
                boolean z7 = Files.exists(target, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(target);
                if (!z7 || !Files.isSameFile(path, target)) {
                    if (E.a(path.getFileSystem(), target.getFileSystem())) {
                        if (z7) {
                            zStartsWith = target.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                        } else {
                            Path parent = target.getParent();
                            if (parent != null && Files.exists(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && parent.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]))) {
                                zStartsWith = true;
                            }
                        }
                    }
                    if (zStartsWith) {
                        throw new FileSystemException(path.toString(), target.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                    }
                }
            }
            final Path pathNormalize = target.normalize();
            final ArrayList arrayList = new ArrayList();
            y.visitFileTree(path, Integer.MAX_VALUE, z6, new O3.l() { // from class: M3.s
                @Override // O3.l
                public final Object invoke(Object obj) {
                    f visitFileTree = (f) obj;
                    E.f(visitFileTree, "$this$visitFileTree");
                    final ArrayList arrayList2 = arrayList;
                    final O3.q qVar = copyAction;
                    final Path path2 = path;
                    final Path path3 = target;
                    final Path path4 = pathNormalize;
                    final O3.q qVar2 = onError;
                    g gVar = (g) visitFileTree;
                    gVar.onPreVisitDirectory(new O3.p() { // from class: M3.t
                        @Override // O3.p
                        public final Object invoke(Object obj2, Object obj3) {
                            Path directory = (Path) obj2;
                            BasicFileAttributes attributes = (BasicFileAttributes) obj3;
                            E.f(directory, "directory");
                            E.f(attributes, "attributes");
                            ArrayList arrayList3 = arrayList2;
                            FileVisitResult fileVisitResultB = x.b(arrayList3, qVar, path2, path3, path4, qVar2, directory);
                            if (fileVisitResultB == FileVisitResult.CONTINUE) {
                                arrayList3.add(directory);
                            }
                            return fileVisitResultB;
                        }
                    });
                    gVar.onVisitFile(new v(arrayList2, qVar, path2, path3, path4, qVar2));
                    gVar.onVisitFileFailed(new w(qVar2, path2, path3, path4));
                    gVar.onPostVisitDirectory(new O3.p() { // from class: M3.u
                        @Override // O3.p
                        public final Object invoke(Object obj2, Object obj3) {
                            Path directory = (Path) obj2;
                            IOException iOException = (IOException) obj3;
                            E.f(directory, "directory");
                            O.removeLast(arrayList2);
                            return iOException == null ? FileVisitResult.CONTINUE : x.c(qVar2, path2, path3, path4, directory, iOException);
                        }
                    });
                    return Q.INSTANCE;
                }
            });
            return target;
        }
        throw new NoSuchFileException(path.toString(), target.toString(), "The source file doesn't exist.");
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(k kVar) {
        int iOrdinal = kVar.ordinal();
        if (iOrdinal == 0) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        if (iOrdinal == 1) {
            return FileVisitResult.TERMINATE;
        }
        throw new C1937q();
    }
}
