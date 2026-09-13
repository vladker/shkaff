package org.apache.poi.hssf.model;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.CRNCountRecord;
import org.apache.poi.hssf.record.CRNRecord;
import org.apache.poi.hssf.record.ExternSheetRecord;
import org.apache.poi.hssf.record.ExternalNameRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.SupBookRecord;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Workbook;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class LinkTable {
    private final List<NameRecord> _definedNames;
    private final ExternSheetRecord _externSheetRecord;
    private ExternalBookBlock[] _externalBookBlocks;
    private final int _recordCount;
    private final WorkbookRecordList _workbookRecordList;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CRNBlock {
        private final CRNCountRecord _countRecord;
        private final CRNRecord[] _crns;

        public CRNBlock(RecordStream recordStream) {
            CRNCountRecord cRNCountRecord = (CRNCountRecord) recordStream.getNext();
            this._countRecord = cRNCountRecord;
            int numberOfCRNs = cRNCountRecord.getNumberOfCRNs();
            CRNRecord[] cRNRecordArr = new CRNRecord[numberOfCRNs];
            for (int i5 = 0; i5 < numberOfCRNs; i5++) {
                cRNRecordArr[i5] = (CRNRecord) recordStream.getNext();
            }
            this._crns = cRNRecordArr;
        }

        public CRNRecord[] getCrns() {
            return (CRNRecord[]) this._crns.clone();
        }
    }

    public LinkTable(List<Record> list, int i5, WorkbookRecordList workbookRecordList, Map<String, NameCommentRecord> map) {
        this._workbookRecordList = workbookRecordList;
        RecordStream recordStream = new RecordStream(list, i5);
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextClass() == SupBookRecord.class) {
            arrayList.add(new ExternalBookBlock(recordStream));
        }
        ExternalBookBlock[] externalBookBlockArr = new ExternalBookBlock[arrayList.size()];
        this._externalBookBlocks = externalBookBlockArr;
        arrayList.toArray(externalBookBlockArr);
        arrayList.clear();
        if (this._externalBookBlocks.length <= 0 || recordStream.peekNextClass() != ExternSheetRecord.class) {
            this._externSheetRecord = null;
        } else {
            this._externSheetRecord = readExtSheetRecord(recordStream);
        }
        this._definedNames = new ArrayList();
        while (true) {
            Class<? extends Record> clsPeekNextClass = recordStream.peekNextClass();
            if (clsPeekNextClass == NameRecord.class) {
                this._definedNames.add((NameRecord) recordStream.getNext());
            } else {
                if (clsPeekNextClass != NameCommentRecord.class) {
                    int countRead = recordStream.getCountRead();
                    this._recordCount = countRead;
                    this._workbookRecordList.getRecords().addAll(list.subList(i5, countRead + i5));
                    return;
                }
                NameCommentRecord nameCommentRecord = (NameCommentRecord) recordStream.getNext();
                map.put(nameCommentRecord.getNameText(), nameCommentRecord);
            }
        }
    }

    private int extendExternalBookBlocks(ExternalBookBlock externalBookBlock) {
        ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
        int length = externalBookBlockArr.length;
        ExternalBookBlock[] externalBookBlockArr2 = new ExternalBookBlock[length + 1];
        System.arraycopy(externalBookBlockArr, 0, externalBookBlockArr2, 0, externalBookBlockArr.length);
        externalBookBlockArr2[length] = externalBookBlock;
        this._externalBookBlocks = externalBookBlockArr2;
        return externalBookBlockArr2.length - 1;
    }

    private int findFirstRecordLocBySid(short s6) {
        Iterator<Record> it = this._workbookRecordList.getRecords().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next().getSid() == s6) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private int findRefIndexFromExtBookIndex(int i5) {
        return this._externSheetRecord.findRefIndexFromExtBookIndex(i5);
    }

    private int getExternalWorkbookIndex(String str) {
        int i5 = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (i5 >= externalBookBlockArr.length) {
                return -1;
            }
            SupBookRecord externalBookRecord = externalBookBlockArr[i5].getExternalBookRecord();
            if (externalBookRecord.isExternalReferences() && str.equals(externalBookRecord.getURL())) {
                return i5;
            }
            i5++;
        }
    }

    private static int getSheetIndex(String[] strArr, String str) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5].equals(str)) {
                return i5;
            }
        }
        throw new RuntimeException(AbstractC0157z.o("External workbook does not contain sheet '", str, "'"));
    }

    private static boolean isDuplicatedNames(NameRecord nameRecord, NameRecord nameRecord2) {
        return nameRecord2.getNameText().equalsIgnoreCase(nameRecord.getNameText()) && isSameSheetNames(nameRecord, nameRecord2);
    }

    private static boolean isSameSheetNames(NameRecord nameRecord, NameRecord nameRecord2) {
        return nameRecord2.getSheetNumber() == nameRecord.getSheetNumber();
    }

    private static ExternSheetRecord readExtSheetRecord(RecordStream recordStream) {
        ArrayList arrayList = new ArrayList(2);
        while (recordStream.peekNextClass() == ExternSheetRecord.class) {
            arrayList.add((ExternSheetRecord) recordStream.getNext());
        }
        int size = arrayList.size();
        if (size < 1) {
            throw new RuntimeException("Expected an EXTERNSHEET record but got (" + recordStream.peekNextClass().getName() + ")");
        }
        if (size == 1) {
            return (ExternSheetRecord) arrayList.get(0);
        }
        ExternSheetRecord[] externSheetRecordArr = new ExternSheetRecord[size];
        arrayList.toArray(externSheetRecordArr);
        return ExternSheetRecord.combine(externSheetRecordArr);
    }

    public void addName(NameRecord nameRecord) {
        this._definedNames.add(nameRecord);
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 23);
        if (iFindFirstRecordLocBySid == -1) {
            iFindFirstRecordLocBySid = findFirstRecordLocBySid(SupBookRecord.sid);
        }
        if (iFindFirstRecordLocBySid == -1) {
            iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 140);
        }
        this._workbookRecordList.add(iFindFirstRecordLocBySid + this._definedNames.size(), nameRecord);
    }

    public NameXPtg addNameXPtg(String str) {
        ExternalBookBlock externalBookBlock;
        int i5 = 0;
        int iExtendExternalBookBlocks = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (iExtendExternalBookBlocks >= externalBookBlockArr.length) {
                iExtendExternalBookBlocks = -1;
                externalBookBlock = null;
                break;
            }
            if (externalBookBlockArr[iExtendExternalBookBlocks].getExternalBookRecord().isAddInFunctions()) {
                externalBookBlock = this._externalBookBlocks[iExtendExternalBookBlocks];
                break;
            }
            iExtendExternalBookBlocks++;
        }
        if (externalBookBlock == null) {
            externalBookBlock = new ExternalBookBlock();
            iExtendExternalBookBlocks = extendExternalBookBlocks(externalBookBlock);
            this._workbookRecordList.add(findFirstRecordLocBySid((short) 23), externalBookBlock.getExternalBookRecord());
            this._externSheetRecord.addRef(this._externalBookBlocks.length - 1, -2, -2);
        }
        ExternalNameRecord externalNameRecord = new ExternalNameRecord();
        externalNameRecord.setText(str);
        externalNameRecord.setParsedExpression(new Ptg[]{ErrPtg.REF_INVALID});
        int iAddExternalName = externalBookBlock.addExternalName(externalNameRecord);
        for (Record record : this._workbookRecordList.getRecords()) {
            if ((record instanceof SupBookRecord) && ((SupBookRecord) record).isAddInFunctions()) {
                break;
            }
            i5++;
        }
        this._workbookRecordList.add(i5 + externalBookBlock.getNumberOfNames(), externalNameRecord);
        return new NameXPtg(this._externSheetRecord.getRefIxForSheet(iExtendExternalBookBlocks, -2, -2), iAddExternalName);
    }

    public boolean changeExternalReference(String str, String str2) {
        for (ExternalBookBlock externalBookBlock : this._externalBookBlocks) {
            SupBookRecord externalBookRecord = externalBookBlock.getExternalBookRecord();
            if (externalBookRecord.isExternalReferences() && externalBookRecord.getURL().equals(str)) {
                externalBookRecord.setURL(str2);
                return true;
            }
        }
        return false;
    }

    public int checkExternSheet(int i5) {
        return checkExternSheet(i5, i5);
    }

    public String[] getExternalBookAndSheetName(int i5) {
        SupBookRecord externalBookRecord = this._externalBookBlocks[this._externSheetRecord.getExtbookIndexFromRefIndex(i5)].getExternalBookRecord();
        if (!externalBookRecord.isExternalReferences()) {
            return null;
        }
        int firstSheetIndexFromRefIndex = this._externSheetRecord.getFirstSheetIndexFromRefIndex(i5);
        int lastSheetIndexFromRefIndex = this._externSheetRecord.getLastSheetIndexFromRefIndex(i5);
        String str = firstSheetIndexFromRefIndex >= 0 ? externalBookRecord.getSheetNames()[firstSheetIndexFromRefIndex] : null;
        return firstSheetIndexFromRefIndex == lastSheetIndexFromRefIndex ? new String[]{externalBookRecord.getURL(), str} : new String[]{externalBookRecord.getURL(), str, lastSheetIndexFromRefIndex >= 0 ? externalBookRecord.getSheetNames()[lastSheetIndexFromRefIndex] : null};
    }

    public int getExternalSheetIndex(String str, String str2, String str3) {
        int externalWorkbookIndex = getExternalWorkbookIndex(str);
        if (externalWorkbookIndex == -1) {
            throw new RuntimeException(AbstractC0157z.o("No external workbook with name '", str, "'"));
        }
        SupBookRecord externalBookRecord = this._externalBookBlocks[externalWorkbookIndex].getExternalBookRecord();
        int sheetIndex = getSheetIndex(externalBookRecord.getSheetNames(), str2);
        int sheetIndex2 = getSheetIndex(externalBookRecord.getSheetNames(), str3);
        int refIxForSheet = this._externSheetRecord.getRefIxForSheet(externalWorkbookIndex, sheetIndex, sheetIndex2);
        return refIxForSheet < 0 ? this._externSheetRecord.addRef(externalWorkbookIndex, sheetIndex, sheetIndex2) : refIxForSheet;
    }

    public int getFirstInternalSheetIndexForExtIndex(int i5) {
        if (i5 >= this._externSheetRecord.getNumOfRefs() || i5 < 0) {
            return -1;
        }
        return this._externSheetRecord.getFirstSheetIndexFromRefIndex(i5);
    }

    public int getLastInternalSheetIndexForExtIndex(int i5) {
        if (i5 >= this._externSheetRecord.getNumOfRefs() || i5 < 0) {
            return -1;
        }
        return this._externSheetRecord.getLastSheetIndexFromRefIndex(i5);
    }

    public NameRecord getNameRecord(int i5) {
        return this._definedNames.get(i5);
    }

    public NameXPtg getNameXPtg(String str, int i5) {
        int iFindRefIndexFromExtBookIndex;
        int i6 = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (i6 >= externalBookBlockArr.length) {
                return null;
            }
            int indexOfName = externalBookBlockArr[i6].getIndexOfName(str);
            if (indexOfName >= 0 && (iFindRefIndexFromExtBookIndex = findRefIndexFromExtBookIndex(i6)) >= 0 && (i5 == -1 || iFindRefIndexFromExtBookIndex == i5)) {
                return new NameXPtg(iFindRefIndexFromExtBookIndex, indexOfName);
            }
            i6++;
        }
    }

    public int getNumNames() {
        return this._definedNames.size();
    }

    public int getRecordCount() {
        return this._recordCount;
    }

    public NameRecord getSpecificBuiltinRecord(byte b, int i5) {
        for (NameRecord nameRecord : this._definedNames) {
            if (nameRecord.getBuiltInName() == b && nameRecord.getSheetNumber() == i5) {
                return nameRecord;
            }
        }
        return null;
    }

    public int linkExternalWorkbook(String str, Workbook workbook) {
        int externalWorkbookIndex = getExternalWorkbookIndex(str);
        if (externalWorkbookIndex != -1) {
            return externalWorkbookIndex;
        }
        int numberOfSheets = workbook.getNumberOfSheets();
        String[] strArr = new String[numberOfSheets];
        for (int i5 = 0; i5 < numberOfSheets; i5++) {
            strArr[i5] = workbook.getSheetName(i5);
        }
        ExternalBookBlock externalBookBlock = new ExternalBookBlock(AbstractC0157z.n(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, str), strArr);
        int iExtendExternalBookBlocks = extendExternalBookBlocks(externalBookBlock);
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 23);
        if (iFindFirstRecordLocBySid == -1) {
            iFindFirstRecordLocBySid = this._workbookRecordList.size();
        }
        this._workbookRecordList.add(iFindFirstRecordLocBySid, externalBookBlock.getExternalBookRecord());
        for (int i6 = 0; i6 < numberOfSheets; i6++) {
            this._externSheetRecord.addRef(iExtendExternalBookBlocks, i6, i6);
        }
        return iExtendExternalBookBlocks;
    }

    public boolean nameAlreadyExists(NameRecord nameRecord) {
        for (int numNames = getNumNames() - 1; numNames >= 0; numNames--) {
            NameRecord nameRecord2 = getNameRecord(numNames);
            if (nameRecord2 != nameRecord && isDuplicatedNames(nameRecord, nameRecord2)) {
                return true;
            }
        }
        return false;
    }

    public void removeBuiltinRecord(byte b, int i5) {
        NameRecord specificBuiltinRecord = getSpecificBuiltinRecord(b, i5);
        if (specificBuiltinRecord != null) {
            this._definedNames.remove(specificBuiltinRecord);
        }
    }

    public void removeName(int i5) {
        this._definedNames.remove(i5);
    }

    public void removeSheet(int i5) {
        this._externSheetRecord.removeSheet(i5);
    }

    public int resolveNameXIx(int i5, int i6) {
        return this._externalBookBlocks[this._externSheetRecord.getExtbookIndexFromRefIndex(i5)].getNameIx(i6);
    }

    public String resolveNameXText(int i5, int i6, InternalWorkbook internalWorkbook) {
        int extbookIndexFromRefIndex = this._externSheetRecord.getExtbookIndexFromRefIndex(i5);
        int firstSheetIndexFromRefIndex = this._externSheetRecord.getFirstSheetIndexFromRefIndex(i5);
        if (firstSheetIndexFromRefIndex == -1) {
            throw new RuntimeException("Referenced sheet could not be found");
        }
        if (this._externalBookBlocks[extbookIndexFromRefIndex]._externalNameRecords.length > i6) {
            return this._externalBookBlocks[extbookIndexFromRefIndex].getNameText(i6);
        }
        if (firstSheetIndexFromRefIndex != -2) {
            StringBuilder sbT = AbstractC0157z.t(extbookIndexFromRefIndex, "Ext Book Index relative but beyond the supported length, was ", " but maximum is ");
            sbT.append(this._externalBookBlocks.length);
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
        NameRecord nameRecord = getNameRecord(i6);
        int sheetNumber = nameRecord.getSheetNumber();
        StringBuilder sb = new StringBuilder(64);
        if (sheetNumber > 0) {
            SheetNameFormatter.appendFormat(sb, internalWorkbook.getSheetName(sheetNumber - 1));
            sb.append("!");
        }
        sb.append(nameRecord.getNameText());
        return sb.toString();
    }

    public int checkExternSheet(int i5, int i6) {
        int i7 = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (i7 >= externalBookBlockArr.length) {
                i7 = -1;
                break;
            }
            if (externalBookBlockArr[i7].getExternalBookRecord().isInternalReferences()) {
                break;
            }
            i7++;
        }
        if (i7 < 0) {
            throw new RuntimeException("Could not find 'internal references' EXTERNALBOOK");
        }
        ExternSheetRecord externSheetRecord = this._externSheetRecord;
        if (externSheetRecord != null) {
            int refIxForSheet = externSheetRecord.getRefIxForSheet(i7, i5, i6);
            return refIxForSheet >= 0 ? refIxForSheet : this._externSheetRecord.addRef(i7, i5, i6);
        }
        throw new RuntimeException("Did not have an external sheet record, having blocks: " + this._externalBookBlocks.length);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ExternalBookBlock {
        private final CRNBlock[] _crnBlocks;
        private final SupBookRecord _externalBookRecord;
        private ExternalNameRecord[] _externalNameRecords;

        public ExternalBookBlock(RecordStream recordStream) {
            this._externalBookRecord = (SupBookRecord) recordStream.getNext();
            ArrayList arrayList = new ArrayList();
            while (recordStream.peekNextClass() == ExternalNameRecord.class) {
                arrayList.add(recordStream.getNext());
            }
            ExternalNameRecord[] externalNameRecordArr = new ExternalNameRecord[arrayList.size()];
            this._externalNameRecords = externalNameRecordArr;
            arrayList.toArray(externalNameRecordArr);
            arrayList.clear();
            while (recordStream.peekNextClass() == CRNCountRecord.class) {
                arrayList.add(new CRNBlock(recordStream));
            }
            CRNBlock[] cRNBlockArr = new CRNBlock[arrayList.size()];
            this._crnBlocks = cRNBlockArr;
            arrayList.toArray(cRNBlockArr);
        }

        public int addExternalName(ExternalNameRecord externalNameRecord) {
            ExternalNameRecord[] externalNameRecordArr = this._externalNameRecords;
            int length = externalNameRecordArr.length;
            ExternalNameRecord[] externalNameRecordArr2 = new ExternalNameRecord[length + 1];
            System.arraycopy(externalNameRecordArr, 0, externalNameRecordArr2, 0, externalNameRecordArr.length);
            externalNameRecordArr2[length] = externalNameRecord;
            this._externalNameRecords = externalNameRecordArr2;
            return externalNameRecordArr2.length - 1;
        }

        public SupBookRecord getExternalBookRecord() {
            return this._externalBookRecord;
        }

        public int getIndexOfName(String str) {
            int i5 = 0;
            while (true) {
                ExternalNameRecord[] externalNameRecordArr = this._externalNameRecords;
                if (i5 >= externalNameRecordArr.length) {
                    return -1;
                }
                if (externalNameRecordArr[i5].getText().equalsIgnoreCase(str)) {
                    return i5;
                }
                i5++;
            }
        }

        public int getNameIx(int i5) {
            return this._externalNameRecords[i5].getIx();
        }

        public String getNameText(int i5) {
            return this._externalNameRecords[i5].getText();
        }

        public int getNumberOfNames() {
            return this._externalNameRecords.length;
        }

        public ExternalBookBlock(String str, String[] strArr) {
            this._externalBookRecord = SupBookRecord.createExternalReferences(str, strArr);
            this._crnBlocks = new CRNBlock[0];
        }

        public ExternalBookBlock(int i5) {
            this._externalBookRecord = SupBookRecord.createInternalReferences((short) i5);
            this._externalNameRecords = new ExternalNameRecord[0];
            this._crnBlocks = new CRNBlock[0];
        }

        public ExternalBookBlock() {
            this._externalBookRecord = SupBookRecord.createAddInFunctions();
            this._externalNameRecords = new ExternalNameRecord[0];
            this._crnBlocks = new CRNBlock[0];
        }
    }

    public LinkTable(int i5, WorkbookRecordList workbookRecordList) {
        this._workbookRecordList = workbookRecordList;
        this._definedNames = new ArrayList();
        this._externalBookBlocks = new ExternalBookBlock[]{new ExternalBookBlock(i5)};
        ExternSheetRecord externSheetRecord = new ExternSheetRecord();
        this._externSheetRecord = externSheetRecord;
        this._recordCount = 2;
        Record externalBookRecord = this._externalBookBlocks[0].getExternalBookRecord();
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 140);
        if (iFindFirstRecordLocBySid < 0 && (iFindFirstRecordLocBySid = findFirstRecordLocBySid(SSTRecord.sid) - 1) < 0) {
            throw new RuntimeException("CountryRecord or SSTRecord not found");
        }
        int i6 = iFindFirstRecordLocBySid + 1;
        workbookRecordList.add(i6, externSheetRecord);
        workbookRecordList.add(i6, externalBookRecord);
    }
}
