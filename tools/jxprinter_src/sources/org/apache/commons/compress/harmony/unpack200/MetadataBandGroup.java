package org.apache.commons.compress.harmony.unpack200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MetadataBandGroup {
    private static CPUTF8 riaUTF8;
    private static CPUTF8 ripaUTF8;
    private static CPUTF8 rvaUTF8;
    private static CPUTF8 rvpaUTF8;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int[] f6724T;
    private int T_index;
    public int[] anno_N;
    private int anno_N_Index;
    private List attributes;
    public CPDouble[] caseD_KD;
    private int caseD_KD_Index;
    public CPFloat[] caseF_KF;
    private int caseF_KF_Index;
    public CPInteger[] caseI_KI;
    private int caseI_KI_Index;
    public CPLong[] caseJ_KJ;
    private int caseJ_KJ_Index;
    public int[] casearray_N;
    private int casearray_N_Index;
    public CPUTF8[] casec_RS;
    private int casec_RS_Index;
    public String[] caseec_RU;
    private int caseec_RU_Index;
    public String[] caseet_RS;
    private int caseet_RS_Index;
    public CPUTF8[] cases_RU;
    private int cases_RU_Index;
    private final CpBands cpBands;
    public CPUTF8[] name_RU;
    public CPUTF8[] nestname_RU;
    private Iterator nestname_RU_Iterator;
    public int[] nestpair_N;
    private int nestpair_N_Index;
    public CPUTF8[] nesttype_RS;
    private int nesttype_RS_Index;
    public int[][] pair_N;
    private int pair_N_Index;
    public int[] param_NB;
    private final String type;
    public CPUTF8[][] type_RS;

    public MetadataBandGroup(String str, CpBands cpBands) {
        this.type = str;
        this.cpBands = cpBands;
    }

    private AnnotationsAttribute.Annotation getAnnotation(CPUTF8 cputf8, int i5, Iterator it) {
        CPUTF8[] cputf8Arr = new CPUTF8[i5];
        AnnotationsAttribute.ElementValue[] elementValueArr = new AnnotationsAttribute.ElementValue[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            cputf8Arr[i6] = (CPUTF8) it.next();
            int[] iArr = this.f6724T;
            int i7 = this.T_index;
            this.T_index = i7 + 1;
            int i8 = iArr[i7];
            elementValueArr[i6] = new AnnotationsAttribute.ElementValue(i8, getNextValue(i8));
        }
        return new AnnotationsAttribute.Annotation(i5, cputf8, cputf8Arr, elementValueArr);
    }

    private Attribute getAttribute(int i5, CPUTF8[] cputf8Arr, int[] iArr, Iterator it) {
        AnnotationsAttribute.Annotation[] annotationArr = new AnnotationsAttribute.Annotation[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            annotationArr[i6] = getAnnotation(cputf8Arr[i6], iArr[i6], it);
        }
        return new RuntimeVisibleorInvisibleAnnotationsAttribute(this.type.equals("RVA") ? rvaUTF8 : riaUTF8, annotationArr);
    }

    private Object getNextValue(int i5) {
        if (i5 == 64) {
            CPUTF8[] cputf8Arr = this.nesttype_RS;
            int i6 = this.nesttype_RS_Index;
            this.nesttype_RS_Index = i6 + 1;
            CPUTF8 cputf8 = cputf8Arr[i6];
            int[] iArr = this.nestpair_N;
            int i7 = this.nestpair_N_Index;
            this.nestpair_N_Index = i7 + 1;
            return getAnnotation(cputf8, iArr[i7], this.nestname_RU_Iterator);
        }
        if (i5 == 70) {
            CPFloat[] cPFloatArr = this.caseF_KF;
            int i8 = this.caseF_KF_Index;
            this.caseF_KF_Index = i8 + 1;
            return cPFloatArr[i8];
        }
        if (i5 != 83) {
            if (i5 == 99) {
                CPUTF8[] cputf8Arr2 = this.casec_RS;
                int i9 = this.casec_RS_Index;
                this.casec_RS_Index = i9 + 1;
                return cputf8Arr2[i9];
            }
            if (i5 == 101) {
                StringBuilder sb = new StringBuilder();
                String[] strArr = this.caseet_RS;
                int i10 = this.caseet_RS_Index;
                this.caseet_RS_Index = i10 + 1;
                sb.append(strArr[i10]);
                sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                String[] strArr2 = this.caseec_RU;
                int i11 = this.caseec_RU_Index;
                this.caseec_RU_Index = i11 + 1;
                sb.append(strArr2[i11]);
                return this.cpBands.cpNameAndTypeValue(sb.toString());
            }
            if (i5 == 115) {
                CPUTF8[] cputf8Arr3 = this.cases_RU;
                int i12 = this.cases_RU_Index;
                this.cases_RU_Index = i12 + 1;
                return cputf8Arr3[i12];
            }
            if (i5 != 73) {
                if (i5 == 74) {
                    CPLong[] cPLongArr = this.caseJ_KJ;
                    int i13 = this.caseJ_KJ_Index;
                    this.caseJ_KJ_Index = i13 + 1;
                    return cPLongArr[i13];
                }
                if (i5 != 90) {
                    if (i5 == 91) {
                        int[] iArr2 = this.casearray_N;
                        int i14 = this.casearray_N_Index;
                        this.casearray_N_Index = i14 + 1;
                        int i15 = iArr2[i14];
                        AnnotationsAttribute.ElementValue[] elementValueArr = new AnnotationsAttribute.ElementValue[i15];
                        for (int i16 = 0; i16 < i15; i16++) {
                            int[] iArr3 = this.f6724T;
                            int i17 = this.T_index;
                            this.T_index = i17 + 1;
                            int i18 = iArr3[i17];
                            elementValueArr[i16] = new AnnotationsAttribute.ElementValue(i18, getNextValue(i18));
                        }
                        return elementValueArr;
                    }
                    switch (i5) {
                        case 66:
                        case 67:
                            break;
                        case 68:
                            CPDouble[] cPDoubleArr = this.caseD_KD;
                            int i19 = this.caseD_KD_Index;
                            this.caseD_KD_Index = i19 + 1;
                            return cPDoubleArr[i19];
                        default:
                            return null;
                    }
                }
            }
        }
        CPInteger[] cPIntegerArr = this.caseI_KI;
        int i20 = this.caseI_KI_Index;
        this.caseI_KI_Index = i20 + 1;
        return cPIntegerArr[i20];
    }

    private Attribute getParameterAttribute(int i5, Iterator it) {
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation[] parameterAnnotationArr = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int[] iArr = this.anno_N;
            int i7 = this.anno_N_Index;
            this.anno_N_Index = i7 + 1;
            int i8 = iArr[i7];
            int[][] iArr2 = this.pair_N;
            int i9 = this.pair_N_Index;
            this.pair_N_Index = i9 + 1;
            int[] iArr3 = iArr2[i9];
            AnnotationsAttribute.Annotation[] annotationArr = new AnnotationsAttribute.Annotation[i8];
            for (int i10 = 0; i10 < i8; i10++) {
                annotationArr[i10] = getAnnotation(this.type_RS[this.anno_N_Index - 1][i10], iArr3[i10], it);
            }
            parameterAnnotationArr[i6] = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation(annotationArr);
        }
        return new RuntimeVisibleorInvisibleParameterAnnotationsAttribute(this.type.equals("RVPA") ? rvpaUTF8 : ripaUTF8, parameterAnnotationArr);
    }

    public static void setRiaAttributeName(CPUTF8 cputf8) {
        riaUTF8 = cputf8;
    }

    public static void setRipaAttributeName(CPUTF8 cputf8) {
        ripaUTF8 = cputf8;
    }

    public static void setRvaAttributeName(CPUTF8 cputf8) {
        rvaUTF8 = cputf8;
    }

    public static void setRvpaAttributeName(CPUTF8 cputf8) {
        rvpaUTF8 = cputf8;
    }

    public List getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList();
            CPUTF8[] cputf8Arr = this.name_RU;
            int i5 = 0;
            if (cputf8Arr != null) {
                Iterator it = Arrays.asList(cputf8Arr).iterator();
                if (!this.type.equals("AD")) {
                    this.T_index = 0;
                }
                this.caseI_KI_Index = 0;
                this.caseD_KD_Index = 0;
                this.caseF_KF_Index = 0;
                this.caseJ_KJ_Index = 0;
                this.casec_RS_Index = 0;
                this.caseet_RS_Index = 0;
                this.caseec_RU_Index = 0;
                this.cases_RU_Index = 0;
                this.casearray_N_Index = 0;
                this.nesttype_RS_Index = 0;
                this.nestpair_N_Index = 0;
                this.nestname_RU_Iterator = Arrays.asList(this.nestname_RU).iterator();
                if (!this.type.equals("RVA") && !this.type.equals("RIA")) {
                    if (this.type.equals("RVPA") || this.type.equals("RIPA")) {
                        this.anno_N_Index = 0;
                        this.pair_N_Index = 0;
                        while (true) {
                            int[] iArr = this.param_NB;
                            if (i5 >= iArr.length) {
                                break;
                            }
                            this.attributes.add(getParameterAttribute(iArr[i5], it));
                            i5++;
                        }
                    }
                } else {
                    while (true) {
                        int[] iArr2 = this.anno_N;
                        if (i5 >= iArr2.length) {
                            break;
                        }
                        this.attributes.add(getAttribute(iArr2[i5], this.type_RS[i5], this.pair_N[i5], it));
                        i5++;
                    }
                }
            } else if (this.type.equals("AD")) {
                while (i5 < this.f6724T.length) {
                    List list = this.attributes;
                    int i6 = this.f6724T[i5];
                    list.add(new AnnotationDefaultAttribute(new AnnotationsAttribute.ElementValue(i6, getNextValue(i6))));
                    i5++;
                }
            }
        }
        return this.attributes;
    }
}
