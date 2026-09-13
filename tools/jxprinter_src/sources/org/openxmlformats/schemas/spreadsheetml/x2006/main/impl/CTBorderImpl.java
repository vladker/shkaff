package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTBorderImpl extends XmlComplexContentImpl implements CTBorder {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "start"), new QName(XSSFRelation.NS_SPREADSHEETML, "end"), new QName(XSSFRelation.NS_SPREADSHEETML, "left"), new QName(XSSFRelation.NS_SPREADSHEETML, "right"), new QName(XSSFRelation.NS_SPREADSHEETML, "top"), new QName(XSSFRelation.NS_SPREADSHEETML, "bottom"), new QName(XSSFRelation.NS_SPREADSHEETML, "diagonal"), new QName(XSSFRelation.NS_SPREADSHEETML, "vertical"), new QName(XSSFRelation.NS_SPREADSHEETML, "horizontal"), new QName("", "diagonalUp"), new QName("", "diagonalDown"), new QName("", "outline")};
    private static final long serialVersionUID = 1;

    public CTBorderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewBottom() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewDiagonal() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewEnd() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewHorizontal() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewLeft() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewRight() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewStart() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewTop() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr addNewVertical() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getBottom() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getDiagonal() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean getDiagonalDown() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[10]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean getDiagonalUp() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[9]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getEnd() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getHorizontal() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getLeft() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean getOutline() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[11]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getRight() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getStart() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getTop() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public CTBorderPr getVertical() {
        CTBorderPr cTBorderPr;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderPr = (CTBorderPr) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTBorderPr == null) {
                cTBorderPr = null;
            }
        }
        return cTBorderPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetBottom() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetDiagonal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetDiagonalDown() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[10]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetDiagonalUp() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetEnd() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetHorizontal() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetLeft() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetOutline() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[11]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetRight() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetStart() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetTop() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public boolean isSetVertical() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setBottom(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setDiagonal(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setDiagonalDown(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setDiagonalUp(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setEnd(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setHorizontal(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setLeft(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setOutline(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[11]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setRight(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setStart(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setTop(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void setVertical(CTBorderPr cTBorderPr) {
        generatedSetterHelperImpl(cTBorderPr, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetDiagonal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetDiagonalDown() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetDiagonalUp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetEnd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetHorizontal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetOutline() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[11]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetStart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void unsetVertical() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public XmlBoolean xgetDiagonalDown() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[10]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public XmlBoolean xgetDiagonalUp() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[9]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public XmlBoolean xgetOutline() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[11]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[11]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void xsetDiagonalDown(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[10]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void xsetDiagonalUp(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[9]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder
    public void xsetOutline(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[11]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[11]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
