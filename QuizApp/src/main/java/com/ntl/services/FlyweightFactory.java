/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class FlyweightFactory {
    private static Map<String, List> catchedData = new HashMap<>();
    
    public static <T> List<T> getData(BaseServices s, String key) throws SQLException{
        if (catchedData.containsKey(key)) {
            return catchedData.get(key);
        }else {
            List<T> re = s.list();
            catchedData.put(key, re);
            
            return re;
        }
                
    }
}
