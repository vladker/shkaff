package org.apache.poi.xssf.binary;

import A3.AbstractC0157z;
import java.io.InputStream;
import java.util.Queue;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.usermodel.XSSFComment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFBSheetHandler extends XSSFBParser {
    private static final int CHECK_ALL_ROWS = -1;
    private final XSSFBCellHeader cellBuffer;
    private final XSSFBCommentsTable comments;
    private int currentRow;
    private final DataFormatter dataFormatter;
    private final boolean formulasNotResults;
    private final XSSFSheetXMLHandler.SheetContentsHandler handler;
    private XSSFBCellRange hyperlinkCellRange;
    private int lastEndedRow;
    private int lastStartedRow;
    private byte[] rkBuffer;
    private final SharedStrings stringsTable;
    private final XSSFBStylesTable styles;
    private StringBuilder xlWideStringBuffer;

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBSheetHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtRowHdr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellIsst.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellSt.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellRk.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellReal.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellBool.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellError.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellBlank.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmlaString.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmlaNum.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmlaError.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndSheetData.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtBeginHeaderFooter.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface SheetContentsHandler extends XSSFSheetXMLHandler.SheetContentsHandler {
        void hyperlinkCell(String str, String str2, String str3, String str4, XSSFComment xSSFComment);
    }

    public XSSFBSheetHandler(InputStream inputStream, XSSFBStylesTable xSSFBStylesTable, XSSFBCommentsTable xSSFBCommentsTable, SharedStrings sharedStrings, XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, DataFormatter dataFormatter, boolean z6) {
        super(inputStream);
        this.lastEndedRow = -1;
        this.lastStartedRow = -1;
        this.rkBuffer = new byte[8];
        this.xlWideStringBuffer = new StringBuilder();
        this.cellBuffer = new XSSFBCellHeader();
        this.styles = xSSFBStylesTable;
        this.comments = xSSFBCommentsTable;
        this.stringsTable = sharedStrings;
        this.handler = sheetContentsHandler;
        this.dataFormatter = dataFormatter;
        this.formulasNotResults = z6;
    }

    private void beforeCellValue(byte[] bArr) {
        XSSFBCellHeader.parse(bArr, 0, this.currentRow, this.cellBuffer);
        checkMissedComments(this.currentRow, this.cellBuffer.getColNum());
    }

    private void checkMissedComments(int i5, int i6) {
        XSSFBCommentsTable xSSFBCommentsTable = this.comments;
        if (xSSFBCommentsTable == null) {
            return;
        }
        Queue<CellAddress> addresses = xSSFBCommentsTable.getAddresses();
        while (!addresses.isEmpty()) {
            CellAddress cellAddressPeek = addresses.peek();
            if (cellAddressPeek.getRow() == i5 && cellAddressPeek.getColumn() < i6) {
                CellAddress cellAddressRemove = addresses.remove();
                dumpEmptyCellComment(cellAddressRemove, this.comments.get(cellAddressRemove));
            } else if (cellAddressPeek.getRow() == i5 && cellAddressPeek.getColumn() == i6) {
                addresses.remove();
                return;
            } else if ((cellAddressPeek.getRow() == i5 && cellAddressPeek.getColumn() > i6) || cellAddressPeek.getRow() > i5) {
                return;
            }
        }
    }

    private void dumpEmptyCellComment(CellAddress cellAddress, XSSFBComment xSSFBComment) {
        this.handler.cell(cellAddress.formatAsString(), null, xSSFBComment);
    }

    private void endRow(int i5) {
        if (this.lastEndedRow == i5) {
            return;
        }
        this.handler.endRow(i5);
        this.lastEndedRow = i5;
    }

    private String formatVal(double d, int i5) {
        String numberFormatString = this.styles.getNumberFormatString(i5);
        short numberFormatIndex = this.styles.getNumberFormatIndex(i5);
        if (numberFormatString == null) {
            numberFormatIndex = 0;
            numberFormatString = BuiltinFormats.getBuiltinFormat(0);
        }
        return this.dataFormatter.formatRawCellContents(d, numberFormatIndex, numberFormatString);
    }

    private void handleBoolean(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(bArr[8] == 1 ? "TRUE" : "FALSE");
    }

    private void handleBrtCellIsst(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(this.stringsTable.getItemAt(XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 8))).getString());
    }

    private void handleCellError(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue("ERROR");
    }

    private void handleCellReal(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(formatVal(LittleEndian.getDouble(bArr, 8), this.cellBuffer.getStyleIdx()));
    }

    private void handleCellRk(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(formatVal(rkNumber(bArr, 8), this.cellBuffer.getStyleIdx()));
    }

    private void handleCellSt(byte[] bArr) {
        beforeCellValue(bArr);
        this.xlWideStringBuffer.setLength(0);
        XSSFBUtils.readXLWideString(bArr, 8, this.xlWideStringBuffer);
        handleCellValue(this.xlWideStringBuffer.toString());
    }

    private void handleCellValue(String str) {
        CellAddress cellAddress = new CellAddress(this.currentRow, this.cellBuffer.getColNum());
        XSSFBCommentsTable xSSFBCommentsTable = this.comments;
        this.handler.cell(cellAddress.formatAsString(), str, xSSFBCommentsTable != null ? xSSFBCommentsTable.get(cellAddress) : null);
    }

    private void handleFmlaError(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue("ERROR");
    }

    private void handleFmlaNum(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(formatVal(LittleEndian.getDouble(bArr, 8), this.cellBuffer.getStyleIdx()));
    }

    private void handleFmlaString(byte[] bArr) {
        beforeCellValue(bArr);
        this.xlWideStringBuffer.setLength(0);
        XSSFBUtils.readXLWideString(bArr, 8, this.xlWideStringBuffer);
        handleCellValue(this.xlWideStringBuffer.toString());
    }

    private void handleHeaderFooter(byte[] bArr) {
        XSSFBHeaderFooters xSSFBHeaderFooters = XSSFBHeaderFooters.parse(bArr);
        outputHeaderFooter(xSSFBHeaderFooters.getHeader());
        outputHeaderFooter(xSSFBHeaderFooters.getFooter());
        outputHeaderFooter(xSSFBHeaderFooters.getHeaderEven());
        outputHeaderFooter(xSSFBHeaderFooters.getFooterEven());
        outputHeaderFooter(xSSFBHeaderFooters.getHeaderFirst());
        outputHeaderFooter(xSSFBHeaderFooters.getFooterFirst());
    }

    private void outputHeaderFooter(XSSFBHeaderFooter xSSFBHeaderFooter) {
        String string = xSSFBHeaderFooter.getString();
        if (StringUtil.isNotBlank(string)) {
            this.handler.headerFooter(string, xSSFBHeaderFooter.isHeader(), xSSFBHeaderFooter.getHeaderFooterTypeLabel());
        }
    }

    private double rkNumber(byte[] bArr, int i5) {
        byte b = bArr[i5];
        boolean z6 = (b & 1) == 1;
        boolean z7 = ((b >> 1) & 1) == 0;
        byte[] bArr2 = this.rkBuffer;
        bArr2[4] = (byte) (((byte) (b & (-2))) & (-3));
        System.arraycopy(bArr, i5 + 1, bArr2, 5, 3);
        double d = z7 ? LittleEndian.getDouble(this.rkBuffer) : LittleEndian.getInt(this.rkBuffer, 4) >> 2;
        return z6 ? d / 100.0d : d;
    }

    private void startRow(int i5) {
        int i6 = this.lastStartedRow;
        if (i5 == i6) {
            return;
        }
        if (i6 != this.lastEndedRow) {
            endRow(i6);
        }
        this.handler.startRow(i5);
        this.lastStartedRow = i5;
    }

    @Override // org.apache.poi.xssf.binary.XSSFBParser
    public void handleRecord(int i5, byte[] bArr) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i5).ordinal()]) {
            case 1:
                int iCastToInt = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 0));
                if (iCastToInt > 1048576) {
                    throw new XSSFBParseException(AbstractC0157z.k(iCastToInt, "Row number beyond allowable range: "));
                }
                this.currentRow = iCastToInt;
                checkMissedComments(iCastToInt);
                startRow(this.currentRow);
                return;
            case 2:
                handleBrtCellIsst(bArr);
                return;
            case 3:
                handleCellSt(bArr);
                return;
            case 4:
                handleCellRk(bArr);
                return;
            case 5:
                handleCellReal(bArr);
                return;
            case 6:
                handleBoolean(bArr);
                return;
            case 7:
                handleCellError(bArr);
                return;
            case 8:
                beforeCellValue(bArr);
                return;
            case 9:
                handleFmlaString(bArr);
                return;
            case 10:
                handleFmlaNum(bArr);
                return;
            case 11:
                handleFmlaError(bArr);
                return;
            case 12:
                checkMissedComments(-1);
                endRow(this.lastStartedRow);
                return;
            case 13:
                handleHeaderFooter(bArr);
                return;
            default:
                return;
        }
    }

    private void checkMissedComments(int i5) {
        XSSFBCommentsTable xSSFBCommentsTable = this.comments;
        if (xSSFBCommentsTable == null) {
            return;
        }
        Queue<CellAddress> addresses = xSSFBCommentsTable.getAddresses();
        int row = -1;
        while (!addresses.isEmpty()) {
            CellAddress cellAddressPeek = addresses.peek();
            if (i5 != -1 && cellAddressPeek.getRow() >= i5) {
                return;
            }
            CellAddress cellAddressRemove = addresses.remove();
            if (cellAddressRemove.getRow() != row) {
                startRow(cellAddressRemove.getRow());
            }
            dumpEmptyCellComment(cellAddressRemove, this.comments.get(cellAddressRemove));
            row = cellAddressRemove.getRow();
        }
    }
}
