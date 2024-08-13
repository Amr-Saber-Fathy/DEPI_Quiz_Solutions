package papers;

import java.time.LocalDate;


public class Subscription {

	private static int subscriptionID = 0;
	private String subscriptionType = "";
	private LocalDate startDate = null;
	private LocalDate endtDate = null;
	
	////////////Constructor///////////////
	public Subscription(String subscriptionType, LocalDate startDate, LocalDate endtDate) 
	{
		setSubscriptionID();
		this.setSubscriptionType(subscriptionType);
		this.setStartDate(startDate);
		this.setEndtDate(endtDate);
	}

	////////////Getters and setters////////////
	public static int getSubscriptionID() {
		return subscriptionID;
	}

	private static void setSubscriptionID() {
		Subscription.subscriptionID ++;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		if(subscriptionType == null || subscriptionType == "") {
			System.out.println("Invalid Subscription Type");
		}
		else {
			this.subscriptionType = subscriptionType;
		}
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		if(startDate == null) {
			System.out.println("Invalid Start Date");
		}
		else {
			this.startDate = startDate;
		}
	}

	public LocalDate getEndtDate() {
		return endtDate;
	}

	public void setEndtDate(LocalDate endtDate) {
		if(endtDate == null) {
			System.out.println("Invalid End Date");
		}
		else {
			this.endtDate = endtDate;
		}
	}

	
	
}
