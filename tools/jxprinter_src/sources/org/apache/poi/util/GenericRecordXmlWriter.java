package org.apache.poi.util;

import A3.AbstractC0157z;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GenericRecordXmlWriter implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TABS;
    private static final String ZEROS = "0000000000000000";
    private final PrintWriter fw;
    private static final Pattern ESC_CHARS = Pattern.compile("[<>&'\"\\p{Cntrl}]");
    private static final List<Map.Entry<Class<?>, GenericRecordHandler>> handler = new ArrayList();
    private int indent = 0;
    private boolean withComments = true;
    private int childIndex = 0;
    private boolean attributePhase = true;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface GenericRecordHandler {
        boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj);
    }

    static {
        char[] cArr = new char[255];
        Arrays.fill(cArr, '\t');
        TABS = new String(cArr);
        final int i5 = 10;
        handler(String.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i5) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i6 = 1;
        handler(Number.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i6) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i7 = 2;
        handler(Boolean.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i7) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i8 = 3;
        handler(List.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i8) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i9 = 4;
        handler(GenericRecordUtil.AnnotatedFlag.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i9) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i10 = 5;
        handler(byte[].class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i10) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i11 = 6;
        handler(Point2D.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i11) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i12 = 7;
        handler(Dimension2D.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i12) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i13 = 8;
        handler(Rectangle2D.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i13) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i14 = 9;
        handler(Path2D.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i14) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i15 = 11;
        handler(AffineTransform.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i15) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i16 = 12;
        handler(Color.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i16) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i17 = 13;
        handler(BufferedImage.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i17) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i18 = 0;
        handler(Array.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i18) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
        final int i19 = 10;
        handler(Object.class, new GenericRecordHandler() { // from class: org.apache.poi.util.h
            @Override // org.apache.poi.util.GenericRecordXmlWriter.GenericRecordHandler
            public final boolean print(GenericRecordXmlWriter genericRecordXmlWriter, String str, Object obj) {
                switch (i19) {
                    case 0:
                        return genericRecordXmlWriter.printArray(str, obj);
                    case 1:
                        return genericRecordXmlWriter.printNumber(str, obj);
                    case 2:
                        return genericRecordXmlWriter.printBoolean(str, obj);
                    case 3:
                        return genericRecordXmlWriter.printList(str, obj);
                    case 4:
                        return genericRecordXmlWriter.printAnnotatedFlag(str, obj);
                    case 5:
                        return genericRecordXmlWriter.printBytes(str, obj);
                    case 6:
                        return genericRecordXmlWriter.printPoint(str, obj);
                    case 7:
                        return genericRecordXmlWriter.printDimension(str, obj);
                    case 8:
                        return genericRecordXmlWriter.printRectangle(str, obj);
                    case 9:
                        return genericRecordXmlWriter.printPath(str, obj);
                    case 10:
                        return genericRecordXmlWriter.printObject(str, obj);
                    case 11:
                        return genericRecordXmlWriter.printAffineTransform(str, obj);
                    case 12:
                        return genericRecordXmlWriter.printColor(str, obj);
                    default:
                        return genericRecordXmlWriter.printBufferedImage(str, obj);
                }
            }
        });
    }

    public GenericRecordXmlWriter(File file) {
        this.fw = new PrintWriter(new OutputStreamWriter(AbstractC1127c.NULL.equals(file.getName()) ? NullOutputStream.NULL_OUTPUT_STREAM : new FileOutputStream(file), StandardCharsets.UTF_8));
    }

    private static void handler(Class<?> cls, GenericRecordHandler genericRecordHandler) {
        handler.add(new AbstractMap.SimpleEntry(cls, genericRecordHandler));
    }

    public static boolean isComplex(Object obj) {
        return ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof String) || (obj instanceof Color) || (obj instanceof Enum)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printList$4(Object obj) {
        writeValue("item>", obj);
        this.childIndex++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeChildren$0(GenericRecord genericRecord) {
        writeValue("record", genericRecord);
        this.childIndex++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$writeValue$2(Object obj, Map.Entry entry) {
        return matchInstanceOrArray((Class) entry.getKey(), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeValue$3(String str, Object obj, Map.Entry entry) {
        ((GenericRecordHandler) entry.getValue()).print(this, str, obj);
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.fw.close();
    }

    public void closeName(String str) {
        String strReplace = str.replace(">>", ">");
        if (this.attributePhase) {
            this.fw.append((CharSequence) "\"");
            return;
        }
        if (!strReplace.endsWith(">")) {
            this.fw.println("/>");
            return;
        }
        this.fw.println(tabs() + "\t</" + strReplace);
    }

    public void openName(String str) {
        String strReplace = str.replace(">>", ">");
        if (this.attributePhase) {
            this.fw.print(" " + strReplace.replace('>', Chars.SPACE).trim() + "=\"");
            return;
        }
        this.fw.print(tabs() + "<" + strReplace);
        if (strReplace.endsWith(">")) {
            this.fw.println();
        }
    }

    public boolean printAffineTransform(String str, Object obj) {
        openName(str);
        AffineTransform affineTransform = (AffineTransform) obj;
        PrintWriter printWriter = this.fw;
        StringBuilder sbY = AbstractC0157z.y("<", str, " scaleX=\"");
        sbY.append(affineTransform.getScaleX());
        sbY.append("\" shearX=\"");
        sbY.append(affineTransform.getShearX());
        sbY.append("\" transX=\"");
        sbY.append(affineTransform.getTranslateX());
        sbY.append("\" scaleY=\"");
        sbY.append(affineTransform.getScaleY());
        sbY.append("\" shearY=\"");
        sbY.append(affineTransform.getShearY());
        sbY.append("\" transY=\"");
        sbY.append(affineTransform.getTranslateY());
        sbY.append("\"/>");
        printWriter.write(sbY.toString());
        closeName(str);
        return true;
    }

    public boolean printAnnotatedFlag(String str, Object obj) {
        int i5;
        GenericRecordUtil.AnnotatedFlag annotatedFlag = (GenericRecordUtil.AnnotatedFlag) obj;
        Number number = annotatedFlag.getValue().get();
        if (number instanceof Byte) {
            i5 = 2;
        } else if (number instanceof Short) {
            i5 = 4;
        } else {
            i5 = number instanceof Integer ? 8 : 16;
        }
        openName(str);
        this.fw.print(" flag=\"0x");
        this.fw.print(trimHex(number.longValue(), i5));
        this.fw.print(Chars.DQUOTE);
        if (this.withComments) {
            this.fw.print(" description=\"");
            this.fw.print(annotatedFlag.getDescription());
            this.fw.print("\"");
        }
        closeName(str);
        return true;
    }

    public boolean printArray(String str, Object obj) {
        openName(str + ">");
        int length = Array.getLength(obj);
        int i5 = this.childIndex;
        int i6 = 0;
        while (true) {
            this.childIndex = i6;
            int i7 = this.childIndex;
            if (i7 >= length) {
                this.childIndex = i5;
                closeName(str + ">");
                return true;
            }
            writeValue("item>", Array.get(obj, i7));
            i6 = this.childIndex + 1;
        }
    }

    public boolean printBoolean(String str, Object obj) {
        openName(str);
        this.fw.write(((Boolean) obj).toString());
        closeName(str);
        return true;
    }

    public boolean printBufferedImage(String str, Object obj) {
        openName(str);
        BufferedImage bufferedImage = (BufferedImage) obj;
        this.fw.println(" width=\"" + bufferedImage.getWidth() + "\" height=\"" + bufferedImage.getHeight() + "\" bands=\"" + bufferedImage.getColorModel().getNumComponents() + "\"");
        closeName(str);
        return true;
    }

    public boolean printBytes(String str, Object obj) {
        openName(str + ">");
        this.fw.write(Base64.getEncoder().encodeToString((byte[]) obj));
        closeName(str + ">");
        return true;
    }

    public boolean printColor(String str, Object obj) {
        openName(str);
        int rgb = ((Color) obj).getRGB();
        this.fw.print("0x" + trimHex(rgb, 8));
        closeName(str);
        return true;
    }

    public boolean printDimension(String str, Object obj) {
        openName(str);
        Dimension2D dimension2D = (Dimension2D) obj;
        this.fw.println(" width=\"" + dimension2D.getWidth() + "\" height=\"" + dimension2D.getHeight() + "\"/>");
        closeName(str);
        return true;
    }

    public void printGenericRecord(String str, Object obj) {
        write(str, (GenericRecord) obj);
    }

    public boolean printList(String str, Object obj) {
        openName(str + ">");
        int i5 = this.childIndex;
        this.childIndex = 0;
        ((List) obj).forEach(new j(this, 2));
        this.childIndex = i5;
        closeName(str + ">");
        return true;
    }

    public boolean printNumber(String str, Object obj) {
        openName(str);
        this.fw.print(((Number) obj).toString());
        closeName(str);
        return true;
    }

    public boolean printObject(String str, Object obj) {
        openName(str + ">");
        String string = obj.toString();
        Matcher matcher = ESC_CHARS.matcher(string);
        int iEnd = 0;
        while (true) {
            if (!matcher.find()) {
                this.fw.append((CharSequence) string, iEnd, string.length());
                closeName(str + ">");
                return true;
            }
            this.fw.write(string, iEnd, matcher.start());
            String strGroup = matcher.group();
            strGroup.getClass();
            switch (strGroup) {
                case """:
                    this.fw.write("&quot;");
                    break;
                case "&":
                    this.fw.write("&amp;");
                    break;
                case "'":
                    this.fw.write("&apos;");
                    break;
                case "<":
                    this.fw.write("&lt;");
                    break;
                case ">":
                    this.fw.write("&gt;");
                    break;
                default:
                    this.fw.write("&#x");
                    this.fw.write(Long.toHexString(strGroup.codePointAt(0)));
                    this.fw.write(";");
                    break;
            }
            iEnd = matcher.end();
        }
    }

    public boolean printPath(String str, Object obj) {
        int i5;
        openName(str + ">");
        PathIterator pathIterator = ((Path2D) obj).getPathIterator((AffineTransform) null);
        double[] dArr = new double[6];
        int i6 = 2;
        this.indent += 2;
        String strTabs = tabs();
        this.indent -= 2;
        while (!pathIterator.isDone()) {
            this.fw.print(strTabs);
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            this.fw.print("<pathelement ");
            if (iCurrentSegment == 0) {
                i5 = i6;
                this.fw.print("type=\"move\" x=\"" + dArr[0] + "\" y=\"" + dArr[1] + "\"");
            } else if (iCurrentSegment == 1) {
                i5 = i6;
                this.fw.print("type=\"lineto\" x=\"" + dArr[0] + "\" y=\"" + dArr[1] + "\"");
            } else if (iCurrentSegment == i6) {
                i5 = i6;
                this.fw.print("type=\"quad\" x1=\"" + dArr[0] + "\" y1=\"" + dArr[1] + "\" x2=\"" + dArr[i5] + "\" y2=\"" + dArr[3] + "\"");
            } else if (iCurrentSegment != 3) {
                if (iCurrentSegment == 4) {
                    this.fw.print("type=\"close\"");
                }
                i5 = i6;
            } else {
                i5 = i6;
                this.fw.print("type=\"cubic\" x1=\"" + dArr[0] + "\" y1=\"" + dArr[1] + "\" x2=\"" + dArr[i5] + "\" y2=\"" + dArr[3] + "\" x3=\"" + dArr[4] + "\" y3=\"" + dArr[5] + "\"");
            }
            this.fw.println("/>");
            pathIterator.next();
            i6 = i5;
        }
        closeName(str + ">");
        return true;
    }

    public boolean printPoint(String str, Object obj) {
        openName(str);
        Point2D point2D = (Point2D) obj;
        this.fw.println(" x=\"" + point2D.getX() + "\" y=\"" + point2D.getY() + "\"/>");
        closeName(str);
        return true;
    }

    public boolean printRectangle(String str, Object obj) {
        openName(str);
        Rectangle2D rectangle2D = (Rectangle2D) obj;
        this.fw.println(" x=\"" + rectangle2D.getX() + "\" y=\"" + rectangle2D.getY() + "\" width=\"" + rectangle2D.getWidth() + "\" height=\"" + rectangle2D.getHeight() + "\"/>");
        closeName(str);
        return true;
    }

    public void setWithComments(boolean z6) {
        this.withComments = z6;
    }

    public String tabs() {
        String str = TABS;
        return str.substring(0, Math.min(this.indent, str.length()));
    }

    public String trimHex(long j6, int i5) {
        String hexString = Long.toHexString(j6);
        int length = hexString.length();
        return ZEROS.substring(0, Math.max(0, i5 - length)) + hexString.substring(Math.max(0, length - i5), length);
    }

    public void write(GenericRecord genericRecord) {
        write("record", genericRecord);
    }

    public boolean writeChildren(GenericRecord genericRecord, boolean z6) {
        List<? extends GenericRecord> genericChildren = genericRecord.getGenericChildren();
        if (genericChildren == null || genericChildren.isEmpty()) {
            return false;
        }
        if (!z6) {
            this.fw.print(">");
        }
        this.indent++;
        this.fw.println();
        this.fw.println(tabs() + "<children>");
        this.indent = this.indent + 1;
        int i5 = this.childIndex;
        this.childIndex = 0;
        genericChildren.forEach(new j(this, 0));
        this.childIndex = i5;
        this.fw.println();
        this.indent--;
        this.fw.println(tabs() + "</children>");
        this.indent = this.indent - 1;
        return true;
    }

    public void writeError(String str) {
        printObject("error", str);
    }

    public Stream<Map.Entry<String, Supplier<?>>> writeProp(Map.Entry<String, Supplier<?>> entry) {
        final Object obj = entry.getValue().get();
        if (obj == null) {
            return Stream.empty();
        }
        boolean zIsComplex = isComplex(obj);
        if (this.attributePhase == zIsComplex) {
            return zIsComplex ? Stream.of(new AbstractMap.SimpleEntry(entry.getKey(), new Supplier() { // from class: org.apache.poi.util.g
                @Override // java.util.function.Supplier
                public final Object get() {
                    return GenericRecordXmlWriter.lambda$writeProp$1(obj);
                }
            })) : Stream.empty();
        }
        int i5 = this.childIndex;
        this.childIndex = 0;
        writeValue(entry.getKey(), obj);
        this.childIndex = i5;
        return Stream.empty();
    }

    public boolean writeProperties(GenericRecord genericRecord) {
        Map<String, Supplier<?>> genericProperties = genericRecord.getGenericProperties();
        if (genericProperties == null || genericProperties.isEmpty()) {
            return false;
        }
        int i5 = this.childIndex;
        this.childIndex = 0;
        List list = (List) genericProperties.entrySet().stream().flatMap(new Function() { // from class: org.apache.poi.util.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7252a.writeProp((Map.Entry) obj);
            }
        }).collect(Collectors.toList());
        this.attributePhase = false;
        if (!list.isEmpty()) {
            this.fw.println(">");
            this.indent++;
            list.forEach(new j(this, 1));
            this.indent--;
        }
        this.childIndex = i5;
        return !list.isEmpty();
    }

    public void writeValue(String str, Object obj) {
        if (obj instanceof GenericRecord) {
            printGenericRecord(str, obj);
        } else if (obj != null) {
            if (str.endsWith(">")) {
                this.fw.print("\t");
            }
            int i5 = 1;
            handler.stream().filter(new c(obj, i5)).findFirst().ifPresent(new org.apache.poi.hssf.usermodel.a(this, i5, str, obj));
        }
    }

    public static String marshal(GenericRecord genericRecord, boolean z6) {
        StringBuilder sb = new StringBuilder();
        try {
            GenericRecordXmlWriter genericRecordXmlWriter = new GenericRecordXmlWriter(sb);
            try {
                genericRecordXmlWriter.setWithComments(z6);
                genericRecordXmlWriter.write(genericRecord);
                String string = sb.toString();
                genericRecordXmlWriter.close();
                return string;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        genericRecordXmlWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return "<record/>";
        }
    }

    public void write(String str, GenericRecord genericRecord) {
        String strTabs = tabs();
        Enum<?> genericRecordType = genericRecord.getGenericRecordType();
        String strName = genericRecordType != null ? genericRecordType.name() : genericRecord.getClass().getSimpleName();
        this.fw.append((CharSequence) strTabs);
        this.fw.append((CharSequence) "<").append((CharSequence) str).append((CharSequence) " type=\"");
        this.fw.append((CharSequence) strName);
        this.fw.append((CharSequence) "\"");
        if (this.childIndex > 0) {
            this.fw.append((CharSequence) " index=\"");
            this.fw.print(this.childIndex);
            this.fw.append((CharSequence) "\"");
        }
        this.attributePhase = true;
        boolean zWriteProperties = writeProperties(genericRecord);
        this.attributePhase = false;
        if (!writeChildren(genericRecord, zWriteProperties) && !zWriteProperties) {
            this.fw.println("/>");
            return;
        }
        this.fw.append((CharSequence) strTabs);
        this.fw.println("</" + str + ">");
    }

    public GenericRecordXmlWriter(Appendable appendable) {
        this.fw = new PrintWriter(new GenericRecordJsonWriter.AppendableWriter(appendable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$writeProp$1(Object obj) {
        return obj;
    }
}
