package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTileInfoProperties extends XmlObject {
    public static final DocumentFactory<CTTileInfoProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTileInfoProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttileinfoproperties2featype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STRectAlignment.Enum getAlgn();

    STTileFlipMode.Enum getFlip();

    Object getSx();

    Object getSy();

    Object getTx();

    Object getTy();

    boolean isSetAlgn();

    boolean isSetFlip();

    boolean isSetSx();

    boolean isSetSy();

    boolean isSetTx();

    boolean isSetTy();

    void setAlgn(STRectAlignment.Enum r6);

    void setFlip(STTileFlipMode.Enum r6);

    void setSx(Object obj);

    void setSy(Object obj);

    void setTx(Object obj);

    void setTy(Object obj);

    void unsetAlgn();

    void unsetFlip();

    void unsetSx();

    void unsetSy();

    void unsetTx();

    void unsetTy();

    STRectAlignment xgetAlgn();

    STTileFlipMode xgetFlip();

    STPercentage xgetSx();

    STPercentage xgetSy();

    STCoordinate xgetTx();

    STCoordinate xgetTy();

    void xsetAlgn(STRectAlignment sTRectAlignment);

    void xsetFlip(STTileFlipMode sTTileFlipMode);

    void xsetSx(STPercentage sTPercentage);

    void xsetSy(STPercentage sTPercentage);

    void xsetTx(STCoordinate sTCoordinate);

    void xsetTy(STCoordinate sTCoordinate);
}
