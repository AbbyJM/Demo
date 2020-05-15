package com.abby.exception;

import java.io.*;

public class ExceptionDemo {
    public static void main(String[] args) {

    }

    /**
     * 提前抛出异常演示
     * @param filename 文件名
     * @throws FileNotFoundException 文件名为null时提前抛出异常
     */
    private void fastFailDemo(String filename) throws FileNotFoundException {
        //提前抛出异常
        if(filename==null){
            throw new IllegalArgumentException("filename is null");
        }
        InputStream is = new FileInputStream(filename);
    }

    /**
     * 延迟捕获异常错误示例
     * @param filename 文件名
     */
    private void delayCatch(String filename) throws IOException {
        InputStream is = null;

        //提早捕获异常
        try{
           is = new FileInputStream(filename);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //如果上面发生异常这个is就是null，程序抛出的就是NullPointerException
        //但是实际的异常应该是FileNotFoundException
        int read;
        while((read=is.read())!=-1) {

        }
    }
}
