package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTWrapSquare extends XmlObject {
    public static final DocumentFactory<CTWrapSquare> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTWrapSquare> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctwrapsquare2678type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTEffectExtent addNewEffectExtent();

    long getDistB();

    long getDistL();

    long getDistR();

    long getDistT();

    CTEffectExtent getEffectExtent();

    STWrapText.Enum getWrapText();

    boolean isSetDistB();

    boolean isSetDistL();

    boolean isSetDistR();

    boolean isSetDistT();

    boolean isSetEffectExtent();

    void setDistB(long j6);

    void setDistL(long j6);

    void setDistR(long j6);

    void setDistT(long j6);

    void setEffectExtent(CTEffectExtent cTEffectExtent);

    void setWrapText(STWrapText.Enum r6);

    void unsetDistB();

    void unsetDistL();

    void unsetDistR();

    void unsetDistT();

    void unsetEffectExtent();

    STWrapDistance xgetDistB();

    STWrapDistance xgetDistL();

    STWrapDistance xgetDistR();

    STWrapDistance xgetDistT();

    STWrapText xgetWrapText();

    void xsetDistB(STWrapDistance sTWrapDistance);

    void xsetDistL(STWrapDistance sTWrapDistance);

    void xsetDistR(STWrapDistance sTWrapDistance);

    void xsetDistT(STWrapDistance sTWrapDistance);

    void xsetWrapText(STWrapText sTWrapText);
}
