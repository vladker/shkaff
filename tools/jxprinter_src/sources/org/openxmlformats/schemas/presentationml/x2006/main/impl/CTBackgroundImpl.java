package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTBackgroundImpl extends XmlComplexContentImpl implements CTBackground {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "bgPr"), new QName(XSSFRelation.NS_PRESENTATIONML, "bgRef"), new QName("", "bwMode")};
    private static final long serialVersionUID = 1;

    public CTBackgroundImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public CTBackgroundProperties addNewBgPr() {
        CTBackgroundProperties cTBackgroundProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBackgroundProperties = (CTBackgroundProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBackgroundProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public CTStyleMatrixReference addNewBgRef() {
        CTStyleMatrixReference cTStyleMatrixReference;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrixReference = (CTStyleMatrixReference) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTStyleMatrixReference;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public CTBackgroundProperties getBgPr() {
        CTBackgroundProperties cTBackgroundProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBackgroundProperties = (CTBackgroundProperties) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBackgroundProperties == null) {
                cTBackgroundProperties = null;
            }
        }
        return cTBackgroundProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public CTStyleMatrixReference getBgRef() {
        CTStyleMatrixReference cTStyleMatrixReference;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrixReference = (CTStyleMatrixReference) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTStyleMatrixReference == null) {
                cTStyleMatrixReference = null;
            }
        }
        return cTStyleMatrixReference;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public STBlackWhiteMode.Enum getBwMode() {
        STBlackWhiteMode.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[2]);
                }
                r6 = simpleValue == null ? null : (STBlackWhiteMode.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public boolean isSetBgPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public boolean isSetBgRef() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public boolean isSetBwMode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void setBgPr(CTBackgroundProperties cTBackgroundProperties) {
        generatedSetterHelperImpl(cTBackgroundProperties, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void setBgRef(CTStyleMatrixReference cTStyleMatrixReference) {
        generatedSetterHelperImpl(cTStyleMatrixReference, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void setBwMode(STBlackWhiteMode.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void unsetBgPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void unsetBgRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void unsetBwMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public STBlackWhiteMode xgetBwMode() {
        STBlackWhiteMode sTBlackWhiteMode;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTBlackWhiteMode = (STBlackWhiteMode) typeStore.find_attribute_user(qNameArr[2]);
                if (sTBlackWhiteMode == null) {
                    sTBlackWhiteMode = (STBlackWhiteMode) get_default_attribute_value(qNameArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTBlackWhiteMode;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackground
    public void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STBlackWhiteMode sTBlackWhiteMode2 = (STBlackWhiteMode) typeStore.find_attribute_user(qNameArr[2]);
                if (sTBlackWhiteMode2 == null) {
                    sTBlackWhiteMode2 = (STBlackWhiteMode) get_store().add_attribute_user(qNameArr[2]);
                }
                sTBlackWhiteMode2.set(sTBlackWhiteMode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
