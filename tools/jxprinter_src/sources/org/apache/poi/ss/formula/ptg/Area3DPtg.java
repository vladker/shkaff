package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ExternSheetReferenceToken;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Area3DPtg extends AreaPtgBase implements WorkbookDependentFormula, ExternSheetReferenceToken {
    private static final int SIZE = 11;
    public static final byte sid = 59;
    private int field_1_index_extern_sheet;

    public Area3DPtg(String str, int i5) {
        super(new AreaReference(str, SpreadsheetVersion.EXCEL97));
        setExternSheetIndex(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ss.formula.ExternSheetReferenceToken
    public String format2DRefAsString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ExternSheetReferenceToken
    public int getExternSheetIndex() {
        return this.field_1_index_extern_sheet;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.b
            public final /* synthetic */ Area3DPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return Integer.valueOf(this.b.getExternSheetIndex());
                }
            }
        }, "externSheetIndex", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.b
            public final /* synthetic */ Area3DPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return Integer.valueOf(this.b.getExternSheetIndex());
                }
            }
        });
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return sid;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 11;
    }

    public void setExternSheetIndex(int i5) {
        this.field_1_index_extern_sheet = i5;
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook) {
        return ExternSheetNameResolver.prependSheetName(formulaRenderingWorkbook, this.field_1_index_extern_sheet, formatReferenceAsString());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeShort(this.field_1_index_extern_sheet);
        writeCoordinates(littleEndianOutput);
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    public Area3DPtg(Area3DPtg area3DPtg) {
        super(area3DPtg);
        this.field_1_index_extern_sheet = area3DPtg.field_1_index_extern_sheet;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg, org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public Area3DPtg copy() {
        return new Area3DPtg(this);
    }

    public Area3DPtg(LittleEndianInput littleEndianInput) {
        this.field_1_index_extern_sheet = littleEndianInput.readShort();
        readCoordinates(littleEndianInput);
    }

    public Area3DPtg(int i5, int i6, int i7, int i8, boolean z6, boolean z7, boolean z8, boolean z9, int i9) {
        super(i5, i6, i7, i8, z6, z7, z8, z9);
        setExternSheetIndex(i9);
    }

    public Area3DPtg(AreaReference areaReference, int i5) {
        super(areaReference);
        setExternSheetIndex(i5);
    }
}
