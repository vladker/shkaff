package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType;
import org.openxmlformats.schemas.drawingml.x2006.chart.STSplitType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTSplitTypeImpl extends XmlComplexContentImpl implements CTSplitType {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTSplitTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType
    public STSplitType.Enum getVal() {
        STSplitType.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
                }
                r6 = simpleValue == null ? null : (STSplitType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType
    public boolean isSetVal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType
    public void setVal(STSplitType.Enum r6) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType
    public STSplitType xgetVal() {
        STSplitType sTSplitType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTSplitType = (STSplitType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTSplitType == null) {
                    sTSplitType = (STSplitType) get_default_attribute_value(qNameArr[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTSplitType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType
    public void xsetVal(STSplitType sTSplitType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSplitType sTSplitType2 = (STSplitType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTSplitType2 == null) {
                    sTSplitType2 = (STSplitType) get_store().add_attribute_user(qNameArr[0]);
                }
                sTSplitType2.set(sTSplitType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
