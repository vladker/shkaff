package M3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends SimpleFileVisitor {
    private final O3.p onPostVisitDirectory;
    private final O3.p onPreVisitDirectory;
    private final O3.p onVisitFile;
    private final O3.p onVisitFileFailed;

    public h(O3.p pVar, O3.p pVar2, O3.p pVar3, O3.p pVar4) {
        this.onPreVisitDirectory = pVar;
        this.onVisitFile = pVar2;
        this.onVisitFileFailed = pVar3;
        this.onPostVisitDirectory = pVar4;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult postVisitDirectory(Path dir, IOException iOException) throws IOException {
        FileVisitResult fileVisitResult;
        E.f(dir, "dir");
        O3.p pVar = this.onPostVisitDirectory;
        if (pVar != null && (fileVisitResult = (FileVisitResult) pVar.invoke(dir, iOException)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultPostVisitDirectory = super.postVisitDirectory(dir, iOException);
        E.e(fileVisitResultPostVisitDirectory, "postVisitDirectory(...)");
        return fileVisitResultPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResult;
        E.f(dir, "dir");
        E.f(attrs, "attrs");
        O3.p pVar = this.onPreVisitDirectory;
        if (pVar != null && (fileVisitResult = (FileVisitResult) pVar.invoke(dir, attrs)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        E.e(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResult;
        E.f(file, "file");
        E.f(attrs, "attrs");
        O3.p pVar = this.onVisitFile;
        if (pVar != null && (fileVisitResult = (FileVisitResult) pVar.invoke(file, attrs)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        E.e(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        FileVisitResult fileVisitResult;
        E.f(file, "file");
        E.f(exc, "exc");
        O3.p pVar = this.onVisitFileFailed;
        if (pVar != null && (fileVisitResult = (FileVisitResult) pVar.invoke(file, exc)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultVisitFileFailed = super.visitFileFailed(file, exc);
        E.e(fileVisitResultVisitFileFailed, "visitFileFailed(...)");
        return fileVisitResultVisitFileFailed;
    }
}
