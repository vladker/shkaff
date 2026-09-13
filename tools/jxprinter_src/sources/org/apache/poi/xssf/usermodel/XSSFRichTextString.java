package org.apache.poi.xssf.usermodel;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFRichTextString implements RichTextString {
    private static final Pattern utfPtrn = Pattern.compile("_x([0-9A-Fa-f]{4})_");
    private CTRst st;
    private StylesTable styles;

    public XSSFRichTextString(String str) {
        CTRst cTRstNewInstance = CTRst.Factory.newInstance();
        this.st = cTRstNewInstance;
        cTRstNewInstance.setT(str);
        preserveSpaces(this.st.xgetT());
    }

    private ThemesTable getThemesTable() {
        StylesTable stylesTable = this.styles;
        if (stylesTable == null) {
            return null;
        }
        return stylesTable.getTheme();
    }

    public static void preserveSpaces(STXstring sTXstring) {
        String stringValue = sTXstring.getStringValue();
        if (stringValue == null || stringValue.length() <= 0) {
            return;
        }
        char cCharAt = stringValue.charAt(0);
        char cCharAt2 = stringValue.charAt(stringValue.length() - 1);
        if (Character.isWhitespace(cCharAt) || Character.isWhitespace(cCharAt2)) {
            XmlCursor xmlCursorNewCursor = sTXstring.newCursor();
            try {
                xmlCursorNewCursor.toNextToken();
                xmlCursorNewCursor.insertAttributeWithValue(new QName("http://www.w3.org/XML/1998/namespace", "space"), "preserve");
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    private void setRunAttributes(CTFont cTFont, CTRPrElt cTRPrElt) {
        if (cTFont.sizeOfBArray() > 0) {
            cTRPrElt.addNewB().setVal(cTFont.getBArray(0).getVal());
        }
        if (cTFont.sizeOfUArray() > 0) {
            cTRPrElt.addNewU().setVal(cTFont.getUArray(0).getVal());
        }
        if (cTFont.sizeOfIArray() > 0) {
            cTRPrElt.addNewI().setVal(cTFont.getIArray(0).getVal());
        }
        if (cTFont.sizeOfColorArray() > 0) {
            CTColor colorArray = cTFont.getColorArray(0);
            CTColor cTColorAddNewColor = cTRPrElt.addNewColor();
            if (colorArray.isSetAuto()) {
                cTColorAddNewColor.setAuto(colorArray.getAuto());
            }
            if (colorArray.isSetIndexed()) {
                cTColorAddNewColor.setIndexed(colorArray.getIndexed());
            }
            if (colorArray.isSetRgb()) {
                cTColorAddNewColor.setRgb(colorArray.getRgb());
            }
            if (colorArray.isSetTheme()) {
                cTColorAddNewColor.setTheme(colorArray.getTheme());
            }
            if (colorArray.isSetTint()) {
                cTColorAddNewColor.setTint(colorArray.getTint());
            }
        }
        if (cTFont.sizeOfSzArray() > 0) {
            cTRPrElt.addNewSz().setVal(cTFont.getSzArray(0).getVal());
        }
        if (cTFont.sizeOfNameArray() > 0) {
            cTRPrElt.addNewRFont().setVal(cTFont.getNameArray(0).getVal());
        }
        if (cTFont.sizeOfFamilyArray() > 0) {
            cTRPrElt.addNewFamily().setVal(cTFont.getFamilyArray(0).getVal());
        }
        if (cTFont.sizeOfSchemeArray() > 0) {
            cTRPrElt.addNewScheme().setVal(cTFont.getSchemeArray(0).getVal());
        }
        if (cTFont.sizeOfCharsetArray() > 0) {
            cTRPrElt.addNewCharset().setVal(cTFont.getCharsetArray(0).getVal());
        }
        if (cTFont.sizeOfCondenseArray() > 0) {
            cTRPrElt.addNewCondense().setVal(cTFont.getCondenseArray(0).getVal());
        }
        if (cTFont.sizeOfExtendArray() > 0) {
            cTRPrElt.addNewExtend().setVal(cTFont.getExtendArray(0).getVal());
        }
        if (cTFont.sizeOfVertAlignArray() > 0) {
            cTRPrElt.addNewVertAlign().setVal(cTFont.getVertAlignArray(0).getVal());
        }
        if (cTFont.sizeOfOutlineArray() > 0) {
            cTRPrElt.addNewOutline().setVal(cTFont.getOutlineArray(0).getVal());
        }
        if (cTFont.sizeOfShadowArray() > 0) {
            cTRPrElt.addNewShadow().setVal(cTFont.getShadowArray(0).getVal());
        }
        if (cTFont.sizeOfStrikeArray() > 0) {
            cTRPrElt.addNewStrike().setVal(cTFont.getStrikeArray(0).getVal());
        }
    }

    public static CTFont toCTFont(CTRPrElt cTRPrElt) {
        CTFont cTFontNewInstance = CTFont.Factory.newInstance();
        if (cTRPrElt != null) {
            if (cTRPrElt.sizeOfBArray() > 0) {
                cTFontNewInstance.addNewB().setVal(cTRPrElt.getBArray(0).getVal());
            }
            if (cTRPrElt.sizeOfUArray() > 0) {
                cTFontNewInstance.addNewU().setVal(cTRPrElt.getUArray(0).getVal());
            }
            if (cTRPrElt.sizeOfIArray() > 0) {
                cTFontNewInstance.addNewI().setVal(cTRPrElt.getIArray(0).getVal());
            }
            if (cTRPrElt.sizeOfColorArray() > 0) {
                CTColor colorArray = cTRPrElt.getColorArray(0);
                CTColor cTColorAddNewColor = cTFontNewInstance.addNewColor();
                if (colorArray.isSetAuto()) {
                    cTColorAddNewColor.setAuto(colorArray.getAuto());
                }
                if (colorArray.isSetIndexed()) {
                    cTColorAddNewColor.setIndexed(colorArray.getIndexed());
                }
                if (colorArray.isSetRgb()) {
                    cTColorAddNewColor.setRgb(colorArray.getRgb());
                }
                if (colorArray.isSetTheme()) {
                    cTColorAddNewColor.setTheme(colorArray.getTheme());
                }
                if (colorArray.isSetTint()) {
                    cTColorAddNewColor.setTint(colorArray.getTint());
                }
            }
            if (cTRPrElt.sizeOfSzArray() > 0) {
                cTFontNewInstance.addNewSz().setVal(cTRPrElt.getSzArray(0).getVal());
            }
            if (cTRPrElt.sizeOfRFontArray() > 0) {
                cTFontNewInstance.addNewName().setVal(cTRPrElt.getRFontArray(0).getVal());
            }
            if (cTRPrElt.sizeOfFamilyArray() > 0) {
                cTFontNewInstance.addNewFamily().setVal(cTRPrElt.getFamilyArray(0).getVal());
            }
            if (cTRPrElt.sizeOfSchemeArray() > 0) {
                cTFontNewInstance.addNewScheme().setVal(cTRPrElt.getSchemeArray(0).getVal());
            }
            if (cTRPrElt.sizeOfCharsetArray() > 0) {
                cTFontNewInstance.addNewCharset().setVal(cTRPrElt.getCharsetArray(0).getVal());
            }
            if (cTRPrElt.sizeOfCondenseArray() > 0) {
                cTFontNewInstance.addNewCondense().setVal(cTRPrElt.getCondenseArray(0).getVal());
            }
            if (cTRPrElt.sizeOfExtendArray() > 0) {
                cTFontNewInstance.addNewExtend().setVal(cTRPrElt.getExtendArray(0).getVal());
            }
            if (cTRPrElt.sizeOfVertAlignArray() > 0) {
                cTFontNewInstance.addNewVertAlign().setVal(cTRPrElt.getVertAlignArray(0).getVal());
            }
            if (cTRPrElt.sizeOfOutlineArray() > 0) {
                cTFontNewInstance.addNewOutline().setVal(cTRPrElt.getOutlineArray(0).getVal());
            }
            if (cTRPrElt.sizeOfShadowArray() > 0) {
                cTFontNewInstance.addNewShadow().setVal(cTRPrElt.getShadowArray(0).getVal());
            }
            if (cTRPrElt.sizeOfStrikeArray() > 0) {
                cTFontNewInstance.addNewStrike().setVal(cTRPrElt.getStrikeArray(0).getVal());
            }
        }
        return cTFontNewInstance;
    }

    public static String utfDecode(String str) {
        if (str == null || !str.contains("_x")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Matcher matcher = utfPtrn.matcher(str);
        int iEnd = 0;
        while (matcher.find()) {
            int iStart = matcher.start();
            if (iStart > iEnd) {
                sb.append((CharSequence) str, iEnd, iStart);
            }
            sb.append((char) Integer.decode("0x" + matcher.group(1)).intValue());
            iEnd = matcher.end();
        }
        return iEnd == 0 ? str : androidx.exifinterface.media.a.j(str, iEnd, sb);
    }

    public static int utfLength(String str) {
        int i5 = 0;
        if (str == null) {
            return 0;
        }
        if (!str.contains("_x")) {
            return str.length();
        }
        while (utfPtrn.matcher(str).find()) {
            i5++;
        }
        return str.length() - (i5 * 6);
    }

    public void append(String str, XSSFFont xSSFFont) {
        if (this.st.sizeOfRArray() == 0 && this.st.isSetT()) {
            CTRElt cTREltAddNewR = this.st.addNewR();
            cTREltAddNewR.setT(this.st.getT());
            preserveSpaces(cTREltAddNewR.xgetT());
            this.st.unsetT();
        }
        CTRElt cTREltAddNewR2 = this.st.addNewR();
        cTREltAddNewR2.setT(str);
        preserveSpaces(cTREltAddNewR2.xgetT());
        if (xSSFFont != null) {
            setRunAttributes(xSSFFont.getCTFont(), cTREltAddNewR2.addNewRPr());
        }
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i5, int i6, short s6) {
        XSSFFont fontAt;
        StylesTable stylesTable = this.styles;
        if (stylesTable == null) {
            fontAt = new XSSFFont();
            fontAt.setFontName("#" + ((int) s6));
        } else {
            fontAt = stylesTable.getFontAt(s6);
        }
        applyFont(i5, i6, fontAt);
    }

    public CTRst buildCTRst(String str, TreeMap<Integer, CTRPrElt> treeMap) {
        if (str.length() != treeMap.lastKey().intValue()) {
            throw new IllegalArgumentException("Text length was " + str.length() + " but the last format index was " + treeMap.lastKey());
        }
        CTRst cTRstNewInstance = CTRst.Factory.newInstance();
        int i5 = 0;
        for (Map.Entry<Integer, CTRPrElt> entry : treeMap.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            CTRElt cTREltAddNewR = cTRstNewInstance.addNewR();
            cTREltAddNewR.setT(str.substring(i5, iIntValue));
            preserveSpaces(cTREltAddNewR.xgetT());
            CTRPrElt value = entry.getValue();
            if (value != null) {
                cTREltAddNewR.setRPr(value);
            }
            i5 = iIntValue;
        }
        return cTRstNewInstance;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void clearFormatting() {
        String string = getString();
        this.st.setRArray(null);
        this.st.setT(string);
    }

    @Internal
    public CTRst getCTRst() {
        return this.st;
    }

    public XSSFFont getFontAtIndex(int i5) {
        ThemesTable themesTable = getThemesTable();
        int i6 = 0;
        for (CTRElt cTRElt : this.st.getRArray()) {
            int length = cTRElt.getT().length();
            if (i5 >= i6 && i5 < i6 + length) {
                XSSFFont xSSFFont = new XSSFFont(toCTFont(cTRElt.getRPr()));
                xSSFFont.setThemesTable(themesTable);
                return xSSFFont;
            }
            i6 += length;
        }
        return null;
    }

    public XSSFFont getFontOfFormattingRun(int i5) {
        if (this.st.sizeOfRArray() != 0 && i5 < this.st.sizeOfRArray()) {
            CTRElt rArray = this.st.getRArray(i5);
            if (rArray.getRPr() != null) {
                XSSFFont xSSFFont = new XSSFFont(toCTFont(rArray.getRPr()));
                xSSFFont.setThemesTable(getThemesTable());
                return xSSFFont;
            }
        }
        return null;
    }

    public TreeMap<Integer, CTRPrElt> getFormatMap(CTRst cTRst) {
        TreeMap<Integer, CTRPrElt> treeMap = new TreeMap<>();
        int iUtfLength = 0;
        for (CTRElt cTRElt : cTRst.getRArray()) {
            String t6 = cTRElt.getT();
            CTRPrElt rPr = cTRElt.getRPr();
            iUtfLength += utfLength(t6);
            treeMap.put(Integer.valueOf(iUtfLength), rPr);
        }
        return treeMap;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int getIndexOfFormattingRun(int i5) {
        if (this.st.sizeOfRArray() == 0) {
            return 0;
        }
        int length = 0;
        for (int i6 = 0; i6 < this.st.sizeOfRArray(); i6++) {
            CTRElt rArray = this.st.getRArray(i6);
            if (i6 == i5) {
                return length;
            }
            length += rArray.getT().length();
        }
        return -1;
    }

    public int getLengthOfFormattingRun(int i5) {
        if (this.st.sizeOfRArray() == 0 || i5 >= this.st.sizeOfRArray()) {
            return -1;
        }
        return this.st.getRArray(i5).getT().length();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        if (this.st.sizeOfRArray() == 0) {
            return utfDecode(this.st.getT());
        }
        StringBuilder sb = new StringBuilder();
        for (CTRElt cTRElt : this.st.getRArray()) {
            sb.append(cTRElt.getT());
        }
        return utfDecode(sb.toString());
    }

    public boolean hasFormatting() {
        CTRElt[] rArray = this.st.getRArray();
        if (rArray != null && rArray.length != 0) {
            for (CTRElt cTRElt : rArray) {
                if (cTRElt.isSetRPr()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int length() {
        return getString().length();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int numFormattingRuns() {
        return this.st.sizeOfRArray();
    }

    public void setString(String str) {
        clearFormatting();
        this.st.setT(str);
        preserveSpaces(this.st.xgetT());
    }

    public void setStylesTableReference(StylesTable stylesTable) {
        this.styles = stylesTable;
        if (this.st.sizeOfRArray() > 0) {
            for (CTRElt cTRElt : this.st.getRArray()) {
                CTRPrElt rPr = cTRElt.getRPr();
                if (rPr != null && rPr.sizeOfRFontArray() > 0) {
                    String val = rPr.getRFontArray(0).getVal();
                    if (val.startsWith("#")) {
                        XSSFFont fontAt = this.styles.getFontAt(Integer.parseInt(val.substring(1)));
                        rPr.removeRFont(0);
                        setRunAttributes(fontAt.getCTFont(), rPr);
                    }
                }
            }
        }
    }

    public String toString() {
        String string = getString();
        return string == null ? "" : string;
    }

    public XSSFRichTextString() {
        this.st = CTRst.Factory.newInstance();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i5, int i6, Font font) {
        if (i5 <= i6) {
            if (i5 < 0 || i6 > length()) {
                throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "Start and end index not in range, but had ", " and "));
            }
            if (i5 == i6) {
                return;
            }
            if (this.st.sizeOfRArray() == 0 && this.st.isSetT()) {
                this.st.addNewR().setT(this.st.getT());
                this.st.unsetT();
            }
            String string = getString();
            TreeMap<Integer, CTRPrElt> formatMap = getFormatMap(this.st);
            CTRPrElt cTRPrEltNewInstance = CTRPrElt.Factory.newInstance();
            setRunAttributes(((XSSFFont) font).getCTFont(), cTRPrEltNewInstance);
            applyFont(formatMap, i5, i6, cTRPrEltNewInstance);
            this.st.set(buildCTRst(string, formatMap));
            return;
        }
        throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "Start index must be less than end index, but had ", " and "));
    }

    @Internal
    public XSSFRichTextString(CTRst cTRst) {
        this.st = cTRst;
    }

    public void append(String str) {
        append(str, null);
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(Font font) {
        applyFont(0, getString().length(), font);
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(short s6) {
        XSSFFont fontAt;
        StylesTable stylesTable = this.styles;
        if (stylesTable == null) {
            fontAt = new XSSFFont();
            fontAt.setFontName("#" + ((int) s6));
        } else {
            fontAt = stylesTable.getFontAt(s6);
        }
        applyFont(0, getString().length(), fontAt);
    }

    public void applyFont(TreeMap<Integer, CTRPrElt> treeMap, int i5, int i6, CTRPrElt cTRPrElt) {
        Iterator<Integer> it = treeMap.keySet().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (i7 >= i5 && iIntValue < i6) {
                it.remove();
            }
            i7 = iIntValue;
        }
        if (i5 > 0 && !treeMap.containsKey(Integer.valueOf(i5))) {
            for (Map.Entry<Integer, CTRPrElt> entry : treeMap.entrySet()) {
                if (entry.getKey().intValue() > i5) {
                    treeMap.put(Integer.valueOf(i5), entry.getValue());
                    break;
                }
            }
        }
        treeMap.put(Integer.valueOf(i6), cTRPrElt);
        SortedMap<Integer, CTRPrElt> sortedMapSubMap = treeMap.subMap(Integer.valueOf(i5), Integer.valueOf(i6));
        while (sortedMapSubMap.size() > 1) {
            sortedMapSubMap.remove(sortedMapSubMap.lastKey());
        }
    }
}
