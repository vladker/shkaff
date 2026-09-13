package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STScreenSize;
import com.microsoft.schemas.office.office.STScreenSize$Enum;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STColorType;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTBackground extends XmlObject {
    public static final DocumentFactory<CTBackground> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBackground> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbackgroundd4ectype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFill addNewFill();

    STBWMode.Enum getBwmode();

    STBWMode.Enum getBwnormal();

    STBWMode.Enum getBwpure();

    CTFill getFill();

    String getFillcolor();

    STTrueFalse.Enum getFilled();

    String getId();

    STScreenSize$Enum getTargetscreensize();

    boolean isSetBwmode();

    boolean isSetBwnormal();

    boolean isSetBwpure();

    boolean isSetFill();

    boolean isSetFillcolor();

    boolean isSetFilled();

    boolean isSetId();

    boolean isSetTargetscreensize();

    void setBwmode(STBWMode.Enum r6);

    void setBwnormal(STBWMode.Enum r6);

    void setBwpure(STBWMode.Enum r6);

    void setFill(CTFill cTFill);

    void setFillcolor(String str);

    void setFilled(STTrueFalse.Enum r6);

    void setId(String str);

    void setTargetscreensize(STScreenSize$Enum sTScreenSize$Enum);

    void unsetBwmode();

    void unsetBwnormal();

    void unsetBwpure();

    void unsetFill();

    void unsetFillcolor();

    void unsetFilled();

    void unsetId();

    void unsetTargetscreensize();

    STBWMode xgetBwmode();

    STBWMode xgetBwnormal();

    STBWMode xgetBwpure();

    STColorType xgetFillcolor();

    STTrueFalse xgetFilled();

    XmlString xgetId();

    STScreenSize xgetTargetscreensize();

    void xsetBwmode(STBWMode sTBWMode);

    void xsetBwnormal(STBWMode sTBWMode);

    void xsetBwpure(STBWMode sTBWMode);

    void xsetFillcolor(STColorType sTColorType);

    void xsetFilled(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetTargetscreensize(STScreenSize sTScreenSize);
}
