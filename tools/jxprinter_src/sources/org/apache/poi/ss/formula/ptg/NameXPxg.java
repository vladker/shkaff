package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NameXPxg extends OperandPtg implements Pxg {
    private int externalWorkbookNumber;
    private String nameName;
    private String sheetName;

    public NameXPxg(int i5, String str, String str2) {
        this.externalWorkbookNumber = i5;
        this.sheetName = str;
        this.nameName = str2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.p
            public final /* synthetic */ NameXPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 1:
                        return this.b.getSheetName();
                    default:
                        return this.b.getNameName();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.p
            public final /* synthetic */ NameXPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 1:
                        return this.b.getSheetName();
                    default:
                        return this.b.getNameName();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("externalWorkbookNumber", supplier, "sheetName", supplier2, "nameName", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.p
            public final /* synthetic */ NameXPxg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getExternalWorkbookNumber());
                    case 1:
                        return this.b.getSheetName();
                    default:
                        return this.b.getNameName();
                }
            }
        });
    }

    public String getNameName() {
        return this.nameName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public String getSheetName() {
        return this.sheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) -1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public void setSheetName(String str) {
        this.sheetName = str;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        boolean z6;
        StringBuilder sb = new StringBuilder(64);
        boolean z7 = true;
        if (this.externalWorkbookNumber >= 0) {
            sb.append('[');
            sb.append(this.externalWorkbookNumber);
            sb.append(']');
            z6 = true;
        } else {
            z6 = false;
        }
        String str = this.sheetName;
        if (str != null) {
            SheetNameFormatter.appendFormat(sb, str);
        } else {
            z7 = z6;
        }
        if (z7) {
            sb.append('!');
        }
        sb.append(this.nameName);
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg, org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public NameXPxg copy() {
        return new NameXPxg(this);
    }

    public NameXPxg(NameXPxg nameXPxg) {
        super(nameXPxg);
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = nameXPxg.externalWorkbookNumber;
        this.sheetName = nameXPxg.sheetName;
        this.nameName = nameXPxg.nameName;
    }

    public NameXPxg(String str, String str2) {
        this(-1, str, str2);
    }

    public NameXPxg(String str) {
        this(-1, null, str);
    }
}
