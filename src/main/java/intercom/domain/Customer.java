package intercom.domain;

public class Customer implements Comparable<Customer>{
    public double latitude;
    public Integer user_id;
    public String name;
    public double longitude;

    
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
    public int compareTo(Customer obj) {
        return this.getUser_id().compareTo(obj.getUser_id());
    }
}
