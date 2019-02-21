package foodwell.projectsimply.com.getgitinfoapp.ux.i;

import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.common.Repository;

public interface ViewInterface {
    void showListOfRepositories(List<Repository> repositoriesList);

    void stopLoaderForFailListFetched();

    void readmeSetSuccessfully(Repository repository);

    void readmeSetFail(Repository repository);
}
