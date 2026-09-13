package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTCustomGeometry2DImpl extends XmlComplexContentImpl implements CTCustomGeometry2D {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "avLst"), new QName(XSSFRelation.NS_DRAWINGML, "gdLst"), new QName(XSSFRelation.NS_DRAWINGML, "ahLst"), new QName(XSSFRelation.NS_DRAWINGML, "cxnLst"), new QName(XSSFRelation.NS_DRAWINGML, "rect"), new QName(XSSFRelation.NS_DRAWINGML, "pathLst")};
    private static final long serialVersionUID = 1;

    public CTCustomGeometry2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTAdjustHandleList addNewAhLst() {
        CTAdjustHandleList cTAdjustHandleList;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjustHandleList = (CTAdjustHandleList) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTAdjustHandleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList addNewAvLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTConnectionSiteList addNewCxnLst() {
        CTConnectionSiteList cTConnectionSiteList;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSiteList = (CTConnectionSiteList) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTConnectionSiteList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList addNewGdLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTPath2DList addNewPathLst() {
        CTPath2DList cTPath2DList;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DList = (CTPath2DList) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPath2DList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomRect addNewRect() {
        CTGeomRect cTGeomRect;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomRect = (CTGeomRect) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGeomRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTAdjustHandleList getAhLst() {
        CTAdjustHandleList cTAdjustHandleList;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjustHandleList = (CTAdjustHandleList) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTAdjustHandleList == null) {
                cTAdjustHandleList = null;
            }
        }
        return cTAdjustHandleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList getAvLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGeomGuideList == null) {
                cTGeomGuideList = null;
            }
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTConnectionSiteList getCxnLst() {
        CTConnectionSiteList cTConnectionSiteList;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSiteList = (CTConnectionSiteList) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTConnectionSiteList == null) {
                cTConnectionSiteList = null;
            }
        }
        return cTConnectionSiteList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList getGdLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTGeomGuideList == null) {
                cTGeomGuideList = null;
            }
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTPath2DList getPathLst() {
        CTPath2DList cTPath2DList;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DList = (CTPath2DList) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPath2DList == null) {
                cTPath2DList = null;
            }
        }
        return cTPath2DList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomRect getRect() {
        CTGeomRect cTGeomRect;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomRect = (CTGeomRect) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTGeomRect == null) {
                cTGeomRect = null;
            }
        }
        return cTGeomRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetAhLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetAvLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetCxnLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetGdLst() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetRect() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setAhLst(CTAdjustHandleList cTAdjustHandleList) {
        generatedSetterHelperImpl(cTAdjustHandleList, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setAvLst(CTGeomGuideList cTGeomGuideList) {
        generatedSetterHelperImpl(cTGeomGuideList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setCxnLst(CTConnectionSiteList cTConnectionSiteList) {
        generatedSetterHelperImpl(cTConnectionSiteList, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setGdLst(CTGeomGuideList cTGeomGuideList) {
        generatedSetterHelperImpl(cTGeomGuideList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setPathLst(CTPath2DList cTPath2DList) {
        generatedSetterHelperImpl(cTPath2DList, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setRect(CTGeomRect cTGeomRect) {
        generatedSetterHelperImpl(cTGeomRect, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetAhLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetAvLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetCxnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetGdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }
}
