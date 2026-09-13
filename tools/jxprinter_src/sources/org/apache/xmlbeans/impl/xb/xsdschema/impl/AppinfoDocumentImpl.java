package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AppinfoDocumentImpl extends XmlComplexContentImpl implements AppinfoDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "appinfo")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AppinfoImpl extends XmlComplexContentImpl implements AppinfoDocument.Appinfo {
        private static final QName[] PROPERTY_QNAME = {new QName("", FirebaseAnalytics.Param.SOURCE)};
        private static final long serialVersionUID = 1;

        public AppinfoImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public String getSource() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public boolean isSetSource() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
            }
            return z6;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void unsetSource() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[0]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public XmlAnyURI xgetSource() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
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

    public AppinfoDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument
    public AppinfoDocument.Appinfo addNewAppinfo() {
        AppinfoDocument.Appinfo appinfo;
        synchronized (monitor()) {
            check_orphaned();
            appinfo = (AppinfoDocument.Appinfo) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return appinfo;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument
    public AppinfoDocument.Appinfo getAppinfo() {
        AppinfoDocument.Appinfo appinfo;
        synchronized (monitor()) {
            check_orphaned();
            appinfo = (AppinfoDocument.Appinfo) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (appinfo == null) {
                appinfo = null;
            }
        }
        return appinfo;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument
    public void setAppinfo(AppinfoDocument.Appinfo appinfo) {
        generatedSetterHelperImpl(appinfo, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
