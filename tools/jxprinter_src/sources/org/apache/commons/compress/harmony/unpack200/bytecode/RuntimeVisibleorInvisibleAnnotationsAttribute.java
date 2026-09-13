package org.apache.commons.compress.harmony.unpack200.bytecode;

import A3.AbstractC0157z;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RuntimeVisibleorInvisibleAnnotationsAttribute extends AnnotationsAttribute {
    private final AnnotationsAttribute.Annotation[] annotations;
    private final int num_annotations;

    public RuntimeVisibleorInvisibleAnnotationsAttribute(CPUTF8 cputf8, AnnotationsAttribute.Annotation[] annotationArr) {
        super(cputf8);
        this.num_annotations = annotationArr.length;
        this.annotations = annotationArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public int getLength() {
        int length = 2;
        for (int i5 = 0; i5 < this.num_annotations; i5++) {
            length += this.annotations[i5].getLength();
        }
        return length;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.attributeName);
        int i5 = 0;
        while (true) {
            AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
            if (i5 >= annotationArr.length) {
                break;
            }
            arrayList.addAll(annotationArr[i5].getClassFileEntries());
            i5++;
        }
        int size = arrayList.size();
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[size];
        for (int i6 = 0; i6 < size; i6++) {
            classFileEntryArr[i6] = (ClassFileEntry) arrayList.get(i6);
        }
        return classFileEntryArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        int i5 = 0;
        while (true) {
            AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
            if (i5 >= annotationArr.length) {
                return;
            }
            annotationArr[i5].resolve(classConstantPool);
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.attributeName.underlyingString());
        sb.append(": ");
        return AbstractC0157z.l(" annotations", this.num_annotations, sb);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        int size = dataOutputStream.size();
        dataOutputStream.writeShort(this.num_annotations);
        for (int i5 = 0; i5 < this.num_annotations; i5++) {
            this.annotations[i5].writeBody(dataOutputStream);
        }
        if (dataOutputStream.size() - size != getLength()) {
            throw new Error();
        }
    }
}
