package com.zlylib.fileselectorlib.adapter;

import O0.e;
import androidx.annotation.Nullable;
import com.zlylib.fileselectorlib.R;
import com.zlylib.fileselectorlib.bean.EssFile;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FileListAdapter extends e {
    private onLoadFileCountListener loadFileCountListener;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface onLoadFileCountListener {
        void onLoadFileCount(int i5);
    }

    public FileListAdapter(@Nullable List<EssFile> list) {
        super(R.layout.item_file_list, list);
    }

    public onLoadFileCountListener getLoadFileCountListener() {
        return this.loadFileCountListener;
    }

    public void setLoadFileCountListener(onLoadFileCountListener onloadfilecountlistener) {
        this.loadFileCountListener = onloadfilecountlistener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:95:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:97:0x0205  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b1, code lost:
    
        if (r0.equals("xlsx") != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
    
        if (r0.equals("pptx") != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c3, code lost:
    
        if (r0.equals(org.apache.poi.openxml4j.opc.ContentTypes.EXTENSION_JPG_2) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cd, code lost:
    
        if (r0.equals("docx") != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e5, code lost:
    
        if (r0.equals("xls") != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
    
        r7.setImageResource(com.zlylib.fileselectorlib.R.mipmap.xls);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0101, code lost:
    
        if (r0.equals("ppt") != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0103, code lost:
    
        r7.setImageResource(com.zlylib.fileselectorlib.R.mipmap.ppt);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
    
        if (r0.equals(org.apache.poi.openxml4j.opc.ContentTypes.EXTENSION_PNG) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0126, code lost:
    
        if (r0.equals("mp4") != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013e, code lost:
    
        if (r0.equals(org.apache.poi.openxml4j.opc.ContentTypes.EXTENSION_JPG_1) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0140, code lost:
    
        com.bumptech.glide.c.with(getContext()).load(r8.getAbsolutePath()).apply(((I0.j) new I0.j().centerCrop()).placeholder(com.zlylib.fileselectorlib.R.mipmap.png)).into(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c7, code lost:
    
        if (r0.equals("f4v") != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
    
        r7.setImageResource(com.zlylib.fileselectorlib.R.mipmap.movie);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d5, code lost:
    
        if (r0.equals("doc") != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d7, code lost:
    
        r7.setImageResource(com.zlylib.fileselectorlib.R.mipmap.doc);
     */
    @Override // O0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r7, com.zlylib.fileselectorlib.bean.EssFile r8) {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zlylib.fileselectorlib.adapter.FileListAdapter.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.zlylib.fileselectorlib.bean.EssFile):void");
    }
}
