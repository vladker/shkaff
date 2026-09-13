package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hpsf.ClassIDPredefined;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.HexRead;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HyperlinkRecord extends StandardRecord {
    private static final byte[] FILE_TAIL;
    static final int HLINK_ABS = 2;
    static final int HLINK_LABEL = 20;
    static final int HLINK_PLACE = 8;
    private static final int HLINK_TARGET_FRAME = 128;
    private static final int HLINK_UNC_PATH = 256;
    static final int HLINK_URL = 1;
    private static final int TAIL_SIZE;
    public static final short sid = 440;
    private String _address;
    private int _fileOpts;
    private ClassID _guid;
    private String _label;
    private int _linkOpts;
    private ClassID _moniker;
    private CellRangeAddress _range;
    private String _shortFilename;
    private String _targetFrame;
    private String _textMark;
    private byte[] _uninterpretedTail;
    private static final Logger LOG = LogManager.getLogger((Class<?>) HyperlinkRecord.class);
    private static final byte[] URL_TAIL = HexRead.readFromString("79 58 81 F4  3B 1D 7F 48   AF 2C 82 5D  C4 85 27 63   00 00 00 00  A5 AB 00 00");

    static {
        byte[] fromString = HexRead.readFromString("FF FF AD DE  00 00 00 00   00 00 00 00  00 00 00 00   00 00 00 00  00 00 00 00");
        FILE_TAIL = fromString;
        TAIL_SIZE = fromString.length;
    }

    public HyperlinkRecord() {
    }

    private static String appendNullTerm(String str) {
        if (str == null) {
            return null;
        }
        return str.concat(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR);
    }

    private static String cleanString(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(0);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this._range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return GenericRecordUtil.getBitsAsString(new C1380a0(this, 0), new int[]{1, 2, 8, 20, 128, 256}, new String[]{"URL", "ABS", "PLACE", "LABEL", "TARGET_FRAME", "UNC_PATH"});
    }

    private static byte[] readTail(byte[] bArr, LittleEndianInput littleEndianInput) {
        byte[] bArr2 = new byte[TAIL_SIZE];
        littleEndianInput.readFully(bArr2);
        return bArr2;
    }

    private static void writeTail(byte[] bArr, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(bArr);
    }

    public String getAddress() {
        if ((this._linkOpts & 1) == 0 || !ClassIDPredefined.FILE_MONIKER.equals(this._moniker)) {
            return (this._linkOpts & 8) != 0 ? cleanString(this._textMark) : cleanString(this._address);
        }
        String str = this._address;
        if (str == null) {
            str = this._shortFilename;
        }
        return cleanString(str);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int i5;
        int length = (this._linkOpts & 20) != 0 ? (this._label.length() * 2) + 36 : 32;
        if ((this._linkOpts & 128) != 0) {
            length = length + 4 + (this._targetFrame.length() * 2);
        }
        int i6 = this._linkOpts;
        if ((i6 & 1) != 0 && (i6 & 256) != 0) {
            length = length + 4 + (this._address.length() * 2);
        }
        int i7 = this._linkOpts;
        if ((i7 & 1) != 0 && (i7 & 256) == 0) {
            int i8 = length + 16;
            if (ClassIDPredefined.URL_MONIKER.equals(this._moniker)) {
                length = length + 20 + (this._address.length() * 2);
                if (this._uninterpretedTail != null) {
                    i5 = TAIL_SIZE;
                    length += i5;
                }
            } else if (ClassIDPredefined.FILE_MONIKER.equals(this._moniker)) {
                int length2 = this._shortFilename.length() + length + 22 + TAIL_SIZE;
                length = length2 + 4;
                String str = this._address;
                if (str != null) {
                    i5 = length2 + 10;
                    length = str.length() * 2;
                    length += i5;
                }
            } else {
                length = i8;
            }
        }
        if ((this._linkOpts & 8) != 0) {
            return (this._textMark.length() * 2) + length + 4;
        }
        return length;
    }

    public int getFileOptions() {
        return this._fileOpts;
    }

    public int getFirstColumn() {
        return this._range.getFirstColumn();
    }

    public int getFirstRow() {
        return this._range.getFirstRow();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("range", new C1380a0(this, 1), "guid", new C1380a0(this, 2), "linkOpts", new C1380a0(this, 3), "label", new C1380a0(this, 4), "targetFrame", new C1380a0(this, 5), "moniker", new C1380a0(this, 6), "textMark", new C1380a0(this, 7), "address", new C1380a0(this, 8));
    }

    public ClassID getGuid() {
        return this._guid;
    }

    public String getLabel() {
        return cleanString(this._label);
    }

    public int getLabelOptions() {
        return 2;
    }

    public int getLastColumn() {
        return this._range.getLastColumn();
    }

    public int getLastRow() {
        return this._range.getLastRow();
    }

    public int getLinkOptions() {
        return this._linkOpts;
    }

    public ClassID getMoniker() {
        return this._moniker;
    }

    public String getShortFilename() {
        return cleanString(this._shortFilename);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public String getTargetFrame() {
        return cleanString(this._targetFrame);
    }

    public String getTextMark() {
        return cleanString(this._textMark);
    }

    public boolean isDocumentLink() {
        return (this._linkOpts & 8) > 0;
    }

    public boolean isFileLink() {
        int i5 = this._linkOpts;
        return (i5 & 1) > 0 && (i5 & 2) == 0;
    }

    public boolean isUrlLink() {
        int i5 = this._linkOpts;
        return (i5 & 1) > 0 && (i5 & 2) > 0;
    }

    public void newDocumentLink() {
        this._range = new CellRangeAddress(0, 0, 0, 0);
        this._guid = ClassIDPredefined.STD_MONIKER.getClassID();
        this._linkOpts = 28;
        setLabel("");
        this._moniker = ClassIDPredefined.FILE_MONIKER.getClassID();
        setAddress("");
        setTextMark("");
    }

    public void newFileLink() {
        this._range = new CellRangeAddress(0, 0, 0, 0);
        this._guid = ClassIDPredefined.STD_MONIKER.getClassID();
        this._linkOpts = 21;
        this._fileOpts = 0;
        setLabel("");
        this._moniker = ClassIDPredefined.FILE_MONIKER.getClassID();
        setAddress(null);
        setShortFilename("");
        this._uninterpretedTail = FILE_TAIL;
    }

    public void newUrlLink() {
        this._range = new CellRangeAddress(0, 0, 0, 0);
        this._guid = ClassIDPredefined.STD_MONIKER.getClassID();
        this._linkOpts = 23;
        setLabel("");
        this._moniker = ClassIDPredefined.URL_MONIKER.getClassID();
        setAddress("");
        this._uninterpretedTail = URL_TAIL;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this._range.serialize(littleEndianOutput);
        this._guid.write(littleEndianOutput);
        littleEndianOutput.writeInt(2);
        littleEndianOutput.writeInt(this._linkOpts);
        if ((this._linkOpts & 20) != 0) {
            littleEndianOutput.writeInt(this._label.length());
            StringUtil.putUnicodeLE(this._label, littleEndianOutput);
        }
        if ((this._linkOpts & 128) != 0) {
            littleEndianOutput.writeInt(this._targetFrame.length());
            StringUtil.putUnicodeLE(this._targetFrame, littleEndianOutput);
        }
        int i5 = this._linkOpts;
        if ((i5 & 1) != 0 && (i5 & 256) != 0) {
            littleEndianOutput.writeInt(this._address.length());
            StringUtil.putUnicodeLE(this._address, littleEndianOutput);
        }
        int i6 = this._linkOpts;
        if ((i6 & 1) != 0 && (i6 & 256) == 0) {
            this._moniker.write(littleEndianOutput);
            if (ClassIDPredefined.URL_MONIKER.equals(this._moniker)) {
                if (this._uninterpretedTail == null) {
                    littleEndianOutput.writeInt(this._address.length() * 2);
                    StringUtil.putUnicodeLE(this._address, littleEndianOutput);
                } else {
                    littleEndianOutput.writeInt((this._address.length() * 2) + TAIL_SIZE);
                    StringUtil.putUnicodeLE(this._address, littleEndianOutput);
                    writeTail(this._uninterpretedTail, littleEndianOutput);
                }
            } else if (ClassIDPredefined.FILE_MONIKER.equals(this._moniker)) {
                littleEndianOutput.writeShort(this._fileOpts);
                littleEndianOutput.writeInt(this._shortFilename.length());
                StringUtil.putCompressedUnicode(this._shortFilename, littleEndianOutput);
                writeTail(this._uninterpretedTail, littleEndianOutput);
                String str = this._address;
                if (str == null) {
                    littleEndianOutput.writeInt(0);
                } else {
                    int length = str.length() * 2;
                    littleEndianOutput.writeInt(length + 6);
                    littleEndianOutput.writeInt(length);
                    littleEndianOutput.writeShort(3);
                    StringUtil.putUnicodeLE(this._address, littleEndianOutput);
                }
            }
        }
        if ((this._linkOpts & 8) != 0) {
            littleEndianOutput.writeInt(this._textMark.length());
            StringUtil.putUnicodeLE(this._textMark, littleEndianOutput);
        }
    }

    public void setAddress(String str) {
        if ((this._linkOpts & 1) != 0 && ClassIDPredefined.FILE_MONIKER.equals(this._moniker)) {
            this._shortFilename = appendNullTerm(str);
        } else if ((this._linkOpts & 8) != 0) {
            this._textMark = appendNullTerm(str);
        } else {
            this._address = appendNullTerm(str);
        }
    }

    public void setFirstColumn(int i5) {
        this._range.setFirstColumn(i5);
    }

    public void setFirstRow(int i5) {
        this._range.setFirstRow(i5);
    }

    public void setLabel(String str) {
        this._label = appendNullTerm(str);
    }

    public void setLastColumn(int i5) {
        this._range.setLastColumn(i5);
    }

    public void setLastRow(int i5) {
        this._range.setLastRow(i5);
    }

    public void setShortFilename(String str) {
        this._shortFilename = appendNullTerm(str);
    }

    public void setTextMark(String str) {
        this._textMark = appendNullTerm(str);
    }

    public HyperlinkRecord(HyperlinkRecord hyperlinkRecord) {
        super(hyperlinkRecord);
        CellRangeAddress cellRangeAddress = hyperlinkRecord._range;
        this._range = cellRangeAddress == null ? null : cellRangeAddress.copy();
        ClassID classID = hyperlinkRecord._guid;
        this._guid = classID == null ? null : classID.copy();
        this._fileOpts = hyperlinkRecord._fileOpts;
        this._linkOpts = hyperlinkRecord._linkOpts;
        this._label = hyperlinkRecord._label;
        this._targetFrame = hyperlinkRecord._targetFrame;
        ClassID classID2 = hyperlinkRecord._moniker;
        this._moniker = classID2 == null ? null : classID2.copy();
        this._shortFilename = hyperlinkRecord._shortFilename;
        this._address = hyperlinkRecord._address;
        this._textMark = hyperlinkRecord._textMark;
        byte[] bArr = hyperlinkRecord._uninterpretedTail;
        this._uninterpretedTail = bArr != null ? (byte[]) bArr.clone() : null;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.HYPERLINK;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public HyperlinkRecord copy() {
        return new HyperlinkRecord(this);
    }

    public HyperlinkRecord(RecordInputStream recordInputStream) {
        this._range = new CellRangeAddress(recordInputStream);
        this._guid = new ClassID(recordInputStream);
        int i5 = recordInputStream.readInt();
        if (i5 == 2) {
            int i6 = recordInputStream.readInt();
            this._linkOpts = i6;
            if ((i6 & 20) != 0) {
                this._label = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
            }
            if ((this._linkOpts & 128) != 0) {
                this._targetFrame = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
            }
            int i7 = this._linkOpts;
            if ((i7 & 1) != 0 && (i7 & 256) != 0) {
                this._moniker = null;
                this._address = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
            }
            int i8 = this._linkOpts;
            if ((i8 & 1) != 0 && (i8 & 256) == 0) {
                ClassID classID = new ClassID(recordInputStream);
                this._moniker = classID;
                if (ClassIDPredefined.URL_MONIKER.equals(classID)) {
                    int i9 = recordInputStream.readInt();
                    if (i9 == recordInputStream.remaining()) {
                        this._address = recordInputStream.readUnicodeLEString(i9 / 2);
                    } else {
                        this._address = recordInputStream.readUnicodeLEString((i9 - TAIL_SIZE) / 2);
                        this._uninterpretedTail = readTail(URL_TAIL, recordInputStream);
                    }
                } else if (ClassIDPredefined.FILE_MONIKER.equals(this._moniker)) {
                    this._fileOpts = recordInputStream.readShort();
                    this._shortFilename = StringUtil.readCompressedUnicode(recordInputStream, recordInputStream.readInt());
                    this._uninterpretedTail = readTail(FILE_TAIL, recordInputStream);
                    if (recordInputStream.readInt() > 0) {
                        int i10 = recordInputStream.readInt();
                        recordInputStream.readUShort();
                        this._address = StringUtil.readUnicodeLE(recordInputStream, i10 / 2);
                    } else {
                        this._address = null;
                    }
                } else if (ClassIDPredefined.STD_MONIKER.equals(this._moniker)) {
                    this._fileOpts = recordInputStream.readShort();
                    byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(recordInputStream.readInt(), HSSFWorkbook.getMaxRecordLength());
                    recordInputStream.readFully(bArrSafelyAllocate);
                    this._address = new String(bArrSafelyAllocate, StringUtil.UTF8);
                }
            }
            if ((this._linkOpts & 8) != 0) {
                this._textMark = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
            }
            if (recordInputStream.remaining() > 0) {
                LOG.atWarn().log("Hyperlink data remains: {} : {}", Unbox.box(recordInputStream.remaining()), HexDump.toHex(recordInputStream.readRemainder()));
                return;
            }
            return;
        }
        throw new RecordFormatException(AbstractC0157z.k(i5, "Stream Version must be 0x2 but found "));
    }
}
