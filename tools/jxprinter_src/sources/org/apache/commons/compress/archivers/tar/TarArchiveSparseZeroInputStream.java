package org.apache.commons.compress.archivers.tar;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class TarArchiveSparseZeroInputStream extends InputStream {
    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return j6;
    }
}
