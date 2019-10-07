/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entry;

/**
 *
 * @author dattv
 */
public class EntryDao {

    private Connection connection;

    public EntryDao() {
    }

    public List<Entry> get3EntryByOderDate() {

        List<Entry> temp = new ArrayList();

        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();

            String sql = "SELECT TOP 3 * FROM Entrys ORDER BY Date desc";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                temp.add(new Entry(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("image"),
                        rs.getTimestamp("createdate"),
                        rs.getString("type")
                ));

            }
        } catch (Exception ex) {
            Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return temp;
    }

    public Entry getEntrysByTypeOderDate(String type) throws Exception {

        Entry tempEntry = null;
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();

            String sql = "SELECT TOP 1 * FROM entry WHERE type = ? ORDER BY Date desc";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                tempEntry = new Entry(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("image"),
                        rs.getTimestamp("createdate"),
                        rs.getString("type")
                );

            }

        } catch (Exception ex) {
            Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tempEntry;
    }

 

    public int getNumOfEntrys() {

        int row=0;
        try {

            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();

            String sql = "SELECT count(*) as row FROM Entry";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                row=rs.getInt("row");

            }

        } catch (Exception ex) {
            Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return row;
    }

    public Entry getEntryById(int id) {

        Entry Entry = new Entry();
        try {

            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();

            String sql = "SELECT * FROM entry Where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Entry = new Entry(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("image"),
                        rs.getTimestamp("createdate"),
                        rs.getString("type")
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Entry;
    }

    public ArrayList<Entry> getByPage(int page) {

        ArrayList<Entry> temp = new ArrayList();

        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();

            String sql = "SELECT * "
                    + "FROM ( "
                    + "    SELECT *, ROW_NUMBER() OVER (ORDER BY Date desc) RowNum "
                    + "    FROM Entrys "
                    + ") AS MyDerivedTable "
                    + "WHERE MyDerivedTable.RowNum BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (page - 1) * 2 + 1);
            statement.setInt(2, (page - 1) * 2 + 2);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                temp.add(new Entry(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("image"),
                        rs.getTimestamp("createdate"),
                        rs.getString("type")
                ));

            }

        } catch (Exception ex) {
            Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return temp;
    }
    
    
       public String getAboutMe() throws Exception {

        String aboutMe = "";
        try {
            DBContext dBContext = new DBContext();
            connection = dBContext.getConnection();

            String sql = "SELECT * FROM aboutme";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                aboutMe = rs.getString("content");
            }

        } catch (Exception ex) {
            Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EntryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return aboutMe;
    }
}
