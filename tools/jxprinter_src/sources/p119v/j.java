package p119v;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.appdev.standard.model.ReceiptBarcodeDataModel;
import com.appdev.standard.model.ReceiptDateDataModel;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptLineDataModel;
import com.appdev.standard.model.ReceiptPictureDataModel;
import com.appdev.standard.model.ReceiptQrCodeDataModel;
import com.appdev.standard.model.ReceiptTableDataModel;
import com.appdev.standard.model.ReceiptTextDataModel;
import com.appdev.standard.page.printerlabel.util.QRCodeUtil;
import com.appdev.standard.page.printerlabel.widget.BaseBarcodeView;
import com.appdev.standard.page.printerlabel.widget.BaseLineView;
import com.appdev.standard.page.printerlabel.widget.BaseTableView;
import com.appdev.standard.page.printerlabel.widget.BaseTextView;
import com.library.base.util.recyclerview.a;
import com.library.base.util.recyclerview.f;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Y;
import org.json.JSONException;
import org.json.JSONObject;
import p113u.c;
import p113u.d;
import p113u.g;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8756a;
    public HashSet b;
    public boolean c;
    public Integer d;
    public Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8758g;

    @Override // com.library.base.util.recyclerview.b
    public final void convert(a aVar, Object obj) {
        ReceiptElementModel receiptElementModel = (ReceiptElementModel) obj;
        RelativeLayout relativeLayout = (RelativeLayout) aVar.a(d.ll_test);
        if (receiptElementModel.isSelectState()) {
            relativeLayout.setBackgroundResource(c.bg_rad_0_stroke_ffae00);
        } else {
            relativeLayout.setBackground(null);
            if (relativeLayout.getChildCount() != 0 && (relativeLayout.getChildAt(0) instanceof BaseTableView)) {
                ((BaseTableView) relativeLayout.getChildAt(0)).hiddenSelected();
            }
        }
        int itemType = receiptElementModel.getItemType();
        if (itemType == 1) {
            relativeLayout.removeAllViews();
            ReceiptLineDataModel receiptLineDataModel = (ReceiptLineDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptLineDataModel.class);
            BaseLineView baseLineView = new BaseLineView(this.context);
            baseLineView.setLayoutParams(new ViewGroup.LayoutParams(C1849c.mm2pxWithScale(receiptLineDataModel.getW()), -2));
            baseLineView.setLineStyleIndex(receiptLineDataModel.getLineStyleIndex());
            baseLineView.setLineSize(receiptLineDataModel.getLineSize());
            relativeLayout.addView(baseLineView);
            return;
        }
        if (itemType == 11) {
            relativeLayout.removeAllViews();
            ReceiptDateDataModel receiptDateDataModel = (ReceiptDateDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptDateDataModel.class);
            BaseTextView baseTextView = new BaseTextView(this.context);
            baseTextView.setLayoutParams(new ViewGroup.LayoutParams(C1849c.mm2pxWithScale(receiptDateDataModel.getW()), -2));
            if (Y.f(receiptDateDataModel.getDateFormat()) && Y.f(receiptDateDataModel.getTimeFormat())) {
                return;
            }
            baseTextView.setContent(receiptDateDataModel.getShowContent(this.f8758g));
            baseTextView.setTextSize(receiptDateDataModel.getFontSize());
            baseTextView.setBold(receiptDateDataModel.isBold());
            baseTextView.setItalic(receiptDateDataModel.isItalic());
            baseTextView.setUnderline(receiptDateDataModel.isUnderLine());
            baseTextView.setStrikethrough(receiptDateDataModel.isDeleteLine());
            baseTextView.sethAlignment(receiptDateDataModel.getAligment());
            relativeLayout.addView(baseTextView);
            return;
        }
        switch (itemType) {
            case 5:
                relativeLayout.removeAllViews();
                ReceiptTextDataModel receiptTextDataModel = (ReceiptTextDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptTextDataModel.class);
                BaseTextView baseTextView2 = new BaseTextView(this.context);
                baseTextView2.setLayoutParams(new ViewGroup.LayoutParams(C1849c.mm2pxWithScale(receiptTextDataModel.getW()), -2));
                baseTextView2.setContent(Y.f(receiptTextDataModel.getShowContent(this.f8758g)) ? this.context.getString(g.hint_20) : receiptTextDataModel.getShowContent(this.f8758g));
                baseTextView2.setTextSize(receiptTextDataModel.getFontSize());
                baseTextView2.setBold(receiptTextDataModel.isBold());
                baseTextView2.setItalic(receiptTextDataModel.isItalic());
                baseTextView2.setUnderline(receiptTextDataModel.isUnderLine());
                baseTextView2.setStrikethrough(receiptTextDataModel.isDeleteLine());
                baseTextView2.sethAlignment(receiptTextDataModel.getAligment());
                baseTextView2.setLinesSpace(receiptTextDataModel.getLinesSpace());
                baseTextView2.setWordSpace(receiptTextDataModel.getWordSpace());
                baseTextView2.setFontType(receiptTextDataModel.getFontId());
                relativeLayout.addView(baseTextView2);
                return;
            case 6:
                relativeLayout.removeAllViews();
                ReceiptPictureDataModel receiptPictureDataModel = (ReceiptPictureDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptPictureDataModel.class);
                ImageView imageView = new ImageView(this.context);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(C1849c.mm2pxWithScale(receiptPictureDataModel.getW()), C1849c.mm2pxWithScale(receiptPictureDataModel.getH())));
                if (receiptPictureDataModel.getDisplayMode() == 1) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                String str = receiptPictureDataModel.getContent() + "_" + receiptPictureDataModel.getDisplayMode();
                Bitmap bitmap = (Bitmap) this.f8756a.get(str);
                if (this.b.contains(str)) {
                    imageView.setImageDrawable(null);
                } else if (bitmap == null) {
                    com.bumptech.glide.c.with(this.context).asBitmap().load(receiptPictureDataModel.getContent()).into(new h(this, receiptPictureDataModel, imageView, str));
                } else {
                    imageView.setImageBitmap(bitmap);
                }
                relativeLayout.addView(imageView);
                return;
            case 7:
                relativeLayout.removeAllViews();
                ReceiptBarcodeDataModel receiptBarcodeDataModel = (ReceiptBarcodeDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptBarcodeDataModel.class);
                BaseBarcodeView baseBarcodeView = new BaseBarcodeView(this.context);
                baseBarcodeView.setLayoutParams(new ViewGroup.LayoutParams(C1849c.mm2pxWithScale(receiptBarcodeDataModel.getW()), C1849c.mm2pxWithScale(receiptBarcodeDataModel.getH())));
                baseBarcodeView.setDefaultHeight(receiptBarcodeDataModel.getH());
                baseBarcodeView.setDefaultWidth(receiptBarcodeDataModel.getW());
                baseBarcodeView.setContent(receiptBarcodeDataModel.getShowContent(this.f8758g));
                baseBarcodeView.setBarcodeType(receiptBarcodeDataModel.getEncodeRef());
                baseBarcodeView.setTextSize(30.0f);
                relativeLayout.addView(baseBarcodeView);
                return;
            case 8:
                relativeLayout.removeAllViews();
                ReceiptQrCodeDataModel receiptQrCodeDataModel = (ReceiptQrCodeDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptQrCodeDataModel.class);
                ImageView imageView2 = new ImageView(this.context);
                imageView2.setLayoutParams(new ViewGroup.LayoutParams(C1849c.mm2pxWithScale(receiptQrCodeDataModel.getW()), C1849c.mm2pxWithScale(receiptQrCodeDataModel.getH())));
                imageView2.setImageBitmap(QRCodeUtil.createQRCodeBitmap(receiptQrCodeDataModel.getEncodeRef(), receiptQrCodeDataModel.getShowContent(this.f8758g), C1849c.mm2pxWithScale(receiptQrCodeDataModel.getW()), C1849c.mm2pxWithScale(receiptQrCodeDataModel.getH()), null));
                relativeLayout.addView(imageView2);
                return;
            case 9:
                try {
                    relativeLayout.removeAllViews();
                    ReceiptTableDataModel receiptTableDataModel = (ReceiptTableDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptTableDataModel.class);
                    JSONObject jSONObjectObjectToJson = receiptTableDataModel.ObjectToJson();
                    BaseTableView baseTableView = new BaseTableView(this.context, jSONObjectObjectToJson.getJSONArray("tableData"), jSONObjectObjectToJson.getJSONArray("mergeData"));
                    baseTableView.setLineSize(receiptTableDataModel.getLineSize());
                    baseTableView.setOpenFrame(receiptTableDataModel.getOpenFrame());
                    if (this.f8757f) {
                        baseTableView.setShow(false);
                        if (receiptElementModel.isSelectState()) {
                            baseTableView.setEditView(this.d.intValue(), this.e.intValue());
                        }
                        baseTableView.setOnSelectChangedListener(new i(this));
                    } else {
                        baseTableView.setShow(true);
                    }
                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                    layoutParams.width = -1;
                    relativeLayout.setLayoutParams(layoutParams);
                    relativeLayout.addView(baseTableView);
                    return;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            default:
                return;
        }
    }
}
