package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTHighlight extends XmlObject {
    public static final DocumentFactory<CTHighlight> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHighlight> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthighlight071etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STHighlightColor.Enum getVal();

    void setVal(STHighlightColor.Enum r6);

    STHighlightColor xgetVal();

    void xsetVal(STHighlightColor sTHighlightColor);
}
