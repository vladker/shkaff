package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBottomPageBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTopPageBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageBorderDisplay;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageBorderOffset;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageBorderZOrder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageBorderZOrder$Enum;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTPageBordersImpl extends XmlComplexContentImpl implements CTPageBorders {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "top"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "left"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bottom"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "right"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "zOrder"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "display"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "offsetFrom")};
    private static final long serialVersionUID = 1;

    public CTPageBordersImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTBottomPageBorder addNewBottom() {
        CTBottomPageBorder cTBottomPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBottomPageBorder = (CTBottomPageBorder) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBottomPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTPageBorder addNewLeft() {
        CTPageBorder cTPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBorder = (CTPageBorder) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTPageBorder addNewRight() {
        CTPageBorder cTPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBorder = (CTPageBorder) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTTopPageBorder addNewTop() {
        CTTopPageBorder cTTopPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTTopPageBorder = (CTTopPageBorder) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTopPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTBottomPageBorder getBottom() {
        CTBottomPageBorder cTBottomPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBottomPageBorder = (CTBottomPageBorder) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTBottomPageBorder == null) {
                cTBottomPageBorder = null;
            }
        }
        return cTBottomPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public STPageBorderDisplay.Enum getDisplay() {
        STPageBorderDisplay.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            r6 = simpleValue == null ? null : (STPageBorderDisplay.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTPageBorder getLeft() {
        CTPageBorder cTPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBorder = (CTPageBorder) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTPageBorder == null) {
                cTPageBorder = null;
            }
        }
        return cTPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public STPageBorderOffset.Enum getOffsetFrom() {
        STPageBorderOffset.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[6]);
                }
                r6 = simpleValue == null ? null : (STPageBorderOffset.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTPageBorder getRight() {
        CTPageBorder cTPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBorder = (CTPageBorder) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTPageBorder == null) {
                cTPageBorder = null;
            }
        }
        return cTPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public CTTopPageBorder getTop() {
        CTTopPageBorder cTTopPageBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTTopPageBorder = (CTTopPageBorder) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTopPageBorder == null) {
                cTTopPageBorder = null;
            }
        }
        return cTTopPageBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public STPageBorderZOrder$Enum getZOrder() {
        STPageBorderZOrder$Enum sTPageBorderZOrder$Enum;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[4]);
                }
                sTPageBorderZOrder$Enum = simpleValue == null ? null : (STPageBorderZOrder$Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPageBorderZOrder$Enum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetBottom() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetDisplay() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetLeft() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetOffsetFrom() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetRight() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetTop() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public boolean isSetZOrder() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setBottom(CTBottomPageBorder cTBottomPageBorder) {
        generatedSetterHelperImpl(cTBottomPageBorder, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setDisplay(STPageBorderDisplay.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setLeft(CTPageBorder cTPageBorder) {
        generatedSetterHelperImpl(cTPageBorder, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setOffsetFrom(STPageBorderOffset.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setRight(CTPageBorder cTPageBorder) {
        generatedSetterHelperImpl(cTPageBorder, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setTop(CTTopPageBorder cTTopPageBorder) {
        generatedSetterHelperImpl(cTTopPageBorder, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void setZOrder(STPageBorderZOrder$Enum sTPageBorderZOrder$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setEnumValue(sTPageBorderZOrder$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetDisplay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetOffsetFrom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void unsetZOrder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public STPageBorderDisplay xgetDisplay() {
        STPageBorderDisplay sTPageBorderDisplay;
        synchronized (monitor()) {
            check_orphaned();
            sTPageBorderDisplay = (STPageBorderDisplay) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return sTPageBorderDisplay;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public STPageBorderOffset xgetOffsetFrom() {
        STPageBorderOffset sTPageBorderOffset;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTPageBorderOffset = (STPageBorderOffset) typeStore.find_attribute_user(qNameArr[6]);
                if (sTPageBorderOffset == null) {
                    sTPageBorderOffset = (STPageBorderOffset) get_default_attribute_value(qNameArr[6]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPageBorderOffset;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public STPageBorderZOrder xgetZOrder() {
        STPageBorderZOrder sTPageBorderZOrderFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTPageBorderZOrderFind_attribute_user = typeStore.find_attribute_user(qNameArr[4]);
                if (sTPageBorderZOrderFind_attribute_user == null) {
                    sTPageBorderZOrderFind_attribute_user = (STPageBorderZOrder) get_default_attribute_value(qNameArr[4]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPageBorderZOrderFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void xsetDisplay(STPageBorderDisplay sTPageBorderDisplay) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPageBorderDisplay sTPageBorderDisplay2 = (STPageBorderDisplay) typeStore.find_attribute_user(qNameArr[5]);
                if (sTPageBorderDisplay2 == null) {
                    sTPageBorderDisplay2 = (STPageBorderDisplay) get_store().add_attribute_user(qNameArr[5]);
                }
                sTPageBorderDisplay2.set(sTPageBorderDisplay);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void xsetOffsetFrom(STPageBorderOffset sTPageBorderOffset) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPageBorderOffset sTPageBorderOffset2 = (STPageBorderOffset) typeStore.find_attribute_user(qNameArr[6]);
                if (sTPageBorderOffset2 == null) {
                    sTPageBorderOffset2 = (STPageBorderOffset) get_store().add_attribute_user(qNameArr[6]);
                }
                sTPageBorderOffset2.set(sTPageBorderOffset);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders
    public void xsetZOrder(STPageBorderZOrder sTPageBorderZOrder) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPageBorderZOrder sTPageBorderZOrderFind_attribute_user = typeStore.find_attribute_user(qNameArr[4]);
                if (sTPageBorderZOrderFind_attribute_user == null) {
                    sTPageBorderZOrderFind_attribute_user = (STPageBorderZOrder) get_store().add_attribute_user(qNameArr[4]);
                }
                sTPageBorderZOrderFind_attribute_user.set(sTPageBorderZOrder);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
