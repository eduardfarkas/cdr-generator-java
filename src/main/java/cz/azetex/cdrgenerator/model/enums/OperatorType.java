package cz.azetex.cdrgenerator.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.text.MessageFormat.format;

@RequiredArgsConstructor
public enum OperatorType {
    POSTPAID ("postpaid"),
    PREPAID  ("prepaid"),
    M2M      ("m2m");

    @Getter
    private final String name;

    public static OperatorType of(String name) {
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        format("Neexistující operatorType: {0}", name))); // TODO udělat message
    }
}
