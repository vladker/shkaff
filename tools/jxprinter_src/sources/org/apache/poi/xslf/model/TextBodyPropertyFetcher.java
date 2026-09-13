package org.apache.poi.xslf.model;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.xdgf.usermodel.a;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TextBodyPropertyFetcher<T> extends PropertyFetcher<T> {
    private static final QName[] TX_BODY = {new QName(XSSFRelation.NS_PRESENTATIONML, "txBody")};
    private static final QName[] BODY_PR = {new QName(XSSFRelation.NS_DRAWINGML, "bodyPr")};

    /* JADX INFO: Access modifiers changed from: private */
    public static CTTextBodyProperties parse(XMLStreamReader xMLStreamReader) {
        CTTextBody cTTextBody = CTTextBody.Factory.parse(xMLStreamReader);
        if (cTTextBody != null) {
            return cTTextBody.getBodyPr();
        }
        return null;
    }

    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFShape xSLFShape) {
        try {
            CTTextBodyProperties cTTextBodyProperties = (CTTextBodyProperties) XPathHelper.selectProperty(xSLFShape.getXmlObject(), CTTextBodyProperties.class, new a(5), TX_BODY, BODY_PR);
            return cTTextBodyProperties != null && fetch(cTTextBodyProperties);
        } catch (XmlException unused) {
        }
    }

    public abstract boolean fetch(CTTextBodyProperties cTTextBodyProperties);
}
