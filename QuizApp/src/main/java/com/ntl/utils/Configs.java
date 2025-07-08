/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.utils;

import com.ntl.services.CategoryServices;
import com.ntl.services.LevelServices;
import com.ntl.services.question.QuestionServices;
import com.ntl.services.UpdateQuestionServices;
import com.ntl.services.question.BaseQuestionServices;

/**
 *
 * @author Admin
 */
public class Configs {

    public static final CategoryServices cateService = new CategoryServices();
    public static final LevelServices levelService = new LevelServices();
    public static BaseQuestionServices questionService = new QuestionServices();
    public static final UpdateQuestionServices uQService = new UpdateQuestionServices();
            
}
