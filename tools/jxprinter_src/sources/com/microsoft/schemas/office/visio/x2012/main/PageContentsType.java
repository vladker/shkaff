package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface PageContentsType extends XmlObject {
    public static final DocumentFactory<PageContentsType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<PageContentsType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "pagecontentstypea5d0type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    ConnectsType addNewConnects();

    ShapesType addNewShapes();

    ConnectsType getConnects();

    ShapesType getShapes();

    boolean isSetConnects();

    boolean isSetShapes();

    void setConnects(ConnectsType connectsType);

    void setShapes(ShapesType shapesType);

    void unsetConnects();

    void unsetShapes();
}
