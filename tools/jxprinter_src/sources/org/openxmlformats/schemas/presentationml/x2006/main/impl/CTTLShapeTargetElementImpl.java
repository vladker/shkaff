package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAnimationElementChoice;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLOleChartTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSubShapeId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTextTargetElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTLShapeTargetElementImpl extends XmlComplexContentImpl implements CTTLShapeTargetElement {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "bg"), new QName(XSSFRelation.NS_PRESENTATIONML, "subSp"), new QName(XSSFRelation.NS_PRESENTATIONML, "oleChartEl"), new QName(XSSFRelation.NS_PRESENTATIONML, "txEl"), new QName(XSSFRelation.NS_PRESENTATIONML, "graphicEl"), new QName("", "spid")};
    private static final long serialVersionUID = 1;

    public CTTLShapeTargetElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTEmpty addNewBg() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTAnimationElementChoice addNewGraphicEl() {
        CTAnimationElementChoice cTAnimationElementChoiceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnimationElementChoiceAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTAnimationElementChoiceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLOleChartTargetElement addNewOleChartEl() {
        CTTLOleChartTargetElement cTTLOleChartTargetElementAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLOleChartTargetElementAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLOleChartTargetElementAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLSubShapeId addNewSubSp() {
        CTTLSubShapeId cTTLSubShapeIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTLSubShapeIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLTextTargetElement addNewTxEl() {
        CTTLTextTargetElement cTTLTextTargetElementAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTextTargetElementAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLTextTargetElementAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTEmpty getBg() {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTEmptyFind_element_user == null) {
                cTEmptyFind_element_user = null;
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTAnimationElementChoice getGraphicEl() {
        CTAnimationElementChoice cTAnimationElementChoiceFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnimationElementChoiceFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTAnimationElementChoiceFind_element_user == null) {
                cTAnimationElementChoiceFind_element_user = null;
            }
        }
        return cTAnimationElementChoiceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLOleChartTargetElement getOleChartEl() {
        CTTLOleChartTargetElement cTTLOleChartTargetElementFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLOleChartTargetElementFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTLOleChartTargetElementFind_element_user == null) {
                cTTLOleChartTargetElementFind_element_user = null;
            }
        }
        return cTTLOleChartTargetElementFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public long getSpid() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLSubShapeId getSubSp() {
        CTTLSubShapeId cTTLSubShapeIdFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTLSubShapeIdFind_element_user == null) {
                cTTLSubShapeIdFind_element_user = null;
            }
        }
        return cTTLSubShapeIdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLTextTargetElement getTxEl() {
        CTTLTextTargetElement cTTLTextTargetElementFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTextTargetElementFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTLTextTargetElementFind_element_user == null) {
                cTTLTextTargetElementFind_element_user = null;
            }
        }
        return cTTLTextTargetElementFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetBg() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetGraphicEl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetOleChartEl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetSubSp() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetTxEl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setBg(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setGraphicEl(CTAnimationElementChoice cTAnimationElementChoice) {
        generatedSetterHelperImpl(cTAnimationElementChoice, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setOleChartEl(CTTLOleChartTargetElement cTTLOleChartTargetElement) {
        generatedSetterHelperImpl(cTTLOleChartTargetElement, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setSpid(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setSubSp(CTTLSubShapeId cTTLSubShapeId) {
        generatedSetterHelperImpl(cTTLSubShapeId, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setTxEl(CTTLTextTargetElement cTTLTextTargetElement) {
        generatedSetterHelperImpl(cTTLTextTargetElement, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetGraphicEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetOleChartEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetSubSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetTxEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public STDrawingElementId xgetSpid() {
        STDrawingElementId sTDrawingElementId;
        synchronized (monitor()) {
            check_orphaned();
            sTDrawingElementId = (STDrawingElementId) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return sTDrawingElementId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void xsetSpid(STDrawingElementId sTDrawingElementId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STDrawingElementId sTDrawingElementId2 = (STDrawingElementId) typeStore.find_attribute_user(qNameArr[5]);
                if (sTDrawingElementId2 == null) {
                    sTDrawingElementId2 = (STDrawingElementId) get_store().add_attribute_user(qNameArr[5]);
                }
                sTDrawingElementId2.set(sTDrawingElementId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
