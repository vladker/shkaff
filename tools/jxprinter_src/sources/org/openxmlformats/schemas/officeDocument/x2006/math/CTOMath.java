package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTOMath extends XmlObject {
    public static final DocumentFactory<CTOMath> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOMath> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctomath6725type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAcc addNewAcc();

    CTBar addNewBar();

    CTMarkupRange addNewBookmarkEnd();

    CTBookmark addNewBookmarkStart();

    CTBorderBox addNewBorderBox();

    CTBox addNewBox();

    CTMarkupRange addNewCommentRangeEnd();

    CTMarkupRange addNewCommentRangeStart();

    CTCustomXmlRun addNewCustomXml();

    CTMarkup addNewCustomXmlDelRangeEnd();

    CTTrackChange addNewCustomXmlDelRangeStart();

    CTMarkup addNewCustomXmlInsRangeEnd();

    CTTrackChange addNewCustomXmlInsRangeStart();

    CTMarkup addNewCustomXmlMoveFromRangeEnd();

    CTTrackChange addNewCustomXmlMoveFromRangeStart();

    CTMarkup addNewCustomXmlMoveToRangeEnd();

    CTTrackChange addNewCustomXmlMoveToRangeStart();

    CTD addNewD();

    CTRunTrackChange addNewDel();

    CTEqArr addNewEqArr();

    CTF addNewF();

    CTSimpleField addNewFldSimple();

    CTFunc addNewFunc();

    CTGroupChr addNewGroupChr();

    CTHyperlink addNewHyperlink();

    CTRunTrackChange addNewIns();

    CTLimLow addNewLimLow();

    CTLimUpp addNewLimUpp();

    CTM addNewM();

    CTRunTrackChange addNewMoveFrom();

    CTMarkupRange addNewMoveFromRangeEnd();

    CTMoveBookmark addNewMoveFromRangeStart();

    CTRunTrackChange addNewMoveTo();

    CTMarkupRange addNewMoveToRangeEnd();

    CTMoveBookmark addNewMoveToRangeStart();

    CTNary addNewNary();

    CTOMath addNewOMath();

    CTOMathPara addNewOMathPara();

    CTPerm addNewPermEnd();

    CTPermStart addNewPermStart();

    CTPhant addNewPhant();

    CTProofErr addNewProofErr();

    CTR addNewR();

    CTRad addNewRad();

    CTSPre addNewSPre();

    CTSSub addNewSSub();

    CTSSubSup addNewSSubSup();

    CTSSup addNewSSup();

    CTSdtRun addNewSdt();

    CTSmartTagRun addNewSmartTag();

    CTAcc getAccArray(int i5);

    CTAcc[] getAccArray();

    List<CTAcc> getAccList();

    CTBar getBarArray(int i5);

    CTBar[] getBarArray();

    List<CTBar> getBarList();

    CTMarkupRange getBookmarkEndArray(int i5);

    CTMarkupRange[] getBookmarkEndArray();

    List<CTMarkupRange> getBookmarkEndList();

    CTBookmark getBookmarkStartArray(int i5);

    CTBookmark[] getBookmarkStartArray();

    List<CTBookmark> getBookmarkStartList();

    CTBorderBox getBorderBoxArray(int i5);

    CTBorderBox[] getBorderBoxArray();

    List<CTBorderBox> getBorderBoxList();

    CTBox getBoxArray(int i5);

    CTBox[] getBoxArray();

    List<CTBox> getBoxList();

    CTMarkupRange getCommentRangeEndArray(int i5);

    CTMarkupRange[] getCommentRangeEndArray();

    List<CTMarkupRange> getCommentRangeEndList();

    CTMarkupRange getCommentRangeStartArray(int i5);

    CTMarkupRange[] getCommentRangeStartArray();

    List<CTMarkupRange> getCommentRangeStartList();

    CTCustomXmlRun getCustomXmlArray(int i5);

    CTCustomXmlRun[] getCustomXmlArray();

    CTMarkup getCustomXmlDelRangeEndArray(int i5);

    CTMarkup[] getCustomXmlDelRangeEndArray();

    List<CTMarkup> getCustomXmlDelRangeEndList();

    CTTrackChange getCustomXmlDelRangeStartArray(int i5);

    CTTrackChange[] getCustomXmlDelRangeStartArray();

    List<CTTrackChange> getCustomXmlDelRangeStartList();

    CTMarkup getCustomXmlInsRangeEndArray(int i5);

    CTMarkup[] getCustomXmlInsRangeEndArray();

    List<CTMarkup> getCustomXmlInsRangeEndList();

    CTTrackChange getCustomXmlInsRangeStartArray(int i5);

    CTTrackChange[] getCustomXmlInsRangeStartArray();

    List<CTTrackChange> getCustomXmlInsRangeStartList();

    List<CTCustomXmlRun> getCustomXmlList();

    CTMarkup getCustomXmlMoveFromRangeEndArray(int i5);

    CTMarkup[] getCustomXmlMoveFromRangeEndArray();

    List<CTMarkup> getCustomXmlMoveFromRangeEndList();

    CTTrackChange getCustomXmlMoveFromRangeStartArray(int i5);

    CTTrackChange[] getCustomXmlMoveFromRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveFromRangeStartList();

    CTMarkup getCustomXmlMoveToRangeEndArray(int i5);

    CTMarkup[] getCustomXmlMoveToRangeEndArray();

    List<CTMarkup> getCustomXmlMoveToRangeEndList();

    CTTrackChange getCustomXmlMoveToRangeStartArray(int i5);

    CTTrackChange[] getCustomXmlMoveToRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveToRangeStartList();

    CTD getDArray(int i5);

    CTD[] getDArray();

    List<CTD> getDList();

    CTRunTrackChange getDelArray(int i5);

    CTRunTrackChange[] getDelArray();

    List<CTRunTrackChange> getDelList();

    CTEqArr getEqArrArray(int i5);

    CTEqArr[] getEqArrArray();

    List<CTEqArr> getEqArrList();

    CTF getFArray(int i5);

    CTF[] getFArray();

    List<CTF> getFList();

    CTSimpleField getFldSimpleArray(int i5);

    CTSimpleField[] getFldSimpleArray();

    List<CTSimpleField> getFldSimpleList();

    CTFunc getFuncArray(int i5);

    CTFunc[] getFuncArray();

    List<CTFunc> getFuncList();

    CTGroupChr getGroupChrArray(int i5);

    CTGroupChr[] getGroupChrArray();

    List<CTGroupChr> getGroupChrList();

    CTHyperlink getHyperlinkArray(int i5);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTRunTrackChange getInsArray(int i5);

    CTRunTrackChange[] getInsArray();

    List<CTRunTrackChange> getInsList();

    CTLimLow getLimLowArray(int i5);

    CTLimLow[] getLimLowArray();

    List<CTLimLow> getLimLowList();

    CTLimUpp getLimUppArray(int i5);

    CTLimUpp[] getLimUppArray();

    List<CTLimUpp> getLimUppList();

    CTM getMArray(int i5);

    CTM[] getMArray();

    List<CTM> getMList();

    CTRunTrackChange getMoveFromArray(int i5);

    CTRunTrackChange[] getMoveFromArray();

    List<CTRunTrackChange> getMoveFromList();

    CTMarkupRange getMoveFromRangeEndArray(int i5);

    CTMarkupRange[] getMoveFromRangeEndArray();

    List<CTMarkupRange> getMoveFromRangeEndList();

    CTMoveBookmark getMoveFromRangeStartArray(int i5);

    CTMoveBookmark[] getMoveFromRangeStartArray();

    List<CTMoveBookmark> getMoveFromRangeStartList();

    CTRunTrackChange getMoveToArray(int i5);

    CTRunTrackChange[] getMoveToArray();

    List<CTRunTrackChange> getMoveToList();

    CTMarkupRange getMoveToRangeEndArray(int i5);

    CTMarkupRange[] getMoveToRangeEndArray();

    List<CTMarkupRange> getMoveToRangeEndList();

    CTMoveBookmark getMoveToRangeStartArray(int i5);

    CTMoveBookmark[] getMoveToRangeStartArray();

    List<CTMoveBookmark> getMoveToRangeStartList();

    CTNary getNaryArray(int i5);

    CTNary[] getNaryArray();

    List<CTNary> getNaryList();

    CTOMath getOMathArray(int i5);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathPara getOMathParaArray(int i5);

    CTOMathPara[] getOMathParaArray();

    List<CTOMathPara> getOMathParaList();

    CTPerm getPermEndArray(int i5);

    CTPerm[] getPermEndArray();

    List<CTPerm> getPermEndList();

    CTPermStart getPermStartArray(int i5);

    CTPermStart[] getPermStartArray();

    List<CTPermStart> getPermStartList();

    CTPhant getPhantArray(int i5);

    CTPhant[] getPhantArray();

    List<CTPhant> getPhantList();

    CTProofErr getProofErrArray(int i5);

    CTProofErr[] getProofErrArray();

    List<CTProofErr> getProofErrList();

    CTR getRArray(int i5);

    CTR[] getRArray();

    List<CTR> getRList();

    CTRad getRadArray(int i5);

    CTRad[] getRadArray();

    List<CTRad> getRadList();

    CTSPre getSPreArray(int i5);

    CTSPre[] getSPreArray();

    List<CTSPre> getSPreList();

    CTSSub getSSubArray(int i5);

    CTSSub[] getSSubArray();

    List<CTSSub> getSSubList();

    CTSSubSup getSSubSupArray(int i5);

    CTSSubSup[] getSSubSupArray();

    List<CTSSubSup> getSSubSupList();

    CTSSup getSSupArray(int i5);

    CTSSup[] getSSupArray();

    List<CTSSup> getSSupList();

    CTSdtRun getSdtArray(int i5);

    CTSdtRun[] getSdtArray();

    List<CTSdtRun> getSdtList();

    CTSmartTagRun getSmartTagArray(int i5);

    CTSmartTagRun[] getSmartTagArray();

    List<CTSmartTagRun> getSmartTagList();

    CTAcc insertNewAcc(int i5);

    CTBar insertNewBar(int i5);

    CTMarkupRange insertNewBookmarkEnd(int i5);

    CTBookmark insertNewBookmarkStart(int i5);

    CTBorderBox insertNewBorderBox(int i5);

    CTBox insertNewBox(int i5);

    CTMarkupRange insertNewCommentRangeEnd(int i5);

    CTMarkupRange insertNewCommentRangeStart(int i5);

    CTCustomXmlRun insertNewCustomXml(int i5);

    CTMarkup insertNewCustomXmlDelRangeEnd(int i5);

    CTTrackChange insertNewCustomXmlDelRangeStart(int i5);

    CTMarkup insertNewCustomXmlInsRangeEnd(int i5);

    CTTrackChange insertNewCustomXmlInsRangeStart(int i5);

    CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i5);

    CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i5);

    CTMarkup insertNewCustomXmlMoveToRangeEnd(int i5);

    CTTrackChange insertNewCustomXmlMoveToRangeStart(int i5);

    CTD insertNewD(int i5);

    CTRunTrackChange insertNewDel(int i5);

    CTEqArr insertNewEqArr(int i5);

    CTF insertNewF(int i5);

    CTSimpleField insertNewFldSimple(int i5);

    CTFunc insertNewFunc(int i5);

    CTGroupChr insertNewGroupChr(int i5);

    CTHyperlink insertNewHyperlink(int i5);

    CTRunTrackChange insertNewIns(int i5);

    CTLimLow insertNewLimLow(int i5);

    CTLimUpp insertNewLimUpp(int i5);

    CTM insertNewM(int i5);

    CTRunTrackChange insertNewMoveFrom(int i5);

    CTMarkupRange insertNewMoveFromRangeEnd(int i5);

    CTMoveBookmark insertNewMoveFromRangeStart(int i5);

    CTRunTrackChange insertNewMoveTo(int i5);

    CTMarkupRange insertNewMoveToRangeEnd(int i5);

    CTMoveBookmark insertNewMoveToRangeStart(int i5);

    CTNary insertNewNary(int i5);

    CTOMath insertNewOMath(int i5);

    CTOMathPara insertNewOMathPara(int i5);

    CTPerm insertNewPermEnd(int i5);

    CTPermStart insertNewPermStart(int i5);

    CTPhant insertNewPhant(int i5);

    CTProofErr insertNewProofErr(int i5);

    CTR insertNewR(int i5);

    CTRad insertNewRad(int i5);

    CTSPre insertNewSPre(int i5);

    CTSSub insertNewSSub(int i5);

    CTSSubSup insertNewSSubSup(int i5);

    CTSSup insertNewSSup(int i5);

    CTSdtRun insertNewSdt(int i5);

    CTSmartTagRun insertNewSmartTag(int i5);

    void removeAcc(int i5);

    void removeBar(int i5);

    void removeBookmarkEnd(int i5);

    void removeBookmarkStart(int i5);

    void removeBorderBox(int i5);

    void removeBox(int i5);

    void removeCommentRangeEnd(int i5);

    void removeCommentRangeStart(int i5);

    void removeCustomXml(int i5);

    void removeCustomXmlDelRangeEnd(int i5);

    void removeCustomXmlDelRangeStart(int i5);

    void removeCustomXmlInsRangeEnd(int i5);

    void removeCustomXmlInsRangeStart(int i5);

    void removeCustomXmlMoveFromRangeEnd(int i5);

    void removeCustomXmlMoveFromRangeStart(int i5);

    void removeCustomXmlMoveToRangeEnd(int i5);

    void removeCustomXmlMoveToRangeStart(int i5);

    void removeD(int i5);

    void removeDel(int i5);

    void removeEqArr(int i5);

    void removeF(int i5);

    void removeFldSimple(int i5);

    void removeFunc(int i5);

    void removeGroupChr(int i5);

    void removeHyperlink(int i5);

    void removeIns(int i5);

    void removeLimLow(int i5);

    void removeLimUpp(int i5);

    void removeM(int i5);

    void removeMoveFrom(int i5);

    void removeMoveFromRangeEnd(int i5);

    void removeMoveFromRangeStart(int i5);

    void removeMoveTo(int i5);

    void removeMoveToRangeEnd(int i5);

    void removeMoveToRangeStart(int i5);

    void removeNary(int i5);

    void removeOMath(int i5);

    void removeOMathPara(int i5);

    void removePermEnd(int i5);

    void removePermStart(int i5);

    void removePhant(int i5);

    void removeProofErr(int i5);

    void removeR(int i5);

    void removeRad(int i5);

    void removeSPre(int i5);

    void removeSSub(int i5);

    void removeSSubSup(int i5);

    void removeSSup(int i5);

    void removeSdt(int i5);

    void removeSmartTag(int i5);

    void setAccArray(int i5, CTAcc cTAcc);

    void setAccArray(CTAcc[] cTAccArr);

    void setBarArray(int i5, CTBar cTBar);

    void setBarArray(CTBar[] cTBarArr);

    void setBookmarkEndArray(int i5, CTMarkupRange cTMarkupRange);

    void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setBookmarkStartArray(int i5, CTBookmark cTBookmark);

    void setBookmarkStartArray(CTBookmark[] cTBookmarkArr);

    void setBorderBoxArray(int i5, CTBorderBox cTBorderBox);

    void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr);

    void setBoxArray(int i5, CTBox cTBox);

    void setBoxArray(CTBox[] cTBoxArr);

    void setCommentRangeEndArray(int i5, CTMarkupRange cTMarkupRange);

    void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCommentRangeStartArray(int i5, CTMarkupRange cTMarkupRange);

    void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCustomXmlArray(int i5, CTCustomXmlRun cTCustomXmlRun);

    void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr);

    void setCustomXmlDelRangeEndArray(int i5, CTMarkup cTMarkup);

    void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlDelRangeStartArray(int i5, CTTrackChange cTTrackChange);

    void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlInsRangeEndArray(int i5, CTMarkup cTMarkup);

    void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlInsRangeStartArray(int i5, CTTrackChange cTTrackChange);

    void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveFromRangeEndArray(int i5, CTMarkup cTMarkup);

    void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveFromRangeStartArray(int i5, CTTrackChange cTTrackChange);

    void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveToRangeEndArray(int i5, CTMarkup cTMarkup);

    void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveToRangeStartArray(int i5, CTTrackChange cTTrackChange);

    void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setDArray(int i5, CTD ctd);

    void setDArray(CTD[] ctdArr);

    void setDelArray(int i5, CTRunTrackChange cTRunTrackChange);

    void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setEqArrArray(int i5, CTEqArr cTEqArr);

    void setEqArrArray(CTEqArr[] cTEqArrArr);

    void setFArray(int i5, CTF ctf);

    void setFArray(CTF[] ctfArr);

    void setFldSimpleArray(int i5, CTSimpleField cTSimpleField);

    void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr);

    void setFuncArray(int i5, CTFunc cTFunc);

    void setFuncArray(CTFunc[] cTFuncArr);

    void setGroupChrArray(int i5, CTGroupChr cTGroupChr);

    void setGroupChrArray(CTGroupChr[] cTGroupChrArr);

    void setHyperlinkArray(int i5, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    void setInsArray(int i5, CTRunTrackChange cTRunTrackChange);

    void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setLimLowArray(int i5, CTLimLow cTLimLow);

    void setLimLowArray(CTLimLow[] cTLimLowArr);

    void setLimUppArray(int i5, CTLimUpp cTLimUpp);

    void setLimUppArray(CTLimUpp[] cTLimUppArr);

    void setMArray(int i5, CTM ctm);

    void setMArray(CTM[] ctmArr);

    void setMoveFromArray(int i5, CTRunTrackChange cTRunTrackChange);

    void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromRangeEndArray(int i5, CTMarkupRange cTMarkupRange);

    void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveFromRangeStartArray(int i5, CTMoveBookmark cTMoveBookmark);

    void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setMoveToArray(int i5, CTRunTrackChange cTRunTrackChange);

    void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveToRangeEndArray(int i5, CTMarkupRange cTMarkupRange);

    void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveToRangeStartArray(int i5, CTMoveBookmark cTMoveBookmark);

    void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setNaryArray(int i5, CTNary cTNary);

    void setNaryArray(CTNary[] cTNaryArr);

    void setOMathArray(int i5, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaArray(int i5, CTOMathPara cTOMathPara);

    void setOMathParaArray(CTOMathPara[] cTOMathParaArr);

    void setPermEndArray(int i5, CTPerm cTPerm);

    void setPermEndArray(CTPerm[] cTPermArr);

    void setPermStartArray(int i5, CTPermStart cTPermStart);

    void setPermStartArray(CTPermStart[] cTPermStartArr);

    void setPhantArray(int i5, CTPhant cTPhant);

    void setPhantArray(CTPhant[] cTPhantArr);

    void setProofErrArray(int i5, CTProofErr cTProofErr);

    void setProofErrArray(CTProofErr[] cTProofErrArr);

    void setRArray(int i5, CTR ctr);

    void setRArray(CTR[] ctrArr);

    void setRadArray(int i5, CTRad cTRad);

    void setRadArray(CTRad[] cTRadArr);

    void setSPreArray(int i5, CTSPre cTSPre);

    void setSPreArray(CTSPre[] cTSPreArr);

    void setSSubArray(int i5, CTSSub cTSSub);

    void setSSubArray(CTSSub[] cTSSubArr);

    void setSSubSupArray(int i5, CTSSubSup cTSSubSup);

    void setSSubSupArray(CTSSubSup[] cTSSubSupArr);

    void setSSupArray(int i5, CTSSup cTSSup);

    void setSSupArray(CTSSup[] cTSSupArr);

    void setSdtArray(int i5, CTSdtRun cTSdtRun);

    void setSdtArray(CTSdtRun[] cTSdtRunArr);

    void setSmartTagArray(int i5, CTSmartTagRun cTSmartTagRun);

    void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr);

    int sizeOfAccArray();

    int sizeOfBarArray();

    int sizeOfBookmarkEndArray();

    int sizeOfBookmarkStartArray();

    int sizeOfBorderBoxArray();

    int sizeOfBoxArray();

    int sizeOfCommentRangeEndArray();

    int sizeOfCommentRangeStartArray();

    int sizeOfCustomXmlArray();

    int sizeOfCustomXmlDelRangeEndArray();

    int sizeOfCustomXmlDelRangeStartArray();

    int sizeOfCustomXmlInsRangeEndArray();

    int sizeOfCustomXmlInsRangeStartArray();

    int sizeOfCustomXmlMoveFromRangeEndArray();

    int sizeOfCustomXmlMoveFromRangeStartArray();

    int sizeOfCustomXmlMoveToRangeEndArray();

    int sizeOfCustomXmlMoveToRangeStartArray();

    int sizeOfDArray();

    int sizeOfDelArray();

    int sizeOfEqArrArray();

    int sizeOfFArray();

    int sizeOfFldSimpleArray();

    int sizeOfFuncArray();

    int sizeOfGroupChrArray();

    int sizeOfHyperlinkArray();

    int sizeOfInsArray();

    int sizeOfLimLowArray();

    int sizeOfLimUppArray();

    int sizeOfMArray();

    int sizeOfMoveFromArray();

    int sizeOfMoveFromRangeEndArray();

    int sizeOfMoveFromRangeStartArray();

    int sizeOfMoveToArray();

    int sizeOfMoveToRangeEndArray();

    int sizeOfMoveToRangeStartArray();

    int sizeOfNaryArray();

    int sizeOfOMathArray();

    int sizeOfOMathParaArray();

    int sizeOfPermEndArray();

    int sizeOfPermStartArray();

    int sizeOfPhantArray();

    int sizeOfProofErrArray();

    int sizeOfRArray();

    int sizeOfRadArray();

    int sizeOfSPreArray();

    int sizeOfSSubArray();

    int sizeOfSSubSupArray();

    int sizeOfSSupArray();

    int sizeOfSdtArray();

    int sizeOfSmartTagArray();
}
