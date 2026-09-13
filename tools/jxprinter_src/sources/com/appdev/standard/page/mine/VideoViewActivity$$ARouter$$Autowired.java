package com.appdev.standard.page.mine;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VideoViewActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        VideoViewActivity videoViewActivity = (VideoViewActivity) obj;
        videoViewActivity.fileName = videoViewActivity.getIntent().getExtras() == null ? videoViewActivity.fileName : videoViewActivity.getIntent().getExtras().getString("fileName", videoViewActivity.fileName);
        videoViewActivity.title = videoViewActivity.getIntent().getExtras() == null ? videoViewActivity.title : videoViewActivity.getIntent().getExtras().getString("title", videoViewActivity.title);
    }
}
