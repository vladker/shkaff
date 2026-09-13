package org.apache.poi.poifs.crypt.temp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.output.CloseShieldOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RandomSingleton;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class AesZipFileZipEntrySource implements ZipEntrySource {
    private static final Logger LOG = LogManager.getLogger((Class<?>) AesZipFileZipEntrySource.class);
    private static final String PADDING = "PKCS5Padding";
    private final Cipher ci;
    private boolean closed = false;
    private final File tmpFile;
    private final ZipFile zipFile;

    private AesZipFileZipEntrySource(File file, Cipher cipher) {
        this.tmpFile = file;
        this.zipFile = new ZipFile(file);
        this.ci = cipher;
    }

    private static void copyToFile(InputStream inputStream, File file, byte[] bArr, byte[] bArr2) {
        CipherAlgorithm cipherAlgorithm = CipherAlgorithm.aes128;
        Cipher cipher = CryptoFunctions.getCipher(new SecretKeySpec(bArr, cipherAlgorithm.jceId), cipherAlgorithm, ChainingMode.cbc, bArr2, 1, PADDING);
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(fileOutputStream);
                while (true) {
                    try {
                        ZipArchiveEntry nextZipEntry = zipArchiveInputStream.getNextZipEntry();
                        if (nextZipEntry == null) {
                            zipArchiveOutputStream.close();
                            fileOutputStream.close();
                            zipArchiveInputStream.close();
                            return;
                        }
                        ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(nextZipEntry.getName());
                        zipArchiveEntry.setComment(nextZipEntry.getComment());
                        zipArchiveEntry.setExtra(nextZipEntry.getExtra());
                        zipArchiveEntry.setTime(nextZipEntry.getTime());
                        zipArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
                        CipherOutputStream cipherOutputStream = new CipherOutputStream(CloseShieldOutputStream.wrap(zipArchiveOutputStream), cipher);
                        try {
                            IOUtils.copy(zipArchiveInputStream, cipherOutputStream);
                            cipherOutputStream.close();
                            zipArchiveOutputStream.closeArchiveEntry();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    cipherOutputStream.close();
                                    throw th2;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            try {
                                zipArchiveOutputStream.close();
                                throw th5;
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                                throw th5;
                            }
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th7) {
                        try {
                            fileOutputStream.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
            } catch (Throwable th9) {
                throw th9;
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    zipArchiveInputStream.close();
                    throw th11;
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                    throw th11;
                }
            }
        }
    }

    public static AesZipFileZipEntrySource createZipEntrySource(InputStream inputStream) {
        try {
            byte[] bArr = new byte[16];
            byte[] bArr2 = new byte[16];
            RandomSingleton.getInstance().nextBytes(bArr);
            RandomSingleton.getInstance().nextBytes(bArr2);
            File fileCreateTempFile = TempFile.createTempFile("protectedXlsx", ".zip");
            try {
                copyToFile(inputStream, fileCreateTempFile, bArr2, bArr);
                AesZipFileZipEntrySource aesZipFileZipEntrySourceFileToSource = fileToSource(fileCreateTempFile, bArr2, bArr);
                IOUtils.closeQuietly(inputStream);
                return aesZipFileZipEntrySourceFileToSource;
            } catch (IOException | RuntimeException e) {
                if (!fileCreateTempFile.delete()) {
                    LOG.atInfo().log("Temp file was not deleted, may already have been deleted by another method.");
                }
                throw e;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    private static AesZipFileZipEntrySource fileToSource(File file, byte[] bArr, byte[] bArr2) {
        CipherAlgorithm cipherAlgorithm = CipherAlgorithm.aes128;
        return new AesZipFileZipEntrySource(file, CryptoFunctions.getCipher(new SecretKeySpec(bArr, cipherAlgorithm.jceId), cipherAlgorithm, ChainingMode.cbc, bArr2, 2, PADDING));
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.zipFile.close();
            if (!this.tmpFile.delete()) {
                LOG.atWarn().log("{} can't be removed (or was already removed).", this.tmpFile.getAbsolutePath());
            }
        }
        this.closed = true;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipArchiveEntry> getEntries() {
        return this.zipFile.getEntries();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public ZipArchiveEntry getEntry(String str) {
        return this.zipFile.getEntry(str);
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipArchiveEntry zipArchiveEntry) {
        return new CipherInputStream(this.zipFile.getInputStream(zipArchiveEntry), this.ci);
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public boolean isClosed() {
        return this.closed;
    }
}
