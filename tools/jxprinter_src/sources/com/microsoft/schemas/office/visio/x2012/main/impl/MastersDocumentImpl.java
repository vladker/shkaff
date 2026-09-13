package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MastersDocument;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class MastersDocumentImpl extends XmlComplexContentImpl implements MastersDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Masters")};
    private static final long serialVersionUID = 1;

    public MastersDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersDocument
    public MastersType addNewMasters() {
        MastersType mastersType;
        synchronized (monitor()) {
            check_orphaned();
            mastersType = (MastersType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return mastersType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersDocument
    public MastersType getMasters() {
        MastersType mastersType;
        synchronized (monitor()) {
            check_orphaned();
            mastersType = (MastersType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (mastersType == null) {
                mastersType = null;
            }
        }
        return mastersType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersDocument
    public void setMasters(MastersType mastersType) {
        generatedSetterHelperImpl(mastersType, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
