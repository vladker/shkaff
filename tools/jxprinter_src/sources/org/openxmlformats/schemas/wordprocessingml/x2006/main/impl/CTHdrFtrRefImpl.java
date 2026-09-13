package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTHdrFtrRefImpl extends CTRelImpl implements CTHdrFtrRef {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "type")};
    private static final long serialVersionUID = 1;

    public CTHdrFtrRefImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public STHdrFtr.Enum getType() {
        STHdrFtr.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STHdrFtr.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public void setType(STHdrFtr.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public STHdrFtr xgetType() {
        STHdrFtr sTHdrFtr;
        synchronized (monitor()) {
            check_orphaned();
            sTHdrFtr = (STHdrFtr) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTHdrFtr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public void xsetType(STHdrFtr sTHdrFtr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STHdrFtr sTHdrFtr2 = (STHdrFtr) typeStore.find_attribute_user(qNameArr[0]);
                if (sTHdrFtr2 == null) {
                    sTHdrFtr2 = (STHdrFtr) get_store().add_attribute_user(qNameArr[0]);
                }
                sTHdrFtr2.set(sTHdrFtr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
