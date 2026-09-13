package org.apache.poi.openxml4j.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.poifs.crypt.temp.EncryptedTempData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ZipArchiveFakeEntry extends ZipArchiveEntry implements Closeable {
    private byte[] data;
    private EncryptedTempData encryptedTempData;
    private File tempFile;
    private static final Logger LOG = LogManager.getLogger((Class<?>) ZipArchiveFakeEntry.class);
    private static final int DEFAULT_MAX_ENTRY_SIZE = 100000000;
    private static int MAX_ENTRY_SIZE = DEFAULT_MAX_ENTRY_SIZE;

    public ZipArchiveFakeEntry(final ZipArchiveEntry zipArchiveEntry, InputStream inputStream) throws IOException {
        super(zipArchiveEntry.getName());
        final long size = zipArchiveEntry.getSize();
        int thresholdBytesForTempFiles = ZipInputStreamZipEntrySource.getThresholdBytesForTempFiles();
        if (thresholdBytesForTempFiles < 0 || size < thresholdBytesForTempFiles) {
            if (size < -1 || size >= 2147483647L) {
                throw new IOException("ZIP entry size is too large or invalid");
            }
            this.data = size == -1 ? IOUtils.toByteArrayWithMaxLength(inputStream, getMaxEntrySize()) : IOUtils.toByteArray(inputStream, (int) size, getMaxEntrySize());
            return;
        }
        if (!ZipInputStreamZipEntrySource.shouldEncryptTempFiles()) {
            this.tempFile = TempFile.createTempFile("poi-zip-entry", ".tmp");
            final int i5 = 0;
            final int i6 = 1;
            LOG.atInfo().log("created for temp file {} for zip entry {} of size {} bytes", new Supplier() { // from class: org.apache.poi.openxml4j.util.a
                @Override // org.apache.logging.log4j.util.Supplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return ((ZipArchiveFakeEntry) this).lambda$new$0();
                        default:
                            return this.getName();
                    }
                }
            }, new Supplier() { // from class: org.apache.poi.openxml4j.util.a
                @Override // org.apache.logging.log4j.util.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return ((ZipArchiveFakeEntry) zipArchiveEntry).lambda$new$0();
                        default:
                            return zipArchiveEntry.getName();
                    }
                }
            }, new Supplier() { // from class: org.apache.poi.openxml4j.util.b
                @Override // org.apache.logging.log4j.util.Supplier
                public final Object get() {
                    return Long.valueOf(size);
                }
            });
            IOUtils.copy(inputStream, this.tempFile);
            return;
        }
        EncryptedTempData encryptedTempData = new EncryptedTempData();
        this.encryptedTempData = encryptedTempData;
        OutputStream outputStream = encryptedTempData.getOutputStream();
        try {
            IOUtils.copy(inputStream, outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static int getMaxEntrySize() {
        return MAX_ENTRY_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0() {
        return this.tempFile.getAbsolutePath();
    }

    public static void setMaxEntrySize(int i5) {
        MAX_ENTRY_SIZE = i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.data = null;
        EncryptedTempData encryptedTempData = this.encryptedTempData;
        if (encryptedTempData != null) {
            encryptedTempData.dispose();
        }
        File file = this.tempFile;
        if (file == null || !file.exists() || this.tempFile.delete()) {
            return;
        }
        LOG.atDebug().log("temp file was already deleted (probably due to previous call to close this resource)");
    }

    public InputStream getInputStream() throws IOException {
        EncryptedTempData encryptedTempData = this.encryptedTempData;
        if (encryptedTempData != null) {
            try {
                return encryptedTempData.getInputStream();
            } catch (IOException e) {
                throw new IOException("failed to read from encrypted temp data", e);
            }
        }
        if (this.tempFile == null) {
            if (this.data != null) {
                return new UnsynchronizedByteArrayInputStream(this.data);
            }
            throw new IOException("Cannot retrieve data from Zip Entry, probably because the Zip Entry was closed before the data was requested.");
        }
        try {
            return new FileInputStream(this.tempFile);
        } catch (FileNotFoundException unused) {
            throw new IOException("temp file " + this.tempFile.getAbsolutePath() + " is missing");
        }
    }
}
