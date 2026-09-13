package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.model.ElementAttributeType;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeFragment extends com.library.base.frame.f {
    private final String TAG;
    private BaseControlView baseControlView;
    private List<BaseControlView> baseControlViews;
    private Fragment baseFragment;

    @BindView(5097)
    FrameLayout flElementAttribute;
    private Fragment[] fragments;
    private TemplatePageView pageView;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5821)
    RecyclerView rvElementAttribute;

    @BindView(6262)
    TextView tvTab1;

    @BindView(6263)
    TextView tvTab2;

    @BindView(6264)
    TextView tvTab3;

    @BindView(6265)
    TextView tvTab4;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExcelFragment extends FlutterBoostFragment {
        private BaseControlView baseControlView;

        @Override // com.idlefish.flutterboost.containers.FlutterBoostFragment, io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
        public void onDestroyView() {
            super.onDestroyView();
        }

        @Override // com.idlefish.flutterboost.containers.FlutterBoostFragment, androidx.fragment.app.Fragment
        public void onHiddenChanged(boolean z6) {
            super.onHiddenChanged(z6);
            p051j0.a.k("ExcelFragment", "onHiddenChanged: " + z6);
            if (z6) {
                return;
            }
            final ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, this.baseControlView.getJson().toString());
            if (elementAttributeTextBean.getInputDataType() != 2) {
                this.baseControlView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment.ExcelFragment.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        elementAttributeTextBean.setInputDataType(2);
                        ExcelFragment.this.baseControlView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                    }
                });
            }
        }

        @Override // com.idlefish.flutterboost.containers.FlutterBoostFragment, io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
        }

        public void setBaseControlView(BaseControlView baseControlView) {
            this.baseControlView = baseControlView;
        }
    }

    public ElementAttributeFragment(List<BaseControlView> list, TemplatePageView templatePageView) {
        this.TAG = getClass().getName();
        this.fragments = null;
        this.baseFragment = null;
        this.baseControlViews = new ArrayList();
        this.baseControlView = null;
        if (list != null) {
            this.baseControlViews = list;
        }
        this.pageView = templatePageView;
    }

    private void showDefaultLayout() {
        try {
            Fragment[] fragmentArr = this.fragments;
            if (fragmentArr != null && fragmentArr.length > 0 && (fragmentArr[0] instanceof AttributeLayoutFragment)) {
                updateUIForDefaultLayout();
                return;
            }
            Fragment[] fragmentArr2 = {new AttributeLayoutFragment(this.pageView)};
            this.fragments = fragmentArr2;
            this.baseFragment = fragmentArr2[0];
            updateUIForDefaultLayout();
            FragmentManager childFragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Iterator<Fragment> it = childFragmentManager.getFragments().iterator();
            while (it.hasNext()) {
                fragmentTransactionBeginTransaction.remove(it.next());
            }
            fragmentTransactionBeginTransaction.add(p113u.d.fl_element_attribute, this.baseFragment).commitNowAllowingStateLoss();
        } catch (Exception e) {
            p051j0.a.e(this.TAG, "Error showing default layout", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchFragment(Fragment fragment) {
        if (fragment == null || fragment.equals(this.baseFragment)) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Fragment fragment2 = this.baseFragment;
        if (fragment2 != null && fragment2.isAdded()) {
            fragmentTransactionBeginTransaction.hide(this.baseFragment);
        }
        if (fragment.isAdded()) {
            fragmentTransactionBeginTransaction.show(fragment);
        } else {
            fragmentTransactionBeginTransaction.add(p113u.d.fl_element_attribute, fragment);
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        this.baseFragment = fragment;
    }

    private void updateUIForDefaultLayout() {
        this.tvTab1.setVisibility(0);
        this.tvTab2.setVisibility(8);
        this.tvTab3.setVisibility(8);
        this.tvTab4.setVisibility(8);
        TextView textView = this.tvTab1;
        int i5 = p113u.g.text_224;
        textView.setText(getString(i5));
        this.quickAdapter.clear();
        this.quickAdapter.add(new ElementAttributeType(getString(i5), true));
        this.quickAdapter.notifyDataSetChanged();
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        boolean z6;
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_element_attribute) { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, ElementAttributeType elementAttributeType) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_element_attribute_type_content);
                textView.setText(elementAttributeType.getContent());
                if (elementAttributeType.isSelect()) {
                    textView.setTextColor(ElementAttributeFragment.this.getResources().getColor(p113u.a.color_FFAE00));
                } else {
                    textView.setTextColor(ElementAttributeFragment.this.getResources().getColor(p113u.a.color_333333));
                }
            }
        };
        this.rvElementAttribute.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvElementAttribute.setAdapter(this.quickAdapter);
        if (this.baseControlViews.size() == 1) {
            BaseControlView baseControlView = this.baseControlViews.get(0);
            this.baseControlView = baseControlView;
            if (baseControlView.elementType() == 5) {
                ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, ((PrinterLabelTextView) this.baseControlView).getJson().toString());
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_215), elementAttributeTextBean.getInputDataType() == 0));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_138), elementAttributeTextBean.getInputDataType() == 1));
                this.quickAdapter.add(new ElementAttributeType("Excel", elementAttributeTextBean.getInputDataType() == 2));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_139), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_152), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_221), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                HashMap map = new HashMap();
                map.put("fileName", elementAttributeTextBean.getExcelName());
                map.put("fileUrl", elementAttributeTextBean.getExcelFileUrl());
                map.put("showTableHeader", Boolean.valueOf(elementAttributeTextBean.isShowExcelHeader()));
                map.put("excelHeaderColumn", Integer.valueOf(elementAttributeTextBean.getExcelHeaderColumn()));
                ExcelFragment excelFragment = (ExcelFragment) new FlutterBoostFragment.CachedEngineFragmentBuilder(ExcelFragment.class).shouldAttachEngineToActivity(false).url("label_excel_attribute").urlParams(map).uniqueId("label_excel_attribute_" + System.currentTimeMillis()).build();
                excelFragment.setBaseControlView(this.baseControlView);
                p102s.k.setCurrentView(this.baseControlView);
                this.fragments = new Fragment[]{new AttributeTextDataFragment(this.baseControlView), new AttributeTextSerialNumberFragment(this.baseControlView), excelFragment, new AttributeTextStyleFragment(this.baseControlView), new AttributeTextFontFragment(this.baseControlView), new AttributeTextSpacingFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                if (elementAttributeTextBean.getInputDataType() == 2) {
                    this.baseFragment = this.fragments[2];
                } else {
                    this.baseFragment = this.fragments[elementAttributeTextBean.getInputDataType() == 1 ? (char) 1 : (char) 0];
                }
            } else if (this.baseControlView.elementType() == 7) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_216), true));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_225), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                p102s.k.setCurrentView(this.baseControlView);
                com.library.base.frame.f[] fVarArr = {new AttributeBarcodeDataFragment(this.baseControlView), new AttributeBarcodeStyleFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fVarArr;
                this.baseFragment = fVarArr[0];
            } else if (this.baseControlView.elementType() == 8) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_216), true));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_96), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                p102s.k.setCurrentView(this.baseControlView);
                com.library.base.frame.f[] fVarArr2 = {new AttributeQrcodeDataFragment(this.baseControlView), new AttributeQrcodeStyleFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fVarArr2;
                this.baseFragment = fVarArr2[0];
            } else if (this.baseControlView.elementType() == 2) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_97), true));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_139), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                com.library.base.frame.f[] fVarArr3 = {new AttributeShapeDataFragment(this.baseControlView), new AttributeShapeStyleFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fVarArr3;
                this.baseFragment = fVarArr3[0];
            } else if (this.baseControlView.elementType() == 6) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_226), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                com.library.base.frame.f[] fVarArr4 = {new AttributeMaterialStyleFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fVarArr4;
                this.baseFragment = fVarArr4[0];
            } else if (this.baseControlView.elementType() == 1) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_139), true));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                com.library.base.frame.f[] fVarArr5 = {new AttributeLineStyleFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fVarArr5;
                this.baseFragment = fVarArr5[0];
            } else if (this.baseControlView.elementType() == 9) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_216), true));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_100), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_226), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                HashMap map2 = new HashMap();
                PrinterLabelTableView printerLabelTableView = (PrinterLabelTableView) this.baseControlView;
                ArrayList arrayList = new ArrayList();
                arrayList.add(printerLabelTableView);
                p102s.r.setTable(arrayList);
                map2.put("isOpenFrame", Boolean.valueOf(printerLabelTableView.isOpenFrame()));
                map2.put("isSingleSelectMode", Boolean.valueOf(printerLabelTableView.isSingleSelectMode()));
                Fragment[] fragmentArr = {new AttributeTableDataFragment(this.baseControlView), new AttributeTableStyleFragment(this.baseControlView), new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("table_adjust").urlParams(map2).uniqueId("table_adjust_" + System.currentTimeMillis()).build(), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fragmentArr;
                this.baseFragment = fragmentArr[0];
            } else if (this.baseControlView.elementType() == 10) {
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_101), true));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_139), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_152), false));
                this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                com.library.base.frame.f[] fVarArr6 = {new AttributeTimeDataFragment(this.baseControlView), new AttributeTimeStyleFragment(this.baseControlView), new AttributeTimeFontFragment(this.baseControlView), new AttributeLayoutFragment(this.pageView)};
                this.fragments = fVarArr6;
                this.baseFragment = fVarArr6[0];
            }
        } else {
            int i5 = 5;
            Iterator<BaseControlView> it = this.baseControlViews.iterator();
            boolean z7 = false;
            while (true) {
                if (!it.hasNext()) {
                    z6 = true;
                    break;
                }
                BaseControlView next = it.next();
                if (next != null) {
                    int iElementType = next.elementType();
                    int i6 = i5;
                    if (iElementType != i6) {
                        z6 = false;
                        z7 = true;
                        break;
                    } else {
                        i5 = i6;
                        z7 = true;
                    }
                }
            }
            if (!z7) {
                p051j0.a.d(this.TAG, "No valid elements found in selection");
                showDefaultLayout();
                return;
            }
            if (z6) {
                try {
                    this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_139), true));
                    this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_152), false));
                    this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_221), false));
                    this.quickAdapter.add(new ElementAttributeType(getString(p113u.g.text_224), false));
                    Fragment[] fragmentArr2 = {new AttributeTextStyleFragment(this.baseControlViews), new AttributeTextFontFragment(this.baseControlViews), new AttributeTextSpacingFragment(this.baseControlViews), new AttributeLayoutFragment(this.pageView)};
                    this.fragments = fragmentArr2;
                    this.baseFragment = fragmentArr2[0];
                } catch (Exception e) {
                    p051j0.a.e(this.TAG, "Error creating fragments for multiple text elements", e);
                    showDefaultLayout();
                }
            } else {
                showDefaultLayout();
            }
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        if (this.baseFragment.isAdded()) {
            fragmentTransactionBeginTransaction.show(this.baseFragment).commit();
        } else {
            Fragment fragment = this.baseFragment;
            if (fragment instanceof FlutterBoostFragment) {
                fragmentTransactionBeginTransaction.add(p113u.d.fl_element_attribute, fragment, ((FlutterBoostFragment) fragment).getUniqueId()).show(this.baseFragment).commit();
            } else {
                fragmentTransactionBeginTransaction.add(p113u.d.fl_element_attribute, fragment).show(this.baseFragment).commit();
            }
        }
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i7) {
                Iterator<Object> it2 = ElementAttributeFragment.this.quickAdapter.getData().iterator();
                while (it2.hasNext()) {
                    ((ElementAttributeType) it2.next()).setSelect(false);
                }
                ((ElementAttributeType) ElementAttributeFragment.this.quickAdapter.getData().get(i7)).setSelect(true);
                ElementAttributeFragment.this.quickAdapter.notifyDataSetChanged();
                if (ElementAttributeFragment.this.fragments == null || i7 >= ElementAttributeFragment.this.fragments.length) {
                    return;
                }
                ElementAttributeFragment elementAttributeFragment = ElementAttributeFragment.this;
                elementAttributeFragment.switchFragment(elementAttributeFragment.fragments[i7]);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i7) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_element_attribute;
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({6080})
    public void onElementAttributeBackClick() {
        S4.d.b().f(new p137y.n());
    }

    @OnClick({6262})
    public void onTab1Click() {
        Fragment[] fragmentArr = this.fragments;
        if (fragmentArr == null || fragmentArr.length <= 0) {
            return;
        }
        switchFragment(fragmentArr[0]);
    }

    @OnClick({6263})
    public void onTab2Click() {
        Fragment[] fragmentArr = this.fragments;
        if (fragmentArr == null || fragmentArr.length <= 1) {
            return;
        }
        switchFragment(fragmentArr[1]);
    }

    @OnClick({6264})
    public void onTab3Click() {
        Fragment[] fragmentArr = this.fragments;
        if (fragmentArr == null || fragmentArr.length <= 2) {
            return;
        }
        switchFragment(fragmentArr[2]);
    }

    @OnClick({6265})
    public void onTab4Click() {
        Fragment[] fragmentArr = this.fragments;
        if (fragmentArr == null || fragmentArr.length <= 3) {
            return;
        }
        switchFragment(fragmentArr[3]);
    }

    public ElementAttributeFragment() {
        this.TAG = getClass().getName();
        this.fragments = null;
        this.baseFragment = null;
        this.baseControlViews = new ArrayList();
        this.baseControlView = null;
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
