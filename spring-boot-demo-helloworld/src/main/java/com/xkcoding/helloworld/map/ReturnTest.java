package com.xkcoding.helloworld.map;

public class ReturnTest {

    /**
     * 以finall中的return为准
     * @return
     */
    public static int test1(){
        int x = 0;
        try {
            x =1;
            return x;
        }catch (Exception e){
            x = 2;
            return x;
        }finally {
            x =3;
            return x;
        }
    }


    public static int test2(){
        int x = 0;
        try {
            x = 1;
            return x++;//先返回 后递增 所以是返回1
        }catch (Exception e){
            x = 2;
            return x;
        }finally {
            x =3;
        }
    }

    public static int test3(){
        int x = 0;
        try {
            x = 1;
            return x;
        }catch (Exception e){
            x = 2;
            return x;
        }finally {
            x =3;
        }
    }


    public static void main(String[] args) {
        System.out.println(test3());
    }

}
