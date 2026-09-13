package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTR extends XmlObject {
    public static final DocumentFactory<CTR> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTR> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctr386atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTEmpty addNewAnnotationRef();

    CTBr addNewBr();

    CTMarkup addNewCommentReference();

    CTRel addNewContentPart();

    CTEmpty addNewContinuationSeparator();

    CTEmpty addNewCr();

    CTEmpty addNewDayLong();

    CTEmpty addNewDayShort();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewDelInstrText();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewDelText();

    CTDrawing addNewDrawing();

    CTEmpty addNewEndnoteRef();

    CTFtnEdnRef addNewEndnoteReference();

    CTFldChar addNewFldChar();

    CTEmpty addNewFootnoteRef();

    CTFtnEdnRef addNewFootnoteReference();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewInstrText();

    CTEmpty addNewLastRenderedPageBreak();

    CTEmpty addNewMonthLong();

    CTEmpty addNewMonthShort();

    CTEmpty addNewNoBreakHyphen();

    CTObject addNewObject();

    CTEmpty addNewPgNum();

    CTPicture addNewPict();

    CTPTab addNewPtab();

    CTRPR addNewRPr();

    CTRPr addNewRPr2();

    CTRuby addNewRuby();

    CTEmpty addNewSeparator();

    CTEmpty addNewSoftHyphen();

    CTSym addNewSym();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewT();

    CTText addNewT2();

    CTEmpty addNewTab();

    CTEmpty addNewYearLong();

    CTEmpty addNewYearShort();

    CTEmpty getAnnotationRefArray(int i5);

    CTEmpty[] getAnnotationRefArray();

    List<CTEmpty> getAnnotationRefList();

    CTBr getBrArray(int i5);

    CTBr[] getBrArray();

    List<CTBr> getBrList();

    CTMarkup getCommentReferenceArray(int i5);

    CTMarkup[] getCommentReferenceArray();

    List<CTMarkup> getCommentReferenceList();

    CTRel getContentPartArray(int i5);

    CTRel[] getContentPartArray();

    List<CTRel> getContentPartList();

    CTEmpty getContinuationSeparatorArray(int i5);

    CTEmpty[] getContinuationSeparatorArray();

    List<CTEmpty> getContinuationSeparatorList();

    CTEmpty getCrArray(int i5);

    CTEmpty[] getCrArray();

    List<CTEmpty> getCrList();

    CTEmpty getDayLongArray(int i5);

    CTEmpty[] getDayLongArray();

    List<CTEmpty> getDayLongList();

    CTEmpty getDayShortArray(int i5);

    CTEmpty[] getDayShortArray();

    List<CTEmpty> getDayShortList();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getDelInstrTextArray(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getDelInstrTextArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getDelInstrTextList();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getDelTextArray(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getDelTextArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getDelTextList();

    CTDrawing getDrawingArray(int i5);

    CTDrawing[] getDrawingArray();

    List<CTDrawing> getDrawingList();

    CTEmpty getEndnoteRefArray(int i5);

    CTEmpty[] getEndnoteRefArray();

    List<CTEmpty> getEndnoteRefList();

    CTFtnEdnRef getEndnoteReferenceArray(int i5);

    CTFtnEdnRef[] getEndnoteReferenceArray();

    List<CTFtnEdnRef> getEndnoteReferenceList();

    CTFldChar getFldCharArray(int i5);

    CTFldChar[] getFldCharArray();

    List<CTFldChar> getFldCharList();

    CTEmpty getFootnoteRefArray(int i5);

    CTEmpty[] getFootnoteRefArray();

    List<CTEmpty> getFootnoteRefList();

    CTFtnEdnRef getFootnoteReferenceArray(int i5);

    CTFtnEdnRef[] getFootnoteReferenceArray();

    List<CTFtnEdnRef> getFootnoteReferenceList();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getInstrTextArray(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getInstrTextArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getInstrTextList();

    CTEmpty getLastRenderedPageBreakArray(int i5);

    CTEmpty[] getLastRenderedPageBreakArray();

    List<CTEmpty> getLastRenderedPageBreakList();

    CTEmpty getMonthLongArray(int i5);

    CTEmpty[] getMonthLongArray();

    List<CTEmpty> getMonthLongList();

    CTEmpty getMonthShortArray(int i5);

    CTEmpty[] getMonthShortArray();

    List<CTEmpty> getMonthShortList();

    CTEmpty getNoBreakHyphenArray(int i5);

    CTEmpty[] getNoBreakHyphenArray();

    List<CTEmpty> getNoBreakHyphenList();

    CTObject getObjectArray(int i5);

    CTObject[] getObjectArray();

    List<CTObject> getObjectList();

    CTEmpty getPgNumArray(int i5);

    CTEmpty[] getPgNumArray();

    List<CTEmpty> getPgNumList();

    CTPicture getPictArray(int i5);

    CTPicture[] getPictArray();

    List<CTPicture> getPictList();

    CTPTab getPtabArray(int i5);

    CTPTab[] getPtabArray();

    List<CTPTab> getPtabList();

    CTRPR getRPr();

    CTRPr getRPr2();

    CTRuby getRubyArray(int i5);

    CTRuby[] getRubyArray();

    List<CTRuby> getRubyList();

    CTEmpty getSeparatorArray(int i5);

    CTEmpty[] getSeparatorArray();

    List<CTEmpty> getSeparatorList();

    CTEmpty getSoftHyphenArray(int i5);

    CTEmpty[] getSoftHyphenArray();

    List<CTEmpty> getSoftHyphenList();

    CTSym getSymArray(int i5);

    CTSym[] getSymArray();

    List<CTSym> getSymList();

    CTText getT2Array(int i5);

    CTText[] getT2Array();

    List<CTText> getT2List();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getTArray(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getTArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getTList();

    CTEmpty getTabArray(int i5);

    CTEmpty[] getTabArray();

    List<CTEmpty> getTabList();

    CTEmpty getYearLongArray(int i5);

    CTEmpty[] getYearLongArray();

    List<CTEmpty> getYearLongList();

    CTEmpty getYearShortArray(int i5);

    CTEmpty[] getYearShortArray();

    List<CTEmpty> getYearShortList();

    CTEmpty insertNewAnnotationRef(int i5);

    CTBr insertNewBr(int i5);

    CTMarkup insertNewCommentReference(int i5);

    CTRel insertNewContentPart(int i5);

    CTEmpty insertNewContinuationSeparator(int i5);

    CTEmpty insertNewCr(int i5);

    CTEmpty insertNewDayLong(int i5);

    CTEmpty insertNewDayShort(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewDelInstrText(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewDelText(int i5);

    CTDrawing insertNewDrawing(int i5);

    CTEmpty insertNewEndnoteRef(int i5);

    CTFtnEdnRef insertNewEndnoteReference(int i5);

    CTFldChar insertNewFldChar(int i5);

    CTEmpty insertNewFootnoteRef(int i5);

    CTFtnEdnRef insertNewFootnoteReference(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewInstrText(int i5);

    CTEmpty insertNewLastRenderedPageBreak(int i5);

    CTEmpty insertNewMonthLong(int i5);

    CTEmpty insertNewMonthShort(int i5);

    CTEmpty insertNewNoBreakHyphen(int i5);

    CTObject insertNewObject(int i5);

    CTEmpty insertNewPgNum(int i5);

    CTPicture insertNewPict(int i5);

    CTPTab insertNewPtab(int i5);

    CTRuby insertNewRuby(int i5);

    CTEmpty insertNewSeparator(int i5);

    CTEmpty insertNewSoftHyphen(int i5);

    CTSym insertNewSym(int i5);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewT(int i5);

    CTText insertNewT2(int i5);

    CTEmpty insertNewTab(int i5);

    CTEmpty insertNewYearLong(int i5);

    CTEmpty insertNewYearShort(int i5);

    boolean isSetRPr();

    boolean isSetRPr2();

    void removeAnnotationRef(int i5);

    void removeBr(int i5);

    void removeCommentReference(int i5);

    void removeContentPart(int i5);

    void removeContinuationSeparator(int i5);

    void removeCr(int i5);

    void removeDayLong(int i5);

    void removeDayShort(int i5);

    void removeDelInstrText(int i5);

    void removeDelText(int i5);

    void removeDrawing(int i5);

    void removeEndnoteRef(int i5);

    void removeEndnoteReference(int i5);

    void removeFldChar(int i5);

    void removeFootnoteRef(int i5);

    void removeFootnoteReference(int i5);

    void removeInstrText(int i5);

    void removeLastRenderedPageBreak(int i5);

    void removeMonthLong(int i5);

    void removeMonthShort(int i5);

    void removeNoBreakHyphen(int i5);

    void removeObject(int i5);

    void removePgNum(int i5);

    void removePict(int i5);

    void removePtab(int i5);

    void removeRuby(int i5);

    void removeSeparator(int i5);

    void removeSoftHyphen(int i5);

    void removeSym(int i5);

    void removeT(int i5);

    void removeT2(int i5);

    void removeTab(int i5);

    void removeYearLong(int i5);

    void removeYearShort(int i5);

    void setAnnotationRefArray(int i5, CTEmpty cTEmpty);

    void setAnnotationRefArray(CTEmpty[] cTEmptyArr);

    void setBrArray(int i5, CTBr cTBr);

    void setBrArray(CTBr[] cTBrArr);

    void setCommentReferenceArray(int i5, CTMarkup cTMarkup);

    void setCommentReferenceArray(CTMarkup[] cTMarkupArr);

    void setContentPartArray(int i5, CTRel cTRel);

    void setContentPartArray(CTRel[] cTRelArr);

    void setContinuationSeparatorArray(int i5, CTEmpty cTEmpty);

    void setContinuationSeparatorArray(CTEmpty[] cTEmptyArr);

    void setCrArray(int i5, CTEmpty cTEmpty);

    void setCrArray(CTEmpty[] cTEmptyArr);

    void setDayLongArray(int i5, CTEmpty cTEmpty);

    void setDayLongArray(CTEmpty[] cTEmptyArr);

    void setDayShortArray(int i5, CTEmpty cTEmpty);

    void setDayShortArray(CTEmpty[] cTEmptyArr);

    void setDelInstrTextArray(int i5, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setDelInstrTextArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setDelTextArray(int i5, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setDelTextArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setDrawingArray(int i5, CTDrawing cTDrawing);

    void setDrawingArray(CTDrawing[] cTDrawingArr);

    void setEndnoteRefArray(int i5, CTEmpty cTEmpty);

    void setEndnoteRefArray(CTEmpty[] cTEmptyArr);

    void setEndnoteReferenceArray(int i5, CTFtnEdnRef cTFtnEdnRef);

    void setEndnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr);

    void setFldCharArray(int i5, CTFldChar cTFldChar);

    void setFldCharArray(CTFldChar[] cTFldCharArr);

    void setFootnoteRefArray(int i5, CTEmpty cTEmpty);

    void setFootnoteRefArray(CTEmpty[] cTEmptyArr);

    void setFootnoteReferenceArray(int i5, CTFtnEdnRef cTFtnEdnRef);

    void setFootnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr);

    void setInstrTextArray(int i5, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setInstrTextArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setLastRenderedPageBreakArray(int i5, CTEmpty cTEmpty);

    void setLastRenderedPageBreakArray(CTEmpty[] cTEmptyArr);

    void setMonthLongArray(int i5, CTEmpty cTEmpty);

    void setMonthLongArray(CTEmpty[] cTEmptyArr);

    void setMonthShortArray(int i5, CTEmpty cTEmpty);

    void setMonthShortArray(CTEmpty[] cTEmptyArr);

    void setNoBreakHyphenArray(int i5, CTEmpty cTEmpty);

    void setNoBreakHyphenArray(CTEmpty[] cTEmptyArr);

    void setObjectArray(int i5, CTObject cTObject);

    void setObjectArray(CTObject[] cTObjectArr);

    void setPgNumArray(int i5, CTEmpty cTEmpty);

    void setPgNumArray(CTEmpty[] cTEmptyArr);

    void setPictArray(int i5, CTPicture cTPicture);

    void setPictArray(CTPicture[] cTPictureArr);

    void setPtabArray(int i5, CTPTab cTPTab);

    void setPtabArray(CTPTab[] cTPTabArr);

    void setRPr(CTRPR ctrpr);

    void setRPr2(CTRPr cTRPr);

    void setRubyArray(int i5, CTRuby cTRuby);

    void setRubyArray(CTRuby[] cTRubyArr);

    void setSeparatorArray(int i5, CTEmpty cTEmpty);

    void setSeparatorArray(CTEmpty[] cTEmptyArr);

    void setSoftHyphenArray(int i5, CTEmpty cTEmpty);

    void setSoftHyphenArray(CTEmpty[] cTEmptyArr);

    void setSymArray(int i5, CTSym cTSym);

    void setSymArray(CTSym[] cTSymArr);

    void setT2Array(int i5, CTText cTText);

    void setT2Array(CTText[] cTTextArr);

    void setTArray(int i5, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setTArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setTabArray(int i5, CTEmpty cTEmpty);

    void setTabArray(CTEmpty[] cTEmptyArr);

    void setYearLongArray(int i5, CTEmpty cTEmpty);

    void setYearLongArray(CTEmpty[] cTEmptyArr);

    void setYearShortArray(int i5, CTEmpty cTEmpty);

    void setYearShortArray(CTEmpty[] cTEmptyArr);

    int sizeOfAnnotationRefArray();

    int sizeOfBrArray();

    int sizeOfCommentReferenceArray();

    int sizeOfContentPartArray();

    int sizeOfContinuationSeparatorArray();

    int sizeOfCrArray();

    int sizeOfDayLongArray();

    int sizeOfDayShortArray();

    int sizeOfDelInstrTextArray();

    int sizeOfDelTextArray();

    int sizeOfDrawingArray();

    int sizeOfEndnoteRefArray();

    int sizeOfEndnoteReferenceArray();

    int sizeOfFldCharArray();

    int sizeOfFootnoteRefArray();

    int sizeOfFootnoteReferenceArray();

    int sizeOfInstrTextArray();

    int sizeOfLastRenderedPageBreakArray();

    int sizeOfMonthLongArray();

    int sizeOfMonthShortArray();

    int sizeOfNoBreakHyphenArray();

    int sizeOfObjectArray();

    int sizeOfPgNumArray();

    int sizeOfPictArray();

    int sizeOfPtabArray();

    int sizeOfRubyArray();

    int sizeOfSeparatorArray();

    int sizeOfSoftHyphenArray();

    int sizeOfSymArray();

    int sizeOfT2Array();

    int sizeOfTArray();

    int sizeOfTabArray();

    int sizeOfYearLongArray();

    int sizeOfYearShortArray();

    void unsetRPr();

    void unsetRPr2();
}
