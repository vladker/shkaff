package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTManualLayoutImpl extends XmlComplexContentImpl implements CTManualLayout {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_CHART, "layoutTarget"), new QName(XSSFRelation.NS_CHART, "xMode"), new QName(XSSFRelation.NS_CHART, "yMode"), new QName(XSSFRelation.NS_CHART, "wMode"), new QName(XSSFRelation.NS_CHART, "hMode"), new QName(XSSFRelation.NS_CHART, "x"), new QName(XSSFRelation.NS_CHART, "y"), new QName(XSSFRelation.NS_CHART, "w"), new QName(XSSFRelation.NS_CHART, "h"), new QName(XSSFRelation.NS_CHART, "extLst")};
    private static final long serialVersionUID = 1;

    public CTManualLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble addNewH() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode addNewHMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutTarget addNewLayoutTarget() {
        CTLayoutTarget cTLayoutTarget;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutTarget = (CTLayoutTarget) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLayoutTarget;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble addNewW() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode addNewWMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble addNewX() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode addNewXMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble addNewY() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode addNewYMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble getH() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTDouble == null) {
                cTDouble = null;
            }
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode getHMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTLayoutMode == null) {
                cTLayoutMode = null;
            }
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutTarget getLayoutTarget() {
        CTLayoutTarget cTLayoutTarget;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutTarget = (CTLayoutTarget) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTLayoutTarget == null) {
                cTLayoutTarget = null;
            }
        }
        return cTLayoutTarget;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble getW() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTDouble == null) {
                cTDouble = null;
            }
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode getWMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTLayoutMode == null) {
                cTLayoutMode = null;
            }
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble getX() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTDouble == null) {
                cTDouble = null;
            }
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode getXMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTLayoutMode == null) {
                cTLayoutMode = null;
            }
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTDouble getY() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTDouble == null) {
                cTDouble = null;
            }
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public CTLayoutMode getYMode() {
        CTLayoutMode cTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            cTLayoutMode = (CTLayoutMode) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTLayoutMode == null) {
                cTLayoutMode = null;
            }
        }
        return cTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetH() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetHMode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetLayoutTarget() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetW() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetWMode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetX() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetXMode() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetY() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public boolean isSetYMode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setH(CTDouble cTDouble) {
        generatedSetterHelperImpl(cTDouble, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setHMode(CTLayoutMode cTLayoutMode) {
        generatedSetterHelperImpl(cTLayoutMode, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setLayoutTarget(CTLayoutTarget cTLayoutTarget) {
        generatedSetterHelperImpl(cTLayoutTarget, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setW(CTDouble cTDouble) {
        generatedSetterHelperImpl(cTDouble, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setWMode(CTLayoutMode cTLayoutMode) {
        generatedSetterHelperImpl(cTLayoutMode, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setX(CTDouble cTDouble) {
        generatedSetterHelperImpl(cTDouble, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setXMode(CTLayoutMode cTLayoutMode) {
        generatedSetterHelperImpl(cTLayoutMode, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setY(CTDouble cTDouble) {
        generatedSetterHelperImpl(cTDouble, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void setYMode(CTLayoutMode cTLayoutMode) {
        generatedSetterHelperImpl(cTLayoutMode, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetHMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetLayoutTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetWMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetX() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetXMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetY() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout
    public void unsetYMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }
}
