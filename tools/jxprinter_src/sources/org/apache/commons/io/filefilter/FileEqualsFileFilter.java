package org.apache.commons.io.filefilter;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileEqualsFileFilter extends AbstractFileFilter {
    private final File file;
    private final Path path;

    public FileEqualsFileFilter(File file) {
        Objects.requireNonNull(file, Constants.FILE);
        this.file = file;
        this.path = file.toPath();
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return Objects.equals(this.file, file);
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(Objects.equals(this.path, path), path);
    }
}
