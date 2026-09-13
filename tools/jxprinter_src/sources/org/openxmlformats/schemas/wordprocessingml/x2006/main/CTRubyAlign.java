package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTRubyAlign extends XmlObject {
    public static final DocumentFactory<CTRubyAlign> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTRubyAlign> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctrubyalign41e7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STRubyAlign.Enum getVal();

    void setVal(STRubyAlign.Enum r6);

    STRubyAlign xgetVal();

    void xsetVal(STRubyAlign sTRubyAlign);
}
