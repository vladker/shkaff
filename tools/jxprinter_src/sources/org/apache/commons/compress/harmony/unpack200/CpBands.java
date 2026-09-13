package org.apache.commons.compress.harmony.unpack200;

import A3.AbstractC0157z;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CpBands extends BandSet {
    private int classOffset;
    private String[] cpClass;
    private int[] cpClassInts;
    private String[] cpDescriptor;
    private int[] cpDescriptorNameInts;
    private int[] cpDescriptorTypeInts;
    private double[] cpDouble;
    private String[] cpFieldClass;
    private int[] cpFieldClassInts;
    private String[] cpFieldDescriptor;
    private int[] cpFieldDescriptorInts;
    private float[] cpFloat;
    private String[] cpIMethodClass;
    private int[] cpIMethodClassInts;
    private String[] cpIMethodDescriptor;
    private int[] cpIMethodDescriptorInts;
    private int[] cpInt;
    private long[] cpLong;
    private String[] cpMethodClass;
    private int[] cpMethodClassInts;
    private String[] cpMethodDescriptor;
    private int[] cpMethodDescriptorInts;
    private String[] cpSignature;
    private int[] cpSignatureInts;
    private String[] cpString;
    private int[] cpStringInts;
    private String[] cpUTF8;
    private int descrOffset;
    private final Map descriptorsToCPNameAndTypes;
    private int doubleOffset;
    private final Map doublesToCPDoubles;
    private int fieldOffset;
    private int floatOffset;
    private final Map floatsToCPFloats;
    private int imethodOffset;
    private int intOffset;
    private final Map integersToCPIntegers;
    private int longOffset;
    private final Map longsToCPLongs;
    private Map mapClass;
    private Map mapDescriptor;
    private Map mapSignature;
    private Map mapUTF8;
    private int methodOffset;
    private final SegmentConstantPool pool;
    private int signatureOffset;
    private int stringOffset;
    private final Map stringsToCPClass;
    private final Map stringsToCPStrings;
    private final Map stringsToCPUTF8;

    public CpBands(Segment segment) {
        super(segment);
        this.pool = new SegmentConstantPool(this);
        this.stringsToCPUTF8 = new HashMap();
        this.stringsToCPStrings = new HashMap();
        this.longsToCPLongs = new HashMap();
        this.integersToCPIntegers = new HashMap();
        this.floatsToCPFloats = new HashMap();
        this.stringsToCPClass = new HashMap();
        this.doublesToCPDoubles = new HashMap();
        this.descriptorsToCPNameAndTypes = new HashMap();
    }

    private void parseCpClass(InputStream inputStream) {
        int cpClassCount = this.header.getCpClassCount();
        this.cpClassInts = decodeBandInt("cp_Class", inputStream, Codec.UDELTA5, cpClassCount);
        this.cpClass = new String[cpClassCount];
        this.mapClass = new HashMap(cpClassCount);
        for (int i5 = 0; i5 < cpClassCount; i5++) {
            String[] strArr = this.cpClass;
            String str = this.cpUTF8[this.cpClassInts[i5]];
            strArr[i5] = str;
            this.mapClass.put(str, Integer.valueOf(i5));
        }
    }

    private void parseCpDescriptor(InputStream inputStream) {
        int cpDescriptorCount = this.header.getCpDescriptorCount();
        this.cpDescriptorNameInts = decodeBandInt("cp_Descr_name", inputStream, Codec.DELTA5, cpDescriptorCount);
        this.cpDescriptorTypeInts = decodeBandInt("cp_Descr_type", inputStream, Codec.UDELTA5, cpDescriptorCount);
        String[] references = getReferences(this.cpDescriptorNameInts, this.cpUTF8);
        String[] references2 = getReferences(this.cpDescriptorTypeInts, this.cpSignature);
        this.cpDescriptor = new String[cpDescriptorCount];
        this.mapDescriptor = new HashMap(cpDescriptorCount);
        for (int i5 = 0; i5 < cpDescriptorCount; i5++) {
            this.cpDescriptor[i5] = references[i5] + ParameterizedMessage.ERROR_MSG_SEPARATOR + references2[i5];
            this.mapDescriptor.put(this.cpDescriptor[i5], Integer.valueOf(i5));
        }
    }

    private void parseCpDouble(InputStream inputStream) {
        long[] flags = parseFlags("cp_Double", inputStream, this.header.getCpDoubleCount(), Codec.UDELTA5, Codec.DELTA5);
        this.cpDouble = new double[flags.length];
        for (int i5 = 0; i5 < flags.length; i5++) {
            this.cpDouble[i5] = Double.longBitsToDouble(flags[i5]);
        }
    }

    private void parseCpField(InputStream inputStream) {
        int cpFieldCount = this.header.getCpFieldCount();
        this.cpFieldClassInts = decodeBandInt("cp_Field_class", inputStream, Codec.DELTA5, cpFieldCount);
        this.cpFieldDescriptorInts = decodeBandInt("cp_Field_desc", inputStream, Codec.UDELTA5, cpFieldCount);
        this.cpFieldClass = new String[cpFieldCount];
        this.cpFieldDescriptor = new String[cpFieldCount];
        for (int i5 = 0; i5 < cpFieldCount; i5++) {
            this.cpFieldClass[i5] = this.cpClass[this.cpFieldClassInts[i5]];
            this.cpFieldDescriptor[i5] = this.cpDescriptor[this.cpFieldDescriptorInts[i5]];
        }
    }

    private void parseCpFloat(InputStream inputStream) {
        int cpFloatCount = this.header.getCpFloatCount();
        this.cpFloat = new float[cpFloatCount];
        int[] iArrDecodeBandInt = decodeBandInt("cp_Float", inputStream, Codec.UDELTA5, cpFloatCount);
        for (int i5 = 0; i5 < cpFloatCount; i5++) {
            this.cpFloat[i5] = Float.intBitsToFloat(iArrDecodeBandInt[i5]);
        }
    }

    private void parseCpIMethod(InputStream inputStream) {
        int cpIMethodCount = this.header.getCpIMethodCount();
        this.cpIMethodClassInts = decodeBandInt("cp_Imethod_class", inputStream, Codec.DELTA5, cpIMethodCount);
        this.cpIMethodDescriptorInts = decodeBandInt("cp_Imethod_desc", inputStream, Codec.UDELTA5, cpIMethodCount);
        this.cpIMethodClass = new String[cpIMethodCount];
        this.cpIMethodDescriptor = new String[cpIMethodCount];
        for (int i5 = 0; i5 < cpIMethodCount; i5++) {
            this.cpIMethodClass[i5] = this.cpClass[this.cpIMethodClassInts[i5]];
            this.cpIMethodDescriptor[i5] = this.cpDescriptor[this.cpIMethodDescriptorInts[i5]];
        }
    }

    private void parseCpInt(InputStream inputStream) {
        this.cpInt = decodeBandInt("cpInt", inputStream, Codec.UDELTA5, this.header.getCpIntCount());
    }

    private void parseCpLong(InputStream inputStream) {
        this.cpLong = parseFlags("cp_Long", inputStream, this.header.getCpLongCount(), Codec.UDELTA5, Codec.DELTA5);
    }

    private void parseCpMethod(InputStream inputStream) {
        int cpMethodCount = this.header.getCpMethodCount();
        this.cpMethodClassInts = decodeBandInt("cp_Method_class", inputStream, Codec.DELTA5, cpMethodCount);
        this.cpMethodDescriptorInts = decodeBandInt("cp_Method_desc", inputStream, Codec.UDELTA5, cpMethodCount);
        this.cpMethodClass = new String[cpMethodCount];
        this.cpMethodDescriptor = new String[cpMethodCount];
        for (int i5 = 0; i5 < cpMethodCount; i5++) {
            this.cpMethodClass[i5] = this.cpClass[this.cpMethodClassInts[i5]];
            this.cpMethodDescriptor[i5] = this.cpDescriptor[this.cpMethodDescriptorInts[i5]];
        }
    }

    private void parseCpSignature(InputStream inputStream) {
        int cpSignatureCount = this.header.getCpSignatureCount();
        int[] iArrDecodeBandInt = decodeBandInt("cp_Signature_form", inputStream, Codec.DELTA5, cpSignatureCount);
        this.cpSignatureInts = iArrDecodeBandInt;
        String[] references = getReferences(iArrDecodeBandInt, this.cpUTF8);
        this.cpSignature = new String[cpSignatureCount];
        this.mapSignature = new HashMap();
        int i5 = 0;
        for (int i6 = 0; i6 < cpSignatureCount; i6++) {
            for (char c : references[i6].toCharArray()) {
                if (c == 'L') {
                    this.cpSignatureInts[i6] = -1;
                    i5++;
                }
            }
        }
        String[] references2 = parseReferences("cp_Signature_classes", inputStream, Codec.UDELTA5, i5, this.cpClass);
        int i7 = 0;
        for (int i8 = 0; i8 < cpSignatureCount; i8++) {
            String str = references[i8];
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(64);
            ArrayList arrayList = new ArrayList();
            for (int i9 = 0; i9 < length; i9++) {
                char cCharAt = str.charAt(i9);
                stringBuffer.append(cCharAt);
                if (cCharAt == 'L') {
                    String str2 = references2[i7];
                    arrayList.add(str2);
                    stringBuffer.append(str2);
                    i7++;
                }
            }
            this.cpSignature[i8] = stringBuffer.toString();
            this.mapSignature.put(stringBuffer.toString(), Integer.valueOf(i8));
        }
    }

    private void parseCpString(InputStream inputStream) {
        int cpStringCount = this.header.getCpStringCount();
        this.cpStringInts = decodeBandInt("cp_String", inputStream, Codec.UDELTA5, cpStringCount);
        this.cpString = new String[cpStringCount];
        for (int i5 = 0; i5 < cpStringCount; i5++) {
            this.cpString[i5] = this.cpUTF8[this.cpStringInts[i5]];
        }
    }

    private void parseCpUtf8(InputStream inputStream) {
        int cpUTF8Count = this.header.getCpUTF8Count();
        this.cpUTF8 = new String[cpUTF8Count];
        HashMap map = new HashMap(cpUTF8Count + 1);
        this.mapUTF8 = map;
        this.cpUTF8[0] = "";
        map.put("", 0);
        int[] iArrDecodeBandInt = decodeBandInt("cpUTF8Prefix", inputStream, Codec.DELTA5, cpUTF8Count - 2);
        int[] iArrDecodeBandInt2 = decodeBandInt("cpUTF8Suffix", inputStream, Codec.UNSIGNED5, cpUTF8Count - 1);
        int i5 = 0;
        int i6 = 0;
        for (int i7 : iArrDecodeBandInt2) {
            if (i7 == 0) {
                i6++;
            } else {
                i5 += i7;
            }
        }
        char[] cArr = new char[i5];
        int[] iArrDecodeBandInt3 = decodeBandInt("cp_Utf8_chars", inputStream, Codec.CHAR3, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            cArr[i8] = (char) iArrDecodeBandInt3[i8];
        }
        int[] iArrDecodeBandInt4 = decodeBandInt("cp_Utf8_big_suffix", inputStream, Codec.DELTA5, i6);
        int[][] iArr = new int[i6][];
        for (int i9 = 0; i9 < i6; i9++) {
            iArr[i9] = decodeBandInt(AbstractC0157z.k(i9, "cp_Utf8_big_chars "), inputStream, Codec.DELTA5, iArrDecodeBandInt4[i9]);
        }
        char[][] cArr2 = new char[i6][];
        for (int i10 = 0; i10 < i6; i10++) {
            cArr2[i10] = new char[iArr[i10].length];
            int i11 = 0;
            while (true) {
                int[] iArr2 = iArr[i10];
                if (i11 < iArr2.length) {
                    cArr2[i10][i11] = (char) iArr2[i11];
                    i11++;
                }
            }
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        while (i14 < cpUTF8Count) {
            String[] strArr = this.cpUTF8;
            int i15 = i14 - 1;
            String str = strArr[i15];
            if (iArrDecodeBandInt2[i15] == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, i14 > 1 ? iArrDecodeBandInt[i14 - 2] : 0));
                sb.append(new String(cArr2[i13]));
                strArr[i14] = sb.toString();
                this.mapUTF8.put(this.cpUTF8[i14], Integer.valueOf(i14));
                i13++;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str.substring(0, i14 > 1 ? iArrDecodeBandInt[i14 - 2] : 0));
                sb2.append(new String(cArr, i12, iArrDecodeBandInt2[i15]));
                strArr[i14] = sb2.toString();
                i12 += iArrDecodeBandInt2[i15];
                this.mapUTF8.put(this.cpUTF8[i14], Integer.valueOf(i14));
            }
            i14++;
        }
    }

    public CPClass cpClassValue(int i5) {
        String str = this.cpClass[i5];
        int i6 = this.cpClassInts[i5];
        int i7 = this.classOffset + i5;
        CPClass cPClass = (CPClass) this.stringsToCPClass.get(str);
        if (cPClass != null) {
            return cPClass;
        }
        CPClass cPClass2 = new CPClass(cpUTF8Value(i6), i7);
        this.stringsToCPClass.put(str, cPClass2);
        return cPClass2;
    }

    public CPDouble cpDoubleValue(int i5) {
        Double dValueOf = Double.valueOf(this.cpDouble[i5]);
        CPDouble cPDouble = (CPDouble) this.doublesToCPDoubles.get(dValueOf);
        if (cPDouble != null) {
            return cPDouble;
        }
        CPDouble cPDouble2 = new CPDouble(dValueOf, i5 + this.doubleOffset);
        this.doublesToCPDoubles.put(dValueOf, cPDouble2);
        return cPDouble2;
    }

    public CPFieldRef cpFieldValue(int i5) {
        return new CPFieldRef(cpClassValue(this.cpFieldClassInts[i5]), cpNameAndTypeValue(this.cpFieldDescriptorInts[i5]), i5 + this.fieldOffset);
    }

    public CPFloat cpFloatValue(int i5) {
        Float fValueOf = Float.valueOf(this.cpFloat[i5]);
        CPFloat cPFloat = (CPFloat) this.floatsToCPFloats.get(fValueOf);
        if (cPFloat != null) {
            return cPFloat;
        }
        CPFloat cPFloat2 = new CPFloat(fValueOf, i5 + this.floatOffset);
        this.floatsToCPFloats.put(fValueOf, cPFloat2);
        return cPFloat2;
    }

    public CPInterfaceMethodRef cpIMethodValue(int i5) {
        return new CPInterfaceMethodRef(cpClassValue(this.cpIMethodClassInts[i5]), cpNameAndTypeValue(this.cpIMethodDescriptorInts[i5]), i5 + this.imethodOffset);
    }

    public CPInteger cpIntegerValue(int i5) {
        Integer numValueOf = Integer.valueOf(this.cpInt[i5]);
        CPInteger cPInteger = (CPInteger) this.integersToCPIntegers.get(numValueOf);
        if (cPInteger != null) {
            return cPInteger;
        }
        CPInteger cPInteger2 = new CPInteger(numValueOf, i5 + this.intOffset);
        this.integersToCPIntegers.put(numValueOf, cPInteger2);
        return cPInteger2;
    }

    public CPLong cpLongValue(int i5) {
        Long lValueOf = Long.valueOf(this.cpLong[i5]);
        CPLong cPLong = (CPLong) this.longsToCPLongs.get(lValueOf);
        if (cPLong != null) {
            return cPLong;
        }
        CPLong cPLong2 = new CPLong(lValueOf, i5 + this.longOffset);
        this.longsToCPLongs.put(lValueOf, cPLong2);
        return cPLong2;
    }

    public CPMethodRef cpMethodValue(int i5) {
        return new CPMethodRef(cpClassValue(this.cpMethodClassInts[i5]), cpNameAndTypeValue(this.cpMethodDescriptorInts[i5]), i5 + this.methodOffset);
    }

    public CPNameAndType cpNameAndTypeValue(int i5) {
        String str = this.cpDescriptor[i5];
        CPNameAndType cPNameAndType = (CPNameAndType) this.descriptorsToCPNameAndTypes.get(str);
        if (cPNameAndType != null) {
            return cPNameAndType;
        }
        CPNameAndType cPNameAndType2 = new CPNameAndType(cpUTF8Value(this.cpDescriptorNameInts[i5]), cpSignatureValue(this.cpDescriptorTypeInts[i5]), i5 + this.descrOffset);
        this.descriptorsToCPNameAndTypes.put(str, cPNameAndType2);
        return cPNameAndType2;
    }

    public CPUTF8 cpSignatureValue(int i5) {
        int i6 = this.cpSignatureInts[i5];
        if (i6 == -1) {
            i6 = this.signatureOffset + i5;
        }
        String str = this.cpSignature[i5];
        CPUTF8 cputf8 = (CPUTF8) this.stringsToCPUTF8.get(str);
        if (cputf8 != null) {
            return cputf8;
        }
        CPUTF8 cputf9 = new CPUTF8(str, i6);
        this.stringsToCPUTF8.put(str, cputf9);
        return cputf9;
    }

    public CPString cpStringValue(int i5) {
        String str = this.cpString[i5];
        int i6 = this.cpStringInts[i5];
        int i7 = this.stringOffset + i5;
        CPString cPString = (CPString) this.stringsToCPStrings.get(str);
        if (cPString != null) {
            return cPString;
        }
        CPString cPString2 = new CPString(cpUTF8Value(i6), i7);
        this.stringsToCPStrings.put(str, cPString2);
        return cPString2;
    }

    public CPUTF8 cpUTF8Value(int i5) {
        String str = this.cpUTF8[i5];
        CPUTF8 cputf8 = (CPUTF8) this.stringsToCPUTF8.get(str);
        if (cputf8 == null) {
            CPUTF8 cputf9 = new CPUTF8(str, i5);
            this.stringsToCPUTF8.put(str, cputf9);
            return cputf9;
        }
        if (cputf8.getGlobalIndex() > i5) {
            cputf8.setGlobalIndex(i5);
        }
        return cputf8;
    }

    public SegmentConstantPool getConstantPool() {
        return this.pool;
    }

    public String[] getCpClass() {
        return this.cpClass;
    }

    public String[] getCpDescriptor() {
        return this.cpDescriptor;
    }

    public int[] getCpDescriptorNameInts() {
        return this.cpDescriptorNameInts;
    }

    public int[] getCpDescriptorTypeInts() {
        return this.cpDescriptorTypeInts;
    }

    public String[] getCpFieldClass() {
        return this.cpFieldClass;
    }

    public String[] getCpIMethodClass() {
        return this.cpIMethodClass;
    }

    public int[] getCpInt() {
        return this.cpInt;
    }

    public long[] getCpLong() {
        return this.cpLong;
    }

    public String[] getCpMethodClass() {
        return this.cpMethodClass;
    }

    public String[] getCpMethodDescriptor() {
        return this.cpMethodDescriptor;
    }

    public String[] getCpSignature() {
        return this.cpSignature;
    }

    public String[] getCpUTF8() {
        return this.cpUTF8;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void read(InputStream inputStream) {
        parseCpUtf8(inputStream);
        parseCpInt(inputStream);
        parseCpFloat(inputStream);
        parseCpLong(inputStream);
        parseCpDouble(inputStream);
        parseCpString(inputStream);
        parseCpClass(inputStream);
        parseCpSignature(inputStream);
        parseCpDescriptor(inputStream);
        parseCpField(inputStream);
        parseCpMethod(inputStream);
        parseCpIMethod(inputStream);
        int length = this.cpUTF8.length;
        this.intOffset = length;
        int length2 = length + this.cpInt.length;
        this.floatOffset = length2;
        int length3 = length2 + this.cpFloat.length;
        this.longOffset = length3;
        int length4 = length3 + this.cpLong.length;
        this.doubleOffset = length4;
        int length5 = length4 + this.cpDouble.length;
        this.stringOffset = length5;
        int length6 = length5 + this.cpString.length;
        this.classOffset = length6;
        int length7 = length6 + this.cpClass.length;
        this.signatureOffset = length7;
        int length8 = length7 + this.cpSignature.length;
        this.descrOffset = length8;
        int length9 = length8 + this.cpDescriptor.length;
        this.fieldOffset = length9;
        int length10 = length9 + this.cpFieldClass.length;
        this.methodOffset = length10;
        this.imethodOffset = length10 + this.cpMethodClass.length;
    }

    public CPClass cpClassValue(String str) {
        CPClass cPClass = (CPClass) this.stringsToCPClass.get(str);
        if (cPClass != null) {
            return cPClass;
        }
        Integer num = (Integer) this.mapClass.get(str);
        if (num != null) {
            return cpClassValue(num.intValue());
        }
        CPClass cPClass2 = new CPClass(cpUTF8Value(str, false), -1);
        this.stringsToCPClass.put(str, cPClass2);
        return cPClass2;
    }

    public CPUTF8 cpUTF8Value(String str) {
        return cpUTF8Value(str, true);
    }

    public CPUTF8 cpUTF8Value(String str, boolean z6) {
        CPUTF8 cputf8 = (CPUTF8) this.stringsToCPUTF8.get(str);
        if (cputf8 != null) {
            return cputf8;
        }
        Integer num = z6 ? (Integer) this.mapUTF8.get(str) : null;
        if (num != null) {
            return cpUTF8Value(num.intValue());
        }
        if (z6) {
            num = (Integer) this.mapSignature.get(str);
        }
        if (num != null) {
            return cpSignatureValue(num.intValue());
        }
        CPUTF8 cputf9 = new CPUTF8(str, -1);
        this.stringsToCPUTF8.put(str, cputf9);
        return cputf9;
    }

    public CPNameAndType cpNameAndTypeValue(String str) {
        CPNameAndType cPNameAndType = (CPNameAndType) this.descriptorsToCPNameAndTypes.get(str);
        if (cPNameAndType != null) {
            return cPNameAndType;
        }
        Integer num = (Integer) this.mapDescriptor.get(str);
        if (num != null) {
            return cpNameAndTypeValue(num.intValue());
        }
        int iIndexOf = str.indexOf(58);
        CPNameAndType cPNameAndType2 = new CPNameAndType(cpUTF8Value(str.substring(0, iIndexOf), true), cpUTF8Value(str.substring(iIndexOf + 1), true), this.descrOffset - 1);
        this.descriptorsToCPNameAndTypes.put(str, cPNameAndType2);
        return cPNameAndType2;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void unpack() {
    }
}
