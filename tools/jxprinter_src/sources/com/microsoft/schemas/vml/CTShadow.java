package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STColorType;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTShadow extends XmlObject {
    public static final DocumentFactory<CTShadow> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTShadow> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctshadowdfdetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getColor();

    String getColor2();

    String getId();

    String getMatrix();

    STTrueFalse.Enum getObscured();

    String getOffset();

    String getOffset2();

    STTrueFalse.Enum getOn();

    String getOpacity();

    String getOrigin();

    STShadowType.Enum getType();

    boolean isSetColor();

    boolean isSetColor2();

    boolean isSetId();

    boolean isSetMatrix();

    boolean isSetObscured();

    boolean isSetOffset();

    boolean isSetOffset2();

    boolean isSetOn();

    boolean isSetOpacity();

    boolean isSetOrigin();

    boolean isSetType();

    void setColor(String str);

    void setColor2(String str);

    void setId(String str);

    void setMatrix(String str);

    void setObscured(STTrueFalse.Enum r6);

    void setOffset(String str);

    void setOffset2(String str);

    void setOn(STTrueFalse.Enum r6);

    void setOpacity(String str);

    void setOrigin(String str);

    void setType(STShadowType.Enum r6);

    void unsetColor();

    void unsetColor2();

    void unsetId();

    void unsetMatrix();

    void unsetObscured();

    void unsetOffset();

    void unsetOffset2();

    void unsetOn();

    void unsetOpacity();

    void unsetOrigin();

    void unsetType();

    STColorType xgetColor();

    STColorType xgetColor2();

    XmlString xgetId();

    XmlString xgetMatrix();

    STTrueFalse xgetObscured();

    XmlString xgetOffset();

    XmlString xgetOffset2();

    STTrueFalse xgetOn();

    XmlString xgetOpacity();

    XmlString xgetOrigin();

    STShadowType xgetType();

    void xsetColor(STColorType sTColorType);

    void xsetColor2(STColorType sTColorType);

    void xsetId(XmlString xmlString);

    void xsetMatrix(XmlString xmlString);

    void xsetObscured(STTrueFalse sTTrueFalse);

    void xsetOffset(XmlString xmlString);

    void xsetOffset2(XmlString xmlString);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetOrigin(XmlString xmlString);

    void xsetType(STShadowType sTShadowType);
}
