package com.appdev.standard.page.printerlabel;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PicturePrintActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        PicturePrintActivity picturePrintActivity = (PicturePrintActivity) obj;
        picturePrintActivity.path = picturePrintActivity.getIntent().getExtras() == null ? picturePrintActivity.path : picturePrintActivity.getIntent().getExtras().getString("path", picturePrintActivity.path);
        picturePrintActivity.isRotate = picturePrintActivity.getIntent().getBooleanExtra("rotate", picturePrintActivity.isRotate);
    }
}
