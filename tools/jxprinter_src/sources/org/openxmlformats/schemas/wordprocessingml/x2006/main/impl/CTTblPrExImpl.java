package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExChange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTTblPrExImpl extends CTTblPrExBaseImpl implements CTTblPrEx {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "tblPrExChange")};
    private static final long serialVersionUID = 1;

    public CTTblPrExImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange addNewTblPrExChange() {
        CTTblPrExChange cTTblPrExChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrExChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTblPrExChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange getTblPrExChange() {
        CTTblPrExChange cTTblPrExChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrExChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTblPrExChangeFind_element_user == null) {
                cTTblPrExChangeFind_element_user = null;
            }
        }
        return cTTblPrExChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public boolean isSetTblPrExChange() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void setTblPrExChange(CTTblPrExChange cTTblPrExChange) {
        generatedSetterHelperImpl(cTTblPrExChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void unsetTblPrExChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
