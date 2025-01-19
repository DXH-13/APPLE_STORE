package Models;

public class Reviews {

    private int reviewID;
    private int accountID;
    private String reviewDate;
    private String comment;
    Accounts a;

    public Reviews() {
    }

    public Reviews(int reviewID, int accountID, String reviewDate, String comment) {
        this.reviewID = reviewID;
        this.accountID = accountID;
        this.reviewDate = reviewDate;
        this.comment = comment;
    }

    public Reviews(int reviewID, int accountID, String reviewDate, String comment, Accounts a) {
        this.reviewID = reviewID;
        this.accountID = accountID;
        this.reviewDate = reviewDate;
        this.comment = comment;
        this.a = a;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Accounts getA() {
        return a;
    }

    public void setA(Accounts a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Reviews{" + "reviewID=" + reviewID + ", accountID=" + accountID + ", reviewDate=" + reviewDate + ", comment=" + comment + ", a=" + a + '}';
    }
    
    
    

       
}
