package org.apache.poi.common.usermodel;

import java.util.HashMap;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PictureType {
    EMF("image/x-emf", ".emf", 2),
    WMF("image/x-wmf", ".wmf", 3),
    PICT(ContentTypes.IMAGE_PICT, ".pict", 4),
    JPEG(ContentTypes.IMAGE_JPEG, ".jpg", 5),
    PNG(ContentTypes.IMAGE_PNG, ".png", 6),
    DIB("image/dib", ".dib", 7),
    GIF(ContentTypes.IMAGE_GIF, ".gif", 8),
    TIFF(ContentTypes.IMAGE_TIFF, ".tif", 9),
    EPS("image/x-eps", ".eps", 10),
    BMP("image/x-ms-bmp", ".bmp", 11),
    WPG("image/x-wpg", ".wpg", 12),
    WDP("image/vnd.ms-photo", ".wdp", 13),
    SVG("image/svg+xml", ".svg", -1),
    UNKNOWN("", ".dat", -1),
    ERROR("", ".dat", -1),
    CMYKJPEG(ContentTypes.IMAGE_JPEG, ".jpg", -1),
    CLIENT("", ".dat", -1);

    private static final HashMap<Integer, PictureType> PICTURE_TYPE_BY_OOXML_ID = new HashMap<>();
    public final String contentType;
    public final String extension;
    public final int ooxmlId;

    /* JADX INFO: renamed from: org.apache.poi.common.usermodel.PictureType$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.BMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.PNG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.WMF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.EMF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.TIFF.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.UNKNOWN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static {
        for (PictureType pictureType : values()) {
            int i5 = pictureType.ooxmlId;
            if (i5 >= -1) {
                PICTURE_TYPE_BY_OOXML_ID.put(Integer.valueOf(i5), pictureType);
            }
        }
    }

    PictureType(String str, String str2, int i5) {
        this.contentType = str;
        this.extension = str2;
        this.ooxmlId = i5;
    }

    public static PictureType findByOoxmlId(int i5) {
        return PICTURE_TYPE_BY_OOXML_ID.get(Integer.valueOf(i5));
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getExtension() {
        return this.extension;
    }

    public int getOoxmlId() {
        return this.ooxmlId;
    }

    public static PictureType valueOf(FileMagic fileMagic) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[fileMagic.ordinal()]) {
            case 1:
                return BMP;
            case 2:
                return GIF;
            case 3:
                return JPEG;
            case 4:
                return PNG;
            case 5:
                return SVG;
            case 6:
                return WMF;
            case 7:
                return EMF;
            case 8:
                return TIFF;
            default:
                return UNKNOWN;
        }
    }
}
