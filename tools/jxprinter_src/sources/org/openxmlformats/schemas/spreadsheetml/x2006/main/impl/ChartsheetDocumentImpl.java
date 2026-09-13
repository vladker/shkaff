package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class ChartsheetDocumentImpl extends XmlComplexContentImpl implements ChartsheetDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "chartsheet")};
    private static final long serialVersionUID = 1;

    public ChartsheetDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument
    public CTChartsheet addNewChartsheet() {
        CTChartsheet cTChartsheet;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheet = (CTChartsheet) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTChartsheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument
    public CTChartsheet getChartsheet() {
        CTChartsheet cTChartsheet;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheet = (CTChartsheet) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTChartsheet == null) {
                cTChartsheet = null;
            }
        }
        return cTChartsheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument
    public void setChartsheet(CTChartsheet cTChartsheet) {
        generatedSetterHelperImpl(cTChartsheet, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
