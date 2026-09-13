package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRPR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import p5.g0;
import p5.h0;
import p5.i0;
import p5.j0;
import p5.k0;
import p5.l0;
import p5.m0;
import p5.n0;
import p5.o0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTRImpl extends XmlComplexContentImpl implements CTR {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rPr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "rPr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, CompressorStreamFactory.BROTLI), new QName(XSSFRelation.NS_WORDPROCESSINGML, "t"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "contentPart"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "delText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "instrText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "delInstrText"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "noBreakHyphen"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "softHyphen"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "dayShort"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "monthShort"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "yearShort"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "dayLong"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "monthLong"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "yearLong"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "annotationRef"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "footnoteRef"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "endnoteRef"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "separator"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "continuationSeparator"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "sym"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "pgNum"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "cr"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "tab"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "object"), new QName(XSSFRelation.NS_WORDPROCESSINGML, ContentTypes.EXTENSION_PICT), new QName(XSSFRelation.NS_WORDPROCESSINGML, "fldChar"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "ruby"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "footnoteReference"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "endnoteReference"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "commentReference"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "drawing"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "ptab"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "lastRenderedPageBreak"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "t")};
    private static final long serialVersionUID = 1;

    public CTRImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewAnnotationRef() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr addNewBr() {
        CTBr cTBr;
        synchronized (monitor()) {
            check_orphaned();
            cTBr = (CTBr) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup addNewCommentReference() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel addNewContentPart() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewContinuationSeparator() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewCr() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewDayLong() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewDayShort() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewDelInstrText() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewDelText() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewEndnoteRef() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef addNewEndnoteReference() {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar addNewFldChar() {
        CTFldChar cTFldChar;
        synchronized (monitor()) {
            check_orphaned();
            cTFldChar = (CTFldChar) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTFldChar;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewFootnoteRef() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef addNewFootnoteReference() {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewInstrText() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewLastRenderedPageBreak() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewMonthLong() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewMonthShort() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewNoBreakHyphen() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject addNewObject() {
        CTObject cTObject;
        synchronized (monitor()) {
            check_orphaned();
            cTObject = (CTObject) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewPgNum() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture addNewPict() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab addNewPtab() {
        CTPTab cTPTab;
        synchronized (monitor()) {
            check_orphaned();
            cTPTab = (CTPTab) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTPTab;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPR addNewRPr() {
        CTRPR ctrprAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrprAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return ctrprAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPr addNewRPr2() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby addNewRuby() {
        CTRuby cTRuby;
        synchronized (monitor()) {
            check_orphaned();
            cTRuby = (CTRuby) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTRuby;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewSeparator() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewSoftHyphen() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym addNewSym() {
        CTSym cTSym;
        synchronized (monitor()) {
            check_orphaned();
            cTSym = (CTSym) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTSym;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewT() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText addNewT2() {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewTab() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewYearLong() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewYearShort() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getAnnotationRefArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getAnnotationRefList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 27), new h0(this, 15), new k0(this, 2), new i0(this, 15), new j0(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr[] getBrArray() {
        return (CTBr[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTBr[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTBr> getBrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 12), new h0(this, 6), new g0(this, 13), new i0(this, 5), new j0(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup[] getCommentReferenceArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[31], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTMarkup> getCommentReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 15), new h0(this, 7), new g0(this, 16), new i0(this, 6), new j0(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel[] getContentPartArray() {
        return (CTRel[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTRel[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTRel> getContentPartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 25), new h0(this, 12), new g0(this, 26), new i0(this, 12), new j0(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getContinuationSeparatorArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getContinuationSeparatorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 10), new h0(this, 5), new g0(this, 11), new i0(this, 4), new j0(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getCrArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getCrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 16), new h0(this, 23), new k0(this, 17), new i0(this, 23), new j0(this, 23));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getDayLongArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getDayLongList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 5), new h0(this, 4), new g0(this, 14), new i0(this, 8), new j0(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getDayShortArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getDayShortList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 3), new h0(this, 1), new g0(this, 4), new i0(this, 1), new j0(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getDelInstrTextArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getDelInstrTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 20), new h0(this, 27), new k0(this, 29), new n0(this, 1), new o0(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getDelTextArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getDelTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 8), new h0(this, 19), new k0(this, 9), new i0(this, 18), new j0(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing[] getDrawingArray() {
        return (CTDrawing[]) getXmlObjectArray(PROPERTY_QNAME[32], new CTDrawing[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTDrawing> getDrawingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 28), new h0(this, 13), new g0(this, 29), new i0(this, 13), new j0(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getEndnoteRefArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getEndnoteRefList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 8), new h0(this, 3), new g0(this, 9), new i0(this, 3), new j0(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef[] getEndnoteReferenceArray() {
        return (CTFtnEdnRef[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTFtnEdnRef[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTFtnEdnRef> getEndnoteReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 6), new h0(this, 2), new g0(this, 7), new i0(this, 2), new j0(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar[] getFldCharArray() {
        return (CTFldChar[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTFldChar[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTFldChar> getFldCharList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 23), new h0(this, 26), new k0(this, 24), new i0(this, 26), new j0(this, 26));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getFootnoteRefArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getFootnoteRefList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 1), new h0(this, 0), new g0(this, 2), new i0(this, 0), new j0(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef[] getFootnoteReferenceArray() {
        return (CTFtnEdnRef[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTFtnEdnRef[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTFtnEdnRef> getFootnoteReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new l0(this, 0), new m0(this, 0), new l0(this, 1), new i0(this, 29), new j0(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getInstrTextArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getInstrTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 5), new h0(this, 18), new k0(this, 6), new i0(this, 17), new j0(this, 17));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getLastRenderedPageBreakArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[34], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getLastRenderedPageBreakList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new l0(this, 4), new m0(this, 2), new l0(this, 5), new n0(this, 2), new o0(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getMonthLongArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getMonthLongList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 17), new h0(this, 8), new g0(this, 18), new i0(this, 7), new j0(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getMonthShortArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getMonthShortList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 21), new h0(this, 25), new k0(this, 22), new i0(this, 25), new j0(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getNoBreakHyphenArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getNoBreakHyphenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 27), new h0(this, 29), new k0(this, 28), new i0(this, 28), new j0(this, 28));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject[] getObjectArray() {
        return (CTObject[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTObject[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTObject> getObjectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new l0(this, 6), new m0(this, 3), new l0(this, 7), new n0(this, 3), new o0(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getPgNumArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getPgNumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new l0(this, 2), new m0(this, 1), new l0(this, 3), new n0(this, 0), new o0(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture[] getPictArray() {
        return (CTPicture[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTPicture[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTPicture> getPictList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 10), new h0(this, 20), new k0(this, 11), new i0(this, 19), new j0(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab[] getPtabArray() {
        return (CTPTab[]) getXmlObjectArray(PROPERTY_QNAME[33], new CTPTab[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTPTab> getPtabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 23), new h0(this, 11), new g0(this, 24), new i0(this, 11), new j0(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPR getRPr() {
        CTRPR ctrprFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrprFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (ctrprFind_element_user == null) {
                ctrprFind_element_user = null;
            }
        }
        return ctrprFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPr getRPr2() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTRPr == null) {
                cTRPr = null;
            }
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby[] getRubyArray() {
        return (CTRuby[]) getXmlObjectArray(PROPERTY_QNAME[28], new CTRuby[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTRuby> getRubyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 25), new h0(this, 28), new k0(this, 26), new i0(this, 27), new j0(this, 27));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getSeparatorArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getSeparatorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 0), new h0(this, 16), new k0(this, 7), new i0(this, 20), new j0(this, 22));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getSoftHyphenArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getSoftHyphenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 12), new h0(this, 21), new k0(this, 13), new i0(this, 21), new j0(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym[] getSymArray() {
        return (CTSym[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTSym[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTSym> getSymList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 19), new h0(this, 9), new g0(this, 20), new i0(this, 9), new j0(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText[] getT2Array() {
        return (org.openxmlformats.schemas.officeDocument.x2006.math.CTText[]) getXmlObjectArray(PROPERTY_QNAME[35], new org.openxmlformats.schemas.officeDocument.x2006.math.CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<org.openxmlformats.schemas.officeDocument.x2006.math.CTText> getT2List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 0), new h0(this, 14), new k0(this, 1), new i0(this, 14), new j0(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getTArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getTList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 18), new h0(this, 24), new k0(this, 19), new i0(this, 24), new j0(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getTabArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getTabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new g0(this, 21), new h0(this, 10), new g0(this, 22), new i0(this, 10), new j0(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getYearLongArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getYearLongList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 14), new h0(this, 22), new k0(this, 15), new i0(this, 22), new j0(this, 21));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getYearShortArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getYearShortList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new k0(this, 3), new h0(this, 17), new k0(this, 4), new i0(this, 16), new j0(this, 16));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewAnnotationRef(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[16], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr insertNewBr(int i5) {
        CTBr cTBr;
        synchronized (monitor()) {
            check_orphaned();
            cTBr = (CTBr) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTBr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup insertNewCommentReference(int i5) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[31], i5);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel insertNewContentPart(int i5) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewContinuationSeparator(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[20], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewCr(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[23], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewDayLong(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[13], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewDayShort(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewDelInstrText(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewDelText(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing insertNewDrawing(int i5) {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().insert_element_user(PROPERTY_QNAME[32], i5);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewEndnoteRef(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[18], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef insertNewEndnoteReference(int i5) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().insert_element_user(PROPERTY_QNAME[30], i5);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar insertNewFldChar(int i5) {
        CTFldChar cTFldChar;
        synchronized (monitor()) {
            check_orphaned();
            cTFldChar = (CTFldChar) get_store().insert_element_user(PROPERTY_QNAME[27], i5);
        }
        return cTFldChar;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewFootnoteRef(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[17], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef insertNewFootnoteReference(int i5) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().insert_element_user(PROPERTY_QNAME[29], i5);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewInstrText(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewLastRenderedPageBreak(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[34], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewMonthLong(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[14], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewMonthShort(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewNoBreakHyphen(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject insertNewObject(int i5) {
        CTObject cTObject;
        synchronized (monitor()) {
            check_orphaned();
            cTObject = (CTObject) get_store().insert_element_user(PROPERTY_QNAME[25], i5);
        }
        return cTObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewPgNum(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[22], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture insertNewPict(int i5) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().insert_element_user(PROPERTY_QNAME[26], i5);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab insertNewPtab(int i5) {
        CTPTab cTPTab;
        synchronized (monitor()) {
            check_orphaned();
            cTPTab = (CTPTab) get_store().insert_element_user(PROPERTY_QNAME[33], i5);
        }
        return cTPTab;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby insertNewRuby(int i5) {
        CTRuby cTRuby;
        synchronized (monitor()) {
            check_orphaned();
            cTRuby = (CTRuby) get_store().insert_element_user(PROPERTY_QNAME[28], i5);
        }
        return cTRuby;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewSeparator(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[19], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewSoftHyphen(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym insertNewSym(int i5) {
        CTSym cTSym;
        synchronized (monitor()) {
            check_orphaned();
            cTSym = (CTSym) get_store().insert_element_user(PROPERTY_QNAME[21], i5);
        }
        return cTSym;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewT(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText insertNewT2(int i5) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) get_store().insert_element_user(PROPERTY_QNAME[35], i5);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewTab(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[24], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewYearLong(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[15], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewYearShort(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[12], i5);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public boolean isSetRPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public boolean isSetRPr2() {
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

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeAnnotationRef(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeBr(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeCommentReference(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeContentPart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeContinuationSeparator(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeCr(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDayLong(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDayShort(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDelInstrText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDelText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDrawing(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeEndnoteRef(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeEndnoteReference(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeFldChar(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeFootnoteRef(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeFootnoteReference(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeInstrText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeLastRenderedPageBreak(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeMonthLong(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeMonthShort(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeNoBreakHyphen(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeObject(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removePgNum(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removePict(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removePtab(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeRuby(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeSeparator(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeSoftHyphen(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeSym(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeT(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeT2(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeTab(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeYearLong(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeYearShort(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setAnnotationRefArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setBrArray(CTBr[] cTBrArr) {
        check_orphaned();
        arraySetterHelper(cTBrArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCommentReferenceArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[31]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContentPartArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContinuationSeparatorArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCrArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayLongArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayShortArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelInstrTextArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelTextArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDrawingArray(CTDrawing[] cTDrawingArr) {
        check_orphaned();
        arraySetterHelper(cTDrawingArr, PROPERTY_QNAME[32]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteRefArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr) {
        check_orphaned();
        arraySetterHelper(cTFtnEdnRefArr, PROPERTY_QNAME[30]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFldCharArray(CTFldChar[] cTFldCharArr) {
        check_orphaned();
        arraySetterHelper(cTFldCharArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteRefArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr) {
        check_orphaned();
        arraySetterHelper(cTFtnEdnRefArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setInstrTextArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setLastRenderedPageBreakArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[34]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthLongArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthShortArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setNoBreakHyphenArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setObjectArray(CTObject[] cTObjectArr) {
        check_orphaned();
        arraySetterHelper(cTObjectArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPgNumArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPictArray(CTPicture[] cTPictureArr) {
        check_orphaned();
        arraySetterHelper(cTPictureArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPtabArray(CTPTab[] cTPTabArr) {
        check_orphaned();
        arraySetterHelper(cTPTabArr, PROPERTY_QNAME[33]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRPr(CTRPR ctrpr) {
        generatedSetterHelperImpl(ctrpr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRPr2(CTRPr cTRPr) {
        generatedSetterHelperImpl(cTRPr, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRubyArray(CTRuby[] cTRubyArr) {
        check_orphaned();
        arraySetterHelper(cTRubyArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSeparatorArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSoftHyphenArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSymArray(CTSym[] cTSymArr) {
        check_orphaned();
        arraySetterHelper(cTSymArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setT2Array(org.openxmlformats.schemas.officeDocument.x2006.math.CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[35]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTabArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearLongArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearShortArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfAnnotationRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfBrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfCommentReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfContentPartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfContinuationSeparatorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfCrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDayLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDayShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDelInstrTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDelTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDrawingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfEndnoteRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfEndnoteReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfFldCharArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfFootnoteRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfFootnoteReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfInstrTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfLastRenderedPageBreakArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfMonthLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfMonthShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfNoBreakHyphenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfPgNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfPictArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfPtabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfRubyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfSeparatorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfSoftHyphenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfSymArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfT2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[35]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfTArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfYearLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfYearShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void unsetRPr2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getAnnotationRefArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr getBrArray(int i5) {
        CTBr cTBr;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBr = (CTBr) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTBr == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup getCommentReferenceArray(int i5) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[31], i5);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel getContentPartArray(int i5) {
        CTRel cTRel;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRel = (CTRel) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTRel == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getContinuationSeparatorArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getCrArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getDayLongArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getDayShortArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getDelInstrTextArray(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTText == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getDelTextArray(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (cTText == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing getDrawingArray(int i5) {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDrawing = (CTDrawing) get_store().find_element_user(PROPERTY_QNAME[32], i5);
                if (cTDrawing == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getEndnoteRefArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef getEndnoteReferenceArray(int i5) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFtnEdnRef = (CTFtnEdnRef) get_store().find_element_user(PROPERTY_QNAME[30], i5);
                if (cTFtnEdnRef == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar getFldCharArray(int i5) {
        CTFldChar cTFldChar;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFldChar = (CTFldChar) get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (cTFldChar == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFldChar;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getFootnoteRefArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef getFootnoteReferenceArray(int i5) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFtnEdnRef = (CTFtnEdnRef) get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (cTFtnEdnRef == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getInstrTextArray(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (cTText == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getLastRenderedPageBreakArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[34], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getMonthLongArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getMonthShortArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getNoBreakHyphenArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject getObjectArray(int i5) {
        CTObject cTObject;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTObject = (CTObject) get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (cTObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getPgNumArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture getPictArray(int i5) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPicture = (CTPicture) get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (cTPicture == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab getPtabArray(int i5) {
        CTPTab cTPTab;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPTab = (CTPTab) get_store().find_element_user(PROPERTY_QNAME[33], i5);
                if (cTPTab == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPTab;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby getRubyArray(int i5) {
        CTRuby cTRuby;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRuby = (CTRuby) get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (cTRuby == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRuby;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getSeparatorArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getSoftHyphenArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym getSymArray(int i5) {
        CTSym cTSym;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSym = (CTSym) get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (cTSym == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSym;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText getT2Array(int i5) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTText = (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) get_store().find_element_user(PROPERTY_QNAME[35], i5);
                if (cTText == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getTArray(int i5) {
        CTText cTText;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTText == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getTabArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getYearLongArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getYearShortArray(int i5) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (cTEmpty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setAnnotationRefArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[16], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setBrArray(int i5, CTBr cTBr) {
        generatedSetterHelperImpl(cTBr, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCommentReferenceArray(int i5, CTMarkup cTMarkup) {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[31], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContentPartArray(int i5, CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContinuationSeparatorArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[20], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCrArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[23], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayLongArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[13], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayShortArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[10], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelInstrTextArray(int i5, CTText cTText) {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelTextArray(int i5, CTText cTText) {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[5], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDrawingArray(int i5, CTDrawing cTDrawing) {
        generatedSetterHelperImpl(cTDrawing, PROPERTY_QNAME[32], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteRefArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[18], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteReferenceArray(int i5, CTFtnEdnRef cTFtnEdnRef) {
        generatedSetterHelperImpl(cTFtnEdnRef, PROPERTY_QNAME[30], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFldCharArray(int i5, CTFldChar cTFldChar) {
        generatedSetterHelperImpl(cTFldChar, PROPERTY_QNAME[27], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteRefArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[17], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteReferenceArray(int i5, CTFtnEdnRef cTFtnEdnRef) {
        generatedSetterHelperImpl(cTFtnEdnRef, PROPERTY_QNAME[29], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setInstrTextArray(int i5, CTText cTText) {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[6], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setLastRenderedPageBreakArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[34], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthLongArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[14], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthShortArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[11], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setNoBreakHyphenArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[8], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setObjectArray(int i5, CTObject cTObject) {
        generatedSetterHelperImpl(cTObject, PROPERTY_QNAME[25], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPgNumArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[22], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPictArray(int i5, CTPicture cTPicture) {
        generatedSetterHelperImpl(cTPicture, PROPERTY_QNAME[26], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPtabArray(int i5, CTPTab cTPTab) {
        generatedSetterHelperImpl(cTPTab, PROPERTY_QNAME[33], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRubyArray(int i5, CTRuby cTRuby) {
        generatedSetterHelperImpl(cTRuby, PROPERTY_QNAME[28], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSeparatorArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[19], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSoftHyphenArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[9], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSymArray(int i5, CTSym cTSym) {
        generatedSetterHelperImpl(cTSym, PROPERTY_QNAME[21], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setT2Array(int i5, org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText) {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[35], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTArray(int i5, CTText cTText) {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTabArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[24], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearLongArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[15], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearShortArray(int i5, CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[12], i5, (short) 2);
    }
}
