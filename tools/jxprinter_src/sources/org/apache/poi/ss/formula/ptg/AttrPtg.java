package org.apache.poi.ss.formula.ptg;

import A3.AbstractC0157z;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class AttrPtg extends ControlPtg {
    private static final int SIZE = 4;
    public static final byte sid = 25;
    private final int _chooseFuncOffset;
    private final short _data;
    private final int[] _jumpTable;
    private final byte _options;
    private static final BitField semiVolatile = BitFieldFactory.getInstance(1);
    private static final BitField optiIf = BitFieldFactory.getInstance(2);
    private static final BitField optiChoose = BitFieldFactory.getInstance(4);
    private static final BitField optiSkip = BitFieldFactory.getInstance(8);
    private static final BitField optiSum = BitFieldFactory.getInstance(16);
    private static final BitField baxcel = BitFieldFactory.getInstance(32);
    private static final BitField space = BitFieldFactory.getInstance(64);
    public static final AttrPtg SUM = new AttrPtg(16, 0, null, -1);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SpaceType {
        public static final int CR_BEFORE = 1;
        public static final int CR_BEFORE_CLOSE_PAREN = 5;
        public static final int CR_BEFORE_OPEN_PAREN = 3;
        public static final int SPACE_AFTER_EQUALITY = 6;
        public static final int SPACE_BEFORE = 0;
        public static final int SPACE_BEFORE_CLOSE_PAREN = 4;
        public static final int SPACE_BEFORE_OPEN_PAREN = 2;

        private SpaceType() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttrPtg(LittleEndianInput littleEndianInput) {
        this._options = littleEndianInput.readByte();
        int i5 = littleEndianInput.readShort();
        this._data = i5;
        if (!isOptimizedChoose()) {
            this._jumpTable = null;
            this._chooseFuncOffset = -1;
            return;
        }
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = littleEndianInput.readUShort();
        }
        this._jumpTable = iArr;
        this._chooseFuncOffset = littleEndianInput.readUShort();
    }

    public static AttrPtg createIf(int i5) {
        return new AttrPtg(optiIf.set(0), i5, null, -1);
    }

    public static AttrPtg createSkip(int i5) {
        return new AttrPtg(optiSkip.set(0), i5, null, -1);
    }

    public static AttrPtg createSpace(int i5, int i6) {
        return new AttrPtg(space.set(0), (i5 & 255) | ((i6 << 8) & 65535), null, -1);
    }

    public static AttrPtg getSumSingle() {
        return new AttrPtg(optiSum.set(0), 0, null, -1);
    }

    private boolean isBaxcel() {
        return baxcel.isSet(this._options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$0() {
        return Byte.valueOf(this._options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf((this._data >> 8) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$2() {
        return Integer.valueOf(this._data & 255);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public AttrPtg copy() {
        return this;
    }

    public int getChooseFuncOffset() {
        if (this._jumpTable != null) {
            return this._chooseFuncOffset;
        }
        throw new IllegalStateException("Not tAttrChoose");
    }

    public short getData() {
        return this._data;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.h
            public final /* synthetic */ AttrPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Boolean.valueOf(this.b.isSemiVolatile());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i6 = 1;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.h
            public final /* synthetic */ AttrPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Boolean.valueOf(this.b.isSemiVolatile());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        }, new BitField[]{semiVolatile, optiIf, optiChoose, optiSkip, optiSum, baxcel, space}, new String[]{"SEMI_VOLATILE", "OPTI_IF", "OPTI_CHOOSE", "OPTI_SKIP", "OPTI_SUM", "BAXCEL", "SPACE"});
        final int i7 = 2;
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("volatile", supplier, "options", bitsAsString, "space_count", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.h
            public final /* synthetic */ AttrPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Boolean.valueOf(this.b.isSemiVolatile());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        }, "space_type", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.h
            public final /* synthetic */ AttrPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Boolean.valueOf(this.b.isSemiVolatile());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        }, new int[]{0, 1, 2, 3, 4, 5, 6}, new String[]{"SPACE_BEFORE", "CR_BEFORE", "SPACE_BEFORE_OPEN_PAREN", "CR_BEFORE_OPEN_PAREN", "SPACE_BEFORE_CLOSE_PAREN", "CR_BEFORE_CLOSE_PAREN", "SPACE_AFTER_EQUALITY"}));
    }

    public int[] getJumpTable() {
        return (int[]) this._jumpTable.clone();
    }

    public int getNumberOfOperands() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 25;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        int[] iArr = this._jumpTable;
        if (iArr != null) {
            return ((iArr.length + 1) * 2) + 4;
        }
        return 4;
    }

    public int getType() {
        return -1;
    }

    public boolean isOptimizedChoose() {
        return optiChoose.isSet(this._options);
    }

    public boolean isOptimizedIf() {
        return optiIf.isSet(this._options);
    }

    public boolean isSemiVolatile() {
        return semiVolatile.isSet(this._options);
    }

    public boolean isSkip() {
        return optiSkip.isSet(this._options);
    }

    public boolean isSpace() {
        return space.isSet(this._options);
    }

    public boolean isSum() {
        return optiSum.isSet(this._options);
    }

    public String toFormulaString(String[] strArr) {
        if (space.isSet(this._options)) {
            return strArr[0];
        }
        if (optiIf.isSet(this._options)) {
            StringBuilder sb = new StringBuilder();
            sb.append(toFormulaString());
            sb.append("(");
            return AbstractC0157z.s(sb, strArr[0], ")");
        }
        if (optiSkip.isSet(this._options)) {
            return toFormulaString() + strArr[0];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(toFormulaString());
        sb2.append("(");
        return AbstractC0157z.s(sb2, strArr[0], ")");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 25);
        littleEndianOutput.writeByte(this._options);
        littleEndianOutput.writeShort(this._data);
        int[] iArr = this._jumpTable;
        if (iArr != null) {
            for (int i5 : iArr) {
                littleEndianOutput.writeShort(i5);
            }
            littleEndianOutput.writeShort(this._chooseFuncOffset);
        }
    }

    private AttrPtg(int i5, int i6, int[] iArr, int i7) {
        this._options = (byte) i5;
        this._data = (short) i6;
        this._jumpTable = iArr;
        this._chooseFuncOffset = i7;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        if (semiVolatile.isSet(this._options)) {
            return "ATTR(semiVolatile)";
        }
        if (optiIf.isSet(this._options)) {
            return "IF";
        }
        if (optiChoose.isSet(this._options)) {
            return "CHOOSE";
        }
        if (optiSkip.isSet(this._options)) {
            return "";
        }
        if (optiSum.isSet(this._options)) {
            return "SUM";
        }
        if (baxcel.isSet(this._options)) {
            return "ATTR(baxcel)";
        }
        return space.isSet(this._options) ? "" : "UNKNOWN ATTRIBUTE";
    }
}
