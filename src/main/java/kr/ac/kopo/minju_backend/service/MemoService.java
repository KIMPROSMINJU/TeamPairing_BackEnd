package kr.ac.kopo.minju_backend.service;

import kr.ac.kopo.minju_backend.dto.MemoDTO;
import kr.ac.kopo.minju_backend.entity.Memo;

import java.sql.Date;
import java.util.Optional;

public interface MemoService {
    // 메모 등록
    Memo registerMemo(MemoDTO dto);

    // 메모 삭제
    void deleteMemo(MemoDTO dto);

    // 메모 수정
    Optional<Memo> updateMemo(MemoDTO dto);

    // 최초작성날짜로 메모 검색
    Optional<Memo> findByRegDate(Date regDate);

    // 최종수정날짜로 메모 검색
    Optional<Memo> findMemoByModDate(Date modDate);

    // 메모 내용으로 메모 검색
    Optional<Memo> findMemoByMemo(String memo);

    // 메모 아이디로 메모 검색
    Optional<Memo> findMemoByMemoId(String memoId);

    default Memo dtoToEntity(MemoDTO dto){
        return Memo.builder()
                .memoId(dto.getMemoId())
                .regDate(dto.getRegDate())
                .modDate(dto.getModDate())
                .memo(dto.getMemo())
                .build();
    }

    default MemoDTO entityToDto(Memo entity){
        return MemoDTO.builder()
                .memoId(entity.getMemoId())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .memo(entity.getMemo())
                .build();
    }
}
