package com.smu.mscda;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for App – MCDA 5512 Maven Assignment
 *
 * Verifies:
 *   - StringUtils.capitalize() produces the correct output
 *   - DigestUtils.md5Hex() produces the correct MD5 hex digest
 */
class AppTest {

    /** "smu" → "Smu" */
    @Test
    void testCapitalize_smu() {
        assertEquals("Smu", StringUtils.capitalize("smu"),
                "Single lowercase word should have its first letter capitalized");
    }

    /** "hello world" → "Hello world"  (StringUtils.capitalize only touches first char) */
    @Test
    void testCapitalize_multiWord() {
        assertEquals("Hello world", StringUtils.capitalize("hello world"),
                "StringUtils.capitalize only capitalizes the very first character");
    }

    /** Empty string → still empty */
    @Test
    void testCapitalize_empty() {
        assertEquals("", StringUtils.capitalize(""),
                "Capitalizing an empty string should return empty string");
    }

    /** MD5("smu") must equal the value computed by Apache Commons Codec */
    @Test
    void testMd5Hex_smu() {
        assertEquals("3773300c2f413cc7136f8d74b305519c",
                DigestUtils.md5Hex("smu"),
                "MD5 hex of 'smu' must match the value computed by DigestUtils");
    }

    /** MD5 is case-sensitive: "smu" ≠ "Smu" */
    @Test
    void testMd5Hex_caseSensitive() {
        assertNotEquals(DigestUtils.md5Hex("smu"),
                DigestUtils.md5Hex("Smu"),
                "MD5 is case-sensitive; 'smu' and 'Smu' must produce different hashes");
    }

    /** MD5 output is always 32 hex characters */
    @Test
    void testMd5Hex_length() {
        String hash = DigestUtils.md5Hex("any input");
        assertEquals(32, hash.length(),
                "MD5 hex digest must always be 32 characters long");
    }
}
