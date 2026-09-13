package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSdtDateMappingType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSdtDateMappingTypeImpl extends XmlComplexContentImpl implements CTSdtDateMappingType {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "val")};
    private static final long serialVersionUID = 1;

    public CTSdtDateMappingTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType
    public STSdtDateMappingType.Enum getVal() {
        STSdtDateMappingType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STSdtDateMappingType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType
    public boolean isSetVal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType
    public void setVal(STSdtDateMappingType.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType
    public STSdtDateMappingType xgetVal() {
        STSdtDateMappingType sTSdtDateMappingType;
        synchronized (monitor()) {
            check_orphaned();
            sTSdtDateMappingType = (STSdtDateMappingType) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTSdtDateMappingType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType
    public void xsetVal(STSdtDateMappingType sTSdtDateMappingType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSdtDateMappingType sTSdtDateMappingType2 = (STSdtDateMappingType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTSdtDateMappingType2 == null) {
                    sTSdtDateMappingType2 = (STSdtDateMappingType) get_store().add_attribute_user(qNameArr[0]);
                }
                sTSdtDateMappingType2.set(sTSdtDateMappingType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
