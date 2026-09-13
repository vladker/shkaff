package org.apache.poi.xssf.usermodel;

import F4.f;
import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.excel.STObjectType;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.vml.CTImageData;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.poifs.crypt.dsig.SignatureLine;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFSignatureLine extends SignatureLine {
    private static final String MS_VML_URN = "urn:schemas-microsoft-com:vml";

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFSignatureLine$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$PictureType;

        static {
            int[] iArr = new int[PictureType.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$PictureType = iArr;
            try {
                iArr[PictureType.BMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.DIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.EMF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.EPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.GIF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.PICT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.PNG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.TIFF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.WMF.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.WPG.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addPicture, reason: merged with bridge method [inline-methods] */
    public String lambda$add$0(byte[] bArr, PictureType pictureType, XSSFSheet xSSFSheet) throws InvalidFormatException {
        XSSFWorkbook workbook = xSSFSheet.getWorkbook();
        XSSFVMLDrawing vMLDrawing = xSSFSheet.getVMLDrawing(false);
        POIXMLRelation pOIXMLRelationMapType = mapType(pictureType);
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = vMLDrawing.createRelationship(pOIXMLRelationMapType, workbook.getXssfFactory(), workbook.getNextPartNumber(pOIXMLRelationMapType, -1), false);
        try {
            OutputStream outputStream = relationPartCreateRelationship.getDocumentPart().getPackagePart().getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.close();
                return relationPartCreateRelationship.getRelationship().getId();
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

    private static POIXMLRelation mapType(PictureType pictureType) throws InvalidFormatException {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$PictureType[pictureType.ordinal()]) {
            case 1:
                return XSSFRelation.IMAGE_BMP;
            case 2:
                return XSSFRelation.IMAGE_DIB;
            case 3:
                return XSSFRelation.IMAGE_EMF;
            case 4:
                return XSSFRelation.IMAGE_EPS;
            case 5:
                return XSSFRelation.IMAGE_GIF;
            case 6:
                return XSSFRelation.IMAGE_JPEG;
            case 7:
                return XSSFRelation.IMAGE_PICT;
            case 8:
                return XSSFRelation.IMAGE_PNG;
            case 9:
                return XSSFRelation.IMAGE_TIFF;
            case 10:
                return XSSFRelation.IMAGE_WMF;
            case 11:
                return XSSFRelation.IMAGE_WPG;
            default:
                throw new InvalidFormatException("Unsupported picture format " + pictureType);
        }
    }

    public void add(XSSFSheet xSSFSheet, XSSFClientAnchor xSSFClientAnchor) {
        add(xSSFSheet.getVMLDrawing(true).getDocument().getXml(), new f(this, xSSFSheet, 12));
        CTClientData cTClientDataAddNewClientData = getSignatureShape().addNewClientData();
        cTClientDataAddNewClientData.addAnchor(((int) xSSFClientAnchor.getCol1()) + ", " + xSSFClientAnchor.getDx1() + ", " + xSSFClientAnchor.getRow1() + ", " + xSSFClientAnchor.getDy1() + ", " + ((int) xSSFClientAnchor.getCol2()) + ", " + xSSFClientAnchor.getDx2() + ", " + xSSFClientAnchor.getRow2() + ", " + xSSFClientAnchor.getDy2());
        cTClientDataAddNewClientData.setObjectType(STObjectType.PICT);
        STTrueFalseBlank.Enum r6 = STTrueFalseBlank.f7727X;
        cTClientDataAddNewClientData.addSizeWithCells(r6);
        cTClientDataAddNewClientData.addCF(ContentTypes.EXTENSION_PICT);
        cTClientDataAddNewClientData.addAutoPict(r6);
    }

    public void parse(XSSFSheet xSSFSheet) {
        CTSignatureLine cTSignatureLine;
        XSSFVMLDrawing vMLDrawing = xSSFSheet.getVMLDrawing(false);
        if (vMLDrawing == null || (cTSignatureLine = (CTSignatureLine) XPathHelper.selectProperty(vMLDrawing.getDocument(), CTSignatureLine.class, null, new QName[]{XSSFVMLDrawing.QNAME_VMLDRAWING}, new QName[]{new QName(MS_VML_URN, "shape")}, new QName[]{SignatureLine.QNAME_SIGNATURE_LINE})) == null) {
            return;
        }
        setSignatureShape(cTSignatureLine);
        parse();
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureLine
    public void setRelationId(CTImageData cTImageData, String str) {
        cTImageData.setRelid(str);
    }
}
