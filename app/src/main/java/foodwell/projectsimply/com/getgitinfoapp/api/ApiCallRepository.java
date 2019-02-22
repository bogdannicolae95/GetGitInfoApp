package foodwell.projectsimply.com.getgitinfoapp.api;

import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.GetReposInfoApp;
import foodwell.projectsimply.com.getgitinfoapp.R;
import foodwell.projectsimply.com.getgitinfoapp.api.i.ReadmeResponseCallback;
import foodwell.projectsimply.com.getgitinfoapp.api.i.RepositoriesCallback;
import foodwell.projectsimply.com.getgitinfoapp.api.responses.ReadmeResponse;
import foodwell.projectsimply.com.getgitinfoapp.api.responses.RepositoriesResponse;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiCallRepository {
    private ApiCallServices apiCallServices;

    public ApiCallRepository() {
        Retrofit retrofit = new RetrofitConnectionFactory().createConnection(GetReposInfoApp.getStringRes(R.string.base_url));
        apiCallServices = retrofit.create(ApiCallServices.class);
    }

    public void getRepositoriesFromApi(final RepositoriesCallback repositoriesCallback,int page){

        Callback<RepositoriesResponse> callback = new Callback<RepositoriesResponse>() {
            @Override
            public void onResponse(Call<RepositoriesResponse> call, Response<RepositoriesResponse> response) {
                if(response.code() == 200){
                    repositoriesCallback.onSuccess(response.body(),response.headers());
                }else{
                    repositoriesCallback.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<RepositoriesResponse> call, Throwable t) {
                repositoriesCallback.onFail(t.getMessage());
            }
        };
        apiCallServices.getReposFromApi("java","stars","desc",page).enqueue(callback);
    }

    public void getReadmeForRepo(final ReadmeResponseCallback readmeResponseCallback, String loginUserName,String repoName){
        Callback<ReadmeResponse> callback = new Callback<ReadmeResponse>() {
            @Override
            public void onResponse(Call<ReadmeResponse> call, Response<ReadmeResponse> response) {
                if(response.code() == 200){
                    readmeResponseCallback.onSuccess(response.body());
                }else{
                    readmeResponseCallback.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<ReadmeResponse> call, Throwable t) {
                readmeResponseCallback.onFail(t.getMessage());
            }
        };
        apiCallServices.getReadmeContentForRepository(loginUserName,repoName).enqueue(callback);
    }
}
