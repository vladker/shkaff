package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.bertsir.zbar.Qr.Image;
import cn.bertsir.zbar.Qr.ImageScanner;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.utils.QRUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.datamatrix.detector.Detector;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class CameraScanAnalysis implements Camera.PreviewCallback {
    private static final String TAG = "CameraScanAnalysis";
    private Image barcode;
    private Camera camera;
    private Context context;
    private int cropHeight;
    private int cropWidth;
    private byte[] data;
    private ScanCallback mCallback;
    private Handler mHandler;
    private ImageScanner mImageScanner;
    private Camera.Size size;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private boolean allowAnalysis = true;
    private long lastResultTime = 0;
    private MultiFormatReader multiFormatReader = new MultiFormatReader();
    private Runnable mAnalysisTask = new Runnable() { // from class: cn.bertsir.zbar.CameraScanAnalysis.2
        @Override // java.lang.Runnable
        public void run() {
            if (Symbol.is_auto_zoom && Symbol.scanType == 1 && QRUtils.getInstance().isScreenOriatationPortrait(CameraScanAnalysis.this.context)) {
                if (Symbol.is_only_scan_center && (Symbol.cropX == 0 || Symbol.cropY == 0 || CameraScanAnalysis.this.cropWidth == 0 || CameraScanAnalysis.this.cropHeight == 0)) {
                    return;
                }
                try {
                    ResultPoint[] points = new Detector(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(CameraScanAnalysis.this.data, CameraScanAnalysis.this.size.width, CameraScanAnalysis.this.size.height, Symbol.cropX, Symbol.cropY, CameraScanAnalysis.this.cropWidth, CameraScanAnalysis.this.cropHeight, true))).getBlackMatrix()).detect().getPoints();
                    float x6 = points[0].getX();
                    float y6 = points[0].getY();
                    float x7 = x6 - points[1].getX();
                    float y7 = y6 - points[1].getY();
                    int iSqrt = (int) Math.sqrt((Math.abs(y7) * Math.abs(y7)) + (Math.abs(x7) * Math.abs(x7)));
                    if (iSqrt < CameraScanAnalysis.this.cropWidth / 4 && iSqrt > 10) {
                        CameraScanAnalysis cameraScanAnalysis = CameraScanAnalysis.this;
                        cameraScanAnalysis.cameraZoom(cameraScanAnalysis.camera);
                    }
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }
            String str = null;
            int type = -1;
            if (CameraScanAnalysis.this.mImageScanner.scanImage(CameraScanAnalysis.this.barcode) != 0) {
                for (Symbol symbol : CameraScanAnalysis.this.mImageScanner.getResults()) {
                    String data = symbol.getData();
                    type = symbol.getType();
                    str = data;
                }
            }
            if (TextUtils.isEmpty(str)) {
                if (!Symbol.doubleEngine) {
                    CameraScanAnalysis.this.allowAnalysis = true;
                    return;
                } else {
                    CameraScanAnalysis cameraScanAnalysis2 = CameraScanAnalysis.this;
                    cameraScanAnalysis2.decode(cameraScanAnalysis2.data, CameraScanAnalysis.this.size.width, CameraScanAnalysis.this.size.height);
                    return;
                }
            }
            ScanResult scanResult = new ScanResult();
            scanResult.setContent(str);
            scanResult.setType(type == 64 ? 1 : 2);
            Message messageObtainMessage = CameraScanAnalysis.this.mHandler.obtainMessage();
            messageObtainMessage.obj = scanResult;
            messageObtainMessage.sendToTarget();
            CameraScanAnalysis.this.lastResultTime = System.currentTimeMillis();
            if (Symbol.looperScan) {
                CameraScanAnalysis.this.allowAnalysis = true;
            }
        }
    };

    public CameraScanAnalysis(Context context) {
        this.context = context;
        ImageScanner imageScanner = new ImageScanner();
        this.mImageScanner = imageScanner;
        int i5 = Symbol.scanType;
        if (i5 == 1) {
            imageScanner.setConfig(0, 0, 0);
            this.mImageScanner.setConfig(64, 0, 1);
        } else if (i5 == 2) {
            imageScanner.setConfig(0, 0, 0);
            this.mImageScanner.setConfig(128, 0, 1);
            this.mImageScanner.setConfig(39, 0, 1);
            this.mImageScanner.setConfig(13, 0, 1);
            this.mImageScanner.setConfig(8, 0, 1);
            this.mImageScanner.setConfig(12, 0, 1);
            this.mImageScanner.setConfig(9, 0, 1);
            this.mImageScanner.setConfig(9, 0, 1);
        } else if (i5 != 3 && i5 == 4) {
            imageScanner.setConfig(0, 0, 0);
            this.mImageScanner.setConfig(Symbol.scanFormat, 0, 1);
        } else {
            imageScanner.setConfig(0, 256, 3);
            this.mImageScanner.setConfig(0, 257, 3);
        }
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: cn.bertsir.zbar.CameraScanAnalysis.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (CameraScanAnalysis.this.mCallback != null) {
                    CameraScanAnalysis.this.mCallback.onScanResult((ScanResult) message.obj);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decode(byte[] bArr, int i5, int i6) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i7 = 0; i7 < i6; i7++) {
            for (int i8 = 0; i8 < i5; i8++) {
                bArr2[(((i8 * i6) + i6) - i7) - 1] = bArr[(i7 * i5) + i8];
            }
        }
        PlanarYUVLuminanceSource planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr2, i6, i5, 0, 0, i6, i5, true);
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QRCodeReader());
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        this.multiFormatReader.setHints(hashtable);
        try {
            try {
                Result resultDecodeWithState = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
                String string = resultDecodeWithState.toString();
                BarcodeFormat barcodeFormat = resultDecodeWithState.getBarcodeFormat();
                if (TextUtils.isEmpty(string)) {
                    this.allowAnalysis = true;
                } else {
                    ScanResult scanResult = new ScanResult();
                    scanResult.setContent(string);
                    scanResult.setType(barcodeFormat == BarcodeFormat.QR_CODE ? 1 : 2);
                    Message messageObtainMessage = this.mHandler.obtainMessage();
                    messageObtainMessage.obj = scanResult;
                    messageObtainMessage.sendToTarget();
                    this.lastResultTime = System.currentTimeMillis();
                    if (Symbol.looperScan) {
                        this.allowAnalysis = true;
                    }
                }
            } catch (ReaderException unused) {
                this.allowAnalysis = true;
            }
        } finally {
            this.multiFormatReader.reset();
        }
    }

    public void cameraZoom(Camera camera) {
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported() && parameters.getMaxZoom() != 0 && parameters.getZoom() + 10 <= parameters.getMaxZoom()) {
                parameters.setZoom(parameters.getZoom() + 10);
                camera.setParameters(parameters);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.allowAnalysis) {
            this.allowAnalysis = false;
            this.data = bArr;
            this.camera = camera;
            this.size = camera.getParameters().getPreviewSize();
            Camera.Size size = this.size;
            Image image = new Image(size.width, size.height, "Y800");
            this.barcode = image;
            image.setData(bArr);
            if (Symbol.is_only_scan_center) {
                float f6 = Symbol.cropWidth;
                Camera.Size size2 = this.size;
                int i5 = size2.height;
                int i6 = (int) ((i5 / Symbol.screenWidth) * f6);
                this.cropWidth = i6;
                float f7 = Symbol.cropHeight;
                int i7 = size2.width;
                int i8 = (int) ((i7 / Symbol.screenHeight) * f7);
                this.cropHeight = i8;
                Symbol.cropX = (i7 / 2) - (i8 / 2);
                Symbol.cropY = (i5 / 2) - (i6 / 2);
                this.barcode.setCrop(Symbol.cropX, Symbol.cropY, i8, i6);
            } else {
                Symbol.cropX = 0;
                Symbol.cropY = 0;
                Camera.Size size3 = this.size;
                this.cropWidth = size3.width;
                this.cropHeight = size3.height;
            }
            if (!Symbol.looperScan || System.currentTimeMillis() - this.lastResultTime >= Symbol.looperWaitTime) {
                this.executorService.execute(this.mAnalysisTask);
            } else {
                this.allowAnalysis = true;
            }
        }
    }

    public void onStart() {
        this.allowAnalysis = true;
    }

    public void onStop() {
        this.allowAnalysis = false;
    }

    public void setScanCallback(ScanCallback scanCallback) {
        this.mCallback = scanCallback;
    }
}
