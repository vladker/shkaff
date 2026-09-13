package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CalcChainDocumentImpl extends XmlComplexContentImpl implements CalcChainDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "calcChain")};
    private static final long serialVersionUID = 1;

    public CalcChainDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public CTCalcChain addNewCalcChain() {
        CTCalcChain cTCalcChain;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcChain = (CTCalcChain) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCalcChain;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public CTCalcChain getCalcChain() {
        CTCalcChain cTCalcChain;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcChain = (CTCalcChain) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTCalcChain == null) {
                cTCalcChain = null;
            }
        }
        return cTCalcChain;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public void setCalcChain(CTCalcChain cTCalcChain) {
        generatedSetterHelperImpl(cTCalcChain, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
