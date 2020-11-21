package org.acme.services;

import org.acme.models.CommentResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@ApplicationScoped
public class ProfanityService {

    List<String> badWords = List.of("fuck", "Arse","Bloody","Bugger","Cow","Crap","Damn","Ginger","Git","God","Goddam","Minger","Sod-off","Arsehole","Balls","Bint","Bitch","Bollocks","Bullshit","Feck","Munter","Pissed","pissed off","Shit","Son of a bitch","Tits","Bastard","Beaver","Beef curtains","Bellend","Bloodclaat","Clunge","Cock","Dick","Dickhead","Fanny","Flaps","Gash","Knob","Minge","Prick","Punani","Pussy","Snatch","Twat","Cunt","Fuck","Motherfucker");
    private final String PATTERN = "((\\b[^\\s]+\\b)((?<=\\.\\w).)?)";

    public boolean isProfanity(String word) {
        return badWords.stream()
                .map(String::toLowerCase)
                .anyMatch(p -> p.contains(word.toLowerCase()));
    }

    public CommentResponse analyse(String comment) {

        var pattern = Pattern.compile(PATTERN, Pattern.MULTILINE);
        var matcher = pattern.matcher(comment);


        int numberOfWordsInComment;
        List<String> putMatches = new ArrayList<>();
        while (matcher.find()) {
            System.out.println(matcher.group());
            putMatches.add(matcher.group());
        }

        var res =  badWords.stream().anyMatch(putMatches::contains);
        return new CommentResponse(comment, res, 0.5);
    }

}
