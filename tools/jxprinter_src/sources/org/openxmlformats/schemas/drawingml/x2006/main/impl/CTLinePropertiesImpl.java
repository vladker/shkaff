package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinBevel;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinMiterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinRound;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTLinePropertiesImpl extends XmlComplexContentImpl implements CTLineProperties {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "noFill"), new QName(XSSFRelation.NS_DRAWINGML, "solidFill"), new QName(XSSFRelation.NS_DRAWINGML, "gradFill"), new QName(XSSFRelation.NS_DRAWINGML, "pattFill"), new QName(XSSFRelation.NS_DRAWINGML, "prstDash"), new QName(XSSFRelation.NS_DRAWINGML, "custDash"), new QName(XSSFRelation.NS_DRAWINGML, "round"), new QName(XSSFRelation.NS_DRAWINGML, "bevel"), new QName(XSSFRelation.NS_DRAWINGML, "miter"), new QName(XSSFRelation.NS_DRAWINGML, "headEnd"), new QName(XSSFRelation.NS_DRAWINGML, "tailEnd"), new QName(XSSFRelation.NS_DRAWINGML, "extLst"), new QName("", "w"), new QName("", "cap"), new QName("", "cmpd"), new QName("", "algn")};
    private static final long serialVersionUID = 1;

    public CTLinePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinBevel addNewBevel() {
        CTLineJoinBevel cTLineJoinBevel;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinBevel = (CTLineJoinBevel) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTLineJoinBevel;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTDashStopList addNewCustDash() {
        CTDashStopList cTDashStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStopList = (CTDashStopList) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTDashStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties addNewHeadEnd() {
        CTLineEndProperties cTLineEndProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineEndProperties = (CTLineEndProperties) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTLineEndProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinMiterProperties addNewMiter() {
        CTLineJoinMiterProperties cTLineJoinMiterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinMiterProperties = (CTLineJoinMiterProperties) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTLineJoinMiterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPresetLineDashProperties addNewPrstDash() {
        CTPresetLineDashProperties cTPresetLineDashProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetLineDashProperties = (CTPresetLineDashProperties) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTPresetLineDashProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinRound addNewRound() {
        CTLineJoinRound cTLineJoinRound;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinRound = (CTLineJoinRound) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTLineJoinRound;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties addNewTailEnd() {
        CTLineEndProperties cTLineEndProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineEndProperties = (CTLineEndProperties) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTLineEndProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STPenAlignment.Enum getAlgn() {
        STPenAlignment.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[15]);
            r6 = simpleValue == null ? null : (STPenAlignment.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinBevel getBevel() {
        CTLineJoinBevel cTLineJoinBevel;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinBevel = (CTLineJoinBevel) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTLineJoinBevel == null) {
                cTLineJoinBevel = null;
            }
        }
        return cTLineJoinBevel;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STLineCap.Enum getCap() {
        STLineCap.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[13]);
            r6 = simpleValue == null ? null : (STLineCap.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STCompoundLine.Enum getCmpd() {
        STCompoundLine.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[14]);
            r6 = simpleValue == null ? null : (STCompoundLine.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTDashStopList getCustDash() {
        CTDashStopList cTDashStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStopList = (CTDashStopList) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTDashStopList == null) {
                cTDashStopList = null;
            }
        }
        return cTDashStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTGradientFillProperties getGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTGradientFillProperties == null) {
                cTGradientFillProperties = null;
            }
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties getHeadEnd() {
        CTLineEndProperties cTLineEndProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineEndProperties = (CTLineEndProperties) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTLineEndProperties == null) {
                cTLineEndProperties = null;
            }
        }
        return cTLineEndProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinMiterProperties getMiter() {
        CTLineJoinMiterProperties cTLineJoinMiterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinMiterProperties = (CTLineJoinMiterProperties) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTLineJoinMiterProperties == null) {
                cTLineJoinMiterProperties = null;
            }
        }
        return cTLineJoinMiterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTNoFillProperties getNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTNoFillProperties == null) {
                cTNoFillProperties = null;
            }
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPatternFillProperties getPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTPatternFillProperties == null) {
                cTPatternFillProperties = null;
            }
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPresetLineDashProperties getPrstDash() {
        CTPresetLineDashProperties cTPresetLineDashProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetLineDashProperties = (CTPresetLineDashProperties) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTPresetLineDashProperties == null) {
                cTPresetLineDashProperties = null;
            }
        }
        return cTPresetLineDashProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinRound getRound() {
        CTLineJoinRound cTLineJoinRound;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinRound = (CTLineJoinRound) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTLineJoinRound == null) {
                cTLineJoinRound = null;
            }
        }
        return cTLineJoinRound;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTSolidColorFillProperties getSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTSolidColorFillProperties == null) {
                cTSolidColorFillProperties = null;
            }
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties getTailEnd() {
        CTLineEndProperties cTLineEndProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineEndProperties = (CTLineEndProperties) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTLineEndProperties == null) {
                cTLineEndProperties = null;
            }
        }
        return cTLineEndProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public int getW() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[12]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetAlgn() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetBevel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetCap() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetCmpd() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[14]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetCustDash() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetGradFill() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetHeadEnd() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetMiter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetNoFill() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetPattFill() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetPrstDash() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetRound() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetSolidFill() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetTailEnd() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetW() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[12]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setAlgn(STPenAlignment.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setBevel(CTLineJoinBevel cTLineJoinBevel) {
        generatedSetterHelperImpl(cTLineJoinBevel, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setCap(STLineCap.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setCmpd(STCompoundLine.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[14]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setCustDash(CTDashStopList cTDashStopList) {
        generatedSetterHelperImpl(cTDashStopList, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        generatedSetterHelperImpl(cTGradientFillProperties, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setHeadEnd(CTLineEndProperties cTLineEndProperties) {
        generatedSetterHelperImpl(cTLineEndProperties, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setMiter(CTLineJoinMiterProperties cTLineJoinMiterProperties) {
        generatedSetterHelperImpl(cTLineJoinMiterProperties, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        generatedSetterHelperImpl(cTNoFillProperties, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        generatedSetterHelperImpl(cTPatternFillProperties, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setPrstDash(CTPresetLineDashProperties cTPresetLineDashProperties) {
        generatedSetterHelperImpl(cTPresetLineDashProperties, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setRound(CTLineJoinRound cTLineJoinRound) {
        generatedSetterHelperImpl(cTLineJoinRound, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        generatedSetterHelperImpl(cTSolidColorFillProperties, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setTailEnd(CTLineEndProperties cTLineEndProperties) {
        generatedSetterHelperImpl(cTLineEndProperties, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setW(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetBevel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetCap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[13]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetCmpd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[14]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetCustDash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetHeadEnd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetMiter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetPrstDash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetRound() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetTailEnd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[12]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STPenAlignment xgetAlgn() {
        STPenAlignment sTPenAlignment;
        synchronized (monitor()) {
            check_orphaned();
            sTPenAlignment = (STPenAlignment) get_store().find_attribute_user(PROPERTY_QNAME[15]);
        }
        return sTPenAlignment;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STLineCap xgetCap() {
        STLineCap sTLineCap;
        synchronized (monitor()) {
            check_orphaned();
            sTLineCap = (STLineCap) get_store().find_attribute_user(PROPERTY_QNAME[13]);
        }
        return sTLineCap;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STCompoundLine xgetCmpd() {
        STCompoundLine sTCompoundLine;
        synchronized (monitor()) {
            check_orphaned();
            sTCompoundLine = (STCompoundLine) get_store().find_attribute_user(PROPERTY_QNAME[14]);
        }
        return sTCompoundLine;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STLineWidth xgetW() {
        STLineWidth sTLineWidth;
        synchronized (monitor()) {
            check_orphaned();
            sTLineWidth = (STLineWidth) get_store().find_attribute_user(PROPERTY_QNAME[12]);
        }
        return sTLineWidth;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetAlgn(STPenAlignment sTPenAlignment) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPenAlignment sTPenAlignment2 = (STPenAlignment) typeStore.find_attribute_user(qNameArr[15]);
                if (sTPenAlignment2 == null) {
                    sTPenAlignment2 = (STPenAlignment) get_store().add_attribute_user(qNameArr[15]);
                }
                sTPenAlignment2.set(sTPenAlignment);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetCap(STLineCap sTLineCap) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLineCap sTLineCap2 = (STLineCap) typeStore.find_attribute_user(qNameArr[13]);
                if (sTLineCap2 == null) {
                    sTLineCap2 = (STLineCap) get_store().add_attribute_user(qNameArr[13]);
                }
                sTLineCap2.set(sTLineCap);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetCmpd(STCompoundLine sTCompoundLine) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STCompoundLine sTCompoundLine2 = (STCompoundLine) typeStore.find_attribute_user(qNameArr[14]);
                if (sTCompoundLine2 == null) {
                    sTCompoundLine2 = (STCompoundLine) get_store().add_attribute_user(qNameArr[14]);
                }
                sTCompoundLine2.set(sTCompoundLine);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetW(STLineWidth sTLineWidth) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLineWidth sTLineWidth2 = (STLineWidth) typeStore.find_attribute_user(qNameArr[12]);
                if (sTLineWidth2 == null) {
                    sTLineWidth2 = (STLineWidth) get_store().add_attribute_user(qNameArr[12]);
                }
                sTLineWidth2.set(sTLineWidth);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
