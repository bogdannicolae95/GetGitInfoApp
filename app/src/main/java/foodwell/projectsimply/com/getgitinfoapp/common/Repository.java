package foodwell.projectsimply.com.getgitinfoapp.common;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Base64;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Repository implements Serializable {
    private int repoId;
    private int stars;
    private String fullName;
    private String loginName;
    private String repoUrl;
    private int watchers;
    private int forks;
    private int openIssues;
    private String defaultBranch;
    private String readmeContent;
    private String repoName;

    public Repository(int repoId, String fullName, String loginName, String repoUrl, int wathers, int forks, int openIssues, String defaultBranch, String readmeContent,int stars,String repoName) {
        this.repoId = repoId;
        this.fullName = fullName;
        this.loginName = loginName;
        this.repoUrl = repoUrl;
        this.watchers = wathers;
        this.forks = forks;
        this.openIssues = openIssues;
        this.defaultBranch = defaultBranch;
        this.readmeContent = readmeContent;
        this.stars =stars;
        this.repoName = repoName;
    }

    public int getRepoId() {
        return repoId;
    }

    public int getStars() {
        return stars;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setRepoId(int repoId) {
        this.repoId = repoId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int wathers) {
        this.watchers = wathers;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getReadmeContent() {
        return readmeContent;
    }

    public void setReadmeContent(String readmeContent) {
        this.readmeContent = readmeContent;
    }


    public String getDecodeReadmeContent(){
        byte[] valueDecoded = new byte[0];
        valueDecoded = Base64.decode(readmeContent.getBytes(StandardCharsets.UTF_8),Base64.DEFAULT);
        return new String(valueDecoded);
    }
}
