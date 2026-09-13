package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StringRefForm extends SingleByteReferenceForm {
    public StringRefForm(int i5, String str, int[] iArr) {
        super(i5, str, iArr);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.SingleByteReferenceForm, org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm
    public int getOffset(OperandManager operandManager) {
        return operandManager.nextStringRef();
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.SingleByteReferenceForm, org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm
    public int getPoolID() {
        return 6;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.forms.SingleByteReferenceForm, org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm
    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i5) {
        byteCode.setNested(new ClassFileEntry[]{(CPString) operandManager.globalConstantPool().getValue(getPoolID(), i5)});
        if (this.widened) {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
        } else {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 1}});
        }
    }

    public StringRefForm(int i5, String str, int[] iArr, boolean z6) {
        this(i5, str, iArr);
        this.widened = z6;
    }
}
