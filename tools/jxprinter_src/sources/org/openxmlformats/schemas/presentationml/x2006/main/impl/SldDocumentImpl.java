package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SldDocumentImpl extends XmlComplexContentImpl implements SldDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "sld")};
    private static final long serialVersionUID = 1;

    public SldDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldDocument
    public CTSlide addNewSld() {
        CTSlide cTSlide;
        synchronized (monitor()) {
            check_orphaned();
            cTSlide = (CTSlide) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSlide;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldDocument
    public CTSlide getSld() {
        CTSlide cTSlide;
        synchronized (monitor()) {
            check_orphaned();
            cTSlide = (CTSlide) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSlide == null) {
                cTSlide = null;
            }
        }
        return cTSlide;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldDocument
    public void setSld(CTSlide cTSlide) {
        generatedSetterHelperImpl(cTSlide, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
