package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CPMember extends ClassFileEntry {
    List attributes;
    protected final CPUTF8 descriptor;
    transient int descriptorIndex;
    short flags;
    CPUTF8 name;
    transient int nameIndex;

    public CPMember(CPUTF8 cputf8, CPUTF8 cputf9, long j6, List list) {
        this.name = cputf8;
        this.descriptor = cputf9;
        this.flags = (short) j6;
        this.attributes = list == null ? Collections.EMPTY_LIST : list;
        if (cputf8 == null || cputf9 == null) {
            throw new NullPointerException("Null arguments are not allowed");
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.flags);
        dataOutputStream.writeShort(this.nameIndex);
        dataOutputStream.writeShort(this.descriptorIndex);
        int size = this.attributes.size();
        dataOutputStream.writeShort(size);
        for (int i5 = 0; i5 < size; i5++) {
            ((Attribute) this.attributes.get(i5)).doWrite(dataOutputStream);
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CPMember cPMember = (CPMember) obj;
        return this.attributes.equals(cPMember.attributes) && this.descriptor.equals(cPMember.descriptor) && this.flags == cPMember.flags && this.name.equals(cPMember.name);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        int size = this.attributes.size();
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[size + 2];
        classFileEntryArr[0] = this.name;
        classFileEntryArr[1] = this.descriptor;
        for (int i5 = 0; i5 < size; i5++) {
            classFileEntryArr[i5 + 2] = (Attribute) this.attributes.get(i5);
        }
        return classFileEntryArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public int hashCode() {
        return this.name.hashCode() + ((((this.descriptor.hashCode() + ((this.attributes.hashCode() + 31) * 31)) * 31) + this.flags) * 31);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.nameIndex = classConstantPool.indexOf(this.name);
        this.descriptorIndex = classConstantPool.indexOf(this.descriptor);
        for (int i5 = 0; i5 < this.attributes.size(); i5++) {
            ((Attribute) this.attributes.get(i5)).resolve(classConstantPool);
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return "CPMember: " + this.name + "(" + this.descriptor + ")";
    }
}
