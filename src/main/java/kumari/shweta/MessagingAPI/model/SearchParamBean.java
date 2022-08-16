package kumari.shweta.MessagingAPI.model;

import javax.ws.rs.QueryParam;

public class SearchParamBean {

	@QueryParam("cName")
	public String name;
	
	@QueryParam("cAddress")
	public String address;
	
	@QueryParam("cGender")
	public String gender;
	
	@Override
	public String toString() {
		return "SearchParamBean [name=" + name + ", address=" + address + ", gender=" + gender + "]";
	}
	
}
