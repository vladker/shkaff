package com.bumptech.glide;

import A3.I;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.library.base.frame.FrameActivity;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p108t.C1773e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements k {
    public static final List a(Throwable th) {
        if (th instanceof C1773e) {
            C1773e c1773e = (C1773e) th;
            return I.listOf(c1773e.getCode(), c1773e.getMessage(), c1773e.getDetails());
        }
        return I.listOf((Object[]) new String[]{th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th)});
    }

    public static double[][] b(double[][] dArr, int i5) {
        if (i5 != dArr.length) {
            return dArr;
        }
        double[][] dArr2 = new double[i5 * 2][];
        for (int i6 = 0; i6 < i5; i6++) {
            dArr2[i6] = dArr[i6];
        }
        return dArr2;
    }

    public static Bitmap c(int i5, int i6, String str) {
        File file = new File(str);
        Bitmap bitmapDecodeFileDescriptor = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileDescriptor fd = fileInputStream.getFD();
            BitmapFactory.Options options = new BitmapFactory.Options();
            int iRound = 1;
            options.inSampleSize = 1;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            BitmapFactory.decodeFileDescriptor(fd, null, options);
            int i7 = options.outHeight;
            int i8 = options.outWidth;
            if (i7 > i6 || i8 > i5) {
                iRound = Math.round(i7 / i6);
                int iRound2 = Math.round(i8 / i5);
                if (iRound >= iRound2) {
                    iRound = iRound2;
                }
                while ((i8 * i7) / (iRound * iRound) > i5 * i6 * 2) {
                    iRound++;
                }
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = iRound;
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fd, null, options);
            fileInputStream.close();
            return bitmapDecodeFileDescriptor;
        } catch (FileNotFoundException unused) {
            Log.e("FileNotFound", str + "not found");
            return bitmapDecodeFileDescriptor;
        } catch (IOException unused2) {
            Log.e("IOException", str + "read error");
            return bitmapDecodeFileDescriptor;
        }
    }

    public static String d(Context context, Uri uri) {
        try {
            DigestInputStream digestInputStream = new DigestInputStream(context.getContentResolver().openInputStream(uri), MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
            while (digestInputStream.read(new byte[8192]) != -1) {
            }
            byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toString((b & UnsignedBytes.MAX_VALUE) + 256, 16).substring(1));
            }
            digestInputStream.close();
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String e(String str) {
        try {
            DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream(new File(str)), MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
            while (digestInputStream.read(new byte[8192]) != -1) {
            }
            byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toString((b & UnsignedBytes.MAX_VALUE) + 256, 16).substring(1));
            }
            digestInputStream.close();
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap f(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static String g(FrameActivity frameActivity, Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        StringBuilder sb = new StringBuilder();
        sb.append(frameActivity.getExternalCacheDir());
        sb.append(PackagingURIHelper.FORWARD_SLASH_STRING);
        sb.append(str);
        sb.append(".png");
        String string = sb.toString();
        ?? r6 = 0;
        try {
            try {
                fileOutputStream = new FileOutputStream(string);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    try {
                        fileOutputStream.close();
                        return string;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return string;
                    }
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable unused) {
                r6 = sb;
                try {
                    r6.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
                return string;
            }
        } catch (IOException e9) {
            e = e9;
            fileOutputStream = null;
        } catch (Throwable unused2) {
            r6.close();
            return string;
        }
    }
}
