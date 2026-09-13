package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFDDList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFHelpText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFStatusText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFTextInput;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMacroName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnsignedDecimalNumber;
import s5.C1641a0;
import s5.C1646b0;
import s5.C1651c0;
import s5.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTFFDataImpl extends XmlComplexContentImpl implements CTFFData {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "name"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "label"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "tabIndex"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "enabled"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "calcOnExit"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "entryMacro"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "exitMacro"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "helpText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "statusText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "checkBox"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "ddList"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "textInput")};
    private static final long serialVersionUID = 1;

    public CTFFDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewCalcOnExit() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox addNewCheckBox() {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList addNewDdList() {
        CTFFDDList cTFFDDListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTFFDDListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewEnabled() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewEntryMacro() {
        CTMacroName cTMacroNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTMacroNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewExitMacro() {
        CTMacroName cTMacroNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTMacroNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText addNewHelpText() {
        CTFFHelpText cTFFHelpTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTFFHelpTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber addNewLabel() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName addNewName() {
        CTFFName cTFFName;
        synchronized (monitor()) {
            check_orphaned();
            cTFFName = (CTFFName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFFName;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText addNewStatusText() {
        CTFFStatusText cTFFStatusTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTFFStatusTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber addNewTabIndex() {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTUnsignedDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput addNewTextInput() {
        CTFFTextInput cTFFTextInput;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInput = (CTFFTextInput) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTFFTextInput;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getCalcOnExitArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getCalcOnExitList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 22), new C1651c0(this, 5), new Y(this, 23), new C1641a0(this, 11), new C1646b0(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox[] getCheckBoxArray() {
        return (CTFFCheckBox[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTFFCheckBox[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFCheckBox> getCheckBoxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 7), new C1651c0(this, 3), new Y(this, 8), new C1641a0(this, 3), new C1646b0(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList[] getDdListArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTFFDDList[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFDDList> getDdListList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 10), new BiConsumer() { // from class: s5.d0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8390a.setDdListArray(((Integer) obj).intValue(), (CTFFDDList) obj2);
                }
            }, new Y(this, 11), new C1641a0(this, 4), new C1646b0(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getEnabledArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getEnabledList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 5), new C1651c0(this, 2), new Y(this, 6), new C1641a0(this, 2), new C1646b0(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getEntryMacroArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTMacroName[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getEntryMacroList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 18), new BiConsumer() { // from class: s5.g0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8408a.setEntryMacroArray(((Integer) obj).intValue(), (CTMacroName) obj2);
                }
            }, new Y(this, 19), new C1641a0(this, 9), new C1646b0(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getExitMacroArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTMacroName[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getExitMacroList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 14), new BiConsumer() { // from class: s5.f0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8402a.setExitMacroArray(((Integer) obj).intValue(), (CTMacroName) obj2);
                }
            }, new Y(this, 15), new C1641a0(this, 7), new C1646b0(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText[] getHelpTextArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTFFHelpText[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFHelpText> getHelpTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 20), new BiConsumer() { // from class: s5.h0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8414a.setHelpTextArray(((Integer) obj).intValue(), (CTFFHelpText) obj2);
                }
            }, new Y(this, 21), new C1641a0(this, 10), new C1646b0(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber[] getLabelArray() {
        return (CTDecimalNumber[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTDecimalNumber> getLabelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 3), new C1651c0(this, 0), new Y(this, 4), new C1641a0(this, 1), new C1646b0(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName[] getNameArray() {
        return (CTFFName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTFFName[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFName> getNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 0), new C1651c0(this, 1), new Y(this, 9), new C1641a0(this, 6), new C1646b0(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText[] getStatusTextArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTFFStatusText[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFStatusText> getStatusTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 12), new BiConsumer() { // from class: s5.e0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8396a.setStatusTextArray(((Integer) obj).intValue(), (CTFFStatusText) obj2);
                }
            }, new Y(this, 13), new C1641a0(this, 5), new C1646b0(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber[] getTabIndexArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTUnsignedDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTUnsignedDecimalNumber> getTabIndexList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 1), new BiConsumer() { // from class: s5.Z
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8366a.setTabIndexArray(((Integer) obj).intValue(), (CTUnsignedDecimalNumber) obj2);
                }
            }, new Y(this, 2), new C1641a0(this, 0), new C1646b0(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput[] getTextInputArray() {
        return (CTFFTextInput[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTFFTextInput[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFTextInput> getTextInputList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Y(this, 16), new C1651c0(this, 4), new Y(this, 17), new C1641a0(this, 8), new C1646b0(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewCalcOnExit(int i5) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox insertNewCheckBox(int i5) {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList insertNewDdList(int i5) {
        CTFFDDList cTFFDDListInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return cTFFDDListInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewEnabled(int i5) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewEntryMacro(int i5) {
        CTMacroName cTMacroNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return cTMacroNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewExitMacro(int i5) {
        CTMacroName cTMacroNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return cTMacroNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText insertNewHelpText(int i5) {
        CTFFHelpText cTFFHelpTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTFFHelpTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber insertNewLabel(int i5) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName insertNewName(int i5) {
        CTFFName cTFFName;
        synchronized (monitor()) {
            check_orphaned();
            cTFFName = (CTFFName) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTFFName;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText insertNewStatusText(int i5) {
        CTFFStatusText cTFFStatusTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return cTFFStatusTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber insertNewTabIndex(int i5) {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTUnsignedDecimalNumberInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput insertNewTextInput(int i5) {
        CTFFTextInput cTFFTextInput;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInput = (CTFFTextInput) get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return cTFFTextInput;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCalcOnExit(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCheckBox(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeDdList(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEnabled(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEntryMacro(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeExitMacro(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeHelpText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeLabel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeName(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeStatusText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeTabIndex(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeTextInput(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr) {
        check_orphaned();
        arraySetterHelper(cTFFCheckBoxArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(CTFFDDList[] cTFFDDListArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFFDDListArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(CTMacroName[] cTMacroNameArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTMacroNameArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(CTMacroName[] cTMacroNameArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTMacroNameArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFFHelpTextArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setLabelArray(CTDecimalNumber[] cTDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper(cTDecimalNumberArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(CTFFName[] cTFFNameArr) {
        check_orphaned();
        arraySetterHelper(cTFFNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFFStatusTextArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTabIndexArray(CTUnsignedDecimalNumber[] cTUnsignedDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTUnsignedDecimalNumberArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(CTFFTextInput[] cTFFTextInputArr) {
        check_orphaned();
        arraySetterHelper(cTFFTextInputArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCalcOnExitArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCheckBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfDdListArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEnabledArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEntryMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfExitMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfHelpTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfLabelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfStatusTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfTabIndexArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfTextInputArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getCalcOnExitArray(int i5) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTOnOff == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox getCheckBoxArray(int i5) {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFFCheckBox = (CTFFCheckBox) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (cTFFCheckBox == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList getDdListArray(int i5) {
        CTFFDDList cTFFDDListFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFFDDListFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (cTFFDDListFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFFDDListFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getEnabledArray(int i5) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTOnOff == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getEntryMacroArray(int i5) {
        CTMacroName cTMacroNameFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMacroNameFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (cTMacroNameFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMacroNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getExitMacroArray(int i5) {
        CTMacroName cTMacroNameFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMacroNameFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (cTMacroNameFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMacroNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText getHelpTextArray(int i5) {
        CTFFHelpText cTFFHelpTextFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFFHelpTextFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTFFHelpTextFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFFHelpTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber getLabelArray(int i5) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTDecimalNumber == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName getNameArray(int i5) {
        CTFFName cTFFName;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFFName = (CTFFName) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTFFName == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFFName;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText getStatusTextArray(int i5) {
        CTFFStatusText cTFFStatusTextFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFFStatusTextFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (cTFFStatusTextFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFFStatusTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber getTabIndexArray(int i5) {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTUnsignedDecimalNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTUnsignedDecimalNumberFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTUnsignedDecimalNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput getTextInputArray(int i5) {
        CTFFTextInput cTFFTextInput;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFFTextInput = (CTFFTextInput) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (cTFFTextInput == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFFTextInput;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(int i5, CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(int i5, CTFFCheckBox cTFFCheckBox) {
        generatedSetterHelperImpl(cTFFCheckBox, PROPERTY_QNAME[9], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(int i5, CTFFDDList cTFFDDList) {
        generatedSetterHelperImpl(cTFFDDList, PROPERTY_QNAME[10], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(int i5, CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(int i5, CTMacroName cTMacroName) {
        generatedSetterHelperImpl(cTMacroName, PROPERTY_QNAME[5], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(int i5, CTMacroName cTMacroName) {
        generatedSetterHelperImpl(cTMacroName, PROPERTY_QNAME[6], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(int i5, CTFFHelpText cTFFHelpText) {
        generatedSetterHelperImpl(cTFFHelpText, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setLabelArray(int i5, CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(int i5, CTFFName cTFFName) {
        generatedSetterHelperImpl(cTFFName, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(int i5, CTFFStatusText cTFFStatusText) {
        generatedSetterHelperImpl(cTFFStatusText, PROPERTY_QNAME[8], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTabIndexArray(int i5, CTUnsignedDecimalNumber cTUnsignedDecimalNumber) {
        generatedSetterHelperImpl(cTUnsignedDecimalNumber, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(int i5, CTFFTextInput cTFFTextInput) {
        generatedSetterHelperImpl(cTFFTextInput, PROPERTY_QNAME[11], i5, (short) 2);
    }
}
