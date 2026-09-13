package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.frame.MvpActivity;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PHOTO_PRINT)
public class PhotoPrintActivity extends MvpActivity {
    private p056k0.i mediaPicker = new p056k0.i();

    @BindView(6274)
    TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLocalPicClick$0(Uri uri) {
        if (uri == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("image", uri.toString());
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("pic_printer").arguments(map).requestCode(0).build());
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mediaPicker.attachToActivity(this);
        this.tvTitle.setText(getString(p113u.g.text_182));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_photo_print;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
    }

    public void onLocalPicClick(View view) {
        this.mediaPicker.pick(new y(7));
    }

    public void onMaterialLibraryClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MATERIAL_LIBRARY);
    }
}
