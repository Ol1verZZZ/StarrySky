package com.other.finalproject.bean;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
public class FavoriteB {


    /**
     * favorite : {"favoDate":1577548800000,"resourceid":7,"username":"DYB"}
     * ResponseCode : 206
     */

    private FavoriteBean favorite;
    private String responseCode;

    public FavoriteBean getFavorite() {
        return favorite;
    }

    public void setFavorite(FavoriteBean favorite) {
        this.favorite = favorite;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public static class FavoriteBean {
        /**
         * favoDate : 1577548800000
         * resourceid : 7
         * username : DYB
         */

        private long favoDate;
        private int resourceid;
        private String username;

        public long getFavoDate() {
            return favoDate;
        }

        public void setFavoDate(long favoDate) {
            this.favoDate = favoDate;
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
}
