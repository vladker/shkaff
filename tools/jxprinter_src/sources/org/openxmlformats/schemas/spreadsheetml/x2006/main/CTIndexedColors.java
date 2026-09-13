package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTIndexedColors extends XmlObject {
    public static final DocumentFactory<CTIndexedColors> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTIndexedColors> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctindexedcolorsa0a0type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTRgbColor addNewRgbColor();

    CTRgbColor getRgbColorArray(int i5);

    CTRgbColor[] getRgbColorArray();

    List<CTRgbColor> getRgbColorList();

    CTRgbColor insertNewRgbColor(int i5);

    void removeRgbColor(int i5);

    void setRgbColorArray(int i5, CTRgbColor cTRgbColor);

    void setRgbColorArray(CTRgbColor[] cTRgbColorArr);

    int sizeOfRgbColorArray();
}
