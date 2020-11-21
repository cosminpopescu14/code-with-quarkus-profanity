package org.acme.models;

public class CommentResponse {
    private String comment;

    private boolean containBadWords;
    private int numberOfWords;
    private double percentage;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isContainBadWords() {
        return containBadWords;
    }

    public void setContainBadWords(boolean containBadWords) {
        this.containBadWords = containBadWords;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public CommentResponse(String comment, boolean containBadWords, int numberOfWords, double percentage) {
        this.comment = comment;
        this.containBadWords = containBadWords;
        this.percentage = percentage;
        this.numberOfWords = numberOfWords;
    }

    @Override
    public String toString() {
        return "CommentResponse{" +
               "comment='" + comment + '\'' +
               ", containBadWords=" + containBadWords +
               ", numberOfWords=" + numberOfWords +
               ", percentage=" + percentage +
               '}';
    }
}
