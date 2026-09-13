package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LookupSwitchForm extends SwitchForm {
    public LookupSwitchForm(int i5, String str) {
        super(i5, str);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm
    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i5) {
        int iNextCaseCount = operandManager.nextCaseCount();
        int iNextLabel = operandManager.nextLabel();
        int[] iArr = new int[iNextCaseCount];
        for (int i6 = 0; i6 < iNextCaseCount; i6++) {
            iArr[i6] = operandManager.nextCaseValues();
        }
        int[] iArr2 = new int[iNextCaseCount];
        for (int i7 = 0; i7 < iNextCaseCount; i7++) {
            iArr2[i7] = operandManager.nextLabel();
        }
        int i8 = iNextCaseCount + 1;
        int[] iArr3 = new int[i8];
        iArr3[0] = iNextLabel;
        int i9 = 1;
        for (int i10 = 1; i10 < i8; i10++) {
            iArr3[i10] = iArr2[i10 - 1];
        }
        byteCode.setByteCodeTargets(iArr3);
        int i11 = i5 % 4;
        int i12 = 3 - i11;
        int i13 = iNextCaseCount * 4;
        int[] iArr4 = new int[(12 - i11) + i13 + i13];
        iArr4[0] = byteCode.getOpcode();
        int i14 = 0;
        while (i14 < i12) {
            iArr4[i9] = 0;
            i14++;
            i9++;
        }
        iArr4[i9] = -1;
        iArr4[i9 + 1] = -1;
        iArr4[i9 + 2] = -1;
        iArr4[i9 + 3] = -1;
        setRewrite4Bytes(iNextCaseCount, i9 + 4, iArr4);
        int i15 = i9 + 8;
        for (int i16 = 0; i16 < iNextCaseCount; i16++) {
            setRewrite4Bytes(iArr[i16], i15, iArr4);
            iArr4[i15 + 4] = -1;
            iArr4[i15 + 5] = -1;
            int i17 = i15 + 7;
            iArr4[i15 + 6] = -1;
            i15 += 8;
            iArr4[i17] = -1;
        }
        byteCode.setRewrite(iArr4);
    }
}
