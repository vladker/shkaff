package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridChange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTTblGridImpl extends CTTblGridBaseImpl implements CTTblGrid {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "tblGridChange")};
    private static final long serialVersionUID = 1;

    public CTTblGridImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public CTTblGridChange addNewTblGridChange() {
        CTTblGridChange cTTblGridChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTblGridChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public CTTblGridChange getTblGridChange() {
        CTTblGridChange cTTblGridChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTblGridChangeFind_element_user == null) {
                cTTblGridChangeFind_element_user = null;
            }
        }
        return cTTblGridChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public boolean isSetTblGridChange() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public void setTblGridChange(CTTblGridChange cTTblGridChange) {
        generatedSetterHelperImpl(cTTblGridChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public void unsetTblGridChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
