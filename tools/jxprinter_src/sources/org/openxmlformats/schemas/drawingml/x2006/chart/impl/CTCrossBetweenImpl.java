package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTCrossBetweenImpl extends XmlComplexContentImpl implements CTCrossBetween {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTCrossBetweenImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween
    public STCrossBetween.Enum getVal() {
        STCrossBetween.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STCrossBetween.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween
    public void setVal(STCrossBetween.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween
    public STCrossBetween xgetVal() {
        STCrossBetween sTCrossBetween;
        synchronized (monitor()) {
            check_orphaned();
            sTCrossBetween = (STCrossBetween) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTCrossBetween;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween
    public void xsetVal(STCrossBetween sTCrossBetween) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STCrossBetween sTCrossBetween2 = (STCrossBetween) typeStore.find_attribute_user(qNameArr[0]);
                if (sTCrossBetween2 == null) {
                    sTCrossBetween2 = (STCrossBetween) get_store().add_attribute_user(qNameArr[0]);
                }
                sTCrossBetween2.set(sTCrossBetween);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
