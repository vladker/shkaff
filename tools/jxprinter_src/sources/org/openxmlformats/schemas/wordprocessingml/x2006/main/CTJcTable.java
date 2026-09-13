package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTJcTable extends XmlObject {
    public static final DocumentFactory<CTJcTable> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTJcTable> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctjctablefa9dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STJcTable.Enum getVal();

    void setVal(STJcTable.Enum r6);

    STJcTable xgetVal();

    void xsetVal(STJcTable sTJcTable);
}
