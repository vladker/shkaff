package com.zlylib.fileselectorlib.adapter;

import O0.e;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zlylib.fileselectorlib.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class SelectSdcardAdapter extends e {
    public SelectSdcardAdapter(@Nullable List<String> list) {
        super(R.layout.item_select_sdcard, list);
    }

    @Override // O0.e
    public void convert(BaseViewHolder baseViewHolder, String str) {
        baseViewHolder.setText(R.id.tv_item_select_sdcard, str);
    }
}
