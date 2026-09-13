package org.apache.commons.compress.archivers.tar;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TarArchiveSparseEntry implements TarConstants {
    private final boolean isExtended;
    private final List<TarArchiveStructSparse> sparseHeaders;

    public TarArchiveSparseEntry(byte[] bArr) {
        this.sparseHeaders = new ArrayList(TarUtils.readSparseStructs(bArr, 0, 21));
        this.isExtended = TarUtils.parseBoolean(bArr, 504);
    }

    public List<TarArchiveStructSparse> getSparseHeaders() {
        return this.sparseHeaders;
    }

    public boolean isExtended() {
        return this.isExtended;
    }
}
