package p056k0;

import android.content.Context;
import android.graphics.Color;
import cn.bertsir.zbar.QrConfig;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public static QrConfig a(Context context) {
        return new QrConfig.Builder().setDesText(context.getString(g.text_266)).setShowDes(false).setShowLight(false).setShowTitle(true).setShowAlbum(true).setCornerColor(-1).setLineColor(-1).setLineSpeed(2000).setScanType(1).setScanViewType(1).setPlaySound(true).setNeedCrop(false).setIsOnlyCenter(false).setTitleText(context.getString(g.text_267)).setTitleBackgroudColor(Color.parseColor("#5EB1FF")).setTitleTextColor(-1).setShowZoom(false).setAutoZoom(true).setFingerZoom(false).setScreenOrientation(1).setDoubleEngine(true).setLooperScan(false).create();
    }
}
