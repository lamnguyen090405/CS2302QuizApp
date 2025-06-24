/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.services;

import com.ntl.pojo.Category;
import com.ntl.pojo.Level;
import com.ntl.utils.jdbcConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServices {

    public List<Level> getLevels() throws SQLException {
        Connection conn = jdbcConnector.getInstance().connect();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM level");

        List<Level> levels = new ArrayList<>();
        while (rs.next()) {
            Level l = new Level(rs.getInt("id"), rs.getString("name"), rs.getString("note"));
            levels.add(l);
        }

        return levels;
    }
}
