package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    private FileSystem fileSystem;

    @BeforeEach
    void setUp() {
        fileSystem = new FileSystem();
    }

    @Test
    void testMkdir() {
        fileSystem.mkdir("testDir");
        assertNotNull(fileSystem.getCurrent().getChild("testDir"));
        assertTrue(fileSystem.getCurrent().getChild("testDir") instanceof Directory);
    }

    @Test
    void testMkdirDuplicate() {
        fileSystem.mkdir("testDir");
        fileSystem.mkdir("testDir"); 
        assertEquals(1, fileSystem.getCurrent().getChildren().size());
    }

    @Test
    void testTouch() {
        fileSystem.touch("testFile");
        assertNotNull(fileSystem.getCurrent().getChild("testFile"));
        assertTrue(fileSystem.getCurrent().getChild("testFile") instanceof File);
    }

    @Test
    void testTouchDuplicate() {
        fileSystem.touch("testFile.txt");
        fileSystem.touch("testFile.txt"); 
        assertEquals(1, fileSystem.getCurrent().getChildren().size());
    }

    @Test
    void testCd() {
        fileSystem.mkdir("testDir");
        fileSystem.cd("testDir");
        assertEquals("testDir", fileSystem.getCurrent().getName());
    }

    @Test
    void testCdToParent() {
        Directory original = fileSystem.getCurrent();
        fileSystem.mkdir("testDir");
        fileSystem.cd("testDir");
        fileSystem.cd("..");
        assertEquals(original, fileSystem.getCurrent());
    }

    @Test
    void testCdToRoot() {
        fileSystem.mkdir("testDir");
        fileSystem.cd("testDir");
        fileSystem.cd(null);
        assertEquals("home", fileSystem.getCurrent().getName());
    }

    @Test
    void testPwd() {
        fileSystem.mkdir("testDir");
        fileSystem.cd("testDir");
        assertEquals("/home/nazareno/testDir", fileSystem.getPrompt());
    }

    @Test
    void testGetPrompt() {
        assertEquals("/home/nazareno", fileSystem.getPrompt());
    }
} 