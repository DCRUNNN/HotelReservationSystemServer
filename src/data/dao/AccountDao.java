package data.dao;

public interface AccountDao {

	public boolean insert(String clientID, String pass);

	public boolean check(String id, String password);

}
