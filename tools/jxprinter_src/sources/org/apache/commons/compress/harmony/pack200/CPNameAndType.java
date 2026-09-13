package org.apache.commons.compress.harmony.pack200;

import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPNameAndType extends ConstantPoolEntry implements Comparable {
    private final CPUTF8 name;
    private final CPSignature signature;

    public CPNameAndType(CPUTF8 cputf8, CPSignature cPSignature) {
        this.name = cputf8;
        this.signature = cPSignature;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof CPNameAndType)) {
            return 0;
        }
        CPNameAndType cPNameAndType = (CPNameAndType) obj;
        int iCompareTo = this.signature.compareTo(cPNameAndType.signature);
        return iCompareTo == 0 ? this.name.compareTo(cPNameAndType.name) : iCompareTo;
    }

    public String getName() {
        return this.name.getUnderlyingString();
    }

    public int getNameIndex() {
        return this.name.getIndex();
    }

    public int getTypeIndex() {
        return this.signature.getIndex();
    }

    public String toString() {
        return this.name + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.signature;
    }
}
