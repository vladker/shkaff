package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTBackground extends XmlObject {
    public static final DocumentFactory<CTBackground> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBackground> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbackground36f7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBackgroundProperties addNewBgPr();

    CTStyleMatrixReference addNewBgRef();

    CTBackgroundProperties getBgPr();

    CTStyleMatrixReference getBgRef();

    STBlackWhiteMode.Enum getBwMode();

    boolean isSetBgPr();

    boolean isSetBgRef();

    boolean isSetBwMode();

    void setBgPr(CTBackgroundProperties cTBackgroundProperties);

    void setBgRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setBwMode(STBlackWhiteMode.Enum r6);

    void unsetBgPr();

    void unsetBgRef();

    void unsetBwMode();

    STBlackWhiteMode xgetBwMode();

    void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode);
}
