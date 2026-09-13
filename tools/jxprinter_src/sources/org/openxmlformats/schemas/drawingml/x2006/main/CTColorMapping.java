package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTColorMapping extends XmlObject {
    public static final DocumentFactory<CTColorMapping> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColorMapping> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolormapping5bc6type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    STColorSchemeIndex.Enum getAccent1();

    STColorSchemeIndex.Enum getAccent2();

    STColorSchemeIndex.Enum getAccent3();

    STColorSchemeIndex.Enum getAccent4();

    STColorSchemeIndex.Enum getAccent5();

    STColorSchemeIndex.Enum getAccent6();

    STColorSchemeIndex.Enum getBg1();

    STColorSchemeIndex.Enum getBg2();

    CTOfficeArtExtensionList getExtLst();

    STColorSchemeIndex.Enum getFolHlink();

    STColorSchemeIndex.Enum getHlink();

    STColorSchemeIndex.Enum getTx1();

    STColorSchemeIndex.Enum getTx2();

    boolean isSetExtLst();

    void setAccent1(STColorSchemeIndex.Enum r6);

    void setAccent2(STColorSchemeIndex.Enum r6);

    void setAccent3(STColorSchemeIndex.Enum r6);

    void setAccent4(STColorSchemeIndex.Enum r6);

    void setAccent5(STColorSchemeIndex.Enum r6);

    void setAccent6(STColorSchemeIndex.Enum r6);

    void setBg1(STColorSchemeIndex.Enum r6);

    void setBg2(STColorSchemeIndex.Enum r6);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFolHlink(STColorSchemeIndex.Enum r6);

    void setHlink(STColorSchemeIndex.Enum r6);

    void setTx1(STColorSchemeIndex.Enum r6);

    void setTx2(STColorSchemeIndex.Enum r6);

    void unsetExtLst();

    STColorSchemeIndex xgetAccent1();

    STColorSchemeIndex xgetAccent2();

    STColorSchemeIndex xgetAccent3();

    STColorSchemeIndex xgetAccent4();

    STColorSchemeIndex xgetAccent5();

    STColorSchemeIndex xgetAccent6();

    STColorSchemeIndex xgetBg1();

    STColorSchemeIndex xgetBg2();

    STColorSchemeIndex xgetFolHlink();

    STColorSchemeIndex xgetHlink();

    STColorSchemeIndex xgetTx1();

    STColorSchemeIndex xgetTx2();

    void xsetAccent1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent2(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent3(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent4(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent5(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent6(STColorSchemeIndex sTColorSchemeIndex);

    void xsetBg1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetBg2(STColorSchemeIndex sTColorSchemeIndex);

    void xsetFolHlink(STColorSchemeIndex sTColorSchemeIndex);

    void xsetHlink(STColorSchemeIndex sTColorSchemeIndex);

    void xsetTx1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetTx2(STColorSchemeIndex sTColorSchemeIndex);
}
