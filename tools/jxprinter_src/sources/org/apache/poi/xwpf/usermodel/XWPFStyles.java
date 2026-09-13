package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFStyles extends POIXMLDocumentPart {
    private CTStyles ctStyles;
    private XWPFDefaultParagraphStyle defaultParaStyle;
    private XWPFDefaultRunStyle defaultRunStyle;
    private XWPFLatentStyles latentStyles;
    private final List<XWPFStyle> listStyle;

    public XWPFStyles(PackagePart packagePart) {
        super(packagePart);
        this.listStyle = new ArrayList();
    }

    public void addStyle(XWPFStyle xWPFStyle) {
        this.listStyle.add(xWPFStyle);
        this.ctStyles.addNewStyle();
        this.ctStyles.setStyleArray(this.ctStyles.sizeOfStyleArray() - 1, xWPFStyle.getCTStyle());
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        if (this.ctStyles == null) {
            throw new IllegalStateException("Unable to write out styles that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTStyles.type.getName().getNamespaceURI(), "styles"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.ctStyles.save(outputStream, xmlOptions);
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

    public void ensureDocDefaults() {
        if (!this.ctStyles.isSetDocDefaults()) {
            this.ctStyles.addNewDocDefaults();
        }
        CTDocDefaults docDefaults = this.ctStyles.getDocDefaults();
        if (!docDefaults.isSetPPrDefault()) {
            docDefaults.addNewPPrDefault();
        }
        if (!docDefaults.isSetRPrDefault()) {
            docDefaults.addNewRPrDefault();
        }
        CTPPrDefault pPrDefault = docDefaults.getPPrDefault();
        CTRPrDefault rPrDefault = docDefaults.getRPrDefault();
        if (!pPrDefault.isSetPPr()) {
            pPrDefault.addNewPPr();
        }
        if (!rPrDefault.isSetRPr()) {
            rPrDefault.addNewRPr();
        }
        this.defaultRunStyle = new XWPFDefaultRunStyle(rPrDefault.getRPr());
        this.defaultParaStyle = new XWPFDefaultParagraphStyle(pPrDefault.getPPr());
    }

    public CTLanguage getCTLanguage() {
        ensureDocDefaults();
        return this.defaultRunStyle.getRPr().sizeOfLangArray() > 0 ? this.defaultRunStyle.getRPr().getLangArray(0) : this.defaultRunStyle.getRPr().addNewLang();
    }

    public XWPFDefaultParagraphStyle getDefaultParagraphStyle() {
        ensureDocDefaults();
        return this.defaultParaStyle;
    }

    public XWPFDefaultRunStyle getDefaultRunStyle() {
        ensureDocDefaults();
        return this.defaultRunStyle;
    }

    public XWPFLatentStyles getLatentStyles() {
        return this.latentStyles;
    }

    public int getNumberOfStyles() {
        return this.listStyle.size();
    }

    public XWPFStyle getStyle(String str) {
        for (XWPFStyle xWPFStyle : this.listStyle) {
            if (xWPFStyle.getStyleId() != null && xWPFStyle.getStyleId().equals(str)) {
                return xWPFStyle;
            }
        }
        return null;
    }

    public XWPFStyle getStyleWithName(String str) {
        for (XWPFStyle xWPFStyle : this.listStyle) {
            if (str.equals(xWPFStyle.getName())) {
                return xWPFStyle;
            }
        }
        return null;
    }

    public XWPFStyle getStyleWithSameName(XWPFStyle xWPFStyle) {
        for (XWPFStyle xWPFStyle2 : this.listStyle) {
            if (xWPFStyle2.hasSameName(xWPFStyle)) {
                return xWPFStyle2;
            }
        }
        return null;
    }

    public List<XWPFStyle> getUsedStyleList(XWPFStyle xWPFStyle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(xWPFStyle);
        return getUsedStyleList(xWPFStyle, arrayList);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                setStyles(StylesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getStyles());
                this.latentStyles = new XWPFLatentStyles(this.ctStyles.getLatentStyles(), this);
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
        } catch (XmlException e) {
            throw new POIXMLException("Unable to read styles", e);
        }
    }

    public void setDefaultFonts(CTFonts cTFonts) {
        ensureDocDefaults();
        CTRPr rPr = this.defaultRunStyle.getRPr();
        if (rPr.sizeOfRFontsArray() == 0) {
            rPr.addNewRFonts();
        }
        rPr.setRFontsArray(0, cTFonts);
    }

    public void setEastAsia(String str) {
        getCTLanguage().setEastAsia(str);
    }

    public void setSpellingLanguage(String str) {
        CTLanguage cTLanguage = getCTLanguage();
        cTLanguage.setVal(str);
        cTLanguage.setBidi(str);
    }

    public void setStyles(CTStyles cTStyles) {
        this.ctStyles = cTStyles;
        for (CTStyle cTStyle : cTStyles.getStyleArray()) {
            this.listStyle.add(new XWPFStyle(cTStyle, this));
        }
        if (this.ctStyles.isSetDocDefaults()) {
            CTDocDefaults docDefaults = this.ctStyles.getDocDefaults();
            if (docDefaults.isSetRPrDefault() && docDefaults.getRPrDefault().isSetRPr()) {
                this.defaultRunStyle = new XWPFDefaultRunStyle(docDefaults.getRPrDefault().getRPr());
            }
            if (docDefaults.isSetPPrDefault() && docDefaults.getPPrDefault().isSetPPr()) {
                this.defaultParaStyle = new XWPFDefaultParagraphStyle(docDefaults.getPPrDefault().getPPr());
            }
        }
    }

    public boolean styleExist(String str) {
        return getStyle(str) != null;
    }

    public XWPFStyles() {
        this.listStyle = new ArrayList();
    }

    private List<XWPFStyle> getUsedStyleList(XWPFStyle xWPFStyle, List<XWPFStyle> list) {
        XWPFStyle style = getStyle(xWPFStyle.getBasisStyleID());
        if (style != null && !list.contains(style)) {
            list.add(style);
            getUsedStyleList(style, list);
        }
        XWPFStyle style2 = getStyle(xWPFStyle.getLinkStyleID());
        if (style2 != null && !list.contains(style2)) {
            list.add(style2);
            getUsedStyleList(style2, list);
        }
        XWPFStyle style3 = getStyle(xWPFStyle.getNextStyleID());
        if (style3 != null && !list.contains(style3)) {
            list.add(style3);
            getUsedStyleList(style3, list);
        }
        return list;
    }
}
