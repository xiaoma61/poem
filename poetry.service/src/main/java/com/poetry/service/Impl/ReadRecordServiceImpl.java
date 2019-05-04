package com.poetry.service.Impl;

import com.poetry.dao.ReadRecordMapper;
import com.poetry.service.ReadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadRecordServiceImpl implements ReadRecordService {
    @Autowired
    ReadRecordMapper readRecordMapper;
}
