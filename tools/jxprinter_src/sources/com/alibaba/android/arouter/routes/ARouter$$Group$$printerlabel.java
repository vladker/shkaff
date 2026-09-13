package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.page.printerlabel.PublishToIndustryActivity;
import com.appdev.standard.page.printerlabel.PublishToSquareActivity;
import com.appdev.standard.page.printerlabel.TemplateEditActivity;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$printerlabel implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(DefaultRouteConstant.ACTIVITY_PUBLISH_TO_INDUSTRY, RouteMeta.build(routeType, PublishToIndustryActivity.class, "/printerlabel/publishtoindustryactivity", "printerlabel", null, -1, Integer.MIN_VALUE));
        map.put(DefaultRouteConstant.ACTIVITY_PUBLISH_TO_SQUARE, RouteMeta.build(routeType, PublishToSquareActivity.class, "/printerlabel/publishtosquareactivity", "printerlabel", null, -1, Integer.MIN_VALUE));
        map.put(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT, RouteMeta.build(routeType, TemplateEditActivity.class, "/printerlabel/templateeditactivity", "printerlabel", null, -1, Integer.MIN_VALUE));
    }
}
