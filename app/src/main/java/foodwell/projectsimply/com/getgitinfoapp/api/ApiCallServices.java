package foodwell.projectsimply.com.getgitinfoapp.api;

import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.api.responses.ReadmeResponse;
import foodwell.projectsimply.com.getgitinfoapp.api.responses.RepositoriesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCallServices {

    @GET("search/repositories?")
    Call<RepositoriesResponse> getReposFromApi(
            @Query("q") String language,
            @Query("sort") String sort,
            @Query("order") String desc,
            @Query("page") int page);

    @GET("repos/{full_name}/contents/README.md")
    Call<ReadmeResponse> getReadmeContentForRepository(@Path("full_name") String fullName);

}
