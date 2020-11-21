package org.acme.models;

public class Response {

    private String wordSupplied;
    private boolean isProfanity;


    public String getWordSupplied() {
        return wordSupplied;
    }

    public void setWordSupplied(String wordSupplied) {
        this.wordSupplied = wordSupplied;
    }

    public boolean isProfanity() {
        return isProfanity;
    }

    public void setProfanity(boolean profanity) {
        isProfanity = profanity;
    }

    public Response(String wordSupplied, boolean isProfanity) {
        this.wordSupplied = wordSupplied;
        this.isProfanity = isProfanity;
    }
}
