package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLblAlgn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTLblAlgnImpl extends XmlComplexContentImpl implements CTLblAlgn {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTLblAlgnImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn
    public STLblAlgn.Enum getVal() {
        STLblAlgn.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STLblAlgn.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn
    public void setVal(STLblAlgn.Enum r6) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn
    public STLblAlgn xgetVal() {
        STLblAlgn sTLblAlgn;
        synchronized (monitor()) {
            check_orphaned();
            sTLblAlgn = (STLblAlgn) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTLblAlgn;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn
    public void xsetVal(STLblAlgn sTLblAlgn) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLblAlgn sTLblAlgn2 = (STLblAlgn) typeStore.find_attribute_user(qNameArr[0]);
                if (sTLblAlgn2 == null) {
                    sTLblAlgn2 = (STLblAlgn) get_store().add_attribute_user(qNameArr[0]);
                }
                sTLblAlgn2.set(sTLblAlgn);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
