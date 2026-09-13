package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTColor extends XmlObject {
    public static final DocumentFactory<CTColor> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColor> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolor6d4ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STThemeColor.Enum getThemeColor();

    byte[] getThemeShade();

    byte[] getThemeTint();

    Object getVal();

    boolean isSetThemeColor();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    void setThemeColor(STThemeColor.Enum r6);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(Object obj);

    void unsetThemeColor();

    void unsetThemeShade();

    void unsetThemeTint();

    STThemeColor xgetThemeColor();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STHexColor xgetVal();

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STHexColor sTHexColor);
}
