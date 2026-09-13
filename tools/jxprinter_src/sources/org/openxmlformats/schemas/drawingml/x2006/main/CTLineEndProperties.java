package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTLineEndProperties extends XmlObject {
    public static final DocumentFactory<CTLineEndProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLineEndProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlineendproperties8acbtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STLineEndLength.Enum getLen();

    STLineEndType.Enum getType();

    STLineEndWidth.Enum getW();

    boolean isSetLen();

    boolean isSetType();

    boolean isSetW();

    void setLen(STLineEndLength.Enum r6);

    void setType(STLineEndType.Enum r6);

    void setW(STLineEndWidth.Enum r6);

    void unsetLen();

    void unsetType();

    void unsetW();

    STLineEndLength xgetLen();

    STLineEndType xgetType();

    STLineEndWidth xgetW();

    void xsetLen(STLineEndLength sTLineEndLength);

    void xsetType(STLineEndType sTLineEndType);

    void xsetW(STLineEndWidth sTLineEndWidth);
}
