package org.apache.commons.compress.harmony.unpack200;

import androidx.collection.a;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IcTuple {
    public static final int NESTED_CLASS_FLAG = 65536;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    protected String f6720C;

    /* JADX INFO: renamed from: C2, reason: collision with root package name */
    protected String f6721C2;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    protected int f6722F;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    protected String f6723N;
    private boolean anonymous;
    private final int c2Index;
    private final int cIndex;
    private int cachedHashCode;
    private String cachedOuterClassString;
    private String cachedSimpleClassName;
    private boolean hashcodeComputed;
    private boolean initialized;
    private final int nIndex;
    private boolean outerIsAnonymous;
    private boolean predictOuter;
    private boolean predictSimple;
    private final int tIndex;
    private boolean member = true;
    private int cachedOuterClassIndex = -1;
    private int cachedSimpleClassNameIndex = -1;

    public IcTuple(String str, int i5, String str2, String str3, int i6, int i7, int i8, int i9) {
        this.f6720C = str;
        this.f6722F = i5;
        this.f6721C2 = str2;
        this.f6723N = str3;
        this.cIndex = i6;
        this.c2Index = i7;
        this.nIndex = i8;
        this.tIndex = i9;
        if (str3 == null) {
            this.predictSimple = true;
        }
        if (str2 == null) {
            this.predictOuter = true;
        }
        initializeClassStrings();
    }

    private boolean computeOuterIsAnonymous() {
        String[] strArrInnerBreakAtDollar = innerBreakAtDollar(this.cachedOuterClassString);
        if (strArrInnerBreakAtDollar.length == 0) {
            throw new Error("Should have an outer before checking if it's anonymous");
        }
        for (String str : strArrInnerBreakAtDollar) {
            if (isAllDigits(str)) {
                return true;
            }
        }
        return false;
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = 17;
        String str = this.f6720C;
        if (str != null) {
            this.cachedHashCode = str.hashCode();
        }
        String str2 = this.f6721C2;
        if (str2 != null) {
            this.cachedHashCode = str2.hashCode();
        }
        String str3 = this.f6723N;
        if (str3 != null) {
            this.cachedHashCode = str3.hashCode();
        }
    }

    private void initializeClassStrings() {
        if (this.initialized) {
            return;
        }
        this.initialized = true;
        if (!this.predictSimple) {
            this.cachedSimpleClassName = this.f6723N;
        }
        if (!this.predictOuter) {
            this.cachedOuterClassString = this.f6721C2;
        }
        String[] strArrInnerBreakAtDollar = innerBreakAtDollar(this.f6720C);
        int length = strArrInnerBreakAtDollar.length;
        if (strArrInnerBreakAtDollar.length < 2) {
            return;
        }
        int length2 = strArrInnerBreakAtDollar.length - 1;
        this.cachedSimpleClassName = strArrInnerBreakAtDollar[length2];
        this.cachedOuterClassString = "";
        int i5 = 0;
        while (i5 < length2) {
            this.cachedOuterClassString += strArrInnerBreakAtDollar[i5];
            if (isAllDigits(strArrInnerBreakAtDollar[i5])) {
                this.member = false;
            }
            i5++;
            if (i5 != length2) {
                this.cachedOuterClassString = a.f('$', this.cachedOuterClassString, new StringBuilder());
            }
        }
        if (!this.predictSimple) {
            this.cachedSimpleClassName = this.f6723N;
            this.cachedSimpleClassNameIndex = this.nIndex;
        }
        if (!this.predictOuter) {
            this.cachedOuterClassString = this.f6721C2;
            this.cachedOuterClassIndex = this.c2Index;
        }
        if (isAllDigits(this.cachedSimpleClassName)) {
            this.anonymous = true;
            this.member = false;
            if (nestedExplicitFlagSet()) {
                this.member = true;
            }
        }
        this.outerIsAnonymous = computeOuterIsAnonymous();
    }

    private boolean isAllDigits(String str) {
        if (str == null) {
            return false;
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (!Character.isDigit(str.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        IcTuple icTuple = (IcTuple) obj;
        return nullSafeEquals(this.f6720C, icTuple.f6720C) && nullSafeEquals(this.f6721C2, icTuple.f6721C2) && nullSafeEquals(this.f6723N, icTuple.f6723N);
    }

    public String getC() {
        return this.f6720C;
    }

    public String getC2() {
        return this.f6721C2;
    }

    public int getF() {
        return this.f6722F;
    }

    public String getN() {
        return this.f6723N;
    }

    public int getTupleIndex() {
        return this.tIndex;
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public String[] innerBreakAtDollar(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        while (i5 < str.length()) {
            if (str.charAt(i5) <= '$') {
                arrayList.add(str.substring(i6, i5));
                i6 = i5 + 1;
            }
            i5++;
            if (i5 >= str.length()) {
                arrayList.add(str.substring(i6));
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            strArr[i7] = (String) arrayList.get(i7);
        }
        return strArr;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public boolean isMember() {
        return this.member;
    }

    public boolean nestedExplicitFlagSet() {
        return (this.f6722F & 65536) == 65536;
    }

    public boolean nullSafeEquals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public int outerClassIndex() {
        return this.cachedOuterClassIndex;
    }

    public String outerClassString() {
        return this.cachedOuterClassString;
    }

    public boolean outerIsAnonymous() {
        return this.outerIsAnonymous;
    }

    public boolean predicted() {
        return this.predictOuter || this.predictSimple;
    }

    public String simpleClassName() {
        return this.cachedSimpleClassName;
    }

    public int simpleClassNameIndex() {
        return this.cachedSimpleClassNameIndex;
    }

    public int thisClassIndex() {
        if (predicted()) {
            return this.cIndex;
        }
        return -1;
    }

    public String thisClassString() {
        if (predicted()) {
            return this.f6720C;
        }
        return this.f6721C2 + "$" + this.f6723N;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("IcTuple (");
        stringBuffer.append(simpleClassName());
        stringBuffer.append(" in ");
        stringBuffer.append(outerClassString());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}
