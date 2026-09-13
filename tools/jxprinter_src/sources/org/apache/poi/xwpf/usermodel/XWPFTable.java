package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.usermodel.g;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJcTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFTable implements IBodyElement, ISDTContents {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DEFAULT_PERCENTAGE_WIDTH = "100%";
    public static final String REGEX_PERCENTAGE = "[0-9]+(\\.[0-9]+)?%";
    public static final String REGEX_WIDTH_VALUE = "auto|[0-9]+|[0-9]+(\\.[0-9]+)?%";
    private static final HashMap<Integer, XWPFBorderType> stBorderTypeMap;
    private static final EnumMap<XWPFBorderType, STBorder.Enum> xwpfBorderTypeMap;
    private final CTTbl ctTbl;
    protected IBody part;
    protected final List<XWPFTableRow> tableRows;
    protected StringBuilder text;

    /* JADX INFO: renamed from: org.apache.poi.xwpf.usermodel.XWPFTable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border;

        static {
            int[] iArr = new int[Border.values().length];
            $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border = iArr;
            try {
                iArr[Border.INSIDE_V.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[Border.INSIDE_H.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[Border.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[Border.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[Border.RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[Border.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Border {
        INSIDE_V,
        INSIDE_H,
        LEFT,
        TOP,
        BOTTOM,
        RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum XWPFBorderType {
        NIL,
        NONE,
        SINGLE,
        THICK,
        DOUBLE,
        DOTTED,
        DASHED,
        DOT_DASH,
        DOT_DOT_DASH,
        TRIPLE,
        THIN_THICK_SMALL_GAP,
        THICK_THIN_SMALL_GAP,
        THIN_THICK_THIN_SMALL_GAP,
        THIN_THICK_MEDIUM_GAP,
        THICK_THIN_MEDIUM_GAP,
        THIN_THICK_THIN_MEDIUM_GAP,
        THIN_THICK_LARGE_GAP,
        THICK_THIN_LARGE_GAP,
        THIN_THICK_THIN_LARGE_GAP,
        WAVE,
        DOUBLE_WAVE,
        DASH_SMALL_GAP,
        DASH_DOT_STROKED,
        THREE_D_EMBOSS,
        THREE_D_ENGRAVE,
        OUTSET,
        INSET
    }

    static {
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap = new EnumMap<>(XWPFBorderType.class);
        xwpfBorderTypeMap = enumMap;
        XWPFBorderType xWPFBorderType = XWPFBorderType.NIL;
        enumMap.put(xWPFBorderType, STBorder.NIL);
        XWPFBorderType xWPFBorderType2 = XWPFBorderType.NONE;
        enumMap.put(xWPFBorderType2, STBorder.NONE);
        XWPFBorderType xWPFBorderType3 = XWPFBorderType.SINGLE;
        enumMap.put(xWPFBorderType3, STBorder.SINGLE);
        XWPFBorderType xWPFBorderType4 = XWPFBorderType.THICK;
        enumMap.put(xWPFBorderType4, STBorder.THICK);
        XWPFBorderType xWPFBorderType5 = XWPFBorderType.DOUBLE;
        enumMap.put(xWPFBorderType5, STBorder.DOUBLE);
        XWPFBorderType xWPFBorderType6 = XWPFBorderType.DOTTED;
        enumMap.put(xWPFBorderType6, STBorder.DOTTED);
        XWPFBorderType xWPFBorderType7 = XWPFBorderType.DASHED;
        enumMap.put(xWPFBorderType7, STBorder.DASHED);
        XWPFBorderType xWPFBorderType8 = XWPFBorderType.DOT_DASH;
        enumMap.put(xWPFBorderType8, STBorder.DOT_DASH);
        XWPFBorderType xWPFBorderType9 = XWPFBorderType.DOT_DOT_DASH;
        enumMap.put(xWPFBorderType9, STBorder.DOT_DOT_DASH);
        XWPFBorderType xWPFBorderType10 = XWPFBorderType.TRIPLE;
        enumMap.put(xWPFBorderType10, STBorder.TRIPLE);
        XWPFBorderType xWPFBorderType11 = XWPFBorderType.THIN_THICK_SMALL_GAP;
        enumMap.put(xWPFBorderType11, STBorder.THIN_THICK_SMALL_GAP);
        XWPFBorderType xWPFBorderType12 = XWPFBorderType.THICK_THIN_SMALL_GAP;
        enumMap.put(xWPFBorderType12, STBorder.THICK_THIN_SMALL_GAP);
        XWPFBorderType xWPFBorderType13 = XWPFBorderType.THIN_THICK_THIN_SMALL_GAP;
        enumMap.put(xWPFBorderType13, STBorder.THIN_THICK_THIN_SMALL_GAP);
        XWPFBorderType xWPFBorderType14 = XWPFBorderType.THIN_THICK_MEDIUM_GAP;
        enumMap.put(xWPFBorderType14, STBorder.THIN_THICK_MEDIUM_GAP);
        XWPFBorderType xWPFBorderType15 = XWPFBorderType.THICK_THIN_MEDIUM_GAP;
        enumMap.put(xWPFBorderType15, STBorder.THICK_THIN_MEDIUM_GAP);
        XWPFBorderType xWPFBorderType16 = XWPFBorderType.THIN_THICK_THIN_MEDIUM_GAP;
        enumMap.put(xWPFBorderType16, STBorder.THIN_THICK_THIN_MEDIUM_GAP);
        XWPFBorderType xWPFBorderType17 = XWPFBorderType.THIN_THICK_LARGE_GAP;
        enumMap.put(xWPFBorderType17, STBorder.THIN_THICK_LARGE_GAP);
        XWPFBorderType xWPFBorderType18 = XWPFBorderType.THICK_THIN_LARGE_GAP;
        enumMap.put(xWPFBorderType18, STBorder.THICK_THIN_LARGE_GAP);
        XWPFBorderType xWPFBorderType19 = XWPFBorderType.THIN_THICK_THIN_LARGE_GAP;
        enumMap.put(xWPFBorderType19, STBorder.THIN_THICK_THIN_LARGE_GAP);
        XWPFBorderType xWPFBorderType20 = XWPFBorderType.WAVE;
        enumMap.put(xWPFBorderType20, STBorder.WAVE);
        XWPFBorderType xWPFBorderType21 = XWPFBorderType.DOUBLE_WAVE;
        enumMap.put(xWPFBorderType21, STBorder.DOUBLE_WAVE);
        XWPFBorderType xWPFBorderType22 = XWPFBorderType.DASH_SMALL_GAP;
        enumMap.put(xWPFBorderType22, STBorder.DASH_SMALL_GAP);
        XWPFBorderType xWPFBorderType23 = XWPFBorderType.DASH_DOT_STROKED;
        enumMap.put(xWPFBorderType23, STBorder.DASH_DOT_STROKED);
        XWPFBorderType xWPFBorderType24 = XWPFBorderType.THREE_D_EMBOSS;
        enumMap.put(xWPFBorderType24, STBorder.THREE_D_EMBOSS);
        XWPFBorderType xWPFBorderType25 = XWPFBorderType.THREE_D_ENGRAVE;
        enumMap.put(xWPFBorderType25, STBorder.THREE_D_ENGRAVE);
        XWPFBorderType xWPFBorderType26 = XWPFBorderType.OUTSET;
        enumMap.put(xWPFBorderType26, STBorder.OUTSET);
        XWPFBorderType xWPFBorderType27 = XWPFBorderType.INSET;
        enumMap.put(xWPFBorderType27, STBorder.INSET);
        HashMap<Integer, XWPFBorderType> map = new HashMap<>();
        stBorderTypeMap = map;
        map.put(1, xWPFBorderType);
        map.put(2, xWPFBorderType2);
        map.put(3, xWPFBorderType3);
        map.put(4, xWPFBorderType4);
        map.put(5, xWPFBorderType5);
        map.put(6, xWPFBorderType6);
        map.put(7, xWPFBorderType7);
        map.put(8, xWPFBorderType8);
        map.put(9, xWPFBorderType9);
        map.put(10, xWPFBorderType10);
        map.put(11, xWPFBorderType11);
        map.put(12, xWPFBorderType12);
        map.put(13, xWPFBorderType13);
        map.put(14, xWPFBorderType14);
        map.put(15, xWPFBorderType15);
        map.put(16, xWPFBorderType16);
        map.put(17, xWPFBorderType17);
        map.put(18, xWPFBorderType18);
        map.put(19, xWPFBorderType19);
        map.put(20, xWPFBorderType20);
        map.put(21, xWPFBorderType21);
        map.put(22, xWPFBorderType22);
        map.put(23, xWPFBorderType23);
        map.put(24, xWPFBorderType24);
        map.put(25, xWPFBorderType25);
        map.put(26, xWPFBorderType26);
        map.put(27, xWPFBorderType27);
    }

    public XWPFTable(CTTbl cTTbl, IBody iBody, int i5, int i6) {
        this(cTTbl, iBody);
        for (int i7 = 0; i7 < i5; i7++) {
            XWPFTableRow xWPFTableRowCreateRow = getRow(i7) == null ? createRow() : getRow(i7);
            for (int i8 = 0; i8 < i6; i8++) {
                if (xWPFTableRowCreateRow.getCell(i8) == null) {
                    xWPFTableRowCreateRow.createCell();
                }
            }
        }
    }

    private void addColumn(XWPFTableRow xWPFTableRow, int i5) {
        if (i5 > 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                xWPFTableRow.createCell();
            }
        }
    }

    private void cleanupTblBorders() {
        CTTblPr tblPr = getTblPr(false);
        if (tblPr == null || !tblPr.isSetTblBorders()) {
            return;
        }
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders.isSetInsideH() || tblBorders.isSetInsideV() || tblBorders.isSetTop() || tblBorders.isSetBottom() || tblBorders.isSetLeft() || tblBorders.isSetRight()) {
            return;
        }
        tblPr.unsetTblBorders();
    }

    private void createEmptyTable(CTTbl cTTbl) {
        cTTbl.addNewTr().addNewTc().addNewP();
        CTTblPr cTTblPrAddNewTblPr = cTTbl.addNewTblPr();
        cTTblPrAddNewTblPr.addNewTblW().setW(BigInteger.valueOf(0L));
        cTTblPrAddNewTblPr.getTblW().setType(STTblWidth.AUTO);
        CTTblBorders cTTblBordersAddNewTblBorders = cTTblPrAddNewTblPr.addNewTblBorders();
        CTBorder cTBorderAddNewBottom = cTTblBordersAddNewTblBorders.addNewBottom();
        STBorder.Enum r6 = STBorder.SINGLE;
        cTBorderAddNewBottom.setVal(r6);
        cTTblBordersAddNewTblBorders.addNewInsideH().setVal(r6);
        cTTblBordersAddNewTblBorders.addNewInsideV().setVal(r6);
        cTTblBordersAddNewTblBorders.addNewLeft().setVal(r6);
        cTTblBordersAddNewTblBorders.addNewRight().setVal(r6);
        cTTblBordersAddNewTblBorders.addNewTop().setVal(r6);
    }

    private String getBorderColor(Border border) {
        CTBorder tblBorder = getTblBorder(false, border);
        if (tblBorder == null || !tblBorder.isSetColor()) {
            return null;
        }
        return tblBorder.xgetColor().getStringValue();
    }

    private int getBorderSize(Border border) {
        CTBorder tblBorder = getTblBorder(false, border);
        if (tblBorder == null || !tblBorder.isSetSz()) {
            return -1;
        }
        return tblBorder.getSz().intValue();
    }

    private int getBorderSpace(Border border) {
        CTBorder tblBorder = getTblBorder(false, border);
        if (tblBorder == null || !tblBorder.isSetSpace()) {
            return -1;
        }
        return tblBorder.getSpace().intValue();
    }

    private XWPFBorderType getBorderType(Border border) {
        CTBorder tblBorder = getTblBorder(false, border);
        if (tblBorder != null) {
            return stBorderTypeMap.get(Integer.valueOf(tblBorder.getVal().intValue()));
        }
        return null;
    }

    private int getCellMargin(Function<CTTblCellMar, CTTblWidth> function) {
        CTTblWidth cTTblWidthApply;
        CTTblCellMar tblCellMar = getTblPr().getTblCellMar();
        if (tblCellMar == null || (cTTblWidthApply = function.apply(tblCellMar)) == null) {
            return 0;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTTblWidthApply.xgetW()));
    }

    private CTBorder getTblBorder(boolean z6, Border border) {
        g gVar;
        Function gVar2;
        Function gVar3;
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[border.ordinal()]) {
            case 1:
                gVar = new g(17);
                gVar2 = new g(28);
                gVar3 = new g(29);
                break;
            case 2:
                gVar = new g(14);
                gVar2 = new c(0);
                gVar3 = new c(1);
                break;
            case 3:
                gVar = new g(18);
                gVar2 = new c(2);
                gVar3 = new c(3);
                break;
            case 4:
                gVar = new g(19);
                gVar2 = new g(21);
                gVar3 = new g(22);
                break;
            case 5:
                gVar = new g(20);
                gVar2 = new g(24);
                gVar3 = new g(25);
                break;
            case 6:
                gVar = new g(15);
                gVar2 = new g(26);
                gVar3 = new g(27);
                break;
            default:
                return null;
        }
        CTTblBorders tblBorders = getTblBorders(z6);
        if (tblBorders == null) {
            return null;
        }
        if (((Boolean) gVar.apply(tblBorders)).booleanValue()) {
            return (CTBorder) gVar2.apply(tblBorders);
        }
        if (z6) {
            return (CTBorder) gVar3.apply(tblBorders);
        }
        return null;
    }

    private CTTblBorders getTblBorders(boolean z6) {
        CTTblPr tblPr = getTblPr(z6);
        if (tblPr == null) {
            return null;
        }
        if (tblPr.isSetTblBorders()) {
            return tblPr.getTblBorders();
        }
        if (z6) {
            return tblPr.addNewTblBorders();
        }
        return null;
    }

    private CTTblPr getTblPr() {
        return getTblPr(true);
    }

    private void removeBorder(Border border) {
        g gVar;
        b bVar;
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFTable$Border[border.ordinal()]) {
            case 1:
                gVar = new g(17);
                bVar = new b(4);
                break;
            case 2:
                gVar = new g(14);
                bVar = new b(3);
                break;
            case 3:
                gVar = new g(18);
                bVar = new b(5);
                break;
            case 4:
                gVar = new g(19);
                bVar = new b(6);
                break;
            case 5:
                gVar = new g(20);
                bVar = new b(7);
                break;
            case 6:
                gVar = new g(15);
                bVar = new b(2);
                break;
            default:
                return;
        }
        CTTblBorders tblBorders = getTblBorders(false);
        if (tblBorders == null || !((Boolean) gVar.apply(tblBorders)).booleanValue()) {
            return;
        }
        bVar.accept(tblBorders);
        cleanupTblBorders();
    }

    private void setBorder(Border border, XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        CTBorder tblBorder = getTblBorder(true, border);
        tblBorder.setVal(xwpfBorderTypeMap.get(xWPFBorderType));
        tblBorder.setSz(BigInteger.valueOf(i5));
        tblBorder.setSpace(BigInteger.valueOf(i6));
        tblBorder.setColor(str);
    }

    private void setCellMargin(CTTblCellMar cTTblCellMar, Function<CTTblCellMar, Boolean> function, Function<CTTblCellMar, CTTblWidth> function2, Function<CTTblCellMar, CTTblWidth> function3, Consumer<CTTblCellMar> consumer, int i5) {
        if (i5 == 0) {
            if (function.apply(cTTblCellMar).booleanValue()) {
                consumer.accept(cTTblCellMar);
            }
        } else {
            if (!function.apply(cTTblCellMar).booleanValue()) {
                function2 = function3;
            }
            CTTblWidth cTTblWidthApply = function2.apply(cTTblCellMar);
            cTTblWidthApply.setType(STTblWidth.DXA);
            cTTblWidthApply.setW(BigInteger.valueOf(i5));
        }
    }

    public static void setWidthPercentage(CTTblWidth cTTblWidth, String str) {
        cTTblWidth.setType(STTblWidth.PCT);
        if (str.matches(REGEX_PERCENTAGE)) {
            cTTblWidth.setW(BigInteger.valueOf(Math.round(Double.parseDouble(str.substring(0, str.length() - 1)) * 50.0d)));
        } else {
            if (!str.matches("[0-9]+")) {
                throw new RuntimeException(AbstractC0157z.o("setWidthPercentage(): Width value must be a percentage (\"33.3%\" or an integer, was \"", str, "\""));
            }
            cTTblWidth.setW(new BigInteger(str));
        }
    }

    public static void setWidthValue(String str, CTTblWidth cTTblWidth) {
        if (!str.matches(REGEX_WIDTH_VALUE)) {
            throw new RuntimeException(AbstractC0157z.o("Table width value \"", str, "\" must match regular expression \"auto|[0-9]+|[0-9]+(\\.[0-9]+)?%\"."));
        }
        if (str.matches("auto")) {
            cTTblWidth.setType(STTblWidth.AUTO);
            cTTblWidth.setW(BigInteger.ZERO);
        } else if (str.matches(REGEX_PERCENTAGE)) {
            setWidthPercentage(cTTblWidth, str);
        } else {
            cTTblWidth.setW(new BigInteger(str));
            cTTblWidth.setType(STTblWidth.DXA);
        }
    }

    public void addNewCol() {
        if (this.tableRows.isEmpty()) {
            createRow();
        }
        Iterator<XWPFTableRow> it = this.tableRows.iterator();
        while (it.hasNext()) {
            it.next().createCell();
        }
    }

    public void addRow(XWPFTableRow xWPFTableRow) {
        this.ctTbl.addNewTr();
        this.ctTbl.setTrArray(getNumberOfRows() - 1, xWPFTableRow.getCtRow());
        this.tableRows.add(xWPFTableRow);
    }

    public XWPFTableRow createRow() {
        int iSizeOfTcArray = this.ctTbl.sizeOfTrArray() > 0 ? this.ctTbl.getTrArray(0).sizeOfTcArray() : 0;
        XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.addNewTr(), this);
        addColumn(xWPFTableRow, iSizeOfTcArray);
        this.tableRows.add(xWPFTableRow);
        return xWPFTableRow;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public IBody getBody() {
        return this.part;
    }

    public String getBottomBorderColor() {
        return getBorderColor(Border.BOTTOM);
    }

    public int getBottomBorderSize() {
        return getBorderSize(Border.BOTTOM);
    }

    public int getBottomBorderSpace() {
        return getBorderSpace(Border.BOTTOM);
    }

    public XWPFBorderType getBottomBorderType() {
        return getBorderType(Border.BOTTOM);
    }

    @Internal
    public CTTbl getCTTbl() {
        return this.ctTbl;
    }

    public int getCellMarginBottom() {
        return getCellMargin(new g(9));
    }

    public int getCellMarginLeft() {
        return getCellMargin(new g(11));
    }

    public int getCellMarginRight() {
        return getCellMargin(new c(5));
    }

    public int getCellMarginTop() {
        return getCellMargin(new c(7));
    }

    public int getColBandSize() {
        CTTblPr tblPr = getTblPr();
        if (tblPr.isSetTblStyleColBandSize()) {
            return tblPr.getTblStyleColBandSize().getVal().intValue();
        }
        return 0;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyElementType getElementType() {
        return BodyElementType.TABLE;
    }

    public String getInsideHBorderColor() {
        return getBorderColor(Border.INSIDE_H);
    }

    public int getInsideHBorderSize() {
        return getBorderSize(Border.INSIDE_H);
    }

    public int getInsideHBorderSpace() {
        return getBorderSpace(Border.INSIDE_H);
    }

    public XWPFBorderType getInsideHBorderType() {
        return getBorderType(Border.INSIDE_H);
    }

    public String getInsideVBorderColor() {
        return getBorderColor(Border.INSIDE_V);
    }

    public int getInsideVBorderSize() {
        return getBorderSize(Border.INSIDE_V);
    }

    public int getInsideVBorderSpace() {
        return getBorderSpace(Border.INSIDE_V);
    }

    public XWPFBorderType getInsideVBorderType() {
        return getBorderType(Border.INSIDE_V);
    }

    public String getLeftBorderColor() {
        return getBorderColor(Border.LEFT);
    }

    public int getLeftBorderSize() {
        return getBorderSize(Border.LEFT);
    }

    public int getLeftBorderSpace() {
        return getBorderSpace(Border.LEFT);
    }

    public XWPFBorderType getLeftBorderType() {
        return getBorderType(Border.LEFT);
    }

    public int getNumberOfRows() {
        return this.ctTbl.sizeOfTrArray();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement, org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody iBody = this.part;
        if (iBody != null) {
            return iBody.getPart();
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyType getPartType() {
        return this.part.getPartType();
    }

    public String getRightBorderColor() {
        return getBorderColor(Border.RIGHT);
    }

    public int getRightBorderSize() {
        return getBorderSize(Border.RIGHT);
    }

    public int getRightBorderSpace() {
        return getBorderSpace(Border.RIGHT);
    }

    public XWPFBorderType getRightBorderType() {
        return getBorderType(Border.RIGHT);
    }

    public XWPFTableRow getRow(int i5) {
        if (i5 < 0 || i5 >= this.ctTbl.sizeOfTrArray()) {
            return null;
        }
        return getRows().get(i5);
    }

    public int getRowBandSize() {
        CTTblPr tblPr = getTblPr();
        if (tblPr.isSetTblStyleRowBandSize()) {
            return tblPr.getTblStyleRowBandSize().getVal().intValue();
        }
        return 0;
    }

    public List<XWPFTableRow> getRows() {
        return Collections.unmodifiableList(this.tableRows);
    }

    public String getStyleID() {
        CTString tblStyle;
        CTTblPr tblPr = this.ctTbl.getTblPr();
        if (tblPr == null || (tblStyle = tblPr.getTblStyle()) == null) {
            return null;
        }
        return tblStyle.getVal();
    }

    public TableRowAlign getTableAlignment() {
        CTTblPr tblPr = getTblPr(false);
        if (tblPr != null && tblPr.isSetJc()) {
            return TableRowAlign.valueOf(tblPr.getJc().getVal().intValue());
        }
        return null;
    }

    public String getText() {
        return this.text.toString();
    }

    public String getTopBorderColor() {
        return getBorderColor(Border.TOP);
    }

    public int getTopBorderSize() {
        return getBorderSize(Border.TOP);
    }

    public int getTopBorderSpace() {
        return getBorderSpace(Border.TOP);
    }

    public XWPFBorderType getTopBorderType() {
        return getBorderType(Border.TOP);
    }

    public int getWidth() {
        CTTblPr tblPr = getTblPr();
        if (tblPr.isSetTblW()) {
            return (int) Units.toDXA(POIXMLUnits.parseLength(tblPr.getTblW().xgetW()));
        }
        return -1;
    }

    public double getWidthDecimal() {
        return getWidthDecimal(getTblPr().getTblW());
    }

    public TableWidthType getWidthType() {
        return getWidthType(getTblPr().getTblW());
    }

    public XWPFTableRow insertNewTableRow(int i5) {
        if (i5 < 0 || i5 > this.tableRows.size()) {
            return null;
        }
        XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.insertNewTr(i5), this);
        this.tableRows.add(i5, xWPFTableRow);
        return xWPFTableRow;
    }

    public void removeBorders() {
        CTTblPr tblPr = getTblPr(false);
        if (tblPr == null || !tblPr.isSetTblBorders()) {
            return;
        }
        tblPr.unsetTblBorders();
    }

    public void removeBottomBorder() {
        removeBorder(Border.BOTTOM);
    }

    public void removeInsideHBorder() {
        removeBorder(Border.INSIDE_H);
    }

    public void removeInsideVBorder() {
        removeBorder(Border.INSIDE_V);
    }

    public void removeLeftBorder() {
        removeBorder(Border.LEFT);
    }

    public void removeRightBorder() {
        removeBorder(Border.RIGHT);
    }

    public boolean removeRow(int i5) {
        if (i5 < 0 || i5 >= this.tableRows.size()) {
            return false;
        }
        if (this.ctTbl.sizeOfTrArray() > 0) {
            this.ctTbl.removeTr(i5);
        }
        this.tableRows.remove(i5);
        return true;
    }

    public void removeTableAlignment() {
        CTTblPr tblPr = getTblPr(false);
        if (tblPr == null || !tblPr.isSetJc()) {
            return;
        }
        tblPr.unsetJc();
    }

    public void removeTopBorder() {
        removeBorder(Border.TOP);
    }

    public void setBottomBorder(XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        setBorder(Border.BOTTOM, xWPFBorderType, i5, i6, str);
    }

    public void setCellMargins(int i5, int i6, int i7, int i8) {
        CTTblPr tblPr = getTblPr();
        CTTblCellMar tblCellMar = tblPr.isSetTblCellMar() ? tblPr.getTblCellMar() : tblPr.addNewTblCellMar();
        setCellMargin(tblCellMar, new g(16), new c(7), new c(8), new b(0), i5);
        setCellMargin(tblCellMar, new g(10), new g(11), new g(12), new b(1), i6);
        setCellMargin(tblCellMar, new g(13), new g(9), new g(23), new b(8), i7);
        setCellMargin(tblCellMar, new c(4), new c(5), new c(6), new b(9), i8);
    }

    public void setColBandSize(int i5) {
        CTTblPr tblPr = getTblPr();
        (tblPr.isSetTblStyleColBandSize() ? tblPr.getTblStyleColBandSize() : tblPr.addNewTblStyleColBandSize()).setVal(BigInteger.valueOf(i5));
    }

    public void setInsideHBorder(XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        setBorder(Border.INSIDE_H, xWPFBorderType, i5, i6, str);
    }

    public void setInsideVBorder(XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        setBorder(Border.INSIDE_V, xWPFBorderType, i5, i6, str);
    }

    public void setLeftBorder(XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        setBorder(Border.LEFT, xWPFBorderType, i5, i6, str);
    }

    public void setRightBorder(XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        setBorder(Border.RIGHT, xWPFBorderType, i5, i6, str);
    }

    public void setRowBandSize(int i5) {
        CTTblPr tblPr = getTblPr();
        (tblPr.isSetTblStyleRowBandSize() ? tblPr.getTblStyleRowBandSize() : tblPr.addNewTblStyleRowBandSize()).setVal(BigInteger.valueOf(i5));
    }

    public void setStyleID(String str) {
        CTTblPr tblPr = getTblPr();
        CTString tblStyle = tblPr.getTblStyle();
        if (tblStyle == null) {
            tblStyle = tblPr.addNewTblStyle();
        }
        tblStyle.setVal(str);
    }

    public void setTableAlignment(TableRowAlign tableRowAlign) {
        CTTblPr tblPr = getTblPr(true);
        (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc()).setVal(STJcTable.Enum.forInt(tableRowAlign.getValue()));
    }

    public void setTopBorder(XWPFBorderType xWPFBorderType, int i5, int i6, String str) {
        setBorder(Border.TOP, xWPFBorderType, i5, i6, str);
    }

    public void setWidth(int i5) {
        CTTblPr tblPr = getTblPr();
        CTTblWidth tblW = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
        tblW.setW(new BigInteger(Integer.toString(i5)));
        tblW.setType(STTblWidth.DXA);
    }

    public void setWidthType(TableWidthType tableWidthType) {
        setWidthType(tableWidthType, getTblPr().getTblW());
    }

    private CTTblPr getTblPr(boolean z6) {
        if (this.ctTbl.getTblPr() != null) {
            return this.ctTbl.getTblPr();
        }
        if (z6) {
            return this.ctTbl.addNewTblPr();
        }
        return null;
    }

    public static double getWidthDecimal(CTTblWidth cTTblWidth) {
        STTblWidth.Enum type = cTTblWidth.getType();
        if (type == STTblWidth.DXA || type == STTblWidth.AUTO || type == STTblWidth.NIL) {
            return Units.toDXA(POIXMLUnits.parseLength(cTTblWidth.xgetW())) + 0.0d;
        }
        if (type == STTblWidth.PCT) {
            return Units.toDXA(POIXMLUnits.parseLength(cTTblWidth.xgetW())) / 50.0d;
        }
        return 0.0d;
    }

    public static TableWidthType getWidthType(CTTblWidth cTTblWidth) {
        STTblWidth.Enum type = cTTblWidth.getType();
        if (type == null) {
            type = STTblWidth.NIL;
            cTTblWidth.setType(type);
        }
        int iIntValue = type.intValue();
        if (iIntValue == 1) {
            return TableWidthType.NIL;
        }
        if (iIntValue != 2) {
            return iIntValue != 3 ? TableWidthType.AUTO : TableWidthType.DXA;
        }
        return TableWidthType.PCT;
    }

    public static void setWidthType(TableWidthType tableWidthType, CTTblWidth cTTblWidth) {
        if (getWidthType(cTTblWidth).equals(tableWidthType)) {
            return;
        }
        STTblWidth.Enum stWidthType = tableWidthType.getStWidthType();
        cTTblWidth.setType(stWidthType);
        if (stWidthType.intValue() == 2) {
            setWidthPercentage(cTTblWidth, DEFAULT_PERCENTAGE_WIDTH);
        } else {
            cTTblWidth.setW(BigInteger.ZERO);
        }
    }

    public XWPFTableRow getRow(CTRow cTRow) {
        for (int i5 = 0; i5 < getRows().size(); i5++) {
            if (getRows().get(i5).getCtRow() == cTRow) {
                return getRow(i5);
            }
        }
        return null;
    }

    public boolean addRow(XWPFTableRow xWPFTableRow, int i5) {
        if (i5 < 0 || i5 > this.tableRows.size()) {
            return false;
        }
        this.ctTbl.insertNewTr(i5);
        this.ctTbl.setTrArray(i5, xWPFTableRow.getCtRow());
        this.tableRows.add(i5, xWPFTableRow);
        return true;
    }

    public XWPFTable(CTTbl cTTbl, IBody iBody) {
        this.text = new StringBuilder(64);
        this.tableRows = new ArrayList();
        this.part = iBody;
        this.ctTbl = cTTbl;
        if (cTTbl.sizeOfTrArray() == 0) {
            createEmptyTable(cTTbl);
        }
        for (CTRow cTRow : cTTbl.getTrList()) {
            StringBuilder sb = new StringBuilder();
            this.tableRows.add(new XWPFTableRow(cTRow, this));
            Iterator<CTTc> it = cTRow.getTcList().iterator();
            while (it.hasNext()) {
                Iterator<CTP> it2 = it.next().getPList().iterator();
                while (it2.hasNext()) {
                    XWPFParagraph xWPFParagraph = new XWPFParagraph(it2.next(), iBody);
                    if (sb.length() > 0) {
                        sb.append('\t');
                    }
                    sb.append(xWPFParagraph.getText());
                }
            }
            if (sb.length() > 0) {
                this.text.append((CharSequence) sb);
                this.text.append('\n');
            }
        }
    }

    public void setWidth(String str) {
        setWidthValue(str, getTblPr().getTblW());
    }
}
