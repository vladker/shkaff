package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTMarkupRange extends CTMarkup {
    public static final DocumentFactory<CTMarkupRange> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMarkupRange> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmarkuprangeba3dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STDisplacedByCustomXml.Enum getDisplacedByCustomXml();

    boolean isSetDisplacedByCustomXml();

    void setDisplacedByCustomXml(STDisplacedByCustomXml.Enum r6);

    void unsetDisplacedByCustomXml();

    STDisplacedByCustomXml xgetDisplacedByCustomXml();

    void xsetDisplacedByCustomXml(STDisplacedByCustomXml sTDisplacedByCustomXml);
}
