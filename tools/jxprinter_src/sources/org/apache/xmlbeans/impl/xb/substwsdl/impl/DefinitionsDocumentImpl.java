package org.apache.xmlbeans.impl.xb.substwsdl.impl;

import K4.a;
import K4.b;
import K4.c;
import K4.d;
import androidx.core.app.NotificationCompat;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.substwsdl.TImport;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DefinitionsDocumentImpl extends XmlComplexContentImpl implements DefinitionsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "definitions")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DefinitionsImpl extends XmlComplexContentImpl implements DefinitionsDocument.Definitions {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "import"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "types"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", Constants.MESSAGE), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "binding"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "portType"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", NotificationCompat.CATEGORY_SERVICE)};
        private static final long serialVersionUID = 1;

        public DefinitionsImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewBinding() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[3]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport addNewImport() {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewMessage() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[2]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewPortType() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[4]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewService() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[5]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewTypes() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getBindingArray() {
            return getXmlObjectArray(PROPERTY_QNAME[3], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getBindingList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 7), new b(this, 4), new a(this, 8), new c(this, 3), new d(this, 3));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport[] getImportArray() {
            return (TImport[]) getXmlObjectArray(PROPERTY_QNAME[0], new TImport[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<TImport> getImportList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 10), new b(this, 5), new a(this, 11), new c(this, 5), new d(this, 5));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getMessageArray() {
            return getXmlObjectArray(PROPERTY_QNAME[2], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getMessageList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 0), new b(this, 2), new a(this, 9), new c(this, 4), new d(this, 4));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getPortTypeArray() {
            return getXmlObjectArray(PROPERTY_QNAME[4], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getPortTypeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 3), new b(this, 1), new a(this, 4), new c(this, 1), new d(this, 1));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getServiceArray() {
            return getXmlObjectArray(PROPERTY_QNAME[5], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getServiceList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 5), new b(this, 3), new a(this, 6), new c(this, 2), new d(this, 2));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getTypesArray() {
            return getXmlObjectArray(PROPERTY_QNAME[1], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getTypesList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 1), new b(this, 0), new a(this, 2), new c(this, 0), new d(this, 0));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewBinding(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport insertNewImport(int i5) {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewMessage(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewPortType(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewService(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[5], i5);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewTypes(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeBinding(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[3], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeImport(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeMessage(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[2], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removePortType(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[4], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeService(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[5], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeTypes(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setBindingArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[3]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setImportArray(TImport[] tImportArr) {
            check_orphaned();
            arraySetterHelper(tImportArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setMessageArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[2]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setPortTypeArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[4]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setServiceArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[5]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setTypesArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[1]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfBindingArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfImportArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfMessageArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfPortTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfServiceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfTypesArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getBindingArray(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                    if (xmlObject == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport getImportArray(int i5) {
            TImport tImport;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    tImport = (TImport) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                    if (tImport == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getMessageArray(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                    if (xmlObject == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getPortTypeArray(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                    if (xmlObject == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getServiceArray(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                    if (xmlObject == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getTypesArray(int i5) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                    if (xmlObject == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setBindingArray(int i5, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[3], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setImportArray(int i5, TImport tImport) {
            generatedSetterHelperImpl(tImport, PROPERTY_QNAME[0], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setMessageArray(int i5, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[2], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setPortTypeArray(int i5, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[4], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setServiceArray(int i5, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[5], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setTypesArray(int i5, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[1], i5, (short) 2);
        }
    }

    public DefinitionsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public DefinitionsDocument.Definitions addNewDefinitions() {
        DefinitionsDocument.Definitions definitions;
        synchronized (monitor()) {
            check_orphaned();
            definitions = (DefinitionsDocument.Definitions) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return definitions;
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public DefinitionsDocument.Definitions getDefinitions() {
        DefinitionsDocument.Definitions definitions;
        synchronized (monitor()) {
            check_orphaned();
            definitions = (DefinitionsDocument.Definitions) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (definitions == null) {
                definitions = null;
            }
        }
        return definitions;
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public void setDefinitions(DefinitionsDocument.Definitions definitions) {
        generatedSetterHelperImpl(definitions, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
