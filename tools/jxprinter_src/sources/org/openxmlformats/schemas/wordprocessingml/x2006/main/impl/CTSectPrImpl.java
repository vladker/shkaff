package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEdnProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLineNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPaperSource;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import s5.C1664e3;
import s5.C1669f3;
import s5.C1674g3;
import s5.C1679h3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSectPrImpl extends XmlComplexContentImpl implements CTSectPr {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "headerReference"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "footerReference"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "footnotePr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "endnotePr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "type"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "pgSz"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "pgMar"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "paperSrc"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "pgBorders"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "lnNumType"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "pgNumType"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "cols"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "formProt"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "vAlign"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "noEndnote"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "titlePg"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "textDirection"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "bidi"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rtlGutter"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "docGrid"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "printerSettings"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "sectPrChange"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rsidRPr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rsidDel"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rsidR"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rsidSect")};
    private static final long serialVersionUID = 1;

    public CTSectPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewBidi() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTColumns addNewCols() {
        CTColumns cTColumns;
        synchronized (monitor()) {
            check_orphaned();
            cTColumns = (CTColumns) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTColumns;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTDocGrid addNewDocGrid() {
        CTDocGrid cTDocGrid;
        synchronized (monitor()) {
            check_orphaned();
            cTDocGrid = (CTDocGrid) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTDocGrid;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTEdnProps addNewEndnotePr() {
        CTEdnProps cTEdnProps;
        synchronized (monitor()) {
            check_orphaned();
            cTEdnProps = (CTEdnProps) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTEdnProps;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef addNewFooterReference() {
        CTHdrFtrRef cTHdrFtrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRef = (CTHdrFtrRef) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTHdrFtrRef;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTFtnProps addNewFootnotePr() {
        CTFtnProps cTFtnProps;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnProps = (CTFtnProps) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTFtnProps;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewFormProt() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef addNewHeaderReference() {
        CTHdrFtrRef cTHdrFtrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRef = (CTHdrFtrRef) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTHdrFtrRef;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTLineNumber addNewLnNumType() {
        CTLineNumber cTLineNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTLineNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewNoEndnote() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPaperSource addNewPaperSrc() {
        CTPaperSource cTPaperSource;
        synchronized (monitor()) {
            check_orphaned();
            cTPaperSource = (CTPaperSource) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTPaperSource;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageBorders addNewPgBorders() {
        CTPageBorders cTPageBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBorders = (CTPageBorders) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTPageBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageMar addNewPgMar() {
        CTPageMar cTPageMar;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMar = (CTPageMar) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTPageMar;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageNumber addNewPgNumType() {
        CTPageNumber cTPageNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTPageNumber = (CTPageNumber) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTPageNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageSz addNewPgSz() {
        CTPageSz cTPageSz;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSz = (CTPageSz) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPageSz;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTRel addNewPrinterSettings() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewRtlGutter() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectPrChange addNewSectPrChange() {
        CTSectPrChange cTSectPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSectPrChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTSectPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTTextDirection addNewTextDirection() {
        CTTextDirection cTTextDirection;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirection = (CTTextDirection) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTTextDirection;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff addNewTitlePg() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectType addNewType() {
        CTSectType cTSectType;
        synchronized (monitor()) {
            check_orphaned();
            cTSectType = (CTSectType) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTSectType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTVerticalJc addNewVAlign() {
        CTVerticalJc cTVerticalJc;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJc = (CTVerticalJc) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTVerticalJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getBidi() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTColumns getCols() {
        CTColumns cTColumns;
        synchronized (monitor()) {
            check_orphaned();
            cTColumns = (CTColumns) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTColumns == null) {
                cTColumns = null;
            }
        }
        return cTColumns;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTDocGrid getDocGrid() {
        CTDocGrid cTDocGrid;
        synchronized (monitor()) {
            check_orphaned();
            cTDocGrid = (CTDocGrid) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (cTDocGrid == null) {
                cTDocGrid = null;
            }
        }
        return cTDocGrid;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTEdnProps getEndnotePr() {
        CTEdnProps cTEdnProps;
        synchronized (monitor()) {
            check_orphaned();
            cTEdnProps = (CTEdnProps) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTEdnProps == null) {
                cTEdnProps = null;
            }
        }
        return cTEdnProps;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef[] getFooterReferenceArray() {
        return (CTHdrFtrRef[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTHdrFtrRef[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public List<CTHdrFtrRef> getFooterReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1664e3(this, 0), new C1669f3(this, 0), new C1664e3(this, 1), new C1674g3(this, 0), new C1679h3(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTFtnProps getFootnotePr() {
        CTFtnProps cTFtnProps;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnProps = (CTFtnProps) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTFtnProps == null) {
                cTFtnProps = null;
            }
        }
        return cTFtnProps;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getFormProt() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef[] getHeaderReferenceArray() {
        return (CTHdrFtrRef[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTHdrFtrRef[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public List<CTHdrFtrRef> getHeaderReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1664e3(this, 2), new C1669f3(this, 1), new C1664e3(this, 3), new C1674g3(this, 1), new C1679h3(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTLineNumber getLnNumType() {
        CTLineNumber cTLineNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTLineNumberFind_element_user == null) {
                cTLineNumberFind_element_user = null;
            }
        }
        return cTLineNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getNoEndnote() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPaperSource getPaperSrc() {
        CTPaperSource cTPaperSource;
        synchronized (monitor()) {
            check_orphaned();
            cTPaperSource = (CTPaperSource) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTPaperSource == null) {
                cTPaperSource = null;
            }
        }
        return cTPaperSource;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageBorders getPgBorders() {
        CTPageBorders cTPageBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBorders = (CTPageBorders) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTPageBorders == null) {
                cTPageBorders = null;
            }
        }
        return cTPageBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageMar getPgMar() {
        CTPageMar cTPageMar;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMar = (CTPageMar) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTPageMar == null) {
                cTPageMar = null;
            }
        }
        return cTPageMar;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageNumber getPgNumType() {
        CTPageNumber cTPageNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTPageNumber = (CTPageNumber) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTPageNumber == null) {
                cTPageNumber = null;
            }
        }
        return cTPageNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTPageSz getPgSz() {
        CTPageSz cTPageSz;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSz = (CTPageSz) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPageSz == null) {
                cTPageSz = null;
            }
        }
        return cTPageSz;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTRel getPrinterSettings() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().find_element_user(PROPERTY_QNAME[20], 0);
            if (cTRel == null) {
                cTRel = null;
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidDel() {
        byte[] byteArrayValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[23]);
            byteArrayValue = simpleValue == null ? null : simpleValue.getByteArrayValue();
        }
        return byteArrayValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidR() {
        byte[] byteArrayValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[24]);
            byteArrayValue = simpleValue == null ? null : simpleValue.getByteArrayValue();
        }
        return byteArrayValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidRPr() {
        byte[] byteArrayValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[22]);
            byteArrayValue = simpleValue == null ? null : simpleValue.getByteArrayValue();
        }
        return byteArrayValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public byte[] getRsidSect() {
        byte[] byteArrayValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[25]);
            byteArrayValue = simpleValue == null ? null : simpleValue.getByteArrayValue();
        }
        return byteArrayValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getRtlGutter() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectPrChange getSectPrChange() {
        CTSectPrChange cTSectPrChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSectPrChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], 0);
            if (cTSectPrChangeFind_element_user == null) {
                cTSectPrChangeFind_element_user = null;
            }
        }
        return cTSectPrChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTTextDirection getTextDirection() {
        CTTextDirection cTTextDirection;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirection = (CTTextDirection) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            if (cTTextDirection == null) {
                cTTextDirection = null;
            }
        }
        return cTTextDirection;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTOnOff getTitlePg() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTSectType getType() {
        CTSectType cTSectType;
        synchronized (monitor()) {
            check_orphaned();
            cTSectType = (CTSectType) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTSectType == null) {
                cTSectType = null;
            }
        }
        return cTSectType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTVerticalJc getVAlign() {
        CTVerticalJc cTVerticalJc;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJc = (CTVerticalJc) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTVerticalJc == null) {
                cTVerticalJc = null;
            }
        }
        return cTVerticalJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef insertNewFooterReference(int i5) {
        CTHdrFtrRef cTHdrFtrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRef = (CTHdrFtrRef) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTHdrFtrRef;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef insertNewHeaderReference(int i5) {
        CTHdrFtrRef cTHdrFtrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrRef = (CTHdrFtrRef) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTHdrFtrRef;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetBidi() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetCols() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetDocGrid() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetEndnotePr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetFootnotePr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetFormProt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetLnNumType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetNoEndnote() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPaperSrc() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgBorders() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgMar() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgNumType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPgSz() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetPrinterSettings() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[20]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidDel() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[23]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidR() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[24]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidRPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[22]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRsidSect() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[25]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetRtlGutter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetSectPrChange() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[21]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetTextDirection() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetTitlePg() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public boolean isSetVAlign() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void removeFooterReference(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void removeHeaderReference(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setBidi(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setCols(CTColumns cTColumns) {
        generatedSetterHelperImpl(cTColumns, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setDocGrid(CTDocGrid cTDocGrid) {
        generatedSetterHelperImpl(cTDocGrid, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setEndnotePr(CTEdnProps cTEdnProps) {
        generatedSetterHelperImpl(cTEdnProps, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFooterReferenceArray(CTHdrFtrRef[] cTHdrFtrRefArr) {
        check_orphaned();
        arraySetterHelper(cTHdrFtrRefArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFootnotePr(CTFtnProps cTFtnProps) {
        generatedSetterHelperImpl(cTFtnProps, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFormProt(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setHeaderReferenceArray(CTHdrFtrRef[] cTHdrFtrRefArr) {
        check_orphaned();
        arraySetterHelper(cTHdrFtrRefArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setLnNumType(CTLineNumber cTLineNumber) {
        generatedSetterHelperImpl(cTLineNumber, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setNoEndnote(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPaperSrc(CTPaperSource cTPaperSource) {
        generatedSetterHelperImpl(cTPaperSource, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgBorders(CTPageBorders cTPageBorders) {
        generatedSetterHelperImpl(cTPageBorders, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgMar(CTPageMar cTPageMar) {
        generatedSetterHelperImpl(cTPageMar, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgNumType(CTPageNumber cTPageNumber) {
        generatedSetterHelperImpl(cTPageNumber, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPgSz(CTPageSz cTPageSz) {
        generatedSetterHelperImpl(cTPageSz, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setPrinterSettings(CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[20], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidDel(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[23]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[23]);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidR(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[24]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[24]);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidRPr(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[22]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[22]);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRsidSect(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[25]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[25]);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setRtlGutter(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setSectPrChange(CTSectPrChange cTSectPrChange) {
        generatedSetterHelperImpl(cTSectPrChange, PROPERTY_QNAME[21], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setTextDirection(CTTextDirection cTTextDirection) {
        generatedSetterHelperImpl(cTTextDirection, PROPERTY_QNAME[16], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setTitlePg(CTOnOff cTOnOff) {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setType(CTSectType cTSectType) {
        generatedSetterHelperImpl(cTSectType, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setVAlign(CTVerticalJc cTVerticalJc) {
        generatedSetterHelperImpl(cTVerticalJc, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public int sizeOfFooterReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public int sizeOfHeaderReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetBidi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetCols() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetDocGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetEndnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetFootnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetFormProt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetLnNumType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetNoEndnote() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPaperSrc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgNumType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPgSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetPrinterSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[23]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[24]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[22]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRsidSect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[25]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetRtlGutter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetSectPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetTitlePg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void unsetVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidDel() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(PROPERTY_QNAME[23]);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidR() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(PROPERTY_QNAME[24]);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidRPr() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(PROPERTY_QNAME[22]);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public STLongHexNumber xgetRsidSect() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(PROPERTY_QNAME[25]);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidDel(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qNameArr[23]);
                if (sTLongHexNumber2 == null) {
                    sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qNameArr[23]);
                }
                sTLongHexNumber2.set(sTLongHexNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidR(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qNameArr[24]);
                if (sTLongHexNumber2 == null) {
                    sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qNameArr[24]);
                }
                sTLongHexNumber2.set(sTLongHexNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidRPr(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qNameArr[22]);
                if (sTLongHexNumber2 == null) {
                    sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qNameArr[22]);
                }
                sTLongHexNumber2.set(sTLongHexNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void xsetRsidSect(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qNameArr[25]);
                if (sTLongHexNumber2 == null) {
                    sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qNameArr[25]);
                }
                sTLongHexNumber2.set(sTLongHexNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef getFooterReferenceArray(int i5) {
        CTHdrFtrRef cTHdrFtrRef;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTHdrFtrRef = (CTHdrFtrRef) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTHdrFtrRef == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTHdrFtrRef;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public CTHdrFtrRef getHeaderReferenceArray(int i5) {
        CTHdrFtrRef cTHdrFtrRef;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTHdrFtrRef = (CTHdrFtrRef) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTHdrFtrRef == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTHdrFtrRef;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setFooterReferenceArray(int i5, CTHdrFtrRef cTHdrFtrRef) {
        generatedSetterHelperImpl(cTHdrFtrRef, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr
    public void setHeaderReferenceArray(int i5, CTHdrFtrRef cTHdrFtrRef) {
        generatedSetterHelperImpl(cTHdrFtrRef, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
