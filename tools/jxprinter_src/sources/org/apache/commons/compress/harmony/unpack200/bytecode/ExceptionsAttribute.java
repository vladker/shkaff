package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExceptionsAttribute extends Attribute {
    private static CPUTF8 attributeName;
    private transient int[] exceptionIndexes;
    private final CPClass[] exceptions;

    public ExceptionsAttribute(CPClass[] cPClassArr) {
        super(attributeName);
        this.exceptions = cPClassArr;
    }

    private static int hashCode(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        int iHashCode = 1;
        for (int i5 = 0; i5 < objArr.length; i5++) {
            int i6 = iHashCode * 31;
            Object obj = objArr[i5];
            iHashCode = i6 + (obj == null ? 0 : obj.hashCode());
        }
        return iHashCode;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && getClass() == obj.getClass() && Arrays.equals(this.exceptions, ((ExceptionsAttribute) obj).exceptions);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public int getLength() {
        return (this.exceptions.length * 2) + 2;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[this.exceptions.length + 1];
        int i5 = 0;
        while (true) {
            CPClass[] cPClassArr = this.exceptions;
            if (i5 >= cPClassArr.length) {
                classFileEntryArr[cPClassArr.length] = getAttributeName();
                return classFileEntryArr;
            }
            classFileEntryArr[i5] = cPClassArr[i5];
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.exceptionIndexes = new int[this.exceptions.length];
        int i5 = 0;
        while (true) {
            CPClass[] cPClassArr = this.exceptions;
            if (i5 >= cPClassArr.length) {
                return;
            }
            cPClassArr[i5].resolve(classConstantPool);
            this.exceptionIndexes[i5] = classConstantPool.indexOf(this.exceptions[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Exceptions: ");
        int i5 = 0;
        while (true) {
            CPClass[] cPClassArr = this.exceptions;
            if (i5 >= cPClassArr.length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(cPClassArr[i5]);
            stringBuffer.append(Chars.SPACE);
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.exceptionIndexes.length);
        int i5 = 0;
        while (true) {
            int[] iArr = this.exceptionIndexes;
            if (i5 >= iArr.length) {
                return;
            }
            dataOutputStream.writeShort(iArr[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public int hashCode() {
        return (super.hashCode() * 31) + hashCode(this.exceptions);
    }
}
