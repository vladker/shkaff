package org.apache.poi.xssf.usermodel;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.excel.STObjectType;
import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.office.office.CTShapeLayout;
import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.ShapelayoutDocument;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.STExt;
import com.microsoft.schemas.vml.STStrokeJoinStyle;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.schemas.vmldrawing.XmlDocument;
import org.apache.poi.util.Internal;
import org.apache.poi.util.ReplacingInputStream;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFVMLDrawing extends POIXMLDocumentPart {
    private static final String COMMENT_SHAPE_TYPE_ID = "_x0000_t202";
    public static final QName QNAME_VMLDRAWING = new QName("urn:schemas-poi-apache-org:vmldrawing", "xml");
    private static final Pattern ptrn_shapeId = Pattern.compile("_x0000_s(\\d+)");
    private int _shapeId;
    private String _shapeTypeId;
    private XmlDocument root;

    public XSSFVMLDrawing() {
        this._shapeId = 1024;
        newDrawing();
    }

    private boolean matchCommentShape(XmlObject xmlObject, int i5, int i6) {
        if (!(xmlObject instanceof CTShape)) {
            return false;
        }
        CTShape cTShape = (CTShape) xmlObject;
        if (cTShape.sizeOfClientDataArray() == 0) {
            return false;
        }
        CTClientData clientDataArray = cTShape.getClientDataArray(0);
        if (clientDataArray.getObjectType() != STObjectType.NOTE) {
            return false;
        }
        return clientDataArray.getRowArray(0).intValue() == i5 && clientDataArray.getColumnArray(0).intValue() == i6;
    }

    private void newDrawing() {
        XmlDocument xmlDocumentNewInstance = XmlDocument.Factory.newInstance();
        this.root = xmlDocumentNewInstance;
        XmlCursor xmlCursorNewCursor = xmlDocumentNewInstance.addNewXml().newCursor();
        try {
            ShapelayoutDocument shapelayoutDocumentNewInstance = ShapelayoutDocument.Factory.newInstance();
            CTShapeLayout cTShapeLayoutAddNewShapelayout = shapelayoutDocumentNewInstance.addNewShapelayout();
            STExt.Enum r6 = STExt.EDIT;
            cTShapeLayoutAddNewShapelayout.setExt(r6);
            CTIdMap cTIdMapAddNewIdmap = cTShapeLayoutAddNewShapelayout.addNewIdmap();
            cTIdMapAddNewIdmap.setExt(r6);
            cTIdMapAddNewIdmap.setData("1");
            xmlCursorNewCursor.toEndToken();
            XmlCursor xmlCursorNewCursor2 = shapelayoutDocumentNewInstance.newCursor();
            try {
                xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
                xmlCursorNewCursor2.close();
                CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
                CTShapetype cTShapetypeAddNewShapetype = cTGroupNewInstance.addNewShapetype();
                this._shapeTypeId = COMMENT_SHAPE_TYPE_ID;
                cTShapetypeAddNewShapetype.setId(COMMENT_SHAPE_TYPE_ID);
                cTShapetypeAddNewShapetype.setCoordsize("21600,21600");
                cTShapetypeAddNewShapetype.setSpt(202.0f);
                cTShapetypeAddNewShapetype.setPath2("m,l,21600r21600,l21600,xe");
                cTShapetypeAddNewShapetype.addNewStroke().setJoinstyle(STStrokeJoinStyle.MITER);
                CTPath cTPathAddNewPath = cTShapetypeAddNewShapetype.addNewPath();
                cTPathAddNewPath.setGradientshapeok(STTrueFalse.f7724T);
                cTPathAddNewPath.setConnecttype(STConnectType.RECT);
                xmlCursorNewCursor.toEndToken();
                XmlCursor xmlCursorNewCursor3 = cTGroupNewInstance.newCursor();
                try {
                    xmlCursorNewCursor3.copyXmlContents(xmlCursorNewCursor);
                    xmlCursorNewCursor3.close();
                    xmlCursorNewCursor.close();
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
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            write(outputStream);
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

    public CTShape findCommentShape(int i5, int i6) {
        XmlCursor xmlCursorNewCursor = this.root.getXml().newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (matchCommentShape(object, i5, i6)) {
                    CTShape cTShape = (CTShape) object;
                    xmlCursorNewCursor.close();
                    return cTShape;
                }
            }
            xmlCursorNewCursor.close();
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

    public XmlDocument getDocument() {
        return this.root;
    }

    public List<XmlObject> getItems() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.root.getXml().newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                arrayList.add(xmlCursorNewCursor.getObject());
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

    @Internal
    public CTShape newCommentShape() {
        CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
        CTShape cTShapeAddNewShape = cTGroupNewInstance.addNewShape();
        StringBuilder sb = new StringBuilder("_x0000_s");
        int i5 = this._shapeId + 1;
        this._shapeId = i5;
        sb.append(i5);
        cTShapeAddNewShape.setId(sb.toString());
        cTShapeAddNewShape.setType("#" + this._shapeTypeId);
        cTShapeAddNewShape.setStyle("position:absolute; visibility:hidden");
        cTShapeAddNewShape.setFillcolor("#ffffe1");
        cTShapeAddNewShape.setInsetmode(STInsetMode.AUTO);
        cTShapeAddNewShape.addNewFill().setColor("#ffffe1");
        CTShadow cTShadowAddNewShadow = cTShapeAddNewShape.addNewShadow();
        STTrueFalse.Enum r6 = STTrueFalse.f7724T;
        cTShadowAddNewShadow.setOn(r6);
        cTShadowAddNewShadow.setColor("black");
        cTShadowAddNewShadow.setObscured(r6);
        cTShapeAddNewShape.addNewPath().setConnecttype(STConnectType.NONE);
        cTShapeAddNewShape.addNewTextbox().setStyle("mso-direction-alt:auto");
        CTClientData cTClientDataAddNewClientData = cTShapeAddNewShape.addNewClientData();
        cTClientDataAddNewClientData.setObjectType(STObjectType.NOTE);
        cTClientDataAddNewClientData.addNewMoveWithCells();
        cTClientDataAddNewClientData.addNewSizeWithCells();
        cTClientDataAddNewClientData.addNewAnchor().setStringValue("1, 15, 0, 2, 3, 15, 3, 16");
        cTClientDataAddNewClientData.addNewAutoFill().setStringValue("False");
        cTClientDataAddNewClientData.addNewRow().setBigIntegerValue(BigInteger.valueOf(0L));
        cTClientDataAddNewClientData.addNewColumn().setBigIntegerValue(BigInteger.valueOf(0L));
        XmlCursor xmlCursorNewCursor = this.root.getXml().newCursor();
        try {
            xmlCursorNewCursor.toEndToken();
            XmlCursor xmlCursorNewCursor2 = cTGroupNewInstance.newCursor();
            try {
                xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
                xmlCursorNewCursor.toPrevSibling();
                CTShape cTShape = (CTShape) xmlCursorNewCursor.getObject();
                xmlCursorNewCursor2.close();
                xmlCursorNewCursor.close();
                return cTShape;
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

    public void read(InputStream inputStream) {
        String id;
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setLoadSubstituteNamespaces(Collections.singletonMap("", QNAME_VMLDRAWING.getNamespaceURI()));
        xmlOptions.setDocumentType(XmlDocument.type);
        XmlDocument xmlDocument = XmlDocument.Factory.parse(new ReplacingInputStream(new ReplacingInputStream(inputStream, "<br>", "<br/>"), " xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\"", ""), xmlOptions);
        this.root = xmlDocument;
        XmlCursor xmlCursorNewCursor = xmlDocument.getXml().newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTShapetype) {
                    this._shapeTypeId = ((CTShapetype) object).getId();
                } else if ((object instanceof CTShape) && (id = ((CTShape) object).getId()) != null) {
                    Matcher matcher = ptrn_shapeId.matcher(id);
                    if (matcher.find()) {
                        this._shapeId = Math.max(this._shapeId, Integer.parseInt(matcher.group(1)));
                    }
                }
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

    public boolean removeCommentShape(int i5, int i6) {
        XmlCursor xmlCursorNewCursor = this.root.getXml().newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                if (matchCommentShape(xmlCursorNewCursor.getObject(), i5, i6)) {
                    xmlCursorNewCursor.removeXml();
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

    public void write(OutputStream outputStream) {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveImplicitNamespaces(Collections.singletonMap("", QNAME_VMLDRAWING.getNamespaceURI()));
        this.root.save(outputStream, xmlOptions);
    }

    public XSSFVMLDrawing(PackagePart packagePart) throws IOException {
        super(packagePart);
        this._shapeId = 1024;
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            read(inputStream);
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
}
