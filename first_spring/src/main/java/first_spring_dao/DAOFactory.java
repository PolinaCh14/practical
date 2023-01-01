package first_spring_dao;

public class DAOFactory {
	private static IDAO dao;

	public static IDAO getDAOInstance(TypeDAO type) {
		switch (type) {
		case MY_SQL:
			dao = new MYSQL();
			break;
		case COLLECTION:
			dao = new MyCollection();
		}
		return dao;
	}
}
