package com.zlylib.fileselectorlib.adapter;

import O0.e;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zlylib.fileselectorlib.R;
import com.zlylib.fileselectorlib.bean.BreadModel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class BreadAdapter extends e {
    public BreadAdapter(@Nullable List<BreadModel> list) {
        super(R.layout.bread_item, list);
        addChildClickViewIds(R.id.btn_bread);
    }

    @Override // O0.e
    public void convert(BaseViewHolder baseViewHolder, BreadModel breadModel) {
        baseViewHolder.setText(R.id.btn_bread, breadModel.getCurName());
    }
}
