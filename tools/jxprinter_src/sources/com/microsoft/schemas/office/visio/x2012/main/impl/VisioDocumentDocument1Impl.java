package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class VisioDocumentDocument1Impl extends XmlComplexContentImpl implements VisioDocumentDocument1 {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "VisioDocument")};
    private static final long serialVersionUID = 1;

    public VisioDocumentDocument1Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1
    public VisioDocumentType addNewVisioDocument() {
        VisioDocumentType visioDocumentType;
        synchronized (monitor()) {
            check_orphaned();
            visioDocumentType = (VisioDocumentType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return visioDocumentType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1
    public VisioDocumentType getVisioDocument() {
        VisioDocumentType visioDocumentType;
        synchronized (monitor()) {
            check_orphaned();
            visioDocumentType = (VisioDocumentType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (visioDocumentType == null) {
                visioDocumentType = null;
            }
        }
        return visioDocumentType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1
    public void setVisioDocument(VisioDocumentType visioDocumentType) {
        generatedSetterHelperImpl(visioDocumentType, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
