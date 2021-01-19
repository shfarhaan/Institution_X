package com.example.institutionx;

public class StreamDetails {
    String userName, time, postDetail, numberOfComments;

    public StreamDetails(String userName, String time, String postDetail, String numberOfComments) {
        this.userName = userName;
        this.time = time;
        this.postDetail = postDetail;
        this.numberOfComments = numberOfComments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(String postDetail) {
        this.postDetail = postDetail;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
