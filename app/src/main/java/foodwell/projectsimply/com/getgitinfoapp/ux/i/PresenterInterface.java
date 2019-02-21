package foodwell.projectsimply.com.getgitinfoapp.ux.i;

import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.common.Repository;

public interface PresenterInterface {
    void setListOfRepositories(List<Repository> repositoriesList);

    void listOfRepositoriesFetchedFail();

    void getReadmeSucces(Repository repository);

    void getReadmeFail(Repository repository);
}
