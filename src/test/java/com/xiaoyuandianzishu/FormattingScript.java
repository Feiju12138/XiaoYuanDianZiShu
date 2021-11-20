package com.xiaoyuandianzishu;

import java.util.Scanner;

/**
 * 格式化电子书内容，改为JSON格式的字符串
 */
public class FormattingScript {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {

            StringBuffer stringBuffer = new StringBuffer();

            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            stringBuffer.append("[");
            for (int i = 0; i < arr.length; i++) {
                if (i!=0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\""+arr[i]+"\"");
            }
            stringBuffer.append("]");

            System.out.println(stringBuffer);

        }

    }

}
