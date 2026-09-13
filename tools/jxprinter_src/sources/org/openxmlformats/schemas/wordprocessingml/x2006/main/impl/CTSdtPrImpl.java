package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDataBinding;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDropDownList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnsignedDecimalNumber;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSdtPrImpl extends XmlComplexContentImpl implements CTSdtPr {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "rPr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "alias"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "tag"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "id"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "lock"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "placeholder"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "temporary"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "showingPlcHdr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "dataBinding"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "label"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "tabIndex"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "equation"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "comboBox"), new QName(XSSFRelation.NS_WORDPROCESSINGML, XmlErrorCodes.DATE), new QName(XSSFRelation.NS_WORDPROCESSINGML, "docPartObj"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "docPartList"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "dropDownList"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "picture"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "richText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "text"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "citation"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "group"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bibliography")};
    private static final long serialVersionUID = 1;

    public CTSdtPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString addNewAlias() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewBibliography() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewCitation() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox addNewComboBox() {
        CTSdtComboBox cTSdtComboBox;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtComboBox = (CTSdtComboBox) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTSdtComboBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding addNewDataBinding() {
        CTDataBinding cTDataBinding;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBinding = (CTDataBinding) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTDataBinding;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate addNewDate() {
        CTSdtDate cTSdtDate;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDate = (CTSdtDate) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTSdtDate;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart addNewDocPartList() {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart addNewDocPartObj() {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList addNewDropDownList() {
        CTSdtDropDownList cTSdtDropDownList;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDropDownList = (CTSdtDropDownList) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTSdtDropDownList;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewEquation() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewGroup() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber addNewId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber addNewLabel() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock addNewLock() {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTLock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewPicture() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder addNewPlaceholder() {
        CTPlaceholder cTPlaceholder;
        synchronized (monitor()) {
            check_orphaned();
            cTPlaceholder = (CTPlaceholder) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPlaceholder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewRichText() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff addNewShowingPlcHdr() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTUnsignedDecimalNumber addNewTabIndex() {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTUnsignedDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString addNewTag() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff addNewTemporary() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText addNewText() {
        CTSdtText cTSdtText;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtText = (CTSdtText) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTSdtText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString getAlias() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getBibliography() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[22], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getCitation() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[20], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox getComboBox() {
        CTSdtComboBox cTSdtComboBox;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtComboBox = (CTSdtComboBox) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTSdtComboBox == null) {
                cTSdtComboBox = null;
            }
        }
        return cTSdtComboBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding getDataBinding() {
        CTDataBinding cTDataBinding;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBinding = (CTDataBinding) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTDataBinding == null) {
                cTDataBinding = null;
            }
        }
        return cTDataBinding;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate getDate() {
        CTSdtDate cTSdtDate;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDate = (CTSdtDate) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTSdtDate == null) {
                cTSdtDate = null;
            }
        }
        return cTSdtDate;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart getDocPartList() {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTSdtDocPart == null) {
                cTSdtDocPart = null;
            }
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart getDocPartObj() {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTSdtDocPart == null) {
                cTSdtDocPart = null;
            }
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList getDropDownList() {
        CTSdtDropDownList cTSdtDropDownList;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDropDownList = (CTSdtDropDownList) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            if (cTSdtDropDownList == null) {
                cTSdtDropDownList = null;
            }
        }
        return cTSdtDropDownList;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getEquation() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getGroup() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[21], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber getId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber getLabel() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock getLock() {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTLock == null) {
                cTLock = null;
            }
        }
        return cTLock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getPicture() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder getPlaceholder() {
        CTPlaceholder cTPlaceholder;
        synchronized (monitor()) {
            check_orphaned();
            cTPlaceholder = (CTPlaceholder) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPlaceholder == null) {
                cTPlaceholder = null;
            }
        }
        return cTPlaceholder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr getRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRPr == null) {
                cTRPr = null;
            }
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getRichText() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[18], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff getShowingPlcHdr() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTUnsignedDecimalNumber getTabIndex() {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTUnsignedDecimalNumberFind_element_user == null) {
                cTUnsignedDecimalNumberFind_element_user = null;
            }
        }
        return cTUnsignedDecimalNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString getTag() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff getTemporary() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText getText() {
        CTSdtText cTSdtText;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtText = (CTSdtText) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (cTSdtText == null) {
                cTSdtText = null;
            }
        }
        return cTSdtText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetAlias() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetBibliography() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[22]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetCitation() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[20]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetComboBox() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetDataBinding() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetDate() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetDocPartList() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetDocPartObj() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetDropDownList() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetEquation() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetGroup() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[21]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetLabel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetLock() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetPicture() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetPlaceholder() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetRPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetRichText() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetShowingPlcHdr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetTabIndex() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetTag() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetTemporary() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public boolean isSetText() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setAlias(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setBibliography(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[22], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setCitation(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[20], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setComboBox(CTSdtComboBox cTSdtComboBox) {
        generatedSetterHelperImpl(cTSdtComboBox, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDataBinding(CTDataBinding cTDataBinding) {
        generatedSetterHelperImpl(cTDataBinding, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDate(CTSdtDate cTSdtDate) {
        generatedSetterHelperImpl(cTSdtDate, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartList(CTSdtDocPart cTSdtDocPart) {
        generatedSetterHelperImpl(cTSdtDocPart, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartObj(CTSdtDocPart cTSdtDocPart) {
        generatedSetterHelperImpl(cTSdtDocPart, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDropDownList(CTSdtDropDownList cTSdtDropDownList) {
        generatedSetterHelperImpl(cTSdtDropDownList, PROPERTY_QNAME[16], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setEquation(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setGroup(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[21], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setId(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setLabel(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setLock(CTLock cTLock) {
        generatedSetterHelperImpl(cTLock, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPicture(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPlaceholder(CTPlaceholder cTPlaceholder) {
        generatedSetterHelperImpl(cTPlaceholder, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRPr(CTRPr cTRPr) {
        generatedSetterHelperImpl(cTRPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRichText(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setShowingPlcHdr(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTabIndex(CTUnsignedDecimalNumber cTUnsignedDecimalNumber) {
        generatedSetterHelperImpl(cTUnsignedDecimalNumber, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTag(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTemporary(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setText(CTSdtText cTSdtText) {
        generatedSetterHelperImpl(cTSdtText, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetAlias() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetBibliography() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetCitation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetComboBox() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetDataBinding() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetDocPartList() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetDocPartObj() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetDropDownList() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetEquation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetLabel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetLock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetPlaceholder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetRichText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetShowingPlcHdr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetTabIndex() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetTag() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetTemporary() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void unsetText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }
}
