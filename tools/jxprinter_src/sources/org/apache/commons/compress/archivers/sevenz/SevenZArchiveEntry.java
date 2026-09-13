package org.apache.commons.compress.archivers.sevenz;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TimeZone;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SevenZArchiveEntry implements ArchiveEntry {
    static final SevenZArchiveEntry[] EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY = new SevenZArchiveEntry[0];
    private long accessDate;
    private long compressedCrc;
    private long compressedSize;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private long crc;
    private long creationDate;
    private boolean hasAccessDate;
    private boolean hasCrc;
    private boolean hasCreationDate;
    private boolean hasLastModifiedDate;
    private boolean hasStream;
    private boolean hasWindowsAttributes;
    private boolean isAntiItem;
    private boolean isDirectory;
    private long lastModifiedDate;
    private String name;
    private long size;
    private int windowsAttributes;

    private boolean equalSevenZMethods(Iterable<? extends SevenZMethodConfiguration> iterable, Iterable<? extends SevenZMethodConfiguration> iterable2) {
        if (iterable == null) {
            return iterable2 == null;
        }
        if (iterable2 == null) {
            return false;
        }
        Iterator<? extends SevenZMethodConfiguration> it = iterable.iterator();
        Iterator<? extends SevenZMethodConfiguration> it2 = iterable2.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !it.next().equals(it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static long javaTimeToNtfsTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.set(1601, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return (date.getTime() - calendar.getTimeInMillis()) * 10000;
    }

    public static Date ntfsTimeToJavaTime(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.set(1601, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return new Date((j6 / 10000) + calendar.getTimeInMillis());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SevenZArchiveEntry sevenZArchiveEntry = (SevenZArchiveEntry) obj;
            if (Objects.equals(this.name, sevenZArchiveEntry.name) && this.hasStream == sevenZArchiveEntry.hasStream && this.isDirectory == sevenZArchiveEntry.isDirectory && this.isAntiItem == sevenZArchiveEntry.isAntiItem && this.hasCreationDate == sevenZArchiveEntry.hasCreationDate && this.hasLastModifiedDate == sevenZArchiveEntry.hasLastModifiedDate && this.hasAccessDate == sevenZArchiveEntry.hasAccessDate && this.creationDate == sevenZArchiveEntry.creationDate && this.lastModifiedDate == sevenZArchiveEntry.lastModifiedDate && this.accessDate == sevenZArchiveEntry.accessDate && this.hasWindowsAttributes == sevenZArchiveEntry.hasWindowsAttributes && this.windowsAttributes == sevenZArchiveEntry.windowsAttributes && this.hasCrc == sevenZArchiveEntry.hasCrc && this.crc == sevenZArchiveEntry.crc && this.compressedCrc == sevenZArchiveEntry.compressedCrc && this.size == sevenZArchiveEntry.size && this.compressedSize == sevenZArchiveEntry.compressedSize && equalSevenZMethods(this.contentMethods, sevenZArchiveEntry.contentMethods)) {
                return true;
            }
        }
        return false;
    }

    public Date getAccessDate() {
        if (this.hasAccessDate) {
            return ntfsTimeToJavaTime(this.accessDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    @Deprecated
    public int getCompressedCrc() {
        return (int) this.compressedCrc;
    }

    public long getCompressedCrcValue() {
        return this.compressedCrc;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public Iterable<? extends SevenZMethodConfiguration> getContentMethods() {
        return this.contentMethods;
    }

    @Deprecated
    public int getCrc() {
        return (int) this.crc;
    }

    public long getCrcValue() {
        return this.crc;
    }

    public Date getCreationDate() {
        if (this.hasCreationDate) {
            return ntfsTimeToJavaTime(this.creationDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public boolean getHasAccessDate() {
        return this.hasAccessDate;
    }

    public boolean getHasCrc() {
        return this.hasCrc;
    }

    public boolean getHasCreationDate() {
        return this.hasCreationDate;
    }

    public boolean getHasLastModifiedDate() {
        return this.hasLastModifiedDate;
    }

    public boolean getHasWindowsAttributes() {
        return this.hasWindowsAttributes;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        if (this.hasLastModifiedDate) {
            return ntfsTimeToJavaTime(this.lastModifiedDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public int getWindowsAttributes() {
        return this.windowsAttributes;
    }

    public boolean hasStream() {
        return this.hasStream;
    }

    public int hashCode() {
        String name = getName();
        if (name == null) {
            return 0;
        }
        return name.hashCode();
    }

    public boolean isAntiItem() {
        return this.isAntiItem;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setAccessDate(long j6) {
        this.accessDate = j6;
    }

    public void setAntiItem(boolean z6) {
        this.isAntiItem = z6;
    }

    @Deprecated
    public void setCompressedCrc(int i5) {
        this.compressedCrc = i5;
    }

    public void setCompressedCrcValue(long j6) {
        this.compressedCrc = j6;
    }

    public void setCompressedSize(long j6) {
        this.compressedSize = j6;
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> iterable) {
        if (iterable == null) {
            this.contentMethods = null;
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<? extends SevenZMethodConfiguration> it = iterable.iterator();
        while (it.hasNext()) {
            linkedList.addLast(it.next());
        }
        this.contentMethods = Collections.unmodifiableList(linkedList);
    }

    @Deprecated
    public void setCrc(int i5) {
        this.crc = i5;
    }

    public void setCrcValue(long j6) {
        this.crc = j6;
    }

    public void setCreationDate(long j6) {
        this.creationDate = j6;
    }

    public void setDirectory(boolean z6) {
        this.isDirectory = z6;
    }

    public void setHasAccessDate(boolean z6) {
        this.hasAccessDate = z6;
    }

    public void setHasCrc(boolean z6) {
        this.hasCrc = z6;
    }

    public void setHasCreationDate(boolean z6) {
        this.hasCreationDate = z6;
    }

    public void setHasLastModifiedDate(boolean z6) {
        this.hasLastModifiedDate = z6;
    }

    public void setHasStream(boolean z6) {
        this.hasStream = z6;
    }

    public void setHasWindowsAttributes(boolean z6) {
        this.hasWindowsAttributes = z6;
    }

    public void setLastModifiedDate(long j6) {
        this.lastModifiedDate = j6;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(long j6) {
        this.size = j6;
    }

    public void setWindowsAttributes(int i5) {
        this.windowsAttributes = i5;
    }

    public void setAccessDate(Date date) {
        boolean z6 = date != null;
        this.hasAccessDate = z6;
        if (z6) {
            this.accessDate = javaTimeToNtfsTime(date);
        }
    }

    public void setCreationDate(Date date) {
        boolean z6 = date != null;
        this.hasCreationDate = z6;
        if (z6) {
            this.creationDate = javaTimeToNtfsTime(date);
        }
    }

    public void setLastModifiedDate(Date date) {
        boolean z6 = date != null;
        this.hasLastModifiedDate = z6;
        if (z6) {
            this.lastModifiedDate = javaTimeToNtfsTime(date);
        }
    }
}
