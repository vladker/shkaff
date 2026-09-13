package com.appdev.standard.page.printerlabel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.Consts;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.LocalFileModel;
import com.appdev.standard.page.LoadFileActivity;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PDF_FILE_LIST)
public class PDFFileListActivity extends MvpActivity {
    private final int FILE_SELECT_CODE = 1;
    private Context context;
    private C0451d mCustomPopWindow;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5845)
    RecyclerView rvPdfFileListData;

    @BindView(6274)
    TextView tvTitle;

    private void handleLogic(View view) {
        View viewFindViewById = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_file);
        View viewFindViewById2 = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_wechat);
        View viewFindViewById3 = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_qq);
        View viewFindViewById4 = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_dingding);
        View viewFindViewById5 = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_whatsapp);
        View viewFindViewById6 = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_facebook);
        View viewFindViewById7 = view.findViewById(p113u.d.ll_pop_pdf_print_file_import_skype);
        viewFindViewById5.setVisibility(8);
        viewFindViewById6.setVisibility(8);
        viewFindViewById7.setVisibility(8);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation"});
                PDFFileListActivity.this.startActivityForResult(intent, 1);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent launchIntentForPackage = PDFFileListActivity.this.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                if (launchIntentForPackage == null) {
                    p042h2.d.show(p113u.g.toast_6);
                } else {
                    LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_NORMAL);
                    PDFFileListActivity.this.startActivity(launchIntentForPackage);
                }
            }
        });
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent launchIntentForPackage = PDFFileListActivity.this.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                if (launchIntentForPackage == null) {
                    p042h2.d.show(p113u.g.text_463);
                } else {
                    LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_NORMAL);
                    PDFFileListActivity.this.startActivity(launchIntentForPackage);
                }
            }
        });
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent launchIntentForPackage = PDFFileListActivity.this.getPackageManager().getLaunchIntentForPackage("com.alibaba.android.rimet");
                if (launchIntentForPackage == null) {
                    p042h2.d.show(p113u.g.text_464);
                } else {
                    LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_NORMAL);
                    PDFFileListActivity.this.startActivity(launchIntentForPackage);
                }
            }
        });
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent launchIntentForPackage = PDFFileListActivity.this.getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (launchIntentForPackage == null) {
                    p042h2.d.show(p113u.g.text_465);
                } else {
                    LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_NORMAL);
                    PDFFileListActivity.this.startActivity(launchIntentForPackage);
                }
            }
        });
        viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent launchIntentForPackage = PDFFileListActivity.this.getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                if (launchIntentForPackage == null) {
                    p042h2.d.show(p113u.g.text_466);
                } else {
                    LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_NORMAL);
                    PDFFileListActivity.this.startActivity(launchIntentForPackage);
                }
            }
        });
        viewFindViewById7.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PDFFileListActivity.this.mCustomPopWindow.a();
                Intent launchIntentForPackage = PDFFileListActivity.this.getPackageManager().getLaunchIntentForPackage("com.skype.raider");
                if (launchIntentForPackage == null) {
                    p042h2.d.show(p113u.g.text_467);
                } else {
                    LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_NORMAL);
                    PDFFileListActivity.this.startActivity(launchIntentForPackage);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLocalFileList() {
        this.quickAdapter.replaceAll((List) Hawk.get(p035f5.b.g(), new ArrayList()));
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.context = this;
        this.tvTitle.setText(getString(p113u.g.text_237));
        this.quickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_pdf_file_list) { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, LocalFileModel localFileModel) {
                aVar.b(p113u.d.tv_item_pdf_file_list_title, localFileModel.getFileName());
                aVar.b(p113u.d.tv_item_pdf_file_list_time, localFileModel.getTime());
                if (localFileModel.getFileName().endsWith(".pdf")) {
                    int i5 = p113u.d.iv_file_icon;
                    ((ImageView) aVar.a(i5)).setImageResource(p113u.f.ic_pdf_icon);
                    return;
                }
                if (localFileModel.getFileName().endsWith(".doc") || localFileModel.getFileName().endsWith(".docx")) {
                    int i6 = p113u.d.iv_file_icon;
                    ((ImageView) aVar.a(i6)).setImageResource(p113u.f.ic_word);
                    return;
                }
                if (localFileModel.getFileName().endsWith(".ppt") || localFileModel.getFileName().endsWith(".pptx")) {
                    int i7 = p113u.d.iv_file_icon;
                    ((ImageView) aVar.a(i7)).setImageResource(p113u.f.ic_ppt);
                } else if (localFileModel.getFileName().endsWith(".txt")) {
                    int i8 = p113u.d.iv_file_icon;
                    ((ImageView) aVar.a(i8)).setImageResource(p113u.f.ic_text);
                } else if (localFileModel.getFileName().endsWith(".xls") || localFileModel.getFileName().endsWith(".xlsx")) {
                    int i9 = p113u.d.iv_file_icon;
                    ((ImageView) aVar.a(i9)).setImageResource(p113u.f.ic_excel);
                }
            }
        };
        this.rvPdfFileListData.setLayoutManager(new LinearLayoutManager(this));
        this.rvPdfFileListData.setAdapter(this.quickAdapter);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Bundle bundle = new Bundle();
                bundle.putString("fileAbsolutePath", ((LocalFileModel) PDFFileListActivity.this.quickAdapter.getItem(i5)).getFilePath());
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PDF_PRINT).with(bundle).navigation();
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, final int i5) {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(PDFFileListActivity.this.context);
                defaultTipDialog.c(PDFFileListActivity.this.getString(p113u.g.text_245));
                defaultTipDialog.e("");
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.PDFFileListActivity.2.1
                    @Override // com.library.base.frame.d
                    public void onConfirm() {
                        LocalFileModel localFileModel = (LocalFileModel) PDFFileListActivity.this.quickAdapter.getItem(i5);
                        if (localFileModel.getFilePath().startsWith(PDFFileListActivity.this.getExternalFilesDir(null).getAbsolutePath() + File.separator + "docs")) {
                            File file = new File(localFileModel.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        long id = ((LocalFileModel) PDFFileListActivity.this.quickAdapter.getItem(i5)).getId();
                        List<LocalFileModel> list = (List) Hawk.get(p035f5.b.g(), new ArrayList());
                        ArrayList arrayList = new ArrayList();
                        for (LocalFileModel localFileModel2 : list) {
                            if (localFileModel2.getId() != id) {
                                arrayList.add(localFileModel2);
                            }
                        }
                        Hawk.put(p035f5.b.g(), arrayList);
                        p042h2.d.show(p113u.g.toast_39);
                        PDFFileListActivity.this.refreshLocalFileList();
                    }

                    @Override // com.library.base.frame.d
                    public void onCancel() {
                    }
                };
                defaultTipDialog.show();
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_pdf_file_list;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, @Nullable Intent intent) {
        Uri data;
        String strC;
        super.onActivityResult(i5, i6, intent);
        if (i5 != 1 || i6 != -1 || intent == null || (strC = p051j0.i.c(this.context, (data = intent.getData()))) == null) {
            return;
        }
        String strSubstring = strC.substring(0, strC.lastIndexOf(Consts.DOT));
        String strSubstring2 = strC.substring(strC.lastIndexOf(Consts.DOT));
        StringBuilder sb = new StringBuilder();
        sb.append(getExternalFilesDir(null).getAbsolutePath());
        String str = File.separator;
        File file = new File(androidx.exifinterface.media.a.s(sb, str, "docs", str, strC));
        int i7 = 1;
        while (file.exists()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getExternalFilesDir(null).getAbsolutePath());
            String str2 = File.separator;
            androidx.collection.a.y(sb2, str2, "docs", str2, strSubstring);
            sb2.append("(");
            sb2.append(i7);
            sb2.append(")");
            sb2.append(strSubstring2);
            file = new File(sb2.toString());
            strC = strSubstring + "(" + i7 + ")" + strSubstring2;
            i7++;
        }
        p051j0.i.l(this, data, file);
        p035f5.b.a(strC, file.getAbsolutePath());
        refreshLocalFileList();
    }

    public void onPdfFileListAddClick(View view) {
        View rootView = getWindow().getDecorView().getRootView();
        View viewInflate = LayoutInflater.from(this).inflate(p113u.e.pop_pdf_print_file_import, (ViewGroup) null);
        handleLogic(viewInflate);
        C0450c c0450c = new C0450c(this);
        c0450c.f2639a.e = viewInflate;
        c0450c.b(-2);
        C0451d c0451d = c0450c.f2639a;
        c0451d.d = true;
        c0451d.f2643h = true;
        C0451d c0451dA = c0450c.a();
        c0451dA.b(rootView);
        this.mCustomPopWindow = c0451dA;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshLocalFileList();
    }
}
