package com.poetry.service;

import com.poetry.pojo.Dto.RankInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RankService {

    List<RankInfoDto> getOneDayRankings();

    List<RankInfoDto> getOneWeekRankings();

    public boolean addLike(int videoId);

    boolean addComment(int videoId);

}
