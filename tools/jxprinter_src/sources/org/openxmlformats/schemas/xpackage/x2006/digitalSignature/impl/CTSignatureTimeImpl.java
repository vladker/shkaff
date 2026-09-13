package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.STFormat;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.STValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSignatureTimeImpl extends XmlComplexContentImpl implements CTSignatureTime {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/package/2006/digital-signature", "Format"), new QName("http://schemas.openxmlformats.org/package/2006/digital-signature", "Value")};
    private static final long serialVersionUID = 1;

    public CTSignatureTimeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public String getFormat() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public String getValue() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void setFormat(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[0], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[0]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void setValue(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[1], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[1]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public STFormat xgetFormat() {
        STFormat sTFormat;
        synchronized (monitor()) {
            check_orphaned();
            sTFormat = (STFormat) get_store().find_element_user(PROPERTY_QNAME[0], 0);
        }
        return sTFormat;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public STValue xgetValue() {
        STValue sTValue;
        synchronized (monitor()) {
            check_orphaned();
            sTValue = (STValue) get_store().find_element_user(PROPERTY_QNAME[1], 0);
        }
        return sTValue;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void xsetFormat(STFormat sTFormat) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STFormat sTFormat2 = (STFormat) typeStore.find_element_user(qNameArr[0], 0);
                if (sTFormat2 == null) {
                    sTFormat2 = (STFormat) get_store().add_element_user(qNameArr[0]);
                }
                sTFormat2.set(sTFormat);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void xsetValue(STValue sTValue) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STValue sTValue2 = (STValue) typeStore.find_element_user(qNameArr[1], 0);
                if (sTValue2 == null) {
                    sTValue2 = (STValue) get_store().add_element_user(qNameArr[1]);
                }
                sTValue2.set(sTValue);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
