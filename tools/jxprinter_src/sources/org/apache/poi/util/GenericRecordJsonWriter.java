package org.apache.poi.util;

import A3.AbstractC0157z;
import androidx.core.os.EnvironmentCompat;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.PackedColorModel;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GenericRecordJsonWriter implements Closeable {
    private static final String TABS;
    private static final String ZEROS = "0000000000000000";
    protected final AppendableWriter aw;
    protected final PrintWriter fw;
    private static final Pattern ESC_CHARS = Pattern.compile("[\"\\p{Cntrl}\\\\]");
    private static final String NL = System.getProperty("line.separator");
    private static final List<Map.Entry<Class<?>, GenericRecordHandler>> handler = new ArrayList();
    protected int indent = 0;
    protected boolean withComments = true;
    protected int childIndex = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface GenericRecordHandler {
        boolean print(GenericRecordJsonWriter genericRecordJsonWriter, String str, Object obj);
    }

    static {
        char[] cArr = new char[255];
        Arrays.fill(cArr, '\t');
        TABS = new String(cArr);
        handler(String.class, new b(8));
        handler(Number.class, new b(14));
        handler(Boolean.class, new b(15));
        handler(List.class, new b(0));
        handler(GenericRecord.class, new b(1));
        handler(GenericRecordUtil.AnnotatedFlag.class, new b(2));
        handler(byte[].class, new b(3));
        handler(Point2D.class, new b(4));
        handler(Dimension2D.class, new b(5));
        handler(Rectangle2D.class, new b(6));
        handler(Path2D.class, new b(9));
        handler(AffineTransform.class, new b(10));
        handler(Color.class, new b(11));
        handler(BufferedImage.class, new b(12));
        handler(Array.class, new b(13));
        handler(Object.class, new b(8));
    }

    public GenericRecordJsonWriter(File file) {
        AppendableWriter appendableWriter = new AppendableWriter((Writer) new OutputStreamWriter(AbstractC1127c.NULL.equals(file.getName()) ? NullOutputStream.NULL_OUTPUT_STREAM : new FileOutputStream(file), StandardCharsets.UTF_8));
        this.aw = appendableWriter;
        this.fw = new PrintWriter(appendableWriter);
    }

    private static void handler(Class<?> cls, GenericRecordHandler genericRecordHandler) {
        handler.add(new AbstractMap.SimpleEntry(cls, genericRecordHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printList$3(Object obj) {
        writeValue(null, obj);
        this.childIndex++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$writeChildren$1(GenericRecord genericRecord) {
        if (!writeValue(null, genericRecord)) {
            return false;
        }
        int i5 = this.childIndex + 1;
        this.childIndex = i5;
        return i5 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$writeProperties$0(Map.Entry entry) {
        return writeProp((String) entry.getKey(), (Supplier) entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$writeValue$2(Object obj, Map.Entry entry) {
        return matchInstanceOrArray((Class) entry.getKey(), obj);
    }

    public static String marshal(GenericRecord genericRecord) {
        return marshal(genericRecord, true);
    }

    public static boolean matchInstanceOrArray(Class<?> cls, Object obj) {
        if (cls.isInstance(obj)) {
            return true;
        }
        return Array.class.equals(cls) && obj.getClass().isArray();
    }

    public static String trimHex(long j6, int i5) {
        String hexString = Long.toHexString(j6);
        int length = hexString.length();
        return ZEROS.substring(0, Math.max(0, i5 - length)) + hexString.substring(Math.max(0, length - i5), length);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.fw.close();
    }

    public boolean printAffineTransform(String str, Object obj) {
        printName(str);
        AffineTransform affineTransform = (AffineTransform) obj;
        this.fw.write("{ \"scaleX\": " + affineTransform.getScaleX() + ", \"shearX\": " + affineTransform.getShearX() + ", \"transX\": " + affineTransform.getTranslateX() + ", \"scaleY\": " + affineTransform.getScaleY() + ", \"shearY\": " + affineTransform.getShearY() + ", \"transY\": " + affineTransform.getTranslateY() + " }");
        return true;
    }

    public boolean printAnnotatedFlag(String str, Object obj) {
        printName(str);
        GenericRecordUtil.AnnotatedFlag annotatedFlag = (GenericRecordUtil.AnnotatedFlag) obj;
        this.fw.print(annotatedFlag.getValue().get().longValue());
        if (!this.withComments) {
            return true;
        }
        this.fw.write(" /* ");
        this.fw.write(annotatedFlag.getDescription());
        this.fw.write(" */ ");
        return true;
    }

    public boolean printArray(String str, Object obj) {
        printName(str);
        this.fw.write("[");
        int length = Array.getLength(obj);
        int i5 = this.childIndex;
        int i6 = 0;
        while (true) {
            this.childIndex = i6;
            int i7 = this.childIndex;
            if (i7 >= length) {
                this.childIndex = i5;
                this.fw.write(tabs() + "\t]");
                return true;
            }
            writeValue(null, Array.get(obj, i7));
            i6 = this.childIndex + 1;
        }
    }

    public boolean printBoolean(String str, Object obj) {
        printName(str);
        this.fw.write(((Boolean) obj).toString());
        return true;
    }

    public boolean printBytes(String str, Object obj) {
        printName(str);
        this.fw.write(34);
        this.fw.write(Base64.getEncoder().encodeToString((byte[]) obj));
        this.fw.write(34);
        return true;
    }

    public boolean printColor(String str, Object obj) {
        printName(str);
        int rgb = ((Color) obj).getRGB();
        this.fw.print(rgb);
        if (!this.withComments) {
            return true;
        }
        this.fw.write(" /* 0x");
        this.fw.write(trimHex(rgb, 8));
        this.fw.write(" */");
        return true;
    }

    public boolean printDimension(String str, Object obj) {
        printName(str);
        Dimension2D dimension2D = (Dimension2D) obj;
        this.fw.write("{ \"width\": " + dimension2D.getWidth() + ", \"height\": " + dimension2D.getHeight() + " }");
        return true;
    }

    public boolean printGenericRecord(String str, Object obj) {
        printName(str);
        this.indent++;
        write((GenericRecord) obj);
        this.indent--;
        return true;
    }

    public boolean printImage(String str, Object obj) {
        String str2;
        BufferedImage bufferedImage = (BufferedImage) obj;
        String[] strArr = {"XYZ", "Lab", "Luv", "YCbCr", "Yxy", "RGB", "GRAY", "HSV", "HLS", "CMYK", "Unknown", "CMY", "Unknown"};
        String[] strArr2 = {"CUSTOM", "INT_RGB", "INT_ARGB", "INT_ARGB_PRE", "INT_BGR", "3BYTE_BGR", "4BYTE_ABGR", "4BYTE_ABGR_PRE", "USHORT_565_RGB", "USHORT_555_RGB", "BYTE_GRAY", "USHORT_GRAY", "BYTE_BINARY", "BYTE_INDEXED"};
        printName(str);
        ColorModel colorModel = bufferedImage.getColorModel();
        if (colorModel instanceof IndexColorModel) {
            str2 = "indexed";
        } else if (colorModel instanceof ComponentColorModel) {
            str2 = "component";
        } else if (colorModel instanceof DirectColorModel) {
            str2 = "direct";
        } else {
            str2 = colorModel instanceof PackedColorModel ? "packed" : EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PrintWriter printWriter = this.fw;
        StringBuilder sb = new StringBuilder("{ \"width\": ");
        sb.append(bufferedImage.getWidth());
        sb.append(", \"height\": ");
        sb.append(bufferedImage.getHeight());
        sb.append(", \"type\": \"");
        androidx.collection.a.y(sb, strArr2[bufferedImage.getType()], "\", \"colormodel\": \"", str2, "\", \"pixelBits\": ");
        sb.append(colorModel.getPixelSize());
        sb.append(", \"numComponents\": ");
        sb.append(colorModel.getNumComponents());
        sb.append(", \"colorSpace\": \"");
        sb.append(strArr[Math.min(colorModel.getColorSpace().getType(), 12)]);
        sb.append("\", \"transparency\": ");
        sb.append(colorModel.getTransparency());
        sb.append(", \"alpha\": ");
        sb.append(colorModel.hasAlpha());
        sb.append(VectorFormat.DEFAULT_SUFFIX);
        printWriter.write(sb.toString());
        return true;
    }

    public boolean printList(String str, Object obj) {
        printName(str);
        this.fw.println("[");
        int i5 = this.childIndex;
        this.childIndex = 0;
        ((List) obj).forEach(new j(this, 3));
        this.childIndex = i5;
        this.fw.write(tabs() + "\t]");
        return true;
    }

    public void printName(String str) {
        this.fw.print(str != null ? AbstractC0157z.o("\"", str, "\": ") : "");
    }

    public boolean printNull(String str, Object obj) {
        printName(str);
        this.fw.write(AbstractC1127c.NULL);
        return true;
    }

    public boolean printNumber(String str, Object obj) {
        int i5;
        Number number = (Number) obj;
        printName(str);
        if (obj instanceof Float) {
            this.fw.print(number.floatValue());
            return true;
        }
        if (obj instanceof Double) {
            this.fw.print(number.doubleValue());
            return true;
        }
        this.fw.print(number.longValue());
        if (number instanceof Byte) {
            i5 = 2;
        } else if (number instanceof Short) {
            i5 = 4;
        } else if (number instanceof Integer) {
            i5 = 8;
        } else {
            i5 = number instanceof Long ? 16 : -1;
        }
        long jLongValue = number.longValue();
        if (this.withComments && i5 > 0 && (jLongValue < 0 || jLongValue > 9)) {
            this.fw.write(" /* 0x");
            this.fw.write(trimHex(jLongValue, i5));
            this.fw.write(" */");
        }
        return true;
    }

    public boolean printObject(String str, Object obj) {
        printName(str);
        this.fw.write(34);
        String string = obj.toString();
        Matcher matcher = ESC_CHARS.matcher(string);
        int iEnd = 0;
        while (true) {
            if (!matcher.find()) {
                this.fw.append((CharSequence) string, iEnd, string.length());
                this.fw.write(34);
                return true;
            }
            this.fw.append((CharSequence) string, iEnd, matcher.start());
            String strGroup = matcher.group();
            strGroup.getClass();
            switch (strGroup) {
                case "":
                    this.fw.write("\\\\b");
                    break;
                case "	":
                    this.fw.write("\\\\t");
                    break;
                case "
":
                    this.fw.write("\\\\n");
                    break;
                case "":
                    this.fw.write("\\\\f");
                    break;
                case "":
                    this.fw.write("\\\\r");
                    break;
                case """:
                    this.fw.write("\\\\\"");
                    break;
                case "\":
                    this.fw.write("\\\\\\\\");
                    break;
                default:
                    this.fw.write("\\\\u");
                    this.fw.write(trimHex(strGroup.charAt(0), 4));
                    break;
            }
            iEnd = matcher.end();
        }
    }

    public boolean printPath(String str, Object obj) {
        printName(str);
        PathIterator pathIterator = ((Path2D) obj).getPathIterator((AffineTransform) null);
        double[] dArr = new double[6];
        this.fw.write("[");
        this.indent += 2;
        String strTabs = tabs();
        this.indent -= 2;
        boolean z6 = false;
        while (!pathIterator.isDone()) {
            this.fw.println(z6 ? ", " : "");
            this.fw.print(strTabs);
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            this.fw.append((CharSequence) "{ \"type\": ");
            if (iCurrentSegment == 0) {
                this.fw.write("\"move\", \"x\": " + dArr[0] + ", \"y\": " + dArr[1]);
            } else if (iCurrentSegment == 1) {
                this.fw.write("\"lineto\", \"x\": " + dArr[0] + ", \"y\": " + dArr[1]);
            } else if (iCurrentSegment == 2) {
                this.fw.write("\"quad\", \"x1\": " + dArr[0] + ", \"y1\": " + dArr[1] + ", \"x2\": " + dArr[2] + ", \"y2\": " + dArr[3]);
            } else if (iCurrentSegment == 3) {
                this.fw.write("\"cubic\", \"x1\": " + dArr[0] + ", \"y1\": " + dArr[1] + ", \"x2\": " + dArr[2] + ", \"y2\": " + dArr[3] + ", \"x3\": " + dArr[4] + ", \"y3\": " + dArr[5]);
            } else if (iCurrentSegment == 4) {
                this.fw.write("\"close\"");
            }
            this.fw.append((CharSequence) " }");
            pathIterator.next();
            z6 = true;
        }
        this.fw.write("]");
        return true;
    }

    public boolean printPoint(String str, Object obj) {
        printName(str);
        Point2D point2D = (Point2D) obj;
        this.fw.write("{ \"x\": " + point2D.getX() + ", \"y\": " + point2D.getY() + " }");
        return true;
    }

    public boolean printRectangle(String str, Object obj) {
        printName(str);
        Rectangle2D rectangle2D = (Rectangle2D) obj;
        this.fw.write("{ \"x\": " + rectangle2D.getX() + ", \"y\": " + rectangle2D.getY() + ", \"width\": " + rectangle2D.getWidth() + ", \"height\": " + rectangle2D.getHeight() + " }");
        return true;
    }

    public void setWithComments(boolean z6) {
        this.withComments = z6;
    }

    public String tabs() {
        String str = TABS;
        return str.substring(0, Math.min(this.indent, str.length()));
    }

    public void write(GenericRecord genericRecord) {
        String strTabs = tabs();
        Enum<?> genericRecordType = genericRecord.getGenericRecordType();
        String strName = genericRecordType != null ? genericRecordType.name() : genericRecord.getClass().getSimpleName();
        this.fw.append((CharSequence) strTabs);
        this.fw.append((CharSequence) VectorFormat.DEFAULT_PREFIX);
        if (this.withComments) {
            this.fw.append((CharSequence) "   /* ");
            this.fw.append((CharSequence) strName);
            if (this.childIndex > 0) {
                this.fw.append((CharSequence) " - index: ");
                this.fw.print(this.childIndex);
            }
            this.fw.append((CharSequence) " */");
        }
        this.fw.println();
        boolean zWriteProperties = writeProperties(genericRecord);
        this.fw.println();
        writeChildren(genericRecord, zWriteProperties);
        this.fw.append((CharSequence) strTabs);
        this.fw.append((CharSequence) VectorFormat.DEFAULT_SUFFIX);
    }

    public boolean writeChildren(GenericRecord genericRecord, boolean z6) {
        List<? extends GenericRecord> genericChildren = genericRecord.getGenericChildren();
        if (genericChildren != null && !genericChildren.isEmpty()) {
            this.indent++;
            AppendableWriter appendableWriter = this.aw;
            StringBuilder sb = new StringBuilder();
            sb.append(tabs());
            sb.append(z6 ? ", " : "");
            sb.append("\"children\": [");
            sb.append(NL);
            appendableWriter.setHoldBack(sb.toString());
            int i5 = this.childIndex;
            this.childIndex = 0;
            long jCount = genericChildren.stream().filter(new a(this, 1)).count();
            this.childIndex = i5;
            this.aw.setHoldBack(null);
            if (jCount > 0) {
                this.fw.println();
                this.fw.println(tabs() + "]");
            }
            this.indent--;
            if (jCount > 0) {
                return true;
            }
        }
        return false;
    }

    public void writeError(String str) {
        this.fw.append((CharSequence) "{ error: ");
        printObject("error", str);
        this.fw.append((CharSequence) " }");
    }

    public boolean writeProp(String str, Supplier<?> supplier) {
        StringBuilder sb;
        String str2;
        boolean z6 = this.childIndex > 0;
        AppendableWriter appendableWriter = this.aw;
        if (z6) {
            sb = new StringBuilder();
            sb.append(NL);
            sb.append(tabs());
            str2 = "\t, ";
        } else {
            sb = new StringBuilder();
            sb.append(tabs());
            str2 = "\t  ";
        }
        sb.append(str2);
        appendableWriter.setHoldBack(sb.toString());
        int i5 = this.childIndex;
        this.childIndex = 0;
        boolean zWriteValue = writeValue(str, supplier.get());
        this.childIndex = i5 + (zWriteValue ? 1 : 0);
        this.aw.setHoldBack(null);
        return zWriteValue;
    }

    public boolean writeProperties(GenericRecord genericRecord) {
        Map<String, Supplier<?>> genericProperties = genericRecord.getGenericProperties();
        if (genericProperties != null && !genericProperties.isEmpty()) {
            int i5 = this.childIndex;
            this.childIndex = 0;
            long jCount = genericProperties.entrySet().stream().filter(new a(this, 0)).count();
            this.childIndex = i5;
            if (jCount > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean writeValue(String str, Object obj) {
        if (this.childIndex > 0) {
            this.aw.setHoldBack(",");
        }
        GenericRecordHandler bVar = obj == null ? new b(7) : (GenericRecordHandler) handler.stream().filter(new c(obj, 0)).findFirst().map(new com.google.android.material.color.utilities.g(28)).orElse(null);
        boolean z6 = bVar != null && bVar.print(this, str, obj);
        this.aw.setHoldBack(null);
        return z6;
    }

    public static String marshal(GenericRecord genericRecord, boolean z6) {
        StringBuilder sb = new StringBuilder();
        try {
            GenericRecordJsonWriter genericRecordJsonWriter = new GenericRecordJsonWriter(sb);
            try {
                genericRecordJsonWriter.setWithComments(z6);
                genericRecordJsonWriter.write(genericRecord);
                String string = sb.toString();
                genericRecordJsonWriter.close();
                return string;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        genericRecordJsonWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return "{}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AppendableWriter extends Writer {
        private final Appendable appender;
        private String holdBack;
        private final Writer writer;

        public AppendableWriter(Appendable appendable) {
            super(appendable);
            this.appender = appendable;
            this.writer = null;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flush();
            Object obj = this.appender;
            if (obj == null) {
                obj = this.writer;
            }
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            }
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            Object obj = this.appender;
            if (obj == null) {
                obj = this.writer;
            }
            if (obj instanceof Flushable) {
                ((Flushable) obj).flush();
            }
        }

        public void setHoldBack(String str) {
            this.holdBack = str;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i5, int i6) throws IOException {
            String str = this.holdBack;
            if (str != null) {
                Appendable appendable = this.appender;
                if (appendable != null) {
                    appendable.append(str);
                } else {
                    Writer writer = this.writer;
                    if (writer != null) {
                        writer.write(str);
                    }
                }
                this.holdBack = null;
            }
            Appendable appendable2 = this.appender;
            if (appendable2 != null) {
                appendable2.append(String.valueOf(cArr), i5, i6);
                return;
            }
            Writer writer2 = this.writer;
            if (writer2 != null) {
                writer2.write(cArr, i5, i6);
            }
        }

        public AppendableWriter(Writer writer) {
            super(writer);
            this.appender = null;
            this.writer = writer;
        }
    }

    public GenericRecordJsonWriter(Appendable appendable) {
        AppendableWriter appendableWriter = new AppendableWriter(appendable);
        this.aw = appendableWriter;
        this.fw = new PrintWriter(appendableWriter);
    }
}
