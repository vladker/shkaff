package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ArrayInitialPtg extends Ptg {
    private final int _reserved0;
    private final int _reserved1;
    private final int _reserved2;

    public ArrayInitialPtg(LittleEndianInput littleEndianInput) {
        this._reserved0 = littleEndianInput.readInt();
        this._reserved1 = littleEndianInput.readUShort();
        this._reserved2 = littleEndianInput.readUByte();
    }

    private static RuntimeException invalid() {
        throw new IllegalStateException("This object is a partially initialised tArray, and cannot be used as a Ptg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this._reserved0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this._reserved1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this._reserved2);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public ArrayInitialPtg copy() {
        return this;
    }

    public ArrayPtg finishReading(LittleEndianInput littleEndianInput) {
        int uByte = littleEndianInput.readUByte() + 1;
        short s6 = (short) (littleEndianInput.readShort() + 1);
        ArrayPtg arrayPtg = new ArrayPtg(this._reserved0, this._reserved1, this._reserved2, uByte, s6, ConstantValueParser.parse(littleEndianInput, s6 * uByte));
        arrayPtg.setClass(getPtgClass());
        return arrayPtg;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        throw invalid();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.f
            public final /* synthetic */ ArrayInitialPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.f
            public final /* synthetic */ ArrayInitialPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("reserved0", supplier, "reserved1", supplier2, "reserved2", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.f
            public final /* synthetic */ ArrayInitialPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        });
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) -1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 8;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return false;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw invalid();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        throw invalid();
    }
}
