package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXmlName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCustomXmlRun extends XmlObject {
    public static final DocumentFactory<CTCustomXmlRun> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomXmlRun> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomxmlrun1ac3type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBdoContentRun addNewBdo();

    CTMarkupRange addNewBookmarkEnd();

    CTBookmark addNewBookmarkStart();

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

    CTCustomXmlPr addNewCustomXmlPr();

    CTRunTrackChange addNewDel();

    CTDirContentRun addNewDir();

    CTSimpleField addNewFldSimple();

    CTHyperlink addNewHyperlink();

    CTRunTrackChange addNewIns();

    CTRunTrackChange addNewMoveFrom();

    CTMarkupRange addNewMoveFromRangeEnd();

    CTMoveBookmark addNewMoveFromRangeStart();

    CTRunTrackChange addNewMoveTo();

    CTMarkupRange addNewMoveToRangeEnd();

    CTMoveBookmark addNewMoveToRangeStart();

    CTOMath addNewOMath();

    CTOMathPara addNewOMathPara();

    CTPerm addNewPermEnd();

    CTPermStart addNewPermStart();

    CTProofErr addNewProofErr();

    CTR addNewR();

    CTSdtRun addNewSdt();

    CTSmartTagRun addNewSmartTag();

    CTRel addNewSubDoc();

    CTBdoContentRun getBdoArray(int i5);

    CTBdoContentRun[] getBdoArray();

    List<CTBdoContentRun> getBdoList();

    CTMarkupRange getBookmarkEndArray(int i5);

    CTMarkupRange[] getBookmarkEndArray();

    List<CTMarkupRange> getBookmarkEndList();

    CTBookmark getBookmarkStartArray(int i5);

    CTBookmark[] getBookmarkStartArray();

    List<CTBookmark> getBookmarkStartList();

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

    CTCustomXmlPr getCustomXmlPr();

    CTRunTrackChange getDelArray(int i5);

    CTRunTrackChange[] getDelArray();

    List<CTRunTrackChange> getDelList();

    CTDirContentRun getDirArray(int i5);

    CTDirContentRun[] getDirArray();

    List<CTDirContentRun> getDirList();

    String getElement();

    CTSimpleField getFldSimpleArray(int i5);

    CTSimpleField[] getFldSimpleArray();

    List<CTSimpleField> getFldSimpleList();

    CTHyperlink getHyperlinkArray(int i5);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTRunTrackChange getInsArray(int i5);

    CTRunTrackChange[] getInsArray();

    List<CTRunTrackChange> getInsList();

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

    CTProofErr getProofErrArray(int i5);

    CTProofErr[] getProofErrArray();

    List<CTProofErr> getProofErrList();

    CTR getRArray(int i5);

    CTR[] getRArray();

    List<CTR> getRList();

    CTSdtRun getSdtArray(int i5);

    CTSdtRun[] getSdtArray();

    List<CTSdtRun> getSdtList();

    CTSmartTagRun getSmartTagArray(int i5);

    CTSmartTagRun[] getSmartTagArray();

    List<CTSmartTagRun> getSmartTagList();

    CTRel getSubDocArray(int i5);

    CTRel[] getSubDocArray();

    List<CTRel> getSubDocList();

    String getUri();

    CTBdoContentRun insertNewBdo(int i5);

    CTMarkupRange insertNewBookmarkEnd(int i5);

    CTBookmark insertNewBookmarkStart(int i5);

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

    CTRunTrackChange insertNewDel(int i5);

    CTDirContentRun insertNewDir(int i5);

    CTSimpleField insertNewFldSimple(int i5);

    CTHyperlink insertNewHyperlink(int i5);

    CTRunTrackChange insertNewIns(int i5);

    CTRunTrackChange insertNewMoveFrom(int i5);

    CTMarkupRange insertNewMoveFromRangeEnd(int i5);

    CTMoveBookmark insertNewMoveFromRangeStart(int i5);

    CTRunTrackChange insertNewMoveTo(int i5);

    CTMarkupRange insertNewMoveToRangeEnd(int i5);

    CTMoveBookmark insertNewMoveToRangeStart(int i5);

    CTOMath insertNewOMath(int i5);

    CTOMathPara insertNewOMathPara(int i5);

    CTPerm insertNewPermEnd(int i5);

    CTPermStart insertNewPermStart(int i5);

    CTProofErr insertNewProofErr(int i5);

    CTR insertNewR(int i5);

    CTSdtRun insertNewSdt(int i5);

    CTSmartTagRun insertNewSmartTag(int i5);

    CTRel insertNewSubDoc(int i5);

    boolean isSetCustomXmlPr();

    boolean isSetUri();

    void removeBdo(int i5);

    void removeBookmarkEnd(int i5);

    void removeBookmarkStart(int i5);

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

    void removeDel(int i5);

    void removeDir(int i5);

    void removeFldSimple(int i5);

    void removeHyperlink(int i5);

    void removeIns(int i5);

    void removeMoveFrom(int i5);

    void removeMoveFromRangeEnd(int i5);

    void removeMoveFromRangeStart(int i5);

    void removeMoveTo(int i5);

    void removeMoveToRangeEnd(int i5);

    void removeMoveToRangeStart(int i5);

    void removeOMath(int i5);

    void removeOMathPara(int i5);

    void removePermEnd(int i5);

    void removePermStart(int i5);

    void removeProofErr(int i5);

    void removeR(int i5);

    void removeSdt(int i5);

    void removeSmartTag(int i5);

    void removeSubDoc(int i5);

    void setBdoArray(int i5, CTBdoContentRun cTBdoContentRun);

    void setBdoArray(CTBdoContentRun[] cTBdoContentRunArr);

    void setBookmarkEndArray(int i5, CTMarkupRange cTMarkupRange);

    void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setBookmarkStartArray(int i5, CTBookmark cTBookmark);

    void setBookmarkStartArray(CTBookmark[] cTBookmarkArr);

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

    void setCustomXmlPr(CTCustomXmlPr cTCustomXmlPr);

    void setDelArray(int i5, CTRunTrackChange cTRunTrackChange);

    void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setDirArray(int i5, CTDirContentRun cTDirContentRun);

    void setDirArray(CTDirContentRun[] cTDirContentRunArr);

    void setElement(String str);

    void setFldSimpleArray(int i5, CTSimpleField cTSimpleField);

    void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr);

    void setHyperlinkArray(int i5, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    void setInsArray(int i5, CTRunTrackChange cTRunTrackChange);

    void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr);

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

    void setOMathArray(int i5, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaArray(int i5, CTOMathPara cTOMathPara);

    void setOMathParaArray(CTOMathPara[] cTOMathParaArr);

    void setPermEndArray(int i5, CTPerm cTPerm);

    void setPermEndArray(CTPerm[] cTPermArr);

    void setPermStartArray(int i5, CTPermStart cTPermStart);

    void setPermStartArray(CTPermStart[] cTPermStartArr);

    void setProofErrArray(int i5, CTProofErr cTProofErr);

    void setProofErrArray(CTProofErr[] cTProofErrArr);

    void setRArray(int i5, CTR ctr);

    void setRArray(CTR[] ctrArr);

    void setSdtArray(int i5, CTSdtRun cTSdtRun);

    void setSdtArray(CTSdtRun[] cTSdtRunArr);

    void setSmartTagArray(int i5, CTSmartTagRun cTSmartTagRun);

    void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr);

    void setSubDocArray(int i5, CTRel cTRel);

    void setSubDocArray(CTRel[] cTRelArr);

    void setUri(String str);

    int sizeOfBdoArray();

    int sizeOfBookmarkEndArray();

    int sizeOfBookmarkStartArray();

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

    int sizeOfDelArray();

    int sizeOfDirArray();

    int sizeOfFldSimpleArray();

    int sizeOfHyperlinkArray();

    int sizeOfInsArray();

    int sizeOfMoveFromArray();

    int sizeOfMoveFromRangeEndArray();

    int sizeOfMoveFromRangeStartArray();

    int sizeOfMoveToArray();

    int sizeOfMoveToRangeEndArray();

    int sizeOfMoveToRangeStartArray();

    int sizeOfOMathArray();

    int sizeOfOMathParaArray();

    int sizeOfPermEndArray();

    int sizeOfPermStartArray();

    int sizeOfProofErrArray();

    int sizeOfRArray();

    int sizeOfSdtArray();

    int sizeOfSmartTagArray();

    int sizeOfSubDocArray();

    void unsetCustomXmlPr();

    void unsetUri();

    STXmlName xgetElement();

    STString xgetUri();

    void xsetElement(STXmlName sTXmlName);

    void xsetUri(STString sTString);
}
