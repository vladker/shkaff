package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNumRef extends XmlObject {
    public static final DocumentFactory<CTNumRef> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumRef> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumref062ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTNumData addNewNumCache();

    CTExtensionList getExtLst();

    String getF();

    CTNumData getNumCache();

    boolean isSetExtLst();

    boolean isSetNumCache();

    void setExtLst(CTExtensionList cTExtensionList);

    void setF(String str);

    void setNumCache(CTNumData cTNumData);

    void unsetExtLst();

    void unsetNumCache();

    XmlString xgetF();

    void xsetF(XmlString xmlString);
}
