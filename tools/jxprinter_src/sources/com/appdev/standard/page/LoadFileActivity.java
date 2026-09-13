package com.appdev.standard.page;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.Consts;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.TextFontModel;
import com.bumptech.glide.f;
import com.library.base.frame.MvpActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import p042h2.e;
import p051j0.i;
import p102s.G;
import p113u.g;
import p137y.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_LOAD_FILE)
public class LoadFileActivity extends MvpActivity {
    private static LoadType currentLoadType = LoadType.LOAD_TYPE_NORMAL;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LoadType {
        LOAD_TYPE_NORMAL,
        LOAD_TYPE_SP_FILE,
        LOAD_TYPE_SP_EXCEL
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void handleFontFile(Uri uri, String str) {
        if (!e.f4031a.h()) {
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
            defaultTipDialog.e("");
            defaultTipDialog.c(getString(g.text_248));
            defaultTipDialog.b(getString(g.text_256));
            defaultTipDialog.f2608a = new f() { // from class: com.appdev.standard.page.LoadFileActivity.1
                @Override // com.library.base.frame.d
                public void onCancel() {
                    LoadFileActivity.this.finish();
                }

                @Override // com.library.base.frame.d
                public void onConfirm() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                    LoadFileActivity.this.finish();
                }
            };
            defaultTipDialog.show();
            return;
        }
        try {
            File file = new File(getFilesDir(), "fonts");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i5 = inputStreamOpenInputStream.read(bArr);
                        if (i5 <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i5);
                        }
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                    fileOutputStream.close();
                    inputStreamOpenInputStream.close();
                    String strReplaceAll = str.replaceAll("\\.(ttf|otf)$", "");
                    String str2 = "custom_" + strReplaceAll + "_" + System.currentTimeMillis();
                    TextFontModel textFontModel = new TextFontModel();
                    textFontModel.setFontlibId(str2);
                    textFontModel.setName(strReplaceAll);
                    textFontModel.setLocalFilePath(file2.getAbsolutePath());
                    textFontModel.setDownload(true);
                    S4.d.b().h(new p(textFontModel));
                    p042h2.d.show(g.font_import_success);
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                throw th4;
            }
        } catch (Exception e) {
            p051j0.a.e(this.TAG, "Failed to import font", e);
            p042h2.d.show(g.font_import_failed);
        }
        finish();
    }

    private void handlerLoadFile(Intent intent) {
        String strSubstring;
        String strSubstring2;
        String action = intent.getAction();
        String type = intent.getType();
        String dataString = intent.getDataString();
        p051j0.a.k(this.TAG, "action=" + action);
        p051j0.a.k(this.TAG, "type=" + type);
        p051j0.a.k(this.TAG, "uri=" + dataString);
        if ("android.intent.action.VIEW".equals(action)) {
            Uri data = intent.getData();
            if (data == null) {
                data = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            }
            String strC = i.c(this, data);
            if (strC == null) {
                p042h2.d.show(g.toast_10);
                finish();
                return;
            }
            p051j0.a.k(this.TAG, "fileName=".concat(strC));
            if (isFontFile(strC)) {
                handleFontFile(data, strC);
                return;
            }
            if (currentLoadType == LoadType.LOAD_TYPE_NORMAL) {
                if (!strC.endsWith(".doc") && !strC.endsWith(".docx") && !strC.endsWith(".ppt") && !strC.endsWith(".pptx") && !strC.endsWith(".xls") && !strC.endsWith(".xlsx") && !strC.endsWith(".jpg") && !strC.endsWith(".png") && !strC.endsWith(".pdf")) {
                    p042h2.d.show(g.toast_10);
                    finish();
                    return;
                }
                int iLastIndexOf = strC.lastIndexOf(Consts.DOT);
                if (iLastIndexOf == -1) {
                    strSubstring2 = "";
                    strSubstring = strC;
                } else {
                    strSubstring = strC.substring(0, iLastIndexOf);
                    strSubstring2 = strC.substring(iLastIndexOf);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(getExternalFilesDir(null).getAbsolutePath());
                String str = File.separator;
                File file = new File(androidx.exifinterface.media.a.s(sb, str, "docs", str, strC));
                int i5 = 1;
                while (file.exists()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(getExternalFilesDir(null).getAbsolutePath());
                    String str2 = File.separator;
                    androidx.collection.a.y(sb2, str2, "docs", str2, strSubstring);
                    sb2.append("(");
                    sb2.append(i5);
                    sb2.append(")");
                    sb2.append(strSubstring2);
                    file = new File(sb2.toString());
                    strC = strSubstring + "(" + i5 + ")" + strSubstring2;
                    i5++;
                }
                i.l(this, data, file);
                p035f5.b.a(strC, file.getAbsolutePath());
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PDF_FILE_LIST).navigation();
            } else if (currentLoadType == LoadType.LOAD_TYPE_SP_FILE) {
                if (!strC.endsWith(".bin")) {
                    p042h2.d.show(g.toast_10);
                    finish();
                    return;
                }
                File externalCacheDir = getExternalCacheDir();
                if (externalCacheDir == null) {
                    externalCacheDir = getCacheDir();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(externalCacheDir);
                String str3 = File.separator;
                File file2 = new File(androidx.exifinterface.media.a.s(sb3, str3, "open_cache", str3, strC));
                i.l(this, data, file2);
                G.Companion.addFiletoCloud(file2.getAbsolutePath());
            } else if (currentLoadType == LoadType.LOAD_TYPE_SP_EXCEL) {
                if (!strC.endsWith(".xls") && !strC.endsWith(".xlsx")) {
                    p042h2.d.show(g.toast_10);
                    finish();
                    return;
                }
                File externalCacheDir2 = getExternalCacheDir();
                if (externalCacheDir2 == null) {
                    externalCacheDir2 = getCacheDir();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(externalCacheDir2);
                String str4 = File.separator;
                File file3 = new File(androidx.exifinterface.media.a.s(sb4, str4, "open_cache", str4, strC));
                i.l(this, data, file3);
                G.Companion.addExcelToCloud(file3.getAbsolutePath());
            }
            V1.b.h().getClass();
            V1.b.b.remove(this);
            finish();
        }
    }

    private boolean isFontFile(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf");
    }

    public static void setLoadType(LoadType loadType) {
        currentLoadType = loadType;
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_load_file;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handlerLoadFile(intent);
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        handlerLoadFile(getIntent());
    }
}
