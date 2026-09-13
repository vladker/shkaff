package M3;

import A3.C0144l;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends SimpleFileVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f473a;
    private l directoryNode;
    private C0144l entries = new C0144l();

    public d(boolean z6) {
        this.f473a = z6;
    }

    public final List<l> readEntries(l directoryNode) throws IOException {
        E.f(directoryNode, "directoryNode");
        this.directoryNode = directoryNode;
        Files.walkFileTree(directoryNode.getPath(), j.INSTANCE.toVisitOptions(this.f473a), 1, this);
        this.entries.removeFirst();
        C0144l c0144l = this.entries;
        this.entries = new C0144l();
        return c0144l;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        E.f(dir, "dir");
        E.f(attrs, "attrs");
        this.entries.addLast(new l(dir, attrs.fileKey(), this.directoryNode));
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        E.e(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        E.f(file, "file");
        E.f(attrs, "attrs");
        this.entries.addLast(new l(file, null, this.directoryNode));
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        E.e(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }
}
