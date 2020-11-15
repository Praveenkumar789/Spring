package praveen.model;

public class UserDetails {
	
	int id;
	String name;
	String password;
	
	public UserDetails(int Id, String Name, String Password) {
		this.id = Id;
		this.name = Name;
		this.password = Password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		String userdetails = "Id" + this.getId() +"\nName: "+ this.getName() ;
		return userdetails;
	}
}
