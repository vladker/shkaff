package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectorLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTNonVisualConnectorPropertiesImpl extends XmlComplexContentImpl implements CTNonVisualConnectorProperties {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "cxnSpLocks"), new QName(XSSFRelation.NS_DRAWINGML, "stCxn"), new QName(XSSFRelation.NS_DRAWINGML, "endCxn"), new QName(XSSFRelation.NS_DRAWINGML, "extLst")};
    private static final long serialVersionUID = 1;

    public CTNonVisualConnectorPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnectorLocking addNewCxnSpLocks() {
        CTConnectorLocking cTConnectorLockingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectorLockingAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTConnectorLockingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection addNewEndCxn() {
        CTConnection cTConnection;
        synchronized (monitor()) {
            check_orphaned();
            cTConnection = (CTConnection) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTConnection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection addNewStCxn() {
        CTConnection cTConnection;
        synchronized (monitor()) {
            check_orphaned();
            cTConnection = (CTConnection) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTConnection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnectorLocking getCxnSpLocks() {
        CTConnectorLocking cTConnectorLockingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectorLockingFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTConnectorLockingFind_element_user == null) {
                cTConnectorLockingFind_element_user = null;
            }
        }
        return cTConnectorLockingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection getEndCxn() {
        CTConnection cTConnection;
        synchronized (monitor()) {
            check_orphaned();
            cTConnection = (CTConnection) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTConnection == null) {
                cTConnection = null;
            }
        }
        return cTConnection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public CTConnection getStCxn() {
        CTConnection cTConnection;
        synchronized (monitor()) {
            check_orphaned();
            cTConnection = (CTConnection) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTConnection == null) {
                cTConnection = null;
            }
        }
        return cTConnection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetCxnSpLocks() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetEndCxn() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public boolean isSetStCxn() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setCxnSpLocks(CTConnectorLocking cTConnectorLocking) {
        generatedSetterHelperImpl(cTConnectorLocking, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setEndCxn(CTConnection cTConnection) {
        generatedSetterHelperImpl(cTConnection, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void setStCxn(CTConnection cTConnection) {
        generatedSetterHelperImpl(cTConnection, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetCxnSpLocks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetEndCxn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties
    public void unsetStCxn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }
}
