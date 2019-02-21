package foodwell.projectsimply.com.getgitinfoapp;


import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import foodwell.projectsimply.com.getgitinfoapp.common.Repository;


public class RepositoryDetailFragment  {

    public static void showRepositoryDetail(Context context,Repository repository) {
        Dialog dialog = new Dialog(context,R.style.FullScreenDialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.repository_detail_layout);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setCanceledOnTouchOutside(false);

        TextView repoFullName = dialog.findViewById(R.id.repository_full_name);
        repoFullName.setText(repository.getFullName());

        TextView repoReadMe = dialog.findViewById(R.id.repository_login_name);
        if(repository.getReadmeContent() != null && !repository.getReadmeContent().isEmpty()){
            repoReadMe.setText(repository.getFullName());
        }else{
            repoReadMe.setText(GetReposInfoApp.getStringRes(R.string.not_readme));
        }

        dialog.show();
    }

}
