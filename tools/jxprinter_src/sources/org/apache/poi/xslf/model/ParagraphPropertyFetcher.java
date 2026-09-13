package org.apache.poi.xslf.model;

import java.util.function.Consumer;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import l5.d2;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.usermodel.a;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class ParagraphPropertyFetcher<T> extends PropertyFetcher<T> {
    static final String DML_NS = "http://schemas.openxmlformats.org/drawingml/2006/main";
    static final String PML_NS = "http://schemas.openxmlformats.org/presentationml/2006/main";
    int _level;
    private final ParaPropFetcher<T> fetcher;
    private final XSLFTextParagraph para;
    private static final QName[] TX_BODY = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "txBody")};
    private static final QName[] LST_STYLE = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lstStyle")};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ParaPropFetcher<S> {
        void fetch(CTTextParagraphProperties cTTextParagraphProperties, Consumer<S> consumer);
    }

    public ParagraphPropertyFetcher(XSLFTextParagraph xSLFTextParagraph, ParaPropFetcher<T> paraPropFetcher) {
        this.para = xSLFTextParagraph;
        this._level = xSLFTextParagraph.getIndentLevel();
        this.fetcher = paraPropFetcher;
    }

    private void fetchMasterProp() {
        if (isSet()) {
            return;
        }
        fetchProp(this.para.getDefaultMasterStyle());
    }

    private void fetchParagraphProp() {
        fetchProp(this.para.getXmlObject().getPPr());
    }

    private void fetchProp(CTTextParagraphProperties cTTextParagraphProperties) {
        if (cTTextParagraphProperties != null) {
            this.fetcher.fetch(cTTextParagraphProperties, new d2(this, 11));
        }
    }

    private void fetchShapeProp(XSLFShape xSLFShape) {
        if (isSet()) {
            return;
        }
        xSLFShape.fetchShapeProperty(this);
    }

    private void fetchThemeProp(XSLFShape xSLFShape) {
        if (isSet()) {
            return;
        }
        fetchProp(getThemeProps(xSLFShape, this._level));
    }

    public static CTTextParagraphProperties getThemeProps(XSLFShape xSLFShape, int i5) {
        CTTextListStyle defaultTextStyle;
        if (xSLFShape.isPlaceholder() || (defaultTextStyle = xSLFShape.getSheet().getSlideShow().getCTPresentation().getDefaultTextStyle()) == null) {
            return null;
        }
        switch (i5) {
            case 0:
                return defaultTextStyle.getLvl1PPr();
            case 1:
                return defaultTextStyle.getLvl2PPr();
            case 2:
                return defaultTextStyle.getLvl3PPr();
            case 3:
                return defaultTextStyle.getLvl4PPr();
            case 4:
                return defaultTextStyle.getLvl5PPr();
            case 5:
                return defaultTextStyle.getLvl6PPr();
            case 6:
                return defaultTextStyle.getLvl7PPr();
            case 7:
                return defaultTextStyle.getLvl8PPr();
            case 8:
                return defaultTextStyle.getLvl9PPr();
            default:
                return null;
        }
    }

    public static CTTextParagraphProperties parse(XMLStreamReader xMLStreamReader) {
        CTTextParagraph cTTextParagraph = CTTextParagraph.Factory.parse(xMLStreamReader);
        if (cTTextParagraph == null || !cTTextParagraph.isSetPPr()) {
            return null;
        }
        return cTTextParagraph.getPPr();
    }

    public static CTTextParagraphProperties select(XSLFShape xSLFShape, int i5) {
        return (CTTextParagraphProperties) XPathHelper.selectProperty(xSLFShape.getXmlObject(), CTTextParagraphProperties.class, new a(4), TX_BODY, LST_STYLE, new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl" + (i5 + 1) + "pPr")});
    }

    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFShape xSLFShape) {
        try {
            fetchProp(select(xSLFShape, this._level));
        } catch (XmlException unused) {
        }
        return isSet();
    }

    public T fetchProperty(XSLFShape xSLFShape) {
        XSLFSheet sheet = xSLFShape.getSheet();
        fetchParagraphProp();
        if (!(sheet instanceof XSLFSlideMaster)) {
            fetchShapeProp(xSLFShape);
            fetchThemeProp(xSLFShape);
        }
        fetchMasterProp();
        if (isSet()) {
            return getValue();
        }
        return null;
    }
}
