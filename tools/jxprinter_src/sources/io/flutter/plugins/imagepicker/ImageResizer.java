package io.flutter.plugins.imagepicker;

import A3.AbstractC0157z;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.SizeFCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    public ImageResizer(@NonNull Context context, @NonNull ExifDataCopier exifDataCopier) {
        this.context = context;
        this.exifDataCopier = exifDataCopier;
    }

    private int calculateSampleSize(BitmapFactory.Options options, int i5, int i6) {
        int i7 = options.outHeight;
        int i8 = options.outWidth;
        int i9 = 1;
        if (i7 <= i6 && i8 <= i5) {
            return 1;
        }
        int i10 = i7 / 2;
        int i11 = i8 / 2;
        while (i10 / i9 >= i6 && i11 / i9 >= i5) {
            i9 *= 2;
        }
        return i9;
    }

    private SizeFCompat calculateTargetSize(double d, double d6, @Nullable Double d7, @Nullable Double d8) {
        double d9 = d / d6;
        boolean z6 = false;
        boolean z7 = d7 != null;
        boolean z8 = d8 != null;
        double dMin = z7 ? Math.min(d, Math.round(d7.doubleValue())) : d;
        double dMin2 = z8 ? Math.min(d6, Math.round(d8.doubleValue())) : d6;
        boolean z9 = z7 && d7.doubleValue() < d;
        if (z8 && d8.doubleValue() < d6) {
            z6 = true;
        }
        if (z9 || z6) {
            double d10 = dMin2 * d9;
            double d11 = dMin / d9;
            if (d11 > dMin2) {
                dMin = Math.round(d10);
            } else {
                dMin2 = Math.round(d11);
            }
        }
        return new SizeFCompat((float) dMin, (float) dMin2);
    }

    private void copyExif(String str, String str2) throws Throwable {
        try {
            this.exifDataCopier.copyExif(new ExifInterface(str), new ExifInterface(str2));
        } catch (Exception e) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e);
        }
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i5) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean zHasAlpha = bitmap.hasAlpha();
        if (zHasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(zHasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
        File fileCreateFile = createFile(this.context.getCacheDir(), str);
        FileOutputStream fileOutputStreamCreateOutputStream = createOutputStream(fileCreateFile);
        fileOutputStreamCreateOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStreamCreateOutputStream.close();
        return fileCreateFile;
    }

    private FileOutputStream createOutputStream(File file) {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i5, int i6, boolean z6) {
        return Bitmap.createScaledBitmap(bitmap, i5, i6, z6);
    }

    private Bitmap decodeFile(String str, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private File resizedImage(Bitmap bitmap, Double d, Double d6, int i5, String str) {
        return createImageOnExternalDirectory(AbstractC0157z.n("/scaled_", str), createScaledBitmap(bitmap, d.intValue(), d6.intValue(), false), i5);
    }

    @VisibleForTesting
    public SizeFCompat readFileDimensions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        return new SizeFCompat(options.outWidth, options.outHeight);
    }

    public String resizeImageIfNeeded(String str, @Nullable Double d, @Nullable Double d6, int i5) throws Throwable {
        SizeFCompat fileDimensions = readFileDimensions(str);
        if (fileDimensions.getWidth() == -1.0f || fileDimensions.getHeight() == -1.0f) {
            return str;
        }
        if (d == null && d6 == null && i5 >= 100) {
            return str;
        }
        try {
            String[] strArrSplit = str.split(PackagingURIHelper.FORWARD_SLASH_STRING);
            String str2 = strArrSplit[strArrSplit.length - 1];
            SizeFCompat sizeFCompatCalculateTargetSize = calculateTargetSize(fileDimensions.getWidth(), fileDimensions.getHeight(), d, d6);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = calculateSampleSize(options, (int) sizeFCompatCalculateTargetSize.getWidth(), (int) sizeFCompatCalculateTargetSize.getHeight());
            Bitmap bitmapDecodeFile = decodeFile(str, options);
            if (bitmapDecodeFile == null) {
                return str;
            }
            File fileResizedImage = resizedImage(bitmapDecodeFile, Double.valueOf(sizeFCompatCalculateTargetSize.getWidth()), Double.valueOf(sizeFCompatCalculateTargetSize.getHeight()), i5, str2);
            copyExif(str, fileResizedImage.getPath());
            return fileResizedImage.getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
