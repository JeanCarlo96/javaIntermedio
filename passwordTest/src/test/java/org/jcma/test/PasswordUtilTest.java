package org.jcma.test;

import org.junit.Assert;
import org.junit.Test;

import static org.jcma.test.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("123456!"));

    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_and_numbers(){
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd1234!"));
    }

}