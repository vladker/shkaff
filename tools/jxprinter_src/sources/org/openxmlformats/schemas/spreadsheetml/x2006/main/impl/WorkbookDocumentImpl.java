package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class WorkbookDocumentImpl extends XmlComplexContentImpl implements WorkbookDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "workbook")};
    private static final long serialVersionUID = 1;

    public WorkbookDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument
    public CTWorkbook addNewWorkbook() {
        CTWorkbook cTWorkbook;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbook = (CTWorkbook) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTWorkbook;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument
    public CTWorkbook getWorkbook() {
        CTWorkbook cTWorkbook;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbook = (CTWorkbook) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTWorkbook == null) {
                cTWorkbook = null;
            }
        }
        return cTWorkbook;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument
    public void setWorkbook(CTWorkbook cTWorkbook) {
        generatedSetterHelperImpl(cTWorkbook, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
