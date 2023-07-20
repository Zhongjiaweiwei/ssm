package org.example.util;

/**
 * 执行成功返回值
 */
public class DoUtil {
    public static void returnResult(int i){
        if (i==1){
            System.out.println("操作成功");
        }else {
            System.out.println("操作失败");
        }
    }
}
