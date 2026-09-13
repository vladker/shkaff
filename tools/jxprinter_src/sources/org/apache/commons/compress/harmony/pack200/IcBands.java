package org.apache.commons.compress.harmony.pack200;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IcBands extends BandSet {
    private int bit16Count;
    private final CpBands cpBands;
    private final Set innerClasses;
    private final Map outerToInner;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class IcTuple implements Comparable {

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        protected CPClass f6711C;

        /* JADX INFO: renamed from: C2, reason: collision with root package name */
        protected CPClass f6712C2;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        protected int f6713F;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        protected CPUTF8 f6714N;

        public IcTuple(CPClass cPClass, int i5, CPClass cPClass2, CPUTF8 cputf8) {
            this.f6711C = cPClass;
            this.f6713F = i5;
            this.f6712C2 = cPClass2;
            this.f6714N = cputf8;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f6711C.compareTo(((IcTuple) obj).f6711C);
        }

        public boolean equals(Object obj) {
            CPClass cPClass;
            if (obj instanceof IcTuple) {
                IcTuple icTuple = (IcTuple) obj;
                if (this.f6711C.equals(icTuple.f6711C) && this.f6713F == icTuple.f6713F && ((cPClass = this.f6712C2) == null ? icTuple.f6712C2 == null : cPClass.equals(icTuple.f6712C2))) {
                    CPUTF8 cputf8 = this.f6714N;
                    if (cputf8 != null) {
                        if (cputf8.equals(icTuple.f6714N)) {
                            return true;
                        }
                    } else if (icTuple.f6714N == null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isAnonymous() {
            String string = this.f6711C.toString();
            return Character.isDigit(string.substring(string.lastIndexOf(36) + 1).charAt(0));
        }

        public String toString() {
            return this.f6711C.toString();
        }
    }

    public IcBands(SegmentHeader segmentHeader, CpBands cpBands, int i5) {
        super(i5, segmentHeader);
        this.innerClasses = new TreeSet();
        this.bit16Count = 0;
        this.outerToInner = new HashMap();
        this.cpBands = cpBands;
    }

    private void addToMap(String str, IcTuple icTuple) {
        List list = (List) this.outerToInner.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.outerToInner.put(str, arrayList);
            arrayList.add(icTuple);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (icTuple.equals((IcTuple) it.next())) {
                    return;
                }
            }
            list.add(icTuple);
        }
    }

    private String getOuter(String str) {
        return str.substring(0, str.lastIndexOf(36));
    }

    private boolean namesArePredictable(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('$');
        sb.append(str3);
        return str.equals(sb.toString()) && str3.indexOf(36) == -1;
    }

    public void addInnerClass(String str, String str2, String str3, int i5) {
        if (str2 == null && str3 == null) {
            IcTuple icTuple = new IcTuple(this.cpBands.getCPClass(str), i5, null, null);
            addToMap(getOuter(str), icTuple);
            this.innerClasses.add(icTuple);
        } else if (namesArePredictable(str, str2, str3)) {
            IcTuple icTuple2 = new IcTuple(this.cpBands.getCPClass(str), i5, null, null);
            addToMap(str2, icTuple2);
            this.innerClasses.add(icTuple2);
        } else {
            IcTuple icTuple3 = new IcTuple(this.cpBands.getCPClass(str), i5 | 65536, this.cpBands.getCPClass(str2), this.cpBands.getCPUtf8(str3));
            if (this.innerClasses.add(icTuple3)) {
                this.bit16Count++;
                addToMap(str2, icTuple3);
            }
        }
    }

    public void finaliseBands() {
        this.segmentHeader.setIc_count(this.innerClasses.size());
    }

    public IcTuple getIcTuple(CPClass cPClass) {
        for (IcTuple icTuple : this.innerClasses) {
            if (icTuple.f6711C.equals(cPClass)) {
                return icTuple;
            }
        }
        return null;
    }

    public List getInnerClassesForOuter(String str) {
        return (List) this.outerToInner.get(str);
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) {
        PackingUtils.log("Writing internal class bands...");
        int size = this.innerClasses.size();
        int[] iArr = new int[size];
        int size2 = this.innerClasses.size();
        int[] iArr2 = new int[size2];
        int i5 = this.bit16Count;
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        ArrayList arrayList = new ArrayList(this.innerClasses);
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            IcTuple icTuple = (IcTuple) arrayList.get(i7);
            iArr[i7] = icTuple.f6711C.getIndex();
            int i8 = icTuple.f6713F;
            iArr2[i7] = i8;
            if ((i8 & 65536) != 0) {
                CPClass cPClass = icTuple.f6712C2;
                iArr3[i6] = cPClass == null ? 0 : cPClass.getIndex() + 1;
                CPUTF8 cputf8 = icTuple.f6714N;
                iArr4[i6] = cputf8 == null ? 0 : cputf8.getIndex() + 1;
                i6++;
            }
        }
        byte[] bArrEncodeBandInt = encodeBandInt("ic_this_class", iArr, Codec.UDELTA5);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote "), bArrEncodeBandInt.length, " bytes from ic_this_class[", size, "]");
        byte[] bArrEncodeBandInt2 = encodeBandInt("ic_flags", iArr2, Codec.UNSIGNED5);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote "), bArrEncodeBandInt2.length, " bytes from ic_flags[", size2, "]");
        BHSDCodec bHSDCodec = Codec.DELTA5;
        byte[] bArrEncodeBandInt3 = encodeBandInt("ic_outer_class", iArr3, bHSDCodec);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt3, "Wrote "), bArrEncodeBandInt3.length, " bytes from ic_outer_class[", i5, "]");
        byte[] bArrEncodeBandInt4 = encodeBandInt("ic_name", iArr4, bHSDCodec);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt4, "Wrote "), bArrEncodeBandInt4.length, " bytes from ic_name[", i5, "]");
    }
}
