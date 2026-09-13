package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STDiagramLayout;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import java.math.BigInteger;
import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STColorType;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTLine extends XmlObject {
    public static final DocumentFactory<CTLine> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLine> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctline50f2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAnchorLock addNewAnchorlock();

    CTBorder addNewBorderbottom();

    CTBorder addNewBorderleft();

    CTBorder addNewBorderright();

    CTBorder addNewBordertop();

    CTCallout addNewCallout();

    CTClientData addNewClientData();

    CTClipPath addNewClippath();

    CTExtrusion addNewExtrusion();

    CTFill addNewFill();

    CTFormulas addNewFormulas();

    CTHandles addNewHandles();

    CTImageData addNewImagedata();

    CTLock addNewLock();

    CTPath addNewPath();

    CTShadow addNewShadow();

    CTSignatureLine addNewSignatureline();

    CTSkew addNewSkew();

    CTStroke addNewStroke();

    CTTextbox addNewTextbox();

    CTRel addNewTextdata();

    CTTextPath addNewTextpath();

    CTWrap addNewWrap();

    STTrueFalse.Enum getAllowincell();

    STTrueFalse.Enum getAllowoverlap();

    String getAlt();

    CTAnchorLock getAnchorlockArray(int i5);

    CTAnchorLock[] getAnchorlockArray();

    List<CTAnchorLock> getAnchorlockList();

    CTBorder getBorderbottomArray(int i5);

    CTBorder[] getBorderbottomArray();

    List<CTBorder> getBorderbottomList();

    String getBorderbottomcolor();

    CTBorder getBorderleftArray(int i5);

    CTBorder[] getBorderleftArray();

    List<CTBorder> getBorderleftList();

    String getBorderleftcolor();

    CTBorder getBorderrightArray(int i5);

    CTBorder[] getBorderrightArray();

    List<CTBorder> getBorderrightList();

    String getBorderrightcolor();

    CTBorder getBordertopArray(int i5);

    CTBorder[] getBordertopArray();

    List<CTBorder> getBordertopList();

    String getBordertopcolor();

    STTrueFalse.Enum getBullet();

    STTrueFalse.Enum getButton();

    STBWMode.Enum getBwmode();

    STBWMode.Enum getBwnormal();

    STBWMode.Enum getBwpure();

    CTCallout getCalloutArray(int i5);

    CTCallout[] getCalloutArray();

    List<CTCallout> getCalloutList();

    String getChromakey();

    String getClass1();

    CTClientData getClientDataArray(int i5);

    CTClientData[] getClientDataArray();

    List<CTClientData> getClientDataList();

    STTrueFalse.Enum getClip();

    CTClipPath getClippathArray(int i5);

    CTClipPath[] getClippathArray();

    List<CTClipPath> getClippathList();

    STTrueFalse.Enum getCliptowrap();

    STConnectorType.Enum getConnectortype();

    String getCoordorigin();

    String getCoordsize();

    BigInteger getDgmlayout();

    BigInteger getDgmlayoutmru();

    BigInteger getDgmnodekind();

    STTrueFalse.Enum getDoubleclicknotify();

    CTExtrusion getExtrusionArray(int i5);

    CTExtrusion[] getExtrusionArray();

    List<CTExtrusion> getExtrusionList();

    CTFill getFillArray(int i5);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    String getFillcolor();

    STTrueFalse.Enum getFilled();

    STTrueFalse.Enum getForcedash();

    CTFormulas getFormulasArray(int i5);

    CTFormulas[] getFormulasArray();

    List<CTFormulas> getFormulasList();

    String getFrom();

    CTHandles getHandlesArray(int i5);

    CTHandles[] getHandlesArray();

    List<CTHandles> getHandlesList();

    STTrueFalse.Enum getHr();

    STHrAlign.Enum getHralign();

    String getHref();

    STTrueFalse.Enum getHrnoshade();

    float getHrpct();

    STTrueFalse.Enum getHrstd();

    String getId();

    CTImageData getImagedataArray(int i5);

    CTImageData[] getImagedataArray();

    List<CTImageData> getImagedataList();

    STInsetMode.Enum getInsetmode();

    STTrueFalse.Enum getInsetpen();

    CTLock getLockArray(int i5);

    CTLock[] getLockArray();

    List<CTLock> getLockList();

    STTrueFalseBlank.Enum getOle();

    STTrueFalse.Enum getOleicon();

    STTrueFalse.Enum getOned();

    String getOpacity();

    CTPath getPathArray(int i5);

    CTPath[] getPathArray();

    List<CTPath> getPathList();

    STTrueFalse.Enum getPreferrelative();

    STTrueFalse.Enum getPrint();

    BigInteger getRegroupid();

    CTShadow getShadowArray(int i5);

    CTShadow[] getShadowArray();

    List<CTShadow> getShadowList();

    CTSignatureLine getSignaturelineArray(int i5);

    CTSignatureLine[] getSignaturelineArray();

    List<CTSignatureLine> getSignaturelineList();

    CTSkew getSkewArray(int i5);

    CTSkew[] getSkewArray();

    List<CTSkew> getSkewList();

    String getSpid();

    float getSpt();

    CTStroke getStrokeArray(int i5);

    CTStroke[] getStrokeArray();

    List<CTStroke> getStrokeList();

    String getStrokecolor();

    STTrueFalse.Enum getStroked();

    String getStrokeweight();

    String getStyle();

    String getTarget();

    CTTextbox getTextboxArray(int i5);

    CTTextbox[] getTextboxArray();

    List<CTTextbox> getTextboxList();

    CTRel getTextdataArray(int i5);

    CTRel[] getTextdataArray();

    List<CTRel> getTextdataList();

    CTTextPath getTextpathArray(int i5);

    CTTextPath[] getTextpathArray();

    List<CTTextPath> getTextpathList();

    String getTitle();

    String getTo();

    STTrueFalse.Enum getUserdrawn();

    STTrueFalse.Enum getUserhidden();

    CTWrap getWrapArray(int i5);

    CTWrap[] getWrapArray();

    List<CTWrap> getWrapList();

    String getWrapcoords();

    CTAnchorLock insertNewAnchorlock(int i5);

    CTBorder insertNewBorderbottom(int i5);

    CTBorder insertNewBorderleft(int i5);

    CTBorder insertNewBorderright(int i5);

    CTBorder insertNewBordertop(int i5);

    CTCallout insertNewCallout(int i5);

    CTClientData insertNewClientData(int i5);

    CTClipPath insertNewClippath(int i5);

    CTExtrusion insertNewExtrusion(int i5);

    CTFill insertNewFill(int i5);

    CTFormulas insertNewFormulas(int i5);

    CTHandles insertNewHandles(int i5);

    CTImageData insertNewImagedata(int i5);

    CTLock insertNewLock(int i5);

    CTPath insertNewPath(int i5);

    CTShadow insertNewShadow(int i5);

    CTSignatureLine insertNewSignatureline(int i5);

    CTSkew insertNewSkew(int i5);

    CTStroke insertNewStroke(int i5);

    CTTextbox insertNewTextbox(int i5);

    CTRel insertNewTextdata(int i5);

    CTTextPath insertNewTextpath(int i5);

    CTWrap insertNewWrap(int i5);

    boolean isSetAllowincell();

    boolean isSetAllowoverlap();

    boolean isSetAlt();

    boolean isSetBorderbottomcolor();

    boolean isSetBorderleftcolor();

    boolean isSetBorderrightcolor();

    boolean isSetBordertopcolor();

    boolean isSetBullet();

    boolean isSetButton();

    boolean isSetBwmode();

    boolean isSetBwnormal();

    boolean isSetBwpure();

    boolean isSetChromakey();

    boolean isSetClass1();

    boolean isSetClip();

    boolean isSetCliptowrap();

    boolean isSetConnectortype();

    boolean isSetCoordorigin();

    boolean isSetCoordsize();

    boolean isSetDgmlayout();

    boolean isSetDgmlayoutmru();

    boolean isSetDgmnodekind();

    boolean isSetDoubleclicknotify();

    boolean isSetFillcolor();

    boolean isSetFilled();

    boolean isSetForcedash();

    boolean isSetFrom();

    boolean isSetHr();

    boolean isSetHralign();

    boolean isSetHref();

    boolean isSetHrnoshade();

    boolean isSetHrpct();

    boolean isSetHrstd();

    boolean isSetId();

    boolean isSetInsetmode();

    boolean isSetInsetpen();

    boolean isSetOle();

    boolean isSetOleicon();

    boolean isSetOned();

    boolean isSetOpacity();

    boolean isSetPreferrelative();

    boolean isSetPrint();

    boolean isSetRegroupid();

    boolean isSetSpid();

    boolean isSetSpt();

    boolean isSetStrokecolor();

    boolean isSetStroked();

    boolean isSetStrokeweight();

    boolean isSetStyle();

    boolean isSetTarget();

    boolean isSetTitle();

    boolean isSetTo();

    boolean isSetUserdrawn();

    boolean isSetUserhidden();

    boolean isSetWrapcoords();

    void removeAnchorlock(int i5);

    void removeBorderbottom(int i5);

    void removeBorderleft(int i5);

    void removeBorderright(int i5);

    void removeBordertop(int i5);

    void removeCallout(int i5);

    void removeClientData(int i5);

    void removeClippath(int i5);

    void removeExtrusion(int i5);

    void removeFill(int i5);

    void removeFormulas(int i5);

    void removeHandles(int i5);

    void removeImagedata(int i5);

    void removeLock(int i5);

    void removePath(int i5);

    void removeShadow(int i5);

    void removeSignatureline(int i5);

    void removeSkew(int i5);

    void removeStroke(int i5);

    void removeTextbox(int i5);

    void removeTextdata(int i5);

    void removeTextpath(int i5);

    void removeWrap(int i5);

    void setAllowincell(STTrueFalse.Enum r6);

    void setAllowoverlap(STTrueFalse.Enum r6);

    void setAlt(String str);

    void setAnchorlockArray(int i5, CTAnchorLock cTAnchorLock);

    void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr);

    void setBorderbottomArray(int i5, CTBorder cTBorder);

    void setBorderbottomArray(CTBorder[] cTBorderArr);

    void setBorderbottomcolor(String str);

    void setBorderleftArray(int i5, CTBorder cTBorder);

    void setBorderleftArray(CTBorder[] cTBorderArr);

    void setBorderleftcolor(String str);

    void setBorderrightArray(int i5, CTBorder cTBorder);

    void setBorderrightArray(CTBorder[] cTBorderArr);

    void setBorderrightcolor(String str);

    void setBordertopArray(int i5, CTBorder cTBorder);

    void setBordertopArray(CTBorder[] cTBorderArr);

    void setBordertopcolor(String str);

    void setBullet(STTrueFalse.Enum r6);

    void setButton(STTrueFalse.Enum r6);

    void setBwmode(STBWMode.Enum r6);

    void setBwnormal(STBWMode.Enum r6);

    void setBwpure(STBWMode.Enum r6);

    void setCalloutArray(int i5, CTCallout cTCallout);

    void setCalloutArray(CTCallout[] cTCalloutArr);

    void setChromakey(String str);

    void setClass1(String str);

    void setClientDataArray(int i5, CTClientData cTClientData);

    void setClientDataArray(CTClientData[] cTClientDataArr);

    void setClip(STTrueFalse.Enum r6);

    void setClippathArray(int i5, CTClipPath cTClipPath);

    void setClippathArray(CTClipPath[] cTClipPathArr);

    void setCliptowrap(STTrueFalse.Enum r6);

    void setConnectortype(STConnectorType.Enum r6);

    void setCoordorigin(String str);

    void setCoordsize(String str);

    void setDgmlayout(BigInteger bigInteger);

    void setDgmlayoutmru(BigInteger bigInteger);

    void setDgmnodekind(BigInteger bigInteger);

    void setDoubleclicknotify(STTrueFalse.Enum r6);

    void setExtrusionArray(int i5, CTExtrusion cTExtrusion);

    void setExtrusionArray(CTExtrusion[] cTExtrusionArr);

    void setFillArray(int i5, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    void setFillcolor(String str);

    void setFilled(STTrueFalse.Enum r6);

    void setForcedash(STTrueFalse.Enum r6);

    void setFormulasArray(int i5, CTFormulas cTFormulas);

    void setFormulasArray(CTFormulas[] cTFormulasArr);

    void setFrom(String str);

    void setHandlesArray(int i5, CTHandles cTHandles);

    void setHandlesArray(CTHandles[] cTHandlesArr);

    void setHr(STTrueFalse.Enum r6);

    void setHralign(STHrAlign.Enum r6);

    void setHref(String str);

    void setHrnoshade(STTrueFalse.Enum r6);

    void setHrpct(float f6);

    void setHrstd(STTrueFalse.Enum r6);

    void setId(String str);

    void setImagedataArray(int i5, CTImageData cTImageData);

    void setImagedataArray(CTImageData[] cTImageDataArr);

    void setInsetmode(STInsetMode.Enum r6);

    void setInsetpen(STTrueFalse.Enum r6);

    void setLockArray(int i5, CTLock cTLock);

    void setLockArray(CTLock[] cTLockArr);

    void setOle(STTrueFalseBlank.Enum r6);

    void setOleicon(STTrueFalse.Enum r6);

    void setOned(STTrueFalse.Enum r6);

    void setOpacity(String str);

    void setPathArray(int i5, CTPath cTPath);

    void setPathArray(CTPath[] cTPathArr);

    void setPreferrelative(STTrueFalse.Enum r6);

    void setPrint(STTrueFalse.Enum r6);

    void setRegroupid(BigInteger bigInteger);

    void setShadowArray(int i5, CTShadow cTShadow);

    void setShadowArray(CTShadow[] cTShadowArr);

    void setSignaturelineArray(int i5, CTSignatureLine cTSignatureLine);

    void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr);

    void setSkewArray(int i5, CTSkew cTSkew);

    void setSkewArray(CTSkew[] cTSkewArr);

    void setSpid(String str);

    void setSpt(float f6);

    void setStrokeArray(int i5, CTStroke cTStroke);

    void setStrokeArray(CTStroke[] cTStrokeArr);

    void setStrokecolor(String str);

    void setStroked(STTrueFalse.Enum r6);

    void setStrokeweight(String str);

    void setStyle(String str);

    void setTarget(String str);

    void setTextboxArray(int i5, CTTextbox cTTextbox);

    void setTextboxArray(CTTextbox[] cTTextboxArr);

    void setTextdataArray(int i5, CTRel cTRel);

    void setTextdataArray(CTRel[] cTRelArr);

    void setTextpathArray(int i5, CTTextPath cTTextPath);

    void setTextpathArray(CTTextPath[] cTTextPathArr);

    void setTitle(String str);

    void setTo(String str);

    void setUserdrawn(STTrueFalse.Enum r6);

    void setUserhidden(STTrueFalse.Enum r6);

    void setWrapArray(int i5, CTWrap cTWrap);

    void setWrapArray(CTWrap[] cTWrapArr);

    void setWrapcoords(String str);

    int sizeOfAnchorlockArray();

    int sizeOfBorderbottomArray();

    int sizeOfBorderleftArray();

    int sizeOfBorderrightArray();

    int sizeOfBordertopArray();

    int sizeOfCalloutArray();

    int sizeOfClientDataArray();

    int sizeOfClippathArray();

    int sizeOfExtrusionArray();

    int sizeOfFillArray();

    int sizeOfFormulasArray();

    int sizeOfHandlesArray();

    int sizeOfImagedataArray();

    int sizeOfLockArray();

    int sizeOfPathArray();

    int sizeOfShadowArray();

    int sizeOfSignaturelineArray();

    int sizeOfSkewArray();

    int sizeOfStrokeArray();

    int sizeOfTextboxArray();

    int sizeOfTextdataArray();

    int sizeOfTextpathArray();

    int sizeOfWrapArray();

    void unsetAllowincell();

    void unsetAllowoverlap();

    void unsetAlt();

    void unsetBorderbottomcolor();

    void unsetBorderleftcolor();

    void unsetBorderrightcolor();

    void unsetBordertopcolor();

    void unsetBullet();

    void unsetButton();

    void unsetBwmode();

    void unsetBwnormal();

    void unsetBwpure();

    void unsetChromakey();

    void unsetClass1();

    void unsetClip();

    void unsetCliptowrap();

    void unsetConnectortype();

    void unsetCoordorigin();

    void unsetCoordsize();

    void unsetDgmlayout();

    void unsetDgmlayoutmru();

    void unsetDgmnodekind();

    void unsetDoubleclicknotify();

    void unsetFillcolor();

    void unsetFilled();

    void unsetForcedash();

    void unsetFrom();

    void unsetHr();

    void unsetHralign();

    void unsetHref();

    void unsetHrnoshade();

    void unsetHrpct();

    void unsetHrstd();

    void unsetId();

    void unsetInsetmode();

    void unsetInsetpen();

    void unsetOle();

    void unsetOleicon();

    void unsetOned();

    void unsetOpacity();

    void unsetPreferrelative();

    void unsetPrint();

    void unsetRegroupid();

    void unsetSpid();

    void unsetSpt();

    void unsetStrokecolor();

    void unsetStroked();

    void unsetStrokeweight();

    void unsetStyle();

    void unsetTarget();

    void unsetTitle();

    void unsetTo();

    void unsetUserdrawn();

    void unsetUserhidden();

    void unsetWrapcoords();

    STTrueFalse xgetAllowincell();

    STTrueFalse xgetAllowoverlap();

    XmlString xgetAlt();

    XmlString xgetBorderbottomcolor();

    XmlString xgetBorderleftcolor();

    XmlString xgetBorderrightcolor();

    XmlString xgetBordertopcolor();

    STTrueFalse xgetBullet();

    STTrueFalse xgetButton();

    STBWMode xgetBwmode();

    STBWMode xgetBwnormal();

    STBWMode xgetBwpure();

    STColorType xgetChromakey();

    XmlString xgetClass1();

    STTrueFalse xgetClip();

    STTrueFalse xgetCliptowrap();

    STConnectorType xgetConnectortype();

    XmlString xgetCoordorigin();

    XmlString xgetCoordsize();

    STDiagramLayout xgetDgmlayout();

    STDiagramLayout xgetDgmlayoutmru();

    XmlInteger xgetDgmnodekind();

    STTrueFalse xgetDoubleclicknotify();

    STColorType xgetFillcolor();

    STTrueFalse xgetFilled();

    STTrueFalse xgetForcedash();

    XmlString xgetFrom();

    STTrueFalse xgetHr();

    STHrAlign xgetHralign();

    XmlString xgetHref();

    STTrueFalse xgetHrnoshade();

    XmlFloat xgetHrpct();

    STTrueFalse xgetHrstd();

    XmlString xgetId();

    STInsetMode xgetInsetmode();

    STTrueFalse xgetInsetpen();

    STTrueFalseBlank xgetOle();

    STTrueFalse xgetOleicon();

    STTrueFalse xgetOned();

    XmlString xgetOpacity();

    STTrueFalse xgetPreferrelative();

    STTrueFalse xgetPrint();

    XmlInteger xgetRegroupid();

    XmlString xgetSpid();

    XmlFloat xgetSpt();

    STColorType xgetStrokecolor();

    STTrueFalse xgetStroked();

    XmlString xgetStrokeweight();

    XmlString xgetStyle();

    XmlString xgetTarget();

    XmlString xgetTitle();

    XmlString xgetTo();

    STTrueFalse xgetUserdrawn();

    STTrueFalse xgetUserhidden();

    XmlString xgetWrapcoords();

    void xsetAllowincell(STTrueFalse sTTrueFalse);

    void xsetAllowoverlap(STTrueFalse sTTrueFalse);

    void xsetAlt(XmlString xmlString);

    void xsetBorderbottomcolor(XmlString xmlString);

    void xsetBorderleftcolor(XmlString xmlString);

    void xsetBorderrightcolor(XmlString xmlString);

    void xsetBordertopcolor(XmlString xmlString);

    void xsetBullet(STTrueFalse sTTrueFalse);

    void xsetButton(STTrueFalse sTTrueFalse);

    void xsetBwmode(STBWMode sTBWMode);

    void xsetBwnormal(STBWMode sTBWMode);

    void xsetBwpure(STBWMode sTBWMode);

    void xsetChromakey(STColorType sTColorType);

    void xsetClass1(XmlString xmlString);

    void xsetClip(STTrueFalse sTTrueFalse);

    void xsetCliptowrap(STTrueFalse sTTrueFalse);

    void xsetConnectortype(STConnectorType sTConnectorType);

    void xsetCoordorigin(XmlString xmlString);

    void xsetCoordsize(XmlString xmlString);

    void xsetDgmlayout(STDiagramLayout sTDiagramLayout);

    void xsetDgmlayoutmru(STDiagramLayout sTDiagramLayout);

    void xsetDgmnodekind(XmlInteger xmlInteger);

    void xsetDoubleclicknotify(STTrueFalse sTTrueFalse);

    void xsetFillcolor(STColorType sTColorType);

    void xsetFilled(STTrueFalse sTTrueFalse);

    void xsetForcedash(STTrueFalse sTTrueFalse);

    void xsetFrom(XmlString xmlString);

    void xsetHr(STTrueFalse sTTrueFalse);

    void xsetHralign(STHrAlign sTHrAlign);

    void xsetHref(XmlString xmlString);

    void xsetHrnoshade(STTrueFalse sTTrueFalse);

    void xsetHrpct(XmlFloat xmlFloat);

    void xsetHrstd(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetInsetpen(STTrueFalse sTTrueFalse);

    void xsetOle(STTrueFalseBlank sTTrueFalseBlank);

    void xsetOleicon(STTrueFalse sTTrueFalse);

    void xsetOned(STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetPreferrelative(STTrueFalse sTTrueFalse);

    void xsetPrint(STTrueFalse sTTrueFalse);

    void xsetRegroupid(XmlInteger xmlInteger);

    void xsetSpid(XmlString xmlString);

    void xsetSpt(XmlFloat xmlFloat);

    void xsetStrokecolor(STColorType sTColorType);

    void xsetStroked(STTrueFalse sTTrueFalse);

    void xsetStrokeweight(XmlString xmlString);

    void xsetStyle(XmlString xmlString);

    void xsetTarget(XmlString xmlString);

    void xsetTitle(XmlString xmlString);

    void xsetTo(XmlString xmlString);

    void xsetUserdrawn(STTrueFalse sTTrueFalse);

    void xsetUserhidden(STTrueFalse sTTrueFalse);

    void xsetWrapcoords(XmlString xmlString);
}
