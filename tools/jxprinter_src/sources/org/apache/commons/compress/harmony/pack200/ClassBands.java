package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.exifinterface.media.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.objectweb.asm.Label;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassBands extends BandSet {
    private boolean anySyntheticClasses;
    private boolean anySyntheticFields;
    private boolean anySyntheticMethods;
    private final AttributeDefinitionBands attrBands;
    private final List classAttributeBands;
    private final List classEnclosingMethodClass;
    private final List classEnclosingMethodDesc;
    private final IntList classFileVersionMajor;
    private final IntList classFileVersionMinor;
    private List classInnerClassesNameRUN;
    private List classInnerClassesOuterRCN;
    private final Map classReferencesInnerClass;
    private final List classSignature;
    private final List classSourceFile;
    private int[] class_InnerClasses_F;
    private int[] class_InnerClasses_N;
    private CPClass[] class_InnerClasses_RC;
    private final MetadataBandGroup class_RIA_bands;
    private final MetadataBandGroup class_RVA_bands;
    private int[] class_attr_calls;
    private final int[] class_field_count;
    private final long[] class_flags;
    private final CPClass[][] class_interface;
    private final int[] class_interface_count;
    private final int[] class_method_count;
    private final CPClass[] class_super;
    private final CPClass[] class_this;
    private final List codeAttributeBands;
    private final List codeFlags;
    private final List codeHandlerCatchPO;
    private final List codeHandlerClass;
    private final IntList codeHandlerCount;
    private final List codeHandlerEndPO;
    private final List codeHandlerStartP;
    private int[] codeHeaders;
    private final List codeLineNumberTableBciP;
    private final IntList codeLineNumberTableLine;
    private final IntList codeLineNumberTableN;
    private final List codeLocalVariableTableBciP;
    private final IntList codeLocalVariableTableN;
    private final List codeLocalVariableTableNameRU;
    private final IntList codeLocalVariableTableSlot;
    private final List codeLocalVariableTableSpanO;
    private final List codeLocalVariableTableTypeRS;
    private final List codeLocalVariableTypeTableBciP;
    private final IntList codeLocalVariableTypeTableN;
    private final List codeLocalVariableTypeTableNameRU;
    private final IntList codeLocalVariableTypeTableSlot;
    private final List codeLocalVariableTypeTableSpanO;
    private final List codeLocalVariableTypeTableTypeRS;
    private final IntList codeMaxLocals;
    private final IntList codeMaxStack;
    private int[] code_attr_calls;
    private final CpBands cpBands;
    private final List fieldAttributeBands;
    private final List fieldConstantValueKQ;
    private final List fieldSignature;
    private final MetadataBandGroup field_RIA_bands;
    private final MetadataBandGroup field_RVA_bands;
    private int[] field_attr_calls;
    private final CPNameAndType[][] field_descr;
    private final long[][] field_flags;
    private int index;
    private final int[] major_versions;
    private final List methodAttributeBands;
    private final List methodExceptionClasses;
    private final IntList methodExceptionNumber;
    private final List methodSignature;
    private final MetadataBandGroup method_AD_bands;
    private final MetadataBandGroup method_RIA_bands;
    private final MetadataBandGroup method_RIPA_bands;
    private final MetadataBandGroup method_RVA_bands;
    private final MetadataBandGroup method_RVPA_bands;
    private int[] method_attr_calls;
    private final CPNameAndType[][] method_descr;
    private final long[][] method_flags;
    private int numMethodArgs;
    private final Segment segment;
    private final boolean stripDebug;
    private final List tempFieldDesc;
    private final List tempFieldFlags;
    private final List tempMethodDesc;
    private final List tempMethodFlags;
    private TempParamAnnotation tempMethodRIPA;
    private TempParamAnnotation tempMethodRVPA;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TempParamAnnotation {
        int[] annoN;
        int numParams;
        IntList pairN = new IntList();
        List typeRS = new ArrayList();
        List nameRU = new ArrayList();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        List f6710t = new ArrayList();
        List values = new ArrayList();
        List caseArrayN = new ArrayList();
        List nestTypeRS = new ArrayList();
        List nestNameRU = new ArrayList();
        List nestPairN = new ArrayList();

        public TempParamAnnotation(int i5) {
            this.numParams = i5;
            this.annoN = new int[i5];
        }

        public void addParameterAnnotation(int i5, String str, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
            int[] iArr = this.annoN;
            iArr[i5] = iArr[i5] + 1;
            this.typeRS.add(str);
            this.pairN.add(list.size());
            this.nameRU.addAll(list);
            this.f6710t.addAll(list2);
            this.values.addAll(list3);
            this.caseArrayN.addAll(list4);
            this.nestTypeRS.addAll(list5);
            this.nestNameRU.addAll(list6);
            this.nestPairN.addAll(list7);
        }
    }

    public ClassBands(Segment segment, int i5, int i6, boolean z6) {
        super(i6, segment.getSegmentHeader());
        this.classSourceFile = new ArrayList();
        this.classEnclosingMethodClass = new ArrayList();
        this.classEnclosingMethodDesc = new ArrayList();
        this.classSignature = new ArrayList();
        this.classFileVersionMinor = new IntList();
        this.classFileVersionMajor = new IntList();
        this.fieldConstantValueKQ = new ArrayList();
        this.fieldSignature = new ArrayList();
        this.methodSignature = new ArrayList();
        this.methodExceptionNumber = new IntList();
        this.methodExceptionClasses = new ArrayList();
        this.codeMaxStack = new IntList();
        this.codeMaxLocals = new IntList();
        this.codeHandlerCount = new IntList();
        this.codeHandlerStartP = new ArrayList();
        this.codeHandlerEndPO = new ArrayList();
        this.codeHandlerCatchPO = new ArrayList();
        this.codeHandlerClass = new ArrayList();
        this.codeFlags = new ArrayList();
        this.codeLineNumberTableN = new IntList();
        this.codeLineNumberTableBciP = new ArrayList();
        this.codeLineNumberTableLine = new IntList();
        this.codeLocalVariableTableN = new IntList();
        this.codeLocalVariableTableBciP = new ArrayList();
        this.codeLocalVariableTableSpanO = new ArrayList();
        this.codeLocalVariableTableNameRU = new ArrayList();
        this.codeLocalVariableTableTypeRS = new ArrayList();
        this.codeLocalVariableTableSlot = new IntList();
        this.codeLocalVariableTypeTableN = new IntList();
        this.codeLocalVariableTypeTableBciP = new ArrayList();
        this.codeLocalVariableTypeTableSpanO = new ArrayList();
        this.codeLocalVariableTypeTableNameRU = new ArrayList();
        this.codeLocalVariableTypeTableTypeRS = new ArrayList();
        this.codeLocalVariableTypeTableSlot = new IntList();
        this.classAttributeBands = new ArrayList();
        this.methodAttributeBands = new ArrayList();
        this.fieldAttributeBands = new ArrayList();
        this.codeAttributeBands = new ArrayList();
        this.tempFieldFlags = new ArrayList();
        this.tempFieldDesc = new ArrayList();
        this.tempMethodFlags = new ArrayList();
        this.tempMethodDesc = new ArrayList();
        this.anySyntheticClasses = false;
        this.anySyntheticFields = false;
        this.anySyntheticMethods = false;
        this.classReferencesInnerClass = new HashMap();
        this.index = 0;
        this.numMethodArgs = 0;
        this.stripDebug = z6;
        this.segment = segment;
        this.cpBands = segment.getCpBands();
        this.attrBands = segment.getAttrBands();
        this.class_this = new CPClass[i5];
        this.class_super = new CPClass[i5];
        this.class_interface_count = new int[i5];
        this.class_interface = new CPClass[i5][];
        this.class_field_count = new int[i5];
        this.class_method_count = new int[i5];
        this.field_descr = new CPNameAndType[i5][];
        this.field_flags = new long[i5][];
        this.method_descr = new CPNameAndType[i5][];
        this.method_flags = new long[i5][];
        for (int i7 = 0; i7 < i5; i7++) {
            this.field_flags[i7] = new long[0];
            this.method_flags[i7] = new long[0];
        }
        this.major_versions = new int[i5];
        this.class_flags = new long[i5];
        this.class_RVA_bands = new MetadataBandGroup("RVA", 0, this.cpBands, this.segmentHeader, i6);
        this.class_RIA_bands = new MetadataBandGroup("RIA", 0, this.cpBands, this.segmentHeader, i6);
        this.field_RVA_bands = new MetadataBandGroup("RVA", 1, this.cpBands, this.segmentHeader, i6);
        this.field_RIA_bands = new MetadataBandGroup("RIA", 1, this.cpBands, this.segmentHeader, i6);
        this.method_RVA_bands = new MetadataBandGroup("RVA", 2, this.cpBands, this.segmentHeader, i6);
        this.method_RIA_bands = new MetadataBandGroup("RIA", 2, this.cpBands, this.segmentHeader, i6);
        this.method_RVPA_bands = new MetadataBandGroup("RVPA", 2, this.cpBands, this.segmentHeader, i6);
        this.method_RIPA_bands = new MetadataBandGroup("RIPA", 2, this.cpBands, this.segmentHeader, i6);
        this.method_AD_bands = new MetadataBandGroup("AD", 2, this.cpBands, this.segmentHeader, i6);
        createNewAttributeBands();
    }

    public static int countArgs(String str) {
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(41);
        if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 < iIndexOf) {
            throw new IllegalArgumentException("No arguments");
        }
        int i5 = 0;
        boolean z6 = false;
        boolean z7 = false;
        for (int i6 = iIndexOf + 1; i6 < iIndexOf2; i6++) {
            char cCharAt = str.charAt(i6);
            if (z6 && cCharAt == ';') {
                z6 = false;
                z7 = false;
            } else if (!z6 && cCharAt == 'L') {
                i5++;
                z6 = true;
            } else if (cCharAt == '[') {
                z7 = true;
            } else if (!z6) {
                if (z7) {
                    i5++;
                    z7 = false;
                } else {
                    i5 = (cCharAt == 'D' || cCharAt == 'J') ? i5 + 2 : i5 + 1;
                }
            }
        }
        return i5;
    }

    private void createNewAttributeBands() {
        Iterator it = this.attrBands.getClassAttributeLayouts().iterator();
        while (it.hasNext()) {
            this.classAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), (AttributeDefinitionBands.AttributeDefinition) it.next()));
        }
        Iterator it2 = this.attrBands.getMethodAttributeLayouts().iterator();
        while (it2.hasNext()) {
            this.methodAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), (AttributeDefinitionBands.AttributeDefinition) it2.next()));
        }
        Iterator it3 = this.attrBands.getFieldAttributeLayouts().iterator();
        while (it3.hasNext()) {
            this.fieldAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), (AttributeDefinitionBands.AttributeDefinition) it3.next()));
        }
        Iterator it4 = this.attrBands.getCodeAttributeLayouts().iterator();
        while (it4.hasNext()) {
            this.codeAttributeBands.add(new NewAttributeBands(this.effort, this.cpBands, this.segment.getSegmentHeader(), (AttributeDefinitionBands.AttributeDefinition) it4.next()));
        }
    }

    private int[] getInts(CPClass[] cPClassArr) {
        int length = cPClassArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            CPClass cPClass = cPClassArr[i5];
            if (cPClass != null) {
                iArr[i5] = cPClass.getIndex();
            }
        }
        return iArr;
    }

    private boolean isInnerClass(String str) {
        return str.indexOf(36) != -1;
    }

    private boolean isInnerClassOf(String str, CPClass cPClass) {
        if (!isInnerClass(str)) {
            return false;
        }
        String strSubstring = str.substring(0, str.lastIndexOf(36));
        if (strSubstring.equals(cPClass.toString())) {
            return true;
        }
        return isInnerClassOf(strSubstring, cPClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$finaliseBands$0(Object obj, Object obj2) {
        return ((NewAttributeBands) obj).getFlagIndex() - ((NewAttributeBands) obj2).getFlagIndex();
    }

    private void renumberBci(List list, IntList intList, Map map) {
        for (int size = list.size() - 1; size >= 0; size--) {
            Object obj = list.get(size);
            if (obj instanceof Integer) {
                return;
            }
            if (obj instanceof Label) {
                list.remove(size);
                list.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue())));
            }
        }
    }

    private void renumberDoubleOffsetBci(List list, List list2, List list3, IntList intList, Map map) {
        for (int size = list3.size() - 1; size >= 0; size--) {
            Object obj = list3.get(size);
            if (obj instanceof Integer) {
                return;
            }
            if (obj instanceof Label) {
                list3.remove(size);
                list3.add(size, Integer.valueOf((intList.get(((Integer) map.get(obj)).intValue()) - ((Integer) list.get(size)).intValue()) - ((Integer) list2.get(size)).intValue()));
            }
        }
    }

    private void renumberOffsetBci(List list, List list2, IntList intList, Map map) {
        for (int size = list2.size() - 1; size >= 0; size--) {
            Object obj = list2.get(size);
            if (obj instanceof Integer) {
                return;
            }
            if (obj instanceof Label) {
                list2.remove(size);
                list2.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue()) - ((Integer) list.get(size)).intValue()));
            }
        }
    }

    private int sum(int[] iArr) {
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        return i5;
    }

    private void writeClassAttributeBands(OutputStream outputStream) throws IOException {
        long[] jArr = this.class_flags;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeFlags = encodeFlags("class_flags", jArr, bHSDCodec, bHSDCodec, this.segmentHeader.have_class_flags_hi());
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeFlags, "Wrote ");
        sbI.append(bArrEncodeFlags.length);
        sbI.append(" bytes from class_flags[");
        AbstractC1125a.m("]", this.class_flags.length, sbI);
        byte[] bArrEncodeBandInt = encodeBandInt("class_attr_calls", this.class_attr_calls, bHSDCodec);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI2.append(bArrEncodeBandInt.length);
        sbI2.append(" bytes from class_attr_calls[");
        AbstractC1125a.m("]", this.class_attr_calls.length, sbI2);
        byte[] bArrEncodeBandInt2 = encodeBandInt("classSourceFile", cpEntryOrNullListToArray(this.classSourceFile), bHSDCodec);
        outputStream.write(bArrEncodeBandInt2);
        StringBuilder sb = new StringBuilder("Wrote ");
        sb.append(bArrEncodeBandInt2.length);
        sb.append(" bytes from classSourceFile[");
        AbstractC1125a.o(this.classSourceFile, sb, "]");
        byte[] bArrEncodeBandInt3 = encodeBandInt("class_enclosing_method_RC", cpEntryListToArray(this.classEnclosingMethodClass), bHSDCodec);
        outputStream.write(bArrEncodeBandInt3);
        StringBuilder sb2 = new StringBuilder("Wrote ");
        sb2.append(bArrEncodeBandInt3.length);
        sb2.append(" bytes from class_enclosing_method_RC[");
        AbstractC1125a.o(this.classEnclosingMethodClass, sb2, "]");
        byte[] bArrEncodeBandInt4 = encodeBandInt("class_EnclosingMethod_RDN", cpEntryOrNullListToArray(this.classEnclosingMethodDesc), bHSDCodec);
        outputStream.write(bArrEncodeBandInt4);
        StringBuilder sb3 = new StringBuilder("Wrote ");
        sb3.append(bArrEncodeBandInt4.length);
        sb3.append(" bytes from class_EnclosingMethod_RDN[");
        AbstractC1125a.o(this.classEnclosingMethodDesc, sb3, "]");
        byte[] bArrEncodeBandInt5 = encodeBandInt("class_Signature_RS", cpEntryListToArray(this.classSignature), bHSDCodec);
        outputStream.write(bArrEncodeBandInt5);
        StringBuilder sb4 = new StringBuilder("Wrote ");
        sb4.append(bArrEncodeBandInt5.length);
        sb4.append(" bytes from class_Signature_RS[");
        AbstractC1125a.o(this.classSignature, sb4, "]");
        this.class_RVA_bands.pack(outputStream);
        this.class_RIA_bands.pack(outputStream);
        byte[] bArrEncodeBandInt6 = encodeBandInt("class_InnerClasses_N", this.class_InnerClasses_N, bHSDCodec);
        StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt6, "Wrote ");
        sbI3.append(bArrEncodeBandInt6.length);
        sbI3.append(" bytes from class_InnerClasses_N[");
        AbstractC1125a.m("]", this.class_InnerClasses_N.length, sbI3);
        byte[] bArrEncodeBandInt7 = encodeBandInt("class_InnerClasses_RC", getInts(this.class_InnerClasses_RC), bHSDCodec);
        StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt7, "Wrote ");
        sbI4.append(bArrEncodeBandInt7.length);
        sbI4.append(" bytes from class_InnerClasses_RC[");
        AbstractC1125a.m("]", this.class_InnerClasses_RC.length, sbI4);
        byte[] bArrEncodeBandInt8 = encodeBandInt("class_InnerClasses_F", this.class_InnerClasses_F, bHSDCodec);
        StringBuilder sbI5 = AbstractC1125a.i(outputStream, bArrEncodeBandInt8, "Wrote ");
        sbI5.append(bArrEncodeBandInt8.length);
        sbI5.append(" bytes from class_InnerClasses_F[");
        AbstractC1125a.m("]", this.class_InnerClasses_F.length, sbI5);
        byte[] bArrEncodeBandInt9 = encodeBandInt("class_InnerClasses_outer_RCN", cpEntryOrNullListToArray(this.classInnerClassesOuterRCN), bHSDCodec);
        outputStream.write(bArrEncodeBandInt9);
        StringBuilder sb5 = new StringBuilder("Wrote ");
        sb5.append(bArrEncodeBandInt9.length);
        sb5.append(" bytes from class_InnerClasses_outer_RCN[");
        AbstractC1125a.o(this.classInnerClassesOuterRCN, sb5, "]");
        byte[] bArrEncodeBandInt10 = encodeBandInt("class_InnerClasses_name_RUN", cpEntryOrNullListToArray(this.classInnerClassesNameRUN), bHSDCodec);
        outputStream.write(bArrEncodeBandInt10);
        StringBuilder sb6 = new StringBuilder("Wrote ");
        sb6.append(bArrEncodeBandInt10.length);
        sb6.append(" bytes from class_InnerClasses_name_RUN[");
        AbstractC1125a.o(this.classInnerClassesNameRUN, sb6, "]");
        byte[] bArrEncodeBandInt11 = encodeBandInt("classFileVersionMinor", this.classFileVersionMinor.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt11);
        PackingUtils.log("Wrote " + bArrEncodeBandInt11.length + " bytes from classFileVersionMinor[" + this.classFileVersionMinor.size() + "]");
        byte[] bArrEncodeBandInt12 = encodeBandInt("classFileVersionMajor", this.classFileVersionMajor.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt12);
        PackingUtils.log("Wrote " + bArrEncodeBandInt12.length + " bytes from classFileVersionMajor[" + this.classFileVersionMajor.size() + "]");
        Iterator it = this.classAttributeBands.iterator();
        while (it.hasNext()) {
            ((NewAttributeBands) it.next()).pack(outputStream);
        }
    }

    private void writeCodeAttributeBands(OutputStream outputStream) throws IOException {
        long[] jArrLongListToArray = longListToArray(this.codeFlags);
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeFlags = encodeFlags("codeFlags", jArrLongListToArray, bHSDCodec, bHSDCodec, this.segmentHeader.have_code_flags_hi());
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeFlags, "Wrote ");
        sbI.append(bArrEncodeFlags.length);
        sbI.append(" bytes from codeFlags[");
        AbstractC1125a.o(this.codeFlags, sbI, "]");
        byte[] bArrEncodeBandInt = encodeBandInt("code_attr_calls", this.code_attr_calls, bHSDCodec);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI2.append(bArrEncodeBandInt.length);
        sbI2.append(" bytes from code_attr_calls[");
        AbstractC1125a.m("]", this.code_attr_calls.length, sbI2);
        byte[] bArrEncodeBandInt2 = encodeBandInt("code_LineNumberTable_N", this.codeLineNumberTableN.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt2);
        PackingUtils.log("Wrote " + bArrEncodeBandInt2.length + " bytes from code_LineNumberTable_N[" + this.codeLineNumberTableN.size() + "]");
        int[] iArrIntegerListToArray = integerListToArray(this.codeLineNumberTableBciP);
        BHSDCodec bHSDCodec2 = Codec.BCI5;
        byte[] bArrEncodeBandInt3 = encodeBandInt("code_LineNumberTable_bci_P", iArrIntegerListToArray, bHSDCodec2);
        StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt3, "Wrote ");
        sbI3.append(bArrEncodeBandInt3.length);
        sbI3.append(" bytes from code_LineNumberTable_bci_P[");
        AbstractC1125a.o(this.codeLineNumberTableBciP, sbI3, "]");
        byte[] bArrEncodeBandInt4 = encodeBandInt("code_LineNumberTable_line", this.codeLineNumberTableLine.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt4);
        PackingUtils.log("Wrote " + bArrEncodeBandInt4.length + " bytes from code_LineNumberTable_line[" + this.codeLineNumberTableLine.size() + "]");
        byte[] bArrEncodeBandInt5 = encodeBandInt("code_LocalVariableTable_N", this.codeLocalVariableTableN.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt5);
        PackingUtils.log("Wrote " + bArrEncodeBandInt5.length + " bytes from code_LocalVariableTable_N[" + this.codeLocalVariableTableN.size() + "]");
        byte[] bArrEncodeBandInt6 = encodeBandInt("code_LocalVariableTable_bci_P", integerListToArray(this.codeLocalVariableTableBciP), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt6);
        StringBuilder sb = new StringBuilder("Wrote ");
        sb.append(bArrEncodeBandInt6.length);
        sb.append(" bytes from code_LocalVariableTable_bci_P[");
        AbstractC1125a.o(this.codeLocalVariableTableBciP, sb, "]");
        int[] iArrIntegerListToArray2 = integerListToArray(this.codeLocalVariableTableSpanO);
        BHSDCodec bHSDCodec3 = Codec.BRANCH5;
        byte[] bArrEncodeBandInt7 = encodeBandInt("code_LocalVariableTable_span_O", iArrIntegerListToArray2, bHSDCodec3);
        StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt7, "Wrote ");
        sbI4.append(bArrEncodeBandInt7.length);
        sbI4.append(" bytes from code_LocalVariableTable_span_O[");
        AbstractC1125a.o(this.codeLocalVariableTableSpanO, sbI4, "]");
        byte[] bArrEncodeBandInt8 = encodeBandInt("code_LocalVariableTable_name_RU", cpEntryListToArray(this.codeLocalVariableTableNameRU), bHSDCodec);
        outputStream.write(bArrEncodeBandInt8);
        StringBuilder sb2 = new StringBuilder("Wrote ");
        sb2.append(bArrEncodeBandInt8.length);
        sb2.append(" bytes from code_LocalVariableTable_name_RU[");
        AbstractC1125a.o(this.codeLocalVariableTableNameRU, sb2, "]");
        byte[] bArrEncodeBandInt9 = encodeBandInt("code_LocalVariableTable_type_RS", cpEntryListToArray(this.codeLocalVariableTableTypeRS), bHSDCodec);
        outputStream.write(bArrEncodeBandInt9);
        StringBuilder sb3 = new StringBuilder("Wrote ");
        sb3.append(bArrEncodeBandInt9.length);
        sb3.append(" bytes from code_LocalVariableTable_type_RS[");
        AbstractC1125a.o(this.codeLocalVariableTableTypeRS, sb3, "]");
        byte[] bArrEncodeBandInt10 = encodeBandInt("code_LocalVariableTable_slot", this.codeLocalVariableTableSlot.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt10);
        PackingUtils.log("Wrote " + bArrEncodeBandInt10.length + " bytes from code_LocalVariableTable_slot[" + this.codeLocalVariableTableSlot.size() + "]");
        byte[] bArrEncodeBandInt11 = encodeBandInt("code_LocalVariableTypeTable_N", this.codeLocalVariableTypeTableN.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt11);
        PackingUtils.log("Wrote " + bArrEncodeBandInt11.length + " bytes from code_LocalVariableTypeTable_N[" + this.codeLocalVariableTypeTableN.size() + "]");
        byte[] bArrEncodeBandInt12 = encodeBandInt("code_LocalVariableTypeTable_bci_P", integerListToArray(this.codeLocalVariableTypeTableBciP), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt12);
        StringBuilder sb4 = new StringBuilder("Wrote ");
        sb4.append(bArrEncodeBandInt12.length);
        sb4.append(" bytes from code_LocalVariableTypeTable_bci_P[");
        AbstractC1125a.o(this.codeLocalVariableTypeTableBciP, sb4, "]");
        byte[] bArrEncodeBandInt13 = encodeBandInt("code_LocalVariableTypeTable_span_O", integerListToArray(this.codeLocalVariableTypeTableSpanO), bHSDCodec3);
        outputStream.write(bArrEncodeBandInt13);
        StringBuilder sb5 = new StringBuilder("Wrote ");
        sb5.append(bArrEncodeBandInt13.length);
        sb5.append(" bytes from code_LocalVariableTypeTable_span_O[");
        AbstractC1125a.o(this.codeLocalVariableTypeTableSpanO, sb5, "]");
        byte[] bArrEncodeBandInt14 = encodeBandInt("code_LocalVariableTypeTable_name_RU", cpEntryListToArray(this.codeLocalVariableTypeTableNameRU), bHSDCodec);
        outputStream.write(bArrEncodeBandInt14);
        StringBuilder sb6 = new StringBuilder("Wrote ");
        sb6.append(bArrEncodeBandInt14.length);
        sb6.append(" bytes from code_LocalVariableTypeTable_name_RU[");
        AbstractC1125a.o(this.codeLocalVariableTypeTableNameRU, sb6, "]");
        byte[] bArrEncodeBandInt15 = encodeBandInt("code_LocalVariableTypeTable_type_RS", cpEntryListToArray(this.codeLocalVariableTypeTableTypeRS), bHSDCodec);
        outputStream.write(bArrEncodeBandInt15);
        StringBuilder sb7 = new StringBuilder("Wrote ");
        sb7.append(bArrEncodeBandInt15.length);
        sb7.append(" bytes from code_LocalVariableTypeTable_type_RS[");
        AbstractC1125a.o(this.codeLocalVariableTypeTableTypeRS, sb7, "]");
        byte[] bArrEncodeBandInt16 = encodeBandInt("code_LocalVariableTypeTable_slot", this.codeLocalVariableTypeTableSlot.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt16);
        PackingUtils.log("Wrote " + bArrEncodeBandInt16.length + " bytes from code_LocalVariableTypeTable_slot[" + this.codeLocalVariableTypeTableSlot.size() + "]");
        Iterator it = this.codeAttributeBands.iterator();
        while (it.hasNext()) {
            ((NewAttributeBands) it.next()).pack(outputStream);
        }
    }

    private void writeCodeBands(OutputStream outputStream) throws IOException {
        byte[] bArrEncodeBandInt = encodeBandInt("codeHeaders", this.codeHeaders, Codec.BYTE1);
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI.append(bArrEncodeBandInt.length);
        sbI.append(" bytes from codeHeaders[");
        AbstractC1125a.m("]", this.codeHeaders.length, sbI);
        int[] array = this.codeMaxStack.toArray();
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeBandInt2 = encodeBandInt("codeMaxStack", array, bHSDCodec);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote ");
        sbI2.append(bArrEncodeBandInt2.length);
        sbI2.append(" bytes from codeMaxStack[");
        sbI2.append(this.codeMaxStack.size());
        sbI2.append("]");
        PackingUtils.log(sbI2.toString());
        byte[] bArrEncodeBandInt3 = encodeBandInt("codeMaxLocals", this.codeMaxLocals.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt3);
        PackingUtils.log("Wrote " + bArrEncodeBandInt3.length + " bytes from codeMaxLocals[" + this.codeMaxLocals.size() + "]");
        byte[] bArrEncodeBandInt4 = encodeBandInt("codeHandlerCount", this.codeHandlerCount.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt4);
        PackingUtils.log("Wrote " + bArrEncodeBandInt4.length + " bytes from codeHandlerCount[" + this.codeHandlerCount.size() + "]");
        byte[] bArrEncodeBandInt5 = encodeBandInt("codeHandlerStartP", integerListToArray(this.codeHandlerStartP), Codec.BCI5);
        StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt5, "Wrote ");
        sbI3.append(bArrEncodeBandInt5.length);
        sbI3.append(" bytes from codeHandlerStartP[");
        AbstractC1125a.o(this.codeHandlerStartP, sbI3, "]");
        int[] iArrIntegerListToArray = integerListToArray(this.codeHandlerEndPO);
        BHSDCodec bHSDCodec2 = Codec.BRANCH5;
        byte[] bArrEncodeBandInt6 = encodeBandInt("codeHandlerEndPO", iArrIntegerListToArray, bHSDCodec2);
        StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt6, "Wrote ");
        sbI4.append(bArrEncodeBandInt6.length);
        sbI4.append(" bytes from codeHandlerEndPO[");
        AbstractC1125a.o(this.codeHandlerEndPO, sbI4, "]");
        byte[] bArrEncodeBandInt7 = encodeBandInt("codeHandlerCatchPO", integerListToArray(this.codeHandlerCatchPO), bHSDCodec2);
        outputStream.write(bArrEncodeBandInt7);
        StringBuilder sb = new StringBuilder("Wrote ");
        sb.append(bArrEncodeBandInt7.length);
        sb.append(" bytes from codeHandlerCatchPO[");
        AbstractC1125a.o(this.codeHandlerCatchPO, sb, "]");
        byte[] bArrEncodeBandInt8 = encodeBandInt("codeHandlerClass", cpEntryOrNullListToArray(this.codeHandlerClass), bHSDCodec);
        outputStream.write(bArrEncodeBandInt8);
        StringBuilder sb2 = new StringBuilder("Wrote ");
        sb2.append(bArrEncodeBandInt8.length);
        sb2.append(" bytes from codeHandlerClass[");
        AbstractC1125a.o(this.codeHandlerClass, sb2, "]");
        writeCodeAttributeBands(outputStream);
    }

    private void writeFieldAttributeBands(OutputStream outputStream) throws IOException {
        long[][] jArr = this.field_flags;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeFlags = encodeFlags("field_flags", jArr, bHSDCodec, bHSDCodec, this.segmentHeader.have_field_flags_hi());
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeFlags, "Wrote ");
        sbI.append(bArrEncodeFlags.length);
        sbI.append(" bytes from field_flags[");
        AbstractC1125a.m("]", this.field_flags.length, sbI);
        byte[] bArrEncodeBandInt = encodeBandInt("field_attr_calls", this.field_attr_calls, bHSDCodec);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI2.append(bArrEncodeBandInt.length);
        sbI2.append(" bytes from field_attr_calls[");
        AbstractC1125a.m("]", this.field_attr_calls.length, sbI2);
        byte[] bArrEncodeBandInt2 = encodeBandInt("fieldConstantValueKQ", cpEntryListToArray(this.fieldConstantValueKQ), bHSDCodec);
        outputStream.write(bArrEncodeBandInt2);
        StringBuilder sb = new StringBuilder("Wrote ");
        sb.append(bArrEncodeBandInt2.length);
        sb.append(" bytes from fieldConstantValueKQ[");
        AbstractC1125a.o(this.fieldConstantValueKQ, sb, "]");
        byte[] bArrEncodeBandInt3 = encodeBandInt("fieldSignature", cpEntryListToArray(this.fieldSignature), bHSDCodec);
        outputStream.write(bArrEncodeBandInt3);
        StringBuilder sb2 = new StringBuilder("Wrote ");
        sb2.append(bArrEncodeBandInt3.length);
        sb2.append(" bytes from fieldSignature[");
        AbstractC1125a.o(this.fieldSignature, sb2, "]");
        this.field_RVA_bands.pack(outputStream);
        this.field_RIA_bands.pack(outputStream);
        Iterator it = this.fieldAttributeBands.iterator();
        while (it.hasNext()) {
            ((NewAttributeBands) it.next()).pack(outputStream);
        }
    }

    private void writeMethodAttributeBands(OutputStream outputStream) throws IOException {
        long[][] jArr = this.method_flags;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeFlags = encodeFlags("method_flags", jArr, bHSDCodec, bHSDCodec, this.segmentHeader.have_method_flags_hi());
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeFlags, "Wrote ");
        sbI.append(bArrEncodeFlags.length);
        sbI.append(" bytes from method_flags[");
        AbstractC1125a.m("]", this.method_flags.length, sbI);
        byte[] bArrEncodeBandInt = encodeBandInt("method_attr_calls", this.method_attr_calls, bHSDCodec);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI2.append(bArrEncodeBandInt.length);
        sbI2.append(" bytes from method_attr_calls[");
        AbstractC1125a.m("]", this.method_attr_calls.length, sbI2);
        byte[] bArrEncodeBandInt2 = encodeBandInt("methodExceptionNumber", this.methodExceptionNumber.toArray(), bHSDCodec);
        outputStream.write(bArrEncodeBandInt2);
        PackingUtils.log("Wrote " + bArrEncodeBandInt2.length + " bytes from methodExceptionNumber[" + this.methodExceptionNumber.size() + "]");
        byte[] bArrEncodeBandInt3 = encodeBandInt("methodExceptionClasses", cpEntryListToArray(this.methodExceptionClasses), bHSDCodec);
        outputStream.write(bArrEncodeBandInt3);
        StringBuilder sb = new StringBuilder("Wrote ");
        sb.append(bArrEncodeBandInt3.length);
        sb.append(" bytes from methodExceptionClasses[");
        AbstractC1125a.o(this.methodExceptionClasses, sb, "]");
        byte[] bArrEncodeBandInt4 = encodeBandInt("methodSignature", cpEntryListToArray(this.methodSignature), bHSDCodec);
        outputStream.write(bArrEncodeBandInt4);
        StringBuilder sb2 = new StringBuilder("Wrote ");
        sb2.append(bArrEncodeBandInt4.length);
        sb2.append(" bytes from methodSignature[");
        AbstractC1125a.o(this.methodSignature, sb2, "]");
        this.method_RVA_bands.pack(outputStream);
        this.method_RIA_bands.pack(outputStream);
        this.method_RVPA_bands.pack(outputStream);
        this.method_RIPA_bands.pack(outputStream);
        this.method_AD_bands.pack(outputStream);
        Iterator it = this.methodAttributeBands.iterator();
        while (it.hasNext()) {
            ((NewAttributeBands) it.next()).pack(outputStream);
        }
    }

    public void addAnnotation(int i5, String str, boolean z6, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        if (i5 == 0) {
            if (z6) {
                this.class_RVA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
                if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
                    this.class_RVA_bands.incrementAnnoN();
                    return;
                }
                this.class_RVA_bands.newEntryInAnnoN();
                long[] jArr = this.class_flags;
                int i6 = this.index;
                jArr[i6] = jArr[i6] | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                return;
            }
            this.class_RIA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
            if ((this.class_flags[this.index] & 4194304) != 0) {
                this.class_RIA_bands.incrementAnnoN();
                return;
            }
            this.class_RIA_bands.newEntryInAnnoN();
            long[] jArr2 = this.class_flags;
            int i7 = this.index;
            jArr2[i7] = jArr2[i7] | 4194304;
            return;
        }
        if (i5 == 1) {
            if (z6) {
                this.field_RVA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
                List list8 = this.tempFieldFlags;
                Long l6 = (Long) list8.remove(list8.size() - 1);
                if ((l6.intValue() & 2097152) != 0) {
                    this.field_RVA_bands.incrementAnnoN();
                } else {
                    this.field_RVA_bands.newEntryInAnnoN();
                }
                this.tempFieldFlags.add(Long.valueOf(l6.intValue() | 2097152));
                return;
            }
            this.field_RIA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
            List list9 = this.tempFieldFlags;
            Long l7 = (Long) list9.remove(list9.size() - 1);
            if ((l7.intValue() & 4194304) != 0) {
                this.field_RIA_bands.incrementAnnoN();
            } else {
                this.field_RIA_bands.newEntryInAnnoN();
            }
            this.tempFieldFlags.add(Long.valueOf(l7.intValue() | 4194304));
            return;
        }
        if (i5 != 2) {
            return;
        }
        if (z6) {
            this.method_RVA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
            List list10 = this.tempMethodFlags;
            Long l8 = (Long) list10.remove(list10.size() - 1);
            if ((l8.intValue() & 2097152) != 0) {
                this.method_RVA_bands.incrementAnnoN();
            } else {
                this.method_RVA_bands.newEntryInAnnoN();
            }
            this.tempMethodFlags.add(Long.valueOf(l8.intValue() | 2097152));
            return;
        }
        this.method_RIA_bands.addAnnotation(str, list, list2, list3, list4, list5, list6, list7);
        List list11 = this.tempMethodFlags;
        Long l9 = (Long) list11.remove(list11.size() - 1);
        if ((l9.intValue() & 4194304) != 0) {
            this.method_RIA_bands.incrementAnnoN();
        } else {
            this.method_RIA_bands.newEntryInAnnoN();
        }
        this.tempMethodFlags.add(Long.valueOf(l9.intValue() | 4194304));
    }

    public void addAnnotationDefault(List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        this.method_AD_bands.addAnnotation(null, list, list2, list3, list4, list5, list6, list7);
        List list8 = this.tempMethodFlags;
        this.tempMethodFlags.add(Long.valueOf(((Long) list8.remove(list8.size() - 1)).longValue() | 33554432));
    }

    public void addClass(int i5, int i6, String str, String str2, String str3, String[] strArr) {
        this.class_this[this.index] = this.cpBands.getCPClass(str);
        this.class_super[this.index] = this.cpBands.getCPClass(str3);
        int[] iArr = this.class_interface_count;
        int i7 = this.index;
        iArr[i7] = strArr.length;
        this.class_interface[i7] = new CPClass[strArr.length];
        for (int i8 = 0; i8 < strArr.length; i8++) {
            this.class_interface[this.index][i8] = this.cpBands.getCPClass(strArr[i8]);
        }
        int[] iArr2 = this.major_versions;
        int i9 = this.index;
        iArr2[i9] = i5;
        this.class_flags[i9] = i6;
        if (!this.anySyntheticClasses && (i6 & 4096) != 0 && this.segment.getCurrentClassReader().hasSyntheticAttributes()) {
            this.cpBands.addCPUtf8("Synthetic");
            this.anySyntheticClasses = true;
        }
        if (str2 != null) {
            long[] jArr = this.class_flags;
            int i10 = this.index;
            jArr[i10] = jArr[i10] | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            this.classSignature.add(this.cpBands.getCPSignature(str2));
        }
    }

    public void addClassAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.classAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                long[] jArr = this.class_flags;
                int i5 = this.index;
                jArr[i5] = jArr[i5] | ((long) (1 << flagIndex));
                return;
            }
        }
        throw new RuntimeException(AbstractC0157z.n("No suitable definition for ", str));
    }

    public void addCode() {
        this.codeHandlerCount.add(0);
        if (this.stripDebug) {
            return;
        }
        this.codeFlags.add(4L);
        this.codeLocalVariableTableN.add(0);
    }

    public void addCodeAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.codeAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                List list = this.codeFlags;
                this.codeFlags.add(Long.valueOf(((Long) list.remove(list.size() - 1)).longValue() | ((long) (1 << flagIndex))));
                return;
            }
        }
        throw new RuntimeException(AbstractC0157z.n("No suitable definition for ", str));
    }

    public void addEnclosingMethod(String str, String str2, String str3) {
        long[] jArr = this.class_flags;
        int i5 = this.index;
        jArr[i5] = jArr[i5] | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.classEnclosingMethodClass.add(this.cpBands.getCPClass(str));
        this.classEnclosingMethodDesc.add(str2 == null ? null : this.cpBands.getCPNameAndType(str2, str3));
    }

    public void addField(int i5, String str, String str2, String str3, Object obj) {
        int i6 = i5 & 65535;
        this.tempFieldDesc.add(this.cpBands.getCPNameAndType(str, str2));
        if (str3 != null) {
            this.fieldSignature.add(this.cpBands.getCPSignature(str3));
            i6 |= 524288;
        }
        if (obj != null) {
            this.fieldConstantValueKQ.add(this.cpBands.getConstant(obj));
            i6 |= 131072;
        }
        if (!this.anySyntheticFields && (i6 & 4096) != 0 && this.segment.getCurrentClassReader().hasSyntheticAttributes()) {
            this.cpBands.addCPUtf8("Synthetic");
            this.anySyntheticFields = true;
        }
        this.tempFieldFlags.add(Long.valueOf(i6));
    }

    public void addFieldAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.fieldAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                List list = this.tempFieldFlags;
                this.tempFieldFlags.add(Long.valueOf(((Long) list.remove(list.size() - 1)).longValue() | ((long) (1 << flagIndex))));
                return;
            }
        }
        throw new RuntimeException(AbstractC0157z.n("No suitable definition for ", str));
    }

    public void addHandler(Label label, Label label2, Label label3, String str) {
        IntList intList = this.codeHandlerCount;
        this.codeHandlerCount.add(intList.remove(intList.size() - 1) + 1);
        this.codeHandlerStartP.add(label);
        this.codeHandlerEndPO.add(label2);
        this.codeHandlerCatchPO.add(label3);
        this.codeHandlerClass.add(str == null ? null : this.cpBands.getCPClass(str));
    }

    public void addLineNumber(int i5, Label label) {
        Long l6 = (Long) AbstractC0157z.f(1, this.codeFlags);
        if ((l6.intValue() & 2) == 0) {
            a.w(1, this.codeFlags);
            this.codeFlags.add(Long.valueOf(l6.intValue() | 2));
            this.codeLineNumberTableN.add(1);
        } else {
            IntList intList = this.codeLineNumberTableN;
            intList.increment(intList.size() - 1);
        }
        this.codeLineNumberTableLine.add(i5);
        this.codeLineNumberTableBciP.add(label);
    }

    public void addLocalVariable(String str, String str2, String str3, Label label, Label label2, int i5) {
        if (str3 != null) {
            Long l6 = (Long) AbstractC0157z.f(1, this.codeFlags);
            if ((l6.intValue() & 8) == 0) {
                a.w(1, this.codeFlags);
                this.codeFlags.add(Long.valueOf(l6.intValue() | 8));
                this.codeLocalVariableTypeTableN.add(1);
            } else {
                IntList intList = this.codeLocalVariableTypeTableN;
                intList.increment(intList.size() - 1);
            }
            this.codeLocalVariableTypeTableBciP.add(label);
            this.codeLocalVariableTypeTableSpanO.add(label2);
            this.codeLocalVariableTypeTableNameRU.add(this.cpBands.getCPUtf8(str));
            this.codeLocalVariableTypeTableTypeRS.add(this.cpBands.getCPSignature(str3));
            this.codeLocalVariableTypeTableSlot.add(i5);
        }
        IntList intList2 = this.codeLocalVariableTableN;
        intList2.increment(intList2.size() - 1);
        this.codeLocalVariableTableBciP.add(label);
        this.codeLocalVariableTableSpanO.add(label2);
        this.codeLocalVariableTableNameRU.add(this.cpBands.getCPUtf8(str));
        this.codeLocalVariableTableTypeRS.add(this.cpBands.getCPSignature(str2));
        this.codeLocalVariableTableSlot.add(i5);
    }

    public void addMaxStack(int i5, int i6) {
        List list = this.tempMethodFlags;
        long jIntValue = ((Long) list.remove(list.size() - 1)).intValue() | 131072;
        this.tempMethodFlags.add(Long.valueOf(jIntValue));
        this.codeMaxStack.add(i5);
        if ((jIntValue & 8) == 0) {
            i6--;
        }
        this.codeMaxLocals.add(i6 - this.numMethodArgs);
    }

    public void addMethod(int i5, String str, String str2, String str3, String[] strArr) {
        this.tempMethodDesc.add(this.cpBands.getCPNameAndType(str, str2));
        if (str3 != null) {
            this.methodSignature.add(this.cpBands.getCPSignature(str3));
            i5 |= 524288;
        }
        if (strArr != null) {
            this.methodExceptionNumber.add(strArr.length);
            for (String str4 : strArr) {
                this.methodExceptionClasses.add(this.cpBands.getCPClass(str4));
            }
            i5 |= 262144;
        }
        if ((131072 & i5) != 0) {
            i5 = (i5 & (-131073)) | 1048576;
        }
        this.tempMethodFlags.add(Long.valueOf(i5));
        this.numMethodArgs = countArgs(str2);
        if (this.anySyntheticMethods || (i5 & 4096) == 0 || !this.segment.getCurrentClassReader().hasSyntheticAttributes()) {
            return;
        }
        this.cpBands.addCPUtf8("Synthetic");
        this.anySyntheticMethods = true;
    }

    public void addMethodAttribute(NewAttribute newAttribute) {
        String str = newAttribute.type;
        for (NewAttributeBands newAttributeBands : this.methodAttributeBands) {
            if (newAttributeBands.getAttributeName().equals(str)) {
                newAttributeBands.addAttribute(newAttribute);
                int flagIndex = newAttributeBands.getFlagIndex();
                List list = this.tempMethodFlags;
                this.tempMethodFlags.add(Long.valueOf(((Long) list.remove(list.size() - 1)).longValue() | ((long) (1 << flagIndex))));
                return;
            }
        }
        throw new RuntimeException(AbstractC0157z.n("No suitable definition for ", str));
    }

    public void addParameterAnnotation(int i5, String str, boolean z6, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        if (z6) {
            if (this.tempMethodRVPA == null) {
                TempParamAnnotation tempParamAnnotation = new TempParamAnnotation(this.numMethodArgs);
                this.tempMethodRVPA = tempParamAnnotation;
                tempParamAnnotation.addParameterAnnotation(i5, str, list, list2, list3, list4, list5, list6, list7);
            }
            List list8 = this.tempMethodFlags;
            this.tempMethodFlags.add(Long.valueOf(((Long) list8.remove(list8.size() - 1)).longValue() | 8388608));
            return;
        }
        if (this.tempMethodRIPA == null) {
            TempParamAnnotation tempParamAnnotation2 = new TempParamAnnotation(this.numMethodArgs);
            this.tempMethodRIPA = tempParamAnnotation2;
            tempParamAnnotation2.addParameterAnnotation(i5, str, list, list2, list3, list4, list5, list6, list7);
        }
        List list9 = this.tempMethodFlags;
        this.tempMethodFlags.add(Long.valueOf(((Long) list9.remove(list9.size() - 1)).longValue() | 16777216));
    }

    public void addSourceFile(String str) {
        String string = this.class_this[this.index].toString();
        if (string.indexOf(36) != -1) {
            string = string.substring(0, string.indexOf(36));
        }
        if (str.equals(string.substring(string.lastIndexOf(47) + 1) + ".java")) {
            this.classSourceFile.add(null);
        } else {
            this.classSourceFile.add(this.cpBands.getCPUtf8(str));
        }
        long[] jArr = this.class_flags;
        int i5 = this.index;
        jArr[i5] = jArr[i5] | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
    }

    public void currentClassReferencesInnerClass(CPClass cPClass) {
        CPClass cPClass2;
        int i5 = this.index;
        CPClass[] cPClassArr = this.class_this;
        if (i5 >= cPClassArr.length || (cPClass2 = cPClassArr[i5]) == null || cPClass2.equals(cPClass) || isInnerClassOf(cPClass2.toString(), cPClass)) {
            return;
        }
        Set hashSet = (Set) this.classReferencesInnerClass.get(cPClass2);
        if (hashSet == null) {
            hashSet = new HashSet();
            this.classReferencesInnerClass.put(cPClass2, hashSet);
        }
        hashSet.add(cPClass);
    }

    public void doBciRenumbering(IntList intList, Map map) {
        renumberBci(this.codeLineNumberTableBciP, intList, map);
        renumberBci(this.codeLocalVariableTableBciP, intList, map);
        renumberOffsetBci(this.codeLocalVariableTableBciP, this.codeLocalVariableTableSpanO, intList, map);
        renumberBci(this.codeLocalVariableTypeTableBciP, intList, map);
        renumberOffsetBci(this.codeLocalVariableTypeTableBciP, this.codeLocalVariableTypeTableSpanO, intList, map);
        renumberBci(this.codeHandlerStartP, intList, map);
        renumberOffsetBci(this.codeHandlerStartP, this.codeHandlerEndPO, intList, map);
        renumberDoubleOffsetBci(this.codeHandlerStartP, this.codeHandlerEndPO, this.codeHandlerCatchPO, intList, map);
        Iterator it = this.classAttributeBands.iterator();
        while (it.hasNext()) {
            ((NewAttributeBands) it.next()).renumberBci(intList, map);
        }
        Iterator it2 = this.methodAttributeBands.iterator();
        while (it2.hasNext()) {
            ((NewAttributeBands) it2.next()).renumberBci(intList, map);
        }
        Iterator it3 = this.fieldAttributeBands.iterator();
        while (it3.hasNext()) {
            ((NewAttributeBands) it3.next()).renumberBci(intList, map);
        }
        Iterator it4 = this.codeAttributeBands.iterator();
        while (it4.hasNext()) {
            ((NewAttributeBands) it4.next()).renumberBci(intList, map);
        }
    }

    public void endOfClass() {
        int size = this.tempFieldDesc.size();
        int[] iArr = this.class_field_count;
        int i5 = this.index;
        iArr[i5] = size;
        this.field_descr[i5] = new CPNameAndType[size];
        this.field_flags[i5] = new long[size];
        for (int i6 = 0; i6 < size; i6++) {
            this.field_descr[this.index][i6] = (CPNameAndType) this.tempFieldDesc.get(i6);
            this.field_flags[this.index][i6] = ((Long) this.tempFieldFlags.get(i6)).longValue();
        }
        int size2 = this.tempMethodDesc.size();
        int[] iArr2 = this.class_method_count;
        int i7 = this.index;
        iArr2[i7] = size2;
        this.method_descr[i7] = new CPNameAndType[size2];
        this.method_flags[i7] = new long[size2];
        for (int i8 = 0; i8 < size2; i8++) {
            this.method_descr[this.index][i8] = (CPNameAndType) this.tempMethodDesc.get(i8);
            this.method_flags[this.index][i8] = ((Long) this.tempMethodFlags.get(i8)).longValue();
        }
        this.tempFieldDesc.clear();
        this.tempFieldFlags.clear();
        this.tempMethodDesc.clear();
        this.tempMethodFlags.clear();
        this.index++;
    }

    public void endOfMethod() {
        TempParamAnnotation tempParamAnnotation = this.tempMethodRVPA;
        if (tempParamAnnotation != null) {
            this.method_RVPA_bands.addParameterAnnotation(tempParamAnnotation.numParams, tempParamAnnotation.annoN, tempParamAnnotation.pairN, tempParamAnnotation.typeRS, tempParamAnnotation.nameRU, tempParamAnnotation.f6710t, tempParamAnnotation.values, tempParamAnnotation.caseArrayN, tempParamAnnotation.nestTypeRS, tempParamAnnotation.nestNameRU, tempParamAnnotation.nestPairN);
            this.tempMethodRVPA = null;
        }
        TempParamAnnotation tempParamAnnotation2 = this.tempMethodRIPA;
        if (tempParamAnnotation2 != null) {
            this.method_RIPA_bands.addParameterAnnotation(tempParamAnnotation2.numParams, tempParamAnnotation2.annoN, tempParamAnnotation2.pairN, tempParamAnnotation2.typeRS, tempParamAnnotation2.nameRU, tempParamAnnotation2.f6710t, tempParamAnnotation2.values, tempParamAnnotation2.caseArrayN, tempParamAnnotation2.nestTypeRS, tempParamAnnotation2.nestNameRU, tempParamAnnotation2.nestPairN);
            this.tempMethodRIPA = null;
        }
        if (this.codeFlags.size() > 0) {
            long jLongValue = ((Long) AbstractC0157z.f(1, this.codeFlags)).longValue();
            IntList intList = this.codeLocalVariableTableN;
            int i5 = intList.get(intList.size() - 1);
            if (jLongValue == 4 && i5 == 0) {
                IntList intList2 = this.codeLocalVariableTableN;
                intList2.remove(intList2.size() - 1);
                a.w(1, this.codeFlags);
                this.codeFlags.add(0);
            }
        }
    }

    public void finaliseBands() {
        int i5;
        int defaultMajorVersion = this.segmentHeader.getDefaultMajorVersion();
        int i6 = 0;
        while (true) {
            long[] jArr = this.class_flags;
            if (i6 >= jArr.length) {
                break;
            }
            int i7 = this.major_versions[i6];
            if (i7 != defaultMajorVersion) {
                jArr[i6] = jArr[i6] | 16777216;
                this.classFileVersionMajor.add(i7);
                this.classFileVersionMinor.add(0);
            }
            i6++;
        }
        this.codeHeaders = new int[this.codeHandlerCount.size()];
        int i8 = 0;
        for (int i9 = 0; i9 < this.codeHeaders.length; i9++) {
            int i10 = i9 - i8;
            int i11 = this.codeHandlerCount.get(i10);
            int i12 = this.codeMaxLocals.get(i10);
            int i13 = this.codeMaxStack.get(i10);
            if (i11 == 0) {
                int i14 = (i12 * 12) + i13 + 1;
                if (i14 < 145 && i13 < 12) {
                    this.codeHeaders[i9] = i14;
                }
            } else if (i11 == 1) {
                int i15 = (i12 * 8) + i13 + 145;
                if (i15 < 209 && i13 < 8) {
                    this.codeHeaders[i9] = i15;
                }
            } else if (i11 == 2 && (i5 = (i12 * 7) + i13 + 209) < 256 && i13 < 7) {
                this.codeHeaders[i9] = i5;
            }
            if (this.codeHeaders[i9] != 0) {
                this.codeHandlerCount.remove(i10);
                this.codeMaxLocals.remove(i10);
                this.codeMaxStack.remove(i10);
                i8++;
            } else if (!this.segment.getSegmentHeader().have_all_code_flags()) {
                this.codeFlags.add(0L);
            }
        }
        IntList intList = new IntList();
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        while (true) {
            CPClass[] cPClassArr = this.class_this;
            if (i16 >= cPClassArr.length) {
                break;
            }
            CPClass cPClass = cPClassArr[i16];
            Set set = (Set) this.classReferencesInnerClass.get(cPClass);
            if (set != null) {
                List innerClassesForOuter = this.segment.getIcBands().getInnerClassesForOuter(cPClass.toString());
                if (innerClassesForOuter != null) {
                    Iterator it = innerClassesForOuter.iterator();
                    while (it.hasNext()) {
                        set.remove(((IcBands.IcTuple) it.next()).f6711C);
                    }
                }
                Iterator it2 = set.iterator();
                int i17 = 0;
                while (it2.hasNext()) {
                    IcBands.IcTuple icTuple = this.segment.getIcBands().getIcTuple((CPClass) it2.next());
                    if (icTuple != null && !icTuple.isAnonymous()) {
                        arrayList.add(icTuple);
                        i17++;
                    }
                }
                if (i17 != 0) {
                    intList.add(i17);
                    long[] jArr2 = this.class_flags;
                    jArr2[i16] = jArr2[i16] | 8388608;
                }
            }
            i16++;
        }
        this.class_InnerClasses_N = intList.toArray();
        this.class_InnerClasses_RC = new CPClass[arrayList.size()];
        this.class_InnerClasses_F = new int[arrayList.size()];
        this.classInnerClassesOuterRCN = new ArrayList();
        this.classInnerClassesNameRUN = new ArrayList();
        for (int i18 = 0; i18 < this.class_InnerClasses_RC.length; i18++) {
            IcBands.IcTuple icTuple2 = (IcBands.IcTuple) arrayList.get(i18);
            this.class_InnerClasses_RC[i18] = icTuple2.f6711C;
            CPClass cPClass2 = icTuple2.f6712C2;
            if (cPClass2 == null && icTuple2.f6714N == null) {
                this.class_InnerClasses_F[i18] = 0;
            } else {
                int i19 = icTuple2.f6713F;
                if (i19 == 0) {
                    this.class_InnerClasses_F[i18] = 65536;
                } else {
                    this.class_InnerClasses_F[i18] = i19;
                }
                this.classInnerClassesOuterRCN.add(cPClass2);
                this.classInnerClassesNameRUN.add(icTuple2.f6714N);
            }
        }
        IntList intList2 = new IntList();
        IntList intList3 = new IntList();
        IntList intList4 = new IntList();
        IntList intList5 = new IntList();
        if (this.class_RVA_bands.hasContent()) {
            intList2.add(this.class_RVA_bands.numBackwardsCalls());
        }
        if (this.class_RIA_bands.hasContent()) {
            intList2.add(this.class_RIA_bands.numBackwardsCalls());
        }
        if (this.field_RVA_bands.hasContent()) {
            intList3.add(this.field_RVA_bands.numBackwardsCalls());
        }
        if (this.field_RIA_bands.hasContent()) {
            intList3.add(this.field_RIA_bands.numBackwardsCalls());
        }
        if (this.method_RVA_bands.hasContent()) {
            intList4.add(this.method_RVA_bands.numBackwardsCalls());
        }
        if (this.method_RIA_bands.hasContent()) {
            intList4.add(this.method_RIA_bands.numBackwardsCalls());
        }
        if (this.method_RVPA_bands.hasContent()) {
            intList4.add(this.method_RVPA_bands.numBackwardsCalls());
        }
        if (this.method_RIPA_bands.hasContent()) {
            intList4.add(this.method_RIPA_bands.numBackwardsCalls());
        }
        if (this.method_AD_bands.hasContent()) {
            intList4.add(this.method_AD_bands.numBackwardsCalls());
        }
        I4.a aVar = new I4.a(17);
        Collections.sort(this.classAttributeBands, aVar);
        Collections.sort(this.methodAttributeBands, aVar);
        Collections.sort(this.fieldAttributeBands, aVar);
        Collections.sort(this.codeAttributeBands, aVar);
        for (NewAttributeBands newAttributeBands : this.classAttributeBands) {
            if (newAttributeBands.isUsedAtLeastOnce()) {
                for (int i20 : newAttributeBands.numBackwardsCalls()) {
                    intList2.add(i20);
                }
            }
        }
        for (NewAttributeBands newAttributeBands2 : this.methodAttributeBands) {
            if (newAttributeBands2.isUsedAtLeastOnce()) {
                for (int i21 : newAttributeBands2.numBackwardsCalls()) {
                    intList4.add(i21);
                }
            }
        }
        for (NewAttributeBands newAttributeBands3 : this.fieldAttributeBands) {
            if (newAttributeBands3.isUsedAtLeastOnce()) {
                for (int i22 : newAttributeBands3.numBackwardsCalls()) {
                    intList3.add(i22);
                }
            }
        }
        for (NewAttributeBands newAttributeBands4 : this.codeAttributeBands) {
            if (newAttributeBands4.isUsedAtLeastOnce()) {
                for (int i23 : newAttributeBands4.numBackwardsCalls()) {
                    intList5.add(i23);
                }
            }
        }
        this.class_attr_calls = intList2.toArray();
        this.field_attr_calls = intList3.toArray();
        this.method_attr_calls = intList4.toArray();
        this.code_attr_calls = intList5.toArray();
    }

    public boolean isAnySyntheticClasses() {
        return this.anySyntheticClasses;
    }

    public boolean isAnySyntheticFields() {
        return this.anySyntheticFields;
    }

    public boolean isAnySyntheticMethods() {
        return this.anySyntheticMethods;
    }

    public int numClassesProcessed() {
        return this.index;
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) throws IOException {
        PackingUtils.log("Writing class bands...");
        int[] ints = getInts(this.class_this);
        BHSDCodec bHSDCodec = Codec.DELTA5;
        byte[] bArrEncodeBandInt = encodeBandInt("class_this", ints, bHSDCodec);
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI.append(bArrEncodeBandInt.length);
        sbI.append(" bytes from class_this[");
        AbstractC1125a.m("]", this.class_this.length, sbI);
        byte[] bArrEncodeBandInt2 = encodeBandInt("class_super", getInts(this.class_super), bHSDCodec);
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote ");
        sbI2.append(bArrEncodeBandInt2.length);
        sbI2.append(" bytes from class_super[");
        AbstractC1125a.m("]", this.class_super.length, sbI2);
        byte[] bArrEncodeBandInt3 = encodeBandInt("class_interface_count", this.class_interface_count, bHSDCodec);
        StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt3, "Wrote ");
        sbI3.append(bArrEncodeBandInt3.length);
        sbI3.append(" bytes from class_interface_count[");
        AbstractC1125a.m("]", this.class_interface_count.length, sbI3);
        int iSum = sum(this.class_interface_count);
        int[] iArr = new int[iSum];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            CPClass[][] cPClassArr = this.class_interface;
            if (i5 >= cPClassArr.length) {
                break;
            }
            if (cPClassArr[i5] != null) {
                int i7 = 0;
                while (true) {
                    CPClass[] cPClassArr2 = this.class_interface[i5];
                    if (i7 < cPClassArr2.length) {
                        iArr[i6] = cPClassArr2[i7].getIndex();
                        i6++;
                        i7++;
                    }
                }
            }
            i5++;
        }
        BHSDCodec bHSDCodec2 = Codec.DELTA5;
        byte[] bArrEncodeBandInt4 = encodeBandInt("class_interface", iArr, bHSDCodec2);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt4, "Wrote "), bArrEncodeBandInt4.length, " bytes from class_interface[", iSum, "]");
        byte[] bArrEncodeBandInt5 = encodeBandInt("class_field_count", this.class_field_count, bHSDCodec2);
        StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt5, "Wrote ");
        sbI4.append(bArrEncodeBandInt5.length);
        sbI4.append(" bytes from class_field_count[");
        AbstractC1125a.m("]", this.class_field_count.length, sbI4);
        byte[] bArrEncodeBandInt6 = encodeBandInt("class_method_count", this.class_method_count, bHSDCodec2);
        StringBuilder sbI5 = AbstractC1125a.i(outputStream, bArrEncodeBandInt6, "Wrote ");
        sbI5.append(bArrEncodeBandInt6.length);
        sbI5.append(" bytes from class_method_count[");
        AbstractC1125a.m("]", this.class_method_count.length, sbI5);
        int iSum2 = sum(this.class_field_count);
        int[] iArr2 = new int[iSum2];
        int i8 = 0;
        for (int i9 = 0; i9 < this.index; i9++) {
            int i10 = 0;
            while (true) {
                CPNameAndType[] cPNameAndTypeArr = this.field_descr[i9];
                if (i10 < cPNameAndTypeArr.length) {
                    iArr2[i8] = cPNameAndTypeArr[i10].getIndex();
                    i8++;
                    i10++;
                }
            }
        }
        byte[] bArrEncodeBandInt7 = encodeBandInt("field_descr", iArr2, Codec.DELTA5);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt7, "Wrote "), bArrEncodeBandInt7.length, " bytes from field_descr[", iSum2, "]");
        writeFieldAttributeBands(outputStream);
        int iSum3 = sum(this.class_method_count);
        int[] iArr3 = new int[iSum3];
        int i11 = 0;
        for (int i12 = 0; i12 < this.index; i12++) {
            int i13 = 0;
            while (true) {
                CPNameAndType[] cPNameAndTypeArr2 = this.method_descr[i12];
                if (i13 < cPNameAndTypeArr2.length) {
                    iArr3[i11] = cPNameAndTypeArr2[i13].getIndex();
                    i11++;
                    i13++;
                }
            }
        }
        byte[] bArrEncodeBandInt8 = encodeBandInt("method_descr", iArr3, Codec.MDELTA5);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt8, "Wrote "), bArrEncodeBandInt8.length, " bytes from method_descr[", iSum3, "]");
        writeMethodAttributeBands(outputStream);
        writeClassAttributeBands(outputStream);
        writeCodeBands(outputStream);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x01fb  */
    public void removeCurrentClass() {
        long j6;
        long j7 = this.class_flags[this.index];
        long j8 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        long j9 = j7 & PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        long j10 = 0;
        int i5 = 1;
        if (j9 != 0) {
            a.w(1, this.classSourceFile);
        }
        if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
            a.w(1, this.classEnclosingMethodClass);
            a.w(1, this.classEnclosingMethodDesc);
        }
        if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
            a.w(1, this.classSignature);
        }
        if ((this.class_flags[this.index] & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
            this.class_RVA_bands.removeLatest();
        }
        if ((this.class_flags[this.index] & 4194304) != 0) {
            this.class_RIA_bands.removeLatest();
        }
        Iterator it = this.tempFieldFlags.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if ((jLongValue & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                a.w(1, this.fieldSignature);
            }
            if ((jLongValue & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
                a.w(1, this.fieldConstantValueKQ);
            }
            if ((jLongValue & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
                this.field_RVA_bands.removeLatest();
            }
            if ((jLongValue & 4194304) != 0) {
                this.field_RIA_bands.removeLatest();
            }
        }
        Iterator it2 = this.tempMethodFlags.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            long jLongValue2 = ((Long) it2.next()).longValue();
            if ((jLongValue2 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != j10) {
                a.w(i5, this.methodSignature);
            }
            if ((jLongValue2 & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != j10) {
                IntList intList = this.methodExceptionNumber;
                int iRemove = intList.remove(intList.size() - i5);
                int i6 = 0;
                while (i6 < iRemove) {
                    int i7 = i5;
                    List list = this.methodExceptionClasses;
                    list.remove(list.size() - 1);
                    i6++;
                    i5 = i7;
                    j8 = j8;
                }
            }
            int i8 = i5;
            long j11 = j8;
            if ((jLongValue2 & j11) != j10) {
                IntList intList2 = this.codeMaxLocals;
                intList2.remove(intList2.size() - 1);
                IntList intList3 = this.codeMaxStack;
                intList3.remove(intList3.size() - 1);
                IntList intList4 = this.codeHandlerCount;
                int iRemove2 = intList4.remove(intList4.size() - 1);
                for (int i9 = 0; i9 < iRemove2; i9++) {
                    int size = this.codeHandlerStartP.size() - 1;
                    this.codeHandlerStartP.remove(size);
                    this.codeHandlerEndPO.remove(size);
                    this.codeHandlerCatchPO.remove(size);
                    this.codeHandlerClass.remove(size);
                }
                if (this.stripDebug) {
                    j6 = j10;
                } else {
                    List list2 = this.codeFlags;
                    long jLongValue3 = ((Long) list2.remove(list2.size() - 1)).longValue();
                    IntList intList5 = this.codeLocalVariableTableN;
                    int iRemove3 = intList5.remove(intList5.size() - 1);
                    int i10 = 0;
                    while (i10 < iRemove3) {
                        int size2 = this.codeLocalVariableTableBciP.size() - 1;
                        this.codeLocalVariableTableBciP.remove(size2);
                        this.codeLocalVariableTableSpanO.remove(size2);
                        this.codeLocalVariableTableNameRU.remove(size2);
                        this.codeLocalVariableTableTypeRS.remove(size2);
                        this.codeLocalVariableTableSlot.remove(size2);
                        i10++;
                        j10 = j10;
                    }
                    j6 = j10;
                    if ((8 & jLongValue3) != j6) {
                        IntList intList6 = this.codeLocalVariableTypeTableN;
                        int iRemove4 = intList6.remove(intList6.size() - 1);
                        for (int i11 = 0; i11 < iRemove4; i11++) {
                            int size3 = this.codeLocalVariableTypeTableBciP.size() - 1;
                            this.codeLocalVariableTypeTableBciP.remove(size3);
                            this.codeLocalVariableTypeTableSpanO.remove(size3);
                            this.codeLocalVariableTypeTableNameRU.remove(size3);
                            this.codeLocalVariableTypeTableTypeRS.remove(size3);
                            this.codeLocalVariableTypeTableSlot.remove(size3);
                        }
                    }
                    if ((jLongValue3 & 2) != j6) {
                        IntList intList7 = this.codeLineNumberTableN;
                        int iRemove5 = intList7.remove(intList7.size() - 1);
                        for (int i12 = 0; i12 < iRemove5; i12++) {
                            int size4 = this.codeLineNumberTableBciP.size() - 1;
                            this.codeLineNumberTableBciP.remove(size4);
                            this.codeLineNumberTableLine.remove(size4);
                        }
                    }
                }
            } else {
                j6 = j10;
            }
            if ((jLongValue2 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != j6) {
                this.method_RVA_bands.removeLatest();
            }
            if ((jLongValue2 & 4194304) != j6) {
                this.method_RIA_bands.removeLatest();
            }
            if ((jLongValue2 & 8388608) != j6) {
                this.method_RVPA_bands.removeLatest();
            }
            if ((jLongValue2 & 16777216) != j6) {
                this.method_RIPA_bands.removeLatest();
            }
            if ((jLongValue2 & 33554432) != j6) {
                this.method_AD_bands.removeLatest();
            }
            i5 = i8;
            j8 = j11;
            j10 = j6;
        }
        CPClass[] cPClassArr = this.class_this;
        int i13 = this.index;
        cPClassArr[i13] = null;
        this.class_super[i13] = null;
        this.class_interface_count[i13] = 0;
        this.class_interface[i13] = null;
        this.major_versions[i13] = 0;
        this.class_flags[i13] = j10;
        this.tempFieldDesc.clear();
        this.tempFieldFlags.clear();
        this.tempMethodDesc.clear();
        this.tempMethodFlags.clear();
        int i14 = this.index;
        if (i14 > 0) {
            this.index = i14 - 1;
        }
    }
}
