import java.sql.*;
import org.apache.derby.jdbc.EmbeddedDataSource;
import java.util.MissingResourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
public class DatabaseLoad {
    private EmbeddedDataSource ds;
    private Connection con;
    private Statement stmt;

    public DatabaseLoad() {
        try{
            this.ds = new EmbeddedDataSource();
            this.ds.setDatabaseName("rpgdata");
            this.ds.setCreateDatabase("create");
            this.con = this.ds.getConnection();
            this.stmt = this.con.createStatement();

            this.stmt.executeUpdate("DROP TABLE stats");
            this.stmt.executeUpdate("DROP TABLE playerclass");
            this.stmt.executeUpdate("DROP TABLE npc");

            this.stmt.executeUpdate("CREATE TABLE npc ("
                    + "id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "description VARCHAR(500) NOT NULL,"
                    + "ispassive BOOLEAN NOT NULL)"
                    );
            this.stmt.executeUpdate("CREATE TABLE playerclass ("
                    + "id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "charmaxstamina DECIMAL NOT NULL)"
            );
            this.stmt.executeUpdate("CREATE TABLE stats ("
                    + "id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "value DECIMAL NOT NULL,"
                    + "npc_id INTEGER,"
                    + "playerclass_id INTEGER,"
                    + "FOREIGN KEY (npc_id) REFERENCES npc(id) ON DELETE CASCADE,"
                    + "FOREIGN KEY (playerclass_id) REFERENCES playerclass(id) ON DELETE CASCADE)"
            );
            try (PreparedStatement insertNpc = this.con.prepareStatement(
                    "INSERT INTO npc (name, description, ispassive) VALUES (?, ?, ?)");
                 PreparedStatement insertPlayerClass = this.con.prepareStatement(
                         "INSERT INTO playerclass (name, charmaxstamina) VALUES (?, ?)");
                 PreparedStatement insertStat = this.con.prepareStatement(
                         "INSERT INTO stats (name, value, npc_id, playerclass_id) VALUES (?, ?, ?, ?)")
            ) {
                //npc table inserts
                insertNpc.setString(1, "Guard");
                insertNpc.setString(2, "A strong warrior");
                insertNpc.setBoolean(3, false);
                insertNpc.executeUpdate();
                insertNpc.setString(1, "Litch");
                insertNpc.setString(2, "A undead mage");
                insertNpc.setBoolean(3, false);
                insertNpc.executeUpdate();
                insertNpc.setString(1, "Goblin");
                insertNpc.setString(2, "A little green monster");
                insertNpc.setBoolean(3, false);
                insertNpc.executeUpdate();

                //playerclass table inserts
                insertPlayerClass.setString(1, "Warrior");
                insertPlayerClass.setInt(2, 100);
                insertPlayerClass.executeUpdate();
                insertPlayerClass.setString(1, "Mage");
                insertPlayerClass.setInt(2, 80);
                insertPlayerClass.executeUpdate();
                insertPlayerClass.setString(1, "Potioner");
                insertPlayerClass.setInt(2, 100);
                insertPlayerClass.executeUpdate();

                //npc stats class
                insertStat.setString(1,"HP");
                insertStat.setInt(2,50);
                insertStat.setInt(3,1);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"HP");
                insertStat.setInt(2,80);
                insertStat.setInt(3,2);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"HP");
                insertStat.setInt(2,100);
                insertStat.setInt(3,3);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Defense");
                insertStat.setInt(2,50);
                insertStat.setInt(3,1);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Defense");
                insertStat.setInt(2,90);
                insertStat.setInt(3,2);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Defense");
                insertStat.setInt(2,120);
                insertStat.setInt(3,3);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Attack");
                insertStat.setInt(2,60);
                insertStat.setInt(3,1);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Attack");
                insertStat.setInt(2,70);
                insertStat.setInt(3,2);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Attack");
                insertStat.setInt(2,20);
                insertStat.setInt(3,3);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Magic Power");
                insertStat.setInt(2,60);
                insertStat.setInt(3,1);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Magic Power");
                insertStat.setInt(2,70);
                insertStat.setInt(3,2);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Magic Power");
                insertStat.setInt(2,20);
                insertStat.setInt(3,3);
                insertStat.setNull(4,Types.INTEGER);
                insertStat.executeUpdate();

                //player class stats
                insertStat.setString(1,"HP");
                insertStat.setInt(2,50);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"HP");
                insertStat.setInt(2,90);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"HP");
                insertStat.setInt(2,120);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Defense");
                insertStat.setInt(2,50);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Defense");
                insertStat.setInt(2,90);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Defense");
                insertStat.setInt(2,120);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Attack");
                insertStat.setInt(2,60);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Attack");
                insertStat.setInt(2,70);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Attack");
                insertStat.setInt(2,20);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Magic Power");
                insertStat.setInt(2,60);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Magic Power");
                insertStat.setInt(2,70);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Magic Power");
                insertStat.setInt(2,20);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"MAXHP");
                insertStat.setInt(2,50);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"MAXHP");
                insertStat.setInt(2,80);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"MAXHP");
                insertStat.setInt(2,100);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"Stamina");
                insertStat.setInt(2,60);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Stamina");
                insertStat.setInt(2,70);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"Stamina");
                insertStat.setInt(2,20);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();

                insertStat.setString(1,"StaminaMax");
                insertStat.setInt(2,60);
                insertStat.setInt(4,1);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"StaminaMax");
                insertStat.setInt(2,70);
                insertStat.setInt(4,2);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();
                insertStat.setString(1,"StaminaMax");
                insertStat.setInt(2,20);
                insertStat.setInt(4,3);
                insertStat.setNull(3,Types.INTEGER);
                insertStat.executeUpdate();


            }

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    //note the name we want to use is Gaurd
    public String getNPCname(String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("select name,description,ispassive from npc where name = '" + name + "'");
        rs.next();
        return rs.getString("name");
    }
    public String getNPCdescrip(String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("select name,description,ispassive from npc where name = '" + name + "'");
        rs.next();
        return rs.getString("description");
    }
    public Boolean getNPCpassive(String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("select name,description,ispassive from npc where name = '" + name + "'");
        rs.next();
        return rs.getBoolean("ispassive");
    }

    //we want to use the vairble name "Warrior"
    public String getPlayername(String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("select name,charmaxstamina from playerclass where name = '"+name+"'");
        rs.next();
        return rs.getString("name");
    }

    public int getPlayerStamina(String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("select name,charmaxstamina from playerclass where name = '"+name+"'");
        rs.next();
        return rs.getInt("charmaxstamina") ;
    }

    public ResultSet getNPCstats() throws SQLException
    {
        ResultSet rs = stmt.executeQuery("select name,value from stats where npc_id = 1");
        return rs;
    }

    public ResultSet getPlayerstats() throws SQLException
    {
        ResultSet rs = stmt.executeQuery("select name,value from stats where playerclass_id = 1");
        return rs;
    }
  //  public String getStatNamePlayer(int classnum) throws SQLException {
    //    ResultSet rs = stmt.executeQuery("select name,value from stats where playerclass_id = 1");
     //   return rs.getString("name");
    //}
   // public Double getStatValuePlayer(int classnum) throws SQLException {
      //  ResultSet rs = stmt.executeQuery("select name,value from stats where playerclass_id = 1");
      //  return rs.getString("name");
   // }
    //public String getStatNameNPC(int classnum){
     //   return rs.getString("name");
   // }
   // public Double getStatValueNPC(int classnum){
    //    return rs.getString("name");
   // }

    //private void (){

  //  }
}
