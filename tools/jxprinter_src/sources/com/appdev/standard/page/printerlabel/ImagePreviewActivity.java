package com.appdev.standard.page.printerlabel;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import com.github.chrisbanes.photoview.PhotoView;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = "/printer/imagePreview")
public class ImagePreviewActivity extends AppCompatActivity {

    @Autowired(name = "image_path")
    String imagePath;
    private PhotoView photoView;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(p113u.e.activity_image_preview);
        ARouter.getInstance().inject(this);
        this.photoView = (PhotoView) findViewById(p113u.d.photo_view);
        if (TextUtils.isEmpty(this.imagePath)) {
            return;
        }
        com.bumptech.glide.c.with((FragmentActivity) this).load(new File(this.imagePath)).into(this.photoView);
        this.photoView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.appdev.standard.page.printerlabel.ImagePreviewActivity.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                new File(ImagePreviewActivity.this.imagePath).delete();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
    }
}
