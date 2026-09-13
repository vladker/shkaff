package org.apache.commons.compress.harmony.unpack200.bytecode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CPConstant extends ConstantPoolEntry {
    private final Object value;

    public CPConstant(byte b, Object obj, int i5) {
        super(b, i5);
        this.value = obj;
        if (obj == null) {
            throw new NullPointerException("Null arguments are not allowed");
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CPConstant cPConstant = (CPConstant) obj;
        Object obj2 = this.value;
        if (obj2 == null) {
            if (cPConstant.value != null) {
                return false;
            }
        } else if (!obj2.equals(cPConstant.value)) {
            return false;
        }
        return true;
    }

    public Object getValue() {
        return this.value;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public int hashCode() {
        Object obj = this.value;
        return 31 + (obj == null ? 0 : obj.hashCode());
    }
}
