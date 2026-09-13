package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class VariableInstructionForm extends ByteCodeForm {
    public VariableInstructionForm(int i5, String str) {
        super(i5, str);
    }

    public void setRewrite2Bytes(int i5, int i6, int[] iArr) {
        if (i6 < 0) {
            throw new Error("Trying to rewrite " + this + " but there is no room for 4 bytes");
        }
        int i7 = i6 + 1;
        if (i7 <= iArr.length) {
            iArr[i6] = (65280 & i5) >> 8;
            iArr[i7] = i5 & 255;
            return;
        }
        throw new Error("Trying to rewrite " + this + " with an int at position " + i6 + " but this won't fit in the rewrite array");
    }

    public void setRewrite4Bytes(int i5, int[] iArr) {
        int i6 = 0;
        while (i6 < iArr.length - 3) {
            if (iArr[i6] == -1 && iArr[i6 + 1] == -1 && iArr[i6 + 2] == -1 && iArr[i6 + 3] == -1) {
                setRewrite4Bytes(i5, i6, iArr);
            }
            i6++;
        }
        i6 = -1;
        setRewrite4Bytes(i5, i6, iArr);
    }

    public void setRewrite4Bytes(int i5, int i6, int[] iArr) {
        if (i6 < 0) {
            throw new Error("Trying to rewrite " + this + " but there is no room for 4 bytes");
        }
        int i7 = i6 + 3;
        if (i7 > iArr.length) {
            throw new Error("Trying to rewrite " + this + " with an int at position " + i6 + " but this won't fit in the rewrite array");
        }
        iArr[i6] = ((-16777216) & i5) >> 24;
        iArr[i6 + 1] = (16711680 & i5) >> 16;
        iArr[i6 + 2] = (65280 & i5) >> 8;
        iArr[i7] = i5 & 255;
    }
}
