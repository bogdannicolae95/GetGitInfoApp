package foodwell.projectsimply.com.getgitinfoapp;

import android.app.Application;
import android.support.annotation.StringRes;
import android.widget.Toast;

public class GetReposInfoApp extends Application {
    protected static GetReposInfoApp currentApp;

    public GetReposInfoApp(){
        currentApp = this;
    }

    public static GetReposInfoApp getCurrentApp() {
        return currentApp;
    }

    public static String getStringRes(@StringRes int stringRes){
        return currentApp.getString(stringRes);
    }

    public static void notifyWithToast(String message,int duration){
        Toast.makeText(getCurrentApp(),message,duration).show();
    }
}
