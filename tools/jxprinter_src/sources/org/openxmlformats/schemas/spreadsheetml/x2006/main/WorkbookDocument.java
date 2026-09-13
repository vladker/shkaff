package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface WorkbookDocument extends XmlObject {
    public static final DocumentFactory<WorkbookDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<WorkbookDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "workbookec17doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTWorkbook addNewWorkbook();

    CTWorkbook getWorkbook();

    void setWorkbook(CTWorkbook cTWorkbook);
}
