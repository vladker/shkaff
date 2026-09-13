package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class KeyrefDocumentImpl extends XmlComplexContentImpl implements KeyrefDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "keyref")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class KeyrefImpl extends KeybaseImpl implements KeyrefDocument.Keyref {
        private static final QName[] PROPERTY_QNAME = {new QName("", "refer")};
        private static final long serialVersionUID = 1;

        public KeyrefImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public QName getRefer() {
            QName qNameValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                qNameValue = simpleValue == null ? null : simpleValue.getQNameValue();
            }
            return qNameValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public void setRefer(QName qName) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                    if (simpleValue == null) {
                        simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                    }
                    simpleValue.setQNameValue(qName);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public XmlQName xgetRefer() {
            XmlQName xmlQName;
            synchronized (monitor()) {
                check_orphaned();
                xmlQName = (XmlQName) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            }
            return xmlQName;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public void xsetRefer(XmlQName xmlQName) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qNameArr[0]);
                    if (xmlQName2 == null) {
                        xmlQName2 = (XmlQName) get_store().add_attribute_user(qNameArr[0]);
                    }
                    xmlQName2.set(xmlQName);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public KeyrefDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public KeyrefDocument.Keyref addNewKeyref() {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public KeyrefDocument.Keyref getKeyref() {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (keyref == null) {
                keyref = null;
            }
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public void setKeyref(KeyrefDocument.Keyref keyref) {
        generatedSetterHelperImpl(keyref, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
