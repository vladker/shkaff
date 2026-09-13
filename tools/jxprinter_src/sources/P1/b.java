package P1;

import F4.f;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f561a;
    public final HashMap b = new HashMap();

    public b(Context context) {
        this.f561a = context;
    }

    public static void a(b bVar, MethodChannel.Result result, List list) {
        Iterator it;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Barcode barcode = (Barcode) it2.next();
            HashMap map = new HashMap();
            int valueType = barcode.getValueType();
            map.put("type", Integer.valueOf(valueType));
            map.put("format", Integer.valueOf(barcode.getFormat()));
            map.put("rawValue", barcode.getRawValue());
            map.put("rawBytes", barcode.getRawBytes());
            map.put("displayValue", barcode.getDisplayValue());
            map.put("rect", bVar.getBoundingPoints(barcode.getBoundingBox()));
            Point[] cornerPoints = barcode.getCornerPoints();
            ArrayList arrayList2 = new ArrayList();
            for (Point point : cornerPoints) {
                HashMap map2 = new HashMap();
                map2.put("x", Integer.valueOf(point.x));
                map2.put("y", Integer.valueOf(point.y));
                arrayList2.add(map2);
            }
            map.put("points", arrayList2);
            if (valueType != 1) {
                if (valueType == 2) {
                    map.put("address", barcode.getEmail().getAddress());
                    map.put("body", barcode.getEmail().getBody());
                    map.put("subject", barcode.getEmail().getSubject());
                    map.put("emailType", Integer.valueOf(barcode.getEmail().getType()));
                } else if (valueType == 4) {
                    map.put("number", barcode.getPhone().getNumber());
                    map.put("phoneType", Integer.valueOf(barcode.getPhone().getType()));
                } else if (valueType != 6) {
                    switch (valueType) {
                        case 8:
                            map.put("title", barcode.getUrl().getTitle());
                            map.put("url", barcode.getUrl().getUrl());
                            break;
                        case 9:
                            map.put("ssid", barcode.getWifi().getSsid());
                            map.put("password", barcode.getWifi().getPassword());
                            map.put("encryption", Integer.valueOf(barcode.getWifi().getEncryptionType()));
                            break;
                        case 10:
                            map.put("latitude", Double.valueOf(barcode.getGeoPoint().getLat()));
                            map.put("longitude", Double.valueOf(barcode.getGeoPoint().getLng()));
                            break;
                        case 11:
                            map.put("description", barcode.getCalendarEvent().getDescription());
                            map.put(FirebaseAnalytics.Param.LOCATION, barcode.getCalendarEvent().getLocation());
                            map.put(NotificationCompat.CATEGORY_STATUS, barcode.getCalendarEvent().getStatus());
                            map.put("summary", barcode.getCalendarEvent().getSummary());
                            map.put("organizer", barcode.getCalendarEvent().getOrganizer());
                            map.put("start", barcode.getCalendarEvent().getStart().getRawValue());
                            map.put("end", barcode.getCalendarEvent().getEnd().getRawValue());
                            break;
                        case 12:
                            map.put("addressCity", barcode.getDriverLicense().getAddressCity());
                            map.put("addressState", barcode.getDriverLicense().getAddressState());
                            map.put("addressZip", barcode.getDriverLicense().getAddressZip());
                            map.put("addressStreet", barcode.getDriverLicense().getAddressStreet());
                            map.put("issueDate", barcode.getDriverLicense().getIssueDate());
                            map.put("birthDate", barcode.getDriverLicense().getBirthDate());
                            map.put("expiryDate", barcode.getDriverLicense().getExpiryDate());
                            map.put("gender", barcode.getDriverLicense().getGender());
                            map.put("licenseNumber", barcode.getDriverLicense().getLicenseNumber());
                            map.put("firstName", barcode.getDriverLicense().getFirstName());
                            map.put("lastName", barcode.getDriverLicense().getLastName());
                            map.put("country", barcode.getDriverLicense().getIssuingCountry());
                            break;
                    }
                } else {
                    map.put(Constants.MESSAGE, barcode.getSms().getMessage());
                    map.put("number", barcode.getSms().getPhoneNumber());
                }
                it = it2;
            } else {
                map.put("firstName", barcode.getContactInfo().getName().getFirst());
                map.put("lastName", barcode.getContactInfo().getName().getLast());
                map.put("formattedName", barcode.getContactInfo().getName().getFormattedName());
                map.put("organization", barcode.getContactInfo().getOrganization());
                ArrayList arrayList3 = new ArrayList();
                for (Barcode.Address address : barcode.getContactInfo().getAddresses()) {
                    HashMap map3 = new HashMap();
                    Iterator it3 = it2;
                    map3.put("addressType", Integer.valueOf(address.getType()));
                    ArrayList arrayList4 = new ArrayList();
                    Collections.addAll(arrayList4, address.getAddressLines());
                    map3.put("addressLines", arrayList4);
                    arrayList3.add(map3);
                    it2 = it3;
                }
                it = it2;
                map.put("addresses", arrayList3);
                ArrayList arrayList5 = new ArrayList();
                for (Barcode.Phone phone : barcode.getContactInfo().getPhones()) {
                    HashMap map4 = new HashMap();
                    map4.put("number", phone.getNumber());
                    map4.put("phoneType", Integer.valueOf(phone.getType()));
                    arrayList5.add(map4);
                }
                map.put("phones", arrayList5);
                ArrayList arrayList6 = new ArrayList();
                for (Barcode.Email email : barcode.getContactInfo().getEmails()) {
                    HashMap map5 = new HashMap();
                    map5.put("address", email.getAddress());
                    map5.put("body", email.getBody());
                    map5.put("subject", email.getSubject());
                    map5.put("emailType", Integer.valueOf(email.getType()));
                    arrayList6.add(map5);
                }
                map.put("emails", arrayList6);
                map.put("urls", new ArrayList(barcode.getContactInfo().getUrls()));
            }
            arrayList.add(map);
            it2 = it;
        }
        result.success(arrayList);
    }

    private Map<String, Integer> getBoundingPoints(@Nullable Rect rect) {
        HashMap map = new HashMap();
        if (rect == null) {
            return map;
        }
        map.put("left", Integer.valueOf(rect.left));
        map.put("right", Integer.valueOf(rect.right));
        map.put("top", Integer.valueOf(rect.top));
        map.put("bottom", Integer.valueOf(rect.bottom));
        return map;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        BarcodeScannerOptions barcodeScannerOptionsBuild;
        String str = methodCall.method;
        str.getClass();
        boolean zEquals = str.equals("vision#startBarcodeScanner");
        HashMap map = this.b;
        if (!zEquals) {
            if (!str.equals("vision#closeBarcodeScanner")) {
                result.notImplemented();
                return;
            }
            String str2 = (String) methodCall.argument("id");
            BarcodeScanner barcodeScanner = (BarcodeScanner) map.get(str2);
            if (barcodeScanner != null) {
                barcodeScanner.close();
                map.remove(str2);
            }
            result.success(null);
            return;
        }
        InputImage inputImageA = Q1.b.a((Map) methodCall.argument("imageData"), this.f561a, result);
        if (inputImageA == null) {
            return;
        }
        String str3 = (String) methodCall.argument("id");
        BarcodeScanner client = (BarcodeScanner) map.get(str3);
        int i5 = 0;
        if (client == null) {
            List list = (List) methodCall.argument("formats");
            if (list.size() > 1) {
                int[] iArr = new int[list.size()];
                for (int i6 = 1; i6 < list.size(); i6++) {
                    iArr[i6] = ((Integer) list.get(i6)).intValue();
                }
                barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(((Integer) list.get(0)).intValue(), iArr).build();
            } else {
                barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(((Integer) list.get(0)).intValue(), new int[0]).build();
            }
            client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
            map.put(str3, client);
        }
        client.process(inputImageA).addOnSuccessListener(new f(this, result, 2)).addOnFailureListener(new a(result, i5));
    }
}
