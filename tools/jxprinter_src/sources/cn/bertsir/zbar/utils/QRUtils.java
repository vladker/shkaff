package cn.bertsir.zbar.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import cn.bertsir.zbar.Qr.Image;
import cn.bertsir.zbar.Qr.ImageScanner;
import cn.bertsir.zbar.Qr.Symbol;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class QRUtils {
    private static QRUtils instance;
    private Context mContext;
    private Bitmap scanBitmap;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TextViewConfig {
        private float size;
        private int gravity = 17;
        private int maxLines = 1;
        private int color = ViewCompat.MEASURED_STATE_MASK;

        public void setColor(int i5) {
            this.color = i5;
        }

        public void setGravity(int i5) {
            this.gravity = i5;
        }

        public void setMaxLines(int i5) {
            this.maxLines = i5;
        }

        public void setSize(float f6) {
            this.size = f6;
        }
    }

    private Bitmap compressImage(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        this.scanBitmap = BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int iMax = Math.max((int) (options.outHeight / 800.0f), (int) (options.outWidth / 800.0f));
        options.inSampleSize = iMax > 0 ? iMax : 1;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(str, options);
    }

    private Bitmap createCodeBitmap(String str, int i5, int i6, Context context, TextViewConfig textViewConfig) {
        if (textViewConfig == null) {
            textViewConfig = new TextViewConfig();
        }
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setText(str);
        textView.setTextSize(textViewConfig.size == 0.0f ? textView.getTextSize() : textViewConfig.size);
        textView.setHeight(i6);
        textView.setGravity(textViewConfig.gravity);
        textView.setMaxLines(textViewConfig.maxLines);
        textView.setWidth(i5);
        textView.setDrawingCacheEnabled(true);
        textView.setTextColor(textViewConfig.color);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        textView.buildDrawingCache();
        return textView.getDrawingCache();
    }

    private Bitmap createWaterMaskBitmap(Bitmap bitmap, Bitmap bitmap2, int i5, int i6) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, i5, i6, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    private Bitmap createWaterMaskCenter(Bitmap bitmap, Bitmap bitmap2) {
        return createWaterMaskBitmap(bitmap, bitmap2, (bitmap.getWidth() - bitmap2.getWidth()) / 2, (bitmap.getHeight() - bitmap2.getHeight()) / 2);
    }

    private Bitmap encodeAsBitmap(String str, BarcodeFormat barcodeFormat, int i5, int i6) {
        BitMatrix bitMatrixEncode;
        try {
            bitMatrixEncode = new MultiFormatWriter().encode(str, barcodeFormat, i5, i6, null);
        } catch (WriterException e) {
            e.printStackTrace();
            bitMatrixEncode = null;
        }
        int width = bitMatrixEncode.getWidth();
        int height = bitMatrixEncode.getHeight();
        int[] iArr = new int[width * height];
        for (int i7 = 0; i7 < height; i7++) {
            int i8 = i7 * width;
            for (int i9 = 0; i9 < width; i9++) {
                iArr[i8 + i9] = bitMatrixEncode.get(i9, i7) ? ViewCompat.MEASURED_STATE_MASK : 16777215;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    public static QRUtils getInstance() {
        if (instance == null) {
            instance = new QRUtils();
        }
        return instance;
    }

    private Bitmap mixtureBitmap(Bitmap bitmap, Bitmap bitmap2, PointF pointF) {
        if (bitmap == null || bitmap2 == null || pointF == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(bitmap.getWidth(), bitmap2.getWidth()), bitmap2.getHeight() + bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, pointF.x, pointF.y, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    private Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    private Bitmap zoomImg(Bitmap bitmap, float f6) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f6, f6);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public Bitmap createBarCodeWithText(Context context, String str, int i5, int i6) {
        return createBarCodeWithText(context, str, i5, i6, null);
    }

    @Deprecated
    public Bitmap createBarcode(Context context, String str, int i5, int i6) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("contents not be null");
        }
        if (i5 == 0 || i6 == 0) {
            throw new NullPointerException("desiredWidth or desiredHeight not be null");
        }
        return encodeAsBitmap(str, BarcodeFormat.CODE_128, i5, i6);
    }

    public Bitmap createQRCode(String str) {
        return createQRCode(str, 300, 300);
    }

    public Bitmap createQRCodeAddLogo(String str, Bitmap bitmap) {
        Bitmap bitmapCreateQRCode = createQRCode(str);
        bitmapCreateQRCode.getHeight();
        return createWaterMaskCenter(bitmapCreateQRCode, zoomImg(bitmap, ((int) (((double) bitmapCreateQRCode.getWidth()) * 0.3d)) / bitmap.getWidth()));
    }

    public String decodeBarcode(String str) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        return bitmapDecodeFile != null ? decodeBarcode(bitmapDecodeFile) : "";
    }

    public String decodeQRcode(String str) {
        Bitmap grayscale = toGrayscale(compressImage(str));
        return grayscale != null ? decodeQRcode(grayscale) : "";
    }

    public String decodeQRcodeByZxing(String str) {
        Result resultDecode = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        Bitmap bitmapCompressImage = compressImage(str);
        int[] iArr = new int[bitmapCompressImage.getHeight() * bitmapCompressImage.getWidth()];
        bitmapCompressImage.getPixels(iArr, 0, bitmapCompressImage.getWidth(), 0, 0, bitmapCompressImage.getWidth(), bitmapCompressImage.getHeight());
        try {
            resultDecode = new QRCodeReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(new RGBLuminanceSource(bitmapCompressImage.getWidth(), bitmapCompressImage.getHeight(), iArr))), hashtable);
        } catch (ChecksumException | FormatException | NotFoundException unused) {
        }
        return resultDecode == null ? "" : resultDecode.getText();
    }

    public boolean deleteTempFile(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.delete();
    }

    public float getFingerSpacing(MotionEvent motionEvent) {
        float x6 = motionEvent.getX(0) - motionEvent.getX(1);
        float y6 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y6 * y6) + (x6 * x6));
    }

    public int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public void getVibrator(Context context) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(new long[]{0, 50, 0, 0}, -1);
    }

    public boolean isMIUI() {
        return "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public boolean isScreenOriatationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public Bitmap createBarCodeWithText(Context context, String str, int i5, int i6, TextViewConfig textViewConfig) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("contents not be null");
        }
        if (i5 == 0 || i6 == 0) {
            throw new NullPointerException("desiredWidth or desiredHeight not be null");
        }
        Bitmap bitmapEncodeAsBitmap = encodeAsBitmap(str, BarcodeFormat.CODE_128, i5, i6);
        return mixtureBitmap(bitmapEncodeAsBitmap, createCodeBitmap(str, bitmapEncodeAsBitmap.getWidth(), bitmapEncodeAsBitmap.getHeight(), context, textViewConfig), new PointF(0.0f, i6));
    }

    public Bitmap createQRCode(String str, int i5, int i6) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Bitmap bitmap = null;
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 1);
            BitMatrix bitMatrixEncode = multiFormatWriter.encode(new String(str.getBytes("UTF-8"), "ISO-8859-1"), BarcodeFormat.QR_CODE, i5, i6, hashtable);
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i7 = 0; i7 < height; i7++) {
                int i8 = i7 * width;
                for (int i9 = 0; i9 < width; i9++) {
                    iArr[i8 + i9] = bitMatrixEncode.get(i9, i7) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return bitmapCreateBitmap;
            } catch (Exception e) {
                e = e;
                bitmap = bitmapCreateBitmap;
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public String decodeBarcode(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        if (bitmap != null) {
            return decodeBarcode(bitmap);
        }
        return "";
    }

    public String decodeQRcode(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        if (bitmap != null) {
            return decodeQRcode(bitmap);
        }
        return "";
    }

    public Bitmap createQRCodeAddLogo(String str, int i5, int i6, Bitmap bitmap) {
        Bitmap bitmapCreateQRCode = createQRCode(str, i5, i6);
        bitmapCreateQRCode.getHeight();
        return createWaterMaskCenter(bitmapCreateQRCode, zoomImg(bitmap, ((int) (((double) bitmapCreateQRCode.getWidth()) * 0.3d)) / bitmap.getWidth()));
    }

    public String decodeBarcode(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Image image = new Image(width, height, "RGB4");
        image.setData(iArr);
        ImageScanner imageScanner = new ImageScanner();
        imageScanner.setConfig(0, 0, 0);
        imageScanner.setConfig(128, 0, 1);
        imageScanner.setConfig(39, 0, 1);
        imageScanner.setConfig(13, 0, 1);
        imageScanner.setConfig(8, 0, 1);
        imageScanner.setConfig(12, 0, 1);
        imageScanner.setConfig(9, 0, 1);
        String data = null;
        if (imageScanner.scanImage(image.convert("Y800")) != 0) {
            Iterator<Symbol> it = imageScanner.getResults().iterator();
            while (it.hasNext()) {
                data = it.next().getData();
            }
        }
        return data;
    }

    public String decodeQRcode(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Image image = new Image(width, height, "RGB4");
        image.setData(iArr);
        ImageScanner imageScanner = new ImageScanner();
        imageScanner.setConfig(0, 0, 0);
        imageScanner.setConfig(64, 0, 1);
        String data = null;
        if (imageScanner.scanImage(image.convert("Y800")) != 0) {
            Iterator<Symbol> it = imageScanner.getResults().iterator();
            while (it.hasNext()) {
                data = it.next().getData();
            }
        }
        bitmap.recycle();
        return data;
    }

    public String decodeQRcodeByZxing(Bitmap bitmap) {
        Result resultDecode;
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        this.scanBitmap = bitmap;
        int[] iArr = new int[this.scanBitmap.getHeight() * bitmap.getWidth()];
        Bitmap bitmap2 = this.scanBitmap;
        bitmap2.getPixels(iArr, 0, bitmap2.getWidth(), 0, 0, this.scanBitmap.getWidth(), this.scanBitmap.getHeight());
        try {
            resultDecode = new QRCodeReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(new RGBLuminanceSource(this.scanBitmap.getWidth(), this.scanBitmap.getHeight(), iArr))), hashtable);
        } catch (ChecksumException | FormatException | NotFoundException unused) {
            resultDecode = null;
        }
        if (resultDecode == null) {
            return "";
        }
        return resultDecode.getText();
    }
}
