package com.xiaomin.shixun;

import java.util.Arrays;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/30 9:58
 */
public class chengfabiao {
    public static void main(String[] args) {
        multiTable(9);
    }

    public static void multiTable(int n){
        int[] ret=new int[n*(n+1)/2];
        int index=0;
        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%dx%d=%d\t",j,i,j*i);
                ret[index]=j*i;
                index++;
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(ret));
    }
}
