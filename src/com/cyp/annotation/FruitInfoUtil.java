package com.cyp.annotation;
import java.lang.reflect.Field;

/**
 * 
 * @author pierre
 * @Date  2017-2-15
 * @version  V1.0
 *
 */

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){
        
        String strFruitName="name of fruit: ";
        String strFruitColor="color of fruit: ";
        String strFruitProvicer="provider of fruit: ";
        
        Field[] fields = clazz.getDeclaredFields();
        
        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer=" provider_id = "+fruitProvider.id()+" ==providerName ="+fruitProvider.name()+"==provider_address = "+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}
