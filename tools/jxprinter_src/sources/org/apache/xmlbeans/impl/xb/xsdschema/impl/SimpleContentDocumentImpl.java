package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SimpleContentDocumentImpl extends XmlComplexContentImpl implements SimpleContentDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "simpleContent")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SimpleContentImpl extends AnnotatedImpl implements SimpleContentDocument.SimpleContent {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "restriction"), new QName("http://www.w3.org/2001/XMLSchema", "extension")};
        private static final long serialVersionUID = 1;

        public SimpleContentImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleExtensionType addNewExtension() {
            SimpleExtensionType simpleExtensionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleExtensionType = (SimpleExtensionType) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return simpleExtensionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleRestrictionType addNewRestriction() {
            SimpleRestrictionType simpleRestrictionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleRestrictionType = (SimpleRestrictionType) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return simpleRestrictionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleExtensionType getExtension() {
            SimpleExtensionType simpleExtensionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleExtensionType = (SimpleExtensionType) get_store().find_element_user(PROPERTY_QNAME[1], 0);
                if (simpleExtensionType == null) {
                    simpleExtensionType = null;
                }
            }
            return simpleExtensionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleRestrictionType getRestriction() {
            SimpleRestrictionType simpleRestrictionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleRestrictionType = (SimpleRestrictionType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
                if (simpleRestrictionType == null) {
                    simpleRestrictionType = null;
                }
            }
            return simpleRestrictionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public boolean isSetExtension() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = true;
                if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                    z6 = false;
                }
            }
            return z6;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public boolean isSetRestriction() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
            }
            return z6;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void setExtension(SimpleExtensionType simpleExtensionType) {
            generatedSetterHelperImpl(simpleExtensionType, PROPERTY_QNAME[1], 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void setRestriction(SimpleRestrictionType simpleRestrictionType) {
            generatedSetterHelperImpl(simpleRestrictionType, PROPERTY_QNAME[0], 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void unsetExtension() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void unsetRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], 0);
            }
        }
    }

    public SimpleContentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public SimpleContentDocument.SimpleContent addNewSimpleContent() {
        SimpleContentDocument.SimpleContent simpleContent;
        synchronized (monitor()) {
            check_orphaned();
            simpleContent = (SimpleContentDocument.SimpleContent) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return simpleContent;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public SimpleContentDocument.SimpleContent getSimpleContent() {
        SimpleContentDocument.SimpleContent simpleContent;
        synchronized (monitor()) {
            check_orphaned();
            simpleContent = (SimpleContentDocument.SimpleContent) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (simpleContent == null) {
                simpleContent = null;
            }
        }
        return simpleContent;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public void setSimpleContent(SimpleContentDocument.SimpleContent simpleContent) {
        generatedSetterHelperImpl(simpleContent, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
