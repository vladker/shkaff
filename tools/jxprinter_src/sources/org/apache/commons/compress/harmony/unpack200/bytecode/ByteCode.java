package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteCode extends ClassFileEntry {
    private static ByteCode[] noArgByteCodes = new ByteCode[255];
    private final ByteCodeForm byteCodeForm;
    private int byteCodeOffset;
    private int[] byteCodeTargets;
    private ClassFileEntry[] nested;
    private int[][] nestedPositions;
    private int[] rewrite;

    public ByteCode(int i5) {
        this(i5, ClassFileEntry.NONE);
    }

    public static ByteCode getByteCode(int i5) {
        int i6 = i5 & 255;
        if (!ByteCodeForm.get(i6).hasNoOperand()) {
            return new ByteCode(i6);
        }
        ByteCode[] byteCodeArr = noArgByteCodes;
        if (byteCodeArr[i6] == null) {
            byteCodeArr[i6] = new ByteCode(i6);
        }
        return noArgByteCodes[i6];
    }

    public void applyByteCodeTargetFixup(CodeAttribute codeAttribute) {
        getByteCodeForm().fixUpByteCodeTargets(this, codeAttribute);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        int i5 = 0;
        while (true) {
            int[] iArr = this.rewrite;
            if (i5 >= iArr.length) {
                return;
            }
            dataOutputStream.writeByte(iArr[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public boolean equals(Object obj) {
        return this == obj;
    }

    public void extractOperands(OperandManager operandManager, Segment segment, int i5) {
        getByteCodeForm().setByteCodeOperands(this, operandManager, i5);
    }

    public ByteCodeForm getByteCodeForm() {
        return this.byteCodeForm;
    }

    public int getByteCodeIndex() {
        return this.byteCodeOffset;
    }

    public int[] getByteCodeTargets() {
        return this.byteCodeTargets;
    }

    public int getLength() {
        return this.rewrite.length;
    }

    public String getName() {
        return getByteCodeForm().getName();
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        return this.nested;
    }

    public int[] getNestedPosition(int i5) {
        return getNestedPositions()[i5];
    }

    public int[][] getNestedPositions() {
        return this.nestedPositions;
    }

    public int getOpcode() {
        return getByteCodeForm().getOpcode();
    }

    public int[] getRewrite() {
        return this.rewrite;
    }

    public boolean hasMultipleByteCodes() {
        return getByteCodeForm().hasMultipleByteCodes();
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public int hashCode() {
        return objectHashCode();
    }

    public boolean nestedMustStartClassPool() {
        return this.byteCodeForm.nestedMustStartClassPool();
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        if (this.nested.length > 0) {
            for (int i5 = 0; i5 < this.nested.length; i5++) {
                int i6 = getNestedPosition(i5)[1];
                if (i6 == 1) {
                    setOperandByte(classConstantPool.indexOf(this.nested[i5]), getNestedPosition(i5)[0]);
                } else {
                    if (i6 != 2) {
                        throw new Error("Unhandled resolve " + this);
                    }
                    setOperand2Bytes(classConstantPool.indexOf(this.nested[i5]), getNestedPosition(i5)[0]);
                }
            }
        }
    }

    public void setByteCodeIndex(int i5) {
        this.byteCodeOffset = i5;
    }

    public void setByteCodeTargets(int[] iArr) {
        this.byteCodeTargets = iArr;
    }

    public void setNested(ClassFileEntry[] classFileEntryArr) {
        this.nested = classFileEntryArr;
    }

    public void setNestedPositions(int[][] iArr) {
        this.nestedPositions = iArr;
    }

    public void setOperand2Bytes(int i5, int i6) {
        int iFirstOperandIndex = getByteCodeForm().firstOperandIndex();
        int length = getByteCodeForm().getRewrite().length;
        if (iFirstOperandIndex < 1) {
            throw new Error("Trying to rewrite " + this + " that has no rewrite");
        }
        int i7 = iFirstOperandIndex + i6;
        int i8 = i7 + 1;
        if (i8 <= length) {
            int[] iArr = this.rewrite;
            iArr[i7] = (65280 & i5) >> 8;
            iArr[i8] = i5 & 255;
        } else {
            throw new Error("Trying to rewrite " + this + " with an int at position " + i6 + " but this won't fit in the rewrite array");
        }
    }

    public void setOperandByte(int i5, int i6) {
        int iFirstOperandIndex = getByteCodeForm().firstOperandIndex();
        int iOperandLength = getByteCodeForm().operandLength();
        if (iFirstOperandIndex < 1) {
            throw new Error("Trying to rewrite " + this + " that has no rewrite");
        }
        int i7 = iFirstOperandIndex + i6;
        if (i7 <= iOperandLength) {
            this.rewrite[i7] = i5 & 255;
            return;
        }
        throw new Error("Trying to rewrite " + this + " with an byte at position " + i6 + " but this won't fit in the rewrite array");
    }

    public void setOperandBytes(int[] iArr) {
        int iFirstOperandIndex = getByteCodeForm().firstOperandIndex();
        int iOperandLength = getByteCodeForm().operandLength();
        if (iFirstOperandIndex < 1) {
            throw new Error("Trying to rewrite " + this + " that has no rewrite");
        }
        if (iOperandLength == iArr.length) {
            for (int i5 = 0; i5 < iOperandLength; i5++) {
                this.rewrite[i5 + iFirstOperandIndex] = iArr[i5] & 255;
            }
            return;
        }
        throw new Error("Trying to rewrite " + this + " with " + iArr.length + " but bytecode has length " + this.byteCodeForm.operandLength());
    }

    public void setOperandSigned2Bytes(int i5, int i6) {
        if (i5 >= 0) {
            setOperand2Bytes(i5, i6);
        } else {
            setOperand2Bytes(i5 + 65536, i6);
        }
    }

    public void setRewrite(int[] iArr) {
        this.rewrite = iArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return getByteCodeForm().getName();
    }

    public ByteCode(int i5, ClassFileEntry[] classFileEntryArr) {
        this.byteCodeOffset = -1;
        ByteCodeForm byteCodeForm = ByteCodeForm.get(i5);
        this.byteCodeForm = byteCodeForm;
        this.rewrite = byteCodeForm.getRewriteCopy();
        this.nested = classFileEntryArr;
    }
}
