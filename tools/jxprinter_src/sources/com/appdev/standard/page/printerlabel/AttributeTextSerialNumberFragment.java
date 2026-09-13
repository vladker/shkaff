package com.appdev.standard.page.printerlabel;

import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import kotlin.jvm.internal.Y;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextSerialNumberFragment extends com.library.base.frame.f {
    private ElementAttributeTextBean elementAttributeTextBean;
    private PrinterLabelTextView printerLabelTextView;

    @BindView(6033)
    TextView tvAttributeTextIncrementalContent;

    @BindView(6034)
    TextView tvAttributeTextInterval;

    @BindView(6035)
    TextView tvAttributeTextPrefix;

    @BindView(6036)
    TextView tvAttributeTextSuffix;

    public AttributeTextSerialNumberFragment(BaseControlView baseControlView) {
        this.printerLabelTextView = (PrinterLabelTextView) baseControlView;
    }

    private void bindSerialFields() {
        String seqContent = this.printerLabelTextView.getSeqContent();
        if (Y.f(seqContent)) {
            this.printerLabelTextView.setSeqContent("1");
            seqContent = "1";
        }
        this.tvAttributeTextIncrementalContent.setText(seqContent);
        this.tvAttributeTextInterval.setText(String.valueOf(this.elementAttributeTextBean.getInterval()));
        this.tvAttributeTextPrefix.setText(this.elementAttributeTextBean.getPrefix());
        this.tvAttributeTextSuffix.setText(this.elementAttributeTextBean.getSuffix());
    }

    private void ensureSerialMode() {
        if (this.elementAttributeTextBean.getInputDataType() == 1) {
            return;
        }
        this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeTextSerialNumberFragment.this.elementAttributeTextBean.setInputDataType(1);
                String seqContent = AttributeTextSerialNumberFragment.this.printerLabelTextView.getSeqContent();
                if (Y.f(seqContent)) {
                    AttributeTextSerialNumberFragment.this.printerLabelTextView.setSeqContent("1");
                    seqContent = "1";
                }
                AttributeTextSerialNumberFragment.this.elementAttributeTextBean.setContent(seqContent);
                AttributeTextSerialNumberFragment.this.tvAttributeTextIncrementalContent.setText(seqContent);
                AttributeTextSerialNumberFragment.this.printerLabelTextView.recoverFromJson(AttributeTextSerialNumberFragment.this.elementAttributeTextBean.ObjectToJson());
            }
        });
    }

    private void refreshElementBean() {
        this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.printerLabelTextView.getJson().toString());
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        refreshElementBean();
        bindSerialFields();
        ensureSerialMode();
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_text_serial_number;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z6) {
        super.onHiddenChanged(z6);
        if (z6) {
            return;
        }
        refreshElementBean();
        bindSerialFields();
        ensureSerialMode();
    }

    @OnClick({6033})
    public void onIncrementalContentClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeTextBean.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.2
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeTextSerialNumberFragment.this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeTextSerialNumberFragment.this.printerLabelTextView.getJson();
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean.setContent(str);
                        AttributeTextSerialNumberFragment.this.printerLabelTextView.recoverFromJson(AttributeTextSerialNumberFragment.this.elementAttributeTextBean.ObjectToJson());
                        AttributeTextSerialNumberFragment.this.tvAttributeTextIncrementalContent.setText(str);
                    }
                });
            }
        };
    }

    @OnClick({6034})
    public void onIntervalClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext(), 2);
        contentEditDialog.a(String.valueOf(this.elementAttributeTextBean.getInterval()));
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.3
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeTextSerialNumberFragment.this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        int i5;
                        JSONObject json = AttributeTextSerialNumberFragment.this.printerLabelTextView.getJson();
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                        try {
                            i5 = Integer.parseInt(str);
                        } catch (Exception unused) {
                            i5 = 1;
                        }
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean.setInterval(i5);
                        AttributeTextSerialNumberFragment.this.printerLabelTextView.recoverFromJson(AttributeTextSerialNumberFragment.this.elementAttributeTextBean.ObjectToJson());
                        AttributeTextSerialNumberFragment.this.tvAttributeTextInterval.setText(str);
                    }
                });
            }
        };
    }

    @OnClick({6035})
    public void onPrefixClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeTextBean.getPrefix());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.4
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeTextSerialNumberFragment.this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.4.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeTextSerialNumberFragment.this.printerLabelTextView.getJson();
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean.setPrefix(str);
                        AttributeTextSerialNumberFragment.this.printerLabelTextView.recoverFromJson(AttributeTextSerialNumberFragment.this.elementAttributeTextBean.ObjectToJson());
                        AttributeTextSerialNumberFragment.this.tvAttributeTextPrefix.setText(str);
                    }
                });
            }
        };
    }

    @OnClick({6036})
    public void onSuffixClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeTextBean.getSuffix());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.5
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeTextSerialNumberFragment.this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment.5.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeTextSerialNumberFragment.this.printerLabelTextView.getJson();
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                        AttributeTextSerialNumberFragment.this.elementAttributeTextBean.setSuffix(str);
                        AttributeTextSerialNumberFragment.this.printerLabelTextView.recoverFromJson(AttributeTextSerialNumberFragment.this.elementAttributeTextBean.ObjectToJson());
                        AttributeTextSerialNumberFragment.this.tvAttributeTextSuffix.setText(str);
                    }
                });
            }
        };
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
