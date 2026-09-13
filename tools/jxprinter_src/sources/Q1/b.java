package Q1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.google.mlkit.vision.common.InputImage;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static InputImage a(Map map, Context context, MethodChannel.Result result) {
        String str = (String) map.get("type");
        if (str == null || !str.equals("bitmap")) {
            if (str != null && str.equals(Constants.FILE)) {
                try {
                    return InputImage.fromFilePath(context, Uri.fromFile(new File((String) map.get("path"))));
                } catch (IOException e) {
                    Log.e("ImageError", "Getting Image failed");
                    Log.e("ImageError", e.toString());
                    result.error("InputImageConverterError", e.toString(), e);
                    return null;
                }
            }
            if (str == null || !str.equals("bytes")) {
                result.error("InputImageConverterError", "Invalid Input Image", null);
                return null;
            }
            try {
                Map map2 = (Map) map.get("metadata");
                Object obj = map.get("bytes");
                Objects.requireNonNull(obj);
                byte[] bArr = (byte[]) obj;
                Object obj2 = map2.get("image_format");
                Objects.requireNonNull(obj2);
                int i5 = Integer.parseInt(obj2.toString());
                Object obj3 = map2.get("rotation");
                Objects.requireNonNull(obj3);
                int i6 = Integer.parseInt(obj3.toString());
                Object obj4 = map2.get("width");
                Objects.requireNonNull(obj4);
                int iIntValue = Double.valueOf(obj4.toString()).intValue();
                Object obj5 = map2.get("height");
                Objects.requireNonNull(obj5);
                int iIntValue2 = Double.valueOf(obj5.toString()).intValue();
                if (i5 != 17 && i5 != 842094169) {
                    result.error("InputImageConverterError", "ImageFormat is not supported.", null);
                    return null;
                }
                return InputImage.fromByteArray(bArr, iIntValue, iIntValue2, i6, i5);
            } catch (Exception e6) {
                Log.e("ImageError", "Getting Image failed");
                Log.e("ImageError", e6.toString());
                result.error("InputImageConverterError", e6.toString(), e6);
                return null;
            }
        }
        try {
            byte[] bArr2 = (byte[]) map.get("bitmapData");
            if (bArr2 == null) {
                result.error("InputImageConverterError", "Bitmap data is null", null);
                return null;
            }
            Object obj6 = map.get("rotation");
            int iIntValue3 = obj6 != null ? ((Integer) obj6).intValue() : 0;
            try {
                Map map3 = (Map) map.get("metadata");
                if (map3 == null) {
                    try {
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                        if (bitmapDecodeByteArray != null) {
                            return InputImage.fromBitmap(bitmapDecodeByteArray, iIntValue3);
                        }
                        result.error("InputImageConverterError", "Failed to decode bitmap from the provided data", null);
                        return null;
                    } catch (Exception e7) {
                        Log.e("ImageError", "Getting Bitmap failed", e7);
                        result.error("InputImageConverterError", e7.toString(), e7);
                        return null;
                    }
                }
                Object obj7 = map3.get("width");
                Objects.requireNonNull(obj7);
                int iIntValue4 = Double.valueOf(obj7.toString()).intValue();
                Object obj8 = map3.get("height");
                Objects.requireNonNull(obj8);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iIntValue4, Double.valueOf(obj8.toString()).intValue(), Bitmap.Config.ARGB_8888);
                IntBuffer intBufferAllocate = IntBuffer.allocate(bArr2.length / 4);
                for (int i7 = 0; i7 < bArr2.length; i7 += 4) {
                    intBufferAllocate.put(((bArr2[i7] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr2[i7 + 3] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr2[i7 + 1] & UnsignedBytes.MAX_VALUE) << 8) | (bArr2[i7 + 2] & UnsignedBytes.MAX_VALUE));
                }
                intBufferAllocate.rewind();
                bitmapCreateBitmap.copyPixelsFromBuffer(intBufferAllocate);
                return InputImage.fromBitmap(bitmapCreateBitmap, iIntValue3);
            } catch (Exception e8) {
                Log.e("ImageError", "Error creating bitmap from raw data", e8);
            }
            Log.e("ImageError", "Getting Bitmap failed");
            Log.e("ImageError", e.toString());
            result.error("InputImageConverterError", e.toString(), e);
            return null;
        } catch (Exception e9) {
            Log.e("ImageError", "Getting Bitmap failed");
            Log.e("ImageError", e9.toString());
            result.error("InputImageConverterError", e9.toString(), e9);
            return null;
        }
    }
}
