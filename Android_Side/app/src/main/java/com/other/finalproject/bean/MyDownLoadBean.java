package com.other.finalproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author: hedianbo.
 * date: 2019-12-31
 * desc:
 */
public class MyDownLoadBean implements Serializable {

    /**
     * downloads : [{"dId":23,"date":1577721600000,"owner":"ZWH","point":16,"resourceid":2,"username":"g"}]
     * exps : [{"exp":50,"rank":0},{"exp":100,"rank":1},{"exp":150,"rank":2},{"exp":200,"rank":3},{"exp":250,"rank":4},{"exp":300,"rank":5},{"exp":500,"rank":6},{"exp":800,"rank":7},{"exp":1500,"rank":8},{"exp":4000,"rank":9},{"exp":8000,"rank":10},{"exp":15000,"rank":11},{"exp":30000,"rank":12},{"exp":40000,"rank":13},{"exp":50000,"rank":14},{"exp":60000,"rank":15},{"exp":1000000,"rank":16},{"exp":1000000000,"rank":17}]
     * resources : [{"content":"别名:星球大战：豆瓣评分: 7.1导演:莱恩·约翰逊演员:黛西·雷德利 / 约翰·博耶加 / 亚当·德赖弗","likes":200,"picaddr":"static/image/png/2.png","point":20,"resourceid":2,"restype":2,"title":"星球大战8：最后的绝地武士","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-4fjm.html","username":"ZWH"}]
     * user : {"email":"e","exp":10,"point":99980,"rank":0,"sex":"f","type":"n","username":"g"}
     * responseCode : 200
     */

    private UserBean user;
    private String responseCode;
    private List<DownloadsBean> downloads;
    private List<ExpsBean> exps;
    private List<ResourcesBean> resources;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<DownloadsBean> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<DownloadsBean> downloads) {
        this.downloads = downloads;
    }

    public List<ExpsBean> getExps() {
        return exps;
    }

    public void setExps(List<ExpsBean> exps) {
        this.exps = exps;
    }

    public List<ResourcesBean> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesBean> resources) {
        this.resources = resources;
    }

    public static class UserBean {
        /**
         * email : e
         * exp : 10
         * point : 99980
         * rank : 0
         * sex : f
         * type : n
         * username : g
         */

        private String email;
        private int exp;
        private int point;
        private int rank;
        private String sex;
        private String type;
        private String username;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class DownloadsBean {
        /**
         * dId : 23
         * date : 1577721600000
         * owner : ZWH
         * point : 16
         * resourceid : 2
         * username : g
         */

        private int dId;
        private long date;
        private String owner;
        private int point;
        private int resourceid;
        private String username;

        public int getDId() {
            return dId;
        }

        public void setDId(int dId) {
            this.dId = dId;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class ExpsBean {
        /**
         * exp : 50
         * rank : 0
         */

        private int exp;
        private int rank;

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public static class ResourcesBean {
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
