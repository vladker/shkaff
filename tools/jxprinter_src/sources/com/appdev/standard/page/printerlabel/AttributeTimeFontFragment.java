package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.util.LanguageUtils;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTimeView;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTimeFontFragment extends com.library.base.frame.f implements J.a {
    private ElementAttributeTextBean elementAttributeTextBean;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5816)
    RecyclerView rvAttributeTextFont;
    private List<TextFontModel> textFontModels;
    private J.b textFontWorker;
    private PrinterLabelTimeView timeView;

    @BindView(6109)
    TextView tvImportFont;

    public AttributeTimeFontFragment(BaseControlView baseControlView) {
        if (!(baseControlView instanceof PrinterLabelTimeView)) {
            throw new IllegalArgumentException("必须传入 PrinterLabelTimeView 实例");
        }
        this.timeView = (PrinterLabelTimeView) baseControlView;
    }

    private void applyFontDirectly(TextFontModel textFontModel, int i5) {
        this.timeView.runWithTemplateEdit(new C0479k(this, textFontModel, i5, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyFontDirectly$1(TextFontModel textFontModel, int i5) {
        this.elementAttributeTextBean.setFontType(textFontModel.getFontlibId());
        this.timeView.recoverFromJson(this.elementAttributeTextBean.ObjectToJson());
        updateSelection(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$initComponent$0(View view) {
        if (p042h2.e.f4031a.h()) {
            p042h2.d.show(p113u.g.text_519);
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_248));
        defaultTipDialog.b(getString(p113u.g.text_256));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeFontFragment.1
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

    private void updateSelection(int i5) {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ((TextFontModel) it.next()).setSelect(false);
        }
        ((TextFontModel) this.quickAdapter.getItem(i5)).setSelect(true);
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
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        J.b bVar = new J.b(getContext());
        this.textFontWorker = bVar;
        addPresenter(bVar);
        this.tvImportFont.setOnClickListener(new v(this, 0));
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_attribute_text_font) { // from class: com.appdev.standard.page.printerlabel.AttributeTimeFontFragment.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, TextFontModel textFontModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_attribute_text_font_content);
                textView.setText(textFontModel.getName());
                textView.setBackgroundResource(textFontModel.isSelect() ? p113u.c.bg_fff3da_rad_6_stroke_ffae00 : p113u.c.bg_f8f8f8_rad_6);
            }
        };
        this.rvAttributeTextFont.setLayoutManager(new GridLayoutManager(getContext(), LanguageUtils.isCJKLanguage(getContext()) ? 3 : 2));
        this.rvAttributeTextFont.setAdapter(this.quickAdapter);
        this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.timeView.getJson().toString());
        List<TextFontModel> list = (List) Hawk.get("FONT_LIB_DATA", null);
        this.textFontModels = list;
        if (list == null) {
            p050j.w.e();
            this.textFontWorker.a();
            return;
        }
        this.quickAdapter.clear();
        this.quickAdapter.addAll(com.bumptech.glide.h.b(getFrameActivity()));
        this.quickAdapter.addAll(this.textFontModels);
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            TextFontModel textFontModel = (TextFontModel) it.next();
            if (textFontModel.getFontlibId().equals(String.valueOf(this.elementAttributeTextBean.getFontType()))) {
                textFontModel.setSelect(true);
                this.quickAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_text_font;
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.quickAdapter.setOnItemClickListener(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTimeFontFragment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements com.library.base.util.recyclerview.e {
        public AnonymousClass3() {
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemClick(View view, final int i5) {
            final TextFontModel textFontModel = (TextFontModel) AttributeTimeFontFragment.this.quickAdapter.getItem(i5);
            if (Integer.parseInt(textFontModel.getFontlibId()) <= 0) {
                AttributeTimeFontFragment.this.timeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeFontFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeTimeFontFragment.this.timeView.getJson();
                        AttributeTimeFontFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                        AttributeTimeFontFragment.this.elementAttributeTextBean.setFontType(textFontModel.getFontlibId());
                        AttributeTimeFontFragment.this.timeView.recoverFromJson(AttributeTimeFontFragment.this.elementAttributeTextBean.ObjectToJson());
                        Iterator<Object> it = AttributeTimeFontFragment.this.quickAdapter.getData().iterator();
                        while (it.hasNext()) {
                            ((TextFontModel) it.next()).setSelect(false);
                        }
                        ((TextFontModel) AttributeTimeFontFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                        AttributeTimeFontFragment.this.quickAdapter.notifyDataSetChanged();
                    }
                });
            } else {
                AttributeTimeFontFragment.this.getFrameActivity().needStoragePermission(new PermissionTipDialog(AttributeTimeFontFragment.this.getFrameActivity(), AttributeTimeFontFragment.this.getString(p113u.g.text_324)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeFontFragment.3.2
                    @Override // p026e2.a
                    public void onRequestPermissionFail() {
                        p042h2.d.show(p113u.g.toast_3);
                    }

                    @Override // p026e2.a
                    public void onRequestPermissionSuccess() {
                        p051j0.a.d("onRequestPermissionSuccess", "获取权限成功");
                        String str = AttributeTimeFontFragment.this.getFrameActivity().getCacheDir().getAbsolutePath() + "/fontData/";
                        File file = new File(str);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (new File(androidx.collection.a.o(str, textFontModel.getFontlibId(), ".ttf")).exists()) {
                            AttributeTimeFontFragment.this.timeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeFontFragment.3.2.1
                                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                public void run() {
                                    JSONObject json = AttributeTimeFontFragment.this.timeView.getJson();
                                    AttributeTimeFontFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                                    AttributeTimeFontFragment.this.elementAttributeTextBean.setFontType(textFontModel.getFontlibId());
                                    AttributeTimeFontFragment.this.timeView.recoverFromJson(AttributeTimeFontFragment.this.elementAttributeTextBean.ObjectToJson());
                                    Iterator<Object> it = AttributeTimeFontFragment.this.quickAdapter.getData().iterator();
                                    while (it.hasNext()) {
                                        ((TextFontModel) it.next()).setSelect(false);
                                    }
                                    ((TextFontModel) AttributeTimeFontFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                                    AttributeTimeFontFragment.this.quickAdapter.notifyDataSetChanged();
                                }
                            });
                            return;
                        }
                        com.appdev.standard.util.fileDownload.g.b().a(new File(androidx.collection.a.o(str, textFontModel.getFontlibId(), ".ttf")), textFontModel.getFileUrl());
                    }
                });
            }
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemLongClick(View view, int i5) {
        }
    }
}
