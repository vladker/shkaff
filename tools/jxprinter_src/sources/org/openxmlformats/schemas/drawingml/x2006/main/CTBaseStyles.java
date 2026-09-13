package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTBaseStyles extends XmlObject {
    public static final DocumentFactory<CTBaseStyles> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBaseStyles> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbasestyles122etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTColorScheme addNewClrScheme();

    CTOfficeArtExtensionList addNewExtLst();

    CTStyleMatrix addNewFmtScheme();

    CTFontScheme addNewFontScheme();

    CTColorScheme getClrScheme();

    CTOfficeArtExtensionList getExtLst();

    CTStyleMatrix getFmtScheme();

    CTFontScheme getFontScheme();

    boolean isSetExtLst();

    void setClrScheme(CTColorScheme cTColorScheme);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFmtScheme(CTStyleMatrix cTStyleMatrix);

    void setFontScheme(CTFontScheme cTFontScheme);

    void unsetExtLst();
}
