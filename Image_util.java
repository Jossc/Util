import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 修改图片
 */
public class Image_util {

    public static void createThumbnail(String filename,int thumbWidth,int thumbHeiht,int quality,String outFilename) throws InterruptedException, IOException {
        /**
         * 获取本地图片名称
         */
        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image,0);
        mediaTracker.waitForID(0);

        double  thumbnail = (double)thumbWidth / (double)thumbHeiht;
        int imagerWith = image.getWidth(null);
        int imagerHeight = image.getHeight(null);
        double imageRatio = (double) imagerWith / (double)imagerHeight;
        if(thumbnail<imageRatio){
            thumbHeiht = (int) (thumbWidth/imageRatio);
        }else {
            thumbWidth = (int) (thumbWidth*imageRatio);
        }

        /**
         * 重新构造图片
         */
        BufferedImage thumbImage = new BufferedImage(thumbWidth,thumbHeiht,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumbImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image,0,0,thumbWidth,thumbHeiht,null);

        /**
         * 保存图片
         */
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);
        quality  = Math.max(0,Math.min(quality,100));
        param.setQuality((float) quality/ 100.0f,false);
        encoder.setJPEGEncodeParam(param);
        encoder.encode(thumbImage);

        if(out!=null){
            out.close();
        }
    }
}
