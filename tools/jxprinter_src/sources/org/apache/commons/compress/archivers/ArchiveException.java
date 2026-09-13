package org.apache.commons.compress.archivers;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArchiveException extends Exception {
    private static final long serialVersionUID = 2772690708123267100L;

    public ArchiveException(String str) {
        super(str);
    }

    public ArchiveException(String str, Exception exc) {
        super(str);
        initCause(exc);
    }
}
