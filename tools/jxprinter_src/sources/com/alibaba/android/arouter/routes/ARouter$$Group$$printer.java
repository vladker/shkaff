package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.appdev.standard.page.printerlabel.ImagePreviewActivity;
import java.util.Map;
import p036g.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$printer implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        a aVar = new a();
        aVar.put("image_path", 8);
        map.put("/printer/imagePreview", RouteMeta.build(routeType, ImagePreviewActivity.class, "/printer/imagepreview", "printer", aVar, -1, Integer.MIN_VALUE));
    }
}
