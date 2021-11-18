package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.CdrResponseDto;
import cz.azetex.cdrgenerator.facade.CdrFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CdrController {

    public final CdrFacade cdrFacade;

//    api/cdrs/
//    api/cdrs/{id}
//    api/cdrs?operatorTypeName=m2m&dataType=sms

    @GetMapping("/cdrs")
    public CdrResponseDto listAllCdrsByOperatorTypeName(@RequestParam(required = false) String operatorTypeName,
                                                        @RequestParam(required = false) String dataTypeName,
                                                        @RequestParam int page,
                                                        @RequestParam int pageSize) {

        return cdrFacade.getCdrs(operatorTypeName, dataTypeName, page, pageSize);
    }

    @GetMapping("/cdrs/{id}")
    public CdrResponseDto listCdrDetail(@PathVariable Long id) {
        return cdrFacade.getCdrById(id);
    }

    @PutMapping("/cdrs/{id}/update")
//    public CdrResponseDto updateCdr(parametry cdr) {
    public ResponseEntity<CdrResponseDto> updateCdr() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cdrs/create")
//    public CdrResponseDto createCdr(parametry cdr) {
    public ResponseEntity<CdrResponseDto> createCdr() {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cdrs/{id}")
    public ResponseEntity<CdrResponseDto> deleteCdrById(@PathVariable Long id) {
        CdrResponseDto cdrResponseDto = new CdrResponseDto();
        return ResponseEntity.ok().build();
    }
}
