package org.apache.commons.compress.harmony.unpack200;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BcBands extends BandSet {
    private int[] bcByte;
    private int[] bcCaseCount;
    private int[] bcCaseValue;
    private int[] bcClassRef;
    private int[] bcDoubleRef;
    private int[][] bcEscByte;
    private int[] bcEscRef;
    private int[] bcEscRefSize;
    private int[] bcEscSize;
    private int[] bcFieldRef;
    private int[] bcFloatRef;
    private int[] bcIMethodRef;
    private int[] bcInitRef;
    private int[] bcIntRef;
    private int[] bcLabel;
    private int[] bcLocal;
    private int[] bcLongRef;
    private int[] bcMethodRef;
    private int[] bcShort;
    private int[] bcStringRef;
    private int[] bcSuperField;
    private int[] bcSuperMethod;
    private int[] bcThisField;
    private int[] bcThisMethod;
    private byte[][][] methodByteCodePacked;
    private List wideByteCodes;

    public BcBands(Segment segment) {
        super(segment);
    }

    private boolean endsWithLoad(int i5) {
        return i5 >= 21 && i5 <= 25;
    }

    private boolean endsWithStore(int i5) {
        return i5 >= 54 && i5 <= 58;
    }

    private boolean startsWithIf(int i5) {
        return (i5 >= 153 && i5 <= 166) || i5 == 198 || i5 == 199;
    }

    public int[] getBcByte() {
        return this.bcByte;
    }

    public int[] getBcCaseCount() {
        return this.bcCaseCount;
    }

    public int[] getBcCaseValue() {
        return this.bcCaseValue;
    }

    public int[] getBcClassRef() {
        return this.bcClassRef;
    }

    public int[] getBcDoubleRef() {
        return this.bcDoubleRef;
    }

    public int[] getBcFieldRef() {
        return this.bcFieldRef;
    }

    public int[] getBcFloatRef() {
        return this.bcFloatRef;
    }

    public int[] getBcIMethodRef() {
        return this.bcIMethodRef;
    }

    public int[] getBcInitRef() {
        return this.bcInitRef;
    }

    public int[] getBcIntRef() {
        return this.bcIntRef;
    }

    public int[] getBcLabel() {
        return this.bcLabel;
    }

    public int[] getBcLocal() {
        return this.bcLocal;
    }

    public int[] getBcLongRef() {
        return this.bcLongRef;
    }

    public int[] getBcMethodRef() {
        return this.bcMethodRef;
    }

    public int[] getBcShort() {
        return this.bcShort;
    }

    public int[] getBcStringRef() {
        return this.bcStringRef;
    }

    public int[] getBcSuperField() {
        return this.bcSuperField;
    }

    public int[] getBcSuperMethod() {
        return this.bcSuperMethod;
    }

    public int[] getBcThisField() {
        return this.bcThisField;
    }

    public int[] getBcThisMethod() {
        return this.bcThisMethod;
    }

    public byte[][][] getMethodByteCodePacked() {
        return this.methodByteCodePacked;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x0114 A[PHI: r10
  0x0114: PHI (r10v8 int) = (r10v4 int), (r10v7 int), (r10v4 int), (r10v4 int) binds: [B:35:0x00f5, B:61:0x0144, B:38:0x00fe, B:45:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x011b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0156  */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00f2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x00f5. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x00f8. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x00fb. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x00fe. Please report as an issue. */
    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void read(InputStream inputStream) {
        AttributeLayout attributeLayout;
        int i5;
        AttributeLayoutMap attributeDefinitionMap = this.segment.getAttrDefinitionBands().getAttributeDefinitionMap();
        int classCount = this.header.getClassCount();
        long[][] methodFlags = this.segment.getClassBands().getMethodFlags();
        AttributeLayout attributeLayout2 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_ABSTRACT, 2);
        AttributeLayout attributeLayout3 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_NATIVE, 2);
        this.methodByteCodePacked = new byte[classCount][][];
        ArrayList arrayList = new ArrayList();
        this.wideByteCodes = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i7 < classCount) {
            int length = methodFlags[i7].length;
            int i28 = classCount;
            this.methodByteCodePacked[i7] = new byte[length][];
            int i29 = 0;
            while (i29 < length) {
                int i30 = i29;
                long[][] jArr = methodFlags;
                long j6 = methodFlags[i7][i30];
                if (attributeLayout2.matches(j6) || attributeLayout3.matches(j6)) {
                    attributeLayout = attributeLayout3;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        byte b = (byte) (inputStream.read() & 255);
                        attributeLayout = attributeLayout3;
                        if (b != -1) {
                            byteArrayOutputStream.write(b);
                            attributeLayout3 = attributeLayout;
                        } else {
                            this.methodByteCodePacked[i7][i30] = byteArrayOutputStream.toByteArray();
                            byte[] bArr = this.methodByteCodePacked[i7][i30];
                            int length2 = bArr.length;
                            int length3 = bArr.length;
                            int[] iArr = new int[length3];
                            int i31 = 0;
                            while (i31 < length3) {
                                iArr[i31] = this.methodByteCodePacked[i7][i30][i31] & UnsignedBytes.MAX_VALUE;
                                i31++;
                                length3 = length3;
                            }
                            int i32 = 0;
                            while (true) {
                                byte[] bArr2 = this.methodByteCodePacked[i7][i30];
                                if (i32 < bArr2.length) {
                                    int i33 = bArr2[i32] & UnsignedBytes.MAX_VALUE;
                                    int i34 = i32;
                                    if (i33 != 132) {
                                        if (i33 == 192 || i33 == 193) {
                                            i17++;
                                        } else if (i33 != 196) {
                                            if (i33 != 197) {
                                                if (i33 == 253) {
                                                    i27++;
                                                } else if (i33 != 254) {
                                                    switch (i33) {
                                                        case 16:
                                                            i9++;
                                                            break;
                                                        case 17:
                                                            i10++;
                                                            break;
                                                        case 18:
                                                        case 19:
                                                            i16++;
                                                            break;
                                                        case 20:
                                                            i14++;
                                                            break;
                                                        default:
                                                            switch (i33) {
                                                                case 167:
                                                                case 168:
                                                                    i12++;
                                                                    break;
                                                                case 169:
                                                                    i11++;
                                                                    break;
                                                                case 170:
                                                                    arrayList.add(Boolean.TRUE);
                                                                    i8++;
                                                                    i12++;
                                                                    break;
                                                                case 171:
                                                                    arrayList.add(Boolean.FALSE);
                                                                    i8++;
                                                                    i12++;
                                                                    break;
                                                                default:
                                                                    switch (i33) {
                                                                        case 178:
                                                                        case 179:
                                                                        case 180:
                                                                        case 181:
                                                                            i18++;
                                                                            break;
                                                                        case 182:
                                                                        case 183:
                                                                        case 184:
                                                                            i19++;
                                                                            break;
                                                                        case 185:
                                                                            i20++;
                                                                            break;
                                                                        default:
                                                                            switch (i33) {
                                                                                case 187:
                                                                                case 189:
                                                                                    break;
                                                                                case 188:
                                                                                    i9++;
                                                                                    break;
                                                                                default:
                                                                                    switch (i33) {
                                                                                        case 200:
                                                                                        case 201:
                                                                                            i12++;
                                                                                            break;
                                                                                        case 202:
                                                                                        case 203:
                                                                                        case 204:
                                                                                        case 205:
                                                                                        case 209:
                                                                                        case 210:
                                                                                        case 211:
                                                                                        case 212:
                                                                                            i21++;
                                                                                            break;
                                                                                        case 206:
                                                                                        case 207:
                                                                                        case 208:
                                                                                        case 213:
                                                                                        case 214:
                                                                                        case 215:
                                                                                            i23++;
                                                                                            break;
                                                                                        case 216:
                                                                                        case 217:
                                                                                        case 218:
                                                                                        case 219:
                                                                                        case 223:
                                                                                        case 224:
                                                                                        case 225:
                                                                                        case 226:
                                                                                            i22++;
                                                                                            break;
                                                                                        case 220:
                                                                                        case 221:
                                                                                        case 222:
                                                                                        case 227:
                                                                                        case 228:
                                                                                        case 229:
                                                                                            i24++;
                                                                                            break;
                                                                                        case 230:
                                                                                        case 231:
                                                                                        case 232:
                                                                                            i25++;
                                                                                            break;
                                                                                        case 233:
                                                                                        case 236:
                                                                                            break;
                                                                                        case 234:
                                                                                        case 237:
                                                                                            i13++;
                                                                                            break;
                                                                                        case 235:
                                                                                        case 238:
                                                                                            i6++;
                                                                                            break;
                                                                                        case 239:
                                                                                            i15++;
                                                                                            break;
                                                                                        default:
                                                                                            if (endsWithLoad(i33) || endsWithStore(i33)) {
                                                                                                i11++;
                                                                                            } else if (startsWithIf(i33)) {
                                                                                                i12++;
                                                                                            }
                                                                                            break;
                                                                                    }
                                                                                    break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    i26++;
                                                }
                                                i5 = i34;
                                            } else {
                                                i9++;
                                            }
                                            i17++;
                                        } else {
                                            int i35 = i34 + 1;
                                            int i36 = bArr2[i35] & UnsignedBytes.MAX_VALUE;
                                            i34 = i35;
                                            this.wideByteCodes.add(Integer.valueOf(i36));
                                            if (i36 == 132) {
                                                i11++;
                                                i10++;
                                            } else if (endsWithLoad(i36) || endsWithStore(i36) || i36 == 169) {
                                                i11++;
                                            } else {
                                                this.segment.log(2, "Found unhandled " + ByteCode.getByteCode(i36));
                                            }
                                        }
                                        i32 = i5 + 1;
                                    } else {
                                        i11++;
                                        i9++;
                                    }
                                    i5 = i34;
                                    i32 = i5 + 1;
                                }
                            }
                        }
                    }
                }
                i29 = i30 + 1;
                attributeLayout3 = attributeLayout;
                methodFlags = jArr;
            }
            i7++;
            classCount = i28;
            methodFlags = methodFlags;
        }
        this.bcCaseCount = decodeBandInt("bc_case_count", inputStream, Codec.UNSIGNED5, i8);
        int i37 = 0;
        for (int i38 = 0; i38 < this.bcCaseCount.length; i38++) {
            i37 = ((Boolean) arrayList.get(i38)).booleanValue() ? i37 + 1 : i37 + this.bcCaseCount[i38];
        }
        this.bcCaseValue = decodeBandInt("bc_case_value", inputStream, Codec.DELTA5, i37);
        for (int i39 = 0; i39 < i8; i39++) {
            i12 += this.bcCaseCount[i39];
        }
        BHSDCodec bHSDCodec = Codec.BYTE1;
        this.bcByte = decodeBandInt("bc_byte", inputStream, bHSDCodec, i9);
        BHSDCodec bHSDCodec2 = Codec.DELTA5;
        this.bcShort = decodeBandInt("bc_short", inputStream, bHSDCodec2, i10);
        BHSDCodec bHSDCodec3 = Codec.UNSIGNED5;
        this.bcLocal = decodeBandInt("bc_local", inputStream, bHSDCodec3, i11);
        this.bcLabel = decodeBandInt("bc_label", inputStream, Codec.BRANCH5, i12);
        this.bcIntRef = decodeBandInt("bc_intref", inputStream, bHSDCodec2, i13);
        this.bcFloatRef = decodeBandInt("bc_floatref", inputStream, bHSDCodec2, i6);
        this.bcLongRef = decodeBandInt("bc_longref", inputStream, bHSDCodec2, i14);
        this.bcDoubleRef = decodeBandInt("bc_doubleref", inputStream, bHSDCodec2, i15);
        this.bcStringRef = decodeBandInt("bc_stringref", inputStream, bHSDCodec2, i16);
        this.bcClassRef = decodeBandInt("bc_classref", inputStream, bHSDCodec3, i17);
        this.bcFieldRef = decodeBandInt("bc_fieldref", inputStream, bHSDCodec2, i18);
        this.bcMethodRef = decodeBandInt("bc_methodref", inputStream, bHSDCodec3, i19);
        this.bcIMethodRef = decodeBandInt("bc_imethodref", inputStream, bHSDCodec2, i20);
        this.bcThisField = decodeBandInt("bc_thisfield", inputStream, bHSDCodec3, i21);
        this.bcSuperField = decodeBandInt("bc_superfield", inputStream, bHSDCodec3, i22);
        this.bcThisMethod = decodeBandInt("bc_thismethod", inputStream, bHSDCodec3, i23);
        this.bcSuperMethod = decodeBandInt("bc_supermethod", inputStream, bHSDCodec3, i24);
        this.bcInitRef = decodeBandInt("bc_initref", inputStream, bHSDCodec3, i25);
        int i40 = i27;
        this.bcEscRef = decodeBandInt("bc_escref", inputStream, bHSDCodec3, i40);
        this.bcEscRefSize = decodeBandInt("bc_escrefsize", inputStream, bHSDCodec3, i40);
        int[] iArrDecodeBandInt = decodeBandInt("bc_escsize", inputStream, bHSDCodec3, i26);
        this.bcEscSize = iArrDecodeBandInt;
        this.bcEscByte = decodeBandInt("bc_escbyte", inputStream, bHSDCodec, iArrDecodeBandInt);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x024b  */
    /* JADX WARN: Code duplicated, block: B:48:0x025a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0261 A[SYNTHETIC] */
    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void unpack() {
        ArrayList[][] arrayListArr;
        String[][] strArr;
        AttributeLayout attributeLayout;
        int i5;
        List list;
        int i6;
        Attribute attribute;
        int classCount = this.header.getClassCount();
        long[][] methodFlags = this.segment.getClassBands().getMethodFlags();
        int[] codeMaxNALocals = this.segment.getClassBands().getCodeMaxNALocals();
        int[] codeMaxStack = this.segment.getClassBands().getCodeMaxStack();
        ArrayList[][] methodAttributes = this.segment.getClassBands().getMethodAttributes();
        String[][] methodDescr = this.segment.getClassBands().getMethodDescr();
        AttributeLayoutMap attributeDefinitionMap = this.segment.getAttrDefinitionBands().getAttributeDefinitionMap();
        AttributeLayout attributeLayout2 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_ABSTRACT, 2);
        AttributeLayout attributeLayout3 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_NATIVE, 2);
        AttributeLayout attributeLayout4 = attributeDefinitionMap.getAttributeLayout(AttributeLayout.ACC_STATIC, 2);
        int size = this.wideByteCodes.size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr[i7] = ((Integer) this.wideByteCodes.get(i7)).intValue();
        }
        OperandManager operandManager = new OperandManager(this.bcCaseCount, this.bcCaseValue, this.bcByte, this.bcShort, this.bcLocal, this.bcLabel, this.bcIntRef, this.bcFloatRef, this.bcLongRef, this.bcDoubleRef, this.bcStringRef, this.bcClassRef, this.bcFieldRef, this.bcMethodRef, this.bcIMethodRef, this.bcThisField, this.bcSuperField, this.bcThisMethod, this.bcSuperMethod, this.bcInitRef, iArr);
        operandManager.setSegment(this.segment);
        ArrayList orderedCodeAttributes = this.segment.getClassBands().getOrderedCodeAttributes();
        int[] codeHandlerCount = this.segment.getClassBands().getCodeHandlerCount();
        int[][] codeHandlerStartP = this.segment.getClassBands().getCodeHandlerStartP();
        int[][] codeHandlerEndPO = this.segment.getClassBands().getCodeHandlerEndPO();
        int[][] codeHandlerCatchPO = this.segment.getClassBands().getCodeHandlerCatchPO();
        int[][] codeHandlerClassRCN = this.segment.getClassBands().getCodeHandlerClassRCN();
        boolean zHasAllCodeFlags = this.segment.getSegmentHeader().getOptions().hasAllCodeFlags();
        boolean[] codeHasAttributes = this.segment.getClassBands().getCodeHasAttributes();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < classCount) {
            int i11 = classCount;
            int length = methodFlags[i8].length;
            int[] iArr2 = codeMaxNALocals;
            int i12 = 0;
            while (i12 < length) {
                int i13 = i12;
                int[] iArr3 = codeMaxStack;
                long j6 = methodFlags[i8][i13];
                if (attributeLayout2.matches(j6) || attributeLayout3.matches(j6)) {
                    arrayListArr = methodAttributes;
                    strArr = methodDescr;
                    attributeLayout = attributeLayout4;
                    i5 = i8;
                    i9 = i9;
                    i10 = i10;
                } else {
                    int i14 = i9;
                    int i15 = iArr3[i14];
                    int i16 = iArr2[i14];
                    if (!attributeLayout4.matches(j6)) {
                        i16++;
                    }
                    int iCountInvokeInterfaceArgs = SegmentUtils.countInvokeInterfaceArgs(methodDescr[i8][i13]) + i16;
                    String[] cpClass = this.segment.getCpBands().getCpClass();
                    operandManager.setCurrentClass(cpClass[this.segment.getClassBands().getClassThisInts()[i8]]);
                    operandManager.setSuperClass(cpClass[this.segment.getClassBands().getClassSuperInts()[i8]]);
                    ArrayList arrayList = new ArrayList();
                    if (codeHandlerCount != null) {
                        int i17 = 0;
                        while (i17 < codeHandlerCount[i14]) {
                            int i18 = codeHandlerClassRCN[i14][i17] - 1;
                            int i19 = i17;
                            arrayList.add(new ExceptionTableEntry(codeHandlerStartP[i14][i19], codeHandlerEndPO[i14][i19], codeHandlerCatchPO[i14][i19], i18 != -1 ? this.segment.getCpBands().cpClassValue(i18) : null));
                            i17 = i19 + 1;
                            methodAttributes = methodAttributes;
                            methodDescr = methodDescr;
                            attributeLayout4 = attributeLayout4;
                        }
                    }
                    arrayListArr = methodAttributes;
                    strArr = methodDescr;
                    attributeLayout = attributeLayout4;
                    int i20 = i8;
                    i5 = i20;
                    int i21 = i10;
                    CodeAttribute codeAttribute = new CodeAttribute(i15, iCountInvokeInterfaceArgs, this.methodByteCodePacked[i20][i13], this.segment, operandManager, arrayList);
                    ArrayList arrayList2 = arrayListArr[i5][i13];
                    int i22 = 0;
                    for (int i23 = 0; i23 < arrayList2.size(); i23++) {
                        Attribute attribute2 = (Attribute) arrayList2.get(i23);
                        if (!(attribute2 instanceof NewAttribute) || ((NewAttribute) attribute2).getLayoutIndex() >= 15) {
                            break;
                        }
                        i22++;
                    }
                    arrayList2.add(i22, codeAttribute);
                    codeAttribute.renumber(codeAttribute.byteCodeOffsets);
                    if (zHasAllCodeFlags) {
                        list = (List) orderedCodeAttributes.get(i14);
                    } else {
                        if (codeHasAttributes[i14]) {
                            list = (List) orderedCodeAttributes.get(i21);
                            i10 = i21 + 1;
                        } else {
                            list = Collections.EMPTY_LIST;
                        }
                        for (i6 = 0; i6 < list.size(); i6++) {
                            attribute = (Attribute) list.get(i6);
                            codeAttribute.addAttribute(attribute);
                            if (attribute.hasBCIRenumbering()) {
                                ((BCIRenumberedAttribute) attribute).renumber(codeAttribute.byteCodeOffsets);
                            }
                        }
                        i9 = i14 + 1;
                    }
                    i10 = i21;
                    while (i6 < list.size()) {
                        attribute = (Attribute) list.get(i6);
                        codeAttribute.addAttribute(attribute);
                        if (attribute.hasBCIRenumbering()) {
                            ((BCIRenumberedAttribute) attribute).renumber(codeAttribute.byteCodeOffsets);
                        }
                    }
                    i9 = i14 + 1;
                }
                i12 = i13 + 1;
                i8 = i5;
                codeMaxStack = iArr3;
                length = length;
                methodAttributes = arrayListArr;
                methodDescr = strArr;
                attributeLayout4 = attributeLayout;
            }
            i8++;
            classCount = i11;
            codeMaxNALocals = iArr2;
            codeMaxStack = codeMaxStack;
        }
    }
}
