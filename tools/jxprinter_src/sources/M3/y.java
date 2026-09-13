package M3;

import A3.T;
import A3.v0;
import A3.w0;
import W3.InterfaceC0233q;
import X3.W;
import X3.b0;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends x {
    private static final Path Path(String path) {
        E.f(path, "path");
        Path path2 = Paths.get(path, new String[0]);
        E.e(path2, "get(...)");
        return path2;
    }

    private static final Path absolute(Path path) {
        E.f(path, "<this>");
        Path absolutePath = path.toAbsolutePath();
        E.e(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    private static final String absolutePathString(Path path) {
        E.f(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    private static final Path copyTo(Path path, Path target, boolean z6) throws IOException {
        E.f(path, "<this>");
        E.f(target, "target");
        CopyOption[] copyOptionArr = z6 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        E.e(pathCopy, "copy(...)");
        return pathCopy;
    }

    public static /* synthetic */ Path copyTo$default(Path path, Path target, boolean z6, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        E.f(path, "<this>");
        E.f(target, "target");
        CopyOption[] copyOptionArr = z6 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        E.e(pathCopy, "copy(...)");
        return pathCopy;
    }

    private static final Path createDirectories(Path path, FileAttribute<?>... attributes) throws IOException {
        E.f(path, "<this>");
        E.f(attributes, "attributes");
        Path pathCreateDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateDirectories, "createDirectories(...)");
        return pathCreateDirectories;
    }

    private static final Path createDirectory(Path path, FileAttribute<?>... attributes) throws IOException {
        E.f(path, "<this>");
        E.f(attributes, "attributes");
        Path pathCreateDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateDirectory, "createDirectory(...)");
        return pathCreateDirectory;
    }

    private static final Path createFile(Path path, FileAttribute<?>... attributes) throws IOException {
        E.f(path, "<this>");
        E.f(attributes, "attributes");
        Path pathCreateFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateFile, "createFile(...)");
        return pathCreateFile;
    }

    private static final Path createLinkPointingTo(Path path, Path target) throws IOException {
        E.f(path, "<this>");
        E.f(target, "target");
        Path pathCreateLink = Files.createLink(path, target);
        E.e(pathCreateLink, "createLink(...)");
        return pathCreateLink;
    }

    public static final Path createParentDirectories(Path path, FileAttribute<?>... attributes) throws FileAlreadyExistsException {
        E.f(path, "<this>");
        E.f(attributes, "attributes");
        Path parent = path.getParent();
        if (parent != null && !Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr = (FileAttribute[]) Arrays.copyOf(attributes, attributes.length);
                E.e(Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length)), "createDirectories(...)");
                return path;
            } catch (FileAlreadyExistsException e) {
                if (!Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e;
                }
            }
        }
        return path;
    }

    private static final Path createSymbolicLinkPointingTo(Path path, Path target, FileAttribute<?>... attributes) throws IOException {
        E.f(path, "<this>");
        E.f(target, "target");
        E.f(attributes, "attributes");
        Path pathCreateSymbolicLink = Files.createSymbolicLink(path, target, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateSymbolicLink, "createSymbolicLink(...)");
        return pathCreateSymbolicLink;
    }

    private static final Path createTempDirectory(String str, FileAttribute<?>... attributes) throws IOException {
        E.f(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    public static /* synthetic */ Path createTempDirectory$default(String str, FileAttribute[] attributes, int i5, Object obj) throws IOException {
        if ((i5 & 1) != 0) {
            str = null;
        }
        E.f(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    private static final Path createTempFile(String str, String str2, FileAttribute<?>... attributes) throws IOException {
        E.f(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    public static /* synthetic */ Path createTempFile$default(String str, String str2, FileAttribute[] attributes, int i5, Object obj) throws IOException {
        if ((i5 & 1) != 0) {
            str = null;
        }
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        E.f(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    private static final void deleteExisting(Path path) throws IOException {
        E.f(path, "<this>");
        Files.delete(path);
    }

    private static final boolean deleteIfExists(Path path) {
        E.f(path, "<this>");
        return Files.deleteIfExists(path);
    }

    private static final Path div(Path path, Path other) {
        E.f(path, "<this>");
        E.f(other, "other");
        Path pathResolve = path.resolve(other);
        E.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    private static final boolean exists(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> attributeViewClass) {
        E.f(path, "path");
        E.f(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    private static final <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        E.l();
        throw null;
    }

    private static final <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        E.l();
        throw null;
    }

    private static final long fileSize(Path path) {
        E.f(path, "<this>");
        return Files.size(path);
    }

    private static final FileStore fileStore(Path path) throws IOException {
        E.f(path, "<this>");
        FileStore fileStore = Files.getFileStore(path);
        E.e(fileStore, "getFileStore(...)");
        return fileStore;
    }

    public static final FileVisitor<Path> fileVisitor(O3.l builderAction) {
        E.f(builderAction, "builderAction");
        g gVar = new g();
        builderAction.invoke(gVar);
        return gVar.build();
    }

    private static final void forEachDirectoryEntry(Path path, String glob, O3.l action) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(glob, "glob");
        E.f(action, "action");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            E.c(directoryStreamNewDirectoryStream);
            Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static /* synthetic */ void forEachDirectoryEntry$default(Path path, String glob, O3.l action, int i5, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i5 & 1) != 0) {
            glob = ProxyConfig.MATCH_ALL_SCHEMES;
        }
        E.f(path, "<this>");
        E.f(glob, "glob");
        E.f(action, "action");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            E.c(directoryStreamNewDirectoryStream);
            Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    private static final Object getAttribute(Path path, String attribute, LinkOption... options) {
        E.f(path, "<this>");
        E.f(attribute, "attribute");
        E.f(options, "options");
        return Files.getAttribute(path, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    public static final String getExtension(Path path) {
        String string;
        String strSubstringAfterLast;
        E.f(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringAfterLast = b0.substringAfterLast(string, '.', "")) == null) ? "" : strSubstringAfterLast;
    }

    public static final String getInvariantSeparatorsPathString(Path path) {
        E.f(path, "<this>");
        String separator = path.getFileSystem().getSeparator();
        boolean zA = E.a(separator, PackagingURIHelper.FORWARD_SLASH_STRING);
        String string = path.toString();
        if (zA) {
            return string;
        }
        E.c(separator);
        return W.replace(string, separator, PackagingURIHelper.FORWARD_SLASH_STRING, false);
    }

    private static final FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(options, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        E.e(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    public static final String getName(Path path) {
        E.f(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? "" : string;
    }

    public static final String getNameWithoutExtension(Path path) {
        String string;
        String strSubstringBeforeLast;
        E.f(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringBeforeLast = b0.substringBeforeLast(string, Consts.DOT, string)) == null) ? "" : strSubstringBeforeLast;
    }

    private static final UserPrincipal getOwner(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(options, "options");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        E.e(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    private static final boolean isDirectory(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final boolean isExecutable(Path path) {
        E.f(path, "<this>");
        return Files.isExecutable(path);
    }

    private static final boolean isHidden(Path path) {
        E.f(path, "<this>");
        return Files.isHidden(path);
    }

    private static final boolean isReadable(Path path) {
        E.f(path, "<this>");
        return Files.isReadable(path);
    }

    private static final boolean isRegularFile(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final boolean isSameFileAs(Path path, Path other) {
        E.f(path, "<this>");
        E.f(other, "other");
        return Files.isSameFile(path, other);
    }

    private static final boolean isSymbolicLink(Path path) {
        E.f(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    private static final boolean isWritable(Path path) {
        E.f(path, "<this>");
        return Files.isWritable(path);
    }

    public static final List<Path> listDirectoryEntries(Path path, String glob) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(glob, "glob");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            E.c(directoryStreamNewDirectoryStream);
            List<Path> list = T.toList(directoryStreamNewDirectoryStream);
            L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
            return list;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ProxyConfig.MATCH_ALL_SCHEMES;
        }
        return listDirectoryEntries(path, str);
    }

    private static final Path moveTo(Path path, Path target, CopyOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(target, "target");
        E.f(options, "options");
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        E.e(pathMove, "move(...)");
        return pathMove;
    }

    public static /* synthetic */ Path moveTo$default(Path path, Path target, boolean z6, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        E.f(path, "<this>");
        E.f(target, "target");
        CopyOption[] copyOptionArr = z6 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        E.e(pathMove, "move(...)");
        return pathMove;
    }

    private static final boolean notExists(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        E.l();
        throw null;
    }

    private static final Path readSymbolicLink(Path path) throws IOException {
        E.f(path, "<this>");
        Path symbolicLink = Files.readSymbolicLink(path);
        E.e(symbolicLink, "readSymbolicLink(...)");
        return symbolicLink;
    }

    public static final Path relativeTo(Path path, Path base) {
        E.f(path, "<this>");
        E.f(base, "base");
        try {
            return m.INSTANCE.tryRelativeTo(path, base);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e);
        }
    }

    public static final Path relativeToOrNull(Path path, Path base) {
        E.f(path, "<this>");
        E.f(base, "base");
        try {
            return m.INSTANCE.tryRelativeTo(path, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final Path relativeToOrSelf(Path path, Path base) {
        E.f(path, "<this>");
        E.f(base, "base");
        Path pathRelativeToOrNull = relativeToOrNull(path, base);
        return pathRelativeToOrNull == null ? path : pathRelativeToOrNull;
    }

    private static final Path setAttribute(Path path, String attribute, Object obj, LinkOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(attribute, "attribute");
        E.f(options, "options");
        Path attribute2 = Files.setAttribute(path, attribute, obj, (LinkOption[]) Arrays.copyOf(options, options.length));
        E.e(attribute2, "setAttribute(...)");
        return attribute2;
    }

    private static final Path setLastModifiedTime(Path path, FileTime value) throws IOException {
        E.f(path, "<this>");
        E.f(value, "value");
        Path lastModifiedTime = Files.setLastModifiedTime(path, value);
        E.e(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    private static final Path setOwner(Path path, UserPrincipal value) throws IOException {
        E.f(path, "<this>");
        E.f(value, "value");
        Path owner = Files.setOwner(path, value);
        E.e(owner, "setOwner(...)");
        return owner;
    }

    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> value) throws IOException {
        E.f(path, "<this>");
        E.f(value, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions(path, value);
        E.e(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    private static final Path toPath(URI uri) {
        E.f(uri, "<this>");
        Path path = Paths.get(uri);
        E.e(path, "get(...)");
        return path;
    }

    private static final <T> T useDirectoryEntries(Path path, String glob, O3.l block) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(glob, "glob");
        E.f(block, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            E.c(directoryStreamNewDirectoryStream);
            T t6 = (T) block.invoke(T.asSequence(directoryStreamNewDirectoryStream));
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static /* synthetic */ Object useDirectoryEntries$default(Path path, String glob, O3.l block, int i5, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i5 & 1) != 0) {
            glob = ProxyConfig.MATCH_ALL_SCHEMES;
        }
        E.f(path, "<this>");
        E.f(glob, "glob");
        E.f(block, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            E.c(directoryStreamNewDirectoryStream);
            Object objInvoke = block.invoke(T.asSequence(directoryStreamNewDirectoryStream));
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(directoryStreamNewDirectoryStream, th);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static final void visitFileTree(Path path, FileVisitor<Path> visitor, int i5, boolean z6) throws IOException {
        E.f(path, "<this>");
        E.f(visitor, "visitor");
        Files.walkFileTree(path, z6 ? v0.setOf(FileVisitOption.FOLLOW_LINKS) : w0.emptySet(), i5, visitor);
    }

    public static final InterfaceC0233q walk(Path path, p... options) {
        E.f(path, "<this>");
        E.f(options, "options");
        return new o(path, options);
    }

    private static final Path Path(String base, String... subpaths) {
        E.f(base, "base");
        E.f(subpaths, "subpaths");
        Path path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        E.e(path, "get(...)");
        return path;
    }

    public static final Path createTempDirectory(Path path, String str, FileAttribute<?>... attributes) throws IOException {
        E.f(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            E.e(pathCreateTempDirectory, "createTempDirectory(...)");
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateTempDirectory2, "createTempDirectory(...)");
        return pathCreateTempDirectory2;
    }

    public static final Path createTempFile(Path path, String str, String str2, FileAttribute<?>... attributes) throws IOException {
        E.f(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            E.e(pathCreateTempFile, "createTempFile(...)");
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        E.e(pathCreateTempFile2, "createTempFile(...)");
        return pathCreateTempFile2;
    }

    private static final Path div(Path path, String other) {
        E.f(path, "<this>");
        E.f(other, "other");
        Path pathResolve = path.resolve(other);
        E.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    private static final Path moveTo(Path path, Path target, boolean z6) throws IOException {
        E.f(path, "<this>");
        E.f(target, "target");
        CopyOption[] copyOptionArr = z6 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        E.e(pathMove, "move(...)");
        return pathMove;
    }

    private static final Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(attributes, "attributes");
        E.f(options, "options");
        Map<String, Object> attributes2 = Files.readAttributes(path, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        E.e(attributes2, "readAttributes(...)");
        return attributes2;
    }

    private static final Path copyTo(Path path, Path target, CopyOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(target, "target");
        E.f(options, "options");
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        E.e(pathCopy, "copy(...)");
        return pathCopy;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        return createTempDirectory(path, str, fileAttributeArr);
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            str2 = null;
        }
        return createTempFile(path, str, str2, fileAttributeArr);
    }

    public static final void visitFileTree(Path path, int i5, boolean z6, O3.l builderAction) {
        E.f(path, "<this>");
        E.f(builderAction, "builderAction");
        visitFileTree(path, fileVisitor(builderAction), i5, z6);
    }

    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    public static /* synthetic */ void getPathString$annotations(Path path) {
    }
}
