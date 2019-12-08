package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.TestFathor;

import java.io.*;

/**
 * IO流测试类
 * File类操作
 * IO流操作
 */
public class IOTest extends TestFathor {

    @Override
    protected void init() {
        //test.pers.YalongBai.test.handler

    }

    @Override
    public void handler()  {
        String inputPath = "E:/工作文档/面试文档/git常见命令.txt";
        String outPath = "E:/工作文档/git常见命令.txt";
        FileReader fr = null;
        FileWriter fw = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;

        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        PrintStream printStream = null;
        PrintWriter printWriter = null;
        try {
            fr = new FileReader(inputPath);
            fw = new FileWriter(outPath, true);
            //copyFile2(fw, fr);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            //copyFile(br, bw);

            fileInputStream = new FileInputStream(inputPath);
            fileOutputStream = new FileOutputStream(outPath);
            //copyFile(fileInputStream, fileOutputStream);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //copyFile(bufferedInputStream, bufferedOutputStream);

            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
            // copyFile(inputStreamReader, outputStreamWriter);

            printWriter = new PrintWriter(bw);
            printStream = new PrintStream(new File(outPath));
            copyFile(br, printWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw != null){
                    fw.close();
                }
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
                if(bw != null ){
                    bw.close();
                }
                if(fileInputStream != null){
                    fileInputStream.close();
                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
                if(inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if(outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if(printStream != null) {
                    printStream.close();
                }
                if(printWriter != null) {
                    printWriter.close();
                }

            }catch (IOException e){
                logger.info("出错啦！");
            }

        }


    }

    private  void fileInit(String fileName, String notexistsFile){

        if(fileName != null && fileName.trim().length() > 0){
            File file = new File(fileName);
            logger.info("测试" + fileName + "的属性方法" );
            if(file.exists()){
                logger.info("此文件存在！");
                showFileInfo(file);
            }else {
                try {
                    logger.info("此文件不存在");
                    logger.info("创建一个新文件=》" + fileName + "创建结果=》" + file.createNewFile());
                    showFileInfo(file);
                    file.delete();
                } catch (IOException e) {
                    logger.info("文件流操作出错！");
                    e.printStackTrace();
                }
            }
        }

        if(notexistsFile != null && notexistsFile.trim().length() > 0){
            File file = new File(notexistsFile);
            if(file.exists()){
                logger.info("该文件或者目录已存在！");
            }else {
                logger.info("该文件不存在，执行mkdirs()方法创建。。。");
                if(file.mkdirs()){
                    logger.info("创建文件成功！");
                }else {
                    logger.info("创建文件失败！");

                }

            }
        }

    }

    /**
     * 删除文件
     * @param fileName 待删除的抽象路径名
     */
    public void deletFile(String fileName){
        if(fileName != null && fileName.trim().length() > 0)
        {
            File file = new File(fileName);
            if(file.exists()) {
                file.delete();
            }
            if(file.isFile()){
                logger.info(fileName + "文件删除成功！");
            }
            if(file.isDirectory()){
                logger.info(fileName + "目录删除成功！");
            }
        }
    }

    /**
     * 展示抽象路径名目录的文件和目录
     * @param fileName 指定抽象路径名
     * @param shouType 展示类型=》ignore(file) = "file"-展示抽象路径名下的文件数组；其他展示抽象路径名下的文件和目录字符串数组
     */
    public Object[] listFiles(String fileName, String shouType){
         File file = new File(fileName);
         if ("file".compareToIgnoreCase(shouType) == 0){
                return file.listFiles();
         }
         return file.list();
    }

    /**
     * 文件过滤器 FileFilter
     * @param
     * @param
     *
     */
    public static class MyFileFilter1 implements FileFilter{
        private final String fileType; // 文件类型过滤器
        private String  sufix;  // 文件名过滤器  规则自己定
        public MyFileFilter1(String sufix, String fileType) {
            this.sufix = sufix;
            this.fileType = fileType;
        }

        @Override
        public boolean accept(File pathname) {
            String filename = pathname.getName();

            if("file".compareToIgnoreCase(fileType) == 0){
                if(pathname.isFile() && filename.contains(sufix))
                    return true;
            } else if("directory".compareToIgnoreCase(fileType) == 0){
                if(pathname.isDirectory() && filename.contains(sufix))
                    return true;
            }else{
                return true;
            }

            return false;
        }
    }


    /**
     * 展示file实例的属性
     */
    private void showFileInfo(File file){
        logger.info("此文件是不是目录：" + file.isDirectory());
        logger.info("此文件是不是文件：" + file.isFile());
        logger.info("此文件对象的名称为：" + file.getName());
        logger.info("此文件对象的绝对路径为：" + file.getAbsolutePath());
        logger.info("此文件对象的绝对路径名形式为：" + file.getAbsoluteFile());
        logger.info("此文件对象的相对路径为：" + file.getPath());
        logger.info("此文件对象的相对路径为：" + file.getName());
        logger.info("此文件对象的父目录为：" + file.getParent());
        logger.info("此文件对象的父目录的抽象路径名为：" + file.getParentFile());
        logger.info("此文件对象长度为：" + file.length());
        logger.info("系统路径分割操作符为：" + File.pathSeparator);
        logger.info("系统名称分割符为：" + File.separator);
    }

    /**
     * File类方法测试
     */
    public void fileTest(String existsFile, String notexistsFile){
        /**
         * 测试已存在文件的内容
         */
        fileInit(existsFile, notexistsFile);
    }

    /*********************************************************************************************************************
     ************************************使用不同的IO继承类实现文本赋值*********************************************************
     *********************************************************************************************************************
     *********************************************************************************************************************
     **********************************************************************************************************************/

    /**
     *  利用字符流FileWriter FileReader实现文本文件复制
     *
     * 读取方式：1 按字符读取
     * @param fw  文件写入对象
     * @param fr 文件读取对象
     * @throws IOException IO异常
     */
    public static void copyFile(FileWriter fw, FileReader fr) throws IOException {
        logger.info("使用FileWriter，FileReader对象复制文件(按字符读取)。。。");
        long startTime = System.currentTimeMillis();
        int len;
        while ((len=fr.read()) != -1){
            fw.write(len);
        }
        fw.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime)/1000 + "秒。");
    }

    /**
     * 利用字符流FileWriter FileReader实现文本文件复制
     * 读取方式 按字符数组读取
     * @param fw
     * @param fr
     * @throws IOException
     */
    public static void copyFile2(FileWriter fw, FileReader fr ) throws IOException {
        logger.info("使用FileWriter，FileReader对象复制文件(按字符数组读取)。。。");
        long startTime = System.currentTimeMillis();
        char[] cache = new char[1024];
        int len;
        while ( (len=fr.read(cache)) != -1){
            fw.write(cache, 0, len);
        }
        fw.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime)/1000 + "秒。");
    }

    /**
     * 利用字符缓存流BufferedReader 和 BufferedWriter 实现文本文件复制
     *  读取方式 按字符缓存读取
     *
     */
    public static  void copyFile(BufferedReader fr, BufferedWriter fw) throws IOException {
        logger.info("BufferedReader，BufferedWriter对象复制文件(按字符缓存读取)。。。");
        long startTime = System.currentTimeMillis();
        int len;
        char[] cache = new char[1024];
        while ((len = fr.read(cache)) != -1){
            fw.write(cache, 0, len);
        }
        fw.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime)/1000 + "秒。");
    }

    /**
     * 利用字符缓存流BufferedReader 和 BufferedWriter 实现文本文件复制（还有一个PrintWriter实现对文件输出）
     * 读取方式 利用readLine实现
     * @param fr
     * @param fw
     */
    public static void copyFile2(BufferedWriter fw, BufferedReader fr) throws IOException {

        logger.info("BufferedReader，BufferedWriter对象复制文件(按字符缓存读取)。。。");
        long startTime = System.currentTimeMillis();
        String info = null;
        while ((info = fr.readLine()) != null){
            fw.write(info);
            fw.newLine();
        }
        fw.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime)/1000 + "秒。");
    }

    /**
     * 使用字节流实现文件复制
     * @param fileInputStream
     * @param fileOutputStream
     */
    public static void copyFile(FileInputStream fileInputStream,  FileOutputStream fileOutputStream) throws IOException {
        logger.info("FileInputStream，FileOutputStreamr对象复制文件(按字符缓存读取)。。。");
        long startTime = System.currentTimeMillis();
        int len;
        byte[] buff = new byte[1024];

        while ( (len = fileInputStream.read(buff) ) != -1) {
            fileOutputStream.write(buff, 0, len);
        }
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime) + "毫秒。");
    }

    /**
     * 使用缓存字节 复制文件
     * @param bufferedInputStream
     * @param bufferedOutputStream
     */
    public  static void copyFile(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        logger.info("BufferedInputStream，BufferedOutputStream对象复制文件(按字符缓存读取)。。。");
        long startTime = System.currentTimeMillis();
        int len;
        byte[] cache = new byte[1024];
        while ( (len = bufferedInputStream.read(cache) ) != -1) {
            bufferedOutputStream.write(cache, 0, len);
        }
        bufferedOutputStream.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime) + "毫秒。");
    }

    /**
     * 利用转化流复制文件-- 主要针对编码格式问题
     * @param inputStreamReader
     * @param outputStreamWriter
     * @throws IOException
     */
    public static void copyFile(InputStreamReader inputStreamReader, OutputStreamWriter outputStreamWriter) throws IOException {
        logger.info("BufferedInputStream，BufferedOutputStream对象复制文件(按字符缓存读取)。。。");
        long startTime = System.currentTimeMillis();
        int len;
        char[] cache = new char[1024];
        while ( (len = inputStreamReader.read(cache) ) != -1){
                outputStreamWriter.write(cache, 0, len);
        }
        outputStreamWriter.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime) + "毫秒。");
    }

    /**
     * 利用PrintWriter复制文件， input端可以使用任意输入流对象
     * @param reader
     * @param printWriter
     */
    public  static void copyFile(Reader reader, PrintWriter printWriter) throws IOException{
        logger.info("InputStreamReader，PrintWriter(PrintStream)对象复制文件。。。");
        long startTime = System.currentTimeMillis();
        int len;
        char[] cache = new char[1024];
        while ( (len = reader.read(cache) ) != -1){
            printWriter.println(cache);
        }
         printWriter.printf("今天我加班，加了%s个小时，太累了，喝了%s瓶白酒", 4, 7);
         printWriter.println("看我写的对不对!");
         printWriter.flush();
        long endTime = System.currentTimeMillis();
        logger.info("复制文件完成，总共用时" + (endTime - startTime) + "毫秒。");
    }





}
