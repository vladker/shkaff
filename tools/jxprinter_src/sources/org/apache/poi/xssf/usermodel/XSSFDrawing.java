package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFDrawing extends POIXMLDocumentPart implements Drawing<XSSFShape> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFDrawing.class);
    protected static final String NAMESPACE_A = "http://schemas.openxmlformats.org/drawingml/2006/main";
    protected static final String NAMESPACE_C = "http://schemas.openxmlformats.org/drawingml/2006/chart";
    private CTDrawing drawing;
    private long numOfGraphicFrames;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFDrawing$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType;

        static {
            int[] iArr = new int[ClientAnchor.AnchorType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType = iArr;
            try {
                iArr[ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType[ClientAnchor.AnchorType.MOVE_AND_RESIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType[ClientAnchor.AnchorType.MOVE_DONT_RESIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public XSSFDrawing() {
        this.drawing = newDrawing();
    }

    private void addShapes(XmlCursor xmlCursor, List<XSSFShape> list) {
        XSSFShape xSSFShapeGroup;
        do {
            xmlCursor.push();
            if (xmlCursor.toFirstChild()) {
                do {
                    XmlObject object = xmlCursor.getObject();
                    if (!(object instanceof CTMarker)) {
                        if (object instanceof CTPicture) {
                            xSSFShapeGroup = new XSSFPicture(this, (CTPicture) object);
                        } else if (object instanceof CTConnector) {
                            xSSFShapeGroup = new XSSFConnector(this, (CTConnector) object);
                        } else if (object instanceof CTShape) {
                            xSSFShapeGroup = hasOleLink(object) ? new XSSFObjectData(this, (CTShape) object) : new XSSFSimpleShape(this, (CTShape) object);
                        } else if (object instanceof CTGraphicalObjectFrame) {
                            xSSFShapeGroup = new XSSFGraphicFrame(this, (CTGraphicalObjectFrame) object);
                        } else if (object instanceof CTGroupShape) {
                            xSSFShapeGroup = new XSSFShapeGroup(this, (CTGroupShape) object);
                        } else if (object instanceof XmlAnyTypeImpl) {
                            LOG.atWarn().log("trying to parse AlternateContent, this unlinks the returned Shapes from the underlying xml content, so those shapes can't be used to modify the drawing, i.e. modifications will be ignored!");
                            xmlCursor.push();
                            xmlCursor.toFirstChild();
                            try {
                                try {
                                    XmlCursor xmlCursorNewCursor = CTDrawing.Factory.parse(xmlCursor.newXMLStreamReader()).newCursor();
                                    try {
                                        if (xmlCursorNewCursor.toFirstChild()) {
                                            addShapes(xmlCursorNewCursor, list);
                                        }
                                        xmlCursorNewCursor.close();
                                        xmlCursor.pop();
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
                                } catch (XmlException e) {
                                    LOG.atWarn().withThrowable(e).log("unable to parse CTDrawing in alternate content.");
                                }
                            } catch (Throwable th4) {
                                xmlCursor.pop();
                                throw th4;
                            }
                        }
                        xSSFShapeGroup.anchor = getAnchorFromParent(object);
                        list.add(xSSFShapeGroup);
                    }
                } while (xmlCursor.toNextSibling());
            }
            xmlCursor.pop();
        } while (xmlCursor.toNextSibling());
    }

    private XSSFGraphicFrame createGraphicFrame(XSSFClientAnchor xSSFClientAnchor) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameAddNewGraphicFrame = createTwoCellAnchor(xSSFClientAnchor).addNewGraphicFrame();
        cTGraphicalObjectFrameAddNewGraphicFrame.set(XSSFGraphicFrame.prototype());
        cTGraphicalObjectFrameAddNewGraphicFrame.setXfrm(createXfrm(xSSFClientAnchor));
        long j6 = this.numOfGraphicFrames;
        this.numOfGraphicFrames = 1 + j6;
        XSSFGraphicFrame xSSFGraphicFrame = new XSSFGraphicFrame(this, cTGraphicalObjectFrameAddNewGraphicFrame);
        xSSFGraphicFrame.setAnchor(xSSFClientAnchor);
        xSSFGraphicFrame.setId(j6);
        xSSFGraphicFrame.setName("Diagramm" + j6);
        return xSSFGraphicFrame;
    }

    private CTTwoCellAnchor createTwoCellAnchor(XSSFClientAnchor xSSFClientAnchor) {
        STEditAs.Enum r6;
        CTTwoCellAnchor cTTwoCellAnchorAddNewTwoCellAnchor = this.drawing.addNewTwoCellAnchor();
        cTTwoCellAnchorAddNewTwoCellAnchor.setFrom(xSSFClientAnchor.getFrom());
        cTTwoCellAnchorAddNewTwoCellAnchor.setTo(xSSFClientAnchor.getTo());
        cTTwoCellAnchorAddNewTwoCellAnchor.addNewClientData();
        xSSFClientAnchor.setTo(cTTwoCellAnchorAddNewTwoCellAnchor.getTo());
        xSSFClientAnchor.setFrom(cTTwoCellAnchorAddNewTwoCellAnchor.getFrom());
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType[xSSFClientAnchor.getAnchorType().ordinal()];
        if (i5 == 1) {
            r6 = STEditAs.ABSOLUTE;
        } else if (i5 != 2) {
            r6 = i5 != 3 ? STEditAs.ONE_CELL : STEditAs.ONE_CELL;
        } else {
            r6 = STEditAs.TWO_CELL;
        }
        cTTwoCellAnchorAddNewTwoCellAnchor.setEditAs(r6);
        return cTTwoCellAnchorAddNewTwoCellAnchor;
    }

    private CTTransform2D createXfrm(XSSFClientAnchor xSSFClientAnchor) {
        CTTransform2D cTTransform2DNewInstance = CTTransform2D.Factory.newInstance();
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DNewInstance.addNewOff();
        cTPoint2DAddNewOff.setX(Integer.valueOf(xSSFClientAnchor.getDx1()));
        cTPoint2DAddNewOff.setY(Integer.valueOf(xSSFClientAnchor.getDy1()));
        XSSFSheet sheet = getSheet();
        double rowHeightInPixels = 0.0d;
        double columnWidthInPixels = 0.0d;
        for (int col1 = xSSFClientAnchor.getCol1(); col1 < xSSFClientAnchor.getCol2(); col1++) {
            columnWidthInPixels += (double) sheet.getColumnWidthInPixels(col1);
        }
        for (int row1 = xSSFClientAnchor.getRow1(); row1 < xSSFClientAnchor.getRow2(); row1++) {
            rowHeightInPixels += ImageUtils.getRowHeightInPixels(sheet, row1);
        }
        long jPixelToEMU = Units.pixelToEMU((int) columnWidthInPixels);
        long jPixelToEMU2 = Units.pixelToEMU((int) rowHeightInPixels);
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DNewInstance.addNewExt();
        cTPositiveSize2DAddNewExt.setCx((jPixelToEMU - ((long) xSSFClientAnchor.getDx1())) + ((long) xSSFClientAnchor.getDx2()));
        cTPositiveSize2DAddNewExt.setCy((jPixelToEMU2 - ((long) xSSFClientAnchor.getDy1())) + ((long) xSSFClientAnchor.getDy2()));
        return cTTransform2DNewInstance;
    }

    private XSSFAnchor getAnchorFromParent(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            XmlObject object = xmlCursorNewCursor.toParent() ? xmlCursorNewCursor.getObject() : null;
            xmlCursorNewCursor.close();
            if (object != null) {
                if (object instanceof CTTwoCellAnchor) {
                    CTTwoCellAnchor cTTwoCellAnchor = (CTTwoCellAnchor) object;
                    return new XSSFClientAnchor(cTTwoCellAnchor.getFrom(), cTTwoCellAnchor.getTo());
                }
                if (object instanceof CTOneCellAnchor) {
                    CTOneCellAnchor cTOneCellAnchor = (CTOneCellAnchor) object;
                    return new XSSFClientAnchor(getSheet(), cTOneCellAnchor.getFrom(), cTOneCellAnchor.getExt());
                }
                if (object instanceof CTAbsoluteAnchor) {
                    CTAbsoluteAnchor cTAbsoluteAnchor = (CTAbsoluteAnchor) object;
                    return new XSSFClientAnchor(getSheet(), cTAbsoluteAnchor.getPos(), cTAbsoluteAnchor.getExt());
                }
            }
            return null;
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

    private boolean hasOleLink(XmlObject xmlObject) {
        QName qName = new QName(null, "uri");
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:extLst/a:ext");
            while (xmlCursorNewCursor.toNextSelection()) {
                if ("{63B3BB69-23CF-44E3-9099-C40C66FF867C}".equals(xmlCursorNewCursor.getAttributeText(qName))) {
                    xmlCursorNewCursor.close();
                    return true;
                }
            }
            xmlCursorNewCursor.close();
            return false;
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

    private static CTDrawing newDrawing() {
        return CTDrawing.Factory.newInstance();
    }

    private long newShapeId() {
        return ((long) this.drawing.sizeOfAbsoluteAnchorArray()) + 1 + ((long) this.drawing.sizeOfOneCellAnchorArray()) + ((long) this.drawing.sizeOfTwoCellAnchorArray());
    }

    public PackageRelationship addPictureReference(int i5) {
        return addRelation(null, XSSFRelation.IMAGES, new XSSFPictureData(getSheet().getWorkbook().getAllPictures().get(i5).getPackagePart())).getRelationship();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTDrawing.type.getName().getNamespaceURI(), "wsDr", "xdr"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.drawing.save(outputStream, xmlOptions);
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

    public XSSFChart createChart(XSSFClientAnchor xSSFClientAnchor) {
        POIXMLDocumentPart.RelationPart relationPartCreateChartRelationPart = createChartRelationPart();
        XSSFChart xSSFChart = (XSSFChart) relationPartCreateChartRelationPart.getDocumentPart();
        String id = relationPartCreateChartRelationPart.getRelationship().getId();
        XSSFGraphicFrame xSSFGraphicFrameCreateGraphicFrame = createGraphicFrame(xSSFClientAnchor);
        xSSFGraphicFrameCreateGraphicFrame.setChart(xSSFChart, id);
        xSSFGraphicFrameCreateGraphicFrame.getCTGraphicalObjectFrame().setXfrm(createXfrm(xSSFClientAnchor));
        return xSSFChart;
    }

    public POIXMLDocumentPart.RelationPart createChartRelationPart() {
        XSSFRelation xSSFRelation;
        XSSFWorkbook workbook = getSheet().getWorkbook();
        XSSFFactory xSSFFactory = workbook == null ? XSSFFactory.getInstance() : workbook.getXssfFactory();
        OPCPackage oPCPackage = getPackagePart().getPackage();
        int size = oPCPackage.getPartsByContentType(XSSFRelation.CHART.getContentType()).size();
        do {
            size++;
            try {
                xSSFRelation = XSSFRelation.CHART;
            } catch (InvalidFormatException e) {
                throw new IllegalStateException(AbstractC0157z.k(size, "Failed for "), e);
            }
        } while (oPCPackage.getPart(PackagingURIHelper.createPartName(xSSFRelation.getFileName(size))) != null);
        return createRelationship(xSSFRelation, xSSFFactory, size, false);
    }

    public XSSFConnector createConnector(XSSFClientAnchor xSSFClientAnchor) {
        CTConnector cTConnectorAddNewCxnSp = createTwoCellAnchor(xSSFClientAnchor).addNewCxnSp();
        cTConnectorAddNewCxnSp.set(XSSFConnector.prototype());
        XSSFConnector xSSFConnector = new XSSFConnector(this, cTConnectorAddNewCxnSp);
        xSSFConnector.anchor = xSSFClientAnchor;
        return xSSFConnector;
    }

    public XSSFShapeGroup createGroup(XSSFClientAnchor xSSFClientAnchor) {
        CTGroupShape cTGroupShapeAddNewGrpSp = createTwoCellAnchor(xSSFClientAnchor).addNewGrpSp();
        cTGroupShapeAddNewGrpSp.set(XSSFShapeGroup.prototype());
        CTTransform2D cTTransform2DCreateXfrm = createXfrm(xSSFClientAnchor);
        CTGroupTransform2D xfrm = cTGroupShapeAddNewGrpSp.getGrpSpPr().getXfrm();
        xfrm.setOff(cTTransform2DCreateXfrm.getOff());
        xfrm.setExt(cTTransform2DCreateXfrm.getExt());
        xfrm.setChExt(cTTransform2DCreateXfrm.getExt());
        XSSFShapeGroup xSSFShapeGroup = new XSSFShapeGroup(this, cTGroupShapeAddNewGrpSp);
        xSSFShapeGroup.anchor = xSSFClientAnchor;
        return xSSFShapeGroup;
    }

    public XSSFSimpleShape createSimpleShape(XSSFClientAnchor xSSFClientAnchor) {
        long jNewShapeId = newShapeId();
        CTShape cTShapeAddNewSp = createTwoCellAnchor(xSSFClientAnchor).addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        cTShapeAddNewSp.getNvSpPr().getCNvPr().setId(jNewShapeId);
        cTShapeAddNewSp.getSpPr().setXfrm(createXfrm(xSSFClientAnchor));
        XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(this, cTShapeAddNewSp);
        xSSFSimpleShape.anchor = xSSFClientAnchor;
        return xSSFSimpleShape;
    }

    public XSSFTextBox createTextbox(XSSFClientAnchor xSSFClientAnchor) {
        long jNewShapeId = newShapeId();
        CTShape cTShapeAddNewSp = createTwoCellAnchor(xSSFClientAnchor).addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        cTShapeAddNewSp.getNvSpPr().getCNvPr().setId(jNewShapeId);
        XSSFTextBox xSSFTextBox = new XSSFTextBox(this, cTShapeAddNewSp);
        xSSFTextBox.anchor = xSSFClientAnchor;
        return xSSFTextBox;
    }

    @Internal
    public CTDrawing getCTDrawing() {
        return this.drawing;
    }

    public List<XSSFChart> getCharts() {
        ArrayList arrayList = new ArrayList();
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSSFChart) {
                arrayList.add((XSSFChart) pOIXMLDocumentPart);
            }
        }
        return arrayList;
    }

    public List<XSSFShape> getShapes() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.drawing.newCursor();
        try {
            if (xmlCursorNewCursor.toFirstChild()) {
                addShapes(xmlCursorNewCursor, arrayList);
            }
            xmlCursorNewCursor.close();
            return arrayList;
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

    public XSSFSheet getSheet() {
        return (XSSFSheet) getParent();
    }

    public XSSFChart importChart(XSSFChart xSSFChart) {
        CTTwoCellAnchor twoCellAnchorArray = ((XSSFDrawing) xSSFChart.getParent()).getCTDrawing().getTwoCellAnchorArray(0);
        XSSFClientAnchor xSSFClientAnchor = new XSSFClientAnchor((CTMarker) twoCellAnchorArray.getFrom().copy(), (CTMarker) twoCellAnchorArray.getTo().copy());
        xSSFClientAnchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
        XSSFChart xSSFChartCreateChart = createChart(xSSFClientAnchor);
        xSSFChartCreateChart.getCTChartSpace().set(xSSFChart.getCTChartSpace().copy());
        return xSSFChartCreateChart;
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return getShapes().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFShape> spliterator() {
        return getShapes().spliterator();
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFClientAnchor createAnchor(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return new XSSFClientAnchor(i5, i6, i7, i8, i9, i10, i11, i12);
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFComment createCellComment(ClientAnchor clientAnchor) {
        return getSheet().getCommentsTable(true).createNewComment(clientAnchor);
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFObjectData createObjectData(ClientAnchor clientAnchor, int i5, int i6) {
        XSSFSheet sheet = getSheet();
        PackagePart packagePart = sheet.getPackagePart();
        XSSFSheet sheet2 = getSheet();
        long sheetIndex = ((((long) sheet2.getWorkbook().getSheetIndex(sheet2)) + 1) * 1024) + newShapeId();
        XSSFRelation xSSFRelation = XSSFRelation.OLEEMBEDDINGS;
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(xSSFRelation.getFileName(i5));
            TargetMode targetMode = TargetMode.INTERNAL;
            PackageRelationship packageRelationshipAddRelationship = packagePart.addRelationship(packagePartNameCreatePartName, targetMode, xSSFRelation.getRelation());
            PackagePartName partName = sheet.getWorkbook().getAllPictures().get(i6).getPackagePart().getPartName();
            PackageRelationship packageRelationshipAddRelationship2 = packagePart.addRelationship(partName, targetMode, PackageRelationshipTypes.IMAGE_PART);
            PackageRelationship packageRelationshipAddRelationship3 = getPackagePart().addRelationship(partName, targetMode, PackageRelationshipTypes.IMAGE_PART);
            CTWorksheet cTWorksheet = sheet.getCTWorksheet();
            CTOleObject cTOleObjectAddNewOleObject = (cTWorksheet.isSetOleObjects() ? cTWorksheet.getOleObjects() : cTWorksheet.addNewOleObjects()).addNewOleObject();
            cTOleObjectAddNewOleObject.setProgId(ExtractorFactory.OOXML_PACKAGE);
            cTOleObjectAddNewOleObject.setShapeId(sheetIndex);
            cTOleObjectAddNewOleObject.setId(packageRelationshipAddRelationship.getId());
            XmlCursor xmlCursorNewCursor = cTOleObjectAddNewOleObject.newCursor();
            try {
                xmlCursorNewCursor.toEndToken();
                xmlCursorNewCursor.beginElement("objectPr", XSSFRelation.NS_SPREADSHEETML);
                xmlCursorNewCursor.insertAttributeWithValue("id", PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, packageRelationshipAddRelationship2.getId());
                xmlCursorNewCursor.insertAttributeWithValue("defaultSize", "0");
                xmlCursorNewCursor.beginElement("anchor", XSSFRelation.NS_SPREADSHEETML);
                xmlCursorNewCursor.insertAttributeWithValue("moveWithCells", "1");
                CTTwoCellAnchor cTTwoCellAnchorCreateTwoCellAnchor = createTwoCellAnchor((XSSFClientAnchor) clientAnchor);
                XmlCursor xmlCursorNewCursor2 = cTTwoCellAnchorCreateTwoCellAnchor.newCursor();
                try {
                    xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
                    xmlCursorNewCursor2.close();
                    xmlCursorNewCursor.toParent();
                    xmlCursorNewCursor.toFirstChild();
                    xmlCursorNewCursor.setName(new QName(XSSFRelation.NS_SPREADSHEETML, TypedValues.TransitionType.S_FROM));
                    xmlCursorNewCursor.toNextSibling();
                    xmlCursorNewCursor.setName(new QName(XSSFRelation.NS_SPREADSHEETML, TypedValues.TransitionType.S_TO));
                    xmlCursorNewCursor.close();
                    CTShape cTShapeAddNewSp = cTTwoCellAnchorCreateTwoCellAnchor.addNewSp();
                    cTShapeAddNewSp.set(XSSFObjectData.prototype());
                    XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) clientAnchor;
                    cTShapeAddNewSp.getSpPr().setXfrm(createXfrm(xSSFClientAnchor));
                    CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTShapeAddNewSp.getSpPr().addNewBlipFill();
                    cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(packageRelationshipAddRelationship3.getId());
                    cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
                    CTNonVisualDrawingProps cNvPr = cTShapeAddNewSp.getNvSpPr().getCNvPr();
                    cNvPr.setId(sheetIndex);
                    cNvPr.setName("Object " + sheetIndex);
                    XmlCursor xmlCursorNewCursor3 = cNvPr.getExtLst().getExtArray(0).newCursor();
                    try {
                        xmlCursorNewCursor3.toFirstChild();
                        xmlCursorNewCursor3.setAttributeText(new QName("spid"), "_x0000_s" + sheetIndex);
                        xmlCursorNewCursor3.close();
                        XSSFObjectData xSSFObjectData = new XSSFObjectData(this, cTShapeAddNewSp);
                        xSSFObjectData.anchor = xSSFClientAnchor;
                        return xSSFObjectData;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (xmlCursorNewCursor3 != null) {
                                try {
                                    xmlCursorNewCursor3.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        if (xmlCursorNewCursor2 != null) {
                            try {
                                xmlCursorNewCursor2.close();
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
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public XSSFPicture createPicture(XSSFClientAnchor xSSFClientAnchor, int i5) {
        PackageRelationship packageRelationshipAddPictureReference = addPictureReference(i5);
        long jNewShapeId = newShapeId();
        CTPicture cTPictureAddNewPic = createTwoCellAnchor(xSSFClientAnchor).addNewPic();
        cTPictureAddNewPic.set(XSSFPicture.prototype());
        cTPictureAddNewPic.getNvPicPr().getCNvPr().setId(jNewShapeId);
        XSSFPicture xSSFPicture = new XSSFPicture(this, cTPictureAddNewPic);
        xSSFPicture.anchor = xSSFClientAnchor;
        xSSFPicture.setPictureReference(packageRelationshipAddPictureReference);
        cTPictureAddNewPic.getSpPr().setXfrm(createXfrm(xSSFClientAnchor));
        return xSSFPicture;
    }

    public XSSFDrawing(PackagePart packagePart) throws IOException {
        super(packagePart);
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setLoadReplaceDocumentElement(null);
        InputStream inputStream = packagePart.getInputStream();
        try {
            this.drawing = CTDrawing.Factory.parse(inputStream, xmlOptions);
            if (inputStream != null) {
                inputStream.close();
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
    }

    public XSSFChart createChart(ClientAnchor clientAnchor) {
        return createChart((XSSFClientAnchor) clientAnchor);
    }

    public List<XSSFShape> getShapes(XSSFShapeGroup xSSFShapeGroup) {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = xSSFShapeGroup.getCTGroupShape().newCursor();
        try {
            addShapes(xmlCursorNewCursor, arrayList);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return arrayList;
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

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFPicture createPicture(ClientAnchor clientAnchor, int i5) {
        return createPicture((XSSFClientAnchor) clientAnchor, i5);
    }
}
