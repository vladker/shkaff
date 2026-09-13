package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTPPrGeneralImpl extends CTPPrBaseImpl implements CTPPrGeneral {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "pPrChange")};
    private static final long serialVersionUID = 1;

    public CTPPrGeneralImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral
    public CTPPrChange addNewPPrChange() {
        CTPPrChange cTPPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral
    public CTPPrChange getPPrChange() {
        CTPPrChange cTPPrChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTPPrChangeFind_element_user == null) {
                cTPPrChangeFind_element_user = null;
            }
        }
        return cTPPrChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral
    public boolean isSetPPrChange() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral
    public void setPPrChange(CTPPrChange cTPPrChange) {
        generatedSetterHelperImpl(cTPPrChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral
    public void unsetPPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
