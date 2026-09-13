package com.appdev.standard.page.printerlabel;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.frame.MvpActivity;
import com.library.base.view.photoview.PhotoView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MATERIAL_LIBRARY_PAGE)
public class MaterialLibraryPageActivity extends MvpActivity {
    private static final int REQUEST_CODE_STORAGE_PERMISSION = 100;

    @Autowired(name = "path")
    String path;

    @BindView(5715)
    PhotoView pvMain;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.MaterialLibraryPageActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$appdev$standard$page$printerlabel$MaterialLibraryPageActivity$JumpType;

        static {
            int[] iArr = new int[JumpType.values().length];
            $SwitchMap$com$appdev$standard$page$printerlabel$MaterialLibraryPageActivity$JumpType = iArr;
            try {
                iArr[JumpType.PRINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$appdev$standard$page$printerlabel$MaterialLibraryPageActivity$JumpType[JumpType.EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum JumpType {
        PRINT,
        EDIT
    }

    private void downloadAndSaveImage(String str) {
        runOnNewThread(new x(this, str, 2));
    }

    private void downloadImage(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            downloadAndSaveImage(str);
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
        } else {
            downloadAndSaveImage(str);
        }
    }

    private void downloadPrintImage(String str, JumpType jumpType) {
        runOnNewThread(new RunnableC0482n(this, str, jumpType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleJump, reason: merged with bridge method [inline-methods] */
    public void lambda$downloadPrintImage$0(JumpType jumpType, File file) {
        p050j.w.c();
        int i5 = AnonymousClass1.$SwitchMap$com$appdev$standard$page$printerlabel$MaterialLibraryPageActivity$JumpType[jumpType.ordinal()];
        if (i5 == 1) {
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PICTURE_PRINT).withString("path", file.getAbsolutePath()).navigation();
            return;
        }
        if (i5 != 2) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        p051j0.a.d(this.TAG, "Local path: " + absolutePath);
        HashMap map = new HashMap();
        map.put("image_path", absolutePath);
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("footage_editing").arguments(map).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadAndSaveImage$3(Uri uri) {
        p050j.w.c();
        if (uri != null) {
            p042h2.d.show(p113u.g.text_423);
        } else {
            p042h2.d.show(p113u.g.text_432);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadAndSaveImage$4(String str, Uri uri) {
        runOnUiThread(new w(uri, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadAndSaveImage$5() {
        p050j.w.c();
        p042h2.d.show(p113u.g.text_432);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadAndSaveImage$6(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            File fileSaveImageToMediaStore = Build.VERSION.SDK_INT >= 29 ? saveImageToMediaStore(bitmapDecodeStream) : saveImageToPublicDirectory(bitmapDecodeStream);
            inputStream.close();
            if (fileSaveImageToMediaStore == null || !fileSaveImageToMediaStore.exists() || fileSaveImageToMediaStore.length() <= 0) {
                throw new IOException("File not created or empty");
            }
            MediaScannerConnection.scanFile(getApplicationContext(), new String[]{fileSaveImageToMediaStore.getAbsolutePath()}, new String[]{ContentTypes.IMAGE_JPEG}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.appdev.standard.page.printerlabel.z
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str2, Uri uri) {
                    this.f2823a.lambda$downloadAndSaveImage$4(str2, uri);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            runOnUiThread(new G(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadPrintImage$1() {
        p050j.w.c();
        p042h2.d.show(p113u.g.text_432);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPrintImage$2(String str, JumpType jumpType) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            File externalCacheDir = getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = getCacheDir();
            }
            File file = new File(externalCacheDir, "jx_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
            String absolutePath = file.getAbsolutePath();
            p051j0.a.d(this.TAG, "aPath=" + absolutePath);
            runOnUiThread(new RunnableC0482n(this, jumpType, file, 1));
        } catch (IOException e) {
            e.printStackTrace();
            runOnUiThread(new G(2));
        }
    }

    @RequiresApi(api = 29)
    private File saveImageToMediaStore(Bitmap bitmap) throws IOException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", androidx.exifinterface.media.a.k("jx_", System.currentTimeMillis(), ".jpg"));
        contentValues.put("mime_type", ContentTypes.IMAGE_JPEG);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = getContentResolver();
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            throw new IOException("Failed to create MediaStore entry");
        }
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
        if (outputStreamOpenOutputStream != null) {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.flush();
            } catch (Throwable th) {
                try {
                    outputStreamOpenOutputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        if (outputStreamOpenOutputStream != null) {
            outputStreamOpenOutputStream.close();
        }
        contentValues.clear();
        contentValues.put("is_pending", (Integer) 0);
        contentResolver.update(uriInsert, contentValues, null, null);
        try {
            Cursor cursorQuery = contentResolver.query(uriInsert, new String[]{"_data"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        File file = new File(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")));
                        cursorQuery.close();
                        return file;
                    }
                } catch (Throwable th3) {
                    try {
                        cursorQuery.close();
                        throw th3;
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                        throw th3;
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private File saveImageToPublicDirectory(Bitmap bitmap) throws IOException {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdirs()) {
            throw new IOException("Failed to create directory: " + externalStoragePublicDirectory.getAbsolutePath());
        }
        File file = new File(externalStoragePublicDirectory, androidx.exifinterface.media.a.k("jx_", System.currentTimeMillis(), ".jpg"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        p047i2.a.a(this.pvMain, this.path);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_material_library_page;
    }

    public void onDownloadPicClick(View view) {
        downloadImage(this.path);
    }

    public void onEditPicClick(View view) {
        downloadPrintImage(this.path, JumpType.EDIT);
    }

    public void onPrintPicClick(View view) {
        downloadPrintImage(this.path, JumpType.PRINT);
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i5, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 100) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                p042h2.d.show(p113u.g.toast_3);
            } else {
                downloadAndSaveImage(this.path);
            }
        }
    }
}
