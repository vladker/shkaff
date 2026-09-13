package com.appdev.standard.page.printerlabel;

import butterknife.BindView;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextSpacingFragment extends com.library.base.frame.f {
    private List<BaseControlView> baseControlViews;

    @BindView(5547)
    LineProgressWidget lpwTextLinesSpace;

    @BindView(5553)
    LineProgressWidget lpwTextWordSpace;
    private ElementAttributeTextBean referenceBean;
    private PrinterLabelTextView referenceTextView;

    public AttributeTextSpacingFragment(List<BaseControlView> list) {
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

    private void applySpacingToAllElements(final float f6, final float f7) {
        for (BaseControlView baseControlView : this.baseControlViews) {
            if (baseControlView instanceof PrinterLabelTextView) {
                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.s
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public final void run() {
                        AttributeTextSpacingFragment.lambda$applySpacingToAllElements$2(printerLabelTextView, f6, f7);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$applySpacingToAllElements$2(PrinterLabelTextView printerLabelTextView, float f6, float f7) {
        try {
            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
            elementAttributeTextBean.setWordSpace(f6);
            elementAttributeTextBean.setLinesSpace(f7);
            printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
        } catch (Exception e) {
            p051j0.a.e("ContentValues", "Error applying spacing", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshUI$0(float f6) {
        applySpacingToAllElements(f6, this.referenceBean.getLinesSpace());
        this.referenceBean.setWordSpace(f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshUI$1(float f6) {
        applySpacingToAllElements(this.referenceBean.getWordSpace(), f6);
        this.referenceBean.setLinesSpace(f6);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        PrinterLabelTextView printerLabelTextView = this.referenceTextView;
        if (printerLabelTextView == null) {
            p051j0.a.d("ContentValues", "No valid text view found");
            return;
        }
        try {
            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
            this.referenceBean = elementAttributeTextBean;
            this.lpwTextWordSpace.setPosition(elementAttributeTextBean.getWordSpace());
            this.lpwTextLinesSpace.setPosition(this.referenceBean.getLinesSpace());
        } catch (Exception e) {
            p051j0.a.e("ContentValues", "Error initializing spacing fragment", e);
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_text_spacing;
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        final int i5 = 0;
        this.lpwTextWordSpace.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener(this) { // from class: com.appdev.standard.page.printerlabel.t
            public final /* synthetic */ AttributeTextSpacingFragment b;

            {
                this.b = this;
            }

            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public final void onRangeUp(float f6) {
                switch (i5) {
                    case 0:
                        this.b.lambda$refreshUI$0(f6);
                        break;
                    default:
                        this.b.lambda$refreshUI$1(f6);
                        break;
                }
            }
        });
        final int i6 = 1;
        this.lpwTextLinesSpace.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener(this) { // from class: com.appdev.standard.page.printerlabel.t
            public final /* synthetic */ AttributeTextSpacingFragment b;

            {
                this.b = this;
            }

            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public final void onRangeUp(float f6) {
                switch (i6) {
                    case 0:
                        this.b.lambda$refreshUI$0(f6);
                        break;
                    default:
                        this.b.lambda$refreshUI$1(f6);
                        break;
                }
            }
        });
    }

    public AttributeTextSpacingFragment(BaseControlView baseControlView) {
        ArrayList arrayList = new ArrayList();
        this.baseControlViews = arrayList;
        if (baseControlView instanceof PrinterLabelTextView) {
            this.referenceTextView = (PrinterLabelTextView) baseControlView;
            arrayList.add(baseControlView);
        }
    }
}
