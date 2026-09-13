package com.microsoft.schemas.office.excel;

import java.math.BigInteger;
import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTClientData extends XmlObject {
    public static final DocumentFactory<CTClientData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTClientData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctclientdata433btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    void addAccel(BigInteger bigInteger);

    void addAccel2(BigInteger bigInteger);

    void addAnchor(String str);

    void addAutoFill(STTrueFalseBlank.Enum r6);

    void addAutoLine(STTrueFalseBlank.Enum r6);

    void addAutoPict(STTrueFalseBlank.Enum r6);

    void addAutoScale(STTrueFalseBlank.Enum r6);

    void addCF(String str);

    void addCamera(STTrueFalseBlank.Enum r6);

    void addCancel(STTrueFalseBlank.Enum r6);

    void addChecked(BigInteger bigInteger);

    void addColHidden(STTrueFalseBlank.Enum r6);

    void addColored(STTrueFalseBlank.Enum r6);

    void addColumn(BigInteger bigInteger);

    void addDDE(STTrueFalseBlank.Enum r6);

    void addDefault(STTrueFalseBlank.Enum r6);

    void addDefaultSize(STTrueFalseBlank.Enum r6);

    void addDisabled(STTrueFalseBlank.Enum r6);

    void addDismiss(STTrueFalseBlank.Enum r6);

    void addDropLines(BigInteger bigInteger);

    void addDropStyle(String str);

    void addDx(BigInteger bigInteger);

    void addFirstButton(STTrueFalseBlank.Enum r6);

    void addFmlaGroup(String str);

    void addFmlaLink(String str);

    void addFmlaMacro(String str);

    void addFmlaPict(String str);

    void addFmlaRange(String str);

    void addFmlaTxbx(String str);

    void addHelp(STTrueFalseBlank.Enum r6);

    void addHoriz(STTrueFalseBlank.Enum r6);

    void addInc(BigInteger bigInteger);

    void addJustLastX(STTrueFalseBlank.Enum r6);

    void addLCT(String str);

    void addListItem(String str);

    void addLockText(STTrueFalseBlank.Enum r6);

    void addLocked(STTrueFalseBlank.Enum r6);

    void addMapOCX(STTrueFalseBlank.Enum r6);

    void addMax(BigInteger bigInteger);

    void addMin(BigInteger bigInteger);

    void addMoveWithCells(STTrueFalseBlank.Enum r6);

    void addMultiLine(STTrueFalseBlank.Enum r6);

    void addMultiSel(String str);

    XmlInteger addNewAccel();

    XmlInteger addNewAccel2();

    XmlString addNewAnchor();

    STTrueFalseBlank addNewAutoFill();

    STTrueFalseBlank addNewAutoLine();

    STTrueFalseBlank addNewAutoPict();

    STTrueFalseBlank addNewAutoScale();

    STCF addNewCF();

    STTrueFalseBlank addNewCamera();

    STTrueFalseBlank addNewCancel();

    XmlInteger addNewChecked();

    STTrueFalseBlank addNewColHidden();

    STTrueFalseBlank addNewColored();

    XmlInteger addNewColumn();

    STTrueFalseBlank addNewDDE();

    STTrueFalseBlank addNewDefault();

    STTrueFalseBlank addNewDefaultSize();

    STTrueFalseBlank addNewDisabled();

    STTrueFalseBlank addNewDismiss();

    XmlInteger addNewDropLines();

    XmlString addNewDropStyle();

    XmlInteger addNewDx();

    STTrueFalseBlank addNewFirstButton();

    XmlString addNewFmlaGroup();

    XmlString addNewFmlaLink();

    XmlString addNewFmlaMacro();

    XmlString addNewFmlaPict();

    XmlString addNewFmlaRange();

    XmlString addNewFmlaTxbx();

    STTrueFalseBlank addNewHelp();

    STTrueFalseBlank addNewHoriz();

    XmlInteger addNewInc();

    STTrueFalseBlank addNewJustLastX();

    XmlString addNewLCT();

    XmlString addNewListItem();

    STTrueFalseBlank addNewLockText();

    STTrueFalseBlank addNewLocked();

    STTrueFalseBlank addNewMapOCX();

    XmlInteger addNewMax();

    XmlInteger addNewMin();

    STTrueFalseBlank addNewMoveWithCells();

    STTrueFalseBlank addNewMultiLine();

    XmlString addNewMultiSel();

    STTrueFalseBlank addNewNoThreeD();

    STTrueFalseBlank addNewNoThreeD2();

    XmlInteger addNewPage();

    STTrueFalseBlank addNewPrintObject();

    STTrueFalseBlank addNewRecalcAlways();

    XmlInteger addNewRow();

    STTrueFalseBlank addNewRowHidden();

    XmlString addNewScriptExtended();

    XmlNonNegativeInteger addNewScriptLanguage();

    XmlNonNegativeInteger addNewScriptLocation();

    XmlString addNewScriptText();

    STTrueFalseBlank addNewSecretEdit();

    XmlInteger addNewSel();

    XmlString addNewSelType();

    STTrueFalseBlank addNewSizeWithCells();

    XmlString addNewTextHAlign();

    XmlString addNewTextVAlign();

    STTrueFalseBlank addNewUIObj();

    STTrueFalseBlank addNewVScroll();

    XmlInteger addNewVTEdit();

    XmlInteger addNewVal();

    STTrueFalseBlank addNewValidIds();

    STTrueFalseBlank addNewVisible();

    XmlInteger addNewWidthMin();

    void addNoThreeD(STTrueFalseBlank.Enum r6);

    void addNoThreeD2(STTrueFalseBlank.Enum r6);

    void addPage(BigInteger bigInteger);

    void addPrintObject(STTrueFalseBlank.Enum r6);

    void addRecalcAlways(STTrueFalseBlank.Enum r6);

    void addRow(BigInteger bigInteger);

    void addRowHidden(STTrueFalseBlank.Enum r6);

    void addScriptExtended(String str);

    void addScriptLanguage(BigInteger bigInteger);

    void addScriptLocation(BigInteger bigInteger);

    void addScriptText(String str);

    void addSecretEdit(STTrueFalseBlank.Enum r6);

    void addSel(BigInteger bigInteger);

    void addSelType(String str);

    void addSizeWithCells(STTrueFalseBlank.Enum r6);

    void addTextHAlign(String str);

    void addTextVAlign(String str);

    void addUIObj(STTrueFalseBlank.Enum r6);

    void addVScroll(STTrueFalseBlank.Enum r6);

    void addVTEdit(BigInteger bigInteger);

    void addVal(BigInteger bigInteger);

    void addValidIds(STTrueFalseBlank.Enum r6);

    void addVisible(STTrueFalseBlank.Enum r6);

    void addWidthMin(BigInteger bigInteger);

    BigInteger getAccel2Array(int i5);

    BigInteger[] getAccel2Array();

    List<BigInteger> getAccel2List();

    BigInteger getAccelArray(int i5);

    BigInteger[] getAccelArray();

    List<BigInteger> getAccelList();

    String getAnchorArray(int i5);

    String[] getAnchorArray();

    List<String> getAnchorList();

    STTrueFalseBlank.Enum getAutoFillArray(int i5);

    STTrueFalseBlank.Enum[] getAutoFillArray();

    List<STTrueFalseBlank.Enum> getAutoFillList();

    STTrueFalseBlank.Enum getAutoLineArray(int i5);

    STTrueFalseBlank.Enum[] getAutoLineArray();

    List<STTrueFalseBlank.Enum> getAutoLineList();

    STTrueFalseBlank.Enum getAutoPictArray(int i5);

    STTrueFalseBlank.Enum[] getAutoPictArray();

    List<STTrueFalseBlank.Enum> getAutoPictList();

    STTrueFalseBlank.Enum getAutoScaleArray(int i5);

    STTrueFalseBlank.Enum[] getAutoScaleArray();

    List<STTrueFalseBlank.Enum> getAutoScaleList();

    String getCFArray(int i5);

    String[] getCFArray();

    List<String> getCFList();

    STTrueFalseBlank.Enum getCameraArray(int i5);

    STTrueFalseBlank.Enum[] getCameraArray();

    List<STTrueFalseBlank.Enum> getCameraList();

    STTrueFalseBlank.Enum getCancelArray(int i5);

    STTrueFalseBlank.Enum[] getCancelArray();

    List<STTrueFalseBlank.Enum> getCancelList();

    BigInteger getCheckedArray(int i5);

    BigInteger[] getCheckedArray();

    List<BigInteger> getCheckedList();

    STTrueFalseBlank.Enum getColHiddenArray(int i5);

    STTrueFalseBlank.Enum[] getColHiddenArray();

    List<STTrueFalseBlank.Enum> getColHiddenList();

    STTrueFalseBlank.Enum getColoredArray(int i5);

    STTrueFalseBlank.Enum[] getColoredArray();

    List<STTrueFalseBlank.Enum> getColoredList();

    BigInteger getColumnArray(int i5);

    BigInteger[] getColumnArray();

    List<BigInteger> getColumnList();

    STTrueFalseBlank.Enum getDDEArray(int i5);

    STTrueFalseBlank.Enum[] getDDEArray();

    List<STTrueFalseBlank.Enum> getDDEList();

    STTrueFalseBlank.Enum getDefaultArray(int i5);

    STTrueFalseBlank.Enum[] getDefaultArray();

    List<STTrueFalseBlank.Enum> getDefaultList();

    STTrueFalseBlank.Enum getDefaultSizeArray(int i5);

    STTrueFalseBlank.Enum[] getDefaultSizeArray();

    List<STTrueFalseBlank.Enum> getDefaultSizeList();

    STTrueFalseBlank.Enum getDisabledArray(int i5);

    STTrueFalseBlank.Enum[] getDisabledArray();

    List<STTrueFalseBlank.Enum> getDisabledList();

    STTrueFalseBlank.Enum getDismissArray(int i5);

    STTrueFalseBlank.Enum[] getDismissArray();

    List<STTrueFalseBlank.Enum> getDismissList();

    BigInteger getDropLinesArray(int i5);

    BigInteger[] getDropLinesArray();

    List<BigInteger> getDropLinesList();

    String getDropStyleArray(int i5);

    String[] getDropStyleArray();

    List<String> getDropStyleList();

    BigInteger getDxArray(int i5);

    BigInteger[] getDxArray();

    List<BigInteger> getDxList();

    STTrueFalseBlank.Enum getFirstButtonArray(int i5);

    STTrueFalseBlank.Enum[] getFirstButtonArray();

    List<STTrueFalseBlank.Enum> getFirstButtonList();

    String getFmlaGroupArray(int i5);

    String[] getFmlaGroupArray();

    List<String> getFmlaGroupList();

    String getFmlaLinkArray(int i5);

    String[] getFmlaLinkArray();

    List<String> getFmlaLinkList();

    String getFmlaMacroArray(int i5);

    String[] getFmlaMacroArray();

    List<String> getFmlaMacroList();

    String getFmlaPictArray(int i5);

    String[] getFmlaPictArray();

    List<String> getFmlaPictList();

    String getFmlaRangeArray(int i5);

    String[] getFmlaRangeArray();

    List<String> getFmlaRangeList();

    String getFmlaTxbxArray(int i5);

    String[] getFmlaTxbxArray();

    List<String> getFmlaTxbxList();

    STTrueFalseBlank.Enum getHelpArray(int i5);

    STTrueFalseBlank.Enum[] getHelpArray();

    List<STTrueFalseBlank.Enum> getHelpList();

    STTrueFalseBlank.Enum getHorizArray(int i5);

    STTrueFalseBlank.Enum[] getHorizArray();

    List<STTrueFalseBlank.Enum> getHorizList();

    BigInteger getIncArray(int i5);

    BigInteger[] getIncArray();

    List<BigInteger> getIncList();

    STTrueFalseBlank.Enum getJustLastXArray(int i5);

    STTrueFalseBlank.Enum[] getJustLastXArray();

    List<STTrueFalseBlank.Enum> getJustLastXList();

    String getLCTArray(int i5);

    String[] getLCTArray();

    List<String> getLCTList();

    String getListItemArray(int i5);

    String[] getListItemArray();

    List<String> getListItemList();

    STTrueFalseBlank.Enum getLockTextArray(int i5);

    STTrueFalseBlank.Enum[] getLockTextArray();

    List<STTrueFalseBlank.Enum> getLockTextList();

    STTrueFalseBlank.Enum getLockedArray(int i5);

    STTrueFalseBlank.Enum[] getLockedArray();

    List<STTrueFalseBlank.Enum> getLockedList();

    STTrueFalseBlank.Enum getMapOCXArray(int i5);

    STTrueFalseBlank.Enum[] getMapOCXArray();

    List<STTrueFalseBlank.Enum> getMapOCXList();

    BigInteger getMaxArray(int i5);

    BigInteger[] getMaxArray();

    List<BigInteger> getMaxList();

    BigInteger getMinArray(int i5);

    BigInteger[] getMinArray();

    List<BigInteger> getMinList();

    STTrueFalseBlank.Enum getMoveWithCellsArray(int i5);

    STTrueFalseBlank.Enum[] getMoveWithCellsArray();

    List<STTrueFalseBlank.Enum> getMoveWithCellsList();

    STTrueFalseBlank.Enum getMultiLineArray(int i5);

    STTrueFalseBlank.Enum[] getMultiLineArray();

    List<STTrueFalseBlank.Enum> getMultiLineList();

    String getMultiSelArray(int i5);

    String[] getMultiSelArray();

    List<String> getMultiSelList();

    STTrueFalseBlank.Enum getNoThreeD2Array(int i5);

    STTrueFalseBlank.Enum[] getNoThreeD2Array();

    List<STTrueFalseBlank.Enum> getNoThreeD2List();

    STTrueFalseBlank.Enum getNoThreeDArray(int i5);

    STTrueFalseBlank.Enum[] getNoThreeDArray();

    List<STTrueFalseBlank.Enum> getNoThreeDList();

    STObjectType.Enum getObjectType();

    BigInteger getPageArray(int i5);

    BigInteger[] getPageArray();

    List<BigInteger> getPageList();

    STTrueFalseBlank.Enum getPrintObjectArray(int i5);

    STTrueFalseBlank.Enum[] getPrintObjectArray();

    List<STTrueFalseBlank.Enum> getPrintObjectList();

    STTrueFalseBlank.Enum getRecalcAlwaysArray(int i5);

    STTrueFalseBlank.Enum[] getRecalcAlwaysArray();

    List<STTrueFalseBlank.Enum> getRecalcAlwaysList();

    BigInteger getRowArray(int i5);

    BigInteger[] getRowArray();

    STTrueFalseBlank.Enum getRowHiddenArray(int i5);

    STTrueFalseBlank.Enum[] getRowHiddenArray();

    List<STTrueFalseBlank.Enum> getRowHiddenList();

    List<BigInteger> getRowList();

    String getScriptExtendedArray(int i5);

    String[] getScriptExtendedArray();

    List<String> getScriptExtendedList();

    BigInteger getScriptLanguageArray(int i5);

    BigInteger[] getScriptLanguageArray();

    List<BigInteger> getScriptLanguageList();

    BigInteger getScriptLocationArray(int i5);

    BigInteger[] getScriptLocationArray();

    List<BigInteger> getScriptLocationList();

    String getScriptTextArray(int i5);

    String[] getScriptTextArray();

    List<String> getScriptTextList();

    STTrueFalseBlank.Enum getSecretEditArray(int i5);

    STTrueFalseBlank.Enum[] getSecretEditArray();

    List<STTrueFalseBlank.Enum> getSecretEditList();

    BigInteger getSelArray(int i5);

    BigInteger[] getSelArray();

    List<BigInteger> getSelList();

    String getSelTypeArray(int i5);

    String[] getSelTypeArray();

    List<String> getSelTypeList();

    STTrueFalseBlank.Enum getSizeWithCellsArray(int i5);

    STTrueFalseBlank.Enum[] getSizeWithCellsArray();

    List<STTrueFalseBlank.Enum> getSizeWithCellsList();

    String getTextHAlignArray(int i5);

    String[] getTextHAlignArray();

    List<String> getTextHAlignList();

    String getTextVAlignArray(int i5);

    String[] getTextVAlignArray();

    List<String> getTextVAlignList();

    STTrueFalseBlank.Enum getUIObjArray(int i5);

    STTrueFalseBlank.Enum[] getUIObjArray();

    List<STTrueFalseBlank.Enum> getUIObjList();

    STTrueFalseBlank.Enum getVScrollArray(int i5);

    STTrueFalseBlank.Enum[] getVScrollArray();

    List<STTrueFalseBlank.Enum> getVScrollList();

    BigInteger getVTEditArray(int i5);

    BigInteger[] getVTEditArray();

    List<BigInteger> getVTEditList();

    BigInteger getValArray(int i5);

    BigInteger[] getValArray();

    List<BigInteger> getValList();

    STTrueFalseBlank.Enum getValidIdsArray(int i5);

    STTrueFalseBlank.Enum[] getValidIdsArray();

    List<STTrueFalseBlank.Enum> getValidIdsList();

    STTrueFalseBlank.Enum getVisibleArray(int i5);

    STTrueFalseBlank.Enum[] getVisibleArray();

    List<STTrueFalseBlank.Enum> getVisibleList();

    BigInteger getWidthMinArray(int i5);

    BigInteger[] getWidthMinArray();

    List<BigInteger> getWidthMinList();

    void insertAccel(int i5, BigInteger bigInteger);

    void insertAccel2(int i5, BigInteger bigInteger);

    void insertAnchor(int i5, String str);

    void insertAutoFill(int i5, STTrueFalseBlank.Enum r6);

    void insertAutoLine(int i5, STTrueFalseBlank.Enum r6);

    void insertAutoPict(int i5, STTrueFalseBlank.Enum r6);

    void insertAutoScale(int i5, STTrueFalseBlank.Enum r6);

    void insertCF(int i5, String str);

    void insertCamera(int i5, STTrueFalseBlank.Enum r6);

    void insertCancel(int i5, STTrueFalseBlank.Enum r6);

    void insertChecked(int i5, BigInteger bigInteger);

    void insertColHidden(int i5, STTrueFalseBlank.Enum r6);

    void insertColored(int i5, STTrueFalseBlank.Enum r6);

    void insertColumn(int i5, BigInteger bigInteger);

    void insertDDE(int i5, STTrueFalseBlank.Enum r6);

    void insertDefault(int i5, STTrueFalseBlank.Enum r6);

    void insertDefaultSize(int i5, STTrueFalseBlank.Enum r6);

    void insertDisabled(int i5, STTrueFalseBlank.Enum r6);

    void insertDismiss(int i5, STTrueFalseBlank.Enum r6);

    void insertDropLines(int i5, BigInteger bigInteger);

    void insertDropStyle(int i5, String str);

    void insertDx(int i5, BigInteger bigInteger);

    void insertFirstButton(int i5, STTrueFalseBlank.Enum r6);

    void insertFmlaGroup(int i5, String str);

    void insertFmlaLink(int i5, String str);

    void insertFmlaMacro(int i5, String str);

    void insertFmlaPict(int i5, String str);

    void insertFmlaRange(int i5, String str);

    void insertFmlaTxbx(int i5, String str);

    void insertHelp(int i5, STTrueFalseBlank.Enum r6);

    void insertHoriz(int i5, STTrueFalseBlank.Enum r6);

    void insertInc(int i5, BigInteger bigInteger);

    void insertJustLastX(int i5, STTrueFalseBlank.Enum r6);

    void insertLCT(int i5, String str);

    void insertListItem(int i5, String str);

    void insertLockText(int i5, STTrueFalseBlank.Enum r6);

    void insertLocked(int i5, STTrueFalseBlank.Enum r6);

    void insertMapOCX(int i5, STTrueFalseBlank.Enum r6);

    void insertMax(int i5, BigInteger bigInteger);

    void insertMin(int i5, BigInteger bigInteger);

    void insertMoveWithCells(int i5, STTrueFalseBlank.Enum r6);

    void insertMultiLine(int i5, STTrueFalseBlank.Enum r6);

    void insertMultiSel(int i5, String str);

    XmlInteger insertNewAccel(int i5);

    XmlInteger insertNewAccel2(int i5);

    XmlString insertNewAnchor(int i5);

    STTrueFalseBlank insertNewAutoFill(int i5);

    STTrueFalseBlank insertNewAutoLine(int i5);

    STTrueFalseBlank insertNewAutoPict(int i5);

    STTrueFalseBlank insertNewAutoScale(int i5);

    STCF insertNewCF(int i5);

    STTrueFalseBlank insertNewCamera(int i5);

    STTrueFalseBlank insertNewCancel(int i5);

    XmlInteger insertNewChecked(int i5);

    STTrueFalseBlank insertNewColHidden(int i5);

    STTrueFalseBlank insertNewColored(int i5);

    XmlInteger insertNewColumn(int i5);

    STTrueFalseBlank insertNewDDE(int i5);

    STTrueFalseBlank insertNewDefault(int i5);

    STTrueFalseBlank insertNewDefaultSize(int i5);

    STTrueFalseBlank insertNewDisabled(int i5);

    STTrueFalseBlank insertNewDismiss(int i5);

    XmlInteger insertNewDropLines(int i5);

    XmlString insertNewDropStyle(int i5);

    XmlInteger insertNewDx(int i5);

    STTrueFalseBlank insertNewFirstButton(int i5);

    XmlString insertNewFmlaGroup(int i5);

    XmlString insertNewFmlaLink(int i5);

    XmlString insertNewFmlaMacro(int i5);

    XmlString insertNewFmlaPict(int i5);

    XmlString insertNewFmlaRange(int i5);

    XmlString insertNewFmlaTxbx(int i5);

    STTrueFalseBlank insertNewHelp(int i5);

    STTrueFalseBlank insertNewHoriz(int i5);

    XmlInteger insertNewInc(int i5);

    STTrueFalseBlank insertNewJustLastX(int i5);

    XmlString insertNewLCT(int i5);

    XmlString insertNewListItem(int i5);

    STTrueFalseBlank insertNewLockText(int i5);

    STTrueFalseBlank insertNewLocked(int i5);

    STTrueFalseBlank insertNewMapOCX(int i5);

    XmlInteger insertNewMax(int i5);

    XmlInteger insertNewMin(int i5);

    STTrueFalseBlank insertNewMoveWithCells(int i5);

    STTrueFalseBlank insertNewMultiLine(int i5);

    XmlString insertNewMultiSel(int i5);

    STTrueFalseBlank insertNewNoThreeD(int i5);

    STTrueFalseBlank insertNewNoThreeD2(int i5);

    XmlInteger insertNewPage(int i5);

    STTrueFalseBlank insertNewPrintObject(int i5);

    STTrueFalseBlank insertNewRecalcAlways(int i5);

    XmlInteger insertNewRow(int i5);

    STTrueFalseBlank insertNewRowHidden(int i5);

    XmlString insertNewScriptExtended(int i5);

    XmlNonNegativeInteger insertNewScriptLanguage(int i5);

    XmlNonNegativeInteger insertNewScriptLocation(int i5);

    XmlString insertNewScriptText(int i5);

    STTrueFalseBlank insertNewSecretEdit(int i5);

    XmlInteger insertNewSel(int i5);

    XmlString insertNewSelType(int i5);

    STTrueFalseBlank insertNewSizeWithCells(int i5);

    XmlString insertNewTextHAlign(int i5);

    XmlString insertNewTextVAlign(int i5);

    STTrueFalseBlank insertNewUIObj(int i5);

    STTrueFalseBlank insertNewVScroll(int i5);

    XmlInteger insertNewVTEdit(int i5);

    XmlInteger insertNewVal(int i5);

    STTrueFalseBlank insertNewValidIds(int i5);

    STTrueFalseBlank insertNewVisible(int i5);

    XmlInteger insertNewWidthMin(int i5);

    void insertNoThreeD(int i5, STTrueFalseBlank.Enum r6);

    void insertNoThreeD2(int i5, STTrueFalseBlank.Enum r6);

    void insertPage(int i5, BigInteger bigInteger);

    void insertPrintObject(int i5, STTrueFalseBlank.Enum r6);

    void insertRecalcAlways(int i5, STTrueFalseBlank.Enum r6);

    void insertRow(int i5, BigInteger bigInteger);

    void insertRowHidden(int i5, STTrueFalseBlank.Enum r6);

    void insertScriptExtended(int i5, String str);

    void insertScriptLanguage(int i5, BigInteger bigInteger);

    void insertScriptLocation(int i5, BigInteger bigInteger);

    void insertScriptText(int i5, String str);

    void insertSecretEdit(int i5, STTrueFalseBlank.Enum r6);

    void insertSel(int i5, BigInteger bigInteger);

    void insertSelType(int i5, String str);

    void insertSizeWithCells(int i5, STTrueFalseBlank.Enum r6);

    void insertTextHAlign(int i5, String str);

    void insertTextVAlign(int i5, String str);

    void insertUIObj(int i5, STTrueFalseBlank.Enum r6);

    void insertVScroll(int i5, STTrueFalseBlank.Enum r6);

    void insertVTEdit(int i5, BigInteger bigInteger);

    void insertVal(int i5, BigInteger bigInteger);

    void insertValidIds(int i5, STTrueFalseBlank.Enum r6);

    void insertVisible(int i5, STTrueFalseBlank.Enum r6);

    void insertWidthMin(int i5, BigInteger bigInteger);

    void removeAccel(int i5);

    void removeAccel2(int i5);

    void removeAnchor(int i5);

    void removeAutoFill(int i5);

    void removeAutoLine(int i5);

    void removeAutoPict(int i5);

    void removeAutoScale(int i5);

    void removeCF(int i5);

    void removeCamera(int i5);

    void removeCancel(int i5);

    void removeChecked(int i5);

    void removeColHidden(int i5);

    void removeColored(int i5);

    void removeColumn(int i5);

    void removeDDE(int i5);

    void removeDefault(int i5);

    void removeDefaultSize(int i5);

    void removeDisabled(int i5);

    void removeDismiss(int i5);

    void removeDropLines(int i5);

    void removeDropStyle(int i5);

    void removeDx(int i5);

    void removeFirstButton(int i5);

    void removeFmlaGroup(int i5);

    void removeFmlaLink(int i5);

    void removeFmlaMacro(int i5);

    void removeFmlaPict(int i5);

    void removeFmlaRange(int i5);

    void removeFmlaTxbx(int i5);

    void removeHelp(int i5);

    void removeHoriz(int i5);

    void removeInc(int i5);

    void removeJustLastX(int i5);

    void removeLCT(int i5);

    void removeListItem(int i5);

    void removeLockText(int i5);

    void removeLocked(int i5);

    void removeMapOCX(int i5);

    void removeMax(int i5);

    void removeMin(int i5);

    void removeMoveWithCells(int i5);

    void removeMultiLine(int i5);

    void removeMultiSel(int i5);

    void removeNoThreeD(int i5);

    void removeNoThreeD2(int i5);

    void removePage(int i5);

    void removePrintObject(int i5);

    void removeRecalcAlways(int i5);

    void removeRow(int i5);

    void removeRowHidden(int i5);

    void removeScriptExtended(int i5);

    void removeScriptLanguage(int i5);

    void removeScriptLocation(int i5);

    void removeScriptText(int i5);

    void removeSecretEdit(int i5);

    void removeSel(int i5);

    void removeSelType(int i5);

    void removeSizeWithCells(int i5);

    void removeTextHAlign(int i5);

    void removeTextVAlign(int i5);

    void removeUIObj(int i5);

    void removeVScroll(int i5);

    void removeVTEdit(int i5);

    void removeVal(int i5);

    void removeValidIds(int i5);

    void removeVisible(int i5);

    void removeWidthMin(int i5);

    void setAccel2Array(int i5, BigInteger bigInteger);

    void setAccel2Array(BigInteger[] bigIntegerArr);

    void setAccelArray(int i5, BigInteger bigInteger);

    void setAccelArray(BigInteger[] bigIntegerArr);

    void setAnchorArray(int i5, String str);

    void setAnchorArray(String[] strArr);

    void setAutoFillArray(int i5, STTrueFalseBlank.Enum r6);

    void setAutoFillArray(STTrueFalseBlank.Enum[] enumArr);

    void setAutoLineArray(int i5, STTrueFalseBlank.Enum r6);

    void setAutoLineArray(STTrueFalseBlank.Enum[] enumArr);

    void setAutoPictArray(int i5, STTrueFalseBlank.Enum r6);

    void setAutoPictArray(STTrueFalseBlank.Enum[] enumArr);

    void setAutoScaleArray(int i5, STTrueFalseBlank.Enum r6);

    void setAutoScaleArray(STTrueFalseBlank.Enum[] enumArr);

    void setCFArray(int i5, String str);

    void setCFArray(String[] strArr);

    void setCameraArray(int i5, STTrueFalseBlank.Enum r6);

    void setCameraArray(STTrueFalseBlank.Enum[] enumArr);

    void setCancelArray(int i5, STTrueFalseBlank.Enum r6);

    void setCancelArray(STTrueFalseBlank.Enum[] enumArr);

    void setCheckedArray(int i5, BigInteger bigInteger);

    void setCheckedArray(BigInteger[] bigIntegerArr);

    void setColHiddenArray(int i5, STTrueFalseBlank.Enum r6);

    void setColHiddenArray(STTrueFalseBlank.Enum[] enumArr);

    void setColoredArray(int i5, STTrueFalseBlank.Enum r6);

    void setColoredArray(STTrueFalseBlank.Enum[] enumArr);

    void setColumnArray(int i5, BigInteger bigInteger);

    void setColumnArray(BigInteger[] bigIntegerArr);

    void setDDEArray(int i5, STTrueFalseBlank.Enum r6);

    void setDDEArray(STTrueFalseBlank.Enum[] enumArr);

    void setDefaultArray(int i5, STTrueFalseBlank.Enum r6);

    void setDefaultArray(STTrueFalseBlank.Enum[] enumArr);

    void setDefaultSizeArray(int i5, STTrueFalseBlank.Enum r6);

    void setDefaultSizeArray(STTrueFalseBlank.Enum[] enumArr);

    void setDisabledArray(int i5, STTrueFalseBlank.Enum r6);

    void setDisabledArray(STTrueFalseBlank.Enum[] enumArr);

    void setDismissArray(int i5, STTrueFalseBlank.Enum r6);

    void setDismissArray(STTrueFalseBlank.Enum[] enumArr);

    void setDropLinesArray(int i5, BigInteger bigInteger);

    void setDropLinesArray(BigInteger[] bigIntegerArr);

    void setDropStyleArray(int i5, String str);

    void setDropStyleArray(String[] strArr);

    void setDxArray(int i5, BigInteger bigInteger);

    void setDxArray(BigInteger[] bigIntegerArr);

    void setFirstButtonArray(int i5, STTrueFalseBlank.Enum r6);

    void setFirstButtonArray(STTrueFalseBlank.Enum[] enumArr);

    void setFmlaGroupArray(int i5, String str);

    void setFmlaGroupArray(String[] strArr);

    void setFmlaLinkArray(int i5, String str);

    void setFmlaLinkArray(String[] strArr);

    void setFmlaMacroArray(int i5, String str);

    void setFmlaMacroArray(String[] strArr);

    void setFmlaPictArray(int i5, String str);

    void setFmlaPictArray(String[] strArr);

    void setFmlaRangeArray(int i5, String str);

    void setFmlaRangeArray(String[] strArr);

    void setFmlaTxbxArray(int i5, String str);

    void setFmlaTxbxArray(String[] strArr);

    void setHelpArray(int i5, STTrueFalseBlank.Enum r6);

    void setHelpArray(STTrueFalseBlank.Enum[] enumArr);

    void setHorizArray(int i5, STTrueFalseBlank.Enum r6);

    void setHorizArray(STTrueFalseBlank.Enum[] enumArr);

    void setIncArray(int i5, BigInteger bigInteger);

    void setIncArray(BigInteger[] bigIntegerArr);

    void setJustLastXArray(int i5, STTrueFalseBlank.Enum r6);

    void setJustLastXArray(STTrueFalseBlank.Enum[] enumArr);

    void setLCTArray(int i5, String str);

    void setLCTArray(String[] strArr);

    void setListItemArray(int i5, String str);

    void setListItemArray(String[] strArr);

    void setLockTextArray(int i5, STTrueFalseBlank.Enum r6);

    void setLockTextArray(STTrueFalseBlank.Enum[] enumArr);

    void setLockedArray(int i5, STTrueFalseBlank.Enum r6);

    void setLockedArray(STTrueFalseBlank.Enum[] enumArr);

    void setMapOCXArray(int i5, STTrueFalseBlank.Enum r6);

    void setMapOCXArray(STTrueFalseBlank.Enum[] enumArr);

    void setMaxArray(int i5, BigInteger bigInteger);

    void setMaxArray(BigInteger[] bigIntegerArr);

    void setMinArray(int i5, BigInteger bigInteger);

    void setMinArray(BigInteger[] bigIntegerArr);

    void setMoveWithCellsArray(int i5, STTrueFalseBlank.Enum r6);

    void setMoveWithCellsArray(STTrueFalseBlank.Enum[] enumArr);

    void setMultiLineArray(int i5, STTrueFalseBlank.Enum r6);

    void setMultiLineArray(STTrueFalseBlank.Enum[] enumArr);

    void setMultiSelArray(int i5, String str);

    void setMultiSelArray(String[] strArr);

    void setNoThreeD2Array(int i5, STTrueFalseBlank.Enum r6);

    void setNoThreeD2Array(STTrueFalseBlank.Enum[] enumArr);

    void setNoThreeDArray(int i5, STTrueFalseBlank.Enum r6);

    void setNoThreeDArray(STTrueFalseBlank.Enum[] enumArr);

    void setObjectType(STObjectType.Enum r6);

    void setPageArray(int i5, BigInteger bigInteger);

    void setPageArray(BigInteger[] bigIntegerArr);

    void setPrintObjectArray(int i5, STTrueFalseBlank.Enum r6);

    void setPrintObjectArray(STTrueFalseBlank.Enum[] enumArr);

    void setRecalcAlwaysArray(int i5, STTrueFalseBlank.Enum r6);

    void setRecalcAlwaysArray(STTrueFalseBlank.Enum[] enumArr);

    void setRowArray(int i5, BigInteger bigInteger);

    void setRowArray(BigInteger[] bigIntegerArr);

    void setRowHiddenArray(int i5, STTrueFalseBlank.Enum r6);

    void setRowHiddenArray(STTrueFalseBlank.Enum[] enumArr);

    void setScriptExtendedArray(int i5, String str);

    void setScriptExtendedArray(String[] strArr);

    void setScriptLanguageArray(int i5, BigInteger bigInteger);

    void setScriptLanguageArray(BigInteger[] bigIntegerArr);

    void setScriptLocationArray(int i5, BigInteger bigInteger);

    void setScriptLocationArray(BigInteger[] bigIntegerArr);

    void setScriptTextArray(int i5, String str);

    void setScriptTextArray(String[] strArr);

    void setSecretEditArray(int i5, STTrueFalseBlank.Enum r6);

    void setSecretEditArray(STTrueFalseBlank.Enum[] enumArr);

    void setSelArray(int i5, BigInteger bigInteger);

    void setSelArray(BigInteger[] bigIntegerArr);

    void setSelTypeArray(int i5, String str);

    void setSelTypeArray(String[] strArr);

    void setSizeWithCellsArray(int i5, STTrueFalseBlank.Enum r6);

    void setSizeWithCellsArray(STTrueFalseBlank.Enum[] enumArr);

    void setTextHAlignArray(int i5, String str);

    void setTextHAlignArray(String[] strArr);

    void setTextVAlignArray(int i5, String str);

    void setTextVAlignArray(String[] strArr);

    void setUIObjArray(int i5, STTrueFalseBlank.Enum r6);

    void setUIObjArray(STTrueFalseBlank.Enum[] enumArr);

    void setVScrollArray(int i5, STTrueFalseBlank.Enum r6);

    void setVScrollArray(STTrueFalseBlank.Enum[] enumArr);

    void setVTEditArray(int i5, BigInteger bigInteger);

    void setVTEditArray(BigInteger[] bigIntegerArr);

    void setValArray(int i5, BigInteger bigInteger);

    void setValArray(BigInteger[] bigIntegerArr);

    void setValidIdsArray(int i5, STTrueFalseBlank.Enum r6);

    void setValidIdsArray(STTrueFalseBlank.Enum[] enumArr);

    void setVisibleArray(int i5, STTrueFalseBlank.Enum r6);

    void setVisibleArray(STTrueFalseBlank.Enum[] enumArr);

    void setWidthMinArray(int i5, BigInteger bigInteger);

    void setWidthMinArray(BigInteger[] bigIntegerArr);

    int sizeOfAccel2Array();

    int sizeOfAccelArray();

    int sizeOfAnchorArray();

    int sizeOfAutoFillArray();

    int sizeOfAutoLineArray();

    int sizeOfAutoPictArray();

    int sizeOfAutoScaleArray();

    int sizeOfCFArray();

    int sizeOfCameraArray();

    int sizeOfCancelArray();

    int sizeOfCheckedArray();

    int sizeOfColHiddenArray();

    int sizeOfColoredArray();

    int sizeOfColumnArray();

    int sizeOfDDEArray();

    int sizeOfDefaultArray();

    int sizeOfDefaultSizeArray();

    int sizeOfDisabledArray();

    int sizeOfDismissArray();

    int sizeOfDropLinesArray();

    int sizeOfDropStyleArray();

    int sizeOfDxArray();

    int sizeOfFirstButtonArray();

    int sizeOfFmlaGroupArray();

    int sizeOfFmlaLinkArray();

    int sizeOfFmlaMacroArray();

    int sizeOfFmlaPictArray();

    int sizeOfFmlaRangeArray();

    int sizeOfFmlaTxbxArray();

    int sizeOfHelpArray();

    int sizeOfHorizArray();

    int sizeOfIncArray();

    int sizeOfJustLastXArray();

    int sizeOfLCTArray();

    int sizeOfListItemArray();

    int sizeOfLockTextArray();

    int sizeOfLockedArray();

    int sizeOfMapOCXArray();

    int sizeOfMaxArray();

    int sizeOfMinArray();

    int sizeOfMoveWithCellsArray();

    int sizeOfMultiLineArray();

    int sizeOfMultiSelArray();

    int sizeOfNoThreeD2Array();

    int sizeOfNoThreeDArray();

    int sizeOfPageArray();

    int sizeOfPrintObjectArray();

    int sizeOfRecalcAlwaysArray();

    int sizeOfRowArray();

    int sizeOfRowHiddenArray();

    int sizeOfScriptExtendedArray();

    int sizeOfScriptLanguageArray();

    int sizeOfScriptLocationArray();

    int sizeOfScriptTextArray();

    int sizeOfSecretEditArray();

    int sizeOfSelArray();

    int sizeOfSelTypeArray();

    int sizeOfSizeWithCellsArray();

    int sizeOfTextHAlignArray();

    int sizeOfTextVAlignArray();

    int sizeOfUIObjArray();

    int sizeOfVScrollArray();

    int sizeOfVTEditArray();

    int sizeOfValArray();

    int sizeOfValidIdsArray();

    int sizeOfVisibleArray();

    int sizeOfWidthMinArray();

    XmlInteger xgetAccel2Array(int i5);

    XmlInteger[] xgetAccel2Array();

    List<XmlInteger> xgetAccel2List();

    XmlInteger xgetAccelArray(int i5);

    XmlInteger[] xgetAccelArray();

    List<XmlInteger> xgetAccelList();

    XmlString xgetAnchorArray(int i5);

    XmlString[] xgetAnchorArray();

    List<XmlString> xgetAnchorList();

    STTrueFalseBlank xgetAutoFillArray(int i5);

    STTrueFalseBlank[] xgetAutoFillArray();

    List<STTrueFalseBlank> xgetAutoFillList();

    STTrueFalseBlank xgetAutoLineArray(int i5);

    STTrueFalseBlank[] xgetAutoLineArray();

    List<STTrueFalseBlank> xgetAutoLineList();

    STTrueFalseBlank xgetAutoPictArray(int i5);

    STTrueFalseBlank[] xgetAutoPictArray();

    List<STTrueFalseBlank> xgetAutoPictList();

    STTrueFalseBlank xgetAutoScaleArray(int i5);

    STTrueFalseBlank[] xgetAutoScaleArray();

    List<STTrueFalseBlank> xgetAutoScaleList();

    STCF xgetCFArray(int i5);

    STCF[] xgetCFArray();

    List<STCF> xgetCFList();

    STTrueFalseBlank xgetCameraArray(int i5);

    STTrueFalseBlank[] xgetCameraArray();

    List<STTrueFalseBlank> xgetCameraList();

    STTrueFalseBlank xgetCancelArray(int i5);

    STTrueFalseBlank[] xgetCancelArray();

    List<STTrueFalseBlank> xgetCancelList();

    XmlInteger xgetCheckedArray(int i5);

    XmlInteger[] xgetCheckedArray();

    List<XmlInteger> xgetCheckedList();

    STTrueFalseBlank xgetColHiddenArray(int i5);

    STTrueFalseBlank[] xgetColHiddenArray();

    List<STTrueFalseBlank> xgetColHiddenList();

    STTrueFalseBlank xgetColoredArray(int i5);

    STTrueFalseBlank[] xgetColoredArray();

    List<STTrueFalseBlank> xgetColoredList();

    XmlInteger xgetColumnArray(int i5);

    XmlInteger[] xgetColumnArray();

    List<XmlInteger> xgetColumnList();

    STTrueFalseBlank xgetDDEArray(int i5);

    STTrueFalseBlank[] xgetDDEArray();

    List<STTrueFalseBlank> xgetDDEList();

    STTrueFalseBlank xgetDefaultArray(int i5);

    STTrueFalseBlank[] xgetDefaultArray();

    List<STTrueFalseBlank> xgetDefaultList();

    STTrueFalseBlank xgetDefaultSizeArray(int i5);

    STTrueFalseBlank[] xgetDefaultSizeArray();

    List<STTrueFalseBlank> xgetDefaultSizeList();

    STTrueFalseBlank xgetDisabledArray(int i5);

    STTrueFalseBlank[] xgetDisabledArray();

    List<STTrueFalseBlank> xgetDisabledList();

    STTrueFalseBlank xgetDismissArray(int i5);

    STTrueFalseBlank[] xgetDismissArray();

    List<STTrueFalseBlank> xgetDismissList();

    XmlInteger xgetDropLinesArray(int i5);

    XmlInteger[] xgetDropLinesArray();

    List<XmlInteger> xgetDropLinesList();

    XmlString xgetDropStyleArray(int i5);

    XmlString[] xgetDropStyleArray();

    List<XmlString> xgetDropStyleList();

    XmlInteger xgetDxArray(int i5);

    XmlInteger[] xgetDxArray();

    List<XmlInteger> xgetDxList();

    STTrueFalseBlank xgetFirstButtonArray(int i5);

    STTrueFalseBlank[] xgetFirstButtonArray();

    List<STTrueFalseBlank> xgetFirstButtonList();

    XmlString xgetFmlaGroupArray(int i5);

    XmlString[] xgetFmlaGroupArray();

    List<XmlString> xgetFmlaGroupList();

    XmlString xgetFmlaLinkArray(int i5);

    XmlString[] xgetFmlaLinkArray();

    List<XmlString> xgetFmlaLinkList();

    XmlString xgetFmlaMacroArray(int i5);

    XmlString[] xgetFmlaMacroArray();

    List<XmlString> xgetFmlaMacroList();

    XmlString xgetFmlaPictArray(int i5);

    XmlString[] xgetFmlaPictArray();

    List<XmlString> xgetFmlaPictList();

    XmlString xgetFmlaRangeArray(int i5);

    XmlString[] xgetFmlaRangeArray();

    List<XmlString> xgetFmlaRangeList();

    XmlString xgetFmlaTxbxArray(int i5);

    XmlString[] xgetFmlaTxbxArray();

    List<XmlString> xgetFmlaTxbxList();

    STTrueFalseBlank xgetHelpArray(int i5);

    STTrueFalseBlank[] xgetHelpArray();

    List<STTrueFalseBlank> xgetHelpList();

    STTrueFalseBlank xgetHorizArray(int i5);

    STTrueFalseBlank[] xgetHorizArray();

    List<STTrueFalseBlank> xgetHorizList();

    XmlInteger xgetIncArray(int i5);

    XmlInteger[] xgetIncArray();

    List<XmlInteger> xgetIncList();

    STTrueFalseBlank xgetJustLastXArray(int i5);

    STTrueFalseBlank[] xgetJustLastXArray();

    List<STTrueFalseBlank> xgetJustLastXList();

    XmlString xgetLCTArray(int i5);

    XmlString[] xgetLCTArray();

    List<XmlString> xgetLCTList();

    XmlString xgetListItemArray(int i5);

    XmlString[] xgetListItemArray();

    List<XmlString> xgetListItemList();

    STTrueFalseBlank xgetLockTextArray(int i5);

    STTrueFalseBlank[] xgetLockTextArray();

    List<STTrueFalseBlank> xgetLockTextList();

    STTrueFalseBlank xgetLockedArray(int i5);

    STTrueFalseBlank[] xgetLockedArray();

    List<STTrueFalseBlank> xgetLockedList();

    STTrueFalseBlank xgetMapOCXArray(int i5);

    STTrueFalseBlank[] xgetMapOCXArray();

    List<STTrueFalseBlank> xgetMapOCXList();

    XmlInteger xgetMaxArray(int i5);

    XmlInteger[] xgetMaxArray();

    List<XmlInteger> xgetMaxList();

    XmlInteger xgetMinArray(int i5);

    XmlInteger[] xgetMinArray();

    List<XmlInteger> xgetMinList();

    STTrueFalseBlank xgetMoveWithCellsArray(int i5);

    STTrueFalseBlank[] xgetMoveWithCellsArray();

    List<STTrueFalseBlank> xgetMoveWithCellsList();

    STTrueFalseBlank xgetMultiLineArray(int i5);

    STTrueFalseBlank[] xgetMultiLineArray();

    List<STTrueFalseBlank> xgetMultiLineList();

    XmlString xgetMultiSelArray(int i5);

    XmlString[] xgetMultiSelArray();

    List<XmlString> xgetMultiSelList();

    STTrueFalseBlank xgetNoThreeD2Array(int i5);

    STTrueFalseBlank[] xgetNoThreeD2Array();

    List<STTrueFalseBlank> xgetNoThreeD2List();

    STTrueFalseBlank xgetNoThreeDArray(int i5);

    STTrueFalseBlank[] xgetNoThreeDArray();

    List<STTrueFalseBlank> xgetNoThreeDList();

    STObjectType xgetObjectType();

    XmlInteger xgetPageArray(int i5);

    XmlInteger[] xgetPageArray();

    List<XmlInteger> xgetPageList();

    STTrueFalseBlank xgetPrintObjectArray(int i5);

    STTrueFalseBlank[] xgetPrintObjectArray();

    List<STTrueFalseBlank> xgetPrintObjectList();

    STTrueFalseBlank xgetRecalcAlwaysArray(int i5);

    STTrueFalseBlank[] xgetRecalcAlwaysArray();

    List<STTrueFalseBlank> xgetRecalcAlwaysList();

    XmlInteger xgetRowArray(int i5);

    XmlInteger[] xgetRowArray();

    STTrueFalseBlank xgetRowHiddenArray(int i5);

    STTrueFalseBlank[] xgetRowHiddenArray();

    List<STTrueFalseBlank> xgetRowHiddenList();

    List<XmlInteger> xgetRowList();

    XmlString xgetScriptExtendedArray(int i5);

    XmlString[] xgetScriptExtendedArray();

    List<XmlString> xgetScriptExtendedList();

    XmlNonNegativeInteger xgetScriptLanguageArray(int i5);

    XmlNonNegativeInteger[] xgetScriptLanguageArray();

    List<XmlNonNegativeInteger> xgetScriptLanguageList();

    XmlNonNegativeInteger xgetScriptLocationArray(int i5);

    XmlNonNegativeInteger[] xgetScriptLocationArray();

    List<XmlNonNegativeInteger> xgetScriptLocationList();

    XmlString xgetScriptTextArray(int i5);

    XmlString[] xgetScriptTextArray();

    List<XmlString> xgetScriptTextList();

    STTrueFalseBlank xgetSecretEditArray(int i5);

    STTrueFalseBlank[] xgetSecretEditArray();

    List<STTrueFalseBlank> xgetSecretEditList();

    XmlInteger xgetSelArray(int i5);

    XmlInteger[] xgetSelArray();

    List<XmlInteger> xgetSelList();

    XmlString xgetSelTypeArray(int i5);

    XmlString[] xgetSelTypeArray();

    List<XmlString> xgetSelTypeList();

    STTrueFalseBlank xgetSizeWithCellsArray(int i5);

    STTrueFalseBlank[] xgetSizeWithCellsArray();

    List<STTrueFalseBlank> xgetSizeWithCellsList();

    XmlString xgetTextHAlignArray(int i5);

    XmlString[] xgetTextHAlignArray();

    List<XmlString> xgetTextHAlignList();

    XmlString xgetTextVAlignArray(int i5);

    XmlString[] xgetTextVAlignArray();

    List<XmlString> xgetTextVAlignList();

    STTrueFalseBlank xgetUIObjArray(int i5);

    STTrueFalseBlank[] xgetUIObjArray();

    List<STTrueFalseBlank> xgetUIObjList();

    STTrueFalseBlank xgetVScrollArray(int i5);

    STTrueFalseBlank[] xgetVScrollArray();

    List<STTrueFalseBlank> xgetVScrollList();

    XmlInteger xgetVTEditArray(int i5);

    XmlInteger[] xgetVTEditArray();

    List<XmlInteger> xgetVTEditList();

    XmlInteger xgetValArray(int i5);

    XmlInteger[] xgetValArray();

    List<XmlInteger> xgetValList();

    STTrueFalseBlank xgetValidIdsArray(int i5);

    STTrueFalseBlank[] xgetValidIdsArray();

    List<STTrueFalseBlank> xgetValidIdsList();

    STTrueFalseBlank xgetVisibleArray(int i5);

    STTrueFalseBlank[] xgetVisibleArray();

    List<STTrueFalseBlank> xgetVisibleList();

    XmlInteger xgetWidthMinArray(int i5);

    XmlInteger[] xgetWidthMinArray();

    List<XmlInteger> xgetWidthMinList();

    void xsetAccel2Array(int i5, XmlInteger xmlInteger);

    void xsetAccel2Array(XmlInteger[] xmlIntegerArr);

    void xsetAccelArray(int i5, XmlInteger xmlInteger);

    void xsetAccelArray(XmlInteger[] xmlIntegerArr);

    void xsetAnchorArray(int i5, XmlString xmlString);

    void xsetAnchorArray(XmlString[] xmlStringArr);

    void xsetAutoFillArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetAutoFillArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetAutoLineArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetAutoLineArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetAutoPictArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetAutoPictArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetAutoScaleArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetAutoScaleArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetCFArray(int i5, STCF stcf);

    void xsetCFArray(STCF[] stcfArr);

    void xsetCameraArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetCameraArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetCancelArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetCancelArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetCheckedArray(int i5, XmlInteger xmlInteger);

    void xsetCheckedArray(XmlInteger[] xmlIntegerArr);

    void xsetColHiddenArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetColHiddenArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetColoredArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetColoredArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetColumnArray(int i5, XmlInteger xmlInteger);

    void xsetColumnArray(XmlInteger[] xmlIntegerArr);

    void xsetDDEArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetDDEArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetDefaultArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetDefaultArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetDefaultSizeArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetDefaultSizeArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetDisabledArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetDisabledArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetDismissArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetDismissArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetDropLinesArray(int i5, XmlInteger xmlInteger);

    void xsetDropLinesArray(XmlInteger[] xmlIntegerArr);

    void xsetDropStyleArray(int i5, XmlString xmlString);

    void xsetDropStyleArray(XmlString[] xmlStringArr);

    void xsetDxArray(int i5, XmlInteger xmlInteger);

    void xsetDxArray(XmlInteger[] xmlIntegerArr);

    void xsetFirstButtonArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetFirstButtonArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetFmlaGroupArray(int i5, XmlString xmlString);

    void xsetFmlaGroupArray(XmlString[] xmlStringArr);

    void xsetFmlaLinkArray(int i5, XmlString xmlString);

    void xsetFmlaLinkArray(XmlString[] xmlStringArr);

    void xsetFmlaMacroArray(int i5, XmlString xmlString);

    void xsetFmlaMacroArray(XmlString[] xmlStringArr);

    void xsetFmlaPictArray(int i5, XmlString xmlString);

    void xsetFmlaPictArray(XmlString[] xmlStringArr);

    void xsetFmlaRangeArray(int i5, XmlString xmlString);

    void xsetFmlaRangeArray(XmlString[] xmlStringArr);

    void xsetFmlaTxbxArray(int i5, XmlString xmlString);

    void xsetFmlaTxbxArray(XmlString[] xmlStringArr);

    void xsetHelpArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetHelpArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetHorizArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetHorizArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetIncArray(int i5, XmlInteger xmlInteger);

    void xsetIncArray(XmlInteger[] xmlIntegerArr);

    void xsetJustLastXArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetJustLastXArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetLCTArray(int i5, XmlString xmlString);

    void xsetLCTArray(XmlString[] xmlStringArr);

    void xsetListItemArray(int i5, XmlString xmlString);

    void xsetListItemArray(XmlString[] xmlStringArr);

    void xsetLockTextArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetLockTextArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetLockedArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetLockedArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetMapOCXArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetMapOCXArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetMaxArray(int i5, XmlInteger xmlInteger);

    void xsetMaxArray(XmlInteger[] xmlIntegerArr);

    void xsetMinArray(int i5, XmlInteger xmlInteger);

    void xsetMinArray(XmlInteger[] xmlIntegerArr);

    void xsetMoveWithCellsArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetMoveWithCellsArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetMultiLineArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetMultiLineArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetMultiSelArray(int i5, XmlString xmlString);

    void xsetMultiSelArray(XmlString[] xmlStringArr);

    void xsetNoThreeD2Array(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetNoThreeD2Array(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetNoThreeDArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetNoThreeDArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetObjectType(STObjectType sTObjectType);

    void xsetPageArray(int i5, XmlInteger xmlInteger);

    void xsetPageArray(XmlInteger[] xmlIntegerArr);

    void xsetPrintObjectArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetPrintObjectArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetRecalcAlwaysArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetRecalcAlwaysArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetRowArray(int i5, XmlInteger xmlInteger);

    void xsetRowArray(XmlInteger[] xmlIntegerArr);

    void xsetRowHiddenArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetRowHiddenArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetScriptExtendedArray(int i5, XmlString xmlString);

    void xsetScriptExtendedArray(XmlString[] xmlStringArr);

    void xsetScriptLanguageArray(int i5, XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetScriptLanguageArray(XmlNonNegativeInteger[] xmlNonNegativeIntegerArr);

    void xsetScriptLocationArray(int i5, XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetScriptLocationArray(XmlNonNegativeInteger[] xmlNonNegativeIntegerArr);

    void xsetScriptTextArray(int i5, XmlString xmlString);

    void xsetScriptTextArray(XmlString[] xmlStringArr);

    void xsetSecretEditArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetSecretEditArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetSelArray(int i5, XmlInteger xmlInteger);

    void xsetSelArray(XmlInteger[] xmlIntegerArr);

    void xsetSelTypeArray(int i5, XmlString xmlString);

    void xsetSelTypeArray(XmlString[] xmlStringArr);

    void xsetSizeWithCellsArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetSizeWithCellsArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetTextHAlignArray(int i5, XmlString xmlString);

    void xsetTextHAlignArray(XmlString[] xmlStringArr);

    void xsetTextVAlignArray(int i5, XmlString xmlString);

    void xsetTextVAlignArray(XmlString[] xmlStringArr);

    void xsetUIObjArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetUIObjArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetVScrollArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetVScrollArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetVTEditArray(int i5, XmlInteger xmlInteger);

    void xsetVTEditArray(XmlInteger[] xmlIntegerArr);

    void xsetValArray(int i5, XmlInteger xmlInteger);

    void xsetValArray(XmlInteger[] xmlIntegerArr);

    void xsetValidIdsArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetValidIdsArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetVisibleArray(int i5, STTrueFalseBlank sTTrueFalseBlank);

    void xsetVisibleArray(STTrueFalseBlank[] sTTrueFalseBlankArr);

    void xsetWidthMinArray(int i5, XmlInteger xmlInteger);

    void xsetWidthMinArray(XmlInteger[] xmlIntegerArr);
}
