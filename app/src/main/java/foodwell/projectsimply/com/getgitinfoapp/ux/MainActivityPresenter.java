package foodwell.projectsimply.com.getgitinfoapp.ux;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.common.Repository;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.PresenterInterface;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.ViewInterface;

public class MainActivityPresenter implements PresenterInterface, LifecycleObserver {

    private ViewInterface viewInterface;
    private MainActivitModel model;

    public MainActivityPresenter(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        this.model = new MainActivitModel(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void clearData(){
        model.clear();
    }

    public void getListOfRepositories(int page) {
        model.getRepositoriesFromGit(page);
    }

    @Override
    public void setListOfRepositories(List<Repository> repositoriesList) {
        viewInterface.showListOfRepositories(repositoriesList);
    }

    @Override
    public void listOfRepositoriesFetchedFail() {
        viewInterface.stopLoaderForFailListFetched();
    }

    @Override
    public void getReadmeSucces(Repository repository) {
        viewInterface.readmeSetSuccessfully(repository);
    }

    @Override
    public void getReadmeFail(Repository repository) {
        viewInterface.readmeSetFail(repository);
    }

    public void getReadmeForRepository(Repository repository) {
        model.getReadmeForSelectedRepository(repository);
    }
}
