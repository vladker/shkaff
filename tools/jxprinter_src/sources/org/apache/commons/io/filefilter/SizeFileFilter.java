package org.apache.commons.io.filefilter;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j6) {
        this(j6, true);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return accept(file.length());
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        String str = this.acceptLarger ? ">=" : "<";
        StringBuilder sb = new StringBuilder();
        a.x(sb, super.toString(), "(", str);
        return AbstractC0157z.r(sb, this.size, ")");
    }

    public SizeFileFilter(long j6, boolean z6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j6;
        this.acceptLarger = z6;
    }

    private boolean accept(long j6) {
        return this.acceptLarger != ((j6 > this.size ? 1 : (j6 == this.size ? 0 : -1)) < 0);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        return AbstractFileFilter.toFileVisitResult(accept(Files.size(path)), path);
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        try {
            return AbstractFileFilter.toFileVisitResult(accept(Files.size(path)), path);
        } catch (IOException e) {
            return handle(e);
        }
    }
}
