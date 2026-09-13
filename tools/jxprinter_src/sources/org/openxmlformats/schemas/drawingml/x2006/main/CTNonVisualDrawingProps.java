package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNonVisualDrawingProps extends XmlObject {
    public static final DocumentFactory<CTNonVisualDrawingProps> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNonVisualDrawingProps> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnonvisualdrawingprops8fb0type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTHyperlink addNewHlinkClick();

    CTHyperlink addNewHlinkHover();

    String getDescr();

    CTOfficeArtExtensionList getExtLst();

    boolean getHidden();

    CTHyperlink getHlinkClick();

    CTHyperlink getHlinkHover();

    long getId();

    String getName();

    String getTitle();

    boolean isSetDescr();

    boolean isSetExtLst();

    boolean isSetHidden();

    boolean isSetHlinkClick();

    boolean isSetHlinkHover();

    boolean isSetTitle();

    void setDescr(String str);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setHidden(boolean z6);

    void setHlinkClick(CTHyperlink cTHyperlink);

    void setHlinkHover(CTHyperlink cTHyperlink);

    void setId(long j6);

    void setName(String str);

    void setTitle(String str);

    void unsetDescr();

    void unsetExtLst();

    void unsetHidden();

    void unsetHlinkClick();

    void unsetHlinkHover();

    void unsetTitle();

    XmlString xgetDescr();

    XmlBoolean xgetHidden();

    STDrawingElementId xgetId();

    XmlString xgetName();

    XmlString xgetTitle();

    void xsetDescr(XmlString xmlString);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetId(STDrawingElementId sTDrawingElementId);

    void xsetName(XmlString xmlString);

    void xsetTitle(XmlString xmlString);
}
