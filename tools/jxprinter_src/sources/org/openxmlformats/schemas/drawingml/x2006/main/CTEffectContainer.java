package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTEffectContainer extends XmlObject {
    public static final DocumentFactory<CTEffectContainer> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEffectContainer> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cteffectcontainer2e21type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAlphaBiLevelEffect addNewAlphaBiLevel();

    CTAlphaCeilingEffect addNewAlphaCeiling();

    CTAlphaFloorEffect addNewAlphaFloor();

    CTAlphaInverseEffect addNewAlphaInv();

    CTAlphaModulateEffect addNewAlphaMod();

    CTAlphaModulateFixedEffect addNewAlphaModFix();

    CTAlphaOutsetEffect addNewAlphaOutset();

    CTAlphaReplaceEffect addNewAlphaRepl();

    CTBiLevelEffect addNewBiLevel();

    CTBlendEffect addNewBlend();

    CTBlurEffect addNewBlur();

    CTColorChangeEffect addNewClrChange();

    CTColorReplaceEffect addNewClrRepl();

    CTEffectContainer addNewCont();

    CTDuotoneEffect addNewDuotone();

    CTEffectReference addNewEffect();

    CTFillEffect addNewFill();

    CTFillOverlayEffect addNewFillOverlay();

    CTGlowEffect addNewGlow();

    CTGrayscaleEffect addNewGrayscl();

    CTHSLEffect addNewHsl();

    CTInnerShadowEffect addNewInnerShdw();

    CTLuminanceEffect addNewLum();

    CTOuterShadowEffect addNewOuterShdw();

    CTPresetShadowEffect addNewPrstShdw();

    CTReflectionEffect addNewReflection();

    CTRelativeOffsetEffect addNewRelOff();

    CTSoftEdgesEffect addNewSoftEdge();

    CTTintEffect addNewTint();

    CTTransformEffect addNewXfrm();

    CTAlphaBiLevelEffect getAlphaBiLevelArray(int i5);

    CTAlphaBiLevelEffect[] getAlphaBiLevelArray();

    List<CTAlphaBiLevelEffect> getAlphaBiLevelList();

    CTAlphaCeilingEffect getAlphaCeilingArray(int i5);

    CTAlphaCeilingEffect[] getAlphaCeilingArray();

    List<CTAlphaCeilingEffect> getAlphaCeilingList();

    CTAlphaFloorEffect getAlphaFloorArray(int i5);

    CTAlphaFloorEffect[] getAlphaFloorArray();

    List<CTAlphaFloorEffect> getAlphaFloorList();

    CTAlphaInverseEffect getAlphaInvArray(int i5);

    CTAlphaInverseEffect[] getAlphaInvArray();

    List<CTAlphaInverseEffect> getAlphaInvList();

    CTAlphaModulateEffect getAlphaModArray(int i5);

    CTAlphaModulateEffect[] getAlphaModArray();

    CTAlphaModulateFixedEffect getAlphaModFixArray(int i5);

    CTAlphaModulateFixedEffect[] getAlphaModFixArray();

    List<CTAlphaModulateFixedEffect> getAlphaModFixList();

    List<CTAlphaModulateEffect> getAlphaModList();

    CTAlphaOutsetEffect getAlphaOutsetArray(int i5);

    CTAlphaOutsetEffect[] getAlphaOutsetArray();

    List<CTAlphaOutsetEffect> getAlphaOutsetList();

    CTAlphaReplaceEffect getAlphaReplArray(int i5);

    CTAlphaReplaceEffect[] getAlphaReplArray();

    List<CTAlphaReplaceEffect> getAlphaReplList();

    CTBiLevelEffect getBiLevelArray(int i5);

    CTBiLevelEffect[] getBiLevelArray();

    List<CTBiLevelEffect> getBiLevelList();

    CTBlendEffect getBlendArray(int i5);

    CTBlendEffect[] getBlendArray();

    List<CTBlendEffect> getBlendList();

    CTBlurEffect getBlurArray(int i5);

    CTBlurEffect[] getBlurArray();

    List<CTBlurEffect> getBlurList();

    CTColorChangeEffect getClrChangeArray(int i5);

    CTColorChangeEffect[] getClrChangeArray();

    List<CTColorChangeEffect> getClrChangeList();

    CTColorReplaceEffect getClrReplArray(int i5);

    CTColorReplaceEffect[] getClrReplArray();

    List<CTColorReplaceEffect> getClrReplList();

    CTEffectContainer getContArray(int i5);

    CTEffectContainer[] getContArray();

    List<CTEffectContainer> getContList();

    CTDuotoneEffect getDuotoneArray(int i5);

    CTDuotoneEffect[] getDuotoneArray();

    List<CTDuotoneEffect> getDuotoneList();

    CTEffectReference getEffectArray(int i5);

    CTEffectReference[] getEffectArray();

    List<CTEffectReference> getEffectList();

    CTFillEffect getFillArray(int i5);

    CTFillEffect[] getFillArray();

    List<CTFillEffect> getFillList();

    CTFillOverlayEffect getFillOverlayArray(int i5);

    CTFillOverlayEffect[] getFillOverlayArray();

    List<CTFillOverlayEffect> getFillOverlayList();

    CTGlowEffect getGlowArray(int i5);

    CTGlowEffect[] getGlowArray();

    List<CTGlowEffect> getGlowList();

    CTGrayscaleEffect getGraysclArray(int i5);

    CTGrayscaleEffect[] getGraysclArray();

    List<CTGrayscaleEffect> getGraysclList();

    CTHSLEffect getHslArray(int i5);

    CTHSLEffect[] getHslArray();

    List<CTHSLEffect> getHslList();

    CTInnerShadowEffect getInnerShdwArray(int i5);

    CTInnerShadowEffect[] getInnerShdwArray();

    List<CTInnerShadowEffect> getInnerShdwList();

    CTLuminanceEffect getLumArray(int i5);

    CTLuminanceEffect[] getLumArray();

    List<CTLuminanceEffect> getLumList();

    String getName();

    CTOuterShadowEffect getOuterShdwArray(int i5);

    CTOuterShadowEffect[] getOuterShdwArray();

    List<CTOuterShadowEffect> getOuterShdwList();

    CTPresetShadowEffect getPrstShdwArray(int i5);

    CTPresetShadowEffect[] getPrstShdwArray();

    List<CTPresetShadowEffect> getPrstShdwList();

    CTReflectionEffect getReflectionArray(int i5);

    CTReflectionEffect[] getReflectionArray();

    List<CTReflectionEffect> getReflectionList();

    CTRelativeOffsetEffect getRelOffArray(int i5);

    CTRelativeOffsetEffect[] getRelOffArray();

    List<CTRelativeOffsetEffect> getRelOffList();

    CTSoftEdgesEffect getSoftEdgeArray(int i5);

    CTSoftEdgesEffect[] getSoftEdgeArray();

    List<CTSoftEdgesEffect> getSoftEdgeList();

    CTTintEffect getTintArray(int i5);

    CTTintEffect[] getTintArray();

    List<CTTintEffect> getTintList();

    STEffectContainerType$Enum getType();

    CTTransformEffect getXfrmArray(int i5);

    CTTransformEffect[] getXfrmArray();

    List<CTTransformEffect> getXfrmList();

    CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i5);

    CTAlphaCeilingEffect insertNewAlphaCeiling(int i5);

    CTAlphaFloorEffect insertNewAlphaFloor(int i5);

    CTAlphaInverseEffect insertNewAlphaInv(int i5);

    CTAlphaModulateEffect insertNewAlphaMod(int i5);

    CTAlphaModulateFixedEffect insertNewAlphaModFix(int i5);

    CTAlphaOutsetEffect insertNewAlphaOutset(int i5);

    CTAlphaReplaceEffect insertNewAlphaRepl(int i5);

    CTBiLevelEffect insertNewBiLevel(int i5);

    CTBlendEffect insertNewBlend(int i5);

    CTBlurEffect insertNewBlur(int i5);

    CTColorChangeEffect insertNewClrChange(int i5);

    CTColorReplaceEffect insertNewClrRepl(int i5);

    CTEffectContainer insertNewCont(int i5);

    CTDuotoneEffect insertNewDuotone(int i5);

    CTEffectReference insertNewEffect(int i5);

    CTFillEffect insertNewFill(int i5);

    CTFillOverlayEffect insertNewFillOverlay(int i5);

    CTGlowEffect insertNewGlow(int i5);

    CTGrayscaleEffect insertNewGrayscl(int i5);

    CTHSLEffect insertNewHsl(int i5);

    CTInnerShadowEffect insertNewInnerShdw(int i5);

    CTLuminanceEffect insertNewLum(int i5);

    CTOuterShadowEffect insertNewOuterShdw(int i5);

    CTPresetShadowEffect insertNewPrstShdw(int i5);

    CTReflectionEffect insertNewReflection(int i5);

    CTRelativeOffsetEffect insertNewRelOff(int i5);

    CTSoftEdgesEffect insertNewSoftEdge(int i5);

    CTTintEffect insertNewTint(int i5);

    CTTransformEffect insertNewXfrm(int i5);

    boolean isSetName();

    boolean isSetType();

    void removeAlphaBiLevel(int i5);

    void removeAlphaCeiling(int i5);

    void removeAlphaFloor(int i5);

    void removeAlphaInv(int i5);

    void removeAlphaMod(int i5);

    void removeAlphaModFix(int i5);

    void removeAlphaOutset(int i5);

    void removeAlphaRepl(int i5);

    void removeBiLevel(int i5);

    void removeBlend(int i5);

    void removeBlur(int i5);

    void removeClrChange(int i5);

    void removeClrRepl(int i5);

    void removeCont(int i5);

    void removeDuotone(int i5);

    void removeEffect(int i5);

    void removeFill(int i5);

    void removeFillOverlay(int i5);

    void removeGlow(int i5);

    void removeGrayscl(int i5);

    void removeHsl(int i5);

    void removeInnerShdw(int i5);

    void removeLum(int i5);

    void removeOuterShdw(int i5);

    void removePrstShdw(int i5);

    void removeReflection(int i5);

    void removeRelOff(int i5);

    void removeSoftEdge(int i5);

    void removeTint(int i5);

    void removeXfrm(int i5);

    void setAlphaBiLevelArray(int i5, CTAlphaBiLevelEffect cTAlphaBiLevelEffect);

    void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr);

    void setAlphaCeilingArray(int i5, CTAlphaCeilingEffect cTAlphaCeilingEffect);

    void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr);

    void setAlphaFloorArray(int i5, CTAlphaFloorEffect cTAlphaFloorEffect);

    void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr);

    void setAlphaInvArray(int i5, CTAlphaInverseEffect cTAlphaInverseEffect);

    void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr);

    void setAlphaModArray(int i5, CTAlphaModulateEffect cTAlphaModulateEffect);

    void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr);

    void setAlphaModFixArray(int i5, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect);

    void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr);

    void setAlphaOutsetArray(int i5, CTAlphaOutsetEffect cTAlphaOutsetEffect);

    void setAlphaOutsetArray(CTAlphaOutsetEffect[] cTAlphaOutsetEffectArr);

    void setAlphaReplArray(int i5, CTAlphaReplaceEffect cTAlphaReplaceEffect);

    void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr);

    void setBiLevelArray(int i5, CTBiLevelEffect cTBiLevelEffect);

    void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr);

    void setBlendArray(int i5, CTBlendEffect cTBlendEffect);

    void setBlendArray(CTBlendEffect[] cTBlendEffectArr);

    void setBlurArray(int i5, CTBlurEffect cTBlurEffect);

    void setBlurArray(CTBlurEffect[] cTBlurEffectArr);

    void setClrChangeArray(int i5, CTColorChangeEffect cTColorChangeEffect);

    void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr);

    void setClrReplArray(int i5, CTColorReplaceEffect cTColorReplaceEffect);

    void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr);

    void setContArray(int i5, CTEffectContainer cTEffectContainer);

    void setContArray(CTEffectContainer[] cTEffectContainerArr);

    void setDuotoneArray(int i5, CTDuotoneEffect cTDuotoneEffect);

    void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr);

    void setEffectArray(int i5, CTEffectReference cTEffectReference);

    void setEffectArray(CTEffectReference[] cTEffectReferenceArr);

    void setFillArray(int i5, CTFillEffect cTFillEffect);

    void setFillArray(CTFillEffect[] cTFillEffectArr);

    void setFillOverlayArray(int i5, CTFillOverlayEffect cTFillOverlayEffect);

    void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr);

    void setGlowArray(int i5, CTGlowEffect cTGlowEffect);

    void setGlowArray(CTGlowEffect[] cTGlowEffectArr);

    void setGraysclArray(int i5, CTGrayscaleEffect cTGrayscaleEffect);

    void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr);

    void setHslArray(int i5, CTHSLEffect cTHSLEffect);

    void setHslArray(CTHSLEffect[] cTHSLEffectArr);

    void setInnerShdwArray(int i5, CTInnerShadowEffect cTInnerShadowEffect);

    void setInnerShdwArray(CTInnerShadowEffect[] cTInnerShadowEffectArr);

    void setLumArray(int i5, CTLuminanceEffect cTLuminanceEffect);

    void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr);

    void setName(String str);

    void setOuterShdwArray(int i5, CTOuterShadowEffect cTOuterShadowEffect);

    void setOuterShdwArray(CTOuterShadowEffect[] cTOuterShadowEffectArr);

    void setPrstShdwArray(int i5, CTPresetShadowEffect cTPresetShadowEffect);

    void setPrstShdwArray(CTPresetShadowEffect[] cTPresetShadowEffectArr);

    void setReflectionArray(int i5, CTReflectionEffect cTReflectionEffect);

    void setReflectionArray(CTReflectionEffect[] cTReflectionEffectArr);

    void setRelOffArray(int i5, CTRelativeOffsetEffect cTRelativeOffsetEffect);

    void setRelOffArray(CTRelativeOffsetEffect[] cTRelativeOffsetEffectArr);

    void setSoftEdgeArray(int i5, CTSoftEdgesEffect cTSoftEdgesEffect);

    void setSoftEdgeArray(CTSoftEdgesEffect[] cTSoftEdgesEffectArr);

    void setTintArray(int i5, CTTintEffect cTTintEffect);

    void setTintArray(CTTintEffect[] cTTintEffectArr);

    void setType(STEffectContainerType$Enum sTEffectContainerType$Enum);

    void setXfrmArray(int i5, CTTransformEffect cTTransformEffect);

    void setXfrmArray(CTTransformEffect[] cTTransformEffectArr);

    int sizeOfAlphaBiLevelArray();

    int sizeOfAlphaCeilingArray();

    int sizeOfAlphaFloorArray();

    int sizeOfAlphaInvArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaModFixArray();

    int sizeOfAlphaOutsetArray();

    int sizeOfAlphaReplArray();

    int sizeOfBiLevelArray();

    int sizeOfBlendArray();

    int sizeOfBlurArray();

    int sizeOfClrChangeArray();

    int sizeOfClrReplArray();

    int sizeOfContArray();

    int sizeOfDuotoneArray();

    int sizeOfEffectArray();

    int sizeOfFillArray();

    int sizeOfFillOverlayArray();

    int sizeOfGlowArray();

    int sizeOfGraysclArray();

    int sizeOfHslArray();

    int sizeOfInnerShdwArray();

    int sizeOfLumArray();

    int sizeOfOuterShdwArray();

    int sizeOfPrstShdwArray();

    int sizeOfReflectionArray();

    int sizeOfRelOffArray();

    int sizeOfSoftEdgeArray();

    int sizeOfTintArray();

    int sizeOfXfrmArray();

    void unsetName();

    void unsetType();

    XmlToken xgetName();

    STEffectContainerType xgetType();

    void xsetName(XmlToken xmlToken);

    void xsetType(STEffectContainerType sTEffectContainerType);
}
