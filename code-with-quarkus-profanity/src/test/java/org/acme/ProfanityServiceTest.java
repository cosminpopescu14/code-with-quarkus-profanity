package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.services.ProfanityService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ProfanityServiceTest {

    @Inject
    ProfanityService profanityService;

    @Test
    public void test_if_a_word_is_a_good_word() {


        assertFalse(profanityService.isProfanity("nice"));
        assertFalse(profanityService.isProfanity("word"));
        assertFalse(profanityService.isProfanity("dog"));
    }

    @Test
    public void test_if_a_word_is_a_bad_word() {
        assertTrue(profanityService.isProfanity("Fuck"));
        assertTrue(profanityService.isProfanity("pussy"));
        assertTrue(profanityService.isProfanity("bitch"));
    }

    @Test
    public void test_if_a_comment_is_nice() {
        var redditComment = "Personally, I would use Micronaut. Because I'm more familiar with their Spring-like API's, and haven't had any exposure to Java EE in almost 15 years! lol\n" +
                            "\n" +
                            "But between those two, Quarkus seems further along. And seems to have more investment from its corporate parent (i.e. RedHat) than Helidon has from its corporate parent (i.e. Oracle). Quarkus seems like it's part of a deliberate strategy to draw mindshare for an ecosystem, whereas Helidon feels more like some devs got approval to open source a thing.\n";

        var redditCommentAboutNodeJsAndJava = "The cool thing about Java imo is that there's always something new and it seems like the Java ecosystem is changing faster than it was but at the same time old knowledge isn't obsolete once something new is out. There are now bi yearly releases of Java for example. One example for what i mean is Spring Boot,\n" +
                                              " the biggest Web Framework in Java right now (there's not really anything web specific to it. It's basically a general purpose Dependency injection framework but web is what it's mostly used for). It was released in 2014 and built an easy to use Convention over Configuration wrapper around the Spring Framework that has been around for a long time and an embedded Webserver(only if you use it for web obviously).\n" +
                                              "  Spring Boot hasn't really changed all that much since then but the ecosystem around it, the tools, resources and a whole lot of smaller and bigger details about the framework have become so much better since then. They don't really shy away from breaking things but just like everything in the Java ecosystem they are always concerned with not breaking anything without a very good reason to do so.\n";
        assertFalse(profanityService.analyse(redditComment).isContainBadWords());
        assertFalse(profanityService.analyse(redditCommentAboutNodeJsAndJava).isContainBadWords());
    }

    @Test
    public void test_if_a_comment_is_bad() {
        var comment = "People laugh when I say I work at McDonald’s. And I say bitch at least I have a job!\n"
                      + "                  At least I don’t bother my parents asking them for $$$\n"
                      + "                  And live me the fuck alone";

        assertTrue(profanityService.analyse(comment).isContainBadWords());
    }
}
