package org.acme.domain;

/**
 * Class for modelling the response for a single word
 */
public class WordResponse {

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

    public WordResponse(String wordSupplied, boolean isProfanity) {
        this.wordSupplied = wordSupplied;
        this.isProfanity = isProfanity;
    }
}
