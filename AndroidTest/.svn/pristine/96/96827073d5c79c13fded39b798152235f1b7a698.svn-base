package com.xinglefly.test;

import android.test.AndroidTestCase;
import android.util.Log;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;
import com.xinglefly.activity.control_ui.bean.VideoInfo;

import java.util.List;

/**
 * 详解Xutil的db使用
 * @author xinglefly
 *
 */
public class TextDB extends AndroidTestCase {

    private static final String TAG = "TextDB";

    /*************** Xutil db CRUD  *********************/

    public void testinsert() throws DbException {
        DbUtils db = DbUtils.create(getContext(), "VideoInfo");

        // VideoInfo info = new VideoInfo("不能这么丢脸", 453, 1251);
        VideoInfo info = new VideoInfo();
        info.setUrl("走就要走的正大光明");
        info.setPlayid(454);
        info.setVideoid(1254);
        info.setCurrentPosition(0);
        db.save(info);
        Log.d(TAG, "--insert-->" + info.toString());
    }

    public void testSelectAll() throws DbException {
        DbUtils db = DbUtils.create(getContext(), "VideoInfo");
        List<VideoInfo> info = db.findAll(Selector.from(VideoInfo.class));
        for (VideoInfo VideoInfo : info) {
            Log.d(TAG, "select all-->"+VideoInfo.toString());
        }
    }
    
    @SuppressWarnings("unused")
    public void testSelectAllById() throws DbException{
        DbUtils db = DbUtils.create(getContext(), "VideoInfo");
        List<VideoInfo> info = db.findAll(Selector.from(VideoInfo.class).where("playid", "=", 454).and("videoid","=",1254));
        VideoInfo VideoInfo2 = info.get(0);
            Log.d(TAG, "select by playid-->"+VideoInfo2.toString());
            if(VideoInfo2.getCurrentPosition()==0){
                //update data
                VideoInfo2.setCurrentPosition(12345678);
                db.update(VideoInfo2);
                Log.d(TAG, "update OK!");
            }else{
                //insert data
                db.save(new VideoInfo(123, 456, 789456));
                Log.d(TAG, "save OK!");
            }

    }
     
    public void testfindId() throws DbException{
        DbUtils db = DbUtils.create(getContext(), "VideoInfo");
        VideoInfo info = db.findById(VideoInfo.class, 0); //通过ID查询
        Log.d(TAG, "findId-->"+info.toString());
    }

    
    public void testUpdate() throws DbException{
        DbUtils db = DbUtils.create(getContext(), "VideoInfo");
//        db.update(VideoInfo.class, WhereBuilder.b("id", "=", 4),"videoid","currentPosition");
        VideoInfo newinfo = new VideoInfo(452, 1523, 1234569); 
        db.update(newinfo, "playid","videoid","currentPosition");
        testSelectAll();
    }
    
    public void testDelete() throws DbException{
        DbUtils db = DbUtils.create(getContext(), "VideoInfo");
        db.delete(VideoInfo.class, WhereBuilder.b("videoid", "=", 1253));
        Log.d(TAG, "delete OK!");
    }
    
    /*************** Xutil db *********************/
    
}
