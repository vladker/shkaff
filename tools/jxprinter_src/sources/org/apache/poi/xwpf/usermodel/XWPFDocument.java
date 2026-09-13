package org.apache.poi.xwpf.usermodel;

import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import javax.xml.namespace.QName;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.IdentifierManager;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xslf.usermodel.g;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFDocument extends POIXMLDocument implements Document, IBody {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XWPFDocument.class);
    protected List<IBodyElement> bodyElements;
    protected final List<XWPFChart> charts;
    private XWPFComments comments;
    protected List<XWPFSDT> contentControls;
    private CTDocument1 ctDocument;
    private final IdentifierManager drawingIdManager;
    protected XWPFEndnotes endnotes;
    protected List<XWPFFooter> footers;
    private final FootnoteEndnoteIdManager footnoteIdManager;
    protected XWPFFootnotes footnotes;
    private XWPFHeaderFooterPolicy headerFooterPolicy;
    protected List<XWPFHeader> headers;
    protected List<XWPFHyperlink> hyperlinks;
    protected XWPFNumbering numbering;
    protected Map<Long, List<XWPFPictureData>> packagePictures;
    protected List<XWPFParagraph> paragraphs;
    protected List<XWPFPictureData> pictures;
    private XWPFSettings settings;
    protected XWPFStyles styles;
    protected List<XWPFTable> tables;

    public XWPFDocument(OPCPackage oPCPackage) {
        super(oPCPackage);
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.charts = new ArrayList();
        this.drawingIdManager = new IdentifierManager(0L, KeyboardMap.kValueMask);
        this.footnoteIdManager = new FootnoteEndnoteIdManager(this);
        load(XWPFFactory.getInstance());
    }

    private int getBodyElementSpecificPos(int i5, List<? extends IBodyElement> list) {
        if (!list.isEmpty() && i5 >= 0 && i5 < this.bodyElements.size()) {
            IBodyElement iBodyElement = this.bodyElements.get(i5);
            if (iBodyElement.getElementType() != list.get(0).getElementType()) {
                return -1;
            }
            for (int iMin = Math.min(i5, list.size() - 1); iMin >= 0; iMin--) {
                if (list.get(iMin) == iBodyElement) {
                    return iMin;
                }
            }
        }
        return -1;
    }

    private int getPosOfBodyElement(IBodyElement iBodyElement) {
        BodyElementType elementType = iBodyElement.getElementType();
        for (int i5 = 0; i5 < this.bodyElements.size(); i5++) {
            IBodyElement iBodyElement2 = this.bodyElements.get(i5);
            if (iBodyElement2.getElementType() == elementType && iBodyElement2.equals(iBodyElement)) {
                return i5;
            }
        }
        return -1;
    }

    private int getRelationIndex(XWPFRelation xWPFRelation) {
        Iterator<POIXMLDocumentPart.RelationPart> it = getRelationParts().iterator();
        int i5 = 1;
        while (it.hasNext()) {
            if (it.next().getRelationship().getRelationshipType().equals(xWPFRelation.getRelation())) {
                i5++;
            }
        }
        return i5;
    }

    private CTSectPr getSection() {
        CTBody body = getDocument().getBody();
        return body.isSetSectPr() ? body.getSectPr() : body.addNewSectPr();
    }

    private void initFootnotes() {
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
            String relationshipType = relationPart.getRelationship().getRelationshipType();
            if (relationshipType.equals(XWPFRelation.FOOTNOTE.getRelation())) {
                XWPFFootnotes xWPFFootnotes = (XWPFFootnotes) documentPart;
                this.footnotes = xWPFFootnotes;
                xWPFFootnotes.onDocumentRead();
                this.footnotes.setIdManager(this.footnoteIdManager);
            } else if (relationshipType.equals(XWPFRelation.ENDNOTE.getRelation())) {
                XWPFEndnotes xWPFEndnotes = (XWPFEndnotes) documentPart;
                this.endnotes = xWPFEndnotes;
                xWPFEndnotes.onDocumentRead();
                this.endnotes.setIdManager(this.footnoteIdManager);
            }
        }
    }

    private void initHyperlinks() {
        try {
            this.hyperlinks = new ArrayList();
            for (PackageRelationship packageRelationship : getPackagePart().getRelationshipsByType(XWPFRelation.HYPERLINK.getRelation())) {
                this.hyperlinks.add(new XWPFHyperlink(packageRelationship.getId(), packageRelationship.getTargetURI().toString()));
            }
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    private boolean isCursorInBody(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            boolean z6 = xmlCursorNewCursor.getObject() == this.ctDocument.getBody();
            xmlCursorNewCursor.close();
            return z6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$registerPackagePictureData$0(Long l6) {
        return new ArrayList(1);
    }

    public static OPCPackage newPackage() {
        OPCPackage oPCPackageCreate = null;
        try {
            oPCPackageCreate = OPCPackage.create(new UnsynchronizedByteArrayOutputStream());
            XWPFRelation xWPFRelation = XWPFRelation.DOCUMENT;
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(xWPFRelation.getDefaultFileName());
            oPCPackageCreate.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, PackageRelationshipTypes.CORE_DOCUMENT);
            oPCPackageCreate.createPart(packagePartNameCreatePartName, xWPFRelation.getContentType());
            oPCPackageCreate.getPackageProperties().setCreatorProperty(POIXMLDocument.DOCUMENT_CREATOR);
            return oPCPackageCreate;
        } catch (Exception e) {
            IOUtils.closeQuietly(oPCPackageCreate);
            throw new POIXMLException(e);
        }
    }

    @Internal
    public XWPFEndnote addEndnote(CTFtnEdn cTFtnEdn) {
        XWPFEndnote xWPFEndnote = new XWPFEndnote(this, cTFtnEdn);
        this.endnotes.addEndnote(cTFtnEdn);
        return xWPFEndnote;
    }

    @Internal
    public XWPFFootnote addFootnote(CTFtnEdn cTFtnEdn) {
        return this.footnotes.addFootnote(cTFtnEdn);
    }

    public String addPictureData(byte[] bArr, int i5) {
        return addPictureData(bArr, PictureType.findByOoxmlId(i5));
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTDocument1.type.getName().getNamespaceURI(), "document"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.ctDocument.save(outputStream, xmlOptions);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public XWPFChart createChart() {
        return createChart(500000, 500000);
    }

    public XWPFComments createComments() {
        if (this.comments == null) {
            CommentsDocument commentsDocumentNewInstance = CommentsDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.COMMENT;
            XWPFComments xWPFComments = (XWPFComments) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFComments.setCtComments(commentsDocumentNewInstance.addNewComments());
            xWPFComments.setXWPFDocument(getXWPFDocument());
            this.comments = xWPFComments;
        }
        return this.comments;
    }

    public XWPFEndnote createEndnote() {
        return createEndnotes().createEndnote();
    }

    public XWPFEndnotes createEndnotes() {
        if (this.endnotes == null) {
            EndnotesDocument endnotesDocumentNewInstance = EndnotesDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.ENDNOTE;
            XWPFEndnotes xWPFEndnotes = (XWPFEndnotes) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFEndnotes.setEndnotes(endnotesDocumentNewInstance.addNewEndnotes());
            xWPFEndnotes.setIdManager(this.footnoteIdManager);
            this.endnotes = xWPFEndnotes;
        }
        return this.endnotes;
    }

    public XWPFFooter createFooter(HeaderFooterType headerFooterType) {
        XWPFHeaderFooterPolicy xWPFHeaderFooterPolicyCreateHeaderFooterPolicy = createHeaderFooterPolicy();
        if (headerFooterType == HeaderFooterType.FIRST) {
            CTSectPr section = getSection();
            if (!section.isSetTitlePg()) {
                section.addNewTitlePg().setVal(STOnOff1.ON);
            }
        }
        return xWPFHeaderFooterPolicyCreateHeaderFooterPolicy.createFooter(STHdrFtr.Enum.forInt(headerFooterType.toInt()));
    }

    public XWPFFootnote createFootnote() {
        return createFootnotes().createFootnote();
    }

    public XWPFFootnotes createFootnotes() {
        if (this.footnotes == null) {
            FootnotesDocument footnotesDocumentNewInstance = FootnotesDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.FOOTNOTE;
            XWPFFootnotes xWPFFootnotes = (XWPFFootnotes) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFFootnotes.setFootnotes(footnotesDocumentNewInstance.addNewFootnotes());
            xWPFFootnotes.setIdManager(this.footnoteIdManager);
            this.footnotes = xWPFFootnotes;
        }
        return this.footnotes;
    }

    public XWPFHeader createHeader(HeaderFooterType headerFooterType) {
        XWPFHeaderFooterPolicy xWPFHeaderFooterPolicyCreateHeaderFooterPolicy = createHeaderFooterPolicy();
        if (headerFooterType == HeaderFooterType.FIRST) {
            CTSectPr section = getSection();
            if (!section.isSetTitlePg()) {
                section.addNewTitlePg().setVal(STOnOff1.ON);
            }
        }
        return xWPFHeaderFooterPolicyCreateHeaderFooterPolicy.createHeader(STHdrFtr.Enum.forInt(headerFooterType.toInt()));
    }

    public XWPFHeaderFooterPolicy createHeaderFooterPolicy() {
        if (this.headerFooterPolicy == null) {
            this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);
        }
        return this.headerFooterPolicy;
    }

    public XWPFNumbering createNumbering() {
        if (this.numbering == null) {
            NumberingDocument numberingDocumentNewInstance = NumberingDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.NUMBERING;
            XWPFNumbering xWPFNumbering = (XWPFNumbering) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFNumbering.setNumbering(numberingDocumentNewInstance.addNewNumbering());
            this.numbering = xWPFNumbering;
        }
        return this.numbering;
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctDocument.getBody().addNewP(), this);
        this.bodyElements.add(xWPFParagraph);
        this.paragraphs.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFStyles createStyles() {
        if (this.styles == null) {
            StylesDocument stylesDocumentNewInstance = StylesDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.STYLES;
            XWPFStyles xWPFStyles = (XWPFStyles) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFStyles.setStyles(stylesDocumentNewInstance.addNewStyles());
            this.styles = xWPFStyles;
        }
        return this.styles;
    }

    public void createTOC() {
        TOC toc = new TOC(getDocument().getBody().addNewSdt());
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            String style = xWPFParagraph.getStyle();
            if (style != null && style.startsWith("Heading")) {
                try {
                    toc.addRow(Integer.parseInt(style.substring(7)), xWPFParagraph.getText(), 1, "112723803");
                } catch (NumberFormatException e) {
                    LOG.atError().withThrowable(e).log("can't format number in TOC heading");
                }
            }
        }
    }

    public XWPFTable createTable() {
        XWPFTable xWPFTable = new XWPFTable(this.ctDocument.getBody().addNewTbl(), this);
        this.bodyElements.add(xWPFTable);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public void enforceCommentsProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.COMMENTS);
    }

    public void enforceFillingFormsProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.FORMS);
    }

    public void enforceReadonlyProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.READ_ONLY);
    }

    public void enforceTrackedChangesProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.TRACKED_CHANGES);
    }

    public void enforceUpdateFields() {
        this.settings.setUpdateFields();
    }

    public XWPFPictureData findPackagePictureData(byte[] bArr) {
        List<XWPFPictureData> list = this.packagePictures.get(Long.valueOf(IOUtils.calculateChecksum(bArr)));
        XWPFPictureData xWPFPictureData = null;
        if (list != null) {
            Iterator<XWPFPictureData> it = list.iterator();
            while (it.hasNext() && xWPFPictureData == null) {
                XWPFPictureData next = it.next();
                if (Arrays.equals(bArr, next.getData())) {
                    xWPFPictureData = next;
                }
            }
        }
        return xWPFPictureData;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument
    public List<PackagePart> getAllEmbeddedParts() {
        LinkedList linkedList = new LinkedList();
        PackagePart packagePart = getPackagePart();
        Iterator<PackageRelationship> it = getPackagePart().getRelationshipsByType(POIXMLDocument.OLE_OBJECT_REL_TYPE).iterator();
        while (it.hasNext()) {
            linkedList.add(packagePart.getRelatedPart(it.next()));
        }
        Iterator<PackageRelationship> it2 = getPackagePart().getRelationshipsByType(POIXMLDocument.PACK_OBJECT_REL_TYPE).iterator();
        while (it2.hasNext()) {
            linkedList.add(packagePart.getRelatedPart(it2.next()));
        }
        return linkedList;
    }

    public List<XWPFPictureData> getAllPackagePictures() {
        ArrayList arrayList = new ArrayList();
        Iterator<List<XWPFPictureData>> it = this.packagePictures.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<XWPFPictureData> getAllPictures() {
        return Collections.unmodifiableList(this.pictures);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public Iterator<IBodyElement> getBodyElementsIterator() {
        return this.bodyElements.iterator();
    }

    public Spliterator<IBodyElement> getBodyElementsSpliterator() {
        return this.bodyElements.spliterator();
    }

    public List<XWPFChart> getCharts() {
        return Collections.unmodifiableList(this.charts);
    }

    public XWPFComment getCommentByID(String str) {
        XWPFComments xWPFComments = this.comments;
        if (xWPFComments == null) {
            return null;
        }
        return xWPFComments.getCommentByID(str);
    }

    public XWPFComment[] getComments() {
        XWPFComments xWPFComments = this.comments;
        if (xWPFComments == null) {
            return null;
        }
        return (XWPFComment[]) xWPFComments.getComments().toArray(new XWPFComment[0]);
    }

    public XWPFComments getDocComments() {
        return this.comments;
    }

    @Internal
    public CTDocument1 getDocument() {
        return this.ctDocument;
    }

    public IdentifierManager getDrawingIdManager() {
        return this.drawingIdManager;
    }

    public XWPFEndnote getEndnoteByID(int i5) {
        XWPFEndnotes xWPFEndnotes = this.endnotes;
        if (xWPFEndnotes == null) {
            return null;
        }
        return xWPFEndnotes.getFootnoteById(i5);
    }

    public List<XWPFEndnote> getEndnotes() {
        XWPFEndnotes xWPFEndnotes = this.endnotes;
        return xWPFEndnotes == null ? Collections.EMPTY_LIST : xWPFEndnotes.getEndnotesList();
    }

    public boolean getEvenAndOddHeadings() {
        return this.settings.getEvenAndOddHeadings();
    }

    public XWPFFooter getFooterArray(int i5) {
        if (i5 < 0 || i5 >= this.footers.size()) {
            return null;
        }
        return this.footers.get(i5);
    }

    public List<XWPFFooter> getFooterList() {
        return Collections.unmodifiableList(this.footers);
    }

    public XWPFFootnote getFootnoteByID(int i5) {
        XWPFFootnotes xWPFFootnotes = this.footnotes;
        if (xWPFFootnotes == null) {
            return null;
        }
        return (XWPFFootnote) xWPFFootnotes.getFootnoteById(i5);
    }

    public List<XWPFFootnote> getFootnotes() {
        XWPFFootnotes xWPFFootnotes = this.footnotes;
        return xWPFFootnotes == null ? Collections.EMPTY_LIST : xWPFFootnotes.getFootnotesList();
    }

    public XWPFHeader getHeaderArray(int i5) {
        if (i5 < 0 || i5 >= this.headers.size()) {
            return null;
        }
        return this.headers.get(i5);
    }

    public XWPFHeaderFooterPolicy getHeaderFooterPolicy() {
        return this.headerFooterPolicy;
    }

    public List<XWPFHeader> getHeaderList() {
        return Collections.unmodifiableList(this.headers);
    }

    public XWPFHyperlink getHyperlinkByID(String str) {
        for (XWPFHyperlink xWPFHyperlink : this.hyperlinks) {
            if (xWPFHyperlink.getId().equals(str)) {
                return xWPFHyperlink;
            }
        }
        initHyperlinks();
        for (XWPFHyperlink xWPFHyperlink2 : this.hyperlinks) {
            if (xWPFHyperlink2.getId().equals(str)) {
                return xWPFHyperlink2;
            }
        }
        return null;
    }

    public XWPFHyperlink[] getHyperlinks() {
        return (XWPFHyperlink[]) this.hyperlinks.toArray(new XWPFHyperlink[0]);
    }

    public XWPFParagraph getLastParagraph() {
        return this.paragraphs.get(this.paragraphs.toArray().length - 1);
    }

    public boolean getMirrorMargins() {
        return this.settings.getMirrorMargins();
    }

    public int getNextPicNameNumber(int i5) {
        return getNextPicNameNumber(PictureType.findByOoxmlId(i5));
    }

    public XWPFNumbering getNumbering() {
        return this.numbering;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (xWPFParagraph.getCTP() == ctp) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i5) {
        if (i5 < 0 || i5 >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i5);
    }

    public int getParagraphPos(int i5) {
        return getBodyElementSpecificPos(i5, this.paragraphs);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    public Iterator<XWPFParagraph> getParagraphsIterator() {
        return this.paragraphs.iterator();
    }

    public Spliterator<XWPFParagraph> getParagraphsSpliterator() {
        return this.paragraphs.spliterator();
    }

    public PackagePart getPartById(String str) {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(str));
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.DOCUMENT;
    }

    public XWPFPictureData getPictureDataByID(String str) {
        POIXMLDocumentPart relationById = getRelationById(str);
        if (relationById instanceof XWPFPictureData) {
            return (XWPFPictureData) relationById;
        }
        return null;
    }

    public int getPosOfParagraph(XWPFParagraph xWPFParagraph) {
        return getPosOfBodyElement(xWPFParagraph);
    }

    public int getPosOfTable(XWPFTable xWPFTable) {
        return getPosOfBodyElement(xWPFTable);
    }

    public XWPFSettings getSettings() {
        return this.settings;
    }

    @Internal
    public CTStyles getStyle() throws IOException {
        try {
            PackagePart[] relatedByType = getRelatedByType(XWPFRelation.STYLES.getRelation());
            if (relatedByType.length != 1) {
                throw new IllegalStateException("Expecting one Styles document part, but found " + relatedByType.length);
            }
            InputStream inputStream = relatedByType[0].getInputStream();
            try {
                CTStyles styles = StylesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getStyles();
                if (inputStream != null) {
                    inputStream.close();
                }
                return styles;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (InvalidFormatException e) {
            throw new IllegalStateException(e);
        }
    }

    public XWPFStyles getStyles() {
        return this.styles;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        for (int i5 = 0; i5 < this.tables.size(); i5++) {
            if (getTables().get(i5).getCTTbl() == cTTbl) {
                return getTables().get(i5);
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i5) {
        if (i5 < 0 || i5 >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i5);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XWPFTableRow row;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            XmlObject object = xmlCursorNewCursor.getObject();
            if (!(object instanceof CTRow)) {
                xmlCursorNewCursor.close();
                return null;
            }
            CTRow cTRow = (CTRow) object;
            xmlCursorNewCursor.toParent();
            XmlObject object2 = xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.close();
            if (!(object2 instanceof CTTbl) || (table = getTable((CTTbl) object2)) == null || (row = table.getRow(cTRow)) == null) {
                return null;
            }
            return row.getTableCell(cTTc);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public int getTablePos(int i5) {
        return getBodyElementSpecificPos(i5, this.tables);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    public Iterator<XWPFTable> getTablesIterator() {
        return this.tables.iterator();
    }

    public Spliterator<XWPFTable> getTablesSpliterator() {
        return this.tables.spliterator();
    }

    public String getTblStyle(XWPFTable xWPFTable) {
        return xWPFTable.getStyleID();
    }

    public long getZoomPercent() {
        return this.settings.getZoomPercent();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z6;
        XmlObject object = null;
        if (!isCursorInBody(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("p", CTP.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTP ctp = (CTP) xmlCursor.getObject();
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp, this);
        while (true) {
            z6 = object instanceof CTP;
            if (z6 || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i5 = 0;
        if (!z6 || object == ctp) {
            this.paragraphs.add(0, xWPFParagraph);
        } else {
            this.paragraphs.add(this.paragraphs.indexOf(getParagraph((CTP) object)) + 1, xWPFParagraph);
        }
        XmlCursor xmlCursorNewCursor = ctp.newCursor();
        try {
            xmlCursor.toCursor(xmlCursorNewCursor);
            while (xmlCursor.toPrevSibling()) {
                XmlObject object2 = xmlCursor.getObject();
                if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                    i5++;
                }
            }
            this.bodyElements.add(i5, xWPFParagraph);
            xmlCursor.toCursor(xmlCursorNewCursor);
            xmlCursor.toEndToken();
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return xWPFParagraph;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z6;
        XmlObject object = null;
        if (!isCursorInBody(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("tbl", CTTbl.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTTbl cTTbl = (CTTbl) xmlCursor.getObject();
        XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
        while (true) {
            z6 = object instanceof CTTbl;
            if (z6 || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i5 = 0;
        if (z6) {
            this.tables.add(this.tables.indexOf(getTable((CTTbl) object)) + 1, xWPFTable);
        } else {
            this.tables.add(0, xWPFTable);
        }
        XmlCursor xmlCursorNewCursor = cTTbl.newCursor();
        try {
            xmlCursor.toCursor(xmlCursorNewCursor);
            while (xmlCursor.toPrevSibling()) {
                XmlObject object2 = xmlCursor.getObject();
                if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                    i5++;
                }
            }
            this.bodyElements.add(i5, xWPFTable);
            xmlCursor.toCursor(xmlCursorNewCursor);
            xmlCursor.toEndToken();
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return xWPFTable;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i5, XWPFTable xWPFTable) {
        this.bodyElements.add(i5, xWPFTable);
        CTTbl[] tblArray = this.ctDocument.getBody().getTblArray();
        int length = tblArray.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length && tblArray[i7] != xWPFTable.getCTTbl(); i7++) {
            i6++;
        }
        this.tables.add(i6, xWPFTable);
    }

    public boolean isEnforcedCommentsProtection() {
        return this.settings.isEnforcedWith(STDocProtect.COMMENTS);
    }

    public boolean isEnforcedFillingFormsProtection() {
        return this.settings.isEnforcedWith(STDocProtect.FORMS);
    }

    public boolean isEnforcedProtection() {
        return this.settings.isEnforcedWith();
    }

    public boolean isEnforcedReadonlyProtection() {
        return this.settings.isEnforcedWith(STDocProtect.READ_ONLY);
    }

    public boolean isEnforcedTrackedChangesProtection() {
        return this.settings.isEnforcedWith(STDocProtect.TRACKED_CHANGES);
    }

    public boolean isEnforcedUpdateFields() {
        return this.settings.isUpdateFields();
    }

    public boolean isTrackRevisions() {
        return this.settings.isTrackRevisions();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentCreate() {
        CTDocument1 cTDocument1NewInstance = CTDocument1.Factory.newInstance();
        this.ctDocument = cTDocument1NewInstance;
        cTDocument1NewInstance.addNewBody();
        this.settings = (XWPFSettings) createRelationship(XWPFRelation.SETTINGS, XWPFFactory.getInstance());
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication(POIXMLDocument.DOCUMENT_CREATOR);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() throws IOException {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                DocumentDocument documentDocument = DocumentDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                this.ctDocument = documentDocument.getDocument();
                if (inputStream != null) {
                    inputStream.close();
                }
                initFootnotes();
                XmlCursor xmlCursorNewCursor = this.ctDocument.newCursor();
                try {
                    xmlCursorNewCursor.selectPath("./*");
                    while (xmlCursorNewCursor.toNextSelection()) {
                        XmlObject object = xmlCursorNewCursor.getObject();
                        if (object instanceof CTBody) {
                            XmlCursor xmlCursorNewCursor2 = object.newCursor();
                            try {
                                xmlCursorNewCursor2.selectPath("./*");
                                while (xmlCursorNewCursor2.toNextSelection()) {
                                    XmlObject object2 = xmlCursorNewCursor2.getObject();
                                    if (object2 instanceof CTP) {
                                        XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object2, this);
                                        this.bodyElements.add(xWPFParagraph);
                                        this.paragraphs.add(xWPFParagraph);
                                    } else if (object2 instanceof CTTbl) {
                                        XWPFTable xWPFTable = new XWPFTable((CTTbl) object2, this);
                                        this.bodyElements.add(xWPFTable);
                                        this.tables.add(xWPFTable);
                                    } else if (object2 instanceof CTSdtBlock) {
                                        XWPFSDT xwpfsdt = new XWPFSDT((CTSdtBlock) object2, this);
                                        this.bodyElements.add(xwpfsdt);
                                        this.contentControls.add(xwpfsdt);
                                    }
                                }
                                xmlCursorNewCursor2.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    if (xmlCursorNewCursor2 != null) {
                                        try {
                                            xmlCursorNewCursor2.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                    }
                    xmlCursorNewCursor.close();
                    if (documentDocument.getDocument().getBody().getSectPr() != null) {
                        this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);
                    }
                    for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                        POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                        String relationshipType = relationPart.getRelationship().getRelationshipType();
                        if (relationshipType.equals(XWPFRelation.STYLES.getRelation())) {
                            XWPFStyles xWPFStyles = (XWPFStyles) documentPart;
                            this.styles = xWPFStyles;
                            xWPFStyles.onDocumentRead();
                        } else if (relationshipType.equals(XWPFRelation.NUMBERING.getRelation())) {
                            XWPFNumbering xWPFNumbering = (XWPFNumbering) documentPart;
                            this.numbering = xWPFNumbering;
                            xWPFNumbering.onDocumentRead();
                        } else if (relationshipType.equals(XWPFRelation.FOOTER.getRelation())) {
                            XWPFFooter xWPFFooter = (XWPFFooter) documentPart;
                            this.footers.add(xWPFFooter);
                            xWPFFooter.onDocumentRead();
                        } else if (relationshipType.equals(XWPFRelation.HEADER.getRelation())) {
                            XWPFHeader xWPFHeader = (XWPFHeader) documentPart;
                            this.headers.add(xWPFHeader);
                            xWPFHeader.onDocumentRead();
                        } else if (relationshipType.equals(XWPFRelation.COMMENT.getRelation())) {
                            XWPFComments xWPFComments = (XWPFComments) documentPart;
                            this.comments = xWPFComments;
                            xWPFComments.onDocumentRead();
                        } else if (relationshipType.equals(XWPFRelation.SETTINGS.getRelation())) {
                            XWPFSettings xWPFSettings = (XWPFSettings) documentPart;
                            this.settings = xWPFSettings;
                            xWPFSettings.onDocumentRead();
                        } else if (relationshipType.equals(XWPFRelation.IMAGES.getRelation())) {
                            XWPFPictureData xWPFPictureData = (XWPFPictureData) documentPart;
                            xWPFPictureData.onDocumentRead();
                            registerPackagePictureData(xWPFPictureData);
                            this.pictures.add(xWPFPictureData);
                        } else if (relationshipType.equals(XWPFRelation.CHART.getRelation())) {
                            this.charts.add((XWPFChart) documentPart);
                        } else if (relationshipType.equals(XWPFRelation.GLOSSARY_DOCUMENT.getRelation())) {
                            Iterator<POIXMLDocumentPart> it = documentPart.getRelations().iterator();
                            while (it.hasNext()) {
                                POIXMLDocumentPart._invokeOnDocumentRead(it.next());
                            }
                        }
                    }
                    initHyperlinks();
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        if (xmlCursorNewCursor != null) {
                            try {
                                xmlCursorNewCursor.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public void registerPackagePictureData(XWPFPictureData xWPFPictureData) {
        List<XWPFPictureData> listComputeIfAbsent = this.packagePictures.computeIfAbsent(xWPFPictureData.getChecksum(), new g(8));
        if (listComputeIfAbsent.contains(xWPFPictureData)) {
            return;
        }
        listComputeIfAbsent.add(xWPFPictureData);
    }

    public boolean removeBodyElement(int i5) {
        if (i5 < 0 || i5 >= this.bodyElements.size()) {
            return false;
        }
        BodyElementType elementType = this.bodyElements.get(i5).getElementType();
        if (elementType == BodyElementType.TABLE) {
            int tablePos = getTablePos(i5);
            this.tables.remove(tablePos);
            this.ctDocument.getBody().removeTbl(tablePos);
        }
        if (elementType == BodyElementType.PARAGRAPH) {
            int paragraphPos = getParagraphPos(i5);
            this.paragraphs.remove(paragraphPos);
            this.ctDocument.getBody().removeP(paragraphPos);
        }
        this.bodyElements.remove(i5);
        return true;
    }

    public boolean removeEndnote(int i5) {
        XWPFEndnotes xWPFEndnotes = this.endnotes;
        if (xWPFEndnotes != null) {
            return xWPFEndnotes.removeEndnote(i5);
        }
        return false;
    }

    public boolean removeFootnote(int i5) {
        XWPFFootnotes xWPFFootnotes = this.footnotes;
        if (xWPFFootnotes != null) {
            return xWPFFootnotes.removeFootnote(i5);
        }
        return false;
    }

    public void removeProtectionEnforcement() {
        this.settings.removeEnforcement();
    }

    public void setEvenAndOddHeadings(boolean z6) {
        this.settings.setEvenAndOddHeadings(z6);
    }

    public void setMirrorMargins(boolean z6) {
        this.settings.setMirrorMargins(z6);
    }

    public void setParagraph(XWPFParagraph xWPFParagraph, int i5) {
        this.paragraphs.set(i5, xWPFParagraph);
        this.ctDocument.getBody().setPArray(i5, xWPFParagraph.getCTP());
    }

    public void setTable(int i5, XWPFTable xWPFTable) {
        this.tables.set(i5, xWPFTable);
        this.ctDocument.getBody().setTblArray(i5, xWPFTable.getCTTbl());
    }

    public void setTrackRevisions(boolean z6) {
        this.settings.setTrackRevisions(z6);
    }

    public void setZoomPercent(long j6) {
        this.settings.setZoomPercent(j6);
    }

    public boolean validateProtectionPassword(String str) {
        return this.settings.validateProtectionPassword(str);
    }

    public String addPictureData(byte[] bArr, PictureType pictureType) throws InvalidFormatException {
        if (pictureType == null) {
            throw new InvalidFormatException("pictureType is not supported");
        }
        XWPFPictureData xWPFPictureDataFindPackagePictureData = findPackagePictureData(bArr);
        POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[pictureType.ooxmlId];
        if (xWPFPictureDataFindPackagePictureData != null) {
            return !getRelations().contains(xWPFPictureDataFindPackagePictureData) ? addRelation(null, XWPFRelation.IMAGES, xWPFPictureDataFindPackagePictureData).getRelationship().getId() : getRelationId(xWPFPictureDataFindPackagePictureData);
        }
        XWPFPictureData xWPFPictureData = (XWPFPictureData) createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), getNextPicNameNumber(pictureType));
        try {
            OutputStream outputStream = xWPFPictureData.getPackagePart().getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.close();
                registerPackagePictureData(xWPFPictureData);
                this.pictures.add(xWPFPictureData);
                return getRelationId(xWPFPictureData);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public XWPFChart createChart(int i5, int i6) {
        return createChart(createParagraph().createRun(), i5, i6);
    }

    public void enforceCommentsProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.COMMENTS, str, hashAlgorithm);
    }

    public void enforceFillingFormsProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.FORMS, str, hashAlgorithm);
    }

    public void enforceReadonlyProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.READ_ONLY, str, hashAlgorithm);
    }

    public void enforceTrackedChangesProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.TRACKED_CHANGES, str, hashAlgorithm);
    }

    public int getNextPicNameNumber(PictureType pictureType) throws InvalidFormatException {
        if (pictureType == null) {
            throw new InvalidFormatException("pictureType is not supported");
        }
        int size = getAllPackagePictures().size() + 1;
        PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(XWPFPictureData.RELATIONS[pictureType.ooxmlId].getFileName(size));
        while (getPackage().getPart(packagePartNameCreatePartName) != null) {
            size++;
            packagePartNameCreatePartName = PackagingURIHelper.createPartName(XWPFPictureData.RELATIONS[pictureType.ooxmlId].getFileName(size));
        }
        return size;
    }

    public XWPFChart createChart(XWPFRun xWPFRun, int i5, int i6) {
        XWPFRelation xWPFRelation = XWPFRelation.CHART;
        int nextPartNumber = getNextPartNumber(xWPFRelation, this.charts.size() + 1);
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xWPFRelation, XWPFFactory.getInstance(), nextPartNumber, false);
        XWPFChart xWPFChart = (XWPFChart) relationPartCreateRelationship.getDocumentPart();
        xWPFChart.setChartIndex(nextPartNumber);
        xWPFChart.attach(relationPartCreateRelationship.getRelationship().getId(), xWPFRun);
        xWPFChart.setChartBoundingBox(i5, i6);
        this.charts.add(xWPFChart);
        return xWPFChart;
    }

    public XWPFTable createTable(int i5, int i6) {
        XWPFTable xWPFTable = new XWPFTable(this.ctDocument.getBody().addNewTbl(), this, i5, i6);
        this.bodyElements.add(xWPFTable);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public XWPFDocument(InputStream inputStream) {
        super(PackageHelper.open(inputStream));
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.charts = new ArrayList();
        this.drawingIdManager = new IdentifierManager(0L, KeyboardMap.kValueMask);
        this.footnoteIdManager = new FootnoteEndnoteIdManager(this);
        load(XWPFFactory.getInstance());
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this;
    }

    public String addPictureData(InputStream inputStream, int i5) {
        try {
            return addPictureData(IOUtils.toByteArrayWithMaxLength(inputStream, XWPFPictureData.getMaxImageSize()), i5);
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public String addPictureData(InputStream inputStream, PictureType pictureType) {
        try {
            return addPictureData(IOUtils.toByteArrayWithMaxLength(inputStream, XWPFPictureData.getMaxImageSize()), pictureType);
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public XWPFDocument() {
        super(newPackage());
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.charts = new ArrayList();
        this.drawingIdManager = new IdentifierManager(0L, KeyboardMap.kValueMask);
        this.footnoteIdManager = new FootnoteEndnoteIdManager(this);
        onDocumentCreate();
    }
}
