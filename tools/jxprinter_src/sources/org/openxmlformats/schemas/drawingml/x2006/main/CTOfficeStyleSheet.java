package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTOfficeStyleSheet extends XmlObject {
    public static final DocumentFactory<CTOfficeStyleSheet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOfficeStyleSheet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctofficestylesheetce25type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCustomColorList addNewCustClrLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTColorSchemeList addNewExtraClrSchemeLst();

    CTObjectStyleDefaults addNewObjectDefaults();

    CTBaseStyles addNewThemeElements();

    CTCustomColorList getCustClrLst();

    CTOfficeArtExtensionList getExtLst();

    CTColorSchemeList getExtraClrSchemeLst();

    String getName();

    CTObjectStyleDefaults getObjectDefaults();

    CTBaseStyles getThemeElements();

    boolean isSetCustClrLst();

    boolean isSetExtLst();

    boolean isSetExtraClrSchemeLst();

    boolean isSetName();

    boolean isSetObjectDefaults();

    void setCustClrLst(CTCustomColorList cTCustomColorList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setExtraClrSchemeLst(CTColorSchemeList cTColorSchemeList);

    void setName(String str);

    void setObjectDefaults(CTObjectStyleDefaults cTObjectStyleDefaults);

    void setThemeElements(CTBaseStyles cTBaseStyles);

    void unsetCustClrLst();

    void unsetExtLst();

    void unsetExtraClrSchemeLst();

    void unsetName();

    void unsetObjectDefaults();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
