package jcp.com.exiyou.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;



public class NetUtil {

    // 判断是否有网
    public static boolean getNetState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            // 没有网的时候弹出提示,返回false
            Toast.makeText(context, "无网络连接,请检查你的网络设置", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            // 返回true
            return true;
        }
    }
}
