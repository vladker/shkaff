package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTBorderPr extends XmlObject {
    public static final DocumentFactory<CTBorderPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBorderPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctborderpre497type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTColor addNewColor();

    CTColor getColor();

    STBorderStyle.Enum getStyle();

    boolean isSetColor();

    boolean isSetStyle();

    void setColor(CTColor cTColor);

    void setStyle(STBorderStyle.Enum r6);

    void unsetColor();

    void unsetStyle();

    STBorderStyle xgetStyle();

    void xsetStyle(STBorderStyle sTBorderStyle);
}
