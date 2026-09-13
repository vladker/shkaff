package com.sandu.JxPrinter.config;

import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.model.ElementAttributePictureBean;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.appdev.standard.page.printerlabel.PicturePrintActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.orhanobut.hawk.Hawk;
import com.sandu.JxPrinter.R;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.json.JSONArray;
import org.json.JSONException;
import org.opencv.videoio.Videoio;
import p042h2.d;
import p052j2.c;
import p134x2.C1849c;
import p134x2.P0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements FlutterBoostDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainApp f3685a;

    public a(MainApp mainApp) {
        this.f3685a = mainApp;
    }

    @Override // com.idlefish.flutterboost.FlutterBoostDelegate
    public final void pushFlutterRoute(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        Intent intentBuild = new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).uniqueId(flutterBoostRouteOptions.uniqueId()).url(flutterBoostRouteOptions.pageName()).urlParams(flutterBoostRouteOptions.arguments()).build(FlutterBoost.instance().currentActivity());
        if (flutterBoostRouteOptions.requestCode() != 0) {
            FlutterBoost.instance().currentActivity().startActivityForResult(intentBuild, flutterBoostRouteOptions.requestCode());
        } else {
            FlutterBoost.instance().currentActivity().startActivity(intentBuild);
        }
    }

    @Override // com.idlefish.flutterboost.FlutterBoostDelegate
    public final void pushNativeRoute(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        int ratio;
        int ratio2;
        int i5;
        if (flutterBoostRouteOptions.pageName().equals("picture_print")) {
            new Intent(FlutterBoost.instance().currentActivity(), (Class<?>) PicturePrintActivity.class);
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PICTURE_PRINT).withString("path", (String) flutterBoostRouteOptions.arguments().get(Constants.FILE)).withBoolean("rotate", false).navigation();
            return;
        }
        if (flutterBoostRouteOptions.pageName().equals("print_device_info")) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_PRINT_DEVICE_INFO);
            return;
        }
        boolean zEquals = flutterBoostRouteOptions.pageName().equals("printer_template_edit");
        MainApp mainApp = this.f3685a;
        if (zEquals) {
            Map<String, Object> mapArguments = flutterBoostRouteOptions.arguments();
            String string = (String) mapArguments.get("createLabelName");
            String str = (String) mapArguments.get("createLabelWidth");
            String str2 = (String) mapArguments.get("createLabelHeight");
            String str3 = (String) mapArguments.get("createLabelColumns");
            String str4 = (String) mapArguments.get("createLabelSpacing");
            String str5 = (String) mapArguments.get("backgroundImagePath");
            String str6 = (String) mapArguments.get("borderImagePath");
            Integer num = (Integer) mapArguments.get("createLabelPaperType");
            Integer num2 = (Integer) mapArguments.get("rotate");
            ArrayList arrayList = new ArrayList();
            if (mapArguments.containsKey("textElements")) {
                for (Iterator it = ((List) mapArguments.get("textElements")).iterator(); it.hasNext(); it = it) {
                    arrayList.add(c.c(Object.class, (String) it.next()));
                }
            }
            if (Y.f(str) || Y.f(str2)) {
                d.show(R.string.please_enter_width_and_height);
                return;
            }
            Hawk.put("defaultLabelSizeWidth", str);
            Hawk.put("defaultLabelSizeHeight", str2);
            StringBuilder sb = new StringBuilder("Navigating to printer_template_edit with parameters: labelName: ");
            androidx.collection.a.y(sb, string, ", width: ", str, ", height: ");
            androidx.collection.a.y(sb, str2, ", column: ", str3, ", spacing: ");
            androidx.collection.a.y(sb, str4, ", backgroundImagePath: ", str5, ",paperType:");
            sb.append(num);
            sb.append(",rotate:");
            sb.append(num2);
            p051j0.a.c("FlutterBoost", sb.toString());
            if (Y.f(string)) {
                string = mainApp.getString(R.string.text_400);
            }
            TemplateConfigBean templateConfigBean = new TemplateConfigBean(string, Integer.parseInt(str), Integer.parseInt(str2), (Y.f(str3) || Integer.parseInt(str3) <= 0) ? 1 : Integer.parseInt(str3), (Y.f(str4) || Integer.parseInt(str4) < 0) ? 2 : Integer.parseInt(str4), null, str5, str6, num.intValue(), num2.intValue());
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_template_config", templateConfigBean);
            if (str5 != null && str5.startsWith("content://")) {
                bundle.putString("background_uri", str5);
            }
            if (arrayList.size() > 0) {
                bundle.putString("data_template_content", c.e(arrayList));
            }
            p051j0.a.c("printer_template_edit", "旋转方向" + num2);
            bundle.putString("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
            bundle.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).withFlags(1).navigation();
            return;
        }
        boolean zEquals2 = flutterBoostRouteOptions.pageName().equals("industr_templates_printer_template_edit");
        String str7 = "ViewContent";
        String str8 = "Content: ";
        String str9 = FirebaseAnalytics.Param.CONTENT;
        if (zEquals2) {
            Map<String, Object> mapArguments2 = flutterBoostRouteOptions.arguments();
            if (mapArguments2 == null) {
                p051j0.a.d("Error", "No arguments received.");
                return;
            }
            String stringArg = mainApp.getStringArg(mapArguments2, "labelName", "");
            String stringArg2 = mainApp.getStringArg(mapArguments2, "width", "50");
            String stringArg3 = mainApp.getStringArg(mapArguments2, "height", "30");
            String stringArg4 = mainApp.getStringArg(mapArguments2, "columns", "1");
            String stringArg5 = mainApp.getStringArg(mapArguments2, "columnMargin", ExifInterface.GPS_MEASUREMENT_2D);
            String stringArg6 = mainApp.getStringArg(mapArguments2, "viewsJson", "[]");
            String stringArg7 = mainApp.getStringArg(mapArguments2, "printerLabelBgUrl", null);
            String stringArg8 = mainApp.getStringArg(mapArguments2, "printerLabelBorderUrl", null);
            String stringArg9 = mainApp.getStringArg(mapArguments2, "paperType", "0");
            String stringArg10 = mainApp.getStringArg(mapArguments2, "templateId", null);
            int rotateInt = mainApp.getRotateInt(mapArguments2, 0);
            p051j0.a.c("ReceivedData", "LabelName: " + stringArg);
            p051j0.a.c("ReceivedData", "LabelWidth: " + stringArg2);
            p051j0.a.c("ReceivedData", "LabelHeight: " + stringArg3);
            p051j0.a.c("ReceivedData", "Columns: " + stringArg4);
            p051j0.a.c("ReceivedData", "ColumnMargin: " + stringArg5);
            p051j0.a.c("ReceivedData", "ViewsJson: " + stringArg6);
            p051j0.a.c("ReceivedData", "PrinterLabelBgUrl: " + stringArg7);
            p051j0.a.c("ReceivedData", "PrinterLabelBorderUrl: " + stringArg8);
            p051j0.a.c("ReceivedData", "PaperType: " + stringArg9);
            p051j0.a.c("ReceivedData", "TemplateId: " + stringArg10);
            p051j0.a.c("ReceivedData", "Rotate: " + rotateInt);
            try {
                JSONArray jSONArray = new JSONArray(stringArg6);
                int i6 = 0;
                while (i6 < jSONArray.length()) {
                    i5 = rotateInt;
                    String str10 = str9;
                    try {
                        String strOptString = jSONArray.getJSONObject(i6).optString(str10, "");
                        JSONArray jSONArray2 = jSONArray;
                        StringBuilder sb2 = new StringBuilder();
                        str9 = str10;
                        String str11 = str8;
                        sb2.append(str11);
                        sb2.append(strOptString);
                        String str12 = str7;
                        p051j0.a.c(str12, sb2.toString());
                        i6++;
                        jSONArray = jSONArray2;
                        str8 = str11;
                        str7 = str12;
                        rotateInt = i5;
                    } catch (JSONException e) {
                        e = e;
                        p051j0.a.e("JSONError", "Error parsing viewsJson", e);
                        TemplateConfigBean templateConfigBean2 = new TemplateConfigBean(stringArg, mainApp.parseIntSafely(stringArg2, 0), mainApp.parseIntSafely(stringArg3, 0), mainApp.parseIntSafely(stringArg4, 0), mainApp.parseIntSafely(stringArg5, 0), stringArg10, stringArg7, stringArg8, mainApp.parseIntSafely(stringArg9, 0), i5);
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("data_template_config", templateConfigBean2);
                        bundle2.putString("data_template_content", stringArg6);
                        bundle2.putInt("data_print_data_source", 1);
                        bundle2.putString("data_print_cover_url", stringArg7);
                        bundle2.putString("data_print_title", stringArg);
                        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle2).navigation();
                        return;
                    }
                }
                i5 = rotateInt;
            } catch (JSONException e6) {
                e = e6;
                i5 = rotateInt;
            }
            TemplateConfigBean templateConfigBean3 = new TemplateConfigBean(stringArg, mainApp.parseIntSafely(stringArg2, 0), mainApp.parseIntSafely(stringArg3, 0), mainApp.parseIntSafely(stringArg4, 0), mainApp.parseIntSafely(stringArg5, 0), stringArg10, stringArg7, stringArg8, mainApp.parseIntSafely(stringArg9, 0), i5);
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("data_template_config", templateConfigBean3);
            bundle3.putString("data_template_content", stringArg6);
            bundle3.putInt("data_print_data_source", 1);
            bundle3.putString("data_print_cover_url", stringArg7);
            bundle3.putString("data_print_title", stringArg);
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle3).navigation();
            return;
        }
        String str13 = str7;
        if (flutterBoostRouteOptions.pageName().equals("similar_label_details")) {
            Map<String, Object> mapArguments3 = flutterBoostRouteOptions.arguments();
            if (mapArguments3 == null) {
                p051j0.a.d("Error", "No arguments received.");
                return;
            }
            String stringArg11 = mainApp.getStringArg(mapArguments3, "labelName", "");
            String stringArg12 = mainApp.getStringArg(mapArguments3, "width", "50");
            String stringArg13 = mainApp.getStringArg(mapArguments3, "height", "30");
            String stringArg14 = mainApp.getStringArg(mapArguments3, "columns", "1");
            String stringArg15 = mainApp.getStringArg(mapArguments3, "columnMargin", ExifInterface.GPS_MEASUREMENT_2D);
            String stringArg16 = mainApp.getStringArg(mapArguments3, "viewsJson", "[]");
            String stringArg17 = mainApp.getStringArg(mapArguments3, "background", null);
            String stringArg18 = mainApp.getStringArg(mapArguments3, "borderUrl", null);
            String stringArg19 = mainApp.getStringArg(mapArguments3, "paperType", "0");
            String stringArg20 = mainApp.getStringArg(mapArguments3, "templateId", null);
            int rotateInt2 = mainApp.getRotateInt(mapArguments3, 0);
            try {
                JSONArray jSONArray3 = new JSONArray(stringArg16);
                int i7 = 0;
                while (i7 < jSONArray3.length()) {
                    String str14 = str9;
                    String strOptString2 = jSONArray3.getJSONObject(i7).optString(str14, "");
                    StringBuilder sb3 = new StringBuilder();
                    String str15 = str8;
                    sb3.append(str15);
                    sb3.append(strOptString2);
                    String str16 = str13;
                    p051j0.a.c(str16, sb3.toString());
                    i7++;
                    str9 = str14;
                    str8 = str15;
                    str13 = str16;
                }
            } catch (JSONException e7) {
                p051j0.a.e("JSONError", "Error parsing viewsJson", e7);
            }
            TemplateConfigBean templateConfigBean4 = new TemplateConfigBean(stringArg11, mainApp.parseIntSafely(stringArg12, 0), mainApp.parseIntSafely(stringArg13, 0), mainApp.parseIntSafely(stringArg14, 0), mainApp.parseIntSafely(stringArg15, 0), stringArg20, stringArg17, stringArg18, mainApp.parseIntSafely(stringArg19, 0), rotateInt2);
            Bundle bundle4 = new Bundle();
            bundle4.putSerializable("data_template_config", templateConfigBean4);
            bundle4.putString("data_template_content", stringArg16);
            bundle4.putInt("data_print_data_source", 2);
            bundle4.putString("data_print_cover_url", stringArg17);
            bundle4.putString("data_print_title", stringArg11);
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle4).navigation();
            return;
        }
        if (flutterBoostRouteOptions.pageName().equals("web_printing")) {
            new Intent(FlutterBoost.instance().currentActivity(), (Class<?>) PicturePrintActivity.class);
            ARouter.getInstance().build("/app/web_print").withString("url", (String) flutterBoostRouteOptions.arguments().get("url")).withBoolean("rotate", false).navigation();
            return;
        }
        if (flutterBoostRouteOptions.pageName().equals("banner_printing")) {
            new Intent(FlutterBoost.instance().currentActivity(), (Class<?>) PicturePrintActivity.class);
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PICTURE_PRINT).withString("path", "banner_printing::" + flutterBoostRouteOptions.arguments().get(Constants.FILE)).withBoolean("rotate", false).navigation();
            return;
        }
        if (flutterBoostRouteOptions.pageName().equals("footage_edit")) {
            ArrayList arrayList2 = new ArrayList();
            try {
                Map<String, Object> mapArguments4 = flutterBoostRouteOptions.arguments();
                if (mapArguments4 == null) {
                    d.a("参数错误");
                    return;
                }
                String str17 = (String) mapArguments4.get("image_path");
                int intSafely = mainApp.parseIntSafely((String) mapArguments4.get("img_width"), 0);
                int intSafely2 = mainApp.parseIntSafely((String) mapArguments4.get("img_height"), 0);
                P0 p0H = p051j0.a.h();
                if (p0H != null) {
                    ratio = p0H.d / C1849c.getRatio();
                    ratio2 = ((p0H.d / C1849c.getRatio()) * intSafely2) / intSafely;
                } else {
                    ratio = intSafely / C1849c.getRatio();
                    ratio2 = intSafely2 / C1849c.getRatio();
                }
                ElementAttributePictureBean elementAttributePictureBean = new ElementAttributePictureBean();
                elementAttributePictureBean.setElementType(6);
                elementAttributePictureBean.setContent(str17);
                elementAttributePictureBean.setX(0.0f);
                elementAttributePictureBean.setY(0.0f);
                elementAttributePictureBean.setWidth(ratio);
                elementAttributePictureBean.setHeight(ratio2);
                arrayList2.add(0, elementAttributePictureBean);
                TemplateConfigBean templateConfigBean5 = new TemplateConfigBean(Y.f("") ? mainApp.getString(R.string.text_400) : "", ratio, ratio2, (Y.f("1") || Integer.parseInt("1") <= 0) ? 1 : Integer.parseInt("1"), (Y.f(ExifInterface.GPS_MEASUREMENT_2D) || Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D) < 0) ? 2 : Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D));
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("data_template_config", templateConfigBean5);
                bundle5.putString("data_template_content", c.e(arrayList2));
                bundle5.putInt("data_print_data_source", 6);
                bundle5.putString("data_print_title", templateConfigBean5.getName());
                String strValueOf = String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100);
                bundle5.putString("personLabelId", strValueOf + System.currentTimeMillis() + strValueOf);
                bundle5.putString("cloudLabelId", strValueOf + System.currentTimeMillis() + strValueOf);
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle5).navigation();
            } catch (Exception e8) {
                p051j0.a.e("RouteHandler", "处理异常", e8);
                d.a("系统错误");
            }
        }
    }
}
