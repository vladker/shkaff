package org.apache.poi.xslf.usermodel;

import java.awt.Insets;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.draw.SVGImageRenderer;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFPictureShape extends XSLFSimpleShape implements PictureShape<XSLFShape, XSLFTextParagraph> {
    private static final String BITMAP_URI = "{28A0092B-C50C-407E-A947-70E740481C1C}";
    private static final String MS_DML_NS = "http://schemas.microsoft.com/office/drawing/2010/main";
    private static final String MS_SVG_NS = "http://schemas.microsoft.com/office/drawing/2016/SVG/main";
    private static final String SVG_URI = "{96DAC541-7B7A-43D3-8B79-37D633B846F1}";
    private XSLFPictureData _data;
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFPictureShape.class);
    private static final QName EMBED_TAG = new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "embed", "rel");
    private static final QName[] BLIP_FILL = {new QName(XSSFRelation.NS_PRESENTATIONML, "blipFill")};

    public XSLFPictureShape(CTPicture cTPicture, XSLFSheet xSLFSheet) {
        super(cTPicture, xSLFSheet);
    }

    public static XSLFPictureShape addSvgImage(XSLFSheet xSLFSheet, XSLFPictureData xSLFPictureData, PictureData.PictureType pictureType, Rectangle2D rectangle2D) throws IOException {
        PictureData.PictureType pictureType2;
        SVGImageRenderer sVGImageRenderer = new SVGImageRenderer();
        InputStream inputStream = xSLFPictureData.getInputStream();
        try {
            sVGImageRenderer.loadImage(inputStream, xSLFPictureData.getType().contentType);
            if (inputStream != null) {
                inputStream.close();
            }
            Dimension2D dimension = sVGImageRenderer.getDimension();
            if (rectangle2D == null) {
                rectangle2D = new Rectangle2D.Double(0.0d, 0.0d, Units.pixelToPoints((int) dimension.getWidth()), Units.pixelToPoints((int) dimension.getHeight()));
            }
            if (pictureType == null) {
                pictureType = PictureData.PictureType.PNG;
            }
            if (pictureType != PictureData.PictureType.JPEG && pictureType != PictureData.PictureType.GIF && pictureType != (pictureType2 = PictureData.PictureType.PNG)) {
                pictureType = pictureType2;
            }
            BufferedImage image = sVGImageRenderer.getImage(dimension);
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(BZip2Constants.BASEBLOCKSIZE);
            ImageIO.write(image, pictureType.extension.substring(1), unsynchronizedByteArrayOutputStream);
            XSLFPictureShape xSLFPictureShapeCreatePicture = xSLFSheet.createPicture((PictureData) xSLFSheet.getSlideShow().addPicture(unsynchronizedByteArrayOutputStream.toInputStream(), pictureType));
            xSLFPictureShapeCreatePicture.setAnchor(rectangle2D);
            xSLFPictureShapeCreatePicture.setSvgImage(xSLFPictureData);
            return xSLFPictureShapeCreatePicture;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream == null) {
                    throw th2;
                }
                try {
                    inputStream.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    private CTPictureNonVisual getCTPictureNonVisual() {
        XmlObject xmlObject = getXmlObject();
        if (xmlObject instanceof CTPicture) {
            return ((CTPicture) xmlObject).getNvPicPr();
        }
        return null;
    }

    private int getExt(CTOfficeArtExtensionList cTOfficeArtExtensionList, String str) {
        int iSizeOfExtArray = cTOfficeArtExtensionList.sizeOfExtArray();
        for (int i5 = 0; i5 < iSizeOfExtArray; i5++) {
            if (str.equals(cTOfficeArtExtensionList.getExtArray(i5).getUri())) {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader) {
        CTPicture cTPicture = CTPicture.Factory.parse(xMLStreamReader);
        if (cTPicture != null) {
            return cTPicture.getBlipFill();
        }
        return null;
    }

    public static CTPicture prototype(int i5, String str) {
        CTPicture cTPictureNewInstance = CTPicture.Factory.newInstance();
        CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPictureNewInstance.addNewNvPicPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
        cTPictureNonVisualAddNewNvPicPr.addNewNvPr();
        CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPictureNewInstance.addNewBlipFill();
        cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(str);
        cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTPictureNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        return cTPictureNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFPictureShape xSLFPictureShape = (XSLFPictureShape) xSLFShape;
        String blipId = xSLFPictureShape.getBlipId();
        if (blipId == null) {
            LOG.atWarn().log("unable to copy invalid picture shape");
            return;
        }
        String strImportBlip = getSheet().importBlip(blipId, xSLFPictureShape.getSheet());
        CTBlip blip = getBlipFill().getBlip();
        blip.setEmbed(strImportBlip);
        CTPictureNonVisual cTPictureNonVisual = getCTPictureNonVisual();
        CTApplicationNonVisualDrawingProps nvPr = cTPictureNonVisual == null ? null : cTPictureNonVisual.getNvPr();
        if (nvPr != null && nvPr.isSetCustDataLst()) {
            nvPr.unsetCustDataLst();
        }
        if (blip.isSetExtLst()) {
            for (CTOfficeArtExtension cTOfficeArtExtension : blip.getExtLst().getExtArray()) {
                XmlObject[] xmlObjectArrSelectPath = cTOfficeArtExtension.selectPath("declare namespace a14='http://schemas.microsoft.com/office/drawing/2010/main' $this//a14:imgProps/a14:imgLayer");
                if (xmlObjectArrSelectPath != null && xmlObjectArrSelectPath.length == 1) {
                    XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
                    try {
                        QName qName = EMBED_TAG;
                        xmlCursorNewCursor.setAttributeText(qName, getSheet().importBlip(xmlCursorNewCursor.getAttributeText(qName), xSLFPictureShape.getSheet()));
                        xmlCursorNewCursor.close();
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
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.PictureShape
    public PictureData getAlternativePictureData() {
        return getSvgImage();
    }

    public CTBlip getBlip() {
        return getBlipFill().getBlip();
    }

    public CTBlipFillProperties getBlipFill() {
        CTBlipFillProperties blipFill = ((CTPicture) getXmlObject()).getBlipFill();
        if (blipFill != null) {
            return blipFill;
        }
        try {
            return (CTBlipFillProperties) XPathHelper.selectProperty(getXmlObject(), CTBlipFillProperties.class, new org.apache.poi.xdgf.usermodel.a(7), BLIP_FILL);
        } catch (XmlException unused) {
            return null;
        }
    }

    public String getBlipId() {
        CTBlip blip = getBlip();
        if (blip == null) {
            return null;
        }
        String embed = blip.getEmbed();
        if (embed.isEmpty()) {
            return null;
        }
        return embed;
    }

    public String getBlipLink() {
        CTBlip blip = getBlip();
        if (blip == null) {
            return null;
        }
        String link = blip.getLink();
        if (link.isEmpty()) {
            return null;
        }
        return link;
    }

    @Override // org.apache.poi.sl.usermodel.PictureShape
    public Insets getClipping() {
        CTRelativeRect srcRect = getBlipFill().getSrcRect();
        if (srcRect == null) {
            return null;
        }
        return new Insets(POIXMLUnits.parsePercent(srcRect.xgetT()), POIXMLUnits.parsePercent(srcRect.xgetL()), POIXMLUnits.parsePercent(srcRect.xgetB()), POIXMLUnits.parsePercent(srcRect.xgetR()));
    }

    public String getName() {
        CTNonVisualDrawingProps cNvPr;
        CTPictureNonVisual cTPictureNonVisual = getCTPictureNonVisual();
        if (cTPictureNonVisual == null || (cNvPr = cTPictureNonVisual.getCNvPr()) == null) {
            return null;
        }
        return cNvPr.getName();
    }

    public URI getPictureLink() {
        String blipLink;
        PackageRelationship relationship;
        if (getBlipId() != null || (blipLink = getBlipLink()) == null || (relationship = getSheet().getPackagePart().getRelationship(blipLink)) == null) {
            return null;
        }
        return relationship.getTargetURI();
    }

    public XSLFPictureData getSvgImage() {
        CTOfficeArtExtensionList extLst;
        CTBlip blip = getBlip();
        if (blip == null || (extLst = blip.getExtLst()) == null) {
            return null;
        }
        int iSizeOfExtArray = extLst.sizeOfExtArray();
        for (int i5 = 0; i5 < iSizeOfExtArray; i5++) {
            XmlCursor xmlCursorNewCursor = extLst.getExtArray(i5).newCursor();
            try {
                if (xmlCursorNewCursor.toChild(MS_SVG_NS, "svgBlip")) {
                    String attributeText = xmlCursorNewCursor.getAttributeText(EMBED_TAG);
                    XSLFPictureData xSLFPictureData = attributeText != null ? (XSLFPictureData) getSheet().getRelationById(attributeText) : null;
                    xmlCursorNewCursor.close();
                    return xSLFPictureData;
                }
                xmlCursorNewCursor.close();
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
        return null;
    }

    public String getVideoFileLink() {
        CTPictureNonVisual cTPictureNonVisual;
        CTApplicationNonVisualDrawingProps nvPr;
        if (!isVideoFile() || (cTPictureNonVisual = getCTPictureNonVisual()) == null || (nvPr = cTPictureNonVisual.getNvPr()) == null || nvPr.getVideoFile() == null) {
            return null;
        }
        return nvPr.getVideoFile().getLink();
    }

    public boolean isExternalLinkedPicture() {
        return getBlipId() == null && getBlipLink() != null;
    }

    public boolean isVideoFile() {
        CTApplicationNonVisualDrawingProps nvPr;
        CTPictureNonVisual cTPictureNonVisual = getCTPictureNonVisual();
        if (cTPictureNonVisual == null || (nvPr = cTPictureNonVisual.getNvPr()) == null) {
            return false;
        }
        return nvPr.isSetVideoFile();
    }

    public boolean setName(String str) {
        XmlObject xmlObject = getXmlObject();
        if (!(xmlObject instanceof CTPicture)) {
            return false;
        }
        CTPicture cTPicture = (CTPicture) xmlObject;
        CTPictureNonVisual nvPicPr = cTPicture.getNvPicPr();
        if (nvPicPr == null) {
            nvPicPr = cTPicture.addNewNvPicPr();
        }
        if (nvPicPr == null) {
            return false;
        }
        CTNonVisualDrawingProps cNvPr = nvPicPr.getCNvPr();
        if (cNvPr == null) {
            cNvPr = nvPicPr.addNewCNvPr();
        }
        if (cNvPr == null) {
            return false;
        }
        cNvPr.setName(str);
        return true;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        super.setPlaceholder(placeholder);
    }

    public void setSvgImage(XSLFPictureData xSLFPictureData) {
        CTBlip blip = getBlip();
        CTOfficeArtExtensionList extLst = blip.isSetExtLst() ? blip.getExtLst() : blip.addNewExtLst();
        if (getExt(extLst, BITMAP_URI) == -1) {
            CTOfficeArtExtension cTOfficeArtExtensionAddNewExt = extLst.addNewExt();
            cTOfficeArtExtensionAddNewExt.setUri(BITMAP_URI);
            XmlCursor xmlCursorNewCursor = cTOfficeArtExtensionAddNewExt.newCursor();
            try {
                xmlCursorNewCursor.toEndToken();
                xmlCursorNewCursor.beginElement(new QName(MS_DML_NS, "useLocalDpi", "a14"));
                xmlCursorNewCursor.insertNamespace("a14", MS_DML_NS);
                xmlCursorNewCursor.insertAttributeWithValue("val", "0");
                xmlCursorNewCursor.close();
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
        int ext = getExt(extLst, SVG_URI);
        if (ext != -1) {
            extLst.removeExt(ext);
        }
        String relationId = getSheet().getRelationId(xSLFPictureData);
        if (relationId == null) {
            relationId = getSheet().addRelation(null, XSLFRelation.IMAGE_SVG, xSLFPictureData).getRelationship().getId();
        }
        CTOfficeArtExtension cTOfficeArtExtensionAddNewExt2 = extLst.addNewExt();
        cTOfficeArtExtensionAddNewExt2.setUri(SVG_URI);
        XmlCursor xmlCursorNewCursor2 = cTOfficeArtExtensionAddNewExt2.newCursor();
        try {
            xmlCursorNewCursor2.toEndToken();
            xmlCursorNewCursor2.beginElement(new QName(MS_SVG_NS, "svgBlip", "asvg"));
            xmlCursorNewCursor2.insertNamespace("asvg", MS_SVG_NS);
            xmlCursorNewCursor2.insertAttributeWithValue(EMBED_TAG, relationId);
            xmlCursorNewCursor2.close();
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
    }

    @Override // org.apache.poi.sl.usermodel.PictureShape
    public XSLFPictureData getPictureData() {
        if (this._data == null) {
            String blipId = getBlipId();
            if (blipId == null) {
                return null;
            }
            this._data = (XSLFPictureData) getSheet().getRelationById(blipId);
        }
        return this._data;
    }
}
