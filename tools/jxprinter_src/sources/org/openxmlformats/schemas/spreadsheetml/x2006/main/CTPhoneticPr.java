package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPhoneticPr extends XmlObject {
    public static final DocumentFactory<CTPhoneticPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPhoneticPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctphoneticpr898btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STPhoneticAlignment$Enum getAlignment();

    long getFontId();

    STPhoneticType.Enum getType();

    boolean isSetAlignment();

    boolean isSetType();

    void setAlignment(STPhoneticAlignment$Enum sTPhoneticAlignment$Enum);

    void setFontId(long j6);

    void setType(STPhoneticType.Enum r6);

    void unsetAlignment();

    void unsetType();

    STPhoneticAlignment xgetAlignment();

    STFontId xgetFontId();

    STPhoneticType xgetType();

    void xsetAlignment(STPhoneticAlignment sTPhoneticAlignment);

    void xsetFontId(STFontId sTFontId);

    void xsetType(STPhoneticType sTPhoneticType);
}
