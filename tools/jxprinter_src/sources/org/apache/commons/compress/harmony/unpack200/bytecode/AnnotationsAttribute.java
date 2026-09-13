package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AnnotationsAttribute extends Attribute {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Annotation {
        private final CPUTF8[] element_names;
        private final ElementValue[] element_values;
        private int[] name_indexes;
        private final int num_pairs;
        private final CPUTF8 type;
        private int type_index;

        public Annotation(int i5, CPUTF8 cputf8, CPUTF8[] cputf8Arr, ElementValue[] elementValueArr) {
            this.num_pairs = i5;
            this.type = cputf8;
            this.element_names = cputf8Arr;
            this.element_values = elementValueArr;
        }

        public List getClassFileEntries() {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (true) {
                CPUTF8[] cputf8Arr = this.element_names;
                if (i5 >= cputf8Arr.length) {
                    arrayList.add(this.type);
                    return arrayList;
                }
                arrayList.add(cputf8Arr[i5]);
                arrayList.addAll(this.element_values[i5].getClassFileEntries());
                i5++;
            }
        }

        public int getLength() {
            int length = 4;
            for (int i5 = 0; i5 < this.num_pairs; i5++) {
                length = length + 2 + this.element_values[i5].getLength();
            }
            return length;
        }

        public void resolve(ClassConstantPool classConstantPool) {
            this.type.resolve(classConstantPool);
            this.type_index = classConstantPool.indexOf(this.type);
            this.name_indexes = new int[this.num_pairs];
            int i5 = 0;
            while (true) {
                CPUTF8[] cputf8Arr = this.element_names;
                if (i5 >= cputf8Arr.length) {
                    return;
                }
                cputf8Arr[i5].resolve(classConstantPool);
                this.name_indexes[i5] = classConstantPool.indexOf(this.element_names[i5]);
                this.element_values[i5].resolve(classConstantPool);
                i5++;
            }
        }

        public void writeBody(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeShort(this.type_index);
            dataOutputStream.writeShort(this.num_pairs);
            for (int i5 = 0; i5 < this.num_pairs; i5++) {
                dataOutputStream.writeShort(this.name_indexes[i5]);
                this.element_values[i5].writeBody(dataOutputStream);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ElementValue {
        private int constant_value_index = -1;
        private final int tag;
        private final Object value;

        public ElementValue(int i5, Object obj) {
            this.tag = i5;
            this.value = obj;
        }

        public List getClassFileEntries() {
            ArrayList arrayList = new ArrayList(1);
            Object obj = this.value;
            if (obj instanceof CPNameAndType) {
                arrayList.add(((CPNameAndType) obj).name);
                arrayList.add(((CPNameAndType) this.value).descriptor);
                return arrayList;
            }
            if (obj instanceof ClassFileEntry) {
                arrayList.add(obj);
                return arrayList;
            }
            if (obj instanceof ElementValue[]) {
                for (ElementValue elementValue : (ElementValue[]) obj) {
                    arrayList.addAll(elementValue.getClassFileEntries());
                }
            } else if (obj instanceof Annotation) {
                arrayList.addAll(((Annotation) obj).getClassFileEntries());
            }
            return arrayList;
        }

        public int getLength() {
            int i5 = this.tag;
            if (i5 == 64) {
                return ((Annotation) this.value).getLength() + 1;
            }
            int length = 3;
            if (i5 != 70 && i5 != 83 && i5 != 99) {
                if (i5 == 101) {
                    return 5;
                }
                if (i5 != 115 && i5 != 73 && i5 != 74 && i5 != 90) {
                    if (i5 == 91) {
                        for (ElementValue elementValue : (ElementValue[]) this.value) {
                            length += elementValue.getLength();
                        }
                        return length;
                    }
                    switch (i5) {
                        case 66:
                        case 67:
                        case 68:
                            break;
                        default:
                            return 0;
                    }
                }
            }
            return 3;
        }

        public void resolve(ClassConstantPool classConstantPool) {
            Object obj = this.value;
            if (obj instanceof CPConstant) {
                ((CPConstant) obj).resolve(classConstantPool);
                this.constant_value_index = classConstantPool.indexOf((CPConstant) this.value);
                return;
            }
            if (obj instanceof CPClass) {
                ((CPClass) obj).resolve(classConstantPool);
                this.constant_value_index = classConstantPool.indexOf((CPClass) this.value);
                return;
            }
            if (obj instanceof CPUTF8) {
                ((CPUTF8) obj).resolve(classConstantPool);
                this.constant_value_index = classConstantPool.indexOf((CPUTF8) this.value);
                return;
            }
            if (obj instanceof CPNameAndType) {
                ((CPNameAndType) obj).resolve(classConstantPool);
                return;
            }
            if (obj instanceof Annotation) {
                ((Annotation) obj).resolve(classConstantPool);
                return;
            }
            if (obj instanceof ElementValue[]) {
                for (ElementValue elementValue : (ElementValue[]) obj) {
                    elementValue.resolve(classConstantPool);
                }
            }
        }

        public void writeBody(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeByte(this.tag);
            int i5 = this.constant_value_index;
            if (i5 != -1) {
                dataOutputStream.writeShort(i5);
                return;
            }
            Object obj = this.value;
            if (obj instanceof CPNameAndType) {
                ((CPNameAndType) obj).writeBody(dataOutputStream);
                return;
            }
            if (obj instanceof Annotation) {
                ((Annotation) obj).writeBody(dataOutputStream);
                return;
            }
            if (!(obj instanceof ElementValue[])) {
                throw new Error("");
            }
            ElementValue[] elementValueArr = (ElementValue[]) obj;
            dataOutputStream.writeShort(elementValueArr.length);
            for (ElementValue elementValue : elementValueArr) {
                elementValue.writeBody(dataOutputStream);
            }
        }
    }

    public AnnotationsAttribute(CPUTF8 cputf8) {
        super(cputf8);
    }
}
