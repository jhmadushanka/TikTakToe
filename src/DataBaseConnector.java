
import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DataBaseConnector {
    String url="jdbc:mysql://localhost/scores";
    String user="root";
    String password="1234";
    Connection con;
    Statement st;
    ResultSet rs;
    String driver="com.mysql.jdbc.Driver";
    PreparedStatement ps;
    String sql;
    int n=0;
    void connect()
    {
        try{
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url,user,password); 
           
        }
        catch(Exception e)
        {
           out.printf("Error");
        }
    }
    void update(String Name, int Score)
    {
        
        if(search(Name))
        {
            try {
                sql="update gamer set score=? where name=?";
                ps=con.prepareStatement(sql);
                ps.setInt(1, Score);
                ps.setString(2, Name);
                ps.executeUpdate();
                ps.close();
               
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
               
            }
            
             
        }
        else
        {
            
            try {
                sql="insert into gamer(name,score) values (?,?)";
                ps=con.prepareStatement(sql);
                
                ps.setString(1, Name);
                ps.setInt(2, Score);
                ps.executeUpdate();
                ps.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public static void main(String args[])
    {
        DataBaseConnector db=new DataBaseConnector();
        db.connect();
        db.getAll();
        db.update("pppp", 2078787878);
        
    }

    public boolean search(String Name) {
        Boolean a;
        try {
         
        sql="select name from gamer where name=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, Name);
        rs=ps.executeQuery();
        if(rs.next()==Boolean.TRUE) a=Boolean.TRUE;
        else a=Boolean.FALSE;
        
        ps.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        return a;
       
    }
    public int getScore(String Name)
    {
        try {
            sql="select score from gamer where name=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, Name);
            rs=ps.executeQuery();
            if(rs.next())
                return rs.getInt("score");
                
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
      return 0;  
    }
    public ResultSet getAll()
            {
                String[] records=new String[3];
                sql="select * from gamer order by score desc";
                int i=0;
            try {
                st=con.createStatement();
                st.executeQuery(sql);
                st=con.createStatement();
                rs=st.executeQuery("select name from gamer order by score desc");
               
                        } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
                
            }
              return rs;  
                
            }
    public void disconnect() throws SQLException
    {
        con.close();
    }
            
    
}
