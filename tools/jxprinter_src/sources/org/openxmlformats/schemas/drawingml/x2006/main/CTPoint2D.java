package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPoint2D extends XmlObject {
    public static final DocumentFactory<CTPoint2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPoint2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpoint2d8193type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getX();

    Object getY();

    void setX(Object obj);

    void setY(Object obj);

    STCoordinate xgetX();

    STCoordinate xgetY();

    void xsetX(STCoordinate sTCoordinate);

    void xsetY(STCoordinate sTCoordinate);
}
