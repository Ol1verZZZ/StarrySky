package com.other.finalproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author: hedianbo.
 * date: 2019-12-31
 * desc:
 */
public class CollectResourceBean implements Serializable{


    /**
     * resources : [{"content":"别名:星球大战：豆瓣评分: 7.1导演:莱恩·约翰逊演员:黛西·雷德利 / 约翰·博耶加 / 亚当·德赖弗","likes":200,"picaddr":"static/image/png/2.png","point":20,"resourceid":2,"restype":2,"title":"星球大战8：最后的绝地武士","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-4fjm.html","username":"ZWH"},{"content":"豆瓣评分: 6.4\r\n导演:赖水清\r\n演员:黄海波 / 潘粤明 / 陈莎莉","likes":123,"picaddr":"static/image/png/4.png","point":20,"resourceid":4,"restype":2,"title":"新情义无价","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-5xo5.html","username":"ZWH"}]
     * responseCode : 200
     */

    private String responseCode;
    private List<ResourcesBean> resources;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<ResourcesBean> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesBean> resources) {
        this.resources = resources;
    }

    public static class ResourcesBean implements Serializable {
        /**
         * content : 别名:星球大战：豆瓣评分: 7.1导演:莱恩·约翰逊演员:黛西·雷德利 / 约翰·博耶加 / 亚当·德赖弗
         * likes : 200
         * picaddr : static/image/png/2.png
         * point : 20
         * resourceid : 2
         * restype : 2
         * title : 星球大战8：最后的绝地武士
         * uploadTime : 2019-12-18 00:19:06
         * url : http://www.foxiys.com/a-4fjm.html
         * username : ZWH
         */

        private String content;
        private int likes;
        private String picaddr;
        private int point;
        private int resourceid;
        private int restype;
        private String title;
        private String uploadTime;
        private String url;
        private String username;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getPicaddr() {
            return picaddr;
        }

        public void setPicaddr(String picaddr) {
            this.picaddr = picaddr;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getResourceid() {
            return resourceid;
        }

        public void setResourceid(int resourceid) {
            this.resourceid = resourceid;
        }

        public int getRestype() {
            return restype;
        }

        public void setRestype(int restype) {
            this.restype = restype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUploadTime() {
            return uploadTime;
        }

        public void setUploadTime(String uploadTime) {
            this.uploadTime = uploadTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
