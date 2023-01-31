package com.jcma.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void probar_string_cualquiera_no_es_vacio(){
        assertFalse(StringUtil.isEmpty("Jean Carlo Marchesini"));
    }

    @Test
    public void probar_cadena_vacia_es_vacio(){
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void probar_aparicion_excepcion_por_tipo_no_permitido(){
        StringUtil.isEmpty(null);
    }

    @Test
    public void probar_cadena_con_espacios_en_blanco_es_vacio(){
        assertTrue(StringUtil.isEmpty("   "));
    }

}