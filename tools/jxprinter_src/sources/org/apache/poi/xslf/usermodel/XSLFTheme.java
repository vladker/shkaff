package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTheme extends POIXMLDocumentPart {
    private CTOfficeStyleSheet _theme;

    public XSLFTheme() {
        this._theme = CTOfficeStyleSheet.Factory.newInstance();
    }

    private static CTColor getMapColor(String str, CTColorScheme cTColorScheme) {
        if (str == null || cTColorScheme == null) {
            return null;
        }
        switch (str) {
            case "accent1":
                return cTColorScheme.getAccent1();
            case "accent2":
                return cTColorScheme.getAccent2();
            case "accent3":
                return cTColorScheme.getAccent3();
            case "accent4":
                return cTColorScheme.getAccent4();
            case "accent5":
                return cTColorScheme.getAccent5();
            case "accent6":
                return cTColorScheme.getAccent6();
            case "dk1":
                return cTColorScheme.getDk1();
            case "dk2":
                return cTColorScheme.getDk2();
            case "lt1":
                return cTColorScheme.getLt1();
            case "lt2":
                return cTColorScheme.getLt2();
            case "hlink":
                return cTColorScheme.getHlink();
            case "folHlink":
                return cTColorScheme.getFolHlink();
            default:
                return null;
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(XSSFRelation.NS_DRAWINGML, "theme"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            getXmlObject().save(outputStream, xmlOptions);
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

    @Internal
    public CTColor getCTColor(String str) {
        CTBaseStyles themeElements = this._theme.getThemeElements();
        return getMapColor(str, themeElements == null ? null : themeElements.getClrScheme());
    }

    public String getMajorFont() {
        return this._theme.getThemeElements().getFontScheme().getMajorFont().getLatin().getTypeface();
    }

    public String getMinorFont() {
        return this._theme.getThemeElements().getFontScheme().getMinorFont().getLatin().getTypeface();
    }

    public String getName() {
        return this._theme.getName();
    }

    @Internal
    public CTOfficeStyleSheet getXmlObject() {
        return this._theme;
    }

    public void importTheme(XSLFTheme xSLFTheme) {
        this._theme = xSLFTheme.getXmlObject();
    }

    public void setName(String str) {
        this._theme.setName(str);
    }

    public XSLFTheme(PackagePart packagePart) throws IOException {
        super(packagePart);
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            this._theme = ThemeDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getTheme();
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
}
