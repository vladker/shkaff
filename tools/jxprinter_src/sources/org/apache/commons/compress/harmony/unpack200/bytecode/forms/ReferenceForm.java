package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ReferenceForm extends ByteCodeForm {
    public ReferenceForm(int i5, String str, int[] iArr) {
        super(i5, str, iArr);
    }

    public abstract int getOffset(OperandManager operandManager);

    public abstract int getPoolID();

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i5) {
        try {
            setNestedEntries(byteCode, operandManager, getOffset(operandManager));
        } catch (Pack200Exception unused) {
            throw new Error("Got a pack200 exception. What to do?");
        }
    }

    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i5) {
        ClassFileEntry[] classFileEntryArr = {operandManager.globalConstantPool().getConstantPoolEntry(getPoolID(), i5)};
        if (classFileEntryArr[0] == null) {
            throw new NullPointerException("Null nested entries are not allowed");
        }
        byteCode.setNested(classFileEntryArr);
        byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
    }
}
