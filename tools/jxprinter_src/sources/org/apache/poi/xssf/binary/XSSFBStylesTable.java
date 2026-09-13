package org.apache.poi.xssf.binary;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFBStylesTable extends XSSFBParser {
    private boolean inCellXFS;
    private boolean inFmts;
    private final SortedMap<Short, String> numberFormats;
    private final List<Short> styleIds;

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBStylesTable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtBeginCellXFs.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndCellXFs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtXf.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtBeginFmts.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndFmts.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmt.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public XSSFBStylesTable(InputStream inputStream) throws IOException {
        super(inputStream);
        this.numberFormats = new TreeMap();
        this.styleIds = new ArrayList();
        parse();
    }

    private void handleBrtXFInCellXF(byte[] bArr) {
        this.styleIds.add(Short.valueOf((short) (bArr[2] & UnsignedBytes.MAX_VALUE)));
    }

    private void handleFormat(byte[] bArr) {
        int i5 = bArr[0] & UnsignedBytes.MAX_VALUE;
        if (i5 > 32767) {
            throw new POIXMLException("Format id must be a short");
        }
        StringBuilder sb = new StringBuilder();
        XSSFBUtils.readXLWideString(bArr, 2, sb);
        this.numberFormats.put(Short.valueOf((short) i5), sb.toString());
    }

    public short getNumberFormatIndex(int i5) {
        return this.styleIds.get(i5).shortValue();
    }

    public String getNumberFormatString(int i5) {
        short numberFormatIndex = getNumberFormatIndex(i5);
        return this.numberFormats.containsKey(Short.valueOf(numberFormatIndex)) ? this.numberFormats.get(Short.valueOf(numberFormatIndex)) : BuiltinFormats.getBuiltinFormat(numberFormatIndex);
    }

    @Override // org.apache.poi.xssf.binary.XSSFBParser
    public void handleRecord(int i5, byte[] bArr) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i5).ordinal()]) {
            case 1:
                this.inCellXFS = true;
                break;
            case 2:
                this.inCellXFS = false;
                break;
            case 3:
                if (this.inCellXFS) {
                    handleBrtXFInCellXF(bArr);
                }
                break;
            case 4:
                this.inFmts = true;
                break;
            case 5:
                this.inFmts = false;
                break;
            case 6:
                if (this.inFmts) {
                    handleFormat(bArr);
                }
                break;
        }
    }
}
