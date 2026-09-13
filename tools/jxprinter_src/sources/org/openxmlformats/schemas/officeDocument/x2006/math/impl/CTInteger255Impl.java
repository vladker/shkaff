package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger255;
import org.openxmlformats.schemas.officeDocument.x2006.math.STInteger255;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTInteger255Impl extends XmlComplexContentImpl implements CTInteger255 {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "val")};
    private static final long serialVersionUID = 1;

    public CTInteger255Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger255
    public int getVal() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger255
    public void setVal(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger255
    public STInteger255 xgetVal() {
        STInteger255 sTInteger255;
        synchronized (monitor()) {
            check_orphaned();
            sTInteger255 = (STInteger255) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTInteger255;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger255
    public void xsetVal(STInteger255 sTInteger255) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STInteger255 sTInteger256 = (STInteger255) typeStore.find_attribute_user(qNameArr[0]);
                if (sTInteger256 == null) {
                    sTInteger256 = (STInteger255) get_store().add_attribute_user(qNameArr[0]);
                }
                sTInteger256.set(sTInteger255);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
