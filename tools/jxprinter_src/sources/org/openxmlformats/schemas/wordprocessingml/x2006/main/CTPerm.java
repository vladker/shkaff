package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPerm extends XmlObject {
    public static final DocumentFactory<CTPerm> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPerm> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctperm7878type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STDisplacedByCustomXml.Enum getDisplacedByCustomXml();

    String getId();

    boolean isSetDisplacedByCustomXml();

    void setDisplacedByCustomXml(STDisplacedByCustomXml.Enum r6);

    void setId(String str);

    void unsetDisplacedByCustomXml();

    STDisplacedByCustomXml xgetDisplacedByCustomXml();

    STString xgetId();

    void xsetDisplacedByCustomXml(STDisplacedByCustomXml sTDisplacedByCustomXml);

    void xsetId(STString sTString);
}
