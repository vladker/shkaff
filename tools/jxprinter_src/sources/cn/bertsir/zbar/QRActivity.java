package cn.bertsir.zbar;

import A3.AbstractC0157z;
import W2.b;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.utils.QRUtils;
import cn.bertsir.zbar.view.ScanView;
import cn.bertsir.zbar.view.VerticalSeekBar;
import com.soundcloud.android.crop.CropImageActivity;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class QRActivity extends Activity implements View.OnClickListener, SensorEventListener {
    static final int REQUEST_IMAGE_GET = 1;
    static final int REQUEST_PHOTO_CUT = 2;
    public static final int RESULT_CANCELED = 401;
    private static final String TAG = "QRActivity";
    private CameraPreview cp;
    private String cropTempPath;
    private FrameLayout fl_title;
    private ImageView iv_album;
    private ImageView iv_flash;
    private ImageView mo_scanner_back;
    private QrConfig options;
    private AlertDialog progressDialog;
    private Sensor sensor;
    private SensorManager sensorManager;
    private SoundPool soundPool;
    private ScanView sv;
    private TextView textDialog;
    private TextView tv_des;
    private TextView tv_title;
    private Uri uricropFile;
    private VerticalSeekBar vsb_zoom;
    public final float AUTOLIGHTMIN = 10.0f;
    private float oldDist = 1.0f;
    private ScanCallback resultCallback = new ScanCallback() { // from class: cn.bertsir.zbar.QRActivity.2
        @Override // cn.bertsir.zbar.ScanCallback
        public void onScanResult(ScanResult scanResult) {
            if (QRActivity.this.options.isPlay_sound()) {
                QRActivity.this.soundPool.play(1, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            if (QRActivity.this.options.isShow_vibrator()) {
                QRUtils.getInstance().getVibrator(QRActivity.this.getApplicationContext());
            }
            if (QRActivity.this.cp != null) {
                QRActivity.this.cp.setFlash(false);
            }
            QrManager.getInstance().getResultCallback().onScanSuccess(scanResult);
            if (Symbol.looperScan) {
                return;
            }
            QRActivity.this.finish();
        }
    };

    private void fromAlbum() {
        if (Build.VERSION.SDK_INT <= 29 && checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 100);
            return;
        }
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 1);
    }

    private String getSystemLanguageSafely(Context context) {
        try {
            return context.getResources().getConfiguration().locale.getLanguage();
        } catch (Exception unused) {
            return "en";
        }
    }

    private void initParm() {
        int screen_orientation = this.options.getSCREEN_ORIENTATION();
        if (screen_orientation == 1) {
            setRequestedOrientation(1);
        } else if (screen_orientation == 2) {
            setRequestedOrientation(0);
        } else if (screen_orientation != 3) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(4);
        }
        Symbol.scanType = this.options.getScan_type();
        Symbol.scanFormat = this.options.getCustombarcodeformat();
        Symbol.is_only_scan_center = this.options.isOnly_center();
        Symbol.is_auto_zoom = this.options.isAuto_zoom();
        Symbol.doubleEngine = this.options.isDouble_engine();
        Symbol.looperScan = this.options.isLoop_scan();
        Symbol.looperWaitTime = this.options.getLoop_wait_time();
        Symbol.screenWidth = QRUtils.getInstance().getScreenWidth(this);
        Symbol.screenHeight = QRUtils.getInstance().getScreenHeight(this);
        if (this.options.isAuto_light()) {
            getSensorManager();
        }
    }

    private void initView() {
        this.cp = (CameraPreview) findViewById(R.id.cp);
        SoundPool soundPool = new SoundPool(10, 1, 5);
        this.soundPool = soundPool;
        soundPool.load(this, QrConfig.getDing_path(), 1);
        ScanView scanView = (ScanView) findViewById(R.id.sv);
        this.sv = scanView;
        scanView.setType(this.options.getScan_view_type());
        ImageView imageView = (ImageView) findViewById(R.id.mo_scanner_back);
        this.mo_scanner_back = imageView;
        imageView.setOnClickListener(this);
        this.mo_scanner_back.setImageResource(this.options.getBackImgRes());
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_flash);
        this.iv_flash = imageView2;
        imageView2.setOnClickListener(this);
        this.iv_flash.setImageResource(this.options.getLightImageRes());
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_album);
        this.iv_album = imageView3;
        imageView3.setOnClickListener(this);
        this.iv_album.setImageResource(this.options.getAblumImageRes());
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        this.fl_title = (FrameLayout) findViewById(R.id.fl_title);
        this.tv_des = (TextView) findViewById(R.id.tv_des);
        this.vsb_zoom = (VerticalSeekBar) findViewById(R.id.vsb_zoom);
        this.iv_album.setVisibility(this.options.isShow_light() ? 0 : 8);
        this.fl_title.setVisibility(this.options.isShow_title() ? 0 : 8);
        this.iv_flash.setVisibility(this.options.isShow_light() ? 0 : 8);
        this.iv_album.setVisibility(this.options.isShow_album() ? 0 : 8);
        this.tv_des.setVisibility(this.options.isShow_des() ? 0 : 8);
        this.vsb_zoom.setVisibility(this.options.isShow_zoom() ? 0 : 8);
        this.tv_des.setText(this.options.getDes_text());
        this.tv_title.setText(this.options.getTitle_text());
        this.fl_title.setBackgroundColor(this.options.getTITLE_BACKGROUND_COLOR());
        this.tv_title.setTextColor(this.options.getTITLE_TEXT_COLOR());
        this.sv.setCornerColor(this.options.getCORNER_COLOR());
        this.sv.setLineSpeed(this.options.getLine_speed());
        this.sv.setLineColor(this.options.getLINE_COLOR());
        this.sv.setScanLineStyle(this.options.getLine_style());
        setSeekBarColor(this.vsb_zoom, this.options.getCORNER_COLOR());
        this.vsb_zoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: cn.bertsir.zbar.QRActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i5, boolean z6) {
                QRActivity.this.cp.setZoom(i5 / 100.0f);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recognitionLocation$0() {
        TextView textViewShowProgressDialog = showProgressDialog();
        this.textDialog = textViewShowProgressDialog;
        textViewShowProgressDialog.setText(getResources().getString(R.string.zbar_hint_loading));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recognitionLocation$1() {
        Toast.makeText(this, R.string.zbar_error_decode_failed, 0).show();
        closeProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recognitionLocation$2(String str) {
        closeProgressDialog();
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, R.string.zbar_error_no_qr_found, 0).show();
            return;
        }
        ScanResult scanResult = new ScanResult();
        scanResult.setContent(str);
        scanResult.setType(1);
        QrManager.getInstance().getResultCallback().onScanSuccess(scanResult);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recognitionLocation$3(Exception exc) {
        Toast.makeText(this, R.string.zbar_error_recognition_failed + exc.getMessage(), 0).show();
        closeProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recognitionLocation$4(Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                if (bitmapDecodeStream == null) {
                    runOnUiThread(new a(this, 0));
                } else {
                    runOnUiThread(new b(this, QRUtils.getInstance().decodeQRcode(bitmapDecodeStream), 10));
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            runOnUiThread(new b(this, e, 11));
            Log.e(TAG, "recognitionLocation error", e);
        }
    }

    private void recognitionLocation(Uri uri) {
        runOnUiThread(new a(this, 1));
        new Thread(new b(this, uri, 12)).start();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Locale locale = new Locale(context.getSharedPreferences("Settings", 0).getString("app_language", getSystemLanguageSafely(context)));
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        contextCreateConfigurationContext.getResources().updateConfiguration(configuration, contextCreateConfigurationContext.getResources().getDisplayMetrics());
        super.attachBaseContext(contextCreateConfigurationContext);
    }

    public void closeProgressDialog() {
        try {
            AlertDialog alertDialog = this.progressDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cropPhoto(Uri uri) {
        Uri uri2 = Uri.parse("file:///" + this.cropTempPath);
        this.uricropFile = uri2;
        Intent intent = new Intent();
        intent.setData(uri);
        intent.putExtra("output", uri2);
        intent.putExtra("aspect_x", 1);
        intent.putExtra("aspect_y", 1);
        intent.setClass(this, CropImageActivity.class);
        startActivityForResult(intent, 6709);
    }

    public void getSensorManager() {
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.sensorManager = sensorManager;
        if (sensorManager != null) {
            this.sensor = sensorManager.getDefaultSensor(5);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (i6 == -1) {
            if (i5 != 1) {
                if (i5 == 6709) {
                    recognitionLocation(this.uricropFile);
                }
            } else if (this.options.isNeed_crop()) {
                cropPhoto(intent.getData());
            } else {
                recognitionLocation(intent.getData());
            }
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_album) {
            fromAlbum();
            return;
        }
        if (view.getId() == R.id.iv_flash) {
            CameraPreview cameraPreview = this.cp;
            if (cameraPreview != null) {
                cameraPreview.setFlash();
                return;
            }
            return;
        }
        if (view.getId() == R.id.mo_scanner_back) {
            setResult(401);
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(getExternalCacheDir());
        this.cropTempPath = AbstractC0157z.s(sb, File.separator, "cropQr.jpg");
        getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        this.options = (QrConfig) getIntent().getExtras().get(QrConfig.EXTRA_THIS_CONFIG);
        initParm();
        setContentView(R.layout.activity_qr);
        initView();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CameraPreview cameraPreview = this.cp;
        if (cameraPreview != null) {
            cameraPreview.setFlash(false);
            this.cp.stop();
        }
        this.soundPool.release();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        CameraPreview cameraPreview = this.cp;
        if (cameraPreview != null) {
            cameraPreview.stop();
        }
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.sensor);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (i5 == 100 && iArr[0] == 0) {
            fromAlbum();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        CameraPreview cameraPreview = this.cp;
        if (cameraPreview != null) {
            cameraPreview.setScanCallback(this.resultCallback);
            this.cp.start();
        }
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, this.sensor, 3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] >= 10.0f || !this.cp.isPreviewStart()) {
            return;
        }
        this.cp.setFlash(true);
        this.sensorManager.unregisterListener(this, this.sensor);
        this.sensor = null;
        this.sensorManager = null;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.options.isFinger_zoom()) {
            int action = motionEvent.getAction() & 255;
            if (action != 2) {
                if (action == 5) {
                    this.oldDist = QRUtils.getInstance().getFingerSpacing(motionEvent);
                }
            } else if (motionEvent.getPointerCount() == 2) {
                float fingerSpacing = QRUtils.getInstance().getFingerSpacing(motionEvent);
                float f6 = this.oldDist;
                if (fingerSpacing > f6) {
                    this.cp.handleZoom(true);
                } else if (fingerSpacing < f6) {
                    this.cp.handleZoom(false);
                }
                this.oldDist = fingerSpacing;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @RequiresApi(api = 16)
    public void setSeekBarColor(SeekBar seekBar, int i5) {
        Drawable thumb = seekBar.getThumb();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        thumb.setColorFilter(i5, mode);
        seekBar.getProgressDrawable().setColorFilter(i5, mode);
    }

    public TextView showProgressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setCancelable(false);
        View viewInflate = View.inflate(this, R.layout.dialog_loading_qr, null);
        builder.setView(viewInflate);
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.pb_loading);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_hint);
        progressBar.setIndeterminateTintList(getColorStateList(R.color.dialog_pro_color));
        AlertDialog alertDialogCreate = builder.create();
        this.progressDialog = alertDialogCreate;
        alertDialogCreate.show();
        return textView;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i5) {
    }
}
