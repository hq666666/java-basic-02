package com.person.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author hq
 * @description BIO:客户端
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket("127.0.0.1",9090);
             os= socket.getOutputStream();
             os.write("HelloServer".getBytes());
             os.flush();
             is = socket.getInputStream();
             byte[] bytes = new byte[10247];
            int len = is.read(bytes);
            System.out.println(new String(bytes,0,len));
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
