package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BottomMarginRecord;
import org.apache.poi.hssf.record.ContinueRecord;
import org.apache.poi.hssf.record.FooterRecord;
import org.apache.poi.hssf.record.HCenterRecord;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.HeaderRecord;
import org.apache.poi.hssf.record.HorizontalPageBreakRecord;
import org.apache.poi.hssf.record.LeftMarginRecord;
import org.apache.poi.hssf.record.Margin;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.apache.poi.hssf.record.PrintSetupRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RightMarginRecord;
import org.apache.poi.hssf.record.TopMarginRecord;
import org.apache.poi.hssf.record.UserSViewBegin;
import org.apache.poi.hssf.record.VCenterRecord;
import org.apache.poi.hssf.record.VerticalPageBreakRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PageSettingsBlock extends RecordAggregate {
    private Record _bitmap;
    private BottomMarginRecord _bottomMargin;
    private PageBreakRecord _columnBreaksRecord;
    private FooterRecord _footer;
    private HCenterRecord _hCenter;
    private HeaderRecord _header;
    private HeaderFooterRecord _headerFooter;
    private LeftMarginRecord _leftMargin;
    private final List<PLSAggregate> _plsRecords;
    private PrintSetupRecord _printSetup;
    private Record _printSize;
    private RightMarginRecord _rightMargin;
    private PageBreakRecord _rowBreaksRecord;
    private final List<HeaderFooterRecord> _sviewHeaderFooters;
    private TopMarginRecord _topMargin;
    private VCenterRecord _vCenter;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PLSAggregate extends RecordAggregate {
        private static final ContinueRecord[] EMPTY_CONTINUE_RECORD_ARRAY = new ContinueRecord[0];
        private final Record _pls;
        private ContinueRecord[] _plsContinues;

        public PLSAggregate(RecordStream recordStream) {
            this._pls = recordStream.getNext();
            if (recordStream.peekNextSid() != 60) {
                this._plsContinues = EMPTY_CONTINUE_RECORD_ARRAY;
                return;
            }
            ArrayList arrayList = new ArrayList();
            while (recordStream.peekNextSid() == 60) {
                arrayList.add((ContinueRecord) recordStream.getNext());
            }
            ContinueRecord[] continueRecordArr = new ContinueRecord[arrayList.size()];
            this._plsContinues = continueRecordArr;
            arrayList.toArray(continueRecordArr);
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
        public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
            recordVisitor.visitRecord(this._pls);
            for (ContinueRecord continueRecord : this._plsContinues) {
                recordVisitor.visitRecord(continueRecord);
            }
        }
    }

    public PageSettingsBlock(RecordStream recordStream) {
        this._sviewHeaderFooters = new ArrayList();
        this._plsRecords = new ArrayList();
        while (readARecord(recordStream)) {
        }
    }

    private void checkNotPresent(Record record) {
        if (record == null) {
            return;
        }
        throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(record.getSid()) + ")");
    }

    private static HCenterRecord createHCenter() {
        HCenterRecord hCenterRecord = new HCenterRecord();
        hCenterRecord.setHCenter(false);
        return hCenterRecord;
    }

    private static PrintSetupRecord createPrintSetup() {
        PrintSetupRecord printSetupRecord = new PrintSetupRecord();
        printSetupRecord.setPaperSize((short) 1);
        printSetupRecord.setScale((short) 100);
        printSetupRecord.setPageStart((short) 1);
        printSetupRecord.setFitWidth((short) 1);
        printSetupRecord.setFitHeight((short) 1);
        printSetupRecord.setOptions((short) 2);
        printSetupRecord.setHResolution((short) 300);
        printSetupRecord.setVResolution((short) 300);
        printSetupRecord.setHeaderMargin(0.5d);
        printSetupRecord.setFooterMargin(0.5d);
        printSetupRecord.setCopies((short) 1);
        return printSetupRecord;
    }

    private static VCenterRecord createVCenter() {
        VCenterRecord vCenterRecord = new VCenterRecord();
        vCenterRecord.setVCenter(false);
        return vCenterRecord;
    }

    private PageBreakRecord getColumnBreaksRecord() {
        if (this._columnBreaksRecord == null) {
            this._columnBreaksRecord = new VerticalPageBreakRecord();
        }
        return this._columnBreaksRecord;
    }

    private Margin getMarginRec(int i5) {
        if (i5 == 0) {
            return this._leftMargin;
        }
        if (i5 == 1) {
            return this._rightMargin;
        }
        if (i5 == 2) {
            return this._topMargin;
        }
        if (i5 == 3) {
            return this._bottomMargin;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown margin constant:  "));
    }

    private PageBreakRecord getRowBreaksRecord() {
        if (this._rowBreaksRecord == null) {
            this._rowBreaksRecord = new HorizontalPageBreakRecord();
        }
        return this._rowBreaksRecord;
    }

    public static boolean isComponentRecord(int i5) {
        if (i5 == 20 || i5 == 21 || i5 == 26 || i5 == 27 || i5 == 51 || i5 == 77 || i5 == 161 || i5 == 233 || i5 == 2204 || i5 == 131 || i5 == 132) {
            return true;
        }
        switch (i5) {
            case 38:
            case 39:
            case 40:
            case 41:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$positionRecords$0(Map map, CustomViewSettingsRecordAggregate customViewSettingsRecordAggregate, Record record) {
        HeaderFooterRecord headerFooterRecord;
        if (record.getSid() != 426 || (headerFooterRecord = (HeaderFooterRecord) map.get(HexDump.toHex(((UserSViewBegin) record).getGuid()))) == null) {
            return;
        }
        customViewSettingsRecordAggregate.append(headerFooterRecord);
        this._sviewHeaderFooters.remove(headerFooterRecord);
    }

    private boolean readARecord(RecordStream recordStream) {
        int iPeekNextSid = recordStream.peekNextSid();
        if (iPeekNextSid == 20) {
            checkNotPresent(this._header);
            this._header = (HeaderRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 21) {
            checkNotPresent(this._footer);
            this._footer = (FooterRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 26) {
            checkNotPresent(this._columnBreaksRecord);
            this._columnBreaksRecord = (PageBreakRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 27) {
            checkNotPresent(this._rowBreaksRecord);
            this._rowBreaksRecord = (PageBreakRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 51) {
            checkNotPresent(this._printSize);
            this._printSize = recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 77) {
            this._plsRecords.add(new PLSAggregate(recordStream));
            return true;
        }
        if (iPeekNextSid == 161) {
            checkNotPresent(this._printSetup);
            this._printSetup = (PrintSetupRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 233) {
            checkNotPresent(this._bitmap);
            this._bitmap = recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 2204) {
            HeaderFooterRecord headerFooterRecord = (HeaderFooterRecord) recordStream.getNext();
            if (headerFooterRecord.isCurrentSheet()) {
                this._headerFooter = headerFooterRecord;
                return true;
            }
            this._sviewHeaderFooters.add(headerFooterRecord);
            return true;
        }
        if (iPeekNextSid == 131) {
            checkNotPresent(this._hCenter);
            this._hCenter = (HCenterRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 132) {
            checkNotPresent(this._vCenter);
            this._vCenter = (VCenterRecord) recordStream.getNext();
            return true;
        }
        switch (iPeekNextSid) {
            case 38:
                checkNotPresent(this._leftMargin);
                this._leftMargin = (LeftMarginRecord) recordStream.getNext();
                return true;
            case 39:
                checkNotPresent(this._rightMargin);
                this._rightMargin = (RightMarginRecord) recordStream.getNext();
                return true;
            case 40:
                checkNotPresent(this._topMargin);
                this._topMargin = (TopMarginRecord) recordStream.getNext();
                return true;
            case 41:
                checkNotPresent(this._bottomMargin);
                this._bottomMargin = (BottomMarginRecord) recordStream.getNext();
                return true;
            default:
                return false;
        }
    }

    private static void shiftBreaks(PageBreakRecord pageBreakRecord, int i5, int i6, int i7) {
        int i8;
        Iterator<PageBreakRecord.Break> breaksIterator = pageBreakRecord.getBreaksIterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            i8 = 0;
            if (!breaksIterator.hasNext()) {
                break;
            }
            PageBreakRecord.Break next = breaksIterator.next();
            int main = next.getMain();
            boolean z6 = main >= i5;
            i8 = main <= i6 ? 1 : 0;
            if (z6 && i8 != 0) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            PageBreakRecord.Break r9 = (PageBreakRecord.Break) obj;
            pageBreakRecord.removeBreak(r9.getMain());
            pageBreakRecord.addBreak((short) (r9.getMain() + i7), r9.getSubFrom(), r9.getSubTo());
        }
    }

    private static void visitIfPresent(Record record, RecordAggregate.RecordVisitor recordVisitor) {
        if (record != null) {
            recordVisitor.visitRecord(record);
        }
    }

    public void addLateHeaderFooter(HeaderFooterRecord headerFooterRecord) {
        if (this._headerFooter != null) {
            throw new IllegalStateException("This page settings block already has a header/footer record");
        }
        if (headerFooterRecord.getSid() == 2204) {
            this._headerFooter = headerFooterRecord;
        } else {
            throw new RecordFormatException("Unexpected header-footer record sid: 0x" + Integer.toHexString(headerFooterRecord.getSid()));
        }
    }

    public void addLateRecords(RecordStream recordStream) {
        while (readARecord(recordStream)) {
        }
    }

    public int[] getColumnBreaks() {
        return getColumnBreaksRecord().getBreaks();
    }

    public FooterRecord getFooter() {
        return this._footer;
    }

    public HCenterRecord getHCenter() {
        return this._hCenter;
    }

    public HeaderRecord getHeader() {
        return this._header;
    }

    public double getMargin(short s6) {
        Margin marginRec = getMarginRec(s6);
        if (marginRec != null) {
            return marginRec.getMargin();
        }
        if (s6 == 0 || s6 == 1) {
            return 0.75d;
        }
        if (s6 == 2 || s6 == 3) {
            return 1.0d;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(s6, "Unknown margin constant:  "));
    }

    public int getNumColumnBreaks() {
        return getColumnBreaksRecord().getNumBreaks();
    }

    public int getNumRowBreaks() {
        return getRowBreaksRecord().getNumBreaks();
    }

    public PrintSetupRecord getPrintSetup() {
        return this._printSetup;
    }

    public int[] getRowBreaks() {
        return getRowBreaksRecord().getBreaks();
    }

    public VCenterRecord getVCenter() {
        return this._vCenter;
    }

    public boolean isColumnBroken(int i5) {
        return getColumnBreaksRecord().getBreak(i5) != null;
    }

    public boolean isRowBroken(int i5) {
        return getRowBreaksRecord().getBreak(i5) != null;
    }

    public void positionRecords(List<RecordBase> list) {
        ArrayList arrayList = new ArrayList(this._sviewHeaderFooters);
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            HeaderFooterRecord headerFooterRecord = (HeaderFooterRecord) obj;
            map.put(HexDump.toHex(headerFooterRecord.getGuid()), headerFooterRecord);
        }
        for (RecordBase recordBase : list) {
            if (recordBase instanceof CustomViewSettingsRecordAggregate) {
                CustomViewSettingsRecordAggregate customViewSettingsRecordAggregate = (CustomViewSettingsRecordAggregate) recordBase;
                customViewSettingsRecordAggregate.visitContainedRecords(new M1.b(this, 3, map, customViewSettingsRecordAggregate));
            }
        }
    }

    public void removeColumnBreak(int i5) {
        getColumnBreaksRecord().removeBreak(i5);
    }

    public void removeRowBreak(int i5) {
        if (getRowBreaksRecord().getBreaks().length < 1) {
            throw new IllegalArgumentException("Sheet does not define any row breaks");
        }
        getRowBreaksRecord().removeBreak((short) i5);
    }

    public void setColumnBreak(short s6, short s7, short s8) {
        getColumnBreaksRecord().addBreak(s6, s7, s8);
    }

    public void setFooter(FooterRecord footerRecord) {
        this._footer = footerRecord;
    }

    public void setHeader(HeaderRecord headerRecord) {
        this._header = headerRecord;
    }

    public void setMargin(short s6, double d) {
        Margin marginRec = getMarginRec(s6);
        Margin margin = marginRec;
        if (marginRec == null) {
            if (s6 == 0) {
                LeftMarginRecord leftMarginRecord = new LeftMarginRecord();
                this._leftMargin = leftMarginRecord;
                margin = leftMarginRecord;
            } else if (s6 == 1) {
                RightMarginRecord rightMarginRecord = new RightMarginRecord();
                this._rightMargin = rightMarginRecord;
                margin = rightMarginRecord;
            } else if (s6 == 2) {
                TopMarginRecord topMarginRecord = new TopMarginRecord();
                this._topMargin = topMarginRecord;
                margin = topMarginRecord;
            } else {
                if (s6 != 3) {
                    throw new IllegalArgumentException(AbstractC0157z.k(s6, "Unknown margin constant:  "));
                }
                BottomMarginRecord bottomMarginRecord = new BottomMarginRecord();
                this._bottomMargin = bottomMarginRecord;
                margin = bottomMarginRecord;
            }
        }
        margin.setMargin(d);
    }

    public void setPrintSetup(PrintSetupRecord printSetupRecord) {
        this._printSetup = printSetupRecord;
    }

    public void setRowBreak(int i5, short s6, short s7) {
        getRowBreaksRecord().addBreak((short) i5, s6, s7);
    }

    public void shiftColumnBreaks(short s6, short s7, short s8) {
        shiftBreaks(getColumnBreaksRecord(), s6, s7, s8);
    }

    public void shiftRowBreaks(int i5, int i6, int i7) {
        shiftBreaks(getRowBreaksRecord(), i5, i6, i7);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        visitIfPresent(this._rowBreaksRecord, recordVisitor);
        visitIfPresent(this._columnBreaksRecord, recordVisitor);
        HeaderRecord headerRecord = this._header;
        if (headerRecord == null) {
            recordVisitor.visitRecord(new HeaderRecord(""));
        } else {
            recordVisitor.visitRecord(headerRecord);
        }
        FooterRecord footerRecord = this._footer;
        if (footerRecord == null) {
            recordVisitor.visitRecord(new FooterRecord(""));
        } else {
            recordVisitor.visitRecord(footerRecord);
        }
        visitIfPresent(this._hCenter, recordVisitor);
        visitIfPresent(this._vCenter, recordVisitor);
        visitIfPresent(this._leftMargin, recordVisitor);
        visitIfPresent(this._rightMargin, recordVisitor);
        visitIfPresent(this._topMargin, recordVisitor);
        visitIfPresent(this._bottomMargin, recordVisitor);
        Iterator<PLSAggregate> it = this._plsRecords.iterator();
        while (it.hasNext()) {
            it.next().visitContainedRecords(recordVisitor);
        }
        visitIfPresent(this._printSetup, recordVisitor);
        visitIfPresent(this._printSize, recordVisitor);
        visitIfPresent(this._headerFooter, recordVisitor);
        visitIfPresent(this._bitmap, recordVisitor);
    }

    private static void visitIfPresent(PageBreakRecord pageBreakRecord, RecordAggregate.RecordVisitor recordVisitor) {
        if (pageBreakRecord == null || pageBreakRecord.isEmpty()) {
            return;
        }
        recordVisitor.visitRecord(pageBreakRecord);
    }

    public PageSettingsBlock() {
        this._sviewHeaderFooters = new ArrayList();
        this._plsRecords = new ArrayList();
        this._rowBreaksRecord = new HorizontalPageBreakRecord();
        this._columnBreaksRecord = new VerticalPageBreakRecord();
        this._header = new HeaderRecord("");
        this._footer = new FooterRecord("");
        this._hCenter = createHCenter();
        this._vCenter = createVCenter();
        this._printSetup = createPrintSetup();
    }
}
