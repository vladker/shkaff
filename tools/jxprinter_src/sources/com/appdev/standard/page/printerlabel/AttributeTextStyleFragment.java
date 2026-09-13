package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextStyleFragment extends com.library.base.frame.f {
    private List<BaseControlView> baseControlViews;
    private ElementAttributeTextBean elementAttributeTextBean;

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

    @BindView(5194)
    ImageView ivAttributeTextStyleStretch;

    @BindView(5195)
    ImageView ivAttributeTextStyleStrikethrough;

    @BindView(5196)
    ImageView ivAttributeTextStyleUnderline;

    @BindView(5304)
    ImageView ivTextStyleArchCurve;

    @BindView(5305)
    ImageView ivTextStyleHorizontal;

    @BindView(5306)
    ImageView ivTextStyleScrollPair;

    @BindView(5307)
    ImageView ivTextStyleVerticalPair;

    @BindView(5548)
    LineProgressWidget lpwTextSize;
    private PrinterLabelTextView printerLabelTextView;
    private ElementAttributeTextBean referenceBean;
    private PrinterLabelTextView referenceTextView;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 implements BaseControlView.TemplateEditTask {
        final /* synthetic */ int val$direction;
        final /* synthetic */ PrinterLabelTextView val$textView;

        public AnonymousClass1(PrinterLabelTextView printerLabelTextView, int i5) {
            this.val$textView = printerLabelTextView;
            this.val$direction = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(int i5) {
            AttributeTextStyleFragment.this.updateTextLayoutStyleUI(i5);
        }

        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
        public void run() {
            try {
                ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.val$textView.getJson().toString());
                elementAttributeTextBean.setDirection(this.val$direction);
                this.val$textView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                if (this.val$textView != AttributeTextStyleFragment.this.referenceTextView || AttributeTextStyleFragment.this.getActivity() == null) {
                    return;
                }
                AttributeTextStyleFragment.this.getActivity().runOnUiThread(new u(this, this.val$direction, 0));
            } catch (Exception e) {
                p051j0.a.e("StorageUtil", "Error setting text layout", e);
            }
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass7 implements BaseControlView.TemplateEditTask {
        final /* synthetic */ int val$alignment;
        final /* synthetic */ PrinterLabelTextView val$textView;

        public AnonymousClass7(PrinterLabelTextView printerLabelTextView, int i5) {
            this.val$textView = printerLabelTextView;
            this.val$alignment = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(int i5) {
            AttributeTextStyleFragment.this.setAlignmentUI(i5);
        }

        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
        public void run() {
            try {
                ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.val$textView.getJson().toString());
                elementAttributeTextBean.sethAlignment(this.val$alignment);
                this.val$textView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                if (this.val$textView != AttributeTextStyleFragment.this.referenceTextView || AttributeTextStyleFragment.this.getActivity() == null) {
                    return;
                }
                AttributeTextStyleFragment.this.getActivity().runOnUiThread(new u(this, this.val$alignment, 1));
            } catch (Exception e) {
                p051j0.a.e("StorageUtil", "Error setting text alignment", e);
            }
        }
    }

    public AttributeTextStyleFragment(List<BaseControlView> list) {
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

    private void initStyleUI(ElementAttributeTextBean elementAttributeTextBean) {
        this.lpwTextSize.setPosition(elementAttributeTextBean.getTextSize() / 10.0f);
        setViewSelectedState(this.ivAttributeTextStyleBold, elementAttributeTextBean.isBold());
        setViewSelectedState(this.ivAttributeTextStyleItalic, elementAttributeTextBean.isItalic());
        setViewSelectedState(this.ivAttributeTextStyleUnderline, elementAttributeTextBean.isUnderline());
        setViewSelectedState(this.ivAttributeTextStyleStrikethrough, elementAttributeTextBean.isStrikethrough());
        setAlignmentUI(elementAttributeTextBean.gethAlignment());
        updateTextLayoutStyleUI(elementAttributeTextBean.getDirection());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshUI$0(final float f6) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment.2
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        try {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                            elementAttributeTextBean.setTextSize(f6 * 10.0f);
                            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                        } catch (Exception e) {
                            p051j0.a.e("StorageUtil", "Error setting text size", e);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlignmentUI(int i5) {
        this.ivAttributeTextStyleLeft.setBackground(null);
        this.ivAttributeTextStyleCenter.setBackground(null);
        this.ivAttributeTextStyleRight.setBackground(null);
        this.ivAttributeTextStyleStretch.setBackground(null);
        if (i5 == 0) {
            setViewSelectedState(this.ivAttributeTextStyleLeft, true);
            return;
        }
        if (i5 == 1) {
            setViewSelectedState(this.ivAttributeTextStyleCenter, true);
        } else if (i5 == 2) {
            setViewSelectedState(this.ivAttributeTextStyleRight, true);
        } else {
            if (i5 != 4) {
                return;
            }
            setViewSelectedState(this.ivAttributeTextStyleStretch, true);
        }
    }

    private void setTextAlignment(int i5) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new AnonymousClass7(printerLabelTextView, i5));
            }
        }
    }

    private void setTextLayoutStyle(int i5) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new AnonymousClass1(printerLabelTextView, i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewSelectedState(ImageView imageView, boolean z6) {
        if (imageView != null) {
            imageView.setBackgroundResource(z6 ? p113u.c.bg_fff3da_rad_4_stroke_ffae00 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextLayoutStyleUI(int i5) {
        this.ivTextStyleHorizontal.setBackground(null);
        this.ivTextStyleScrollPair.setBackground(null);
        this.ivTextStyleVerticalPair.setBackground(null);
        this.ivTextStyleArchCurve.setBackground(null);
        if (i5 == 0) {
            setViewSelectedState(this.ivTextStyleHorizontal, true);
            return;
        }
        if (i5 == 1) {
            setViewSelectedState(this.ivTextStyleScrollPair, true);
        } else if (i5 == 2) {
            setViewSelectedState(this.ivTextStyleVerticalPair, true);
        } else {
            if (i5 != 3) {
                return;
            }
            setViewSelectedState(this.ivTextStyleArchCurve, true);
        }
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        PrinterLabelTextView printerLabelTextView = this.referenceTextView;
        if (printerLabelTextView == null) {
            p051j0.a.d("StorageUtil", "No valid text view found");
            return;
        }
        try {
            JSONObject json = printerLabelTextView.getJson();
            if (json == null) {
                p051j0.a.d("StorageUtil", "JSON data is null");
                return;
            }
            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
            this.referenceBean = elementAttributeTextBean;
            if (elementAttributeTextBean == null) {
                p051j0.a.d("StorageUtil", "Failed to parse text attributes");
            } else {
                initStyleUI(elementAttributeTextBean);
            }
        } catch (Exception e) {
            p051j0.a.e("StorageUtil", "Error initializing style fragment", e);
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_text_style;
    }

    @OnClick({5304})
    public void onArchCurveStyleClick(View view) {
        p051j0.a.c("DEBUG", "拱门弯曲点击事件触发");
        setTextLayoutStyle(3);
    }

    @OnClick({5189})
    public void onBoldClick(View view) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment.3
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        try {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                            boolean z6 = !elementAttributeTextBean.isBold();
                            elementAttributeTextBean.setBold(z6);
                            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                            if (printerLabelTextView == AttributeTextStyleFragment.this.referenceTextView) {
                                AttributeTextStyleFragment attributeTextStyleFragment = AttributeTextStyleFragment.this;
                                attributeTextStyleFragment.setViewSelectedState(attributeTextStyleFragment.ivAttributeTextStyleBold, z6);
                            }
                        } catch (Exception e) {
                            p051j0.a.e("StorageUtil", "Error setting bold style", e);
                        }
                    }
                });
            }
        }
    }

    @OnClick({5190})
    public void onCenterClick(View view) {
        setTextAlignment(1);
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onControlViewEditEvent(p137y.f fVar) {
        PrinterLabelTextView printerLabelTextView = this.referenceTextView;
        if (printerLabelTextView != null) {
            try {
                ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                this.referenceBean = elementAttributeTextBean;
                this.lpwTextSize.setPosition(elementAttributeTextBean.getTextSize() / 10.0f);
                updateTextLayoutStyleUI(this.referenceBean.getDirection());
            } catch (Exception e) {
                p051j0.a.e("StorageUtil", "Error handling edit event", e);
            }
        }
    }

    @OnClick({5305})
    public void onHorizontalStyleClick(View view) {
        p051j0.a.c("DEBUG", "横向正常点击事件触发");
        setTextLayoutStyle(0);
    }

    @OnClick({5191})
    public void onItalicClick(View view) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment.4
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        try {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                            boolean z6 = !elementAttributeTextBean.isItalic();
                            elementAttributeTextBean.setItalic(z6);
                            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                            if (printerLabelTextView == AttributeTextStyleFragment.this.referenceTextView) {
                                AttributeTextStyleFragment attributeTextStyleFragment = AttributeTextStyleFragment.this;
                                attributeTextStyleFragment.setViewSelectedState(attributeTextStyleFragment.ivAttributeTextStyleItalic, z6);
                            }
                        } catch (Exception e) {
                            p051j0.a.e("StorageUtil", "Error setting italic style", e);
                        }
                    }
                });
            }
        }
    }

    @OnClick({5192})
    public void onLeftClick(View view) {
        setTextAlignment(0);
    }

    @OnClick({5193})
    public void onRightClick(View view) {
        setTextAlignment(2);
    }

    @OnClick({5306})
    public void onScrollPairStyleClick(View view) {
        p051j0.a.c("DEBUG", "横向对联点击事件触发");
        setTextLayoutStyle(1);
    }

    @OnClick({5194})
    public void onStretchClick(View view) {
        setTextAlignment(4);
    }

    @OnClick({5195})
    public void onStrikethroughClick(View view) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment.6
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        try {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                            boolean z6 = !elementAttributeTextBean.isStrikethrough();
                            elementAttributeTextBean.setStrikethrough(z6);
                            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                            if (printerLabelTextView == AttributeTextStyleFragment.this.referenceTextView) {
                                AttributeTextStyleFragment attributeTextStyleFragment = AttributeTextStyleFragment.this;
                                attributeTextStyleFragment.setViewSelectedState(attributeTextStyleFragment.ivAttributeTextStyleStrikethrough, z6);
                            }
                        } catch (Exception e) {
                            p051j0.a.e("StorageUtil", "Error setting strikethrough style", e);
                        }
                    }
                });
            }
        }
    }

    @OnClick({5196})
    public void onUnderlineClick(View view) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment.5
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        try {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                            boolean z6 = !elementAttributeTextBean.isUnderline();
                            elementAttributeTextBean.setUnderline(z6);
                            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                            if (printerLabelTextView == AttributeTextStyleFragment.this.referenceTextView) {
                                AttributeTextStyleFragment attributeTextStyleFragment = AttributeTextStyleFragment.this;
                                attributeTextStyleFragment.setViewSelectedState(attributeTextStyleFragment.ivAttributeTextStyleUnderline, z6);
                            }
                        } catch (Exception e) {
                            p051j0.a.e("StorageUtil", "Error setting underline style", e);
                        }
                    }
                });
            }
        }
    }

    @OnClick({5307})
    public void onVerticalPairStyleClick(View view) {
        p051j0.a.c("DEBUG", "竖向对联点击事件触发");
        setTextLayoutStyle(2);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.lpwTextSize.setOnRangeUpListener(new H(this, 3));
    }

    public AttributeTextStyleFragment(BaseControlView baseControlView) {
        ArrayList arrayList = new ArrayList();
        this.baseControlViews = arrayList;
        if (baseControlView instanceof PrinterLabelTextView) {
            this.referenceTextView = (PrinterLabelTextView) baseControlView;
            arrayList.add(baseControlView);
        }
    }
}
