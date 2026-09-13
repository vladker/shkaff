package com.appdev.standard.page.receipt.operate;

import J.b;
import S4.k;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptTextDataModel;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.bumptech.glide.h;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.library.base.frame.FrameActivity;
import com.library.base.util.recyclerview.f;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p052j2.c;
import p113u.d;
import p113u.e;
import p113u.g;
import p137y.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptTextOperate extends ReceiptBaseOperate implements J.a {
    private static final String FONT_DIR_NAME = "fonts";
    private static final String IMPORTED_FONTS = "imported_fonts";
    private static final int REQUEST_CODE_IMPORT_FONT = 1001;
    private f fontQuickAdapter;
    private ImageView ivAligmentCenter;
    private ImageView ivAligmentLeft;
    private ImageView ivAligmentRight;
    private ImageView ivStyleBold;
    private ImageView ivStyleItalic;
    private ImageView ivStyleStrikethrough;
    private ImageView ivStyleUnderline;
    private LinearLayout llFontContainer;
    private LinearLayout llSerialNumber;
    private LinearLayout llSpacing;
    private LinearLayout llStyle;
    private LineProgressWidget lpwTextLinesSpace;
    private LineProgressWidget lpwTextWordSpace;
    private C0451d mCustomPopWindow;
    private RadioButton rbFontSize1;
    private RadioButton rbFontSize2;
    private RadioButton rbFontSize3;
    private ReceiptTextDataModel receiptTextDataModel;
    private RecyclerView rvFont;
    private List<TextFontModel> textFontModels;
    private b textFontWorker;
    private TextView tvContent;
    private TextView tvImportFont;
    private TextView tvTextIncrementalContent;
    private TextView tvTextInterval;
    private TextView tvTextPrefix;
    private TextView tvTextSuffix;
    private TextView tvTitleContent;
    private TextView tvTitleFont;
    private TextView tvTitleSerialNumber;
    private TextView tvTitleSpacing;
    private TextView tvTitleStyle;
    private View vLine;

    public ReceiptTextOperate(Context context, f fVar) {
        super(context, fVar);
        this.receiptTextDataModel = null;
    }

    private String getFontFileNameFromUri(Uri uri) {
        Uri uri2;
        String string = null;
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            uri2 = uri;
            Cursor cursorQuery = this.context.getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("_display_name");
                string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
                cursorQuery.close();
            }
        } else {
            uri2 = uri;
        }
        return string == null ? uri2.getLastPathSegment() : string;
    }

    private File getFontStorageDir() {
        return new File(this.context.getFilesDir(), FONT_DIR_NAME);
    }

    private void handleLogic(View view) {
        View viewFindViewById = view.findViewById(d.ll_pop_font_import_file);
        View viewFindViewById2 = view.findViewById(d.ll_pop_font_file_import_wechat);
        View viewFindViewById3 = view.findViewById(d.ll_pop_font_file_import_qq);
        viewFindViewById.setOnClickListener(new a(this, 0));
        viewFindViewById2.setOnClickListener(new a(this, 1));
        viewFindViewById3.setOnClickListener(new a(this, 2));
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void importFontFromUri(Uri uri) {
        try {
            String fontFileNameFromUri = getFontFileNameFromUri(uri);
            if (fontFileNameFromUri == null) {
                p042h2.d.show(g.text_519);
                return;
            }
            String lowerCase = fontFileNameFromUri.toLowerCase();
            if (!lowerCase.endsWith(".ttf") && !lowerCase.endsWith(".otf")) {
                p042h2.d.show(g.invalid_font_file);
                return;
            }
            File fontStorageDir = getFontStorageDir();
            if (!fontStorageDir.exists()) {
                fontStorageDir.mkdirs();
            }
            File file = new File(fontStorageDir, fontFileNameFromUri);
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i5 = inputStreamOpenInputStream.read(bArr);
                        if (i5 <= 0) {
                            fileOutputStream.close();
                            inputStreamOpenInputStream.close();
                            String strReplaceAll = fontFileNameFromUri.replaceAll("\\.(ttf|otf)$", "");
                            TextFontModel textFontModel = new TextFontModel();
                            textFontModel.setFontlibId("custom_" + strReplaceAll + System.currentTimeMillis());
                            textFontModel.setName(strReplaceAll);
                            textFontModel.setLocalFilePath(file.getAbsolutePath());
                            textFontModel.setDownload(true);
                            saveImportedFont(textFontModel);
                            this.fontQuickAdapter.add(textFontModel);
                            this.fontQuickAdapter.notifyDataSetChanged();
                            p042h2.d.show(g.font_import_success);
                            S4.d.b().h(new p(textFontModel));
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i5);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                throw th4;
            }
        } catch (Exception e) {
            p051j0.a.e("FontImport", "导入失败", e);
            p042h2.d.show(g.font_import_failed);
        }
    }

    private void initTextTitle() {
        this.vLine = this.contentView.findViewById(d.v_line);
        this.tvTitleContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_1);
        this.tvTitleSerialNumber = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_2);
        this.tvTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_3);
        this.tvTitleSpacing = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_4);
        this.tvTitleFont = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_5);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.selectType(view.getId());
            }
        };
        this.tvTitleContent.setOnClickListener(onClickListener);
        this.tvTitleSerialNumber.setOnClickListener(onClickListener);
        this.tvTitleStyle.setOnClickListener(onClickListener);
        this.tvTitleSpacing.setOnClickListener(onClickListener);
        this.tvTitleFont.setOnClickListener(onClickListener);
    }

    private void initTextTitle1() {
        this.tvTitleContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_1);
        TextView textView = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_content);
        this.tvContent = textView;
        textView.setText(this.receiptTextDataModel.getContent());
        this.tvContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.showEditContent();
            }
        });
    }

    private void initTextTitle2() {
        this.tvTitleSerialNumber = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_2);
        this.llSerialNumber = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_text_serial_number);
        this.tvTextIncrementalContent = (TextView) this.contentView.findViewById(d.tv_attribute_text_incremental_content);
        this.tvTextInterval = (TextView) this.contentView.findViewById(d.tv_attribute_text_interval);
        this.tvTextPrefix = (TextView) this.contentView.findViewById(d.tv_attribute_text_prefix);
        this.tvTextSuffix = (TextView) this.contentView.findViewById(d.tv_attribute_text_suffix);
        this.tvTextIncrementalContent.setText(this.receiptTextDataModel.getContent());
        this.tvTextInterval.setText(String.valueOf(this.receiptTextDataModel.getInterval()));
        this.tvTextSuffix.setText(this.receiptTextDataModel.getSuffix());
        this.tvTextPrefix.setText(this.receiptTextDataModel.getPrefix());
        this.tvTextIncrementalContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.showEditContent();
            }
        });
        this.tvTextInterval.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptTextOperate.this.context, 2);
                contentEditDialog.a(String.valueOf(ReceiptTextOperate.this.receiptTextDataModel.getInterval()));
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.4.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        int i5;
                        try {
                            i5 = Integer.parseInt(str);
                        } catch (Exception unused) {
                            i5 = 1;
                        }
                        ReceiptTextOperate.this.receiptTextDataModel.setInterval(i5);
                        ReceiptTextOperate.this.tvTextInterval.setText(str);
                        ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                        receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                    }
                };
            }
        });
        this.tvTextSuffix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptTextOperate.this.context);
                contentEditDialog.a(String.valueOf(ReceiptTextOperate.this.receiptTextDataModel.getSuffix()));
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.5.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptTextOperate.this.receiptTextDataModel.setSuffix(str);
                        ReceiptTextOperate.this.tvTextSuffix.setText(str);
                        ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                        receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                        ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
                    }
                };
            }
        });
        this.tvTextPrefix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptTextOperate.this.context);
                contentEditDialog.a(String.valueOf(ReceiptTextOperate.this.receiptTextDataModel.getPrefix()));
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.6.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptTextOperate.this.receiptTextDataModel.setPrefix(str);
                        ReceiptTextOperate.this.tvTextPrefix.setText(str);
                        ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                        receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                        ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
                    }
                };
            }
        });
    }

    private void initTextTitle3() {
        this.tvTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_3);
        this.llStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_text_title_style);
        this.rbFontSize1 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_text_fontSize_1);
        this.rbFontSize2 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_text_fontSize_2);
        this.rbFontSize3 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_text_fontSize_3);
        this.ivStyleBold = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_bold);
        this.ivStyleItalic = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_italic);
        this.ivStyleUnderline = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_underline);
        this.ivStyleStrikethrough = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_strikethrough);
        this.ivAligmentLeft = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_aligment_left);
        this.ivAligmentCenter = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_aligment_center);
        this.ivAligmentRight = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_aligment_right);
        RadioButton radioButton = this.rbFontSize1;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        radioButton.setBackgroundResource(i5);
        this.rbFontSize2.setBackgroundResource(i5);
        this.rbFontSize3.setBackgroundResource(i5);
        int fontSize = this.receiptTextDataModel.getFontSize();
        if (fontSize == 30) {
            this.rbFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (fontSize == 50) {
            this.rbFontSize2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (fontSize == 70) {
            this.rbFontSize3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        if (this.receiptTextDataModel.isBold()) {
            this.ivStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleBold.setBackgroundResource(i5);
        }
        if (this.receiptTextDataModel.isItalic()) {
            this.ivStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleItalic.setBackgroundResource(i5);
        }
        if (this.receiptTextDataModel.isUnderLine()) {
            this.ivStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleUnderline.setBackgroundResource(i5);
        }
        if (this.receiptTextDataModel.isDeleteLine()) {
            this.ivStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleStrikethrough.setBackgroundResource(i5);
        }
        this.ivAligmentLeft.setBackgroundResource(i5);
        this.ivAligmentCenter.setBackgroundResource(i5);
        this.ivAligmentRight.setBackgroundResource(i5);
        int aligment = this.receiptTextDataModel.getAligment();
        if (aligment == 0) {
            this.ivAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (aligment == 1) {
            this.ivAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (aligment == 2) {
            this.ivAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RadioButton radioButton2 = ReceiptTextOperate.this.rbFontSize1;
                int i6 = p113u.c.bg_f8f8f8_rad_6;
                radioButton2.setBackgroundResource(i6);
                ReceiptTextOperate.this.rbFontSize2.setBackgroundResource(i6);
                ReceiptTextOperate.this.rbFontSize3.setBackgroundResource(i6);
                if (view.getId() == d.rb_pop_receipt_edit_text_fontSize_1) {
                    ReceiptTextOperate.this.receiptTextDataModel.setFontSize(30);
                    ReceiptTextOperate.this.rbFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (view.getId() == d.rb_pop_receipt_edit_text_fontSize_2) {
                    ReceiptTextOperate.this.receiptTextDataModel.setFontSize(50);
                    ReceiptTextOperate.this.rbFontSize2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (view.getId() == d.rb_pop_receipt_edit_text_fontSize_3) {
                    ReceiptTextOperate.this.receiptTextDataModel.setFontSize(70);
                    ReceiptTextOperate.this.rbFontSize3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTextOperate.this.receiptTextDataModel.setFontSize(30);
                    ReceiptTextOperate.this.rbFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        };
        this.rbFontSize1.setOnClickListener(onClickListener);
        this.rbFontSize2.setOnClickListener(onClickListener);
        this.rbFontSize3.setOnClickListener(onClickListener);
        this.ivStyleBold.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.receiptTextDataModel.setBold(!ReceiptTextOperate.this.receiptTextDataModel.isBold());
                if (ReceiptTextOperate.this.receiptTextDataModel.isBold()) {
                    ReceiptTextOperate.this.ivStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTextOperate.this.ivStyleBold.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        });
        this.ivStyleItalic.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.receiptTextDataModel.setItalic(!ReceiptTextOperate.this.receiptTextDataModel.isItalic());
                if (ReceiptTextOperate.this.receiptTextDataModel.isItalic()) {
                    ReceiptTextOperate.this.ivStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTextOperate.this.ivStyleItalic.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        });
        this.ivStyleUnderline.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.receiptTextDataModel.setUnderLine(!ReceiptTextOperate.this.receiptTextDataModel.isUnderLine());
                if (ReceiptTextOperate.this.receiptTextDataModel.isUnderLine()) {
                    ReceiptTextOperate.this.ivStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTextOperate.this.ivStyleUnderline.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        });
        this.ivStyleStrikethrough.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTextOperate.this.receiptTextDataModel.setDeleteLine(!ReceiptTextOperate.this.receiptTextDataModel.isDeleteLine());
                if (ReceiptTextOperate.this.receiptTextDataModel.isDeleteLine()) {
                    ReceiptTextOperate.this.ivStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTextOperate.this.ivStyleStrikethrough.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        });
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.iv_pop_receipt_edit_text_aligment_left) {
                    ReceiptTextOperate.this.receiptTextDataModel.setAligment(0);
                } else if (view.getId() == d.iv_pop_receipt_edit_text_aligment_center) {
                    ReceiptTextOperate.this.receiptTextDataModel.setAligment(1);
                } else if (view.getId() == d.iv_pop_receipt_edit_text_aligment_right) {
                    ReceiptTextOperate.this.receiptTextDataModel.setAligment(2);
                } else {
                    ReceiptTextOperate.this.receiptTextDataModel.setAligment(0);
                }
                ImageView imageView = ReceiptTextOperate.this.ivAligmentLeft;
                int i6 = p113u.c.bg_f8f8f8_rad_6;
                imageView.setBackgroundResource(i6);
                ReceiptTextOperate.this.ivAligmentCenter.setBackgroundResource(i6);
                ReceiptTextOperate.this.ivAligmentRight.setBackgroundResource(i6);
                int aligment2 = ReceiptTextOperate.this.receiptTextDataModel.getAligment();
                if (aligment2 == 0) {
                    ReceiptTextOperate.this.ivAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (aligment2 == 1) {
                    ReceiptTextOperate.this.ivAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (aligment2 == 2) {
                    ReceiptTextOperate.this.ivAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        };
        this.ivAligmentLeft.setOnClickListener(onClickListener2);
        this.ivAligmentCenter.setOnClickListener(onClickListener2);
        this.ivAligmentRight.setOnClickListener(onClickListener2);
    }

    private void initTextTitle4() {
        this.tvTitleSpacing = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_4);
        this.llSpacing = (LinearLayout) this.contentView.findViewById(d.tv_pop_receipt_edit_text_spacing);
        this.lpwTextWordSpace = (LineProgressWidget) this.contentView.findViewById(d.lpw_text_word_space);
        this.lpwTextLinesSpace = (LineProgressWidget) this.contentView.findViewById(d.lpw_text_lines_space);
        this.lpwTextWordSpace.setPosition(this.receiptTextDataModel.getWordSpace());
        this.lpwTextLinesSpace.setPosition(this.receiptTextDataModel.getLinesSpace());
        this.lpwTextWordSpace.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.13
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                ReceiptTextOperate.this.receiptTextDataModel.setWordSpace(f6);
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        });
        this.lpwTextLinesSpace.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.14
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                ReceiptTextOperate.this.receiptTextDataModel.setLinesSpace(f6);
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        });
    }

    private void initTextTitle5() {
        this.tvTitleFont = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_5);
        this.llFontContainer = (LinearLayout) this.contentView.findViewById(d.ll_font_container);
        this.rvFont = (RecyclerView) this.contentView.findViewById(d.rv_attribute_text_font);
        this.tvImportFont = (TextView) this.contentView.findViewById(d.tv_import_font);
        b bVar = new b(this.context);
        this.textFontWorker = bVar;
        bVar.b = this;
        if (!S4.d.b().e(this)) {
            S4.d.b().j(this);
        }
        this.fontQuickAdapter = new f(this.context, e.item_attribute_text_font) { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.15
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, TextFontModel textFontModel) {
                TextView textView = (TextView) aVar.a(d.tv_item_attribute_text_font_content);
                textView.setText(textFontModel.getName());
                if (textFontModel.isSelect()) {
                    textView.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    textView.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
            }
        };
        this.rvFont.setLayoutManager(new GridLayoutManager(this.context, 3));
        this.rvFont.setAdapter(this.fontQuickAdapter);
        this.tvImportFont.setOnClickListener(new a(this, 3));
        List<TextFontModel> list = (List) Hawk.get("FONT_LIB_DATA", null);
        this.textFontModels = list;
        if (list == null) {
            w.e();
            this.textFontWorker.a();
        } else {
            this.fontQuickAdapter.clear();
            this.fontQuickAdapter.addAll(h.b(this.context));
            this.fontQuickAdapter.addAll(this.textFontModels);
            loadImportedFonts();
            Iterator<Object> it = this.fontQuickAdapter.getData().iterator();
            while (it.hasNext()) {
                TextFontModel textFontModel = (TextFontModel) it.next();
                if (textFontModel.getFontlibId().equals(String.valueOf(this.receiptTextDataModel.getFontId()))) {
                    textFontModel.setSelect(true);
                    this.fontQuickAdapter.notifyDataSetChanged();
                    break;
                }
            }
        }
        this.fontQuickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.16
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                FrameActivity frameActivity = (FrameActivity) receiptTextOperate.context;
                TextFontModel textFontModel2 = (TextFontModel) receiptTextOperate.fontQuickAdapter.getItem(i5);
                if (textFontModel2.getFontlibId().equals("0") || textFontModel2.getFontlibId().equals("-10001") || textFontModel2.getFontlibId().equals("-10002") || textFontModel2.getFontlibId().equals("-10003") || textFontModel2.getFontlibId().equals("-10004") || textFontModel2.getFontlibId().equals("-10005") || textFontModel2.getFontlibId().equals("-10006") || textFontModel2.getFontlibId().startsWith("custom_")) {
                    ReceiptTextOperate.this.selectFont(textFontModel2.getFontlibId());
                    return;
                }
                String str = frameActivity.getCacheDir().getAbsolutePath() + "/fontData/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (new File(androidx.collection.a.o(str, textFontModel2.getFontlibId(), ".ttf")).exists()) {
                    ReceiptTextOperate.this.selectFont(textFontModel2.getFontlibId());
                    return;
                }
                com.appdev.standard.util.fileDownload.g.b().a(new File(androidx.collection.a.o(str, textFontModel2.getFontlibId(), ".ttf")), textFontModel2.getFileUrl());
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$1(View view) {
        this.mCustomPopWindow.a();
        Context context = this.context;
        if (context instanceof Activity) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "application/x-font-ttf", "application/x-font-otf"});
            ((Activity) context).startActivityForResult(intent, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$2(View view) {
        this.mCustomPopWindow.a();
        Context context = this.context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            if (launchIntentForPackage != null) {
                activity.startActivity(launchIntentForPackage);
            } else {
                p042h2.d.show(g.toast_6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$3(View view) {
        this.mCustomPopWindow.a();
        Context context = this.context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
            if (launchIntentForPackage != null) {
                activity.startActivity(launchIntentForPackage);
            } else {
                p042h2.d.show(g.text_463);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTextTitle5$0(View view) {
        showImportFontDialog();
    }

    private void loadImportedFonts() {
        List<TextFontModel> list = (List) Hawk.get(IMPORTED_FONTS, null);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = this.fontQuickAdapter.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(((TextFontModel) it.next()).getFontlibId());
            }
            for (TextFontModel textFontModel : list) {
                if (!arrayList.contains(textFontModel.getFontlibId())) {
                    this.fontQuickAdapter.add(textFontModel);
                }
            }
            this.fontQuickAdapter.notifyDataSetChanged();
        }
    }

    private void saveImportedFont(TextFontModel textFontModel) {
        List list = (List) Hawk.get(IMPORTED_FONTS, new ArrayList());
        list.add(textFontModel);
        Hawk.put(IMPORTED_FONTS, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectFont(String str) {
        Iterator<Object> it = this.fontQuickAdapter.getData().iterator();
        while (it.hasNext()) {
            TextFontModel textFontModel = (TextFontModel) it.next();
            textFontModel.setSelect(textFontModel.getFontlibId().equals(str));
        }
        this.fontQuickAdapter.notifyDataSetChanged();
        this.receiptTextDataModel.setFontId(str);
        this.item.setData(c.e(this.receiptTextDataModel));
        this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectType(int i5) {
        TextView textView = this.tvTitleContent;
        Resources resources = this.context.getResources();
        int i6 = p113u.a.color_333333;
        textView.setTextColor(resources.getColor(i6));
        this.tvTitleSerialNumber.setTextColor(this.context.getResources().getColor(i6));
        this.tvTitleStyle.setTextColor(this.context.getResources().getColor(i6));
        this.tvTitleSpacing.setTextColor(this.context.getResources().getColor(i6));
        this.tvTitleFont.setTextColor(this.context.getResources().getColor(i6));
        this.tvContent.setVisibility(8);
        this.llSerialNumber.setVisibility(8);
        this.llStyle.setVisibility(8);
        this.llSpacing.setVisibility(8);
        LinearLayout linearLayout = this.llFontContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.vLine.setVisibility(0);
        if (i5 == d.tv_pop_receipt_edit_text_title_1) {
            this.vLine.setVisibility(8);
            this.tvTitleContent.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.tvContent.setVisibility(0);
            this.receiptTextDataModel.setInputDataType(0);
            this.item.setData(c.e(this.receiptTextDataModel));
            this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
            return;
        }
        if (i5 == d.tv_pop_receipt_edit_text_title_2) {
            this.tvTitleSerialNumber.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llSerialNumber.setVisibility(0);
            this.receiptTextDataModel.setInputDataType(1);
            this.item.setData(c.e(this.receiptTextDataModel));
            this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
            return;
        }
        if (i5 == d.tv_pop_receipt_edit_text_title_3) {
            this.tvTitleStyle.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llStyle.setVisibility(0);
            return;
        }
        if (i5 == d.tv_pop_receipt_edit_text_title_4) {
            this.tvTitleSpacing.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llSpacing.setVisibility(0);
        } else {
            if (i5 != d.tv_pop_receipt_edit_text_title_5) {
                this.tvTitleContent.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
                this.tvContent.setVisibility(0);
                return;
            }
            this.tvTitleFont.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            LinearLayout linearLayout2 = this.llFontContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditContent() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(this.context);
        contentEditDialog.a(this.receiptTextDataModel.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.17
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(String str) {
                ReceiptTextOperate.this.receiptTextDataModel.setContent(str);
                ReceiptTextOperate.this.tvContent.setText(str);
                ReceiptTextOperate.this.tvTextIncrementalContent.setText(str);
                ReceiptTextOperate receiptTextOperate = ReceiptTextOperate.this;
                receiptTextOperate.item.setData(c.e(receiptTextOperate.receiptTextDataModel));
                ReceiptTextOperate.this.quickAdapter.notifyItemChanged(ReceiptTextOperate.this.quickAdapter.getData().indexOf(ReceiptTextOperate.this.item));
            }
        };
    }

    private void showImportFontDialog() {
        if (!p042h2.e.f4031a.h()) {
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
            defaultTipDialog.e("");
            defaultTipDialog.c(this.context.getString(g.text_248));
            defaultTipDialog.b(this.context.getString(g.text_256));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.18
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
            return;
        }
        Context context = this.context;
        if (context instanceof Activity) {
            View rootView = ((Activity) context).getWindow().getDecorView().getRootView();
            View viewInflate = LayoutInflater.from(this.context).inflate(e.pop_font_import, (ViewGroup) null);
            handleLogic(viewInflate);
            C0450c c0450c = new C0450c(this.context);
            c0450c.f2639a.e = viewInflate;
            c0450c.b(-2);
            C0451d c0451d = c0450c.f2639a;
            c0451d.d = true;
            c0451d.f2643h = true;
            C0451d c0451dA = c0450c.a();
            c0451dA.b(rootView);
            this.mCustomPopWindow = c0451dA;
        }
    }

    @Override // J.a
    public void getAppFontLibSuccess(List<TextFontModel> list) {
        this.fontQuickAdapter.clear();
        this.fontQuickAdapter.addAll(h.b(this.context));
        this.fontQuickAdapter.addAll(list);
        loadImportedFonts();
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_text;
    }

    public void handleActivityResult(int i5, int i6, Intent intent) {
        if (i5 == 1001 && i6 == -1 && intent != null) {
            if (p042h2.e.f4031a.h()) {
                importFontFromUri(intent.getData());
                return;
            }
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
            defaultTipDialog.e("");
            defaultTipDialog.c(this.context.getString(g.text_248));
            defaultTipDialog.b(this.context.getString(g.text_256));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTextOperate.19
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
        }
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        this.receiptTextDataModel = (ReceiptTextDataModel) c.d(receiptElementModel.getData(), ReceiptTextDataModel.class);
        initTextTitle1();
        initTextTitle2();
        initTextTitle3();
        initTextTitle4();
        initTextTitle5();
        initTextTitle();
        if (this.receiptTextDataModel.getInputDataType() == 1) {
            selectType(d.tv_pop_receipt_edit_text_title_2);
        } else {
            selectType(d.tv_pop_receipt_edit_text_title_1);
        }
    }

    public void onDestroy() {
        if (S4.d.b().e(this)) {
            S4.d.b().m(this);
        }
    }

    @k(sticky = true, threadMode = ThreadMode.MAIN)
    public void onFontImportedEvent(p pVar) {
        S4.d.b().k(pVar);
        TextFontModel textFontModel = pVar.f9019a;
        Iterator<Object> it = this.fontQuickAdapter.getData().iterator();
        while (it.hasNext()) {
            if (((TextFontModel) it.next()).getFontlibId().equals(textFontModel.getFontlibId())) {
                return;
            }
        }
        List list = (List) Hawk.get(IMPORTED_FONTS, new ArrayList());
        list.add(textFontModel);
        Hawk.put(IMPORTED_FONTS, list);
        this.fontQuickAdapter.add(textFontModel);
        this.fontQuickAdapter.notifyDataSetChanged();
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void show(ReceiptElementModel receiptElementModel, View view) {
        super.show(receiptElementModel, view);
    }

    private void selectFont(TextFontModel textFontModel) {
        selectFont(textFontModel.getFontlibId());
    }

    @Override // J.a
    public void getAppFontLibFailed(int i5, String str) {
    }
}
