package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class WorksheetDocumentImpl extends XmlComplexContentImpl implements WorksheetDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "worksheet")};
    private static final long serialVersionUID = 1;

    public WorksheetDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument
    public CTWorksheet addNewWorksheet() {
        CTWorksheet cTWorksheet;
        synchronized (monitor()) {
            check_orphaned();
            cTWorksheet = (CTWorksheet) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTWorksheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument
    public CTWorksheet getWorksheet() {
        CTWorksheet cTWorksheet;
        synchronized (monitor()) {
            check_orphaned();
            cTWorksheet = (CTWorksheet) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTWorksheet == null) {
                cTWorksheet = null;
            }
        }
        return cTWorksheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument
    public void setWorksheet(CTWorksheet cTWorksheet) {
        generatedSetterHelperImpl(cTWorksheet, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
