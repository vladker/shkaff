package org.apache.poi.xdgf.usermodel.section;

import com.google.common.net.HttpHeaders;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LINE_GRADIENT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
final class XDGFSectionTypes {
    private static final /* synthetic */ XDGFSectionTypes[] $VALUES;
    public static final XDGFSectionTypes ACTIONS;
    public static final XDGFSectionTypes ACTION_TAG;
    public static final XDGFSectionTypes ANNOTATION;
    public static final XDGFSectionTypes CHARACTER;
    public static final XDGFSectionTypes CONNECTION;
    public static final XDGFSectionTypes CONNECTION_ABCD;
    public static final XDGFSectionTypes CONTROL;
    public static final XDGFSectionTypes FIELD;
    public static final XDGFSectionTypes FILL_GRADIENT;
    public static final XDGFSectionTypes GEOMETRY;
    public static final XDGFSectionTypes HYPERLINK;
    public static final XDGFSectionTypes LAYER;
    public static final XDGFSectionTypes LINE_GRADIENT;
    private static final Map<String, XDGFSectionTypes> LOOKUP;
    public static final XDGFSectionTypes PARAGRAPH;
    public static final XDGFSectionTypes PROPERTY;
    public static final XDGFSectionTypes REVIEWER;
    public static final XDGFSectionTypes SCRATCH;
    public static final XDGFSectionTypes TABS;
    public static final XDGFSectionTypes USER;
    private final BiFunction<SectionType, XDGFSheet, ? extends XDGFSection> constructor;
    private final String sectionType;

    static {
        final int i5 = 0;
        final int i6 = 0;
        XDGFSectionTypes xDGFSectionTypes = new XDGFSectionTypes("LINE_GRADIENT", 0, "LineGradient", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i5) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        LINE_GRADIENT = xDGFSectionTypes;
        XDGFSectionTypes xDGFSectionTypes2 = new XDGFSectionTypes("FILL_GRADIENT", 1, "FillGradient", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        FILL_GRADIENT = xDGFSectionTypes2;
        final int i7 = 2;
        XDGFSectionTypes xDGFSectionTypes3 = new XDGFSectionTypes("CHARACTER", 2, "Character", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i7) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        CHARACTER = xDGFSectionTypes3;
        final int i8 = 0;
        XDGFSectionTypes xDGFSectionTypes4 = new XDGFSectionTypes("PARAGRAPH", 3, "Paragraph", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i8) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        PARAGRAPH = xDGFSectionTypes4;
        final int i9 = 0;
        XDGFSectionTypes xDGFSectionTypes5 = new XDGFSectionTypes("TABS", 4, "Tabs", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i9) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        TABS = xDGFSectionTypes5;
        final int i10 = 0;
        XDGFSectionTypes xDGFSectionTypes6 = new XDGFSectionTypes("SCRATCH", 5, "Scratch", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i10) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        SCRATCH = xDGFSectionTypes6;
        final int i11 = 0;
        XDGFSectionTypes xDGFSectionTypes7 = new XDGFSectionTypes("CONNECTION", 6, HttpHeaders.CONNECTION, new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i11) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        CONNECTION = xDGFSectionTypes7;
        final int i12 = 0;
        XDGFSectionTypes xDGFSectionTypes8 = new XDGFSectionTypes("CONNECTION_ABCD", 7, "ConnectionABCD", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i12) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        CONNECTION_ABCD = xDGFSectionTypes8;
        final int i13 = 0;
        XDGFSectionTypes xDGFSectionTypes9 = new XDGFSectionTypes("FIELD", 8, "Field", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i13) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        FIELD = xDGFSectionTypes9;
        final int i14 = 0;
        XDGFSectionTypes xDGFSectionTypes10 = new XDGFSectionTypes("CONTROL", 9, "Control", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i14) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        CONTROL = xDGFSectionTypes10;
        final int i15 = 1;
        XDGFSectionTypes xDGFSectionTypes11 = new XDGFSectionTypes("GEOMETRY", 10, "Geometry", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i15) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        GEOMETRY = xDGFSectionTypes11;
        final int i16 = 0;
        XDGFSectionTypes xDGFSectionTypes12 = new XDGFSectionTypes("ACTIONS", 11, "Actions", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i16) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        ACTIONS = xDGFSectionTypes12;
        final int i17 = 0;
        XDGFSectionTypes xDGFSectionTypes13 = new XDGFSectionTypes("LAYER", 12, "Layer", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i17) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        LAYER = xDGFSectionTypes13;
        final int i18 = 0;
        XDGFSectionTypes xDGFSectionTypes14 = new XDGFSectionTypes("USER", 13, "User", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i18) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        USER = xDGFSectionTypes14;
        final int i19 = 0;
        XDGFSectionTypes xDGFSectionTypes15 = new XDGFSectionTypes("PROPERTY", 14, "Property", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i19) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        PROPERTY = xDGFSectionTypes15;
        final int i20 = 0;
        XDGFSectionTypes xDGFSectionTypes16 = new XDGFSectionTypes("HYPERLINK", 15, "Hyperlink", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i20) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        HYPERLINK = xDGFSectionTypes16;
        final int i21 = 0;
        XDGFSectionTypes xDGFSectionTypes17 = new XDGFSectionTypes("REVIEWER", 16, "Reviewer", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i21) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        REVIEWER = xDGFSectionTypes17;
        final int i22 = 0;
        XDGFSectionTypes xDGFSectionTypes18 = new XDGFSectionTypes("ANNOTATION", 17, "Annotation", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i22) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        ANNOTATION = xDGFSectionTypes18;
        final int i23 = 0;
        XDGFSectionTypes xDGFSectionTypes19 = new XDGFSectionTypes("ACTION_TAG", 18, "ActionTag", new BiFunction() { // from class: org.apache.poi.xdgf.usermodel.section.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i23) {
                    case 0:
                        return new GenericSection((SectionType) obj, (XDGFSheet) obj2);
                    case 1:
                        return new GeometrySection((SectionType) obj, (XDGFSheet) obj2);
                    default:
                        return new CharacterSection((SectionType) obj, (XDGFSheet) obj2);
                }
            }
        });
        ACTION_TAG = xDGFSectionTypes19;
        $VALUES = new XDGFSectionTypes[]{xDGFSectionTypes, xDGFSectionTypes2, xDGFSectionTypes3, xDGFSectionTypes4, xDGFSectionTypes5, xDGFSectionTypes6, xDGFSectionTypes7, xDGFSectionTypes8, xDGFSectionTypes9, xDGFSectionTypes10, xDGFSectionTypes11, xDGFSectionTypes12, xDGFSectionTypes13, xDGFSectionTypes14, xDGFSectionTypes15, xDGFSectionTypes16, xDGFSectionTypes17, xDGFSectionTypes18, xDGFSectionTypes19};
        LOOKUP = (Map) Stream.of((Object[]) values()).collect(Collectors.toMap(new a(1), Function.identity()));
    }

    private XDGFSectionTypes(String str, int i5, String str2, BiFunction biFunction) {
        super(str, i5);
        this.sectionType = str2;
        this.constructor = biFunction;
    }

    public static XDGFSection load(SectionType sectionType, XDGFSheet xDGFSheet) {
        String n6 = sectionType.getN();
        XDGFSectionTypes xDGFSectionTypes = LOOKUP.get(n6);
        if (xDGFSectionTypes != null) {
            return xDGFSectionTypes.constructor.apply(sectionType, xDGFSheet);
        }
        throw new POIXMLException(androidx.collection.a.p("Invalid '", sectionType.schemaType().getName().getLocalPart(), "' name '", n6, "'"));
    }

    public static XDGFSectionTypes valueOf(String str) {
        return (XDGFSectionTypes) Enum.valueOf(XDGFSectionTypes.class, str);
    }

    public static XDGFSectionTypes[] values() {
        return (XDGFSectionTypes[]) $VALUES.clone();
    }

    public String getSectionType() {
        return this.sectionType;
    }
}
