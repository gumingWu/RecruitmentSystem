package com.recruit.server.mapper;

import com.recruit.server.model.model_test.test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface mapper_test {
    List<test> selectall();
}
