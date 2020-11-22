package org.acme.services;

import org.acme.models.CommentResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@ApplicationScoped
public class ProfanityService {

    //List<String> badWords = List.of("fuck", "Arse","Bloody","Bugger","Cow","Crap","Damn","Ginger","Git","God","Goddam","Minger","Sod-off","Arsehole","Balls","Bint","Bitch","Bollocks","Bullshit","Feck","Munter","Pissed","pissed off","Shit","Son of a bitch","Tits","Bastard","Beaver","Beef curtains","Bellend","Bloodclaat","Clunge","Cock","Dick","Dickhead","Fanny","Flaps","Gash","Knob","Minge","Prick","Punani","Pussy","Snatch","Twat","Cunt","Fuck","Motherfucker");


    List<String> badWords = List.of("4r5e","50 yard cunt","punt","5h1t","5hit","a_s_s","a2m","a$$","a55","a$$hole","a55hole","adult","aeolus","ahole","amateur","anal","anal impaler","anal","leakage","analprobe","anilingus","anus","ar5e","areola","areole","arian","arrse","arse","arsehole","aryan","ass","assfuck","ass hole","ass-fucker","assbang","assbanged","assbangs","asses","assfuck","assfucker","assfukka","assh0le","asshat","assho1e","asshole","assholes","assmaster","assmucus","assmunch","asswhole","asswipe","asswipes","autoerotic","azazel","azz","b!tch","b00bs","b17ch","b1tch","babe","babes","ballbag","ballsack","bang bang","box","bangbros","banger","bareback","barf","bastard","bastards","bawdy","beaner","beardedclam","beastial","beastiality","beatch","beater","beaver","curtain","beer","beeyotch","bellend","beotch","bestial","bestiality","bi+ch","biatch","big tits","bigtits","bimbo","bimbos","birdlock","bitch","bitch","tit","bitched","bitcher","bitchers","bitches","bitchin","bitching","bitchy","bloody","blow",
            "blowjob","blow me","blow mud","blowjob","blowjobs","blue waffle","blumpkin","bod","bodily","boink","boiolas","bollock","bollocks","bollok","bone","boned","boner","boners","bong","boob","boobies","boobs","booby","booger","bookie","booobs","boooobs","booooobs","booooooobs","bootee","bootie","booty","booze","boozer","boozy","bosom","bosomy","bowel","bowels","bra","brassiere","breast","breasts","buceta","bugger","bukkake","bull-shit","bullshit","bullshits","bullshitted","bullturds","bum","bung",
            "bunnyfucker","bust a load","busty","butt","buttfuck","butt-fuck","butt_fuck","buttfucker","butthole","buttmuch","buttplug","c-0-c-k","c-o-c-k","c-u-n-t","c.0.c.k","c.o.c.k.","c.u.n.t","c0ck","c0cksucker","caca","cahone","cameltoe",
            "carpetmuncher","carpet muncher","cawk","cervix","chinc","chincs","chink","choade","chode","chodes",
            "chotabags","cipa","cl1t","climax","clit",
            "clitlicker","clitoris","clitorus","clits","clitty","clitty litter","clusterfuck","cnut","cocain","cocaine","cock",
            "cockpocket","cock snot","cock sucker","cock-sucker","cockblock","cockface","cockhead","cockholster","cockknocker","cockmunch","cockmuncher","cocks","cocksmoker","cocksuck","cocksucked","cocksucker","cocksucking","cocksucks","cocksuka","cocksukka","coital","cok","cokmuncher","coksucka","commie","condom","coon","coons",
            "somewood","corksucker","cornhole",
            "corpwhore","cox","crabs","crack","cracker","crackwhore","crap","crappy","cum",
            "cumchugger",
            "cumdumpster",
            "cumfreak",
            "cumguzzler","cumdump","cummer","cummin","cumming","cums","cumshot","cumshots","cumslut","cumstain","cunilingus","cunillingus","cunnilingus","cunny","cunt",
            "cunthair","cunt-struck","cuntbag","cuntface","cunthunter","cuntlick","cuntlick","cuntlicker","cuntlicker","cuntlicking","cunts","cuntsicle",
            "cutrope","cyalis","cyberfuc","cyberfuck","cyberfucked","cyberfucker","cyberfuckers","cyberfucking","d0ng","d0uch3","d0uche","d1ck","d1ld0","d1ldo","dago","dagos","dammit","damn","damned","damnit","dawgie-style","dick","dickhole","dickshy","dick-ish","dickbag","dickdipper","dickface","dickflipper","dickhead","dickheads","dickish","dickripper","dicksipper","dickweed","dickwhipper","dickzipper","diddle","dike","dildo","dildos","diligaf","dillweed","dimwit","dingle","dink","dinks","dipship","dirsa",
            "dirtySanchez","dlck","dog-fucker",
            "doggiestyle","doggie-style","doggiestyle","doggin","dogging","doggy-style","dong","donkeyribber","doofus","doosh","dopey","douch3","douche","douchebag","douchebags","douchey","drunk","duche","dumass","dumbass","dumbasses","dummy","dyke","dykes","eat a dick","eat hair pie","ejaculate","ejaculated","ejaculates","ejaculating","ejaculatings","ejaculation","ejakulate","enlargement","erect","erection","erotic","essohbee","extacy","extasy","f_u_c_k","f-u-c-k","f.u.c.k","f4nny","facial","fack","fag","fagg","fagged","fagging","faggit","faggitt","faggot","faggs","fagot","fagots","fags","faig","faigt","fanny","fannybandit","fannyflaps","fannyfucker","fanyy","fart","fartknocker","fat","fatass","fcuk","fcuker","fcuking","feck","fecker","felch","felcher","felching","fellate","fellatio","feltch","feltcher","fingerfuck","fingerfucked","fingerfucker","fingerfuckers","fingerfucking","fingerfucks","fist fuck","fisted","fistfuck","fistfucked","fistfucker","fistfuckers","fistfucking","fistfuckings","fistfucks","fisting","fisty","flange",
            "flog the log","floozy","foad","fondle","foobar","fook","fooker","foreskin","freex","frigg","frigga","fubar","fuck","fuck",
            "fuckhole","fuck puppet","fuck trophy","fuck yo mama","fuck-ass","fuck-bitch","fuck-tard","fucka","fuckass","fucked","fucker","fuckers","fuckface","fuckhead","fuckheads","fuckin","fucking","fuckings","fuckingshitmotherfucker","fuckme","fuckmeat","fucknugget","fucknut","fuckoff","fucks","fucktard","fucktoy","fuckup","fuckwad","fuckwhit","fuckwit",
            "fudgepacker","fudgepacker","fuk","fuker","fukker","fukkin","fuks","fukwhit","fukwit","fux","fux0r","fvck","fxck","g-spot","gae","gai","gang-bang","gangbang","gangbang","gangbanged","gangbangs","ganja",
            "gassyass","gay","gaylord","gays","gaysex","gey","gfy","ghay","ghey","gigolo","glans","goatse","god","goddamn","god-dam","god-damned","godamn","godamnit","goddam","goddammit","goddamn","goddamned","goldenshower","gonad","gonads","gook","gooks","gringo","gspot","gtfo","guido","h0m0","h0mo",
            "hamflap","handjob","hard on","hardcoresex","he11","hebe","heeb","hell","hemp","heroin","herp","herpes","herpy","heshe","hitler","hiv","hoar","hoare","hobag","hoer","hom0","homey","homo","homoerotic","homoey","honky","hooch","hookah","hooker","hoor","hootch","hooter","hooters","hore","horniest","horny","hotsex","how to kill", "how to murdep","hump","humped","humping","hussy","hymen","inbred","incest","injun","j3rk0ff","jack-off","jackass","jackhole","jackoff","jap","japs","jerk","jerk-off","jerk0ff","jerked","jerkoff","jism","jiz","jizm","jizz","jizzed","junkie","junky","kawk","kike","kikes","kill","kinky",
            "kinky Jesus","kkk","klan","knob","knob end","knobead","knobed","knobend","knobhead","knobjocky","knobjokey","kock","kondum","kondums","kooch","kooches","kootch","kraut","kum","kummer","kumming","kums","kunilingus","kwif","kyke","l3i+ch","l3itch","labia","lech","LEN","leper","lesbians","lesbo","lesbos","lez","lezbian","lezbians","lezbo","lezbos","lezzie","lezzies","lezzy","lmao","lmfao","loin","loins","lube","lust","lusting","lusty","m-fucking","m0f0","m0fo","m45terbate","ma5terb8","ma5terbate","mafugly","mams","masochist","massa","master-bate","masterb8","masterbat*","masterbat3","masterbate","masterbating","masterbation","masterbations","masturbate","masturbating","masturbation","maxi","menses","menstruate","menstruation","meth","mo-fo","mof0","mofo","molest","moolie","moron","mothafuck","mothafucka","mothafuckas","mothafuckaz","mothafucked","mothafucker","mothafuckers","mothafuckin","mothafucking","mothafuckings","mothafucks","mother fucker","motherfucker","motherfuck","motherfucka","motherfucked","motherfucker","motherfuckers","motherfuckin","motherfucking","motherfuckings","motherfuckka","motherfucks","mtherfucker","mthrfucker","mthrfucking","muff","muffpuff","muffdiver","murder","mutha","muthafecker","muthafuckaz","muthafucker","muthafuckker","muther","mutherfucker","mutherfucking","muthrfucking","n1gga","n1gger","nad","nads","naked","napalm","nappy","nazi","nazism","need the dick","negro","nigg3r","nigg4h","nigga","niggah","niggas","niggaz","nigger","niggers","niggle","niglet","nimrod","ninny","nipple","nob","nob jokey","nobhead","nobjocky","nobjokey","nooky","numbnuts","nut butter","nutsack","nympho","opiate","opium","oral","orally","organ","orgasim","orgasims","orgasm","orgasmic","orgasms","orgies","orgy","ovary","ovum","ovums","p.u.s.s.y.","p0rn","paddy","paki","pantie","panties","panty","pastie","pasty","pawn","pcp","pecker","pedo","pedophile","pedophilia","pedophiliac","pee","peepee","penetrate","penetration","penial","penile","penis","penisfucker","perversion","peyote","phalli","phallic","phonesex","phuck","phuk","phuked","phuking","phukked","phukking","phuks","phuq","pigfucker","pillowbiter","pimp","pimpis","pinko","piss","piss-off","pissed","pisser","pissers","pisses","pissflaps","pissin","pissing","pissoff","pissoff","pms","polack","pollock","poon","poontang","poop","porn","porno","pornography","pornos","pot","potty","prick","pricks","prig","pron","prostitute","prude","pube","pubic","pubis","punkass","punky","puss","pusse","pussi","pussies","pussy",
            "pussy fart",
            "pussy palace","pussypounder","pussys","puto","queaf","queaf","queef","queer","queero","queers","quicky","quim","r-tard","racy","rape","raped","raper","rapist","raunch","rectal","rectum","rectus","reefer","reetard","reich","retard","retarded","revue","rimjaw","rimjob","rimming","ritard","rtard","rum","rump","rumprammer","ruski","shit","s_h_i_t","s-h-1-t","s-h-i-t","s-o-b","s.h.i.t.","s.o.b.","s0b","sadism","sadist","sandbar",
            "sausage queen","scag","scantily","schizo","schlong","screw","screwed","screwing","scroat","scrog","scrot","scrote","scrotum","scrud","scum","seaman","seamen","seduce","semen","sex","sexual","sh!+","sh!t","sh1t","shag","shagger","shaggin","shagging","shamedame","shemale","shi+","shit",
            "shit fucker","shitdick","shite","shiteater","shited","shitey","shitface","shitfuck","shitfull","shithead","shithole","shithouse","shiting","shitings","shits","shitt","shitted","shitter","shitters","shitting","shittings","shitty","shiz","sissy","skag","skank","slave","sleaze","sleazy","slope","slut",
            "slut bucket","slutdumper","slutkiss","sluts","smegma","smut","smutty","snatch","sniper","snuff","sodom","son-of-a-bitch","souse","soused","spac","sperm","spic","spick","spik","spiks","spooge","spunk","steamy","stfu","stiffy","stoned","strip","stroke","stupid","suck","sucked","sucking","sumofabiatch","t1t","t1tt1e5","t1tties","tampon","tard","tawdry","teabagging","teat","teets","teez","terd","teste","testee","testes","testical","testicle","testis","thrust","thug","tinkle","tit","tit wank","titfuck","titi","tits","titt","tittie5","tittiefucker","titties","titty","tittyfuck","tittyfucker","tittywank","titwank","toke","toots","tosser","tramp","transsexual","trashy","tubgirl","turd","tush","tw4t","twat","twathead","twats","twatty","twunt","twunter","ugly","undies","unwed","urinal","urine","uterus","uzi","v14gra","v1gra","vag","vagina","valium","viagra","virgin","vixen","vodka","vomit","voyeur","vulgar","vulva","w00se","wad","wang","wank","wanker","wanky","wazoo","wedgie","weed","weenie","weewee","weiner","weirdo","wench","wetback","wh0re","wh0reface","whitey","whiz","whoar","whoralicious","whore","whorealicious","whored","whoreface","whorehopper","whorehouse","whores","whoring","wigger","willies","willy","womb","woody","wop","wtf","x-rated","xrated","xxx","yeasty","yobbo","zoophile", "fuck");



    private final String PATTERN = "((\\b[^\\s]+\\b)((?<=\\.\\w).)?)";

    public boolean isProfanity(String word) {
        var badWord = String.format("\b(%s)\b", word);
        Arrays.stream(word.split(badWord)).forEach(System.out::println);

        return Arrays.stream(word.split(badWord))
                .map(String::toLowerCase)
                .map(String::strip)
                .anyMatch(badWords::contains);
    }

    public CommentResponse analyse(String comment) {

        var pattern = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
        var matcher = pattern.matcher(comment);

        List<String> putMatches = new ArrayList<>();
        while (matcher.find()) {
            putMatches.add(matcher.group());
        }

        var res =  badWords.stream()
                .map(String::toLowerCase)
                .anyMatch(putMatches::contains);
        double numberOfWordsInComment = putMatches.size();
        double numberOfBadWordsInComment = badWords
                .stream()
                .map(String::toLowerCase)
                .filter(putMatches::contains)
                .count();

        var percentage = numberOfBadWordsInComment / numberOfWordsInComment * 100L;
        System.out.println(percentage);
        System.out.println(numberOfBadWordsInComment);
        return new CommentResponse(comment, res,
                (int) numberOfWordsInComment, (int) numberOfBadWordsInComment, percentage);
    }

}
