package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTriggerRuntimeNode;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTriggerTimeNodeID;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTime;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTriggerEvent;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTriggerEvent$Enum;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTLTimeConditionImpl extends XmlComplexContentImpl implements CTTLTimeCondition {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "tgtEl"), new QName(XSSFRelation.NS_PRESENTATIONML, "tn"), new QName(XSSFRelation.NS_PRESENTATIONML, "rtn"), new QName("", "evt"), new QName("", "delay")};
    private static final long serialVersionUID = 1;

    public CTTLTimeConditionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerRuntimeNode addNewRtn() {
        CTTLTriggerRuntimeNode cTTLTriggerRuntimeNodeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTriggerRuntimeNodeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLTriggerRuntimeNodeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTimeTargetElement addNewTgtEl() {
        CTTLTimeTargetElement cTTLTimeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeTargetElement = (CTTLTimeTargetElement) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTLTimeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerTimeNodeID addNewTn() {
        CTTLTriggerTimeNodeID cTTLTriggerTimeNodeIDAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTriggerTimeNodeIDAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTLTriggerTimeNodeIDAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public Object getDelay() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public STTLTriggerEvent$Enum getEvt() {
        STTLTriggerEvent$Enum sTTLTriggerEvent$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            sTTLTriggerEvent$Enum = simpleValue == null ? null : (STTLTriggerEvent$Enum) simpleValue.getEnumValue();
        }
        return sTTLTriggerEvent$Enum;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerRuntimeNode getRtn() {
        CTTLTriggerRuntimeNode cTTLTriggerRuntimeNodeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTriggerRuntimeNodeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTLTriggerRuntimeNodeFind_element_user == null) {
                cTTLTriggerRuntimeNodeFind_element_user = null;
            }
        }
        return cTTLTriggerRuntimeNodeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTimeTargetElement getTgtEl() {
        CTTLTimeTargetElement cTTLTimeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeTargetElement = (CTTLTimeTargetElement) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTLTimeTargetElement == null) {
                cTTLTimeTargetElement = null;
            }
        }
        return cTTLTimeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerTimeNodeID getTn() {
        CTTLTriggerTimeNodeID cTTLTriggerTimeNodeIDFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTriggerTimeNodeIDFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTLTriggerTimeNodeIDFind_element_user == null) {
                cTTLTriggerTimeNodeIDFind_element_user = null;
            }
        }
        return cTTLTriggerTimeNodeIDFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetDelay() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetEvt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetRtn() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetTgtEl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetTn() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setDelay(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setEvt(STTLTriggerEvent$Enum sTTLTriggerEvent$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setEnumValue(sTTLTriggerEvent$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setRtn(CTTLTriggerRuntimeNode cTTLTriggerRuntimeNode) {
        generatedSetterHelperImpl(cTTLTriggerRuntimeNode, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setTgtEl(CTTLTimeTargetElement cTTLTimeTargetElement) {
        generatedSetterHelperImpl(cTTLTimeTargetElement, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setTn(CTTLTriggerTimeNodeID cTTLTriggerTimeNodeID) {
        generatedSetterHelperImpl(cTTLTriggerTimeNodeID, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetDelay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetEvt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetRtn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetTgtEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetTn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public STTLTime xgetDelay() {
        STTLTime sTTLTime;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTime = (STTLTime) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return sTTLTime;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public STTLTriggerEvent xgetEvt() {
        STTLTriggerEvent sTTLTriggerEventFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTriggerEventFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTTLTriggerEventFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void xsetDelay(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTime sTTLTime2 = (STTLTime) typeStore.find_attribute_user(qNameArr[4]);
                if (sTTLTime2 == null) {
                    sTTLTime2 = (STTLTime) get_store().add_attribute_user(qNameArr[4]);
                }
                sTTLTime2.set(sTTLTime);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void xsetEvt(STTLTriggerEvent sTTLTriggerEvent) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTLTriggerEvent sTTLTriggerEventFind_attribute_user = typeStore.find_attribute_user(qNameArr[3]);
                if (sTTLTriggerEventFind_attribute_user == null) {
                    sTTLTriggerEventFind_attribute_user = (STTLTriggerEvent) get_store().add_attribute_user(qNameArr[3]);
                }
                sTTLTriggerEventFind_attribute_user.set(sTTLTriggerEvent);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
