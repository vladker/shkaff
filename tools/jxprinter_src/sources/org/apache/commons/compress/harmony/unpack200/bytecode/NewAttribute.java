package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NewAttribute extends BCIRenumberedAttribute {
    private final List body;
    private final int layoutIndex;
    private final List lengths;
    private ClassConstantPool pool;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BCIndex extends BCValue {
        private final int index;

        public BCIndex(int i5) {
            super();
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BCLength extends BCValue {
        private final int length;

        public BCLength(int i5) {
            super();
            this.length = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BCOffset extends BCValue {
        private int index;
        private final int offset;

        public BCOffset(int i5) {
            super();
            this.offset = i5;
        }

        public void setIndex(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class BCValue {
        int actualValue;

        private BCValue() {
        }

        public void setActualValue(int i5) {
            this.actualValue = i5;
        }
    }

    public NewAttribute(CPUTF8 cputf8, int i5) {
        super(cputf8);
        this.lengths = new ArrayList();
        this.body = new ArrayList();
        this.layoutIndex = i5;
    }

    public void addBCIndex(int i5, int i6) {
        this.lengths.add(Integer.valueOf(i5));
        this.body.add(new BCIndex(i6));
    }

    public void addBCLength(int i5, int i6) {
        this.lengths.add(Integer.valueOf(i5));
        this.body.add(new BCLength(i6));
    }

    public void addBCOffset(int i5, int i6) {
        this.lengths.add(Integer.valueOf(i5));
        this.body.add(new BCOffset(i6));
    }

    public void addInteger(int i5, long j6) {
        this.lengths.add(Integer.valueOf(i5));
        this.body.add(Long.valueOf(j6));
    }

    public void addToBody(int i5, Object obj) {
        this.lengths.add(Integer.valueOf(i5));
        this.body.add(obj);
    }

    public int getLayoutIndex() {
        return this.layoutIndex;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public int getLength() {
        int iIntValue = 0;
        for (int i5 = 0; i5 < this.lengths.size(); i5++) {
            iIntValue += ((Integer) this.lengths.get(i5)).intValue();
        }
        return iIntValue;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public ClassFileEntry[] getNestedClassFileEntries() {
        int i5 = 1;
        int i6 = 1;
        for (int i7 = 0; i7 < this.body.size(); i7++) {
            if (this.body.get(i7) instanceof ClassFileEntry) {
                i6++;
            }
        }
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[i6];
        classFileEntryArr[0] = getAttributeName();
        for (int i8 = 0; i8 < this.body.size(); i8++) {
            Object obj = this.body.get(i8);
            if (obj instanceof ClassFileEntry) {
                classFileEntryArr[i5] = (ClassFileEntry) obj;
                i5++;
            }
        }
        return classFileEntryArr;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute
    public int[] getStartPCs() {
        return null;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute
    public void renumber(List list) {
        if (this.renumbered) {
            return;
        }
        Object obj = null;
        for (Object obj2 : this.body) {
            if (obj2 instanceof BCIndex) {
                BCIndex bCIndex = (BCIndex) obj2;
                bCIndex.setActualValue(((Integer) list.get(bCIndex.index)).intValue());
            } else if (obj2 instanceof BCOffset) {
                BCOffset bCOffset = (BCOffset) obj2;
                if (obj instanceof BCIndex) {
                    int i5 = ((BCIndex) obj).index + bCOffset.offset;
                    bCOffset.setIndex(i5);
                    bCOffset.setActualValue(((Integer) list.get(i5)).intValue());
                } else if (obj instanceof BCOffset) {
                    int i6 = ((BCOffset) obj).index + bCOffset.offset;
                    bCOffset.setIndex(i6);
                    bCOffset.setActualValue(((Integer) list.get(i6)).intValue());
                } else {
                    bCOffset.setActualValue(((Integer) list.get(bCOffset.offset)).intValue());
                }
            } else if (obj2 instanceof BCLength) {
                BCLength bCLength = (BCLength) obj2;
                BCIndex bCIndex2 = (BCIndex) obj;
                bCLength.setActualValue(((Integer) list.get(bCIndex2.index + bCLength.length)).intValue() - bCIndex2.actualValue);
            }
            obj = obj2;
        }
        this.renumbered = true;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.Attribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        for (int i5 = 0; i5 < this.body.size(); i5++) {
            Object obj = this.body.get(i5);
            if (obj instanceof ClassFileEntry) {
                ((ClassFileEntry) obj).resolve(classConstantPool);
            }
        }
        this.pool = classConstantPool;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry
    public String toString() {
        return this.attributeName.underlyingString();
    }

    @Override // org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute, org.apache.commons.compress.harmony.unpack200.bytecode.Attribute
    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        long jLongValue;
        int iIndexOf;
        for (int i5 = 0; i5 < this.lengths.size(); i5++) {
            int iIntValue = ((Integer) this.lengths.get(i5)).intValue();
            Object obj = this.body.get(i5);
            if (obj instanceof Long) {
                jLongValue = ((Long) obj).longValue();
            } else {
                if (obj instanceof ClassFileEntry) {
                    iIndexOf = this.pool.indexOf((ClassFileEntry) obj);
                } else if (obj instanceof BCValue) {
                    iIndexOf = ((BCValue) obj).actualValue;
                } else {
                    jLongValue = 0;
                }
                jLongValue = iIndexOf;
            }
            if (iIntValue == 1) {
                dataOutputStream.writeByte((int) jLongValue);
            } else if (iIntValue == 2) {
                dataOutputStream.writeShort((int) jLongValue);
            } else if (iIntValue == 4) {
                dataOutputStream.writeInt((int) jLongValue);
            } else if (iIntValue == 8) {
                dataOutputStream.writeLong(jLongValue);
            }
        }
    }
}
