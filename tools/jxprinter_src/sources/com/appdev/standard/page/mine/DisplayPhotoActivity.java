package com.appdev.standard.page.mine;

import I0.j;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.library.base.view.photoview.PhotoView;
import java.util.Arrays;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DisplayPhotoActivity extends AppCompatActivity {
    private static String KEY_DEFAULT_PIC = "key_default_pic";
    private static String KEY_IMAGE_PATHS = "key_image_paths";
    private static String KEY_POSITION = "key_position";
    public static String TAG = "DisplayPhotoActivity";
    private p021d2.a custom;
    private int defaultPic;
    private String[] imagePaths;
    private PhotoView mLeaflet;
    private RelativeLayout mMultiple;
    private Z1.b mPhotoDisplayAdapter;
    private TextView mPhotoNumber;
    private ViewPager mViewPager;
    private int position;

    public static void open(Context context, String[] strArr) {
        open(context, strArr, -1, -1);
    }

    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.imagePaths = extras.getStringArray(KEY_IMAGE_PATHS);
        this.position = extras.getInt(KEY_POSITION, -1);
        this.defaultPic = extras.getInt(KEY_DEFAULT_PIC, -1);
        p051j0.a.k(TAG, "ImagePaths=" + Arrays.toString(this.imagePaths));
        if (this.position == -1) {
            this.position = 1;
        }
        if (this.defaultPic == -1) {
            this.defaultPic = Y1.b.loading_default_image;
        }
    }

    public void initListener() {
        if (this.imagePaths.length != 1) {
            this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appdev.standard.page.mine.DisplayPhotoActivity.2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i5) {
                    DisplayPhotoActivity.this.mPhotoNumber.setText((i5 + 1) + PackagingURIHelper.FORWARD_SLASH_STRING + DisplayPhotoActivity.this.imagePaths.length);
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i5) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i5, float f6, int i6) {
                }
            });
        }
    }

    public void initView() {
        this.mViewPager = (ViewPager) findViewById(Y1.c.view_pager);
        this.mMultiple = (RelativeLayout) findViewById(Y1.c.multipleRL);
        this.mLeaflet = (PhotoView) findViewById(Y1.c.leafletPV);
        this.mPhotoNumber = (TextView) findViewById(Y1.c.photo_number);
        if (this.imagePaths.length == 1) {
            this.mLeaflet.setVisibility(0);
            com.bumptech.glide.c.with((FragmentActivity) this).load(this.imagePaths[0]).apply(new j().placeholder(this.defaultPic)).into(this.mLeaflet);
            this.mLeaflet.setOnViewTapListener(new p058k2.j() { // from class: com.appdev.standard.page.mine.DisplayPhotoActivity.1
                @Override // p058k2.j
                public void onViewTap(View view, float f6, float f7) {
                    DisplayPhotoActivity.this.finish();
                }
            });
            return;
        }
        this.mMultiple.setVisibility(0);
        Z1.b bVar = new Z1.b(this, this.imagePaths, this.defaultPic);
        this.mPhotoDisplayAdapter = bVar;
        this.mViewPager.setAdapter(bVar);
        this.mViewPager.setCurrentItem(this.position - 1);
        this.mPhotoNumber.setText(this.position + PackagingURIHelper.FORWARD_SLASH_STRING + this.imagePaths.length);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Y1.d.activity_display_photo);
        initData();
        initView();
        initListener();
    }

    public static void open(Context context, String[] strArr, int i5, int i6) {
        Bundle bundle = new Bundle();
        bundle.putStringArray(KEY_IMAGE_PATHS, strArr);
        bundle.putInt(KEY_POSITION, i5);
        bundle.putInt(KEY_DEFAULT_PIC, i6);
        Intent intent = new Intent(context, (Class<?>) DisplayPhotoActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void open(Context context, String[] strArr, int i5) {
        open(context, strArr, i5, -1);
    }
}
