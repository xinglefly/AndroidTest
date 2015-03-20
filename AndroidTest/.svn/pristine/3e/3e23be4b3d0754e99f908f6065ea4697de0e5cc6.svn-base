
package com.xinglefly.activity.control_ui.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

import java.io.Serializable;

/**
 * User
 * 
 * @author xinglefly
 */
@Table(name = "VideoInfo")  // 建议加上注解， 混淆后表名不受影响
public class VideoInfo implements Serializable {

    private static final long serialVersionUID = 5180983886529522880L;
    
    //@Id // 如果主键没有命名名为id或_id的时，需要为主键添加此注解
    //@NoAutoIncrement // int,long类型的id默认自增，不想使用自增时添加此注解
    private int id;
    
    @Column(column="url")
    private String url;
    
    @Column(column="playid")
    private long playid;
    
    @Column(column="videoid")
    private int videoid;
    
    
    // Transient使这个列被忽略，不存入数据库
    @Column(column="currentPosition")
    private long currentPosition;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(long currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getPlayid() {
        return playid;
    }

    public void setPlayid(long playid) {
        this.playid = playid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    
    
    
    @Override
    public String toString() {
        return "VideoInfo [id=" + id + ", url=" + url + ", playid=" + playid + ", videoid="
                + videoid + ", currentPosition=" + currentPosition + "]";
    }

    public VideoInfo() {
        super();
    }

    public VideoInfo(String url, long playid, int videoid) {
        super();
        this.url = url;
        this.playid = playid;
        this.videoid = videoid;
    }

    public VideoInfo(long playid, int videoid, long currentPosition) {
        super();
        this.playid = playid;
        this.videoid = videoid;
        this.currentPosition = currentPosition;
    }

    

}
