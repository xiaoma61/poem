package com.poetry.dao;

import com.poetry.pojo.Do.read_record_commentDo;
import com.poetry.pojo.Dto.PoemReadRecordCommentDto;

import java.util.List;

public interface ReadRecordCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(read_record_commentDo record);

    int insertSelective(read_record_commentDo record);

    read_record_commentDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(read_record_commentDo record);

    int updateByPrimaryKey(read_record_commentDo record);

    List<PoemReadRecordCommentDto> listPoemReadRecordCommentDto(int id);

}