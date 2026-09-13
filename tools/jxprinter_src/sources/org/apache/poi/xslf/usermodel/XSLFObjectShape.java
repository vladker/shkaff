package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.ObjectMetaData;
import org.apache.poi.sl.usermodel.ObjectShape;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFObjectShape extends XSLFGraphicFrame implements ObjectShape<XSLFShape, XSLFTextParagraph> {
    static final String OLE_URI = "http://schemas.openxmlformats.org/presentationml/2006/ole";
    private XSLFPictureData _data;
    private final CTOleObject _oleObject;
    private static final QName[] GRAPHIC = {new QName(XSSFRelation.NS_DRAWINGML, "graphic")};
    private static final QName[] GRAPHIC_DATA = {new QName(XSSFRelation.NS_DRAWINGML, "graphicData")};
    private static final QName[] OLE_OBJ = {new QName(XSSFRelation.NS_PRESENTATIONML, "oleObj")};
    private static final QName[] CT_PICTURE = {new QName(XSSFRelation.NS_PRESENTATIONML, "pic")};

    public XSLFObjectShape(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
        try {
            this._oleObject = (CTOleObject) XPathHelper.selectProperty(getXmlObject(), CTOleObject.class, null, GRAPHIC, GRAPHIC_DATA, OLE_OBJ);
        } catch (XmlException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUpdatedData(PackagePart packagePart, ObjectMetaData objectMetaData, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        packagePart.clear();
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(byteArrayOutputStream.toInputStream());
        try {
            OutputStream outputStream = packagePart.getOutputStream();
            try {
                if (FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2) {
                    POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(inputStreamPrepareToCheckMagic);
                    try {
                        pOIFSFileSystem.getRoot().setStorageClsid(objectMetaData.getClassID());
                        pOIFSFileSystem.writeFilesystem(outputStream);
                        pOIFSFileSystem.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                pOIFSFileSystem.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } else if (objectMetaData.getOleEntry() == null) {
                    byteArrayOutputStream.writeTo(outputStream);
                } else {
                    POIFSFileSystem pOIFSFileSystem2 = new POIFSFileSystem();
                    try {
                        ClassID classID = objectMetaData.getClassID();
                        if (classID != null) {
                            pOIFSFileSystem2.getRoot().setStorageClsid(classID);
                        }
                        pOIFSFileSystem2.createDocument(inputStreamPrepareToCheckMagic, objectMetaData.getOleEntry());
                        Ole10Native.createOleMarkerEntry(pOIFSFileSystem2);
                        pOIFSFileSystem2.writeFilesystem(outputStream);
                        pOIFSFileSystem2.close();
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            try {
                                pOIFSFileSystem2.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                            throw th5;
                        }
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStreamPrepareToCheckMagic != null) {
                    inputStreamPrepareToCheckMagic.close();
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                if (inputStreamPrepareToCheckMagic != null) {
                    try {
                        inputStreamPrepareToCheckMagic.close();
                    } catch (Throwable th12) {
                        th10.addSuppressed(th12);
                    }
                }
                throw th11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CTPicture parse(XMLStreamReader xMLStreamReader) {
        CTGroupShape cTGroupShape = CTGroupShape.Factory.parse(xMLStreamReader);
        if (cTGroupShape.sizeOfPicArray() > 0) {
            return cTGroupShape.getPicArray(0);
        }
        return null;
    }

    public static CTGraphicalObjectFrame prototype(int i5, String str) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Object " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr();
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewNvPr();
        cTGraphicalObjectFrameNewInstance.addNewXfrm();
        CTGraphicalObjectData cTGraphicalObjectDataAddNewGraphicData = cTGraphicalObjectFrameNewInstance.addNewGraphic().addNewGraphicData();
        cTGraphicalObjectDataAddNewGraphicData.setUri(OLE_URI);
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectDataAddNewGraphicData.newCursor();
        try {
            xmlCursorNewCursor.toEndToken();
            xmlCursorNewCursor.beginElement(new QName(XSSFRelation.NS_PRESENTATIONML, "oleObj"));
            xmlCursorNewCursor.insertElement(new QName(XSSFRelation.NS_PRESENTATIONML, "embed"));
            CTGroupShape cTGroupShapeNewInstance = CTGroupShape.Factory.newInstance();
            CTPicture cTPictureAddNewPic = cTGroupShapeNewInstance.addNewPic();
            CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPictureAddNewPic.addNewNvPicPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr2 = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr2.setName("");
            cTNonVisualDrawingPropsAddNewCNvPr2.setId(0L);
            cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr();
            cTPictureNonVisualAddNewNvPicPr.addNewNvPr();
            CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPictureAddNewPic.addNewBlipFill();
            cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(str);
            cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTPictureAddNewPic.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(1270000);
            cTPoint2DAddNewOff.setY(1270000);
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(1270000L);
            cTPositiveSize2DAddNewExt.setCy(1270000L);
            cTShapePropertiesAddNewSpPr.addNewPrstGeom().setPrst(STShapeType.RECT);
            XmlCursor xmlCursorNewCursor2 = cTGroupShapeNewInstance.newCursor();
            try {
                xmlCursorNewCursor2.toStartDoc();
                xmlCursorNewCursor2.moveXmlContents(xmlCursorNewCursor);
                xmlCursorNewCursor2.close();
                xmlCursorNewCursor.close();
                return cTGraphicalObjectFrameNewInstance;
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
    }

    public CTBlip getBlip() {
        return getBlipFill().getBlip();
    }

    public CTBlipFillProperties getBlipFill() {
        try {
            CTPicture cTPicture = (CTPicture) XPathHelper.selectProperty(getXmlObject(), CTPicture.class, new org.apache.poi.xdgf.usermodel.a(6), GRAPHIC, GRAPHIC_DATA, OLE_OBJ, CT_PICTURE);
            if (cTPicture != null) {
                return cTPicture.getBlipFill();
            }
            return null;
        } catch (XmlException unused) {
            return null;
        }
    }

    public String getBlipId() {
        String embed = getBlip().getEmbed();
        if (embed.isEmpty()) {
            return null;
        }
        return embed;
    }

    @Internal
    public CTOleObject getCTOleObject() {
        return this._oleObject;
    }

    @Override // org.apache.poi.sl.usermodel.ObjectShape
    public String getFullName() {
        CTOleObject cTOleObject = this._oleObject;
        if (cTOleObject == null) {
            return null;
        }
        return cTOleObject.getName();
    }

    @Override // org.apache.poi.sl.usermodel.ObjectShape
    public String getProgId() {
        CTOleObject cTOleObject = this._oleObject;
        if (cTOleObject == null) {
            return null;
        }
        return cTOleObject.getProgId();
    }

    @Override // org.apache.poi.sl.usermodel.ObjectShape
    public OutputStream updateObjectData(ObjectMetaData.Application application, final ObjectMetaData objectMetaData) throws IOException {
        final POIXMLDocumentPart.RelationPart relationPartCreateRelationship;
        if (application != null) {
            objectMetaData = application.getMetaData();
        }
        if (objectMetaData == null || objectMetaData.getClassID() == null) {
            throw new IllegalArgumentException("either application and/or metaData needs to be set.");
        }
        XSLFSheet sheet = getSheet();
        if (this._oleObject.isSetId()) {
            relationPartCreateRelationship = sheet.getRelationPartById(this._oleObject.getId());
        } else {
            try {
                XSLFRelation xSLFRelation = XSLFRelation.OLE_OBJECT;
                relationPartCreateRelationship = sheet.createRelationship(xSLFRelation, XSLFFactory.getInstance(), sheet.getPackagePart().getPackage().getUnusedPartIndex(xSLFRelation.getDefaultFileName()), false);
                this._oleObject.setId(relationPartCreateRelationship.getRelationship().getId());
            } catch (InvalidFormatException e) {
                throw new IOException("Unable to add new ole embedding", e);
            }
        }
        this._oleObject.setProgId(objectMetaData.getProgId());
        this._oleObject.setName(objectMetaData.getObjectName());
        return new ByteArrayOutputStream() { // from class: org.apache.poi.xslf.usermodel.XSLFObjectShape.1
            @Override // org.apache.commons.io.output.AbstractByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                XSLFObjectShape.this.addUpdatedData(relationPartCreateRelationship.getDocumentPart().getPackagePart(), objectMetaData, this);
            }
        };
    }

    @Override // org.apache.poi.sl.usermodel.ObjectShape
    public XSLFObjectData getObjectData() {
        return (XSLFObjectData) getSheet().getRelationPartById(getCTOleObject().getId()).getDocumentPart();
    }

    @Override // org.apache.poi.sl.usermodel.ObjectShape
    public XSLFPictureData getPictureData() {
        if (this._data == null) {
            String blipId = getBlipId();
            if (blipId == null) {
                return null;
            }
            PackagePart packagePart = getSheet().getPackagePart();
            PackageRelationship relationship = packagePart.getRelationship(blipId);
            if (relationship != null) {
                try {
                    this._data = new XSLFPictureData(packagePart.getRelatedPart(relationship));
                } catch (Exception e) {
                    throw new POIXMLException(e);
                }
            }
        }
        return this._data;
    }
}
