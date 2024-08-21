package kr.ac.kopo.minju_backend.controller;

import kr.ac.kopo.minju_backend.dto.MemoDTO;
import kr.ac.kopo.minju_backend.entity.Memo;
import kr.ac.kopo.minju_backend.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService){
        this.memoService = memoService;
    }

    @GetMapping("/findby_regdate/{regDate}")
    public ResponseEntity<MemoDTO> getMemoByRegDate(@PathVariable Date regDate){
        Optional<Memo> memo = memoService.findByRegDate(regDate);
        if (memo.isPresent()) {
            MemoDTO memoDTO = memoService.entityToDto(memo.get());
            return ResponseEntity.ok(memoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findby_moddate/{modDate}")
    public ResponseEntity<MemoDTO> getMemoByModDate(@PathVariable Date modDate){
        Optional<Memo> memo = memoService.findMemoByModDate(modDate);
        if (memo.isPresent()) {
            MemoDTO memoDTO = memoService.entityToDto(memo.get());
            return ResponseEntity.ok(memoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findby_memo/{memo_}")
    public ResponseEntity<MemoDTO> getMemoByMemo(@PathVariable String memo_){
        Optional<Memo> memo = memoService.findMemoByMemo(memo_);
        if (memo.isPresent()) {
            MemoDTO memoDTO = memoService.entityToDto(memo.get());
            return ResponseEntity.ok(memoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findby_memoid/{memoId}b")
    public ResponseEntity<MemoDTO> getMemoByMemoId(@PathVariable String memoId){
        Optional<Memo> memo = memoService.findMemoByMemoId(memoId);
        if (memo.isPresent()) {
            MemoDTO memoDTO = memoService.entityToDto(memo.get());
            return ResponseEntity.ok(memoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 메모 등록
    @PostMapping("/register")
    public ResponseEntity<MemoDTO> createMemo(@RequestBody MemoDTO memoDTO){
        Memo memo = memoService.registerMemo(memoDTO);
        MemoDTO createdMemoDTO = memoService.entityToDto((memo));
        return ResponseEntity.ok(createdMemoDTO);
    }

    // 메모 수정
    @PutMapping("/update")
    public ResponseEntity<MemoDTO> updateMemo(@RequestBody MemoDTO memoDetails) {
        Optional<Memo> updatedMemo = memoService.updateMemo(memoDetails);
        if (updatedMemo.isPresent()) {
            MemoDTO updatedMemoDTO = memoService.entityToDto(updatedMemo.get());
            return ResponseEntity.ok(updatedMemoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 메모 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMemo(@RequestBody MemoDTO memoDTO) {
        if (memoService.findMemoByMemoId(memoDTO.getMemoId()).isPresent()) {
            memoService.deleteMemo(memoDTO);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
