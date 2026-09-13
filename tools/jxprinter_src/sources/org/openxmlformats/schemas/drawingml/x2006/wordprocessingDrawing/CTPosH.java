package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPosH extends XmlObject {
    public static final DocumentFactory<CTPosH> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPosH> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctposh7fabtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STAlignH$Enum getAlign();

    int getPosOffset();

    STRelFromH.Enum getRelativeFrom();

    boolean isSetAlign();

    boolean isSetPosOffset();

    void setAlign(STAlignH$Enum sTAlignH$Enum);

    void setPosOffset(int i5);

    void setRelativeFrom(STRelFromH.Enum r6);

    void unsetAlign();

    void unsetPosOffset();

    STAlignH xgetAlign();

    STPositionOffset xgetPosOffset();

    STRelFromH xgetRelativeFrom();

    void xsetAlign(STAlignH sTAlignH);

    void xsetPosOffset(STPositionOffset sTPositionOffset);

    void xsetRelativeFrom(STRelFromH sTRelFromH);
}
