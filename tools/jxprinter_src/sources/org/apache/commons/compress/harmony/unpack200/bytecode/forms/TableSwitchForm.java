package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TableSwitchForm extends SwitchForm {
    public TableSwitchForm(int i5, String str) {
        super(i5, str);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i5) {
        int iNextCaseCount = operandManager.nextCaseCount();
        int iNextLabel = operandManager.nextLabel();
        int iNextCaseValues = operandManager.nextCaseValues();
        int[] iArr = new int[iNextCaseCount];
        for (int i6 = 0; i6 < iNextCaseCount; i6++) {
            iArr[i6] = operandManager.nextLabel();
        }
        int i7 = iNextCaseCount + 1;
        int[] iArr2 = new int[i7];
        iArr2[0] = iNextLabel;
        int i8 = 1;
        for (int i9 = 1; i9 < i7; i9++) {
            iArr2[i9] = iArr[i9 - 1];
        }
        byteCode.setByteCodeTargets(iArr2);
        int i10 = (iNextCaseValues + iNextCaseCount) - 1;
        int i11 = i5 % 4;
        int i12 = 3 - i11;
        int[] iArr3 = new int[(iNextCaseCount * 4) + (16 - i11)];
        iArr3[0] = byteCode.getOpcode();
        int i13 = 0;
        while (i13 < i12) {
            iArr3[i8] = 0;
            i13++;
            i8++;
        }
        iArr3[i8] = -1;
        iArr3[i8 + 1] = -1;
        iArr3[i8 + 2] = -1;
        iArr3[i8 + 3] = -1;
        setRewrite4Bytes(iNextCaseValues, i8 + 4, iArr3);
        setRewrite4Bytes(i10, i8 + 8, iArr3);
        int i14 = i8 + 12;
        for (int i15 = 0; i15 < iNextCaseCount; i15++) {
            iArr3[i14] = -1;
            iArr3[i14 + 1] = -1;
            int i16 = i14 + 3;
            iArr3[i14 + 2] = -1;
            i14 += 4;
            iArr3[i16] = -1;
        }
        byteCode.setRewrite(iArr3);
    }
}
