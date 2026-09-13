package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTDiagram;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
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

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTGroup extends XmlObject {
    public static final DocumentFactory<CTGroup> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGroup> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgroup2b13type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAnchorLock addNewAnchorlock();

    CTArc addNewArc();

    CTBorder addNewBorderbottom();

    CTBorder addNewBorderleft();

    CTBorder addNewBorderright();

    CTBorder addNewBordertop();

    CTCallout addNewCallout();

    CTClientData addNewClientData();

    CTClipPath addNewClippath();

    CTCurve addNewCurve();

    CTDiagram addNewDiagram();

    CTExtrusion addNewExtrusion();

    CTFill addNewFill();

    CTFormulas addNewFormulas();

    CTGroup addNewGroup();

    CTHandles addNewHandles();

    CTImage addNewImage();

    CTImageData addNewImagedata();

    CTLine addNewLine();

    CTLock addNewLock();

    CTOval addNewOval();

    CTPath addNewPath();

    CTPolyLine addNewPolyline();

    CTRect addNewRect();

    CTRoundRect addNewRoundrect();

    CTShadow addNewShadow();

    CTShape addNewShape();

    CTShapetype addNewShapetype();

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

    CTArc getArcArray(int i5);

    CTArc[] getArcArray();

    List<CTArc> getArcList();

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

    CTCallout getCalloutArray(int i5);

    CTCallout[] getCalloutArray();

    List<CTCallout> getCalloutList();

    String getClass1();

    CTClientData getClientDataArray(int i5);

    CTClientData[] getClientDataArray();

    List<CTClientData> getClientDataList();

    CTClipPath getClippathArray(int i5);

    CTClipPath[] getClippathArray();

    List<CTClipPath> getClippathList();

    String getCoordorigin();

    String getCoordsize();

    CTCurve getCurveArray(int i5);

    CTCurve[] getCurveArray();

    List<CTCurve> getCurveList();

    BigInteger getDgmlayout();

    BigInteger getDgmlayoutmru();

    BigInteger getDgmnodekind();

    CTDiagram getDiagramArray(int i5);

    CTDiagram[] getDiagramArray();

    List<CTDiagram> getDiagramList();

    STTrueFalse.Enum getDoubleclicknotify();

    STEditAs.Enum getEditas();

    CTExtrusion getExtrusionArray(int i5);

    CTExtrusion[] getExtrusionArray();

    List<CTExtrusion> getExtrusionList();

    CTFill getFillArray(int i5);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    String getFillcolor();

    STTrueFalse.Enum getFilled();

    CTFormulas getFormulasArray(int i5);

    CTFormulas[] getFormulasArray();

    List<CTFormulas> getFormulasList();

    CTGroup getGroupArray(int i5);

    CTGroup[] getGroupArray();

    List<CTGroup> getGroupList();

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

    CTImage getImageArray(int i5);

    CTImage[] getImageArray();

    List<CTImage> getImageList();

    CTImageData getImagedataArray(int i5);

    CTImageData[] getImagedataArray();

    List<CTImageData> getImagedataList();

    STInsetMode.Enum getInsetmode();

    CTLine getLineArray(int i5);

    CTLine[] getLineArray();

    List<CTLine> getLineList();

    CTLock getLockArray(int i5);

    CTLock[] getLockArray();

    List<CTLock> getLockList();

    STTrueFalse.Enum getOned();

    CTOval getOvalArray(int i5);

    CTOval[] getOvalArray();

    List<CTOval> getOvalList();

    CTPath getPathArray(int i5);

    CTPath[] getPathArray();

    List<CTPath> getPathList();

    CTPolyLine getPolylineArray(int i5);

    CTPolyLine[] getPolylineArray();

    List<CTPolyLine> getPolylineList();

    STTrueFalse.Enum getPrint();

    CTRect getRectArray(int i5);

    CTRect[] getRectArray();

    List<CTRect> getRectList();

    BigInteger getRegroupid();

    CTRoundRect getRoundrectArray(int i5);

    CTRoundRect[] getRoundrectArray();

    List<CTRoundRect> getRoundrectList();

    CTShadow getShadowArray(int i5);

    CTShadow[] getShadowArray();

    List<CTShadow> getShadowList();

    CTShape getShapeArray(int i5);

    CTShape[] getShapeArray();

    List<CTShape> getShapeList();

    CTShapetype getShapetypeArray(int i5);

    CTShapetype[] getShapetypeArray();

    List<CTShapetype> getShapetypeList();

    CTSignatureLine getSignaturelineArray(int i5);

    CTSignatureLine[] getSignaturelineArray();

    List<CTSignatureLine> getSignaturelineList();

    CTSkew getSkewArray(int i5);

    CTSkew[] getSkewArray();

    List<CTSkew> getSkewList();

    String getSpid();

    CTStroke getStrokeArray(int i5);

    CTStroke[] getStrokeArray();

    List<CTStroke> getStrokeList();

    String getStyle();

    String getTablelimits();

    String getTableproperties();

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

    STTrueFalse.Enum getUserdrawn();

    STTrueFalse.Enum getUserhidden();

    CTWrap getWrapArray(int i5);

    CTWrap[] getWrapArray();

    List<CTWrap> getWrapList();

    String getWrapcoords();

    CTAnchorLock insertNewAnchorlock(int i5);

    CTArc insertNewArc(int i5);

    CTBorder insertNewBorderbottom(int i5);

    CTBorder insertNewBorderleft(int i5);

    CTBorder insertNewBorderright(int i5);

    CTBorder insertNewBordertop(int i5);

    CTCallout insertNewCallout(int i5);

    CTClientData insertNewClientData(int i5);

    CTClipPath insertNewClippath(int i5);

    CTCurve insertNewCurve(int i5);

    CTDiagram insertNewDiagram(int i5);

    CTExtrusion insertNewExtrusion(int i5);

    CTFill insertNewFill(int i5);

    CTFormulas insertNewFormulas(int i5);

    CTGroup insertNewGroup(int i5);

    CTHandles insertNewHandles(int i5);

    CTImage insertNewImage(int i5);

    CTImageData insertNewImagedata(int i5);

    CTLine insertNewLine(int i5);

    CTLock insertNewLock(int i5);

    CTOval insertNewOval(int i5);

    CTPath insertNewPath(int i5);

    CTPolyLine insertNewPolyline(int i5);

    CTRect insertNewRect(int i5);

    CTRoundRect insertNewRoundrect(int i5);

    CTShadow insertNewShadow(int i5);

    CTShape insertNewShape(int i5);

    CTShapetype insertNewShapetype(int i5);

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

    boolean isSetClass1();

    boolean isSetCoordorigin();

    boolean isSetCoordsize();

    boolean isSetDgmlayout();

    boolean isSetDgmlayoutmru();

    boolean isSetDgmnodekind();

    boolean isSetDoubleclicknotify();

    boolean isSetEditas();

    boolean isSetFillcolor();

    boolean isSetFilled();

    boolean isSetHr();

    boolean isSetHralign();

    boolean isSetHref();

    boolean isSetHrnoshade();

    boolean isSetHrpct();

    boolean isSetHrstd();

    boolean isSetId();

    boolean isSetInsetmode();

    boolean isSetOned();

    boolean isSetPrint();

    boolean isSetRegroupid();

    boolean isSetSpid();

    boolean isSetStyle();

    boolean isSetTablelimits();

    boolean isSetTableproperties();

    boolean isSetTarget();

    boolean isSetTitle();

    boolean isSetUserdrawn();

    boolean isSetUserhidden();

    boolean isSetWrapcoords();

    void removeAnchorlock(int i5);

    void removeArc(int i5);

    void removeBorderbottom(int i5);

    void removeBorderleft(int i5);

    void removeBorderright(int i5);

    void removeBordertop(int i5);

    void removeCallout(int i5);

    void removeClientData(int i5);

    void removeClippath(int i5);

    void removeCurve(int i5);

    void removeDiagram(int i5);

    void removeExtrusion(int i5);

    void removeFill(int i5);

    void removeFormulas(int i5);

    void removeGroup(int i5);

    void removeHandles(int i5);

    void removeImage(int i5);

    void removeImagedata(int i5);

    void removeLine(int i5);

    void removeLock(int i5);

    void removeOval(int i5);

    void removePath(int i5);

    void removePolyline(int i5);

    void removeRect(int i5);

    void removeRoundrect(int i5);

    void removeShadow(int i5);

    void removeShape(int i5);

    void removeShapetype(int i5);

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

    void setArcArray(int i5, CTArc cTArc);

    void setArcArray(CTArc[] cTArcArr);

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

    void setCalloutArray(int i5, CTCallout cTCallout);

    void setCalloutArray(CTCallout[] cTCalloutArr);

    void setClass1(String str);

    void setClientDataArray(int i5, CTClientData cTClientData);

    void setClientDataArray(CTClientData[] cTClientDataArr);

    void setClippathArray(int i5, CTClipPath cTClipPath);

    void setClippathArray(CTClipPath[] cTClipPathArr);

    void setCoordorigin(String str);

    void setCoordsize(String str);

    void setCurveArray(int i5, CTCurve cTCurve);

    void setCurveArray(CTCurve[] cTCurveArr);

    void setDgmlayout(BigInteger bigInteger);

    void setDgmlayoutmru(BigInteger bigInteger);

    void setDgmnodekind(BigInteger bigInteger);

    void setDiagramArray(int i5, CTDiagram cTDiagram);

    void setDiagramArray(CTDiagram[] cTDiagramArr);

    void setDoubleclicknotify(STTrueFalse.Enum r6);

    void setEditas(STEditAs.Enum r6);

    void setExtrusionArray(int i5, CTExtrusion cTExtrusion);

    void setExtrusionArray(CTExtrusion[] cTExtrusionArr);

    void setFillArray(int i5, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    void setFillcolor(String str);

    void setFilled(STTrueFalse.Enum r6);

    void setFormulasArray(int i5, CTFormulas cTFormulas);

    void setFormulasArray(CTFormulas[] cTFormulasArr);

    void setGroupArray(int i5, CTGroup cTGroup);

    void setGroupArray(CTGroup[] cTGroupArr);

    void setHandlesArray(int i5, CTHandles cTHandles);

    void setHandlesArray(CTHandles[] cTHandlesArr);

    void setHr(STTrueFalse.Enum r6);

    void setHralign(STHrAlign.Enum r6);

    void setHref(String str);

    void setHrnoshade(STTrueFalse.Enum r6);

    void setHrpct(float f6);

    void setHrstd(STTrueFalse.Enum r6);

    void setId(String str);

    void setImageArray(int i5, CTImage cTImage);

    void setImageArray(CTImage[] cTImageArr);

    void setImagedataArray(int i5, CTImageData cTImageData);

    void setImagedataArray(CTImageData[] cTImageDataArr);

    void setInsetmode(STInsetMode.Enum r6);

    void setLineArray(int i5, CTLine cTLine);

    void setLineArray(CTLine[] cTLineArr);

    void setLockArray(int i5, CTLock cTLock);

    void setLockArray(CTLock[] cTLockArr);

    void setOned(STTrueFalse.Enum r6);

    void setOvalArray(int i5, CTOval cTOval);

    void setOvalArray(CTOval[] cTOvalArr);

    void setPathArray(int i5, CTPath cTPath);

    void setPathArray(CTPath[] cTPathArr);

    void setPolylineArray(int i5, CTPolyLine cTPolyLine);

    void setPolylineArray(CTPolyLine[] cTPolyLineArr);

    void setPrint(STTrueFalse.Enum r6);

    void setRectArray(int i5, CTRect cTRect);

    void setRectArray(CTRect[] cTRectArr);

    void setRegroupid(BigInteger bigInteger);

    void setRoundrectArray(int i5, CTRoundRect cTRoundRect);

    void setRoundrectArray(CTRoundRect[] cTRoundRectArr);

    void setShadowArray(int i5, CTShadow cTShadow);

    void setShadowArray(CTShadow[] cTShadowArr);

    void setShapeArray(int i5, CTShape cTShape);

    void setShapeArray(CTShape[] cTShapeArr);

    void setShapetypeArray(int i5, CTShapetype cTShapetype);

    void setShapetypeArray(CTShapetype[] cTShapetypeArr);

    void setSignaturelineArray(int i5, CTSignatureLine cTSignatureLine);

    void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr);

    void setSkewArray(int i5, CTSkew cTSkew);

    void setSkewArray(CTSkew[] cTSkewArr);

    void setSpid(String str);

    void setStrokeArray(int i5, CTStroke cTStroke);

    void setStrokeArray(CTStroke[] cTStrokeArr);

    void setStyle(String str);

    void setTablelimits(String str);

    void setTableproperties(String str);

    void setTarget(String str);

    void setTextboxArray(int i5, CTTextbox cTTextbox);

    void setTextboxArray(CTTextbox[] cTTextboxArr);

    void setTextdataArray(int i5, CTRel cTRel);

    void setTextdataArray(CTRel[] cTRelArr);

    void setTextpathArray(int i5, CTTextPath cTTextPath);

    void setTextpathArray(CTTextPath[] cTTextPathArr);

    void setTitle(String str);

    void setUserdrawn(STTrueFalse.Enum r6);

    void setUserhidden(STTrueFalse.Enum r6);

    void setWrapArray(int i5, CTWrap cTWrap);

    void setWrapArray(CTWrap[] cTWrapArr);

    void setWrapcoords(String str);

    int sizeOfAnchorlockArray();

    int sizeOfArcArray();

    int sizeOfBorderbottomArray();

    int sizeOfBorderleftArray();

    int sizeOfBorderrightArray();

    int sizeOfBordertopArray();

    int sizeOfCalloutArray();

    int sizeOfClientDataArray();

    int sizeOfClippathArray();

    int sizeOfCurveArray();

    int sizeOfDiagramArray();

    int sizeOfExtrusionArray();

    int sizeOfFillArray();

    int sizeOfFormulasArray();

    int sizeOfGroupArray();

    int sizeOfHandlesArray();

    int sizeOfImageArray();

    int sizeOfImagedataArray();

    int sizeOfLineArray();

    int sizeOfLockArray();

    int sizeOfOvalArray();

    int sizeOfPathArray();

    int sizeOfPolylineArray();

    int sizeOfRectArray();

    int sizeOfRoundrectArray();

    int sizeOfShadowArray();

    int sizeOfShapeArray();

    int sizeOfShapetypeArray();

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

    void unsetClass1();

    void unsetCoordorigin();

    void unsetCoordsize();

    void unsetDgmlayout();

    void unsetDgmlayoutmru();

    void unsetDgmnodekind();

    void unsetDoubleclicknotify();

    void unsetEditas();

    void unsetFillcolor();

    void unsetFilled();

    void unsetHr();

    void unsetHralign();

    void unsetHref();

    void unsetHrnoshade();

    void unsetHrpct();

    void unsetHrstd();

    void unsetId();

    void unsetInsetmode();

    void unsetOned();

    void unsetPrint();

    void unsetRegroupid();

    void unsetSpid();

    void unsetStyle();

    void unsetTablelimits();

    void unsetTableproperties();

    void unsetTarget();

    void unsetTitle();

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

    XmlString xgetClass1();

    XmlString xgetCoordorigin();

    XmlString xgetCoordsize();

    STDiagramLayout xgetDgmlayout();

    STDiagramLayout xgetDgmlayoutmru();

    XmlInteger xgetDgmnodekind();

    STTrueFalse xgetDoubleclicknotify();

    STEditAs xgetEditas();

    STColorType xgetFillcolor();

    STTrueFalse xgetFilled();

    STTrueFalse xgetHr();

    STHrAlign xgetHralign();

    XmlString xgetHref();

    STTrueFalse xgetHrnoshade();

    XmlFloat xgetHrpct();

    STTrueFalse xgetHrstd();

    XmlString xgetId();

    STInsetMode xgetInsetmode();

    STTrueFalse xgetOned();

    STTrueFalse xgetPrint();

    XmlInteger xgetRegroupid();

    XmlString xgetSpid();

    XmlString xgetStyle();

    XmlString xgetTablelimits();

    XmlString xgetTableproperties();

    XmlString xgetTarget();

    XmlString xgetTitle();

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

    void xsetClass1(XmlString xmlString);

    void xsetCoordorigin(XmlString xmlString);

    void xsetCoordsize(XmlString xmlString);

    void xsetDgmlayout(STDiagramLayout sTDiagramLayout);

    void xsetDgmlayoutmru(STDiagramLayout sTDiagramLayout);

    void xsetDgmnodekind(XmlInteger xmlInteger);

    void xsetDoubleclicknotify(STTrueFalse sTTrueFalse);

    void xsetEditas(STEditAs sTEditAs);

    void xsetFillcolor(STColorType sTColorType);

    void xsetFilled(STTrueFalse sTTrueFalse);

    void xsetHr(STTrueFalse sTTrueFalse);

    void xsetHralign(STHrAlign sTHrAlign);

    void xsetHref(XmlString xmlString);

    void xsetHrnoshade(STTrueFalse sTTrueFalse);

    void xsetHrpct(XmlFloat xmlFloat);

    void xsetHrstd(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetOned(STTrueFalse sTTrueFalse);

    void xsetPrint(STTrueFalse sTTrueFalse);

    void xsetRegroupid(XmlInteger xmlInteger);

    void xsetSpid(XmlString xmlString);

    void xsetStyle(XmlString xmlString);

    void xsetTablelimits(XmlString xmlString);

    void xsetTableproperties(XmlString xmlString);

    void xsetTarget(XmlString xmlString);

    void xsetTitle(XmlString xmlString);

    void xsetUserdrawn(STTrueFalse sTTrueFalse);

    void xsetUserhidden(STTrueFalse sTTrueFalse);

    void xsetWrapcoords(XmlString xmlString);
}
