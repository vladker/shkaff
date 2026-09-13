package com.appdev.standard.page.printerlabel;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAllFragment_ViewBinding implements Unbinder {
    private ElementAllFragment target;
    private View view14fc;
    private View view14fe;
    private View view14ff;
    private View view1500;
    private View view1501;
    private View view1502;
    private View view1503;
    private View view1504;
    private View view1505;
    private View view1506;
    private View view1507;
    private View view1508;

    @UiThread
    public ElementAllFragment_ViewBinding(final ElementAllFragment elementAllFragment, View view) {
        this.target = elementAllFragment;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_text_add, "method 'onElementTextAddClick'");
        this.view1507 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementTextAddClick(view2);
            }
        });
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_barcode_add, "method 'onElementBarcodeAddClick'");
        this.view14fc = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementBarcodeAddClick(view2);
            }
        });
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_qrcode_add, "method 'onElementQrcodeAddClick'");
        this.view1503 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementQrcodeAddClick(view2);
            }
        });
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_shape_add, "method 'onElementShapeAddClick'");
        this.view1504 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementShapeAddClick(view2);
            }
        });
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_picture_add, "method 'onElementPictureAddClick'");
        this.view1502 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementPictureAddClick(view2);
            }
        });
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_icon_add, "method 'onElementIconAddClick'");
        this.view14ff = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementIconAddClick(view2);
            }
        });
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_material_add, "method 'onElementMaterialAddClick'");
        this.view1501 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementMaterialAddClick(view2);
            }
        });
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_symbols, "method 'onElementSymbolsClick'");
        this.view1505 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementSymbolsClick(view2);
            }
        });
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_excel_import, "method 'onElementExcelImportClick'");
        this.view14fe = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementExcelImportClick(view2);
            }
        });
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_line_add, "method 'onElementLineAddClick'");
        this.view1500 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementLineAddClick(view2);
            }
        });
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_table_add, "method 'onElementTableAddClick'");
        this.view1506 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementTableAddClick(view2);
            }
        });
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_element_time_add, "method 'onElementTimeAddClick'");
        this.view1508 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAllFragment_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAllFragment.onElementTimeAddClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view1507.setOnClickListener(null);
        this.view1507 = null;
        this.view14fc.setOnClickListener(null);
        this.view14fc = null;
        this.view1503.setOnClickListener(null);
        this.view1503 = null;
        this.view1504.setOnClickListener(null);
        this.view1504 = null;
        this.view1502.setOnClickListener(null);
        this.view1502 = null;
        this.view14ff.setOnClickListener(null);
        this.view14ff = null;
        this.view1501.setOnClickListener(null);
        this.view1501 = null;
        this.view1505.setOnClickListener(null);
        this.view1505 = null;
        this.view14fe.setOnClickListener(null);
        this.view14fe = null;
        this.view1500.setOnClickListener(null);
        this.view1500 = null;
        this.view1506.setOnClickListener(null);
        this.view1506 = null;
        this.view1508.setOnClickListener(null);
        this.view1508 = null;
    }
}
