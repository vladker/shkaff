package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTXAlign;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXAlign;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTXAlignImpl extends XmlComplexContentImpl implements CTXAlign {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "val")};
    private static final long serialVersionUID = 1;

    public CTXAlignImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTXAlign
    public STXAlign.Enum getVal() {
        STXAlign.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STXAlign.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTXAlign
    public void setVal(STXAlign.Enum r6) {
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

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTXAlign
    public STXAlign xgetVal() {
        STXAlign sTXAlign;
        synchronized (monitor()) {
            check_orphaned();
            sTXAlign = (STXAlign) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTXAlign;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTXAlign
    public void xsetVal(STXAlign sTXAlign) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STXAlign sTXAlign2 = (STXAlign) typeStore.find_attribute_user(qNameArr[0]);
                if (sTXAlign2 == null) {
                    sTXAlign2 = (STXAlign) get_store().add_attribute_user(qNameArr[0]);
                }
                sTXAlign2.set(sTXAlign);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
