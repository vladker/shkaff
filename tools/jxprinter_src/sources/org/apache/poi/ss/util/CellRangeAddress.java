package org.apache.poi.ss.util;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellRangeAddress extends CellRangeAddressBase {
    public static final int ENCODED_SIZE = 8;

    public CellRangeAddress(int i5, int i6, int i7, int i8) {
        super(i5, i6, i7, i8);
        if (i6 < i5 || i8 < i7) {
            throw new IllegalArgumentException(androidx.exifinterface.media.a.i(" >= ", i8, i7, androidx.collection.a.s("Invalid cell range, having lastRow < firstRow || lastCol < firstCol, had rows ", i6, i5, " >= ", " or cells ")));
        }
    }

    public static int getEncodedSize(int i5) {
        return i5 * 8;
    }

    private static int readUShortAndCheck(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() >= 8) {
            return recordInputStream.readUShort();
        }
        throw new IllegalArgumentException("Ran out of data reading CellRangeAddress");
    }

    public static CellRangeAddress valueOf(String str) {
        CellReference cellReference;
        CellReference cellReference2;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            cellReference2 = new CellReference(str);
            cellReference = cellReference2;
        } else {
            CellReference cellReference3 = new CellReference(str.substring(0, iIndexOf));
            cellReference = new CellReference(str.substring(iIndexOf + 1));
            cellReference2 = cellReference3;
        }
        return new CellRangeAddress(cellReference2.getRow(), cellReference.getRow(), cellReference2.getCol(), cellReference.getCol());
    }

    public String formatAsString() {
        return formatAsString(null, false);
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFirstRow());
        littleEndianOutput.writeShort(getLastRow());
        littleEndianOutput.writeShort(getFirstColumn());
        littleEndianOutput.writeShort(getLastColumn());
    }

    @Override // org.apache.poi.common.Duplicatable
    public CellRangeAddress copy() {
        return new CellRangeAddress(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());
    }

    public String formatAsString(String str, boolean z6) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(SheetNameFormatter.format(str));
            sb.append('!');
        }
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn(), z6, z6);
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn(), z6, z6);
        sb.append(cellReference.formatAsString());
        if (!cellReference.equals(cellReference2) || isFullColumnRange() || isFullRowRange()) {
            sb.append(NameUtil.COLON);
            sb.append(cellReference2.formatAsString());
        }
        return sb.toString();
    }

    public CellRangeAddress(RecordInputStream recordInputStream) {
        super(readUShortAndCheck(recordInputStream), recordInputStream.readUShort(), recordInputStream.readUShort(), recordInputStream.readUShort());
    }
}
