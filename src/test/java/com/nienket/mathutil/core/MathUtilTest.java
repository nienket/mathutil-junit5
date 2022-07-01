/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nienket.mathutil.core;

import static com.nienket.mathutil.core.MathUtil.getFactorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author ACER
 */
public class MathUtilTest {

    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    
    //chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][] {
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ tự của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

    //băt ngoại lệ khi đưa data cà chớn
    //cách junit 4:@Test(expected = tên ngoại lệ.class)
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //xài biểu thức Lambda
        
        //hàm nhận tham số thứ 2 là 1 object/có code implement cái functional
        //interface tên là Executable - có 1 hàm duy nhất không có code
        //tên là execute()
        
        //chơi chậm
        /*Executable exObject = new Executable() {
            @Override
            public void execute() throws Throwable {
                getFactorial(-5);
            }
        };*/
        
        //Executable exObject = () -> {getFactorial(-5);};
        
        //Executable exObject = () -> getFactorial(-5);
        
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
