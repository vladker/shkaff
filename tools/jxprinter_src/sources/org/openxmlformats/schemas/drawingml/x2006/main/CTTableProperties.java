package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTableProperties extends XmlObject {
    public static final DocumentFactory<CTTableProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttableproperties3512type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBlipFillProperties addNewBlipFill();

    CTEffectContainer addNewEffectDag();

    CTEffectList addNewEffectLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTTableStyle addNewTableStyle();

    boolean getBandCol();

    boolean getBandRow();

    CTBlipFillProperties getBlipFill();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getFirstCol();

    boolean getFirstRow();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    boolean getLastCol();

    boolean getLastRow();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    boolean getRtl();

    CTSolidColorFillProperties getSolidFill();

    CTTableStyle getTableStyle();

    String getTableStyleId();

    boolean isSetBandCol();

    boolean isSetBandRow();

    boolean isSetBlipFill();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetExtLst();

    boolean isSetFirstCol();

    boolean isSetFirstRow();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetLastCol();

    boolean isSetLastRow();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetRtl();

    boolean isSetSolidFill();

    boolean isSetTableStyle();

    boolean isSetTableStyleId();

    void setBandCol(boolean z6);

    void setBandRow(boolean z6);

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFirstCol(boolean z6);

    void setFirstRow(boolean z6);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setLastCol(boolean z6);

    void setLastRow(boolean z6);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setRtl(boolean z6);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setTableStyle(CTTableStyle cTTableStyle);

    void setTableStyleId(String str);

    void unsetBandCol();

    void unsetBandRow();

    void unsetBlipFill();

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetExtLst();

    void unsetFirstCol();

    void unsetFirstRow();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetLastCol();

    void unsetLastRow();

    void unsetNoFill();

    void unsetPattFill();

    void unsetRtl();

    void unsetSolidFill();

    void unsetTableStyle();

    void unsetTableStyleId();

    XmlBoolean xgetBandCol();

    XmlBoolean xgetBandRow();

    XmlBoolean xgetFirstCol();

    XmlBoolean xgetFirstRow();

    XmlBoolean xgetLastCol();

    XmlBoolean xgetLastRow();

    XmlBoolean xgetRtl();

    STGuid xgetTableStyleId();

    void xsetBandCol(XmlBoolean xmlBoolean);

    void xsetBandRow(XmlBoolean xmlBoolean);

    void xsetFirstCol(XmlBoolean xmlBoolean);

    void xsetFirstRow(XmlBoolean xmlBoolean);

    void xsetLastCol(XmlBoolean xmlBoolean);

    void xsetLastRow(XmlBoolean xmlBoolean);

    void xsetRtl(XmlBoolean xmlBoolean);

    void xsetTableStyleId(STGuid sTGuid);
}
