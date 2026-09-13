package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WideForm extends VariableInstructionForm {
    public WideForm(int i5, String str) {
        super(i5, str);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i5) {
        int iNextWideByteCode = operandManager.nextWideByteCode();
        if (iNextWideByteCode == 132) {
            setByteCodeOperandsFormat2(iNextWideByteCode, byteCode, operandManager, i5);
        } else {
            setByteCodeOperandsFormat1(iNextWideByteCode, byteCode, operandManager, i5);
        }
    }

    public void setByteCodeOperandsFormat1(int i5, ByteCode byteCode, OperandManager operandManager, int i6) {
        int iNextLocal = operandManager.nextLocal();
        int[] iArr = {byteCode.getOpcode(), i5, 0, 0};
        setRewrite2Bytes(iNextLocal, 2, iArr);
        byteCode.setRewrite(iArr);
    }

    public void setByteCodeOperandsFormat2(int i5, ByteCode byteCode, OperandManager operandManager, int i6) {
        int iNextLocal = operandManager.nextLocal();
        int iNextShort = operandManager.nextShort();
        int[] iArr = new int[6];
        iArr[0] = byteCode.getOpcode();
        iArr[1] = i5;
        setRewrite2Bytes(iNextLocal, 2, iArr);
        setRewrite2Bytes(iNextShort, 4, iArr);
        byteCode.setRewrite(iArr);
    }
}
