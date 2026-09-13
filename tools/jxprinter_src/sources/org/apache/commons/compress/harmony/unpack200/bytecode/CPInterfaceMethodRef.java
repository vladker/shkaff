package org.apache.commons.compress.harmony.unpack200.bytecode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPInterfaceMethodRef extends CPRef {
    private int cachedHashCode;
    private boolean hashcodeComputed;

    public CPInterfaceMethodRef(CPClass cPClass, CPNameAndType cPNameAndType, int i5) {
        super((byte) 11, cPClass, cPNameAndType, i5);
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = this.nameAndType.hashCode() + ((this.className.hashCode() + 31) * 31);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public int invokeInterfaceCount() {
        return this.nameAndType.invokeInterfaceCount();
    }
}
