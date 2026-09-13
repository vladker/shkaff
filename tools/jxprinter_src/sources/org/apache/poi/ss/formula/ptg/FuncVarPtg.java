package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FuncVarPtg extends AbstractFunctionPtg {
    private static final int SIZE = 4;
    public static final byte sid = 34;
    private final boolean _isCetab;
    private static final BitField ceFunc = BitFieldFactory.getInstance(61440);
    public static final OperationPtg SUM = create("SUM", 1);

    private FuncVarPtg(int i5, int i6, byte[] bArr, int i7, boolean z6) {
        super(i5, i6, bArr, i7);
        this._isCetab = z6;
    }

    public static FuncVarPtg create(LittleEndianInput littleEndianInput) {
        return create(littleEndianInput.readByte(), littleEndianInput.readUShort());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Boolean.valueOf(this._isCetab);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public FuncVarPtg copy() {
        return this;
    }

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg, org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.n
            public final /* synthetic */ FuncVarPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "cetab", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.n
            public final /* synthetic */ FuncVarPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 34;
    }

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg, org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 4;
    }

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg
    public String lookupName(short s6) {
        return lookupName(s6, this._isCetab);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 34);
        littleEndianOutput.writeByte(getNumberOfOperands());
        littleEndianOutput.writeShort(getFunctionIndex());
    }

    public static FuncVarPtg create(String str, int i5) {
        return create(i5, AbstractFunctionPtg.lookupIndex(str));
    }

    private static FuncVarPtg create(int i5, int i6) {
        FunctionMetadata functionByIndex;
        BitField bitField = ceFunc;
        boolean zIsSet = bitField.isSet(i6);
        if (zIsSet) {
            i6 = bitField.clear(i6);
            functionByIndex = FunctionMetadataRegistry.getCetabFunctionByIndex(i6);
        } else {
            functionByIndex = FunctionMetadataRegistry.getFunctionByIndex(i6);
        }
        int i7 = i6;
        if (functionByIndex == null) {
            return new FuncVarPtg(i7, 32, new byte[]{32}, i5, zIsSet);
        }
        return new FuncVarPtg(i7, functionByIndex.getReturnClassCode(), functionByIndex.getParameterClassCodes(), i5, zIsSet);
    }
}
