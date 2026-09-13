package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFPictureData extends POIXMLDocumentPart {
    private static final int DEFAULT_MAX_IMAGE_SIZE = 100000000;
    private static int MAX_IMAGE_SIZE = 100000000;
    protected static final POIXMLRelation[] RELATIONS;
    private Long checksum;

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[14];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[PictureType.EMF.ooxmlId] = XWPFRelation.IMAGE_EMF;
        pOIXMLRelationArr[PictureType.WMF.ooxmlId] = XWPFRelation.IMAGE_WMF;
        pOIXMLRelationArr[PictureType.PICT.ooxmlId] = XWPFRelation.IMAGE_PICT;
        pOIXMLRelationArr[PictureType.JPEG.ooxmlId] = XWPFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[PictureType.PNG.ooxmlId] = XWPFRelation.IMAGE_PNG;
        pOIXMLRelationArr[PictureType.DIB.ooxmlId] = XWPFRelation.IMAGE_DIB;
        pOIXMLRelationArr[PictureType.GIF.ooxmlId] = XWPFRelation.IMAGE_GIF;
        pOIXMLRelationArr[PictureType.TIFF.ooxmlId] = XWPFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[PictureType.EPS.ooxmlId] = XWPFRelation.IMAGE_EPS;
        pOIXMLRelationArr[PictureType.BMP.ooxmlId] = XWPFRelation.IMAGE_BMP;
        pOIXMLRelationArr[PictureType.WPG.ooxmlId] = XWPFRelation.IMAGE_WPG;
        pOIXMLRelationArr[PictureType.WDP.ooxmlId] = XWPFRelation.HDPHOTO_WDP;
    }

    public XWPFPictureData() {
    }

    public static int getMaxImageSize() {
        return MAX_IMAGE_SIZE;
    }

    public static void setMaxImageSize(int i5) {
        MAX_IMAGE_SIZE = i5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof XWPFPictureData)) {
            return false;
        }
        XWPFPictureData xWPFPictureData = (XWPFPictureData) obj;
        PackagePart packagePart = xWPFPictureData.getPackagePart();
        PackagePart packagePart2 = getPackagePart();
        if ((packagePart != null && packagePart2 == null) || (packagePart == null && packagePart2 != null)) {
            return false;
        }
        if (packagePart2 != null) {
            OPCPackage oPCPackage = packagePart.getPackage();
            OPCPackage oPCPackage2 = packagePart2.getPackage();
            if ((oPCPackage != null && oPCPackage2 == null) || (oPCPackage == null && oPCPackage2 != null)) {
                return false;
            }
            if (oPCPackage2 != null && !oPCPackage2.equals(oPCPackage)) {
                return false;
            }
        }
        Long checksum = xWPFPictureData.getChecksum();
        Long checksum2 = getChecksum();
        if (checksum2 == null) {
            if (checksum != null) {
                return false;
            }
        } else if (!checksum2.equals(checksum)) {
            return false;
        }
        return Arrays.equals(getData(), xWPFPictureData.getData());
    }

    public Long getChecksum() {
        if (this.checksum == null) {
            try {
                InputStream inputStream = getPackagePart().getInputStream();
                try {
                    this.checksum = Long.valueOf(IOUtils.calculateChecksum(inputStream));
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
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }
        return this.checksum;
    }

    public byte[] getData() {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                byte[] byteArrayWithMaxLength = IOUtils.toByteArrayWithMaxLength(inputStream, getMaxImageSize());
                if (inputStream == null) {
                    return byteArrayWithMaxLength;
                }
                inputStream.close();
                return byteArrayWithMaxLength;
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
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public String getFileName() {
        String name = getPackagePart().getPartName().getName();
        return name.substring(name.lastIndexOf(47) + 1);
    }

    public int getPictureType() {
        String contentType = getPackagePart().getContentType();
        int i5 = 0;
        while (true) {
            POIXMLRelation[] pOIXMLRelationArr = RELATIONS;
            if (i5 >= pOIXMLRelationArr.length) {
                return 0;
            }
            POIXMLRelation pOIXMLRelation = pOIXMLRelationArr[i5];
            if (pOIXMLRelation != null && pOIXMLRelation.getContentType().equals(contentType)) {
                return i5;
            }
            i5++;
        }
    }

    public PictureType getPictureTypeEnum() {
        return PictureType.findByOoxmlId(getPictureType());
    }

    public int hashCode() {
        Long checksum = getChecksum();
        return checksum == null ? super.hashCode() : checksum.hashCode();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
    }

    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    public XWPFPictureData(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
