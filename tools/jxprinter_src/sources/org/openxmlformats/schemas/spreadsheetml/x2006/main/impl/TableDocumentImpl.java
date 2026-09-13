package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class TableDocumentImpl extends XmlComplexContentImpl implements TableDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "table")};
    private static final long serialVersionUID = 1;

    public TableDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument
    public CTTable addNewTable() {
        CTTable cTTable;
        synchronized (monitor()) {
            check_orphaned();
            cTTable = (CTTable) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTable;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument
    public CTTable getTable() {
        CTTable cTTable;
        synchronized (monitor()) {
            check_orphaned();
            cTTable = (CTTable) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTable == null) {
                cTTable = null;
            }
        }
        return cTTable;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument
    public void setTable(CTTable cTTable) {
        generatedSetterHelperImpl(cTTable, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
