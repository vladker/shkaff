package com.appdev.standard.page.mine;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ArticleViewActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        ArticleViewActivity articleViewActivity = (ArticleViewActivity) obj;
        articleViewActivity.url = articleViewActivity.getIntent().getExtras() == null ? articleViewActivity.url : articleViewActivity.getIntent().getExtras().getString("url", articleViewActivity.url);
        articleViewActivity.title = articleViewActivity.getIntent().getExtras() == null ? articleViewActivity.title : articleViewActivity.getIntent().getExtras().getString("title", articleViewActivity.title);
    }
}
