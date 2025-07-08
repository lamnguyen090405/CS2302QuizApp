/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.services;

import com.ntl.pojo.Category;
import com.ntl.pojo.Level;
import com.ntl.utils.jdbcConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServices extends BaseServices<Level>{

  

    @Override
    public PreparedStatement getStm(Connection conn) throws SQLException {
        return conn.prepareCall("SELECT * FROM level");
    }

    @Override
    public List<Level> getResults(ResultSet rs) throws SQLException {
        List<Level> levels = new ArrayList<>();
        while (rs.next()) {
            Level l = new Level(rs.getInt("id"), rs.getString("name"), rs.getString("note"));
            levels.add(l);
        }

        return levels;
    }
}
