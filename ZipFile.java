
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import java.io.File;

/**
 * Created by JossC on 2016/8/7.
 */
public class ZipFile {

    public File zipFile;

    public ZipFile(String  pathName){
        zipFile = new File(pathName);
    }

    /**
     * 压缩文件
     * @param scePathName
     */
    public void compress(String  scePathName){
        File srcdir = new File(scePathName);
        if(!srcdir.exists()){
            throw  new RuntimeException(scePathName + "不存在！");
        }
        Project project;
        project = new Project();
        Zip zip = new Zip();
        zip.setProject(project);
        zip.setDestFile(zipFile);
        FileSet fileSet = new FileSet();
        fileSet.setProject(project);
        fileSet.setDir(srcdir);
        zip.addFileset(fileSet);
        zip.execute();
    }

    /**
     * Test
     * @param args
     */
    public static void main(String []args){
        long begin = System.currentTimeMillis();
        File  file = new File("E:\\documentum");

        System.out.println(file.length());
        new ZipFile("D:\\documentum.zip").compress("E:\\documentum");
        long end = System.currentTimeMillis();
        System.out.println("压缩时间" + (end-begin)+"毫秒");
    }
}
