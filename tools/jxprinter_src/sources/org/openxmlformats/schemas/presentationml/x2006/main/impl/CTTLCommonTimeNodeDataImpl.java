package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLIterateData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTime;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeFillType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeID;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeMasterRelation;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeMasterRelation$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodePresetClassType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodePresetClassType$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeRestartType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeSyncType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeSyncType$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTLCommonTimeNodeDataImpl extends XmlComplexContentImpl implements CTTLCommonTimeNodeData {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "stCondLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "endCondLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "endSync"), new QName(XSSFRelation.NS_PRESENTATIONML, "iterate"), new QName(XSSFRelation.NS_PRESENTATIONML, "childTnLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "subTnLst"), new QName("", "id"), new QName("", "presetID"), new QName("", "presetClass"), new QName("", "presetSubtype"), new QName("", "dur"), new QName("", "repeatCount"), new QName("", "repeatDur"), new QName("", "spd"), new QName("", "accel"), new QName("", "decel"), new QName("", "autoRev"), new QName("", "restart"), new QName("", "fill"), new QName("", "syncBehavior"), new QName("", "tmFilter"), new QName("", "evtFilter"), new QName("", "display"), new QName("", "masterRel"), new QName("", "bldLvl"), new QName("", "grpId"), new QName("", "afterEffect"), new QName("", "nodeType"), new QName("", "nodePh")};
    private static final long serialVersionUID = 1;

    public CTTLCommonTimeNodeDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList addNewChildTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList addNewEndCondLst() {
        CTTLTimeConditionList cTTLTimeConditionList;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeConditionList = (CTTLTimeConditionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTLTimeConditionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeCondition addNewEndSync() {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLIterateData addNewIterate() {
        CTTLIterateData cTTLIterateDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLIterateDataAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLIterateDataAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList addNewStCondLst() {
        CTTLTimeConditionList cTTLTimeConditionList;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeConditionList = (CTTLTimeConditionList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTLTimeConditionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList addNewSubTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getAccel() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[14]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getAfterEffect() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[26]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getAutoRev() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[16]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getBldLvl() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[24]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList getChildTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTimeNodeList == null) {
                cTTimeNodeList = null;
            }
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getDecel() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[15]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getDisplay() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[22]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getDur() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[10]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList getEndCondLst() {
        CTTLTimeConditionList cTTLTimeConditionList;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeConditionList = (CTTLTimeConditionList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTLTimeConditionList == null) {
                cTTLTimeConditionList = null;
            }
        }
        return cTTLTimeConditionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeCondition getEndSync() {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTLTimeCondition == null) {
                cTTLTimeCondition = null;
            }
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public String getEvtFilter() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[21]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeFillType.Enum getFill() {
        STTLTimeNodeFillType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[18]);
            r6 = simpleValue == null ? null : (STTLTimeNodeFillType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public long getGrpId() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[25]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public long getId() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[6]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLIterateData getIterate() {
        CTTLIterateData cTTLIterateDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLIterateDataFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTLIterateDataFind_element_user == null) {
                cTTLIterateDataFind_element_user = null;
            }
        }
        return cTTLIterateDataFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeMasterRelation$Enum getMasterRel() {
        STTLTimeNodeMasterRelation$Enum sTTLTimeNodeMasterRelation$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[23]);
            sTTLTimeNodeMasterRelation$Enum = simpleValue == null ? null : (STTLTimeNodeMasterRelation$Enum) simpleValue.getEnumValue();
        }
        return sTTLTimeNodeMasterRelation$Enum;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getNodePh() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[28]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeType.Enum getNodeType() {
        STTLTimeNodeType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[27]);
            r6 = simpleValue == null ? null : (STTLTimeNodeType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodePresetClassType$Enum getPresetClass() {
        STTLTimeNodePresetClassType$Enum sTTLTimeNodePresetClassType$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[8]);
            sTTLTimeNodePresetClassType$Enum = simpleValue == null ? null : (STTLTimeNodePresetClassType$Enum) simpleValue.getEnumValue();
        }
        return sTTLTimeNodePresetClassType$Enum;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getPresetID() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getPresetSubtype() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[9]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getRepeatCount() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[11]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getRepeatDur() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[12]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeRestartType.Enum getRestart() {
        STTLTimeNodeRestartType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[17]);
            r6 = simpleValue == null ? null : (STTLTimeNodeRestartType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getSpd() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[13]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList getStCondLst() {
        CTTLTimeConditionList cTTLTimeConditionList;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeConditionList = (CTTLTimeConditionList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTLTimeConditionList == null) {
                cTTLTimeConditionList = null;
            }
        }
        return cTTLTimeConditionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList getSubTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTimeNodeList == null) {
                cTTimeNodeList = null;
            }
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeSyncType$Enum getSyncBehavior() {
        STTLTimeNodeSyncType$Enum sTTLTimeNodeSyncType$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[19]);
            sTTLTimeNodeSyncType$Enum = simpleValue == null ? null : (STTLTimeNodeSyncType$Enum) simpleValue.getEnumValue();
        }
        return sTTLTimeNodeSyncType$Enum;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public String getTmFilter() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[20]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetAccel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[14]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetAfterEffect() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[26]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetAutoRev() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[16]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetBldLvl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[24]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetChildTnLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetDecel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetDisplay() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[22]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetDur() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[10]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetEndCondLst() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetEndSync() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetEvtFilter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[21]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetFill() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[18]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetGrpId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[25]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetIterate() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetMasterRel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[23]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetNodePh() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[28]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetNodeType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[27]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetPresetClass() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetPresetID() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetPresetSubtype() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetRepeatCount() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[11]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetRepeatDur() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[12]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetRestart() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[17]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetSpd() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetStCondLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetSubTnLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetSyncBehavior() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[19]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetTmFilter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[20]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setAccel(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[14]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setAfterEffect(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[26]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[26]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setAutoRev(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setBldLvl(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[24]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[24]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setChildTnLst(CTTimeNodeList cTTimeNodeList) {
        generatedSetterHelperImpl(cTTimeNodeList, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setDecel(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setDisplay(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[22]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[22]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setDur(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setEndCondLst(CTTLTimeConditionList cTTLTimeConditionList) {
        generatedSetterHelperImpl(cTTLTimeConditionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setEndSync(CTTLTimeCondition cTTLTimeCondition) {
        generatedSetterHelperImpl(cTTLTimeCondition, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setEvtFilter(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[21]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[21]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setFill(STTLTimeNodeFillType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[18]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setGrpId(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[25]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[25]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setId(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setIterate(CTTLIterateData cTTLIterateData) {
        generatedSetterHelperImpl(cTTLIterateData, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setMasterRel(STTLTimeNodeMasterRelation$Enum sTTLTimeNodeMasterRelation$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[23]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[23]);
                }
                simpleValue.setEnumValue(sTTLTimeNodeMasterRelation$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setNodePh(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[28]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[28]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setNodeType(STTLTimeNodeType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[27]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[27]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setPresetClass(STTLTimeNodePresetClassType$Enum sTTLTimeNodePresetClassType$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
                }
                simpleValue.setEnumValue(sTTLTimeNodePresetClassType$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setPresetID(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setPresetSubtype(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setRepeatCount(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[11]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setRepeatDur(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setRestart(STTLTimeNodeRestartType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[17]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setSpd(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setStCondLst(CTTLTimeConditionList cTTLTimeConditionList) {
        generatedSetterHelperImpl(cTTLTimeConditionList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setSubTnLst(CTTimeNodeList cTTimeNodeList) {
        generatedSetterHelperImpl(cTTimeNodeList, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setSyncBehavior(STTLTimeNodeSyncType$Enum sTTLTimeNodeSyncType$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[19]);
                }
                simpleValue.setEnumValue(sTTLTimeNodeSyncType$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setTmFilter(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[20]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetAccel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[14]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetAfterEffect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[26]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetAutoRev() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[16]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetBldLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[24]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetChildTnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetDecel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetDisplay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[22]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetDur() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetEndCondLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetEndSync() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetEvtFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[21]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetGrpId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[25]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetIterate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetMasterRel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[23]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetNodePh() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[28]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetNodeType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[27]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetPresetClass() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetPresetID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetPresetSubtype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetRepeatCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[11]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetRepeatDur() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[12]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetRestart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetSpd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[13]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetStCondLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetSubTnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetSyncBehavior() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetTmFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[20]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STPositiveFixedPercentage xgetAccel() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTPositiveFixedPercentage = (STPositiveFixedPercentage) typeStore.find_attribute_user(qNameArr[14]);
                if (sTPositiveFixedPercentage == null) {
                    sTPositiveFixedPercentage = (STPositiveFixedPercentage) get_default_attribute_value(qNameArr[14]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetAfterEffect() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[26]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetAutoRev() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[16]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[16]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlInt xgetBldLvl() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PROPERTY_QNAME[24]);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STPositiveFixedPercentage xgetDecel() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTPositiveFixedPercentage = (STPositiveFixedPercentage) typeStore.find_attribute_user(qNameArr[15]);
                if (sTPositiveFixedPercentage == null) {
                    sTPositiveFixedPercentage = (STPositiveFixedPercentage) get_default_attribute_value(qNameArr[15]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetDisplay() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[22]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTime xgetDur() {
        STTLTime sTTLTime;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTime = (STTLTime) get_store().find_attribute_user(PROPERTY_QNAME[10]);
        }
        return sTTLTime;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlString xgetEvtFilter() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[21]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeFillType xgetFill() {
        STTLTimeNodeFillType sTTLTimeNodeFillType;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeFillType = (STTLTimeNodeFillType) get_store().find_attribute_user(PROPERTY_QNAME[18]);
        }
        return sTTLTimeNodeFillType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlUnsignedInt xgetGrpId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[25]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeID xgetId() {
        STTLTimeNodeID sTTLTimeNodeIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeIDFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[6]);
        }
        return sTTLTimeNodeIDFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeMasterRelation xgetMasterRel() {
        STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelationFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeMasterRelationFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[23]);
        }
        return sTTLTimeNodeMasterRelationFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetNodePh() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[28]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeType xgetNodeType() {
        STTLTimeNodeType sTTLTimeNodeType;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeType = (STTLTimeNodeType) get_store().find_attribute_user(PROPERTY_QNAME[27]);
        }
        return sTTLTimeNodeType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodePresetClassType xgetPresetClass() {
        STTLTimeNodePresetClassType sTTLTimeNodePresetClassTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodePresetClassTypeFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[8]);
        }
        return sTTLTimeNodePresetClassTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlInt xgetPresetID() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlInt xgetPresetSubtype() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PROPERTY_QNAME[9]);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTime xgetRepeatCount() {
        STTLTime sTTLTime;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTTLTime = (STTLTime) typeStore.find_attribute_user(qNameArr[11]);
                if (sTTLTime == null) {
                    sTTLTime = (STTLTime) get_default_attribute_value(qNameArr[11]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTLTime;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTime xgetRepeatDur() {
        STTLTime sTTLTime;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTime = (STTLTime) get_store().find_attribute_user(PROPERTY_QNAME[12]);
        }
        return sTTLTime;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeRestartType xgetRestart() {
        STTLTimeNodeRestartType sTTLTimeNodeRestartType;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeRestartType = (STTLTimeNodeRestartType) get_store().find_attribute_user(PROPERTY_QNAME[17]);
        }
        return sTTLTimeNodeRestartType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STPercentage xgetSpd() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTPercentage = (STPercentage) typeStore.find_attribute_user(qNameArr[13]);
                if (sTPercentage == null) {
                    sTPercentage = (STPercentage) get_default_attribute_value(qNameArr[13]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeSyncType xgetSyncBehavior() {
        STTLTimeNodeSyncType sTTLTimeNodeSyncTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeSyncTypeFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[19]);
        }
        return sTTLTimeNodeSyncTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlString xgetTmFilter() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[20]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetAccel(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPositiveFixedPercentage sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) typeStore.find_attribute_user(qNameArr[14]);
                if (sTPositiveFixedPercentage2 == null) {
                    sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) get_store().add_attribute_user(qNameArr[14]);
                }
                sTPositiveFixedPercentage2.set(sTPositiveFixedPercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetAfterEffect(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[26]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[26]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetAutoRev(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[16]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[16]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetBldLvl(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qNameArr[24]);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qNameArr[24]);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetDecel(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPositiveFixedPercentage sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) typeStore.find_attribute_user(qNameArr[15]);
                if (sTPositiveFixedPercentage2 == null) {
                    sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) get_store().add_attribute_user(qNameArr[15]);
                }
                sTPositiveFixedPercentage2.set(sTPositiveFixedPercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetDisplay(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[22]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[22]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetDur(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTime sTTLTime2 = (STTLTime) typeStore.find_attribute_user(qNameArr[10]);
                if (sTTLTime2 == null) {
                    sTTLTime2 = (STTLTime) get_store().add_attribute_user(qNameArr[10]);
                }
                sTTLTime2.set(sTTLTime);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetEvtFilter(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[21]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[21]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetFill(STTLTimeNodeFillType sTTLTimeNodeFillType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodeFillType sTTLTimeNodeFillType2 = (STTLTimeNodeFillType) typeStore.find_attribute_user(qNameArr[18]);
                if (sTTLTimeNodeFillType2 == null) {
                    sTTLTimeNodeFillType2 = (STTLTimeNodeFillType) get_store().add_attribute_user(qNameArr[18]);
                }
                sTTLTimeNodeFillType2.set(sTTLTimeNodeFillType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetGrpId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[25]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[25]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetId(STTLTimeNodeID sTTLTimeNodeID) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodeID sTTLTimeNodeIDFind_attribute_user = typeStore.find_attribute_user(qNameArr[6]);
                if (sTTLTimeNodeIDFind_attribute_user == null) {
                    sTTLTimeNodeIDFind_attribute_user = (STTLTimeNodeID) get_store().add_attribute_user(qNameArr[6]);
                }
                sTTLTimeNodeIDFind_attribute_user.set(sTTLTimeNodeID);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetMasterRel(STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelation) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelationFind_attribute_user = typeStore.find_attribute_user(qNameArr[23]);
                if (sTTLTimeNodeMasterRelationFind_attribute_user == null) {
                    sTTLTimeNodeMasterRelationFind_attribute_user = (STTLTimeNodeMasterRelation) get_store().add_attribute_user(qNameArr[23]);
                }
                sTTLTimeNodeMasterRelationFind_attribute_user.set(sTTLTimeNodeMasterRelation);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetNodePh(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[28]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[28]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetNodeType(STTLTimeNodeType sTTLTimeNodeType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodeType sTTLTimeNodeType2 = (STTLTimeNodeType) typeStore.find_attribute_user(qNameArr[27]);
                if (sTTLTimeNodeType2 == null) {
                    sTTLTimeNodeType2 = (STTLTimeNodeType) get_store().add_attribute_user(qNameArr[27]);
                }
                sTTLTimeNodeType2.set(sTTLTimeNodeType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetPresetClass(STTLTimeNodePresetClassType sTTLTimeNodePresetClassType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodePresetClassType sTTLTimeNodePresetClassTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[8]);
                if (sTTLTimeNodePresetClassTypeFind_attribute_user == null) {
                    sTTLTimeNodePresetClassTypeFind_attribute_user = (STTLTimeNodePresetClassType) get_store().add_attribute_user(qNameArr[8]);
                }
                sTTLTimeNodePresetClassTypeFind_attribute_user.set(sTTLTimeNodePresetClassType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetPresetID(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qNameArr[7]);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qNameArr[7]);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetPresetSubtype(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qNameArr[9]);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qNameArr[9]);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetRepeatCount(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTime sTTLTime2 = (STTLTime) typeStore.find_attribute_user(qNameArr[11]);
                if (sTTLTime2 == null) {
                    sTTLTime2 = (STTLTime) get_store().add_attribute_user(qNameArr[11]);
                }
                sTTLTime2.set(sTTLTime);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetRepeatDur(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTime sTTLTime2 = (STTLTime) typeStore.find_attribute_user(qNameArr[12]);
                if (sTTLTime2 == null) {
                    sTTLTime2 = (STTLTime) get_store().add_attribute_user(qNameArr[12]);
                }
                sTTLTime2.set(sTTLTime);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetRestart(STTLTimeNodeRestartType sTTLTimeNodeRestartType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodeRestartType sTTLTimeNodeRestartType2 = (STTLTimeNodeRestartType) typeStore.find_attribute_user(qNameArr[17]);
                if (sTTLTimeNodeRestartType2 == null) {
                    sTTLTimeNodeRestartType2 = (STTLTimeNodeRestartType) get_store().add_attribute_user(qNameArr[17]);
                }
                sTTLTimeNodeRestartType2.set(sTTLTimeNodeRestartType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetSpd(STPercentage sTPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qNameArr[13]);
                if (sTPercentage2 == null) {
                    sTPercentage2 = (STPercentage) get_store().add_attribute_user(qNameArr[13]);
                }
                sTPercentage2.set(sTPercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetSyncBehavior(STTLTimeNodeSyncType sTTLTimeNodeSyncType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTimeNodeSyncType sTTLTimeNodeSyncTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[19]);
                if (sTTLTimeNodeSyncTypeFind_attribute_user == null) {
                    sTTLTimeNodeSyncTypeFind_attribute_user = (STTLTimeNodeSyncType) get_store().add_attribute_user(qNameArr[19]);
                }
                sTTLTimeNodeSyncTypeFind_attribute_user.set(sTTLTimeNodeSyncType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetTmFilter(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[20]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[20]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
