//package cz.azetex.cdrgenerator.configuration;
//
//import cz.azetex.cdrgenerator.model.OperatorType;
//import cz.azetex.cdrgenerator.repositories.OperatorTypeRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//@Slf4j
//public class LocalDatasource {
//    @Bean
//    @Profile("local")
//    ApplicationRunner applicationRunner(OperatorTypeRepository operatorTypeRepository) {
//        log.info("-------------- loaduju -----------");
//        return args -> {
//            OperatorType operatorType1 = new OperatorType();
//            operatorType1.setName("postpaid test");
//
//            operatorTypeRepository.save(operatorType1);
//
//            OperatorType operatorType1 = new OperatorType();
//            operatorType1.setName("postpaid test");
//
//            operatorTypeRepository.save(operatorType1);
//        };
//    }
//}
