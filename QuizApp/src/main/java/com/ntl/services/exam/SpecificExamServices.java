/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.services.exam;

import com.ntl.pojo.Question;
import com.ntl.services.question.BaseQuestionServices;
import com.ntl.services.question.LimitQuestionServicesDecorator;
import com.ntl.utils.Configs;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class SpecificExamServices extends BaseExamServices{
    private int num;

    public SpecificExamServices(int num) {
        this.num = num;
    }
    
    @Override
    public List<Question> getQuestions() throws SQLException {
        BaseQuestionServices s = new LimitQuestionServicesDecorator(Configs.questionService, num);
        
        return s.list();
    }
    
}
