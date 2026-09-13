package org.apache.commons.compress.harmony.pack200;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.objectweb.asm.Label;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BcBands extends BandSet {
    private static final int ALOAD_0 = 42;
    private static final int IINC = 132;
    private static final int INVOKEINTERFACE = 185;
    private static final int LOOKUPSWITCH = 171;
    private static final int MULTIANEWARRAY = 197;
    private static final int TABLESWITCH = 170;
    private static final int WIDE = 196;
    private static final int endMarker = 255;
    private final IntList bcByte;
    private final IntList bcCaseCount;
    private final IntList bcCaseValue;
    private final List bcClassRef;
    private final IntList bcCodes;
    private final List bcDoubleRef;
    private final List bcFieldRef;
    private final List bcFloatRef;
    private final List bcIMethodRef;
    private List bcInitRef;
    private final List bcIntref;
    private final List bcLabel;
    private final IntList bcLabelRelativeOffsets;
    private final IntList bcLocal;
    private final List bcLongRef;
    private final List bcMethodRef;
    private final IntList bcShort;
    private final List bcStringRef;
    private final List bcSuperField;
    private List bcSuperMethod;
    private List bcThisField;
    private List bcThisMethod;
    private final IntList bciRenumbering;
    private int byteCodeOffset;
    private final CpBands cpBands;
    private String currentClass;
    private String currentNewClass;
    private final Map labelsToOffsets;
    private int renumberedOffset;
    private final Segment segment;
    private String superClass;

    public BcBands(CpBands cpBands, Segment segment, int i5) {
        super(i5, segment.getSegmentHeader());
        this.bcCodes = new IntList();
        this.bcCaseCount = new IntList();
        this.bcCaseValue = new IntList();
        this.bcByte = new IntList();
        this.bcShort = new IntList();
        this.bcLocal = new IntList();
        this.bcLabel = new ArrayList();
        this.bcIntref = new ArrayList();
        this.bcFloatRef = new ArrayList();
        this.bcLongRef = new ArrayList();
        this.bcDoubleRef = new ArrayList();
        this.bcStringRef = new ArrayList();
        this.bcClassRef = new ArrayList();
        this.bcFieldRef = new ArrayList();
        this.bcMethodRef = new ArrayList();
        this.bcIMethodRef = new ArrayList();
        this.bcThisField = new ArrayList();
        this.bcSuperField = new ArrayList();
        this.bcThisMethod = new ArrayList();
        this.bcSuperMethod = new ArrayList();
        this.bcInitRef = new ArrayList();
        this.bciRenumbering = new IntList();
        this.labelsToOffsets = new HashMap();
        this.bcLabelRelativeOffsets = new IntList();
        this.cpBands = cpBands;
        this.segment = segment;
    }

    private List getIndexInClass(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            arrayList.add(Integer.valueOf(((CPMethodOrField) list.get(i5)).getIndexInClass()));
        }
        return arrayList;
    }

    private List getIndexInClassForConstructor(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            arrayList.add(Integer.valueOf(((CPMethodOrField) list.get(i5)).getIndexInClassForConstructor()));
        }
        return arrayList;
    }

    private void updateRenumbering() {
        if (this.bciRenumbering.isEmpty()) {
            this.bciRenumbering.add(0);
        }
        this.renumberedOffset++;
        for (int size = this.bciRenumbering.size(); size < this.byteCodeOffset; size++) {
            this.bciRenumbering.add(-1);
        }
        this.bciRenumbering.add(this.renumberedOffset);
    }

    public void finaliseBands() {
        this.bcThisField = getIndexInClass(this.bcThisField);
        this.bcThisMethod = getIndexInClass(this.bcThisMethod);
        this.bcSuperMethod = getIndexInClass(this.bcSuperMethod);
        this.bcInitRef = getIndexInClassForConstructor(this.bcInitRef);
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) {
        PackingUtils.log("Writing byte code bands...");
        int[] array = this.bcCodes.toArray();
        BHSDCodec bHSDCodec = Codec.BYTE1;
        byte[] bArrEncodeBandInt = encodeBandInt("bcCodes", array, bHSDCodec);
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI.append(bArrEncodeBandInt.length);
        sbI.append(" bytes from bcCodes[");
        sbI.append(this.bcCodes.size());
        sbI.append("]");
        PackingUtils.log(sbI.toString());
        int[] array2 = this.bcCaseCount.toArray();
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        byte[] bArrEncodeBandInt2 = encodeBandInt("bcCaseCount", array2, bHSDCodec2);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote ");
        sbI2.append(bArrEncodeBandInt2.length);
        sbI2.append(" bytes from bcCaseCount[");
        sbI2.append(this.bcCaseCount.size());
        sbI2.append("]");
        PackingUtils.log(sbI2.toString());
        int[] array3 = this.bcCaseValue.toArray();
        BHSDCodec bHSDCodec3 = Codec.DELTA5;
        byte[] bArrEncodeBandInt3 = encodeBandInt("bcCaseValue", array3, bHSDCodec3);
        StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt3, "Wrote ");
        sbI3.append(bArrEncodeBandInt3.length);
        sbI3.append(" bytes from bcCaseValue[");
        sbI3.append(this.bcCaseValue.size());
        sbI3.append("]");
        PackingUtils.log(sbI3.toString());
        byte[] bArrEncodeBandInt4 = encodeBandInt("bcByte", this.bcByte.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt4);
        PackingUtils.log("Wrote " + bArrEncodeBandInt4.length + " bytes from bcByte[" + this.bcByte.size() + "]");
        byte[] bArrEncodeBandInt5 = encodeBandInt("bcShort", this.bcShort.toArray(), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt5);
        PackingUtils.log("Wrote " + bArrEncodeBandInt5.length + " bytes from bcShort[" + this.bcShort.size() + "]");
        byte[] bArrEncodeBandInt6 = encodeBandInt("bcLocal", this.bcLocal.toArray(), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt6);
        PackingUtils.log("Wrote " + bArrEncodeBandInt6.length + " bytes from bcLocal[" + this.bcLocal.size() + "]");
        byte[] bArrEncodeBandInt7 = encodeBandInt("bcLabel", integerListToArray(this.bcLabel), Codec.BRANCH5);
        StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt7, "Wrote ");
        sbI4.append(bArrEncodeBandInt7.length);
        sbI4.append(" bytes from bcLabel[");
        AbstractC1125a.o(this.bcLabel, sbI4, "]");
        byte[] bArrEncodeBandInt8 = encodeBandInt("bcIntref", cpEntryListToArray(this.bcIntref), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt8);
        StringBuilder sb = new StringBuilder("Wrote ");
        sb.append(bArrEncodeBandInt8.length);
        sb.append(" bytes from bcIntref[");
        AbstractC1125a.o(this.bcIntref, sb, "]");
        byte[] bArrEncodeBandInt9 = encodeBandInt("bcFloatRef", cpEntryListToArray(this.bcFloatRef), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt9);
        StringBuilder sb2 = new StringBuilder("Wrote ");
        sb2.append(bArrEncodeBandInt9.length);
        sb2.append(" bytes from bcFloatRef[");
        AbstractC1125a.o(this.bcFloatRef, sb2, "]");
        byte[] bArrEncodeBandInt10 = encodeBandInt("bcLongRef", cpEntryListToArray(this.bcLongRef), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt10);
        StringBuilder sb3 = new StringBuilder("Wrote ");
        sb3.append(bArrEncodeBandInt10.length);
        sb3.append(" bytes from bcLongRef[");
        AbstractC1125a.o(this.bcLongRef, sb3, "]");
        byte[] bArrEncodeBandInt11 = encodeBandInt("bcDoubleRef", cpEntryListToArray(this.bcDoubleRef), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt11);
        StringBuilder sb4 = new StringBuilder("Wrote ");
        sb4.append(bArrEncodeBandInt11.length);
        sb4.append(" bytes from bcDoubleRef[");
        AbstractC1125a.o(this.bcDoubleRef, sb4, "]");
        byte[] bArrEncodeBandInt12 = encodeBandInt("bcStringRef", cpEntryListToArray(this.bcStringRef), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt12);
        StringBuilder sb5 = new StringBuilder("Wrote ");
        sb5.append(bArrEncodeBandInt12.length);
        sb5.append(" bytes from bcStringRef[");
        AbstractC1125a.o(this.bcStringRef, sb5, "]");
        byte[] bArrEncodeBandInt13 = encodeBandInt("bcClassRef", cpEntryOrNullListToArray(this.bcClassRef), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt13);
        StringBuilder sb6 = new StringBuilder("Wrote ");
        sb6.append(bArrEncodeBandInt13.length);
        sb6.append(" bytes from bcClassRef[");
        AbstractC1125a.o(this.bcClassRef, sb6, "]");
        byte[] bArrEncodeBandInt14 = encodeBandInt("bcFieldRef", cpEntryListToArray(this.bcFieldRef), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt14);
        StringBuilder sb7 = new StringBuilder("Wrote ");
        sb7.append(bArrEncodeBandInt14.length);
        sb7.append(" bytes from bcFieldRef[");
        AbstractC1125a.o(this.bcFieldRef, sb7, "]");
        byte[] bArrEncodeBandInt15 = encodeBandInt("bcMethodRef", cpEntryListToArray(this.bcMethodRef), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt15);
        StringBuilder sb8 = new StringBuilder("Wrote ");
        sb8.append(bArrEncodeBandInt15.length);
        sb8.append(" bytes from bcMethodRef[");
        AbstractC1125a.o(this.bcMethodRef, sb8, "]");
        byte[] bArrEncodeBandInt16 = encodeBandInt("bcIMethodRef", cpEntryListToArray(this.bcIMethodRef), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt16);
        StringBuilder sb9 = new StringBuilder("Wrote ");
        sb9.append(bArrEncodeBandInt16.length);
        sb9.append(" bytes from bcIMethodRef[");
        AbstractC1125a.o(this.bcIMethodRef, sb9, "]");
        byte[] bArrEncodeBandInt17 = encodeBandInt("bcThisField", integerListToArray(this.bcThisField), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt17);
        StringBuilder sb10 = new StringBuilder("Wrote ");
        sb10.append(bArrEncodeBandInt17.length);
        sb10.append(" bytes from bcThisField[");
        AbstractC1125a.o(this.bcThisField, sb10, "]");
        byte[] bArrEncodeBandInt18 = encodeBandInt("bcSuperField", integerListToArray(this.bcSuperField), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt18);
        StringBuilder sb11 = new StringBuilder("Wrote ");
        sb11.append(bArrEncodeBandInt18.length);
        sb11.append(" bytes from bcSuperField[");
        AbstractC1125a.o(this.bcSuperField, sb11, "]");
        byte[] bArrEncodeBandInt19 = encodeBandInt("bcThisMethod", integerListToArray(this.bcThisMethod), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt19);
        StringBuilder sb12 = new StringBuilder("Wrote ");
        sb12.append(bArrEncodeBandInt19.length);
        sb12.append(" bytes from bcThisMethod[");
        AbstractC1125a.o(this.bcThisMethod, sb12, "]");
        byte[] bArrEncodeBandInt20 = encodeBandInt("bcSuperMethod", integerListToArray(this.bcSuperMethod), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt20);
        StringBuilder sb13 = new StringBuilder("Wrote ");
        sb13.append(bArrEncodeBandInt20.length);
        sb13.append(" bytes from bcSuperMethod[");
        AbstractC1125a.o(this.bcSuperMethod, sb13, "]");
        byte[] bArrEncodeBandInt21 = encodeBandInt("bcInitRef", integerListToArray(this.bcInitRef), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt21);
        StringBuilder sb14 = new StringBuilder("Wrote ");
        sb14.append(bArrEncodeBandInt21.length);
        sb14.append(" bytes from bcInitRef[");
        AbstractC1125a.o(this.bcInitRef, sb14, "]");
    }

    public void setCurrentClass(String str, String str2) {
        this.currentClass = str;
        this.superClass = str2;
    }

    public void visitEnd() {
        for (int i5 = 0; i5 < this.bciRenumbering.size(); i5++) {
            if (this.bciRenumbering.get(i5) == -1) {
                this.bciRenumbering.remove(i5);
                IntList intList = this.bciRenumbering;
                int i6 = this.renumberedOffset + 1;
                this.renumberedOffset = i6;
                intList.add(i5, i6);
            }
        }
        int i7 = this.renumberedOffset;
        if (i7 != 0) {
            if (i7 + 1 != this.bciRenumbering.size()) {
                throw new RuntimeException("Mistake made with renumbering");
            }
            for (int size = this.bcLabel.size() - 1; size >= 0; size--) {
                Object obj = this.bcLabel.get(size);
                if (obj instanceof Integer) {
                    break;
                }
                if (obj instanceof Label) {
                    this.bcLabel.remove(size);
                    this.bcLabel.add(size, Integer.valueOf(this.bciRenumbering.get(((Integer) this.labelsToOffsets.get(obj)).intValue()) - this.bciRenumbering.get(this.bcLabelRelativeOffsets.get(size))));
                }
            }
            this.bcCodes.add(255);
            this.segment.getClassBands().doBciRenumbering(this.bciRenumbering, this.labelsToOffsets);
            this.bciRenumbering.clear();
            this.labelsToOffsets.clear();
            this.byteCodeOffset = 0;
            this.renumberedOffset = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002c  */
    public void visitFieldInsn(int i5, String str, String str2, String str3) {
        boolean z6;
        this.byteCodeOffset += 3;
        updateRenumbering();
        if (this.bcCodes.size() > 0) {
            IntList intList = this.bcCodes;
            z6 = true;
            if (intList.get(intList.size() - 1) == 42) {
                IntList intList2 = this.bcCodes;
                intList2.remove(intList2.size() - 1);
            } else {
                z6 = false;
            }
        } else {
            z6 = false;
        }
        CPMethodOrField cPField = this.cpBands.getCPField(str, str2, str3);
        if (z6) {
            i5 += 7;
        }
        if (str.equals(this.currentClass)) {
            i5 += 24;
            this.bcThisField.add(cPField);
        } else {
            if (z6) {
                i5 -= 7;
                this.bcCodes.add(42);
            }
            this.bcFieldRef.add(cPField);
        }
        this.bcCodes.add(i5);
    }

    public void visitIincInsn(int i5, int i6) {
        if (i5 > 255 || i6 > 255) {
            this.byteCodeOffset += 6;
            this.bcCodes.add(196);
            this.bcCodes.add(132);
            this.bcLocal.add(i5);
            this.bcShort.add(i6);
        } else {
            this.byteCodeOffset += 3;
            this.bcCodes.add(132);
            this.bcLocal.add(i5);
            this.bcByte.add(i6 & 255);
        }
        updateRenumbering();
    }

    public void visitInsn(int i5) {
        if (i5 >= 202) {
            throw new RuntimeException("Non-standard bytecode instructions not supported");
        }
        this.bcCodes.add(i5);
        this.byteCodeOffset++;
        updateRenumbering();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    public void visitIntInsn(int i5, int i6) {
        if (i5 == 16) {
            this.bcCodes.add(i5);
            this.bcByte.add(i6 & 255);
            this.byteCodeOffset += 2;
        } else if (i5 == 17) {
            this.bcCodes.add(i5);
            this.bcShort.add(i6);
            this.byteCodeOffset += 3;
        } else if (i5 == 188) {
            this.bcCodes.add(i5);
            this.bcByte.add(i6 & 255);
            this.byteCodeOffset += 2;
        }
        updateRenumbering();
    }

    public void visitJumpInsn(int i5, Label label) {
        this.bcCodes.add(i5);
        this.bcLabel.add(label);
        this.bcLabelRelativeOffsets.add(this.byteCodeOffset);
        this.byteCodeOffset += 3;
        updateRenumbering();
    }

    public void visitLabel(Label label) {
        this.labelsToOffsets.put(label, Integer.valueOf(this.byteCodeOffset));
    }

    public void visitLdcInsn(Object obj) {
        CPConstant constant = this.cpBands.getConstant(obj);
        if (this.segment.lastConstantHadWideIndex() || (constant instanceof CPLong) || (constant instanceof CPDouble)) {
            this.byteCodeOffset += 3;
            if (constant instanceof CPInt) {
                this.bcCodes.add(237);
                this.bcIntref.add(constant);
            } else if (constant instanceof CPFloat) {
                this.bcCodes.add(238);
                this.bcFloatRef.add(constant);
            } else if (constant instanceof CPLong) {
                this.bcCodes.add(20);
                this.bcLongRef.add(constant);
            } else if (constant instanceof CPDouble) {
                this.bcCodes.add(239);
                this.bcDoubleRef.add(constant);
            } else if (constant instanceof CPString) {
                this.bcCodes.add(19);
                this.bcStringRef.add(constant);
            } else {
                if (!(constant instanceof CPClass)) {
                    throw new RuntimeException("Constant should not be null");
                }
                this.bcCodes.add(236);
                this.bcClassRef.add(constant);
            }
        } else {
            this.byteCodeOffset += 2;
            if (constant instanceof CPInt) {
                this.bcCodes.add(234);
                this.bcIntref.add(constant);
            } else if (constant instanceof CPFloat) {
                this.bcCodes.add(235);
                this.bcFloatRef.add(constant);
            } else if (constant instanceof CPString) {
                this.bcCodes.add(18);
                this.bcStringRef.add(constant);
            } else if (constant instanceof CPClass) {
                this.bcCodes.add(233);
                this.bcClassRef.add(constant);
            }
        }
        updateRenumbering();
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        this.bcCodes.add(171);
        this.bcLabel.add(label);
        this.bcLabelRelativeOffsets.add(this.byteCodeOffset);
        this.bcCaseCount.add(iArr.length);
        for (int i5 = 0; i5 < labelArr.length; i5++) {
            this.bcCaseValue.add(iArr[i5]);
            this.bcLabel.add(labelArr[i5]);
            this.bcLabelRelativeOffsets.add(this.byteCodeOffset);
        }
        int i6 = this.byteCodeOffset;
        this.byteCodeOffset = (iArr.length * 8) + ((i6 + 1) % 4 != 0 ? 4 - ((i6 + 1) % 4) : 0) + 9 + i6;
        updateRenumbering();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0048  */
    public void visitMethodInsn(int i5, String str, String str2, String str3) {
        boolean z6;
        int i6 = this.byteCodeOffset;
        this.byteCodeOffset = i6 + 3;
        switch (i5) {
            case 182:
            case 183:
            case 184:
                if (this.bcCodes.size() > 0) {
                    IntList intList = this.bcCodes;
                    z6 = true;
                    if (intList.get(intList.size() - 1) == 42) {
                        IntList intList2 = this.bcCodes;
                        intList2.remove(intList2.size() - 1);
                        i5 += 7;
                    } else {
                        z6 = false;
                    }
                } else {
                    z6 = false;
                }
                if (str.equals(this.currentClass)) {
                    i5 += 24;
                    if (str2.equals("<init>") && i5 == 207) {
                        this.bcInitRef.add(this.cpBands.getCPMethod(str, str2, str3));
                        i5 = 230;
                    } else {
                        this.bcThisMethod.add(this.cpBands.getCPMethod(str, str2, str3));
                    }
                } else if (str.equals(this.superClass)) {
                    i5 += 38;
                    if (str2.equals("<init>") && i5 == 221) {
                        this.bcInitRef.add(this.cpBands.getCPMethod(str, str2, str3));
                        i5 = 231;
                    } else {
                        this.bcSuperMethod.add(this.cpBands.getCPMethod(str, str2, str3));
                    }
                } else {
                    if (z6) {
                        i5 -= 7;
                        this.bcCodes.add(42);
                    }
                    if (str2.equals("<init>") && i5 == 183 && str.equals(this.currentNewClass)) {
                        this.bcInitRef.add(this.cpBands.getCPMethod(str, str2, str3));
                        i5 = 232;
                    } else {
                        this.bcMethodRef.add(this.cpBands.getCPMethod(str, str2, str3));
                    }
                }
                this.bcCodes.add(i5);
                break;
            case 185:
                this.byteCodeOffset = i6 + 5;
                this.bcIMethodRef.add(this.cpBands.getCPIMethod(str, str2, str3));
                this.bcCodes.add(185);
                break;
        }
        updateRenumbering();
    }

    public void visitMultiANewArrayInsn(String str, int i5) {
        this.byteCodeOffset += 4;
        updateRenumbering();
        this.bcCodes.add(197);
        this.bcClassRef.add(this.cpBands.getCPClass(str));
        this.bcByte.add(i5 & 255);
    }

    public void visitTableSwitchInsn(int i5, int i6, Label label, Label[] labelArr) {
        this.bcCodes.add(170);
        this.bcLabel.add(label);
        this.bcLabelRelativeOffsets.add(this.byteCodeOffset);
        this.bcCaseValue.add(i5);
        this.bcCaseCount.add(labelArr.length);
        for (Label label2 : labelArr) {
            this.bcLabel.add(label2);
            this.bcLabelRelativeOffsets.add(this.byteCodeOffset);
        }
        int i7 = this.byteCodeOffset;
        this.byteCodeOffset = (labelArr.length * 4) + (i7 % 4 != 0 ? 4 - (i7 % 4) : 0) + 12 + i7;
        updateRenumbering();
    }

    public void visitTypeInsn(int i5, String str) {
        this.byteCodeOffset += 3;
        updateRenumbering();
        this.bcCodes.add(i5);
        this.bcClassRef.add(this.cpBands.getCPClass(str));
        if (i5 == 187) {
            this.currentNewClass = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    public void visitVarInsn(int i5, int i6) {
        if (i6 <= 255) {
            if (i6 <= 3 && i5 != 169) {
                this.byteCodeOffset++;
                switch (i5) {
                    case 21:
                        this.bcCodes.add(i5 + 5 + i6);
                        break;
                    case 22:
                        this.bcCodes.add(i5 + 8 + i6);
                        break;
                    case 23:
                        this.bcCodes.add(i5 + 11 + i6);
                        break;
                    case 24:
                        this.bcCodes.add(i5 + 14 + i6);
                        break;
                    case 25:
                        this.bcCodes.add(i5 + 17 + i6);
                        break;
                    default:
                        switch (i5) {
                            case 54:
                                this.bcCodes.add(i5 + 5 + i6);
                                break;
                            case 55:
                                this.bcCodes.add(i5 + 8 + i6);
                                break;
                            case 56:
                                this.bcCodes.add(i5 + 11 + i6);
                                break;
                            case 57:
                                this.bcCodes.add(i5 + 14 + i6);
                                break;
                            case 58:
                                this.bcCodes.add(i5 + 17 + i6);
                                break;
                        }
                        break;
                }
            } else {
                this.byteCodeOffset += 2;
                this.bcCodes.add(i5);
                this.bcLocal.add(i6);
            }
        } else {
            this.byteCodeOffset += 4;
            this.bcCodes.add(196);
            this.bcCodes.add(i5);
            this.bcLocal.add(i6);
        }
        updateRenumbering();
    }
}
