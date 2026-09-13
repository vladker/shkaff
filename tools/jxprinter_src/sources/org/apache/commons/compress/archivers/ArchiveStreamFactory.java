package org.apache.commons.compress.archivers;

import A3.AbstractC0157z;
import C4.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.compress.archivers.ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.apache.commons.compress.utils.Sets;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArchiveStreamFactory implements ArchiveStreamProvider {
    public static final String AR = "ar";
    public static final String ARJ = "arj";
    public static final String CPIO = "cpio";
    public static final ArchiveStreamFactory DEFAULT = new ArchiveStreamFactory();
    public static final String DUMP = "dump";
    private static final int DUMP_SIGNATURE_SIZE = 32;
    public static final String JAR = "jar";
    public static final String SEVEN_Z = "7z";
    private static final int SIGNATURE_SIZE = 12;
    public static final String TAR = "tar";
    private static final int TAR_HEADER_SIZE = 512;
    public static final String ZIP = "zip";
    private SortedMap<String, ArchiveStreamProvider> archiveInputStreamProviders;
    private SortedMap<String, ArchiveStreamProvider> archiveOutputStreamProviders;
    private final String encoding;
    private volatile String entryEncoding;

    public ArchiveStreamFactory() {
        this(null);
    }

    public static String detect(InputStream inputStream) throws Throwable {
        TarArchiveInputStream tarArchiveInputStream;
        Throwable th;
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] bArr = new byte[12];
        inputStream.mark(12);
        try {
            int fully = IOUtils.readFully(inputStream, bArr);
            inputStream.reset();
            if (ZipArchiveInputStream.matches(bArr, fully)) {
                return ZIP;
            }
            if (JarArchiveInputStream.matches(bArr, fully)) {
                return JAR;
            }
            if (ArArchiveInputStream.matches(bArr, fully)) {
                return AR;
            }
            if (CpioArchiveInputStream.matches(bArr, fully)) {
                return CPIO;
            }
            if (ArjArchiveInputStream.matches(bArr, fully)) {
                return ARJ;
            }
            if (SevenZFile.matches(bArr, fully)) {
                return SEVEN_Z;
            }
            byte[] bArr2 = new byte[32];
            inputStream.mark(32);
            try {
                int fully2 = IOUtils.readFully(inputStream, bArr2);
                inputStream.reset();
                if (DumpArchiveInputStream.matches(bArr2, fully2)) {
                    return DUMP;
                }
                byte[] bArr3 = new byte[512];
                inputStream.mark(512);
                try {
                    int fully3 = IOUtils.readFully(inputStream, bArr3);
                    inputStream.reset();
                    if (TarArchiveInputStream.matches(bArr3, fully3)) {
                        return TAR;
                    }
                    if (fully3 >= 512) {
                        TarArchiveInputStream tarArchiveInputStream2 = null;
                        try {
                            tarArchiveInputStream = new TarArchiveInputStream(new ByteArrayInputStream(bArr3));
                            try {
                                if (tarArchiveInputStream.getNextTarEntry().isCheckSumOK()) {
                                    IOUtils.closeQuietly(tarArchiveInputStream);
                                    return TAR;
                                }
                                IOUtils.closeQuietly(tarArchiveInputStream);
                            } catch (Exception unused) {
                                tarArchiveInputStream2 = tarArchiveInputStream;
                                IOUtils.closeQuietly(tarArchiveInputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                IOUtils.closeQuietly(tarArchiveInputStream);
                                throw th;
                            }
                        } catch (Exception unused2) {
                        } catch (Throwable th3) {
                            tarArchiveInputStream = null;
                            th = th3;
                        }
                    }
                    throw new ArchiveException("No Archiver found for the stream signature");
                } catch (IOException e) {
                    throw new ArchiveException("IOException while reading tar signature", e);
                }
            } catch (IOException e6) {
                throw new ArchiveException("IOException while reading dump signature", e6);
            }
        } catch (IOException e7) {
            throw new ArchiveException("IOException while reading signature.", e7);
        }
    }

    private static ArrayList<ArchiveStreamProvider> findArchiveStreamProviders() {
        return Lists.newArrayList(serviceLoaderIterator());
    }

    public static SortedMap<String, ArchiveStreamProvider> findAvailableArchiveInputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new a(3));
    }

    public static SortedMap<String, ArchiveStreamProvider> findAvailableArchiveOutputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new a(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SortedMap lambda$findAvailableArchiveInputStreamProviders$0() {
        TreeMap treeMap = new TreeMap();
        ArchiveStreamFactory archiveStreamFactory = DEFAULT;
        putAll(archiveStreamFactory.getInputStreamArchiveNames(), archiveStreamFactory, treeMap);
        ArrayList<ArchiveStreamProvider> arrayListFindArchiveStreamProviders = findArchiveStreamProviders();
        int size = arrayListFindArchiveStreamProviders.size();
        int i5 = 0;
        while (i5 < size) {
            ArchiveStreamProvider archiveStreamProvider = arrayListFindArchiveStreamProviders.get(i5);
            i5++;
            ArchiveStreamProvider archiveStreamProvider2 = archiveStreamProvider;
            putAll(archiveStreamProvider2.getInputStreamArchiveNames(), archiveStreamProvider2, treeMap);
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SortedMap lambda$findAvailableArchiveOutputStreamProviders$1() {
        TreeMap treeMap = new TreeMap();
        ArchiveStreamFactory archiveStreamFactory = DEFAULT;
        putAll(archiveStreamFactory.getOutputStreamArchiveNames(), archiveStreamFactory, treeMap);
        ArrayList<ArchiveStreamProvider> arrayListFindArchiveStreamProviders = findArchiveStreamProviders();
        int size = arrayListFindArchiveStreamProviders.size();
        int i5 = 0;
        while (i5 < size) {
            ArchiveStreamProvider archiveStreamProvider = arrayListFindArchiveStreamProviders.get(i5);
            i5++;
            ArchiveStreamProvider archiveStreamProvider2 = archiveStreamProvider;
            putAll(archiveStreamProvider2.getOutputStreamArchiveNames(), archiveStreamProvider2, treeMap);
        }
        return treeMap;
    }

    public static void putAll(Set<String> set, ArchiveStreamProvider archiveStreamProvider, TreeMap<String, ArchiveStreamProvider> treeMap) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            treeMap.put(toKey(it.next()), archiveStreamProvider);
        }
    }

    private static Iterator<ArchiveStreamProvider> serviceLoaderIterator() {
        return new ServiceLoaderIterator(ArchiveStreamProvider.class);
    }

    private static String toKey(String str) {
        return str.toUpperCase(Locale.ROOT);
    }

    public ArchiveInputStream createArchiveInputStream(String str, InputStream inputStream) {
        return createArchiveInputStream(str, inputStream, this.entryEncoding);
    }

    public ArchiveOutputStream createArchiveOutputStream(String str, OutputStream outputStream) {
        return createArchiveOutputStream(str, outputStream, this.entryEncoding);
    }

    public SortedMap<String, ArchiveStreamProvider> getArchiveInputStreamProviders() {
        if (this.archiveInputStreamProviders == null) {
            this.archiveInputStreamProviders = Collections.unmodifiableSortedMap(findAvailableArchiveInputStreamProviders());
        }
        return this.archiveInputStreamProviders;
    }

    public SortedMap<String, ArchiveStreamProvider> getArchiveOutputStreamProviders() {
        if (this.archiveOutputStreamProviders == null) {
            this.archiveOutputStreamProviders = Collections.unmodifiableSortedMap(findAvailableArchiveOutputStreamProviders());
        }
        return this.archiveOutputStreamProviders;
    }

    public String getEntryEncoding() {
        return this.entryEncoding;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public Set<String> getInputStreamArchiveNames() {
        return Sets.newHashSet(AR, ARJ, ZIP, TAR, JAR, CPIO, DUMP, SEVEN_Z);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public Set<String> getOutputStreamArchiveNames() {
        return Sets.newHashSet(AR, ZIP, TAR, JAR, CPIO, SEVEN_Z);
    }

    @Deprecated
    public void setEntryEncoding(String str) {
        if (this.encoding != null) {
            throw new IllegalStateException("Cannot overide encoding set by the constructor");
        }
        this.entryEncoding = str;
    }

    public ArchiveStreamFactory(String str) {
        this.encoding = str;
        this.entryEncoding = str;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public ArchiveInputStream createArchiveInputStream(String str, InputStream inputStream, String str2) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        }
        if (AR.equalsIgnoreCase(str)) {
            return new ArArchiveInputStream(inputStream);
        }
        if (ARJ.equalsIgnoreCase(str)) {
            return str2 != null ? new ArjArchiveInputStream(inputStream, str2) : new ArjArchiveInputStream(inputStream);
        }
        if (ZIP.equalsIgnoreCase(str)) {
            return str2 != null ? new ZipArchiveInputStream(inputStream, str2) : new ZipArchiveInputStream(inputStream);
        }
        if (TAR.equalsIgnoreCase(str)) {
            return str2 != null ? new TarArchiveInputStream(inputStream, str2) : new TarArchiveInputStream(inputStream);
        }
        if (JAR.equalsIgnoreCase(str)) {
            return str2 != null ? new JarArchiveInputStream(inputStream, str2) : new JarArchiveInputStream(inputStream);
        }
        if (CPIO.equalsIgnoreCase(str)) {
            return str2 != null ? new CpioArchiveInputStream(inputStream, str2) : new CpioArchiveInputStream(inputStream);
        }
        if (DUMP.equalsIgnoreCase(str)) {
            return str2 != null ? new DumpArchiveInputStream(inputStream, str2) : new DumpArchiveInputStream(inputStream);
        }
        if (SEVEN_Z.equalsIgnoreCase(str)) {
            throw new StreamingNotSupportedException(SEVEN_Z);
        }
        ArchiveStreamProvider archiveStreamProvider = getArchiveInputStreamProviders().get(toKey(str));
        if (archiveStreamProvider != null) {
            return archiveStreamProvider.createArchiveInputStream(str, inputStream, str2);
        }
        throw new ArchiveException(AbstractC0157z.o("Archiver: ", str, " not found."));
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public ArchiveOutputStream createArchiveOutputStream(String str, OutputStream outputStream, String str2) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream must not be null.");
        }
        if (AR.equalsIgnoreCase(str)) {
            return new ArArchiveOutputStream(outputStream);
        }
        if (ZIP.equalsIgnoreCase(str)) {
            ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
            if (str2 != null) {
                zipArchiveOutputStream.setEncoding(str2);
            }
            return zipArchiveOutputStream;
        }
        if (TAR.equalsIgnoreCase(str)) {
            return str2 != null ? new TarArchiveOutputStream(outputStream, str2) : new TarArchiveOutputStream(outputStream);
        }
        if (JAR.equalsIgnoreCase(str)) {
            return str2 != null ? new JarArchiveOutputStream(outputStream, str2) : new JarArchiveOutputStream(outputStream);
        }
        if (CPIO.equalsIgnoreCase(str)) {
            return str2 != null ? new CpioArchiveOutputStream(outputStream, str2) : new CpioArchiveOutputStream(outputStream);
        }
        if (SEVEN_Z.equalsIgnoreCase(str)) {
            throw new StreamingNotSupportedException(SEVEN_Z);
        }
        ArchiveStreamProvider archiveStreamProvider = getArchiveOutputStreamProviders().get(toKey(str));
        if (archiveStreamProvider != null) {
            return archiveStreamProvider.createArchiveOutputStream(str, outputStream, str2);
        }
        throw new ArchiveException(AbstractC0157z.o("Archiver: ", str, " not found."));
    }

    public ArchiveInputStream createArchiveInputStream(InputStream inputStream) {
        return createArchiveInputStream(detect(inputStream), inputStream);
    }
}
