package com.playdata.pdfolio.gather.service;

import com.playdata.pdfolio.domain.entity.gather.Gather;
import com.playdata.pdfolio.domain.request.gather.WriteRequest;
import com.playdata.pdfolio.gather.repository.GatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GatherService {
    private final GatherRepository gatherRepository;
    
    // 모집글 작성
    public void writeGather(WriteRequest writeRequest){
        Gather save = gatherRepository.save(writeRequest.toEntity());
//            writeRequest.gatherSkill(); 스킬 배열 하나씩 저장해야됨
    }
    
    // 모집글 수정
    public void modifyGather(WriteRequest writeRequest){
        Optional<Gather> optionalGather = gatherRepository.findById(writeRequest.id());

        if (optionalGather.isPresent()) { //  있는지 확인하고 실행
            Gather existingGather = optionalGather.get(); // find로 찾은 Gather 할당

            existingGather.setTitle(writeRequest.title());
            existingGather.setContent(writeRequest.content());
            existingGather.setStartDate(writeRequest.startDate());
            existingGather.setCloseDate(writeRequest.closeDate());
            existingGather.setTeamSize(writeRequest.teamSize());
            existingGather.setCategory(writeRequest.category());
            existingGather.setContact(writeRequest.contact());
            
            // 수정된거 저장
            Gather modifiedGather = gatherRepository.save(existingGather);
        } else {
            // Gather 엔터티를 찾지 못한 경우 예외 처리 또는 메시지 출력
            // 예: throw new NotFoundException("Gather not found with id: " + writeRequest.id());
        }
    }

}
