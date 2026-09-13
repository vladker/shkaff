package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPosV extends XmlObject {
    public static final DocumentFactory<CTPosV> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPosV> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctposv63ddtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STAlignV$Enum getAlign();

    int getPosOffset();

    STRelFromV.Enum getRelativeFrom();

    boolean isSetAlign();

    boolean isSetPosOffset();

    void setAlign(STAlignV$Enum sTAlignV$Enum);

    void setPosOffset(int i5);

    void setRelativeFrom(STRelFromV.Enum r6);

    void unsetAlign();

    void unsetPosOffset();

    STAlignV xgetAlign();

    STPositionOffset xgetPosOffset();

    STRelFromV xgetRelativeFrom();

    void xsetAlign(STAlignV sTAlignV);

    void xsetPosOffset(STPositionOffset sTPositionOffset);

    void xsetRelativeFrom(STRelFromV sTRelFromV);
}
