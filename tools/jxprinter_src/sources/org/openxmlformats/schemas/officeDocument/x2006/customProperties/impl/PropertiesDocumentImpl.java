package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class PropertiesDocumentImpl extends XmlComplexContentImpl implements PropertiesDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "Properties")};
    private static final long serialVersionUID = 1;

    public PropertiesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument
    public CTProperties addNewProperties() {
        CTProperties cTProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTProperties = (CTProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTProperties;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument
    public CTProperties getProperties() {
        CTProperties cTProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTProperties = (CTProperties) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTProperties == null) {
                cTProperties = null;
            }
        }
        return cTProperties;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument
    public void setProperties(CTProperties cTProperties) {
        generatedSetterHelperImpl(cTProperties, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
