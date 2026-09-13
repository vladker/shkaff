package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.STSecondPieSize;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTSecondPieSizeImpl extends XmlComplexContentImpl implements CTSecondPieSize {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTSecondPieSizeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize
    public Object getVal() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize
    public boolean isSetVal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize
    public STSecondPieSize xgetVal() {
        STSecondPieSize sTSecondPieSize;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTSecondPieSize = (STSecondPieSize) typeStore.find_attribute_user(qNameArr[0]);
                if (sTSecondPieSize == null) {
                    sTSecondPieSize = (STSecondPieSize) get_default_attribute_value(qNameArr[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTSecondPieSize;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize
    public void xsetVal(STSecondPieSize sTSecondPieSize) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSecondPieSize sTSecondPieSize2 = (STSecondPieSize) typeStore.find_attribute_user(qNameArr[0]);
                if (sTSecondPieSize2 == null) {
                    sTSecondPieSize2 = (STSecondPieSize) get_store().add_attribute_user(qNameArr[0]);
                }
                sTSecondPieSize2.set(sTSecondPieSize);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
