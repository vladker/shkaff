package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.ObjectData;
import org.apache.poi.util.IOUtils;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFObjectData extends XSSFSimpleShape implements ObjectData {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFObjectData.class);
    private static CTShape prototype;
    private CTOleObject oleObject;

    public XSSFObjectData(XSSFDrawing xSSFDrawing, CTShape cTShape) {
        super(xSSFDrawing, cTShape);
    }

    public static CTShape prototype() {
        if (prototype == null) {
            CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
            CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Shape 1");
            CTOfficeArtExtension cTOfficeArtExtensionAddNewExt = cTNonVisualDrawingPropsAddNewCNvPr.addNewExtLst().addNewExt();
            cTOfficeArtExtensionAddNewExt.setUri("{63B3BB69-23CF-44E3-9099-C40C66FF867C}");
            XmlCursor xmlCursorNewCursor = cTOfficeArtExtensionAddNewExt.newCursor();
            try {
                xmlCursorNewCursor.toEndToken();
                xmlCursorNewCursor.beginElement(new QName("http://schemas.microsoft.com/office/drawing/2010/main", "compatExt", "a14"));
                xmlCursorNewCursor.insertNamespace("a14", "http://schemas.microsoft.com/office/drawing/2010/main");
                xmlCursorNewCursor.insertAttributeWithValue("spid", "_x0000_s1");
                xmlCursorNewCursor.close();
                cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
                CTShapeProperties cTShapePropertiesAddNewSpPr = cTShapeNewInstance.addNewSpPr();
                CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
                CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
                cTPositiveSize2DAddNewExt.setCx(0L);
                cTPositiveSize2DAddNewExt.setCy(0L);
                CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
                cTPoint2DAddNewOff.setX(0);
                cTPoint2DAddNewOff.setY(0);
                CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
                cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
                cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
                prototype = cTShapeNewInstance;
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
        return prototype;
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public String getContentType() {
        return getObjectPart().getContentType();
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public DirectoryEntry getDirectory() throws IOException {
        InputStream inputStream = getObjectPart().getInputStream();
        try {
            DirectoryNode root = new POIFSFileSystem(inputStream).getRoot();
            if (inputStream != null) {
                inputStream.close();
            }
            return root;
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

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public String getFileName() {
        return getObjectPart().getPartName().getName();
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public String getOLE2ClassName() {
        return getOleObject().getProgId();
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public byte[] getObjectData() throws IOException {
        InputStream inputStream = getObjectPart().getInputStream();
        try {
            byte[] byteArray = IOUtils.toByteArray(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return byteArray;
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

    public PackagePart getObjectPart() {
        if (!getOleObject().isSetId()) {
            throw new POIXMLException("Invalid ole object found in sheet container");
        }
        POIXMLDocumentPart relationById = getSheet().getRelationById(getOleObject().getId());
        if (relationById == null) {
            return null;
        }
        return relationById.getPackagePart();
    }

    public CTOleObject getOleObject() {
        if (this.oleObject == null) {
            CTOleObject oleObject = getSheet().readOleObject(getCTShape().getNvSpPr().getCNvPr().getId());
            this.oleObject = oleObject;
            if (oleObject == null) {
                throw new POIXMLException("Ole object not found in sheet container - it's probably a control element");
            }
        }
        return this.oleObject;
    }

    public XSSFSheet getSheet() {
        return (XSSFSheet) getDrawing().getParent();
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public boolean hasDirectoryEntry() {
        InputStream inputStreamPrepareToCheckMagic = null;
        try {
            inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(getObjectPart().getInputStream());
            return FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2;
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("can't determine if directory entry exists");
            return false;
        } finally {
            IOUtils.closeQuietly(inputStreamPrepareToCheckMagic);
        }
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public XSSFPictureData getPictureData() {
        XmlCursor xmlCursorNewCursor = getOleObject().newCursor();
        try {
            if (!xmlCursorNewCursor.toChild(XSSFRelation.NS_SPREADSHEETML, "objectPr")) {
                xmlCursorNewCursor.close();
                return null;
            }
            XSSFPictureData xSSFPictureData = (XSSFPictureData) getSheet().getRelationById(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "id")));
            xmlCursorNewCursor.close();
            return xSSFPictureData;
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
