package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SwitchForm extends VariableInstructionForm {
    public SwitchForm(int i5, String str) {
        super(i5, str);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void fixUpByteCodeTargets(ByteCode byteCode, CodeAttribute codeAttribute) {
        int[] byteCodeTargets = byteCode.getByteCodeTargets();
        int length = byteCodeTargets.length;
        int[] iArr = new int[length];
        int byteCodeIndex = byteCode.getByteCodeIndex();
        int iIntValue = ((Integer) codeAttribute.byteCodeOffsets.get(byteCodeIndex)).intValue();
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = ((Integer) codeAttribute.byteCodeOffsets.get(byteCodeTargets[i5] + byteCodeIndex)).intValue() - iIntValue;
        }
        int[] rewrite = byteCode.getRewrite();
        for (int i6 = 0; i6 < length; i6++) {
            setRewrite4Bytes(iArr[i6], rewrite);
        }
    }
}
