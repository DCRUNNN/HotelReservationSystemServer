package data.datahelper;

public interface AccountDataHelper {

	public boolean insert(String clientID, String pass);

	public boolean check(String id, String password);

}
