package org.apache.poi.sl.draw.geom;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.xml.stream.XMLStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class PresetParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = LogManager.getLogger((Class<?>) PresetParser.class);
    private CustomGeometry customGeometry;
    private final Map<String, CustomGeometry> geom;
    private Mode mode;
    private Path path;
    private boolean useAdjustValue;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.geom.PresetParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode = iArr;
            try {
                iArr[Mode.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.SHAPE_LST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.SHAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.CXN_LST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.AH_LST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.GUIDE_LST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.PATH_LST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[Mode.PATH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FILE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Mode {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode AH_LST;
        public static final Mode CXN_LST;
        public static final Mode FILE;
        public static final Mode GUIDE_LST;
        public static final Mode PATH;
        public static final Mode PATH_LST;
        public static final Mode SHAPE;
        public static final Mode SHAPE_LST;
        final Handler handler;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Handler {
            void update(PresetParser presetParser, XMLStreamReader xMLStreamReader);
        }

        static {
            final int i5 = 0;
            Mode mode = new Mode("FILE", 0, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i5) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            FILE = mode;
            final int i6 = 1;
            Mode mode2 = new Mode("SHAPE_LST", 1, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i6) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            SHAPE_LST = mode2;
            final int i7 = 2;
            Mode mode3 = new Mode("SHAPE", 2, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i7) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            SHAPE = mode3;
            final int i8 = 3;
            Mode mode4 = new Mode("GUIDE_LST", 3, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i8) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            GUIDE_LST = mode4;
            final int i9 = 4;
            Mode mode5 = new Mode("AH_LST", 4, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i9) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            AH_LST = mode5;
            final int i10 = 5;
            Mode mode6 = new Mode("CXN_LST", 5, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i10) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            CXN_LST = mode6;
            final int i11 = 6;
            Mode mode7 = new Mode("PATH_LST", 6, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i11) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            PATH_LST = mode7;
            final int i12 = 7;
            Mode mode8 = new Mode("PATH", 7, new Handler() { // from class: org.apache.poi.sl.draw.geom.b
                @Override // org.apache.poi.sl.draw.geom.PresetParser.Mode.Handler
                public final void update(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
                    switch (i12) {
                        case 0:
                            PresetParser.access$700(presetParser, xMLStreamReader);
                            break;
                        case 1:
                            PresetParser.access$600(presetParser, xMLStreamReader);
                            break;
                        case 2:
                            PresetParser.access$500(presetParser, xMLStreamReader);
                            break;
                        case 3:
                            PresetParser.access$400(presetParser, xMLStreamReader);
                            break;
                        case 4:
                            PresetParser.access$300(presetParser, xMLStreamReader);
                            break;
                        case 5:
                            PresetParser.access$200(presetParser, xMLStreamReader);
                            break;
                        case 6:
                            PresetParser.access$100(presetParser, xMLStreamReader);
                            break;
                        default:
                            PresetParser.access$000(presetParser, xMLStreamReader);
                            break;
                    }
                }
            });
            PATH = mode8;
            $VALUES = new Mode[]{mode, mode2, mode3, mode4, mode5, mode6, mode7, mode8};
        }

        private Mode(String str, int i5, Handler handler) {
            super(str, i5);
            this.handler = handler;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public PresetParser(Mode mode) {
        HashMap map = new HashMap();
        this.geom = map;
        this.mode = mode;
        if (mode == Mode.SHAPE) {
            CustomGeometry customGeometry = new CustomGeometry();
            this.customGeometry = customGeometry;
            map.put("custom", customGeometry);
        }
    }

    public static /* synthetic */ void access$000(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updatePath(xMLStreamReader);
    }

    public static /* synthetic */ void access$100(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updatePathLst(xMLStreamReader);
    }

    public static /* synthetic */ void access$200(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updateCxnList(xMLStreamReader);
    }

    public static /* synthetic */ void access$300(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updateAhList(xMLStreamReader);
    }

    public static /* synthetic */ void access$400(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updateGuideList(xMLStreamReader);
    }

    public static /* synthetic */ void access$500(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updateShape(xMLStreamReader);
    }

    public static /* synthetic */ void access$600(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updateShapeList(xMLStreamReader);
    }

    public static /* synthetic */ void access$700(PresetParser presetParser, XMLStreamReader xMLStreamReader) {
        presetParser.updateFile(xMLStreamReader);
    }

    private void addPolar(XMLStreamReader xMLStreamReader) {
        PolarAdjustHandle polarAdjustHandle = new PolarAdjustHandle();
        this.customGeometry.addAdjustHandle(polarAdjustHandle);
        parseAttributes(xMLStreamReader, new a(polarAdjustHandle, 2));
        polarAdjustHandle.setPos(parsePosPoint(xMLStreamReader));
    }

    private void addRectangle(XMLStreamReader xMLStreamReader) {
        String[] strArr = new String[4];
        parseAttributes(xMLStreamReader, new a(strArr, 4));
        this.customGeometry.setTextBounds(strArr[0], strArr[1], strArr[2], strArr[3]);
        nextTag(xMLStreamReader);
    }

    private void addXY(XMLStreamReader xMLStreamReader) {
        XYAdjustHandle xYAdjustHandle = new XYAdjustHandle();
        this.customGeometry.addAdjustHandle(xYAdjustHandle);
        parseAttributes(xMLStreamReader, new a(xYAdjustHandle, 6));
        xYAdjustHandle.setPos(parsePosPoint(xMLStreamReader));
    }

    private void arcTo(XMLStreamReader xMLStreamReader) {
        ArcToCommand arcToCommand = new ArcToCommand();
        this.path.addCommand(arcToCommand);
        parseAttributes(xMLStreamReader, new a(arcToCommand, 1));
        nextTag(xMLStreamReader);
    }

    private void closePath(XMLStreamReader xMLStreamReader) {
        this.path.addCommand(new ClosePathCommand());
        nextTag(xMLStreamReader);
    }

    private static String collapseString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i5 = 0;
        while (i5 < length && !isWhiteSpace(str.charAt(i5))) {
            i5++;
        }
        if (i5 == length) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length);
        if (i5 != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                sb.append(str.charAt(i6));
            }
            sb.append(Chars.SPACE);
        }
        boolean z6 = true;
        for (int i7 = i5 + 1; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            boolean zIsWhiteSpace = isWhiteSpace(cCharAt);
            if (!z6 || !zIsWhiteSpace) {
                if (zIsWhiteSpace) {
                    cCharAt = ' ';
                }
                sb.append(cCharAt);
                z6 = zIsWhiteSpace;
            }
        }
        int length2 = sb.length();
        if (length2 > 0) {
            int i8 = length2 - 1;
            if (sb.charAt(i8) == ' ') {
                sb.setLength(i8);
            }
        }
        return sb.toString();
    }

    private void cubicBezTo(XMLStreamReader xMLStreamReader) {
        CurveToCommand curveToCommand = new CurveToCommand();
        this.path.addCommand(curveToCommand);
        AdjustPoint ptPoint = parsePtPoint(xMLStreamReader, false);
        AdjustPoint ptPoint2 = parsePtPoint(xMLStreamReader, false);
        AdjustPoint ptPoint3 = parsePtPoint(xMLStreamReader, true);
        curveToCommand.setPt1(ptPoint);
        curveToCommand.setPt2(ptPoint2);
        curveToCommand.setPt3(ptPoint3);
    }

    private void endContext() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$draw$geom$PresetParser$Mode[this.mode.ordinal()]) {
            case 1:
            case 2:
                this.mode = Mode.FILE;
                break;
            case 3:
                this.mode = Mode.SHAPE_LST;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                this.useAdjustValue = false;
                this.path = null;
                this.mode = Mode.SHAPE;
                break;
            case 8:
                this.path = null;
                this.mode = Mode.PATH_LST;
                break;
        }
    }

    private static boolean isWhiteSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addPolar$2(PolarAdjustHandle polarAdjustHandle, String str, String str2) {
        str.getClass();
        switch (str) {
            case "gdRefR":
                polarAdjustHandle.setGdRefR(collapseString(str2));
                break;
            case "maxAng":
                polarAdjustHandle.setMaxAng(str2);
                break;
            case "minAng":
                polarAdjustHandle.setMinAng(str2);
                break;
            case "maxR":
                polarAdjustHandle.setMaxR(str2);
                break;
            case "minR":
                polarAdjustHandle.setMinR(str2);
                break;
            case "gdRefAng":
                polarAdjustHandle.setGdRefAng(collapseString(str2));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addRectangle$6(String[] strArr, String str, String str2) {
        str.getClass();
        switch (str) {
            case "b":
                strArr[3] = str2;
                break;
            case "l":
                strArr[0] = str2;
                break;
            case "r":
                strArr[2] = str2;
                break;
            case "t":
                strArr[1] = str2;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addXY$1(XYAdjustHandle xYAdjustHandle, String str, String str2) {
        str.getClass();
        switch (str) {
            case "gdRefX":
                xYAdjustHandle.setGdRefX(collapseString(str2));
                break;
            case "gdRefY":
                xYAdjustHandle.setGdRefY(collapseString(str2));
                break;
            case "maxX":
                xYAdjustHandle.setMaxX(str2);
                break;
            case "maxY":
                xYAdjustHandle.setMaxY(str2);
                break;
            case "minX":
                xYAdjustHandle.setMinX(str2);
                break;
            case "minY":
                xYAdjustHandle.setMinY(str2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arcTo$5(ArcToCommand arcToCommand, String str, String str2) {
        str.getClass();
        switch (str) {
            case "hR":
                arcToCommand.setHR(str2);
                break;
            case "wR":
                arcToCommand.setWR(str2);
                break;
            case "stAng":
                arcToCommand.setStAng(str2);
                break;
            case "swAng":
                arcToCommand.setSwAng(str2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$parseAdjPoint$7(AdjustPoint adjustPoint, String str, String str2) {
        str.getClass();
        if (str.equals("x")) {
            adjustPoint.setX(str2);
        } else if (str.equals("y")) {
            adjustPoint.setY(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateCxnList$3(ConnectionSite connectionSite, String str, String str2) {
        if ("ang".equals(str)) {
            connectionSite.setAng(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateGuideList$0(Guide guide, String str, String str2) {
        str.getClass();
        if (str.equals("fmla")) {
            guide.setFmla(str2);
        } else if (str.equals("name")) {
            guide.setName(collapseString(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePathLst$4(String str, String str2) {
        str.getClass();
        switch (str) {
            case "extrusionOk":
                this.path.setExtrusionOk(Boolean.parseBoolean(str2));
                break;
            case "stroke":
                this.path.setStroke(Boolean.parseBoolean(str2));
                break;
            case "h":
                this.path.setH(Long.parseLong(str2));
                break;
            case "w":
                this.path.setW(Long.parseLong(str2));
                break;
            case "fill":
                this.path.setFill(mapFill(str2));
                break;
        }
    }

    private void lineTo(XMLStreamReader xMLStreamReader) {
        LineToCommand lineToCommand = new LineToCommand();
        this.path.addCommand(lineToCommand);
        lineToCommand.setPt(parsePtPoint(xMLStreamReader, true));
    }

    private static PaintStyle.PaintModifier mapFill(String str) {
        switch (str.hashCode()) {
            case -2005126536:
                if (str.equals("lightenLess")) {
                    return PaintStyle.PaintModifier.LIGHTEN_LESS;
                }
                break;
            case -1414880040:
                if (str.equals("darkenLess")) {
                    return PaintStyle.PaintModifier.DARKEN_LESS;
                }
                break;
            case -1338968417:
                if (str.equals("darken")) {
                    return PaintStyle.PaintModifier.DARKEN;
                }
                break;
            case 3387192:
                str.equals("none");
                break;
            case 3387324:
                if (str.equals("norm")) {
                    return PaintStyle.PaintModifier.NORM;
                }
                break;
            case 170546239:
                if (str.equals("lighten")) {
                    return PaintStyle.PaintModifier.LIGHTEN;
                }
                break;
        }
        return PaintStyle.PaintModifier.NONE;
    }

    private void moveTo(XMLStreamReader xMLStreamReader) {
        MoveToCommand moveToCommand = new MoveToCommand();
        this.path.addCommand(moveToCommand);
        moveToCommand.setPt(parsePtPoint(xMLStreamReader, true));
    }

    private static int nextTag(XMLStreamReader xMLStreamReader) {
        int next;
        do {
            next = xMLStreamReader.next();
            if (next == 1 || next == 2) {
                break;
            }
        } while (next != 8);
        return next;
    }

    private AdjustPoint parseAdjPoint(XMLStreamReader xMLStreamReader, boolean z6, String str) {
        if (nextTag(xMLStreamReader) == 2) {
            return null;
        }
        AdjustPoint adjustPoint = new AdjustPoint();
        parseAttributes(xMLStreamReader, new a(adjustPoint, 3));
        nextTag(xMLStreamReader);
        if (z6) {
            nextTag(xMLStreamReader);
        }
        return adjustPoint;
    }

    private void parseAttributes(XMLStreamReader xMLStreamReader, BiConsumer<String, String> biConsumer) {
        for (int i5 = 0; i5 < xMLStreamReader.getAttributeCount(); i5++) {
            biConsumer.accept(xMLStreamReader.getAttributeLocalName(i5), xMLStreamReader.getAttributeValue(i5));
        }
    }

    private AdjustPoint parsePosPoint(XMLStreamReader xMLStreamReader) {
        return parseAdjPoint(xMLStreamReader, true, "pos");
    }

    private AdjustPoint parsePtPoint(XMLStreamReader xMLStreamReader, boolean z6) {
        return parseAdjPoint(xMLStreamReader, z6, "pt");
    }

    private void quadBezTo(XMLStreamReader xMLStreamReader) {
        QuadToCommand quadToCommand = new QuadToCommand();
        this.path.addCommand(quadToCommand);
        AdjustPoint ptPoint = parsePtPoint(xMLStreamReader, false);
        AdjustPoint ptPoint2 = parsePtPoint(xMLStreamReader, true);
        quadToCommand.setPt1(ptPoint);
        quadToCommand.setPt2(ptPoint2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAhList(XMLStreamReader xMLStreamReader) {
        String localName = xMLStreamReader.getLocalName();
        localName.getClass();
        if (localName.equals("ahPolar")) {
            addPolar(xMLStreamReader);
        } else if (localName.equals("ahXY")) {
            addXY(xMLStreamReader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCxnList(XMLStreamReader xMLStreamReader) {
        xMLStreamReader.getLocalName();
        ConnectionSite connectionSite = new ConnectionSite();
        this.customGeometry.addConnectionSite(connectionSite);
        parseAttributes(xMLStreamReader, new a(connectionSite, 5));
        connectionSite.setPos(parsePosPoint(xMLStreamReader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFile(XMLStreamReader xMLStreamReader) {
        xMLStreamReader.getLocalName();
        this.mode = Mode.SHAPE_LST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void updateGuideList(XMLStreamReader xMLStreamReader) {
        Object obj;
        xMLStreamReader.getLocalName();
        if (this.useAdjustValue) {
            CustomGeometry customGeometry = this.customGeometry;
            AdjustValue adjustValue = new AdjustValue();
            customGeometry.addAdjustGuide(adjustValue);
            obj = adjustValue;
        } else {
            CustomGeometry customGeometry2 = this.customGeometry;
            Guide guide = new Guide();
            customGeometry2.addGeomGuide(guide);
            obj = guide;
        }
        parseAttributes(xMLStreamReader, new a(obj, 0));
        nextTag(xMLStreamReader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePath(XMLStreamReader xMLStreamReader) {
        String localName = xMLStreamReader.getLocalName();
        localName.getClass();
        switch (localName) {
            case "quadBezTo":
                quadBezTo(xMLStreamReader);
                break;
            case "moveTo":
                moveTo(xMLStreamReader);
                break;
            case "lnTo":
                lineTo(xMLStreamReader);
                break;
            case "arcTo":
                arcTo(xMLStreamReader);
                break;
            case "close":
                closePath(xMLStreamReader);
                break;
            case "cubicBezTo":
                cubicBezTo(xMLStreamReader);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePathLst(XMLStreamReader xMLStreamReader) {
        xMLStreamReader.getLocalName();
        Path path = new Path();
        this.path = path;
        this.customGeometry.addPath(path);
        parseAttributes(xMLStreamReader, new a(this, 7));
        this.mode = Mode.PATH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShape(XMLStreamReader xMLStreamReader) {
        String localName = xMLStreamReader.getLocalName();
        localName.getClass();
        switch (localName) {
            case "cxnLst":
                this.mode = Mode.CXN_LST;
                break;
            case "pathLst":
                this.mode = Mode.PATH_LST;
                break;
            case "rect":
                addRectangle(xMLStreamReader);
                break;
            case "ahLst":
                this.mode = Mode.AH_LST;
                break;
            case "avLst":
                this.useAdjustValue = true;
                this.mode = Mode.GUIDE_LST;
                break;
            case "gdLst":
                this.useAdjustValue = false;
                this.mode = Mode.GUIDE_LST;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShapeList(XMLStreamReader xMLStreamReader) {
        String localName = xMLStreamReader.getLocalName();
        this.customGeometry = new CustomGeometry();
        if (this.geom.containsKey(localName)) {
            LOG.atWarn().log("Duplicate definition of {}", localName);
        }
        this.geom.put(localName, this.customGeometry);
        this.mode = Mode.SHAPE;
    }

    public Map<String, CustomGeometry> getGeom() {
        return this.geom;
    }

    public void parse(XMLStreamReader xMLStreamReader) {
        while (xMLStreamReader.hasNext()) {
            int next = xMLStreamReader.next();
            if (next == 1) {
                this.mode.handler.update(this, xMLStreamReader);
            } else if (next == 2) {
                endContext();
            } else if (next == 8) {
                return;
            }
        }
    }
}
