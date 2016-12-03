package com.cn.service;

import com.cn.dao.NewsDAO;
import com.cn.model.News;
import com.cn.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

/**
 * Created by cn on 2016/7/2.
 */
@Service
public class NewsService {
    @Autowired
    private NewsDAO newsDAO;

    /**
     *
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    public List<News> getLatestNews(int userId, int offset, int limit) {
        return newsDAO.selectByUserIdAndOffset(userId, offset, limit);
    }

    /**
     * 添加咨询
     * @param news
     * @return
     */
    public int addNews(News news) {
        newsDAO.addNews(news);
        return news.getId();
    }

    /**
     * 获取
     * @param newsId
     * @return
     */
    public News getById(int newsId) {
        return newsDAO.getById(newsId);
    }

    /**
     * 保存图片
     * @param file
     * @return
     * @throws IOException
     */
    public String saveImage(MultipartFile file) throws IOException {
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        if (!ToutiaoUtil.isFileAllowed(fileExt)) {
            return null;
        }

        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
        Files.copy(file.getInputStream(), new File(ToutiaoUtil.IMAGE_DIR + fileName).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return ToutiaoUtil.TOUTIAO_DOMAIN + "image?name=" + fileName;
    }

    /**
     * 更新评论数
     * @param id
     * @param count
     * @return
     */
    public int updateCommentCount(int id, int count) {
        return newsDAO.updateCommentCount(id, count);
    }

    /**
     * 与数据库中对应
     * @param id
     * @param count
     * @return
     */
    public int updateLikeCount(int id, int count) {
        return newsDAO.updateLikeCount(id, count);
    }
}
