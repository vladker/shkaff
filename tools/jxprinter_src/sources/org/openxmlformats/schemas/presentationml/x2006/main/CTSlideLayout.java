package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSlideLayout extends XmlObject {
    public static final DocumentFactory<CTSlideLayout> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSlideLayout> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctslidelayouteb34type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCommonSlideData addNewCSld();

    CTColorMappingOverride addNewClrMapOvr();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTCommonSlideData getCSld();

    CTColorMappingOverride getClrMapOvr();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    String getMatchingName();

    boolean getPreserve();

    boolean getShowMasterPhAnim();

    boolean getShowMasterSp();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    STSlideLayoutType.Enum getType();

    boolean getUserDrawn();

    boolean isSetClrMapOvr();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetMatchingName();

    boolean isSetPreserve();

    boolean isSetShowMasterPhAnim();

    boolean isSetShowMasterSp();

    boolean isSetTiming();

    boolean isSetTransition();

    boolean isSetType();

    boolean isSetUserDrawn();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setMatchingName(String str);

    void setPreserve(boolean z6);

    void setShowMasterPhAnim(boolean z6);

    void setShowMasterSp(boolean z6);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void setType(STSlideLayoutType.Enum r6);

    void setUserDrawn(boolean z6);

    void unsetClrMapOvr();

    void unsetExtLst();

    void unsetHf();

    void unsetMatchingName();

    void unsetPreserve();

    void unsetShowMasterPhAnim();

    void unsetShowMasterSp();

    void unsetTiming();

    void unsetTransition();

    void unsetType();

    void unsetUserDrawn();

    XmlString xgetMatchingName();

    XmlBoolean xgetPreserve();

    XmlBoolean xgetShowMasterPhAnim();

    XmlBoolean xgetShowMasterSp();

    STSlideLayoutType xgetType();

    XmlBoolean xgetUserDrawn();

    void xsetMatchingName(XmlString xmlString);

    void xsetPreserve(XmlBoolean xmlBoolean);

    void xsetShowMasterPhAnim(XmlBoolean xmlBoolean);

    void xsetShowMasterSp(XmlBoolean xmlBoolean);

    void xsetType(STSlideLayoutType sTSlideLayoutType);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
