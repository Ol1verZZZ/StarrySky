package com.other.finalproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
public class BBSPost implements Serializable {


    /**
     * posts : [{"commentamount":4,"content":"西游降魔篇，高清度盘","createdate":1577203200000,"fieldid":1,"pLike":4,"postid":44,"posttitle":"西游降魔篇，高清度盘","username":"QinKuai"},{"commentamount":0,"content":"经典侠客RPG","createdate":1577203200000,"fieldid":1,"pLike":0,"postid":45,"posttitle":"西游降魔篇《武林群侠传》 开局V12 金庸卡牌RPG","username":"QinKuai"},{"commentamount":1,"content":"这里夏至，本文微甜无虐","createdate":1577203200000,"fieldid":1,"pLike":1,"postid":46,"posttitle":"Eternal°崇萧「原创」暮冬","username":"QinKuai"},{"commentamount":1,"content":"《我的熊猫男友》甜文（原创） 这里是乐大大，初来驾到，请多关照！","createdate":1577203200000,"fieldid":1,"pLike":0,"postid":59,"posttitle":"《我的熊猫男友》","username":"QinKuai"},{"commentamount":0,"content":"本吧是熊迷们的聚集地","createdate":1577203200000,"fieldid":1,"pLike":0,"postid":60,"posttitle":"熊出没之夺宝熊兵吧\r\n熊出没之夺宝熊兵吧","username":"QinKuai"},{"commentamount":1,"content":"在甘肃武威农村现在创业,做什么前景比较好??","createdate":1577203200000,"fieldid":1,"pLike":2,"postid":81,"posttitle":"在甘肃武威农村现在创业,做什么前景比较好??","username":"DYB"},{"commentamount":0,"content":"\r\n很垃圾一个电影。特别是万国鹏我看着都恶心","createdate":1577203200000,"fieldid":1,"pLike":0,"postid":84,"posttitle":"很垃圾一个电影。特别是万国鹏我看着都恶心","username":"DYB"},{"commentamount":0,"content":"\r\n蓝光碟收到了","createdate":1577203200000,"fieldid":1,"pLike":0,"postid":93,"posttitle":"蓝光碟收到了","username":"DYB"},{"commentamount":0,"content":"题记：我这一楼开得比较正规。","createdate":1577203200000,"fieldid":1,"pLike":0,"postid":95,"posttitle":"我愿未来有你，写给以电影三生三世为代表的中国仙幻电影","username":"QinKuai"},{"commentamount":0,"content":"动画电影《大鱼海棠》粉丝聚集地","createdate":1575388800000,"fieldid":1,"pLike":0,"postid":61,"posttitle":"大鱼海棠吧","username":"QinKuai"},{"commentamount":1,"content":"大圣脆桃手办！出坑回血了","createdate":1575216000000,"fieldid":1,"pLike":24,"postid":3,"posttitle":"西游记之大圣归来吧","username":"XJ"},{"commentamount":0,"content":"【抬头园林】供应绚丽,冬红,红丽,凯尔斯,草原之火,草莓果冻等多个品种.","createdate":1574352000000,"fieldid":1,"pLike":0,"postid":62,"posttitle":"【抬头园林】绚丽,冬红,红丽,亚当,草原之火","username":"QinKuai"}]
     * Constant : 200
     */

    private String responseCode;
    private List<PostsBean> posts;

    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class PostsBean {
        /**
         * commentamount : 4
         * content : 西游降魔篇，高清度盘
         * createdate : 1577203200000
         * fieldid : 1
         * pLike : 4
         * postid : 44
         * posttitle : 西游降魔篇，高清度盘
         * username : QinKuai
         */

        private int commentamount;
        private String content;
        private long createdate;
        private int fieldid;
        private int pLike;
        private int postid;
        private String posttitle;
        private String username;

        public int getCommentamount() {
            return commentamount;
        }

        public void setCommentamount(int commentamount) {
            this.commentamount = commentamount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreatedate() {
            return createdate;
        }

        public void setCreatedate(long createdate) {
            this.createdate = createdate;
        }

        public int getFieldid() {
            return fieldid;
        }

        public void setFieldid(int fieldid) {
            this.fieldid = fieldid;
        }

        public int getPLike() {
            return pLike;
        }

        public void setPLike(int pLike) {
            this.pLike = pLike;
        }

        public int getPostid() {
            return postid;
        }

        public void setPostid(int postid) {
            this.postid = postid;
        }

        public String getPosttitle() {
            return posttitle;
        }

        public void setPosttitle(String posttitle) {
            this.posttitle = posttitle;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
