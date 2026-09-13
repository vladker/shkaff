package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.SpeechRecognizer;
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
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextDataFragment extends com.library.base.frame.f {
    private ActivityResultLauncher<Intent> asrLauncher;
    private ElementAttributeTextBean elementAttributeTextBean;
    private ActivityResultLauncher<Intent> orcGetImageLauncher;
    private PrinterLabelTextView printerLabelTextView;
    private SpeechRecognizer speechRecognizer;

    @BindView(6032)
    TextView tvAttributeTextContent;
    private p056k0.i mediaPicker = new p056k0.i();
    private p056k0.b resultReceiver = new p056k0.b();

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTextDataFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContentEditDialog contentEditDialog = new ContentEditDialog(AttributeTextDataFragment.this.getContext(), 3);
            contentEditDialog.a(AttributeTextDataFragment.this.elementAttributeTextBean.getContent());
            contentEditDialog.show();
            contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeTextDataFragment.1.1
                @Override // com.appdev.standard.dialog.InterfaceC0453f
                public void setNewContent(final String str) {
                    AttributeTextDataFragment.this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextDataFragment.1.1.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json = AttributeTextDataFragment.this.printerLabelTextView.getJson();
                            AttributeTextDataFragment.this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                            AttributeTextDataFragment.this.tvAttributeTextContent.setText(str);
                            AttributeTextDataFragment.this.elementAttributeTextBean.setContent(str);
                            AttributeTextDataFragment.this.printerLabelTextView.recoverFromJson(AttributeTextDataFragment.this.elementAttributeTextBean.ObjectToJson());
                        }
                    });
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTextDataFragment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements p026e2.a {
        public AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRequestPermissionSuccess$0(HashMap map, String str) {
            HashMap map2 = new HashMap();
            map.put("image", str);
            AttributeTextDataFragment.this.orcGetImageLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("image_cropper").urlParams(map2).build(FlutterBoost.instance().currentActivity()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRequestPermissionSuccess$1(HashMap map, ActivityResult activityResult) {
            if (activityResult.getResultCode() == -1) {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0482n(this, map, (String) activityResult.getData().getSerializableExtra(com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY), 0), 200L);
            }
        }

        @Override // p026e2.a
        public void onRequestPermissionFail() {
            p042h2.d.show(p113u.g.toast_3);
        }

        @Override // p026e2.a
        public void onRequestPermissionSuccess() {
            try {
                HashMap map = new HashMap();
                map.put("title", AttributeTextDataFragment.this.getString(p113u.g.text_236));
                AttributeTextDataFragment.this.resultReceiver.startActivityForResult(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("take_photo").urlParams(map).build(AttributeTextDataFragment.this.getActivity()), new o(this, map));
            } catch (Exception e) {
                p051j0.a.e("AttributeTextDataFragment", "", e);
            }
        }
    }

    public AttributeTextDataFragment(BaseControlView baseControlView) {
        this.printerLabelTextView = (PrinterLabelTextView) baseControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(String str) {
        this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.printerLabelTextView.getJson().toString());
        this.tvAttributeTextContent.setText(str);
        this.elementAttributeTextBean.setContent(str);
        this.printerLabelTextView.recoverFromJson(this.elementAttributeTextBean.ObjectToJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(Text text) {
        this.printerLabelTextView.runWithTemplateEdit(new C0480l(this, text.getText(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onViewCreated$2(Exception exc) {
        p051j0.a.e("AttributeTextDataFragment", "Text recognition failed", exc);
        p042h2.d.show(p113u.g.text_485);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("imagePath")) == null || str.isEmpty()) {
            return;
        }
        TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build()).process(InputImage.fromBitmap(com.bumptech.glide.g.f(str), 0)).addOnSuccessListener(new C0481m(this, 2)).addOnFailureListener(new y(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$4(String str) {
        this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.printerLabelTextView.getJson().toString());
        this.tvAttributeTextContent.setText(str);
        this.elementAttributeTextBean.setContent(str);
        this.printerLabelTextView.recoverFromJson(this.elementAttributeTextBean.ObjectToJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$5(ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("text")) == null || str.isEmpty()) {
            return;
        }
        this.printerLabelTextView.runWithTemplateEdit(new C0480l(this, str, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectPicture$6(Uri uri) {
        try {
            HashMap map = new HashMap();
            map.put("image", uri.toString());
            this.orcGetImageLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("image_cropper").urlParams(map).build(FlutterBoost.instance().currentActivity()));
        } catch (Exception e) {
            p051j0.a.e("ElementAllFragment", "", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectPicture$7(Uri uri) {
        if (uri == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new x(this, uri, 1), 200L);
    }

    private void startListening() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", "zh-CN");
        this.speechRecognizer.startListening(intent);
    }

    public void camera() {
        getFrameActivity().needCameraPermission(new PermissionTipDialog(getFrameActivity(), getString(p113u.g.camera_permission)), new AnonymousClass3());
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        this.elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.printerLabelTextView.getJson().toString());
        this.tvAttributeTextContent.setText(this.printerLabelTextView.getCommonContent());
        this.tvAttributeTextContent.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_text_data;
    }

    @OnClick({5342})
    public void onASRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_487)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTextDataFragment.5
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeTextDataFragment.this.asrLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("acr_page").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z6) {
        super.onHiddenChanged(z6);
        if (z6) {
            return;
        }
        ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.printerLabelTextView.getJson().toString());
        this.elementAttributeTextBean = elementAttributeTextBean;
        if (elementAttributeTextBean.getInputDataType() != 0) {
            this.printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextDataFragment.2
                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                public void run() {
                    AttributeTextDataFragment.this.elementAttributeTextBean.setInputDataType(0);
                    AttributeTextDataFragment.this.elementAttributeTextBean.setContent(AttributeTextDataFragment.this.printerLabelTextView.getCommonContent());
                    AttributeTextDataFragment.this.printerLabelTextView.recoverFromJson(AttributeTextDataFragment.this.elementAttributeTextBean.ObjectToJson());
                }
            });
        }
    }

    @OnClick({5348})
    public void onOCRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.CAMERA"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_486)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTextDataFragment.4
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeTextDataFragment.this.orcGetImageLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("ocr_get_image").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @Override // com.library.base.frame.f, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mediaPicker.attachToActivity(this);
        this.resultReceiver.attachToActivity(this);
        this.orcGetImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0481m(this, 0));
        this.asrLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0481m(this, 1));
    }

    public void selectPicture() {
        p051j0.a.k("TAG", "getFrameActivity()=" + getFrameActivity());
        if (getFrameActivity() == null) {
            return;
        }
        this.mediaPicker.pick(new C0481m(this, 3));
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
