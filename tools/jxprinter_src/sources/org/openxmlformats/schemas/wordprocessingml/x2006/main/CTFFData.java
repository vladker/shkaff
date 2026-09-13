package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFFData extends XmlObject {
    public static final DocumentFactory<CTFFData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFFData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctffdataaa7etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOnOff addNewCalcOnExit();

    CTFFCheckBox addNewCheckBox();

    CTFFDDList addNewDdList();

    CTOnOff addNewEnabled();

    CTMacroName addNewEntryMacro();

    CTMacroName addNewExitMacro();

    CTFFHelpText addNewHelpText();

    CTDecimalNumber addNewLabel();

    CTFFName addNewName();

    CTFFStatusText addNewStatusText();

    CTUnsignedDecimalNumber addNewTabIndex();

    CTFFTextInput addNewTextInput();

    CTOnOff getCalcOnExitArray(int i5);

    CTOnOff[] getCalcOnExitArray();

    List<CTOnOff> getCalcOnExitList();

    CTFFCheckBox getCheckBoxArray(int i5);

    CTFFCheckBox[] getCheckBoxArray();

    List<CTFFCheckBox> getCheckBoxList();

    CTFFDDList getDdListArray(int i5);

    CTFFDDList[] getDdListArray();

    List<CTFFDDList> getDdListList();

    CTOnOff getEnabledArray(int i5);

    CTOnOff[] getEnabledArray();

    List<CTOnOff> getEnabledList();

    CTMacroName getEntryMacroArray(int i5);

    CTMacroName[] getEntryMacroArray();

    List<CTMacroName> getEntryMacroList();

    CTMacroName getExitMacroArray(int i5);

    CTMacroName[] getExitMacroArray();

    List<CTMacroName> getExitMacroList();

    CTFFHelpText getHelpTextArray(int i5);

    CTFFHelpText[] getHelpTextArray();

    List<CTFFHelpText> getHelpTextList();

    CTDecimalNumber getLabelArray(int i5);

    CTDecimalNumber[] getLabelArray();

    List<CTDecimalNumber> getLabelList();

    CTFFName getNameArray(int i5);

    CTFFName[] getNameArray();

    List<CTFFName> getNameList();

    CTFFStatusText getStatusTextArray(int i5);

    CTFFStatusText[] getStatusTextArray();

    List<CTFFStatusText> getStatusTextList();

    CTUnsignedDecimalNumber getTabIndexArray(int i5);

    CTUnsignedDecimalNumber[] getTabIndexArray();

    List<CTUnsignedDecimalNumber> getTabIndexList();

    CTFFTextInput getTextInputArray(int i5);

    CTFFTextInput[] getTextInputArray();

    List<CTFFTextInput> getTextInputList();

    CTOnOff insertNewCalcOnExit(int i5);

    CTFFCheckBox insertNewCheckBox(int i5);

    CTFFDDList insertNewDdList(int i5);

    CTOnOff insertNewEnabled(int i5);

    CTMacroName insertNewEntryMacro(int i5);

    CTMacroName insertNewExitMacro(int i5);

    CTFFHelpText insertNewHelpText(int i5);

    CTDecimalNumber insertNewLabel(int i5);

    CTFFName insertNewName(int i5);

    CTFFStatusText insertNewStatusText(int i5);

    CTUnsignedDecimalNumber insertNewTabIndex(int i5);

    CTFFTextInput insertNewTextInput(int i5);

    void removeCalcOnExit(int i5);

    void removeCheckBox(int i5);

    void removeDdList(int i5);

    void removeEnabled(int i5);

    void removeEntryMacro(int i5);

    void removeExitMacro(int i5);

    void removeHelpText(int i5);

    void removeLabel(int i5);

    void removeName(int i5);

    void removeStatusText(int i5);

    void removeTabIndex(int i5);

    void removeTextInput(int i5);

    void setCalcOnExitArray(int i5, CTOnOff cTOnOff);

    void setCalcOnExitArray(CTOnOff[] cTOnOffArr);

    void setCheckBoxArray(int i5, CTFFCheckBox cTFFCheckBox);

    void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr);

    void setDdListArray(int i5, CTFFDDList cTFFDDList);

    void setDdListArray(CTFFDDList[] cTFFDDListArr);

    void setEnabledArray(int i5, CTOnOff cTOnOff);

    void setEnabledArray(CTOnOff[] cTOnOffArr);

    void setEntryMacroArray(int i5, CTMacroName cTMacroName);

    void setEntryMacroArray(CTMacroName[] cTMacroNameArr);

    void setExitMacroArray(int i5, CTMacroName cTMacroName);

    void setExitMacroArray(CTMacroName[] cTMacroNameArr);

    void setHelpTextArray(int i5, CTFFHelpText cTFFHelpText);

    void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr);

    void setLabelArray(int i5, CTDecimalNumber cTDecimalNumber);

    void setLabelArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setNameArray(int i5, CTFFName cTFFName);

    void setNameArray(CTFFName[] cTFFNameArr);

    void setStatusTextArray(int i5, CTFFStatusText cTFFStatusText);

    void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr);

    void setTabIndexArray(int i5, CTUnsignedDecimalNumber cTUnsignedDecimalNumber);

    void setTabIndexArray(CTUnsignedDecimalNumber[] cTUnsignedDecimalNumberArr);

    void setTextInputArray(int i5, CTFFTextInput cTFFTextInput);

    void setTextInputArray(CTFFTextInput[] cTFFTextInputArr);

    int sizeOfCalcOnExitArray();

    int sizeOfCheckBoxArray();

    int sizeOfDdListArray();

    int sizeOfEnabledArray();

    int sizeOfEntryMacroArray();

    int sizeOfExitMacroArray();

    int sizeOfHelpTextArray();

    int sizeOfLabelArray();

    int sizeOfNameArray();

    int sizeOfStatusTextArray();

    int sizeOfTabIndexArray();

    int sizeOfTextInputArray();
}
