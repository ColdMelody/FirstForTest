//package util;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.InetAddress;
//import java.net.URL;
//import java.net.UnknownHostException;
//import java.util.Date;
//
///**
// *功能: 获取外网IP，内网IP，计算机名等信息;
// *
// *作者: jef
// *
// *时间: 20100714
// *
// *版本: v1.0.0
// *
// *
// *程序说明:
// *      通过纯真网络来获取IP，因为ip138网站有时不准。
// *
// *      运行程序时命令行参数请输入http://www.cz88.net/ip/viewip778.aspx
// *      等待程序运行完毕(执行时间视网络情况而定)，会在程序目录下生成一个GETIP.sys文件来输出各参数。
// *
// *      运行时如果不输入命令行参数，则默认使用http://www.cz88.net/ip/viewip778.aspx来获取IP。
// *
// *      注意,
// *      不输入命令行参数时获取的信息会输出到命令行，不会输出到文件。
// *      输入命令行参数时获取的信息则会输出到文件，不管获取IP成功与否。
// *
// *      输出信息部分内容的含义如下,
// *      sucess
// *
// *      hostName is:MyPC
// *      hostAddr is:192.168.1.114
// *      Foreign IP is:210.72.100.9
// *      Location is:江苏省苏州 长城宽带
// *      ......
// *
// *      第一行表示全部过程成功与否。成功输出"sucess"，否则"fail",
// *      第二行表示计算机名,
// *      第三行表示内网IP,
// *      第四行表示外网IP,
// *      第五行表示外网IP所有的可能地理位置(可信度依赖于查询的网站)。
// *      ......
// *
// *
// *使用举例:

// *      c:
// *      cd C:\Documents and Settings
// *      java cn.mail.sendback.util.GetIP http://www.cz88.net/ip/viewip778.aspx
// *
// *      等待C:\Documents and Settings目录下出现GETIP.sys文件则表示执行完毕，
// *      用记事本打开该文件。含义见说明部分。
// *
// */
//public class GetIP {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args){
//        // 通过纯真网络来获取IP，因为ip138网站有时不准。
//        // 运行程序时命令行输入:http://www.cz88.net/ip/viewip778.aspx
//
//        boolean bHasNoArgs =false;
//        if(args.length<=0) bHasNoArgs =true;
//
//        StringBuffer sbFileContent =new StringBuffer();
//        boolean bGetSuccess =true;
//
//        try {
//            InetAddress host =InetAddress.getLocalHost();
//
//            String hostName =host.getHostName();
//            String hostAddr=host.getHostAddress();
//            String tCanonicalHostName =host.getCanonicalHostName();
//
//            Date da =new Date();
//            String osname =System.getProperty("os.name");
//            String osversion =System.getProperty("os.version");
//            String username =System.getProperty("user.name");
//            String userhome =System.getProperty("user.home");
//            String userdir =System.getProperty("user.dir");
//
//            if(bHasNoArgs){
//                System.out.println("hostName is:"+hostName);
//                System.out.println("hostAddr is:"+hostAddr);
//
//                System.out.println("Current Date is:"+da.toString());
//                System.out.println("osname is:"+osname);
//                System.out.println("osversion is:"+osversion);
//                System.out.println("username is:"+username);
//                System.out.println("userhome is:"+userhome);
//                System.out.println("userdir is:"+userdir);
//            }
//            else{
//                sbFileContent.append("hostName is:"+hostName+"\n");
//                sbFileContent.append("hostAddr is:"+hostAddr+"\n");
//
//                sbFileContent.append("Current Date is:"+da.toString()+"\n");
//                sbFileContent.append("osname is:"+osname+"\n");
//                sbFileContent.append("osversion is:"+osversion+"\n");
//                sbFileContent.append("username is:"+username+"\n");
//                sbFileContent.append("userhome is:"+userhome+"\n");
//                sbFileContent.append("userdir is:"+userdir+"\n");
//            }
//
//            StringBuffer url =new StringBuffer();
//            if(bHasNoArgs||args[0].equals(null)||args[0].equals("")){
//                url.append("http://www.cmyip.com/");
//            }
//            else
//                url.append(args[0]);
//            StringBuffer strForeignIP =new StringBuffer("strForeignIPUnkown");
//            StringBuffer strLocation =new StringBuffer("strLocationUnkown");
//
//
//            if(GetIP.getWebIp(url.toString(),strForeignIP,strLocation)){
//                if(bHasNoArgs){
//                    System.out.println("Foreign IP is:"+strForeignIP);
//                    System.out.println("Location is:"+strLocation);
//                }
//                else{
//                    sbFileContent.append("Foreign IP is:"+strForeignIP+"\n");
//                    sbFileContent.append("Location is:"+strLocation+"\n");
//                }
//            }
//            else{
//                if(bHasNoArgs){
//                    System.out.println("Failed to connect:"+url);
//                }
//                else{
//                    bGetSuccess =false;
//                    sbFileContent.append("Failed to connect:"+url+"\n");
//                }
//            }
//
//
//        } catch (UnknownHostException e) {
//            if(bHasNoArgs){
//                e.printStackTrace();
//            }
//            else{
//                bGetSuccess =false;
//                sbFileContent.append(e.getStackTrace()+"\n");
//            }
//        }
//
//
//        if(bGetSuccess)
//            sbFileContent.insert(0,"sucess"+"\n");
//        else
//            sbFileContent.insert(0,"fail"+"\n");
//
//        if(!bHasNoArgs) write2file(sbFileContent);
//
//    }
//
//
//    public static boolean getWebIp(String strUrl,
//                                   StringBuffer strForeignIP,StringBuffer strLocation) {
//        try {
//
//            URL url = new URL(strUrl);
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            String s = "";
//            StringBuffer sb = new StringBuffer("");
//            while ((s = br.readLine()) != null) {
//                sb.append(s + "\r\n");
//            }
//            br.close();
//
//            String webContent = "";
//            webContent = sb.toString();
//
//            if( webContent.equals(null)|| webContent.equals("") ) return false;
//
//
//
//            String flagofForeignIPString ="IPMessage";
//            int startIP = webContent.indexOf(flagofForeignIPString)+flagofForeignIPString.length()+2;
//            int endIP = webContent.indexOf("</span>",startIP);
//            strForeignIP.delete(0, webContent.length());
//            strForeignIP.append(webContent.substring(startIP,endIP));
//
//            String flagofLocationString ="AddrMessage";
//            int startLoc = webContent.indexOf(flagofLocationString)+flagofLocationString.length()+2;
//            int endLoc = webContent.indexOf("</span>",startLoc);
//            strLocation.delete(0, webContent.length());
//            strLocation.append(webContent.substring(startLoc,endLoc));
//
//            return true;
//
//        } catch (Exception e) {
//            //e.printStackTrace();
//            return false;
//        }
//    }
//
//
//    public static void  write2file(StringBuffer content){
//
//        if(content.length()<=0) return;
//
//        try {
//            FileOutputStream fos = new FileOutputStream("GETIP.sys");
//            OutputStreamWriter osr =new OutputStreamWriter(fos);
//            BufferedWriter bw =new BufferedWriter(osr);
//
//            try {
//                int index =0;
//                while(index>=0){
//                    int preIndex =index;
//                    index =content.indexOf("\n", preIndex+2);
//
//                    if(index>0){
//                        String str =new String(content.substring(preIndex, index));
//                        bw.write(str);
//                        bw.newLine();
//                    }
//                    else{
//                        String str =new String(content.substring(preIndex, content.length()-1));
//                        bw.write(str);
//                        break;
//                    }
//                }
//
//            } catch (IOException e1) {
//                // TODO Auto-generated catch block
//                //e1.printStackTrace();
//            }
//
//            try {
//                bw.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                //e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            //e.printStackTrace();
//        }
//    }
//}