package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface ShapesType extends XmlObject {
    public static final DocumentFactory<ShapesType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<ShapesType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "shapestypef507type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    ShapeSheetType addNewShape();

    ShapeSheetType getShapeArray(int i5);

    ShapeSheetType[] getShapeArray();

    List<ShapeSheetType> getShapeList();

    ShapeSheetType insertNewShape(int i5);

    void removeShape(int i5);

    void setShapeArray(int i5, ShapeSheetType shapeSheetType);

    void setShapeArray(ShapeSheetType[] shapeSheetTypeArr);

    int sizeOfShapeArray();
}
