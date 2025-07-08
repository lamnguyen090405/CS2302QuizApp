/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.services.question;

import java.util.List;

/**
 *
 * @author admin
 */
public abstract class QuestionServicesDecorator implements BaseQuestionServices{

    protected BaseQuestionServices decorator;

    public QuestionServicesDecorator(BaseQuestionServices decorator) {
        this.decorator = decorator;
    }
    
}
