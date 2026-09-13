package org.apache.commons.compress.harmony.unpack200;

import androidx.exifinterface.media.ExifInterface;
import androidx.exifinterface.media.a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.DeprecatedAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTypeTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;
import org.opencv.core.Core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassBands extends BandSet {
    private final AttributeLayoutMap attrMap;
    private long[] classAccessFlags;
    private ArrayList[] classAttributes;
    private final int classCount;
    private int[] classFieldCount;
    private long[] classFlags;
    private int[][] classInterfacesInts;
    private int[] classMethodCount;
    private int[] classSuperInts;
    private String[] classThis;
    private int[] classThisInts;
    private int[] classVersionMajor;
    private int[] classVersionMinor;
    private List[] codeAttributes;
    private int[][] codeHandlerCatchPO;
    private int[][] codeHandlerClassRCN;
    private int[] codeHandlerCount;
    private int[][] codeHandlerEndPO;
    private int[][] codeHandlerStartP;
    private boolean[] codeHasAttributes;
    private int[] codeMaxNALocals;
    private int[] codeMaxStack;
    private final CpBands cpBands;
    private long[][] fieldAccessFlags;
    private ArrayList[][] fieldAttributes;
    private String[][] fieldDescr;
    private int[][] fieldDescrInts;
    private long[][] fieldFlags;
    private IcTuple[][] icLocal;
    private long[][] methodAccessFlags;
    private int[] methodAttrCalls;
    private ArrayList[][] methodAttributes;
    private String[][] methodDescr;
    private int[][] methodDescrInts;
    private long[][] methodFlags;
    private final SegmentOptions options;

    public ClassBands(Segment segment) {
        super(segment);
        this.attrMap = segment.getAttrDefinitionBands().getAttributeDefinitionMap();
        this.cpBands = segment.getCpBands();
        this.classCount = this.header.getClassCount();
        this.options = this.header.getOptions();
    }

    private int getCallCount(int[][] iArr, long[][] jArr, int i5) {
        int iNumBackwardsCallables = 0;
        for (int[] iArr2 : iArr) {
            int i6 = 0;
            while (true) {
                if (i6 < iArr2.length) {
                    iNumBackwardsCallables += this.attrMap.getAttributeLayout(iArr2[i6], i5).numBackwardsCallables();
                    i6++;
                }
            }
        }
        int i7 = 0;
        for (long[] jArr2 : jArr) {
            int i8 = 0;
            while (true) {
                if (i8 < jArr2.length) {
                    i7 = (int) (((long) i7) | jArr2[i8]);
                    i8++;
                }
            }
        }
        for (int i9 = 0; i9 < 26; i9++) {
            if (((1 << i9) & i7) != 0) {
                iNumBackwardsCallables = this.attrMap.getAttributeLayout(i9, i5).numBackwardsCallables() + iNumBackwardsCallables;
            }
        }
        return iNumBackwardsCallables;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x01b1  */
    private void parseClassAttrBands(InputStream inputStream) throws IOException {
        int i5;
        AttributeLayout attributeLayout;
        int i6;
        int i7;
        int i8;
        AttributeLayout attributeLayout2;
        int i9;
        int i10;
        AttributeLayout attributeLayout3;
        int i11;
        String c6;
        String n6;
        int i12;
        int i13;
        int i14;
        String[] cpUTF8 = this.cpBands.getCpUTF8();
        String[] cpClass = this.cpBands.getCpClass();
        this.classAttributes = new ArrayList[this.classCount];
        int i15 = 0;
        while (true) {
            i5 = this.classCount;
            if (i15 >= i5) {
                break;
            }
            this.classAttributes[i15] = new ArrayList();
            i15++;
        }
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        InputStream inputStream2 = inputStream;
        long[] flags = parseFlags("class_flags", inputStream2, i5, bHSDCodec, this.options.hasClassFlagsHi());
        this.classFlags = flags;
        int[] iArrDecodeBandInt = decodeBandInt("class_attr_calls", inputStream2, bHSDCodec, getCallCount(decodeBandInt("class_attr_indexes", inputStream2, bHSDCodec, decodeBandInt("class_attr_count", inputStream2, bHSDCodec, SegmentUtils.countBit16(flags))), new long[][]{this.classFlags}, 0));
        AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_DEPRECATED, 0);
        AttributeLayout attributeLayout5 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SOURCE_FILE, 0);
        int[] iArrDecodeBandInt2 = decodeBandInt("class_SourceFile_RUN", inputStream2, bHSDCodec, SegmentUtils.countMatches(this.classFlags, attributeLayout5));
        AttributeLayout attributeLayout6 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_ENCLOSING_METHOD, 0);
        int iCountMatches = SegmentUtils.countMatches(this.classFlags, attributeLayout6);
        int[] iArrDecodeBandInt3 = decodeBandInt("class_EnclosingMethod_RC", inputStream2, bHSDCodec, iCountMatches);
        int[] iArrDecodeBandInt4 = decodeBandInt("class_EnclosingMethod_RDN", inputStream2, bHSDCodec, iCountMatches);
        AttributeLayout attributeLayout7 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SIGNATURE, 0);
        int[] iArrDecodeBandInt5 = decodeBandInt("class_Signature_RS", inputStream2, bHSDCodec, SegmentUtils.countMatches(this.classFlags, attributeLayout7));
        int classMetadataBands = parseClassMetadataBands(inputStream2, iArrDecodeBandInt);
        AttributeLayout attributeLayout8 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_INNER_CLASSES, 0);
        int[] iArrDecodeBandInt6 = decodeBandInt("class_InnerClasses_N", inputStream2, bHSDCodec, SegmentUtils.countMatches(this.classFlags, attributeLayout8));
        int[][] iArrDecodeBandInt7 = decodeBandInt("class_InnerClasses_RC", inputStream2, bHSDCodec, iArrDecodeBandInt6);
        int[][] iArrDecodeBandInt8 = decodeBandInt("class_InnerClasses_F", inputStream2, bHSDCodec, iArrDecodeBandInt6);
        int i16 = 0;
        int i17 = 0;
        while (i17 < iArrDecodeBandInt8.length) {
            int[][] iArr = iArrDecodeBandInt8;
            int i18 = 0;
            while (true) {
                int[] iArr2 = iArr[i17];
                i14 = i16;
                if (i18 < iArr2.length) {
                    i16 = iArr2[i18] != 0 ? i14 + 1 : i14;
                    i18++;
                }
            }
            i17++;
            iArrDecodeBandInt8 = iArr;
            i16 = i14;
        }
        int[][] iArr3 = iArrDecodeBandInt8;
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] iArrDecodeBandInt9 = decodeBandInt("class_InnerClasses_outer_RCN", inputStream2, bHSDCodec2, i16);
        int[] iArrDecodeBandInt10 = decodeBandInt("class_InnerClasses_name_RUN", inputStream2, bHSDCodec2, i16);
        AttributeLayout attributeLayout9 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_CLASS_FILE_VERSION, 0);
        int iCountMatches2 = SegmentUtils.countMatches(this.classFlags, attributeLayout9);
        int[] iArrDecodeBandInt11 = decodeBandInt("class_file_version_minor_H", inputStream2, bHSDCodec2, iCountMatches2);
        int[] iArrDecodeBandInt12 = decodeBandInt("class_file_version_major_H", inputStream2, bHSDCodec2, iCountMatches2);
        if (iCountMatches2 > 0) {
            int i19 = this.classCount;
            this.classVersionMajor = new int[i19];
            this.classVersionMinor = new int[i19];
        }
        int defaultClassMajorVersion = this.header.getDefaultClassMajorVersion();
        int defaultClassMinorVersion = this.header.getDefaultClassMinorVersion();
        int i20 = this.options.hasClassFlagsHi() ? 62 : 31;
        int i21 = i20 + 1;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i21];
        int[] iArr4 = new int[i21];
        List[] listArr = new List[i21];
        int i22 = 0;
        while (i22 < i20) {
            int i23 = i20;
            int[] iArr5 = iArrDecodeBandInt4;
            AttributeLayout attributeLayout10 = this.attrMap.getAttributeLayout(i22, 0);
            if (attributeLayout10 != null && !attributeLayout10.isDefaultLayout()) {
                attributeLayoutArr[i22] = attributeLayout10;
                iArr4[i22] = SegmentUtils.countMatches(this.classFlags, attributeLayout10);
            }
            i22++;
            i20 = i23;
            iArrDecodeBandInt4 = iArr5;
        }
        int[] iArr6 = iArrDecodeBandInt4;
        int i24 = 0;
        while (i24 < i21) {
            if (iArr4[i24] > 0) {
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i24]);
                listArr[i24] = attributeBands.parseAttributes(inputStream2, iArr4[i24]);
                int iNumBackwardsCallables = attributeLayoutArr[i24].numBackwardsCallables();
                if (iNumBackwardsCallables > 0) {
                    int[] iArr7 = new int[iNumBackwardsCallables];
                    System.arraycopy(iArrDecodeBandInt, classMetadataBands, iArr7, 0, iNumBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr7);
                    classMetadataBands += iNumBackwardsCallables;
                }
            }
            i24++;
            inputStream2 = inputStream;
        }
        this.icLocal = new IcTuple[this.classCount][];
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        while (i26 < this.classCount) {
            int i32 = i26;
            long j6 = this.classFlags[i32];
            if (attributeLayout4.matches(j6)) {
                this.classAttributes[i32].add(new DeprecatedAttribute());
            }
            if (attributeLayout5.matches(j6)) {
                attributeLayout = attributeLayout5;
                ClassFileEntry value = attributeLayout.getValue(iArrDecodeBandInt2[i25], this.cpBands.getConstantPool());
                if (value == null) {
                    String str = this.classThis[i32];
                    String strSubstring = str.substring(str.lastIndexOf(47) + 1);
                    String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(46) + 1);
                    char[] charArray = strSubstring2.toCharArray();
                    int i33 = 0;
                    while (true) {
                        if (i33 >= charArray.length) {
                            i33 = -1;
                            break;
                        }
                        char[] cArr = charArray;
                        if (charArray[i33] <= '-') {
                            break;
                        }
                        i33++;
                        charArray = cArr;
                    }
                    if (i33 > -1) {
                        strSubstring2 = strSubstring2.substring(0, i33);
                    }
                    value = this.cpBands.cpUTF8Value(strSubstring2 + ".java", true);
                }
                this.classAttributes[i32].add(new SourceFileAttribute((CPUTF8) value));
                i6 = i25 + 1;
            } else {
                attributeLayout = attributeLayout5;
                i6 = i25;
            }
            if (attributeLayout6.matches(j6)) {
                CPClass cPClassCpClassValue = this.cpBands.cpClassValue(iArrDecodeBandInt3[i27]);
                int i34 = iArr6[i27];
                this.classAttributes[i32].add(new EnclosingMethodAttribute(cPClassCpClassValue, i34 != 0 ? this.cpBands.cpNameAndTypeValue(i34 - 1) : null));
                i7 = i27 + 1;
            } else {
                i7 = i27;
            }
            if (attributeLayout7.matches(j6)) {
                this.classAttributes[i32].add(new SignatureAttribute((CPUTF8) attributeLayout7.getValue(iArrDecodeBandInt5[i28], this.cpBands.getConstantPool())));
                i28++;
            } else {
                i28 = i28;
            }
            if (attributeLayout8.matches(j6)) {
                this.icLocal[i32] = new IcTuple[iArrDecodeBandInt6[i29]];
                int i35 = 0;
                while (i35 < this.icLocal[i32].length) {
                    int i36 = iArrDecodeBandInt7[i29][i35];
                    String str2 = cpClass[i36];
                    int f6 = iArr3[i29][i35];
                    if (f6 != 0) {
                        int i37 = iArrDecodeBandInt9[i31];
                        int i38 = iArrDecodeBandInt10[i31];
                        i31++;
                        i9 = i35;
                        attributeLayout3 = attributeLayout8;
                        i12 = i37;
                        i13 = i38;
                        c6 = cpClass[i37];
                        n6 = cpUTF8[i38];
                        i10 = i7;
                    } else {
                        i9 = i35;
                        IcTuple[] icTuples = this.segment.getIcBands().getIcTuples();
                        i10 = i7;
                        attributeLayout3 = attributeLayout8;
                        int i39 = 0;
                        while (true) {
                            if (i39 >= icTuples.length) {
                                i11 = f6;
                                c6 = null;
                                n6 = null;
                                i12 = -1;
                                i13 = -1;
                                break;
                            }
                            if (icTuples[i39].getC().equals(str2)) {
                                f6 = icTuples[i39].getF();
                                c6 = icTuples[i39].getC2();
                                n6 = icTuples[i39].getN();
                                i12 = -1;
                                i13 = -1;
                            } else {
                                i39++;
                            }
                        }
                        this.icLocal[i32][i9] = new IcTuple(str2, i11, c6, n6, i36, i12, i13, i9);
                        i35 = i9 + 1;
                        i7 = i10;
                        attributeLayout8 = attributeLayout3;
                    }
                    i11 = f6;
                    this.icLocal[i32][i9] = new IcTuple(str2, i11, c6, n6, i36, i12, i13, i9);
                    i35 = i9 + 1;
                    i7 = i10;
                    attributeLayout8 = attributeLayout3;
                }
                i8 = i7;
                attributeLayout2 = attributeLayout8;
                i29++;
            } else {
                i8 = i7;
                attributeLayout2 = attributeLayout8;
            }
            if (attributeLayout9.matches(j6)) {
                this.classVersionMajor[i32] = iArrDecodeBandInt12[i30];
                this.classVersionMinor[i32] = iArrDecodeBandInt11[i30];
                i30++;
            } else {
                int[] iArr8 = this.classVersionMajor;
                if (iArr8 != null) {
                    iArr8[i32] = defaultClassMajorVersion;
                    this.classVersionMinor[i32] = defaultClassMinorVersion;
                }
            }
            for (int i40 = 0; i40 < i21; i40++) {
                AttributeLayout attributeLayout11 = attributeLayoutArr[i40];
                if (attributeLayout11 != null && attributeLayout11.matches(j6)) {
                    this.classAttributes[i32].add(listArr[i40].get(0));
                    listArr[i40].remove(0);
                }
            }
            i26 = i32 + 1;
            attributeLayout4 = attributeLayout4;
            i25 = i6;
            i27 = i8;
            attributeLayout5 = attributeLayout;
            attributeLayout8 = attributeLayout2;
        }
    }

    private int parseClassMetadataBands(InputStream inputStream, int[] iArr) {
        int i5;
        String[] strArr = {"RVA", "RIA"};
        int i6 = 0;
        AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS, 0);
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS, 0);
        int iCountMatches = SegmentUtils.countMatches(this.classFlags, attributeLayout);
        int iCountMatches2 = SegmentUtils.countMatches(this.classFlags, attributeLayout2);
        int[] iArr2 = {iCountMatches, iCountMatches2};
        int[] iArr3 = {0, 0};
        if (iCountMatches > 0) {
            iArr3[0] = iArr[0];
            if (iCountMatches2 > 0) {
                iArr3[1] = iArr[1];
                i5 = 2;
            } else {
                i5 = 1;
            }
        } else if (iCountMatches2 > 0) {
            iArr3[1] = iArr[0];
            i5 = 1;
        } else {
            i5 = 0;
        }
        MetadataBandGroup[] metadata = parseMetadata(inputStream, strArr, iArr2, iArr3, Constants.CLASS);
        List attributes = metadata[0].getAttributes();
        List attributes2 = metadata[1].getAttributes();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            long[] jArr = this.classFlags;
            if (i6 >= jArr.length) {
                return i5;
            }
            if (attributeLayout.matches(jArr[i6])) {
                this.classAttributes[i6].add(attributes.get(i7));
                i7++;
            }
            if (attributeLayout2.matches(this.classFlags[i6])) {
                this.classAttributes[i6].add(attributes2.get(i8));
                i8++;
            }
            i6++;
        }
    }

    private void parseCodeAttrBands(InputStream inputStream, int i5) throws IOException {
        int i6;
        long[] jArr;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        InputStream inputStream2 = inputStream;
        long[] flags = parseFlags("code_flags", inputStream2, i5, bHSDCodec, this.segment.getSegmentHeader().getOptions().hasCodeFlagsHi());
        int iNumBackwardsCallables = 0;
        for (int[] iArr : decodeBandInt("code_attr_indexes", inputStream2, bHSDCodec, decodeBandInt("code_attr_count", inputStream2, bHSDCodec, SegmentUtils.countBit16(flags)))) {
            int i7 = 0;
            while (true) {
                if (i7 < iArr.length) {
                    iNumBackwardsCallables += this.attrMap.getAttributeLayout(iArr[i7], 3).numBackwardsCallables();
                    i7++;
                }
            }
        }
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] iArrDecodeBandInt = decodeBandInt("code_attr_calls", inputStream2, bHSDCodec2, iNumBackwardsCallables);
        AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_LINE_NUMBER_TABLE, 3);
        int[] iArrDecodeBandInt2 = decodeBandInt("code_LineNumberTable_N", inputStream2, bHSDCodec2, SegmentUtils.countMatches(flags, attributeLayout));
        BHSDCodec bHSDCodec3 = Codec.BCI5;
        int[][] iArrDecodeBandInt3 = decodeBandInt("code_LineNumberTable_bci_P", inputStream2, bHSDCodec3, iArrDecodeBandInt2);
        int[][] iArrDecodeBandInt4 = decodeBandInt("code_LineNumberTable_line", inputStream2, bHSDCodec2, iArrDecodeBandInt2);
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TABLE, 3);
        AttributeLayout attributeLayout3 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TYPE_TABLE, 3);
        int[] iArrDecodeBandInt5 = decodeBandInt("code_LocalVariableTable_N", inputStream2, bHSDCodec2, SegmentUtils.countMatches(flags, attributeLayout2));
        int[][] iArrDecodeBandInt6 = decodeBandInt("code_LocalVariableTable_bci_P", inputStream2, bHSDCodec3, iArrDecodeBandInt5);
        BHSDCodec bHSDCodec4 = Codec.BRANCH5;
        int[][] iArrDecodeBandInt7 = decodeBandInt("code_LocalVariableTable_span_O", inputStream2, bHSDCodec4, iArrDecodeBandInt5);
        CPUTF8[][] cPUTF8References = parseCPUTF8References("code_LocalVariableTable_name_RU", inputStream2, bHSDCodec2, iArrDecodeBandInt5);
        CPUTF8[][] cPSignatureReferences = parseCPSignatureReferences("code_LocalVariableTable_type_RS", inputStream2, bHSDCodec2, iArrDecodeBandInt5);
        int[][] iArrDecodeBandInt8 = decodeBandInt("code_LocalVariableTable_slot", inputStream2, bHSDCodec2, iArrDecodeBandInt5);
        int[] iArrDecodeBandInt9 = decodeBandInt("code_LocalVariableTypeTable_N", inputStream2, bHSDCodec2, SegmentUtils.countMatches(flags, attributeLayout3));
        int[][] iArrDecodeBandInt10 = decodeBandInt("code_LocalVariableTypeTable_bci_P", inputStream2, bHSDCodec3, iArrDecodeBandInt9);
        int[][] iArrDecodeBandInt11 = decodeBandInt("code_LocalVariableTypeTable_span_O", inputStream2, bHSDCodec4, iArrDecodeBandInt9);
        CPUTF8[][] cPUTF8References2 = parseCPUTF8References("code_LocalVariableTypeTable_name_RU", inputStream2, bHSDCodec2, iArrDecodeBandInt9);
        CPUTF8[][] cPSignatureReferences2 = parseCPSignatureReferences("code_LocalVariableTypeTable_type_RS", inputStream2, bHSDCodec2, iArrDecodeBandInt9);
        int[][] iArrDecodeBandInt12 = decodeBandInt("code_LocalVariableTypeTable_slot", inputStream2, bHSDCodec2, iArrDecodeBandInt9);
        int i8 = this.options.hasCodeFlagsHi() ? 62 : 31;
        int i9 = i8 + 1;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i9];
        int[] iArr2 = new int[i9];
        List[] listArr = new List[i9];
        int i10 = 0;
        while (i10 < i8) {
            int i11 = i8;
            int[][] iArr3 = iArrDecodeBandInt10;
            AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(i10, 3);
            if (attributeLayout4 != null && !attributeLayout4.isDefaultLayout()) {
                attributeLayoutArr[i10] = attributeLayout4;
                iArr2[i10] = SegmentUtils.countMatches(flags, attributeLayout4);
            }
            i10++;
            i8 = i11;
            iArrDecodeBandInt10 = iArr3;
        }
        int[][] iArr4 = iArrDecodeBandInt10;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i9) {
            if (iArr2[i12] > 0) {
                jArr = flags;
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i12]);
                listArr[i12] = attributeBands.parseAttributes(inputStream2, iArr2[i12]);
                int iNumBackwardsCallables2 = attributeLayoutArr[i12].numBackwardsCallables();
                if (iNumBackwardsCallables2 > 0) {
                    int[] iArr5 = new int[iNumBackwardsCallables2];
                    System.arraycopy(iArrDecodeBandInt, i13, iArr5, 0, iNumBackwardsCallables2);
                    attributeBands.setBackwardsCalls(iArr5);
                    i13 += iNumBackwardsCallables2;
                }
                i12++;
                inputStream2 = inputStream;
                flags = jArr;
            } else {
                jArr = flags;
            }
            i12++;
            inputStream2 = inputStream;
            flags = jArr;
        }
        long[] jArr2 = flags;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < i5; i17 = i6 + 1) {
            int i18 = i14;
            int i19 = i15;
            if (attributeLayout.matches(jArr2[i17])) {
                i6 = i17;
                this.codeAttributes[i6].add(new LineNumberTableAttribute(iArrDecodeBandInt2[i18], iArrDecodeBandInt3[i18], iArrDecodeBandInt4[i18]));
                i14 = i18 + 1;
            } else {
                i6 = i17;
                i14 = i18;
            }
            if (attributeLayout2.matches(jArr2[i6])) {
                this.codeAttributes[i6].add(new LocalVariableTableAttribute(iArrDecodeBandInt5[i19], iArrDecodeBandInt6[i19], iArrDecodeBandInt7[i19], cPUTF8References[i19], cPSignatureReferences[i19], iArrDecodeBandInt8[i19]));
                i15 = i19 + 1;
            } else {
                i15 = i19;
            }
            if (attributeLayout3.matches(jArr2[i6])) {
                LocalVariableTypeTableAttribute localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(iArrDecodeBandInt9[i16], iArr4[i16], iArrDecodeBandInt11[i16], cPUTF8References2[i16], cPSignatureReferences2[i16], iArrDecodeBandInt12[i16]);
                i16++;
                this.codeAttributes[i6].add(localVariableTypeTableAttribute);
            } else {
                i16 = i16;
            }
            int i20 = 0;
            while (i20 < i9) {
                AttributeLayout attributeLayout5 = attributeLayoutArr[i20];
                int i21 = i14;
                int i22 = i15;
                if (attributeLayout5 != null && attributeLayout5.matches(jArr2[i6])) {
                    this.codeAttributes[i6].add(listArr[i20].get(0));
                    listArr[i20].remove(0);
                }
                i20++;
                i14 = i21;
                i15 = i22;
            }
        }
    }

    private void parseCodeBands(InputStream inputStream) throws IOException {
        int i5;
        int i6 = 2;
        int iCountMatches = SegmentUtils.countMatches(this.methodFlags, this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_CODE, 2));
        int[] iArrDecodeBandInt = decodeBandInt("code_headers", inputStream, Codec.BYTE1, iCountMatches);
        boolean zHasAllCodeFlags = this.segment.getSegmentHeader().getOptions().hasAllCodeFlags();
        if (!zHasAllCodeFlags) {
            this.codeHasAttributes = new boolean[iCountMatches];
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iCountMatches; i9++) {
            if (iArrDecodeBandInt[i9] == 0) {
                i8++;
                if (!zHasAllCodeFlags) {
                    this.codeHasAttributes[i9] = true;
                }
            }
        }
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        int[] iArrDecodeBandInt2 = decodeBandInt("code_max_stack", inputStream, bHSDCodec, i8);
        int[] iArrDecodeBandInt3 = decodeBandInt("code_max_na_locals", inputStream, bHSDCodec, i8);
        int[] iArrDecodeBandInt4 = decodeBandInt("code_handler_count", inputStream, bHSDCodec, i8);
        this.codeMaxStack = new int[iCountMatches];
        this.codeMaxNALocals = new int[iCountMatches];
        this.codeHandlerCount = new int[iCountMatches];
        int i10 = 0;
        int i11 = 0;
        while (i10 < iCountMatches) {
            int i12 = iArrDecodeBandInt[i10] & 255;
            if (i12 < 0) {
                throw new IllegalStateException("Shouldn't get here");
            }
            if (i12 == 0) {
                this.codeMaxStack[i10] = iArrDecodeBandInt2[i11];
                this.codeMaxNALocals[i10] = iArrDecodeBandInt3[i11];
                this.codeHandlerCount[i10] = iArrDecodeBandInt4[i11];
                i11++;
                i5 = i6;
            } else {
                i5 = i6;
                if (i12 <= 144) {
                    int i13 = i12 - 1;
                    this.codeMaxStack[i10] = i13 % 12;
                    this.codeMaxNALocals[i10] = i13 / 12;
                    this.codeHandlerCount[i10] = 0;
                } else if (i12 <= 208) {
                    int i14 = i12 - 145;
                    this.codeMaxStack[i10] = i14 % 8;
                    this.codeMaxNALocals[i10] = i14 / 8;
                    this.codeHandlerCount[i10] = 1;
                } else {
                    if (i12 > 255) {
                        throw new IllegalStateException("Shouldn't get here either");
                    }
                    int[] iArr = this.codeMaxStack;
                    int i15 = i12 + Core.StsUnmatchedSizes;
                    iArr[i10] = i15 % 7;
                    this.codeMaxNALocals[i10] = i15 / 7;
                    this.codeHandlerCount[i10] = i5;
                }
            }
            i10++;
            i6 = i5;
        }
        this.codeHandlerStartP = decodeBandInt("code_handler_start_P", inputStream, Codec.BCI5, this.codeHandlerCount);
        BHSDCodec bHSDCodec2 = Codec.BRANCH5;
        this.codeHandlerEndPO = decodeBandInt("code_handler_end_PO", inputStream, bHSDCodec2, this.codeHandlerCount);
        this.codeHandlerCatchPO = decodeBandInt("code_handler_catch_PO", inputStream, bHSDCodec2, this.codeHandlerCount);
        this.codeHandlerClassRCN = decodeBandInt("code_handler_class_RCN", inputStream, Codec.UNSIGNED5, this.codeHandlerCount);
        if (!zHasAllCodeFlags) {
            iCountMatches = i8;
        }
        this.codeAttributes = new List[iCountMatches];
        while (true) {
            List[] listArr = this.codeAttributes;
            if (i7 >= listArr.length) {
                parseCodeAttrBands(inputStream, iCountMatches);
                return;
            } else {
                listArr[i7] = new ArrayList();
                i7++;
            }
        }
    }

    private void parseFieldAttrBands(InputStream inputStream) throws IOException {
        int i5;
        AttributeLayout attributeLayout;
        int[] iArr = this.classFieldCount;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        long[][] flags = parseFlags("field_flags", inputStream, iArr, bHSDCodec, this.options.hasFieldFlagsHi());
        this.fieldFlags = flags;
        int i6 = 1;
        int[] iArrDecodeBandInt = decodeBandInt("field_attr_calls", inputStream, bHSDCodec, getCallCount(decodeBandInt("field_attr_indexes", inputStream, bHSDCodec, decodeBandInt("field_attr_count", inputStream, bHSDCodec, SegmentUtils.countBit16(flags))), this.fieldFlags, 1));
        this.fieldAttributes = new ArrayList[this.classCount][];
        for (int i7 = 0; i7 < this.classCount; i7++) {
            this.fieldAttributes[i7] = new ArrayList[this.fieldFlags[i7].length];
            for (int i8 = 0; i8 < this.fieldFlags[i7].length; i8++) {
                this.fieldAttributes[i7][i8] = new ArrayList();
            }
        }
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_CONSTANT_VALUE, 1);
        int iCountMatches = SegmentUtils.countMatches(this.fieldFlags, attributeLayout2);
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] iArrDecodeBandInt2 = decodeBandInt("field_ConstantValue_KQ", inputStream, bHSDCodec2, iCountMatches);
        AttributeLayout attributeLayout3 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SIGNATURE, 1);
        int[] iArrDecodeBandInt3 = decodeBandInt("field_Signature_RS", inputStream, bHSDCodec2, SegmentUtils.countMatches(this.fieldFlags, attributeLayout3));
        AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_DEPRECATED, 1);
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < this.classCount) {
            int i12 = 0;
            while (true) {
                long[] jArr = this.fieldFlags[i9];
                if (i12 < jArr.length) {
                    int i13 = i6;
                    int[] iArr2 = iArrDecodeBandInt2;
                    long j6 = jArr[i12];
                    if (attributeLayout4.matches(j6)) {
                        this.fieldAttributes[i9][i12].add(new DeprecatedAttribute());
                    }
                    if (attributeLayout2.matches(j6)) {
                        AttributeLayout attributeLayout5 = attributeLayout2;
                        long j7 = iArr2[i10];
                        String str = this.fieldDescr[i9][i12];
                        String strSubstring = str.substring(str.indexOf(58) + 1);
                        if (strSubstring.equals("B") || strSubstring.equals(ExifInterface.LATITUDE_SOUTH) || strSubstring.equals("C") || strSubstring.equals("Z")) {
                            strSubstring = "I";
                        }
                        attributeLayout = attributeLayout5;
                        this.fieldAttributes[i9][i12].add(new ConstantValueAttribute(attributeLayout.getValue(j7, strSubstring, this.cpBands.getConstantPool())));
                        i10++;
                    } else {
                        attributeLayout = attributeLayout2;
                    }
                    if (attributeLayout3.matches(j6)) {
                        long j8 = iArrDecodeBandInt3[i11];
                        String str2 = this.fieldDescr[i9][i12];
                        this.fieldAttributes[i9][i12].add(new SignatureAttribute((CPUTF8) attributeLayout3.getValue(j8, str2.substring(str2.indexOf(58) + 1), this.cpBands.getConstantPool())));
                        i11++;
                    }
                    i12++;
                    attributeLayout2 = attributeLayout;
                    iArrDecodeBandInt2 = iArr2;
                    i6 = i13;
                    iArrDecodeBandInt3 = iArrDecodeBandInt3;
                }
            }
            i9++;
            iArrDecodeBandInt3 = iArrDecodeBandInt3;
        }
        int i14 = i6;
        int fieldMetadataBands = parseFieldMetadataBands(inputStream, iArrDecodeBandInt);
        int i15 = this.options.hasFieldFlagsHi() ? 62 : 31;
        int i16 = i15 + 1;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i16];
        int[] iArr3 = new int[i16];
        List[] listArr = new List[i16];
        int i17 = 0;
        while (i17 < i15) {
            int i18 = i14;
            AttributeLayout attributeLayout6 = this.attrMap.getAttributeLayout(i17, i18);
            if (attributeLayout6 != null && !attributeLayout6.isDefaultLayout()) {
                attributeLayoutArr[i17] = attributeLayout6;
                iArr3[i17] = SegmentUtils.countMatches(this.fieldFlags, attributeLayout6);
            }
            i17++;
            i14 = i18;
        }
        for (int i19 = 0; i19 < i16; i19++) {
            if (iArr3[i19] > 0) {
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i19]);
                listArr[i19] = attributeBands.parseAttributes(inputStream, iArr3[i19]);
                int iNumBackwardsCallables = attributeLayoutArr[i19].numBackwardsCallables();
                if (iNumBackwardsCallables > 0) {
                    int[] iArr4 = new int[iNumBackwardsCallables];
                    System.arraycopy(iArrDecodeBandInt, fieldMetadataBands, iArr4, 0, iNumBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr4);
                    fieldMetadataBands += iNumBackwardsCallables;
                }
            }
        }
        for (int i20 = 0; i20 < this.classCount; i20++) {
            int i21 = 0;
            while (true) {
                long[] jArr2 = this.fieldFlags[i20];
                if (i21 < jArr2.length) {
                    long j9 = jArr2[i21];
                    int i22 = 0;
                    for (int i23 = 0; i23 < i16; i23++) {
                        AttributeLayout attributeLayout7 = attributeLayoutArr[i23];
                        if (attributeLayout7 != null && attributeLayout7.matches(j9)) {
                            if (attributeLayoutArr[i23].getIndex() < 15) {
                                i5 = 0;
                                this.fieldAttributes[i20][i21].add(i22, listArr[i23].get(0));
                                i22++;
                            } else {
                                i5 = 0;
                                this.fieldAttributes[i20][i21].add(listArr[i23].get(0));
                            }
                            listArr[i23].remove(i5);
                        }
                    }
                    i21++;
                }
            }
        }
    }

    private void parseFieldBands(InputStream inputStream) throws IOException {
        int[][] iArrDecodeBandInt = decodeBandInt("field_descr", inputStream, Codec.DELTA5, this.classFieldCount);
        this.fieldDescrInts = iArrDecodeBandInt;
        this.fieldDescr = getReferences(iArrDecodeBandInt, this.cpBands.getCpDescriptor());
        parseFieldAttrBands(inputStream);
    }

    private int parseFieldMetadataBands(InputStream inputStream, int[] iArr) {
        int i5;
        String[] strArr = {"RVA", "RIA"};
        AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS, 1);
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS, 1);
        int iCountMatches = SegmentUtils.countMatches(this.fieldFlags, attributeLayout);
        int iCountMatches2 = SegmentUtils.countMatches(this.fieldFlags, attributeLayout2);
        int[] iArr2 = {iCountMatches, iCountMatches2};
        int[] iArr3 = {0, 0};
        if (iCountMatches > 0) {
            iArr3[0] = iArr[0];
            if (iCountMatches2 > 0) {
                iArr3[1] = iArr[1];
                i5 = 2;
            } else {
                i5 = 1;
            }
        } else if (iCountMatches2 > 0) {
            iArr3[1] = iArr[0];
            i5 = 1;
        } else {
            i5 = 0;
        }
        MetadataBandGroup[] metadata = parseMetadata(inputStream, strArr, iArr2, iArr3, "field");
        List attributes = metadata[0].getAttributes();
        List attributes2 = metadata[1].getAttributes();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < this.fieldFlags.length; i8++) {
            int i9 = 0;
            while (true) {
                long[] jArr = this.fieldFlags[i8];
                if (i9 < jArr.length) {
                    if (attributeLayout.matches(jArr[i9])) {
                        this.fieldAttributes[i8][i9].add(attributes.get(i6));
                        i6++;
                    }
                    if (attributeLayout2.matches(this.fieldFlags[i8][i9])) {
                        this.fieldAttributes[i8][i9].add(attributes2.get(i7));
                        i7++;
                    }
                    i9++;
                }
            }
        }
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0114  */
    private MetadataBandGroup[] parseMetadata(InputStream inputStream, String[] strArr, int[] iArr, int[] iArr2, String str) {
        int i5;
        MetadataBandGroup metadataBandGroup;
        InputStream inputStream2 = inputStream;
        String[] strArr2 = strArr;
        MetadataBandGroup[] metadataBandGroupArr = new MetadataBandGroup[strArr2.length];
        int i6 = 0;
        while (i6 < strArr2.length) {
            metadataBandGroupArr[i6] = new MetadataBandGroup(strArr2[i6], this.cpBands);
            String str2 = strArr2[i6];
            if (str2.indexOf(80) >= 0) {
                metadataBandGroupArr[i6].param_NB = decodeBandInt(a.A(str, "_", str2, "_param_NB"), inputStream2, Codec.BYTE1, iArr[i6]);
            }
            if (str2.equals("AD")) {
                i5 = iArr[i6];
            } else {
                MetadataBandGroup metadataBandGroup2 = metadataBandGroupArr[i6];
                String strA = a.A(str, "_", str2, "_anno_N");
                BHSDCodec bHSDCodec = Codec.UNSIGNED5;
                metadataBandGroup2.anno_N = decodeBandInt(strA, inputStream2, bHSDCodec, iArr[i6]);
                metadataBandGroupArr[i6].type_RS = parseCPSignatureReferences(a.A(str, "_", str2, "_type_RS"), inputStream2, bHSDCodec, metadataBandGroupArr[i6].anno_N);
                metadataBandGroupArr[i6].pair_N = decodeBandInt(a.A(str, "_", str2, "_pair_N"), inputStream2, bHSDCodec, metadataBandGroupArr[i6].anno_N);
                int i7 = 0;
                i5 = 0;
                while (true) {
                    MetadataBandGroup metadataBandGroup3 = metadataBandGroupArr[i6];
                    if (i7 < metadataBandGroup3.pair_N.length) {
                        int i8 = 0;
                        while (true) {
                            int[] iArr3 = metadataBandGroupArr[i6].pair_N[i7];
                            if (i8 < iArr3.length) {
                                i5 += iArr3[i8];
                                i8++;
                            }
                        }
                        i7++;
                    } else {
                        metadataBandGroup3.name_RU = parseCPUTF8References(a.A(str, "_", str2, "_name_RU"), inputStream2, Codec.UNSIGNED5, i5);
                    }
                }
            }
            metadataBandGroupArr[i6].f6724T = decodeBandInt(a.A(str, "_", str2, "_T"), inputStream2, Codec.BYTE1, i5 + iArr2[i6]);
            MetadataBandGroup[] metadataBandGroupArr2 = metadataBandGroupArr;
            int i9 = i6;
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
            while (true) {
                MetadataBandGroup metadataBandGroup4 = metadataBandGroupArr2[i9];
                int i20 = i19;
                int[] iArr4 = metadataBandGroup4.f6724T;
                int i21 = i15;
                if (i10 < iArr4.length) {
                    char c = (char) iArr4[i10];
                    if (c != '@') {
                        if (c != 'F') {
                            if (c == 'S') {
                                i11++;
                            } else if (c == 'c') {
                                i18++;
                            } else if (c == 'e') {
                                i19 = i20 + 1;
                            } else if (c == 's') {
                                i16++;
                            } else if (c == 'I') {
                                i11++;
                            } else if (c == 'J') {
                                i17++;
                            } else if (c == 'Z') {
                                i11++;
                            } else if (c != '[') {
                                switch (c) {
                                    case 'B':
                                    case 'C':
                                        i11++;
                                        break;
                                    case 'D':
                                        i12++;
                                        break;
                                }
                            } else {
                                i14++;
                            }
                            i15 = i21;
                        } else {
                            i13++;
                        }
                        i19 = i20;
                        i15 = i21;
                    } else {
                        i15 = i21 + 1;
                        i19 = i20;
                    }
                    i10++;
                } else {
                    String strA2 = a.A(str, "_", str2, "_caseI_KI");
                    BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
                    metadataBandGroup4.caseI_KI = parseCPIntReferences(strA2, inputStream2, bHSDCodec2, i11);
                    metadataBandGroupArr2[i9].caseD_KD = parseCPDoubleReferences(a.A(str, "_", str2, "_caseD_KD"), inputStream2, bHSDCodec2, i12);
                    metadataBandGroupArr2[i9].caseF_KF = parseCPFloatReferences(a.A(str, "_", str2, "_caseF_KF"), inputStream2, bHSDCodec2, i13);
                    metadataBandGroupArr2[i9].caseJ_KJ = parseCPLongReferences(a.A(str, "_", str2, "_caseJ_KJ"), inputStream2, bHSDCodec2, i17);
                    metadataBandGroupArr2[i9].casec_RS = parseCPSignatureReferences(a.A(str, "_", str2, "_casec_RS"), inputStream2, bHSDCodec2, i18);
                    metadataBandGroupArr2[i9].caseet_RS = parseReferences(a.A(str, "_", str2, "_caseet_RS"), inputStream2, bHSDCodec2, i20, this.cpBands.getCpSignature());
                    inputStream2 = inputStream;
                    metadataBandGroupArr2[i9].caseec_RU = parseReferences(a.A(str, "_", str2, "_caseec_RU"), inputStream2, bHSDCodec2, i20, this.cpBands.getCpUTF8());
                    metadataBandGroupArr2[i9].cases_RU = parseCPUTF8References(a.A(str, "_", str2, "_cases_RU"), inputStream2, bHSDCodec2, i16);
                    metadataBandGroupArr2[i9].casearray_N = decodeBandInt(a.A(str, "_", str2, "_casearray_N"), inputStream2, bHSDCodec2, i14);
                    metadataBandGroupArr2[i9].nesttype_RS = parseCPUTF8References(a.A(str, "_", str2, "_nesttype_RS"), inputStream2, bHSDCodec2, i21);
                    metadataBandGroupArr2[i9].nestpair_N = decodeBandInt(a.A(str, "_", str2, "_nestpair_N"), inputStream2, bHSDCodec2, i21);
                    int i22 = 0;
                    int i23 = 0;
                    while (true) {
                        metadataBandGroup = metadataBandGroupArr2[i9];
                        int[] iArr5 = metadataBandGroup.nestpair_N;
                        if (i22 < iArr5.length) {
                            i23 += iArr5[i22];
                            i22++;
                        }
                    }
                    metadataBandGroup.nestname_RU = parseCPUTF8References(a.A(str, "_", str2, "_nestname_RU"), inputStream2, Codec.UNSIGNED5, i23);
                    i6 = i9 + 1;
                    strArr2 = strArr;
                    metadataBandGroupArr = metadataBandGroupArr2;
                }
            }
        }
        return metadataBandGroupArr;
    }

    private void parseMethodAttrBands(InputStream inputStream) throws IOException {
        int i5;
        AttributeLayout attributeLayout;
        int[] iArr = this.classMethodCount;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        long[][] flags = parseFlags("method_flags", inputStream, iArr, bHSDCodec, this.options.hasMethodFlagsHi());
        this.methodFlags = flags;
        this.methodAttrCalls = decodeBandInt("method_attr_calls", inputStream, bHSDCodec, getCallCount(decodeBandInt("method_attr_indexes", inputStream, bHSDCodec, decodeBandInt("method_attr_count", inputStream, bHSDCodec, SegmentUtils.countBit16(flags))), this.methodFlags, 2));
        this.methodAttributes = new ArrayList[this.classCount][];
        for (int i6 = 0; i6 < this.classCount; i6++) {
            this.methodAttributes[i6] = new ArrayList[this.methodFlags[i6].length];
            for (int i7 = 0; i7 < this.methodFlags[i6].length; i7++) {
                this.methodAttributes[i6][i7] = new ArrayList();
            }
        }
        AttributeLayout attributeLayout2 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_EXCEPTIONS, 2);
        int iCountMatches = SegmentUtils.countMatches(this.methodFlags, attributeLayout2);
        BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
        int[] iArrDecodeBandInt = decodeBandInt("method_Exceptions_n", inputStream, bHSDCodec2, iCountMatches);
        int[][] iArrDecodeBandInt2 = decodeBandInt("method_Exceptions_RC", inputStream, bHSDCodec2, iArrDecodeBandInt);
        AttributeLayout attributeLayout3 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_SIGNATURE, 2);
        int[] iArrDecodeBandInt3 = decodeBandInt("method_signature_RS", inputStream, bHSDCodec2, SegmentUtils.countMatches(this.methodFlags, attributeLayout3));
        AttributeLayout attributeLayout4 = this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_DEPRECATED, 2);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.methodAttributes.length; i10++) {
            int i11 = 0;
            while (i11 < this.methodAttributes[i10].length) {
                int[] iArr2 = iArrDecodeBandInt3;
                long j6 = this.methodFlags[i10][i11];
                if (attributeLayout2.matches(j6)) {
                    int i12 = iArrDecodeBandInt[i8];
                    int[] iArr3 = iArrDecodeBandInt2[i8];
                    CPClass[] cPClassArr = new CPClass[i12];
                    int i13 = 0;
                    while (i13 < i12) {
                        int i14 = i13;
                        cPClassArr[i14] = this.cpBands.cpClassValue(iArr3[i14]);
                        i13 = i14 + 1;
                        attributeLayout2 = attributeLayout2;
                    }
                    attributeLayout = attributeLayout2;
                    this.methodAttributes[i10][i11].add(new ExceptionsAttribute(cPClassArr));
                    i8++;
                } else {
                    attributeLayout = attributeLayout2;
                }
                if (attributeLayout3.matches(j6)) {
                    long j7 = iArr2[i9];
                    String str = this.methodDescr[i10][i11];
                    String strSubstring = str.substring(str.indexOf(58) + 1);
                    if (strSubstring.equals("B") || strSubstring.equals("H")) {
                        strSubstring = "I";
                    }
                    this.methodAttributes[i10][i11].add(new SignatureAttribute((CPUTF8) attributeLayout3.getValue(j7, strSubstring, this.cpBands.getConstantPool())));
                    i9++;
                }
                if (attributeLayout4.matches(j6)) {
                    this.methodAttributes[i10][i11].add(new DeprecatedAttribute());
                }
                i11++;
                iArrDecodeBandInt3 = iArr2;
                attributeLayout2 = attributeLayout;
            }
        }
        int methodMetadataBands = parseMethodMetadataBands(inputStream, this.methodAttrCalls);
        int i15 = this.options.hasMethodFlagsHi() ? 62 : 31;
        int i16 = i15 + 1;
        AttributeLayout[] attributeLayoutArr = new AttributeLayout[i16];
        int[] iArr4 = new int[i16];
        List[] listArr = new List[i16];
        for (int i17 = 0; i17 < i15; i17++) {
            AttributeLayout attributeLayout5 = this.attrMap.getAttributeLayout(i17, 2);
            if (attributeLayout5 != null && !attributeLayout5.isDefaultLayout()) {
                attributeLayoutArr[i17] = attributeLayout5;
                iArr4[i17] = SegmentUtils.countMatches(this.methodFlags, attributeLayout5);
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            if (iArr4[i18] > 0) {
                NewAttributeBands attributeBands = this.attrMap.getAttributeBands(attributeLayoutArr[i18]);
                listArr[i18] = attributeBands.parseAttributes(inputStream, iArr4[i18]);
                int iNumBackwardsCallables = attributeLayoutArr[i18].numBackwardsCallables();
                if (iNumBackwardsCallables > 0) {
                    int[] iArr5 = new int[iNumBackwardsCallables];
                    System.arraycopy(this.methodAttrCalls, methodMetadataBands, iArr5, 0, iNumBackwardsCallables);
                    attributeBands.setBackwardsCalls(iArr5);
                    methodMetadataBands += iNumBackwardsCallables;
                }
            }
        }
        for (int i19 = 0; i19 < this.methodAttributes.length; i19++) {
            for (int i20 = 0; i20 < this.methodAttributes[i19].length; i20++) {
                long j8 = this.methodFlags[i19][i20];
                int i21 = 0;
                for (int i22 = 0; i22 < i16; i22++) {
                    AttributeLayout attributeLayout6 = attributeLayoutArr[i22];
                    if (attributeLayout6 != null && attributeLayout6.matches(j8)) {
                        if (attributeLayoutArr[i22].getIndex() < 15) {
                            i5 = 0;
                            this.methodAttributes[i19][i20].add(i21, listArr[i22].get(0));
                            i21++;
                        } else {
                            i5 = 0;
                            this.methodAttributes[i19][i20].add(listArr[i22].get(0));
                        }
                        listArr[i22].remove(i5);
                    }
                }
            }
        }
    }

    private void parseMethodBands(InputStream inputStream) throws IOException {
        int[][] iArrDecodeBandInt = decodeBandInt("method_descr", inputStream, Codec.MDELTA5, this.classMethodCount);
        this.methodDescrInts = iArrDecodeBandInt;
        this.methodDescr = getReferences(iArrDecodeBandInt, this.cpBands.getCpDescriptor());
        parseMethodAttrBands(inputStream);
    }

    private int parseMethodMetadataBands(InputStream inputStream, int[] iArr) {
        String[] strArr = {"RVA", "RIA", "RVPA", "RIPA", "AD"};
        int[] iArr2 = new int[5];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        iArr2[4] = 0;
        AttributeLayout[] attributeLayoutArr = {this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS, 2), this.attrMap.getAttributeLayout(AttributeLayout.ATTRIBUTE_ANNOTATION_DEFAULT, 2)};
        for (int i5 = 0; i5 < 5; i5++) {
            iArr2[i5] = SegmentUtils.countMatches(this.methodFlags, attributeLayoutArr[i5]);
        }
        int[] iArr3 = new int[5];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 5; i8++) {
            if (iArr2[i8] > 0) {
                i6++;
                iArr3[i8] = iArr[i7];
                i7++;
            } else {
                iArr3[i8] = 0;
            }
        }
        MetadataBandGroup[] metadata = parseMetadata(inputStream, strArr, iArr2, iArr3, "method");
        List[] listArr = new List[5];
        int[] iArr4 = new int[5];
        for (int i9 = 0; i9 < metadata.length; i9++) {
            listArr[i9] = metadata[i9].getAttributes();
            iArr4[i9] = 0;
        }
        for (int i10 = 0; i10 < this.methodFlags.length; i10++) {
            for (int i11 = 0; i11 < this.methodFlags[i10].length; i11++) {
                for (int i12 = 0; i12 < 5; i12++) {
                    if (attributeLayoutArr[i12].matches(this.methodFlags[i10][i11])) {
                        ArrayList arrayList = this.methodAttributes[i10][i11];
                        List list = listArr[i12];
                        int i13 = iArr4[i12];
                        iArr4[i12] = i13 + 1;
                        arrayList.add(list.get(i13));
                    }
                }
            }
        }
        return i6;
    }

    public ArrayList[] getClassAttributes() {
        return this.classAttributes;
    }

    public int[] getClassFieldCount() {
        return this.classFieldCount;
    }

    public long[] getClassFlags() {
        if (this.classAccessFlags == null) {
            int i5 = 0;
            long j6 = 32767;
            for (int i6 = 0; i6 < 16; i6++) {
                AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(i6, 0);
                if (attributeLayout != null && !attributeLayout.isDefaultLayout()) {
                    j6 &= (long) (~(1 << i6));
                }
            }
            this.classAccessFlags = new long[this.classFlags.length];
            while (true) {
                long[] jArr = this.classFlags;
                if (i5 >= jArr.length) {
                    break;
                }
                this.classAccessFlags[i5] = jArr[i5] & j6;
                i5++;
            }
        }
        return this.classAccessFlags;
    }

    public int[][] getClassInterfacesInts() {
        return this.classInterfacesInts;
    }

    public int[] getClassMethodCount() {
        return this.classMethodCount;
    }

    public int[] getClassSuperInts() {
        return this.classSuperInts;
    }

    public int[] getClassThisInts() {
        return this.classThisInts;
    }

    public int[] getClassVersionMajor() {
        return this.classVersionMajor;
    }

    public int[] getClassVersionMinor() {
        return this.classVersionMinor;
    }

    public int[][] getCodeHandlerCatchPO() {
        return this.codeHandlerCatchPO;
    }

    public int[][] getCodeHandlerClassRCN() {
        return this.codeHandlerClassRCN;
    }

    public int[] getCodeHandlerCount() {
        return this.codeHandlerCount;
    }

    public int[][] getCodeHandlerEndPO() {
        return this.codeHandlerEndPO;
    }

    public int[][] getCodeHandlerStartP() {
        return this.codeHandlerStartP;
    }

    public boolean[] getCodeHasAttributes() {
        return this.codeHasAttributes;
    }

    public int[] getCodeMaxNALocals() {
        return this.codeMaxNALocals;
    }

    public int[] getCodeMaxStack() {
        return this.codeMaxStack;
    }

    public ArrayList[][] getFieldAttributes() {
        return this.fieldAttributes;
    }

    public int[][] getFieldDescrInts() {
        return this.fieldDescrInts;
    }

    public long[][] getFieldFlags() {
        if (this.fieldAccessFlags == null) {
            long j6 = 32767;
            for (int i5 = 0; i5 < 16; i5++) {
                AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(i5, 1);
                if (attributeLayout != null && !attributeLayout.isDefaultLayout()) {
                    j6 &= (long) (~(1 << i5));
                }
            }
            this.fieldAccessFlags = new long[this.fieldFlags.length][];
            int i6 = 0;
            while (true) {
                long[][] jArr = this.fieldFlags;
                if (i6 >= jArr.length) {
                    break;
                }
                this.fieldAccessFlags[i6] = new long[jArr[i6].length];
                int i7 = 0;
                while (true) {
                    long[] jArr2 = this.fieldFlags[i6];
                    if (i7 < jArr2.length) {
                        this.fieldAccessFlags[i6][i7] = jArr2[i7] & j6;
                        i7++;
                    }
                }
                i6++;
            }
        }
        return this.fieldAccessFlags;
    }

    public IcTuple[][] getIcLocal() {
        return this.icLocal;
    }

    public ArrayList[][] getMethodAttributes() {
        return this.methodAttributes;
    }

    public String[][] getMethodDescr() {
        return this.methodDescr;
    }

    public int[][] getMethodDescrInts() {
        return this.methodDescrInts;
    }

    public long[][] getMethodFlags() {
        if (this.methodAccessFlags == null) {
            long j6 = 32767;
            for (int i5 = 0; i5 < 16; i5++) {
                AttributeLayout attributeLayout = this.attrMap.getAttributeLayout(i5, 2);
                if (attributeLayout != null && !attributeLayout.isDefaultLayout()) {
                    j6 &= (long) (~(1 << i5));
                }
            }
            this.methodAccessFlags = new long[this.methodFlags.length][];
            int i6 = 0;
            while (true) {
                long[][] jArr = this.methodFlags;
                if (i6 >= jArr.length) {
                    break;
                }
                this.methodAccessFlags[i6] = new long[jArr[i6].length];
                int i7 = 0;
                while (true) {
                    long[] jArr2 = this.methodFlags[i6];
                    if (i7 < jArr2.length) {
                        this.methodAccessFlags[i6][i7] = jArr2[i7] & j6;
                        i7++;
                    }
                }
                i6++;
            }
        }
        return this.methodAccessFlags;
    }

    public ArrayList getOrderedCodeAttributes() {
        ArrayList arrayList = new ArrayList(this.codeAttributes.length);
        for (int i5 = 0; i5 < this.codeAttributes.length; i5++) {
            ArrayList arrayList2 = new ArrayList(this.codeAttributes[i5].size());
            for (int i6 = 0; i6 < this.codeAttributes[i5].size(); i6++) {
                arrayList2.add((Attribute) this.codeAttributes[i5].get(i6));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public long[] getRawClassFlags() {
        return this.classFlags;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void read(InputStream inputStream) {
        int classCount = this.header.getClassCount();
        BHSDCodec bHSDCodec = Codec.DELTA5;
        int[] iArrDecodeBandInt = decodeBandInt("class_this", inputStream, bHSDCodec, classCount);
        this.classThisInts = iArrDecodeBandInt;
        this.classThis = getReferences(iArrDecodeBandInt, this.cpBands.getCpClass());
        this.classSuperInts = decodeBandInt("class_super", inputStream, bHSDCodec, classCount);
        this.classInterfacesInts = decodeBandInt("class_interface", inputStream, bHSDCodec, decodeBandInt("class_interface_count", inputStream, bHSDCodec, classCount));
        this.classFieldCount = decodeBandInt("class_field_count", inputStream, bHSDCodec, classCount);
        this.classMethodCount = decodeBandInt("class_method_count", inputStream, bHSDCodec, classCount);
        parseFieldBands(inputStream);
        parseMethodBands(inputStream);
        parseClassAttrBands(inputStream);
        parseCodeBands(inputStream);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void unpack() {
    }
}
