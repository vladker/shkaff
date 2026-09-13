package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class DirectoryWalker<T> {
    private final int depthLimit;
    private final FileFilter filter;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file, int i5) {
            this("Operation Cancelled", file, i5);
        }

        public int getDepth() {
            return this.depth;
        }

        public File getFile() {
            return this.file;
        }

        public CancelException(String str, File file, int i5) {
            super(str);
            this.file = file;
            this.depth = i5;
        }
    }

    public DirectoryWalker() {
        this(null, -1);
    }

    public final void checkIfCancelled(File file, int i5, Collection<T> collection) throws CancelException {
        if (handleIsCancelled(file, i5, collection)) {
            throw new CancelException(file, i5);
        }
    }

    public boolean handleDirectory(File file, int i5, Collection<T> collection) {
        return true;
    }

    public boolean handleIsCancelled(File file, int i5, Collection<T> collection) {
        return false;
    }

    public final void walk(File file, Collection<T> collection) throws CancelException {
        Objects.requireNonNull(file, "startDirectory");
        try {
            handleStart(file, collection);
            walk(file, 0, collection);
            handleEnd(collection);
        } catch (CancelException e) {
            handleCancelled(file, collection, e);
        }
    }

    public DirectoryWalker(FileFilter fileFilter, int i5) {
        this.filter = fileFilter;
        this.depthLimit = i5;
    }

    public DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i5) {
        if (iOFileFilter == null && iOFileFilter2 == null) {
            this.filter = null;
        } else {
            this.filter = FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter).or(FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.depthLimit = i5;
    }

    private void walk(File file, int i5, Collection<T> collection) throws CancelException {
        checkIfCancelled(file, i5, collection);
        if (handleDirectory(file, i5, collection)) {
            handleDirectoryStart(file, i5, collection);
            int i6 = i5 + 1;
            int i7 = this.depthLimit;
            if (i7 < 0 || i6 <= i7) {
                checkIfCancelled(file, i5, collection);
                FileFilter fileFilter = this.filter;
                File[] fileArrFilterDirectoryContents = filterDirectoryContents(file, i5, fileFilter == null ? file.listFiles() : file.listFiles(fileFilter));
                if (fileArrFilterDirectoryContents == null) {
                    handleRestricted(file, i6, collection);
                } else {
                    for (File file2 : fileArrFilterDirectoryContents) {
                        if (file2.isDirectory()) {
                            walk(file2, i6, collection);
                        } else {
                            checkIfCancelled(file2, i6, collection);
                            handleFile(file2, i6, collection);
                            checkIfCancelled(file2, i6, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i5, collection);
        }
        checkIfCancelled(file, i5, collection);
    }

    public void handleEnd(Collection<T> collection) {
    }

    public void handleStart(File file, Collection<T> collection) {
    }

    public File[] filterDirectoryContents(File file, int i5, File... fileArr) {
        return fileArr;
    }

    public void handleCancelled(File file, Collection<T> collection, CancelException cancelException) throws CancelException {
        throw cancelException;
    }

    public void handleDirectoryEnd(File file, int i5, Collection<T> collection) {
    }

    public void handleDirectoryStart(File file, int i5, Collection<T> collection) {
    }

    public void handleFile(File file, int i5, Collection<T> collection) {
    }

    public void handleRestricted(File file, int i5, Collection<T> collection) {
    }
}
