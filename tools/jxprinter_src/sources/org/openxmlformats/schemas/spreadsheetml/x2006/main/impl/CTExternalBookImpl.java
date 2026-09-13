package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTExternalBookImpl extends XmlComplexContentImpl implements CTExternalBook {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "sheetNames"), new QName(XSSFRelation.NS_SPREADSHEETML, "definedNames"), new QName(XSSFRelation.NS_SPREADSHEETML, "sheetDataSet"), new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "id")};
    private static final long serialVersionUID = 1;

    public CTExternalBookImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalDefinedNames addNewDefinedNames() {
        CTExternalDefinedNames cTExternalDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedNames = (CTExternalDefinedNames) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExternalDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetDataSet addNewSheetDataSet() {
        CTExternalSheetDataSet cTExternalSheetDataSet;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetDataSet = (CTExternalSheetDataSet) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTExternalSheetDataSet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetNames addNewSheetNames() {
        CTExternalSheetNames cTExternalSheetNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetNames = (CTExternalSheetNames) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalSheetNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalDefinedNames getDefinedNames() {
        CTExternalDefinedNames cTExternalDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedNames = (CTExternalDefinedNames) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTExternalDefinedNames == null) {
                cTExternalDefinedNames = null;
            }
        }
        return cTExternalDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetDataSet getSheetDataSet() {
        CTExternalSheetDataSet cTExternalSheetDataSet;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetDataSet = (CTExternalSheetDataSet) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTExternalSheetDataSet == null) {
                cTExternalSheetDataSet = null;
            }
        }
        return cTExternalSheetDataSet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetNames getSheetNames() {
        CTExternalSheetNames cTExternalSheetNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetNames = (CTExternalSheetNames) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTExternalSheetNames == null) {
                cTExternalSheetNames = null;
            }
        }
        return cTExternalSheetNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetDefinedNames() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetSheetDataSet() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetSheetNames() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setDefinedNames(CTExternalDefinedNames cTExternalDefinedNames) {
        generatedSetterHelperImpl(cTExternalDefinedNames, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setSheetDataSet(CTExternalSheetDataSet cTExternalSheetDataSet) {
        generatedSetterHelperImpl(cTExternalSheetDataSet, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setSheetNames(CTExternalSheetNames cTExternalSheetNames) {
        generatedSetterHelperImpl(cTExternalSheetNames, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetSheetDataSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetSheetNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qNameArr[3]);
                if (sTRelationshipId2 == null) {
                    sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qNameArr[3]);
                }
                sTRelationshipId2.set(sTRelationshipId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
