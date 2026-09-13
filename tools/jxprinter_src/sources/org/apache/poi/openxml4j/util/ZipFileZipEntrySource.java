package org.apache.poi.openxml4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZipFileZipEntrySource implements ZipEntrySource {
    private ZipFile zipArchive;

    public ZipFileZipEntrySource(ZipFile zipFile) {
        this.zipArchive = zipFile;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ZipFile zipFile = this.zipArchive;
        if (zipFile != null) {
            zipFile.close();
        }
        this.zipArchive = null;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipArchiveEntry> getEntries() {
        ZipFile zipFile = this.zipArchive;
        if (zipFile != null) {
            return zipFile.getEntries();
        }
        throw new IllegalStateException("Zip File is closed");
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public ZipArchiveEntry getEntry(String str) {
        String strReplace = str.replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
        ZipArchiveEntry entry = this.zipArchive.getEntry(strReplace);
        if (entry != null) {
            return entry;
        }
        Enumeration<ZipArchiveEntry> entries = this.zipArchive.getEntries();
        while (entries.hasMoreElements()) {
            ZipArchiveEntry zipArchiveEntryNextElement = entries.nextElement();
            if (strReplace.equalsIgnoreCase(zipArchiveEntryNextElement.getName().replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/'))) {
                return zipArchiveEntryNextElement;
            }
        }
        return null;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipArchiveEntry zipArchiveEntry) {
        ZipFile zipFile = this.zipArchive;
        if (zipFile != null) {
            return zipFile.getInputStream(zipArchiveEntry);
        }
        throw new IllegalStateException("Zip File is closed");
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public boolean isClosed() {
        return this.zipArchive == null;
    }
}
