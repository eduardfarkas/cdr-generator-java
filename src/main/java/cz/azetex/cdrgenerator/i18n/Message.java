package cz.azetex.cdrgenerator.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Message {

    private final MessageSource msg;

    public String getText(String code, @Nullable Object... arguments) {

        Object[] args = new Object[arguments.length];

        int i = 0;
        for(Object arg : arguments) {
            args[i] = String.valueOf(arg);
            i++;
        }

        return msg.getMessage(code, args, LocaleContextHolder.getLocale());
    }


}
