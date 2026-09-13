package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnixLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private boolean eofSeen;
    private boolean slashNSeen;
    private boolean slashRSeen;
    private final InputStream target;

    public UnixLineEndingInputStream(InputStream inputStream, boolean z6) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z6;
    }

    private int eofGame(boolean z6) {
        if (z6 || !this.ensureLineFeedAtEndOfFile || this.slashNSeen) {
            return -1;
        }
        this.slashNSeen = true;
        return 10;
    }

    private int readWithUpdate() throws IOException {
        int i5 = this.target.read();
        boolean z6 = i5 == -1;
        this.eofSeen = z6;
        if (z6) {
            return i5;
        }
        this.slashNSeen = i5 == 10;
        this.slashRSeen = i5 == 13;
        return i5;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        throw UnsupportedOperationExceptions.mark();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        boolean z6 = this.slashRSeen;
        if (this.eofSeen) {
            return eofGame(z6);
        }
        int withUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame(z6);
        }
        if (this.slashRSeen) {
            return 10;
        }
        return (z6 && this.slashNSeen) ? read() : withUpdate;
    }
}
