package org.apache.commons.io.filefilter;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.file.PathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoffMillis;

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return this.acceptOlder != FileUtils.isFileNewer(file, this.cutoffMillis);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        String str = this.acceptOlder ? "<=" : ">";
        StringBuilder sb = new StringBuilder();
        a.x(sb, super.toString(), "(", str);
        return AbstractC0157z.r(sb, this.cutoffMillis, ")");
    }

    public AgeFileFilter(Date date, boolean z6) {
        this(date.getTime(), z6);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        try {
            return AbstractFileFilter.toFileVisitResult(this.acceptOlder != PathUtils.isNewer(path, this.cutoffMillis, new LinkOption[0]), path);
        } catch (IOException e) {
            return handle(e);
        }
    }

    public AgeFileFilter(File file, boolean z6) {
        this(FileUtils.lastModifiedUnchecked(file), z6);
    }

    public AgeFileFilter(long j6) {
        this(j6, true);
    }

    public AgeFileFilter(long j6, boolean z6) {
        this.acceptOlder = z6;
        this.cutoffMillis = j6;
    }
}
