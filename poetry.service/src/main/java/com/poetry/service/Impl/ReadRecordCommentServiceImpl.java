package com.poetry.service.Impl;

import com.poetry.dao.ReadRecordCommentMapper;
import com.poetry.pojo.Do.read_record_commentDo;
import com.poetry.pojo.Dto.PoemReadRecordCommentDto;
import com.poetry.service.ReadRecordCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadRecordCommentServiceImpl implements ReadRecordCommentService {
    @Autowired
    ReadRecordCommentMapper readRecordCommentMapper;

    @Override
    public int insert(read_record_commentDo record) {

        readRecordCommentMapper.insert(record);

        return 0;
    }

    @Override
    public List<PoemReadRecordCommentDto> listPoemReadRecordCommentDto(int id) {

        return readRecordCommentMapper.listPoemReadRecordCommentDto(id);
    }


}
