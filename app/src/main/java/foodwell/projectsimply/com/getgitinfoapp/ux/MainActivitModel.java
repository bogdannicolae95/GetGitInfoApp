package foodwell.projectsimply.com.getgitinfoapp.ux;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.GetReposInfoApp;
import foodwell.projectsimply.com.getgitinfoapp.api.ApiCallRepository;
import foodwell.projectsimply.com.getgitinfoapp.api.i.ReadmeResponseCallback;
import foodwell.projectsimply.com.getgitinfoapp.api.i.RepositoriesCallback;
import foodwell.projectsimply.com.getgitinfoapp.api.responses.ItemResponse;
import foodwell.projectsimply.com.getgitinfoapp.api.responses.ReadmeResponse;
import foodwell.projectsimply.com.getgitinfoapp.api.responses.RepositoriesResponse;
import foodwell.projectsimply.com.getgitinfoapp.common.Repository;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.PresenterInterface;
import okhttp3.Headers;

public class MainActivitModel {
    PresenterInterface presenterInterface;
    List<Repository> repositoriesList;


    public MainActivitModel(PresenterInterface presenterInterface) {
        this.presenterInterface = presenterInterface;
        repositoriesList = new ArrayList<>();
    }

    public List<Repository> getRepositoriesList() {
        return repositoriesList;
    }

    public void getRepositoriesFromGit(int page){
        new ApiCallRepository().getRepositoriesFromApi(new RepositoriesCallback() {
            @Override
            public void onSuccess(RepositoriesResponse responses, Headers headers) {
                int nrOfPages = responses.getTotalCount() / 30;
                if (responses.getTotalCount() % 30 != 0) {
                    nrOfPages += 1;
                }
                if (page <= nrOfPages) {
                    for (ItemResponse item : responses.getItems()) {
                        final Repository currentRep = new Repository(item.getId(), item.getFullName(), item.getOwner().getLogin(), item.getHtmlUrl(), item.getWatchers(), item.getForks(), item.getOpenIssues(), item.getDefaultBranch(), "",item.getStargazersCount(),item.getName());
                        repositoriesList.add(currentRep);
                    }
                    presenterInterface.setListOfRepositories(repositoriesList);
                }else{
                    GetReposInfoApp.notifyWithToast("No more repositories to load!",Toast.LENGTH_SHORT);
                }
            }


            @Override
            public void onFail(String message) {
                GetReposInfoApp.notifyWithToast(message, Toast.LENGTH_SHORT);
                presenterInterface.listOfRepositoriesFetchedFail();
            }
        },page);

   }

   public void getReadmeForSelectedRepository(Repository repository) {
       if (repository.getReadmeContent().isEmpty()){
           new ApiCallRepository().getReadmeForRepo(new ReadmeResponseCallback() {
               @Override
               public void onSuccess(ReadmeResponse readmeResponse) {
                   repository.setReadmeContent(readmeResponse.getContent());
                   presenterInterface.getReadmeSucces(repository);
               }

               @Override
               public void onFail(String message) {
                   presenterInterface.getReadmeFail(repository);
               }
           }, repository.getLoginName(), repository.getRepoName());
       }else{
           presenterInterface.getReadmeSucces(repository);
       }
   }



    public void clear() {
        repositoriesList.clear();
    }
}
