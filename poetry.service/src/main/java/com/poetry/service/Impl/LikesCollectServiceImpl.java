package com.poetry.service.Impl;

import com.poetry.dao.LikesCollectMapper;
import com.poetry.pojo.Do.likes_collectDo;
import com.poetry.pojo.Dto.Likes_CollectionDto;
import com.poetry.service.LikesCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.poetry.commom.constant.Constants.COLLECTION;
import static com.poetry.commom.constant.Constants.LIKE;

@Service
public class LikesCollectServiceImpl implements LikesCollectService {
    @Autowired
    LikesCollectMapper likesCollectMapper;

    @Override
    public List<Likes_CollectionDto> listLikes_CollectionDto(String id, String type) {
        return likesCollectMapper.listLikes_CollectionDto(id, type);
    }

    @Override
    public int insert(likes_collectDo record) {

        likesCollectMapper.insert(record);

        return 0;
    }

    @Override
    public int deleteByUeser_idAndPoem_idAndType(String user_id, Integer poem_id, String type) {

        likesCollectMapper.deleteByUeser_idAndPoem_idAndType(user_id, poem_id, type);
        return 0;
    }

    @Override
    public int like_collect(likes_collectDo record, int type, boolean like) {

        String mtype="";
        if (like){
            mtype=LIKE;

        }else {
            mtype=COLLECTION;
        }
        if (type==1){
            likesCollectMapper.deleteByUeser_idAndPoem_idAndType(record.getUeserId(),record.getPoemId(),mtype);
            likesCollectMapper.insert(record);
        }else {
            likesCollectMapper.deleteByUeser_idAndPoem_idAndType(record.getUeserId(),record.getPoemId(),mtype);
        }

        return 0;
    }
}
