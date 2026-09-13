package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPMethod extends CPMember {
    private int cachedHashCode;
    private boolean hashcodeComputed;

    public CPMethod(CPUTF8 cputf8, CPUTF8 cputf9, long j6, List list) {
        super(cputf8, cputf9, j6, list);
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = this.descriptor.hashCode() + ((this.name.hashCode() + 31) * 31);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.CPMember, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.CPMember, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return "Method: " + this.name + "(" + this.descriptor + ")";
    }
}
