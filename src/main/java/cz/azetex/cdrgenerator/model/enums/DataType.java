package cz.azetex.cdrgenerator.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.text.MessageFormat.format;

@RequiredArgsConstructor
public enum DataType {
    @JsonProperty("voice")
    VOICE ("voice"),

    @JsonProperty("sms")
    SMS   ("sms"),

    @JsonProperty("mms")
    MMS   ("mms"),

    @JsonProperty("data")
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
