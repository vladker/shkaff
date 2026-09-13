package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTHslColor extends XmlObject {
    public static final DocumentFactory<CTHslColor> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHslColor> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthslcolora63dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPositiveFixedPercentage addNewAlpha();

    CTPositivePercentage addNewAlphaMod();

    CTFixedPercentage addNewAlphaOff();

    CTPercentage addNewBlue();

    CTPercentage addNewBlueMod();

    CTPercentage addNewBlueOff();

    CTComplementTransform addNewComp();

    CTGammaTransform addNewGamma();

    CTGrayscaleTransform addNewGray();

    CTPercentage addNewGreen();

    CTPercentage addNewGreenMod();

    CTPercentage addNewGreenOff();

    CTPositiveFixedAngle addNewHue();

    CTPositivePercentage addNewHueMod();

    CTAngle addNewHueOff();

    CTInverseTransform addNewInv();

    CTInverseGammaTransform addNewInvGamma();

    CTPercentage addNewLum();

    CTPercentage addNewLumMod();

    CTPercentage addNewLumOff();

    CTPercentage addNewRed();

    CTPercentage addNewRedMod();

    CTPercentage addNewRedOff();

    CTPercentage addNewSat();

    CTPercentage addNewSatMod();

    CTPercentage addNewSatOff();

    CTPositiveFixedPercentage addNewShade();

    CTPositiveFixedPercentage addNewTint();

    CTPositiveFixedPercentage getAlphaArray(int i5);

    CTPositiveFixedPercentage[] getAlphaArray();

    List<CTPositiveFixedPercentage> getAlphaList();

    CTPositivePercentage getAlphaModArray(int i5);

    CTPositivePercentage[] getAlphaModArray();

    List<CTPositivePercentage> getAlphaModList();

    CTFixedPercentage getAlphaOffArray(int i5);

    CTFixedPercentage[] getAlphaOffArray();

    List<CTFixedPercentage> getAlphaOffList();

    CTPercentage getBlueArray(int i5);

    CTPercentage[] getBlueArray();

    List<CTPercentage> getBlueList();

    CTPercentage getBlueModArray(int i5);

    CTPercentage[] getBlueModArray();

    List<CTPercentage> getBlueModList();

    CTPercentage getBlueOffArray(int i5);

    CTPercentage[] getBlueOffArray();

    List<CTPercentage> getBlueOffList();

    CTComplementTransform getCompArray(int i5);

    CTComplementTransform[] getCompArray();

    List<CTComplementTransform> getCompList();

    CTGammaTransform getGammaArray(int i5);

    CTGammaTransform[] getGammaArray();

    List<CTGammaTransform> getGammaList();

    CTGrayscaleTransform getGrayArray(int i5);

    CTGrayscaleTransform[] getGrayArray();

    List<CTGrayscaleTransform> getGrayList();

    CTPercentage getGreenArray(int i5);

    CTPercentage[] getGreenArray();

    List<CTPercentage> getGreenList();

    CTPercentage getGreenModArray(int i5);

    CTPercentage[] getGreenModArray();

    List<CTPercentage> getGreenModList();

    CTPercentage getGreenOffArray(int i5);

    CTPercentage[] getGreenOffArray();

    List<CTPercentage> getGreenOffList();

    int getHue2();

    CTPositiveFixedAngle getHueArray(int i5);

    CTPositiveFixedAngle[] getHueArray();

    List<CTPositiveFixedAngle> getHueList();

    CTPositivePercentage getHueModArray(int i5);

    CTPositivePercentage[] getHueModArray();

    List<CTPositivePercentage> getHueModList();

    CTAngle getHueOffArray(int i5);

    CTAngle[] getHueOffArray();

    List<CTAngle> getHueOffList();

    CTInverseTransform getInvArray(int i5);

    CTInverseTransform[] getInvArray();

    CTInverseGammaTransform getInvGammaArray(int i5);

    CTInverseGammaTransform[] getInvGammaArray();

    List<CTInverseGammaTransform> getInvGammaList();

    List<CTInverseTransform> getInvList();

    Object getLum2();

    CTPercentage getLumArray(int i5);

    CTPercentage[] getLumArray();

    List<CTPercentage> getLumList();

    CTPercentage getLumModArray(int i5);

    CTPercentage[] getLumModArray();

    List<CTPercentage> getLumModList();

    CTPercentage getLumOffArray(int i5);

    CTPercentage[] getLumOffArray();

    List<CTPercentage> getLumOffList();

    CTPercentage getRedArray(int i5);

    CTPercentage[] getRedArray();

    List<CTPercentage> getRedList();

    CTPercentage getRedModArray(int i5);

    CTPercentage[] getRedModArray();

    List<CTPercentage> getRedModList();

    CTPercentage getRedOffArray(int i5);

    CTPercentage[] getRedOffArray();

    List<CTPercentage> getRedOffList();

    Object getSat2();

    CTPercentage getSatArray(int i5);

    CTPercentage[] getSatArray();

    List<CTPercentage> getSatList();

    CTPercentage getSatModArray(int i5);

    CTPercentage[] getSatModArray();

    List<CTPercentage> getSatModList();

    CTPercentage getSatOffArray(int i5);

    CTPercentage[] getSatOffArray();

    List<CTPercentage> getSatOffList();

    CTPositiveFixedPercentage getShadeArray(int i5);

    CTPositiveFixedPercentage[] getShadeArray();

    List<CTPositiveFixedPercentage> getShadeList();

    CTPositiveFixedPercentage getTintArray(int i5);

    CTPositiveFixedPercentage[] getTintArray();

    List<CTPositiveFixedPercentage> getTintList();

    CTPositiveFixedPercentage insertNewAlpha(int i5);

    CTPositivePercentage insertNewAlphaMod(int i5);

    CTFixedPercentage insertNewAlphaOff(int i5);

    CTPercentage insertNewBlue(int i5);

    CTPercentage insertNewBlueMod(int i5);

    CTPercentage insertNewBlueOff(int i5);

    CTComplementTransform insertNewComp(int i5);

    CTGammaTransform insertNewGamma(int i5);

    CTGrayscaleTransform insertNewGray(int i5);

    CTPercentage insertNewGreen(int i5);

    CTPercentage insertNewGreenMod(int i5);

    CTPercentage insertNewGreenOff(int i5);

    CTPositiveFixedAngle insertNewHue(int i5);

    CTPositivePercentage insertNewHueMod(int i5);

    CTAngle insertNewHueOff(int i5);

    CTInverseTransform insertNewInv(int i5);

    CTInverseGammaTransform insertNewInvGamma(int i5);

    CTPercentage insertNewLum(int i5);

    CTPercentage insertNewLumMod(int i5);

    CTPercentage insertNewLumOff(int i5);

    CTPercentage insertNewRed(int i5);

    CTPercentage insertNewRedMod(int i5);

    CTPercentage insertNewRedOff(int i5);

    CTPercentage insertNewSat(int i5);

    CTPercentage insertNewSatMod(int i5);

    CTPercentage insertNewSatOff(int i5);

    CTPositiveFixedPercentage insertNewShade(int i5);

    CTPositiveFixedPercentage insertNewTint(int i5);

    void removeAlpha(int i5);

    void removeAlphaMod(int i5);

    void removeAlphaOff(int i5);

    void removeBlue(int i5);

    void removeBlueMod(int i5);

    void removeBlueOff(int i5);

    void removeComp(int i5);

    void removeGamma(int i5);

    void removeGray(int i5);

    void removeGreen(int i5);

    void removeGreenMod(int i5);

    void removeGreenOff(int i5);

    void removeHue(int i5);

    void removeHueMod(int i5);

    void removeHueOff(int i5);

    void removeInv(int i5);

    void removeInvGamma(int i5);

    void removeLum(int i5);

    void removeLumMod(int i5);

    void removeLumOff(int i5);

    void removeRed(int i5);

    void removeRedMod(int i5);

    void removeRedOff(int i5);

    void removeSat(int i5);

    void removeSatMod(int i5);

    void removeSatOff(int i5);

    void removeShade(int i5);

    void removeTint(int i5);

    void setAlphaArray(int i5, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setAlphaArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setAlphaModArray(int i5, CTPositivePercentage cTPositivePercentage);

    void setAlphaModArray(CTPositivePercentage[] cTPositivePercentageArr);

    void setAlphaOffArray(int i5, CTFixedPercentage cTFixedPercentage);

    void setAlphaOffArray(CTFixedPercentage[] cTFixedPercentageArr);

    void setBlueArray(int i5, CTPercentage cTPercentage);

    void setBlueArray(CTPercentage[] cTPercentageArr);

    void setBlueModArray(int i5, CTPercentage cTPercentage);

    void setBlueModArray(CTPercentage[] cTPercentageArr);

    void setBlueOffArray(int i5, CTPercentage cTPercentage);

    void setBlueOffArray(CTPercentage[] cTPercentageArr);

    void setCompArray(int i5, CTComplementTransform cTComplementTransform);

    void setCompArray(CTComplementTransform[] cTComplementTransformArr);

    void setGammaArray(int i5, CTGammaTransform cTGammaTransform);

    void setGammaArray(CTGammaTransform[] cTGammaTransformArr);

    void setGrayArray(int i5, CTGrayscaleTransform cTGrayscaleTransform);

    void setGrayArray(CTGrayscaleTransform[] cTGrayscaleTransformArr);

    void setGreenArray(int i5, CTPercentage cTPercentage);

    void setGreenArray(CTPercentage[] cTPercentageArr);

    void setGreenModArray(int i5, CTPercentage cTPercentage);

    void setGreenModArray(CTPercentage[] cTPercentageArr);

    void setGreenOffArray(int i5, CTPercentage cTPercentage);

    void setGreenOffArray(CTPercentage[] cTPercentageArr);

    void setHue2(int i5);

    void setHueArray(int i5, CTPositiveFixedAngle cTPositiveFixedAngle);

    void setHueArray(CTPositiveFixedAngle[] cTPositiveFixedAngleArr);

    void setHueModArray(int i5, CTPositivePercentage cTPositivePercentage);

    void setHueModArray(CTPositivePercentage[] cTPositivePercentageArr);

    void setHueOffArray(int i5, CTAngle cTAngle);

    void setHueOffArray(CTAngle[] cTAngleArr);

    void setInvArray(int i5, CTInverseTransform cTInverseTransform);

    void setInvArray(CTInverseTransform[] cTInverseTransformArr);

    void setInvGammaArray(int i5, CTInverseGammaTransform cTInverseGammaTransform);

    void setInvGammaArray(CTInverseGammaTransform[] cTInverseGammaTransformArr);

    void setLum2(Object obj);

    void setLumArray(int i5, CTPercentage cTPercentage);

    void setLumArray(CTPercentage[] cTPercentageArr);

    void setLumModArray(int i5, CTPercentage cTPercentage);

    void setLumModArray(CTPercentage[] cTPercentageArr);

    void setLumOffArray(int i5, CTPercentage cTPercentage);

    void setLumOffArray(CTPercentage[] cTPercentageArr);

    void setRedArray(int i5, CTPercentage cTPercentage);

    void setRedArray(CTPercentage[] cTPercentageArr);

    void setRedModArray(int i5, CTPercentage cTPercentage);

    void setRedModArray(CTPercentage[] cTPercentageArr);

    void setRedOffArray(int i5, CTPercentage cTPercentage);

    void setRedOffArray(CTPercentage[] cTPercentageArr);

    void setSat2(Object obj);

    void setSatArray(int i5, CTPercentage cTPercentage);

    void setSatArray(CTPercentage[] cTPercentageArr);

    void setSatModArray(int i5, CTPercentage cTPercentage);

    void setSatModArray(CTPercentage[] cTPercentageArr);

    void setSatOffArray(int i5, CTPercentage cTPercentage);

    void setSatOffArray(CTPercentage[] cTPercentageArr);

    void setShadeArray(int i5, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setShadeArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setTintArray(int i5, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setTintArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    int sizeOfAlphaArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaOffArray();

    int sizeOfBlueArray();

    int sizeOfBlueModArray();

    int sizeOfBlueOffArray();

    int sizeOfCompArray();

    int sizeOfGammaArray();

    int sizeOfGrayArray();

    int sizeOfGreenArray();

    int sizeOfGreenModArray();

    int sizeOfGreenOffArray();

    int sizeOfHueArray();

    int sizeOfHueModArray();

    int sizeOfHueOffArray();

    int sizeOfInvArray();

    int sizeOfInvGammaArray();

    int sizeOfLumArray();

    int sizeOfLumModArray();

    int sizeOfLumOffArray();

    int sizeOfRedArray();

    int sizeOfRedModArray();

    int sizeOfRedOffArray();

    int sizeOfSatArray();

    int sizeOfSatModArray();

    int sizeOfSatOffArray();

    int sizeOfShadeArray();

    int sizeOfTintArray();

    STPositiveFixedAngle xgetHue2();

    STPercentage xgetLum2();

    STPercentage xgetSat2();

    void xsetHue2(STPositiveFixedAngle sTPositiveFixedAngle);

    void xsetLum2(STPercentage sTPercentage);

    void xsetSat2(STPercentage sTPercentage);
}
