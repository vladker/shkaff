package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdListEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTHandoutMasterIdListImpl extends XmlComplexContentImpl implements CTHandoutMasterIdList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "handoutMasterId")};
    private static final long serialVersionUID = 1;

    public CTHandoutMasterIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList
    public CTHandoutMasterIdListEntry addNewHandoutMasterId() {
        CTHandoutMasterIdListEntry cTHandoutMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTHandoutMasterIdListEntry = (CTHandoutMasterIdListEntry) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTHandoutMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList
    public CTHandoutMasterIdListEntry getHandoutMasterId() {
        CTHandoutMasterIdListEntry cTHandoutMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTHandoutMasterIdListEntry = (CTHandoutMasterIdListEntry) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTHandoutMasterIdListEntry == null) {
                cTHandoutMasterIdListEntry = null;
            }
        }
        return cTHandoutMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList
    public boolean isSetHandoutMasterId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList
    public void setHandoutMasterId(CTHandoutMasterIdListEntry cTHandoutMasterIdListEntry) {
        generatedSetterHelperImpl(cTHandoutMasterIdListEntry, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList
    public void unsetHandoutMasterId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
