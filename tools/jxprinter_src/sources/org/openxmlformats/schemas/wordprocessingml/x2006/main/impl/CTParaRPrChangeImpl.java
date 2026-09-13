package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTParaRPrChangeImpl extends CTTrackChangeImpl implements CTParaRPrChange {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "rPr")};
    private static final long serialVersionUID = 1;

    public CTParaRPrChangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrChange
    public CTParaRPrOriginal addNewRPr() {
        CTParaRPrOriginal cTParaRPrOriginal;
        synchronized (monitor()) {
            check_orphaned();
            cTParaRPrOriginal = (CTParaRPrOriginal) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTParaRPrOriginal;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrChange
    public CTParaRPrOriginal getRPr() {
        CTParaRPrOriginal cTParaRPrOriginal;
        synchronized (monitor()) {
            check_orphaned();
            cTParaRPrOriginal = (CTParaRPrOriginal) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTParaRPrOriginal == null) {
                cTParaRPrOriginal = null;
            }
        }
        return cTParaRPrOriginal;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrChange
    public void setRPr(CTParaRPrOriginal cTParaRPrOriginal) {
        generatedSetterHelperImpl(cTParaRPrOriginal, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
