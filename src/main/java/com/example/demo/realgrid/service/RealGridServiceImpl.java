package com.example.demo.realgrid.service;

import com.example.demo.realgrid.dto.RealGridDto;
import com.example.demo.realgrid.entity.RealGridEntity;
import com.example.demo.realgrid.repository.RealGridRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealGridServiceImpl implements RealGridService {

    // RealGridRepository를 주입받아 사용하기 위한 멤버 변수
    private final RealGridRepository realGridRepository;

    // 생성자를 통해 RealGridRepository의 의존성 주입
    public RealGridServiceImpl(RealGridRepository realGridRepository) {
        this.realGridRepository = realGridRepository;
    }

    // 모든 데이터를 조회하는 메서드
    @Override
    public List<RealGridDto> getAllDataDto() {
        // RealGridRepository에서 모든 엔터티를 조회
        List<RealGridEntity> entities = realGridRepository.findAll();

        // 엔터티를 DTO로 변환하여 리스트로 반환
        return entities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // RealGridEntity를 RealGridDto로 변환하는 메서드
    private RealGridDto convertToDto(RealGridEntity entity) {
        RealGridDto dto = new RealGridDto();
        dto.setEMAIL(entity.getEMAIL());
        dto.setINPDATE(entity.getINPDATE());
        dto.setINP_USR(entity.getINP_USR());
        dto.setNICKNAME(entity.getNICKNAME());
        return dto;
    }
}
