package com.poetry.service;

import com.poetry.pojo.Do.read_record_commentDo;
import com.poetry.pojo.Dto.PoemReadRecordCommentDto;

import java.util.List;

public interface ReadRecordCommentService {

    int insert(read_record_commentDo record);

    List<PoemReadRecordCommentDto> listPoemReadRecordCommentDto(int id);


}
