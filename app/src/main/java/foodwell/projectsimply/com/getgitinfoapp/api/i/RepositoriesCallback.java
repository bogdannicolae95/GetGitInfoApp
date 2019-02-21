package foodwell.projectsimply.com.getgitinfoapp.api.i;

import foodwell.projectsimply.com.getgitinfoapp.api.responses.RepositoriesResponse;
import okhttp3.Headers;

public interface RepositoriesCallback {
    void onSuccess(RepositoriesResponse responses, Headers headers);
    void onFail(String message);
}
