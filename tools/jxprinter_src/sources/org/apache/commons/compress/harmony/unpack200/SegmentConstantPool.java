package org.apache.commons.compress.harmony.unpack200;

import A3.AbstractC0157z;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SegmentConstantPool {
    public static final int ALL = 0;
    public static final int CP_CLASS = 7;
    public static final int CP_DESCR = 9;
    public static final int CP_DOUBLE = 5;
    public static final int CP_FIELD = 10;
    public static final int CP_FLOAT = 3;
    public static final int CP_IMETHOD = 12;
    public static final int CP_INT = 2;
    public static final int CP_LONG = 4;
    public static final int CP_METHOD = 11;
    public static final int CP_STRING = 6;
    protected static final String INITSTRING = "<init>";
    protected static final String REGEX_MATCH_ALL = ".*";
    protected static final String REGEX_MATCH_INIT = "^<init>.*";
    public static final int SIGNATURE = 8;
    public static final int UTF_8 = 1;
    private final SegmentConstantPoolArrayCache arrayCache = new SegmentConstantPoolArrayCache();
    private final CpBands bands;

    public SegmentConstantPool(CpBands cpBands) {
        this.bands = cpBands;
    }

    public static boolean regexMatches(String str, String str2) {
        if (REGEX_MATCH_ALL.equals(str)) {
            return true;
        }
        if (!REGEX_MATCH_INIT.equals(str)) {
            throw new Error(AbstractC0157z.n("regex trying to match a pattern I don't know: ", str));
        }
        if (str2.length() < 6) {
            return false;
        }
        return INITSTRING.equals(str2.substring(0, 6));
    }

    public ConstantPoolEntry getClassPoolEntry(String str) {
        int iMatchSpecificPoolEntryIndex = matchSpecificPoolEntryIndex(this.bands.getCpClass(), str, 0);
        if (iMatchSpecificPoolEntryIndex == -1) {
            return null;
        }
        try {
            return getConstantPoolEntry(7, iMatchSpecificPoolEntryIndex);
        } catch (Pack200Exception unused) {
            throw new Error("Error getting class pool entry");
        }
    }

    public ConstantPoolEntry getClassSpecificPoolEntry(int i5, long j6, String str) {
        String[] cpIMethodClass;
        int i6 = (int) j6;
        if (i5 == 10) {
            cpIMethodClass = this.bands.getCpFieldClass();
        } else if (i5 == 11) {
            cpIMethodClass = this.bands.getCpMethodClass();
        } else {
            if (i5 != 12) {
                throw new Error(AbstractC0157z.k(i5, "Don't know how to handle "));
            }
            cpIMethodClass = this.bands.getCpIMethodClass();
        }
        return getConstantPoolEntry(i5, matchSpecificPoolEntryIndex(cpIMethodClass, str, i6));
    }

    public ConstantPoolEntry getConstantPoolEntry(int i5, long j6) throws Pack200Exception {
        int i6 = (int) j6;
        if (i6 == -1) {
            return null;
        }
        if (i6 < 0) {
            throw new Pack200Exception("Cannot have a negative range");
        }
        if (i5 == 1) {
            return this.bands.cpUTF8Value(i6);
        }
        if (i5 == 2) {
            return this.bands.cpIntegerValue(i6);
        }
        if (i5 == 3) {
            return this.bands.cpFloatValue(i6);
        }
        if (i5 == 4) {
            return this.bands.cpLongValue(i6);
        }
        if (i5 == 5) {
            return this.bands.cpDoubleValue(i6);
        }
        if (i5 == 6) {
            return this.bands.cpStringValue(i6);
        }
        if (i5 == 7) {
            return this.bands.cpClassValue(i6);
        }
        if (i5 == 8) {
            throw new Error("I don't know what to do with signatures yet");
        }
        if (i5 == 9) {
            throw new Error("I don't know what to do with descriptors yet");
        }
        if (i5 == 10) {
            return this.bands.cpFieldValue(i6);
        }
        if (i5 == 11) {
            return this.bands.cpMethodValue(i6);
        }
        if (i5 == 12) {
            return this.bands.cpIMethodValue(i6);
        }
        throw new Error("Get value incomplete");
    }

    public ConstantPoolEntry getInitMethodPoolEntry(int i5, long j6, String str) {
        if (i5 == 11) {
            return getConstantPoolEntry(i5, matchSpecificPoolEntryIndex(this.bands.getCpMethodClass(), this.bands.getCpMethodDescriptor(), str, REGEX_MATCH_INIT, (int) j6));
        }
        throw new Error("Nothing but CP_METHOD can be an <init>");
    }

    public ClassFileEntry getValue(int i5, long j6) throws Pack200Exception {
        int i6 = (int) j6;
        if (i6 == -1) {
            return null;
        }
        if (i6 < 0) {
            throw new Pack200Exception("Cannot have a negative range");
        }
        if (i5 == 1) {
            return this.bands.cpUTF8Value(i6);
        }
        if (i5 == 2) {
            return this.bands.cpIntegerValue(i6);
        }
        if (i5 == 3) {
            return this.bands.cpFloatValue(i6);
        }
        if (i5 == 4) {
            return this.bands.cpLongValue(i6);
        }
        if (i5 == 5) {
            return this.bands.cpDoubleValue(i6);
        }
        if (i5 == 6) {
            return this.bands.cpStringValue(i6);
        }
        if (i5 == 7) {
            return this.bands.cpClassValue(i6);
        }
        if (i5 == 8) {
            return this.bands.cpSignatureValue(i6);
        }
        if (i5 == 9) {
            return this.bands.cpNameAndTypeValue(i6);
        }
        throw new Error(AbstractC0157z.k(i5, "Tried to get a value I don't know about: "));
    }

    public int matchSpecificPoolEntryIndex(String[] strArr, String str, int i5) {
        return matchSpecificPoolEntryIndex(strArr, strArr, str, REGEX_MATCH_ALL, i5);
    }

    public int matchSpecificPoolEntryIndex(String[] strArr, String[] strArr2, String str, String str2, int i5) {
        List listIndexesForArrayKey = this.arrayCache.indexesForArrayKey(strArr, str);
        if (listIndexesForArrayKey.isEmpty()) {
            return -1;
        }
        int i6 = -1;
        for (int i7 = 0; i7 < listIndexesForArrayKey.size(); i7++) {
            int iIntValue = ((Integer) listIndexesForArrayKey.get(i7)).intValue();
            if (regexMatches(str2, strArr2[iIntValue]) && (i6 = i6 + 1) == i5) {
                return iIntValue;
            }
        }
        return -1;
    }
}
