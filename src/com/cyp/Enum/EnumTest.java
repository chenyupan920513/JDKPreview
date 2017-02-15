package com.cyp.Enum;

public class EnumTest {  
    public static void main(String[] args) {  
        WeekDay weekday =WeekDay.FRI;  
        System.out.println(weekday);  
        System.out.println(weekday.name());  
        System.out.println(weekday.ordinal());  
        System.out.println(WeekDay.valueOf("SUN"));  
        System.out.println(WeekDay.values().length);  
    }  
    public enum WeekDay{  
        SUN(1),MON(),TUE,WED,THI,FRI,SAT;  
        private WeekDay(){  
            System.out.println("first");  
        }  
        private WeekDay(int day){  
           System.out.println("我是星期天");
        }  
    }  
} 
