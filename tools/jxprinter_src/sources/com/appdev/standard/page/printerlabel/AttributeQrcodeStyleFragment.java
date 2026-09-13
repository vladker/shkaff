package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeQrCodeBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelQrCodeView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeQrcodeStyleFragment extends com.library.base.frame.f {
    private ElementAttributeQrCodeBean elementAttributeQrCodeBean;

    @BindView(5293)
    ImageView ivMore;

    @BindView(5481)
    LinearLayout llFormat;
    private PrinterLabelQrCodeView printerLabelQrCodeView;

    @BindView(6252)
    TextView tvFormat;

    public AttributeQrcodeStyleFragment(BaseControlView baseControlView) {
        this.printerLabelQrCodeView = (PrinterLabelQrCodeView) baseControlView;
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        JSONObject json = this.printerLabelQrCodeView.getJson();
        System.out.println(json);
        ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
        this.elementAttributeQrCodeBean = elementAttributeQrCodeBean;
        this.tvFormat.setText(elementAttributeQrCodeBean.getEncodeRef());
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_qrcode_style;
    }

    @OnClick({5481})
    public void onFormatClick(View view) {
        p097r0.a aVar = new p097r0.a(getContext(), new p109t0.a() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeStyleFragment.1
            @Override // p109t0.a
            public void onOptionsSelect(final int i5, int i6, int i7, View view2) {
                AttributeQrcodeStyleFragment.this.tvFormat.setText((CharSequence) p051j0.a.i().get(i5));
                AttributeQrcodeStyleFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeStyleFragment.1.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeStyleFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeStyleFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeStyleFragment.this.elementAttributeQrCodeBean.setEncodeRef((String) p051j0.a.i().get(i5));
                        AttributeQrcodeStyleFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeStyleFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                    }
                });
            }
        });
        aVar.f7931a.f8190k = getString(p113u.g.text_285);
        aVar.f7931a.f8188i = getString(p113u.g.confirm);
        String string = getResources().getString(p113u.g.cancel);
        p103s0.a aVar2 = aVar.f7931a;
        aVar2.f8189j = string;
        aVar2.f8192m = 14;
        aVar2.f8191l = 14;
        p114u0.d dVarA = aVar.a();
        dVarA.e(p051j0.a.i(), null);
        dVarA.h();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
