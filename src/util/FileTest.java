package util;

import java.io.*;

/**
 * Created by Administrator on 2016/4/19.
 */
public class FileTest {
    private static File getFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return file;
        }
        return file;
    }

    public static void main(String[] args) {

        File file = getFile("d:" + File.separator + "me.txt");
        System.out.println(file.lastModified());
        System.out.println(file.getPath());
        System.out.println(file.length());
        System.out.println(file.toURI());
        System.out.println(file.toURI().getHost());
        System.out.println(file.toURI().getPort());
        System.out.println(file.toURI().getPath());
        ObjectOutputStream out = null;
        ObjectInputStream in=null;
        try {

            out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(new Person("Bill",20));
            in=new ObjectInputStream(new FileInputStream(file));
            Object obj=in.readObject();
            System.out.println(obj.toString());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
