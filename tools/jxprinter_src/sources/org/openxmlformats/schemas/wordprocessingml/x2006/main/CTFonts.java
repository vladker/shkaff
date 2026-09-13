package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFonts extends XmlObject {
    public static final DocumentFactory<CTFonts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFonts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfonts124etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getAscii();

    STTheme.Enum getAsciiTheme();

    String getCs();

    STTheme.Enum getCstheme();

    String getEastAsia();

    STTheme.Enum getEastAsiaTheme();

    String getHAnsi();

    STTheme.Enum getHAnsiTheme();

    STHint.Enum getHint();

    boolean isSetAscii();

    boolean isSetAsciiTheme();

    boolean isSetCs();

    boolean isSetCstheme();

    boolean isSetEastAsia();

    boolean isSetEastAsiaTheme();

    boolean isSetHAnsi();

    boolean isSetHAnsiTheme();

    boolean isSetHint();

    void setAscii(String str);

    void setAsciiTheme(STTheme.Enum r6);

    void setCs(String str);

    void setCstheme(STTheme.Enum r6);

    void setEastAsia(String str);

    void setEastAsiaTheme(STTheme.Enum r6);

    void setHAnsi(String str);

    void setHAnsiTheme(STTheme.Enum r6);

    void setHint(STHint.Enum r6);

    void unsetAscii();

    void unsetAsciiTheme();

    void unsetCs();

    void unsetCstheme();

    void unsetEastAsia();

    void unsetEastAsiaTheme();

    void unsetHAnsi();

    void unsetHAnsiTheme();

    void unsetHint();

    STString xgetAscii();

    STTheme xgetAsciiTheme();

    STString xgetCs();

    STTheme xgetCstheme();

    STString xgetEastAsia();

    STTheme xgetEastAsiaTheme();

    STString xgetHAnsi();

    STTheme xgetHAnsiTheme();

    STHint xgetHint();

    void xsetAscii(STString sTString);

    void xsetAsciiTheme(STTheme sTTheme);

    void xsetCs(STString sTString);

    void xsetCstheme(STTheme sTTheme);

    void xsetEastAsia(STString sTString);

    void xsetEastAsiaTheme(STTheme sTTheme);

    void xsetHAnsi(STString sTString);

    void xsetHAnsiTheme(STTheme sTTheme);

    void xsetHint(STHint sTHint);
}
