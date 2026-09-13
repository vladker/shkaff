package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STConformanceClass;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STConformanceClass$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomShowList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTKinsoku;
import org.openxmlformats.schemas.presentationml.x2006.main.CTModifyVerifier;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPhotoAlbum;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSmartTags;
import org.openxmlformats.schemas.presentationml.x2006.main.STBookmarkIdSeed;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTPresentationImpl extends XmlComplexContentImpl implements CTPresentation {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "sldMasterIdLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "notesMasterIdLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "handoutMasterIdLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "sldIdLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "sldSz"), new QName(XSSFRelation.NS_PRESENTATIONML, "notesSz"), new QName(XSSFRelation.NS_PRESENTATIONML, "smartTags"), new QName(XSSFRelation.NS_PRESENTATIONML, "embeddedFontLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "custShowLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "photoAlbum"), new QName(XSSFRelation.NS_PRESENTATIONML, "custDataLst"), new QName(XSSFRelation.NS_PRESENTATIONML, "kinsoku"), new QName(XSSFRelation.NS_PRESENTATIONML, "defaultTextStyle"), new QName(XSSFRelation.NS_PRESENTATIONML, "modifyVerifier"), new QName(XSSFRelation.NS_PRESENTATIONML, "extLst"), new QName("", "serverZoom"), new QName("", "firstSlideNum"), new QName("", "showSpecialPlsOnTitleSld"), new QName("", "rtl"), new QName("", "removePersonalInfoOnSave"), new QName("", "compatMode"), new QName("", "strictFirstAndLastChars"), new QName("", "embedTrueTypeFonts"), new QName("", "saveSubsetFonts"), new QName("", "autoCompressPictures"), new QName("", "bookmarkIdSeed"), new QName("", "conformance")};
    private static final long serialVersionUID = 1;

    public CTPresentationImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomerDataList addNewCustDataLst() {
        CTCustomerDataList cTCustomerDataList;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataList = (CTCustomerDataList) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTCustomerDataList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomShowList addNewCustShowLst() {
        CTCustomShowList cTCustomShowListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomShowListAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTCustomShowListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTTextListStyle addNewDefaultTextStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTEmbeddedFontList addNewEmbeddedFontLst() {
        CTEmbeddedFontList cTEmbeddedFontList;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontList = (CTEmbeddedFontList) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTEmbeddedFontList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTHandoutMasterIdList addNewHandoutMasterIdLst() {
        CTHandoutMasterIdList cTHandoutMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTHandoutMasterIdList = (CTHandoutMasterIdList) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTHandoutMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTKinsoku addNewKinsoku() {
        CTKinsoku cTKinsokuAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTKinsokuAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTModifyVerifier addNewModifyVerifier() {
        CTModifyVerifier cTModifyVerifierAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTModifyVerifierAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTModifyVerifierAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTNotesMasterIdList addNewNotesMasterIdLst() {
        CTNotesMasterIdList cTNotesMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMasterIdList = (CTNotesMasterIdList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTNotesMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPositiveSize2D addNewNotesSz() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPhotoAlbum addNewPhotoAlbum() {
        CTPhotoAlbum cTPhotoAlbumAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhotoAlbumAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTPhotoAlbumAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideIdList addNewSldIdLst() {
        CTSlideIdList cTSlideIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdList = (CTSlideIdList) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTSlideIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideMasterIdList addNewSldMasterIdLst() {
        CTSlideMasterIdList cTSlideMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdList = (CTSlideMasterIdList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSlideMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideSize addNewSldSz() {
        CTSlideSize cTSlideSize;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideSize = (CTSlideSize) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTSlideSize;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSmartTags addNewSmartTags() {
        CTSmartTags cTSmartTagsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTSmartTagsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getAutoCompressPictures() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[24]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[24]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public long getBookmarkIdSeed() {
        long longValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[25]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[25]);
                }
                longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getCompatMode() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[20]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public STConformanceClass$Enum getConformance() {
        STConformanceClass$Enum sTConformanceClass$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[26]);
            sTConformanceClass$Enum = simpleValue == null ? null : (STConformanceClass$Enum) simpleValue.getEnumValue();
        }
        return sTConformanceClass$Enum;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomerDataList getCustDataLst() {
        CTCustomerDataList cTCustomerDataList;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataList = (CTCustomerDataList) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTCustomerDataList == null) {
                cTCustomerDataList = null;
            }
        }
        return cTCustomerDataList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomShowList getCustShowLst() {
        CTCustomShowList cTCustomShowListFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomShowListFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTCustomShowListFind_element_user == null) {
                cTCustomShowListFind_element_user = null;
            }
        }
        return cTCustomShowListFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTTextListStyle getDefaultTextStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTTextListStyle == null) {
                cTTextListStyle = null;
            }
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getEmbedTrueTypeFonts() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[22]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[22]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTEmbeddedFontList getEmbeddedFontLst() {
        CTEmbeddedFontList cTEmbeddedFontList;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontList = (CTEmbeddedFontList) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTEmbeddedFontList == null) {
                cTEmbeddedFontList = null;
            }
        }
        return cTEmbeddedFontList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public int getFirstSlideNum() {
        int intValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[16]);
                }
                intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTHandoutMasterIdList getHandoutMasterIdLst() {
        CTHandoutMasterIdList cTHandoutMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTHandoutMasterIdList = (CTHandoutMasterIdList) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTHandoutMasterIdList == null) {
                cTHandoutMasterIdList = null;
            }
        }
        return cTHandoutMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTKinsoku getKinsoku() {
        CTKinsoku cTKinsokuFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTKinsokuFind_element_user == null) {
                cTKinsokuFind_element_user = null;
            }
        }
        return cTKinsokuFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTModifyVerifier getModifyVerifier() {
        CTModifyVerifier cTModifyVerifierFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTModifyVerifierFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTModifyVerifierFind_element_user == null) {
                cTModifyVerifierFind_element_user = null;
            }
        }
        return cTModifyVerifierFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTNotesMasterIdList getNotesMasterIdLst() {
        CTNotesMasterIdList cTNotesMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMasterIdList = (CTNotesMasterIdList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTNotesMasterIdList == null) {
                cTNotesMasterIdList = null;
            }
        }
        return cTNotesMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPositiveSize2D getNotesSz() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPositiveSize2D == null) {
                cTPositiveSize2D = null;
            }
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPhotoAlbum getPhotoAlbum() {
        CTPhotoAlbum cTPhotoAlbumFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhotoAlbumFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTPhotoAlbumFind_element_user == null) {
                cTPhotoAlbumFind_element_user = null;
            }
        }
        return cTPhotoAlbumFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getRemovePersonalInfoOnSave() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[19]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getRtl() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[18]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getSaveSubsetFonts() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[23]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[23]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public Object getServerZoom() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[15]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getShowSpecialPlsOnTitleSld() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[17]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideIdList getSldIdLst() {
        CTSlideIdList cTSlideIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdList = (CTSlideIdList) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTSlideIdList == null) {
                cTSlideIdList = null;
            }
        }
        return cTSlideIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideMasterIdList getSldMasterIdLst() {
        CTSlideMasterIdList cTSlideMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdList = (CTSlideMasterIdList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSlideMasterIdList == null) {
                cTSlideMasterIdList = null;
            }
        }
        return cTSlideMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideSize getSldSz() {
        CTSlideSize cTSlideSize;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideSize = (CTSlideSize) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTSlideSize == null) {
                cTSlideSize = null;
            }
        }
        return cTSlideSize;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSmartTags getSmartTags() {
        CTSmartTags cTSmartTagsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTSmartTagsFind_element_user == null) {
                cTSmartTagsFind_element_user = null;
            }
        }
        return cTSmartTagsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getStrictFirstAndLastChars() {
        boolean booleanValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[21]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[21]);
                }
                booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetAutoCompressPictures() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[24]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetBookmarkIdSeed() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[25]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetCompatMode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[20]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetConformance() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[26]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetCustDataLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetCustShowLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetDefaultTextStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetEmbedTrueTypeFonts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[22]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetEmbeddedFontLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetFirstSlideNum() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[16]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetHandoutMasterIdLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetKinsoku() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetModifyVerifier() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetNotesMasterIdLst() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetPhotoAlbum() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetRemovePersonalInfoOnSave() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[19]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetRtl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[18]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSaveSubsetFonts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[23]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetServerZoom() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetShowSpecialPlsOnTitleSld() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[17]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSldIdLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSldMasterIdLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSldSz() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSmartTags() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetStrictFirstAndLastChars() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[21]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setAutoCompressPictures(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[24]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[24]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setBookmarkIdSeed(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[25]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[25]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setCompatMode(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[20]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setConformance(STConformanceClass$Enum sTConformanceClass$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[26]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[26]);
                }
                simpleValue.setEnumValue(sTConformanceClass$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setCustDataLst(CTCustomerDataList cTCustomerDataList) {
        generatedSetterHelperImpl(cTCustomerDataList, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setCustShowLst(CTCustomShowList cTCustomShowList) {
        generatedSetterHelperImpl(cTCustomShowList, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setDefaultTextStyle(CTTextListStyle cTTextListStyle) {
        generatedSetterHelperImpl(cTTextListStyle, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setEmbedTrueTypeFonts(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[22]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[22]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setEmbeddedFontLst(CTEmbeddedFontList cTEmbeddedFontList) {
        generatedSetterHelperImpl(cTEmbeddedFontList, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setFirstSlideNum(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setHandoutMasterIdLst(CTHandoutMasterIdList cTHandoutMasterIdList) {
        generatedSetterHelperImpl(cTHandoutMasterIdList, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setKinsoku(CTKinsoku cTKinsoku) {
        generatedSetterHelperImpl(cTKinsoku, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setModifyVerifier(CTModifyVerifier cTModifyVerifier) {
        generatedSetterHelperImpl(cTModifyVerifier, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setNotesMasterIdLst(CTNotesMasterIdList cTNotesMasterIdList) {
        generatedSetterHelperImpl(cTNotesMasterIdList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setNotesSz(CTPositiveSize2D cTPositiveSize2D) {
        generatedSetterHelperImpl(cTPositiveSize2D, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setPhotoAlbum(CTPhotoAlbum cTPhotoAlbum) {
        generatedSetterHelperImpl(cTPhotoAlbum, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setRemovePersonalInfoOnSave(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[19]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setRtl(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[18]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSaveSubsetFonts(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[23]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[23]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setServerZoom(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setShowSpecialPlsOnTitleSld(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[17]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSldIdLst(CTSlideIdList cTSlideIdList) {
        generatedSetterHelperImpl(cTSlideIdList, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSldMasterIdLst(CTSlideMasterIdList cTSlideMasterIdList) {
        generatedSetterHelperImpl(cTSlideMasterIdList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSldSz(CTSlideSize cTSlideSize) {
        generatedSetterHelperImpl(cTSlideSize, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSmartTags(CTSmartTags cTSmartTags) {
        generatedSetterHelperImpl(cTSmartTags, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setStrictFirstAndLastChars(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[21]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[21]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetAutoCompressPictures() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[24]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetBookmarkIdSeed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[25]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetCompatMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[20]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetConformance() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[26]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetCustShowLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetDefaultTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetEmbedTrueTypeFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[22]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetEmbeddedFontLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetFirstSlideNum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[16]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetHandoutMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetModifyVerifier() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetNotesMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetPhotoAlbum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetRemovePersonalInfoOnSave() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSaveSubsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[23]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetServerZoom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetShowSpecialPlsOnTitleSld() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSldIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSldMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSldSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetStrictFirstAndLastChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[21]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetAutoCompressPictures() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[24]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[24]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public STBookmarkIdSeed xgetBookmarkIdSeed() {
        STBookmarkIdSeed sTBookmarkIdSeed;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTBookmarkIdSeed = (STBookmarkIdSeed) typeStore.find_attribute_user(qNameArr[25]);
                if (sTBookmarkIdSeed == null) {
                    sTBookmarkIdSeed = (STBookmarkIdSeed) get_default_attribute_value(qNameArr[25]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTBookmarkIdSeed;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetCompatMode() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[20]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[20]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public STConformanceClass xgetConformance() {
        STConformanceClass sTConformanceClassFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTConformanceClassFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[26]);
        }
        return sTConformanceClassFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetEmbedTrueTypeFonts() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[22]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[22]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlInt xgetFirstSlideNum() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlInt = (XmlInt) typeStore.find_attribute_user(qNameArr[16]);
                if (xmlInt == null) {
                    xmlInt = (XmlInt) get_default_attribute_value(qNameArr[16]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetRemovePersonalInfoOnSave() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[19]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[19]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetRtl() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[18]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[18]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetSaveSubsetFonts() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[23]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[23]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public STPercentage xgetServerZoom() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTPercentage = (STPercentage) typeStore.find_attribute_user(qNameArr[15]);
                if (sTPercentage == null) {
                    sTPercentage = (STPercentage) get_default_attribute_value(qNameArr[15]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetShowSpecialPlsOnTitleSld() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[17]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[17]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetStrictFirstAndLastChars() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[21]);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[21]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetAutoCompressPictures(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[24]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[24]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetBookmarkIdSeed(STBookmarkIdSeed sTBookmarkIdSeed) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STBookmarkIdSeed sTBookmarkIdSeed2 = (STBookmarkIdSeed) typeStore.find_attribute_user(qNameArr[25]);
                if (sTBookmarkIdSeed2 == null) {
                    sTBookmarkIdSeed2 = (STBookmarkIdSeed) get_store().add_attribute_user(qNameArr[25]);
                }
                sTBookmarkIdSeed2.set(sTBookmarkIdSeed);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetCompatMode(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[20]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[20]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetConformance(STConformanceClass sTConformanceClass) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STConformanceClass sTConformanceClassFind_attribute_user = typeStore.find_attribute_user(qNameArr[26]);
                if (sTConformanceClassFind_attribute_user == null) {
                    sTConformanceClassFind_attribute_user = (STConformanceClass) get_store().add_attribute_user(qNameArr[26]);
                }
                sTConformanceClassFind_attribute_user.set(sTConformanceClass);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetEmbedTrueTypeFonts(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[22]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[22]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetFirstSlideNum(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qNameArr[16]);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qNameArr[16]);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetRemovePersonalInfoOnSave(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[19]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[19]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetRtl(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[18]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[18]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetSaveSubsetFonts(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[23]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[23]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetServerZoom(STPercentage sTPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qNameArr[15]);
                if (sTPercentage2 == null) {
                    sTPercentage2 = (STPercentage) get_store().add_attribute_user(qNameArr[15]);
                }
                sTPercentage2.set(sTPercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetShowSpecialPlsOnTitleSld(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[17]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[17]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetStrictFirstAndLastChars(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[21]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[21]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
