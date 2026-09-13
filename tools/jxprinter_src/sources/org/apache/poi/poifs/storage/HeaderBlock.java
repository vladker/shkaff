package org.apache.poi.poifs.storage;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.IntegerField;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LongField;
import org.apache.poi.util.ShortField;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HeaderBlock implements HeaderBlockConstants {
    private static final byte _default_value = -1;
    private int _bat_count;
    private final byte[] _data;
    private int _property_start;
    private int _sbat_count;
    private int _sbat_start;
    private int _xbat_count;
    private int _xbat_start;
    private final POIFSBigBlockSize bigBlockSize;

    /* JADX INFO: renamed from: org.apache.poi.poifs.storage.HeaderBlock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.OLE2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.MSWRITE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.WORD2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BIFF2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BIFF3.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BIFF4.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public HeaderBlock(InputStream inputStream) {
        this(readFirst512(inputStream));
        if (this.bigBlockSize.getBigBlockSize() != 512) {
            IOUtils.readFully(inputStream, IOUtils.safelyAllocate(this.bigBlockSize.getBigBlockSize() - 512, POIFSFileSystem.getMaxRecordLength()));
        }
    }

    private static IOException alertShortRead(int i5) {
        int iMax = Math.max(i5, 0);
        return new IOException("Unable to read entire header; " + iMax + " byte".concat(iMax == 1 ? "" : "s") + " read; expected 512 bytes");
    }

    private static byte[] readFirst512(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[512];
        int fully = IOUtils.readFully(inputStream, bArr);
        if (fully == 512) {
            return bArr;
        }
        throw alertShortRead(fully);
    }

    public int[] getBATArray() {
        int iMin = Math.min(this._bat_count, 109);
        int[] iArr = new int[iMin];
        int i5 = 76;
        for (int i6 = 0; i6 < iMin; i6++) {
            iArr[i6] = LittleEndian.getInt(this._data, i5);
            i5 += 4;
        }
        return iArr;
    }

    public int getBATCount() {
        return this._bat_count;
    }

    public POIFSBigBlockSize getBigBlockSize() {
        return this.bigBlockSize;
    }

    public int getPropertyStart() {
        return this._property_start;
    }

    public int getSBATCount() {
        return this._sbat_count;
    }

    public int getSBATStart() {
        return this._sbat_start;
    }

    public int getXBATCount() {
        return this._xbat_count;
    }

    public int getXBATIndex() {
        return this._xbat_start;
    }

    public void setBATArray(int[] iArr) {
        int iMin = Math.min(iArr.length, 109);
        int i5 = 109 - iMin;
        int i6 = 76;
        for (int i7 = 0; i7 < iMin; i7++) {
            LittleEndian.putInt(this._data, i6, iArr[i7]);
            i6 += 4;
        }
        for (int i8 = 0; i8 < i5; i8++) {
            LittleEndian.putInt(this._data, i6, -1);
            i6 += 4;
        }
    }

    public void setBATCount(int i5) {
        this._bat_count = i5;
    }

    public void setPropertyStart(int i5) {
        this._property_start = i5;
    }

    public void setSBATBlockCount(int i5) {
        this._sbat_count = i5;
    }

    public void setSBATStart(int i5) {
        this._sbat_start = i5;
    }

    public void setXBATCount(int i5) {
        this._xbat_count = i5;
    }

    public void setXBATStart(int i5) {
        this._xbat_start = i5;
    }

    public void writeData(OutputStream outputStream) {
        new IntegerField(44, this._bat_count, this._data);
        new IntegerField(48, this._property_start, this._data);
        new IntegerField(60, this._sbat_start, this._data);
        new IntegerField(64, this._sbat_count, this._data);
        new IntegerField(68, this._xbat_start, this._data);
        new IntegerField(72, this._xbat_count, this._data);
        outputStream.write(this._data, 0, 512);
        for (int i5 = 512; i5 < this.bigBlockSize.getBigBlockSize(); i5++) {
            outputStream.write(0);
        }
    }

    public HeaderBlock(ByteBuffer byteBuffer) {
        this(IOUtils.toByteArray(byteBuffer, 512));
    }

    private HeaderBlock(byte[] bArr) throws IOException {
        byte[] bArr2 = (byte[]) bArr.clone();
        this._data = bArr2;
        FileMagic fileMagicValueOf = FileMagic.valueOf(bArr);
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[fileMagicValueOf.ordinal()]) {
            case 1:
                byte b = bArr2[30];
                if (b == 12) {
                    this.bigBlockSize = POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS;
                } else if (b == 9) {
                    this.bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
                } else {
                    throw new IOException(AbstractC0157z.l("). Expected 2^9 or 2^12.", bArr2[30], new StringBuilder("Unsupported blocksize  (2^")));
                }
                this._bat_count = new IntegerField(44, bArr).get();
                this._property_start = new IntegerField(48, bArr2).get();
                this._sbat_start = new IntegerField(60, bArr2).get();
                this._sbat_count = new IntegerField(64, bArr2).get();
                this._xbat_start = new IntegerField(68, bArr2).get();
                this._xbat_count = new IntegerField(72, bArr2).get();
                return;
            case 2:
                throw new OfficeXmlFileException("The supplied data appears to be in the Office 2007+ XML. You are calling the part of POI that deals with OLE2 Office Documents. You need to call a different part of POI to process this data (eg XSSF instead of HSSF)");
            case 3:
                throw new NotOLE2FileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
            case 4:
                throw new NotOLE2FileException("The supplied data appears to be in the old MS Write format. Apache POI doesn't currently support this format");
            case 5:
                throw new NotOLE2FileException("The supplied data appears to be an old Word version 2 file. Apache POI doesn't currently support this format");
            case 6:
            case 7:
            case 8:
                throw new OldExcelFormatException("The supplied data appears to be in " + fileMagicValueOf + " format. HSSF only supports the BIFF8 format, try OldExcelExtractor");
            default:
                throw new NotOLE2FileException(a.p("Invalid header signature; read ", HexDump.longToHex(LittleEndian.getLong(bArr, 0)), ", expected ", HexDump.longToHex(HeaderBlockConstants._signature), " - Your file appears not to be a valid OLE2 document"));
        }
    }

    public HeaderBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        this.bigBlockSize = pOIFSBigBlockSize;
        byte[] bArr = new byte[512];
        this._data = bArr;
        Arrays.fill(bArr, (byte) -1);
        new LongField(0, HeaderBlockConstants._signature, bArr);
        new IntegerField(8, 0, bArr);
        new IntegerField(12, 0, bArr);
        new IntegerField(16, 0, bArr);
        new IntegerField(20, 0, bArr);
        new ShortField(24, (short) 59, bArr);
        new ShortField(26, (short) 3, bArr);
        new ShortField(28, (short) -2, bArr);
        new ShortField(30, pOIFSBigBlockSize.getHeaderValue(), bArr);
        new IntegerField(32, 6, bArr);
        new IntegerField(36, 0, bArr);
        new IntegerField(40, 0, bArr);
        new IntegerField(52, 0, bArr);
        new IntegerField(56, 4096, bArr);
        this._bat_count = 0;
        this._sbat_count = 0;
        this._xbat_count = 0;
        this._property_start = -2;
        this._sbat_start = -2;
        this._xbat_start = -2;
    }
}
