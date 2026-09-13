package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTShapeStyle extends XmlObject {
    public static final DocumentFactory<CTShapeStyle> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTShapeStyle> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctshapestyle81ebtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTStyleMatrixReference addNewEffectRef();

    CTStyleMatrixReference addNewFillRef();

    CTFontReference addNewFontRef();

    CTStyleMatrixReference addNewLnRef();

    CTStyleMatrixReference getEffectRef();

    CTStyleMatrixReference getFillRef();

    CTFontReference getFontRef();

    CTStyleMatrixReference getLnRef();

    void setEffectRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setFillRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setFontRef(CTFontReference cTFontReference);

    void setLnRef(CTStyleMatrixReference cTStyleMatrixReference);
}
