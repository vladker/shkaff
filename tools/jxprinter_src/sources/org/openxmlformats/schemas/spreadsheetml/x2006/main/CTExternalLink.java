package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalLink extends XmlObject {
    public static final DocumentFactory<CTExternalLink> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalLink> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternallink966etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDdeLink addNewDdeLink();

    CTExtensionList addNewExtLst();

    CTExternalBook addNewExternalBook();

    CTOleLink addNewOleLink();

    CTDdeLink getDdeLink();

    CTExtensionList getExtLst();

    CTExternalBook getExternalBook();

    CTOleLink getOleLink();

    boolean isSetDdeLink();

    boolean isSetExtLst();

    boolean isSetExternalBook();

    boolean isSetOleLink();

    void setDdeLink(CTDdeLink cTDdeLink);

    void setExtLst(CTExtensionList cTExtensionList);

    void setExternalBook(CTExternalBook cTExternalBook);

    void setOleLink(CTOleLink cTOleLink);

    void unsetDdeLink();

    void unsetExtLst();

    void unsetExternalBook();

    void unsetOleLink();
}
