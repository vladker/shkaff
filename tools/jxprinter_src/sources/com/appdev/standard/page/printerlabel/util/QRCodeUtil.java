package com.appdev.standard.page.printerlabel.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Hashtable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class QRCodeUtil {
    @Nullable
    public static Bitmap createQRCodeBitmap(String str, int i5, int i6) {
        return createQRCodeBitmap("QR_CODE", str, i5, i6, "UTF-8", "H", ExifInterface.GPS_MEASUREMENT_2D, ViewCompat.MEASURED_STATE_MASK, 0);
    }

    private static BitMatrix deleteWhite(BitMatrix bitMatrix) {
        int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
        int i5 = enclosingRectangle[2];
        int i6 = enclosingRectangle[3];
        if (i5 >= bitMatrix.getWidth() || i6 >= bitMatrix.getHeight()) {
            return bitMatrix;
        }
        BitMatrix bitMatrix2 = new BitMatrix(i5, i6);
        bitMatrix2.clear();
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                if (bitMatrix.get(enclosingRectangle[0] + i7, enclosingRectangle[1] + i8)) {
                    bitMatrix2.set(i7, i8);
                }
            }
        }
        return bitMatrix2;
    }

    @Nullable
    public static Bitmap createQRCodeBitmap(String str, String str2, int i5, int i6, @Nullable String str3, @Nullable String str4) {
        return createQRCodeBitmap(str, str2, i5, i6, "UTF-8", str3, str4, ViewCompat.MEASURED_STATE_MASK, 0);
    }

    @Nullable
    public static Bitmap createQRCodeBitmap(String str, String str2, int i5, int i6, @Nullable String str3) {
        return createQRCodeBitmap(str, str2, i5, i6, "UTF-8", str3, "0", ViewCompat.MEASURED_STATE_MASK, 0);
    }

    @Nullable
    public static Bitmap createQRCodeBitmap(String str, String str2, int i5, int i6, @Nullable String str3, @Nullable String str4, @Nullable String str5, @ColorInt int i7, @ColorInt int i8) {
        BitMatrix bitMatrixEncode;
        int width;
        int height;
        int i9 = i5;
        int i10 = i6;
        if (!TextUtils.isEmpty(str2) && i9 >= 0 && i10 >= 0) {
            try {
                Hashtable hashtable = new Hashtable();
                if (!TextUtils.isEmpty(str3)) {
                    hashtable.put(EncodeHintType.CHARACTER_SET, str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashtable.put(EncodeHintType.ERROR_CORRECTION, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashtable.put(EncodeHintType.MARGIN, str5);
                }
                if (str.equals("DATA_MATRIX")) {
                    bitMatrixEncode = new DataMatrixWriter().encode(str2, BarcodeFormat.DATA_MATRIX, i9 > i10 ? i10 : i9, i9 > i10 ? i10 : i9, hashtable);
                } else if (str.equals("PDF_417")) {
                    bitMatrixEncode = new PDF417Writer().encode(str2, BarcodeFormat.PDF_417, i9, i5, hashtable);
                    i9 = i5;
                } else {
                    i9 = i5;
                    bitMatrixEncode = new QRCodeWriter().encode(str2, BarcodeFormat.QR_CODE, i9, i10, hashtable);
                    i10 = i10;
                }
                if (TextUtils.isEmpty(str5) || !"0".equals(str5)) {
                    width = 0;
                    height = 0;
                } else {
                    bitMatrixEncode = deleteWhite(bitMatrixEncode);
                    width = bitMatrixEncode.getWidth();
                    height = bitMatrixEncode.getHeight();
                }
                if (str.equals("DATA_MATRIX")) {
                    int i11 = (i9 > i10 ? i10 : i9) / width;
                    int[] iArr = new int[(i9 > i10 ? i10 : i9) * (i9 > i10 ? i10 : i9)];
                    for (int i12 = 0; i12 < height; i12++) {
                        int i13 = (i9 > i10 ? i10 : i9) * i12 * i11;
                        int i14 = 0;
                        while (i14 < i11) {
                            for (int i15 = 0; i15 < width; i15++) {
                                int i16 = bitMatrixEncode.get(i15, i12) ? i7 : i8;
                                for (int i17 = 0; i17 < i11; i17++) {
                                    iArr[(i15 * i11) + i13 + i17] = i16;
                                }
                            }
                            i14++;
                            i13 += i9 > i10 ? i10 : i9;
                        }
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i9 > i10 ? i10 : i9, i9 > i10 ? i10 : i9, Bitmap.Config.ARGB_8888);
                    int i18 = i9 > i10 ? i10 : i9;
                    int i19 = i9 > i10 ? i10 : i9;
                    if (i9 <= i10) {
                        i10 = i9;
                    }
                    bitmapCreateBitmap.setPixels(iArr, 0, i18, 0, 0, i19, i10);
                    return bitmapCreateBitmap;
                }
                if (str.equals("PDF_417")) {
                    System.out.println("width:  " + i9 + "    height:  " + i10);
                    System.out.println("bitMatrix:  " + bitMatrixEncode.getWidth() + "    height:  " + bitMatrixEncode.getHeight());
                    int[] iArr2 = new int[width * height];
                    for (int i20 = 0; i20 < height; i20++) {
                        for (int i21 = 0; i21 < width; i21++) {
                            iArr2[(i20 * width) + i21] = bitMatrixEncode.get(i21, i20) ? i7 : i8;
                        }
                    }
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    bitmapCreateBitmap2.setPixels(iArr2, 0, width, 0, 0, width, height);
                    return bitmapCreateBitmap2;
                }
                int[] iArr3 = new int[width * height];
                for (int i22 = 0; i22 < height; i22++) {
                    for (int i23 = 0; i23 < width; i23++) {
                        if (bitMatrixEncode.get(i23, i22)) {
                            iArr3[(i22 * width) + i23] = i7;
                        } else {
                            iArr3[(i22 * width) + i23] = i8;
                        }
                    }
                }
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap3.setPixels(iArr3, 0, width, 0, 0, width, height);
                return bitmapCreateBitmap3;
            } catch (Exception e) {
                p051j0.a.e("QRCodeUtil", "createQRCodeBitmap error ", e);
            }
        }
        return null;
    }
}
