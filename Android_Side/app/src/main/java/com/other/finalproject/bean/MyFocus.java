package com.other.finalproject.bean;

import java.util.List;

/**
 * author: hedianbo.
 * date: 2020-01-01
 * desc:
 */
public class MyFocus {


    /**
     * followers : {"qwe":1,"QinKuai":3}
     * followings : [{"birthday":1576080000000,"email":"2609935221@qq.com","exp":50180,"point":99982,"rank":15,"sex":"m","type":"m","username":"QinKuai"},{"email":"qwer","exp":0,"point":0,"rank":0,"sex":"m","type":"n","username":"qwe"}]
     * exps : [{"exp":50,"rank":0},{"exp":100,"rank":1},{"exp":150,"rank":2},{"exp":200,"rank":3},{"exp":250,"rank":4},{"exp":300,"rank":5},{"exp":500,"rank":6},{"exp":800,"rank":7},{"exp":1500,"rank":8},{"exp":4000,"rank":9},{"exp":8000,"rank":10},{"exp":15000,"rank":11},{"exp":30000,"rank":12},{"exp":40000,"rank":13},{"exp":50000,"rank":14},{"exp":60000,"rank":15},{"exp":1000000,"rank":16},{"exp":1000000000,"rank":17}]
     * resources : {"qwe":[{"content":"玩家可以在游戏中通过装扮与培育，打造出独一无二的宝贝，个性装扮都由自己来决定。","likes":10023,"picaddr":"static/image/png/7.png","point":20,"resourceid":7,"restype":1,"title":"《劲舞团》\u201c舞所不能\u201d精简版客户端","uploadTime":"2019-12-18 00:19:06","url":"http://dl.pcgames.com.cn/download/75157.html","username":"qwe"},{"content":"\u201c酱焖豆皮滋味浓厚，口感软嫩，吃起来更是下饭。\u201d无论大人还是小孩,都可以放心地吃豆皮","likes":323,"picaddr":"static/image/png/11.png","point":20,"resourceid":11,"restype":3,"title":"酱焖豆皮","uploadTime":"2019-12-18 00:19:06","url":"https://home.meishichina.com/recipe-501508.html","username":"qwe"},{"content":"别名:星球大战：豆瓣评分: 7.1导演:莱恩·约翰逊演员:黛西·雷德利 / 约翰·博耶加 / 亚当·德赖弗","likes":200,"picaddr":"static/image/png/2.png","point":20,"resourceid":2,"restype":2,"title":"星球大战8：最后的绝地武士","uploadTime":"2019-12-18 00:19:06","url":"http://www.foxiys.com/a-4fjm.html","username":"qwe"}],"QinKuai":[{"content":"简单又快手的家常小菜，健康又低脂，金针菇:活血化瘀菠菜:活血化瘀醋:活血化瘀","likes":253,"picaddr":"static/image/png/12.png","point":20,"resourceid":12,"restype":3,"title":"金针菇拌菠菜","uploadTime":"2019-12-03 01:50:51","url":"https://home.meishichina.com/recipe-501304.html","username":"QinKuai"},{"content":"景点地址：四川阿坝 四川省九寨沟县境内.九寨沟箭竹海海拔2618米，深6米，面积17万平方米，","likes":0,"picaddr":"static/image/png/13fgo.png","point":20,"resourceid":14,"restype":3,"title":"箭竹海","uploadTime":"2019-12-25 12:58:37","url":"https://aba.cncn.com/jingdian/jianzhuhai/","username":"QinKuai"},{"content":"ggggg","likes":0,"picaddr":"static/image/png/14fgo.png","point":20,"resourceid":15,"restype":3,"title":"aa","uploadTime":"2019-12-25 13:52:22","url":"www","username":"QinKuai"}]}
     * user : {"email":"qwer","exp":0,"point":0,"rank":0,"sex":"m","type":"n","username":"qwe"}
     * uploads : {"qwe":5,"QinKuai":5}
     * responseCode : 200
     */

    private FollowersBean followers;
    private ResourcesBean resources;
    private UserBean user;
    private UploadsBean uploads;
    private String responseCode;
    private List<FollowingsBean> followings;
    private List<ExpsBean> exps;

    public FollowersBean getFollowers() {
        return followers;
    }

    public void setFollowers(FollowersBean followers) {
        this.followers = followers;
    }

    public ResourcesBean getResources() {
        return resources;
    }

    public void setResources(ResourcesBean resources) {
        this.resources = resources;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public UploadsBean getUploads() {
        return uploads;
    }

    public void setUploads(UploadsBean uploads) {
        this.uploads = uploads;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<FollowingsBean> getFollowings() {
        return followings;
    }

    public void setFollowings(List<FollowingsBean> followings) {
        this.followings = followings;
    }

    public List<ExpsBean> getExps() {
        return exps;
    }

    public void setExps(List<ExpsBean> exps) {
        this.exps = exps;
    }

    public static class FollowersBean {
        /**
         * qwe : 1
         * QinKuai : 3
         */

        private int qwe;
        private int QinKuai;

        public int getQwe() {
            return qwe;
        }

        public void setQwe(int qwe) {
            this.qwe = qwe;
        }

        public int getQinKuai() {
            return QinKuai;
        }

        public void setQinKuai(int QinKuai) {
            this.QinKuai = QinKuai;
        }
    }

    public static class ResourcesBean {
        private List<QweBean> qwe;
        private List<QinKuaiBean> QinKuai;

        public List<QweBean> getQwe() {
            return qwe;
        }

        public void setQwe(List<QweBean> qwe) {
            this.qwe = qwe;
        }

        public List<QinKuaiBean> getQinKuai() {
            return QinKuai;
        }

        public void setQinKuai(List<QinKuaiBean> QinKuai) {
            this.QinKuai = QinKuai;
        }

        public static class QweBean {
            /**
             * content : 玩家可以在游戏中通过装扮与培育，打造出独一无二的宝贝，个性装扮都由自己来决定。
             * likes : 10023
             * picaddr : static/image/png/7.png
             * point : 20
             * resourceid : 7
             * restype : 1
             * title : 《劲舞团》“舞所不能”精简版客户端
             * uploadTime : 2019-12-18 00:19:06
             * url : http://dl.pcgames.com.cn/download/75157.html
             * username : qwe
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

        public static class QinKuaiBean {
            /**
             * content : 简单又快手的家常小菜，健康又低脂，金针菇:活血化瘀菠菜:活血化瘀醋:活血化瘀
             * likes : 253
             * picaddr : static/image/png/12.png
             * point : 20
             * resourceid : 12
             * restype : 3
             * title : 金针菇拌菠菜
             * uploadTime : 2019-12-03 01:50:51
             * url : https://home.meishichina.com/recipe-501304.html
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

    public static class UserBean {
        /**
         * email : qwer
         * exp : 0
         * point : 0
         * rank : 0
         * sex : m
         * type : n
         * username : qwe
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

    public static class UploadsBean {
        /**
         * qwe : 5
         * QinKuai : 5
         */

        private int qwe;
        private int QinKuai;

        public int getQwe() {
            return qwe;
        }

        public void setQwe(int qwe) {
            this.qwe = qwe;
        }

        public int getQinKuai() {
            return QinKuai;
        }

        public void setQinKuai(int QinKuai) {
            this.QinKuai = QinKuai;
        }
    }

    public static class FollowingsBean {
        /**
         * birthday : 1576080000000
         * email : 2609935221@qq.com
         * exp : 50180
         * point : 99982
         * rank : 15
         * sex : m
         * type : m
         * username : QinKuai
         */

        private long birthday;
        private String email;
        private int exp;
        private int point;
        private int rank;
        private String sex;
        private String type;
        private String username;

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

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
}
