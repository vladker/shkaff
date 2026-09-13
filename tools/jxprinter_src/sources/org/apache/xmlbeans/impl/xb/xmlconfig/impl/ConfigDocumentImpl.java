package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import L4.a;
import L4.b;
import L4.c;
import L4.d;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ConfigDocumentImpl extends XmlComplexContentImpl implements ConfigDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "config")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ConfigImpl extends XmlComplexContentImpl implements ConfigDocument.Config {
        private static final QName[] PROPERTY_QNAME = {new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "namespace"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "qname"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "extension"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "usertype")};
        private static final long serialVersionUID = 1;

        public ConfigImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig addNewExtension() {
            Extensionconfig extensionconfig;
            synchronized (monitor()) {
                check_orphaned();
                extensionconfig = (Extensionconfig) get_store().add_element_user(PROPERTY_QNAME[2]);
            }
            return extensionconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig addNewNamespace() {
            Nsconfig nsconfig;
            synchronized (monitor()) {
                check_orphaned();
                nsconfig = (Nsconfig) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return nsconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig addNewQname() {
            Qnameconfig qnameconfig;
            synchronized (monitor()) {
                check_orphaned();
                qnameconfig = (Qnameconfig) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return qnameconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig addNewUsertype() {
            Usertypeconfig usertypeconfig;
            synchronized (monitor()) {
                check_orphaned();
                usertypeconfig = (Usertypeconfig) get_store().add_element_user(PROPERTY_QNAME[3]);
            }
            return usertypeconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig[] getExtensionArray() {
            return (Extensionconfig[]) getXmlObjectArray(PROPERTY_QNAME[2], new Extensionconfig[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public List<Extensionconfig> getExtensionList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 3), new b(this, 1), new a(this, 4), new c(this, 1), new d(this, 1));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig[] getNamespaceArray() {
            return (Nsconfig[]) getXmlObjectArray(PROPERTY_QNAME[0], new Nsconfig[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public List<Nsconfig> getNamespaceList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 1), new b(this, 0), new a(this, 2), new c(this, 0), new d(this, 0));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig[] getQnameArray() {
            return (Qnameconfig[]) getXmlObjectArray(PROPERTY_QNAME[1], new Qnameconfig[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public List<Qnameconfig> getQnameList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 6), new b(this, 3), new a(this, 7), new c(this, 3), new d(this, 3));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig[] getUsertypeArray() {
            return (Usertypeconfig[]) getXmlObjectArray(PROPERTY_QNAME[3], new Usertypeconfig[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public List<Usertypeconfig> getUsertypeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new a(this, 0), new b(this, 2), new a(this, 5), new c(this, 2), new d(this, 2));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig insertNewExtension(int i5) {
            Extensionconfig extensionconfig;
            synchronized (monitor()) {
                check_orphaned();
                extensionconfig = (Extensionconfig) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
            }
            return extensionconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig insertNewNamespace(int i5) {
            Nsconfig nsconfig;
            synchronized (monitor()) {
                check_orphaned();
                nsconfig = (Nsconfig) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
            }
            return nsconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig insertNewQname(int i5) {
            Qnameconfig qnameconfig;
            synchronized (monitor()) {
                check_orphaned();
                qnameconfig = (Qnameconfig) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
            }
            return qnameconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig insertNewUsertype(int i5) {
            Usertypeconfig usertypeconfig;
            synchronized (monitor()) {
                check_orphaned();
                usertypeconfig = (Usertypeconfig) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
            }
            return usertypeconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeExtension(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[2], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeNamespace(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeQname(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeUsertype(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[3], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setExtensionArray(Extensionconfig[] extensionconfigArr) {
            check_orphaned();
            arraySetterHelper(extensionconfigArr, PROPERTY_QNAME[2]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setNamespaceArray(Nsconfig[] nsconfigArr) {
            check_orphaned();
            arraySetterHelper(nsconfigArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setQnameArray(Qnameconfig[] qnameconfigArr) {
            check_orphaned();
            arraySetterHelper(qnameconfigArr, PROPERTY_QNAME[1]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setUsertypeArray(Usertypeconfig[] usertypeconfigArr) {
            check_orphaned();
            arraySetterHelper(usertypeconfigArr, PROPERTY_QNAME[3]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfExtensionArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfNamespaceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfQnameArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfUsertypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig getExtensionArray(int i5) {
            Extensionconfig extensionconfig;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    extensionconfig = (Extensionconfig) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                    if (extensionconfig == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return extensionconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig getNamespaceArray(int i5) {
            Nsconfig nsconfig;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    nsconfig = (Nsconfig) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                    if (nsconfig == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return nsconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig getQnameArray(int i5) {
            Qnameconfig qnameconfig;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    qnameconfig = (Qnameconfig) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                    if (qnameconfig == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return qnameconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig getUsertypeArray(int i5) {
            Usertypeconfig usertypeconfig;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    usertypeconfig = (Usertypeconfig) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                    if (usertypeconfig == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return usertypeconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setExtensionArray(int i5, Extensionconfig extensionconfig) {
            generatedSetterHelperImpl(extensionconfig, PROPERTY_QNAME[2], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setNamespaceArray(int i5, Nsconfig nsconfig) {
            generatedSetterHelperImpl(nsconfig, PROPERTY_QNAME[0], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setQnameArray(int i5, Qnameconfig qnameconfig) {
            generatedSetterHelperImpl(qnameconfig, PROPERTY_QNAME[1], i5, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setUsertypeArray(int i5, Usertypeconfig usertypeconfig) {
            generatedSetterHelperImpl(usertypeconfig, PROPERTY_QNAME[3], i5, (short) 2);
        }
    }

    public ConfigDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument
    public ConfigDocument.Config addNewConfig() {
        ConfigDocument.Config config;
        synchronized (monitor()) {
            check_orphaned();
            config = (ConfigDocument.Config) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return config;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument
    public ConfigDocument.Config getConfig() {
        ConfigDocument.Config config;
        synchronized (monitor()) {
            check_orphaned();
            config = (ConfigDocument.Config) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (config == null) {
                config = null;
            }
        }
        return config;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument
    public void setConfig(ConfigDocument.Config config) {
        generatedSetterHelperImpl(config, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
