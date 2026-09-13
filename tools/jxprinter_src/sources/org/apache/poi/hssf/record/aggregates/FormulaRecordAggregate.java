package org.apache.poi.hssf.record.aggregates;

import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.SharedValueRecordBase;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FormulaRecordAggregate extends RecordAggregate implements CellValueRecordInterface {
    private final FormulaRecord _formulaRecord;
    private SharedFormulaRecord _sharedFormulaRecord;
    private SharedValueManager _sharedValueManager;
    private StringRecord _stringRecord;

    public FormulaRecordAggregate(FormulaRecord formulaRecord, StringRecord stringRecord, SharedValueManager sharedValueManager) {
        if (sharedValueManager == null) {
            throw new IllegalArgumentException("sfm must not be null");
        }
        if (!formulaRecord.hasCachedResultString()) {
            this._stringRecord = null;
        } else {
            if (stringRecord == null) {
                throw new RecordFormatException("Formula record flag is set but String record was not found");
            }
            this._stringRecord = stringRecord;
        }
        this._formulaRecord = formulaRecord;
        this._sharedValueManager = sharedValueManager;
        if (formulaRecord.isSharedFormula()) {
            CellReference expReference = formulaRecord.getFormula().getExpReference();
            if (expReference == null) {
                handleMissingSharedFormulaRecord(formulaRecord);
            } else {
                this._sharedFormulaRecord = sharedValueManager.linkSharedFormulaRecord(expReference, this);
            }
        }
    }

    private static void handleMissingSharedFormulaRecord(FormulaRecord formulaRecord) {
        if (formulaRecord.getParsedExpression()[0] instanceof ExpPtg) {
            throw new RecordFormatException("SharedFormulaRecord not found for FormulaRecord with (isSharedFormula=true)");
        }
        formulaRecord.setSharedFormula(false);
    }

    public CellRangeAddress getArrayFormulaRange() {
        if (this._sharedFormulaRecord != null) {
            throw new IllegalStateException("not an array formula cell.");
        }
        CellReference expReference = this._formulaRecord.getFormula().getExpReference();
        if (expReference == null) {
            throw new IllegalStateException("not an array formula cell.");
        }
        ArrayRecord arrayRecord = this._sharedValueManager.getArrayRecord(expReference.getRow(), expReference.getCol());
        if (arrayRecord != null) {
            CellRangeAddress8Bit range = arrayRecord.getRange();
            return new CellRangeAddress(range.getFirstRow(), range.getLastRow(), range.getFirstColumn(), range.getLastColumn());
        }
        throw new IllegalStateException("ArrayRecord was not found for the locator " + expReference.formatAsString());
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this._formulaRecord.getColumn();
    }

    public FormulaRecord getFormulaRecord() {
        return this._formulaRecord;
    }

    public Ptg[] getFormulaTokens() {
        SharedFormulaRecord sharedFormulaRecord = this._sharedFormulaRecord;
        if (sharedFormulaRecord != null) {
            return sharedFormulaRecord.getFormulaTokens(this._formulaRecord);
        }
        CellReference expReference = this._formulaRecord.getFormula().getExpReference();
        return expReference != null ? this._sharedValueManager.getArrayRecord(expReference.getRow(), expReference.getCol()).getFormulaTokens() : this._formulaRecord.getParsedExpression();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this._formulaRecord.getRow();
    }

    public StringRecord getStringRecord() {
        return this._stringRecord;
    }

    public String getStringValue() {
        StringRecord stringRecord = this._stringRecord;
        if (stringRecord == null) {
            return null;
        }
        return stringRecord.getString();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this._formulaRecord.getXFIndex();
    }

    public boolean isPartOfArrayFormula() {
        if (this._sharedFormulaRecord != null) {
            return false;
        }
        CellReference expReference = this._formulaRecord.getFormula().getExpReference();
        return (expReference == null ? null : this._sharedValueManager.getArrayRecord(expReference.getRow(), expReference.getCol())) != null;
    }

    public void notifyFormulaChanging() {
        SharedFormulaRecord sharedFormulaRecord = this._sharedFormulaRecord;
        if (sharedFormulaRecord != null) {
            this._sharedValueManager.unlink(sharedFormulaRecord);
        }
    }

    public CellRangeAddress removeArrayFormula(int i5, int i6) {
        CellRangeAddress8Bit cellRangeAddress8BitRemoveArrayFormula = this._sharedValueManager.removeArrayFormula(i5, i6);
        this._formulaRecord.setParsedExpression(null);
        return new CellRangeAddress(cellRangeAddress8BitRemoveArrayFormula.getFirstRow(), cellRangeAddress8BitRemoveArrayFormula.getLastRow(), cellRangeAddress8BitRemoveArrayFormula.getFirstColumn(), cellRangeAddress8BitRemoveArrayFormula.getLastColumn());
    }

    public void setArrayFormula(CellRangeAddress cellRangeAddress, Ptg[] ptgArr) {
        this._sharedValueManager.addArrayRecord(new ArrayRecord(Formula.create(ptgArr), new CellRangeAddress8Bit(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn())));
    }

    public void setCachedBooleanResult(boolean z6) {
        this._stringRecord = null;
        this._formulaRecord.setCachedResultBoolean(z6);
    }

    public void setCachedDoubleResult(double d) {
        this._stringRecord = null;
        this._formulaRecord.setValue(d);
    }

    public void setCachedErrorResult(int i5) {
        this._stringRecord = null;
        this._formulaRecord.setCachedResultErrorCode(i5);
    }

    public void setCachedStringResult(String str) {
        if (this._stringRecord == null) {
            this._stringRecord = new StringRecord();
        }
        this._stringRecord.setString(str);
        if (str.length() < 1) {
            this._formulaRecord.setCachedResultTypeEmptyString();
        } else {
            this._formulaRecord.setCachedResultTypeString();
        }
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setColumn(short s6) {
        this._formulaRecord.setColumn(s6);
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        notifyFormulaChanging();
        this._formulaRecord.setParsedExpression(ptgArr);
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setRow(int i5) {
        this._formulaRecord.setRow(i5);
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setXFIndex(short s6) {
        this._formulaRecord.setXFIndex(s6);
    }

    public String toString() {
        return this._formulaRecord.toString();
    }

    public void unlinkSharedFormula() {
        SharedFormulaRecord sharedFormulaRecord = this._sharedFormulaRecord;
        if (sharedFormulaRecord == null) {
            throw new IllegalStateException("Formula not linked to shared formula");
        }
        this._formulaRecord.setParsedExpression(sharedFormulaRecord.getFormulaTokens(this._formulaRecord));
        this._formulaRecord.setSharedFormula(false);
        this._sharedFormulaRecord = null;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        StringRecord stringRecord;
        recordVisitor.visitRecord(this._formulaRecord);
        SharedValueRecordBase recordForFirstCell = this._sharedValueManager.getRecordForFirstCell(this);
        if (recordForFirstCell != null) {
            recordVisitor.visitRecord(recordForFirstCell);
        }
        if (!this._formulaRecord.hasCachedResultString() || (stringRecord = this._stringRecord) == null) {
            return;
        }
        recordVisitor.visitRecord(stringRecord);
    }

    public void setCachedErrorResult(FormulaError formulaError) {
        setCachedErrorResult(formulaError.getCode());
    }
}
