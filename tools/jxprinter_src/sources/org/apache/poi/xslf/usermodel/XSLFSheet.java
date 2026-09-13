package org.apache.poi.xslf.usermodel;

import androidx.webkit.ProxyConfig;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.draw.DrawPictureShape;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XSLFSheet extends POIXMLDocumentPart implements XSLFShapeContainer, Sheet<XSLFShape, XSLFTextParagraph> {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFSheet.class);
    private XSLFDrawing _drawing;
    private Map<Integer, XSLFSimpleShape> _placeholderByIdMap;
    private Map<Integer, XSLFSimpleShape> _placeholderByTypeMap;
    private List<XSLFTextShape> _placeholders;
    private List<XSLFShape> _shapes;
    private CTGroupShape _spTree;
    private XSLFTheme _theme;
    private final V2.f shapeIds;

    public XSLFSheet() {
        this.shapeIds = new V2.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<XSLFShape> buildShapes(CTGroupShape cTGroupShape, XSLFShapeContainer xSLFShapeContainer) {
        XSLFSheet sheet = xSLFShapeContainer instanceof XSLFSheet ? (XSLFSheet) xSLFShapeContainer : ((XSLFShape) xSLFShapeContainer).getSheet();
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTGroupShape.newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTShape) {
                    arrayList.add(XSLFAutoShape.create((CTShape) object, sheet));
                } else if (object instanceof CTGroupShape) {
                    arrayList.add(new XSLFGroupShape((CTGroupShape) object, sheet));
                } else if (object instanceof CTConnector) {
                    arrayList.add(new XSLFConnectorShape((CTConnector) object, sheet));
                } else if (object instanceof CTPicture) {
                    arrayList.add(new XSLFPictureShape((CTPicture) object, sheet));
                } else if (object instanceof CTGraphicalObjectFrame) {
                    arrayList.add(XSLFGraphicFrame.create((CTGraphicalObjectFrame) object, sheet));
                } else if (object instanceof XmlAnyTypeImpl) {
                    xmlCursorNewCursor.push();
                    if (xmlCursorNewCursor.toChild(PackageNamespaces.MARKUP_COMPATIBILITY, "Choice") && xmlCursorNewCursor.toFirstChild()) {
                        try {
                            arrayList.addAll(buildShapes(CTGroupShape.Factory.parse(xmlCursorNewCursor.newXMLStreamReader()), xSLFShapeContainer));
                        } catch (XmlException e) {
                            LOG.atDebug().withThrowable(e).log("unparsable alternate content");
                        }
                    }
                    xmlCursorNewCursor.pop();
                }
            }
            xmlCursorNewCursor.close();
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ((XSLFShape) obj).setParent(xSLFShapeContainer);
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

    private XSLFDrawing getDrawing() {
        initDrawingAndShapes();
        return this._drawing;
    }

    private XSLFSimpleShape getPlaceholderById(int i5) {
        initPlaceholders();
        return this._placeholderByIdMap.get(Integer.valueOf(i5));
    }

    private void initDrawingAndShapes() {
        CTGroupShape spTree = getSpTree();
        if (this._drawing == null) {
            this._drawing = new XSLFDrawing(this, spTree);
        }
        if (this._shapes == null) {
            this._shapes = buildShapes(spTree, this);
        }
    }

    private void initPlaceholders() {
        if (this._placeholders == null) {
            this._placeholders = new ArrayList();
            this._placeholderByIdMap = new HashMap();
            this._placeholderByTypeMap = new HashMap();
            for (XSLFShape xSLFShape : getShapes()) {
                if (xSLFShape instanceof XSLFTextShape) {
                    XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
                    CTPlaceholder cTPlaceholder = xSLFTextShape.getPlaceholderDetails().getCTPlaceholder(false);
                    if (cTPlaceholder != null) {
                        this._placeholders.add(xSLFTextShape);
                        if (cTPlaceholder.isSetIdx()) {
                            this._placeholderByIdMap.put(Integer.valueOf((int) cTPlaceholder.getIdx()), xSLFTextShape);
                        }
                        if (cTPlaceholder.isSetType()) {
                            this._placeholderByTypeMap.put(Integer.valueOf(cTPlaceholder.getType().intValue()), xSLFTextShape);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTheme$0(POIXMLDocumentPart pOIXMLDocumentPart) {
        return pOIXMLDocumentPart instanceof XSLFTheme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTheme$1(POIXMLDocumentPart pOIXMLDocumentPart) {
        this._theme = (XSLFTheme) pOIXMLDocumentPart;
    }

    private void wipeAndReinitialize(XSLFSheet xSLFSheet, int i5) {
        this._shapes = null;
        this._drawing = null;
        initDrawingAndShapes();
        this._placeholders = null;
        List<XSLFShape> shapes = getShapes();
        List<XSLFShape> shapes2 = xSLFSheet.getShapes();
        for (int i6 = 0; i6 < shapes2.size(); i6++) {
            shapes.get(i5 + i6).copy(shapes2.get(i6));
        }
    }

    public void addChart(XSLFChart xSLFChart) {
        addChart(xSLFChart, new Rectangle(10, 10, 500000, 500000));
    }

    public int allocateShapeId() {
        int iG = this.shapeIds.g(1);
        this.shapeIds.j(iG);
        return iG;
    }

    public XSLFSheet appendContent(XSLFSheet xSLFSheet) {
        int size = getShapes().size();
        CTGroupShape spTree = getSpTree();
        for (XmlObject xmlObject : xSLFSheet.getSpTree().selectPath(ProxyConfig.MATCH_ALL_SCHEMES)) {
            if (xmlObject instanceof CTShape) {
                spTree.addNewSp().set(xmlObject.copy());
            } else if (xmlObject instanceof CTGroupShape) {
                spTree.addNewGrpSp().set(xmlObject.copy());
            } else if (xmlObject instanceof CTConnector) {
                spTree.addNewCxnSp().set(xmlObject.copy());
            } else if (xmlObject instanceof CTPicture) {
                spTree.addNewPic().set(xmlObject.copy());
            } else if (xmlObject instanceof CTGraphicalObjectFrame) {
                spTree.addNewGraphicFrame().set(xmlObject.copy());
            }
        }
        wipeAndReinitialize(xSLFSheet, size);
        return this;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public void clear() {
        ArrayList arrayList = new ArrayList(getShapes());
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            removeShape((XSLFShape) obj);
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        String rootElementName = getRootElementName();
        if (rootElementName != null) {
            xmlOptions.setSaveSyntheticDocumentElement(new QName(XSSFRelation.NS_PRESENTATIONML, rootElementName));
        }
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            getXmlObject().save(outputStream, xmlOptions);
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

    public void deregisterShapeId(int i5) {
        if (!this.shapeIds.f(i5)) {
            LOG.atWarn().log("shape id {} hasn't been registered.", Unbox.box(i5));
        }
        this.shapeIds.a(i5);
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public void draw(Graphics2D graphics2D) {
        DrawFactory.getInstance(graphics2D).getDrawable(this).draw(graphics2D);
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public boolean getFollowMasterGraphics() {
        return false;
    }

    public XSLFSimpleShape getPlaceholder(Placeholder placeholder) {
        return getPlaceholderByType(placeholder.ooxmlId);
    }

    public XSLFSimpleShape getPlaceholderByType(int i5) {
        initPlaceholders();
        return this._placeholderByTypeMap.get(Integer.valueOf(i5));
    }

    public XSLFTextShape[] getPlaceholders() {
        initPlaceholders();
        return (XSLFTextShape[]) this._placeholders.toArray(new XSLFTextShape[0]);
    }

    public abstract String getRootElementName();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<XSLFShape> getShapes() {
        initDrawingAndShapes();
        return this._shapes;
    }

    public CTGroupShape getSpTree() {
        if (this._spTree == null) {
            XmlObject[] xmlObjectArrSelectPath = getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:spTree");
            if (xmlObjectArrSelectPath.length == 0) {
                throw new IllegalStateException("CTGroupShape was not found");
            }
            this._spTree = (CTGroupShape) xmlObjectArrSelectPath[0];
        }
        return this._spTree;
    }

    public XSLFTextShape getTextShapeByType(Placeholder placeholder) {
        for (XSLFShape xSLFShape : getShapes()) {
            if (xSLFShape instanceof XSLFTextShape) {
                XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
                if (xSLFTextShape.getTextType() == placeholder) {
                    return xSLFTextShape;
                }
            }
        }
        return null;
    }

    public XSLFTheme getTheme() {
        if (this._theme != null || !isSupportTheme()) {
            return this._theme;
        }
        getRelations().stream().filter(new org.apache.poi.xddf.usermodel.text.e(21)).findAny().ifPresent(new a(this, 2));
        return this._theme;
    }

    public abstract XmlObject getXmlObject();

    public String importBlip(String str, POIXMLDocumentPart pOIXMLDocumentPart) {
        return getSlideShow().importBlip(str, pOIXMLDocumentPart, this);
    }

    public XSLFSheet importContent(XSLFSheet xSLFSheet) {
        this._spTree = null;
        getSpTree().set(xSLFSheet.getSpTree().copy());
        wipeAndReinitialize(xSLFSheet, 0);
        return this;
    }

    public void importPart(PackageRelationship packageRelationship, PackagePart packagePart) {
        PackagePart packagePart2 = getPackagePart();
        PackagePartName partName = packagePart.getPartName();
        OPCPackage oPCPackage = packagePart2.getPackage();
        if (oPCPackage.containPart(partName)) {
            return;
        }
        packagePart2.addRelationship(partName, TargetMode.INTERNAL, packageRelationship.getRelationshipType());
        try {
            OutputStream outputStream = oPCPackage.createPart(partName, packagePart.getContentType()).getOutputStream();
            try {
                InputStream inputStream = packagePart.getInputStream();
                try {
                    IOUtils.copy(inputStream, outputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
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
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public boolean isSupportTheme() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return getShapes().iterator();
    }

    public String mapSchemeColor(String str) {
        return null;
    }

    public void registerShapeId(int i5) {
        if (this.shapeIds.f(i5)) {
            LOG.atWarn().log("shape id {} has been already used.", Unbox.box(i5));
        }
        this.shapeIds.j(i5);
    }

    public void removePictureRelation(XSLFPictureShape xSLFPictureShape) {
        String blipId;
        String blipId2 = xSLFPictureShape.getBlipId();
        int i5 = 0;
        for (XSLFShape xSLFShape : xSLFPictureShape.getSheet().getShapes()) {
            if ((xSLFShape instanceof XSLFPictureShape) && (blipId = ((XSLFPictureShape) xSLFShape).getBlipId()) != null && blipId.equals(blipId2)) {
                i5++;
            }
        }
        if (i5 <= 1) {
            removeRelation(xSLFPictureShape.getBlipId());
        }
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public void addShape(XSLFShape xSLFShape) {
        throw new UnsupportedOperationException("Adding a shape from a different container is not supported - create it from scratch witht XSLFSheet.create* methods");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFAutoShape createAutoShape() {
        XSLFAutoShape xSLFAutoShapeCreateAutoShape = getDrawing().createAutoShape();
        getShapes().add(xSLFAutoShapeCreateAutoShape);
        xSLFAutoShapeCreateAutoShape.setParent(this);
        return xSLFAutoShapeCreateAutoShape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFConnectorShape createConnector() {
        XSLFConnectorShape xSLFConnectorShapeCreateConnector = getDrawing().createConnector();
        getShapes().add(xSLFConnectorShapeCreateConnector);
        xSLFConnectorShapeCreateConnector.setParent(this);
        return xSLFConnectorShapeCreateConnector;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFFreeformShape createFreeform() {
        XSLFFreeformShape xSLFFreeformShapeCreateFreeform = getDrawing().createFreeform();
        getShapes().add(xSLFFreeformShapeCreateFreeform);
        xSLFFreeformShapeCreateFreeform.setParent(this);
        return xSLFFreeformShapeCreateFreeform;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFGroupShape createGroup() {
        XSLFGroupShape xSLFGroupShapeCreateGroup = getDrawing().createGroup();
        getShapes().add(xSLFGroupShapeCreateGroup);
        xSLFGroupShapeCreateGroup.setParent(this);
        return xSLFGroupShapeCreateGroup;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFObjectShape createOleShape(PictureData pictureData) {
        if (!(pictureData instanceof XSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
        }
        XSLFObjectShape xSLFObjectShapeCreateOleShape = getDrawing().createOleShape(addRelation(null, XSLFRelation.IMAGES, (XSLFPictureData) pictureData).getRelationship().getId());
        CTOleObject cTOleObject = xSLFObjectShapeCreateOleShape.getCTOleObject();
        Dimension imageDimension = pictureData.getImageDimension();
        cTOleObject.setImgW(Units.toEMU(imageDimension.getWidth()));
        cTOleObject.setImgH(Units.toEMU(imageDimension.getHeight()));
        getShapes().add(xSLFObjectShapeCreateOleShape);
        xSLFObjectShapeCreateOleShape.setParent(this);
        return xSLFObjectShapeCreateOleShape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFPictureShape createPicture(PictureData pictureData) {
        if (!(pictureData instanceof XSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
        }
        XSLFPictureShape xSLFPictureShapeCreatePicture = getDrawing().createPicture(addRelation(null, XSLFRelation.IMAGES, (XSLFPictureData) pictureData).getRelationship().getId());
        new DrawPictureShape(xSLFPictureShapeCreatePicture).resize();
        getShapes().add(xSLFPictureShapeCreatePicture);
        xSLFPictureShapeCreatePicture.setParent(this);
        return xSLFPictureShapeCreatePicture;
    }

    public XSLFTable createTable() {
        XSLFTable xSLFTableCreateTable = getDrawing().createTable();
        getShapes().add(xSLFTableCreateTable);
        xSLFTableCreateTable.setParent(this);
        return xSLFTableCreateTable;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFTextBox createTextBox() {
        XSLFTextBox xSLFTextBoxCreateTextBox = getDrawing().createTextBox();
        getShapes().add(xSLFTextBoxCreateTextBox);
        xSLFTextBoxCreateTextBox.setParent(this);
        return xSLFTextBoxCreateTextBox;
    }

    @Internal
    public XSLFSimpleShape getPlaceholder(CTPlaceholder cTPlaceholder) {
        XSLFSimpleShape placeholderById = cTPlaceholder.isSetIdx() ? getPlaceholderById((int) cTPlaceholder.getIdx()) : null;
        return (placeholderById == null && cTPlaceholder.isSetType()) ? getPlaceholderByType(cTPlaceholder.getType().intValue()) : placeholderById;
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFPlaceholderDetails getPlaceholderDetails(Placeholder placeholder) {
        XSLFSimpleShape placeholder2 = getPlaceholder(placeholder);
        if (placeholder2 == null) {
            return null;
        }
        return new XSLFPlaceholderDetails(placeholder2);
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XMLSlideShow getSlideShow() {
        for (POIXMLDocumentPart parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof XMLSlideShow) {
                return (XMLSlideShow) parent;
            }
        }
        throw new IllegalStateException("SlideShow was not found");
    }

    public String mapSchemeColor(CTColorMappingOverride cTColorMappingOverride, String str) {
        String strMapSchemeColor = mapSchemeColor(cTColorMappingOverride == null ? null : cTColorMappingOverride.getOverrideClrMapping(), str);
        if (strMapSchemeColor != null) {
            return strMapSchemeColor;
        }
        XSLFSheet xSLFSheet = (XSLFSheet) getMasterSheet();
        String strMapSchemeColor2 = xSLFSheet != null ? xSLFSheet.mapSchemeColor(str) : null;
        return strMapSchemeColor2 == null ? str : strMapSchemeColor2;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public boolean removeShape(XSLFShape xSLFShape) {
        XmlObject xmlObject = xSLFShape.getXmlObject();
        CTGroupShape spTree = getSpTree();
        deregisterShapeId(xSLFShape.getShapeId());
        if (xmlObject instanceof CTShape) {
            spTree.getSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGroupShape) {
            XSLFGroupShape xSLFGroupShape = (XSLFGroupShape) xSLFShape;
            new ArrayList(xSLFGroupShape.getShapes()).forEach(new a(xSLFGroupShape, 1));
            spTree.getGrpSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTConnector) {
            spTree.getCxnSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGraphicalObjectFrame) {
            spTree.getGraphicFrameList().remove(xmlObject);
        } else {
            if (!(xmlObject instanceof CTPicture)) {
                throw new IllegalArgumentException("Unsupported shape: " + xSLFShape);
            }
            removePictureRelation((XSLFPictureShape) xSLFShape);
            spTree.getPicList().remove(xmlObject);
        }
        return getShapes().remove(xSLFShape);
    }

    public XSLFSheet(PackagePart packagePart) {
        super(packagePart);
        this.shapeIds = new V2.f();
    }

    public void addChart(XSLFChart xSLFChart, Rectangle2D rectangle2D) {
        getDrawing().addChart(addRelation(null, XSLFRelation.CHART, xSLFChart).getRelationship().getId(), rectangle2D);
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFTable createTable(int i5, int i6) {
        if (i5 >= 1 && i6 >= 1) {
            XSLFTable xSLFTableCreateTable = getDrawing().createTable();
            getShapes().add(xSLFTableCreateTable);
            xSLFTableCreateTable.setParent(this);
            for (int i7 = 0; i7 < i5; i7++) {
                XSLFTableRow xSLFTableRowAddRow = xSLFTableCreateTable.addRow();
                for (int i8 = 0; i8 < i6; i8++) {
                    xSLFTableRowAddRow.addCell();
                }
            }
            return xSLFTableCreateTable;
        }
        throw new IllegalArgumentException("numRows and numCols must be greater than 0");
    }

    public String mapSchemeColor(CTColorMapping cTColorMapping, String str) {
        STColorSchemeIndex.Enum accent1;
        if (cTColorMapping != null && str != null) {
            switch (str) {
                case "accent1":
                    accent1 = cTColorMapping.getAccent1();
                    break;
                case "accent2":
                    accent1 = cTColorMapping.getAccent2();
                    break;
                case "accent3":
                    accent1 = cTColorMapping.getAccent3();
                    break;
                case "accent4":
                    accent1 = cTColorMapping.getAccent4();
                    break;
                case "accent5":
                    accent1 = cTColorMapping.getAccent5();
                    break;
                case "accent6":
                    accent1 = cTColorMapping.getAccent6();
                    break;
                case "bg1":
                    accent1 = cTColorMapping.getBg1();
                    break;
                case "bg2":
                    accent1 = cTColorMapping.getBg2();
                    break;
                case "tx1":
                    accent1 = cTColorMapping.getTx1();
                    break;
                case "tx2":
                    accent1 = cTColorMapping.getTx2();
                    break;
                case "hlink":
                    accent1 = cTColorMapping.getHlink();
                    break;
                case "folHlink":
                    accent1 = cTColorMapping.getFolHlink();
                    break;
                default:
                    accent1 = null;
                    break;
            }
        } else {
            accent1 = null;
        }
        if (accent1 == null) {
            return null;
        }
        return accent1.toString();
    }

    public XSLFTextShape getPlaceholder(int i5) {
        initPlaceholders();
        return this._placeholders.get(i5);
    }
}
