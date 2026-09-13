package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import com.google.android.material.color.utilities.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ddf.l;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeader12Record;
import org.apache.poi.hssf.record.CFHeaderBase;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.helpers.BaseRowColShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CFRecordsAggregate extends RecordAggregate implements GenericRecord {
    private static final Logger LOG = LogManager.getLogger((Class<?>) CFRecordsAggregate.class);
    private static final int MAX_97_2003_CONDTIONAL_FORMAT_RULES = 3;
    private final CFHeaderBase header;
    private final List<CFRuleBase> rules;

    public CFRecordsAggregate(CFRecordsAggregate cFRecordsAggregate) {
        ArrayList arrayList = new ArrayList();
        this.rules = arrayList;
        this.header = cFRecordsAggregate.header.copy();
        cFRecordsAggregate.rules.stream().map(new g(14)).forEach(new l(arrayList, 4));
    }

    private void checkRuleIndex(int i5) {
        if (i5 < 0 || i5 >= this.rules.size()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Bad rule record index (", ") nRules=");
            sbT.append(this.rules.size());
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    private void checkRuleType(CFRuleBase cFRuleBase) {
        CFHeaderBase cFHeaderBase = this.header;
        if ((cFHeaderBase instanceof CFHeaderRecord) && (cFRuleBase instanceof CFRuleRecord)) {
            return;
        }
        if (!(cFHeaderBase instanceof CFHeader12Record) || !(cFRuleBase instanceof CFRule12Record)) {
            throw new IllegalArgumentException("Header and Rule must both be CF or both be CF12, can't mix");
        }
    }

    public static CFRecordsAggregate createCFAggregate(RecordStream recordStream) {
        Record next = recordStream.getNext();
        if (next.getSid() != 432 && next.getSid() != 2169) {
            throw new IllegalStateException("next record sid was " + ((int) next.getSid()) + " instead of 432 or 2169 as expected");
        }
        CFHeaderBase cFHeaderBase = (CFHeaderBase) next;
        int numberOfConditionalFormats = cFHeaderBase.getNumberOfConditionalFormats();
        CFRuleBase[] cFRuleBaseArr = new CFRuleBase[numberOfConditionalFormats];
        for (int i5 = 0; i5 < numberOfConditionalFormats; i5++) {
            cFRuleBaseArr[i5] = (CFRuleBase) recordStream.getNext();
        }
        return new CFRecordsAggregate(cFHeaderBase, cFRuleBaseArr);
    }

    private static CFHeaderBase createHeader(CellRangeAddress[] cellRangeAddressArr, CFRuleBase[] cFRuleBaseArr) {
        CFHeaderBase cFHeaderRecord = (cFRuleBaseArr.length == 0 || (cFRuleBaseArr[0] instanceof CFRuleRecord)) ? new CFHeaderRecord(cellRangeAddressArr, cFRuleBaseArr.length) : new CFHeader12Record(cellRangeAddressArr, cFRuleBaseArr.length);
        cFHeaderRecord.setNeedRecalculation(true);
        return cFHeaderRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this.rules;
    }

    public void addRule(CFRuleBase cFRuleBase) {
        if (cFRuleBase == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        if (this.rules.size() >= 3) {
            LOG.atWarn().log("Excel versions before 2007 cannot cope with any more than 3 - this file will cause problems with old Excel versions");
        }
        checkRuleType(cFRuleBase);
        this.rules.add(cFRuleBase);
        this.header.setNumberOfConditionalFormats(this.rules.size());
    }

    public CFRecordsAggregate cloneCFAggregate() {
        return new CFRecordsAggregate(this);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("header", new Supplier(this) { // from class: org.apache.poi.hssf.record.aggregates.a
            public final /* synthetic */ CFRecordsAggregate b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getHeader();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "rules", new Supplier(this) { // from class: org.apache.poi.hssf.record.aggregates.a
            public final /* synthetic */ CFRecordsAggregate b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getHeader();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public CFHeaderBase getHeader() {
        return this.header;
    }

    public int getNumberOfRules() {
        return this.rules.size();
    }

    public CFRuleBase getRule(int i5) {
        checkRuleIndex(i5);
        return this.rules.get(i5);
    }

    public void setRule(int i5, CFRuleBase cFRuleBase) {
        if (cFRuleBase == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        checkRuleIndex(i5);
        checkRuleType(cFRuleBase);
        this.rules.set(i5, cFRuleBase);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public boolean updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i5) {
        CFRule12Record cFRule12Record;
        Ptg[] parsedExpressionScale;
        CellRangeAddress[] cellRanges = this.header.getCellRanges();
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (CellRangeAddress cellRangeAddress : cellRanges) {
            CellRangeAddress cellRangeAddressShiftRange = BaseRowColShifter.shiftRange(formulaShifter, cellRangeAddress, i5);
            if (cellRangeAddressShiftRange == null) {
                z6 = true;
            } else {
                arrayList.add(cellRangeAddressShiftRange);
                if (cellRangeAddressShiftRange != cellRangeAddress) {
                    z6 = true;
                }
            }
        }
        if (z6) {
            int size = arrayList.size();
            if (size == 0) {
                return false;
            }
            CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[size];
            arrayList.toArray(cellRangeAddressArr);
            this.header.setCellRanges(cellRangeAddressArr);
        }
        for (CFRuleBase cFRuleBase : this.rules) {
            Ptg[] parsedExpression1 = cFRuleBase.getParsedExpression1();
            if (parsedExpression1 != null && formulaShifter.adjustFormula(parsedExpression1, i5)) {
                cFRuleBase.setParsedExpression1(parsedExpression1);
            }
            Ptg[] parsedExpression2 = cFRuleBase.getParsedExpression2();
            if (parsedExpression2 != null && formulaShifter.adjustFormula(parsedExpression2, i5)) {
                cFRuleBase.setParsedExpression2(parsedExpression2);
            }
            if ((cFRuleBase instanceof CFRule12Record) && (parsedExpressionScale = (cFRule12Record = (CFRule12Record) cFRuleBase).getParsedExpressionScale()) != null && formulaShifter.adjustFormula(parsedExpressionScale, i5)) {
                cFRule12Record.setParsedExpressionScale(parsedExpressionScale);
            }
        }
        return true;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        recordVisitor.visitRecord(this.header);
        Iterator<CFRuleBase> it = this.rules.iterator();
        while (it.hasNext()) {
            recordVisitor.visitRecord(it.next());
        }
    }

    private CFRecordsAggregate(CFHeaderBase cFHeaderBase, CFRuleBase[] cFRuleBaseArr) {
        this.rules = new ArrayList();
        if (cFHeaderBase == null) {
            throw new IllegalArgumentException("header must not be null");
        }
        if (cFRuleBaseArr != null) {
            if (cFRuleBaseArr.length > 3) {
                LOG.atWarn().log("Excel versions before 2007 require that No more than 3 rules may be specified, {} were found, this file will cause problems with old Excel versions", Unbox.box(cFRuleBaseArr.length));
            }
            if (cFRuleBaseArr.length == cFHeaderBase.getNumberOfConditionalFormats()) {
                this.header = cFHeaderBase;
                for (CFRuleBase cFRuleBase : cFRuleBaseArr) {
                    checkRuleType(cFRuleBase);
                    this.rules.add(cFRuleBase);
                }
                return;
            }
            throw new RecordFormatException("Mismatch number of rules");
        }
        throw new IllegalArgumentException("rules must not be null");
    }

    public CFRecordsAggregate(CellRangeAddress[] cellRangeAddressArr, CFRuleBase[] cFRuleBaseArr) {
        this(createHeader(cellRangeAddressArr, cFRuleBaseArr), cFRuleBaseArr);
    }
}
