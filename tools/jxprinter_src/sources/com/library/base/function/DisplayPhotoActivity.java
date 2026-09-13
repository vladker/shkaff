package com.library.base.function;

import Y1.c;
import Y1.d;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import p058k2.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a implements j {
        public a() {
        }

        @Override // p058k2.j
        public final void onViewTap(View view, float f6, float f7) {
            DisplayPhotoActivity.this.finish();
        }
    }

    public static /* synthetic */ p021d2.a access$200(DisplayPhotoActivity displayPhotoActivity) {
        displayPhotoActivity.getClass();
        return null;
    }

    public static void open(Context context, String[] strArr) {
        open(context, strArr, -1, -1);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0082  */
    /* JADX WARN: Code duplicated, block: B:25:0x0089  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    public void initData() {
        try {
            String string = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString("custom");
            p051j0.a.k(TAG, string);
            if (Class.forName(string).newInstance() == null) {
                throw null;
            }
            throw new ClassCastException();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
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
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
            Bundle extras2 = getIntent().getExtras();
            this.imagePaths = extras2.getStringArray(KEY_IMAGE_PATHS);
            this.position = extras2.getInt(KEY_POSITION, -1);
            this.defaultPic = extras2.getInt(KEY_DEFAULT_PIC, -1);
            p051j0.a.k(TAG, "ImagePaths=" + Arrays.toString(this.imagePaths));
            if (this.position == -1) {
                this.position = 1;
            }
            if (this.defaultPic == -1) {
                this.defaultPic = Y1.b.loading_default_image;
            }
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
            Bundle extras3 = getIntent().getExtras();
            this.imagePaths = extras3.getStringArray(KEY_IMAGE_PATHS);
            this.position = extras3.getInt(KEY_POSITION, -1);
            this.defaultPic = extras3.getInt(KEY_DEFAULT_PIC, -1);
            p051j0.a.k(TAG, "ImagePaths=" + Arrays.toString(this.imagePaths));
            if (this.position == -1) {
                this.position = 1;
            }
            if (this.defaultPic == -1) {
                this.defaultPic = Y1.b.loading_default_image;
            }
        } catch (InstantiationException e8) {
            e8.printStackTrace();
            Bundle extras4 = getIntent().getExtras();
            this.imagePaths = extras4.getStringArray(KEY_IMAGE_PATHS);
            this.position = extras4.getInt(KEY_POSITION, -1);
            this.defaultPic = extras4.getInt(KEY_DEFAULT_PIC, -1);
            p051j0.a.k(TAG, "ImagePaths=" + Arrays.toString(this.imagePaths));
            if (this.position == -1) {
                this.position = 1;
            }
            if (this.defaultPic == -1) {
                this.defaultPic = Y1.b.loading_default_image;
            }
        }
    }

    public void initListener() {
        if (this.imagePaths.length != 1) {
            this.mViewPager.setOnPageChangeListener(new b());
        }
    }

    public void initView() {
        this.mViewPager = (ViewPager) findViewById(c.view_pager);
        this.mMultiple = (RelativeLayout) findViewById(c.multipleRL);
        this.mLeaflet = (PhotoView) findViewById(c.leafletPV);
        this.mPhotoNumber = (TextView) findViewById(c.photo_number);
        if (this.imagePaths.length == 1) {
            this.mLeaflet.setVisibility(0);
            com.bumptech.glide.c.with((FragmentActivity) this).load(this.imagePaths[0]).apply(new I0.j().placeholder(this.defaultPic)).into(this.mLeaflet);
            this.mLeaflet.setOnViewTapListener(new a());
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
        setContentView(d.activity_display_photo);
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

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i5) {
            DisplayPhotoActivity displayPhotoActivity = DisplayPhotoActivity.this;
            displayPhotoActivity.mPhotoNumber.setText((i5 + 1) + PackagingURIHelper.FORWARD_SLASH_STRING + displayPhotoActivity.imagePaths.length);
            DisplayPhotoActivity.access$200(displayPhotoActivity);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i5) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i5, float f6, int i6) {
        }
    }
}
