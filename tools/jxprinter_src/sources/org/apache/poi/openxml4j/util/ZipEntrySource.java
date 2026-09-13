package org.apache.poi.openxml4j.util;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ZipEntrySource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Enumeration<? extends ZipArchiveEntry> getEntries();

    ZipArchiveEntry getEntry(String str);

    InputStream getInputStream(ZipArchiveEntry zipArchiveEntry);

    boolean isClosed();
}
