package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class Ref2DPtgBase extends RefPtgBase {
    private static final int SIZE = 5;

    public Ref2DPtgBase(int i5, int i6, boolean z6, boolean z7) {
        setRow(i5);
        setColumn(i6);
        setRowRelative(z6);
        setColRelative(z7);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final int getSize() {
        return 5;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + getSid());
        writeCoordinates(littleEndianOutput);
    }

    public Ref2DPtgBase(Ref2DPtgBase ref2DPtgBase) {
        super(ref2DPtgBase);
    }

    public Ref2DPtgBase(LittleEndianInput littleEndianInput) {
        readCoordinates(littleEndianInput);
    }

    public Ref2DPtgBase(CellReference cellReference) {
        super(cellReference);
    }
}
