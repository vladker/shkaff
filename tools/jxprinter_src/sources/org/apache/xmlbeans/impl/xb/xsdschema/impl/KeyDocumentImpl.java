package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import io.flutter.plugins.firebase.crashlytics.Constants;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class KeyDocumentImpl extends XmlComplexContentImpl implements KeyDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", Constants.KEY)};
    private static final long serialVersionUID = 1;

    public KeyDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public Keybase addNewKey() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public Keybase getKey() {
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public void setKey(Keybase keybase) {
        generatedSetterHelperImpl(keybase, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
