package org.apache.poi.openxml4j.util;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ZipArchiveThresholdInputStream extends FilterInputStream {
    private static final long GRACE_ENTRY_SIZE = 102400;
    private static final String MAX_ENTRY_SIZE_MSG = "Zip bomb detected! The file would exceed the max size of the expanded data in the zip-file.\nThis may indicates that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMaxEntrySize() if you need to work with files which are very large.\nUncompressed size: %d, Raw/compressed size: %d\nLimits: MAX_ENTRY_SIZE: %d, Entry: %s";
    private static final String MIN_INFLATE_RATIO_MSG = "Zip bomb detected! The file would exceed the max. ratio of compressed file size to the size of the expanded data.\nThis may indicate that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMinInflateRatio() if you need to work with files which exceed this limit.\nUncompressed size: %d, Raw/compressed size: %d, ratio: %f\nLimits: MIN_INFLATE_RATIO: %f, Entry: %s";
    private ZipArchiveEntry entry;
    private boolean guardState;

    public ZipArchiveThresholdInputStream(InputStream inputStream) {
        super(inputStream);
        this.guardState = true;
        if (inputStream instanceof InputStreamStatistics) {
            return;
        }
        throw new IllegalArgumentException("InputStream of class " + inputStream.getClass() + " is not implementing InputStreamStatistics.");
    }

    private void checkThreshold() throws IOException {
        long compressedCount;
        if (this.guardState) {
            InputStreamStatistics inputStreamStatistics = (InputStreamStatistics) ((FilterInputStream) this).in;
            long uncompressedCount = inputStreamStatistics.getUncompressedCount();
            try {
                compressedCount = inputStreamStatistics.getCompressedCount();
            } catch (NullPointerException unused) {
                compressedCount = 0;
            }
            ZipArchiveEntry zipArchiveEntry = this.entry;
            String name = zipArchiveEntry == null ? "not set" : zipArchiveEntry.getName();
            if (uncompressedCount <= ZipSecureFile.MAX_ENTRY_SIZE) {
                if (uncompressedCount <= GRACE_ENTRY_SIZE) {
                    return;
                }
                double d = compressedCount / uncompressedCount;
                if (d < ZipSecureFile.MIN_INFLATE_RATIO) {
                    throw new IOException(String.format(Locale.ROOT, MIN_INFLATE_RATIO_MSG, Long.valueOf(uncompressedCount), Long.valueOf(compressedCount), Double.valueOf(d), Double.valueOf(ZipSecureFile.MIN_INFLATE_RATIO), name));
                }
                return;
            }
            Locale locale = Locale.ROOT;
            long j6 = ZipSecureFile.MAX_ENTRY_SIZE;
            StringBuilder sbT = androidx.collection.a.t("Zip bomb detected! The file would exceed the max size of the expanded data in the zip-file.\nThis may indicates that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMaxEntrySize() if you need to work with files which are very large.\nUncompressed size: ", uncompressedCount, ", Raw/compressed size: ");
            sbT.append(compressedCount);
            sbT.append("\nLimits: MAX_ENTRY_SIZE: ");
            sbT.append(j6);
            sbT.append(", Entry: ");
            sbT.append(name);
            throw new IOException(sbT.toString());
        }
    }

    public ZipArchiveEntry getNextEntry() throws IOException {
        if (!(((FilterInputStream) this).in instanceof ZipArchiveInputStream)) {
            throw new IllegalStateException("getNextEntry() is only allowed for stream based zip processing.");
        }
        try {
            ZipArchiveEntry nextZipEntry = ((ZipArchiveInputStream) ((FilterInputStream) this).in).getNextZipEntry();
            this.entry = nextZipEntry;
            return nextZipEntry;
        } catch (EOFException unused) {
            return null;
        } catch (ZipException e) {
            if (e.getMessage().startsWith("Unexpected record signature")) {
                throw new NotOfficeXmlFileException("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file", e);
            }
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i5 = super.read();
        if (i5 > -1) {
            checkThreshold();
        }
        return i5;
    }

    public void setEntry(ZipArchiveEntry zipArchiveEntry) {
        this.entry = zipArchiveEntry;
    }

    public void setGuardState(boolean z6) {
        this.guardState = z6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        long jSkipFully = IOUtils.skipFully(((FilterInputStream) this).in, j6);
        if (jSkipFully > 0) {
            checkThreshold();
        }
        return jSkipFully;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = super.read(bArr, i5, i6);
        if (i7 > -1) {
            checkThreshold();
        }
        return i7;
    }
}
