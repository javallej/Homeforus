package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsumerList {

    public List<ConsumerListObject> List(int Consumer_ID) throws SQLException, IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <ConsumerListObject> consumerinformation = new ArrayList<ConsumerListObject>();

        try {


            String query = "SELECT * FROM CONSUMER WHERE CONSUMER.Consumer_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Consumer_ID);
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                ConsumerListObject cobject = new ConsumerListObject();
                cobject.setConsumerID(rs.getInt(1));
                cobject.setConsumerUsername(rs.getString(2));
                cobject.setDOB(rs.getString(3));
                cobject.setSSN(rs.getInt(4));
                consumerinformation.add(cobject);
            }
            
            return consumerinformation;
            
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        return consumerinformation;
    }

    

}