package org.acme.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ProfanityService {

    public boolean isProfanity(String word) {

        var badWords = List.of("Arse","Bloody","Bugger","Cow","Crap","Damn","Ginger","Git","God","Goddam","Minger","Sod-off","Arsehole","Balls","Bint","Bitch","Bollocks","Bullshit","Feck","Munter","Pissed","pissed off","Shit","Son of a bitch","Tits","Bastard","Beaver","Beef curtains","Bellend","Bloodclaat","Clunge","Cock","Dick","Dickhead","Fanny","Flaps","Gash","Knob","Minge","Prick","Punani","Pussy","Snatch","Twat","Cunt","Fuck","Motherfucker, bitch");

        return Arrays.stream(word.split(" ")).allMatch(badWords::contains);
    }
}
