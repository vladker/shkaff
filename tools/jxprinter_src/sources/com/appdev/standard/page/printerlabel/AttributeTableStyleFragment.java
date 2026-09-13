package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.model.ElementAttributeTableBean;
import com.appdev.standard.model.ElementAttributeTableChildBean;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Y;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTableStyleFragment extends com.library.base.frame.f implements J.a {
    private static final String FONT_DIR_NAME = "fonts";
    private static final String IMPORTED_FONTS = "imported_fonts";
    private static final int REQUEST_CODE_IMPORT_FONT = 1001;

    @BindView(4968)
    View clTableFontTypeContainer;
    private ElementAttributeTableBean elementAttributeTableBean;

    @BindView(5189)
    ImageView ivAttributeTextStyleBold;

    @BindView(5190)
    ImageView ivAttributeTextStyleCenter;

    @BindView(5191)
    ImageView ivAttributeTextStyleItalic;

    @BindView(5192)
    ImageView ivAttributeTextStyleLeft;

    @BindView(5193)
    ImageView ivAttributeTextStyleRight;

    @BindView(5195)
    ImageView ivAttributeTextStyleStrikethrough;

    @BindView(5196)
    ImageView ivAttributeTextStyleUnderline;

    @BindView(5504)
    LinearLayout llTableFontSize;

    @BindView(5505)
    LinearLayout llTableFontStyle;

    @BindView(5506)
    LinearLayout llTableRowCol;

    @BindView(5507)
    LinearLayout llTableRowHeightColWidth;

    @BindView(5539)
    LineProgressWidget lpwTableColCount;

    @BindView(5540)
    LineProgressWidget lpwTableColWidth;

    @BindView(5541)
    LineProgressWidget lpwTableFontSize;

    @BindView(5542)
    LineProgressWidget lpwTableLineSize;

    @BindView(5543)
    LineProgressWidget lpwTableLinesSpace;

    @BindView(5544)
    LineProgressWidget lpwTableRowCount;

    @BindView(5545)
    LineProgressWidget lpwTableRowHeight;

    @BindView(5546)
    LineProgressWidget lpwTableWordSpace;
    private C0451d mCustomPopWindow;
    private PrinterLabelTableView printerLabelTableView;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5853)
    RecyclerView rvTableFontType;
    private List<TextFontModel> textFontModels;
    private J.b textFontWorker;

    @BindView(6266)
    TextView tvTableImportFont;

    @BindView(6267)
    TextView tvTableStyleFont;

    @BindView(6268)
    TextView tvTableStyleFontType;

    @BindView(6269)
    TextView tvTableStyleRowCol;

    @BindView(6270)
    TextView tvTableStyleRowHeightColWidth;

    @BindView(6271)
    TextView tvTableStyleStyle;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass10 implements LineProgressWidget.OnRangeUpListener {
        public AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onRangeUp$0(float f6) {
            return AttributeTableStyleFragment.this.printerLabelTableView.setLinesSpace(f6);
        }

        @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
        public void onRangeUp(float f6) {
            AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0478j(this, f6, 0));
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements LineProgressWidget.OnRangeUpListener {
        public AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onRangeUp$0(float f6) {
            int i5 = (int) f6;
            if (i5 > AttributeTableStyleFragment.this.printerLabelTableView.getRowsNum()) {
                return AttributeTableStyleFragment.this.printerLabelTableView.addRowOnTableBottom(i5 - AttributeTableStyleFragment.this.printerLabelTableView.getRowsNum());
            }
            if (i5 < AttributeTableStyleFragment.this.printerLabelTableView.getRowsNum()) {
                return AttributeTableStyleFragment.this.printerLabelTableView.removeRowOnTableBottom(AttributeTableStyleFragment.this.printerLabelTableView.getRowsNum() - i5);
            }
            return false;
        }

        @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
        public void onRangeUp(float f6) {
            AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0478j(this, f6, 1));
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements LineProgressWidget.OnRangeUpListener {
        public AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onRangeUp$0(float f6) {
            int i5 = (int) f6;
            if (i5 > AttributeTableStyleFragment.this.printerLabelTableView.getColumnsNum()) {
                return AttributeTableStyleFragment.this.printerLabelTableView.addColumnOnTableRight(i5 - AttributeTableStyleFragment.this.printerLabelTableView.getColumnsNum());
            }
            if (i5 < AttributeTableStyleFragment.this.printerLabelTableView.getColumnsNum()) {
                return AttributeTableStyleFragment.this.printerLabelTableView.removeColumnOnTableRight(AttributeTableStyleFragment.this.printerLabelTableView.getColumnsNum() - i5);
            }
            return false;
        }

        @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
        public void onRangeUp(float f6) {
            AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0478j(this, f6, 2));
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass9 implements LineProgressWidget.OnRangeUpListener {
        public AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onRangeUp$0(float f6) {
            return AttributeTableStyleFragment.this.printerLabelTableView.setWordSpace(f6);
        }

        @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
        public void onRangeUp(float f6) {
            AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0478j(this, f6, 3));
        }
    }

    public AttributeTableStyleFragment(BaseControlView baseControlView) {
        this.printerLabelTableView = (PrinterLabelTableView) baseControlView;
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
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0476h(this, 0));
        viewFindViewById2.setOnClickListener(new ViewOnClickListenerC0476h(this, 1));
        viewFindViewById3.setOnClickListener(new ViewOnClickListenerC0476h(this, 2));
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
    public /* synthetic */ void lambda$handleLogic$6(View view) {
        this.mCustomPopWindow.a();
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "application/x-font-ttf", "application/x-font-otf"});
        startActivityForResult(intent, 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$7(View view) {
        this.mCustomPopWindow.a();
        Intent launchIntentForPackage = getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
        } else {
            p042h2.d.show(p113u.g.toast_6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$8(View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onBoldClick$1() {
        boolean zIsBold = this.printerLabelTableView.isBold();
        if (!this.printerLabelTableView.setBold(!zIsBold)) {
            return false;
        }
        if (zIsBold) {
            this.ivAttributeTextStyleBold.setBackground(null);
            return true;
        }
        this.ivAttributeTextStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onItalicClick$2() {
        boolean zIsItalic = this.printerLabelTableView.isItalic();
        if (!this.printerLabelTableView.setItalic(!zIsItalic)) {
            return false;
        }
        if (zIsItalic) {
            this.ivAttributeTextStyleItalic.setBackground(null);
            return true;
        }
        this.ivAttributeTextStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onStrikethroughClick$4() {
        boolean zIsDeleteLine = this.printerLabelTableView.isDeleteLine();
        if (!this.printerLabelTableView.setDeleteLine(!zIsDeleteLine)) {
            return false;
        }
        if (zIsDeleteLine) {
            this.ivAttributeTextStyleStrikethrough.setBackground(null);
            return true;
        }
        this.ivAttributeTextStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onUnderlineClick$3() {
        boolean zIsUnderLine = this.printerLabelTableView.isUnderLine();
        if (!this.printerLabelTableView.setUnderLine(!zIsUnderLine)) {
            return false;
        }
        if (zIsUnderLine) {
            this.ivAttributeTextStyleUnderline.setBackground(null);
            return true;
        }
        this.ivAttributeTextStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setTextAlignment$5(int i5) {
        if (!this.printerLabelTableView.setAlignment(i5)) {
            return false;
        }
        if (i5 == 0) {
            this.ivAttributeTextStyleLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else if (i5 == 1) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else if (i5 == 2) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        }
        return true;
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

    private void setTextAlignment(final int i5) {
        this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTaskWithResult() { // from class: com.appdev.standard.page.printerlabel.i
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTaskWithResult
            public final boolean run() {
                return this.f2732a.lambda$setTextAlignment$5(i5);
            }
        });
    }

    private void showImportFontDialog() {
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
        S4.d.b().j(this);
        J.b bVar = new J.b(getContext());
        this.textFontWorker = bVar;
        addPresenter(bVar);
        this.tvTableImportFont.setOnClickListener(new ViewOnClickListenerC0476h(this, 3));
        JSONObject json = this.printerLabelTableView.getJson();
        System.out.println(json);
        ElementAttributeTableBean elementAttributeTableBean = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
        this.elementAttributeTableBean = elementAttributeTableBean;
        List listB = p052j2.c.b(elementAttributeTableBean.getTableData(), List.class);
        if (listB != null && listB.size() != 0) {
            this.lpwTableRowCount.setPosition(listB.size());
            this.lpwTableColCount.setPosition(((List) listB.get(0)).size());
        }
        this.lpwTableLineSize.setPosition(this.elementAttributeTableBean.getLineSize());
        ElementAttributeTableChildBean elementAttributeTableChildBean = (ElementAttributeTableChildBean) p052j2.c.d(((List) listB.get(0)).get(0), ElementAttributeTableChildBean.class);
        this.lpwTableRowHeight.setPosition(elementAttributeTableChildBean.getRowsHeight());
        this.lpwTableColWidth.setPosition(elementAttributeTableChildBean.getColumnsWidth());
        this.lpwTableFontSize.setPosition(elementAttributeTableChildBean.getFontSize() / 10.0f);
        this.lpwTableWordSpace.setPosition(elementAttributeTableChildBean.getWordSpace());
        this.lpwTableLinesSpace.setPosition(elementAttributeTableChildBean.getLinesSpace());
        if (elementAttributeTableChildBean.isIsBold()) {
            this.ivAttributeTextStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleBold.setBackground(null);
        }
        if (elementAttributeTableChildBean.isIsItalic()) {
            this.ivAttributeTextStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleItalic.setBackground(null);
        }
        if (elementAttributeTableChildBean.isIsUnderLine()) {
            this.ivAttributeTextStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleUnderline.setBackground(null);
        }
        if (elementAttributeTableChildBean.isIsDeleteLine()) {
            this.ivAttributeTextStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleStrikethrough.setBackground(null);
        }
        int aligment = elementAttributeTableChildBean.getAligment();
        if (aligment == 0) {
            this.ivAttributeTextStyleLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else if (aligment == 1) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else if (aligment == 2) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        }
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_attribute_text_font) { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, TextFontModel textFontModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_attribute_text_font_content);
                textView.setText(textFontModel.getName());
                if (textFontModel.isSelect()) {
                    textView.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    textView.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
            }
        };
        this.rvTableFontType.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.rvTableFontType.setAdapter(this.quickAdapter);
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
            Iterator<Object> it = this.quickAdapter.getData().iterator();
            while (it.hasNext()) {
                TextFontModel textFontModel = (TextFontModel) it.next();
                if (textFontModel.getFontlibId().equals(String.valueOf(elementAttributeTableChildBean.getFontId()))) {
                    textFontModel.setSelect(true);
                    this.quickAdapter.notifyDataSetChanged();
                    break;
                }
            }
        }
        refreshStatus(-1, -1);
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.quickAdapter.setOnItemClickListener(new AnonymousClass2());
        this.lpwTableRowCount.setOnRangeUpListener(new AnonymousClass3());
        this.lpwTableColCount.setOnRangeUpListener(new AnonymousClass4());
        this.lpwTableLineSize.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.5
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.5.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeTableStyleFragment.this.printerLabelTableView.setLineSize(f6);
                    }
                });
            }
        });
        this.lpwTableRowHeight.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.6
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.6.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeTableStyleFragment.this.printerLabelTableView.setRowHeight(f6);
                    }
                });
            }
        });
        this.lpwTableColWidth.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.7
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.7.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeTableStyleFragment.this.printerLabelTableView.setColWidth(f6);
                    }
                });
            }
        });
        this.lpwTableFontSize.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.8
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment.8.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeTableStyleFragment.this.printerLabelTableView.getJson();
                        AttributeTableStyleFragment.this.printerLabelTableView.setTempFontSize(Integer.valueOf((int) (f6 * 10.0f)));
                        AttributeTableStyleFragment.this.printerLabelTableView.setFontSize((int) (f6 * 10.0f));
                    }
                });
            }
        });
        this.lpwTableWordSpace.setOnRangeUpListener(new AnonymousClass9());
        this.lpwTableLinesSpace.setOnRangeUpListener(new AnonymousClass10());
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_table_style;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1001 && i6 == -1 && intent != null) {
            importFontFromUri(intent.getData());
        }
    }

    @OnClick({5189})
    public void onBoldClick(View view) {
        this.printerLabelTableView.runWithTemplateEdit(new C0475g(this, 3));
    }

    @OnClick({5190})
    public void onCenterClick(View view) {
        setTextAlignment(1);
    }

    @OnClick({6269, 6270, 6267, 6268, 6271})
    public void onClick(View view) {
        if (view.getId() == p113u.d.tv_table_style_row_col) {
            this.tvTableStyleRowCol.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            TextView textView = this.tvTableStyleRowHeightColWidth;
            Resources resources = getResources();
            int i5 = p113u.a.color_999999;
            textView.setTextColor(resources.getColor(i5));
            this.tvTableStyleFont.setTextColor(getResources().getColor(i5));
            this.tvTableStyleFontType.setTextColor(getResources().getColor(i5));
            this.tvTableStyleStyle.setTextColor(getResources().getColor(i5));
            this.llTableRowCol.setVisibility(0);
            this.llTableRowHeightColWidth.setVisibility(8);
            this.llTableFontSize.setVisibility(8);
            this.clTableFontTypeContainer.setVisibility(8);
            this.llTableFontStyle.setVisibility(8);
            return;
        }
        if (view.getId() == p113u.d.tv_table_style_row_height_col_width) {
            TextView textView2 = this.tvTableStyleRowCol;
            Resources resources2 = getResources();
            int i6 = p113u.a.color_999999;
            textView2.setTextColor(resources2.getColor(i6));
            this.tvTableStyleRowHeightColWidth.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvTableStyleFont.setTextColor(getResources().getColor(i6));
            this.tvTableStyleFontType.setTextColor(getResources().getColor(i6));
            this.tvTableStyleStyle.setTextColor(getResources().getColor(i6));
            this.llTableRowCol.setVisibility(8);
            this.llTableRowHeightColWidth.setVisibility(0);
            this.llTableFontSize.setVisibility(8);
            this.clTableFontTypeContainer.setVisibility(8);
            this.llTableFontStyle.setVisibility(8);
            return;
        }
        if (view.getId() == p113u.d.tv_table_style_font) {
            TextView textView3 = this.tvTableStyleRowCol;
            Resources resources3 = getResources();
            int i7 = p113u.a.color_999999;
            textView3.setTextColor(resources3.getColor(i7));
            this.tvTableStyleRowHeightColWidth.setTextColor(getResources().getColor(i7));
            this.tvTableStyleFont.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvTableStyleFontType.setTextColor(getResources().getColor(i7));
            this.tvTableStyleStyle.setTextColor(getResources().getColor(i7));
            this.llTableRowCol.setVisibility(8);
            this.llTableRowHeightColWidth.setVisibility(8);
            this.llTableFontSize.setVisibility(0);
            this.clTableFontTypeContainer.setVisibility(8);
            this.llTableFontStyle.setVisibility(8);
            return;
        }
        if (view.getId() == p113u.d.tv_table_style_font_type) {
            TextView textView4 = this.tvTableStyleRowCol;
            Resources resources4 = getResources();
            int i8 = p113u.a.color_999999;
            textView4.setTextColor(resources4.getColor(i8));
            this.tvTableStyleRowHeightColWidth.setTextColor(getResources().getColor(i8));
            this.tvTableStyleFont.setTextColor(getResources().getColor(i8));
            this.tvTableStyleFontType.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvTableStyleStyle.setTextColor(getResources().getColor(i8));
            this.llTableRowCol.setVisibility(8);
            this.llTableRowHeightColWidth.setVisibility(8);
            this.llTableFontSize.setVisibility(8);
            this.clTableFontTypeContainer.setVisibility(0);
            this.llTableFontStyle.setVisibility(8);
            return;
        }
        if (view.getId() == p113u.d.tv_table_style_style) {
            TextView textView5 = this.tvTableStyleRowCol;
            Resources resources5 = getResources();
            int i9 = p113u.a.color_999999;
            textView5.setTextColor(resources5.getColor(i9));
            this.tvTableStyleRowHeightColWidth.setTextColor(getResources().getColor(i9));
            this.tvTableStyleFont.setTextColor(getResources().getColor(i9));
            this.tvTableStyleFontType.setTextColor(getResources().getColor(i9));
            this.tvTableStyleStyle.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llTableRowCol.setVisibility(8);
            this.llTableRowHeightColWidth.setVisibility(8);
            this.llTableFontSize.setVisibility(8);
            this.clTableFontTypeContainer.setVisibility(8);
            this.llTableFontStyle.setVisibility(0);
        }
    }

    @Override // com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        S4.d.b().m(this);
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onEventTableSelect(PrinterLabelTableView.TableSelectEvent tableSelectEvent) {
        String[] strArrSplit = tableSelectEvent.row_col.split(",");
        if (strArrSplit.length == 2) {
            refreshStatus(Integer.valueOf(strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0]).intValue(), Integer.valueOf(strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0]).intValue());
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

    @OnClick({5191})
    public void onItalicClick(View view) {
        this.printerLabelTableView.runWithTemplateEdit(new C0475g(this, 1));
    }

    @OnClick({5192})
    public void onLeftClick(View view) {
        setTextAlignment(0);
    }

    @OnClick({5193})
    public void onRightClick(View view) {
        setTextAlignment(2);
    }

    @OnClick({5195})
    public void onStrikethroughClick(View view) {
        this.printerLabelTableView.runWithTemplateEdit(new C0475g(this, 2));
    }

    @OnClick({5196})
    public void onUnderlineClick(View view) {
        this.printerLabelTableView.runWithTemplateEdit(new C0475g(this, 0));
    }

    public void refreshStatus(int i5, int i6) {
        ElementAttributeTableChildBean selectedChildBean = (i5 <= 0 || i6 <= 0) ? this.printerLabelTableView.getSelectedChildBean() : this.printerLabelTableView.getChildBean(i5, i6);
        if (selectedChildBean == null) {
            return;
        }
        if (selectedChildBean.isIsBold()) {
            this.ivAttributeTextStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleBold.setBackground(null);
        }
        if (selectedChildBean.isIsItalic()) {
            this.ivAttributeTextStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleItalic.setBackground(null);
        }
        if (selectedChildBean.isIsUnderLine()) {
            this.ivAttributeTextStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleUnderline.setBackground(null);
        }
        if (selectedChildBean.isIsDeleteLine()) {
            this.ivAttributeTextStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleStrikethrough.setBackground(null);
        }
        int aligment = selectedChildBean.getAligment();
        if (aligment == 0) {
            this.ivAttributeTextStyleLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else if (aligment == 1) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else if (aligment != 2) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackground(null);
        } else {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        }
        this.lpwTableRowHeight.setPosition(selectedChildBean.getRowsHeight());
        this.lpwTableColWidth.setPosition(selectedChildBean.getColumnsWidth());
        this.lpwTableFontSize.setPosition(selectedChildBean.getFontSize() / 10.0f);
        this.lpwTableWordSpace.setPosition(selectedChildBean.getWordSpace());
        this.lpwTableLinesSpace.setPosition(selectedChildBean.getLinesSpace());
        String fontId = selectedChildBean.getFontId();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ((TextFontModel) it.next()).setSelect(false);
        }
        if (!Y.f(fontId)) {
            Iterator<Object> it2 = this.quickAdapter.getData().iterator();
            while (it2.hasNext()) {
                TextFontModel textFontModel = (TextFontModel) it2.next();
                if (textFontModel.getFontlibId().equals(fontId)) {
                    textFontModel.setSelect(true);
                    break;
                }
            }
        } else if (this.quickAdapter.getData().size() > 0) {
            ((TextFontModel) this.quickAdapter.getItem(0)).setSelect(true);
        }
        this.quickAdapter.notifyDataSetChanged();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass2 implements com.library.base.util.recyclerview.e {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(TextFontModel textFontModel, int i5) {
            if (AttributeTableStyleFragment.this.printerLabelTableView.setFontId(textFontModel.getFontlibId())) {
                Iterator<Object> it = AttributeTableStyleFragment.this.quickAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((TextFontModel) it.next()).setSelect(false);
                }
                ((TextFontModel) AttributeTableStyleFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                AttributeTableStyleFragment.this.quickAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(TextFontModel textFontModel, int i5) {
            if (AttributeTableStyleFragment.this.printerLabelTableView.setFontId(textFontModel.getFontlibId())) {
                Iterator<Object> it = AttributeTableStyleFragment.this.quickAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((TextFontModel) it.next()).setSelect(false);
                }
                ((TextFontModel) AttributeTableStyleFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                AttributeTableStyleFragment.this.quickAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$2(TextFontModel textFontModel, int i5) {
            if (AttributeTableStyleFragment.this.printerLabelTableView.setFontId(textFontModel.getFontlibId())) {
                Iterator<Object> it = AttributeTableStyleFragment.this.quickAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((TextFontModel) it.next()).setSelect(false);
                }
                ((TextFontModel) AttributeTableStyleFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                AttributeTableStyleFragment.this.quickAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemClick(View view, int i5) {
            TextFontModel textFontModel = (TextFontModel) AttributeTableStyleFragment.this.quickAdapter.getItem(i5);
            if (textFontModel.getFontlibId().equals("0") || textFontModel.getFontlibId().equals("-10001") || textFontModel.getFontlibId().equals("-10002") || textFontModel.getFontlibId().equals("-10003") || textFontModel.getFontlibId().equals("-10004") || textFontModel.getFontlibId().equals("-10005") || textFontModel.getFontlibId().equals("-10006")) {
                AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0479k(this, textFontModel, i5, 0));
                return;
            }
            if (textFontModel.getFontlibId().startsWith("custom_")) {
                String localFilePath = textFontModel.getLocalFilePath();
                if (localFilePath == null || !new File(localFilePath).exists()) {
                    p042h2.d.show(p113u.g.font_import_failed);
                    return;
                } else {
                    AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0479k(this, textFontModel, i5, 1));
                    return;
                }
            }
            String str = AttributeTableStyleFragment.this.getFrameActivity().getCacheDir().getAbsolutePath() + "/fontData/";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(androidx.collection.a.o(str, textFontModel.getFontlibId(), ".ttf"));
            if (file2.exists()) {
                AttributeTableStyleFragment.this.printerLabelTableView.runWithTemplateEdit(new C0479k(this, textFontModel, i5, 2));
                return;
            }
            String fileUrl = textFontModel.getFileUrl();
            if (fileUrl == null || fileUrl.isEmpty()) {
                p042h2.d.show(p113u.g.toast_52);
            } else {
                com.appdev.standard.util.fileDownload.g.b().a(file2, fileUrl);
            }
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemLongClick(View view, int i5) {
        }
    }
}
