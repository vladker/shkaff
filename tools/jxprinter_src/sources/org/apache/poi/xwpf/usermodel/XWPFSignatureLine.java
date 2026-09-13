package org.apache.poi.xwpf.usermodel;

import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.vml.CTImageData;
import javax.xml.namespace.QName;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.g;
import org.apache.poi.poifs.crypt.dsig.SignatureLine;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFSignatureLine extends SignatureLine {
    private static final String MS_VML_URN = "urn:schemas-microsoft-com:vml";
    private CTSignatureLine line;

    /* JADX INFO: renamed from: org.apache.poi.xwpf.usermodel.XWPFSignatureLine$1, reason: invalid class name */
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
            try {
                $SwitchMap$org$apache$poi$common$usermodel$PictureType[PictureType.WDP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$add$0(XWPFParagraph xWPFParagraph, byte[] bArr, PictureType pictureType) {
        return xWPFParagraph.getDocument().addPictureData(bArr, mapType(pictureType));
    }

    private static PictureType mapType(PictureType pictureType) throws InvalidFormatException {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$PictureType[pictureType.ordinal()]) {
            case 1:
                return PictureType.BMP;
            case 2:
                return PictureType.DIB;
            case 3:
                return PictureType.EMF;
            case 4:
                return PictureType.EPS;
            case 5:
                return PictureType.GIF;
            case 6:
                return PictureType.JPEG;
            case 7:
                return PictureType.PICT;
            case 8:
                return PictureType.PNG;
            case 9:
                return PictureType.TIFF;
            case 10:
                return PictureType.WMF;
            case 11:
                return PictureType.WPG;
            case 12:
                return PictureType.WDP;
            default:
                throw new InvalidFormatException("Unsupported picture format " + pictureType);
        }
    }

    public void add(XWPFParagraph xWPFParagraph) {
        add(xWPFParagraph.createRun().getCTR().addNewPict(), new g(xWPFParagraph, 8));
    }

    public void parse(XWPFDocument xWPFDocument) {
        CTSignatureLine cTSignatureLine = (CTSignatureLine) XPathHelper.selectProperty(xWPFDocument.getDocument(), CTSignatureLine.class, null, new QName[]{new QName(XSSFRelation.NS_WORDPROCESSINGML, "body")}, new QName[]{new QName(XSSFRelation.NS_WORDPROCESSINGML, "p")}, new QName[]{new QName(XSSFRelation.NS_WORDPROCESSINGML, "r")}, new QName[]{new QName(XSSFRelation.NS_WORDPROCESSINGML, ContentTypes.EXTENSION_PICT)}, new QName[]{new QName(MS_VML_URN, "shape")}, new QName[]{SignatureLine.QNAME_SIGNATURE_LINE});
        this.line = cTSignatureLine;
        if (cTSignatureLine != null) {
            setSignatureShape(cTSignatureLine);
            parse();
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureLine
    public void setRelationId(CTImageData cTImageData, String str) {
        cTImageData.setId2(str);
    }
}
