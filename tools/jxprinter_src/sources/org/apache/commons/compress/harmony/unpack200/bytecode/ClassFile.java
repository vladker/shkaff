package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassFile {
    public int accessFlags;
    public Attribute[] attributes;
    public ClassFileEntry[] fields;
    public int[] interfaces;
    public int major;
    public ClassFileEntry[] methods;
    public int minor;
    public int superClass;
    public int thisClass;
    private final int magic = -889275714;
    public ClassConstantPool pool = new ClassConstantPool();

    public void write(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(-889275714);
        dataOutputStream.writeShort(this.minor);
        dataOutputStream.writeShort(this.major);
        dataOutputStream.writeShort(this.pool.size() + 1);
        int i5 = 1;
        while (i5 <= this.pool.size()) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) this.pool.get(i5);
            constantPoolEntry.doWrite(dataOutputStream);
            if (constantPoolEntry.getTag() == 6 || constantPoolEntry.getTag() == 5) {
                i5++;
            }
            i5++;
        }
        dataOutputStream.writeShort(this.accessFlags);
        dataOutputStream.writeShort(this.thisClass);
        dataOutputStream.writeShort(this.superClass);
        dataOutputStream.writeShort(this.interfaces.length);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr = this.interfaces;
            if (i7 >= iArr.length) {
                break;
            }
            dataOutputStream.writeShort(iArr[i7]);
            i7++;
        }
        dataOutputStream.writeShort(this.fields.length);
        int i8 = 0;
        while (true) {
            ClassFileEntry[] classFileEntryArr = this.fields;
            if (i8 >= classFileEntryArr.length) {
                break;
            }
            classFileEntryArr[i8].write(dataOutputStream);
            i8++;
        }
        dataOutputStream.writeShort(this.methods.length);
        int i9 = 0;
        while (true) {
            ClassFileEntry[] classFileEntryArr2 = this.methods;
            if (i9 >= classFileEntryArr2.length) {
                break;
            }
            classFileEntryArr2[i9].write(dataOutputStream);
            i9++;
        }
        dataOutputStream.writeShort(this.attributes.length);
        while (true) {
            Attribute[] attributeArr = this.attributes;
            if (i6 >= attributeArr.length) {
                return;
            }
            attributeArr[i6].write(dataOutputStream);
            i6++;
        }
    }
}
