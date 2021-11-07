package com.stone.service_member;

import java.util.List;

import com.stone.common_exhibition.Exhibition;

public interface IExhibitionService {

	List<Exhibition> process1(Integer order);

	Exhibition process2(int no);

	List<Exhibition> process3(int no);
}