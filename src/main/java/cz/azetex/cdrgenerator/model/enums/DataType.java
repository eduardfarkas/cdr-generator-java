package cz.azetex.cdrgenerator.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.text.MessageFormat.format;

@RequiredArgsConstructor
public enum DataType {
    VOICE ("voice"),
    SMS   ("sms"),
    MMS   ("mms"),
    DATA  ("data");

    @Getter
    private final String name;

    public static DataType of(String name) {
        return Arrays.stream(values())
                .filter(dataType -> dataType.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        format("Neexistující dataType: {0}", name))); // TODO udělat message
    }
}
