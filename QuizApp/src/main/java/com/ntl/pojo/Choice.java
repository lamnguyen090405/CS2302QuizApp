/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntl.pojo;

/**
 *
 * @author admin
 */
public class Choice {
    private int id;
    private String content;
    private boolean correct;

    public Choice(int id, String name, boolean correct) {
        this.id = id;
        this.content = name;
        this.correct = correct;
    }
    
     public Choice(String name, boolean correct) {
        this.content = name;
        this.correct = correct;
    }
    
}
