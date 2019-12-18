package com.person.io.bio;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hq
 * @description BIO: block-io :阻塞io；
 *              缺点：accept阻塞、read、write阻塞。不适合多线程并发执行；
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        {
            try {
                serverSocket = new ServerSocket();
                //服务端绑定一个具体的地址
                serverSocket.bind(new InetSocketAddress("127.0.0.1",9090));
                System.out.println("ServerStart");
                Socket socket = serverSocket.accept();
                new Thread(()->{
                   new Handler(socket).executor();
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
class  Handler{
    private Socket socket;


    public Handler(Socket socket) {
        this.socket = socket;
    }

    public void executor(){
        //存储数据结构
        byte[] bytes = new byte[1024];
        OutputStream os = null;
        InputStream is = null;
        try {
            is = socket.getInputStream();
            int len =  is.read(bytes);
            System.out.println(new String(bytes,0,len));
            os = socket.getOutputStream();
            os.write("HelloClient".getBytes());
            os.flush(); //刷新内存
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}