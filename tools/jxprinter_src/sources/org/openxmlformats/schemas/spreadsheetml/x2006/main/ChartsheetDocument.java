package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface ChartsheetDocument extends XmlObject {
    public static final DocumentFactory<ChartsheetDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<ChartsheetDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "chartsheet99dedoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTChartsheet addNewChartsheet();

    CTChartsheet getChartsheet();

    void setChartsheet(CTChartsheet cTChartsheet);
}
