package cn.bertsir.zbar;

import android.graphics.Color;
import androidx.annotation.DrawableRes;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class QrConfig implements Serializable {
    public static final int BARCODE_CODABAR = 38;
    public static final int BARCODE_CODE128 = 128;
    public static final int BARCODE_CODE39 = 39;
    public static final int BARCODE_CODE93 = 93;
    public static final int BARCODE_DATABAR = 34;
    public static final int BARCODE_DATABAR_EXP = 35;
    public static final int BARCODE_EAN13 = 13;
    public static final int BARCODE_EAN8 = 8;
    public static final int BARCODE_I25 = 25;
    public static final int BARCODE_ISBN10 = 10;
    public static final int BARCODE_ISBN13 = 14;
    public static final int BARCODE_PDF417 = 57;
    public static final int BARCODE_UPCA = 12;
    public static final int BARCODE_UPCE = 9;
    public static final String EXTRA_THIS_CONFIG = "extra_this_config";
    public static final int LINE_FAST = 1000;
    public static final int LINE_MEDIUM = 2000;
    public static final int LINE_SLOW = 3000;
    public static final int REQUEST_CAMERA = 99;
    public static final int SCANVIEW_TYPE_BARCODE = 2;
    public static final int SCANVIEW_TYPE_QRCODE = 1;
    public static final int SCREEN_LANDSCAPE = 2;
    public static final int SCREEN_PORTRAIT = 1;
    public static final int SCREEN_SENSOR = 3;
    public static final int TYPE_ALL = 3;
    public static final int TYPE_BARCODE = 2;
    public static final int TYPE_CUSTOM = 4;
    public static final int TYPE_QRCODE = 1;
    public static int ding_path = R.raw.qrcode;
    public int CORNER_COLOR = Color.parseColor("#ff5f00");
    public int LINE_COLOR = Color.parseColor("#ff5f00");
    public int TITLE_BACKGROUND_COLOR = Color.parseColor("#ff5f00");
    public int TITLE_TEXT_COLOR = Color.parseColor("#ffffff");
    public boolean show_title = true;
    public boolean show_light = true;
    public boolean show_album = true;
    public boolean show_des = true;
    public boolean need_crop = true;
    public boolean show_zoom = false;
    public boolean auto_zoom = false;
    public boolean finger_zoom = false;
    public boolean only_center = false;
    public boolean play_sound = true;
    public boolean double_engine = false;
    public boolean loop_scan = false;
    public boolean show_vibrator = false;
    public String title_text = "扫描二维码";
    public String des_text = "(识别二维码)";
    public String open_album_text = "选择要识别的图片";
    public int line_speed = 1000;
    public int line_style = 2;
    public int corner_width = 10;
    public int loop_wait_time = 0;
    public int back_img_res = R.drawable.scanner_back_img;
    public int falsh_img_res = R.drawable.scanner_light;
    public int album_img_res = R.drawable.scanner_album;
    public boolean auto_light = false;
    public int custombarcodeformat = -1;
    public int scan_type = 1;
    public int scan_view_type = 1;
    public int SCREEN_ORIENTATION = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Builder {
        private QrConfig watcher = new QrConfig();

        public QrConfig create() {
            return this.watcher;
        }

        public Builder setAblumImageRes(@DrawableRes int i5) {
            this.watcher.album_img_res = i5;
            return this;
        }

        public Builder setAutoLight(boolean z6) {
            this.watcher.auto_light = z6;
            return this;
        }

        public Builder setAutoZoom(boolean z6) {
            this.watcher.auto_zoom = z6;
            return this;
        }

        public Builder setBackImageRes(@DrawableRes int i5) {
            this.watcher.back_img_res = i5;
            return this;
        }

        public Builder setCornerColor(int i5) {
            this.watcher.CORNER_COLOR = i5;
            return this;
        }

        public Builder setCornerWidth(int i5) {
            this.watcher.corner_width = i5;
            return this;
        }

        public Builder setCustombarcodeformat(int i5) {
            this.watcher.custombarcodeformat = i5;
            return this;
        }

        public Builder setDesText(String str) {
            this.watcher.des_text = str;
            return this;
        }

        public Builder setDingPath(int i5) {
            QrConfig.ding_path = i5;
            return this;
        }

        public Builder setDoubleEngine(boolean z6) {
            this.watcher.double_engine = z6;
            return this;
        }

        public Builder setFingerZoom(boolean z6) {
            this.watcher.finger_zoom = z6;
            return this;
        }

        public Builder setIsOnlyCenter(boolean z6) {
            this.watcher.only_center = z6;
            return this;
        }

        public Builder setLightImageRes(@DrawableRes int i5) {
            this.watcher.falsh_img_res = i5;
            return this;
        }

        public Builder setLineColor(int i5) {
            this.watcher.LINE_COLOR = i5;
            return this;
        }

        public Builder setLineSpeed(int i5) {
            this.watcher.line_speed = i5;
            return this;
        }

        public Builder setLooperScan(boolean z6) {
            this.watcher.loop_scan = z6;
            return this;
        }

        public Builder setLooperWaitTime(int i5) {
            this.watcher.loop_wait_time = i5;
            return this;
        }

        public Builder setNeedCrop(boolean z6) {
            this.watcher.need_crop = z6;
            return this;
        }

        public Builder setOpenAlbumText(String str) {
            this.watcher.open_album_text = str;
            return this;
        }

        public Builder setPlaySound(boolean z6) {
            this.watcher.play_sound = z6;
            return this;
        }

        public Builder setScanLineStyle(int i5) {
            this.watcher.line_style = i5;
            return this;
        }

        public Builder setScanType(int i5) {
            this.watcher.scan_type = i5;
            return this;
        }

        public Builder setScanViewType(int i5) {
            this.watcher.scan_view_type = i5;
            return this;
        }

        public Builder setScreenOrientation(int i5) {
            this.watcher.SCREEN_ORIENTATION = i5;
            return this;
        }

        public Builder setShowAlbum(boolean z6) {
            this.watcher.show_album = z6;
            return this;
        }

        public Builder setShowDes(boolean z6) {
            this.watcher.show_des = z6;
            return this;
        }

        public Builder setShowLight(boolean z6) {
            this.watcher.show_light = z6;
            return this;
        }

        public Builder setShowTitle(boolean z6) {
            this.watcher.show_title = z6;
            return this;
        }

        public Builder setShowVibrator(boolean z6) {
            this.watcher.show_vibrator = z6;
            return this;
        }

        public Builder setShowZoom(boolean z6) {
            this.watcher.show_zoom = z6;
            return this;
        }

        public Builder setTitleBackgroudColor(int i5) {
            this.watcher.TITLE_BACKGROUND_COLOR = i5;
            return this;
        }

        public Builder setTitleText(String str) {
            this.watcher.title_text = str;
            return this;
        }

        public Builder setTitleTextColor(int i5) {
            this.watcher.TITLE_TEXT_COLOR = i5;
            return this;
        }
    }

    public static int getDing_path() {
        return ding_path;
    }

    public int getAblumImageRes() {
        return this.album_img_res;
    }

    public int getBackImgRes() {
        return this.back_img_res;
    }

    public int getCORNER_COLOR() {
        return this.CORNER_COLOR;
    }

    public int getCorner_width() {
        return this.corner_width;
    }

    public int getCustombarcodeformat() {
        return this.custombarcodeformat;
    }

    public String getDes_text() {
        return this.des_text;
    }

    public int getLINE_COLOR() {
        return this.LINE_COLOR;
    }

    public int getLightImageRes() {
        return this.falsh_img_res;
    }

    public int getLine_speed() {
        return this.line_speed;
    }

    public int getLine_style() {
        return this.line_style;
    }

    public int getLoop_wait_time() {
        return this.loop_wait_time;
    }

    public String getOpen_album_text() {
        return this.open_album_text;
    }

    public int getSCREEN_ORIENTATION() {
        return this.SCREEN_ORIENTATION;
    }

    public int getScan_type() {
        return this.scan_type;
    }

    public int getScan_view_type() {
        return this.scan_view_type;
    }

    public int getTITLE_BACKGROUND_COLOR() {
        return this.TITLE_BACKGROUND_COLOR;
    }

    public int getTITLE_TEXT_COLOR() {
        return this.TITLE_TEXT_COLOR;
    }

    public String getTitle_text() {
        return this.title_text;
    }

    public boolean isAuto_light() {
        return this.auto_light;
    }

    public boolean isAuto_zoom() {
        return this.auto_zoom;
    }

    public boolean isDouble_engine() {
        return this.double_engine;
    }

    public boolean isFinger_zoom() {
        return this.finger_zoom;
    }

    public boolean isLoop_scan() {
        return this.loop_scan;
    }

    public boolean isNeed_crop() {
        return this.need_crop;
    }

    public boolean isOnly_center() {
        return this.only_center;
    }

    public boolean isPlay_sound() {
        return this.play_sound;
    }

    public boolean isShow_album() {
        return this.show_album;
    }

    public boolean isShow_des() {
        return this.show_des;
    }

    public boolean isShow_light() {
        return this.show_light;
    }

    public boolean isShow_title() {
        return this.show_title;
    }

    public boolean isShow_vibrator() {
        return this.show_vibrator;
    }

    public boolean isShow_zoom() {
        return this.show_zoom;
    }
}
