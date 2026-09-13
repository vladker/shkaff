package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTTblLayoutTypeImpl extends XmlComplexContentImpl implements CTTblLayoutType {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "type")};
    private static final long serialVersionUID = 1;

    public CTTblLayoutTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType
    public STTblLayoutType.Enum getType() {
        STTblLayoutType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STTblLayoutType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType
    public boolean isSetType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType
    public void setType(STTblLayoutType.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType
    public STTblLayoutType xgetType() {
        STTblLayoutType sTTblLayoutType;
        synchronized (monitor()) {
            check_orphaned();
            sTTblLayoutType = (STTblLayoutType) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTTblLayoutType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType
    public void xsetType(STTblLayoutType sTTblLayoutType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTblLayoutType sTTblLayoutType2 = (STTblLayoutType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTTblLayoutType2 == null) {
                    sTTblLayoutType2 = (STTblLayoutType) get_store().add_attribute_user(qNameArr[0]);
                }
                sTTblLayoutType2.set(sTTblLayoutType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
