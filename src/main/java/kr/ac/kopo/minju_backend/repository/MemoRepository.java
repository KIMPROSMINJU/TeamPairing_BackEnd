package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 최초작성날짜로 메모 검색
    Optional<Memo> findMemoByRegDate(Date regDate);

    // 최종수정날짜로 메모 검색
    Optional<Memo> findMemoByModDate(Date modDate);

    // 메모 내용으로 메모 검색
    Optional<Memo> findMemoByMemo(String memo);

    // 메모 아이디로 메모 검색
    Optional<Memo> findMemoByMemoId(String memoId);

    // 메모아이디로 메모 삭제
    Optional<Memo> deleteMemoByMemoId(String memoId);
}
