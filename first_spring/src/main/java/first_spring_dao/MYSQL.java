package first_spring_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import first_spring_class.Lipstick;
import first_spring_class.SunCream;

import java.util.List;

public class MYSQL implements IDAO {
 
	private static final String SERVER = "localhost";
	private static final String DB = "makeup";
	private static final String LOGIN = "First";
	private static final String PASSWORD = "polina";
	
	private static final String ADD_MAKE_UP = "INSERT INTO makeup.makeup1 (name, age, company) VALUES(?, ?, ?)";
	private static final String ADD_SUNCREAM = "INSERT INTO makeup.suncream (spf, idMakeUp) VALUES(?,?)";
	private static final String ADD_LIPBALM = "INSERT INTO makeup.lipbalm (herbs, idmakeUp) VALUES(?,?)";
	private static final String ADD_LIPSTICK = "INSERT INTO makeup.lipstick (color, idLipBalm) VALUES(?,?)";
	
	private static final String GET_MAKE_UP = "SELECT* FROM makeup.makeup1 order by idMakeUp DESC LIMIT 1";
	private static final String GET_LIPBALM = "SELECT* FROM makeup.lipbalm order by idLipBalm DESC LIMIT 1";
	
	private static final String SHOW_SUNCREAM = "SELECT s.idSunCream, name, age, company, s.spf  FROM makeup.makeup1 join makeup.suncream s on makeup1.idMakeUp = s.idmakeUp WHERE spf != 0";
	private static final String SHOW_LIPSTICK = "SELECT l.idLipstick, name, age, company, b.herbs, l.color FROM makeup.makeup1 JOIN makeup.lipbalm b  ON (makeup1.idMakeUp = b.idmakeUp)  JOIN makeup.lipstick l USING (idLipBalm)";
	
	private static final String DELETE_SUNCREAM = "DELETE FROM makeup.makeup1 WHERE name = ?;";
    private static final String DELETE_LIPCTICK = "DELETE FROM makeup.makeup1 WHERE name = ?;"; 
    
    private static final String UPDATE_SPF = "UPDATE makeup.makeup1 join makeup.suncream s on makeup1.idMakeUp = s.idmakeUp SET s.spf = ? WHERE name = ?;";
    
    private static final String SEARCH = "SELECT l.idLipstick, name, age, company, b.herbs, "
    		+ " l.color FROM makeup.makeup1 JOIN makeup.lipbalm b ON (makeup1.idMakeUp = b.idmakeUp) "
    		+ " JOIN makeup.lipstick l USING (idLipBalm) WHERE company LIKE  ? ";
	
    private static Boolean Add_SunCream;
    private static Boolean Add_Lipstick;
    private static Boolean Show_Lipstick;
    private static Boolean Show_SunCream;
    private static Boolean Del_Lipstick;
    private static Boolean Del_SunCream;
    private static Boolean Change_SunCream;
    private static Boolean Search_Comp;
    
    
	public MYSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Add_SunCream = false;
	    Add_Lipstick = false;
	    Show_Lipstick = false;
	    Show_SunCream = false;
	    Del_Lipstick = false;
	    Del_SunCream = false;
	    Change_SunCream = false;
	    Search_Comp = false;
	}
	
	 @Override
	public void addLipstick(Lipstick lip) {
		 while (Add_Lipstick) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
			try {
				Add_Lipstick = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				PreparedStatement add_makeup = con.prepareStatement(ADD_MAKE_UP);
				PreparedStatement add_lipbalm = con.prepareStatement(ADD_LIPBALM);
				PreparedStatement add_lipstick = con.prepareStatement(ADD_LIPSTICK);
				PreparedStatement get_makeup = con.prepareStatement(GET_MAKE_UP);
				PreparedStatement get_lipbalm = con.prepareStatement(GET_LIPBALM);
				
				add_makeup.setString(1, lip.getName());
				add_makeup.setInt(2, lip.getAge());
				add_makeup.setString(3, lip.getCompany());
				add_makeup.executeUpdate();
				
				ResultSet resultSet = get_makeup.executeQuery();
	            resultSet.next();
	            long id_makeup = resultSet.getLong("idMakeUp");
	            
	            add_lipbalm.setString(1, lip.getHerbs());
	            add_lipbalm.setLong(2, id_makeup);
	            add_lipbalm.executeUpdate();
				
				resultSet = get_lipbalm.executeQuery();
	            resultSet.next();
	            long id_lipbalm = resultSet.getLong("idLipBalm");
	            
	            add_lipstick.setInt(1, lip.getColor());
	            add_lipstick.setLong(2, id_lipbalm);
	            add_lipstick.executeUpdate();
               
	            get_lipbalm.close();
	            get_makeup.close();
	            add_lipstick.close();
	            add_lipbalm.close();
	            add_makeup.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Add_Lipstick = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
		
	 @Override
	public void addSunCream(SunCream sun) {
		 while (Add_SunCream) {
	         System.out.println("Waiting... SunCream");
	      }
		 Connection con = null;
			try {
				Add_SunCream = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				PreparedStatement add_makeup = con.prepareStatement(ADD_MAKE_UP);
				PreparedStatement add_suncream = con.prepareStatement(ADD_SUNCREAM);
				PreparedStatement get_makeup = con.prepareStatement(GET_MAKE_UP);
				
				add_makeup.setString(1, sun.getName());
				add_makeup.setInt(2, sun.getAge());
				add_makeup.setString(3, sun.getCompany());
				add_makeup.executeUpdate();
				
				ResultSet resultSet = get_makeup.executeQuery();
	            resultSet.next();
	            long id_makeup = resultSet.getLong("idMakeUp");
	            
	            add_suncream.setInt(1, sun.getSpf());
	            add_suncream.setLong(2, id_makeup);
	            add_suncream.executeUpdate();
	            
	            get_makeup.close();
	            add_suncream.close();
	            add_makeup.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						
						con.close();
						System.out.println("Closed connection.");
						Add_SunCream = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				}
			}
	   }
	 
	 
	 @Override
	public List<Lipstick> showLipstick() {
		 while (Show_Lipstick) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
		 List<Lipstick> list = null;
			try {
				Show_Lipstick = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SHOW_LIPSTICK);
				list = new LinkedList<Lipstick>();
				while (rs.next()) {
					Lipstick lip = new Lipstick();
					lip.setIdLip(rs.getLong("idLipstick"));
					lip.setName(rs.getString("name"));
					lip.setAge(rs.getInt("age"));
					lip.setCompany(rs.getString("company"));
					lip.setHerbs(rs.getString("herbs"));
					lip.setColor(rs.getInt("color"));
					list.add(lip);
				}
				rs.close();
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Show_Lipstick = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return list;
	}
	 
	 @Override
	public List<SunCream> showSunCream() {
		 while (Show_SunCream) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
		 List<SunCream> list = null;
			try {
				Show_SunCream = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SHOW_SUNCREAM);
				list = new LinkedList<SunCream>();
				while (rs.next()) {
					SunCream sun = new SunCream();
					sun.setIdSun(rs.getLong("idSunCream"));
					sun.setName(rs.getString("name"));
					sun.setAge(rs.getInt("age"));
					sun.setCompany(rs.getString("company"));
					sun.setSpf(rs.getInt("spf"));
					list.add(sun);
				}
				rs.close();
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Show_SunCream = false;
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return list;
	  }
	 
	 @Override
	 public void delSunCream(String name) {
		 while (Del_SunCream) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
			try {
				Del_SunCream = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				PreparedStatement del_suncream = con.prepareStatement(DELETE_SUNCREAM);
				
				del_suncream.setString(1, name);
				del_suncream.executeUpdate();
				
				del_suncream.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Del_SunCream = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	   	   }
	 }
	 
	 @Override
	 public void delLipstick(String name) {
		 while (Del_Lipstick) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
			try {
				Del_Lipstick = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				PreparedStatement del_lipstick = con.prepareStatement(DELETE_LIPCTICK);
				
				del_lipstick.setString(1, name);
				del_lipstick.executeUpdate();
				
				del_lipstick.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Del_Lipstick = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	   	   }
	 }
	 
	 @Override
	 public void updateSPF (int spf, String name) {
		 while (Change_SunCream) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
			try {
				Change_SunCream = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				PreparedStatement updspf = con.prepareStatement(UPDATE_SPF);
				
				updspf.setInt(1, spf);
				updspf.setString(2, name);
				updspf.executeUpdate();
				
				updspf.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Change_SunCream = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	   	   }
	 }
	 
	 
	 @Override
	public List<Lipstick> searchCompanyL(String comp) {
		 while (Search_Comp) {
	         System.out.println("Waiting...");
	      }
		 Connection con = null;
		 List<Lipstick> list = null;
			try {
				Search_Comp = true;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, LOGIN, PASSWORD);
				PreparedStatement search = con.prepareStatement(SEARCH);
				search.setString(1, comp);
				ResultSet rs = search.executeQuery();
				
				list = new LinkedList<Lipstick>();
				while (rs.next()) {
					Lipstick lip = new Lipstick();
					lip.setIdLip(rs.getLong("idLipstick"));
					lip.setName(rs.getString("name"));
					lip.setAge(rs.getInt("age"));
					lip.setCompany(rs.getString("company")); 
					lip.setHerbs(rs.getString("herbs"));
					lip.setColor(rs.getInt("color"));
					//return lip;
					list.add(lip);
				}
				rs.close();
				search.close();
				//return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//return null;
			} finally {
				if (con != null) {
					try {
						con.close();
						System.out.println("Closed connection.");
						Search_Comp = false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return list;	
	}
	 
	
}

