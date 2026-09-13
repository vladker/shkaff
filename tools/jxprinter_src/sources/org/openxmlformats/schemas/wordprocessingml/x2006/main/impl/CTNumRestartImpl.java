package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumRestart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STRestartNumber;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTNumRestartImpl extends XmlComplexContentImpl implements CTNumRestart {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "val")};
    private static final long serialVersionUID = 1;

    public CTNumRestartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumRestart
    public STRestartNumber.Enum getVal() {
        STRestartNumber.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STRestartNumber.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumRestart
    public void setVal(STRestartNumber.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumRestart
    public STRestartNumber xgetVal() {
        STRestartNumber sTRestartNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTRestartNumber = (STRestartNumber) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTRestartNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumRestart
    public void xsetVal(STRestartNumber sTRestartNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STRestartNumber sTRestartNumber2 = (STRestartNumber) typeStore.find_attribute_user(qNameArr[0]);
                if (sTRestartNumber2 == null) {
                    sTRestartNumber2 = (STRestartNumber) get_store().add_attribute_user(qNameArr[0]);
                }
                sTRestartNumber2.set(sTRestartNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
