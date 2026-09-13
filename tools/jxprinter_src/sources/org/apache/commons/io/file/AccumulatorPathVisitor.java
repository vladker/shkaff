package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AccumulatorPathVisitor extends CountingPathVisitor {
    private final List<Path> dirList;
    private final List<Path> fileList;

    public AccumulatorPathVisitor() {
        super(Counters.noopPathCounters());
        this.dirList = new ArrayList();
        this.fileList = new ArrayList();
    }

    private void add(List<Path> list, Path path) {
        list.add(path.normalize());
    }

    public static AccumulatorPathVisitor withBigIntegerCounters() {
        return new AccumulatorPathVisitor(Counters.bigIntegerPathCounters());
    }

    public static AccumulatorPathVisitor withLongCounters() {
        return new AccumulatorPathVisitor(Counters.longPathCounters());
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof AccumulatorPathVisitor)) {
            return false;
        }
        AccumulatorPathVisitor accumulatorPathVisitor = (AccumulatorPathVisitor) obj;
        return Objects.equals(this.dirList, accumulatorPathVisitor.dirList) && Objects.equals(this.fileList, accumulatorPathVisitor.fileList);
    }

    public List<Path> getDirList() {
        return this.dirList;
    }

    public List<Path> getFileList() {
        return this.fileList;
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public int hashCode() {
        return Objects.hash(this.dirList, this.fileList) + (super.hashCode() * 31);
    }

    public List<Path> relativizeDirectories(Path path, boolean z6, Comparator<? super Path> comparator) {
        return PathUtils.relativize(getDirList(), path, z6, comparator);
    }

    public List<Path> relativizeFiles(Path path, boolean z6, Comparator<? super Path> comparator) {
        return PathUtils.relativize(getFileList(), path, z6, comparator);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public void updateDirCounter(Path path, IOException iOException) {
        super.updateDirCounter(path, iOException);
        add(this.dirList, path);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public void updateFileCounters(Path path, BasicFileAttributes basicFileAttributes) {
        super.updateFileCounters(path, basicFileAttributes);
        add(this.fileList, path);
    }

    public static AccumulatorPathVisitor withBigIntegerCounters(PathFilter pathFilter, PathFilter pathFilter2) {
        return new AccumulatorPathVisitor(Counters.bigIntegerPathCounters(), pathFilter, pathFilter2);
    }

    public static AccumulatorPathVisitor withLongCounters(PathFilter pathFilter, PathFilter pathFilter2) {
        return new AccumulatorPathVisitor(Counters.longPathCounters(), pathFilter, pathFilter2);
    }

    public AccumulatorPathVisitor(Counters.PathCounters pathCounters) {
        super(pathCounters);
        this.dirList = new ArrayList();
        this.fileList = new ArrayList();
    }

    public AccumulatorPathVisitor(Counters.PathCounters pathCounters, PathFilter pathFilter, PathFilter pathFilter2) {
        super(pathCounters, pathFilter, pathFilter2);
        this.dirList = new ArrayList();
        this.fileList = new ArrayList();
    }
}
