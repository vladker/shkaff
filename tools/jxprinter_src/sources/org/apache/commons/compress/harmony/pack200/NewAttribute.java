package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Label;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NewAttribute extends Attribute {
    private char[] buf;
    private ClassReader classReader;
    private int codeOff;
    private byte[] contents;
    private boolean contextClass;
    private boolean contextCode;
    private boolean contextField;
    private boolean contextMethod;
    private Label[] labels;
    private final String layout;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ErrorAttribute extends NewAttribute {
        public ErrorAttribute(String str, int i5) {
            super(str, "", i5);
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttribute
        public Attribute read(ClassReader classReader, int i5, int i6, char[] cArr, int i7, Label[] labelArr) {
            throw new Error(AbstractC0157z.s(new StringBuilder("Attribute "), this.type, " was found"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PassAttribute extends NewAttribute {
        public PassAttribute(String str, int i5) {
            super(str, "", i5);
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttribute
        public Attribute read(ClassReader classReader, int i5, int i6, char[] cArr, int i7, Label[] labelArr) {
            throw new Segment.PassException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StripAttribute extends NewAttribute {
        public StripAttribute(String str, int i5) {
            super(str, "", i5);
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttribute
        public Attribute read(ClassReader classReader, int i5, int i6, char[] cArr, int i7, Label[] labelArr) {
            return null;
        }
    }

    public NewAttribute(String str, String str2, int i5) {
        super(str);
        this.contextClass = false;
        this.contextMethod = false;
        this.contextField = false;
        this.contextCode = false;
        this.layout = str2;
        addContext(i5);
    }

    public void addContext(int i5) {
        if (i5 == 0) {
            this.contextClass = true;
            return;
        }
        if (i5 == 1) {
            this.contextField = true;
        } else if (i5 == 2) {
            this.contextMethod = true;
        } else {
            if (i5 != 3) {
                return;
            }
            this.contextCode = true;
        }
    }

    public byte[] getBytes() {
        return this.contents;
    }

    public Label getLabel(int i5) {
        return this.labels[i5];
    }

    public String getLayout() {
        return this.layout;
    }

    public boolean isCodeAttribute() {
        return this.codeOff != -1;
    }

    public boolean isContextClass() {
        return this.contextClass;
    }

    public boolean isContextCode() {
        return this.contextCode;
    }

    public boolean isContextField() {
        return this.contextField;
    }

    public boolean isContextMethod() {
        return this.contextMethod;
    }

    public boolean isUnknown() {
        return false;
    }

    public Attribute read(ClassReader classReader, int i5, int i6, char[] cArr, int i7, Label[] labelArr) {
        byte[] bArr = new byte[i6];
        System.arraycopy(classReader.b, i5, bArr, 0, i6);
        return new NewAttribute(classReader, this.type, this.layout, bArr, cArr, i7, labelArr);
    }

    public String readClass(int i5) {
        return this.classReader.readClass(i5, this.buf);
    }

    public Object readConst(int i5) {
        return this.classReader.readConst(i5, this.buf);
    }

    public String readUTF8(int i5) {
        return this.classReader.readUTF8(i5, this.buf);
    }

    public boolean isUnknown(int i5) {
        boolean z6;
        if (i5 == 0) {
            z6 = this.contextClass;
        } else if (i5 == 1) {
            z6 = this.contextField;
        } else if (i5 == 2) {
            z6 = this.contextMethod;
        } else {
            if (i5 != 3) {
                return false;
            }
            z6 = this.contextCode;
        }
        return !z6;
    }

    public NewAttribute(ClassReader classReader, String str, String str2, byte[] bArr, char[] cArr, int i5, Label[] labelArr) {
        super(str);
        this.contextClass = false;
        this.contextMethod = false;
        this.contextField = false;
        this.contextCode = false;
        this.classReader = classReader;
        this.contents = bArr;
        this.layout = str2;
        this.codeOff = i5;
        this.labels = labelArr;
        this.buf = cArr;
    }
}
