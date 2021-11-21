package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.CdrFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CdrController {

    public final CdrFacade cdrFacade;



    @GetMapping("/cdrs")
    public ResponseDto listAllCdrsByOperatorTypeName(@RequestParam(required = false) String operatorTypeName,
                                                     @RequestParam(required = false) String dataTypeName,
                                                     @RequestParam int page,
                                                     @RequestParam int pageSize) {

        return cdrFacade.getCdrs(operatorTypeName, dataTypeName, page, pageSize);
    }

    @GetMapping("/cdrs/{id}")
    public ResponseDto listCdrDetail(@PathVariable Long id) {
        return cdrFacade.getCdrById(id);
    }

    @PutMapping("/cdrs/{id}/update")
//    public CdrResponseDto updateCdr(parametry cdr) {
    public ResponseEntity<ResponseDto> updateCdr() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cdrs/create")
//    public CdrResponseDto createCdr(parametry cdr) {
    public ResponseEntity<ResponseDto> createCdr() {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cdrs/{id}")
    public ResponseEntity<ResponseDto> deleteCdrById(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        return ResponseEntity.ok().build();
    }
}
