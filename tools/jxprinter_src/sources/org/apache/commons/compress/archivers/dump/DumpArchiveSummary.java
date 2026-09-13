package org.apache.commons.compress.archivers.dump;

import java.util.Date;
import org.apache.commons.compress.archivers.zip.ZipEncoding;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DumpArchiveSummary {
    private String devname;
    private long dumpDate;
    private String filesys;
    private int firstrec;
    private int flags;
    private String hostname;
    private String label;
    private int level;
    private int ntrec;
    private long previousDumpDate;
    private int volume;

    public DumpArchiveSummary(byte[] bArr, ZipEncoding zipEncoding) {
        this.dumpDate = ((long) DumpArchiveUtil.convert32(bArr, 4)) * 1000;
        this.previousDumpDate = ((long) DumpArchiveUtil.convert32(bArr, 8)) * 1000;
        this.volume = DumpArchiveUtil.convert32(bArr, 12);
        this.label = DumpArchiveUtil.decode(zipEncoding, bArr, 676, 16).trim();
        this.level = DumpArchiveUtil.convert32(bArr, 692);
        this.filesys = DumpArchiveUtil.decode(zipEncoding, bArr, 696, 64).trim();
        this.devname = DumpArchiveUtil.decode(zipEncoding, bArr, 760, 64).trim();
        this.hostname = DumpArchiveUtil.decode(zipEncoding, bArr, 824, 64).trim();
        this.flags = DumpArchiveUtil.convert32(bArr, 888);
        this.firstrec = DumpArchiveUtil.convert32(bArr, 892);
        this.ntrec = DumpArchiveUtil.convert32(bArr, 896);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            DumpArchiveSummary dumpArchiveSummary = (DumpArchiveSummary) obj;
            if (this.dumpDate == dumpArchiveSummary.dumpDate && getHostname() != null && getHostname().equals(dumpArchiveSummary.getHostname()) && getDevname() != null && getDevname().equals(dumpArchiveSummary.getDevname())) {
                return true;
            }
        }
        return false;
    }

    public String getDevname() {
        return this.devname;
    }

    public Date getDumpDate() {
        return new Date(this.dumpDate);
    }

    public String getFilesystem() {
        return this.filesys;
    }

    public int getFirstRecord() {
        return this.firstrec;
    }

    public int getFlags() {
        return this.flags;
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getLabel() {
        return this.label;
    }

    public int getLevel() {
        return this.level;
    }

    public int getNTRec() {
        return this.ntrec;
    }

    public Date getPreviousDumpDate() {
        return new Date(this.previousDumpDate);
    }

    public int getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String str = this.label;
        int iHashCode = (int) ((this.dumpDate * 31) + ((long) (str != null ? str.hashCode() : 17)));
        String str2 = this.hostname;
        if (str2 != null) {
            iHashCode = (str2.hashCode() * 31) + 17;
        }
        String str3 = this.devname;
        return str3 != null ? (str3.hashCode() * 31) + 17 : iHashCode;
    }

    public boolean isCompressed() {
        return (this.flags & 128) == 128;
    }

    public boolean isExtendedAttributes() {
        return (this.flags & 32768) == 32768;
    }

    public boolean isMetaDataOnly() {
        return (this.flags & 256) == 256;
    }

    public boolean isNewHeader() {
        return (this.flags & 1) == 1;
    }

    public boolean isNewInode() {
        return (this.flags & 2) == 2;
    }

    public void setDevname(String str) {
        this.devname = str;
    }

    public void setDumpDate(Date date) {
        this.dumpDate = date.getTime();
    }

    public void setFilesystem(String str) {
        this.filesys = str;
    }

    public void setFirstRecord(int i5) {
        this.firstrec = i5;
    }

    public void setFlags(int i5) {
        this.flags = i5;
    }

    public void setHostname(String str) {
        this.hostname = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLevel(int i5) {
        this.level = i5;
    }

    public void setNTRec(int i5) {
        this.ntrec = i5;
    }

    public void setPreviousDumpDate(Date date) {
        this.previousDumpDate = date.getTime();
    }

    public void setVolume(int i5) {
        this.volume = i5;
    }
}
