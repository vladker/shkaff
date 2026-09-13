package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STVerticalAlignRun;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTVerticalAlignFontProperty extends XmlObject {
    public static final DocumentFactory<CTVerticalAlignFontProperty> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTVerticalAlignFontProperty> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctverticalalignfontproperty89f2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STVerticalAlignRun.Enum getVal();

    void setVal(STVerticalAlignRun.Enum r6);

    STVerticalAlignRun xgetVal();

    void xsetVal(STVerticalAlignRun sTVerticalAlignRun);
}
