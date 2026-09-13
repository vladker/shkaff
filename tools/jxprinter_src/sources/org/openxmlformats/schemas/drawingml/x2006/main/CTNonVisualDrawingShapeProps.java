package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNonVisualDrawingShapeProps extends XmlObject {
    public static final DocumentFactory<CTNonVisualDrawingShapeProps> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNonVisualDrawingShapeProps> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnonvisualdrawingshapepropsf17btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTShapeLocking addNewSpLocks();

    CTOfficeArtExtensionList getExtLst();

    CTShapeLocking getSpLocks();

    boolean getTxBox();

    boolean isSetExtLst();

    boolean isSetSpLocks();

    boolean isSetTxBox();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setSpLocks(CTShapeLocking cTShapeLocking);

    void setTxBox(boolean z6);

    void unsetExtLst();

    void unsetSpLocks();

    void unsetTxBox();

    XmlBoolean xgetTxBox();

    void xsetTxBox(XmlBoolean xmlBoolean);
}
