package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng;
import org.openxmlformats.schemas.drawingml.x2006.chart.STFirstSliceAng;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTFirstSliceAngImpl extends XmlComplexContentImpl implements CTFirstSliceAng {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTFirstSliceAngImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public int getVal() {
        int intValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                intValue = 0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
                }
                if (simpleValue != null) {
                    intValue = simpleValue.getIntValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public boolean isSetVal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public STFirstSliceAng xgetVal() {
        STFirstSliceAng sTFirstSliceAngFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTFirstSliceAngFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
                if (sTFirstSliceAngFind_attribute_user == null) {
                    sTFirstSliceAngFind_attribute_user = (STFirstSliceAng) get_default_attribute_value(qNameArr[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTFirstSliceAngFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public void xsetVal(STFirstSliceAng sTFirstSliceAng) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STFirstSliceAng sTFirstSliceAngFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
                if (sTFirstSliceAngFind_attribute_user == null) {
                    sTFirstSliceAngFind_attribute_user = (STFirstSliceAng) get_store().add_attribute_user(qNameArr[0]);
                }
                sTFirstSliceAngFind_attribute_user.set(sTFirstSliceAng);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
