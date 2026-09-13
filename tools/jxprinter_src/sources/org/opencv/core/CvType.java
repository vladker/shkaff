package org.opencv.core;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class CvType {
    public static final int CV_16F = 7;
    public static final int CV_16S = 3;
    public static final int CV_16U = 2;
    public static final int CV_32F = 5;
    public static final int CV_32S = 4;
    public static final int CV_64F = 6;
    public static final int CV_8S = 1;
    public static final int CV_8U = 0;
    private static final int CV_CN_MAX = 512;
    private static final int CV_CN_SHIFT = 3;
    private static final int CV_DEPTH_MAX = 8;

    @Deprecated
    public static final int CV_USRTYPE1 = 7;
    public static final int CV_8UC1 = CV_8UC(1);
    public static final int CV_8UC2 = CV_8UC(2);
    public static final int CV_8UC3 = CV_8UC(3);
    public static final int CV_8UC4 = CV_8UC(4);
    public static final int CV_8SC1 = CV_8SC(1);
    public static final int CV_8SC2 = CV_8SC(2);
    public static final int CV_8SC3 = CV_8SC(3);
    public static final int CV_8SC4 = CV_8SC(4);
    public static final int CV_16UC1 = CV_16UC(1);
    public static final int CV_16UC2 = CV_16UC(2);
    public static final int CV_16UC3 = CV_16UC(3);
    public static final int CV_16UC4 = CV_16UC(4);
    public static final int CV_16SC1 = CV_16SC(1);
    public static final int CV_16SC2 = CV_16SC(2);
    public static final int CV_16SC3 = CV_16SC(3);
    public static final int CV_16SC4 = CV_16SC(4);
    public static final int CV_32SC1 = CV_32SC(1);
    public static final int CV_32SC2 = CV_32SC(2);
    public static final int CV_32SC3 = CV_32SC(3);
    public static final int CV_32SC4 = CV_32SC(4);
    public static final int CV_32FC1 = CV_32FC(1);
    public static final int CV_32FC2 = CV_32FC(2);
    public static final int CV_32FC3 = CV_32FC(3);
    public static final int CV_32FC4 = CV_32FC(4);
    public static final int CV_64FC1 = CV_64FC(1);
    public static final int CV_64FC2 = CV_64FC(2);
    public static final int CV_64FC3 = CV_64FC(3);
    public static final int CV_64FC4 = CV_64FC(4);
    public static final int CV_16FC1 = CV_16FC(1);
    public static final int CV_16FC2 = CV_16FC(2);
    public static final int CV_16FC3 = CV_16FC(3);
    public static final int CV_16FC4 = CV_16FC(4);

    public static final int CV_16FC(int i5) {
        return makeType(7, i5);
    }

    public static final int CV_16SC(int i5) {
        return makeType(3, i5);
    }

    public static final int CV_16UC(int i5) {
        return makeType(2, i5);
    }

    public static final int CV_32FC(int i5) {
        return makeType(5, i5);
    }

    public static final int CV_32SC(int i5) {
        return makeType(4, i5);
    }

    public static final int CV_64FC(int i5) {
        return makeType(6, i5);
    }

    public static final int CV_8SC(int i5) {
        return makeType(1, i5);
    }

    public static final int CV_8UC(int i5) {
        return makeType(0, i5);
    }

    public static final int ELEM_SIZE(int i5) {
        switch (depth(i5)) {
            case 0:
            case 1:
                return channels(i5);
            case 2:
            case 3:
            case 7:
                return channels(i5) * 2;
            case 4:
            case 5:
                return channels(i5) * 4;
            case 6:
                return channels(i5) * 8;
            default:
                throw new UnsupportedOperationException(AbstractC0157z.k(i5, "Unsupported CvType value: "));
        }
    }

    public static final int channels(int i5) {
        return (i5 >> 3) + 1;
    }

    public static final int depth(int i5) {
        return i5 & 7;
    }

    public static final boolean isInteger(int i5) {
        return depth(i5) < 5;
    }

    public static final int makeType(int i5, int i6) {
        if (i6 <= 0 || i6 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        }
        if (i5 < 0 || i5 >= 8) {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
        return (i5 & 7) + ((i6 - 1) << 3);
    }

    public static final String typeToString(int i5) {
        String str;
        switch (depth(i5)) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_16F";
                break;
            default:
                throw new UnsupportedOperationException(AbstractC0157z.k(i5, "Unsupported CvType value: "));
        }
        int iChannels = channels(i5);
        if (iChannels <= 4) {
            return str + "C" + iChannels;
        }
        return str + "C(" + iChannels + ")";
    }
}
