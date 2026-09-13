package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import androidx.exifinterface.media.ExifInterface;
import androidx.exifinterface.media.a;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MetadataBandGroup extends BandSet {
    public static final int CONTEXT_CLASS = 0;
    public static final int CONTEXT_FIELD = 1;
    public static final int CONTEXT_METHOD = 2;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public List f6715T;
    public IntList anno_N;
    public List caseD_KD;
    public List caseF_KF;
    public List caseI_KI;
    public List caseJ_KJ;
    public IntList casearray_N;
    public List casec_RS;
    public List caseec_RU;
    public List caseet_RS;
    public List cases_RU;
    private final int context;
    private final CpBands cpBands;
    public List name_RU;
    public List nestname_RU;
    public IntList nestpair_N;
    public List nesttype_RS;
    private int numBackwardsCalls;
    public IntList pair_N;
    public IntList param_NB;
    private final String type;
    public List type_RS;

    public MetadataBandGroup(String str, int i5, CpBands cpBands, SegmentHeader segmentHeader, int i6) {
        super(i6, segmentHeader);
        this.numBackwardsCalls = 0;
        this.param_NB = new IntList();
        this.anno_N = new IntList();
        this.type_RS = new ArrayList();
        this.pair_N = new IntList();
        this.name_RU = new ArrayList();
        this.f6715T = new ArrayList();
        this.caseI_KI = new ArrayList();
        this.caseD_KD = new ArrayList();
        this.caseF_KF = new ArrayList();
        this.caseJ_KJ = new ArrayList();
        this.casec_RS = new ArrayList();
        this.caseet_RS = new ArrayList();
        this.caseec_RU = new ArrayList();
        this.cases_RU = new ArrayList();
        this.casearray_N = new IntList();
        this.nesttype_RS = new ArrayList();
        this.nestpair_N = new IntList();
        this.nestname_RU = new ArrayList();
        this.type = str;
        this.cpBands = cpBands;
        this.context = i5;
    }

    private void removeOnePair() {
        List list = this.f6715T;
        String str = (String) list.remove(list.size() - 1);
        if (str.equals("B") || str.equals("C") || str.equals("I") || str.equals(ExifInterface.LATITUDE_SOUTH) || str.equals("Z")) {
            a.w(1, this.caseI_KI);
            return;
        }
        if (str.equals("D")) {
            a.w(1, this.caseD_KD);
            return;
        }
        if (str.equals("F")) {
            a.w(1, this.caseF_KF);
            return;
        }
        if (str.equals("J")) {
            a.w(1, this.caseJ_KJ);
            return;
        }
        if (str.equals("C")) {
            a.w(1, this.casec_RS);
            return;
        }
        if (str.equals("e")) {
            a.w(1, this.caseet_RS);
            this.caseec_RU.remove(this.caseet_RS.size() - 1);
            return;
        }
        if (str.equals("s")) {
            a.w(1, this.cases_RU);
            return;
        }
        int i5 = 0;
        if (str.equals("[")) {
            IntList intList = this.casearray_N;
            int iRemove = intList.remove(intList.size() - 1);
            this.numBackwardsCalls -= iRemove;
            while (i5 < iRemove) {
                removeOnePair();
                i5++;
            }
            return;
        }
        if (str.equals("@")) {
            a.w(1, this.nesttype_RS);
            IntList intList2 = this.nestpair_N;
            int iRemove2 = intList2.remove(intList2.size() - 1);
            this.numBackwardsCalls -= iRemove2;
            while (i5 < iRemove2) {
                removeOnePair();
                i5++;
            }
        }
    }

    private int[] tagListToArray(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = ((String) list.get(i5)).charAt(0);
        }
        return iArr;
    }

    public void addAnnotation(String str, List list, List list2, List list3, List list4, List list5, List list6, List list7) {
        this.type_RS.add(this.cpBands.getCPSignature(str));
        this.pair_N.add(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.name_RU.add(this.cpBands.getCPUtf8((String) it.next()));
        }
        Iterator it2 = list3.iterator();
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            String str2 = (String) it3.next();
            this.f6715T.add(str2);
            if (str2.equals("B") || str2.equals("C") || str2.equals("I") || str2.equals(ExifInterface.LATITUDE_SOUTH) || str2.equals("Z")) {
                this.caseI_KI.add(this.cpBands.getConstant((Integer) it2.next()));
            } else if (str2.equals("D")) {
                this.caseD_KD.add(this.cpBands.getConstant((Double) it2.next()));
            } else if (str2.equals("F")) {
                this.caseF_KF.add(this.cpBands.getConstant((Float) it2.next()));
            } else if (str2.equals("J")) {
                this.caseJ_KJ.add(this.cpBands.getConstant((Long) it2.next()));
            } else if (str2.equals("c")) {
                this.casec_RS.add(this.cpBands.getCPSignature((String) it2.next()));
            } else if (str2.equals("e")) {
                String str3 = (String) it2.next();
                String str4 = (String) it2.next();
                this.caseet_RS.add(this.cpBands.getCPSignature(str3));
                this.caseec_RU.add(this.cpBands.getCPUtf8(str4));
            } else if (str2.equals("s")) {
                this.cases_RU.add(this.cpBands.getCPUtf8((String) it2.next()));
            }
        }
        Iterator it4 = list4.iterator();
        while (it4.hasNext()) {
            int iIntValue = ((Integer) it4.next()).intValue();
            this.casearray_N.add(iIntValue);
            this.numBackwardsCalls += iIntValue;
        }
        Iterator it5 = list5.iterator();
        while (it5.hasNext()) {
            this.nesttype_RS.add(this.cpBands.getCPSignature((String) it5.next()));
        }
        Iterator it6 = list6.iterator();
        while (it6.hasNext()) {
            this.nestname_RU.add(this.cpBands.getCPUtf8((String) it6.next()));
        }
        Iterator it7 = list7.iterator();
        while (it7.hasNext()) {
            Integer num = (Integer) it7.next();
            this.nestpair_N.add(num.intValue());
            this.numBackwardsCalls = num.intValue() + this.numBackwardsCalls;
        }
    }

    public void addParameterAnnotation(int i5, int[] iArr, IntList intList, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8) {
        this.param_NB.add(i5);
        for (int i6 : iArr) {
            this.anno_N.add(i6);
        }
        this.pair_N.addAll(intList);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.type_RS.add(this.cpBands.getCPSignature((String) it.next()));
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.name_RU.add(this.cpBands.getCPUtf8((String) it2.next()));
        }
        Iterator it3 = list4.iterator();
        Iterator it4 = list3.iterator();
        while (it4.hasNext()) {
            String str = (String) it4.next();
            this.f6715T.add(str);
            if (str.equals("B") || str.equals("C") || str.equals("I") || str.equals(ExifInterface.LATITUDE_SOUTH) || str.equals("Z")) {
                this.caseI_KI.add(this.cpBands.getConstant((Integer) it3.next()));
            } else if (str.equals("D")) {
                this.caseD_KD.add(this.cpBands.getConstant((Double) it3.next()));
            } else if (str.equals("F")) {
                this.caseF_KF.add(this.cpBands.getConstant((Float) it3.next()));
            } else if (str.equals("J")) {
                this.caseJ_KJ.add(this.cpBands.getConstant((Long) it3.next()));
            } else if (str.equals("c")) {
                this.casec_RS.add(this.cpBands.getCPSignature((String) it3.next()));
            } else if (str.equals("e")) {
                String str2 = (String) it3.next();
                String str3 = (String) it3.next();
                this.caseet_RS.add(this.cpBands.getCPSignature(str2));
                this.caseec_RU.add(this.cpBands.getCPUtf8(str3));
            } else if (str.equals("s")) {
                this.cases_RU.add(this.cpBands.getCPUtf8((String) it3.next()));
            }
        }
        Iterator it5 = list5.iterator();
        while (it5.hasNext()) {
            int iIntValue = ((Integer) it5.next()).intValue();
            this.casearray_N.add(iIntValue);
            this.numBackwardsCalls += iIntValue;
        }
        Iterator it6 = list6.iterator();
        while (it6.hasNext()) {
            this.nesttype_RS.add(this.cpBands.getCPSignature((String) it6.next()));
        }
        Iterator it7 = list7.iterator();
        while (it7.hasNext()) {
            this.nestname_RU.add(this.cpBands.getCPUtf8((String) it7.next()));
        }
        Iterator it8 = list8.iterator();
        while (it8.hasNext()) {
            Integer num = (Integer) it8.next();
            this.nestpair_N.add(num.intValue());
            this.numBackwardsCalls = num.intValue() + this.numBackwardsCalls;
        }
    }

    public boolean hasContent() {
        return this.type_RS.size() > 0;
    }

    public void incrementAnnoN() {
        IntList intList = this.anno_N;
        intList.increment(intList.size() - 1);
    }

    public void newEntryInAnnoN() {
        this.anno_N.add(1);
    }

    public int numBackwardsCalls() {
        return this.numBackwardsCalls;
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) {
        String str;
        PackingUtils.log("Writing metadata band group...");
        if (hasContent()) {
            int i5 = this.context;
            if (i5 == 0) {
                str = "Class";
            } else {
                str = i5 == 1 ? "Field" : "Method";
            }
            if (!this.type.equals("AD")) {
                if (this.type.indexOf(80) != -1) {
                    byte[] bArrEncodeBandInt = encodeBandInt(AbstractC0157z.s(AbstractC0157z.x(str, "_"), this.type, " param_NB"), this.param_NB.toArray(), Codec.BYTE1);
                    StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
                    a.z(sbI, bArrEncodeBandInt.length, " bytes from ", str, "_");
                    sbI.append(this.type);
                    sbI.append(" anno_N[");
                    sbI.append(this.param_NB.size());
                    sbI.append("]");
                    PackingUtils.log(sbI.toString());
                }
                String strS = AbstractC0157z.s(AbstractC0157z.x(str, "_"), this.type, " anno_N");
                int[] array = this.anno_N.toArray();
                BHSDCodec bHSDCodec = Codec.UNSIGNED5;
                byte[] bArrEncodeBandInt2 = encodeBandInt(strS, array, bHSDCodec);
                StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote ");
                a.z(sbI2, bArrEncodeBandInt2.length, " bytes from ", str, "_");
                sbI2.append(this.type);
                sbI2.append(" anno_N[");
                sbI2.append(this.anno_N.size());
                sbI2.append("]");
                PackingUtils.log(sbI2.toString());
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_");
                byte[] bArrEncodeBandInt3 = encodeBandInt(AbstractC0157z.s(sb, this.type, " type_RS"), cpEntryListToArray(this.type_RS), bHSDCodec);
                outputStream.write(bArrEncodeBandInt3);
                StringBuilder sb2 = new StringBuilder("Wrote ");
                a.z(sb2, bArrEncodeBandInt3.length, " bytes from ", str, "_");
                sb2.append(this.type);
                sb2.append(" type_RS[");
                sb2.append(this.type_RS.size());
                sb2.append("]");
                PackingUtils.log(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("_");
                byte[] bArrEncodeBandInt4 = encodeBandInt(AbstractC0157z.s(sb3, this.type, " pair_N"), this.pair_N.toArray(), bHSDCodec);
                outputStream.write(bArrEncodeBandInt4);
                StringBuilder sb4 = new StringBuilder("Wrote ");
                a.z(sb4, bArrEncodeBandInt4.length, " bytes from ", str, "_");
                sb4.append(this.type);
                sb4.append(" pair_N[");
                sb4.append(this.pair_N.size());
                sb4.append("]");
                PackingUtils.log(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("_");
                byte[] bArrEncodeBandInt5 = encodeBandInt(AbstractC0157z.s(sb5, this.type, " name_RU"), cpEntryListToArray(this.name_RU), bHSDCodec);
                outputStream.write(bArrEncodeBandInt5);
                StringBuilder sb6 = new StringBuilder("Wrote ");
                a.z(sb6, bArrEncodeBandInt5.length, " bytes from ", str, "_");
                sb6.append(this.type);
                sb6.append(" name_RU[");
                AbstractC1125a.o(this.name_RU, sb6, "]");
            }
            byte[] bArrEncodeBandInt6 = encodeBandInt(AbstractC0157z.s(AbstractC0157z.x(str, "_"), this.type, " T"), tagListToArray(this.f6715T), Codec.BYTE1);
            StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt6, "Wrote ");
            a.z(sbI3, bArrEncodeBandInt6.length, " bytes from ", str, "_");
            sbI3.append(this.type);
            sbI3.append(" T[");
            sbI3.append(this.f6715T.size());
            sbI3.append("]");
            PackingUtils.log(sbI3.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str);
            sb7.append("_");
            String strS2 = AbstractC0157z.s(sb7, this.type, " caseI_KI");
            int[] iArrCpEntryListToArray = cpEntryListToArray(this.caseI_KI);
            BHSDCodec bHSDCodec2 = Codec.UNSIGNED5;
            byte[] bArrEncodeBandInt7 = encodeBandInt(strS2, iArrCpEntryListToArray, bHSDCodec2);
            StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt7, "Wrote ");
            a.z(sbI4, bArrEncodeBandInt7.length, " bytes from ", str, "_");
            sbI4.append(this.type);
            sbI4.append(" caseI_KI[");
            sbI4.append(this.caseI_KI.size());
            sbI4.append("]");
            PackingUtils.log(sbI4.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str);
            sb8.append("_");
            byte[] bArrEncodeBandInt8 = encodeBandInt(AbstractC0157z.s(sb8, this.type, " caseD_KD"), cpEntryListToArray(this.caseD_KD), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt8);
            StringBuilder sb9 = new StringBuilder("Wrote ");
            a.z(sb9, bArrEncodeBandInt8.length, " bytes from ", str, "_");
            sb9.append(this.type);
            sb9.append(" caseD_KD[");
            sb9.append(this.caseD_KD.size());
            sb9.append("]");
            PackingUtils.log(sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(str);
            sb10.append("_");
            byte[] bArrEncodeBandInt9 = encodeBandInt(AbstractC0157z.s(sb10, this.type, " caseF_KF"), cpEntryListToArray(this.caseF_KF), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt9);
            StringBuilder sb11 = new StringBuilder("Wrote ");
            a.z(sb11, bArrEncodeBandInt9.length, " bytes from ", str, "_");
            sb11.append(this.type);
            sb11.append(" caseF_KF[");
            sb11.append(this.caseF_KF.size());
            sb11.append("]");
            PackingUtils.log(sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(str);
            sb12.append("_");
            byte[] bArrEncodeBandInt10 = encodeBandInt(AbstractC0157z.s(sb12, this.type, " caseJ_KJ"), cpEntryListToArray(this.caseJ_KJ), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt10);
            StringBuilder sb13 = new StringBuilder("Wrote ");
            a.z(sb13, bArrEncodeBandInt10.length, " bytes from ", str, "_");
            sb13.append(this.type);
            sb13.append(" caseJ_KJ[");
            sb13.append(this.caseJ_KJ.size());
            sb13.append("]");
            PackingUtils.log(sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(str);
            sb14.append("_");
            byte[] bArrEncodeBandInt11 = encodeBandInt(AbstractC0157z.s(sb14, this.type, " casec_RS"), cpEntryListToArray(this.casec_RS), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt11);
            StringBuilder sb15 = new StringBuilder("Wrote ");
            a.z(sb15, bArrEncodeBandInt11.length, " bytes from ", str, "_");
            sb15.append(this.type);
            sb15.append(" casec_RS[");
            sb15.append(this.casec_RS.size());
            sb15.append("]");
            PackingUtils.log(sb15.toString());
            StringBuilder sb16 = new StringBuilder();
            sb16.append(str);
            sb16.append("_");
            byte[] bArrEncodeBandInt12 = encodeBandInt(AbstractC0157z.s(sb16, this.type, " caseet_RS"), cpEntryListToArray(this.caseet_RS), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt12);
            StringBuilder sb17 = new StringBuilder("Wrote ");
            a.z(sb17, bArrEncodeBandInt12.length, " bytes from ", str, "_");
            sb17.append(this.type);
            sb17.append(" caseet_RS[");
            sb17.append(this.caseet_RS.size());
            sb17.append("]");
            PackingUtils.log(sb17.toString());
            StringBuilder sb18 = new StringBuilder();
            sb18.append(str);
            sb18.append("_");
            byte[] bArrEncodeBandInt13 = encodeBandInt(AbstractC0157z.s(sb18, this.type, " caseec_RU"), cpEntryListToArray(this.caseec_RU), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt13);
            StringBuilder sb19 = new StringBuilder("Wrote ");
            a.z(sb19, bArrEncodeBandInt13.length, " bytes from ", str, "_");
            sb19.append(this.type);
            sb19.append(" caseec_RU[");
            sb19.append(this.caseec_RU.size());
            sb19.append("]");
            PackingUtils.log(sb19.toString());
            StringBuilder sb20 = new StringBuilder();
            sb20.append(str);
            sb20.append("_");
            byte[] bArrEncodeBandInt14 = encodeBandInt(AbstractC0157z.s(sb20, this.type, " cases_RU"), cpEntryListToArray(this.cases_RU), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt14);
            StringBuilder sb21 = new StringBuilder("Wrote ");
            a.z(sb21, bArrEncodeBandInt14.length, " bytes from ", str, "_");
            sb21.append(this.type);
            sb21.append(" cases_RU[");
            sb21.append(this.cases_RU.size());
            sb21.append("]");
            PackingUtils.log(sb21.toString());
            StringBuilder sb22 = new StringBuilder();
            sb22.append(str);
            sb22.append("_");
            byte[] bArrEncodeBandInt15 = encodeBandInt(AbstractC0157z.s(sb22, this.type, " casearray_N"), this.casearray_N.toArray(), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt15);
            StringBuilder sb23 = new StringBuilder("Wrote ");
            a.z(sb23, bArrEncodeBandInt15.length, " bytes from ", str, "_");
            sb23.append(this.type);
            sb23.append(" casearray_N[");
            sb23.append(this.casearray_N.size());
            sb23.append("]");
            PackingUtils.log(sb23.toString());
            StringBuilder sb24 = new StringBuilder();
            sb24.append(str);
            sb24.append("_");
            byte[] bArrEncodeBandInt16 = encodeBandInt(AbstractC0157z.s(sb24, this.type, " nesttype_RS"), cpEntryListToArray(this.nesttype_RS), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt16);
            StringBuilder sb25 = new StringBuilder("Wrote ");
            a.z(sb25, bArrEncodeBandInt16.length, " bytes from ", str, "_");
            sb25.append(this.type);
            sb25.append(" nesttype_RS[");
            sb25.append(this.nesttype_RS.size());
            sb25.append("]");
            PackingUtils.log(sb25.toString());
            StringBuilder sb26 = new StringBuilder();
            sb26.append(str);
            sb26.append("_");
            byte[] bArrEncodeBandInt17 = encodeBandInt(AbstractC0157z.s(sb26, this.type, " nestpair_N"), this.nestpair_N.toArray(), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt17);
            StringBuilder sb27 = new StringBuilder("Wrote ");
            a.z(sb27, bArrEncodeBandInt17.length, " bytes from ", str, "_");
            sb27.append(this.type);
            sb27.append(" nestpair_N[");
            sb27.append(this.nestpair_N.size());
            sb27.append("]");
            PackingUtils.log(sb27.toString());
            StringBuilder sb28 = new StringBuilder();
            sb28.append(str);
            sb28.append("_");
            byte[] bArrEncodeBandInt18 = encodeBandInt(AbstractC0157z.s(sb28, this.type, " nestname_RU"), cpEntryListToArray(this.nestname_RU), bHSDCodec2);
            outputStream.write(bArrEncodeBandInt18);
            StringBuilder sb29 = new StringBuilder("Wrote ");
            a.z(sb29, bArrEncodeBandInt18.length, " bytes from ", str, "_");
            sb29.append(this.type);
            sb29.append(" nestname_RU[");
            AbstractC1125a.o(this.nestname_RU, sb29, "]");
        }
    }

    public void removeLatest() {
        IntList intList = this.anno_N;
        int iRemove = intList.remove(intList.size() - 1);
        for (int i5 = 0; i5 < iRemove; i5++) {
            a.w(1, this.type_RS);
            IntList intList2 = this.pair_N;
            int iRemove2 = intList2.remove(intList2.size() - 1);
            for (int i6 = 0; i6 < iRemove2; i6++) {
                removeOnePair();
            }
        }
    }
}
