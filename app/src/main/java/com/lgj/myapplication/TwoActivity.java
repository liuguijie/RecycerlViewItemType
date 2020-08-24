package com.lgj.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

/**
 * @author 刘桂杰
 * @package com.lgj.myapplication
 * @date 2020/8/14 11:10
 * @description $
 */
public class TwoActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);
        ImageView image = findViewById(R.id.img);
        Bitmap ableBitmap = getDecodeAbleBitmap("/storage/emulated/0/DCIM/WeixinWork/mmexport1597891896169.jpg");
        image.setImageBitmap(ableBitmap);
    }

    private Bitmap getDecodeAbleBitmap(String picturePath) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(picturePath, options);
            int sampleSize = options.outHeight / 400;
            if (sampleSize <= 0) {
                sampleSize = 1;
            }
            options.inSampleSize = sampleSize;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeFile(picturePath, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @author 刘桂杰
     * @date 2020/8/21
     * @description android 11检测5G网络
     */
    public void checkInternet() {
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        manager.listen(new PhoneStateListener() {
            @Override
            public void onDisplayInfoChanged(@NonNull TelephonyDisplayInfo telephonyDisplayInfo) {
                if (ActivityCompat.checkSelfPermission(TwoActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                super.onDisplayInfoChanged(telephonyDisplayInfo);
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                if (overrideNetworkType == TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_LTE_ADVANCED_PRO) {
                    //高级专业版
                }
                if (overrideNetworkType == TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_NR_NSA) {
                    // 	NR (5G) - 5G Sub-6 网络
                }
                if (overrideNetworkType == TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_NR_NSA_MMWAVE) {
                    //5G+/5G UW - 5G mmWave 网络
                }
            }
        }, PhoneStateListener.LISTEN_DISPLAY_INFO_CHANGED);
    }
}
