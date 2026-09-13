package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalSheetName extends XmlObject {
    public static final DocumentFactory<CTExternalSheetName> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalSheetName> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalsheetnamefcdetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getVal();

    boolean isSetVal();

    void setVal(String str);

    void unsetVal();

    STXstring xgetVal();

    void xsetVal(STXstring sTXstring);
}
