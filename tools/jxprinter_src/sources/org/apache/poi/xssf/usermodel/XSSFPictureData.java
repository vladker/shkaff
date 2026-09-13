package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFPictureData extends POIXMLDocumentPart implements PictureData {
    private static final int DEFAULT_MAX_IMAGE_SIZE = 100000000;
    private static int MAX_IMAGE_SIZE = 100000000;
    protected static final POIXMLRelation[] RELATIONS;

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[13];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[2] = XSSFRelation.IMAGE_EMF;
        pOIXMLRelationArr[3] = XSSFRelation.IMAGE_WMF;
        pOIXMLRelationArr[4] = XSSFRelation.IMAGE_PICT;
        pOIXMLRelationArr[5] = XSSFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[6] = XSSFRelation.IMAGE_PNG;
        pOIXMLRelationArr[7] = XSSFRelation.IMAGE_DIB;
        pOIXMLRelationArr[8] = XSSFRelation.IMAGE_GIF;
        pOIXMLRelationArr[9] = XSSFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[10] = XSSFRelation.IMAGE_EPS;
        pOIXMLRelationArr[11] = XSSFRelation.IMAGE_BMP;
        pOIXMLRelationArr[12] = XSSFRelation.IMAGE_WPG;
    }

    public XSSFPictureData() {
    }

    public static int getMaxImageSize() {
        return MAX_IMAGE_SIZE;
    }

    public static void setMaxImageSize(int i5) {
        MAX_IMAGE_SIZE = i5;
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
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

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String getMimeType() {
        return getPackagePart().getContentType();
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
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

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    public XSSFPictureData(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
