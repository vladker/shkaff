package A4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class M extends J {
    public static Long b(FileTime fileTime) {
        long millis = fileTime.toMillis();
        Long lValueOf = Long.valueOf(millis);
        if (millis != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // A4.J, A4.AbstractC0180x
    public void atomicMove(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        try {
            Files.move(source.toNioPath(), target.toNioPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override // A4.J, A4.AbstractC0180x
    public void createSymlink(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        Files.createSymbolicLink(source.toNioPath(), target.toNioPath(), new FileAttribute[0]);
    }

    @Override // A4.J, A4.AbstractC0180x
    public C0178v metadataOrNull(V path) {
        kotlin.jvm.internal.E.f(path, "path");
        return metadataOrNull(path.toNioPath());
    }

    @Override // A4.J
    public String toString() {
        return "NioSystemFileSystem";
    }

    public final C0178v metadataOrNull(Path nioPath) {
        kotlin.jvm.internal.E.f(nioPath, "nioPath");
        try {
            BasicFileAttributes attributes = Files.readAttributes(nioPath, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(nioPath) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            V v6 = symbolicLink != null ? V.Companion.get(symbolicLink, false) : null;
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lB = fileTimeCreationTime != null ? b(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lB2 = fileTimeLastModifiedTime != null ? b(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new C0178v(zIsRegularFile, zIsDirectory, v6, lValueOf, lB, lB2, fileTimeLastAccessTime != null ? b(fileTimeLastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }
}
