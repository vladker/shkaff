package org.apache.commons.io;

import androidx.collection.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.material.color.utilities.g;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import l5.d2;
import org.apache.commons.io.file.AccumulatorPathVisitor;
import org.apache.commons.io.file.Counters;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.file.StandardDeleteOption;
import org.apache.commons.io.filefilter.FileEqualsFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.poi.util.TempFile;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        ONE_KB_BI = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        ONE_MB_BI = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        ONE_GB_BI = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        ONE_TB_BI = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        ONE_PB_BI = bigIntegerMultiply4;
        ONE_EB_BI = bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(ONE_EB));
        ONE_ZB = bigIntegerMultiply5;
        ONE_YB = bigIntegerValueOf.multiply(bigIntegerMultiply5);
        EMPTY_FILE_ARRAY = new File[0];
    }

    @Deprecated
    public FileUtils() {
    }

    private static CopyOption[] addCopyAttributes(CopyOption... copyOptionArr) {
        CopyOption[] copyOptionArr2 = (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length + 1);
        Arrays.sort(copyOptionArr2, 0, copyOptionArr.length);
        int length = copyOptionArr.length;
        StandardCopyOption standardCopyOption = StandardCopyOption.COPY_ATTRIBUTES;
        if (Arrays.binarySearch(copyOptionArr, 0, length, standardCopyOption) >= 0) {
            return copyOptionArr;
        }
        copyOptionArr2[copyOptionArr2.length - 1] = standardCopyOption;
        return copyOptionArr2;
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "size");
        BigInteger bigInteger2 = ONE_EB_BI;
        BigInteger bigIntegerDivide = bigInteger.divide(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (bigIntegerDivide.compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger2) + " EB";
        }
        BigInteger bigInteger4 = ONE_PB_BI;
        if (bigInteger.divide(bigInteger4).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger4) + " PB";
        }
        BigInteger bigInteger5 = ONE_TB_BI;
        if (bigInteger.divide(bigInteger5).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger5) + " TB";
        }
        BigInteger bigInteger6 = ONE_GB_BI;
        if (bigInteger.divide(bigInteger6).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger6) + " GB";
        }
        BigInteger bigInteger7 = ONE_MB_BI;
        if (bigInteger.divide(bigInteger7).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger7) + " MB";
        }
        BigInteger bigInteger8 = ONE_KB_BI;
        if (bigInteger.divide(bigInteger8).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger8) + " KB";
        }
        return bigInteger + " bytes";
    }

    public static Checksum checksum(File file, Checksum checksum) throws IOException {
        requireExistsChecked(file, Constants.FILE);
        requireFile(file, Constants.FILE);
        Objects.requireNonNull(checksum, "checksum");
        CheckedInputStream checkedInputStream = new CheckedInputStream(Files.newInputStream(file.toPath(), new OpenOption[0]), checksum);
        try {
            IOUtils.consume(checkedInputStream);
            checkedInputStream.close();
            return checksum;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    checkedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static long checksumCRC32(File file) {
        return checksum(file, new CRC32()).getValue();
    }

    public static void cleanDirectory(File file) throws IOException {
        File[] fileArrListFiles = listFiles(file, null);
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            try {
                forceDelete(file2);
            } catch (IOException e) {
                arrayList.add(e);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new IOExceptionList(file.toString(), arrayList);
        }
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        File[] fileArrListFiles = listFiles(file, null);
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            try {
                forceDeleteOnExit(file2);
            } catch (IOException e) {
                arrayList.add(e);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new IOExceptionList(arrayList);
        }
    }

    public static boolean contentEquals(File file, File file2) throws IOException {
        boolean zExists;
        if (file == null && file2 == null) {
            return true;
        }
        if (file == null || file2 == null || (zExists = file.exists()) != file2.exists()) {
            return false;
        }
        if (!zExists) {
            return true;
        }
        requireFile(file, "file1");
        requireFile(file2, "file2");
        if (file.length() != file2.length()) {
            return false;
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            InputStream inputStreamNewInputStream2 = Files.newInputStream(file2.toPath(), new OpenOption[0]);
            try {
                boolean zContentEquals = IOUtils.contentEquals(inputStreamNewInputStream, inputStreamNewInputStream2);
                if (inputStreamNewInputStream2 != null) {
                    inputStreamNewInputStream2.close();
                }
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
                return zContentEquals;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamNewInputStream2 != null) {
                        try {
                            inputStreamNewInputStream2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public static boolean contentEqualsIgnoreEOL(File file, File file2, String str) throws IOException {
        boolean zExists;
        if (file == null && file2 == null) {
            return true;
        }
        if (file == null || file2 == null || (zExists = file.exists()) != file2.exists()) {
            return false;
        }
        if (!zExists) {
            return true;
        }
        requireFile(file, "file1");
        requireFile(file2, "file2");
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        Charset charset = Charsets.toCharset(str);
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(file.toPath(), new OpenOption[0]), charset);
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(Files.newInputStream(file2.toPath(), new OpenOption[0]), charset);
            try {
                boolean zContentEqualsIgnoreEOL = IOUtils.contentEqualsIgnoreEOL(inputStreamReader, inputStreamReader2);
                inputStreamReader2.close();
                inputStreamReader.close();
                return zContentEqualsIgnoreEOL;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        inputStreamReader2.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(EMPTY_FILE_ARRAY);
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        requireDirectoryIfExists(file, "sourceDir");
        requireDirectoryIfExists(file2, "destinationDir");
        copyDirectory(file, new File(file2, file.getName()), true);
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        try {
            copyToFile(inputStream, file);
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

    public static void copyToDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "sourceFile");
        if (file.isFile()) {
            copyFileToDirectory(file, file2);
        } else {
            if (file.isDirectory()) {
                copyDirectoryToDirectory(file, file2);
                return;
            }
            throw new FileNotFoundException("The source " + file + " does not exist");
        }
    }

    public static void copyToFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStreamOpenOutputStream = openOutputStream(file);
        try {
            IOUtils.copy(inputStream, fileOutputStreamOpenOutputStream);
            if (fileOutputStreamOpenOutputStream != null) {
                fileOutputStreamOpenOutputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileOutputStreamOpenOutputStream != null) {
                    try {
                        fileOutputStreamOpenOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void copyURLToFile(URL url, File file) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            copyInputStreamToFile(inputStreamOpenStream, file);
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static File createParentDirectories(File file) {
        return mkdirs(getParentFile(file));
    }

    public static String decodeUrl(String str) {
        int i5;
        if (str == null || str.indexOf(37) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        int i6 = 0;
        while (i6 < length) {
            if (str.charAt(i6) == '%') {
                while (true) {
                    i5 = i6 + 3;
                    try {
                        try {
                            byteBufferAllocate.put((byte) Integer.parseInt(str.substring(i6 + 1, i5), 16));
                            if (i5 >= length) {
                                break;
                            }
                            try {
                                if (str.charAt(i5) != '%') {
                                    break;
                                }
                                i6 = i5;
                            } catch (RuntimeException unused) {
                                i6 = i5;
                                if (byteBufferAllocate.position() > 0) {
                                    byteBufferAllocate.flip();
                                    sb.append(StandardCharsets.UTF_8.decode(byteBufferAllocate).toString());
                                    byteBufferAllocate.clear();
                                }
                                sb.append(str.charAt(i6));
                                i6++;
                            }
                        } catch (RuntimeException unused2) {
                        }
                    } catch (Throwable th) {
                        if (byteBufferAllocate.position() > 0) {
                            byteBufferAllocate.flip();
                            sb.append(StandardCharsets.UTF_8.decode(byteBufferAllocate).toString());
                            byteBufferAllocate.clear();
                        }
                        throw th;
                    }
                }
                if (byteBufferAllocate.position() > 0) {
                    byteBufferAllocate.flip();
                    sb.append(StandardCharsets.UTF_8.decode(byteBufferAllocate).toString());
                    byteBufferAllocate.clear();
                }
                i6 = i5;
            }
            sb.append(str.charAt(i6));
            i6++;
        }
        return sb.toString();
    }

    public static File delete(File file) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        Files.delete(file.toPath());
        return file;
    }

    public static void deleteDirectory(File file) throws IOException {
        Objects.requireNonNull(file, "directory");
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            delete(file);
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (isSymlink(file)) {
                return;
            }
            cleanDirectoryOnExit(file);
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean directoryContains(File file, File file2) {
        requireDirectoryExists(file, "directory");
        if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        }
        return false;
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, List<String> list, boolean z6, CopyOption... copyOptionArr) throws IOException {
        FileFilter fileFilter2;
        List<String> list2;
        boolean z7;
        CopyOption[] copyOptionArr2;
        File[] fileArrListFiles = listFiles(file, fileFilter);
        requireDirectoryIfExists(file2, "destDir");
        mkdirs(file2);
        requireCanWrite(file2, "destDir");
        int length = fileArrListFiles.length;
        int i5 = 0;
        while (i5 < length) {
            File file3 = fileArrListFiles[i5];
            File file4 = new File(file2, file3.getName());
            if (list != null && list.contains(file3.getCanonicalPath())) {
                fileFilter2 = fileFilter;
                list2 = list;
                z7 = z6;
                copyOptionArr2 = copyOptionArr;
            } else if (file3.isDirectory()) {
                fileFilter2 = fileFilter;
                list2 = list;
                z7 = z6;
                copyOptionArr2 = copyOptionArr;
                doCopyDirectory(file3, file4, fileFilter2, list2, z7, copyOptionArr2);
            } else {
                fileFilter2 = fileFilter;
                list2 = list;
                z7 = z6;
                copyOptionArr2 = copyOptionArr;
                copyFile(file3, file4, copyOptionArr2);
            }
            i5++;
            fileFilter = fileFilter2;
            list = list2;
            z6 = z7;
            copyOptionArr = copyOptionArr2;
        }
        if (z6) {
            setLastModified(file, file2);
        }
    }

    public static void forceDelete(File file) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        try {
            Counters.PathCounters pathCountersDelete = PathUtils.delete(file.toPath(), PathUtils.EMPTY_LINK_OPTION_ARRAY, StandardDeleteOption.OVERRIDE_READ_ONLY);
            if (pathCountersDelete.getFileCounter().get() < 1 && pathCountersDelete.getDirectoryCounter().get() < 1) {
                throw new FileNotFoundException(a.k(file, "File does not exist: "));
            }
        } catch (IOException e) {
            throw new IOException(a.k(file, "Cannot delete file: "), e);
        }
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    public static void forceMkdir(File file) throws IOException {
        mkdirs(file);
    }

    public static void forceMkdirParent(File file) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        File parentFile = getParentFile(file);
        if (parentFile == null) {
            return;
        }
        forceMkdir(parentFile);
    }

    public static File getFile(File file, String... strArr) {
        Objects.requireNonNull(file, "directory");
        Objects.requireNonNull(strArr, "names");
        int length = strArr.length;
        int i5 = 0;
        while (i5 < length) {
            File file2 = new File(file, strArr[i5]);
            i5++;
            file = file2;
        }
        return file;
    }

    private static File getParentFile(File file) {
        if (file == null) {
            return null;
        }
        return file.getParentFile();
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getTempDirectoryPath() {
        return System.getProperty(TempFile.JAVA_IO_TMPDIR);
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    public static boolean isDirectory(File file, LinkOption... linkOptionArr) {
        return file != null && Files.isDirectory(file.toPath(), linkOptionArr);
    }

    public static boolean isEmptyDirectory(File file) {
        return PathUtils.isEmptyDirectory(file.toPath());
    }

    public static boolean isFileNewer(File file, ChronoLocalDate chronoLocalDate) {
        return isFileNewer(file, chronoLocalDate, LocalTime.now());
    }

    public static boolean isFileOlder(File file, ChronoLocalDate chronoLocalDate) {
        return isFileOlder(file, chronoLocalDate, LocalTime.now());
    }

    public static boolean isRegularFile(File file, LinkOption... linkOptionArr) {
        return file != null && Files.isRegularFile(file.toPath(), linkOptionArr);
    }

    public static boolean isSymlink(File file) {
        return file != null && Files.isSymbolicLink(file.toPath());
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static long lastModified(File file) {
        Path path = file.toPath();
        Objects.requireNonNull(path, Constants.FILE);
        return Files.getLastModifiedTime(path, new LinkOption[0]).toMillis();
    }

    public static long lastModifiedUnchecked(File file) {
        try {
            return lastModified(file);
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static LineIterator lineIterator(File file) {
        return lineIterator(file, null);
    }

    private static AccumulatorPathVisitor listAccumulate(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) throws IOException {
        boolean z6 = iOFileFilter2 != null;
        IOFileFilter fileEqualsFileFilter = new FileEqualsFileFilter(file);
        if (z6) {
            fileEqualsFileFilter = fileEqualsFileFilter.or(iOFileFilter2);
        }
        AccumulatorPathVisitor accumulatorPathVisitor = new AccumulatorPathVisitor(Counters.noopPathCounters(), iOFileFilter, fileEqualsFileFilter);
        Files.walkFileTree(file.toPath(), Collections.EMPTY_SET, toMaxDepth(z6), accumulatorPathVisitor);
        return accumulatorPathVisitor;
    }

    private static File[] listFiles(File file, FileFilter fileFilter) throws IOException {
        requireDirectoryExists(file, "directory");
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (fileArrListFiles != null) {
            return fileArrListFiles;
        }
        throw new IOException(a.k(file, "Unknown I/O error listing contents of directory: "));
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        try {
            AccumulatorPathVisitor accumulatorPathVisitorListAccumulate = listAccumulate(file, iOFileFilter, iOFileFilter2);
            List<Path> fileList = accumulatorPathVisitorListAccumulate.getFileList();
            fileList.addAll(accumulatorPathVisitorListAccumulate.getDirList());
            return (Collection) fileList.stream().map(new g(9)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    private static File mkdirs(File file) throws IOException {
        if (file == null || file.mkdirs() || file.isDirectory()) {
            return file;
        }
        throw new IOException("Cannot create directory '" + file + "'.");
    }

    public static void moveDirectory(File file, File file2) throws IOException {
        validateMoveParameters(file, file2);
        requireDirectory(file, "srcDir");
        requireAbsent(file2, "destDir");
        if (file.renameTo(file2)) {
            return;
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
            throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
        copyDirectory(file, file2);
        deleteDirectory(file);
        if (file.exists()) {
            throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z6) throws IOException {
        validateMoveParameters(file, file2);
        if (!file2.isDirectory()) {
            if (file2.exists()) {
                throw new IOException("Destination '" + file2 + "' is not a directory");
            }
            if (!z6) {
                throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=false]");
            }
            mkdirs(file2);
        }
        moveDirectory(file, new File(file2, file.getName()));
    }

    public static void moveFile(File file, File file2) throws IOException {
        moveFile(file, file2, StandardCopyOption.COPY_ATTRIBUTES);
    }

    public static void moveFileToDirectory(File file, File file2, boolean z6) throws IOException {
        validateMoveParameters(file, file2);
        if (!file2.exists() && z6) {
            mkdirs(file2);
        }
        requireExistsChecked(file2, "destDir");
        requireDirectory(file2, "destDir");
        moveFile(file, new File(file2, file.getName()));
    }

    public static void moveToDirectory(File file, File file2, boolean z6) throws IOException {
        validateMoveParameters(file, file2);
        if (file.isDirectory()) {
            moveDirectoryToDirectory(file, file2, z6);
        } else {
            moveFileToDirectory(file, file2, z6);
        }
    }

    public static FileInputStream openInputStream(File file) {
        Objects.requireNonNull(file, Constants.FILE);
        return new FileInputStream(file);
    }

    public static FileOutputStream openOutputStream(File file) {
        return openOutputStream(file, false);
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream fileInputStreamOpenInputStream = openInputStream(file);
        try {
            long length = file.length();
            byte[] byteArray = length > 0 ? IOUtils.toByteArray(fileInputStreamOpenInputStream, length) : IOUtils.toByteArray(fileInputStreamOpenInputStream);
            if (fileInputStreamOpenInputStream != null) {
                fileInputStreamOpenInputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileInputStreamOpenInputStream != null) {
                    try {
                        fileInputStreamOpenInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static String readFileToString(File file) {
        return readFileToString(file, Charset.defaultCharset());
    }

    @Deprecated
    public static List<String> readLines(File file) {
        return readLines(file, Charset.defaultCharset());
    }

    private static void requireAbsent(File file, String str) throws FileExistsException {
        if (file.exists()) {
            throw new FileExistsException(String.format("File element in parameter '%s' already exists: '%s'", str, file));
        }
    }

    private static void requireCanWrite(File file, String str) {
        Objects.requireNonNull(file, Constants.FILE);
        if (file.canWrite()) {
            return;
        }
        throw new IllegalArgumentException("File parameter '" + str + " is not writable: '" + file + "'");
    }

    private static void requireCanonicalPathsNotEquals(File file, File file2) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (canonicalPath.equals(file2.getCanonicalPath())) {
            throw new IllegalArgumentException(String.format("File canonical paths are equal: '%s' (file1='%s', file2='%s')", canonicalPath, file, file2));
        }
    }

    private static File requireDirectory(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.isDirectory()) {
            return file;
        }
        throw new IllegalArgumentException("Parameter '" + str + "' is not a directory: '" + file + "'");
    }

    private static File requireDirectoryExists(File file, String str) {
        requireExists(file, str);
        requireDirectory(file, str);
        return file;
    }

    private static File requireDirectoryIfExists(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.exists()) {
            requireDirectory(file, str);
        }
        return file;
    }

    private static void requireEqualSizes(File file, File file2, long j6, long j7) throws IOException {
        if (j6 == j7) {
            return;
        }
        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + j6 + " Actual: " + j7);
    }

    private static File requireExists(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.exists()) {
            return file;
        }
        throw new IllegalArgumentException("File system element for parameter '" + str + "' does not exist: '" + file + "'");
    }

    private static File requireExistsChecked(File file, String str) throws FileNotFoundException {
        Objects.requireNonNull(file, str);
        if (file.exists()) {
            return file;
        }
        throw new FileNotFoundException("File system element for parameter '" + str + "' does not exist: '" + file + "'");
    }

    private static File requireFile(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.isFile()) {
            return file;
        }
        throw new IllegalArgumentException("Parameter '" + str + "' is not a file: " + file);
    }

    private static void requireFileCopy(File file, File file2) throws FileNotFoundException {
        requireExistsChecked(file, FirebaseAnalytics.Param.SOURCE);
        Objects.requireNonNull(file2, FirebaseAnalytics.Param.DESTINATION);
    }

    private static File requireFileIfExists(File file, String str) {
        Objects.requireNonNull(file, str);
        return file.exists() ? requireFile(file, str) : file;
    }

    private static void setLastModified(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "sourceFile");
        setLastModified(file2, lastModified(file));
    }

    public static long sizeOf(File file) {
        requireExists(file, Constants.FILE);
        return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
    }

    private static long sizeOf0(File file) {
        Objects.requireNonNull(file, Constants.FILE);
        return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        requireExists(file, Constants.FILE);
        return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
    }

    private static BigInteger sizeOfBig0(File file) {
        Objects.requireNonNull(file, "fileOrDir");
        return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
    }

    public static long sizeOfDirectory(File file) {
        return sizeOfDirectory0(requireDirectoryExists(file, "directory"));
    }

    private static long sizeOfDirectory0(File file) {
        Objects.requireNonNull(file, "directory");
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        long jSizeOf0 = 0;
        for (File file2 : fileArrListFiles) {
            if (!isSymlink(file2)) {
                jSizeOf0 += sizeOf0(file2);
                if (jSizeOf0 < 0) {
                    return jSizeOf0;
                }
            }
        }
        return jSizeOf0;
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        return sizeOfDirectoryBig0(requireDirectoryExists(file, "directory"));
    }

    private static BigInteger sizeOfDirectoryBig0(File file) {
        Objects.requireNonNull(file, "directory");
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (File file2 : fileArrListFiles) {
            if (!isSymlink(file2)) {
                bigIntegerAdd = bigIntegerAdd.add(sizeOfBig0(file2));
            }
        }
        return bigIntegerAdd;
    }

    public static Stream<File> streamFiles(File file, boolean z6, String... strArr) {
        return PathUtils.walk(file.toPath(), strArr == null ? FileFileFilter.INSTANCE : FileFileFilter.INSTANCE.and(new SuffixFileFilter(toSuffixes(strArr))), toMaxDepth(z6), false, FileVisitOption.FOLLOW_LINKS).map(new g(9));
    }

    public static File toFile(URL url) {
        if (url == null || !Constants.FILE.equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace('/', File.separatorChar)));
    }

    public static File[] toFiles(URL... urlArr) {
        if (IOUtils.length(urlArr) == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i5 = 0; i5 < urlArr.length; i5++) {
            URL url = urlArr[i5];
            if (url != null) {
                if (!Constants.FILE.equalsIgnoreCase(url.getProtocol())) {
                    throw new IllegalArgumentException("Can only convert file URL to a File: " + url);
                }
                fileArr[i5] = toFile(url);
            }
        }
        return fileArr;
    }

    private static List<File> toList(Stream<File> stream) {
        return (List) stream.collect(Collectors.toList());
    }

    private static int toMaxDepth(boolean z6) {
        return z6 ? Integer.MAX_VALUE : 1;
    }

    private static String[] toSuffixes(String... strArr) {
        Objects.requireNonNull(strArr, "extensions");
        String[] strArr2 = new String[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            strArr2[i5] = Consts.DOT + strArr[i5];
        }
        return strArr2;
    }

    public static URL[] toURLs(File... fileArr) {
        Objects.requireNonNull(fileArr, "files");
        int length = fileArr.length;
        URL[] urlArr = new URL[length];
        for (int i5 = 0; i5 < length; i5++) {
            urlArr[i5] = fileArr[i5].toURI().toURL();
        }
        return urlArr;
    }

    public static void touch(File file) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        if (!file.exists()) {
            openOutputStream(file).close();
        }
        setLastModified(file, System.currentTimeMillis());
    }

    private static void validateMoveParameters(File file, File file2) throws FileNotFoundException {
        Objects.requireNonNull(file, FirebaseAnalytics.Param.SOURCE);
        Objects.requireNonNull(file2, FirebaseAnalytics.Param.DESTINATION);
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static boolean waitFor(File file, int i5) {
        Objects.requireNonNull(file, Constants.FILE);
        long jCurrentTimeMillis = (((long) i5) * 1000) + System.currentTimeMillis();
        boolean z6 = false;
        while (!file.exists()) {
            try {
                long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
                if (jCurrentTimeMillis2 < 0) {
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                try {
                    Thread.sleep(Math.min(100L, jCurrentTimeMillis2));
                } catch (InterruptedException unused) {
                    z6 = true;
                } catch (Exception unused2) {
                }
            } catch (Throwable th) {
                if (z6) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeLines(File file, Collection<?> collection) throws IOException {
        writeLines(file, null, collection, null, false);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    public static void copyDirectory(File file, File file2, boolean z6) throws IOException {
        copyDirectory(file, file2, null, z6);
    }

    public static void copyFile(File file, File file2, boolean z6) throws IOException {
        copyFile(file, file2, z6 ? new CopyOption[]{StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
    }

    public static void copyFileToDirectory(File file, File file2, boolean z6) throws IOException {
        Objects.requireNonNull(file, "sourceFile");
        requireDirectoryIfExists(file2, "destinationDir");
        copyFile(file, new File(file2, file.getName()), z6);
    }

    public static boolean isFileNewer(File file, ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Objects.requireNonNull(chronoLocalDate, "chronoLocalDate");
        Objects.requireNonNull(localTime, "localTime");
        return isFileNewer(file, chronoLocalDate.atTime(localTime));
    }

    public static boolean isFileOlder(File file, ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Objects.requireNonNull(chronoLocalDate, "chronoLocalDate");
        Objects.requireNonNull(localTime, "localTime");
        return isFileOlder(file, chronoLocalDate.atTime(localTime));
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z6) {
        try {
            return StreamIterator.iterator(streamFiles(file, z6, strArr));
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static LineIterator lineIterator(File file, String str) {
        FileInputStream fileInputStreamOpenInputStream = null;
        try {
            fileInputStreamOpenInputStream = openInputStream(file);
            return IOUtils.lineIterator(fileInputStreamOpenInputStream, str);
        } catch (IOException | RuntimeException e) {
            IOUtils.closeQuietly(fileInputStreamOpenInputStream, new d2(e, 5));
            throw e;
        }
    }

    public static void moveFile(File file, File file2, CopyOption... copyOptionArr) throws IOException {
        validateMoveParameters(file, file2);
        requireFile(file, "srcFile");
        requireAbsent(file2, null);
        if (file.renameTo(file2)) {
            return;
        }
        copyFile(file, file2, copyOptionArr);
        if (file.delete()) {
            return;
        }
        deleteQuietly(file2);
        throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    public static FileOutputStream openOutputStream(File file, boolean z6) {
        Objects.requireNonNull(file, Constants.FILE);
        if (file.exists()) {
            requireFile(file, Constants.FILE);
            requireCanWrite(file, Constants.FILE);
        } else {
            createParentDirectories(file);
        }
        return new FileOutputStream(file, z6);
    }

    public static String readFileToString(File file, Charset charset) throws IOException {
        FileInputStream fileInputStreamOpenInputStream = openInputStream(file);
        try {
            String string = IOUtils.toString(fileInputStreamOpenInputStream, Charsets.toCharset(charset));
            if (fileInputStreamOpenInputStream != null) {
                fileInputStreamOpenInputStream.close();
            }
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileInputStreamOpenInputStream != null) {
                    try {
                        fileInputStreamOpenInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        FileInputStream fileInputStreamOpenInputStream = openInputStream(file);
        try {
            List<String> lines = IOUtils.readLines(fileInputStreamOpenInputStream, Charsets.toCharset(charset));
            if (fileInputStreamOpenInputStream != null) {
                fileInputStreamOpenInputStream.close();
            }
            return lines;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileInputStreamOpenInputStream != null) {
                    try {
                        fileInputStreamOpenInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence, boolean z6) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), z6);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z6) throws IOException {
        writeByteArrayToFile(file, bArr, 0, bArr.length, z6);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z6) throws IOException {
        writeLines(file, null, collection, null, z6);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str, boolean z6) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), z6);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) throws IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyFile(File file, File file2, boolean z6, CopyOption... copyOptionArr) throws IOException {
        if (z6) {
            copyOptionArr = addCopyAttributes(copyOptionArr);
        }
        copyFile(file, file2, copyOptionArr);
    }

    private static void setLastModified(File file, long j6) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        if (!file.setLastModified(j6)) {
            throw new IOException(String.format("Failed setLastModified(%s) on '%s'", Long.valueOf(j6), file));
        }
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws IOException {
        write(file, charSequence, charset, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i5, int i6) throws IOException {
        writeByteArrayToFile(file, bArr, i5, i6, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str) throws IOException {
        writeLines(file, null, collection, str, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z6) throws IOException {
        copyDirectory(file, file2, fileFilter, z6, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFile(File file, File file2, CopyOption... copyOptionArr) throws IOException {
        requireFileCopy(file, file2);
        requireFile(file, "srcFile");
        requireCanonicalPathsNotEquals(file, file2);
        createParentDirectories(file2);
        requireFileIfExists(file2, "destFile");
        if (file2.exists()) {
            requireCanWrite(file2, "destFile");
        }
        Files.copy(file.toPath(), file2.toPath(), copyOptionArr);
        requireEqualSizes(file, file2, file.length(), file2.length());
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z6) throws IOException {
        writeStringToFile(file, Objects.toString(charSequence, null), charset, z6);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i5, int i6, boolean z6) throws IOException {
        FileOutputStream fileOutputStreamOpenOutputStream = openOutputStream(file, z6);
        try {
            fileOutputStreamOpenOutputStream.write(bArr, i5, i6);
            fileOutputStreamOpenOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileOutputStreamOpenOutputStream != null) {
                    try {
                        fileOutputStreamOpenOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z6) throws IOException {
        writeLines(file, null, collection, str, z6);
    }

    public static void writeStringToFile(File file, String str, Charset charset, boolean z6) throws IOException {
        FileOutputStream fileOutputStreamOpenOutputStream = openOutputStream(file, z6);
        try {
            IOUtils.write(str, (OutputStream) fileOutputStreamOpenOutputStream, charset);
            if (fileOutputStreamOpenOutputStream != null) {
                fileOutputStreamOpenOutputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileOutputStreamOpenOutputStream != null) {
                    try {
                        fileOutputStreamOpenOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0041  */
    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z6, CopyOption... copyOptionArr) throws IOException {
        ArrayList arrayList;
        requireFileCopy(file, file2);
        requireDirectory(file, "srcDir");
        requireCanonicalPathsNotEquals(file, file2);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            File[] fileArrListFiles = listFiles(file, fileFilter);
            if (fileArrListFiles.length > 0) {
                arrayList = new ArrayList(fileArrListFiles.length);
                for (File file3 : fileArrListFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
            } else {
                arrayList = null;
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (z6) {
            copyOptionArr = addCopyAttributes(copyOptionArr);
        }
        doCopyDirectory(file, file2, fileFilter, arrayList2, z6, copyOptionArr);
    }

    public static File getFile(String... strArr) {
        Objects.requireNonNull(strArr, "names");
        File file = null;
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static boolean isFileNewer(File file, ChronoLocalDateTime<?> chronoLocalDateTime) {
        return isFileNewer(file, chronoLocalDateTime, ZoneId.systemDefault());
    }

    public static boolean isFileOlder(File file, ChronoLocalDateTime<?> chronoLocalDateTime) {
        return isFileOlder(file, chronoLocalDateTime, ZoneId.systemDefault());
    }

    public static void write(File file, CharSequence charSequence, String str) throws IOException {
        write(file, charSequence, str, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection) throws IOException {
        writeLines(file, str, collection, null, false);
    }

    public static void copyURLToFile(URL url, File file, int i5, int i6) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        uRLConnectionOpenConnection.setConnectTimeout(i5);
        uRLConnectionOpenConnection.setReadTimeout(i6);
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            copyInputStreamToFile(inputStream, file);
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

    public static boolean isFileNewer(File file, ChronoLocalDateTime<?> chronoLocalDateTime, ZoneId zoneId) {
        Objects.requireNonNull(chronoLocalDateTime, "chronoLocalDateTime");
        Objects.requireNonNull(zoneId, "zoneId");
        return isFileNewer(file, (ChronoZonedDateTime<?>) chronoLocalDateTime.atZone(zoneId));
    }

    public static boolean isFileOlder(File file, ChronoLocalDateTime<?> chronoLocalDateTime, ZoneId zoneId) {
        Objects.requireNonNull(chronoLocalDateTime, "chronoLocalDateTime");
        Objects.requireNonNull(zoneId, "zoneId");
        return isFileOlder(file, (ChronoZonedDateTime<?>) chronoLocalDateTime.atZone(zoneId));
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z6) throws IOException {
        write(file, charSequence, Charsets.toCharset(str), z6);
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z6) throws IOException {
        writeLines(file, str, collection, null, z6);
    }

    public static void copyToDirectory(Iterable<File> iterable, File file) throws IOException {
        Objects.requireNonNull(iterable, "sourceIterable");
        Iterator<File> it = iterable.iterator();
        while (it.hasNext()) {
            copyFileToDirectory(it.next(), file);
        }
    }

    public static String readFileToString(File file, String str) {
        return readFileToString(file, Charsets.toCharset(str));
    }

    public static List<String> readLines(File file, String str) {
        return readLines(file, Charsets.toCharset(str));
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) throws IOException {
        writeLines(file, str, collection, str2, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2, boolean z6) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(openOutputStream(file, z6));
        try {
            IOUtils.writeLines(collection, str2, bufferedOutputStream, str);
            bufferedOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static boolean isFileNewer(File file, ChronoZonedDateTime<?> chronoZonedDateTime) {
        Objects.requireNonNull(chronoZonedDateTime, "chronoZonedDateTime");
        return isFileNewer(file, chronoZonedDateTime.toInstant());
    }

    public static boolean isFileOlder(File file, ChronoZonedDateTime<?> chronoZonedDateTime) {
        Objects.requireNonNull(chronoZonedDateTime, "chronoZonedDateTime");
        return isFileOlder(file, chronoZonedDateTime.toInstant());
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        writeStringToFile(file, str, str2, false);
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        try {
            return (Collection) listAccumulate(file, iOFileFilter, iOFileFilter2).getFileList().stream().map(new g(9)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z6) throws IOException {
        writeStringToFile(file, str, Charsets.toCharset(str2), z6);
    }

    public static boolean isFileNewer(File file, Date date) {
        Objects.requireNonNull(date, XmlErrorCodes.DATE);
        return isFileNewer(file, date.getTime());
    }

    public static boolean isFileOlder(File file, Date date) {
        Objects.requireNonNull(date, XmlErrorCodes.DATE);
        return isFileOlder(file, date.getTime());
    }

    public static long copyFile(File file, OutputStream outputStream) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            long jCopyLarge = IOUtils.copyLarge(inputStreamNewInputStream, outputStream);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return jCopyLarge;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static boolean isFileNewer(File file, File file2) {
        requireExists(file2, TypedValues.Custom.S_REFERENCE);
        return isFileNewer(file, lastModifiedUnchecked(file2));
    }

    public static boolean isFileOlder(File file, File file2) {
        requireExists(file2, TypedValues.Custom.S_REFERENCE);
        return isFileOlder(file, lastModifiedUnchecked(file2));
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z6) {
        try {
            return toList(streamFiles(file, z6, strArr));
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static String byteCountToDisplaySize(long j6) {
        return byteCountToDisplaySize(BigInteger.valueOf(j6));
    }

    public static boolean isFileNewer(File file, Instant instant) {
        Objects.requireNonNull(instant, "instant");
        return isFileNewer(file, instant.toEpochMilli());
    }

    public static boolean isFileOlder(File file, Instant instant) {
        Objects.requireNonNull(instant, "instant");
        return isFileOlder(file, instant.toEpochMilli());
    }

    public static boolean isFileNewer(File file, long j6) {
        Objects.requireNonNull(file, Constants.FILE);
        return file.exists() && lastModifiedUnchecked(file) > j6;
    }

    public static boolean isFileOlder(File file, long j6) {
        Objects.requireNonNull(file, Constants.FILE);
        return file.exists() && lastModifiedUnchecked(file) < j6;
    }
}
