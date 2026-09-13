package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataConsolidate;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawingHF;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTScenarios;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetBackgroundPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTags;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import r5.f1;
import r5.g1;
import r5.h1;
import r5.i1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTWorksheetImpl extends XmlComplexContentImpl implements CTWorksheet {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "sheetPr"), new QName(XSSFRelation.NS_SPREADSHEETML, TypedValues.Custom.S_DIMENSION), new QName(XSSFRelation.NS_SPREADSHEETML, "sheetViews"), new QName(XSSFRelation.NS_SPREADSHEETML, "sheetFormatPr"), new QName(XSSFRelation.NS_SPREADSHEETML, "cols"), new QName(XSSFRelation.NS_SPREADSHEETML, "sheetData"), new QName(XSSFRelation.NS_SPREADSHEETML, "sheetCalcPr"), new QName(XSSFRelation.NS_SPREADSHEETML, "sheetProtection"), new QName(XSSFRelation.NS_SPREADSHEETML, "protectedRanges"), new QName(XSSFRelation.NS_SPREADSHEETML, "scenarios"), new QName(XSSFRelation.NS_SPREADSHEETML, "autoFilter"), new QName(XSSFRelation.NS_SPREADSHEETML, "sortState"), new QName(XSSFRelation.NS_SPREADSHEETML, "dataConsolidate"), new QName(XSSFRelation.NS_SPREADSHEETML, "customSheetViews"), new QName(XSSFRelation.NS_SPREADSHEETML, "mergeCells"), new QName(XSSFRelation.NS_SPREADSHEETML, "phoneticPr"), new QName(XSSFRelation.NS_SPREADSHEETML, "conditionalFormatting"), new QName(XSSFRelation.NS_SPREADSHEETML, "dataValidations"), new QName(XSSFRelation.NS_SPREADSHEETML, "hyperlinks"), new QName(XSSFRelation.NS_SPREADSHEETML, "printOptions"), new QName(XSSFRelation.NS_SPREADSHEETML, "pageMargins"), new QName(XSSFRelation.NS_SPREADSHEETML, "pageSetup"), new QName(XSSFRelation.NS_SPREADSHEETML, "headerFooter"), new QName(XSSFRelation.NS_SPREADSHEETML, "rowBreaks"), new QName(XSSFRelation.NS_SPREADSHEETML, "colBreaks"), new QName(XSSFRelation.NS_SPREADSHEETML, "customProperties"), new QName(XSSFRelation.NS_SPREADSHEETML, "cellWatches"), new QName(XSSFRelation.NS_SPREADSHEETML, "ignoredErrors"), new QName(XSSFRelation.NS_SPREADSHEETML, "smartTags"), new QName(XSSFRelation.NS_SPREADSHEETML, "drawing"), new QName(XSSFRelation.NS_SPREADSHEETML, "legacyDrawing"), new QName(XSSFRelation.NS_SPREADSHEETML, "legacyDrawingHF"), new QName(XSSFRelation.NS_SPREADSHEETML, "drawingHF"), new QName(XSSFRelation.NS_SPREADSHEETML, "picture"), new QName(XSSFRelation.NS_SPREADSHEETML, "oleObjects"), new QName(XSSFRelation.NS_SPREADSHEETML, "controls"), new QName(XSSFRelation.NS_SPREADSHEETML, "webPublishItems"), new QName(XSSFRelation.NS_SPREADSHEETML, "tableParts"), new QName(XSSFRelation.NS_SPREADSHEETML, "extLst")};
    private static final long serialVersionUID = 1;

    public CTWorksheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTAutoFilter addNewAutoFilter() {
        CTAutoFilter cTAutoFilter;
        synchronized (monitor()) {
            check_orphaned();
            cTAutoFilter = (CTAutoFilter) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTAutoFilter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCellWatches addNewCellWatches() {
        CTCellWatches cTCellWatches;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatches = (CTCellWatches) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTCellWatches;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak addNewColBreaks() {
        CTPageBreak cTPageBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBreak = (CTPageBreak) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTPageBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols addNewCols() {
        CTCols cTCols;
        synchronized (monitor()) {
            check_orphaned();
            cTCols = (CTCols) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTCols;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting addNewConditionalFormatting() {
        CTConditionalFormatting cTConditionalFormatting;
        synchronized (monitor()) {
            check_orphaned();
            cTConditionalFormatting = (CTConditionalFormatting) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTConditionalFormatting;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTControls addNewControls() {
        CTControls cTControls;
        synchronized (monitor()) {
            check_orphaned();
            cTControls = (CTControls) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return cTControls;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomProperties addNewCustomProperties() {
        CTCustomProperties cTCustomProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperties = (CTCustomProperties) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTCustomProperties;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomSheetViews addNewCustomSheetViews() {
        CTCustomSheetViews cTCustomSheetViews;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetViews = (CTCustomSheetViews) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTCustomSheetViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataConsolidate addNewDataConsolidate() {
        CTDataConsolidate cTDataConsolidate;
        synchronized (monitor()) {
            check_orphaned();
            cTDataConsolidate = (CTDataConsolidate) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTDataConsolidate;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataValidations addNewDataValidations() {
        CTDataValidations cTDataValidations;
        synchronized (monitor()) {
            check_orphaned();
            cTDataValidations = (CTDataValidations) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTDataValidations;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetDimension addNewDimension() {
        CTSheetDimension cTSheetDimension;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetDimension = (CTSheetDimension) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTSheetDimension;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDrawingHF addNewDrawingHF() {
        CTDrawingHF cTDrawingHFAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingHFAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTDrawingHFAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[38]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHeaderFooter addNewHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHyperlinks addNewHyperlinks() {
        CTHyperlinks cTHyperlinks;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlinks = (CTHyperlinks) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTHyperlinks;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTIgnoredErrors addNewIgnoredErrors() {
        CTIgnoredErrors cTIgnoredErrors;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredErrors = (CTIgnoredErrors) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTIgnoredErrors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing addNewLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing addNewLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTMergeCells addNewMergeCells() {
        CTMergeCells cTMergeCells;
        synchronized (monitor()) {
            check_orphaned();
            cTMergeCells = (CTMergeCells) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTMergeCells;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTOleObjects addNewOleObjects() {
        CTOleObjects cTOleObjects;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObjects = (CTOleObjects) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTOleObjects;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageMargins addNewPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageSetup addNewPageSetup() {
        CTPageSetup cTPageSetup;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSetup = (CTPageSetup) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTPageSetup;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPhoneticPr addNewPhoneticPr() {
        CTPhoneticPr cTPhoneticPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticPr = (CTPhoneticPr) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTPhoneticPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetBackgroundPicture addNewPicture() {
        CTSheetBackgroundPicture cTSheetBackgroundPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetBackgroundPicture = (CTSheetBackgroundPicture) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTSheetBackgroundPicture;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPrintOptions addNewPrintOptions() {
        CTPrintOptions cTPrintOptions;
        synchronized (monitor()) {
            check_orphaned();
            cTPrintOptions = (CTPrintOptions) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTPrintOptions;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTProtectedRanges addNewProtectedRanges() {
        CTProtectedRanges cTProtectedRanges;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRanges = (CTProtectedRanges) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTProtectedRanges;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak addNewRowBreaks() {
        CTPageBreak cTPageBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBreak = (CTPageBreak) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTPageBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTScenarios addNewScenarios() {
        CTScenarios cTScenariosAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTScenariosAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTScenariosAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetCalcPr addNewSheetCalcPr() {
        CTSheetCalcPr cTSheetCalcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetCalcPr = (CTSheetCalcPr) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTSheetCalcPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetData addNewSheetData() {
        CTSheetData cTSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetData = (CTSheetData) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetFormatPr addNewSheetFormatPr() {
        CTSheetFormatPr cTSheetFormatPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetFormatPr = (CTSheetFormatPr) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTSheetFormatPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetPr addNewSheetPr() {
        CTSheetPr cTSheetPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetPr = (CTSheetPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSheetPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetProtection addNewSheetProtection() {
        CTSheetProtection cTSheetProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetProtection = (CTSheetProtection) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTSheetProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetViews addNewSheetViews() {
        CTSheetViews cTSheetViews;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetViews = (CTSheetViews) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSheetViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSmartTags addNewSmartTags() {
        CTSmartTags cTSmartTagsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTSmartTagsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSortState addNewSortState() {
        CTSortState cTSortState;
        synchronized (monitor()) {
            check_orphaned();
            cTSortState = (CTSortState) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTSortState;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTTableParts addNewTableParts() {
        CTTableParts cTTableParts;
        synchronized (monitor()) {
            check_orphaned();
            cTTableParts = (CTTableParts) get_store().add_element_user(PROPERTY_QNAME[37]);
        }
        return cTTableParts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTWebPublishItems addNewWebPublishItems() {
        CTWebPublishItems cTWebPublishItemsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishItemsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[36]);
        }
        return cTWebPublishItemsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTAutoFilter getAutoFilter() {
        CTAutoFilter cTAutoFilter;
        synchronized (monitor()) {
            check_orphaned();
            cTAutoFilter = (CTAutoFilter) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTAutoFilter == null) {
                cTAutoFilter = null;
            }
        }
        return cTAutoFilter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCellWatches getCellWatches() {
        CTCellWatches cTCellWatches;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatches = (CTCellWatches) get_store().find_element_user(PROPERTY_QNAME[26], 0);
            if (cTCellWatches == null) {
                cTCellWatches = null;
            }
        }
        return cTCellWatches;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak getColBreaks() {
        CTPageBreak cTPageBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBreak = (CTPageBreak) get_store().find_element_user(PROPERTY_QNAME[24], 0);
            if (cTPageBreak == null) {
                cTPageBreak = null;
            }
        }
        return cTPageBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols[] getColsArray() {
        return (CTCols[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTCols[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public List<CTCols> getColsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new f1(this, 0), new g1(this, 0), new f1(this, 1), new h1(this, 0), new i1(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting[] getConditionalFormattingArray() {
        return (CTConditionalFormatting[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTConditionalFormatting[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public List<CTConditionalFormatting> getConditionalFormattingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new f1(this, 2), new g1(this, 1), new f1(this, 3), new h1(this, 1), new i1(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTControls getControls() {
        CTControls cTControls;
        synchronized (monitor()) {
            check_orphaned();
            cTControls = (CTControls) get_store().find_element_user(PROPERTY_QNAME[35], 0);
            if (cTControls == null) {
                cTControls = null;
            }
        }
        return cTControls;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomProperties getCustomProperties() {
        CTCustomProperties cTCustomProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperties = (CTCustomProperties) get_store().find_element_user(PROPERTY_QNAME[25], 0);
            if (cTCustomProperties == null) {
                cTCustomProperties = null;
            }
        }
        return cTCustomProperties;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomSheetViews getCustomSheetViews() {
        CTCustomSheetViews cTCustomSheetViews;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetViews = (CTCustomSheetViews) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTCustomSheetViews == null) {
                cTCustomSheetViews = null;
            }
        }
        return cTCustomSheetViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataConsolidate getDataConsolidate() {
        CTDataConsolidate cTDataConsolidate;
        synchronized (monitor()) {
            check_orphaned();
            cTDataConsolidate = (CTDataConsolidate) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTDataConsolidate == null) {
                cTDataConsolidate = null;
            }
        }
        return cTDataConsolidate;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataValidations getDataValidations() {
        CTDataValidations cTDataValidations;
        synchronized (monitor()) {
            check_orphaned();
            cTDataValidations = (CTDataValidations) get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTDataValidations == null) {
                cTDataValidations = null;
            }
        }
        return cTDataValidations;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetDimension getDimension() {
        CTSheetDimension cTSheetDimension;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetDimension = (CTSheetDimension) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTSheetDimension == null) {
                cTSheetDimension = null;
            }
        }
        return cTSheetDimension;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDrawing getDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().find_element_user(PROPERTY_QNAME[29], 0);
            if (cTDrawing == null) {
                cTDrawing = null;
            }
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDrawingHF getDrawingHF() {
        CTDrawingHF cTDrawingHFFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingHFFind_element_user = get_store().find_element_user(PROPERTY_QNAME[32], 0);
            if (cTDrawingHFFind_element_user == null) {
                cTDrawingHFFind_element_user = null;
            }
        }
        return cTDrawingHFFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[38], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHeaderFooter getHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(PROPERTY_QNAME[22], 0);
            if (cTHeaderFooter == null) {
                cTHeaderFooter = null;
            }
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHyperlinks getHyperlinks() {
        CTHyperlinks cTHyperlinks;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlinks = (CTHyperlinks) get_store().find_element_user(PROPERTY_QNAME[18], 0);
            if (cTHyperlinks == null) {
                cTHyperlinks = null;
            }
        }
        return cTHyperlinks;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTIgnoredErrors getIgnoredErrors() {
        CTIgnoredErrors cTIgnoredErrors;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredErrors = (CTIgnoredErrors) get_store().find_element_user(PROPERTY_QNAME[27], 0);
            if (cTIgnoredErrors == null) {
                cTIgnoredErrors = null;
            }
        }
        return cTIgnoredErrors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing getLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(PROPERTY_QNAME[30], 0);
            if (cTLegacyDrawing == null) {
                cTLegacyDrawing = null;
            }
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing getLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(PROPERTY_QNAME[31], 0);
            if (cTLegacyDrawing == null) {
                cTLegacyDrawing = null;
            }
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTMergeCells getMergeCells() {
        CTMergeCells cTMergeCells;
        synchronized (monitor()) {
            check_orphaned();
            cTMergeCells = (CTMergeCells) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTMergeCells == null) {
                cTMergeCells = null;
            }
        }
        return cTMergeCells;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTOleObjects getOleObjects() {
        CTOleObjects cTOleObjects;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObjects = (CTOleObjects) get_store().find_element_user(PROPERTY_QNAME[34], 0);
            if (cTOleObjects == null) {
                cTOleObjects = null;
            }
        }
        return cTOleObjects;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageMargins getPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().find_element_user(PROPERTY_QNAME[20], 0);
            if (cTPageMargins == null) {
                cTPageMargins = null;
            }
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageSetup getPageSetup() {
        CTPageSetup cTPageSetup;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSetup = (CTPageSetup) get_store().find_element_user(PROPERTY_QNAME[21], 0);
            if (cTPageSetup == null) {
                cTPageSetup = null;
            }
        }
        return cTPageSetup;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPhoneticPr getPhoneticPr() {
        CTPhoneticPr cTPhoneticPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticPr = (CTPhoneticPr) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTPhoneticPr == null) {
                cTPhoneticPr = null;
            }
        }
        return cTPhoneticPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetBackgroundPicture getPicture() {
        CTSheetBackgroundPicture cTSheetBackgroundPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetBackgroundPicture = (CTSheetBackgroundPicture) get_store().find_element_user(PROPERTY_QNAME[33], 0);
            if (cTSheetBackgroundPicture == null) {
                cTSheetBackgroundPicture = null;
            }
        }
        return cTSheetBackgroundPicture;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPrintOptions getPrintOptions() {
        CTPrintOptions cTPrintOptions;
        synchronized (monitor()) {
            check_orphaned();
            cTPrintOptions = (CTPrintOptions) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (cTPrintOptions == null) {
                cTPrintOptions = null;
            }
        }
        return cTPrintOptions;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTProtectedRanges getProtectedRanges() {
        CTProtectedRanges cTProtectedRanges;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRanges = (CTProtectedRanges) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTProtectedRanges == null) {
                cTProtectedRanges = null;
            }
        }
        return cTProtectedRanges;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak getRowBreaks() {
        CTPageBreak cTPageBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBreak = (CTPageBreak) get_store().find_element_user(PROPERTY_QNAME[23], 0);
            if (cTPageBreak == null) {
                cTPageBreak = null;
            }
        }
        return cTPageBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTScenarios getScenarios() {
        CTScenarios cTScenariosFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTScenariosFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTScenariosFind_element_user == null) {
                cTScenariosFind_element_user = null;
            }
        }
        return cTScenariosFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetCalcPr getSheetCalcPr() {
        CTSheetCalcPr cTSheetCalcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetCalcPr = (CTSheetCalcPr) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTSheetCalcPr == null) {
                cTSheetCalcPr = null;
            }
        }
        return cTSheetCalcPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetData getSheetData() {
        CTSheetData cTSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetData = (CTSheetData) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTSheetData == null) {
                cTSheetData = null;
            }
        }
        return cTSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetFormatPr getSheetFormatPr() {
        CTSheetFormatPr cTSheetFormatPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetFormatPr = (CTSheetFormatPr) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTSheetFormatPr == null) {
                cTSheetFormatPr = null;
            }
        }
        return cTSheetFormatPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetPr getSheetPr() {
        CTSheetPr cTSheetPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetPr = (CTSheetPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSheetPr == null) {
                cTSheetPr = null;
            }
        }
        return cTSheetPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetProtection getSheetProtection() {
        CTSheetProtection cTSheetProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetProtection = (CTSheetProtection) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTSheetProtection == null) {
                cTSheetProtection = null;
            }
        }
        return cTSheetProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetViews getSheetViews() {
        CTSheetViews cTSheetViews;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetViews = (CTSheetViews) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTSheetViews == null) {
                cTSheetViews = null;
            }
        }
        return cTSheetViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSmartTags getSmartTags() {
        CTSmartTags cTSmartTagsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[28], 0);
            if (cTSmartTagsFind_element_user == null) {
                cTSmartTagsFind_element_user = null;
            }
        }
        return cTSmartTagsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSortState getSortState() {
        CTSortState cTSortState;
        synchronized (monitor()) {
            check_orphaned();
            cTSortState = (CTSortState) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTSortState == null) {
                cTSortState = null;
            }
        }
        return cTSortState;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTTableParts getTableParts() {
        CTTableParts cTTableParts;
        synchronized (monitor()) {
            check_orphaned();
            cTTableParts = (CTTableParts) get_store().find_element_user(PROPERTY_QNAME[37], 0);
            if (cTTableParts == null) {
                cTTableParts = null;
            }
        }
        return cTTableParts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTWebPublishItems getWebPublishItems() {
        CTWebPublishItems cTWebPublishItemsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishItemsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[36], 0);
            if (cTWebPublishItemsFind_element_user == null) {
                cTWebPublishItemsFind_element_user = null;
            }
        }
        return cTWebPublishItemsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols insertNewCols(int i5) {
        CTCols cTCols;
        synchronized (monitor()) {
            check_orphaned();
            cTCols = (CTCols) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTCols;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting insertNewConditionalFormatting(int i5) {
        CTConditionalFormatting cTConditionalFormatting;
        synchronized (monitor()) {
            check_orphaned();
            cTConditionalFormatting = (CTConditionalFormatting) get_store().insert_element_user(PROPERTY_QNAME[16], i5);
        }
        return cTConditionalFormatting;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetAutoFilter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetCellWatches() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[26]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetColBreaks() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[24]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetControls() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[35]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetCustomProperties() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[25]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetCustomSheetViews() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDataConsolidate() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDataValidations() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDimension() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDrawing() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[29]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDrawingHF() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[32]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[38]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetHeaderFooter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[22]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetHyperlinks() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetIgnoredErrors() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[27]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetLegacyDrawing() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[30]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetLegacyDrawingHF() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[31]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetMergeCells() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetOleObjects() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[34]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPageMargins() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[20]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPageSetup() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[21]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPhoneticPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPicture() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[33]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPrintOptions() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetProtectedRanges() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetRowBreaks() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[23]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetScenarios() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetCalcPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetFormatPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetProtection() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetViews() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSmartTags() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[28]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSortState() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetTableParts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[37]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetWebPublishItems() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[36]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void removeCols(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void removeConditionalFormatting(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setAutoFilter(CTAutoFilter cTAutoFilter) {
        generatedSetterHelperImpl(cTAutoFilter, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setCellWatches(CTCellWatches cTCellWatches) {
        generatedSetterHelperImpl(cTCellWatches, PROPERTY_QNAME[26], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setColBreaks(CTPageBreak cTPageBreak) {
        generatedSetterHelperImpl(cTPageBreak, PROPERTY_QNAME[24], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setColsArray(CTCols[] cTColsArr) {
        check_orphaned();
        arraySetterHelper(cTColsArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setConditionalFormattingArray(CTConditionalFormatting[] cTConditionalFormattingArr) {
        check_orphaned();
        arraySetterHelper(cTConditionalFormattingArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setControls(CTControls cTControls) {
        generatedSetterHelperImpl(cTControls, PROPERTY_QNAME[35], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setCustomProperties(CTCustomProperties cTCustomProperties) {
        generatedSetterHelperImpl(cTCustomProperties, PROPERTY_QNAME[25], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setCustomSheetViews(CTCustomSheetViews cTCustomSheetViews) {
        generatedSetterHelperImpl(cTCustomSheetViews, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDataConsolidate(CTDataConsolidate cTDataConsolidate) {
        generatedSetterHelperImpl(cTDataConsolidate, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDataValidations(CTDataValidations cTDataValidations) {
        generatedSetterHelperImpl(cTDataValidations, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDimension(CTSheetDimension cTSheetDimension) {
        generatedSetterHelperImpl(cTSheetDimension, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDrawing(CTDrawing cTDrawing) {
        generatedSetterHelperImpl(cTDrawing, PROPERTY_QNAME[29], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDrawingHF(CTDrawingHF cTDrawingHF) {
        generatedSetterHelperImpl(cTDrawingHF, PROPERTY_QNAME[32], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[38], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        generatedSetterHelperImpl(cTHeaderFooter, PROPERTY_QNAME[22], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setHyperlinks(CTHyperlinks cTHyperlinks) {
        generatedSetterHelperImpl(cTHyperlinks, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setIgnoredErrors(CTIgnoredErrors cTIgnoredErrors) {
        generatedSetterHelperImpl(cTIgnoredErrors, PROPERTY_QNAME[27], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing) {
        generatedSetterHelperImpl(cTLegacyDrawing, PROPERTY_QNAME[30], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing) {
        generatedSetterHelperImpl(cTLegacyDrawing, PROPERTY_QNAME[31], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setMergeCells(CTMergeCells cTMergeCells) {
        generatedSetterHelperImpl(cTMergeCells, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setOleObjects(CTOleObjects cTOleObjects) {
        generatedSetterHelperImpl(cTOleObjects, PROPERTY_QNAME[34], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPageMargins(CTPageMargins cTPageMargins) {
        generatedSetterHelperImpl(cTPageMargins, PROPERTY_QNAME[20], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPageSetup(CTPageSetup cTPageSetup) {
        generatedSetterHelperImpl(cTPageSetup, PROPERTY_QNAME[21], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPhoneticPr(CTPhoneticPr cTPhoneticPr) {
        generatedSetterHelperImpl(cTPhoneticPr, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPicture(CTSheetBackgroundPicture cTSheetBackgroundPicture) {
        generatedSetterHelperImpl(cTSheetBackgroundPicture, PROPERTY_QNAME[33], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPrintOptions(CTPrintOptions cTPrintOptions) {
        generatedSetterHelperImpl(cTPrintOptions, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setProtectedRanges(CTProtectedRanges cTProtectedRanges) {
        generatedSetterHelperImpl(cTProtectedRanges, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setRowBreaks(CTPageBreak cTPageBreak) {
        generatedSetterHelperImpl(cTPageBreak, PROPERTY_QNAME[23], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setScenarios(CTScenarios cTScenarios) {
        generatedSetterHelperImpl(cTScenarios, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetCalcPr(CTSheetCalcPr cTSheetCalcPr) {
        generatedSetterHelperImpl(cTSheetCalcPr, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetData(CTSheetData cTSheetData) {
        generatedSetterHelperImpl(cTSheetData, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetFormatPr(CTSheetFormatPr cTSheetFormatPr) {
        generatedSetterHelperImpl(cTSheetFormatPr, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetPr(CTSheetPr cTSheetPr) {
        generatedSetterHelperImpl(cTSheetPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetProtection(CTSheetProtection cTSheetProtection) {
        generatedSetterHelperImpl(cTSheetProtection, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetViews(CTSheetViews cTSheetViews) {
        generatedSetterHelperImpl(cTSheetViews, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSmartTags(CTSmartTags cTSmartTags) {
        generatedSetterHelperImpl(cTSmartTags, PROPERTY_QNAME[28], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSortState(CTSortState cTSortState) {
        generatedSetterHelperImpl(cTSortState, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setTableParts(CTTableParts cTTableParts) {
        generatedSetterHelperImpl(cTTableParts, PROPERTY_QNAME[37], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setWebPublishItems(CTWebPublishItems cTWebPublishItems) {
        generatedSetterHelperImpl(cTWebPublishItems, PROPERTY_QNAME[36], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public int sizeOfColsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public int sizeOfConditionalFormattingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetAutoFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetCellWatches() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetColBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetControls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetCustomProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDataConsolidate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDataValidations() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDimension() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[38], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetHyperlinks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetIgnoredErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetMergeCells() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetOleObjects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPhoneticPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPrintOptions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetProtectedRanges() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetRowBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetScenarios() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetCalcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetFormatPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSortState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetTableParts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[37], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetWebPublishItems() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[36], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols getColsArray(int i5) {
        CTCols cTCols;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCols = (CTCols) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTCols == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCols;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting getConditionalFormattingArray(int i5) {
        CTConditionalFormatting cTConditionalFormatting;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTConditionalFormatting = (CTConditionalFormatting) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (cTConditionalFormatting == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTConditionalFormatting;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setColsArray(int i5, CTCols cTCols) {
        generatedSetterHelperImpl(cTCols, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setConditionalFormattingArray(int i5, CTConditionalFormatting cTConditionalFormatting) {
        generatedSetterHelperImpl(cTConditionalFormatting, PROPERTY_QNAME[16], i5, (short) 2);
    }
}
