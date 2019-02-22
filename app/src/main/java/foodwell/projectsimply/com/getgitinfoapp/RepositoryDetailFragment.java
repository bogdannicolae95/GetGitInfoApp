package foodwell.projectsimply.com.getgitinfoapp;


import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import foodwell.projectsimply.com.getgitinfoapp.common.Repository;

import static android.text.Html.fromHtml;


public class RepositoryDetailFragment  {

    public static void showRepositoryDetail(Context context,Repository repository) {
        Dialog dialog = new Dialog(context,R.style.FullScreenDialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.repository_detail_layout);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setCanceledOnTouchOutside(false);

        TextView watchersCount = dialog.findViewById(R.id.watchers_count);
        watchersCount.setText(String.valueOf(repository.getWatchers()));

        TextView starsCount = dialog.findViewById(R.id.stars_count);
        starsCount.setText(String.valueOf(repository.getStars()));

        TextView forksCount = dialog.findViewById(R.id.forks_count);
        forksCount.setText(String.valueOf(repository.getForks()));

        TextView repoID = dialog.findViewById(R.id.repository_id_value);
        repoID.setText(String.valueOf(repository.getRepoId()));

        TextView repoFullName= dialog.findViewById(R.id.repository_full_name_value);
        repoFullName.setText(String.valueOf(repository.getFullName()));

        TextView repoUserLoginName= dialog.findViewById(R.id.repository_login_name_value);
        repoUserLoginName.setText(String.valueOf(repository.getLoginName()));

        TextView repoUrl= dialog.findViewById(R.id.repository_url_value);
        repoUrl.setText(repository.getRepoUrl());

        TextView repoOpenIssues= dialog.findViewById(R.id.repository_open_issues_value);
        repoOpenIssues.setText(String.valueOf(repository.getOpenIssues()));

        TextView repoDefaultBranch= dialog.findViewById(R.id.repository_default_branch_value);
        repoDefaultBranch.setText(repository.getDefaultBranch());

        TextView readMeContent = dialog.findViewById(R.id.repository_readme_value);
        if(repository.getReadmeContent() != null && !repository.getReadmeContent().isEmpty()){
            readMeContent.setText(repository.getDecodeReadmeContent());
        }else{
            readMeContent.setText(GetReposInfoApp.getStringRes(R.string.not_readme));
        }

        dialog.show();
    }

}
