package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.office.office.CTRegroupTable;
import com.microsoft.schemas.office.office.CTRules;
import com.microsoft.schemas.office.office.CTShapeLayout;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTShapeLayoutImpl extends XmlComplexContentImpl implements CTShapeLayout {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:office:office", "idmap"), new QName("urn:schemas-microsoft-com:office:office", "regrouptable"), new QName("urn:schemas-microsoft-com:office:office", "rules"), new QName("urn:schemas-microsoft-com:vml", "ext")};
    private static final long serialVersionUID = 1;

    public CTShapeLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTIdMap addNewIdmap() {
        CTIdMap cTIdMap;
        synchronized (monitor()) {
            check_orphaned();
            cTIdMap = (CTIdMap) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTIdMap;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRegroupTable addNewRegrouptable() {
        CTRegroupTable cTRegroupTableAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRegroupTableAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTRegroupTableAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRules addNewRules() {
        CTRules cTRulesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRulesAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTRulesAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public STExt.Enum getExt() {
        STExt.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            r6 = simpleValue == null ? null : (STExt.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTIdMap getIdmap() {
        CTIdMap cTIdMap;
        synchronized (monitor()) {
            check_orphaned();
            cTIdMap = (CTIdMap) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTIdMap == null) {
                cTIdMap = null;
            }
        }
        return cTIdMap;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRegroupTable getRegrouptable() {
        CTRegroupTable cTRegroupTableFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRegroupTableFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTRegroupTableFind_element_user == null) {
                cTRegroupTableFind_element_user = null;
            }
        }
        return cTRegroupTableFind_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public CTRules getRules() {
        CTRules cTRulesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRulesFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTRulesFind_element_user == null) {
                cTRulesFind_element_user = null;
            }
        }
        return cTRulesFind_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetExt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetIdmap() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetRegrouptable() {
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

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public boolean isSetRules() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setExt(STExt.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setIdmap(CTIdMap cTIdMap) {
        generatedSetterHelperImpl(cTIdMap, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setRegrouptable(CTRegroupTable cTRegroupTable) {
        generatedSetterHelperImpl(cTRegroupTable, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void setRules(CTRules cTRules) {
        generatedSetterHelperImpl(cTRules, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetIdmap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetRegrouptable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void unsetRules() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public STExt xgetExt() {
        STExt sTExt;
        synchronized (monitor()) {
            check_orphaned();
            sTExt = (STExt) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTExt;
    }

    @Override // com.microsoft.schemas.office.office.CTShapeLayout
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STExt sTExt2 = (STExt) typeStore.find_attribute_user(qNameArr[3]);
                if (sTExt2 == null) {
                    sTExt2 = (STExt) get_store().add_attribute_user(qNameArr[3]);
                }
                sTExt2.set(sTExt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
