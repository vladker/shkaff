package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableBackgroundStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTableStyleImpl extends XmlComplexContentImpl implements CTTableStyle {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "tblBg"), new QName(XSSFRelation.NS_DRAWINGML, "wholeTbl"), new QName(XSSFRelation.NS_DRAWINGML, "band1H"), new QName(XSSFRelation.NS_DRAWINGML, "band2H"), new QName(XSSFRelation.NS_DRAWINGML, "band1V"), new QName(XSSFRelation.NS_DRAWINGML, "band2V"), new QName(XSSFRelation.NS_DRAWINGML, "lastCol"), new QName(XSSFRelation.NS_DRAWINGML, "firstCol"), new QName(XSSFRelation.NS_DRAWINGML, "lastRow"), new QName(XSSFRelation.NS_DRAWINGML, "seCell"), new QName(XSSFRelation.NS_DRAWINGML, "swCell"), new QName(XSSFRelation.NS_DRAWINGML, "firstRow"), new QName(XSSFRelation.NS_DRAWINGML, "neCell"), new QName(XSSFRelation.NS_DRAWINGML, "nwCell"), new QName(XSSFRelation.NS_DRAWINGML, "extLst"), new QName("", "styleId"), new QName("", "styleName")};
    private static final long serialVersionUID = 1;

    public CTTableStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle addNewTblBg() {
        CTTableBackgroundStyle cTTableBackgroundStyleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTableBackgroundStyleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableBackgroundStyleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewWholeTbl() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[15]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[16]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle getTblBg() {
        CTTableBackgroundStyle cTTableBackgroundStyleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTableBackgroundStyleFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTableBackgroundStyleFind_element_user == null) {
                cTTableBackgroundStyleFind_element_user = null;
            }
        }
        return cTTableBackgroundStyleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getWholeTbl() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1H() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1V() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2H() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2V() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstCol() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstRow() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastCol() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastRow() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNeCell() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNwCell() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSeCell() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSwCell() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetTblBg() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetWholeTbl() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1H(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1V(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2H(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2V(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstCol(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstRow(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastCol(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastRow(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNeCell(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNwCell(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSeCell(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSwCell(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setTblBg(CTTableBackgroundStyle cTTableBackgroundStyle) {
        generatedSetterHelperImpl(cTTableBackgroundStyle, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setWholeTbl(CTTablePartStyle cTTablePartStyle) {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetTblBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetWholeTbl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public STGuid xgetStyleId() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_attribute_user(PROPERTY_QNAME[15]);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public XmlString xgetStyleName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[16]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleId(STGuid sTGuid) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STGuid sTGuid2 = (STGuid) typeStore.find_attribute_user(qNameArr[15]);
                if (sTGuid2 == null) {
                    sTGuid2 = (STGuid) get_store().add_attribute_user(qNameArr[15]);
                }
                sTGuid2.set(sTGuid);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleName(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[16]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[16]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
