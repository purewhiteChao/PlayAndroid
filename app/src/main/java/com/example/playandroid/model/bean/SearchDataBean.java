package com.example.playandroid.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 21:43
 * Describe: ${as}
 */
public class SearchDataBean implements Serializable{


    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"挖掘匠","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1479,"link":"http://www.jianshu.com/p/9b25087a5d7d","niceDate":"2017-10-31","origin":"","prefix":"","projectLink":"","publishTime":1509450445000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android <em class='highlight'>Studio3<\/em>.0正式版填坑路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"24K纯帅豆","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1478,"link":"http://www.jianshu.com/p/15afb8234d19","niceDate":"2017-10-31","origin":"","prefix":"","projectLink":"","publishTime":1509450421000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android <em class='highlight'>Studio3<\/em>.0更新之路（遇坑必入）","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":2}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean implements Serializable {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"挖掘匠","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1479,"link":"http://www.jianshu.com/p/9b25087a5d7d","niceDate":"2017-10-31","origin":"","prefix":"","projectLink":"","publishTime":1509450445000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android <em class='highlight'>Studio3<\/em>.0正式版填坑路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"24K纯帅豆","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1478,"link":"http://www.jianshu.com/p/15afb8234d19","niceDate":"2017-10-31","origin":"","prefix":"","projectLink":"","publishTime":1509450421000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android <em class='highlight'>Studio3<\/em>.0更新之路（遇坑必入）","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 2
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<Article> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Article> getDatas() {
            return datas;
        }


    }
}
