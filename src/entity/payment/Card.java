package entity.payment;

public class Card {
	private String owner;
	private String cardCode;
	
	public Card(String owner, String cardCode) {
		this.owner = owner;
		this.cardCode = cardCode;
	}
	
	public String getCardCode() {
        return this.cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }
    
    public String getCardHolderName() {
        return this.owner;
    }

    public void setCardHolderName(String cardHolderName) {
        this.owner = cardHolderName;
    }
}
