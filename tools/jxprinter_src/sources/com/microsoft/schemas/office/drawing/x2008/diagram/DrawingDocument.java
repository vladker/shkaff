package com.microsoft.schemas.office.drawing.x2008.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface DrawingDocument extends XmlObject {
    public static final DocumentFactory<DrawingDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<DrawingDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "drawing324ddoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDrawing addNewDrawing();

    CTDrawing getDrawing();

    void setDrawing(CTDrawing cTDrawing);
}
