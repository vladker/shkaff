package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTBlip extends XmlObject {
    public static final DocumentFactory<CTBlip> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBlip> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctblip034ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAlphaBiLevelEffect addNewAlphaBiLevel();

    CTAlphaCeilingEffect addNewAlphaCeiling();

    CTAlphaFloorEffect addNewAlphaFloor();

    CTAlphaInverseEffect addNewAlphaInv();

    CTAlphaModulateEffect addNewAlphaMod();

    CTAlphaModulateFixedEffect addNewAlphaModFix();

    CTAlphaReplaceEffect addNewAlphaRepl();

    CTBiLevelEffect addNewBiLevel();

    CTBlurEffect addNewBlur();

    CTColorChangeEffect addNewClrChange();

    CTColorReplaceEffect addNewClrRepl();

    CTDuotoneEffect addNewDuotone();

    CTOfficeArtExtensionList addNewExtLst();

    CTFillOverlayEffect addNewFillOverlay();

    CTGrayscaleEffect addNewGrayscl();

    CTHSLEffect addNewHsl();

    CTLuminanceEffect addNewLum();

    CTTintEffect addNewTint();

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

    CTAlphaReplaceEffect getAlphaReplArray(int i5);

    CTAlphaReplaceEffect[] getAlphaReplArray();

    List<CTAlphaReplaceEffect> getAlphaReplList();

    CTBiLevelEffect getBiLevelArray(int i5);

    CTBiLevelEffect[] getBiLevelArray();

    List<CTBiLevelEffect> getBiLevelList();

    CTBlurEffect getBlurArray(int i5);

    CTBlurEffect[] getBlurArray();

    List<CTBlurEffect> getBlurList();

    CTColorChangeEffect getClrChangeArray(int i5);

    CTColorChangeEffect[] getClrChangeArray();

    List<CTColorChangeEffect> getClrChangeList();

    CTColorReplaceEffect getClrReplArray(int i5);

    CTColorReplaceEffect[] getClrReplArray();

    List<CTColorReplaceEffect> getClrReplList();

    STBlipCompression.Enum getCstate();

    CTDuotoneEffect getDuotoneArray(int i5);

    CTDuotoneEffect[] getDuotoneArray();

    List<CTDuotoneEffect> getDuotoneList();

    String getEmbed();

    CTOfficeArtExtensionList getExtLst();

    CTFillOverlayEffect getFillOverlayArray(int i5);

    CTFillOverlayEffect[] getFillOverlayArray();

    List<CTFillOverlayEffect> getFillOverlayList();

    CTGrayscaleEffect getGraysclArray(int i5);

    CTGrayscaleEffect[] getGraysclArray();

    List<CTGrayscaleEffect> getGraysclList();

    CTHSLEffect getHslArray(int i5);

    CTHSLEffect[] getHslArray();

    List<CTHSLEffect> getHslList();

    String getLink();

    CTLuminanceEffect getLumArray(int i5);

    CTLuminanceEffect[] getLumArray();

    List<CTLuminanceEffect> getLumList();

    CTTintEffect getTintArray(int i5);

    CTTintEffect[] getTintArray();

    List<CTTintEffect> getTintList();

    CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i5);

    CTAlphaCeilingEffect insertNewAlphaCeiling(int i5);

    CTAlphaFloorEffect insertNewAlphaFloor(int i5);

    CTAlphaInverseEffect insertNewAlphaInv(int i5);

    CTAlphaModulateEffect insertNewAlphaMod(int i5);

    CTAlphaModulateFixedEffect insertNewAlphaModFix(int i5);

    CTAlphaReplaceEffect insertNewAlphaRepl(int i5);

    CTBiLevelEffect insertNewBiLevel(int i5);

    CTBlurEffect insertNewBlur(int i5);

    CTColorChangeEffect insertNewClrChange(int i5);

    CTColorReplaceEffect insertNewClrRepl(int i5);

    CTDuotoneEffect insertNewDuotone(int i5);

    CTFillOverlayEffect insertNewFillOverlay(int i5);

    CTGrayscaleEffect insertNewGrayscl(int i5);

    CTHSLEffect insertNewHsl(int i5);

    CTLuminanceEffect insertNewLum(int i5);

    CTTintEffect insertNewTint(int i5);

    boolean isSetCstate();

    boolean isSetEmbed();

    boolean isSetExtLst();

    boolean isSetLink();

    void removeAlphaBiLevel(int i5);

    void removeAlphaCeiling(int i5);

    void removeAlphaFloor(int i5);

    void removeAlphaInv(int i5);

    void removeAlphaMod(int i5);

    void removeAlphaModFix(int i5);

    void removeAlphaRepl(int i5);

    void removeBiLevel(int i5);

    void removeBlur(int i5);

    void removeClrChange(int i5);

    void removeClrRepl(int i5);

    void removeDuotone(int i5);

    void removeFillOverlay(int i5);

    void removeGrayscl(int i5);

    void removeHsl(int i5);

    void removeLum(int i5);

    void removeTint(int i5);

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

    void setAlphaReplArray(int i5, CTAlphaReplaceEffect cTAlphaReplaceEffect);

    void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr);

    void setBiLevelArray(int i5, CTBiLevelEffect cTBiLevelEffect);

    void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr);

    void setBlurArray(int i5, CTBlurEffect cTBlurEffect);

    void setBlurArray(CTBlurEffect[] cTBlurEffectArr);

    void setClrChangeArray(int i5, CTColorChangeEffect cTColorChangeEffect);

    void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr);

    void setClrReplArray(int i5, CTColorReplaceEffect cTColorReplaceEffect);

    void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr);

    void setCstate(STBlipCompression.Enum r6);

    void setDuotoneArray(int i5, CTDuotoneEffect cTDuotoneEffect);

    void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr);

    void setEmbed(String str);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFillOverlayArray(int i5, CTFillOverlayEffect cTFillOverlayEffect);

    void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr);

    void setGraysclArray(int i5, CTGrayscaleEffect cTGrayscaleEffect);

    void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr);

    void setHslArray(int i5, CTHSLEffect cTHSLEffect);

    void setHslArray(CTHSLEffect[] cTHSLEffectArr);

    void setLink(String str);

    void setLumArray(int i5, CTLuminanceEffect cTLuminanceEffect);

    void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr);

    void setTintArray(int i5, CTTintEffect cTTintEffect);

    void setTintArray(CTTintEffect[] cTTintEffectArr);

    int sizeOfAlphaBiLevelArray();

    int sizeOfAlphaCeilingArray();

    int sizeOfAlphaFloorArray();

    int sizeOfAlphaInvArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaModFixArray();

    int sizeOfAlphaReplArray();

    int sizeOfBiLevelArray();

    int sizeOfBlurArray();

    int sizeOfClrChangeArray();

    int sizeOfClrReplArray();

    int sizeOfDuotoneArray();

    int sizeOfFillOverlayArray();

    int sizeOfGraysclArray();

    int sizeOfHslArray();

    int sizeOfLumArray();

    int sizeOfTintArray();

    void unsetCstate();

    void unsetEmbed();

    void unsetExtLst();

    void unsetLink();

    STBlipCompression xgetCstate();

    STRelationshipId xgetEmbed();

    STRelationshipId xgetLink();

    void xsetCstate(STBlipCompression sTBlipCompression);

    void xsetEmbed(STRelationshipId sTRelationshipId);

    void xsetLink(STRelationshipId sTRelationshipId);
}
