package org.apache.poi.xssf.binary;

import V2.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFBHyperlinksTable {
    private static final f RECORDS;
    private final List<XSSFHyperlinkRecord> hyperlinkRecords = new ArrayList();
    private Map<String, String> relIdToHyperlink = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class HyperlinkSheetScraper extends XSSFBParser {
        private XSSFBCellRange hyperlinkCellRange;
        private final StringBuilder xlWideStringBuffer;

        public HyperlinkSheetScraper(InputStream inputStream) {
            super(inputStream, XSSFBHyperlinksTable.RECORDS);
            this.hyperlinkCellRange = new XSSFBCellRange();
            this.xlWideStringBuffer = new StringBuilder();
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i5, byte[] bArr) {
            if (i5 != XSSFBRecordType.BrtHLink.getId()) {
                return;
            }
            this.hyperlinkCellRange = XSSFBCellRange.parse(bArr, 0, this.hyperlinkCellRange);
            this.xlWideStringBuffer.setLength(0);
            int xLNullableWideString = XSSFBUtils.readXLNullableWideString(bArr, 16, this.xlWideStringBuffer) + 16;
            String string = this.xlWideStringBuffer.toString();
            this.xlWideStringBuffer.setLength(0);
            int xLWideString = XSSFBUtils.readXLWideString(bArr, xLNullableWideString, this.xlWideStringBuffer) + xLNullableWideString;
            String string2 = this.xlWideStringBuffer.toString();
            this.xlWideStringBuffer.setLength(0);
            int xLWideString2 = XSSFBUtils.readXLWideString(bArr, xLWideString, this.xlWideStringBuffer) + xLWideString;
            String string3 = this.xlWideStringBuffer.toString();
            this.xlWideStringBuffer.setLength(0);
            XSSFBUtils.readXLWideString(bArr, xLWideString2, this.xlWideStringBuffer);
            String string4 = this.xlWideStringBuffer.toString();
            XSSFBCellRange xSSFBCellRange = this.hyperlinkCellRange;
            XSSFBHyperlinksTable.this.hyperlinkRecords.add(new XSSFHyperlinkRecord(new CellRangeAddress(xSSFBCellRange.firstRow, xSSFBCellRange.lastRow, xSSFBCellRange.firstCol, xSSFBCellRange.lastCol), string, string2.length() == 0 ? (String) XSSFBHyperlinksTable.this.relIdToHyperlink.get(string) : string2, string3, string4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TopLeftCellAddressComparator implements Comparator<CellAddress>, Serializable {
        private static final long serialVersionUID = 1;

        private TopLeftCellAddressComparator() {
        }

        @Override // java.util.Comparator
        public int compare(CellAddress cellAddress, CellAddress cellAddress2) {
            if (cellAddress.getRow() < cellAddress2.getRow()) {
                return -1;
            }
            if (cellAddress.getRow() > cellAddress2.getRow()) {
                return 1;
            }
            if (cellAddress.getColumn() < cellAddress2.getColumn()) {
                return -1;
            }
            return cellAddress.getColumn() > cellAddress2.getColumn() ? 1 : 0;
        }
    }

    static {
        f fVar = new f();
        RECORDS = fVar;
        fVar.j(XSSFBRecordType.BrtHLink.getId());
    }

    public XSSFBHyperlinksTable(PackagePart packagePart) throws IOException {
        loadUrlsFromSheetRels(packagePart);
        InputStream inputStream = packagePart.getInputStream();
        try {
            new HyperlinkSheetScraper(inputStream).parse();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private void loadUrlsFromSheetRels(PackagePart packagePart) {
        try {
            for (PackageRelationship packageRelationship : packagePart.getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation())) {
                this.relIdToHyperlink.put(packageRelationship.getId(), packageRelationship.getTargetURI().toString());
            }
        } catch (InvalidFormatException unused) {
        }
    }

    public List<XSSFHyperlinkRecord> findHyperlinkRecord(CellAddress cellAddress) {
        CellRangeAddress cellRangeAddress = new CellRangeAddress(cellAddress.getRow(), cellAddress.getRow(), cellAddress.getColumn(), cellAddress.getColumn());
        ArrayList arrayList = null;
        for (XSSFHyperlinkRecord xSSFHyperlinkRecord : this.hyperlinkRecords) {
            if (CellRangeUtil.intersect(cellRangeAddress, xSSFHyperlinkRecord.getCellRangeAddress()) != 1) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(xSSFHyperlinkRecord);
            }
        }
        return arrayList;
    }

    public Map<CellAddress, List<XSSFHyperlinkRecord>> getHyperLinks() {
        TreeMap treeMap = new TreeMap(new TopLeftCellAddressComparator());
        for (XSSFHyperlinkRecord xSSFHyperlinkRecord : this.hyperlinkRecords) {
            CellAddress cellAddress = new CellAddress(xSSFHyperlinkRecord.getCellRangeAddress().getFirstRow(), xSSFHyperlinkRecord.getCellRangeAddress().getFirstColumn());
            List arrayList = (List) treeMap.get(cellAddress);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(xSSFHyperlinkRecord);
            treeMap.put(cellAddress, arrayList);
        }
        return treeMap;
    }
}
