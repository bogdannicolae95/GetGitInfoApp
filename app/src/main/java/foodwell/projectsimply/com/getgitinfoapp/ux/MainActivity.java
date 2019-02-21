package foodwell.projectsimply.com.getgitinfoapp.ux;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import foodwell.projectsimply.com.getgitinfoapp.R;
import foodwell.projectsimply.com.getgitinfoapp.RepositoryDetailFragment;
import foodwell.projectsimply.com.getgitinfoapp.common.Repository;
import foodwell.projectsimply.com.getgitinfoapp.ux.adapters.RepositoriesAdapter;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.OnBottomReachedListener;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.OnRecyclerItemClicked;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.ViewInterface;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements ViewInterface , OnBottomReachedListener, OnRecyclerItemClicked {

    public Unbinder unbinder;
    MainActivityPresenter presenter;

    @BindView(R.id.repositories_recyclerview)
    RecyclerView repositoriesRecyclerView;

    @BindView(R.id.loadingLayout)
    FrameLayout loadingView;

    RepositoriesAdapter repositoriesAdapter;
    int nrOfPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        presenter = new MainActivityPresenter(this);
        getLifecycle().addObserver(presenter);

        initViews();

        startGettingRepositories();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(presenter);
        unbinder.unbind();
        nrOfPage = 1;
    }

    public void startGettingRepositories(){
        loadingView.setVisibility(VISIBLE);
        presenter.getListOfRepositories(nrOfPage);
    }

    @Override
    public void showListOfRepositories(List<Repository> repositoriesList) {
        loadingView.setVisibility(GONE);
        repositoriesAdapter.setListOfRepositories(repositoriesList);
    }

    @Override
    public void stopLoaderForFailListFetched() {
        loadingView.setVisibility(GONE);
    }

    private void initViews(){
        repositoriesAdapter = new RepositoriesAdapter(this);
        repositoriesRecyclerView.setAdapter(repositoriesAdapter);
        repositoriesRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        repositoriesAdapter.setOnRecyclerItemClicked(this);
    }

    @Override
    public void onBottomReached() {
        loadingView.setVisibility(VISIBLE);
        presenter.getListOfRepositories(++nrOfPage);
    }

    @Override
    public void onItemClick(Repository repository) {
        presenter.getReadmeForRepository(repository);
    }

    @Override
    public void readmeSetSuccessfully(Repository repository) {
        RepositoryDetailFragment.showRepositoryDetail(this,repository);
    }

    @Override
    public void readmeSetFail(Repository repository) {
        RepositoryDetailFragment.showRepositoryDetail(this,repository);
    }
}
