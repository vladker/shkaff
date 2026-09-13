package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTOLEObject;
import com.microsoft.schemas.office.office.STOLEDrawAspect;
import com.microsoft.schemas.office.office.STOLELinkType;
import com.microsoft.schemas.office.office.STOLEType;
import com.microsoft.schemas.office.office.STOLEUpdateMode;
import com.microsoft.schemas.office.office.STOLEUpdateMode$Enum;
import javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTOLEObjectImpl extends XmlComplexContentImpl implements CTOLEObject {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:office:office", "LinkType"), new QName("urn:schemas-microsoft-com:office:office", "LockedField"), new QName("urn:schemas-microsoft-com:office:office", "FieldCodes"), new QName("", PackageRelationship.TYPE_ATTRIBUTE_NAME), new QName("", "ProgID"), new QName("", "ShapeID"), new QName("", "DrawAspect"), new QName("", "ObjectID"), new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "id"), new QName("", "UpdateMode")};
    private static final long serialVersionUID = 1;

    public CTOLEObjectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLEDrawAspect.Enum getDrawAspect() {
        STOLEDrawAspect.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[6]);
            r6 = simpleValue == null ? null : (STOLEDrawAspect.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public String getFieldCodes() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[8]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public String getLinkType() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STTrueFalseBlank.Enum getLockedField() {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            r6 = simpleValue == null ? null : (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public String getObjectID() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public String getProgID() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public String getShapeID() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLEType.Enum getType() {
        STOLEType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            r6 = simpleValue == null ? null : (STOLEType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLEUpdateMode$Enum getUpdateMode() {
        STOLEUpdateMode$Enum sTOLEUpdateMode$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[9]);
            sTOLEUpdateMode$Enum = simpleValue == null ? null : (STOLEUpdateMode$Enum) simpleValue.getEnumValue();
        }
        return sTOLEUpdateMode$Enum;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetDrawAspect() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetFieldCodes() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetLinkType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetLockedField() {
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

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetObjectID() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetProgID() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetShapeID() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public boolean isSetUpdateMode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setDrawAspect(STOLEDrawAspect.Enum r6) {
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

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setFieldCodes(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[2], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[2]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setLinkType(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[0], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[0]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setLockedField(STTrueFalseBlank.Enum r7) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[1], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[1]);
                }
                simpleValue.setEnumValue(r7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setObjectID(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setProgID(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setShapeID(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setType(STOLEType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void setUpdateMode(STOLEUpdateMode$Enum sTOLEUpdateMode$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
                }
                simpleValue.setEnumValue(sTOLEUpdateMode$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetDrawAspect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetFieldCodes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetLinkType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetLockedField() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetObjectID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetProgID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetShapeID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void unsetUpdateMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLEDrawAspect xgetDrawAspect() {
        STOLEDrawAspect sTOLEDrawAspect;
        synchronized (monitor()) {
            check_orphaned();
            sTOLEDrawAspect = (STOLEDrawAspect) get_store().find_attribute_user(PROPERTY_QNAME[6]);
        }
        return sTOLEDrawAspect;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public XmlString xgetFieldCodes() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[2], 0);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(PROPERTY_QNAME[8]);
        }
        return sTRelationshipId;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLELinkType xgetLinkType() {
        STOLELinkType sTOLELinkTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOLELinkTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
        }
        return sTOLELinkTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STTrueFalseBlank xgetLockedField() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[1], 0);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public XmlString xgetObjectID() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public XmlString xgetProgID() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public XmlString xgetShapeID() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLEType xgetType() {
        STOLEType sTOLEType;
        synchronized (monitor()) {
            check_orphaned();
            sTOLEType = (STOLEType) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTOLEType;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public STOLEUpdateMode xgetUpdateMode() {
        STOLEUpdateMode sTOLEUpdateModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOLEUpdateModeFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[9]);
        }
        return sTOLEUpdateModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetDrawAspect(STOLEDrawAspect sTOLEDrawAspect) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STOLEDrawAspect sTOLEDrawAspect2 = (STOLEDrawAspect) typeStore.find_attribute_user(qNameArr[6]);
                if (sTOLEDrawAspect2 == null) {
                    sTOLEDrawAspect2 = (STOLEDrawAspect) get_store().add_attribute_user(qNameArr[6]);
                }
                sTOLEDrawAspect2.set(sTOLEDrawAspect);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetFieldCodes(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[2], 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qNameArr[2]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qNameArr[8]);
                if (sTRelationshipId2 == null) {
                    sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qNameArr[8]);
                }
                sTRelationshipId2.set(sTRelationshipId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetLinkType(STOLELinkType sTOLELinkType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STOLELinkType sTOLELinkTypeFind_element_user = typeStore.find_element_user(qNameArr[0], 0);
                if (sTOLELinkTypeFind_element_user == null) {
                    sTOLELinkTypeFind_element_user = (STOLELinkType) get_store().add_element_user(qNameArr[0]);
                }
                sTOLELinkTypeFind_element_user.set(sTOLELinkType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetLockedField(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) typeStore.find_element_user(qNameArr[1], 0);
                if (sTTrueFalseBlank2 == null) {
                    sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().add_element_user(qNameArr[1]);
                }
                sTTrueFalseBlank2.set(sTTrueFalseBlank);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetObjectID(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[7]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[7]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetProgID(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[4]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[4]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetShapeID(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[5]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[5]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetType(STOLEType sTOLEType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STOLEType sTOLEType2 = (STOLEType) typeStore.find_attribute_user(qNameArr[3]);
                if (sTOLEType2 == null) {
                    sTOLEType2 = (STOLEType) get_store().add_attribute_user(qNameArr[3]);
                }
                sTOLEType2.set(sTOLEType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.office.CTOLEObject
    public void xsetUpdateMode(STOLEUpdateMode sTOLEUpdateMode) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STOLEUpdateMode sTOLEUpdateModeFind_attribute_user = typeStore.find_attribute_user(qNameArr[9]);
                if (sTOLEUpdateModeFind_attribute_user == null) {
                    sTOLEUpdateModeFind_attribute_user = (STOLEUpdateMode) get_store().add_attribute_user(qNameArr[9]);
                }
                sTOLEUpdateModeFind_attribute_user.set(sTOLEUpdateMode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
