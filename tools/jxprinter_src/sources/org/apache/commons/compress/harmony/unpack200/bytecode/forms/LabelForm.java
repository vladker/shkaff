package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LabelForm extends ByteCodeForm {
    protected boolean widened;

    public LabelForm(int i5, String str, int[] iArr) {
        super(i5, str, iArr);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void fixUpByteCodeTargets(ByteCode byteCode, CodeAttribute codeAttribute) {
        int i5 = byteCode.getByteCodeTargets()[0];
        int byteCodeIndex = byteCode.getByteCodeIndex();
        byteCode.setOperandSigned2Bytes(((Integer) codeAttribute.byteCodeOffsets.get(i5 + byteCodeIndex)).intValue() - ((Integer) codeAttribute.byteCodeOffsets.get(byteCodeIndex)).intValue(), 0);
        if (this.widened) {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 4}});
        } else {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i5) {
        byteCode.setByteCodeTargets(new int[]{operandManager.nextLabel()});
    }

    public LabelForm(int i5, String str, int[] iArr, boolean z6) {
        this(i5, str, iArr);
        this.widened = z6;
    }
}
