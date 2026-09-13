package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTextTabStop extends XmlObject {
    public static final DocumentFactory<CTTextTabStop> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTextTabStop> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttexttabstopb57btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STTextTabAlignType.Enum getAlgn();

    Object getPos();

    boolean isSetAlgn();

    boolean isSetPos();

    void setAlgn(STTextTabAlignType.Enum r6);

    void setPos(Object obj);

    void unsetAlgn();

    void unsetPos();

    STTextTabAlignType xgetAlgn();

    STCoordinate32 xgetPos();

    void xsetAlgn(STTextTabAlignType sTTextTabAlignType);

    void xsetPos(STCoordinate32 sTCoordinate32);
}
