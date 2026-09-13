package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationName;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class BaseXSSFEvaluationWorkbook implements FormulaRenderingWorkbook, EvaluationWorkbook, FormulaParsingWorkbook {
    private Map<String, XSSFTable> _tableCache;
    protected final XSSFWorkbook _uBook;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FakeExternalLinksTable extends ExternalLinksTable {
        private final String fileName;

        @Override // org.apache.poi.xssf.model.ExternalLinksTable
        public String getLinkedFileName() {
            return this.fileName;
        }

        private FakeExternalLinksTable(String str) {
            this.fileName = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Name implements EvaluationName {
        private final FormulaParsingWorkbook _fpBook;
        private final int _index;
        private final XSSFName _nameRecord;

        public Name(XSSFName xSSFName, int i5, FormulaParsingWorkbook formulaParsingWorkbook) {
            this._nameRecord = xSSFName;
            this._index = i5;
            this._fpBook = formulaParsingWorkbook;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public NamePtg createPtg() {
            return new NamePtg(this._index);
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public Ptg[] getNameDefinition() {
            return FormulaParser.parse(this._nameRecord.getRefersToFormula(), this._fpBook, FormulaType.NAMEDRANGE, this._nameRecord.getSheetIndex());
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public String getNameText() {
            return this._nameRecord.getNameName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean hasFormula() {
            CTDefinedName cTName = this._nameRecord.getCTName();
            String stringValue = cTName.getStringValue();
            return (cTName.getFunction() || stringValue == null || stringValue.length() <= 0) ? false : true;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isFunctionName() {
            return this._nameRecord.isFunctionName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isRange() {
            return hasFormula();
        }
    }

    public BaseXSSFEvaluationWorkbook(XSSFWorkbook xSSFWorkbook) {
        this._uBook = xSSFWorkbook;
    }

    private int findExternalLinkIndex(String str, List<ExternalLinksTable> list) {
        Iterator<ExternalLinksTable> it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next().getLinkedFileName().equals(str)) {
                return i5 + 1;
            }
            i5++;
        }
        return -1;
    }

    private Map<String, XSSFTable> getTableCache() {
        Map<String, XSSFTable> map = this._tableCache;
        if (map != null) {
            return map;
        }
        this._tableCache = new ConcurrentSkipListMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Sheet> it = this._uBook.iterator();
        while (it.hasNext()) {
            for (XSSFTable xSSFTable : ((XSSFSheet) it.next()).getTables()) {
                this._tableCache.put(xSSFTable.getName(), xSSFTable);
            }
        }
        return this._tableCache;
    }

    private int resolveBookIndex(String str) {
        if (str.startsWith("[") && str.endsWith("]")) {
            str = androidx.collection.a.g(2, 1, str);
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            List<ExternalLinksTable> externalLinksTable = this._uBook.getExternalLinksTable();
            int iFindExternalLinkIndex = findExternalLinkIndex(str, externalLinksTable);
            if (iFindExternalLinkIndex != -1) {
                return iFindExternalLinkIndex;
            }
            if (!str.startsWith("'file:///") || !str.endsWith("'")) {
                throw new RuntimeException("Book not linked for filename ".concat(str));
            }
            String strG = androidx.collection.a.g(1, 0, str.substring(str.lastIndexOf(47) + 1));
            int iFindExternalLinkIndex2 = findExternalLinkIndex(strG, externalLinksTable);
            if (iFindExternalLinkIndex2 != -1) {
                return iFindExternalLinkIndex2;
            }
            externalLinksTable.add(new FakeExternalLinksTable(strG));
            return externalLinksTable.size();
        }
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public void clearAllCachedResultValues() {
        this._tableCache = null;
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(CellReference cellReference, SheetIdentifier sheetIdentifier) {
        return sheetIdentifier.getBookName() != null ? new Ref3DPxg(resolveBookIndex(sheetIdentifier.getBookName()), sheetIdentifier, cellReference) : new Ref3DPxg(sheetIdentifier, cellReference);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(int i5, int i6) {
        throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook, org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(int i5) {
        throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public int getExternalSheetIndex(String str) {
        return convertToExternalSheetIndex(this._uBook.getSheetIndex(str));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public EvaluationName getName(String str, int i5) {
        for (int i6 = 0; i6 < this._uBook.getNumberOfNames(); i6++) {
            XSSFName nameAt = this._uBook.getNameAt(i6);
            String nameName = nameAt.getNameName();
            int sheetIndex = nameAt.getSheetIndex();
            if (str.equalsIgnoreCase(nameName) && (sheetIndex == -1 || sheetIndex == i5)) {
                return new Name(nameAt, i6, this);
            }
        }
        if (i5 == -1) {
            return null;
        }
        return getName(str, -1);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getNameText(NamePtg namePtg) {
        return this._uBook.getNameAt(namePtg.getIndex()).getNameName();
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetFirstNameByExternSheet(int i5) {
        return this._uBook.getSheetName(convertFromExternalSheetIndex(i5));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(String str) {
        return this._uBook.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetLastNameByExternSheet(int i5) {
        return getSheetFirstNameByExternSheet(i5);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public String getSheetName(int i5) {
        return this._uBook.getSheetName(i5);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public UDFFinder getUDFFinder() {
        return this._uBook.getUDFFinder();
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook, org.apache.poi.ss.formula.EvaluationWorkbook
    public String resolveNameXText(NameXPtg nameXPtg) {
        XSSFName nameAt;
        int nameIndex = nameXPtg.getNameIndex();
        String functionName = ((IndexedUDFFinder) getUDFFinder()).getFunctionName(nameIndex);
        return (functionName == null && (nameAt = this._uBook.getNameAt(nameIndex)) != null) ? nameAt.getNameName() : functionName;
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public XSSFName createName() {
        return this._uBook.createName();
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(String str, String str2, int i5) {
        if (i5 <= 0) {
            return new EvaluationWorkbook.ExternalName(str, this._uBook.getNameIndex(str), 0);
        }
        ExternalLinksTable externalLinksTable = this._uBook.getExternalLinksTable().get(i5 - 1);
        for (org.apache.poi.ss.usermodel.Name name : externalLinksTable.getDefinedNames()) {
            if (name.getNameName().equals(str)) {
                return new EvaluationWorkbook.ExternalName(str, -1, name.getSheetIndex() + 1);
            }
        }
        StringBuilder sbY = AbstractC0157z.y("Name '", str, "' not found in reference to ");
        sbY.append(externalLinksTable.getLinkedFileName());
        throw new IllegalArgumentException(sbY.toString());
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(String str, String str2, int i5) {
        String linkedFileName;
        if (i5 > 0) {
            linkedFileName = this._uBook.getExternalLinksTable().get(i5 - 1).getLinkedFileName();
        } else {
            linkedFileName = null;
        }
        return (str2 == null || str.equals(str2)) ? new EvaluationWorkbook.ExternalSheet(linkedFileName, str) : new EvaluationWorkbook.ExternalSheetRange(linkedFileName, str, str2);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public NameXPxg getNameXPtg(String str, SheetIdentifier sheetIdentifier) {
        if (((IndexedUDFFinder) getUDFFinder()).findFunction(str) != null) {
            return new NameXPxg(null, str);
        }
        if (sheetIdentifier == null) {
            if (this._uBook.getNames(str).isEmpty()) {
                return null;
            }
            return new NameXPxg(null, str);
        }
        if (sheetIdentifier.getSheetIdentifier() == null) {
            return new NameXPxg(resolveBookIndex(sheetIdentifier.getBookName()), null, str);
        }
        String name = sheetIdentifier.getSheetIdentifier().getName();
        return sheetIdentifier.getBookName() != null ? new NameXPxg(resolveBookIndex(sheetIdentifier.getBookName()), name, str) : new NameXPxg(name, str);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public XSSFTable getTable(String str) {
        if (str == null) {
            return null;
        }
        return getTableCache().get(str);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    @NotImplemented
    public int getExternalSheetIndex(String str, String str2) {
        throw new RuntimeException("not implemented yet");
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(AreaReference areaReference, SheetIdentifier sheetIdentifier) {
        if (sheetIdentifier.getBookName() != null) {
            return new Area3DPxg(resolveBookIndex(sheetIdentifier.getBookName()), sheetIdentifier, areaReference);
        }
        return new Area3DPxg(sheetIdentifier, areaReference);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationName getName(NamePtg namePtg) {
        int index = namePtg.getIndex();
        return new Name(this._uBook.getNameAt(index), index, this);
    }

    private int convertFromExternalSheetIndex(int i5) {
        return i5;
    }

    private int convertToExternalSheetIndex(int i5) {
        return i5;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int convertFromExternSheetIndex(int i5) {
        return i5;
    }
}
