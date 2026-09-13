package org.apache.poi.hpsf;

import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Thumbnail {
    public static final int CFTAG_FMTID = -3;
    public static final int CFTAG_MACINTOSH = -2;
    public static final int CFTAG_NODATA = 0;
    public static final int CFTAG_WINDOWS = -1;
    public static final int CF_BITMAP = 2;
    public static final int CF_DIB = 8;
    public static final int CF_ENHMETAFILE = 14;
    public static final int CF_METAFILEPICT = 3;
    private static final int DEFAULT_MAX_RECORD_LENGTH = 1000000;
    private static int MAX_RECORD_LENGTH = 1000000;
    public static final int OFFSET_CF = 8;
    public static final int OFFSET_CFTAG = 4;
    public static final int OFFSET_WMFDATA = 20;
    private byte[] _thumbnailData;

    public Thumbnail() {
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public long getClipboardFormat() throws HPSFException {
        if (getClipboardFormatTag() == -1) {
            return LittleEndian.getInt(getThumbnail(), 8);
        }
        throw new HPSFException("Clipboard Format Tag of Thumbnail must be CFTAG_WINDOWS.");
    }

    public long getClipboardFormatTag() {
        return LittleEndian.getInt(getThumbnail(), 4);
    }

    public byte[] getThumbnail() {
        return this._thumbnailData;
    }

    public byte[] getThumbnailAsWMF() throws HPSFException {
        if (getClipboardFormatTag() != -1) {
            throw new HPSFException("Clipboard Format Tag of Thumbnail must be CFTAG_WINDOWS.");
        }
        if (getClipboardFormat() != 3) {
            throw new HPSFException("Clipboard Format of Thumbnail must be CF_METAFILEPICT.");
        }
        byte[] thumbnail = getThumbnail();
        return IOUtils.safelyClone(thumbnail, 20, thumbnail.length - 20, MAX_RECORD_LENGTH);
    }

    public void setThumbnail(byte[] bArr) {
        this._thumbnailData = bArr;
    }

    public Thumbnail(byte[] bArr) {
        this._thumbnailData = bArr;
    }
}
