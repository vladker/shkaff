package org.apache.commons.compress.archivers.examples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Expander {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ArchiveEntrySupplier {
        ArchiveEntry getNextReadableEntry();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface EntryWriter {
        void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArchiveEntry lambda$expand$0(ArchiveInputStream archiveInputStream) {
        ArchiveEntry nextEntry = archiveInputStream.getNextEntry();
        while (nextEntry != null && !archiveInputStream.canReadEntryData(nextEntry)) {
            nextEntry = archiveInputStream.getNextEntry();
        }
        return nextEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArchiveEntry lambda$expand$2(Iterator it) {
        if (it.hasNext()) {
            return (ArchiveEntry) it.next();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$expand$3(TarFile tarFile, ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
        InputStream inputStream = tarFile.getInputStream((TarArchiveEntry) archiveEntry);
        try {
            IOUtils.copy(inputStream, outputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x000f, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ org.apache.commons.compress.archivers.ArchiveEntry lambda$expand$4(java.util.Enumeration r3, org.apache.commons.compress.archivers.zip.ZipFile r4) {
        /*
            boolean r0 = r3.hasMoreElements()
            r1 = 0
            if (r0 == 0) goto Le
            java.lang.Object r0 = r3.nextElement()
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 == 0) goto L24
            boolean r2 = r4.canReadEntryData(r0)
            if (r2 != 0) goto L24
            boolean r0 = r3.hasMoreElements()
            if (r0 == 0) goto Le
            java.lang.Object r0 = r3.nextElement()
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
            goto Lf
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.lambda$expand$4(java.util.Enumeration, org.apache.commons.compress.archivers.zip.ZipFile):org.apache.commons.compress.archivers.ArchiveEntry");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$expand$5(ZipFile zipFile, ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
        InputStream inputStream = zipFile.getInputStream((ZipArchiveEntry) archiveEntry);
        try {
            IOUtils.copy(inputStream, outputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$expand$6(SevenZFile sevenZFile, ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i5 = sevenZFile.read(bArr);
            if (-1 == i5) {
                return;
            } else {
                outputStream.write(bArr, 0, i5);
            }
        }
    }

    private boolean prefersSeekableByteChannel(String str) {
        return ArchiveStreamFactory.TAR.equalsIgnoreCase(str) || ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str);
    }

    public void expand(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath(), new OpenOption[0]));
        try {
            String strDetect = ArchiveStreamFactory.detect(bufferedInputStream);
            bufferedInputStream.close();
            expand(strDetect, file, file2);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void expand(String str, File file, File file2) throws IOException {
        if (prefersSeekableByteChannel(str)) {
            FileChannel fileChannelOpen = FileChannel.open(file.toPath(), StandardOpenOption.READ);
            try {
                expand(str, fileChannelOpen, file2, CloseableConsumer.CLOSING_CONSUMER);
                if (fileChannelOpen != null) {
                    fileChannelOpen.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (fileChannelOpen != null) {
                        try {
                            fileChannelOpen.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath(), new OpenOption[0]));
        try {
            expand(str, bufferedInputStream, file2, CloseableConsumer.CLOSING_CONSUMER);
            bufferedInputStream.close();
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    @Deprecated
    public void expand(InputStream inputStream, File file) {
        expand(inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void expand(InputStream inputStream, File file, CloseableConsumer closeableConsumer) {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            expand((ArchiveInputStream) closeableConsumerAdapter.track(ArchiveStreamFactory.DEFAULT.createArchiveInputStream(inputStream)), file);
            closeableConsumerAdapter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    closeableConsumerAdapter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public void expand(String str, InputStream inputStream, File file) {
        expand(str, inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void expand(String str, InputStream inputStream, File file, CloseableConsumer closeableConsumer) {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            expand((ArchiveInputStream) closeableConsumerAdapter.track(ArchiveStreamFactory.DEFAULT.createArchiveInputStream(str, inputStream)), file);
            closeableConsumerAdapter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    closeableConsumerAdapter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public void expand(String str, SeekableByteChannel seekableByteChannel, File file) {
        expand(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void expand(String str, SeekableByteChannel seekableByteChannel, File file, CloseableConsumer closeableConsumer) {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            if (!prefersSeekableByteChannel(str)) {
                expand(str, (InputStream) closeableConsumerAdapter.track(Channels.newInputStream(seekableByteChannel)), file);
            } else if (ArchiveStreamFactory.TAR.equalsIgnoreCase(str)) {
                expand((TarFile) closeableConsumerAdapter.track(new TarFile(seekableByteChannel)), file);
            } else if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(str)) {
                expand((ZipFile) closeableConsumerAdapter.track(new ZipFile(seekableByteChannel)), file);
            } else {
                if (!ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str)) {
                    throw new ArchiveException("Don't know how to handle format " + str);
                }
                expand((SevenZFile) closeableConsumerAdapter.track(new SevenZFile(seekableByteChannel)), file);
            }
            closeableConsumerAdapter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    closeableConsumerAdapter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void expand(ArchiveInputStream archiveInputStream, File file) throws IOException {
        expand(new d(archiveInputStream), new d(archiveInputStream), file);
    }

    public void expand(TarFile tarFile, File file) throws IOException {
        expand(new c(tarFile.getEntries().iterator(), 0), new c(tarFile, 1), file);
    }

    public void expand(final ZipFile zipFile, File file) throws IOException {
        final Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
        expand(new ArchiveEntrySupplier() { // from class: org.apache.commons.compress.archivers.examples.e
            @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
            public final ArchiveEntry getNextReadableEntry() {
                return Expander.lambda$expand$4(entries, zipFile);
            }
        }, new c(zipFile, 2), file);
    }

    public void expand(SevenZFile sevenZFile, File file) throws IOException {
        sevenZFile.getClass();
        expand(new b(sevenZFile), new b(sevenZFile), file);
    }

    private void expand(ArchiveEntrySupplier archiveEntrySupplier, EntryWriter entryWriter, File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        String str = File.separator;
        if (!canonicalPath.endsWith(str)) {
            canonicalPath = androidx.collection.a.n(canonicalPath, str);
        }
        ArchiveEntry nextReadableEntry = archiveEntrySupplier.getNextReadableEntry();
        while (nextReadableEntry != null) {
            File file2 = new File(file, nextReadableEntry.getName());
            if (file2.getCanonicalPath().startsWith(canonicalPath)) {
                if (nextReadableEntry.isDirectory()) {
                    if (!file2.isDirectory() && !file2.mkdirs()) {
                        throw new IOException(androidx.collection.a.k(file2, "Failed to create directory "));
                    }
                } else {
                    File parentFile = file2.getParentFile();
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        throw new IOException(androidx.collection.a.k(parentFile, "Failed to create directory "));
                    }
                    OutputStream outputStreamNewOutputStream = Files.newOutputStream(file2.toPath(), new OpenOption[0]);
                    try {
                        entryWriter.writeEntryDataTo(nextReadableEntry, outputStreamNewOutputStream);
                        if (outputStreamNewOutputStream != null) {
                            outputStreamNewOutputStream.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (outputStreamNewOutputStream != null) {
                                try {
                                    outputStreamNewOutputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                nextReadableEntry = archiveEntrySupplier.getNextReadableEntry();
            } else {
                throw new IOException("Expanding " + nextReadableEntry.getName() + " would create file outside of " + file);
            }
        }
    }
}
