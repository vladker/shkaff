package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPrintOptions extends XmlObject {
    public static final DocumentFactory<CTPrintOptions> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPrintOptions> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctprintoptions943atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getGridLines();

    boolean getGridLinesSet();

    boolean getHeadings();

    boolean getHorizontalCentered();

    boolean getVerticalCentered();

    boolean isSetGridLines();

    boolean isSetGridLinesSet();

    boolean isSetHeadings();

    boolean isSetHorizontalCentered();

    boolean isSetVerticalCentered();

    void setGridLines(boolean z6);

    void setGridLinesSet(boolean z6);

    void setHeadings(boolean z6);

    void setHorizontalCentered(boolean z6);

    void setVerticalCentered(boolean z6);

    void unsetGridLines();

    void unsetGridLinesSet();

    void unsetHeadings();

    void unsetHorizontalCentered();

    void unsetVerticalCentered();

    XmlBoolean xgetGridLines();

    XmlBoolean xgetGridLinesSet();

    XmlBoolean xgetHeadings();

    XmlBoolean xgetHorizontalCentered();

    XmlBoolean xgetVerticalCentered();

    void xsetGridLines(XmlBoolean xmlBoolean);

    void xsetGridLinesSet(XmlBoolean xmlBoolean);

    void xsetHeadings(XmlBoolean xmlBoolean);

    void xsetHorizontalCentered(XmlBoolean xmlBoolean);

    void xsetVerticalCentered(XmlBoolean xmlBoolean);
}
