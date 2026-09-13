package org.apache.commons.compress.archivers.tar;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TarArchiveStructSparse {
    private final long numbytes;
    private final long offset;

    public TarArchiveStructSparse(long j6, long j7) {
        if (j6 < 0) {
            throw new IllegalArgumentException("offset must not be negative");
        }
        if (j7 < 0) {
            throw new IllegalArgumentException("numbytes must not be negative");
        }
        this.offset = j6;
        this.numbytes = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TarArchiveStructSparse.class == obj.getClass()) {
            TarArchiveStructSparse tarArchiveStructSparse = (TarArchiveStructSparse) obj;
            if (this.offset == tarArchiveStructSparse.offset && this.numbytes == tarArchiveStructSparse.numbytes) {
                return true;
            }
        }
        return false;
    }

    public long getNumbytes() {
        return this.numbytes;
    }

    public long getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.offset), Long.valueOf(this.numbytes));
    }

    public String toString() {
        return "TarArchiveStructSparse{offset=" + this.offset + ", numbytes=" + this.numbytes + '}';
    }
}
