package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.DialogC0464q;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.util.LanguageUtils;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextFontFragment extends com.library.base.frame.f implements J.a {
    private static final String FONT_DIR_NAME = "fonts";
    private static final String IMPORTED_FONTS = "imported_fonts";
    private static final int REQUEST_CODE_IMPORT_FONT = 1001;
    private List<BaseControlView> baseControlViews;
    private DialogC0464q fontDownloadProgressDialog;
    private C0451d mCustomPopWindow;
    private com.library.base.util.recyclerview.f quickAdapter;
    private ElementAttributeTextBean referenceBean;
    private PrinterLabelTextView referenceTextView;

    @BindView(5816)
    RecyclerView rvAttributeTextFont;
    private List<TextFontModel> textFontModels;
    private J.b textFontWorker;

    @BindView(6109)
    TextView tvImportFont;

    public AttributeTextFontFragment(List<BaseControlView> list) {
        this.baseControlViews = new ArrayList();
        if (list != null) {
            this.baseControlViews = list;
            for (BaseControlView baseControlView : list) {
                if (baseControlView instanceof PrinterLabelTextView) {
                    this.referenceTextView = (PrinterLabelTextView) baseControlView;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFontToAllElements(final TextFontModel textFontModel) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.p
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public final void run() {
                        this.f2739a.lambda$applyFontToAllElements$4(printerLabelTextView, textFontModel);
                    }
                });
            }
        }
        updateFontSelection(textFontModel);
    }

    private String getFontFileNameFromUri(Uri uri) {
        Uri uri2;
        String string = null;
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            uri2 = uri;
            Cursor cursorQuery = getContext().getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("_display_name");
                string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
                cursorQuery.close();
            }
        } else {
            uri2 = uri;
        }
        return string == null ? uri2.getLastPathSegment() : string;
    }

    private File getFontStorageDir() {
        return new File(getContext().getFilesDir(), FONT_DIR_NAME);
    }

    private void handleLogic(View view) {
        View viewFindViewById = view.findViewById(p113u.d.ll_pop_font_import_file);
        View viewFindViewById2 = view.findViewById(p113u.d.ll_pop_font_file_import_wechat);
        View viewFindViewById3 = view.findViewById(p113u.d.ll_pop_font_file_import_qq);
        viewFindViewById.setOnClickListener(new q(this, 1));
        viewFindViewById2.setOnClickListener(new q(this, 2));
        viewFindViewById3.setOnClickListener(new q(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkFont(final TextFontModel textFontModel) {
        getFrameActivity().needStoragePermission(new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_324)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTextFontFragment.5

            /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTextFontFragment$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public class AnonymousClass1 extends com.appdev.standard.util.fileDownload.h {
                final /* synthetic */ File val$targetFile;

                public AnonymousClass1(File file) {
                    this.val$targetFile = file;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onError$0() {
                    if (AttributeTextFontFragment.this.fontDownloadProgressDialog != null) {
                        AttributeTextFontFragment.this.fontDownloadProgressDialog.dismiss();
                    }
                    p042h2.d.show(p113u.g.toast_52);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void lambda$onStart$1() {
                    AttributeTextFontFragment.this.fontDownloadProgressDialog = new DialogC0464q(AttributeTextFontFragment.this.getContext());
                    ProgressBar progressBar = AttributeTextFontFragment.this.fontDownloadProgressDialog.f2653a;
                    if (progressBar != null) {
                        progressBar.setMax(100);
                    }
                    AttributeTextFontFragment.this.fontDownloadProgressDialog.a(0);
                    AttributeTextFontFragment.this.fontDownloadProgressDialog.show();
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onError(String str, Throwable th) {
                    new Handler(Looper.getMainLooper()).post(new r(this, 0));
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onProgress(String str, long j6, long j7, boolean z6) {
                    int i5 = (int) ((j6 / j7) * 100.0f);
                    if (AttributeTextFontFragment.this.fontDownloadProgressDialog != null) {
                        AttributeTextFontFragment.this.fontDownloadProgressDialog.a(i5);
                    }
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onStart(com.appdev.standard.util.fileDownload.a aVar) {
                    new Handler(Looper.getMainLooper()).post(new r(this, 1));
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onSuccess(String str) {
                    textFontModel.setLocalFilePath(this.val$targetFile.getAbsolutePath());
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    AttributeTextFontFragment.this.applyFontToAllElements(textFontModel);
                }
            }

            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                File file = new File(androidx.collection.a.o(AttributeTextFontFragment.this.getFrameActivity().getCacheDir() + "/fontData/", textFontModel.getFontlibId(), ".ttf"));
                if (file.exists()) {
                    textFontModel.setLocalFilePath(file.getAbsolutePath());
                    AttributeTextFontFragment.this.applyFontToAllElements(textFontModel);
                } else {
                    com.appdev.standard.util.fileDownload.g.b().b.add(new AnonymousClass1(file));
                    com.appdev.standard.util.fileDownload.g.b().a(file, textFontModel.getFileUrl());
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void importFontFromUri(Uri uri) {
        try {
            String fontFileNameFromUri = getFontFileNameFromUri(uri);
            if (fontFileNameFromUri == null) {
                p042h2.d.show(p113u.g.text_519);
                return;
            }
            String lowerCase = fontFileNameFromUri.toLowerCase();
            if (!lowerCase.endsWith(".ttf") && !lowerCase.endsWith(".otf")) {
                p042h2.d.show(p113u.g.invalid_font_file);
                return;
            }
            File fontStorageDir = getFontStorageDir();
            if (!fontStorageDir.exists()) {
                fontStorageDir.mkdirs();
            }
            File file = new File(fontStorageDir, fontFileNameFromUri);
            InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i5 = inputStreamOpenInputStream.read(bArr);
                        if (i5 <= 0) {
                            fileOutputStream.close();
                            inputStreamOpenInputStream.close();
                            String strReplaceAll = fontFileNameFromUri.replaceAll("\\.(ttf|otf)$", "");
                            TextFontModel textFontModel = new TextFontModel();
                            textFontModel.setFontlibId("custom_" + strReplaceAll + System.currentTimeMillis());
                            textFontModel.setName(strReplaceAll);
                            textFontModel.setLocalFilePath(file.getAbsolutePath());
                            textFontModel.setDownload(true);
                            saveImportedFont(textFontModel);
                            this.quickAdapter.add(textFontModel);
                            this.quickAdapter.notifyDataSetChanged();
                            p042h2.d.show(p113u.g.font_import_success);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i5);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
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
            p051j0.a.e("FontImport", "导入失败", e);
            p042h2.d.show(p113u.g.font_import_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyFontToAllElements$4(PrinterLabelTextView printerLabelTextView, TextFontModel textFontModel) {
        try {
            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
            elementAttributeTextBean.setFontType(textFontModel.getFontlibId());
            if (textFontModel.getLocalFilePath() != null) {
                elementAttributeTextBean.setFontPath(textFontModel.getLocalFilePath());
            } else if (textFontModel.getFontlibId().startsWith("custom_")) {
                String strSubstring = textFontModel.getFontlibId().substring(7);
                File file = new File(getFontStorageDir(), strSubstring + ".ttf");
                File file2 = new File(getFontStorageDir(), strSubstring + ".otf");
                if (file.exists()) {
                    elementAttributeTextBean.setFontPath(file.getAbsolutePath());
                } else if (file2.exists()) {
                    elementAttributeTextBean.setFontPath(file2.getAbsolutePath());
                }
            }
            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
        } catch (Exception e) {
            p051j0.a.e("ContentValues", "Error applying font", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$1(View view) {
        this.mCustomPopWindow.a();
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "application/x-font-ttf", "application/x-font-otf"});
        startActivityForResult(intent, 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$2(View view) {
        this.mCustomPopWindow.a();
        Intent launchIntentForPackage = getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
        } else {
            p042h2.d.show(p113u.g.toast_6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$3(View view) {
        this.mCustomPopWindow.a();
        Intent launchIntentForPackage = getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
        } else {
            p042h2.d.show(p113u.g.text_463);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$0(View view) {
        showImportFontDialog();
    }

    private void loadImportedFonts() {
        List<TextFontModel> list = (List) Hawk.get(IMPORTED_FONTS, null);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = this.quickAdapter.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(((TextFontModel) it.next()).getFontlibId());
            }
            for (TextFontModel textFontModel : list) {
                if (!arrayList.contains(textFontModel.getFontlibId())) {
                    this.quickAdapter.add(textFontModel);
                }
            }
            this.quickAdapter.notifyDataSetChanged();
        }
    }

    private void saveImportedFont(TextFontModel textFontModel) {
        List list = (List) Hawk.get(IMPORTED_FONTS, new ArrayList());
        list.add(textFontModel);
        Hawk.put(IMPORTED_FONTS, list);
    }

    private void showImportFontDialog() {
        if (!p042h2.e.f4031a.h()) {
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
            defaultTipDialog.e("");
            defaultTipDialog.c(getString(p113u.g.text_248));
            defaultTipDialog.b(getString(p113u.g.text_256));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextFontFragment.2
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
            return;
        }
        View rootView = getActivity().getWindow().getDecorView().getRootView();
        View viewInflate = LayoutInflater.from(getContext()).inflate(p113u.e.pop_font_import, (ViewGroup) null);
        handleLogic(viewInflate);
        C0450c c0450c = new C0450c(getContext());
        c0450c.f2639a.e = viewInflate;
        c0450c.b(-2);
        C0451d c0451d = c0450c.f2639a;
        c0451d.d = true;
        c0451d.f2643h = true;
        C0451d c0451dA = c0450c.a();
        c0451dA.b(rootView);
        this.mCustomPopWindow = c0451dA;
    }

    private void updateFontSelection(TextFontModel textFontModel) {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            TextFontModel textFontModel2 = (TextFontModel) it.next();
            textFontModel2.setSelect(textFontModel2.getFontlibId().equals(textFontModel.getFontlibId()));
        }
        this.quickAdapter.notifyDataSetChanged();
    }

    @Override // J.a
    public void getAppFontLibFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // J.a
    public void getAppFontLibSuccess(List<TextFontModel> list) {
        p050j.w.c();
        this.quickAdapter.clear();
        this.quickAdapter.addAll(com.bumptech.glide.h.b(getFrameActivity()));
        this.quickAdapter.addAll(list);
        loadImportedFonts();
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        J.b bVar = new J.b(getContext());
        this.textFontWorker = bVar;
        addPresenter(bVar);
        this.tvImportFont.setOnClickListener(new q(this, 0));
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_attribute_text_font) { // from class: com.appdev.standard.page.printerlabel.AttributeTextFontFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, TextFontModel textFontModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_attribute_text_font_content);
                textView.setText(textFontModel.getName());
                textView.setBackgroundResource(textFontModel.isSelect() ? p113u.c.bg_fff3da_rad_6_stroke_ffae00 : p113u.c.bg_f8f8f8_rad_6);
            }
        };
        this.rvAttributeTextFont.setLayoutManager(new GridLayoutManager(getContext(), LanguageUtils.isCJKLanguage(getContext()) ? 3 : 2));
        this.rvAttributeTextFont.setAdapter(this.quickAdapter);
        PrinterLabelTextView printerLabelTextView = this.referenceTextView;
        if (printerLabelTextView != null) {
            try {
                this.referenceBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
            } catch (Exception e) {
                p051j0.a.e("ContentValues", "Error parsing text attributes", e);
            }
        }
        List<TextFontModel> list = (List) Hawk.get("FONT_LIB_DATA", null);
        this.textFontModels = list;
        if (list == null) {
            p050j.w.e();
            this.textFontWorker.a();
        } else {
            this.quickAdapter.clear();
            this.quickAdapter.addAll(com.bumptech.glide.h.b(getFrameActivity()));
            this.quickAdapter.addAll(this.textFontModels);
            loadImportedFonts();
        }
        if (this.referenceBean != null) {
            Iterator<Object> it = this.quickAdapter.getData().iterator();
            while (it.hasNext()) {
                TextFontModel textFontModel = (TextFontModel) it.next();
                if (textFontModel.getFontlibId().equals(String.valueOf(this.referenceBean.getFontType()))) {
                    textFontModel.setSelect(true);
                    this.quickAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_text_font;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1001 && i6 == -1 && intent != null) {
            if (p042h2.e.f4031a.h()) {
                importFontFromUri(intent.getData());
                return;
            }
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
            defaultTipDialog.e("");
            defaultTipDialog.c(getString(p113u.g.text_248));
            defaultTipDialog.b(getString(p113u.g.text_256));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextFontFragment.3
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
        }
    }

    @S4.k(sticky = true, threadMode = ThreadMode.MAIN)
    public void onFontImportedEvent(p137y.p pVar) {
        S4.d.b().k(pVar);
        TextFontModel textFontModel = pVar.f9019a;
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            if (((TextFontModel) it.next()).getFontlibId().equals(textFontModel.getFontlibId())) {
                return;
            }
        }
        List list = (List) Hawk.get(IMPORTED_FONTS, new ArrayList());
        list.add(textFontModel);
        Hawk.put(IMPORTED_FONTS, list);
        this.quickAdapter.add(textFontModel);
        this.quickAdapter.notifyDataSetChanged();
    }

    @Override // com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        S4.d.b().j(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        S4.d.b().m(this);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.AttributeTextFontFragment.4
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                TextFontModel textFontModel = (TextFontModel) AttributeTextFontFragment.this.quickAdapter.getItem(i5);
                if ("0".equals(textFontModel.getFontlibId()) || textFontModel.getFontlibId().startsWith("custom_") || textFontModel.getFontlibId().startsWith(ProcessIdUtil.DEFAULT_PROCESSID)) {
                    AttributeTextFontFragment.this.applyFontToAllElements(textFontModel);
                    return;
                }
                try {
                    Integer.parseInt(textFontModel.getFontlibId());
                    AttributeTextFontFragment.this.handleNetworkFont(textFontModel);
                } catch (NumberFormatException unused) {
                    AttributeTextFontFragment.this.applyFontToAllElements(textFontModel);
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    public AttributeTextFontFragment(BaseControlView baseControlView) {
        ArrayList arrayList = new ArrayList();
        this.baseControlViews = arrayList;
        if (baseControlView instanceof PrinterLabelTextView) {
            this.referenceTextView = (PrinterLabelTextView) baseControlView;
            arrayList.add(baseControlView);
        }
    }
}
