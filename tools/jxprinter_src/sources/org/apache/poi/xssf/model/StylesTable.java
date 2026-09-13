package org.apache.poi.xssf.model;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.CustomIndexedColorMap;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFBuiltinTableStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFTableStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StylesTable extends POIXMLDocumentPart implements Styles {
    public static final int FIRST_CUSTOM_STYLE_ID = 165;
    private static final short FIRST_USER_DEFINED_NUMBER_FORMAT_ID = 164;
    private static final int MAXIMUM_STYLE_ID = SpreadsheetVersion.EXCEL2007.getMaxCellStyles();
    private int MAXIMUM_NUMBER_OF_DATA_FORMATS;
    private final List<XSSFCellBorder> borders;
    private StyleSheetDocument doc;
    private final List<CTDxf> dxfs;
    private final List<XSSFCellFill> fills;
    private final List<XSSFFont> fonts;
    private IndexedColorMap indexedColors;
    private final SortedMap<Short, String> numberFormats;
    private final List<CTXf> styleXfs;
    private final Map<String, TableStyle> tableStyles;
    private ThemesTable theme;
    private XSSFWorkbook workbook;
    private final List<CTXf> xfs;

    public StylesTable() {
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = 250;
        StyleSheetDocument styleSheetDocumentNewInstance = StyleSheetDocument.Factory.newInstance();
        this.doc = styleSheetDocumentNewInstance;
        styleSheetDocumentNewInstance.addNewStyleSheet();
        initialize();
    }

    private static CTBorder createDefaultBorder() {
        CTBorder cTBorderNewInstance = CTBorder.Factory.newInstance();
        cTBorderNewInstance.addNewBottom();
        cTBorderNewInstance.addNewTop();
        cTBorderNewInstance.addNewLeft();
        cTBorderNewInstance.addNewRight();
        cTBorderNewInstance.addNewDiagonal();
        return cTBorderNewInstance;
    }

    private static CTFill[] createDefaultFills() {
        DocumentFactory<CTFill> documentFactory = CTFill.Factory;
        CTFill[] cTFillArr = {documentFactory.newInstance(), documentFactory.newInstance()};
        cTFillArr[0].addNewPatternFill().setPatternType(STPatternType.NONE);
        cTFillArr[1].addNewPatternFill().setPatternType(STPatternType.DARK_GRAY);
        return cTFillArr;
    }

    private static XSSFFont createDefaultFont() {
        XSSFFont xSSFFont = new XSSFFont(CTFont.Factory.newInstance(), 0, null);
        xSSFFont.setFontHeightInPoints((short) 11);
        xSSFFont.setColor(XSSFFont.DEFAULT_FONT_COLOR);
        xSSFFont.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        xSSFFont.setFamily(FontFamily.SWISS);
        xSSFFont.setScheme(FontScheme.MINOR);
        return xSSFFont;
    }

    private static CTXf createDefaultXf() {
        CTXf cTXfNewInstance = CTXf.Factory.newInstance();
        cTXfNewInstance.setNumFmtId(0L);
        cTXfNewInstance.setFontId(0L);
        cTXfNewInstance.setFillId(0L);
        cTXfNewInstance.setBorderId(0L);
        return cTXfNewInstance;
    }

    private short getNumberFormatId(String str) {
        for (Map.Entry<Short, String> entry : this.numberFormats.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey().shortValue();
            }
        }
        throw new IllegalStateException(AbstractC0157z.n("Number format not in style table: ", str));
    }

    private void initialize() {
        this.fonts.add(createDefaultFont());
        CTFill[] cTFillArrCreateDefaultFills = createDefaultFills();
        this.fills.add(new XSSFCellFill(cTFillArrCreateDefaultFills[0], this.indexedColors));
        this.fills.add(new XSSFCellFill(cTFillArrCreateDefaultFills[1], this.indexedColors));
        this.borders.add(new XSSFCellBorder(createDefaultBorder()));
        this.styleXfs.add(createDefaultXf());
        CTXf cTXfCreateDefaultXf = createDefaultXf();
        cTXfCreateDefaultXf.setXfId(0L);
        this.xfs.add(cTXfCreateDefaultXf);
    }

    @Internal
    public int _getDXfsSize() {
        return this.dxfs.size();
    }

    @Internal
    public int _getStyleXfsSize() {
        return this.styleXfs.size();
    }

    @Internal
    public int _getXfsSize() {
        return this.xfs.size();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            writeTo(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public XSSFCellStyle createCellStyle() {
        int numCellStyles = getNumCellStyles();
        int i5 = MAXIMUM_STYLE_ID;
        if (numCellStyles > i5) {
            throw new IllegalStateException(a.i(i5, "The maximum number of Cell Styles was exceeded. You can define up to ", " style in a .xlsx Workbook"));
        }
        int size = this.styleXfs.size();
        CTXf cTXfNewInstance = CTXf.Factory.newInstance();
        cTXfNewInstance.setNumFmtId(0L);
        cTXfNewInstance.setFontId(0L);
        cTXfNewInstance.setFillId(0L);
        cTXfNewInstance.setBorderId(0L);
        cTXfNewInstance.setXfId(0L);
        return new XSSFCellStyle(putCellXf(cTXfNewInstance) - 1, size - 1, this, this.theme);
    }

    public void ensureThemesTable() {
        XSSFWorkbook xSSFWorkbook;
        if (this.theme != null || (xSSFWorkbook = this.workbook) == null) {
            return;
        }
        setTheme((ThemesTable) xSSFWorkbook.createRelationship(XSSFRelation.THEME, xSSFWorkbook.getXssfFactory()));
    }

    public XSSFFont findFont(boolean z6, short s6, short s7, String str, boolean z7, boolean z8, short s8, byte b) {
        for (XSSFFont xSSFFont : this.fonts) {
            if (xSSFFont.getBold() == z6 && xSSFFont.getColor() == s6 && xSSFFont.getFontHeight() == s7 && xSSFFont.getFontName().equals(str) && xSSFFont.getItalic() == z7 && xSSFFont.getStrikeout() == z8 && xSSFFont.getTypeOffset() == s8 && xSSFFont.getUnderline() == b) {
                return xSSFFont;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public XSSFCellBorder getBorderAt(int i5) {
        return this.borders.get(i5);
    }

    public List<XSSFCellBorder> getBorders() {
        return Collections.unmodifiableList(this.borders);
    }

    @Internal
    public CTStylesheet getCTStylesheet() {
        return this.doc.getStyleSheet();
    }

    @Internal
    public CTXf getCellStyleXfAt(int i5) {
        try {
            return this.styleXfs.get(i5);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Internal
    public CTXf getCellXfAt(int i5) {
        return this.xfs.get(i5);
    }

    @Internal
    public CTDxf getDxfAt(int i5) {
        return this.dxfs.get(i5);
    }

    public TableStyle getExplicitTableStyle(String str) {
        return this.tableStyles.get(str);
    }

    public Set<String> getExplicitTableStyleNames() {
        return this.tableStyles.keySet();
    }

    @Override // org.apache.poi.xssf.model.Styles
    public XSSFCellFill getFillAt(int i5) {
        return this.fills.get(i5);
    }

    public List<XSSFCellFill> getFills() {
        return Collections.unmodifiableList(this.fills);
    }

    @Override // org.apache.poi.xssf.model.Styles
    public XSSFFont getFontAt(int i5) {
        return this.fonts.get(i5);
    }

    public List<XSSFFont> getFonts() {
        return Collections.unmodifiableList(this.fonts);
    }

    public IndexedColorMap getIndexedColors() {
        return this.indexedColors;
    }

    public int getMaxNumberOfDataFormats() {
        return this.MAXIMUM_NUMBER_OF_DATA_FORMATS;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int getNumCellStyles() {
        return this.xfs.size();
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int getNumDataFormats() {
        return this.numberFormats.size();
    }

    @Override // org.apache.poi.xssf.model.Styles
    public String getNumberFormatAt(short s6) {
        return this.numberFormats.get(Short.valueOf(s6));
    }

    public Map<Short, String> getNumberFormats() {
        return Collections.unmodifiableMap(this.numberFormats);
    }

    @Override // org.apache.poi.xssf.model.Styles
    public XSSFCellStyle getStyleAt(int i5) {
        if (i5 < 0 || i5 >= this.xfs.size()) {
            return null;
        }
        return new XSSFCellStyle(i5, this.xfs.get(i5).getXfId() > 0 ? (int) this.xfs.get(i5).getXfId() : 0, this, this.theme);
    }

    public TableStyle getTableStyle(String str) {
        if (str == null) {
            return null;
        }
        try {
            return XSSFBuiltinTableStyle.valueOf(str).getStyle();
        } catch (IllegalArgumentException unused) {
            return getExplicitTableStyle(str);
        }
    }

    public ThemesTable getTheme() {
        return this.theme;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int putBorder(XSSFCellBorder xSSFCellBorder) {
        int iIndexOf = this.borders.indexOf(xSSFCellBorder);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        this.borders.add(xSSFCellBorder);
        xSSFCellBorder.setThemesTable(this.theme);
        return this.borders.size() - 1;
    }

    @Internal
    public int putCellStyleXf(CTXf cTXf) {
        this.styleXfs.add(cTXf);
        return this.styleXfs.size();
    }

    @Internal
    public int putCellXf(CTXf cTXf) {
        this.xfs.add(cTXf);
        return this.xfs.size();
    }

    @Internal
    public int putDxf(CTDxf cTDxf) {
        this.dxfs.add(cTDxf);
        return this.dxfs.size();
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int putFill(XSSFCellFill xSSFCellFill) {
        int iIndexOf = this.fills.indexOf(xSSFCellFill);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        this.fills.add(xSSFCellFill);
        return this.fills.size() - 1;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int putFont(XSSFFont xSSFFont, boolean z6) {
        int iIndexOf = !z6 ? this.fonts.indexOf(xSSFFont) : -1;
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.fonts.size();
        this.fonts.add(xSSFFont);
        return size;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int putNumberFormat(String str) {
        if (this.numberFormats.containsValue(str)) {
            try {
                return getNumberFormatId(str);
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("Found the format, but couldn't figure out where - should never happen!");
            }
        }
        if (this.numberFormats.size() >= this.MAXIMUM_NUMBER_OF_DATA_FORMATS) {
            throw new IllegalStateException(AbstractC0157z.l(" formats in a .xlsx Workbook.", this.MAXIMUM_NUMBER_OF_DATA_FORMATS, new StringBuilder("The maximum number of Data Formats was exceeded. You can define up to ")));
        }
        short sMax = 164;
        if (!this.numberFormats.isEmpty()) {
            short sShortValue = (short) (this.numberFormats.lastKey().shortValue() + 1);
            if (sShortValue < 0) {
                throw new IllegalStateException("Cowardly avoiding creating a number format with a negative id. This is probably due to arithmetic overflow.");
            }
            sMax = (short) Math.max((int) sShortValue, 164);
        }
        this.numberFormats.put(Short.valueOf(sMax), str);
        return sMax;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int putStyle(XSSFCellStyle xSSFCellStyle) {
        CTXf coreXf = xSSFCellStyle.getCoreXf();
        if (!this.xfs.contains(coreXf)) {
            this.xfs.add(coreXf);
        }
        return this.xfs.indexOf(coreXf);
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            StyleSheetDocument styleSheetDocument = StyleSheetDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            this.doc = styleSheetDocument;
            CTStylesheet styleSheet = styleSheetDocument.getStyleSheet();
            CustomIndexedColorMap customIndexedColorMapFromColors = CustomIndexedColorMap.fromColors(styleSheet.getColors());
            if (customIndexedColorMapFromColors != null) {
                this.indexedColors = customIndexedColorMapFromColors;
            }
            CTNumFmts numFmts = styleSheet.getNumFmts();
            if (numFmts != null) {
                for (CTNumFmt cTNumFmt : numFmts.getNumFmtArray()) {
                    this.numberFormats.put(Short.valueOf((short) cTNumFmt.getNumFmtId()), cTNumFmt.getFormatCode());
                }
            }
            CTFonts fonts = styleSheet.getFonts();
            if (fonts != null) {
                int i5 = 0;
                for (CTFont cTFont : fonts.getFontArray()) {
                    this.fonts.add(new XSSFFont(cTFont, i5, this.indexedColors));
                    i5++;
                }
            }
            CTFills fills = styleSheet.getFills();
            if (fills != null) {
                for (CTFill cTFill : fills.getFillArray()) {
                    this.fills.add(new XSSFCellFill(cTFill, this.indexedColors));
                }
            }
            CTBorders borders = styleSheet.getBorders();
            if (borders != null) {
                for (CTBorder cTBorder : borders.getBorderArray()) {
                    this.borders.add(new XSSFCellBorder(cTBorder, this.indexedColors));
                }
            }
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs != null) {
                this.xfs.addAll(Arrays.asList(cellXfs.getXfArray()));
            }
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs != null) {
                this.styleXfs.addAll(Arrays.asList(cellStyleXfs.getXfArray()));
            }
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs != null) {
                this.dxfs.addAll(Arrays.asList(dxfs.getDxfArray()));
            }
            CTTableStyles tableStyles = styleSheet.getTableStyles();
            if (tableStyles == null || dxfs == null) {
                return;
            }
            int i6 = 0;
            for (CTTableStyle cTTableStyle : tableStyles.getTableStyleArray()) {
                this.tableStyles.put(cTTableStyle.getName(), new XSSFTableStyle(i6, dxfs, cTTableStyle, this.indexedColors));
                i6++;
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Override // org.apache.poi.xssf.model.Styles
    public boolean removeNumberFormat(short s6) {
        boolean z6 = this.numberFormats.remove(Short.valueOf(s6)) != null;
        if (z6) {
            for (CTXf cTXf : this.xfs) {
                if (cTXf.isSetNumFmtId() && cTXf.getNumFmtId() == s6) {
                    cTXf.unsetApplyNumberFormat();
                    cTXf.unsetNumFmtId();
                }
            }
        }
        return z6;
    }

    @Internal
    public void replaceCellStyleXfAt(int i5, CTXf cTXf) {
        this.styleXfs.set(i5, cTXf);
    }

    @Internal
    public void replaceCellXfAt(int i5, CTXf cTXf) {
        this.xfs.set(i5, cTXf);
    }

    public void setMaxNumberOfDataFormats(int i5) {
        if (i5 >= getNumDataFormats()) {
            this.MAXIMUM_NUMBER_OF_DATA_FORMATS = i5;
        } else {
            if (i5 >= 0) {
                throw new IllegalStateException("Cannot set the maximum number of data formats less than the current quantity. Data formats must be explicitly removed (via StylesTable.removeNumberFormat) before the limit can be decreased.");
            }
            throw new IllegalArgumentException("Maximum Number of Data Formats must be greater than or equal to 0");
        }
    }

    public void setTheme(ThemesTable themesTable) {
        this.theme = themesTable;
        if (themesTable != null) {
            themesTable.setColorMap(getIndexedColors());
        }
        Iterator<XSSFFont> it = this.fonts.iterator();
        while (it.hasNext()) {
            it.next().setThemesTable(themesTable);
        }
        Iterator<XSSFCellBorder> it2 = this.borders.iterator();
        while (it2.hasNext()) {
            it2.next().setThemesTable(themesTable);
        }
    }

    public void setWorkbook(XSSFWorkbook xSSFWorkbook) {
        this.workbook = xSSFWorkbook;
    }

    public void writeTo(OutputStream outputStream) {
        CTStylesheet styleSheet = this.doc.getStyleSheet();
        CTNumFmts cTNumFmtsNewInstance = CTNumFmts.Factory.newInstance();
        cTNumFmtsNewInstance.setCount(this.numberFormats.size());
        for (Map.Entry<Short, String> entry : this.numberFormats.entrySet()) {
            CTNumFmt cTNumFmtAddNewNumFmt = cTNumFmtsNewInstance.addNewNumFmt();
            cTNumFmtAddNewNumFmt.setNumFmtId(entry.getKey().shortValue());
            cTNumFmtAddNewNumFmt.setFormatCode(entry.getValue());
        }
        styleSheet.setNumFmts(cTNumFmtsNewInstance);
        CTFonts fonts = styleSheet.getFonts();
        if (fonts == null) {
            fonts = CTFonts.Factory.newInstance();
        }
        fonts.setCount(this.fonts.size());
        CTFont[] cTFontArr = new CTFont[this.fonts.size()];
        Iterator<XSSFFont> it = this.fonts.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            cTFontArr[i5] = it.next().getCTFont();
            i5++;
        }
        fonts.setFontArray(cTFontArr);
        styleSheet.setFonts(fonts);
        CTFills fills = styleSheet.getFills();
        if (fills == null) {
            fills = CTFills.Factory.newInstance();
        }
        fills.setCount(this.fills.size());
        CTFill[] cTFillArr = new CTFill[this.fills.size()];
        Iterator<XSSFCellFill> it2 = this.fills.iterator();
        int i6 = 0;
        while (it2.hasNext()) {
            cTFillArr[i6] = it2.next().getCTFill();
            i6++;
        }
        fills.setFillArray(cTFillArr);
        styleSheet.setFills(fills);
        CTBorders borders = styleSheet.getBorders();
        if (borders == null) {
            borders = CTBorders.Factory.newInstance();
        }
        borders.setCount(this.borders.size());
        CTBorder[] cTBorderArr = new CTBorder[this.borders.size()];
        Iterator<XSSFCellBorder> it3 = this.borders.iterator();
        int i7 = 0;
        while (it3.hasNext()) {
            cTBorderArr[i7] = it3.next().getCTBorder();
            i7++;
        }
        borders.setBorderArray(cTBorderArr);
        styleSheet.setBorders(borders);
        if (!this.xfs.isEmpty()) {
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs == null) {
                cellXfs = CTCellXfs.Factory.newInstance();
            }
            cellXfs.setCount(this.xfs.size());
            cellXfs.setXfArray((CTXf[]) this.xfs.toArray(new CTXf[0]));
            styleSheet.setCellXfs(cellXfs);
        }
        if (!this.styleXfs.isEmpty()) {
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs == null) {
                cellStyleXfs = CTCellStyleXfs.Factory.newInstance();
            }
            cellStyleXfs.setCount(this.styleXfs.size());
            cellStyleXfs.setXfArray((CTXf[]) this.styleXfs.toArray(new CTXf[0]));
            styleSheet.setCellStyleXfs(cellStyleXfs);
        }
        if (!this.dxfs.isEmpty()) {
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs == null) {
                dxfs = CTDxfs.Factory.newInstance();
            }
            dxfs.setCount(this.dxfs.size());
            dxfs.setDxfArray((CTDxf[]) this.dxfs.toArray(new CTDxf[0]));
            styleSheet.setDxfs(dxfs);
        }
        this.doc.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int putFont(XSSFFont xSSFFont) {
        return putFont(xSSFFont, false);
    }

    @Override // org.apache.poi.xssf.model.Styles
    public boolean removeNumberFormat(String str) {
        return removeNumberFormat(getNumberFormatId(str));
    }

    public XSSFFont findFont(boolean z6, Color color, short s6, String str, boolean z7, boolean z8, short s7, byte b) {
        for (XSSFFont xSSFFont : this.fonts) {
            if (xSSFFont.getBold() == z6 && xSSFFont.getXSSFColor().equals(color) && xSSFFont.getFontHeight() == s6 && xSSFFont.getFontName().equals(str) && xSSFFont.getItalic() == z7 && xSSFFont.getStrikeout() == z8 && xSSFFont.getTypeOffset() == s7 && xSSFFont.getUnderline() == b) {
                return xSSFFont;
            }
        }
        return null;
    }

    public StylesTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = 250;
        InputStream inputStream = packagePart.getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xssf.model.Styles
    public void putNumberFormat(short s6, String str) {
        this.numberFormats.put(Short.valueOf(s6), str);
    }

    public StylesTable(InputStream inputStream) throws IOException {
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = 250;
        readFrom(inputStream);
    }
}
