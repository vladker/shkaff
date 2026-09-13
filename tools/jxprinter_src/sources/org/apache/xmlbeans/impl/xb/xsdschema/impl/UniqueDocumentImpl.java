package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class UniqueDocumentImpl extends XmlComplexContentImpl implements UniqueDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "unique")};
    private static final long serialVersionUID = 1;

    public UniqueDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public Keybase addNewUnique() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public Keybase getUnique() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (keybase == null) {
                keybase = null;
            }
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public void setUnique(Keybase keybase) {
        generatedSetterHelperImpl(keybase, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
