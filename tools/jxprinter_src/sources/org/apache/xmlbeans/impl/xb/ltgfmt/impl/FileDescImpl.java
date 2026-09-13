package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FileDescImpl extends XmlComplexContentImpl implements FileDesc {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "code"), new QName("", "tsDir"), new QName("", "folder"), new QName("", "fileName"), new QName("", "role"), new QName("", "validity")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RoleImpl extends JavaStringEnumerationHolderEx implements FileDesc.Role {
        private static final long serialVersionUID = 1;

        public RoleImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public RoleImpl(SchemaType schemaType, boolean z6) {
            super(schemaType, z6);
        }
    }

    public FileDescImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public Code addNewCode() {
        Code code;
        synchronized (monitor()) {
            check_orphaned();
            code = (Code) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return code;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public Code getCode() {
        Code code;
        synchronized (monitor()) {
            check_orphaned();
            code = (Code) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (code == null) {
                code = null;
            }
        }
        return code;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getFileName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getFolder() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public FileDesc.Role.Enum getRole() {
        FileDesc.Role.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            r6 = simpleValue == null ? null : (FileDesc.Role.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getTsDir() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean getValidity() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetCode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetFileName() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z6;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetFolder() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z6;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetRole() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z6;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetTsDir() {
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetValidity() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z6;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setCode(Code code) {
        generatedSetterHelperImpl(code, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setFileName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setFolder(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setRole(FileDesc.Role.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setTsDir(String str) {
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setValidity(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetCode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetFileName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetFolder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetRole() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetTsDir() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetValidity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetFileName() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetFolder() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public FileDesc.Role xgetRole() {
        FileDesc.Role role;
        synchronized (monitor()) {
            check_orphaned();
            role = (FileDesc.Role) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return role;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetTsDir() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlBoolean xgetValidity() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetFileName(XmlToken xmlToken) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[3]);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[3]);
                }
                xmlToken2.set(xmlToken);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetFolder(XmlToken xmlToken) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[2]);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[2]);
                }
                xmlToken2.set(xmlToken);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetRole(FileDesc.Role role) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                FileDesc.Role role2 = (FileDesc.Role) typeStore.find_attribute_user(qNameArr[4]);
                if (role2 == null) {
                    role2 = (FileDesc.Role) get_store().add_attribute_user(qNameArr[4]);
                }
                role2.set(role);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetTsDir(XmlToken xmlToken) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[1]);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[1]);
                }
                xmlToken2.set(xmlToken);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetValidity(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[5]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[5]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
