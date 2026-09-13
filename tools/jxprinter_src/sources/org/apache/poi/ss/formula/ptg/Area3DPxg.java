package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;
import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Area3DPxg extends AreaPtgBase implements Pxg3D {
    private int externalWorkbookNumber;
    private String firstSheetName;
    private String lastSheetName;

    public Area3DPxg(Area3DPxg area3DPxg) {
        super(area3DPxg);
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = area3DPxg.externalWorkbookNumber;
        this.firstSheetName = area3DPxg.firstSheetName;
        this.lastSheetName = area3DPxg.lastSheetName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    public String format2DRefAsString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.c
            public final /* synthetic */ Area3DPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 2:
                        return this.b.getSheetName();
                    default:
                        return this.b.getLastSheetName();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.c
            public final /* synthetic */ Area3DPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 2:
                        return this.b.getSheetName();
                    default:
                        return this.b.getLastSheetName();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.c
            public final /* synthetic */ Area3DPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 2:
                        return this.b.getSheetName();
                    default:
                        return this.b.getLastSheetName();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("base", supplier, "externalWorkbookNumber", supplier2, "sheetName", supplier3, "lastSheetName", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.c
            public final /* synthetic */ Area3DPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 2:
                        return this.b.getSheetName();
                    default:
                        return this.b.getLastSheetName();
                }
            }
        });
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg3D
    public String getLastSheetName() {
        return this.lastSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public String getSheetName() {
        return this.firstSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) -1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg3D
    public void setLastSheetName(String str) {
        this.lastSheetName = str;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public void setSheetName(String str) {
        this.firstSheetName = str;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuilder sb = new StringBuilder(64);
        SheetRangeAndWorkbookIndexFormatter.format(sb, this.externalWorkbookNumber, this.firstSheetName, this.lastSheetName);
        sb.append('!');
        sb.append(formatReferenceAsString());
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg, org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public Area3DPxg copy() {
        return new Area3DPxg(this);
    }

    public Area3DPxg(int i5, SheetIdentifier sheetIdentifier, String str) {
        this(i5, sheetIdentifier, new AreaReference(str, SpreadsheetVersion.EXCEL2007));
    }

    public Area3DPxg(int i5, SheetIdentifier sheetIdentifier, AreaReference areaReference) {
        super(areaReference);
        this.externalWorkbookNumber = i5;
        this.firstSheetName = sheetIdentifier.getSheetIdentifier().getName();
        if (sheetIdentifier instanceof SheetRangeIdentifier) {
            this.lastSheetName = ((SheetRangeIdentifier) sheetIdentifier).getLastSheetIdentifier().getName();
        } else {
            this.lastSheetName = null;
        }
    }

    public Area3DPxg(SheetIdentifier sheetIdentifier, String str) {
        this(sheetIdentifier, new AreaReference(str, SpreadsheetVersion.EXCEL2007));
    }

    public Area3DPxg(SheetIdentifier sheetIdentifier, AreaReference areaReference) {
        this(-1, sheetIdentifier, areaReference);
    }
}
