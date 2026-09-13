package org.apache.commons.compress.archivers.cpio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.exifinterface.media.a;
import io.flutter.embedding.android.KeyboardMap;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CpioArchiveEntry implements CpioConstants, ArchiveEntry {
    private final int alignmentBoundary;
    private long chksum;
    private final short fileFormat;
    private long filesize;
    private long gid;
    private final int headerSize;
    private long inode;
    private long maj;
    private long min;
    private long mode;
    private long mtime;
    private String name;
    private long nlink;
    private long rmaj;
    private long rmin;
    private long uid;

    public CpioArchiveEntry(short s6) {
        if (s6 == 1 || s6 == 2) {
            this.headerSize = 110;
            this.alignmentBoundary = 4;
        } else if (s6 == 4) {
            this.headerSize = 76;
            this.alignmentBoundary = 0;
        } else {
            if (s6 != 8) {
                throw new IllegalArgumentException("Unknown header type");
            }
            this.headerSize = 26;
            this.alignmentBoundary = 2;
        }
        this.fileFormat = s6;
    }

    private void checkNewFormat() {
        if ((this.fileFormat & 3) == 0) {
            throw new UnsupportedOperationException();
        }
    }

    private void checkOldFormat() {
        if ((this.fileFormat & 12) == 0) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CpioArchiveEntry cpioArchiveEntry = (CpioArchiveEntry) obj;
        String str = this.name;
        if (str == null) {
            return cpioArchiveEntry.name == null;
        }
        return str.equals(cpioArchiveEntry.name);
    }

    public int getAlignmentBoundary() {
        return this.alignmentBoundary;
    }

    public long getChksum() {
        checkNewFormat();
        return this.chksum & KeyboardMap.kValueMask;
    }

    public int getDataPadCount() {
        int i5;
        int i6 = this.alignmentBoundary;
        if (i6 != 0 && (i5 = (int) (this.filesize % ((long) i6))) > 0) {
            return i6 - i5;
        }
        return 0;
    }

    public long getDevice() {
        checkOldFormat();
        return this.min;
    }

    public long getDeviceMaj() {
        checkNewFormat();
        return this.maj;
    }

    public long getDeviceMin() {
        checkNewFormat();
        return this.min;
    }

    public short getFormat() {
        return this.fileFormat;
    }

    public long getGID() {
        return this.gid;
    }

    @Deprecated
    public int getHeaderPadCount() {
        return getHeaderPadCount((Charset) null);
    }

    public int getHeaderSize() {
        return this.headerSize;
    }

    public long getInode() {
        return this.inode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(getTime() * 1000);
    }

    public long getMode() {
        return (this.mode != 0 || CpioConstants.CPIO_TRAILER.equals(this.name)) ? this.mode : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public long getNumberOfLinks() {
        long j6 = this.nlink;
        if (j6 == 0) {
            return isDirectory() ? 2L : 1L;
        }
        return j6;
    }

    public long getRemoteDevice() {
        checkOldFormat();
        return this.rmin;
    }

    public long getRemoteDeviceMaj() {
        checkNewFormat();
        return this.rmaj;
    }

    public long getRemoteDeviceMin() {
        checkNewFormat();
        return this.rmin;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.filesize;
    }

    public long getTime() {
        return this.mtime;
    }

    public long getUID() {
        return this.uid;
    }

    public int hashCode() {
        return Objects.hash(this.name);
    }

    public boolean isBlockDevice() {
        return CpioUtil.fileType(this.mode) == 24576;
    }

    public boolean isCharacterDevice() {
        return CpioUtil.fileType(this.mode) == PlaybackStateCompat.ACTION_PLAY_FROM_URI;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return CpioUtil.fileType(this.mode) == PlaybackStateCompat.ACTION_PREPARE;
    }

    public boolean isNetwork() {
        return CpioUtil.fileType(this.mode) == 36864;
    }

    public boolean isPipe() {
        return CpioUtil.fileType(this.mode) == PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
    }

    public boolean isRegularFile() {
        return CpioUtil.fileType(this.mode) == PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
    }

    public boolean isSocket() {
        return CpioUtil.fileType(this.mode) == 49152;
    }

    public boolean isSymbolicLink() {
        return CpioUtil.fileType(this.mode) == 40960;
    }

    public void setChksum(long j6) {
        checkNewFormat();
        this.chksum = j6 & KeyboardMap.kValueMask;
    }

    public void setDevice(long j6) {
        checkOldFormat();
        this.min = j6;
    }

    public void setDeviceMaj(long j6) {
        checkNewFormat();
        this.maj = j6;
    }

    public void setDeviceMin(long j6) {
        checkNewFormat();
        this.min = j6;
    }

    public void setGID(long j6) {
        this.gid = j6;
    }

    public void setInode(long j6) {
        this.inode = j6;
    }

    public void setMode(long j6) {
        long j7 = 61440 & j6;
        switch ((int) j7) {
            case 4096:
            case 8192:
            case 16384:
            case CpioConstants.C_ISBLK /* 24576 */:
            case 32768:
            case CpioConstants.C_ISNWK /* 36864 */:
            case 40960:
            case CpioConstants.C_ISSOCK /* 49152 */:
                this.mode = j6;
                return;
            default:
                throw new IllegalArgumentException("Unknown mode. Full: " + Long.toHexString(j6) + " Masked: " + Long.toHexString(j7));
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNumberOfLinks(long j6) {
        this.nlink = j6;
    }

    public void setRemoteDevice(long j6) {
        checkOldFormat();
        this.rmin = j6;
    }

    public void setRemoteDeviceMaj(long j6) {
        checkNewFormat();
        this.rmaj = j6;
    }

    public void setRemoteDeviceMin(long j6) {
        checkNewFormat();
        this.rmin = j6;
    }

    public void setSize(long j6) {
        if (j6 < 0 || j6 > KeyboardMap.kValueMask) {
            throw new IllegalArgumentException(a.k("Invalid entry size <", j6, ">"));
        }
        this.filesize = j6;
    }

    public void setTime(long j6) {
        this.mtime = j6;
    }

    public void setUID(long j6) {
        this.uid = j6;
    }

    public int getHeaderPadCount(Charset charset) {
        String str = this.name;
        if (str == null) {
            return 0;
        }
        return charset == null ? getHeaderPadCount(str.length()) : getHeaderPadCount(str.getBytes(charset).length);
    }

    public void setTime(FileTime fileTime) {
        this.mtime = fileTime.to(TimeUnit.SECONDS);
    }

    public int getHeaderPadCount(long j6) {
        int i5 = this.alignmentBoundary;
        if (i5 == 0) {
            return 0;
        }
        int i6 = this.headerSize + 1;
        if (this.name != null) {
            i6 = (int) (((long) i6) + j6);
        }
        int i7 = i6 % i5;
        if (i7 > 0) {
            return i5 - i7;
        }
        return 0;
    }

    public CpioArchiveEntry(String str) {
        this((short) 1, str);
    }

    public CpioArchiveEntry(short s6, String str) {
        this(s6);
        this.name = str;
    }

    public CpioArchiveEntry(String str, long j6) {
        this(str);
        setSize(j6);
    }

    public CpioArchiveEntry(short s6, String str, long j6) {
        this(s6, str);
        setSize(j6);
    }

    public CpioArchiveEntry(File file, String str) {
        this((short) 1, file, str);
    }

    public CpioArchiveEntry(Path path, String str, LinkOption... linkOptionArr) {
        this((short) 1, path, str, linkOptionArr);
    }

    public CpioArchiveEntry(short s6, File file, String str) {
        this(s6, str, file.isFile() ? file.length() : 0L);
        if (file.isDirectory()) {
            setMode(PlaybackStateCompat.ACTION_PREPARE);
        } else if (file.isFile()) {
            setMode(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        } else {
            throw new IllegalArgumentException("Cannot determine type of file " + file.getName());
        }
        setTime(file.lastModified() / 1000);
    }

    public CpioArchiveEntry(short s6, Path path, String str, LinkOption... linkOptionArr) {
        this(s6, str, Files.isRegularFile(path, linkOptionArr) ? Files.size(path) : 0L);
        if (Files.isDirectory(path, linkOptionArr)) {
            setMode(PlaybackStateCompat.ACTION_PREPARE);
        } else if (Files.isRegularFile(path, linkOptionArr)) {
            setMode(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        } else {
            throw new IllegalArgumentException("Cannot determine type of file " + path);
        }
        setTime(Files.getLastModifiedTime(path, linkOptionArr));
    }
}
