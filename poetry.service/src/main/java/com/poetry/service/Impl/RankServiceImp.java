package com.poetry.service.Impl;

import com.poetry.commom.RedisUtil;
import com.poetry.commom.SerializeUtil;
import com.poetry.dao.ReadRecordMapper;
import com.poetry.dao.UserMapper;
import com.poetry.pojo.Dto.RankInfoDto;
import com.poetry.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RankServiceImp implements RankService {

    public static final int RANK_MEMEBER_FIRST=0;
    public static final int RANK_MEMEBER_LAST=9;

    @Autowired
    UserMapper userMapper;
    @Autowired
    ReadRecordMapper readRecordMapper;


    @Override
    public List<RankInfoDto> getOneDayRankings() {
        List<RankInfoDto> rankList=new ArrayList<>();
        String key= "like"+getDateString(new Date());
        Set<Integer> videoIdSet=RedisUtil.revRange(key,RANK_MEMEBER_FIRST,RANK_MEMEBER_LAST);
        for (int videoId:videoIdSet){
            setRankInfo(videoId,rankList,key);

        }
        return rankList;
    }

    @Override
    public List<RankInfoDto> getOneWeekRankings() {
        List<String> weekKeys=getWeekString();
        String key="weekRank";
        RedisUtil.unionAndStore(weekKeys,key);
        Set<Integer> result=RedisUtil.revRange("weekRank",RANK_MEMEBER_FIRST,RANK_MEMEBER_LAST);
        List<RankInfoDto> weekRankList=new ArrayList<>();
        for (int videoId:result){
            setRankInfo(videoId,weekRankList,key);
        }
        return weekRankList;
    }

    @Override
    public boolean addLike(int videoId) {
        String key= "like"+getDateString(new Date());
        boolean res=RedisUtil.incrScore(key,1,videoId);
        if (res)return true;
        return false;
    }

    @Override
    public boolean addComment(int videoId) {
        String key="comment"+getDateString(new Date());
        boolean res=RedisUtil.incrScore(key,1,videoId);
        if (res)return true;
        return false;
    }

    private int getTodayCommentNumByvideoId(int videoId){
        String key="comment"+getDateString(new Date());
        double commentNum=RedisUtil.score(key,videoId);
        return (int) commentNum;
    }

    private String getDateString(Date date){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        String result=dateFormat.format(date);
        return result;
    }

    private List<String> getWeekString(){
        Date today=new Date();
        Calendar calendar=Calendar.getInstance();
        List<String> result=new ArrayList<>();
        for (int i=0;i<7;i++){
            result.add("like"+getDateString(today));
            int day=calendar.get(Calendar.DATE);
            calendar.set(Calendar.DATE,day-1);
            today=calendar.getTime();
            System.out.println(getDateString(today));
        }
        return result;
    }

    private void setRankInfo(int videoId,List<RankInfoDto> arrayList,String key){
        RankInfoDto infoDto=readRecordMapper.selectRankInfoById(videoId);
        if (infoDto!=null){
            infoDto.setCommentsNum(getTodayCommentNumByvideoId(videoId));
            infoDto.setVideoId(videoId);
            infoDto.setLikesNum((int) RedisUtil.score(key,videoId));
            arrayList.add(infoDto);
        }
    }


}
