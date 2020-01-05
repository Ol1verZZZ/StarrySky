package com.other.finalproject.bean;

import com.other.finalproject.utils.Constant;

import java.io.Serializable;
import java.util.List;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc: 帖子详情
 */
public class BBSPostDetailBean implements Serializable {


    /**
     * comments : [{"commentid":54,"content":"fs","date":"2019-12-25 04:30:47","pLike":0,"postid":3,"username":"DYB"}]
     * post : {"commentamount":1,"content":"大圣脆桃手办！出坑回血了","createdate":1575216000000,"fieldid":1,"pLike":24,"postid":3,"posttitle":"西游记之大圣归来吧","username":"XJ"}
     * follow : false
     * users : [{"birthday":1576080000000,"email":"2566663","exp":1420,"point":9840,"rank":8,"sex":"m","type":"m","username":"DYB"}]
     * Constant : 200
     */

    private PostBean post;
    private boolean follow;
    private String responseCode;
    private List<CommentsBean> comments;
    private List<UsersBean> users;

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }

    public static class PostBean {
        /**
         * commentamount : 1
         * content : 大圣脆桃手办！出坑回血了
         * createdate : 1575216000000
         * fieldid : 1
         * pLike : 24
         * postid : 3
         * posttitle : 西游记之大圣归来吧
         * username : XJ
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

    public static class CommentsBean {
        /**
         * commentid : 54
         * content : fs
         * date : 2019-12-25 04:30:47
         * pLike : 0
         * postid : 3
         * username : DYB
         */

        private int commentid;
        private String content;
        private String date;
        private int pLike;
        private int postid;
        private String username;

        public int getCommentid() {
            return commentid;
        }

        public void setCommentid(int commentid) {
            this.commentid = commentid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class UsersBean {
        /**
         * birthday : 1576080000000
         * email : 2566663
         * exp : 1420
         * point : 9840
         * rank : 8
         * sex : m
         * type : m
         * username : DYB
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
}
