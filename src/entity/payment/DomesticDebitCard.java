package entity.payment;

public class DomesticDebitCard extends Card{
	private String issuingBank;
	private String fromDate;
	
	public DomesticDebitCard(String issuingBank, String cardNumber, String fromDate, String cardHolderName) {
		super(cardHolderName, cardNumber);
		this.issuingBank = issuingBank;
		this.fromDate = fromDate;
	}

    public String getIssueBank() {
        return issuingBank;
    }

    public void setIssueBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
}
