package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDepthPercent;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHPercent;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPerspective;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTView3DImpl extends XmlComplexContentImpl implements CTView3D {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_CHART, "rotX"), new QName(XSSFRelation.NS_CHART, "hPercent"), new QName(XSSFRelation.NS_CHART, "rotY"), new QName(XSSFRelation.NS_CHART, "depthPercent"), new QName(XSSFRelation.NS_CHART, "rAngAx"), new QName(XSSFRelation.NS_CHART, "perspective"), new QName(XSSFRelation.NS_CHART, "extLst")};
    private static final long serialVersionUID = 1;

    public CTView3DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTDepthPercent addNewDepthPercent() {
        CTDepthPercent cTDepthPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTDepthPercent = (CTDepthPercent) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDepthPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTHPercent addNewHPercent() {
        CTHPercent cTHPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTHPercent = (CTHPercent) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTHPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTPerspective addNewPerspective() {
        CTPerspective cTPerspective;
        synchronized (monitor()) {
            check_orphaned();
            cTPerspective = (CTPerspective) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPerspective;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTBoolean addNewRAngAx() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTRotX addNewRotX() {
        CTRotX cTRotX;
        synchronized (monitor()) {
            check_orphaned();
            cTRotX = (CTRotX) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRotX;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTRotY addNewRotY() {
        CTRotY cTRotY;
        synchronized (monitor()) {
            check_orphaned();
            cTRotY = (CTRotY) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTRotY;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTDepthPercent getDepthPercent() {
        CTDepthPercent cTDepthPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTDepthPercent = (CTDepthPercent) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTDepthPercent == null) {
                cTDepthPercent = null;
            }
        }
        return cTDepthPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTHPercent getHPercent() {
        CTHPercent cTHPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTHPercent = (CTHPercent) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTHPercent == null) {
                cTHPercent = null;
            }
        }
        return cTHPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTPerspective getPerspective() {
        CTPerspective cTPerspective;
        synchronized (monitor()) {
            check_orphaned();
            cTPerspective = (CTPerspective) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPerspective == null) {
                cTPerspective = null;
            }
        }
        return cTPerspective;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTBoolean getRAngAx() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTRotX getRotX() {
        CTRotX cTRotX;
        synchronized (monitor()) {
            check_orphaned();
            cTRotX = (CTRotX) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRotX == null) {
                cTRotX = null;
            }
        }
        return cTRotX;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public CTRotY getRotY() {
        CTRotY cTRotY;
        synchronized (monitor()) {
            check_orphaned();
            cTRotY = (CTRotY) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTRotY == null) {
                cTRotY = null;
            }
        }
        return cTRotY;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetDepthPercent() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetHPercent() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetPerspective() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetRAngAx() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetRotX() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public boolean isSetRotY() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setDepthPercent(CTDepthPercent cTDepthPercent) {
        generatedSetterHelperImpl(cTDepthPercent, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setHPercent(CTHPercent cTHPercent) {
        generatedSetterHelperImpl(cTHPercent, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setPerspective(CTPerspective cTPerspective) {
        generatedSetterHelperImpl(cTPerspective, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setRAngAx(CTBoolean cTBoolean) {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setRotX(CTRotX cTRotX) {
        generatedSetterHelperImpl(cTRotX, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void setRotY(CTRotY cTRotY) {
        generatedSetterHelperImpl(cTRotY, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetDepthPercent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetHPercent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetPerspective() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetRAngAx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetRotX() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D
    public void unsetRotY() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }
}
