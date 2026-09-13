package org.apache.commons.compress.harmony.unpack200;

import I4.a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IcBands extends BandSet {
    private final String[] cpClass;
    private final String[] cpUTF8;
    private IcTuple[] icAll;
    private Map outerClassToTuples;
    private Map thisClassToTuple;

    public IcBands(Segment segment) {
        super(segment);
        this.cpClass = segment.getCpBands().getCpClass();
        this.cpUTF8 = segment.getCpBands().getCpUTF8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getRelevantIcTuples$0(Object obj, Object obj2) {
        return Integer.valueOf(((IcTuple) obj).getTupleIndex()).compareTo(Integer.valueOf(((IcTuple) obj2).getTupleIndex()));
    }

    public IcTuple[] getIcTuples() {
        return this.icAll;
    }

    public IcTuple[] getRelevantIcTuples(String str, ClassConstantPool classConstantPool) {
        IcTuple icTuple;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        List list = (List) this.outerClassToTuples.get(str);
        if (list != null) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                IcTuple icTuple2 = (IcTuple) list.get(i5);
                hashSet.add(icTuple2);
                arrayList.add(icTuple2);
            }
        }
        List listEntries = classConstantPool.entries();
        for (int i6 = 0; i6 < listEntries.size(); i6++) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) listEntries.get(i6);
            if ((constantPoolEntry instanceof CPClass) && (icTuple = (IcTuple) this.thisClassToTuple.get(((CPClass) constantPoolEntry).name)) != null && hashSet.add(icTuple)) {
                arrayList.add(icTuple);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        while (arrayList2.size() > 0) {
            arrayList3.clear();
            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                IcTuple icTuple3 = (IcTuple) arrayList2.get(i7);
                IcTuple icTuple4 = (IcTuple) this.thisClassToTuple.get(icTuple3.outerClassString());
                if (icTuple4 != null && !icTuple3.outerIsAnonymous()) {
                    arrayList3.add(icTuple4);
                }
            }
            arrayList2.clear();
            for (int i8 = 0; i8 < arrayList3.size(); i8++) {
                IcTuple icTuple5 = (IcTuple) arrayList3.get(i8);
                if (hashSet.add(icTuple5)) {
                    arrayList.add(icTuple5);
                    arrayList2.add(icTuple5);
                }
            }
        }
        Collections.sort(arrayList, new a(19));
        int size = arrayList.size();
        IcTuple[] icTupleArr = new IcTuple[size];
        for (int i9 = 0; i9 < size; i9++) {
            icTupleArr[i9] = (IcTuple) arrayList.get(i9);
        }
        return icTupleArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void read(InputStream inputStream) {
        String str;
        int i5;
        int i6;
        String str2;
        int innerClassCount = this.header.getInnerClassCount();
        int[] iArrDecodeBandInt = decodeBandInt("ic_this_class", inputStream, Codec.UDELTA5, innerClassCount);
        String[] references = getReferences(iArrDecodeBandInt, this.cpClass);
        int[] iArrDecodeBandInt2 = decodeBandInt("ic_flags", inputStream, Codec.UNSIGNED5, innerClassCount);
        int iCountBit16 = SegmentUtils.countBit16(iArrDecodeBandInt2);
        int[] iArrDecodeBandInt3 = decodeBandInt("ic_outer_class", inputStream, Codec.DELTA5, iCountBit16);
        String[] strArr = new String[iCountBit16];
        int i7 = 0;
        for (int i8 = 0; i8 < iCountBit16; i8++) {
            int i9 = iArrDecodeBandInt3[i8];
            if (i9 == 0) {
                strArr[i8] = null;
            } else {
                strArr[i8] = this.cpClass[i9 - 1];
            }
        }
        int[] iArrDecodeBandInt4 = decodeBandInt("ic_name", inputStream, Codec.DELTA5, iCountBit16);
        String[] strArr2 = new String[iCountBit16];
        for (int i10 = 0; i10 < iCountBit16; i10++) {
            int i11 = iArrDecodeBandInt4[i10];
            if (i11 == 0) {
                strArr2[i10] = null;
            } else {
                strArr2[i10] = this.cpUTF8[i11 - 1];
            }
        }
        this.icAll = new IcTuple[references.length];
        int i12 = 0;
        while (i7 < references.length) {
            String str3 = references[i7];
            int i13 = iArrDecodeBandInt2[i7];
            int i14 = iArrDecodeBandInt[i7];
            if ((65536 & i13) != 0) {
                String str4 = strArr[i12];
                String str5 = strArr2[i12];
                int i15 = iArrDecodeBandInt3[i12] - 1;
                int i16 = iArrDecodeBandInt4[i12] - 1;
                i12++;
                i6 = i16;
                i5 = i15;
                str2 = str5;
                str = str4;
            } else {
                str = null;
                i5 = -1;
                i6 = -1;
                str2 = null;
            }
            int i17 = i7;
            this.icAll[i17] = new IcTuple(str3, i13, str, str2, i14, i5, i6, i17);
            i7 = i17 + 1;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void unpack() {
        IcTuple[] icTuples = getIcTuples();
        this.thisClassToTuple = new HashMap(icTuples.length);
        this.outerClassToTuples = new HashMap(icTuples.length);
        for (IcTuple icTuple : icTuples) {
            if (this.thisClassToTuple.put(icTuple.thisClassString(), icTuple) != null) {
                throw new Error("Collision detected in <thisClassString, IcTuple> mapping. There are at least two inner clases with the same name.");
            }
            if ((!icTuple.isAnonymous() && !icTuple.outerIsAnonymous()) || icTuple.nestedExplicitFlagSet()) {
                String strOuterClassString = icTuple.outerClassString();
                List arrayList = (List) this.outerClassToTuples.get(strOuterClassString);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.outerClassToTuples.put(strOuterClassString, arrayList);
                }
                arrayList.add(icTuple);
            }
        }
    }
}
