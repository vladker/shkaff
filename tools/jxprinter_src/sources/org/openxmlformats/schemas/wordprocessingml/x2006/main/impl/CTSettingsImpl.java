package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMathPr;
import org.openxmlformats.schemas.schemaLibrary.x2006.main.CTSchemaLibrary;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCaptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCharacterSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColorSchemeMapping;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCompat;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumberOrPrecent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocRsids;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocVars;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEdnDocProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnDocProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTKinsoku;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMailMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProof;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTReadingModeInkLockDown;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSaveThroughXslt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShapeDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStylePaneFilter;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyleSort;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangesView;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTView;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTWriteProtection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTWritingStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
import r5.B0;
import s5.C1684i3;
import s5.C1689j3;
import s5.C1694k3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSettingsImpl extends XmlComplexContentImpl implements CTSettings {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "writeProtection"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "view"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "zoom"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "removePersonalInformation"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "removeDateAndTime"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotDisplayPageBoundaries"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "displayBackgroundShape"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "printPostScriptOverText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "printFractionalCharacterWidth"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "printFormsData"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "embedTrueTypeFonts"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "embedSystemFonts"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "saveSubsetFonts"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "saveFormsData"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "mirrorMargins"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "alignBordersAndEdges"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bordersDoNotSurroundHeader"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bordersDoNotSurroundFooter"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "gutterAtTop"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "hideSpellingErrors"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "hideGrammaticalErrors"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "activeWritingStyle"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "proofState"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "formsDesign"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "attachedTemplate"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "linkStyles"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "stylePaneFormatFilter"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "stylePaneSortMethod"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "documentType"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "mailMerge"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "revisionView"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "trackRevisions"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotTrackMoves"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotTrackFormatting"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "documentProtection"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "autoFormatOverride"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "styleLockTheme"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "styleLockQFSet"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "defaultTabStop"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "autoHyphenation"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "consecutiveHyphenLimit"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "hyphenationZone"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotHyphenateCaps"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "showEnvelope"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "summaryLength"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "clickAndTypeStyle"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "defaultTableStyle"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "evenAndOddHeaders"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bookFoldRevPrinting"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bookFoldPrinting"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bookFoldPrintingSheets"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "drawingGridHorizontalSpacing"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "drawingGridVerticalSpacing"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "displayHorizontalDrawingGridEvery"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "displayVerticalDrawingGridEvery"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotUseMarginsForDrawingGridOrigin"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "drawingGridHorizontalOrigin"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "drawingGridVerticalOrigin"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotShadeFormData"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "noPunctuationKerning"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "characterSpacingControl"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "printTwoOnOne"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "strictFirstAndLastChars"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "noLineBreaksAfter"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "noLineBreaksBefore"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "savePreviewPicture"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotValidateAgainstSchema"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "saveInvalidXml"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "ignoreMixedContent"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "alwaysShowPlaceholderText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotDemarcateInvalidXml"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "saveXmlDataOnly"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "useXSLTWhenSaving"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "saveThroughXslt"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "showXMLTags"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "alwaysMergeEmptyNamespace"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "updateFields"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "hdrShapeDefaults"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "footnotePr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "endnotePr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "compat"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "docVars"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rsids"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mathPr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "attachedSchema"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "themeFontLang"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "clrSchemeMapping"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotIncludeSubdocsInStats"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotAutoCompressPictures"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "forceUpgrade"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "captions"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "readModeInkLockDown"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "smartTagType"), new QName("http://schemas.openxmlformats.org/schemaLibrary/2006/main", "schemaLibrary"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "shapeDefaults"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "doNotEmbedSmartTags"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "decimalSymbol"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "listSeparator")};
    private static final long serialVersionUID = 1;

    public CTSettingsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle addNewActiveWritingStyle() {
        CTWritingStyle cTWritingStyleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWritingStyleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTWritingStyleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAlignBordersAndEdges() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAlwaysMergeEmptyNamespace() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[75]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAlwaysShowPlaceholderText() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[69]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewAttachedSchema() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[84]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTRel addNewAttachedTemplate() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAutoFormatOverride() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAutoHyphenation() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[39]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBookFoldPrinting() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[49]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewBookFoldPrintingSheets() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[50]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBookFoldRevPrinting() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[48]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBordersDoNotSurroundFooter() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBordersDoNotSurroundHeader() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCaptions addNewCaptions() {
        CTCaptions cTCaptionsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCaptionsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[90]);
        }
        return cTCaptionsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCharacterSpacing addNewCharacterSpacingControl() {
        CTCharacterSpacing cTCharacterSpacingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCharacterSpacingAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[60]);
        }
        return cTCharacterSpacingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewClickAndTypeStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[45]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTColorSchemeMapping addNewClrSchemeMapping() {
        CTColorSchemeMapping cTColorSchemeMappingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorSchemeMappingAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[86]);
        }
        return cTColorSchemeMappingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCompat addNewCompat() {
        CTCompat cTCompatAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCompatAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[80]);
        }
        return cTCompatAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewConsecutiveHyphenLimit() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[40]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewDecimalSymbol() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[96]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDefaultTabStop() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[38]);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewDefaultTableStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[46]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDisplayBackgroundShape() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewDisplayHorizontalDrawingGridEvery() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[53]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewDisplayVerticalDrawingGridEvery() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[54]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotAutoCompressPictures() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[88]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotDemarcateInvalidXml() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[70]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotDisplayPageBoundaries() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotEmbedSmartTags() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[95]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotHyphenateCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[42]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotIncludeSubdocsInStats() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[87]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotShadeFormData() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[58]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotTrackFormatting() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotTrackMoves() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotUseMarginsForDrawingGridOrigin() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[55]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotValidateAgainstSchema() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[66]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocVars addNewDocVars() {
        CTDocVars cTDocVarsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocVarsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[81]);
        }
        return cTDocVarsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocProtect addNewDocumentProtection() {
        CTDocProtect cTDocProtect;
        synchronized (monitor()) {
            check_orphaned();
            cTDocProtect = (CTDocProtect) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTDocProtect;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocType addNewDocumentType() {
        CTDocType cTDocTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTDocTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridHorizontalOrigin() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[56]);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridHorizontalSpacing() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[51]);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridVerticalOrigin() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[57]);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridVerticalSpacing() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[52]);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewEmbedSystemFonts() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewEmbedTrueTypeFonts() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEdnDocProps addNewEndnotePr() {
        CTEdnDocProps cTEdnDocPropsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEdnDocPropsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[79]);
        }
        return cTEdnDocPropsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewEvenAndOddHeaders() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[47]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTFtnDocProps addNewFootnotePr() {
        CTFtnDocProps cTFtnDocPropsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnDocPropsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[78]);
        }
        return cTFtnDocPropsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEmpty addNewForceUpgrade() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[89]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewFormsDesign() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewGutterAtTop() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults addNewHdrShapeDefaults() {
        CTShapeDefaults cTShapeDefaultsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeDefaultsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[77]);
        }
        return cTShapeDefaultsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewHideGrammaticalErrors() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewHideSpellingErrors() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewHyphenationZone() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[41]);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewIgnoreMixedContent() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[68]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewLinkStyles() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewListSeparator() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[97]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMailMerge addNewMailMerge() {
        CTMailMerge cTMailMergeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMailMergeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTMailMergeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMathPr addNewMathPr() {
        CTMathPr cTMathPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMathPrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[83]);
        }
        return cTMathPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewMirrorMargins() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku addNewNoLineBreaksAfter() {
        CTKinsoku cTKinsokuAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[63]);
        }
        return cTKinsokuAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku addNewNoLineBreaksBefore() {
        CTKinsoku cTKinsokuAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[64]);
        }
        return cTKinsokuAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewNoPunctuationKerning() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[59]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintFormsData() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintFractionalCharacterWidth() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintPostScriptOverText() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintTwoOnOne() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[61]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTProof addNewProofState() {
        CTProof cTProofAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTProofAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTReadingModeInkLockDown addNewReadModeInkLockDown() {
        CTReadingModeInkLockDown cTReadingModeInkLockDownAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReadingModeInkLockDownAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[91]);
        }
        return cTReadingModeInkLockDownAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewRemoveDateAndTime() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewRemovePersonalInformation() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTrackChangesView addNewRevisionView() {
        CTTrackChangesView cTTrackChangesViewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangesViewAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTTrackChangesViewAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocRsids addNewRsids() {
        CTDocRsids cTDocRsidsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocRsidsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[82]);
        }
        return cTDocRsidsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveFormsData() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveInvalidXml() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[67]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSavePreviewPicture() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[65]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveSubsetFonts() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSaveThroughXslt addNewSaveThroughXslt() {
        CTSaveThroughXslt cTSaveThroughXsltAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSaveThroughXsltAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[73]);
        }
        return cTSaveThroughXsltAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveXmlDataOnly() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[71]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSchemaLibrary addNewSchemaLibrary() {
        CTSchemaLibrary cTSchemaLibraryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemaLibraryAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[93]);
        }
        return cTSchemaLibraryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults addNewShapeDefaults() {
        CTShapeDefaults cTShapeDefaultsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeDefaultsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[94]);
        }
        return cTShapeDefaultsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewShowEnvelope() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[43]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewShowXMLTags() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[74]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType addNewSmartTagType() {
        CTSmartTagType cTSmartTagTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[92]);
        }
        return cTSmartTagTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewStrictFirstAndLastChars() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[62]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewStyleLockQFSet() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[37]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewStyleLockTheme() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[36]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTStylePaneFilter addNewStylePaneFormatFilter() {
        CTStylePaneFilter cTStylePaneFilterAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStylePaneFilterAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTStylePaneFilterAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTStyleSort addNewStylePaneSortMethod() {
        CTStyleSort cTStyleSortAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleSortAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTStyleSortAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumberOrPrecent addNewSummaryLength() {
        CTDecimalNumberOrPrecent cTDecimalNumberOrPrecentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberOrPrecentAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[44]);
        }
        return cTDecimalNumberOrPrecentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTLanguage addNewThemeFontLang() {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().add_element_user(PROPERTY_QNAME[85]);
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewTrackRevisions() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewUpdateFields() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[76]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewUseXSLTWhenSaving() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[72]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTView addNewView() {
        CTView cTViewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTViewAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTViewAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWriteProtection addNewWriteProtection() {
        CTWriteProtection cTWriteProtectionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWriteProtectionAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTWriteProtectionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTZoom addNewZoom() {
        CTZoom cTZoom;
        synchronized (monitor()) {
            check_orphaned();
            cTZoom = (CTZoom) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTZoom;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle[] getActiveWritingStyleArray() {
        return getXmlObjectArray(PROPERTY_QNAME[21], (XmlObject[]) new CTWritingStyle[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public List<CTWritingStyle> getActiveWritingStyleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1684i3(this, 0), new BiConsumer() { // from class: s5.l3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8439a.setActiveWritingStyleArray(((Integer) obj).intValue(), (CTWritingStyle) obj2);
                }
            }, new C1684i3(this, 3), new C1689j3(this, 1), new C1694k3(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAlignBordersAndEdges() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAlwaysMergeEmptyNamespace() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[75], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAlwaysShowPlaceholderText() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[69], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString[] getAttachedSchemaArray() {
        return (CTString[]) getXmlObjectArray(PROPERTY_QNAME[84], new CTString[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public List<CTString> getAttachedSchemaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1684i3(this, 1), new B0(this, 29), new C1684i3(this, 2), new C1689j3(this, 0), new C1694k3(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTRel getAttachedTemplate() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().find_element_user(PROPERTY_QNAME[24], 0);
            if (cTRel == null) {
                cTRel = null;
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAutoFormatOverride() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[35], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAutoHyphenation() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[39], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBookFoldPrinting() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[49], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getBookFoldPrintingSheets() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[50], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBookFoldRevPrinting() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[48], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBordersDoNotSurroundFooter() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBordersDoNotSurroundHeader() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCaptions getCaptions() {
        CTCaptions cTCaptionsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCaptionsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[90], 0);
            if (cTCaptionsFind_element_user == null) {
                cTCaptionsFind_element_user = null;
            }
        }
        return cTCaptionsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCharacterSpacing getCharacterSpacingControl() {
        CTCharacterSpacing cTCharacterSpacingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCharacterSpacingFind_element_user = get_store().find_element_user(PROPERTY_QNAME[60], 0);
            if (cTCharacterSpacingFind_element_user == null) {
                cTCharacterSpacingFind_element_user = null;
            }
        }
        return cTCharacterSpacingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getClickAndTypeStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[45], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTColorSchemeMapping getClrSchemeMapping() {
        CTColorSchemeMapping cTColorSchemeMappingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorSchemeMappingFind_element_user = get_store().find_element_user(PROPERTY_QNAME[86], 0);
            if (cTColorSchemeMappingFind_element_user == null) {
                cTColorSchemeMappingFind_element_user = null;
            }
        }
        return cTColorSchemeMappingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCompat getCompat() {
        CTCompat cTCompatFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCompatFind_element_user = get_store().find_element_user(PROPERTY_QNAME[80], 0);
            if (cTCompatFind_element_user == null) {
                cTCompatFind_element_user = null;
            }
        }
        return cTCompatFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getConsecutiveHyphenLimit() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[40], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getDecimalSymbol() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[96], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDefaultTabStop() {
        CTTwipsMeasure cTTwipsMeasureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureFind_element_user = get_store().find_element_user(PROPERTY_QNAME[38], 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = null;
            }
        }
        return cTTwipsMeasureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getDefaultTableStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[46], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDisplayBackgroundShape() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getDisplayHorizontalDrawingGridEvery() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[53], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getDisplayVerticalDrawingGridEvery() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[54], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotAutoCompressPictures() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[88], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotDemarcateInvalidXml() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[70], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotDisplayPageBoundaries() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotEmbedSmartTags() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[95], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotHyphenateCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[42], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotIncludeSubdocsInStats() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[87], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotShadeFormData() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[58], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotTrackFormatting() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[33], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotTrackMoves() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[32], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotUseMarginsForDrawingGridOrigin() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[55], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotValidateAgainstSchema() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[66], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocVars getDocVars() {
        CTDocVars cTDocVarsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocVarsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[81], 0);
            if (cTDocVarsFind_element_user == null) {
                cTDocVarsFind_element_user = null;
            }
        }
        return cTDocVarsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocProtect getDocumentProtection() {
        CTDocProtect cTDocProtect;
        synchronized (monitor()) {
            check_orphaned();
            cTDocProtect = (CTDocProtect) get_store().find_element_user(PROPERTY_QNAME[34], 0);
            if (cTDocProtect == null) {
                cTDocProtect = null;
            }
        }
        return cTDocProtect;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocType getDocumentType() {
        CTDocType cTDocTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[28], 0);
            if (cTDocTypeFind_element_user == null) {
                cTDocTypeFind_element_user = null;
            }
        }
        return cTDocTypeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridHorizontalOrigin() {
        CTTwipsMeasure cTTwipsMeasureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureFind_element_user = get_store().find_element_user(PROPERTY_QNAME[56], 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = null;
            }
        }
        return cTTwipsMeasureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridHorizontalSpacing() {
        CTTwipsMeasure cTTwipsMeasureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureFind_element_user = get_store().find_element_user(PROPERTY_QNAME[51], 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = null;
            }
        }
        return cTTwipsMeasureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridVerticalOrigin() {
        CTTwipsMeasure cTTwipsMeasureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureFind_element_user = get_store().find_element_user(PROPERTY_QNAME[57], 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = null;
            }
        }
        return cTTwipsMeasureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridVerticalSpacing() {
        CTTwipsMeasure cTTwipsMeasureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureFind_element_user = get_store().find_element_user(PROPERTY_QNAME[52], 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = null;
            }
        }
        return cTTwipsMeasureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getEmbedSystemFonts() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getEmbedTrueTypeFonts() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEdnDocProps getEndnotePr() {
        CTEdnDocProps cTEdnDocPropsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEdnDocPropsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[79], 0);
            if (cTEdnDocPropsFind_element_user == null) {
                cTEdnDocPropsFind_element_user = null;
            }
        }
        return cTEdnDocPropsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getEvenAndOddHeaders() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[47], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTFtnDocProps getFootnotePr() {
        CTFtnDocProps cTFtnDocPropsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnDocPropsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[78], 0);
            if (cTFtnDocPropsFind_element_user == null) {
                cTFtnDocPropsFind_element_user = null;
            }
        }
        return cTFtnDocPropsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEmpty getForceUpgrade() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[89], 0);
            if (cTEmpty == null) {
                cTEmpty = null;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getFormsDesign() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[23], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getGutterAtTop() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[18], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults getHdrShapeDefaults() {
        CTShapeDefaults cTShapeDefaultsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeDefaultsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[77], 0);
            if (cTShapeDefaultsFind_element_user == null) {
                cTShapeDefaultsFind_element_user = null;
            }
        }
        return cTShapeDefaultsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getHideGrammaticalErrors() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[20], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getHideSpellingErrors() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getHyphenationZone() {
        CTTwipsMeasure cTTwipsMeasureFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureFind_element_user = get_store().find_element_user(PROPERTY_QNAME[41], 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = null;
            }
        }
        return cTTwipsMeasureFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getIgnoreMixedContent() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[68], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getLinkStyles() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[25], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getListSeparator() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[97], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMailMerge getMailMerge() {
        CTMailMerge cTMailMergeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMailMergeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[29], 0);
            if (cTMailMergeFind_element_user == null) {
                cTMailMergeFind_element_user = null;
            }
        }
        return cTMailMergeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMathPr getMathPr() {
        CTMathPr cTMathPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMathPrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[83], 0);
            if (cTMathPrFind_element_user == null) {
                cTMathPrFind_element_user = null;
            }
        }
        return cTMathPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getMirrorMargins() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku getNoLineBreaksAfter() {
        CTKinsoku cTKinsokuFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuFind_element_user = get_store().find_element_user(PROPERTY_QNAME[63], 0);
            if (cTKinsokuFind_element_user == null) {
                cTKinsokuFind_element_user = null;
            }
        }
        return cTKinsokuFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku getNoLineBreaksBefore() {
        CTKinsoku cTKinsokuFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuFind_element_user = get_store().find_element_user(PROPERTY_QNAME[64], 0);
            if (cTKinsokuFind_element_user == null) {
                cTKinsokuFind_element_user = null;
            }
        }
        return cTKinsokuFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getNoPunctuationKerning() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[59], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintFormsData() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintFractionalCharacterWidth() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintPostScriptOverText() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintTwoOnOne() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[61], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTProof getProofState() {
        CTProof cTProofFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofFind_element_user = get_store().find_element_user(PROPERTY_QNAME[22], 0);
            if (cTProofFind_element_user == null) {
                cTProofFind_element_user = null;
            }
        }
        return cTProofFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTReadingModeInkLockDown getReadModeInkLockDown() {
        CTReadingModeInkLockDown cTReadingModeInkLockDownFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReadingModeInkLockDownFind_element_user = get_store().find_element_user(PROPERTY_QNAME[91], 0);
            if (cTReadingModeInkLockDownFind_element_user == null) {
                cTReadingModeInkLockDownFind_element_user = null;
            }
        }
        return cTReadingModeInkLockDownFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getRemoveDateAndTime() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getRemovePersonalInformation() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTrackChangesView getRevisionView() {
        CTTrackChangesView cTTrackChangesViewFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangesViewFind_element_user = get_store().find_element_user(PROPERTY_QNAME[30], 0);
            if (cTTrackChangesViewFind_element_user == null) {
                cTTrackChangesViewFind_element_user = null;
            }
        }
        return cTTrackChangesViewFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocRsids getRsids() {
        CTDocRsids cTDocRsidsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocRsidsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[82], 0);
            if (cTDocRsidsFind_element_user == null) {
                cTDocRsidsFind_element_user = null;
            }
        }
        return cTDocRsidsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveFormsData() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveInvalidXml() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[67], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSavePreviewPicture() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[65], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveSubsetFonts() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSaveThroughXslt getSaveThroughXslt() {
        CTSaveThroughXslt cTSaveThroughXsltFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSaveThroughXsltFind_element_user = get_store().find_element_user(PROPERTY_QNAME[73], 0);
            if (cTSaveThroughXsltFind_element_user == null) {
                cTSaveThroughXsltFind_element_user = null;
            }
        }
        return cTSaveThroughXsltFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveXmlDataOnly() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[71], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSchemaLibrary getSchemaLibrary() {
        CTSchemaLibrary cTSchemaLibraryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemaLibraryFind_element_user = get_store().find_element_user(PROPERTY_QNAME[93], 0);
            if (cTSchemaLibraryFind_element_user == null) {
                cTSchemaLibraryFind_element_user = null;
            }
        }
        return cTSchemaLibraryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults getShapeDefaults() {
        CTShapeDefaults cTShapeDefaultsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeDefaultsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[94], 0);
            if (cTShapeDefaultsFind_element_user == null) {
                cTShapeDefaultsFind_element_user = null;
            }
        }
        return cTShapeDefaultsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getShowEnvelope() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[43], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getShowXMLTags() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[74], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType[] getSmartTagTypeArray() {
        return getXmlObjectArray(PROPERTY_QNAME[92], (XmlObject[]) new CTSmartTagType[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public List<CTSmartTagType> getSmartTagTypeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1684i3(this, 4), new BiConsumer() { // from class: s5.m3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8444a.setSmartTagTypeArray(((Integer) obj).intValue(), (CTSmartTagType) obj2);
                }
            }, new C1684i3(this, 5), new C1689j3(this, 2), new C1694k3(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getStrictFirstAndLastChars() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[62], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getStyleLockQFSet() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[37], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getStyleLockTheme() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[36], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTStylePaneFilter getStylePaneFormatFilter() {
        CTStylePaneFilter cTStylePaneFilterFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStylePaneFilterFind_element_user = get_store().find_element_user(PROPERTY_QNAME[26], 0);
            if (cTStylePaneFilterFind_element_user == null) {
                cTStylePaneFilterFind_element_user = null;
            }
        }
        return cTStylePaneFilterFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTStyleSort getStylePaneSortMethod() {
        CTStyleSort cTStyleSortFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleSortFind_element_user = get_store().find_element_user(PROPERTY_QNAME[27], 0);
            if (cTStyleSortFind_element_user == null) {
                cTStyleSortFind_element_user = null;
            }
        }
        return cTStyleSortFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumberOrPrecent getSummaryLength() {
        CTDecimalNumberOrPrecent cTDecimalNumberOrPrecentFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberOrPrecentFind_element_user = get_store().find_element_user(PROPERTY_QNAME[44], 0);
            if (cTDecimalNumberOrPrecentFind_element_user == null) {
                cTDecimalNumberOrPrecentFind_element_user = null;
            }
        }
        return cTDecimalNumberOrPrecentFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTLanguage getThemeFontLang() {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().find_element_user(PROPERTY_QNAME[85], 0);
            if (cTLanguage == null) {
                cTLanguage = null;
            }
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getTrackRevisions() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[31], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getUpdateFields() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[76], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getUseXSLTWhenSaving() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[72], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTView getView() {
        CTView cTViewFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTViewFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTViewFind_element_user == null) {
                cTViewFind_element_user = null;
            }
        }
        return cTViewFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWriteProtection getWriteProtection() {
        CTWriteProtection cTWriteProtectionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWriteProtectionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTWriteProtectionFind_element_user == null) {
                cTWriteProtectionFind_element_user = null;
            }
        }
        return cTWriteProtectionFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTZoom getZoom() {
        CTZoom cTZoom;
        synchronized (monitor()) {
            check_orphaned();
            cTZoom = (CTZoom) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTZoom == null) {
                cTZoom = null;
            }
        }
        return cTZoom;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle insertNewActiveWritingStyle(int i5) {
        CTWritingStyle cTWritingStyleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWritingStyleInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[21], i5);
        }
        return cTWritingStyleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString insertNewAttachedSchema(int i5) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().insert_element_user(PROPERTY_QNAME[84], i5);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType insertNewSmartTagType(int i5) {
        CTSmartTagType cTSmartTagTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[92], i5);
        }
        return cTSmartTagTypeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAlignBordersAndEdges() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAlwaysMergeEmptyNamespace() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[75]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAlwaysShowPlaceholderText() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[69]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAttachedTemplate() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[24]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAutoFormatOverride() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[35]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAutoHyphenation() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[39]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBookFoldPrinting() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[49]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBookFoldPrintingSheets() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[50]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBookFoldRevPrinting() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[48]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBordersDoNotSurroundFooter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBordersDoNotSurroundHeader() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetCaptions() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[90]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetCharacterSpacingControl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[60]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetClickAndTypeStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[45]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetClrSchemeMapping() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[86]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetCompat() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[80]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetConsecutiveHyphenLimit() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[40]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDecimalSymbol() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[96]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDefaultTabStop() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[38]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDefaultTableStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[46]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDisplayBackgroundShape() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDisplayHorizontalDrawingGridEvery() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[53]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDisplayVerticalDrawingGridEvery() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[54]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotAutoCompressPictures() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[88]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotDemarcateInvalidXml() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[70]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotDisplayPageBoundaries() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotEmbedSmartTags() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[95]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotHyphenateCaps() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[42]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotIncludeSubdocsInStats() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[87]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotShadeFormData() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[58]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotTrackFormatting() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[33]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotTrackMoves() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[32]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotUseMarginsForDrawingGridOrigin() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[55]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotValidateAgainstSchema() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[66]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDocVars() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[81]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDocumentProtection() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[34]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDocumentType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[28]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridHorizontalOrigin() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[56]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridHorizontalSpacing() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[51]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridVerticalOrigin() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[57]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridVerticalSpacing() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[52]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEmbedSystemFonts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEmbedTrueTypeFonts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEndnotePr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[79]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEvenAndOddHeaders() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[47]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetFootnotePr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[78]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetForceUpgrade() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[89]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetFormsDesign() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[23]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetGutterAtTop() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHdrShapeDefaults() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[77]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHideGrammaticalErrors() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[20]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHideSpellingErrors() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHyphenationZone() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[41]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetIgnoreMixedContent() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[68]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetLinkStyles() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[25]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetListSeparator() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[97]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetMailMerge() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[29]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetMathPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[83]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetMirrorMargins() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetNoLineBreaksAfter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[63]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetNoLineBreaksBefore() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[64]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetNoPunctuationKerning() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[59]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintFormsData() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintFractionalCharacterWidth() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintPostScriptOverText() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintTwoOnOne() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[61]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetProofState() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[22]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetReadModeInkLockDown() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[91]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRemoveDateAndTime() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRemovePersonalInformation() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRevisionView() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[30]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRsids() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[82]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveFormsData() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveInvalidXml() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[67]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSavePreviewPicture() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[65]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveSubsetFonts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveThroughXslt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[73]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveXmlDataOnly() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[71]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSchemaLibrary() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[93]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetShapeDefaults() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[94]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetShowEnvelope() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[43]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetShowXMLTags() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[74]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStrictFirstAndLastChars() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[62]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStyleLockQFSet() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[37]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStyleLockTheme() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[36]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStylePaneFormatFilter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[26]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStylePaneSortMethod() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[27]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSummaryLength() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[44]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetThemeFontLang() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[85]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetTrackRevisions() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[31]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetUpdateFields() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[76]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetUseXSLTWhenSaving() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[72]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetView() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetWriteProtection() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetZoom() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void removeActiveWritingStyle(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void removeAttachedSchema(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[84], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void removeSmartTagType(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[92], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setActiveWritingStyleArray(CTWritingStyle[] cTWritingStyleArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTWritingStyleArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAlignBordersAndEdges(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAlwaysMergeEmptyNamespace(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[75], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAlwaysShowPlaceholderText(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[69], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAttachedSchemaArray(CTString[] cTStringArr) {
        check_orphaned();
        arraySetterHelper(cTStringArr, PROPERTY_QNAME[84]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAttachedTemplate(CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[24], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAutoFormatOverride(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[35], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAutoHyphenation(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[39], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBookFoldPrinting(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[49], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBookFoldPrintingSheets(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[50], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBookFoldRevPrinting(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[48], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBordersDoNotSurroundFooter(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBordersDoNotSurroundHeader(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[16], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setCaptions(CTCaptions cTCaptions) {
        generatedSetterHelperImpl(cTCaptions, PROPERTY_QNAME[90], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setCharacterSpacingControl(CTCharacterSpacing cTCharacterSpacing) {
        generatedSetterHelperImpl(cTCharacterSpacing, PROPERTY_QNAME[60], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setClickAndTypeStyle(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[45], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setClrSchemeMapping(CTColorSchemeMapping cTColorSchemeMapping) {
        generatedSetterHelperImpl(cTColorSchemeMapping, PROPERTY_QNAME[86], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setCompat(CTCompat cTCompat) {
        generatedSetterHelperImpl(cTCompat, PROPERTY_QNAME[80], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setConsecutiveHyphenLimit(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[40], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDecimalSymbol(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[96], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDefaultTabStop(CTTwipsMeasure cTTwipsMeasure) {
        generatedSetterHelperImpl(cTTwipsMeasure, PROPERTY_QNAME[38], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDefaultTableStyle(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[46], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDisplayBackgroundShape(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDisplayHorizontalDrawingGridEvery(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[53], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDisplayVerticalDrawingGridEvery(CTDecimalNumber cTDecimalNumber) {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[54], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotAutoCompressPictures(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[88], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotDemarcateInvalidXml(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[70], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotDisplayPageBoundaries(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotEmbedSmartTags(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[95], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotHyphenateCaps(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[42], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotIncludeSubdocsInStats(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[87], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotShadeFormData(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[58], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotTrackFormatting(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[33], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotTrackMoves(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[32], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotUseMarginsForDrawingGridOrigin(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[55], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotValidateAgainstSchema(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[66], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDocVars(CTDocVars cTDocVars) {
        generatedSetterHelperImpl(cTDocVars, PROPERTY_QNAME[81], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDocumentProtection(CTDocProtect cTDocProtect) {
        generatedSetterHelperImpl(cTDocProtect, PROPERTY_QNAME[34], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDocumentType(CTDocType cTDocType) {
        generatedSetterHelperImpl(cTDocType, PROPERTY_QNAME[28], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridHorizontalOrigin(CTTwipsMeasure cTTwipsMeasure) {
        generatedSetterHelperImpl(cTTwipsMeasure, PROPERTY_QNAME[56], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridHorizontalSpacing(CTTwipsMeasure cTTwipsMeasure) {
        generatedSetterHelperImpl(cTTwipsMeasure, PROPERTY_QNAME[51], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridVerticalOrigin(CTTwipsMeasure cTTwipsMeasure) {
        generatedSetterHelperImpl(cTTwipsMeasure, PROPERTY_QNAME[57], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridVerticalSpacing(CTTwipsMeasure cTTwipsMeasure) {
        generatedSetterHelperImpl(cTTwipsMeasure, PROPERTY_QNAME[52], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEmbedSystemFonts(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEmbedTrueTypeFonts(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEndnotePr(CTEdnDocProps cTEdnDocProps) {
        generatedSetterHelperImpl(cTEdnDocProps, PROPERTY_QNAME[79], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEvenAndOddHeaders(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[47], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setFootnotePr(CTFtnDocProps cTFtnDocProps) {
        generatedSetterHelperImpl(cTFtnDocProps, PROPERTY_QNAME[78], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setForceUpgrade(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[89], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setFormsDesign(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[23], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setGutterAtTop(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHdrShapeDefaults(CTShapeDefaults cTShapeDefaults) {
        generatedSetterHelperImpl(cTShapeDefaults, PROPERTY_QNAME[77], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHideGrammaticalErrors(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[20], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHideSpellingErrors(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHyphenationZone(CTTwipsMeasure cTTwipsMeasure) {
        generatedSetterHelperImpl(cTTwipsMeasure, PROPERTY_QNAME[41], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setIgnoreMixedContent(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[68], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setLinkStyles(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[25], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setListSeparator(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[97], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setMailMerge(CTMailMerge cTMailMerge) {
        generatedSetterHelperImpl(cTMailMerge, PROPERTY_QNAME[29], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setMathPr(CTMathPr cTMathPr) {
        generatedSetterHelperImpl(cTMathPr, PROPERTY_QNAME[83], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setMirrorMargins(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setNoLineBreaksAfter(CTKinsoku cTKinsoku) {
        generatedSetterHelperImpl(cTKinsoku, PROPERTY_QNAME[63], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setNoLineBreaksBefore(CTKinsoku cTKinsoku) {
        generatedSetterHelperImpl(cTKinsoku, PROPERTY_QNAME[64], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setNoPunctuationKerning(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[59], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintFormsData(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintFractionalCharacterWidth(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintPostScriptOverText(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintTwoOnOne(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[61], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setProofState(CTProof cTProof) {
        generatedSetterHelperImpl(cTProof, PROPERTY_QNAME[22], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setReadModeInkLockDown(CTReadingModeInkLockDown cTReadingModeInkLockDown) {
        generatedSetterHelperImpl(cTReadingModeInkLockDown, PROPERTY_QNAME[91], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRemoveDateAndTime(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRemovePersonalInformation(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRevisionView(CTTrackChangesView cTTrackChangesView) {
        generatedSetterHelperImpl(cTTrackChangesView, PROPERTY_QNAME[30], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRsids(CTDocRsids cTDocRsids) {
        generatedSetterHelperImpl(cTDocRsids, PROPERTY_QNAME[82], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveFormsData(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveInvalidXml(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[67], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSavePreviewPicture(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[65], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveSubsetFonts(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveThroughXslt(CTSaveThroughXslt cTSaveThroughXslt) {
        generatedSetterHelperImpl(cTSaveThroughXslt, PROPERTY_QNAME[73], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveXmlDataOnly(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[71], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSchemaLibrary(CTSchemaLibrary cTSchemaLibrary) {
        generatedSetterHelperImpl(cTSchemaLibrary, PROPERTY_QNAME[93], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setShapeDefaults(CTShapeDefaults cTShapeDefaults) {
        generatedSetterHelperImpl(cTShapeDefaults, PROPERTY_QNAME[94], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setShowEnvelope(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[43], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setShowXMLTags(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[74], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSmartTagTypeArray(CTSmartTagType[] cTSmartTagTypeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSmartTagTypeArr, PROPERTY_QNAME[92]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStrictFirstAndLastChars(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[62], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStyleLockQFSet(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[37], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStyleLockTheme(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[36], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStylePaneFormatFilter(CTStylePaneFilter cTStylePaneFilter) {
        generatedSetterHelperImpl(cTStylePaneFilter, PROPERTY_QNAME[26], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStylePaneSortMethod(CTStyleSort cTStyleSort) {
        generatedSetterHelperImpl(cTStyleSort, PROPERTY_QNAME[27], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSummaryLength(CTDecimalNumberOrPrecent cTDecimalNumberOrPrecent) {
        generatedSetterHelperImpl(cTDecimalNumberOrPrecent, PROPERTY_QNAME[44], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setThemeFontLang(CTLanguage cTLanguage) {
        generatedSetterHelperImpl(cTLanguage, PROPERTY_QNAME[85], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setTrackRevisions(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[31], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setUpdateFields(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[76], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setUseXSLTWhenSaving(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[72], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setView(CTView cTView) {
        generatedSetterHelperImpl(cTView, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setWriteProtection(CTWriteProtection cTWriteProtection) {
        generatedSetterHelperImpl(cTWriteProtection, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setZoom(CTZoom cTZoom) {
        generatedSetterHelperImpl(cTZoom, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public int sizeOfActiveWritingStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public int sizeOfAttachedSchemaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[84]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public int sizeOfSmartTagTypeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[92]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAlignBordersAndEdges() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAlwaysMergeEmptyNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[75], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAlwaysShowPlaceholderText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[69], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAttachedTemplate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAutoFormatOverride() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAutoHyphenation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[39], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBookFoldPrinting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[49], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBookFoldPrintingSheets() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[50], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBookFoldRevPrinting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[48], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBordersDoNotSurroundFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBordersDoNotSurroundHeader() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetCaptions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[90], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetCharacterSpacingControl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[60], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetClickAndTypeStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[45], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetClrSchemeMapping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[86], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetCompat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[80], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetConsecutiveHyphenLimit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[40], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDecimalSymbol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[96], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDefaultTabStop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[38], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDefaultTableStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[46], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDisplayBackgroundShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDisplayHorizontalDrawingGridEvery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[53], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDisplayVerticalDrawingGridEvery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[54], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotAutoCompressPictures() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[88], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotDemarcateInvalidXml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[70], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotDisplayPageBoundaries() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotEmbedSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[95], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotHyphenateCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[42], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotIncludeSubdocsInStats() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[87], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotShadeFormData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[58], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotTrackFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotTrackMoves() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotUseMarginsForDrawingGridOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[55], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotValidateAgainstSchema() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[66], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDocVars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[81], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDocumentProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDocumentType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridHorizontalOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[56], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridHorizontalSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[51], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridVerticalOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[57], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridVerticalSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[52], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEmbedSystemFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEmbedTrueTypeFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEndnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[79], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEvenAndOddHeaders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[47], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetFootnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[78], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetForceUpgrade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[89], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetFormsDesign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetGutterAtTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHdrShapeDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[77], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHideGrammaticalErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHideSpellingErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHyphenationZone() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[41], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetIgnoreMixedContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[68], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetLinkStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetListSeparator() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[97], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetMailMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetMathPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[83], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetMirrorMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetNoLineBreaksAfter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[63], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetNoLineBreaksBefore() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[64], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetNoPunctuationKerning() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[59], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintFormsData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintFractionalCharacterWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintPostScriptOverText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintTwoOnOne() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[61], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetProofState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetReadModeInkLockDown() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[91], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRemoveDateAndTime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRemovePersonalInformation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRevisionView() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRsids() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[82], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveFormsData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveInvalidXml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[67], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSavePreviewPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[65], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveSubsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveThroughXslt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[73], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveXmlDataOnly() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[71], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSchemaLibrary() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[93], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetShapeDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[94], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetShowEnvelope() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[43], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetShowXMLTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[74], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStrictFirstAndLastChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[62], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStyleLockQFSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[37], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStyleLockTheme() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[36], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStylePaneFormatFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStylePaneSortMethod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSummaryLength() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[44], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetThemeFontLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[85], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetTrackRevisions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetUpdateFields() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[76], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetUseXSLTWhenSaving() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[72], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetView() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetWriteProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetZoom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle getActiveWritingStyleArray(int i5) {
        CTWritingStyle cTWritingStyleFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTWritingStyleFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (cTWritingStyleFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTWritingStyleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getAttachedSchemaArray(int i5) {
        CTString cTString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[84], i5);
                if (cTString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType getSmartTagTypeArray(int i5) {
        CTSmartTagType cTSmartTagTypeFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSmartTagTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[92], i5);
                if (cTSmartTagTypeFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSmartTagTypeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setActiveWritingStyleArray(int i5, CTWritingStyle cTWritingStyle) {
        generatedSetterHelperImpl(cTWritingStyle, PROPERTY_QNAME[21], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAttachedSchemaArray(int i5, CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[84], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSmartTagTypeArray(int i5, CTSmartTagType cTSmartTagType) {
        generatedSetterHelperImpl(cTSmartTagType, PROPERTY_QNAME[92], i5, (short) 2);
    }
}
