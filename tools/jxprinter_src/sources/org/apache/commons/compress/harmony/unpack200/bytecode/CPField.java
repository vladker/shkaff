package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPField extends CPMember {
    public CPField(CPUTF8 cputf8, CPUTF8 cputf9, long j6, List list) {
        super(cputf8, cputf9, j6, list);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.CPMember, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return "Field: " + this.name + "(" + this.descriptor + ")";
    }
}
