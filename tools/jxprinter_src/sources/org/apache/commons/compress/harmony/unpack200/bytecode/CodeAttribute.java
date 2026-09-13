package org.apache.commons.compress.harmony.unpack200.bytecode;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.Segment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CodeAttribute extends BCIRenumberedAttribute {
    private static CPUTF8 attributeName;
    public List attributes;
    public List byteCodeOffsets;
    public List byteCodes;
    public int codeLength;
    public List exceptionTable;
    public int maxLocals;
    public int maxStack;

    public CodeAttribute(int i5, int i6, byte[] bArr, Segment segment, OperandManager operandManager, List list) {
        super(attributeName);
        this.attributes = new ArrayList();
        this.byteCodeOffsets = new ArrayList();
        this.byteCodes = new ArrayList();
        this.maxLocals = i6;
        this.maxStack = i5;
        this.codeLength = 0;
        this.exceptionTable = list;
        this.byteCodeOffsets.add(0);
        int i7 = 0;
        int i8 = 0;
        while (i7 < bArr.length) {
            ByteCode byteCode = ByteCode.getByteCode(bArr[i7] & UnsignedBytes.MAX_VALUE);
            byteCode.setByteCodeIndex(i8);
            int i9 = i8 + 1;
            byteCode.extractOperands(operandManager, segment, this.codeLength);
            this.byteCodes.add(byteCode);
            this.codeLength = byteCode.getLength() + this.codeLength;
            int iIntValue = ((Integer) AbstractC0157z.f(1, this.byteCodeOffsets)).intValue();
            if (byteCode.hasMultipleByteCodes()) {
                this.byteCodeOffsets.add(Integer.valueOf(iIntValue + 1));
                i8 += 2;
            } else {
                i8 = i9;
            }
            if (i7 < bArr.length - 1) {
                this.byteCodeOffsets.add(Integer.valueOf(byteCode.getLength() + iIntValue));
            }
            if (byteCode.getOpcode() == 196) {
                i7++;
            }
            i7++;
        }
        for (int i10 = 0; i10 < this.byteCodes.size(); i10++) {
            ((ByteCode) this.byteCodes.get(i10)).applyByteCodeTargetFixup(this);
        }
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
        if (attribute instanceof LocalVariableTableAttribute) {
            ((LocalVariableTableAttribute) attribute).setCodeLength(this.codeLength);
        }
        if (attribute instanceof LocalVariableTypeTableAttribute) {
            ((LocalVariableTypeTableAttribute) attribute).setCodeLength(this.codeLength);
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public int getLength() {
        int lengthIncludingHeader = 0;
        for (int i5 = 0; i5 < this.attributes.size(); i5++) {
            lengthIncludingHeader += ((Attribute) this.attributes.get(i5)).getLengthIncludingHeader();
        }
        return (this.exceptionTable.size() * 8) + this.codeLength + 10 + 2 + lengthIncludingHeader;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList(this.byteCodes.size() + this.attributes.size() + 10);
        arrayList.add(getAttributeName());
        arrayList.addAll(this.byteCodes);
        arrayList.addAll(this.attributes);
        for (int i5 = 0; i5 < this.exceptionTable.size(); i5++) {
            CPClass catchType = ((ExceptionTableEntry) this.exceptionTable.get(i5)).getCatchType();
            if (catchType != null) {
                arrayList.add(catchType);
            }
        }
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[arrayList.size()];
        arrayList.toArray(classFileEntryArr);
        return classFileEntryArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute
    public int[] getStartPCs() {
        return null;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute
    public void renumber(List list) {
        for (int i5 = 0; i5 < this.exceptionTable.size(); i5++) {
            ((ExceptionTableEntry) this.exceptionTable.get(i5)).renumber(list);
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        for (int i5 = 0; i5 < this.attributes.size(); i5++) {
            ((Attribute) this.attributes.get(i5)).resolve(classConstantPool);
        }
        for (int i6 = 0; i6 < this.byteCodes.size(); i6++) {
            ((ByteCode) this.byteCodes.get(i6)).resolve(classConstantPool);
        }
        for (int i7 = 0; i7 < this.exceptionTable.size(); i7++) {
            ((ExceptionTableEntry) this.exceptionTable.get(i7)).resolve(classConstantPool);
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return "Code: " + getLength() + " bytes";
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.maxStack);
        dataOutputStream.writeShort(this.maxLocals);
        dataOutputStream.writeInt(this.codeLength);
        for (int i5 = 0; i5 < this.byteCodes.size(); i5++) {
            ((ByteCode) this.byteCodes.get(i5)).write(dataOutputStream);
        }
        dataOutputStream.writeShort(this.exceptionTable.size());
        for (int i6 = 0; i6 < this.exceptionTable.size(); i6++) {
            ((ExceptionTableEntry) this.exceptionTable.get(i6)).write(dataOutputStream);
        }
        dataOutputStream.writeShort(this.attributes.size());
        for (int i7 = 0; i7 < this.attributes.size(); i7++) {
            ((Attribute) this.attributes.get(i7)).write(dataOutputStream);
        }
    }
}
