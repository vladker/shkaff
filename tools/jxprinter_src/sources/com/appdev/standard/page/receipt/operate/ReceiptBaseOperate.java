package com.appdev.standard.page.receipt.operate;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.model.ReceiptElementModel;
import com.library.base.util.recyclerview.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ReceiptBaseOperate {
    protected View contentView;
    protected Context context;
    protected C0451d customPopWindow;
    protected f quickAdapter;
    protected ReceiptElementModel item = null;
    protected View root = null;

    public ReceiptBaseOperate(Context context, f fVar) {
        this.contentView = null;
        this.context = context;
        this.quickAdapter = fVar;
        this.contentView = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) null);
    }

    public View getContentView() {
        return this.contentView;
    }

    public abstract int getLayoutId();

    public Resources getResources() {
        return this.context.getResources();
    }

    public void hide() {
        C0451d c0451d = this.customPopWindow;
        if (c0451d != null) {
            c0451d.a();
        }
    }

    public abstract void initContent(ReceiptElementModel receiptElementModel);

    public void show(ReceiptElementModel receiptElementModel, View view) {
        this.item = receiptElementModel;
        this.root = view;
        initContent(receiptElementModel);
        C0450c c0450c = new C0450c(this.context);
        c0450c.f2639a.e = this.contentView;
        c0450c.b(-2);
        C0451d c0451d = c0450c.f2639a;
        c0451d.d = false;
        c0451d.f2643h = true;
        C0451d c0451dA = c0450c.a();
        c0451dA.b(view);
        this.customPopWindow = c0451dA;
    }

    public void show() {
        ReceiptElementModel receiptElementModel = this.item;
        if (receiptElementModel == null || this.root == null) {
            return;
        }
        initContent(receiptElementModel);
        C0450c c0450c = new C0450c(this.context);
        c0450c.f2639a.e = this.contentView;
        c0450c.b(-2);
        C0451d c0451d = c0450c.f2639a;
        c0451d.d = false;
        c0451d.f2643h = true;
        C0451d c0451dA = c0450c.a();
        c0451dA.b(this.root);
        this.customPopWindow = c0451dA;
    }
}
