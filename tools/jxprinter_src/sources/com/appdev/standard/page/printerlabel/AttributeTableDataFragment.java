package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import java.util.HashMap;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTableDataFragment extends com.library.base.frame.f {
    private ActivityResultLauncher<Intent> asrLauncher;
    private String content = "";
    private ActivityResultLauncher<Intent> orcGetImageLauncher;
    private PrinterLabelTableView printerLabelTableView;

    @BindView(6031)
    TextView tvAttributeTableContent;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTableDataFragment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String content = AttributeTableDataFragment.this.printerLabelTableView.getContent();
            if (content == null) {
                content = "";
            }
            ContentEditDialog contentEditDialog = new ContentEditDialog(AttributeTableDataFragment.this.getContext(), 3);
            contentEditDialog.a(content);
            contentEditDialog.show();
            contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment.3.1
                @Override // com.appdev.standard.dialog.InterfaceC0453f
                public void setNewContent(final String str) {
                    AttributeTableDataFragment.this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment.3.1.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            if (AttributeTableDataFragment.this.printerLabelTableView.getTempFontSize() != null) {
                                AttributeTableDataFragment.this.printerLabelTableView.setFontSize(AttributeTableDataFragment.this.printerLabelTableView.getTempFontSize().intValue());
                            }
                            AttributeTableDataFragment.this.printerLabelTableView.setContent(str);
                            AttributeTableDataFragment.this.tvAttributeTableContent.setText(str);
                        }
                    });
                }
            };
        }
    }

    public AttributeTableDataFragment(BaseControlView baseControlView) {
        this.printerLabelTableView = (PrinterLabelTableView) baseControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(Text text) {
        final String text2 = text.getText();
        this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                if (AttributeTableDataFragment.this.printerLabelTableView.getTempFontSize() != null) {
                    AttributeTableDataFragment.this.printerLabelTableView.setFontSize(AttributeTableDataFragment.this.printerLabelTableView.getTempFontSize().intValue());
                }
                AttributeTableDataFragment.this.tvAttributeTableContent.setText(text2);
                AttributeTableDataFragment.this.printerLabelTableView.setContent(text2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onViewCreated$1(Exception exc) {
        p051j0.a.e("AttributeTextDataFragment", "Text recognition failed", exc);
        p042h2.d.show(p113u.g.text_485);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("imagePath")) == null || str.isEmpty()) {
            return;
        }
        TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build()).process(InputImage.fromBitmap(com.bumptech.glide.g.f(str), 0)).addOnSuccessListener(new C0474f(this, 0)).addOnFailureListener(new y(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(ActivityResult activityResult) {
        final String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("text")) == null || str.isEmpty()) {
            return;
        }
        this.printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                if (AttributeTableDataFragment.this.printerLabelTableView.getTempFontSize() != null) {
                    AttributeTableDataFragment.this.printerLabelTableView.setFontSize(AttributeTableDataFragment.this.printerLabelTableView.getTempFontSize().intValue());
                }
                AttributeTableDataFragment.this.tvAttributeTableContent.setText(str);
                AttributeTableDataFragment.this.printerLabelTableView.setContent(str);
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        String content = this.printerLabelTableView.getContent();
        if (content != null) {
            this.tvAttributeTableContent.setText(content);
        }
        S4.d.b().j(this);
        this.tvAttributeTableContent.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_table_data;
    }

    @OnClick({5342})
    public void onASRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_487)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment.5
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeTableDataFragment.this.asrLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("acr_page").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        S4.d.b().m(this);
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onEventTableSelect(PrinterLabelTableView.TableSelectEvent tableSelectEvent) {
        this.content = tableSelectEvent.baseTextView.getContent();
        this.tvAttributeTableContent.setText(tableSelectEvent.baseTextView.getContent());
    }

    @OnClick({5348})
    public void onOCRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.CAMERA"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_486)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment.4
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeTableDataFragment.this.orcGetImageLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("ocr_get_image").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @Override // com.library.base.frame.f, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.orcGetImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0474f(this, 1));
        this.asrLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0474f(this, 2));
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
