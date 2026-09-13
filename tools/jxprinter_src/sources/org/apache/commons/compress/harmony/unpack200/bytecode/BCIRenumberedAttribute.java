package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BCIRenumberedAttribute extends Attribute {
    protected boolean renumbered;

    public BCIRenumberedAttribute(CPUTF8 cputf8) {
        super(cputf8);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public abstract int getLength();

    public abstract int[] getStartPCs();

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public boolean hasBCIRenumbering() {
        return true;
    }

    public void renumber(List list) {
        if (this.renumbered) {
            throw new Error("Trying to renumber a line number table that has already been renumbered");
        }
        this.renumbered = true;
        int[] startPCs = getStartPCs();
        for (int i5 = 0; i5 < startPCs.length; i5++) {
            startPCs[i5] = ((Integer) list.get(startPCs[i5])).intValue();
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public abstract String toString();

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public abstract void writeBody(DataOutputStream dataOutputStream);
}
