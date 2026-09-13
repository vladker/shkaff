package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTParaRPr extends XmlObject {
    public static final DocumentFactory<CTParaRPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTParaRPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpararprd6fetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOnOff addNewB();

    CTOnOff addNewBCs();

    CTBorder addNewBdr();

    CTOnOff addNewCaps();

    CTColor addNewColor();

    CTOnOff addNewCs();

    CTTrackChange addNewDel();

    CTOnOff addNewDstrike();

    CTEastAsianLayout addNewEastAsianLayout();

    CTTextEffect addNewEffect();

    CTEm addNewEm();

    CTOnOff addNewEmboss();

    CTFitText addNewFitText();

    CTHighlight addNewHighlight();

    CTOnOff addNewI();

    CTOnOff addNewICs();

    CTOnOff addNewImprint();

    CTTrackChange addNewIns();

    CTHpsMeasure addNewKern();

    CTLanguage addNewLang();

    CTTrackChange addNewMoveFrom();

    CTTrackChange addNewMoveTo();

    CTOnOff addNewNoProof();

    CTOnOff addNewOMath();

    CTOnOff addNewOutline();

    CTSignedHpsMeasure addNewPosition();

    CTFonts addNewRFonts();

    CTParaRPrChange addNewRPrChange();

    CTString addNewRStyle();

    CTOnOff addNewRtl();

    CTOnOff addNewShadow();

    CTShd addNewShd();

    CTOnOff addNewSmallCaps();

    CTOnOff addNewSnapToGrid();

    CTSignedTwipsMeasure addNewSpacing();

    CTOnOff addNewSpecVanish();

    CTOnOff addNewStrike();

    CTHpsMeasure addNewSz();

    CTHpsMeasure addNewSzCs();

    CTUnderline addNewU();

    CTOnOff addNewVanish();

    CTVerticalAlignRun addNewVertAlign();

    CTTextScale addNewW();

    CTOnOff addNewWebHidden();

    CTOnOff getBArray(int i5);

    CTOnOff[] getBArray();

    CTOnOff getBCsArray(int i5);

    CTOnOff[] getBCsArray();

    List<CTOnOff> getBCsList();

    List<CTOnOff> getBList();

    CTBorder getBdrArray(int i5);

    CTBorder[] getBdrArray();

    List<CTBorder> getBdrList();

    CTOnOff getCapsArray(int i5);

    CTOnOff[] getCapsArray();

    List<CTOnOff> getCapsList();

    CTColor getColorArray(int i5);

    CTColor[] getColorArray();

    List<CTColor> getColorList();

    CTOnOff getCsArray(int i5);

    CTOnOff[] getCsArray();

    List<CTOnOff> getCsList();

    CTTrackChange getDel();

    CTOnOff getDstrikeArray(int i5);

    CTOnOff[] getDstrikeArray();

    List<CTOnOff> getDstrikeList();

    CTEastAsianLayout getEastAsianLayoutArray(int i5);

    CTEastAsianLayout[] getEastAsianLayoutArray();

    List<CTEastAsianLayout> getEastAsianLayoutList();

    CTTextEffect getEffectArray(int i5);

    CTTextEffect[] getEffectArray();

    List<CTTextEffect> getEffectList();

    CTEm getEmArray(int i5);

    CTEm[] getEmArray();

    List<CTEm> getEmList();

    CTOnOff getEmbossArray(int i5);

    CTOnOff[] getEmbossArray();

    List<CTOnOff> getEmbossList();

    CTFitText getFitTextArray(int i5);

    CTFitText[] getFitTextArray();

    List<CTFitText> getFitTextList();

    CTHighlight getHighlightArray(int i5);

    CTHighlight[] getHighlightArray();

    List<CTHighlight> getHighlightList();

    CTOnOff getIArray(int i5);

    CTOnOff[] getIArray();

    CTOnOff getICsArray(int i5);

    CTOnOff[] getICsArray();

    List<CTOnOff> getICsList();

    List<CTOnOff> getIList();

    CTOnOff getImprintArray(int i5);

    CTOnOff[] getImprintArray();

    List<CTOnOff> getImprintList();

    CTTrackChange getIns();

    CTHpsMeasure getKernArray(int i5);

    CTHpsMeasure[] getKernArray();

    List<CTHpsMeasure> getKernList();

    CTLanguage getLangArray(int i5);

    CTLanguage[] getLangArray();

    List<CTLanguage> getLangList();

    CTTrackChange getMoveFrom();

    CTTrackChange getMoveTo();

    CTOnOff getNoProofArray(int i5);

    CTOnOff[] getNoProofArray();

    List<CTOnOff> getNoProofList();

    CTOnOff getOMathArray(int i5);

    CTOnOff[] getOMathArray();

    List<CTOnOff> getOMathList();

    CTOnOff getOutlineArray(int i5);

    CTOnOff[] getOutlineArray();

    List<CTOnOff> getOutlineList();

    CTSignedHpsMeasure getPositionArray(int i5);

    CTSignedHpsMeasure[] getPositionArray();

    List<CTSignedHpsMeasure> getPositionList();

    CTFonts getRFontsArray(int i5);

    CTFonts[] getRFontsArray();

    List<CTFonts> getRFontsList();

    CTParaRPrChange getRPrChange();

    CTString getRStyleArray(int i5);

    CTString[] getRStyleArray();

    List<CTString> getRStyleList();

    CTOnOff getRtlArray(int i5);

    CTOnOff[] getRtlArray();

    List<CTOnOff> getRtlList();

    CTOnOff getShadowArray(int i5);

    CTOnOff[] getShadowArray();

    List<CTOnOff> getShadowList();

    CTShd getShdArray(int i5);

    CTShd[] getShdArray();

    List<CTShd> getShdList();

    CTOnOff getSmallCapsArray(int i5);

    CTOnOff[] getSmallCapsArray();

    List<CTOnOff> getSmallCapsList();

    CTOnOff getSnapToGridArray(int i5);

    CTOnOff[] getSnapToGridArray();

    List<CTOnOff> getSnapToGridList();

    CTSignedTwipsMeasure getSpacingArray(int i5);

    CTSignedTwipsMeasure[] getSpacingArray();

    List<CTSignedTwipsMeasure> getSpacingList();

    CTOnOff getSpecVanishArray(int i5);

    CTOnOff[] getSpecVanishArray();

    List<CTOnOff> getSpecVanishList();

    CTOnOff getStrikeArray(int i5);

    CTOnOff[] getStrikeArray();

    List<CTOnOff> getStrikeList();

    CTHpsMeasure getSzArray(int i5);

    CTHpsMeasure[] getSzArray();

    CTHpsMeasure getSzCsArray(int i5);

    CTHpsMeasure[] getSzCsArray();

    List<CTHpsMeasure> getSzCsList();

    List<CTHpsMeasure> getSzList();

    CTUnderline getUArray(int i5);

    CTUnderline[] getUArray();

    List<CTUnderline> getUList();

    CTOnOff getVanishArray(int i5);

    CTOnOff[] getVanishArray();

    List<CTOnOff> getVanishList();

    CTVerticalAlignRun getVertAlignArray(int i5);

    CTVerticalAlignRun[] getVertAlignArray();

    List<CTVerticalAlignRun> getVertAlignList();

    CTTextScale getWArray(int i5);

    CTTextScale[] getWArray();

    List<CTTextScale> getWList();

    CTOnOff getWebHiddenArray(int i5);

    CTOnOff[] getWebHiddenArray();

    List<CTOnOff> getWebHiddenList();

    CTOnOff insertNewB(int i5);

    CTOnOff insertNewBCs(int i5);

    CTBorder insertNewBdr(int i5);

    CTOnOff insertNewCaps(int i5);

    CTColor insertNewColor(int i5);

    CTOnOff insertNewCs(int i5);

    CTOnOff insertNewDstrike(int i5);

    CTEastAsianLayout insertNewEastAsianLayout(int i5);

    CTTextEffect insertNewEffect(int i5);

    CTEm insertNewEm(int i5);

    CTOnOff insertNewEmboss(int i5);

    CTFitText insertNewFitText(int i5);

    CTHighlight insertNewHighlight(int i5);

    CTOnOff insertNewI(int i5);

    CTOnOff insertNewICs(int i5);

    CTOnOff insertNewImprint(int i5);

    CTHpsMeasure insertNewKern(int i5);

    CTLanguage insertNewLang(int i5);

    CTOnOff insertNewNoProof(int i5);

    CTOnOff insertNewOMath(int i5);

    CTOnOff insertNewOutline(int i5);

    CTSignedHpsMeasure insertNewPosition(int i5);

    CTFonts insertNewRFonts(int i5);

    CTString insertNewRStyle(int i5);

    CTOnOff insertNewRtl(int i5);

    CTOnOff insertNewShadow(int i5);

    CTShd insertNewShd(int i5);

    CTOnOff insertNewSmallCaps(int i5);

    CTOnOff insertNewSnapToGrid(int i5);

    CTSignedTwipsMeasure insertNewSpacing(int i5);

    CTOnOff insertNewSpecVanish(int i5);

    CTOnOff insertNewStrike(int i5);

    CTHpsMeasure insertNewSz(int i5);

    CTHpsMeasure insertNewSzCs(int i5);

    CTUnderline insertNewU(int i5);

    CTOnOff insertNewVanish(int i5);

    CTVerticalAlignRun insertNewVertAlign(int i5);

    CTTextScale insertNewW(int i5);

    CTOnOff insertNewWebHidden(int i5);

    boolean isSetDel();

    boolean isSetIns();

    boolean isSetMoveFrom();

    boolean isSetMoveTo();

    boolean isSetRPrChange();

    void removeB(int i5);

    void removeBCs(int i5);

    void removeBdr(int i5);

    void removeCaps(int i5);

    void removeColor(int i5);

    void removeCs(int i5);

    void removeDstrike(int i5);

    void removeEastAsianLayout(int i5);

    void removeEffect(int i5);

    void removeEm(int i5);

    void removeEmboss(int i5);

    void removeFitText(int i5);

    void removeHighlight(int i5);

    void removeI(int i5);

    void removeICs(int i5);

    void removeImprint(int i5);

    void removeKern(int i5);

    void removeLang(int i5);

    void removeNoProof(int i5);

    void removeOMath(int i5);

    void removeOutline(int i5);

    void removePosition(int i5);

    void removeRFonts(int i5);

    void removeRStyle(int i5);

    void removeRtl(int i5);

    void removeShadow(int i5);

    void removeShd(int i5);

    void removeSmallCaps(int i5);

    void removeSnapToGrid(int i5);

    void removeSpacing(int i5);

    void removeSpecVanish(int i5);

    void removeStrike(int i5);

    void removeSz(int i5);

    void removeSzCs(int i5);

    void removeU(int i5);

    void removeVanish(int i5);

    void removeVertAlign(int i5);

    void removeW(int i5);

    void removeWebHidden(int i5);

    void setBArray(int i5, CTOnOff cTOnOff);

    void setBArray(CTOnOff[] cTOnOffArr);

    void setBCsArray(int i5, CTOnOff cTOnOff);

    void setBCsArray(CTOnOff[] cTOnOffArr);

    void setBdrArray(int i5, CTBorder cTBorder);

    void setBdrArray(CTBorder[] cTBorderArr);

    void setCapsArray(int i5, CTOnOff cTOnOff);

    void setCapsArray(CTOnOff[] cTOnOffArr);

    void setColorArray(int i5, CTColor cTColor);

    void setColorArray(CTColor[] cTColorArr);

    void setCsArray(int i5, CTOnOff cTOnOff);

    void setCsArray(CTOnOff[] cTOnOffArr);

    void setDel(CTTrackChange cTTrackChange);

    void setDstrikeArray(int i5, CTOnOff cTOnOff);

    void setDstrikeArray(CTOnOff[] cTOnOffArr);

    void setEastAsianLayoutArray(int i5, CTEastAsianLayout cTEastAsianLayout);

    void setEastAsianLayoutArray(CTEastAsianLayout[] cTEastAsianLayoutArr);

    void setEffectArray(int i5, CTTextEffect cTTextEffect);

    void setEffectArray(CTTextEffect[] cTTextEffectArr);

    void setEmArray(int i5, CTEm cTEm);

    void setEmArray(CTEm[] cTEmArr);

    void setEmbossArray(int i5, CTOnOff cTOnOff);

    void setEmbossArray(CTOnOff[] cTOnOffArr);

    void setFitTextArray(int i5, CTFitText cTFitText);

    void setFitTextArray(CTFitText[] cTFitTextArr);

    void setHighlightArray(int i5, CTHighlight cTHighlight);

    void setHighlightArray(CTHighlight[] cTHighlightArr);

    void setIArray(int i5, CTOnOff cTOnOff);

    void setIArray(CTOnOff[] cTOnOffArr);

    void setICsArray(int i5, CTOnOff cTOnOff);

    void setICsArray(CTOnOff[] cTOnOffArr);

    void setImprintArray(int i5, CTOnOff cTOnOff);

    void setImprintArray(CTOnOff[] cTOnOffArr);

    void setIns(CTTrackChange cTTrackChange);

    void setKernArray(int i5, CTHpsMeasure cTHpsMeasure);

    void setKernArray(CTHpsMeasure[] cTHpsMeasureArr);

    void setLangArray(int i5, CTLanguage cTLanguage);

    void setLangArray(CTLanguage[] cTLanguageArr);

    void setMoveFrom(CTTrackChange cTTrackChange);

    void setMoveTo(CTTrackChange cTTrackChange);

    void setNoProofArray(int i5, CTOnOff cTOnOff);

    void setNoProofArray(CTOnOff[] cTOnOffArr);

    void setOMathArray(int i5, CTOnOff cTOnOff);

    void setOMathArray(CTOnOff[] cTOnOffArr);

    void setOutlineArray(int i5, CTOnOff cTOnOff);

    void setOutlineArray(CTOnOff[] cTOnOffArr);

    void setPositionArray(int i5, CTSignedHpsMeasure cTSignedHpsMeasure);

    void setPositionArray(CTSignedHpsMeasure[] cTSignedHpsMeasureArr);

    void setRFontsArray(int i5, CTFonts cTFonts);

    void setRFontsArray(CTFonts[] cTFontsArr);

    void setRPrChange(CTParaRPrChange cTParaRPrChange);

    void setRStyleArray(int i5, CTString cTString);

    void setRStyleArray(CTString[] cTStringArr);

    void setRtlArray(int i5, CTOnOff cTOnOff);

    void setRtlArray(CTOnOff[] cTOnOffArr);

    void setShadowArray(int i5, CTOnOff cTOnOff);

    void setShadowArray(CTOnOff[] cTOnOffArr);

    void setShdArray(int i5, CTShd cTShd);

    void setShdArray(CTShd[] cTShdArr);

    void setSmallCapsArray(int i5, CTOnOff cTOnOff);

    void setSmallCapsArray(CTOnOff[] cTOnOffArr);

    void setSnapToGridArray(int i5, CTOnOff cTOnOff);

    void setSnapToGridArray(CTOnOff[] cTOnOffArr);

    void setSpacingArray(int i5, CTSignedTwipsMeasure cTSignedTwipsMeasure);

    void setSpacingArray(CTSignedTwipsMeasure[] cTSignedTwipsMeasureArr);

    void setSpecVanishArray(int i5, CTOnOff cTOnOff);

    void setSpecVanishArray(CTOnOff[] cTOnOffArr);

    void setStrikeArray(int i5, CTOnOff cTOnOff);

    void setStrikeArray(CTOnOff[] cTOnOffArr);

    void setSzArray(int i5, CTHpsMeasure cTHpsMeasure);

    void setSzArray(CTHpsMeasure[] cTHpsMeasureArr);

    void setSzCsArray(int i5, CTHpsMeasure cTHpsMeasure);

    void setSzCsArray(CTHpsMeasure[] cTHpsMeasureArr);

    void setUArray(int i5, CTUnderline cTUnderline);

    void setUArray(CTUnderline[] cTUnderlineArr);

    void setVanishArray(int i5, CTOnOff cTOnOff);

    void setVanishArray(CTOnOff[] cTOnOffArr);

    void setVertAlignArray(int i5, CTVerticalAlignRun cTVerticalAlignRun);

    void setVertAlignArray(CTVerticalAlignRun[] cTVerticalAlignRunArr);

    void setWArray(int i5, CTTextScale cTTextScale);

    void setWArray(CTTextScale[] cTTextScaleArr);

    void setWebHiddenArray(int i5, CTOnOff cTOnOff);

    void setWebHiddenArray(CTOnOff[] cTOnOffArr);

    int sizeOfBArray();

    int sizeOfBCsArray();

    int sizeOfBdrArray();

    int sizeOfCapsArray();

    int sizeOfColorArray();

    int sizeOfCsArray();

    int sizeOfDstrikeArray();

    int sizeOfEastAsianLayoutArray();

    int sizeOfEffectArray();

    int sizeOfEmArray();

    int sizeOfEmbossArray();

    int sizeOfFitTextArray();

    int sizeOfHighlightArray();

    int sizeOfIArray();

    int sizeOfICsArray();

    int sizeOfImprintArray();

    int sizeOfKernArray();

    int sizeOfLangArray();

    int sizeOfNoProofArray();

    int sizeOfOMathArray();

    int sizeOfOutlineArray();

    int sizeOfPositionArray();

    int sizeOfRFontsArray();

    int sizeOfRStyleArray();

    int sizeOfRtlArray();

    int sizeOfShadowArray();

    int sizeOfShdArray();

    int sizeOfSmallCapsArray();

    int sizeOfSnapToGridArray();

    int sizeOfSpacingArray();

    int sizeOfSpecVanishArray();

    int sizeOfStrikeArray();

    int sizeOfSzArray();

    int sizeOfSzCsArray();

    int sizeOfUArray();

    int sizeOfVanishArray();

    int sizeOfVertAlignArray();

    int sizeOfWArray();

    int sizeOfWebHiddenArray();

    void unsetDel();

    void unsetIns();

    void unsetMoveFrom();

    void unsetMoveTo();

    void unsetRPrChange();
}
