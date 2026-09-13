package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DocumentationDocumentImpl extends XmlComplexContentImpl implements DocumentationDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "documentation")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DocumentationImpl extends XmlComplexContentImpl implements DocumentationDocument.Documentation {
        private static final QName[] PROPERTY_QNAME = {new QName("", FirebaseAnalytics.Param.SOURCE), new QName("http://www.w3.org/XML/1998/namespace", "lang")};
        private static final long serialVersionUID = 1;

        public DocumentationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public String getLang() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public String getSource() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public boolean isSetLang() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = true;
                if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                    z6 = false;
                }
            }
            return z6;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public boolean isSetSource() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
            }
            return z6;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void setLang(String str) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                    if (simpleValue == null) {
                        simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                    }
                    simpleValue.setStringValue(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void setSource(String str) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                    if (simpleValue == null) {
                        simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                    }
                    simpleValue.setStringValue(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void unsetLang() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[1]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void unsetSource() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[0]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public LangAttribute.Lang xgetLang() {
            LangAttribute.Lang lang;
            synchronized (monitor()) {
                check_orphaned();
                lang = (LangAttribute.Lang) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            }
            return lang;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public XmlAnyURI xgetSource() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void xsetLang(LangAttribute.Lang lang) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    LangAttribute.Lang lang2 = (LangAttribute.Lang) typeStore.find_attribute_user(qNameArr[1]);
                    if (lang2 == null) {
                        lang2 = (LangAttribute.Lang) get_store().add_attribute_user(qNameArr[1]);
                    }
                    lang2.set(lang);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void xsetSource(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qNameArr[0]);
                    if (xmlAnyURI2 == null) {
                        xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qNameArr[0]);
                    }
                    xmlAnyURI2.set(xmlAnyURI);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public DocumentationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public DocumentationDocument.Documentation addNewDocumentation() {
        DocumentationDocument.Documentation documentation;
        synchronized (monitor()) {
            check_orphaned();
            documentation = (DocumentationDocument.Documentation) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return documentation;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public DocumentationDocument.Documentation getDocumentation() {
        DocumentationDocument.Documentation documentation;
        synchronized (monitor()) {
            check_orphaned();
            documentation = (DocumentationDocument.Documentation) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (documentation == null) {
                documentation = null;
            }
        }
        return documentation;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public void setDocumentation(DocumentationDocument.Documentation documentation) {
        generatedSetterHelperImpl(documentation, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
