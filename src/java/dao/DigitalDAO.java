/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author CongHoangDevelop
 */
public class DigitalDAO {

    public Digital getTop1() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "select top 1 * from digital_table\n"
                    + "order by [date] desc";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("shortDescription"),
                        rs.getTimestamp("date"),
                        rs.getString("image"));
                return d;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }

    public List<Digital> getTop5() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Digital> list = new ArrayList<>();
            String query = "select top 5 * from digital_table\n"
                    + "where id not in\n"
                    + "(select top 1 id from digital_table\n"
                    + "order by [date] desc)\n"
                    + "order by [date] desc";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("shortDescription"),
                        rs.getTimestamp("date"),
                        rs.getString("image"));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }

    public Digital getById(int id) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "select * from digital_table\n"
                    + "where id = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("shortDescription"),
                        rs.getTimestamp("date"),
                        rs.getString("image"));
                return d;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }

    public int countSearch(String txt) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "select count(*) as counts from digital_table\n"
                    + "where title like ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("counts");
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }

    public List<Digital> search(String txt, int index, int size) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Digital> list = new ArrayList<>();
            String query = "select * from digital_table\n"
                    + "where title like ?\n"
                    + "order by id offset ? rows\n"
                    + "fetch next ? rows only";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, size * (index - 1));
            ps.setInt(3, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("shortDescription"),
                        rs.getTimestamp("date"),
                        rs.getString("image"));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }

    }

    
}
