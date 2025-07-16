/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.services.exam;

import com.ntl.pojo.Exam;
import com.ntl.pojo.Question;
import com.ntl.utils.jdbcConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public abstract class BaseExamServices {

    public abstract List<Question> getQuestions() throws SQLException;

    public void addExam(List<Question> questions) throws SQLException {
        Connection conn = jdbcConnector.getInstance().connect();
        
        conn.setAutoCommit(false);
        Exam ex = new Exam(questions);

        String sql = "INSERT INTO exam(title, created_date) VALUES(?, ?)";
        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1,ex.getTitle());
        stm.setString(2, ex.getCreateDate().toString());
        
        if(stm.executeUpdate() > 0) {
            int exId= -1;
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next())
                exId = rs.getInt(1);
            
            sql = "INSERT INTO exam_question(exam_id, question_id) VALUES(?, ?)";
            stm = conn.prepareCall(sql);
            
            for(var q :questions) {
                stm.setInt(1, exId);
                stm.setInt(2, q.getId());
                
                stm.executeUpdate();
            }
            conn.commit();
        }else conn.rollback();
        

    }
}
