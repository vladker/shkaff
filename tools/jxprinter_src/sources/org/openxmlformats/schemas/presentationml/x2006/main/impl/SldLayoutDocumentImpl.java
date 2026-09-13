package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SldLayoutDocumentImpl extends XmlComplexContentImpl implements SldLayoutDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "sldLayout")};
    private static final long serialVersionUID = 1;

    public SldLayoutDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument
    public CTSlideLayout addNewSldLayout() {
        CTSlideLayout cTSlideLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideLayout = (CTSlideLayout) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSlideLayout;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument
    public CTSlideLayout getSldLayout() {
        CTSlideLayout cTSlideLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideLayout = (CTSlideLayout) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSlideLayout == null) {
                cTSlideLayout = null;
            }
        }
        return cTSlideLayout;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument
    public void setSldLayout(CTSlideLayout cTSlideLayout) {
        generatedSetterHelperImpl(cTSlideLayout, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
