package org.apache.commons.compress.harmony.unpack200.bytecode;

import A3.AbstractC0157z;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RuntimeVisibleorInvisibleParameterAnnotationsAttribute extends AnnotationsAttribute {
    private final int num_parameters;
    private final ParameterAnnotation[] parameter_annotations;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ParameterAnnotation {
        private final AnnotationsAttribute.Annotation[] annotations;
        private final int num_annotations;

        public ParameterAnnotation(AnnotationsAttribute.Annotation[] annotationArr) {
            this.num_annotations = annotationArr.length;
            this.annotations = annotationArr;
        }

        public List getClassFileEntries() {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (true) {
                AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
                if (i5 >= annotationArr.length) {
                    return arrayList;
                }
                arrayList.addAll(annotationArr[i5].getClassFileEntries());
                i5++;
            }
        }

        public int getLength() {
            int length = 2;
            int i5 = 0;
            while (true) {
                AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
                if (i5 >= annotationArr.length) {
                    return length;
                }
                length += annotationArr[i5].getLength();
                i5++;
            }
        }

        public void resolve(ClassConstantPool classConstantPool) {
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

        public void writeBody(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeShort(this.num_annotations);
            int i5 = 0;
            while (true) {
                AnnotationsAttribute.Annotation[] annotationArr = this.annotations;
                if (i5 >= annotationArr.length) {
                    return;
                }
                annotationArr[i5].writeBody(dataOutputStream);
                i5++;
            }
        }
    }

    public RuntimeVisibleorInvisibleParameterAnnotationsAttribute(CPUTF8 cputf8, ParameterAnnotation[] parameterAnnotationArr) {
        super(cputf8);
        this.num_parameters = parameterAnnotationArr.length;
        this.parameter_annotations = parameterAnnotationArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public int getLength() {
        int length = 1;
        for (int i5 = 0; i5 < this.num_parameters; i5++) {
            length += this.parameter_annotations[i5].getLength();
        }
        return length;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.attributeName);
        int i5 = 0;
        while (true) {
            ParameterAnnotation[] parameterAnnotationArr = this.parameter_annotations;
            if (i5 >= parameterAnnotationArr.length) {
                break;
            }
            arrayList.addAll(parameterAnnotationArr[i5].getClassFileEntries());
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
            ParameterAnnotation[] parameterAnnotationArr = this.parameter_annotations;
            if (i5 >= parameterAnnotationArr.length) {
                return;
            }
            parameterAnnotationArr[i5].resolve(classConstantPool);
            i5++;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.attributeName.underlyingString());
        sb.append(": ");
        return AbstractC0157z.l(" parameter annotations", this.num_parameters, sb);
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.num_parameters);
        for (int i5 = 0; i5 < this.num_parameters; i5++) {
            this.parameter_annotations[i5].writeBody(dataOutputStream);
        }
    }
}
