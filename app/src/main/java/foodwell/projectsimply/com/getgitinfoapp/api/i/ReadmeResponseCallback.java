package foodwell.projectsimply.com.getgitinfoapp.api.i;

import foodwell.projectsimply.com.getgitinfoapp.api.responses.ReadmeResponse;

public interface ReadmeResponseCallback {
    void onSuccess(ReadmeResponse readmeResponse);
    void onFail(String message);
}
