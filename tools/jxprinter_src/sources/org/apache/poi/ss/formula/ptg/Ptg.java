package org.apache.poi.ss.formula.ptg;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Ptg implements Duplicatable, GenericRecord {
    public static final byte CLASS_ARRAY = 64;
    public static final byte CLASS_REF = 0;
    public static final byte CLASS_VALUE = 32;
    public static final Ptg[] EMPTY_PTG_ARRAY = new Ptg[0];
    private byte ptgClass;

    public Ptg() {
        this.ptgClass = (byte) 0;
    }

    private static Ptg createBasePtg(byte b, LittleEndianInput littleEndianInput) {
        switch (b) {
            case 0:
                return new UnknownPtg(b);
            case 1:
                return new ExpPtg(littleEndianInput);
            case 2:
                return new TblPtg(littleEndianInput);
            case 3:
                return AddPtg.instance;
            case 4:
                return SubtractPtg.instance;
            case 5:
                return MultiplyPtg.instance;
            case 6:
                return DividePtg.instance;
            case 7:
                return PowerPtg.instance;
            case 8:
                return ConcatPtg.instance;
            case 9:
                return LessThanPtg.instance;
            case 10:
                return LessEqualPtg.instance;
            case 11:
                return EqualPtg.instance;
            case 12:
                return GreaterEqualPtg.instance;
            case 13:
                return GreaterThanPtg.instance;
            case 14:
                return NotEqualPtg.instance;
            case 15:
                return IntersectionPtg.instance;
            case 16:
                return UnionPtg.instance;
            case 17:
                return RangePtg.instance;
            case 18:
                return UnaryPlusPtg.instance;
            case 19:
                return UnaryMinusPtg.instance;
            case 20:
                return PercentPtg.instance;
            case 21:
                return ParenthesisPtg.instance;
            case 22:
                return MissingArgPtg.instance;
            case 23:
                return new StringPtg(littleEndianInput);
            case 24:
            case 26:
            case 27:
            default:
                throw new IllegalArgumentException(androidx.collection.a.i(b, "Unexpected base token id (", ")"));
            case 25:
                return new AttrPtg(littleEndianInput);
            case 28:
                return ErrPtg.read(littleEndianInput);
            case 29:
                return BoolPtg.read(littleEndianInput);
            case 30:
                return new IntPtg(littleEndianInput);
            case 31:
                return new NumberPtg(littleEndianInput);
        }
    }

    private static Ptg createClassifiedPtg(byte b, LittleEndianInput littleEndianInput) {
        int i5 = (b & 31) | 32;
        switch (i5) {
            case 32:
                return new ArrayInitialPtg(littleEndianInput);
            case 33:
                return FuncPtg.create(littleEndianInput);
            case 34:
                return FuncVarPtg.create(littleEndianInput);
            case 35:
                return new NamePtg(littleEndianInput);
            case 36:
                return new RefPtg(littleEndianInput);
            case 37:
                return new AreaPtg(littleEndianInput);
            case 38:
                return new MemAreaPtg(littleEndianInput);
            case 39:
                return new MemErrPtg(littleEndianInput);
            default:
                switch (i5) {
                    case 41:
                        return new MemFuncPtg(littleEndianInput);
                    case 42:
                        return new RefErrorPtg(littleEndianInput);
                    case 43:
                        return new AreaErrPtg(littleEndianInput);
                    case 44:
                        return new RefNPtg(littleEndianInput);
                    case 45:
                        return new AreaNPtg(littleEndianInput);
                    default:
                        switch (i5) {
                            case 57:
                                return new NameXPtg(littleEndianInput);
                            case 58:
                                return new Ref3DPtg(littleEndianInput);
                            case 59:
                                return new Area3DPtg(littleEndianInput);
                            case 60:
                                return new DeletedRef3DPtg(littleEndianInput);
                            case 61:
                                return new DeletedArea3DPtg(littleEndianInput);
                            default:
                                throw new UnsupportedOperationException(" Unknown Ptg in Formula: 0x" + Integer.toHexString(b) + " (" + ((int) b) + ")");
                        }
                }
        }
    }

    public static Ptg createPtg(LittleEndianInput littleEndianInput) {
        byte b = littleEndianInput.readByte();
        if (b < 32) {
            return createBasePtg(b, littleEndianInput);
        }
        Ptg ptgCreateClassifiedPtg = createClassifiedPtg(b, littleEndianInput);
        if (b >= 96) {
            ptgCreateClassifiedPtg.setClass((byte) 64);
            return ptgCreateClassifiedPtg;
        }
        if (b >= 64) {
            ptgCreateClassifiedPtg.setClass((byte) 32);
            return ptgCreateClassifiedPtg;
        }
        ptgCreateClassifiedPtg.setClass((byte) 0);
        return ptgCreateClassifiedPtg;
    }

    public static boolean doesFormulaReferToDeletedCell(Ptg[] ptgArr) {
        for (Ptg ptg : ptgArr) {
            if (isDeletedCellRef(ptg)) {
                return true;
            }
        }
        return false;
    }

    public static int getEncodedSize(Ptg[] ptgArr) {
        int size = 0;
        for (Ptg ptg : ptgArr) {
            size += ptg.getSize();
        }
        return size;
    }

    public static int getEncodedSizeWithoutArrayData(Ptg[] ptgArr) {
        int size = 0;
        for (Ptg ptg : ptgArr) {
            size = ptg instanceof ArrayPtg ? size + 8 : ptg.getSize() + size;
        }
        return size;
    }

    private static boolean isDeletedCellRef(Ptg ptg) {
        if (ptg == ErrPtg.REF_INVALID || (ptg instanceof DeletedArea3DPtg) || (ptg instanceof DeletedRef3DPtg) || (ptg instanceof AreaErrPtg)) {
            return true;
        }
        return ptg instanceof RefErrorPtg;
    }

    public static Ptg[] readTokens(int i5, LittleEndianInput littleEndianInput) {
        ArrayList arrayList = new ArrayList((i5 / 2) + 4);
        int size = 0;
        boolean z6 = false;
        while (size < i5) {
            Ptg ptgCreatePtg = createPtg(littleEndianInput);
            if (ptgCreatePtg instanceof ArrayInitialPtg) {
                z6 = true;
            }
            size += ptgCreatePtg.getSize();
            arrayList.add(ptgCreatePtg);
        }
        if (size != i5) {
            throw new IllegalArgumentException("Ptg array size mismatch");
        }
        if (!z6) {
            return toPtgArray(arrayList);
        }
        Ptg[] ptgArray = toPtgArray(arrayList);
        for (int i6 = 0; i6 < ptgArray.length; i6++) {
            Ptg ptg = ptgArray[i6];
            if (ptg instanceof ArrayInitialPtg) {
                ptgArray[i6] = ((ArrayInitialPtg) ptg).finishReading(littleEndianInput);
            }
        }
        return ptgArray;
    }

    public static int serializePtgs(Ptg[] ptgArr, byte[] bArr, int i5) {
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i5);
        ArrayList arrayList = null;
        int i6 = 0;
        for (Ptg ptg : ptgArr) {
            ptg.write(littleEndianByteArrayOutputStream);
            if (ptg instanceof ArrayPtg) {
                if (arrayList == null) {
                    arrayList = new ArrayList(5);
                }
                arrayList.add(ptg);
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                ((ArrayPtg) ((Ptg) obj)).writeTokenValueBytes(littleEndianByteArrayOutputStream);
            }
        }
        return littleEndianByteArrayOutputStream.getWriteIndex() - i5;
    }

    private static Ptg[] toPtgArray(List<Ptg> list) {
        if (list.isEmpty()) {
            return EMPTY_PTG_ARRAY;
        }
        Ptg[] ptgArr = new Ptg[list.size()];
        list.toArray(ptgArr);
        return ptgArr;
    }

    @Override // org.apache.poi.common.Duplicatable
    public abstract Ptg copy();

    public abstract byte getDefaultOperandClass();

    public final byte getPtgClass() {
        return this.ptgClass;
    }

    public final char getRVAType() {
        if (isBaseToken()) {
            return '.';
        }
        byte b = this.ptgClass;
        if (b == 0) {
            return 'R';
        }
        if (b == 32) {
            return 'V';
        }
        if (b == 64) {
            return 'A';
        }
        throw new IllegalArgumentException(AbstractC0157z.l(")", this.ptgClass, new StringBuilder("Unknown operand class (")));
    }

    public abstract byte getSid();

    public abstract int getSize();

    public abstract boolean isBaseToken();

    public final void setClass(byte b) {
        if (isBaseToken()) {
            throw new IllegalStateException("setClass should not be called on a base token");
        }
        this.ptgClass = b;
    }

    public abstract String toFormulaString();

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public abstract void write(LittleEndianOutput littleEndianOutput);

    public Ptg(Ptg ptg) {
        this.ptgClass = (byte) 0;
        this.ptgClass = ptg.ptgClass;
    }
}
