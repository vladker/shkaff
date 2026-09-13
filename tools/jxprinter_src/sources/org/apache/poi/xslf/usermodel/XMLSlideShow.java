package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.extractor.POIXMLPropertiesTextExtractor;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XMLSlideShow extends POIXMLDocument implements SlideShow<XSLFShape, XSLFTextParagraph> {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 1000000;
    private final List<XSLFChart> _charts;
    private XSLFCommentAuthors _commentAuthors;
    private final List<XSLFSlideMaster> _masters;
    private XSLFNotesMaster _notesMaster;
    private final List<XSLFPictureData> _pictures;
    private CTPresentation _presentation;
    private final List<XSLFSlide> _slides;
    private XSLFTableStyles _tableStyles;
    private static final Logger LOG = LogManager.getLogger((Class<?>) XMLSlideShow.class);
    private static int MAX_RECORD_LENGTH = 1000000;
    private static final Pattern GET_ALL_EMBEDDED_PARTS_PATTERN = Pattern.compile("/ppt/embeddings/.*?");
    private static final Pattern GET_PICTURE_DATA_PATTERN = Pattern.compile("/ppt/media/.*?");

    public XMLSlideShow() {
        this(empty());
    }

    private XSLFNotes createNotesSlide(XSLFSlide xSLFSlide) {
        if (this._notesMaster == null) {
            createNotesMaster();
        }
        XSLFRelation xSLFRelation = XSLFRelation.NOTES;
        XSLFNotes xSLFNotes = (XSLFNotes) createRelationship(xSLFRelation, XSLFFactory.getInstance(), findNextAvailableFileNameIndex(xSLFRelation));
        xSLFSlide.addRelation(null, xSLFRelation, xSLFNotes);
        xSLFNotes.addRelation(null, XSLFRelation.NOTES_MASTER, this._notesMaster);
        xSLFNotes.addRelation(null, XSLFRelation.SLIDE, xSLFSlide);
        xSLFNotes.importContent(this._notesMaster);
        return xSLFNotes;
    }

    public static OPCPackage empty() {
        InputStream resourceAsStream = XMLSlideShow.class.getResourceAsStream("empty.pptx");
        try {
            if (resourceAsStream == null) {
                throw new POIXMLException("Missing resource 'empty.pptx'");
            }
            try {
                OPCPackage oPCPackageOpen = OPCPackage.open(resourceAsStream);
                IOUtils.closeQuietly(resourceAsStream);
                return oPCPackageOpen;
            } catch (Exception e) {
                throw new POIXMLException(e);
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(resourceAsStream);
            throw th;
        }
    }

    private int findNextAvailableFileNameIndex(XSLFRelation xSLFRelation) {
        try {
            return getPackage().getUnusedPartIndex(xSLFRelation.getDefaultFileName());
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPictureData$2(PackagePart packagePart) {
        XSLFPictureData xSLFPictureData = new XSLFPictureData(packagePart);
        xSLFPictureData.setIndex(this._pictures.size());
        this._pictures.add(xSLFPictureData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDocumentRead$0(Map map, CTSlideMasterIdListEntry cTSlideMasterIdListEntry) {
        this._masters.add((XSLFSlideMaster) map.get(cTSlideMasterIdListEntry.getId2()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDocumentRead$1(Map map, CTSlideIdListEntry cTSlideIdListEntry) {
        XSLFSlide xSLFSlide = (XSLFSlide) map.get(cTSlideIdListEntry.getId2());
        if (xSLFSlide == null) {
            LOG.atWarn().log("Slide with r:id {} was defined, but didn't exist in package, skipping", Unbox.box(cTSlideIdListEntry.getId()));
        } else {
            this._slides.add(xSLFSlide);
        }
    }

    private void removePictureRelations(XSLFSlide xSLFSlide, XSLFPictureData xSLFPictureData) {
        removePictureRelations(xSLFSlide, xSLFSlide, xSLFPictureData);
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this._presentation.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
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

    public XSLFChart createChart(XSLFSlide xSLFSlide) {
        XSLFChart xSLFChartCreateChart = createChart();
        xSLFSlide.addRelation(null, XSLFRelation.CHART, xSLFChartCreateChart);
        return xSLFChartCreateChart;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public MasterSheet<XSLFShape, XSLFTextParagraph> createMasterSheet() {
        throw new UnsupportedOperationException();
    }

    public void createNotesMaster() {
        int size = 1;
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSLFRelation.NOTES_MASTER, XSLFFactory.getInstance(), 1, false);
        this._notesMaster = (XSLFNotesMaster) relationPartCreateRelationship.getDocumentPart();
        this._presentation.addNewNotesMasterIdLst().addNewNotesMasterId().setId(relationPartCreateRelationship.getRelationship().getId());
        ArrayList arrayList = new ArrayList();
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFTheme) {
                arrayList.add(XSLFRelation.THEME.getFileNameIndex(pOIXMLDocumentPart));
            }
        }
        if (!arrayList.isEmpty()) {
            int i5 = 1;
            boolean z6 = false;
            for (int i6 = 1; i6 <= arrayList.size(); i6++) {
                if (!arrayList.contains(Integer.valueOf(i6))) {
                    i5 = i6;
                    z6 = true;
                }
            }
            size = !z6 ? 1 + arrayList.size() : i5;
        }
        XSLFRelation xSLFRelation = XSLFRelation.THEME;
        XSLFTheme xSLFTheme = (XSLFTheme) createRelationship(xSLFRelation, XSLFFactory.getInstance(), size);
        xSLFTheme.importTheme(getSlides().get(0).getTheme());
        this._notesMaster.addRelation(null, xSLFRelation, xSLFTheme);
    }

    public XSLFSlideLayout findLayout(String str) {
        Iterator<XSLFSlideMaster> it = getSlideMasters().iterator();
        while (it.hasNext()) {
            XSLFSlideLayout layout = it.next().getLayout(str);
            if (layout != null) {
                return layout;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument
    public List<PackagePart> getAllEmbeddedParts() {
        return Collections.unmodifiableList(getPackage().getPartsByName(GET_ALL_EMBEDDED_PARTS_PATTERN));
    }

    @Internal
    public CTPresentation getCTPresentation() {
        return this._presentation;
    }

    public List<XSLFChart> getCharts() {
        return Collections.unmodifiableList(this._charts);
    }

    public XSLFCommentAuthors getCommentAuthors() {
        return this._commentAuthors;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFFontInfo> getFonts() {
        return XSLFFontInfo.getFonts(this);
    }

    public XSLFNotesMaster getNotesMaster() {
        return this._notesMaster;
    }

    public XSLFNotes getNotesSlide(XSLFSlide xSLFSlide) {
        XSLFNotes notes = xSLFSlide.getNotes();
        return notes == null ? createNotesSlide(xSLFSlide) : notes;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public Dimension getPageSize() {
        CTSlideSize sldSz = this._presentation.getSldSz();
        return new Dimension((int) Units.toPoints(sldSz.getCx()), (int) Units.toPoints(sldSz.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFPictureData> getPictureData() {
        if (this._pictures.isEmpty()) {
            getPackage().getPartsByName(GET_PICTURE_DATA_PATTERN).forEach(new a(this, 0));
        }
        return Collections.unmodifiableList(this._pictures);
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFSlideMaster> getSlideMasters() {
        return this._masters;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFSlide> getSlides() {
        return this._slides;
    }

    public XSLFTableStyles getTableStyles() {
        return this._tableStyles;
    }

    public String importBlip(String str, POIXMLDocumentPart pOIXMLDocumentPart, POIXMLDocumentPart pOIXMLDocumentPart2) {
        OPCPackage oPCPackage = pOIXMLDocumentPart2.getPackagePart().getPackage();
        if (oPCPackage != getPackage()) {
            throw new RuntimeException("the target document part is not a child of this package");
        }
        POIXMLDocumentPart documentPart = pOIXMLDocumentPart.getRelationPartById(str).getDocumentPart();
        if (!(documentPart instanceof XSLFPictureData)) {
            throw new RuntimeException(AbstractC0157z.o("cannot import blip ", str, " - its document part is not XSLFPictureData"));
        }
        XSLFPictureData xSLFPictureDataAddPicture = (XSLFPictureData) documentPart;
        if (oPCPackage != pOIXMLDocumentPart.getPackagePart().getPackage()) {
            xSLFPictureDataAddPicture = addPicture(xSLFPictureDataAddPicture.getData(), xSLFPictureDataAddPicture.getType());
        }
        return pOIXMLDocumentPart2.addRelation(null, XSLFRelation.IMAGES, xSLFPictureDataAddPicture).getRelationship().getId();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() throws IOException {
        try {
            InputStream inputStream = getCorePart().getInputStream();
            try {
                this._presentation = PresentationDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getPresentation();
                if (inputStream != null) {
                    inputStream.close();
                }
                final HashMap map = new HashMap();
                final HashMap map2 = new HashMap();
                HashMap map3 = new HashMap();
                for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                    POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                    if (documentPart instanceof XSLFSlide) {
                        map2.put(relationPart.getRelationship().getId(), (XSLFSlide) documentPart);
                        for (POIXMLDocumentPart pOIXMLDocumentPart : documentPart.getRelations()) {
                            if (pOIXMLDocumentPart instanceof XSLFChart) {
                                map3.put(pOIXMLDocumentPart.getPackagePart().getPartName().getName(), (XSLFChart) pOIXMLDocumentPart);
                            }
                        }
                    } else if (documentPart instanceof XSLFSlideMaster) {
                        map.put(getRelationId(documentPart), (XSLFSlideMaster) documentPart);
                    } else if (documentPart instanceof XSLFTableStyles) {
                        this._tableStyles = (XSLFTableStyles) documentPart;
                    } else if (documentPart instanceof XSLFNotesMaster) {
                        this._notesMaster = (XSLFNotesMaster) documentPart;
                    } else if (documentPart instanceof XSLFCommentAuthors) {
                        this._commentAuthors = (XSLFCommentAuthors) documentPart;
                    }
                }
                this._charts.clear();
                this._charts.addAll(map3.values());
                this._masters.clear();
                if (this._presentation.isSetSldMasterIdLst()) {
                    final int i5 = 0;
                    this._presentation.getSldMasterIdLst().getSldMasterIdList().forEach(new Consumer(this) { // from class: org.apache.poi.xslf.usermodel.b
                        public final /* synthetic */ XMLSlideShow b;

                        {
                            this.b = this;
                        }

                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            switch (i5) {
                                case 0:
                                    this.b.lambda$onDocumentRead$0(map, (CTSlideMasterIdListEntry) obj);
                                    break;
                                default:
                                    this.b.lambda$onDocumentRead$1(map, (CTSlideIdListEntry) obj);
                                    break;
                            }
                        }
                    });
                }
                this._slides.clear();
                if (this._presentation.isSetSldIdLst()) {
                    final int i6 = 1;
                    this._presentation.getSldIdLst().getSldIdList().forEach(new Consumer(this) { // from class: org.apache.poi.xslf.usermodel.b
                        public final /* synthetic */ XMLSlideShow b;

                        {
                            this.b = this;
                        }

                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            switch (i6) {
                                case 0:
                                    this.b.lambda$onDocumentRead$0(map2, (CTSlideMasterIdListEntry) obj);
                                    break;
                                default:
                                    this.b.lambda$onDocumentRead$1(map2, (CTSlideIdListEntry) obj);
                                    break;
                            }
                        }
                    });
                }
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
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public XSLFSlide removeSlide(int i5) {
        XSLFSlide xSLFSlideRemove = this._slides.remove(i5);
        removeRelation(xSLFSlideRemove);
        this._presentation.getSldIdLst().removeSldId(i5);
        for (POIXMLDocumentPart pOIXMLDocumentPart : xSLFSlideRemove.getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFChart) {
                XSLFChart xSLFChart = (XSLFChart) pOIXMLDocumentPart;
                xSLFSlideRemove.removeChartRelation(xSLFChart);
                this._charts.remove(xSLFChart);
            } else if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                xSLFSlideRemove.removeLayoutRelation((XSLFSlideLayout) pOIXMLDocumentPart);
            } else if (pOIXMLDocumentPart instanceof XSLFNotes) {
                removeRelation(xSLFSlideRemove.removeNotes(this._notesMaster));
            } else if (pOIXMLDocumentPart instanceof XSLFPictureData) {
                XSLFPictureData xSLFPictureData = (XSLFPictureData) pOIXMLDocumentPart;
                removePictureRelations(xSLFSlideRemove, xSLFPictureData);
                this._pictures.remove(xSLFPictureData);
            }
        }
        return xSLFSlideRemove;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public void setPageSize(Dimension dimension) {
        CTSlideSize cTSlideSizeNewInstance = CTSlideSize.Factory.newInstance();
        cTSlideSizeNewInstance.setCx(Units.toEMU(dimension.getWidth()));
        cTSlideSizeNewInstance.setCy(Units.toEMU(dimension.getHeight()));
        this._presentation.setSldSz(cTSlideSizeNewInstance);
    }

    public void setSlideOrder(XSLFSlide xSLFSlide, int i5) {
        int iIndexOf = this._slides.indexOf(xSLFSlide);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Slide not found");
        }
        if (iIndexOf == i5) {
            return;
        }
        List<XSLFSlide> list = this._slides;
        list.add(i5, list.remove(iIndexOf));
        CTSlideIdList sldIdLst = this._presentation.getSldIdLst();
        CTSlideIdListEntry[] sldIdArray = sldIdLst.getSldIdArray();
        CTSlideIdListEntry cTSlideIdListEntry = sldIdArray[iIndexOf];
        if (iIndexOf < i5) {
            System.arraycopy(sldIdArray, iIndexOf + 1, sldIdArray, iIndexOf, i5 - iIndexOf);
        } else {
            System.arraycopy(sldIdArray, i5, sldIdArray, i5 + 1, iIndexOf - i5);
        }
        sldIdArray[i5] = cTSlideIdListEntry;
        sldIdLst.setSldIdArray(sldIdArray);
    }

    public XMLSlideShow(OPCPackage oPCPackage) {
        super(oPCPackage);
        this._slides = new ArrayList();
        this._masters = new ArrayList();
        this._pictures = new ArrayList();
        this._charts = new ArrayList();
        try {
            if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
                rebase(getPackage());
            }
            load(XSLFFactory.getInstance());
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    private void removePictureRelations(XSLFSlide xSLFSlide, XSLFShapeContainer xSLFShapeContainer, XSLFPictureData xSLFPictureData) {
        for (XSLFShape xSLFShape : xSLFShapeContainer.getShapes()) {
            if (xSLFShape instanceof XSLFGroupShape) {
                removePictureRelations(xSLFSlide, (XSLFGroupShape) xSLFShape, xSLFPictureData);
            }
            if (xSLFShape instanceof XSLFPictureShape) {
                XSLFPictureShape xSLFPictureShape = (XSLFPictureShape) xSLFShape;
                if (xSLFPictureShape.getPictureData() == xSLFPictureData) {
                    xSLFSlide.removePictureRelation(xSLFPictureShape);
                }
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFFontInfo addFont(InputStream inputStream) {
        return XSLFFontInfo.addFontToSlideShow(this, inputStream);
    }

    public XSLFSlide createSlide(XSLFSlideLayout xSLFSlideLayout) {
        CTSlideIdList sldIdLst = this._presentation.isSetSldIdLst() ? this._presentation.getSldIdLst() : this._presentation.addNewSldIdLst();
        OptionalLong optionalLongMax = Stream.of((Object[]) sldIdLst.getSldIdArray()).mapToLong(new org.apache.commons.compress.archivers.sevenz.a(4)).max();
        XSLFRelation xSLFRelation = XSLFRelation.SLIDE;
        int iMax = (int) (Math.max(optionalLongMax.orElse(0L), 255L) + 1);
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSLFRelation, XSLFFactory.getInstance(), findNextAvailableFileNameIndex(xSLFRelation), false);
        XSLFSlide xSLFSlide = (XSLFSlide) relationPartCreateRelationship.getDocumentPart();
        CTSlideIdListEntry cTSlideIdListEntryAddNewSldId = sldIdLst.addNewSldId();
        cTSlideIdListEntryAddNewSldId.setId(iMax);
        cTSlideIdListEntryAddNewSldId.setId2(relationPartCreateRelationship.getRelationship().getId());
        xSLFSlideLayout.copyLayout(xSLFSlide);
        xSLFSlide.getPackagePart().clearRelationships();
        xSLFSlide.addRelation(null, XSLFRelation.SLIDE_LAYOUT, xSLFSlideLayout);
        this._slides.add(xSLFSlide);
        return xSLFSlide;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData findPictureData(byte[] bArr) {
        long jCalculateChecksum = IOUtils.calculateChecksum(bArr);
        byte[] bArr2 = new byte[8];
        LittleEndian.putLong(bArr2, 0, jCalculateChecksum);
        for (XSLFPictureData xSLFPictureData : getPictureData()) {
            if (Arrays.equals(xSLFPictureData.getChecksum(), bArr2)) {
                return xSLFPictureData;
            }
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        return new POIXMLPropertiesTextExtractor(this);
    }

    public XSLFChart createChart() {
        XSLFRelation xSLFRelation = XSLFRelation.CHART;
        int iFindNextAvailableFileNameIndex = findNextAvailableFileNameIndex(xSLFRelation);
        XSLFChart xSLFChart = (XSLFChart) createRelationship(xSLFRelation, XSLFFactory.getInstance(), iFindNextAvailableFileNameIndex, true).getDocumentPart();
        xSLFChart.setChartIndex(iFindNextAvailableFileNameIndex);
        this._charts.add(xSLFChart);
        return xSLFChart;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData addPicture(byte[] bArr, PictureData.PictureType pictureType) {
        int size;
        XSLFPictureData xSLFPictureDataFindPictureData = findPictureData(bArr);
        if (xSLFPictureDataFindPictureData != null) {
            return xSLFPictureDataFindPictureData;
        }
        XSLFRelation relationForType = XSLFPictureData.getRelationForType(pictureType);
        if (relationForType != null) {
            try {
                size = getPackage().getUnusedPartIndex("/ppt/media/image#\\..+");
            } catch (InvalidFormatException unused) {
                size = this._pictures.size() + 1;
            }
            XSLFPictureData xSLFPictureData = (XSLFPictureData) createRelationship(relationForType, XSLFFactory.getInstance(), size, true).getDocumentPart();
            xSLFPictureData.setIndex(this._pictures.size());
            this._pictures.add(xSLFPictureData);
            try {
                OutputStream outputStream = xSLFPictureData.getPackagePart().getOutputStream();
                try {
                    outputStream.write(bArr);
                    outputStream.close();
                    return xSLFPictureData;
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
        throw new IllegalArgumentException("Picture type " + pictureType + " is not supported.");
    }

    public XMLSlideShow(InputStream inputStream) {
        this(PackageHelper.open(inputStream));
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData addPicture(InputStream inputStream, PictureData.PictureType pictureType) {
        return addPicture(IOUtils.toByteArrayWithMaxLength(inputStream, XSLFPictureData.getMaxImageSize()), pictureType);
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFSlide createSlide() {
        XSLFSlideMaster xSLFSlideMaster = this._masters.get(0);
        XSLFSlideLayout layout = xSLFSlideMaster.getLayout(SlideLayout.BLANK);
        if (layout == null) {
            LOG.atWarn().log("Blank layout was not found - defaulting to first slide layout in master");
            XSLFSlideLayout[] slideLayouts = xSLFSlideMaster.getSlideLayouts();
            if (slideLayouts.length != 0) {
                layout = slideLayouts[0];
            } else {
                throw new POIXMLException("SlideMaster must contain a SlideLayout.");
            }
        }
        return createSlide(layout);
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData addPicture(File file, PictureData.PictureType pictureType) throws IOException {
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(file.length(), MAX_RECORD_LENGTH);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            IOUtils.readFully(fileInputStream, bArrSafelyAllocate);
            fileInputStream.close();
            return addPicture(bArrSafelyAllocate, pictureType);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public Object getPersistDocument() {
        return this;
    }
}
