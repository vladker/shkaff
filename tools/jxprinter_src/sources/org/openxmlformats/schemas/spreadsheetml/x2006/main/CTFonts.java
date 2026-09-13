package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFonts extends XmlObject {
    public static final DocumentFactory<CTFonts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFonts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfonts6623type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFont addNewFont();

    long getCount();

    CTFont getFontArray(int i5);

    CTFont[] getFontArray();

    List<CTFont> getFontList();

    CTFont insertNewFont(int i5);

    boolean isSetCount();

    void removeFont(int i5);

    void setCount(long j6);

    void setFontArray(int i5, CTFont cTFont);

    void setFontArray(CTFont[] cTFontArr);

    int sizeOfFontArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
