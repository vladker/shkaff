package org.apache.commons.compress.changes;

import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class Change {
    static final int TYPE_ADD = 2;
    static final int TYPE_DELETE = 1;
    static final int TYPE_DELETE_DIR = 4;
    static final int TYPE_MOVE = 3;
    private final ArchiveEntry entry;
    private final InputStream input;
    private final boolean replaceMode;
    private final String targetFile;
    private final int type;

    public Change(String str, int i5) {
        Objects.requireNonNull(str, "fileName");
        this.targetFile = str;
        this.type = i5;
        this.input = null;
        this.entry = null;
        this.replaceMode = true;
    }

    public ArchiveEntry getEntry() {
        return this.entry;
    }

    public InputStream getInput() {
        return this.input;
    }

    public boolean isReplaceMode() {
        return this.replaceMode;
    }

    public String targetFile() {
        return this.targetFile;
    }

    public int type() {
        return this.type;
    }

    public Change(ArchiveEntry archiveEntry, InputStream inputStream, boolean z6) {
        Objects.requireNonNull(archiveEntry, "archiveEntry");
        Objects.requireNonNull(inputStream, "inputStream");
        this.entry = archiveEntry;
        this.input = inputStream;
        this.type = 2;
        this.targetFile = null;
        this.replaceMode = z6;
    }
}
