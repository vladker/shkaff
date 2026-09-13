package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercentOrPercentString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTextSpacingPercentImpl extends XmlComplexContentImpl implements CTTextSpacingPercent {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTTextSpacingPercentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
    public Object getVal() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
    public void setVal(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
    public STTextSpacingPercentOrPercentString xgetVal() {
        STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString;
        synchronized (monitor()) {
            check_orphaned();
            sTTextSpacingPercentOrPercentString = (STTextSpacingPercentOrPercentString) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTTextSpacingPercentOrPercentString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent
    public void xsetVal(STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString2 = (STTextSpacingPercentOrPercentString) typeStore.find_attribute_user(qNameArr[0]);
                if (sTTextSpacingPercentOrPercentString2 == null) {
                    sTTextSpacingPercentOrPercentString2 = (STTextSpacingPercentOrPercentString) get_store().add_attribute_user(qNameArr[0]);
                }
                sTTextSpacingPercentOrPercentString2.set(sTTextSpacingPercentOrPercentString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
