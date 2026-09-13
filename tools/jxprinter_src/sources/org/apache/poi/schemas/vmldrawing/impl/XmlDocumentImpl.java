package org.apache.poi.schemas.vmldrawing.impl;

import javax.xml.namespace.QName;
import org.apache.poi.schemas.vmldrawing.CTXML;
import org.apache.poi.schemas.vmldrawing.XmlDocument;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XmlDocumentImpl extends XmlComplexContentImpl implements XmlDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-poi-apache-org:vmldrawing", "xml")};
    private static final long serialVersionUID = 1;

    public XmlDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.poi.schemas.vmldrawing.XmlDocument
    public CTXML addNewXml() {
        CTXML ctxml;
        synchronized (monitor()) {
            check_orphaned();
            ctxml = (CTXML) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return ctxml;
    }

    @Override // org.apache.poi.schemas.vmldrawing.XmlDocument
    public CTXML getXml() {
        CTXML ctxml;
        synchronized (monitor()) {
            check_orphaned();
            ctxml = (CTXML) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (ctxml == null) {
                ctxml = null;
            }
        }
        return ctxml;
    }

    @Override // org.apache.poi.schemas.vmldrawing.XmlDocument
    public void setXml(CTXML ctxml) {
        generatedSetterHelperImpl(ctxml, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
