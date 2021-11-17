//package cz.azetex.cdrgenerator.configuration;
//
//import cz.azetex.cdrgenerator.model.Cdr;
//import cz.azetex.cdrgenerator.model.OperatorType;
//import cz.azetex.cdrgenerator.repositories.CdrRepository;
//import cz.azetex.cdrgenerator.repositories.OperatorTypeRepository;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.List;
//
//@Configuration
//public class H2Datasource {
//    @Bean
//    @Profile("local")
//    ApplicationRunner applicationRunner(CdrRepository cdrRepository, OperatorTypeRepository operatorTypeRepository) {
////        return args -> {
////            var cdr1 = new Cdr("cdr1", "desc1");
////            var cdr2 = new Cdr("cdr2", "desc2");
////            var cdr3 = new Cdr("cdr3", "desc3");
////            var cdr4 = new Cdr("cdr4", "desc4");
////            var cdr5 = new Cdr("cdr5", "desc5");
////            var cdr6 = new Cdr("cdr6", "desc6");
////            cdrRepository.saveAll(List.of(cdr1, cdr2, cdr3, cdr4, cdr5, cdr6));
////
////            var ope1 = new OperatorType("postpaid");
////            var ope2 = new OperatorType("prepaid");
////            var ope3 = new OperatorType("m2m");
////            operatorTypeRepository.saveAll(List.of(ope1, ope2, ope3));
////        };
////    }
//}
