package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SldMasterDocumentImpl extends XmlComplexContentImpl implements SldMasterDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "sldMaster")};
    private static final long serialVersionUID = 1;

    public SldMasterDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument
    public CTSlideMaster addNewSldMaster() {
        CTSlideMaster cTSlideMaster;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMaster = (CTSlideMaster) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSlideMaster;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument
    public CTSlideMaster getSldMaster() {
        CTSlideMaster cTSlideMaster;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMaster = (CTSlideMaster) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSlideMaster == null) {
                cTSlideMaster = null;
            }
        }
        return cTSlideMaster;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument
    public void setSldMaster(CTSlideMaster cTSlideMaster) {
        generatedSetterHelperImpl(cTSlideMaster, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
