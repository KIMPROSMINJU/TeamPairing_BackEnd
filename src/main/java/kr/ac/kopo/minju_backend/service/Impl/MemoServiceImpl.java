package kr.ac.kopo.minju_backend.service.Impl;

import kr.ac.kopo.minju_backend.dto.MemoDTO;
import kr.ac.kopo.minju_backend.entity.Memo;
import kr.ac.kopo.minju_backend.repository.MemoRepository;
import kr.ac.kopo.minju_backend.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {
    private final MemoRepository memoRepository;

    @Autowired
    public MemoServiceImpl(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }
        // 메모 등록
    public Memo registerMemo(MemoDTO dto){
        Memo memo = dtoToEntity(dto);
        return memoRepository.save(memo);
    };

    // 메모 삭제
    public void deleteMemo(MemoDTO dto){
        memoRepository.deleteMemoByMemoId(dto.getMemoId());
    };

    // 메모 수정
    public Optional<Memo> updateMemo(MemoDTO dto){
        Optional<Memo> optionalMemo = memoRepository.findMemoByMemoId(dto.getMemoId());
        if (optionalMemo.isPresent()){
            Memo memo = optionalMemo.get();
            memo.setMemo(dto.getMemo());
            memo.setModDate(dto.getModDate());
            memoRepository.save(memo);
            return Optional.of(memo);
        } else {
            return Optional.empty();
        }
    };

    // 최초작성날짜로 메모 검색
    public Optional<Memo> findByRegDate(Date regDate){
        return memoRepository.findMemoByRegDate(regDate);
    };

    // 최종수정날짜로 메모 검색
    public Optional<Memo> findMemoByModDate(Date modDate){
        return memoRepository.findMemoByModDate(modDate);
    };

    // 메모 내용으로 메모 검색
    public Optional<Memo> findMemoByMemo(String memo){
        return memoRepository.findMemoByMemo(memo);
    };

    // 메모 아이디로 메모 검색
    public Optional<Memo> findMemoByMemoId(String memoId){
        return memoRepository.findMemoByMemoId(memoId);
    };
}
