package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeaderBase;
import org.apache.poi.ss.formula.FormulaShifter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConditionalFormattingTable extends RecordAggregate {
    private final List<CFRecordsAggregate> _cfHeaders = new ArrayList();

    public ConditionalFormattingTable() {
    }

    private void checkIndex(int i5) {
        if (i5 < 0 || i5 >= this._cfHeaders.size()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified CF index ", " is outside the allowable range (0..");
            sbT.append(this._cfHeaders.size() - 1);
            sbT.append(")");
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    public int add(CFRecordsAggregate cFRecordsAggregate) {
        cFRecordsAggregate.getHeader().setID(this._cfHeaders.size());
        this._cfHeaders.add(cFRecordsAggregate);
        return this._cfHeaders.size() - 1;
    }

    public CFRecordsAggregate get(int i5) {
        checkIndex(i5);
        return this._cfHeaders.get(i5);
    }

    public void remove(int i5) {
        checkIndex(i5);
        this._cfHeaders.remove(i5);
    }

    public int size() {
        return this._cfHeaders.size();
    }

    public void updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i5) {
        int i6 = 0;
        while (i6 < this._cfHeaders.size()) {
            if (!this._cfHeaders.get(i6).updateFormulasAfterCellShift(formulaShifter, i5)) {
                this._cfHeaders.remove(i6);
                i6--;
            }
            i6++;
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        Iterator<CFRecordsAggregate> it = this._cfHeaders.iterator();
        while (it.hasNext()) {
            it.next().visitContainedRecords(recordVisitor);
        }
    }

    public ConditionalFormattingTable(RecordStream recordStream) {
        while (recordStream.peekNextRecord() instanceof CFHeaderBase) {
            this._cfHeaders.add(CFRecordsAggregate.createCFAggregate(recordStream));
        }
    }
}
