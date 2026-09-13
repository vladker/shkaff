package org.apache.logging.log4j.message;

import java.io.Serializable;
import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.Strings;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StructuredDataId implements Serializable, StringBuilderFormattable {
    private static final String AT_SIGN = "@";
    private static final int MAX_LENGTH = 32;
    public static final String RESERVED = "-1";
    private static final long serialVersionUID = -8252896346202183738L;
    private final String enterpriseNumber;
    private final String name;
    private final String[] optional;
    private final String[] required;
    public static final StructuredDataId TIME_QUALITY = new StructuredDataId("timeQuality", null, new String[]{"tzKnown", "isSynced", "syncAccuracy"});
    public static final StructuredDataId ORIGIN = new StructuredDataId("origin", null, new String[]{"ip", "enterpriseId", "software", "swVersion"});
    public static final StructuredDataId META = new StructuredDataId("meta", null, new String[]{"sequenceId", "sysUpTime", "language"});

    public StructuredDataId(String str) {
        this(str, (String[]) null, (String[]) null, 32);
    }

    @Override // org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        if (isReserved()) {
            sb.append(this.name);
            return;
        }
        sb.append(this.name);
        sb.append(AT_SIGN);
        sb.append(this.enterpriseNumber);
    }

    public String getEnterpriseNumber() {
        return this.enterpriseNumber;
    }

    public String getName() {
        return this.name;
    }

    public String[] getOptional() {
        return this.optional;
    }

    public String[] getRequired() {
        return this.required;
    }

    public boolean isReserved() {
        return RESERVED.equals(this.enterpriseNumber);
    }

    public StructuredDataId makeId(StructuredDataId structuredDataId) {
        return structuredDataId == null ? this : makeId(structuredDataId.getName(), structuredDataId.getEnterpriseNumber());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.name.length() + 10);
        formatTo(sb);
        return sb.toString();
    }

    public StructuredDataId(String str, int i5) {
        this(str, (String[]) null, (String[]) null, i5);
    }

    public StructuredDataId makeId(String str, String str2) {
        String[] strArr;
        String[] strArr2;
        if (RESERVED.equals(str2)) {
            return this;
        }
        String str3 = this.name;
        if (str3 != null) {
            String[] strArr3 = this.required;
            strArr2 = this.optional;
            strArr = strArr3;
            str = str3;
        } else {
            strArr = null;
            strArr2 = null;
        }
        return new StructuredDataId(str, str2, strArr, strArr2);
    }

    public StructuredDataId(String str, String[] strArr, String[] strArr2) {
        this(str, strArr, strArr2, 32);
    }

    public StructuredDataId(String str, String[] strArr, String[] strArr2, int i5) {
        int iIndexOf;
        if (str != null) {
            i5 = i5 <= 0 ? 32 : i5;
            if (str.length() <= i5) {
                iIndexOf = str.indexOf(AT_SIGN);
            } else {
                throw new IllegalArgumentException(String.format("Length of id %s exceeds maximum of %d characters", str, Integer.valueOf(i5)));
            }
        } else {
            iIndexOf = -1;
        }
        if (iIndexOf > 0) {
            this.name = str.substring(0, iIndexOf);
            this.enterpriseNumber = str.substring(iIndexOf + 1).trim();
        } else {
            this.name = str;
            this.enterpriseNumber = RESERVED;
        }
        this.required = strArr;
        this.optional = strArr2;
    }

    @Deprecated
    public StructuredDataId makeId(String str, int i5) {
        return makeId(str, String.valueOf(i5));
    }

    public StructuredDataId(String str, String str2, String[] strArr, String[] strArr2) {
        this(str, str2, strArr, strArr2, 32);
    }

    @Deprecated
    public StructuredDataId(String str, int i5, String[] strArr, String[] strArr2) {
        this(str, String.valueOf(i5), strArr, strArr2, 32);
    }

    public StructuredDataId(String str, String str2, String[] strArr, String[] strArr2, int i5) {
        if (str != null) {
            if (str.contains(AT_SIGN)) {
                throw new IllegalArgumentException("Structured id name cannot contain an " + Strings.quote(AT_SIGN));
            }
            if (!RESERVED.equals(str2)) {
                this.name = str;
                this.enterpriseNumber = str2;
                String strO = androidx.collection.a.o(str, AT_SIGN, str2);
                if (i5 > 0 && strO.length() > i5) {
                    throw new IllegalArgumentException("Length of id exceeds maximum of " + i5 + " characters: " + strO);
                }
                this.required = strArr;
                this.optional = strArr2;
                return;
            }
            throw new IllegalArgumentException("No enterprise number was supplied");
        }
        throw new IllegalArgumentException("No structured id name was supplied");
    }

    @Deprecated
    public StructuredDataId(String str, int i5, String[] strArr, String[] strArr2, int i6) {
        this(str, String.valueOf(i5), strArr, strArr2, i6);
    }
}
