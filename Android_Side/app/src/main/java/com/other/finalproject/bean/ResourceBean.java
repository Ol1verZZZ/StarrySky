package com.other.finalproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author: hedianbo.
 * date: 2019-12-29
 * desc:
 */
public class ResourceBean implements Serializable {

    /**
     * movies : [{"content":"别名:星球大战：豆瓣评分: 7.1导演:莱恩·约翰逊演员:黛西·雷德利 / 约翰·博耶加 / 亚当·德赖弗","likes":200,"picaddr":"static/image/png/2.png","point":20,"resourceid":2,"restype":2,"title":"星球大战8：最后的绝地武士","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-4fjm.html","username":"ZWH"},{"content":"豆瓣评分: 6.4\r\n导演:赖水清\r\n演员:黄海波 / 潘粤明 / 陈莎莉","likes":123,"picaddr":"static/image/png/4.png","point":20,"resourceid":4,"restype":2,"title":"新情义无价","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-5xo5.html","username":"ZWH"},{"content":"豆瓣评分: 未知导演:丁黑 / 张晓光演员:郭金 / 李煜 / 张鹭","likes":23,"picaddr":"static/image/png/5.png","point":20,"resourceid":5,"restype":2,"title":"沉星档案","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-6g40.html","username":"DYB"},{"content":"豆瓣评分: 未知导演:鄢颇演员:潘粤明 / 李小冉 / 高一玮","likes":22,"picaddr":"static/image/png/3.png","point":20,"resourceid":3,"restype":2,"title":"富滇风云","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-7tn9.html","username":"ZWH"}]
     * games : [{"content":"豆瓣评分: 7.3\r\n导演:延艺\r\n演员:潘粤明 / 刘涛","likes":123333,"picaddr":"static/image/png/6.png","point":20,"resourceid":6,"restype":1,"title":"盘龙卧虎高山顶","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-4305.html","username":"DYB"},{"content":"玩家可以在游戏中通过装扮与培育，打造出独一无二的宝贝，个性装扮都由自己来决定。","likes":10023,"picaddr":"static/image/png/7.png","point":20,"resourceid":7,"restype":1,"title":"《劲舞团》\u201c舞所不能\u201d精简版客户端","uploadTime":"2019-12-18 00:19:06","url":"http://dl.pcgames.com.cn/download/75157.html","username":"XJ"},{"content":"八大门派、自由飞行、云上家园、阵营对战、秘境探险、云海遨游、挖宝探秘、青灯引渡","likes":354,"picaddr":"static/image/png/8.png","point":20,"resourceid":8,"restype":1,"title":"古剑奇谭网络版》公测版本客户端","uploadTime":"2019-12-18 00:19:06","url":"http://dl.pcgames.com.cn/download/75153.html","username":"XJ"},{"content":"新一代自研3D\u201c速鲨\u201d引擎，极度流畅的操作手感，给你最热血、最激爽的格斗体验","likes":102,"picaddr":"static/image/png/9.png","point":20,"resourceid":9,"restype":1,"title":"格斗刀魂OL热血公测客户端_安卓版下载","uploadTime":"2019-12-18 00:19:06","url":"http://dl.pcgames.com.cn/download/72454.html","username":"XJ"}]
     * others : [{"content":"\u201c酱焖豆皮滋味浓厚，口感软嫩，吃起来更是下饭。\u201d无论大人还是小孩,都可以放心地吃豆皮","likes":323,"picaddr":"static/image/png/11.png","point":20,"resourceid":11,"restype":3,"title":"酱焖豆皮","uploadTime":"2019-12-18 00:19:06","url":"https://home.meishichina.com/recipe-501508.html","username":"QinKuai"},{"content":"简单又快手的家常小菜，健康又低脂，金针菇:活血化瘀菠菜:活血化瘀醋:活血化瘀","likes":253,"picaddr":"static/image/png/12.png","point":20,"resourceid":12,"restype":3,"title":"金针菇拌菠菜","uploadTime":"2019-12-03 01:50:51","url":"https://home.meishichina.com/recipe-501304.html","username":"QinKuai"},{"content":"景点地址：四川阿坝 四川省九寨沟县境内.九寨沟箭竹海海拔2618米，深6米，面积17万平方米，","likes":0,"picaddr":"static/image/png/13fgo.png","point":20,"resourceid":14,"restype":3,"title":"箭竹海","uploadTime":"2019-12-25 12:58:37","url":"https://aba.cncn.com/jingdian/jianzhuhai/","username":"QinKuai"},{"content":"ggggg","likes":0,"picaddr":"static/image/png/14fgo.png","point":20,"resourceid":15,"restype":3,"title":"aa","uploadTime":"2019-12-25 13:52:22","url":"www","username":"QinKuai"}]
     * ResponseCode : 200
     */

    private String responseCode;
    private List<MoviesBean> movies;
    private List<GamesBean> games;
    private List<OthersBean> others;

    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<MoviesBean> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesBean> movies) {
        this.movies = movies;
    }

    public List<GamesBean> getGames() {
        return games;
    }

    public void setGames(List<GamesBean> games) {
        this.games = games;
    }

    public List<OthersBean> getOthers() {
        return others;
    }

    public void setOthers(List<OthersBean> others) {
        this.others = others;
    }

    public static class MoviesBean implements Serializable{
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

    public static class GamesBean implements Serializable{
        /**
         * content : 豆瓣评分: 7.3
         导演:延艺
         演员:潘粤明 / 刘涛
         * likes : 123333
         * picaddr : static/image/png/6.png
         * point : 20
         * resourceid : 6
         * restype : 1
         * title : 盘龙卧虎高山顶
         * uploadTime : 2019-12-18 00:19:06
         * url : http://www.foxiys.com/a-4305.html
         * username : DYB
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

    public static class OthersBean implements Serializable{
        /**
         * content : “酱焖豆皮滋味浓厚，口感软嫩，吃起来更是下饭。”无论大人还是小孩,都可以放心地吃豆皮
         * likes : 323
         * picaddr : static/image/png/11.png
         * point : 20
         * resourceid : 11
         * restype : 3
         * title : 酱焖豆皮
         * uploadTime : 2019-12-18 00:19:06
         * url : https://home.meishichina.com/recipe-501508.html
         * username : QinKuai
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
