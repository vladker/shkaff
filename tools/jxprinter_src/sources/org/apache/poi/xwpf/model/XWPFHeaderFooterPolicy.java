package org.apache.poi.xwpf.model;

import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTH;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.STExt;
import java.util.Iterator;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFactory;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFHeaderFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFHeaderFooterPolicy {
    public static final STHdrFtr.Enum DEFAULT = STHdrFtr.DEFAULT;
    public static final STHdrFtr.Enum EVEN = STHdrFtr.EVEN;
    public static final STHdrFtr.Enum FIRST = STHdrFtr.FIRST;
    private XWPFFooter defaultFooter;
    private XWPFHeader defaultHeader;
    private XWPFDocument doc;
    private XWPFFooter evenPageFooter;
    private XWPFHeader evenPageHeader;
    private XWPFFooter firstPageFooter;
    private XWPFHeader firstPageHeader;
    private CTSectPr sectPr;

    public XWPFHeaderFooterPolicy(XWPFDocument xWPFDocument) {
        this(xWPFDocument, null);
    }

    private void assignFooter(XWPFFooter xWPFFooter, STHdrFtr.Enum r6) {
        if (r6 == STHdrFtr.FIRST) {
            this.firstPageFooter = xWPFFooter;
        } else if (r6 == STHdrFtr.EVEN) {
            this.evenPageFooter = xWPFFooter;
        } else {
            this.defaultFooter = xWPFFooter;
        }
    }

    private void assignHeader(XWPFHeader xWPFHeader, STHdrFtr.Enum r6) {
        if (r6 == STHdrFtr.FIRST) {
            this.firstPageHeader = xWPFHeader;
        } else if (r6 == STHdrFtr.EVEN) {
            this.evenPageHeader = xWPFHeader;
        } else {
            this.defaultHeader = xWPFHeader;
        }
    }

    private CTHdrFtr buildFtr(STHdrFtr.Enum r6, XWPFHeaderFooter xWPFHeaderFooter, XWPFParagraph[] xWPFParagraphArr) {
        CTHdrFtr cTHdrFtrBuildHdrFtr = buildHdrFtr(xWPFParagraphArr, xWPFHeaderFooter);
        setFooterReference(r6, xWPFHeaderFooter);
        return cTHdrFtrBuildHdrFtr;
    }

    private CTHdrFtr buildHdr(STHdrFtr.Enum r6, XWPFHeaderFooter xWPFHeaderFooter, XWPFParagraph[] xWPFParagraphArr) {
        CTHdrFtr cTHdrFtrBuildHdrFtr = buildHdrFtr(xWPFParagraphArr, xWPFHeaderFooter);
        setHeaderReference(r6, xWPFHeaderFooter);
        return cTHdrFtrBuildHdrFtr;
    }

    private CTHdrFtr buildHdrFtr(XWPFParagraph[] xWPFParagraphArr, XWPFHeaderFooter xWPFHeaderFooter) {
        CTHdrFtr cTHdrFtr_getHdrFtr = xWPFHeaderFooter._getHdrFtr();
        if (xWPFParagraphArr != null) {
            for (int i5 = 0; i5 < xWPFParagraphArr.length; i5++) {
                cTHdrFtr_getHdrFtr.addNewP();
                cTHdrFtr_getHdrFtr.setPArray(i5, xWPFParagraphArr[i5].getCTP());
            }
        }
        return cTHdrFtr_getHdrFtr;
    }

    private int getRelationIndex(XWPFRelation xWPFRelation) {
        Iterator<POIXMLDocumentPart.RelationPart> it = this.doc.getRelationParts().iterator();
        int i5 = 1;
        while (it.hasNext()) {
            if (it.next().getRelationship().getRelationshipType().equals(xWPFRelation.getRelation())) {
                i5++;
            }
        }
        return i5;
    }

    private XWPFParagraph getWatermarkParagraph(String str, int i5) {
        byte[] rsidRDefault;
        byte[] bArr;
        CTP ctpNewInstance = CTP.Factory.newInstance();
        CTBody body = this.doc.getDocument().getBody();
        if (body.sizeOfPArray() == 0) {
            bArr = null;
            rsidRDefault = null;
        } else {
            CTP pArray = body.getPArray(0);
            byte[] rsidR = pArray.getRsidR();
            rsidRDefault = pArray.getRsidRDefault();
            bArr = rsidR;
        }
        ctpNewInstance.setRsidP(bArr);
        ctpNewInstance.setRsidRDefault(rsidRDefault);
        ctpNewInstance.addNewPPr().addNewPStyle().setVal("Header");
        CTR ctrAddNewR = ctpNewInstance.addNewR();
        ctrAddNewR.addNewRPr().addNewNoProof();
        CTPicture cTPictureAddNewPict = ctrAddNewR.addNewPict();
        CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
        CTShapetype cTShapetypeAddNewShapetype = cTGroupNewInstance.addNewShapetype();
        cTShapetypeAddNewShapetype.setId("_x0000_t136");
        cTShapetypeAddNewShapetype.setCoordsize("1600,21600");
        cTShapetypeAddNewShapetype.setSpt(136.0f);
        cTShapetypeAddNewShapetype.setAdj("10800");
        cTShapetypeAddNewShapetype.setPath2("m@7,0l@8,0m@5,21600l@6,21600e");
        CTFormulas cTFormulasAddNewFormulas = cTShapetypeAddNewShapetype.addNewFormulas();
        cTFormulasAddNewFormulas.addNewF().setEqn("sum #0 0 10800");
        cTFormulasAddNewFormulas.addNewF().setEqn("prod #0 2 1");
        cTFormulasAddNewFormulas.addNewF().setEqn("sum 21600 0 @1");
        cTFormulasAddNewFormulas.addNewF().setEqn("sum 0 0 @2");
        cTFormulasAddNewFormulas.addNewF().setEqn("sum 21600 0 @3");
        cTFormulasAddNewFormulas.addNewF().setEqn("if @0 @3 0");
        cTFormulasAddNewFormulas.addNewF().setEqn("if @0 21600 @1");
        cTFormulasAddNewFormulas.addNewF().setEqn("if @0 0 @2");
        cTFormulasAddNewFormulas.addNewF().setEqn("if @0 @4 21600");
        cTFormulasAddNewFormulas.addNewF().setEqn("mid @5 @6");
        cTFormulasAddNewFormulas.addNewF().setEqn("mid @8 @5");
        cTFormulasAddNewFormulas.addNewF().setEqn("mid @7 @8");
        cTFormulasAddNewFormulas.addNewF().setEqn("mid @6 @7");
        cTFormulasAddNewFormulas.addNewF().setEqn("sum @6 0 @5");
        CTPath cTPathAddNewPath = cTShapetypeAddNewShapetype.addNewPath();
        STTrueFalse.Enum r6 = STTrueFalse.f7724T;
        cTPathAddNewPath.setTextpathok(r6);
        cTPathAddNewPath.setConnecttype(STConnectType.CUSTOM);
        cTPathAddNewPath.setConnectlocs("@9,0;@10,10800;@11,21600;@12,10800");
        cTPathAddNewPath.setConnectangles("270,180,90,0");
        CTTextPath cTTextPathAddNewTextpath = cTShapetypeAddNewShapetype.addNewTextpath();
        cTTextPathAddNewTextpath.setOn(r6);
        cTTextPathAddNewTextpath.setFitshape(r6);
        CTH cthAddNewH = cTShapetypeAddNewShapetype.addNewHandles().addNewH();
        cthAddNewH.setPosition("#0,bottomRight");
        cthAddNewH.setXrange("6629,14971");
        cTShapetypeAddNewShapetype.addNewLock().setExt(STExt.EDIT);
        CTShape cTShapeAddNewShape = cTGroupNewInstance.addNewShape();
        cTShapeAddNewShape.setId("PowerPlusWaterMarkObject" + i5);
        cTShapeAddNewShape.setSpid("_x0000_s102" + (i5 + 4));
        cTShapeAddNewShape.setType("#_x0000_t136");
        cTShapeAddNewShape.setStyle("position:absolute;margin-left:0;margin-top:0;width:415pt;height:207.5pt;z-index:-251654144;mso-wrap-edited:f;mso-position-horizontal:center;mso-position-horizontal-relative:margin;mso-position-vertical:center;mso-position-vertical-relative:margin");
        cTShapeAddNewShape.setWrapcoords("616 5068 390 16297 39 16921 -39 17155 7265 17545 7186 17467 -39 17467 18904 17467 10507 17467 8710 17545 18904 17077 18787 16843 18358 16297 18279 12554 19178 12476 20701 11774 20779 11228 21131 10059 21248 8811 21248 7563 20975 6316 20935 5380 19490 5146 14022 5068 2616 5068");
        cTShapeAddNewShape.setFillcolor("black");
        cTShapeAddNewShape.setStroked(STTrueFalse.FALSE);
        CTTextPath cTTextPathAddNewTextpath2 = cTShapeAddNewShape.addNewTextpath();
        cTTextPathAddNewTextpath2.setStyle("font-family:&quot;Cambria&quot;;font-size:1pt");
        cTTextPathAddNewTextpath2.setString(str);
        cTPictureAddNewPict.set(cTGroupNewInstance);
        return new XWPFParagraph(ctpNewInstance, this.doc);
    }

    private void setFooterReference(STHdrFtr.Enum r6, XWPFHeaderFooter xWPFHeaderFooter) {
        CTHdrFtrRef cTHdrFtrRefAddNewFooterReference = this.sectPr.addNewFooterReference();
        cTHdrFtrRefAddNewFooterReference.setType(r6);
        cTHdrFtrRefAddNewFooterReference.setId(this.doc.getRelationId(xWPFHeaderFooter));
    }

    private void setHeaderReference(STHdrFtr.Enum r6, XWPFHeaderFooter xWPFHeaderFooter) {
        CTHdrFtrRef cTHdrFtrRefAddNewHeaderReference = this.sectPr.addNewHeaderReference();
        cTHdrFtrRefAddNewHeaderReference.setType(r6);
        cTHdrFtrRefAddNewHeaderReference.setId(this.doc.getRelationId(xWPFHeaderFooter));
    }

    public XWPFFooter createFooter(STHdrFtr.Enum r6) {
        return createFooter(r6, null);
    }

    public XWPFHeader createHeader(STHdrFtr.Enum r6) {
        return createHeader(r6, null);
    }

    public void createWatermark(String str) {
        XWPFParagraph[] xWPFParagraphArr = {getWatermarkParagraph(str, 1)};
        createHeader(DEFAULT, xWPFParagraphArr);
        xWPFParagraphArr[0] = getWatermarkParagraph(str, 2);
        createHeader(FIRST, xWPFParagraphArr);
        xWPFParagraphArr[0] = getWatermarkParagraph(str, 3);
        createHeader(EVEN, xWPFParagraphArr);
    }

    public XWPFFooter getDefaultFooter() {
        return this.defaultFooter;
    }

    public XWPFHeader getDefaultHeader() {
        return this.defaultHeader;
    }

    public XWPFFooter getEvenPageFooter() {
        return this.evenPageFooter;
    }

    public XWPFHeader getEvenPageHeader() {
        return this.evenPageHeader;
    }

    public XWPFFooter getFirstPageFooter() {
        return this.firstPageFooter;
    }

    public XWPFHeader getFirstPageHeader() {
        return this.firstPageHeader;
    }

    public XWPFFooter getFooter(int i5) {
        XWPFFooter xWPFFooter;
        XWPFFooter xWPFFooter2;
        if (i5 != 1 || (xWPFFooter2 = this.firstPageFooter) == null) {
            return (i5 % 2 != 0 || (xWPFFooter = this.evenPageFooter) == null) ? this.defaultFooter : xWPFFooter;
        }
        return xWPFFooter2;
    }

    public XWPFHeader getHeader(int i5) {
        XWPFHeader xWPFHeader;
        XWPFHeader xWPFHeader2;
        if (i5 != 1 || (xWPFHeader2 = this.firstPageHeader) == null) {
            return (i5 % 2 != 0 || (xWPFHeader = this.evenPageHeader) == null) ? this.defaultHeader : xWPFHeader;
        }
        return xWPFHeader2;
    }

    public XWPFFooter getOddPageFooter() {
        return this.defaultFooter;
    }

    public XWPFHeader getOddPageHeader() {
        return this.defaultHeader;
    }

    public XWPFHeaderFooterPolicy(XWPFDocument xWPFDocument, CTSectPr cTSectPr) {
        STHdrFtr.Enum type;
        STHdrFtr.Enum type2;
        if (cTSectPr == null) {
            CTBody body = xWPFDocument.getDocument().getBody();
            cTSectPr = body.isSetSectPr() ? body.getSectPr() : body.addNewSectPr();
        }
        this.doc = xWPFDocument;
        this.sectPr = cTSectPr;
        int i5 = 0;
        while (true) {
            if (i5 >= cTSectPr.sizeOfHeaderReferenceArray()) {
                break;
            }
            CTHdrFtrRef headerReferenceArray = cTSectPr.getHeaderReferenceArray(i5);
            POIXMLDocumentPart relationById = xWPFDocument.getRelationById(headerReferenceArray.getId());
            XWPFHeader xWPFHeader = relationById instanceof XWPFHeader ? (XWPFHeader) relationById : null;
            try {
                type2 = headerReferenceArray.getType();
            } catch (XmlValueOutOfRangeException unused) {
                type2 = STHdrFtr.DEFAULT;
            }
            assignHeader(xWPFHeader, type2);
            i5++;
        }
        for (int i6 = 0; i6 < cTSectPr.sizeOfFooterReferenceArray(); i6++) {
            CTHdrFtrRef footerReferenceArray = cTSectPr.getFooterReferenceArray(i6);
            POIXMLDocumentPart relationById2 = xWPFDocument.getRelationById(footerReferenceArray.getId());
            XWPFFooter xWPFFooter = relationById2 instanceof XWPFFooter ? (XWPFFooter) relationById2 : null;
            try {
                type = footerReferenceArray.getType();
            } catch (XmlValueOutOfRangeException unused2) {
                type = STHdrFtr.DEFAULT;
            }
            assignFooter(xWPFFooter, type);
        }
    }

    public XWPFFooter createFooter(STHdrFtr.Enum r6, XWPFParagraph[] xWPFParagraphArr) {
        XWPFFooter footer = getFooter(r6);
        if (footer != null) {
            return footer;
        }
        FtrDocument ftrDocumentNewInstance = FtrDocument.Factory.newInstance();
        XWPFRelation xWPFRelation = XWPFRelation.FOOTER;
        XWPFFooter xWPFFooter = (XWPFFooter) this.doc.createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
        xWPFFooter.setXWPFDocument(this.doc);
        CTHdrFtr cTHdrFtrBuildFtr = buildFtr(r6, xWPFFooter, xWPFParagraphArr);
        xWPFFooter.setHeaderFooter(cTHdrFtrBuildFtr);
        ftrDocumentNewInstance.setFtr(cTHdrFtrBuildFtr);
        assignFooter(xWPFFooter, r6);
        return xWPFFooter;
    }

    public XWPFHeader createHeader(STHdrFtr.Enum r6, XWPFParagraph[] xWPFParagraphArr) {
        XWPFHeader header = getHeader(r6);
        if (header != null) {
            return header;
        }
        HdrDocument hdrDocumentNewInstance = HdrDocument.Factory.newInstance();
        XWPFRelation xWPFRelation = XWPFRelation.HEADER;
        XWPFHeader xWPFHeader = (XWPFHeader) this.doc.createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
        xWPFHeader.setXWPFDocument(this.doc);
        CTHdrFtr cTHdrFtrBuildHdr = buildHdr(r6, xWPFHeader, xWPFParagraphArr);
        xWPFHeader.setHeaderFooter(cTHdrFtrBuildHdr);
        hdrDocumentNewInstance.setHdr(cTHdrFtrBuildHdr);
        assignHeader(xWPFHeader, r6);
        return xWPFHeader;
    }

    public XWPFFooter getFooter(STHdrFtr.Enum r6) {
        if (r6 == STHdrFtr.EVEN) {
            return this.evenPageFooter;
        }
        if (r6 == STHdrFtr.FIRST) {
            return this.firstPageFooter;
        }
        return this.defaultFooter;
    }

    public XWPFHeader getHeader(STHdrFtr.Enum r6) {
        if (r6 == STHdrFtr.EVEN) {
            return this.evenPageHeader;
        }
        if (r6 == STHdrFtr.FIRST) {
            return this.firstPageHeader;
        }
        return this.defaultHeader;
    }
}
