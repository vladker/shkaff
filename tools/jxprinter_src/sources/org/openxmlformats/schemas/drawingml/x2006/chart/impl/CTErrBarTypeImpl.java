package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrBarType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTErrBarTypeImpl extends XmlComplexContentImpl implements CTErrBarType {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTErrBarTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType
    public STErrBarType.Enum getVal() {
        STErrBarType.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
                }
                r6 = simpleValue == null ? null : (STErrBarType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType
    public boolean isSetVal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType
    public void setVal(STErrBarType.Enum r6) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType
    public STErrBarType xgetVal() {
        STErrBarType sTErrBarType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTErrBarType = (STErrBarType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTErrBarType == null) {
                    sTErrBarType = (STErrBarType) get_default_attribute_value(qNameArr[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTErrBarType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBarType
    public void xsetVal(STErrBarType sTErrBarType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STErrBarType sTErrBarType2 = (STErrBarType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTErrBarType2 == null) {
                    sTErrBarType2 = (STErrBarType) get_store().add_attribute_user(qNameArr[0]);
                }
                sTErrBarType2.set(sTErrBarType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
