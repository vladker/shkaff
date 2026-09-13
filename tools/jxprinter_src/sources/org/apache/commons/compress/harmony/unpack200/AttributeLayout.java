package org.apache.commons.compress.harmony.unpack200;

import A3.AbstractC0157z;
import androidx.exifinterface.media.a;
import androidx.webkit.ProxyConfig;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AttributeLayout implements IMatcher {
    public static final String ACC_ABSTRACT = "ACC_ABSTRACT";
    public static final String ACC_ANNOTATION = "ACC_ANNOTATION";
    public static final String ACC_ENUM = "ACC_ENUM";
    public static final String ACC_FINAL = "ACC_FINAL";
    public static final String ACC_INTERFACE = "ACC_INTERFACE";
    public static final String ACC_NATIVE = "ACC_NATIVE";
    public static final String ACC_PRIVATE = "ACC_PRIVATE";
    public static final String ACC_PROTECTED = "ACC_PROTECTED";
    public static final String ACC_PUBLIC = "ACC_PUBLIC";
    public static final String ACC_STATIC = "ACC_STATIC";
    public static final String ACC_STRICT = "ACC_STRICT";
    public static final String ACC_SYNCHRONIZED = "ACC_SYNCHRONIZED";
    public static final String ACC_SYNTHETIC = "ACC_SYNTHETIC";
    public static final String ACC_TRANSIENT = "ACC_TRANSIENT";
    public static final String ACC_VOLATILE = "ACC_VOLATILE";
    public static final String ATTRIBUTE_ANNOTATION_DEFAULT = "AnnotationDefault";
    public static final String ATTRIBUTE_CLASS_FILE_VERSION = "class-file version";
    public static final String ATTRIBUTE_CONSTANT_VALUE = "ConstantValue";
    public static final String ATTRIBUTE_DEPRECATED = "Deprecated";
    public static final String ATTRIBUTE_ENCLOSING_METHOD = "EnclosingMethod";
    public static final String ATTRIBUTE_EXCEPTIONS = "Exceptions";
    public static final String ATTRIBUTE_INNER_CLASSES = "InnerClasses";
    public static final String ATTRIBUTE_LINE_NUMBER_TABLE = "LineNumberTable";
    public static final String ATTRIBUTE_LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    public static final String ATTRIBUTE_LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    public static final String ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    public static final String ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    public static final String ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    public static final String ATTRIBUTE_SIGNATURE = "Signature";
    public static final String ATTRIBUTE_SOURCE_FILE = "SourceFile";
    public static final int CONTEXT_CLASS = 0;
    public static final int CONTEXT_CODE = 3;
    public static final int CONTEXT_FIELD = 1;
    public static final int CONTEXT_METHOD = 2;
    private int backwardsCallCount;
    private final int context;
    private final int index;
    private final boolean isDefault;
    private final String layout;
    private long mask;
    private final String name;
    public static final String ATTRIBUTE_CODE = "Code";
    public static final String[] contextNames = {"Class", "Field", "Method", ATTRIBUTE_CODE};

    public AttributeLayout(String str, int i5, String str2, int i6) {
        this(str, i5, str2, i6, true);
    }

    private static ClassFileEntry getValue(String str, long j6, SegmentConstantPool segmentConstantPool) throws Pack200Exception {
        if (str.startsWith("R")) {
            if (str.indexOf(78) != -1) {
                j6--;
            }
            if (str.startsWith("RU")) {
                return segmentConstantPool.getValue(1, j6);
            }
            if (str.startsWith("RS")) {
                return segmentConstantPool.getValue(8, j6);
            }
        } else if (str.startsWith("K")) {
            char cCharAt = str.charAt(1);
            if (cCharAt != 'C') {
                if (cCharAt == 'D') {
                    return segmentConstantPool.getValue(5, j6);
                }
                if (cCharAt == 'F') {
                    return segmentConstantPool.getValue(3, j6);
                }
                if (cCharAt == 'S') {
                    return segmentConstantPool.getValue(6, j6);
                }
                if (cCharAt != 'I') {
                    if (cCharAt == 'J') {
                        return segmentConstantPool.getValue(4, j6);
                    }
                }
            }
            return segmentConstantPool.getValue(2, j6);
        }
        throw new Pack200Exception("Unknown layout encoding: ".concat(str));
    }

    public Codec getCodec() {
        if (this.layout.indexOf(79) >= 0) {
            return Codec.BRANCH5;
        }
        if (this.layout.indexOf(80) >= 0) {
            return Codec.BCI5;
        }
        if (this.layout.indexOf(83) < 0 || this.layout.indexOf("KS") >= 0 || this.layout.indexOf("RS") >= 0) {
            return this.layout.indexOf(66) >= 0 ? Codec.BYTE1 : Codec.UNSIGNED5;
        }
        return Codec.SIGNED5;
    }

    public int getContext() {
        return this.context;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLayout() {
        return this.layout;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() + 31 : 1;
        String str2 = this.layout;
        if (str2 != null) {
            iHashCode = (iHashCode * 31) + str2.hashCode();
        }
        return (((iHashCode * 31) + this.index) * 31) + this.context;
    }

    public boolean isDefaultLayout() {
        return this.isDefault;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.IMatcher
    public boolean matches(long j6) {
        return (j6 & this.mask) != 0;
    }

    public int numBackwardsCallables() {
        if (this.layout == ProxyConfig.MATCH_ALL_SCHEMES) {
            return 1;
        }
        return this.backwardsCallCount;
    }

    public void setBackwardsCallCount(int i5) {
        this.backwardsCallCount = i5;
    }

    public String toString() {
        return contextNames[this.context] + ": " + this.name;
    }

    public AttributeLayout(String str, int i5, String str2, int i6, boolean z6) throws Pack200Exception {
        this.index = i6;
        this.context = i5;
        if (i6 >= 0) {
            this.mask = 1 << i6;
        } else {
            this.mask = 0L;
        }
        if (i5 != 0 && i5 != 3 && i5 != 1 && i5 != 2) {
            throw new Pack200Exception(AbstractC0157z.k(i5, "Attribute context out of range: "));
        }
        if (str2 == null) {
            throw new Pack200Exception("Cannot have a null layout");
        }
        if (str == null || str.length() == 0) {
            throw new Pack200Exception("Cannot have an unnamed layout");
        }
        this.name = str;
        this.layout = str2;
        this.isDefault = z6;
    }

    public ClassFileEntry getValue(long j6, SegmentConstantPool segmentConstantPool) {
        return getValue(this.layout, j6, segmentConstantPool);
    }

    public ClassFileEntry getValue(long j6, String str, SegmentConstantPool segmentConstantPool) {
        if (!this.layout.startsWith("KQ")) {
            return getValue(this.layout, j6, segmentConstantPool);
        }
        if (str.equals("Ljava/lang/String;")) {
            return getValue("KS", j6, segmentConstantPool);
        }
        StringBuilder sb = new StringBuilder("K");
        sb.append(str);
        return getValue(a.j(this.layout, 2, sb), j6, segmentConstantPool);
    }
}
