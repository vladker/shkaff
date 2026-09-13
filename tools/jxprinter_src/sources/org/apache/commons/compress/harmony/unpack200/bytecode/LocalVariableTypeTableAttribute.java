package org.apache.commons.compress.harmony.unpack200.bytecode;

import A3.AbstractC0157z;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LocalVariableTypeTableAttribute extends BCIRenumberedAttribute {
    private static CPUTF8 attributeName;
    private int codeLength;
    private final int[] indexes;
    private final int[] lengths;
    private final int local_variable_type_table_length;
    private int[] name_indexes;
    private final CPUTF8[] names;
    private int[] signature_indexes;
    private final CPUTF8[] signatures;
    private final int[] start_pcs;

    public LocalVariableTypeTableAttribute(int i5, int[] iArr, int[] iArr2, CPUTF8[] cputf8Arr, CPUTF8[] cputf8Arr2, int[] iArr3) {
        super(attributeName);
        this.local_variable_type_table_length = i5;
        this.start_pcs = iArr;
        this.lengths = iArr2;
        this.names = cputf8Arr;
        this.signatures = cputf8Arr2;
        this.indexes = iArr3;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public int getLength() {
        return (this.local_variable_type_table_length * 10) + 2;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getAttributeName());
        for (int i5 = 0; i5 < this.local_variable_type_table_length; i5++) {
            arrayList.add(this.names[i5]);
            arrayList.add(this.signatures[i5]);
        }
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[arrayList.size()];
        arrayList.toArray(classFileEntryArr);
        return classFileEntryArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute
    public int[] getStartPCs() {
        return this.start_pcs;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute
    public void renumber(List list) throws Pack200Exception {
        int[] iArr = this.start_pcs;
        int[] iArr2 = new int[iArr.length];
        int i5 = 0;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super.renumber(list);
        int i6 = this.codeLength;
        while (true) {
            int[] iArr3 = this.lengths;
            if (i5 >= iArr3.length) {
                return;
            }
            int i7 = this.start_pcs[i5];
            int i8 = iArr2[i5] + iArr3[i5];
            if (i8 < 0) {
                throw new Pack200Exception("Error renumbering bytecode indexes");
            }
            this.lengths[i5] = i8 == list.size() ? i6 - i7 : ((Integer) list.get(i8)).intValue() - i7;
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        int i5 = this.local_variable_type_table_length;
        this.name_indexes = new int[i5];
        this.signature_indexes = new int[i5];
        for (int i6 = 0; i6 < this.local_variable_type_table_length; i6++) {
            this.names[i6].resolve(classConstantPool);
            this.signatures[i6].resolve(classConstantPool);
            this.name_indexes[i6] = classConstantPool.indexOf(this.names[i6]);
            this.signature_indexes[i6] = classConstantPool.indexOf(this.signatures[i6]);
        }
    }

    public void setCodeLength(int i5) {
        this.codeLength = i5;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return AbstractC0157z.l(" varaibles", this.local_variable_type_table_length, new StringBuilder("LocalVariableTypeTable: "));
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.local_variable_type_table_length);
        for (int i5 = 0; i5 < this.local_variable_type_table_length; i5++) {
            dataOutputStream.writeShort(this.start_pcs[i5]);
            dataOutputStream.writeShort(this.lengths[i5]);
            dataOutputStream.writeShort(this.name_indexes[i5]);
            dataOutputStream.writeShort(this.signature_indexes[i5]);
            dataOutputStream.writeShort(this.indexes[i5]);
        }
    }
}
