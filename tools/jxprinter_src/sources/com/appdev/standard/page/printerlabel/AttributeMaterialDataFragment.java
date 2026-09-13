package com.appdev.standard.page.printerlabel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.standard.api.CommonApi;
import com.appdev.standard.model.AppMaterialModel;
import com.appdev.standard.model.DictModel;
import com.appdev.standard.model.ElementAttributePictureBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView;
import com.library.base.frame.FrameApplication;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.StructuredDataId;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeMaterialDataFragment extends com.library.base.frame.f implements p014c0.a, E.f, E.a {
    private E.b appMaterialWorker;
    private com.library.base.util.recyclerview.f contentQuickAdapter;
    private ElementAttributePictureBean elementAttributePictureBean;
    private E.g imageDictWorker;
    private PrinterLabelPictureView printerLabelPictureView;

    @BindView(5840)
    RecyclerView rvMaterialContent;

    @BindView(5841)
    RecyclerView rvMaterialType;
    private com.library.base.util.recyclerview.f typeQuickAdapter;
    private p014c0.e uploadImageWorker = null;
    private p056k0.i mediaPicker = new p056k0.i();

    public AttributeMaterialDataFragment(BaseControlView baseControlView) {
        System.out.println("AttributeMaterialDataFragment");
        this.printerLabelPictureView = (PrinterLabelPictureView) baseControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$selectPicture$0(Uri uri) {
        if (uri == null) {
            return;
        }
        p050j.w.e();
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(uri));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
            this.uploadImageWorker.a(com.bumptech.glide.g.g(getFrameActivity(), bitmapCreateBitmap, com.bumptech.glide.g.d(getContext(), uri)));
        } catch (Exception unused) {
            p050j.w.c();
        }
    }

    @Override // E.a
    public void appMaterialFailed(int i5, String str) {
        p042h2.d.a(str);
    }

    @Override // E.a
    public void appMaterialSuccess(List<AppMaterialModel> list) {
        this.contentQuickAdapter.clear();
        this.contentQuickAdapter.addAll(list);
        Iterator<Object> it = this.contentQuickAdapter.getData().iterator();
        while (it.hasNext()) {
            AppMaterialModel appMaterialModel = (AppMaterialModel) it.next();
            ElementAttributePictureBean elementAttributePictureBean = this.elementAttributePictureBean;
            if (elementAttributePictureBean != null && elementAttributePictureBean.getContent() != null && this.elementAttributePictureBean.getContent().equals(appMaterialModel.getImageUrls())) {
                appMaterialModel.setSelect(true);
                this.contentQuickAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // E.f
    public void getImageDictFailed(int i5, String str) {
        p042h2.d.a(str);
    }

    @Override // E.f
    public void getImageDictSuccess(List<DictModel> list) {
        this.typeQuickAdapter.clear();
        this.typeQuickAdapter.add(new DictModel(getString(p113u.g.text_431), StructuredDataId.RESERVED, true));
        this.typeQuickAdapter.addAll(list);
        this.contentQuickAdapter.clear();
        this.contentQuickAdapter.add(new AppMaterialModel(null, false));
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        this.mediaPicker.attachToActivity(this);
        p014c0.e eVar = new p014c0.e(getContext());
        this.uploadImageWorker = eVar;
        addPresenter(eVar);
        E.g gVar = new E.g(getContext());
        gVar.d = (CommonApi) Http.createApi(CommonApi.class);
        this.imageDictWorker = gVar;
        addPresenter(gVar);
        E.b bVar = new E.b(getContext());
        bVar.d = (CommonApi) Http.createApi(CommonApi.class);
        this.appMaterialWorker = bVar;
        addPresenter(bVar);
        JSONObject json = this.printerLabelPictureView.getJson();
        System.out.println(json);
        this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
        this.typeQuickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_material_type) { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialDataFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, DictModel dictModel) {
                TextView textView = (TextView) aVar.a(p113u.d.item_tv_material_type);
                textView.setText(dictModel.getDictLabel());
                if (dictModel.isSelect()) {
                    textView.setTextColor(AttributeMaterialDataFragment.this.getResources().getColor(p113u.a.color_FFAE00));
                } else {
                    textView.setTextColor(AttributeMaterialDataFragment.this.getResources().getColor(p113u.a.color_999999));
                }
            }
        };
        this.rvMaterialType.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rvMaterialType.setAdapter(this.typeQuickAdapter);
        this.contentQuickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_material_content) { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialDataFragment.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, AppMaterialModel appMaterialModel) {
                ImageView imageView = (ImageView) aVar.a(p113u.d.item_iv_material_content);
                if (appMaterialModel.getImageUrls() == null) {
                    String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
                    imageView.setPadding(0, 0, 0, 0);
                    if (str.equals("zh")) {
                        imageView.setImageResource(p113u.f.ic_shape_image_upload_zh);
                    } else {
                        imageView.setImageResource(p113u.f.ic_shape_image_upload_en);
                    }
                } else {
                    imageView.setPadding(10, 10, 10, 10);
                    p047i2.a.a(imageView, appMaterialModel.getImageUrls());
                }
                if (appMaterialModel.isSelect()) {
                    imageView.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6_stroke_ffae00);
                } else {
                    imageView.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
            }
        };
        this.rvMaterialContent.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.rvMaterialContent.setAdapter(this.contentQuickAdapter);
        this.typeQuickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialDataFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Iterator<Object> it = AttributeMaterialDataFragment.this.typeQuickAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((DictModel) it.next()).setSelect(false);
                }
                DictModel dictModel = (DictModel) AttributeMaterialDataFragment.this.typeQuickAdapter.getData().get(i5);
                dictModel.setSelect(true);
                AttributeMaterialDataFragment.this.typeQuickAdapter.notifyDataSetChanged();
                String dictValue = dictModel.getDictValue();
                if (StructuredDataId.RESERVED.equals(dictValue)) {
                    AttributeMaterialDataFragment.this.contentQuickAdapter.clear();
                    AttributeMaterialDataFragment.this.contentQuickAdapter.add(new AppMaterialModel(null, false));
                } else {
                    E.b bVar2 = AttributeMaterialDataFragment.this.appMaterialWorker;
                    bVar2.d.appMaterial(dictValue).b(new A.c(bVar2, 5));
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        this.contentQuickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialDataFragment.4
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Iterator<Object> it = AttributeMaterialDataFragment.this.contentQuickAdapter.getData().iterator();
                while (it.hasNext()) {
                    AppMaterialModel appMaterialModel = (AppMaterialModel) it.next();
                    if (appMaterialModel.isSelect()) {
                        appMaterialModel.setSelect(false);
                        AttributeMaterialDataFragment.this.contentQuickAdapter.notifyItemChanged(AttributeMaterialDataFragment.this.contentQuickAdapter.getData().indexOf(appMaterialModel));
                    }
                }
                ((AppMaterialModel) AttributeMaterialDataFragment.this.contentQuickAdapter.getData().get(i5)).setSelect(true);
                AttributeMaterialDataFragment.this.contentQuickAdapter.notifyItemChanged(i5);
                final String imageUrls = ((AppMaterialModel) AttributeMaterialDataFragment.this.contentQuickAdapter.getData().get(i5)).getImageUrls();
                if (imageUrls == null) {
                    AttributeMaterialDataFragment.this.selectPicture();
                } else {
                    AttributeMaterialDataFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialDataFragment.4.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json2 = AttributeMaterialDataFragment.this.printerLabelPictureView.getJson();
                            AttributeMaterialDataFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json2.toString());
                            AttributeMaterialDataFragment.this.elementAttributePictureBean.setContent(imageUrls);
                            AttributeMaterialDataFragment.this.elementAttributePictureBean.setPicType(0);
                            AttributeMaterialDataFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialDataFragment.this.elementAttributePictureBean.ObjectToJson());
                        }
                    });
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_material_data;
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onEditMaterialDataEvent(p137y.m mVar) {
        selectPicture();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        E.g gVar = this.imageDictWorker;
        gVar.d.getImageDict().b(new A.c(gVar, 6));
    }

    public void selectPicture() {
        p051j0.a.k("TAG", "getFrameActivity()=" + getFrameActivity());
        if (getFrameActivity() == null) {
            return;
        }
        this.mediaPicker.pick(new H(this, 2));
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(final String str, String str2) {
        p050j.w.c();
        this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialDataFragment.5
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeMaterialDataFragment.this.printerLabelPictureView.getJson();
                AttributeMaterialDataFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                AttributeMaterialDataFragment.this.elementAttributePictureBean.setContent(str);
                AttributeMaterialDataFragment.this.elementAttributePictureBean.setPicType(1);
                AttributeMaterialDataFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialDataFragment.this.elementAttributePictureBean.ObjectToJson());
            }
        });
    }
}
