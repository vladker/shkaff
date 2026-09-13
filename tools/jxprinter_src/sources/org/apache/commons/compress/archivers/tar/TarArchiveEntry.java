package org.apache.commons.compress.archivers.tar;

import A3.AbstractC0157z;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TarArchiveEntry implements ArchiveEntry, TarConstants, EntryStreamOffsets {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRY_ARRAY = new TarArchiveEntry[0];
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final long UNKNOWN = -1;
    private boolean checkSumOK;
    private long dataOffset;
    private int devMajor;
    private int devMinor;
    private final Map<String, String> extraPaxHeaders;
    private final Path file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private final LinkOption[] linkOptions;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private boolean paxGNU1XSparse;
    private boolean paxGNUSparse;
    private final boolean preserveAbsolutePath;
    private long realSize;
    private long size;
    private List<TarArchiveStructSparse> sparseHeaders;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    private TarArchiveEntry(boolean z6) {
        this.name = "";
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.extraPaxHeaders = new HashMap();
        this.dataOffset = -1L;
        String property = System.getProperty("user.name", "");
        this.userName = property.length() > 31 ? property.substring(0, 31) : property;
        this.file = null;
        this.linkOptions = IOUtils.EMPTY_LINK_OPTIONS;
        this.preserveAbsolutePath = z6;
    }

    private int evaluateType(byte[] bArr) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, 257, 6)) {
            return 2;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6)) {
            return ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_XSTAR, bArr, 508, 4) ? 4 : 3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getOrderedSparseHeaders$0(TarArchiveStructSparse tarArchiveStructSparse) {
        return tarArchiveStructSparse.getOffset() > 0 || tarArchiveStructSparse.getNumbytes() > 0;
    }

    private static String normalizeFileName(String str, boolean z6) {
        String lowerCase;
        int iIndexOf;
        if (!z6 && (lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char cCharAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (iIndexOf = str.indexOf(58)) != -1) {
                str = str.substring(iIndexOf + 1);
            }
        }
        String strReplace = str.replace(File.separatorChar, '/');
        while (!z6 && strReplace.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            strReplace = strReplace.substring(1);
        }
        return strReplace;
    }

    private long parseOctalOrBinary(byte[] bArr, int i5, int i6, boolean z6) {
        if (!z6) {
            return TarUtils.parseOctalOrBinary(bArr, i5, i6);
        }
        try {
            return TarUtils.parseOctalOrBinary(bArr, i5, i6);
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private void parseTarHeaderUnwrapped(byte[] bArr, ZipEncoding zipEncoding, boolean z6, boolean z7) throws IOException {
        this.name = z6 ? TarUtils.parseName(bArr, 0, 100) : TarUtils.parseName(bArr, 0, 100, zipEncoding);
        this.mode = (int) parseOctalOrBinary(bArr, 100, 8, z7);
        this.userId = (int) parseOctalOrBinary(bArr, 108, 8, z7);
        this.groupId = (int) parseOctalOrBinary(bArr, 116, 8, z7);
        long octalOrBinary = TarUtils.parseOctalOrBinary(bArr, 124, 12);
        this.size = octalOrBinary;
        if (octalOrBinary < 0) {
            throw new IOException("broken archive, entry with negative size");
        }
        this.modTime = parseOctalOrBinary(bArr, 136, 12, z7);
        this.checkSumOK = TarUtils.verifyCheckSum(bArr);
        this.linkFlag = bArr[156];
        this.linkName = z6 ? TarUtils.parseName(bArr, 157, 100) : TarUtils.parseName(bArr, 157, 100, zipEncoding);
        this.magic = TarUtils.parseName(bArr, 257, 6);
        this.version = TarUtils.parseName(bArr, 263, 2);
        this.userName = z6 ? TarUtils.parseName(bArr, 265, 32) : TarUtils.parseName(bArr, 265, 32, zipEncoding);
        this.groupName = z6 ? TarUtils.parseName(bArr, 297, 32) : TarUtils.parseName(bArr, 297, 32, zipEncoding);
        byte b = this.linkFlag;
        if (b == 51 || b == 52) {
            this.devMajor = (int) parseOctalOrBinary(bArr, 329, 8, z7);
            this.devMinor = (int) parseOctalOrBinary(bArr, 337, 8, z7);
        }
        int iEvaluateType = evaluateType(bArr);
        if (iEvaluateType == 2) {
            this.sparseHeaders = new ArrayList(TarUtils.readSparseStructs(bArr, 386, 4));
            this.isExtended = TarUtils.parseBoolean(bArr, Videoio.CAP_PROP_XI_CC_MATRIX_03);
            this.realSize = TarUtils.parseOctal(bArr, Videoio.CAP_PROP_XI_CC_MATRIX_10, 12);
            return;
        }
        if (iEvaluateType == 4) {
            String name = z6 ? TarUtils.parseName(bArr, 345, 131) : TarUtils.parseName(bArr, 345, 131, zipEncoding);
            if (name.isEmpty()) {
                return;
            }
            StringBuilder sbX = AbstractC0157z.x(name, PackagingURIHelper.FORWARD_SLASH_STRING);
            sbX.append(this.name);
            this.name = sbX.toString();
            return;
        }
        String name2 = z6 ? TarUtils.parseName(bArr, 345, 155) : TarUtils.parseName(bArr, 345, 155, zipEncoding);
        if (isDirectory() && !this.name.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            this.name = AbstractC0157z.s(new StringBuilder(), this.name, PackagingURIHelper.FORWARD_SLASH_STRING);
        }
        if (name2.isEmpty()) {
            return;
        }
        StringBuilder sbX2 = AbstractC0157z.x(name2, PackagingURIHelper.FORWARD_SLASH_STRING);
        sbX2.append(this.name);
        this.name = sbX2.toString();
    }

    private void processPaxHeader(String str, String str2) throws IOException {
        processPaxHeader(str, str2, this.extraPaxHeaders);
    }

    private void readFileMode(Path path, String str, LinkOption... linkOptionArr) {
        if (!Files.isDirectory(path, linkOptionArr)) {
            this.mode = DEFAULT_FILE_MODE;
            this.linkFlag = TarConstants.LF_NORMAL;
            this.name = str;
            this.size = Files.size(path);
            return;
        }
        this.mode = DEFAULT_DIR_MODE;
        this.linkFlag = TarConstants.LF_DIR;
        int length = str.length();
        if (length == 0 || str.charAt(length - 1) != '/') {
            this.name = str.concat(PackagingURIHelper.FORWARD_SLASH_STRING);
        } else {
            this.name = str;
        }
    }

    private void readOsSpecificProperties(Path path, LinkOption... linkOptionArr) {
        Set<String> setSupportedFileAttributeViews = path.getFileSystem().supportedFileAttributeViews();
        if (!setSupportedFileAttributeViews.contains("posix")) {
            if (setSupportedFileAttributeViews.contains("dos")) {
                setModTime(((DosFileAttributes) Files.readAttributes(path, DosFileAttributes.class, linkOptionArr)).lastModifiedTime());
                this.userName = Files.getOwner(path, linkOptionArr).getName();
                return;
            } else {
                setModTime(Files.readAttributes(path, BasicFileAttributes.class, linkOptionArr).lastModifiedTime());
                this.userName = Files.getOwner(path, linkOptionArr).getName();
                return;
            }
        }
        PosixFileAttributes posixFileAttributes = (PosixFileAttributes) Files.readAttributes(path, PosixFileAttributes.class, linkOptionArr);
        setModTime(posixFileAttributes.lastModifiedTime());
        this.userName = posixFileAttributes.owner().getName();
        this.groupName = posixFileAttributes.group().getName();
        if (setSupportedFileAttributeViews.contains("unix")) {
            this.userId = ((Number) Files.getAttribute(path, "unix:uid", linkOptionArr)).longValue();
            this.groupId = ((Number) Files.getAttribute(path, "unix:gid", linkOptionArr)).longValue();
        }
    }

    private int writeEntryHeaderField(long j6, byte[] bArr, int i5, int i6, boolean z6) {
        return (z6 || (j6 >= 0 && j6 < (1 << ((i6 + (-1)) * 3)))) ? TarUtils.formatLongOctalOrBinaryBytes(j6, bArr, i5, i6) : TarUtils.formatLongOctalBytes(0L, bArr, i5, i6);
    }

    public void addPaxHeader(String str, String str2) {
        try {
            processPaxHeader(str, str2);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid input", e);
        }
    }

    public void clearExtraPaxHeaders() {
        this.extraPaxHeaders.clear();
    }

    public boolean equals(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry != null && getName().equals(tarArchiveEntry.getName());
    }

    public void fillGNUSparse0xData(Map<String, String> map) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.name = map.get("GNU.sparse.name");
        }
    }

    public void fillGNUSparse1xData(Map<String, String> map) throws IOException {
        this.paxGNUSparse = true;
        this.paxGNU1XSparse = true;
        if (map.containsKey("GNU.sparse.name")) {
            this.name = map.get("GNU.sparse.name");
        }
        if (map.containsKey("GNU.sparse.realsize")) {
            try {
                this.realSize = Integer.parseInt(map.get("GNU.sparse.realsize"));
            } catch (NumberFormatException unused) {
                throw new IOException(AbstractC0157z.s(new StringBuilder("Corrupted TAR archive. GNU.sparse.realsize header for "), this.name, " contains non-numeric value"));
            }
        }
    }

    public void fillStarSparseData(Map<String, String> map) throws IOException {
        this.starSparse = true;
        if (map.containsKey("SCHILY.realsize")) {
            try {
                this.realSize = Long.parseLong(map.get("SCHILY.realsize"));
            } catch (NumberFormatException unused) {
                throw new IOException(AbstractC0157z.s(new StringBuilder("Corrupted TAR archive. SCHILY.realsize header for "), this.name, " contains non-numeric value"));
            }
        }
    }

    @Override // org.apache.commons.compress.archivers.EntryStreamOffsets
    public long getDataOffset() {
        return this.dataOffset;
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    public TarArchiveEntry[] getDirectoryEntries() {
        if (this.file == null || !isDirectory()) {
            return EMPTY_TAR_ARCHIVE_ENTRY_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        try {
            DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(this.file);
            try {
                Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
                while (it.hasNext()) {
                    arrayList.add(new TarArchiveEntry(it.next()));
                }
                directoryStreamNewDirectoryStream.close();
                return (TarArchiveEntry[]) arrayList.toArray(EMPTY_TAR_ARCHIVE_ENTRY_ARRAY);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (directoryStreamNewDirectoryStream != null) {
                        try {
                            directoryStreamNewDirectoryStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return EMPTY_TAR_ARCHIVE_ENTRY_ARRAY;
        }
    }

    public String getExtraPaxHeader(String str) {
        return this.extraPaxHeaders.get(str);
    }

    public Map<String, String> getExtraPaxHeaders() {
        return Collections.unmodifiableMap(this.extraPaxHeaders);
    }

    public File getFile() {
        Path path = this.file;
        if (path == null) {
            return null;
        }
        return path.toFile();
    }

    @Deprecated
    public int getGroupId() {
        return (int) this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return getModTime();
    }

    public String getLinkName() {
        return this.linkName;
    }

    public long getLongGroupId() {
        return this.groupId;
    }

    public long getLongUserId() {
        return this.userId;
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    public int getMode() {
        return this.mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public List<TarArchiveStructSparse> getOrderedSparseHeaders() throws IOException {
        List<TarArchiveStructSparse> list = this.sparseHeaders;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<TarArchiveStructSparse> list2 = (List) this.sparseHeaders.stream().filter(new a(0)).sorted(Comparator.comparingLong(new org.apache.commons.compress.archivers.sevenz.a(1))).collect(Collectors.toList());
        int size = list2.size();
        int i5 = 0;
        while (i5 < size) {
            TarArchiveStructSparse tarArchiveStructSparse = list2.get(i5);
            i5++;
            if (i5 < size) {
                if (tarArchiveStructSparse.getNumbytes() + tarArchiveStructSparse.getOffset() > list2.get(i5).getOffset()) {
                    throw new IOException("Corrupted TAR archive. Sparse blocks for " + getName() + " overlap each other.");
                }
            }
            if (tarArchiveStructSparse.getNumbytes() + tarArchiveStructSparse.getOffset() < 0) {
                throw new IOException("Unreadable TAR archive. Offset and numbytes for sparse block in " + getName() + " too large.");
            }
        }
        if (!list2.isEmpty()) {
            TarArchiveStructSparse tarArchiveStructSparse2 = list2.get(size - 1);
            if (tarArchiveStructSparse2.getNumbytes() + tarArchiveStructSparse2.getOffset() > getRealSize()) {
                throw new IOException("Corrupted TAR archive. Sparse block extends beyond real size of the entry");
            }
        }
        return list2;
    }

    public Path getPath() {
        return this.file;
    }

    public long getRealSize() {
        return !isSparse() ? getSize() : this.realSize;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public List<TarArchiveStructSparse> getSparseHeaders() {
        return this.sparseHeaders;
    }

    @Deprecated
    public int getUserId() {
        return (int) this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isBlockDevice() {
        return this.linkFlag == 52;
    }

    public boolean isCharacterDevice() {
        return this.linkFlag == 51;
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public boolean isDescendent(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry.getName().startsWith(getName());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        Path path = this.file;
        if (path != null) {
            return Files.isDirectory(path, this.linkOptions);
        }
        if (this.linkFlag == 53) {
            return true;
        }
        return (isPaxHeader() || isGlobalPaxHeader() || !getName().endsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) ? false : true;
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public boolean isFIFO() {
        return this.linkFlag == 54;
    }

    public boolean isFile() {
        Path path = this.file;
        if (path != null) {
            return Files.isRegularFile(path, this.linkOptions);
        }
        byte b = this.linkFlag;
        if (b == 0 || b == 48) {
            return true;
        }
        return !getName().endsWith(PackagingURIHelper.FORWARD_SLASH_STRING);
    }

    public boolean isGNULongLinkEntry() {
        return this.linkFlag == 75;
    }

    public boolean isGNULongNameEntry() {
        return this.linkFlag == 76;
    }

    public boolean isGNUSparse() {
        return isOldGNUSparse() || isPaxGNUSparse();
    }

    public boolean isGlobalPaxHeader() {
        return this.linkFlag == 103;
    }

    public boolean isLink() {
        return this.linkFlag == 49;
    }

    public boolean isOldGNUSparse() {
        return this.linkFlag == 83;
    }

    public boolean isPaxGNU1XSparse() {
        return this.paxGNU1XSparse;
    }

    public boolean isPaxGNUSparse() {
        return this.paxGNUSparse;
    }

    public boolean isPaxHeader() {
        byte b = this.linkFlag;
        return b == 120 || b == 88;
    }

    public boolean isSparse() {
        return isGNUSparse() || isStarSparse();
    }

    public boolean isStarSparse() {
        return this.starSparse;
    }

    @Override // org.apache.commons.compress.archivers.EntryStreamOffsets
    public boolean isStreamContiguous() {
        return true;
    }

    public boolean isSymbolicLink() {
        return this.linkFlag == 50;
    }

    public void parseTarHeader(byte[] bArr) {
        try {
            try {
                parseTarHeader(bArr, TarUtils.DEFAULT_ENCODING);
            } catch (IOException unused) {
                parseTarHeader(bArr, TarUtils.DEFAULT_ENCODING, true, false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataOffset(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("The offset can not be smaller than 0");
        }
        this.dataOffset = j6;
    }

    public void setDevMajor(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Major device number is out of range: "));
        }
        this.devMajor = i5;
    }

    public void setDevMinor(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Minor device number is out of range: "));
        }
        this.devMinor = i5;
    }

    public void setGroupId(int i5) {
        setGroupId(i5);
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIds(int i5, int i6) {
        setUserId(i5);
        setGroupId(i6);
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    public void setModTime(long j6) {
        this.modTime = j6 / 1000;
    }

    public void setMode(int i5) {
        this.mode = i5;
    }

    public void setName(String str) {
        this.name = normalizeFileName(str, this.preserveAbsolutePath);
    }

    public void setNames(String str, String str2) {
        setUserName(str);
        setGroupName(str2);
    }

    public void setSize(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Size is out of range: "));
        }
        this.size = j6;
    }

    public void setSparseHeaders(List<TarArchiveStructSparse> list) {
        this.sparseHeaders = list;
    }

    public void setUserId(int i5) {
        setUserId(i5);
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void updateEntryFromPaxHeaders(Map<String, String> map) throws IOException {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            processPaxHeader(entry.getKey(), entry.getValue(), map);
        }
    }

    public void writeEntryHeader(byte[] bArr) {
        try {
            try {
                writeEntryHeader(bArr, TarUtils.DEFAULT_ENCODING, false);
            } catch (IOException unused) {
                writeEntryHeader(bArr, TarUtils.FALLBACK_ENCODING, false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processPaxHeader(String str, String str2, Map<String, String> map) throws IOException {
        str.getClass();
        switch (str) {
            case "SCHILY.devmajor":
                int i5 = Integer.parseInt(str2);
                if (i5 < 0) {
                    throw new IOException("Corrupted TAR archive. Dev-Major is negative");
                }
                setDevMajor(i5);
                return;
            case "SCHILY.devminor":
                int i6 = Integer.parseInt(str2);
                if (i6 < 0) {
                    throw new IOException("Corrupted TAR archive. Dev-Minor is negative");
                }
                setDevMinor(i6);
                return;
            case "GNU.sparse.realsize":
                fillGNUSparse1xData(map);
                return;
            case "GNU.sparse.size":
                fillGNUSparse0xData(map);
                return;
            case "gid":
                setGroupId(Long.parseLong(str2));
                return;
            case "uid":
                setUserId(Long.parseLong(str2));
                return;
            case "path":
                setName(str2);
                return;
            case "size":
                long j6 = Long.parseLong(str2);
                if (j6 < 0) {
                    throw new IOException("Corrupted TAR archive. Entry size is negative");
                }
                setSize(j6);
                return;
            case "gname":
                setGroupName(str2);
                return;
            case "mtime":
                setModTime((long) (Double.parseDouble(str2) * 1000.0d));
                return;
            case "uname":
                setUserName(str2);
                return;
            case "SCHILY.filetype":
                if ("sparse".equals(str2)) {
                    fillStarSparseData(map);
                    return;
                }
                return;
            case "linkpath":
                setLinkName(str2);
                return;
            default:
                this.extraPaxHeaders.put(str, str2);
                return;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((TarArchiveEntry) obj);
    }

    public void setGroupId(long j6) {
        this.groupId = j6;
    }

    public void setModTime(Date date) {
        this.modTime = date.getTime() / 1000;
    }

    public void setUserId(long j6) {
        this.userId = j6;
    }

    public void setModTime(FileTime fileTime) {
        this.modTime = fileTime.to(TimeUnit.SECONDS);
    }

    public void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        parseTarHeader(bArr, zipEncoding, false, false);
    }

    public void writeEntryHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z6) {
        int iWriteEntryHeaderField = writeEntryHeaderField(this.modTime, bArr, writeEntryHeaderField(this.size, bArr, writeEntryHeaderField(this.groupId, bArr, writeEntryHeaderField(this.userId, bArr, writeEntryHeaderField(this.mode, bArr, TarUtils.formatNameBytes(this.name, bArr, 0, 100, zipEncoding), 8, z6), 8, z6), 8, z6), 12, z6), 12, z6);
        int i5 = 0;
        int i6 = iWriteEntryHeaderField;
        while (i5 < 8) {
            bArr[i6] = 32;
            i5++;
            i6++;
        }
        bArr[i6] = this.linkFlag;
        for (int iWriteEntryHeaderField2 = writeEntryHeaderField(this.devMinor, bArr, writeEntryHeaderField(this.devMajor, bArr, TarUtils.formatNameBytes(this.groupName, bArr, TarUtils.formatNameBytes(this.userName, bArr, TarUtils.formatNameBytes(this.version, bArr, TarUtils.formatNameBytes(this.magic, bArr, TarUtils.formatNameBytes(this.linkName, bArr, i6 + 1, 100, zipEncoding), 6), 2), 32, zipEncoding), 32, zipEncoding), 8, z6), 8, z6); iWriteEntryHeaderField2 < bArr.length; iWriteEntryHeaderField2++) {
            bArr[iWriteEntryHeaderField2] = 0;
        }
        TarUtils.formatCheckSumOctalBytes(TarUtils.computeCheckSum(bArr), bArr, iWriteEntryHeaderField, 8);
    }

    private void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z6, boolean z7) throws IOException {
        try {
            parseTarHeaderUnwrapped(bArr, zipEncoding, z6, z7);
        } catch (IllegalArgumentException e) {
            throw new IOException("Corrupted TAR archive.", e);
        }
    }

    public TarArchiveEntry(String str) {
        this(str, false);
    }

    public TarArchiveEntry(String str, boolean z6) {
        this(z6);
        String strNormalizeFileName = normalizeFileName(str, z6);
        boolean zEndsWith = strNormalizeFileName.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING);
        this.name = strNormalizeFileName;
        this.mode = zEndsWith ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE;
        this.linkFlag = zEndsWith ? TarConstants.LF_DIR : TarConstants.LF_NORMAL;
        this.modTime = System.currentTimeMillis() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(String str, byte b) {
        this(str, b, false);
    }

    public TarArchiveEntry(String str, byte b, boolean z6) {
        this(str, z6);
        this.linkFlag = b;
        if (b == 76) {
            this.magic = TarConstants.MAGIC_GNU;
            this.version = TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarArchiveEntry(File file) {
        this(file, file.getPath());
    }

    public TarArchiveEntry(Path path) {
        this(path, path.toString(), new LinkOption[0]);
    }

    public TarArchiveEntry(File file, String str) {
        this.name = "";
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.extraPaxHeaders = new HashMap();
        this.dataOffset = -1L;
        String strNormalizeFileName = normalizeFileName(str, false);
        Path path = file.toPath();
        this.file = path;
        this.linkOptions = IOUtils.EMPTY_LINK_OPTIONS;
        try {
            readFileMode(path, strNormalizeFileName, new LinkOption[0]);
        } catch (IOException unused) {
            if (!file.isDirectory()) {
                this.size = file.length();
            }
        }
        this.userName = "";
        try {
            readOsSpecificProperties(this.file, new LinkOption[0]);
        } catch (IOException unused2) {
            this.modTime = file.lastModified() / 1000;
        }
        this.preserveAbsolutePath = false;
    }

    public TarArchiveEntry(Path path, String str, LinkOption... linkOptionArr) {
        this.name = "";
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.extraPaxHeaders = new HashMap();
        this.dataOffset = -1L;
        String strNormalizeFileName = normalizeFileName(str, false);
        this.file = path;
        this.linkOptions = linkOptionArr == null ? IOUtils.EMPTY_LINK_OPTIONS : linkOptionArr;
        readFileMode(path, strNormalizeFileName, linkOptionArr);
        this.userName = "";
        readOsSpecificProperties(path, new LinkOption[0]);
        this.preserveAbsolutePath = false;
    }

    public TarArchiveEntry(byte[] bArr) {
        this(false);
        parseTarHeader(bArr);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding) {
        this(bArr, zipEncoding, false);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding, boolean z6) throws IOException {
        this(false);
        parseTarHeader(bArr, zipEncoding, false, z6);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding, boolean z6, long j6) {
        this(bArr, zipEncoding, z6);
        setDataOffset(j6);
    }
}
