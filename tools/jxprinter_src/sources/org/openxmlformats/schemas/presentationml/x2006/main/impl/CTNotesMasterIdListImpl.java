package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdListEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTNotesMasterIdListImpl extends XmlComplexContentImpl implements CTNotesMasterIdList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "notesMasterId")};
    private static final long serialVersionUID = 1;

    public CTNotesMasterIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public CTNotesMasterIdListEntry addNewNotesMasterId() {
        CTNotesMasterIdListEntry cTNotesMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNotesMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public CTNotesMasterIdListEntry getNotesMasterId() {
        CTNotesMasterIdListEntry cTNotesMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTNotesMasterIdListEntry == null) {
                cTNotesMasterIdListEntry = null;
            }
        }
        return cTNotesMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public boolean isSetNotesMasterId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public void setNotesMasterId(CTNotesMasterIdListEntry cTNotesMasterIdListEntry) {
        generatedSetterHelperImpl(cTNotesMasterIdListEntry, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList
    public void unsetNotesMasterId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
