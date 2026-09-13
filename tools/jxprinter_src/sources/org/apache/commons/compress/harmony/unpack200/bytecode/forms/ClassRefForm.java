package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassRefForm extends ReferenceForm {
    protected boolean widened;

    public ClassRefForm(int i5, String str, int[] iArr) {
        super(i5, str, iArr);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm
    public int getOffset(OperandManager operandManager) {
        return operandManager.nextClassRef();
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm
    public int getPoolID() {
        return 7;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm
    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i5) {
        if (i5 != 0) {
            super.setNestedEntries(byteCode, operandManager, i5 - 1);
        } else {
            byteCode.setNested(new ClassFileEntry[]{operandManager.globalConstantPool().getClassPoolEntry(operandManager.getCurrentClass())});
            byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
        }
    }

    public ClassRefForm(int i5, String str, int[] iArr, boolean z6) {
        this(i5, str, iArr);
        this.widened = z6;
    }
}
